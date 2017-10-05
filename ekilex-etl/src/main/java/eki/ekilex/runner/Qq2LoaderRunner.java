package eki.ekilex.runner;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eki.common.data.Count;
import eki.common.data.PgVarcharArray;
import eki.common.service.db.BasicDbService;

@Component
public class Qq2LoaderRunner extends AbstractLoaderRunner {

	private static Logger logger = LoggerFactory.getLogger(Qq2LoaderRunner.class);

	private static final String TRANSFORM_MORPH_DERIV_FILE_PATH = "csv/transform-morph-deriv.csv";

	@Autowired
	private BasicDbService basicDbService;

	private Map<String, String> morphToMorphMap;

	private Map<String, String> morphToDerivMap;

	@Override
	void initialise() throws Exception {

		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceFileInputStream;

		resourceFileInputStream = classLoader.getResourceAsStream(TRANSFORM_MORPH_DERIV_FILE_PATH);
		List<String> morphDerivMapLines = getContentLines(resourceFileInputStream);
		morphToMorphMap = new HashMap<>();
		morphToDerivMap = new HashMap<>();
		for (String morphDerivMapLine : morphDerivMapLines) {
			if (StringUtils.isBlank(morphDerivMapLine)) {
				continue;
			}
			String[] morphDerivMapLineParts = StringUtils.split(morphDerivMapLine, CSV_SEPARATOR);
			String sourceMorphCode = morphDerivMapLineParts[0];
			String destinMorphCode = morphDerivMapLineParts[1];
			String destinDerivCode = morphDerivMapLineParts[2];
			morphToMorphMap.put(sourceMorphCode, destinMorphCode);
			if (!StringUtils.equals(destinDerivCode, String.valueOf(CSV_EMPTY_CELL))) {
				morphToDerivMap.put(sourceMorphCode, destinDerivCode);
			}
		}
	}

	@Transactional
	public void execute(String dataXmlFilePath, String dataLang, String[] datasets) throws Exception {

		logger.debug("Starting loading QQ2...");

		final String articleExp = "/x:sr/x:A";
		final String articleHeaderExp = "x:P";
		final String wordGroupExp = "x:mg";
		final String wordExp = "x:m";
		final String wordVocalFormExp = "x:hld";
		final String wordMorphExp = "x:vk";
		final String wordRectionExp = "x:r";
		final String wordGrammarExp = "x:grg/x:gki";
		final String articleBodyExp = "x:S";
		final String meaningGroupExp = "x:tp";
		final String meaningExp = "x:tg";
		final String wordMatchExpr = "x:xp/x:xg";
		final String wordMatchValueExp = "x:x";
		final String definitionValueExp = "x:xd";
		final String wordMatchRectionExp = "x:xr";
		final String synonymExp = "x:syn";

		final String pseudoHomonymAttr = "i";
		final String lexemeLevel1Attr = "tnr";

		final String defaultWordMorphCode = "SgN";
		final String wordDisplayFormStripChars = ".+'`()¤:_";
		final int defaultHomonymNr = 1;

		long t1, t2;
		t1 = System.currentTimeMillis();

		dataLang = unifyLang(dataLang);
		Document dataDoc = readDocument(dataXmlFilePath);

		List<Element> articleNodes = dataDoc.selectNodes(articleExp);
		int articleCount = articleNodes.size();
		logger.debug("Extracted {} articles", articleCount);

		Map<Long, List<Map<String, Object>>> wordIdRectionMap = new HashMap<>();
		Map<Long, List<Map<String, Object>>> wordIdGrammarMap = new HashMap<>();

		Element headerNode, contentNode;
		List<Element> wordGroupNodes, rectionNodes, grammarNodes, meaningGroupNodes, meaningNodes, definitionValueNodes, wordMatchNodes, synonymNodes;
		Element wordNode, wordVocalFormNode, morphNode, wordMatchValueNode;

		List<Long> newWordIds, synonymLevel1WordIds, synonymLevel2WordIds;
		String word, wordMatch, pseudoHomonymNr, wordDisplayForm, wordVocalForm, lexemeLevel1Str, wordMatchLang;
		String sourceMorphCode, destinMorphCode, destinDerivCode;
		int homonymNr, lexemeLevel1, lexemeLevel2, lexemeLevel3;
		Long wordId, meaningId, lexemeId;

		Count wordDuplicateCount = new Count();
		Count lexemeDuplicateCount = new Count();

		int articleCounter = 0;
		int progressIndicator = articleCount / Math.min(articleCount, 100);

		for (Element articleNode : articleNodes) {

			contentNode = (Element) articleNode.selectSingleNode(articleBodyExp);
			if (contentNode == null) {
				continue;
			}

			// header...
			newWordIds = new ArrayList<>();
			headerNode = (Element) articleNode.selectSingleNode(articleHeaderExp);
			wordGroupNodes = headerNode.selectNodes(wordGroupExp);
			word = null;
			List<String> tmpWords = new ArrayList<>();

			for (Element wordGroupNode : wordGroupNodes) {

				// word, form...
				wordNode = (Element) wordGroupNode.selectSingleNode(wordExp);
				word = wordDisplayForm = wordNode.getTextTrim();
				word = StringUtils.replaceChars(word, wordDisplayFormStripChars, "");
				pseudoHomonymNr = wordNode.attributeValue(pseudoHomonymAttr);
				if (StringUtils.isNotBlank(pseudoHomonymNr)) {
					word = StringUtils.substringBefore(word, pseudoHomonymNr);
				}
				homonymNr = getWordMaxHomonymNr(word, dataLang);
				homonymNr++;
				wordVocalFormNode = (Element) wordGroupNode.selectSingleNode(wordVocalFormExp);
				if (wordVocalFormNode == null) {
					wordVocalForm = null;
				} else {
					wordVocalForm = wordVocalFormNode.getTextTrim();
				}
				morphNode = (Element) wordGroupNode.selectSingleNode(wordMorphExp);
				if (morphNode == null) {
					destinMorphCode = defaultWordMorphCode;
					destinDerivCode = null;
				} else {
					sourceMorphCode = morphNode.getTextTrim();
					destinMorphCode = morphToMorphMap.get(sourceMorphCode);
					destinDerivCode = morphToDerivMap.get(sourceMorphCode);//currently not used
				}

				// save word+paradigm+form
				wordId = saveWord(word, wordDisplayForm, wordVocalForm, homonymNr, destinMorphCode, dataLang, wordDuplicateCount);
				newWordIds.add(wordId);
				tmpWords.add(word);

				// further references...

				// rections...
				rectionNodes = wordGroupNode.selectNodes(wordRectionExp);
				extractRections(rectionNodes, wordId, wordIdRectionMap);

				// grammar...
				grammarNodes = wordGroupNode.selectNodes(wordGrammarExp);
				extractGrammar(grammarNodes, wordId, datasets, wordIdGrammarMap);
			}

			// body...

			synonymNodes = contentNode.selectNodes(synonymExp);
			synonymLevel1WordIds = saveWords(synonymNodes, defaultHomonymNr, defaultWordMorphCode, dataLang, wordDuplicateCount);

			meaningGroupNodes = contentNode.selectNodes(meaningGroupExp);//x:tp

			for (Element meaningGroupNode : meaningGroupNodes) {

				lexemeLevel1Str = meaningGroupNode.attributeValue(lexemeLevel1Attr);
				lexemeLevel1 = Integer.valueOf(lexemeLevel1Str);

				meaningNodes = meaningGroupNode.selectNodes(meaningExp);//x:tg
				lexemeLevel2 = 0;

				for (Element meaningNode : meaningNodes) {

					lexemeLevel2++;
					lexemeLevel3 = 0;

					synonymNodes = meaningNode.selectNodes(synonymExp);
					synonymLevel2WordIds = saveWords(synonymNodes, defaultHomonymNr, defaultWordMorphCode, dataLang, wordDuplicateCount);

					wordMatchNodes = meaningNode.selectNodes(wordMatchExpr);//x:xp/x:xg

					for (Element wordMatchNode : wordMatchNodes) {

						lexemeLevel3++;

						wordMatchLang = wordMatchNode.attributeValue("lang");
						wordMatchLang = unifyLang(wordMatchLang);
						wordMatchValueNode = (Element) wordMatchNode.selectSingleNode(wordMatchValueExp);
						wordMatch = wordMatchValueNode.getTextTrim();
						wordMatch = StringUtils.replaceChars(wordMatch, wordDisplayFormStripChars, "");

						if (StringUtils.isBlank(wordMatch)) {
							continue;
						}

						wordId = saveWord(wordMatch, null, null, defaultHomonymNr, defaultWordMorphCode, wordMatchLang, wordDuplicateCount);

						// meaning
						meaningId = createMeaning(datasets);

						// definitions
						definitionValueNodes = wordMatchNode.selectNodes(definitionValueExp);
						saveDefinitions(definitionValueNodes, meaningId, wordMatchLang, datasets);

						// word match lexeme
						lexemeId = createLexeme(wordId, meaningId, null, null, null, datasets);
						if (lexemeId == null) {
							lexemeDuplicateCount.increment();
						} else {

							// word match lexeme rection
							rectionNodes = wordMatchValueNode.selectNodes(wordMatchRectionExp);
							saveRections(rectionNodes, lexemeId);
						}

						// new words lexemes+rections+grammar
						for (Long newWordId : newWordIds) {

							lexemeId = createLexeme(newWordId, meaningId, lexemeLevel1, lexemeLevel2, lexemeLevel3, datasets);
							if (lexemeId == null) {
								lexemeDuplicateCount.increment();
							} else {

								// word match lexeme rections
								createRections(wordIdRectionMap, lexemeId, newWordId);

								// word match lexeme grammars
								createGrammars(wordIdGrammarMap, lexemeId, newWordId);
							}
						}

						for (Long synonymWordId : synonymLevel1WordIds) {
							lexemeId = createLexeme(synonymWordId, meaningId, null, null, null, datasets);
							if (lexemeId == null) {
								lexemeDuplicateCount.increment();
							}
						}

						for (Long synonymWordId : synonymLevel2WordIds) {
							lexemeId = createLexeme(synonymWordId, meaningId, null, null, null, datasets);
							if (lexemeId == null) {
								lexemeDuplicateCount.increment();
							}
						}
					}
				}
			}

			articleCounter++;
			if (articleCounter % progressIndicator == 0) {
				logger.debug("{} articles iterated", articleCounter);
			}
		}

		logger.debug("Found {} word duplicates", wordDuplicateCount);
		logger.debug("Found {} lexeme duplicates", lexemeDuplicateCount);

		t2 = System.currentTimeMillis();
		logger.debug("Done loading in {} ms", (t2 - t1));
	}

	private List<Long> saveWords(List<Element> synonymNodes, int homonymNr, String wordMorphCode, String lang, Count wordDuplicateCount) throws Exception {

		List<Long> synonymWordIds = new ArrayList<>();
		String synonym;
		Long wordId;

		for (Element synonymNode : synonymNodes) {

			synonym = synonymNode.getTextTrim();
			wordId = saveWord(synonym, null, null, homonymNr, wordMorphCode, lang, wordDuplicateCount);
			synonymWordIds.add(wordId);
		}
		return synonymWordIds;
	}

	private void saveDefinitions(List<Element> definitionValueNodes, Long meaningId, String wordMatchLang, String[] datasets) throws Exception {

		if (definitionValueNodes == null) {
			return;
		}
		for (Element definitionValueNode : definitionValueNodes) {
			String definition = definitionValueNode.getTextTrim();
			createDefinition(meaningId, definition, wordMatchLang, datasets);
		}
	}

	private void saveRections(List<Element> rectionNodes, Long lexemeId) throws Exception {

		if (rectionNodes == null) {
			return;
		}
		for (Element rectionNode : rectionNodes) {
			String rection = rectionNode.getTextTrim();
			createRection(lexemeId, rection);
		}
	}

	private void extractGrammar(List<Element> grammarNodes, Long wordId, String[] datasets, Map<Long, List<Map<String, Object>>> wordIdGrammarMap) {

		List<Map<String, Object>> grammarObjs;
		Map<String, Object> grammarObj;
		String grammarLang;
		String grammar;

		for (Element grammarNode : grammarNodes) {

			grammarLang = grammarNode.attributeValue("lang");
			grammarLang = unifyLang(grammarLang);
			grammar = grammarNode.getTextTrim();

			grammarObjs = wordIdGrammarMap.get(wordId);
			if (grammarObjs == null) {
				grammarObjs = new ArrayList<>();
				wordIdGrammarMap.put(wordId, grammarObjs);
			}
			grammarObj = new HashMap<>();
			grammarObj.put("lang", grammarLang);
			grammarObj.put("value", grammar);
			grammarObj.put("datasets", new PgVarcharArray(datasets));
			grammarObjs.add(grammarObj);
		}
	}

	private void extractRections(List<Element> rectionNodes, Long wordId, Map<Long, List<Map<String, Object>>> wordIdRectionMap) {

		if (rectionNodes == null) {
			return;
		}
		List<Map<String, Object>> rectionObjs = wordIdRectionMap.get(wordId);
		if (rectionObjs == null) {
			rectionObjs = new ArrayList<>();
			wordIdRectionMap.put(wordId, rectionObjs);
		}
		for (Element rectionNode : rectionNodes) {
			String rection = rectionNode.getTextTrim();
			Map<String, Object> rectionObj = new HashMap<>();
			rectionObj.put("value", rection);
			rectionObjs.add(rectionObj);
		}
	}

	private void createGrammars(Map<Long, List<Map<String, Object>>> wordIdGrammarMap, Long lexemeId, Long wordId) throws Exception {

		List<Map<String, Object>> grammarObjs = wordIdGrammarMap.get(wordId);
		if (CollectionUtils.isNotEmpty(grammarObjs)) {
			for (Map<String, Object> grammarObj : grammarObjs) {
				grammarObj.put("lexeme_id", lexemeId);
				basicDbService.createIfNotExists(GRAMMAR, grammarObj);
			}
		}
	}

	private void createRections(Map<Long, List<Map<String, Object>>> wordIdRectionMap, Long lexemeId, Long wordId) throws Exception {

		List<Map<String, Object>> rectionObjs = wordIdRectionMap.get(wordId);
		if (CollectionUtils.isNotEmpty(rectionObjs)) {
			for (Map<String, Object> rectionObj : rectionObjs) {
				rectionObj.put("lexeme_id", lexemeId);
				basicDbService.createIfNotExists(RECTION, rectionObj);
			}
		}
	}

	private List<String> getContentLines(InputStream resourceInputStream) throws Exception {
		List<String> contentLines = IOUtils.readLines(resourceInputStream, UTF_8);
		resourceInputStream.close();
		return contentLines;
	}

}
