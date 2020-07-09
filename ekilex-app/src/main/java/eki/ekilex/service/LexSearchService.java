package eki.ekilex.service;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eki.common.constant.FreeformType;
import eki.common.service.util.LexemeLevelPreseUtil;
import eki.ekilex.data.Classifier;
import eki.ekilex.data.ClassifierSelect;
import eki.ekilex.data.Collocation;
import eki.ekilex.data.CollocationPosGroup;
import eki.ekilex.data.CollocationTuple;
import eki.ekilex.data.DatasetPermission;
import eki.ekilex.data.DefSourceAndNoteSourceTuple;
import eki.ekilex.data.Definition;
import eki.ekilex.data.DefinitionLangGroup;
import eki.ekilex.data.DefinitionNote;
import eki.ekilex.data.EkiUser;
import eki.ekilex.data.EkiUserProfile;
import eki.ekilex.data.FreeForm;
import eki.ekilex.data.Government;
import eki.ekilex.data.Image;
import eki.ekilex.data.ImageSourceTuple;
import eki.ekilex.data.LexemeNote;
import eki.ekilex.data.Meaning;
import eki.ekilex.data.MeaningNote;
import eki.ekilex.data.MeaningWord;
import eki.ekilex.data.MeaningWordLangGroup;
import eki.ekilex.data.NoteLangGroup;
import eki.ekilex.data.NoteSourceTuple;
import eki.ekilex.data.OrderedClassifier;
import eki.ekilex.data.Paradigm;
import eki.ekilex.data.ParadigmFormTuple;
import eki.ekilex.data.Relation;
import eki.ekilex.data.SearchDatasetsRestriction;
import eki.ekilex.data.SourceLink;
import eki.ekilex.data.Tag;
import eki.ekilex.data.Usage;
import eki.ekilex.data.UsageTranslationDefinitionTuple;
import eki.ekilex.data.Word;
import eki.ekilex.data.WordDetails;
import eki.ekilex.data.WordEtym;
import eki.ekilex.data.WordEtymTuple;
import eki.ekilex.data.WordGroup;
import eki.ekilex.data.WordLexeme;
import eki.ekilex.data.WordNote;
import eki.ekilex.data.WordsResult;
import eki.ekilex.service.db.LexSearchDbService;
import eki.ekilex.service.db.LifecycleLogDbService;
import eki.ekilex.service.util.PermCalculator;

@Component
public class LexSearchService extends AbstractWordSearchService {

	@Autowired
	private LexSearchDbService lexSearchDbService;

	@Autowired
	private LexemeLevelPreseUtil lexemeLevelPreseUtil;

	@Autowired
	private LifecycleLogDbService lifecycleLogDbService;

	@Autowired
	private PermCalculator permCalculator;

	@Transactional
	public WordDetails getWordDetails(
			Long wordId, List<String> selectedDatasetCodes, List<ClassifierSelect> languagesOrder, EkiUser user,
			EkiUserProfile userProfile, Tag activeTag, boolean isFullData) throws Exception {

		SearchDatasetsRestriction searchDatasetsRestriction = composeDatasetsRestriction(selectedDatasetCodes);
		Word word = lexSearchDbService.getWord(wordId);
		if (word == null) {
			return null;
		}
		DatasetPermission userRole = user.getRecentRole();
		permCalculator.applyCrud(userRole, word);
		List<Classifier> wordTypes = commonDataDbService.getWordTypes(wordId, classifierLabelLang, classifierLabelTypeDescrip);
		List<WordLexeme> lexemes = lexSearchDbService.getWordLexemes(wordId, searchDatasetsRestriction, classifierLabelLang, classifierLabelTypeDescrip);
		List<ParadigmFormTuple> paradigmFormTuples = lexSearchDbService.getParadigmFormTuples(wordId, word.getWordValue(), classifierLabelLang, classifierLabelTypeDescrip);
		List<Paradigm> paradigms = conversionUtil.composeParadigms(paradigmFormTuples);
		List<Relation> wordRelations = lexSearchDbService.getWordRelations(wordId, classifierLabelLang, classifierLabelTypeFull);
		List<WordEtymTuple> wordEtymTuples = lexSearchDbService.getWordEtymology(wordId);
		List<WordEtym> wordEtymology = conversionUtil.composeWordEtymology(wordEtymTuples);
		List<Relation> wordGroupMembers = lexSearchDbService.getWordGroupMembers(wordId, classifierLabelLang, classifierLabelTypeFull);
		List<WordGroup> wordGroups = conversionUtil.composeWordGroups(wordGroupMembers);
		List<FreeForm> odWordRecommendations = lexSearchDbService.getOdWordRecommendations(wordId);
		List<NoteSourceTuple> wordNoteSourceTuples = commonDataDbService.getWordNoteSourceTuples(wordId);
		List<WordNote> wordNotes = conversionUtil.composeNotes(WordNote.class, wordId, wordNoteSourceTuples);
		permCalculator.filterVisibility(userRole, wordNotes);
		Timestamp latestLogEventTime = lifecycleLogDbService.getLatestLogTimeForWord(wordId);

		boolean isFullDataCorrection = isFullData | CollectionUtils.size(lexemes) == 1;
		for (WordLexeme lexeme : lexemes) {
			populateLexeme(lexeme, languagesOrder, userRole, userProfile, isFullDataCorrection);
		}
		lexemeLevelPreseUtil.combineLevels(lexemes);
		boolean isActiveTagComplete = conversionUtil.isLexemesActiveTagComplete(userRole, lexemes, activeTag);

		WordDetails wordDetails = new WordDetails();
		word.setNotes(wordNotes);
		wordDetails.setWord(word);
		wordDetails.setWordTypes(wordTypes);
		wordDetails.setParadigms(paradigms);
		wordDetails.setLexemes(lexemes);
		wordDetails.setRelations(wordRelations);
		wordDetails.setWordEtymology(wordEtymology);
		wordDetails.setWordGroups(wordGroups);
		wordDetails.setOdWordRecommendations(odWordRecommendations);
		wordDetails.setActiveTagComplete(isActiveTagComplete);
		wordDetails.setLastChangedOn(latestLogEventTime);

		return wordDetails;
	}

	@Transactional
	public WordLexeme getDefaultWordLexeme(Long lexemeId, List<ClassifierSelect> languagesOrder) throws Exception {

		WordLexeme lexeme = lexSearchDbService.getLexeme(lexemeId, classifierLabelLang, classifierLabelTypeDescrip);
		if (lexeme != null) {
			populateLexeme(lexeme, languagesOrder, new DatasetPermission(), null, true);
		}
		return lexeme;
	}

	@Transactional
	public WordLexeme getWordLexeme(
			Long lexemeId, List<ClassifierSelect> languagesOrder, EkiUserProfile userProfile, DatasetPermission userRole, boolean isFullData) throws Exception {

		WordLexeme lexeme = lexSearchDbService.getLexeme(lexemeId, classifierLabelLang, classifierLabelTypeDescrip);
		if (lexeme != null) {
			populateLexeme(lexeme, languagesOrder, userRole, userProfile, isFullData);
		}
		return lexeme;
	}

	@Transactional
	public List<WordLexeme> getWordLexemesWithDefinitionsData(
			String searchFilter, List<String> datasetCodes, DatasetPermission userRole, List<String> tagNames) {

		SearchDatasetsRestriction searchDatasetsRestriction = composeDatasetsRestriction(datasetCodes);
		List<WordLexeme> lexemes = new ArrayList<>();
		if (isNotBlank(searchFilter)) {
			WordsResult words = getWords(searchFilter, datasetCodes, userRole, tagNames, false, DEFAULT_OFFSET, DEFAULT_MAX_RESULTS_LIMIT);
			if (CollectionUtils.isNotEmpty(words.getWords())) {
				for (Word word : words.getWords()) {
					List<WordLexeme> wordLexemes = lexSearchDbService.getWordLexemes(word.getWordId(), searchDatasetsRestriction, classifierLabelLang, classifierLabelTypeDescrip);
					wordLexemes.forEach(lexeme -> {
						Long lexemeId = lexeme.getLexemeId();
						Long meaningId = lexeme.getMeaningId();
						String datasetCode = lexeme.getDatasetCode();
						List<MeaningWord> meaningWords = lexSearchDbService.getMeaningWords(lexemeId);
						List<MeaningWordLangGroup> meaningWordLangGroups = conversionUtil.composeMeaningWordLangGroups(meaningWords, lexeme.getWordLang());
						List<Definition> definitions = commonDataDbService.getMeaningDefinitions(meaningId, datasetCode, classifierLabelLang, classifierLabelTypeDescrip);
						permCalculator.filterVisibility(userRole, definitions);
						lexeme.setMeaningWordLangGroups(meaningWordLangGroups);
						Meaning meaning = new Meaning();
						meaning.setDefinitions(definitions);
						lexeme.setMeaning(meaning);
					});
					lexemeLevelPreseUtil.combineLevels(wordLexemes);
					lexemes.addAll(wordLexemes);
				}
			}
		}
		return lexemes;
	}

	@Transactional
	public Word getWord(Long wordId) {
		return lexSearchDbService.getWord(wordId);
	}

	private void populateLexeme(
			WordLexeme lexeme, List<ClassifierSelect> languagesOrder, DatasetPermission userRole, EkiUserProfile userProfile, boolean isFullData) throws Exception {

		final String[] excludeMeaningAttributeTypes = new String[] {
				FreeformType.LEARNER_COMMENT.name(), FreeformType.SEMANTIC_TYPE.name(), FreeformType.NOTE.name()};
		final String[] excludeLexemeAttributeTypes = new String[] {
				FreeformType.GOVERNMENT.name(), FreeformType.GRAMMAR.name(), FreeformType.USAGE.name(),
				FreeformType.NOTE.name(), FreeformType.OD_LEXEME_RECOMMENDATION.name()};

		Long lexemeId = lexeme.getLexemeId();
		Long meaningId = lexeme.getMeaningId();
		String datasetCode = lexeme.getDatasetCode();
		String wordLang = lexeme.getWordLang();
		Meaning meaning = new Meaning();

		permCalculator.applyCrud(userRole, lexeme);
		List<String> tags = commonDataDbService.getLexemeTags(lexemeId);
		List<MeaningWord> meaningWords = lexSearchDbService.getMeaningWords(lexemeId);
		List<MeaningWordLangGroup> meaningWordLangGroups = conversionUtil.composeMeaningWordLangGroups(meaningWords, wordLang);
		List<OrderedClassifier> meaningDomains = commonDataDbService.getMeaningDomains(meaningId);
		meaningDomains = conversionUtil.removeOrderedClassifierDuplicates(meaningDomains);

		lexeme.setMeaningWordLangGroups(meaningWordLangGroups);
		meaning.setMeaningId(meaningId);
		meaning.setDomains(meaningDomains);

		List<Definition> definitions = commonDataDbService.getMeaningDefinitions(meaningId, datasetCode, classifierLabelLang, classifierLabelTypeDescrip);
		permCalculator.applyCrud(userRole, definitions);
		permCalculator.filterVisibility(userRole, definitions);

		if (isFullData) {

			List<DefSourceAndNoteSourceTuple> definitionsDataTuples = commonDataDbService.getMeaningDefSourceAndNoteSourceTuples(meaningId);
			conversionUtil.composeMeaningDefinitions(definitions, definitionsDataTuples);
			for (Definition definition : definitions) {
				List<DefinitionNote> definitionNotes = definition.getNotes();
				permCalculator.filterVisibility(userRole, definitionNotes);
			}
			List<Government> governments = commonDataDbService.getLexemeGovernments(lexemeId);
			List<FreeForm> grammars = commonDataDbService.getLexemeGrammars(lexemeId);
			List<UsageTranslationDefinitionTuple> usageTranslationDefinitionTuples =
					commonDataDbService.getLexemeUsageTranslationDefinitionTuples(lexemeId, classifierLabelLang, classifierLabelTypeDescrip);
			List<Usage> usages = conversionUtil.composeUsages(usageTranslationDefinitionTuples);
			permCalculator.applyCrud(userRole, usages);
			permCalculator.filterVisibility(userRole, usages);
			List<FreeForm> lexemeFreeforms = commonDataDbService.getLexemeFreeforms(lexemeId, excludeLexemeAttributeTypes);
			List<NoteSourceTuple> lexemeNoteSourceTuples = commonDataDbService.getLexemeNoteSourceTuples(lexemeId);
			List<LexemeNote> lexemeNotes = conversionUtil.composeNotes(LexemeNote.class, lexemeId, lexemeNoteSourceTuples);
			permCalculator.filterVisibility(userRole, lexemeNotes);
			List<NoteLangGroup> lexemeNoteLangGroups = conversionUtil.composeNoteLangGroups(lexemeNotes, languagesOrder);
			List<FreeForm> odLexemeRecommendations = commonDataDbService.getOdLexemeRecommendations(lexemeId);
			List<Relation> lexemeRelations = commonDataDbService.getLexemeRelations(lexemeId, classifierLabelLang, classifierLabelTypeFull);
			List<SourceLink> lexemeSourceLinks = commonDataDbService.getLexemeSourceLinks(lexemeId);
			List<CollocationTuple> primaryCollocTuples = lexSearchDbService.getPrimaryCollocationTuples(lexemeId);
			List<CollocationPosGroup> collocationPosGroups = conversionUtil.composeCollocPosGroups(primaryCollocTuples);
			List<CollocationTuple> secondaryCollocTuples = lexSearchDbService.getSecondaryCollocationTuples(lexemeId);
			List<Collocation> secondaryCollocations = conversionUtil.composeCollocations(secondaryCollocTuples);

			List<FreeForm> meaningFreeforms = commonDataDbService.getMeaningFreeforms(meaningId, excludeMeaningAttributeTypes);
			List<FreeForm> meaningLearnerComments = commonDataDbService.getMeaningLearnerComments(meaningId);
			List<ImageSourceTuple> meaningImageSourceTuples = commonDataDbService.getMeaningImageSourceTuples(meaningId);
			List<Image> meaningImages = conversionUtil.composeMeaningImages(meaningImageSourceTuples);
			List<NoteSourceTuple> meaningNoteSourceTuples = commonDataDbService.getMeaningNoteSourceTuples(meaningId);
			List<MeaningNote> meaningNotes = conversionUtil.composeNotes(MeaningNote.class, meaningId, meaningNoteSourceTuples);
			permCalculator.filterVisibility(userRole, meaningNotes);
			List<NoteLangGroup> meaningNoteLangGroups = conversionUtil.composeNoteLangGroups(meaningNotes, languagesOrder);
			List<Classifier> meaningSemanticTypes = commonDataDbService.getMeaningSemanticTypes(meaningId, classifierLabelLang, classifierLabelTypeDescrip);
			List<String> meaningWordPreferredOrderDatasetCodes = Arrays.asList(datasetCode);
			List<Relation> meaningRelations = commonDataDbService.getMeaningRelations(meaningId, meaningWordPreferredOrderDatasetCodes, classifierLabelLang, classifierLabelTypeDescrip);
			List<List<Relation>> viewMeaningRelations = conversionUtil.composeViewMeaningRelations(meaningRelations, userProfile, wordLang, languagesOrder);
			List<DefinitionLangGroup> definitionLangGroups = conversionUtil.composeMeaningDefinitionLangGroups(definitions, languagesOrder);

			lexeme.setGovernments(governments);
			lexeme.setGrammars(grammars);
			lexeme.setUsages(usages);
			lexeme.setLexemeFreeforms(lexemeFreeforms);
			lexeme.setLexemeNoteLangGroups(lexemeNoteLangGroups);
			lexeme.setOdLexemeRecommendations(odLexemeRecommendations);
			lexeme.setLexemeRelations(lexemeRelations);
			lexeme.setSourceLinks(lexemeSourceLinks);
			lexeme.setCollocationPosGroups(collocationPosGroups);
			lexeme.setSecondaryCollocations(secondaryCollocations);

			permCalculator.applyCrud(userRole, meaning);
			meaning.setFreeforms(meaningFreeforms);
			meaning.setLearnerComments(meaningLearnerComments);
			meaning.setImages(meaningImages);
			meaning.setNoteLangGroups(meaningNoteLangGroups);
			meaning.setSemanticTypes(meaningSemanticTypes);
			meaning.setRelations(meaningRelations);
			meaning.setViewRelations(viewMeaningRelations);
			meaning.setDefinitionLangGroups(definitionLangGroups);

			boolean lexemeOrMeaningClassifiersExist =
					StringUtils.isNotBlank(lexeme.getLexemeValueStateCode())
							|| StringUtils.isNotBlank(lexeme.getLexemeFrequencyGroupCode())
							|| StringUtils.isNotBlank(lexeme.getLexemeProcessStateCode())
							|| CollectionUtils.isNotEmpty(lexeme.getPos())
							|| CollectionUtils.isNotEmpty(lexeme.getDerivs())
							|| CollectionUtils.isNotEmpty(lexeme.getRegisters())
							|| CollectionUtils.isNotEmpty(lexeme.getGrammars())
							|| CollectionUtils.isNotEmpty(lexeme.getLexemeFrequencies())
							|| CollectionUtils.isNotEmpty(meaning.getDomains())
							|| CollectionUtils.isNotEmpty(meaning.getSemanticTypes());
			lexeme.setLexemeOrMeaningClassifiersExist(lexemeOrMeaningClassifiersExist);
		}

		meaning.setDefinitions(definitions);
		lexeme.setMeaning(meaning);
		lexeme.setTags(tags);
	}
}