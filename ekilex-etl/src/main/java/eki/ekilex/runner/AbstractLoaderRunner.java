package eki.ekilex.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import eki.common.constant.TableName;
import eki.common.data.Count;
import eki.common.data.PgVarcharArray;
import eki.common.service.db.BasicDbService;
import eki.ekilex.constant.SystemConstant;
import eki.ekilex.data.transform.Form;
import eki.ekilex.data.transform.Paradigm;

public abstract class AbstractLoaderRunner implements InitializingBean, SystemConstant, TableName {

	private static final String SQL_SELECT_WORD_MAX_HOMONYM = "sql/select_word_max_homonym.sql";

	private static final String SQL_SELECT_WORD_BY_FORM_AND_HOMONYM = "sql/select_word_by_form_and_homonym.sql";

	@Autowired
	protected BasicDbService basicDbService;

	private String sqlSelectWordByFormAndHomonym;

	private String sqlSelectWordMaxHomonym;

	abstract void initialise() throws Exception;

	@Override
	public void afterPropertiesSet() throws Exception {

		initialise();

		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceFileInputStream;

		resourceFileInputStream = classLoader.getResourceAsStream(SQL_SELECT_WORD_MAX_HOMONYM);
		sqlSelectWordMaxHomonym = getContent(resourceFileInputStream);

		resourceFileInputStream = classLoader.getResourceAsStream(SQL_SELECT_WORD_BY_FORM_AND_HOMONYM);
		sqlSelectWordByFormAndHomonym = getContent(resourceFileInputStream);
	}

	protected String getContent(InputStream resourceInputStream) throws Exception {
		String content = IOUtils.toString(resourceInputStream, UTF_8);
		resourceInputStream.close();
		return content;
	}

	protected boolean isLang(String lang) {
		Locale locale = new Locale(lang);
		String displayName = locale.getDisplayName();
		boolean isLang = !StringUtils.equalsIgnoreCase(lang, displayName);
		return isLang;
	}

	protected String unifyLang(String lang) {
		Locale locale = new Locale(lang);
		lang = locale.getISO3Language();
		return lang;
	}

	protected Document readDocument(String dataXmlFilePath) throws Exception {

		SAXReader dataDocParser = new SAXReader();
		File dataDocFile = new File(dataXmlFilePath);
		FileInputStream dataDocFileInputStream = new FileInputStream(dataDocFile);
		InputStreamReader dataDocInputReader = new InputStreamReader(dataDocFileInputStream, UTF_8);
		Document dataDoc = dataDocParser.read(dataDocInputReader);
		dataDocInputReader.close();
		dataDocFileInputStream.close();
		return dataDoc;
	}

	protected Long saveWord(
			String word, String wordDisplayForm, String wordVocalForm, int homonymNr, String wordMorphCode, String lang,
			Paradigm paradigm, Count wordDuplicateCount) throws Exception {

		Map<String, Object> tableRowValueMap = getWord(word, homonymNr, lang);
		Long wordId;

		if (tableRowValueMap == null) {

			// word
			wordId = createWord(wordMorphCode, homonymNr, lang);

			if (paradigm == null) {

				// empty paradigm
				Long paradigmId = createParadigm(wordId);
	
				// form
				createForm(word, wordDisplayForm, wordVocalForm, wordMorphCode, paradigmId, true);
			}

		} else {
			wordId = (Long) tableRowValueMap.get("id");
			wordDuplicateCount.increment();
		}
		if (paradigm != null) {

			// mab paradigm
			Long paradigmId = createParadigm(wordId);

			// mab forms
			List<Form> forms = paradigm.getForms();
			for (Form form : forms) {
				if (form.isWord()) {
					createForm(form.getValue(), wordDisplayForm, wordVocalForm, form.getMorphCode(), paradigmId, form.isWord());					
				} else {
					createForm(form.getValue(), null, null, form.getMorphCode(), paradigmId, form.isWord());
				}
			}
		}
		return wordId;
	}

	private Map<String, Object> getWord(String word, int homonymNr, String lang) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("word", word);
		tableRowParamMap.put("homonymNr", homonymNr);
		tableRowParamMap.put("lang", lang);
		Map<String, Object> tableRowValueMap = basicDbService.queryForMap(sqlSelectWordByFormAndHomonym, tableRowParamMap);
		return tableRowValueMap;
	}

	private void createForm(String form, String wordDisplayForm, String wordVocalForm, String morphCode, Long paradigmId, boolean isWord) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("paradigm_id", paradigmId);
		tableRowParamMap.put("morph_code", morphCode);
		tableRowParamMap.put("value", form);
		if (StringUtils.isNotBlank(wordDisplayForm)) {
			tableRowParamMap.put("display_form", wordDisplayForm);
		}
		if (StringUtils.isNotBlank(wordVocalForm)) {
			tableRowParamMap.put("vocal_form", wordVocalForm);
		}
		tableRowParamMap.put("is_word", isWord);
		basicDbService.create(FORM, tableRowParamMap);
	}

	private Long createParadigm(Long wordId) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("word_id", wordId);
		Long paradigmId = basicDbService.create(PARADIGM, tableRowParamMap);
		return paradigmId;
	}

	private Long createWord(final String morphCode, final int homonymNr, String lang) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("lang", lang);
		tableRowParamMap.put("morph_code", morphCode);
		tableRowParamMap.put("homonym_nr", homonymNr);
		Long wordId = basicDbService.create(WORD, tableRowParamMap);
		return wordId;
	}

	protected int getWordMaxHomonymNr(String word, String lang) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("word", word);
		tableRowParamMap.put("lang", lang);
		Map<String, Object> tableRowValueMap = basicDbService.queryForMap(sqlSelectWordMaxHomonym, tableRowParamMap);
		int homonymNr = (int) tableRowValueMap.get("max_homonym_nr");
		return homonymNr;
	}

	protected Long createMeaning(String[] datasets) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("datasets", new PgVarcharArray(datasets));
		Long meaningId = basicDbService.create(MEANING, tableRowParamMap);
		return meaningId;
	}

	protected void createDefinition(Long meaningId, String definition, String lang, String[] datasets) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("meaning_id", meaningId);
		tableRowParamMap.put("value", definition);
		tableRowParamMap.put("lang", lang);
		tableRowParamMap.put("datasets", new PgVarcharArray(datasets));
		basicDbService.create(DEFINITION, tableRowParamMap);
	}

	protected Long createLexeme(Long wordId, Long meaningId, Integer lexemeLevel1, Integer lexemeLevel2, Integer lexemeLevel3, String[] datasets) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("word_id", wordId);
		tableRowParamMap.put("meaning_id", meaningId);
		if (lexemeLevel1 != null) {
			tableRowParamMap.put("level1", lexemeLevel1);
		}
		if (lexemeLevel2 != null) {
			tableRowParamMap.put("level2", lexemeLevel2);
		}
		if (lexemeLevel3 != null) {
			tableRowParamMap.put("level3", lexemeLevel3);
		}
		tableRowParamMap.put("datasets", new PgVarcharArray(datasets));
		Long lexemeId = basicDbService.createIfNotExists(LEXEME, tableRowParamMap);
		return lexemeId;
	}

	protected Long createOrSelectRection(Long lexemeId, String rection) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("lexeme_id", lexemeId);
		tableRowParamMap.put("value", rection);
		Long rectionId = basicDbService.createOrSelect(RECTION, tableRowParamMap);
		return rectionId;
	}

	protected Long createUsage(Long rectionId, String usage) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("rection_id", rectionId);
		tableRowParamMap.put("value", usage);
		Long usageId = basicDbService.create(USAGE, tableRowParamMap);
		return usageId;
	}

	protected Long createUsageTranslation(Long usageId, String translation, String lang) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("usage_id", usageId);
		tableRowParamMap.put("value", translation);
		tableRowParamMap.put("lang", lang);
		Long usageTranslationId = basicDbService.create(USAGE_TRANSLATION, tableRowParamMap);
		return usageTranslationId;
	}

	protected void createMeaningDomain(Long meaningId, String domainCode, String domainOrigin) throws Exception {

		Map<String, Object> tableRowParamMap = new HashMap<>();
		tableRowParamMap.put("meaning_id", meaningId);
		tableRowParamMap.put("domain_code", domainCode);
		tableRowParamMap.put("domain_origin", domainOrigin);
		basicDbService.create(MEANING_DOMAIN, tableRowParamMap);
	}
}
