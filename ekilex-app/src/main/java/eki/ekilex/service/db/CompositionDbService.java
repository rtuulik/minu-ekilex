package eki.ekilex.service.db;

import static eki.ekilex.data.db.Tables.COLLOCATION;
import static eki.ekilex.data.db.Tables.DEFINITION;
import static eki.ekilex.data.db.Tables.DEFINITION_DATASET;
import static eki.ekilex.data.db.Tables.DEFINITION_FREEFORM;
import static eki.ekilex.data.db.Tables.DEFINITION_SOURCE_LINK;
import static eki.ekilex.data.db.Tables.FORM;
import static eki.ekilex.data.db.Tables.FREEFORM;
import static eki.ekilex.data.db.Tables.FREEFORM_SOURCE_LINK;
import static eki.ekilex.data.db.Tables.LEXEME;
import static eki.ekilex.data.db.Tables.LEXEME_ACTIVITY_LOG;
import static eki.ekilex.data.db.Tables.LEXEME_DERIV;
import static eki.ekilex.data.db.Tables.LEXEME_FREEFORM;
import static eki.ekilex.data.db.Tables.LEXEME_POS;
import static eki.ekilex.data.db.Tables.LEXEME_REGION;
import static eki.ekilex.data.db.Tables.LEXEME_REGISTER;
import static eki.ekilex.data.db.Tables.LEXEME_SOURCE_LINK;
import static eki.ekilex.data.db.Tables.LEXEME_TAG;
import static eki.ekilex.data.db.Tables.LEX_COLLOC;
import static eki.ekilex.data.db.Tables.LEX_COLLOC_POS_GROUP;
import static eki.ekilex.data.db.Tables.LEX_COLLOC_REL_GROUP;
import static eki.ekilex.data.db.Tables.LEX_RELATION;
import static eki.ekilex.data.db.Tables.MEANING;
import static eki.ekilex.data.db.Tables.MEANING_ACTIVITY_LOG;
import static eki.ekilex.data.db.Tables.MEANING_DOMAIN;
import static eki.ekilex.data.db.Tables.MEANING_FREEFORM;
import static eki.ekilex.data.db.Tables.MEANING_RELATION;
import static eki.ekilex.data.db.Tables.MEANING_SEMANTIC_TYPE;
import static eki.ekilex.data.db.Tables.PARADIGM;
import static eki.ekilex.data.db.Tables.WORD;
import static eki.ekilex.data.db.Tables.WORD_ACTIVITY_LOG;
import static eki.ekilex.data.db.Tables.WORD_ETYMOLOGY;
import static eki.ekilex.data.db.Tables.WORD_ETYMOLOGY_RELATION;
import static eki.ekilex.data.db.Tables.WORD_ETYMOLOGY_SOURCE_LINK;
import static eki.ekilex.data.db.Tables.WORD_FREEFORM;
import static eki.ekilex.data.db.Tables.WORD_GROUP_MEMBER;
import static eki.ekilex.data.db.Tables.WORD_RELATION;
import static eki.ekilex.data.db.Tables.WORD_WORD_TYPE;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.jooq.Condition;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;

import eki.common.constant.Complexity;
import eki.common.constant.GlobalConstant;
import eki.ekilex.data.IdPair;
import eki.ekilex.data.LexCollocationGroupTuple;
import eki.ekilex.data.LexCollocationTuple;
import eki.ekilex.data.SimpleWord;
import eki.ekilex.data.db.tables.Collocation;
import eki.ekilex.data.db.tables.Definition;
import eki.ekilex.data.db.tables.LexColloc;
import eki.ekilex.data.db.tables.LexCollocPosGroup;
import eki.ekilex.data.db.tables.LexCollocRelGroup;
import eki.ekilex.data.db.tables.LexRelation;
import eki.ekilex.data.db.tables.Lexeme;
import eki.ekilex.data.db.tables.LexemeActivityLog;
import eki.ekilex.data.db.tables.LexemeSourceLink;
import eki.ekilex.data.db.tables.LexemeTag;
import eki.ekilex.data.db.tables.Meaning;
import eki.ekilex.data.db.tables.MeaningActivityLog;
import eki.ekilex.data.db.tables.MeaningRelation;
import eki.ekilex.data.db.tables.MeaningSemanticType;
import eki.ekilex.data.db.tables.WordActivityLog;
import eki.ekilex.data.db.tables.WordEtymologyRelation;
import eki.ekilex.data.db.tables.WordGroupMember;
import eki.ekilex.data.db.tables.WordRelation;
import eki.ekilex.data.db.tables.WordWordType;
import eki.ekilex.data.db.tables.records.DefinitionDatasetRecord;
import eki.ekilex.data.db.tables.records.DefinitionFreeformRecord;
import eki.ekilex.data.db.tables.records.DefinitionRecord;
import eki.ekilex.data.db.tables.records.DefinitionSourceLinkRecord;
import eki.ekilex.data.db.tables.records.FormRecord;
import eki.ekilex.data.db.tables.records.FreeformRecord;
import eki.ekilex.data.db.tables.records.FreeformSourceLinkRecord;
import eki.ekilex.data.db.tables.records.LexCollocRecord;
import eki.ekilex.data.db.tables.records.LexRelationRecord;
import eki.ekilex.data.db.tables.records.LexemeDerivRecord;
import eki.ekilex.data.db.tables.records.LexemeFreeformRecord;
import eki.ekilex.data.db.tables.records.LexemePosRecord;
import eki.ekilex.data.db.tables.records.LexemeRecord;
import eki.ekilex.data.db.tables.records.LexemeRegisterRecord;
import eki.ekilex.data.db.tables.records.LexemeSourceLinkRecord;
import eki.ekilex.data.db.tables.records.MeaningDomainRecord;
import eki.ekilex.data.db.tables.records.MeaningFreeformRecord;
import eki.ekilex.data.db.tables.records.MeaningRecord;
import eki.ekilex.data.db.tables.records.MeaningRelationRecord;
import eki.ekilex.data.db.tables.records.ParadigmRecord;
import eki.ekilex.data.db.tables.records.WordEtymologyRecord;
import eki.ekilex.data.db.tables.records.WordEtymologyRelationRecord;
import eki.ekilex.data.db.tables.records.WordEtymologySourceLinkRecord;
import eki.ekilex.data.db.tables.records.WordFreeformRecord;
import eki.ekilex.data.db.tables.records.WordGroupMemberRecord;
import eki.ekilex.data.db.tables.records.WordRecord;
import eki.ekilex.data.db.tables.records.WordRelationRecord;
import eki.ekilex.data.db.tables.records.WordWordTypeRecord;

@Component
public class CompositionDbService extends AbstractDataDbService implements GlobalConstant {

	public LexemeRecord getLexeme(Long lexemeId) {
		return create.selectFrom(LEXEME).where(LEXEME.ID.eq(lexemeId)).fetchOne();
	}

	public LexemeRecord getLexeme(Long wordId, Long meaningId, String datasetCode) {
		return create
				.selectFrom(LEXEME)
				.where(
						LEXEME.WORD_ID.eq(wordId)
								.and(LEXEME.MEANING_ID.eq(meaningId))
								.and(LEXEME.DATASET_CODE.eq(datasetCode)))
				.fetchOne();
	}

	public List<LexemeRecord> getLexemesWithHigherLevel1(Long wordId, String datasetCode, Integer level1) {
		return create
				.selectFrom(LEXEME)
				.where(LEXEME.WORD_ID.eq(wordId)
						.and(LEXEME.DATASET_CODE.eq(datasetCode))
						.and(LEXEME.LEVEL1.gt(level1)))
				.fetch();
	}

	public List<LexemeRecord> getLexemesWithHigherLevel2(Long wordId, String datasetCode, Integer level1, Integer level2) {
		return create
				.selectFrom(LEXEME)
				.where(LEXEME.WORD_ID.eq(wordId)
						.and(LEXEME.DATASET_CODE.eq(datasetCode))
						.and(LEXEME.LEVEL1.eq(level1))
						.and(LEXEME.LEVEL2.gt(level2)))
				.fetch();
	}

	public Integer getLevel2MinimumValue(Long wordId, String datasetCode, Integer level1) {
		return create
				.select(DSL.min(LEXEME.LEVEL2))
				.from(LEXEME)
				.where(LEXEME.WORD_ID.eq(wordId)
						.and(LEXEME.DATASET_CODE.eq(datasetCode))
						.and(LEXEME.LEVEL1.eq(level1)))
				.fetchOneInto(Integer.class);
	}

	public List<LexemeRecord> getWordLexemes(Long wordId) {
		return create
				.selectFrom(LEXEME).where(
					LEXEME.WORD_ID.eq(wordId))
				.fetch();
	}

	public List<LexemeRecord> getMeaningLexemes(Long meaningId) {
		return create
				.selectFrom(LEXEME).where(
						LEXEME.MEANING_ID.eq(meaningId))
				.fetch();
	}

	public List<LexemeRecord> getMeaningLexemes(Long meaningId, String datasetCode) {
		return create
				.selectFrom(LEXEME).where(
					LEXEME.MEANING_ID.eq(meaningId)
					.and(LEXEME.DATASET_CODE.eq(datasetCode)))
				.fetch();
	}

	public List<LexemeRecord> getMeaningLexemes(Long meaningId, List<String> userPermDatasetCodes) {
		return create
				.selectFrom(LEXEME).where(
						LEXEME.MEANING_ID.eq(meaningId)
								.and(LEXEME.IS_PUBLIC.eq(PUBLICITY_PUBLIC)
										.or(LEXEME.DATASET_CODE.in(userPermDatasetCodes))))
				.fetch();
	}

	public List<Long> getMeaningDefinitionIds(Long meaningId, boolean publicDataOnly) {

		Condition where = DEFINITION.MEANING_ID.eq(meaningId);
		if (publicDataOnly) {
			where = where.and(DEFINITION.IS_PUBLIC.isTrue());
		}
		return create.select(DEFINITION.ID).from(DEFINITION).where(where).orderBy(DEFINITION.ORDER_BY).fetchInto(Long.class);
	}

	public List<IdPair> getMeaningsCommonWordsLexemeIdPairs(Long meaningId, Long sourceMeaningId) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		Meaning m1 = MEANING.as("m1");
		Meaning m2 = MEANING.as("m2");

		SelectConditionStep<Record1<Long>> wordIds = DSL.
				selectDistinct(l1.WORD_ID)
				.from(l1, m1)
				.where(l1.MEANING_ID.eq(meaningId)
						.and(l1.MEANING_ID.eq(m1.ID))
						.andExists(DSL
								.select(l2.ID)
								.from(l2, m2)
								.where(m2.ID.eq(sourceMeaningId)
										.and(l2.MEANING_ID.eq(m2.ID))
										.and(l2.WORD_ID.eq(l1.WORD_ID)))));

		return create
				.select(l1.ID.as("id1"), l2.ID.as("id2"))
				.from(l1, l2)
				.where(l1.WORD_ID.in(wordIds)
						.and(l1.DATASET_CODE.eq(l2.DATASET_CODE))
						.and(l1.MEANING_ID.eq(meaningId))
						.and(l2.MEANING_ID.eq(sourceMeaningId))
						.and(l2.WORD_ID.eq(l1.WORD_ID)))
				.fetchInto(IdPair.class);
	}

	public List<LexRelationRecord> getLexemeRelations(Long lexemeId) {

		return create
				.selectFrom(LEX_RELATION)
				.where(LEX_RELATION.LEXEME1_ID.eq(lexemeId).or(LEX_RELATION.LEXEME2_ID.eq(lexemeId)))
				.orderBy(LEX_RELATION.ORDER_BY)
				.fetch();
	}

	public void joinMeanings(Long targetMeaningId, Long sourceMeaningId) {

		create.update(LEXEME).set(LEXEME.MEANING_ID, targetMeaningId).where(LEXEME.MEANING_ID.eq(sourceMeaningId)).execute();
		joinMeaningDefinitions(targetMeaningId, sourceMeaningId);
		joinMeaningDomains(targetMeaningId, sourceMeaningId);
		joinMeaningFreeforms(targetMeaningId, sourceMeaningId);
		joinMeaningRelations(targetMeaningId, sourceMeaningId);
		joinMeaningSemanticTypes(targetMeaningId, sourceMeaningId);

		MeaningActivityLog mals = MEANING_ACTIVITY_LOG.as("mals");
		MeaningActivityLog malt = MEANING_ACTIVITY_LOG.as("malt");
		create
				.update(mals)
				.set(mals.MEANING_ID, targetMeaningId)
				.where(
						mals.MEANING_ID.eq(sourceMeaningId)
								.andNotExists(DSL
										.select(malt.ID)
										.from(malt)
										.where(
												malt.MEANING_ID.eq(targetMeaningId)
														.and(malt.ACTIVITY_LOG_ID.eq(mals.ACTIVITY_LOG_ID)))))
				.execute();

		create.delete(MEANING).where(MEANING.ID.eq(sourceMeaningId)).execute();
	}

	public void joinLexemes(Long targetLexemeId, Long sourceLexemeId) {

		joinLexemeCollocations(targetLexemeId, sourceLexemeId);
		joinLexemeSourceLinks(targetLexemeId, sourceLexemeId);
		joinLexemeRegisters(targetLexemeId, sourceLexemeId);
		joinLexemePos(targetLexemeId, sourceLexemeId);
		joinLexemeFreeforms(targetLexemeId, sourceLexemeId);
		joinLexemeDerivs(targetLexemeId, sourceLexemeId);
		joinLexemeRegions(targetLexemeId, sourceLexemeId);
		joinLexemeRelations(targetLexemeId, sourceLexemeId);
		joinLexemePublicity(targetLexemeId, sourceLexemeId);
		joinLexemeComplexity(targetLexemeId, sourceLexemeId);
		joinLexemeTags(targetLexemeId, sourceLexemeId);

		LexemeActivityLog lals = LEXEME_ACTIVITY_LOG.as("lals");
		LexemeActivityLog lalt = LEXEME_ACTIVITY_LOG.as("lalt");
		create
				.update(lals)
				.set(lals.LEXEME_ID, targetLexemeId)
				.where(
						lals.LEXEME_ID.eq(sourceLexemeId)
								.andNotExists(DSL
										.select(lalt.ID)
										.from(lalt)
										.where(
												lalt.LEXEME_ID.eq(targetLexemeId)
														.and(lalt.ACTIVITY_LOG_ID.eq(lals.ACTIVITY_LOG_ID)))))
				.execute();

		create.delete(LEXEME).where(LEXEME.ID.eq(sourceLexemeId)).execute();
	}

	private void joinLexemeTags(Long lexemeId, Long sourceLexemeId) {

		LexemeTag lt1 = LEXEME_TAG.as("lt1");
		LexemeTag lt2 = LEXEME_TAG.as("lt2");
		create
				.update(lt1)
				.set(lt1.LEXEME_ID, lexemeId)
				.where(lt1.LEXEME_ID.eq(sourceLexemeId))
				.andNotExists(DSL
						.select(lt2.ID)
						.from(lt2)
						.where(lt2.LEXEME_ID.eq(lexemeId)
								.and(lt2.TAG_NAME.eq(lt1.TAG_NAME))))
				.execute();
	}

	private void joinLexemePublicity(Long targetLexemeId, Long sourceLexemeId) {

		boolean targetLexemePublicity = create.select(LEXEME.IS_PUBLIC).from(LEXEME).where(LEXEME.ID.eq(targetLexemeId)).fetchOneInto(boolean.class);
		if (PUBLICITY_PUBLIC == targetLexemePublicity) {
			return;
		}

		boolean sourceLexemePublicity = create.select(LEXEME.IS_PUBLIC).from(LEXEME).where(LEXEME.ID.eq(sourceLexemeId)).fetchOneInto(boolean.class);
		if (PUBLICITY_PUBLIC == sourceLexemePublicity) {
			create.update(LEXEME).set(LEXEME.IS_PUBLIC, PUBLICITY_PUBLIC).where(LEXEME.ID.eq(targetLexemeId)).execute();
		}
	}

	private void joinLexemeComplexity(Long targetLexemeId, Long sourceLexemeId) {

		Complexity targetLexemeComplexity = create.select(LEXEME.COMPLEXITY).from(LEXEME).where(LEXEME.ID.eq(targetLexemeId)).fetchOneInto(Complexity.class);
		if (Complexity.ANY == targetLexemeComplexity) {
			return;
		}
		Complexity sourceLexemeComplexity = create.select(LEXEME.COMPLEXITY).from(LEXEME).where(LEXEME.ID.eq(sourceLexemeId)).fetchOneInto(Complexity.class);
		if (targetLexemeComplexity != sourceLexemeComplexity) {
			create.update(LEXEME).set(LEXEME.COMPLEXITY, Complexity.ANY.name()).where(LEXEME.ID.eq(targetLexemeId)).execute();
		}
	}

	private void joinLexemeCollocations(Long lexemeId, Long sourceLexemeId) {

		LexColloc lc1 = LEX_COLLOC.as("lc1");
		LexColloc lc2 = LEX_COLLOC.as("lc2");
		create.update(lc1)
				.set(lc1.LEXEME_ID, lexemeId)
				.where(lc1.LEXEME_ID.eq(sourceLexemeId))
				.andNotExists(DSL
						.select(lc2.ID)
						.from(lc2)
						.where(lc2.LEXEME_ID.eq(lexemeId)
								.and(lc2.COLLOCATION_ID.eq(lc1.COLLOCATION_ID))))
				.execute();

		create.update(LEX_COLLOC_POS_GROUP).set(LEX_COLLOC_POS_GROUP.LEXEME_ID, lexemeId).where(LEX_COLLOC_POS_GROUP.LEXEME_ID.eq(sourceLexemeId)).execute();
	}

	private void joinLexemeRegions(Long lexemeId, Long sourceLexemeId) {

		create.update(LEXEME_REGION)
				.set(LEXEME_REGION.LEXEME_ID, lexemeId)
				.where(LEXEME_REGION.LEXEME_ID.eq(sourceLexemeId)
						.and(LEXEME_REGION.REGION_CODE.notIn(
								DSL.select(LEXEME_REGION.REGION_CODE).from(LEXEME_REGION).where(LEXEME_REGION.LEXEME_ID.eq(lexemeId)))))
				.execute();
	}

	private void joinLexemeRelations(Long lexemeId, Long sourceLexemeId) {

		LexRelation lr1 = LEX_RELATION.as("lr1");
		LexRelation lr2 = LEX_RELATION.as("lr2");

		create.update(lr1)
				.set(lr1.LEXEME1_ID, lexemeId)
				.where(
						lr1.LEXEME1_ID.eq(sourceLexemeId)
								.and(lr1.LEXEME2_ID.ne(lexemeId)))
				.andNotExists(DSL
						.select(lr2.ID)
						.from(lr2)
						.where(
								lr2.LEXEME1_ID.eq(lexemeId)
										.and(lr2.LEXEME2_ID.eq(lr1.LEXEME2_ID))
										.and(lr2.LEX_REL_TYPE_CODE.eq(lr1.LEX_REL_TYPE_CODE))))
				.execute();

		create.update(lr1)
				.set(lr1.LEXEME2_ID, lexemeId)
				.where(
						lr1.LEXEME2_ID.eq(sourceLexemeId)
								.and(lr1.LEXEME1_ID.ne(lexemeId)))
				.andNotExists(DSL
						.select(lr2.ID)
						.from(lr2)
						.where(
								lr2.LEXEME2_ID.eq(lexemeId)
										.and(lr2.LEXEME1_ID.eq(lr1.LEXEME1_ID))
										.and(lr2.LEX_REL_TYPE_CODE.eq(lr1.LEX_REL_TYPE_CODE))))
				.execute();
	}

	private void joinLexemeDerivs(Long lexemeId, Long sourceLexemeId) {

		create.update(LEXEME_DERIV)
				.set(LEXEME_DERIV.LEXEME_ID, lexemeId)
				.where(LEXEME_DERIV.LEXEME_ID.eq(sourceLexemeId)
						.and(LEXEME_DERIV.DERIV_CODE.notIn(
								DSL.select(LEXEME_DERIV.DERIV_CODE).from(LEXEME_DERIV).where(LEXEME_DERIV.LEXEME_ID.eq(lexemeId)))))
				.execute();
	}

	private void joinLexemeFreeforms(Long lexemeId, Long sourceLexemeId) {

		Result<FreeformRecord> lexemeFreeforms = create.selectFrom(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(LEXEME_FREEFORM.FREEFORM_ID).from(LEXEME_FREEFORM).where(LEXEME_FREEFORM.LEXEME_ID.eq(lexemeId))))
				.fetch();
		Result<FreeformRecord> sourceLexemeFreeforms = create.selectFrom(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(LEXEME_FREEFORM.FREEFORM_ID).from(LEXEME_FREEFORM).where(LEXEME_FREEFORM.LEXEME_ID.eq(sourceLexemeId))))
				.fetch();

		List<Long> nonDublicateFreeformIds = getNonDuplicateFreeformIds(lexemeFreeforms, sourceLexemeFreeforms);

		create.update(LEXEME_FREEFORM)
				.set(LEXEME_FREEFORM.LEXEME_ID, lexemeId)
				.where(LEXEME_FREEFORM.LEXEME_ID.eq(sourceLexemeId)
						.and(LEXEME_FREEFORM.FREEFORM_ID.in(nonDublicateFreeformIds)))
				.execute();

		create.delete(FREEFORM)
				.where(FREEFORM.ID.in(DSL
						.select(LEXEME_FREEFORM.FREEFORM_ID)
						.from(LEXEME_FREEFORM)
						.where(LEXEME_FREEFORM.LEXEME_ID.eq(sourceLexemeId))))
				.execute();

		create.delete(LEXEME_FREEFORM).where(LEXEME_FREEFORM.LEXEME_ID.eq(sourceLexemeId)).execute();
	}

	private void joinLexemePos(Long lexemeId, Long sourceLexemeId) {

		create.update(LEXEME_POS)
				.set(LEXEME_POS.LEXEME_ID, lexemeId)
				.where(LEXEME_POS.LEXEME_ID.eq(sourceLexemeId)
						.and(LEXEME_POS.POS_CODE.notIn(
								DSL.select(LEXEME_POS.POS_CODE).from(LEXEME_POS).where(LEXEME_POS.LEXEME_ID.eq(lexemeId))))).execute();
	}

	private void joinLexemeRegisters(Long lexemeId, Long sourceLexemeId) {

		create.update(LEXEME_REGISTER)
				.set(LEXEME_REGISTER.LEXEME_ID, lexemeId)
				.where(LEXEME_REGISTER.LEXEME_ID.eq(sourceLexemeId)
						.and(LEXEME_REGISTER.REGISTER_CODE.notIn(
								DSL.select(LEXEME_REGISTER.REGISTER_CODE).from(LEXEME_REGISTER).where(LEXEME_REGISTER.LEXEME_ID.eq(lexemeId)))))
				.execute();
	}

	private void joinLexemeSourceLinks(Long lexemeId, Long sourceLexemeId) {

		LexemeSourceLink lsl1 = LEXEME_SOURCE_LINK.as("lsl1");
		LexemeSourceLink lsl2 = LEXEME_SOURCE_LINK.as("lsl2");
		create.update(lsl1)
				.set(lsl1.LEXEME_ID, lexemeId)
				.where(lsl1.LEXEME_ID.eq(sourceLexemeId))
				.andNotExists(DSL
						.select(lsl2.ID)
						.from(lsl2)
						.where(lsl2.LEXEME_ID.eq(lexemeId)
								.and(lsl2.TYPE.eq(lsl1.TYPE))
								.and(lsl2.VALUE.eq(lsl1.VALUE))))
				.execute();
	}

	private void joinMeaningSemanticTypes(Long meaningId, Long sourceMeaningId) {

		MeaningSemanticType mst1 = MEANING_SEMANTIC_TYPE.as("mst1");
		MeaningSemanticType mst2 = MEANING_SEMANTIC_TYPE.as("mst2");

		create.update(mst1)
				.set(mst1.MEANING_ID, meaningId)
				.where(mst1.MEANING_ID.eq(sourceMeaningId))
				.andNotExists(DSL
						.select(mst2.ID)
						.from(mst2)
						.where(
								mst2.MEANING_ID.eq(meaningId)
										.and(mst2.SEMANTIC_TYPE_CODE.eq(mst1.SEMANTIC_TYPE_CODE))))
				.execute();
	}

	private void joinMeaningRelations(Long meaningId, Long sourceMeaningId) {

		MeaningRelation mr1 = MEANING_RELATION.as("mr1");
		MeaningRelation mr2 = MEANING_RELATION.as("mr2");

		create.update(mr1)
				.set(mr1.MEANING1_ID, meaningId)
				.where(
						mr1.MEANING1_ID.eq(sourceMeaningId)
								.and(mr1.MEANING2_ID.ne(meaningId)))
				.andNotExists(DSL
						.select(mr2.ID)
						.from(mr2)
						.where(
								mr2.MEANING1_ID.eq(meaningId)
										.and(mr2.MEANING2_ID.eq(mr1.MEANING2_ID))
										.and(mr2.MEANING_REL_TYPE_CODE.eq(mr1.MEANING_REL_TYPE_CODE))))
				.execute();

		create.update(mr1)
				.set(mr1.MEANING2_ID, meaningId)
				.where(
						mr1.MEANING2_ID.eq(sourceMeaningId)
								.and(mr1.MEANING1_ID.ne(meaningId)))
				.andNotExists(DSL
						.select(mr2.ID)
						.from(mr2)
						.where(
								mr2.MEANING2_ID.eq(meaningId)
										.and(mr2.MEANING1_ID.eq(mr1.MEANING1_ID))
										.and(mr2.MEANING_REL_TYPE_CODE.eq(mr1.MEANING_REL_TYPE_CODE))))
				.execute();
	}

	private void joinMeaningFreeforms(Long meaningId, Long sourceMeaningId) {

		Result<FreeformRecord> meaningFreeforms = create
				.selectFrom(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(MEANING_FREEFORM.FREEFORM_ID).from(MEANING_FREEFORM).where(MEANING_FREEFORM.MEANING_ID.eq(meaningId))))
				.fetch();
		Result<FreeformRecord> sourceMeaningFreeforms = create.selectFrom(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(MEANING_FREEFORM.FREEFORM_ID).from(MEANING_FREEFORM).where(MEANING_FREEFORM.MEANING_ID.eq(sourceMeaningId))))
				.fetch();

		List<Long> nonDublicateFreeformIds = getNonDuplicateFreeformIds(meaningFreeforms, sourceMeaningFreeforms);

		create.update(MEANING_FREEFORM)
				.set(MEANING_FREEFORM.MEANING_ID, meaningId)
				.where(MEANING_FREEFORM.MEANING_ID.eq(sourceMeaningId)
						.and(MEANING_FREEFORM.FREEFORM_ID.in(nonDublicateFreeformIds)))
				.execute();

		create.delete(FREEFORM)
				.where(FREEFORM.ID.in(DSL
						.select(MEANING_FREEFORM.FREEFORM_ID)
						.from(MEANING_FREEFORM)
						.where(MEANING_FREEFORM.MEANING_ID.eq(sourceMeaningId))))
				.execute();

		create.delete(MEANING_FREEFORM).where(MEANING_FREEFORM.MEANING_ID.eq(sourceMeaningId)).execute();
	}

	private void joinMeaningDomains(Long meaningId, Long sourceMeaningId) {
		create.update(MEANING_DOMAIN).set(MEANING_DOMAIN.MEANING_ID, meaningId)
				.where(
						MEANING_DOMAIN.MEANING_ID.eq(sourceMeaningId)
								.and(DSL.row(MEANING_DOMAIN.DOMAIN_CODE, MEANING_DOMAIN.DOMAIN_ORIGIN).notIn(
										DSL.select(MEANING_DOMAIN.DOMAIN_CODE, MEANING_DOMAIN.DOMAIN_ORIGIN).from(MEANING_DOMAIN).where(MEANING_DOMAIN.MEANING_ID.eq(meaningId)))))
				.execute();
	}

	private void joinMeaningDefinitions(Long meaningId, Long sourceMeaningId) {

		Definition def1 = DEFINITION.as("def1");
		Definition def2 = DEFINITION.as("def2");

		create.update(def1)
				.set(def1.MEANING_ID, meaningId)
				.where(def1.MEANING_ID.eq(sourceMeaningId))
				.andNotExists(DSL
						.select(def2.ID)
						.from(def2)
						.where(def2.MEANING_ID.eq(meaningId)
								.and(def2.VALUE.eq(def1.VALUE))
								.and(def2.COMPLEXITY.eq(def1.COMPLEXITY))))
				.execute();
	}

	public Long cloneLexeme(Long lexemeId, Long meaningId, Long wordId) {

		LexemeRecord lexeme = create.selectFrom(LEXEME).where(LEXEME.ID.eq(lexemeId)).fetchOne();
		LexemeRecord clonedLexeme = lexeme.copy();
		if (meaningId != null) {
			clonedLexeme.setMeaningId(meaningId);
		}
		if (wordId != null) {
			clonedLexeme.setWordId(wordId);
		}
		clonedLexeme.changed(LEXEME.ORDER_BY, false);
		clonedLexeme.store();
		return clonedLexeme.getId();
	}

	public Long cloneEmptyLexeme(Long lexemeId, Long meaningId) {

		LexemeRecord lexeme = create.selectFrom(LEXEME).where(LEXEME.ID.eq(lexemeId)).fetchOne();
		LexemeRecord clonedLexeme = lexeme.copy();
		clonedLexeme.setMeaningId(meaningId);
		clonedLexeme.changed(LEXEME.ORDER_BY, false);
		clonedLexeme.setIsPublic(PUBLICITY_PUBLIC);
		clonedLexeme.store();
		return clonedLexeme.getId();
	}

	public void cloneLexemeDerivs(Long lexemeId, Long clonedLexemeId) {

		Result<LexemeDerivRecord> lexemeDerivatives = create.selectFrom(LEXEME_DERIV)
				.where(LEXEME_DERIV.LEXEME_ID.eq(lexemeId))
				.orderBy(LEXEME_DERIV.ID)
				.fetch();
		lexemeDerivatives.stream().map(LexemeDerivRecord::copy).forEach(clonedLexemeDeriv -> {
			clonedLexemeDeriv.setLexemeId(clonedLexemeId);
			clonedLexemeDeriv.store();
		});
	}

	public void cloneLexemeFreeforms(Long lexemeId, Long clonedLexemeId, boolean publicDataOnly) {

		Condition where = LEXEME_FREEFORM.LEXEME_ID.eq(lexemeId).and(LEXEME_FREEFORM.FREEFORM_ID.eq(FREEFORM.ID));
		if (publicDataOnly) {
			where = where.and(FREEFORM.IS_PUBLIC.isTrue());
		}
		List<Long> lexemeFreeformIds = create.select(FREEFORM.ID).from(FREEFORM, LEXEME_FREEFORM).where(where).orderBy(LEXEME_FREEFORM.ID).fetchInto(Long.class);
		lexemeFreeformIds.forEach(lexemeFreeformId -> {
			Long clonedFreeformId = cloneFreeform(lexemeFreeformId, null);
			LexemeFreeformRecord clonedLexemeFreeform = create.newRecord(LEXEME_FREEFORM);
			clonedLexemeFreeform.setLexemeId(clonedLexemeId);
			clonedLexemeFreeform.setFreeformId(clonedFreeformId);
			clonedLexemeFreeform.store();
		});
	}

	public void cloneLexemePoses(Long lexemeId, Long clonedLexemeId) {

		Result<LexemePosRecord> lexemePoses = create.selectFrom(LEXEME_POS)
				.where(LEXEME_POS.LEXEME_ID.eq(lexemeId))
				.orderBy(LEXEME_POS.ORDER_BY)
				.fetch();
		lexemePoses.stream().map(LexemePosRecord::copy).forEach(clonedLexemePos -> {
			clonedLexemePos.setLexemeId(clonedLexemeId);
			clonedLexemePos.changed(LEXEME_POS.ORDER_BY, false);
			clonedLexemePos.store();
		});
	}

	public void cloneLexemeRegisters(Long lexemeId, Long clonedLexemeId) {

		Result<LexemeRegisterRecord> lexemeRegisters = create.selectFrom(LEXEME_REGISTER)
				.where(LEXEME_REGISTER.LEXEME_ID.eq(lexemeId))
				.orderBy(LEXEME_REGISTER.ORDER_BY)
				.fetch();
		lexemeRegisters.stream().map(LexemeRegisterRecord::copy).forEach(clonedLexemeRegister -> {
			clonedLexemeRegister.setLexemeId(clonedLexemeId);
			clonedLexemeRegister.changed(LEXEME_REGISTER.ORDER_BY, false);
			clonedLexemeRegister.store();
		});
	}

	public void cloneLexemeSoureLinks(Long lexemeId, Long clonedLexemeId) {

		Result<LexemeSourceLinkRecord> lexemeSourceLinks = create.selectFrom(LEXEME_SOURCE_LINK)
						.where(LEXEME_SOURCE_LINK.LEXEME_ID.eq(lexemeId))
						.orderBy(LEXEME_SOURCE_LINK.ORDER_BY)
						.fetch();
		lexemeSourceLinks.stream().map(LexemeSourceLinkRecord::copy).forEach(clonedLexemeSourceLink -> {
			clonedLexemeSourceLink.setLexemeId(clonedLexemeId);
			clonedLexemeSourceLink.changed(LEXEME_SOURCE_LINK.ORDER_BY, false);
			clonedLexemeSourceLink.store();
		});
	}

	public void cloneLexemeCollocations(Long lexemeId, Long clonedLexemeId) {

		Map<Long, Long> collocIdMap = new HashMap<>();
		Map<Long, Long> relGroupIdMap = new HashMap<>();
		Map<Long, Long> posGroupIdMap = new HashMap<>();
		List<LexCollocationTuple> lexCollocationTuples = getLexCollocationTuples(lexemeId);
		List<LexCollocationGroupTuple> lexCollocationGroupTuples = getLexCollocationGroupTuples(lexemeId);
		Map<Long, LexCollocationGroupTuple> lexCollocationGroupTupleMap = lexCollocationGroupTuples.stream()
				.collect(Collectors.toMap(lexCollocationGroupTuple -> lexCollocationGroupTuple.getRelGroupId(), lexCollocationGroupTuple -> lexCollocationGroupTuple));

		for (LexCollocationTuple lexCollocationTuple : lexCollocationTuples) {
			Long lexCollocId = lexCollocationTuple.getLexCollocId();
			Long collocId = lexCollocationTuple.getCollocId();
			Long relGroupId = lexCollocationTuple.getRelGroupId();

			Long clonedCollocId = collocIdMap.get(collocId);
			if (clonedCollocId == null) {
				clonedCollocId = createCollocation(lexCollocationTuple);
				collocIdMap.put(collocId, clonedCollocId);

				Result<LexCollocRecord> relatedLexCollocs = create.selectFrom(LEX_COLLOC).where(LEX_COLLOC.COLLOCATION_ID.eq(collocId).and(LEX_COLLOC.ID.ne(lexCollocId))).fetch();
				for (LexCollocRecord relatedLexColloc : relatedLexCollocs) {
					LexCollocRecord clonedRelatedLexColloc = relatedLexColloc.copy();
					clonedRelatedLexColloc.setCollocationId(clonedCollocId);
					clonedRelatedLexColloc.store();
				}
			}

			Long clonedRelGroupId = null;
			if (relGroupId != null) {
				clonedRelGroupId = relGroupIdMap.get(relGroupId);
				if (clonedRelGroupId == null) {
					LexCollocationGroupTuple lexCollocationGroupTuple = lexCollocationGroupTupleMap.get(relGroupId);
					Long posGroupId = lexCollocationGroupTuple.getPosGroupId();
					Long clonedPosGroupId = posGroupIdMap.get(posGroupId);
					if (clonedPosGroupId == null) {
						clonedPosGroupId = createPosGroup(lexCollocationGroupTuple, clonedLexemeId);
						posGroupIdMap.put(posGroupId, clonedPosGroupId);
					}
					clonedRelGroupId = createRelGroup(lexCollocationGroupTuple, clonedPosGroupId);
					relGroupIdMap.put(relGroupId, clonedRelGroupId);
				}
			}

			createLexColloc(lexCollocationTuple, clonedLexemeId, clonedRelGroupId, clonedCollocId);
		}
	}

	private List<LexCollocationTuple> getLexCollocationTuples(Long lexemeId) {

		LexColloc lc = LEX_COLLOC.as("lc");
		Collocation c = COLLOCATION.as("c");

		return create
				.select(
						lc.ID.as("lex_colloc_id"),
						lc.REL_GROUP_ID.as("rel_group_id"),
						lc.MEMBER_FORM.as("member_form"),
						lc.CONJUNCT.as("conjunct"),
						lc.WEIGHT.as("weight"),
						lc.MEMBER_ORDER.as("member_order"),
						lc.GROUP_ORDER.as("group_order"),
						c.ID.as("colloc_id"),
						c.VALUE.as("colloc_value"),
						c.DEFINITION.as("colloc_definition"),
						c.FREQUENCY.as("colloc_frequency"),
						c.SCORE.as("colloc_score"),
						c.USAGES.as("colloc_usages"),
						c.COMPLEXITY.as("colloc_complexity"))
				.from(lc, c)
				.where(lc.LEXEME_ID.eq(lexemeId)
						.and(c.ID.eq(lc.COLLOCATION_ID)))
				.fetchInto(LexCollocationTuple.class);
	}

	private List<LexCollocationGroupTuple> getLexCollocationGroupTuples(Long lexemeId) {

		LexCollocRelGroup lcrg = LEX_COLLOC_REL_GROUP.as("lcrg");
		LexCollocPosGroup lcpg = LEX_COLLOC_POS_GROUP.as("lcpg");

		return create
				.select(
						lcpg.ID.as("pos_group_id"),
						lcpg.POS_GROUP_CODE.as("pos_group_code"),
						lcpg.ORDER_BY.as("pos_group_order_by"),
						lcrg.ID.as("rel_group_id"),
						lcrg.NAME.as("rel_group_name"),
						lcrg.FREQUENCY.as("rel_group_frequency"),
						lcrg.SCORE.as("rel_group_score"),
						lcrg.ORDER_BY.as("rel_group_order_by"))
				.from(LEXEME
						.innerJoin(lcpg).on(lcpg.LEXEME_ID.eq(LEXEME.ID))
						.innerJoin(lcrg).on(lcrg.POS_GROUP_ID.eq(lcpg.ID)))
				.where(LEXEME.ID.eq(lexemeId))
				.fetchInto(LexCollocationGroupTuple.class);
	}

	private Long createCollocation(LexCollocationTuple lexCollocationTuple) {

		String value = lexCollocationTuple.getCollocValue();
		String definition = lexCollocationTuple.getCollocDefinition();
		BigDecimal frequency = lexCollocationTuple.getCollocFrequency() == null ? null : BigDecimal.valueOf(lexCollocationTuple.getCollocFrequency());
		BigDecimal score = lexCollocationTuple.getCollocScore() == null ? null : BigDecimal.valueOf(lexCollocationTuple.getCollocScore());
		String[] usages = lexCollocationTuple.getCollocUsages() == null ? null : lexCollocationTuple.getCollocUsages().toArray(new String[0]);
		String complexity = lexCollocationTuple.getCollocComplexity();

		return create
				.insertInto(COLLOCATION,
						COLLOCATION.VALUE,
						COLLOCATION.DEFINITION,
						COLLOCATION.FREQUENCY,
						COLLOCATION.SCORE,
						COLLOCATION.USAGES,
						COLLOCATION.COMPLEXITY)
				.values(value, definition, frequency, score, usages, complexity)
				.returning(COLLOCATION.ID)
				.fetchOne()
				.getId();
	}

	private Long createPosGroup(LexCollocationGroupTuple lexCollocationGroupTuple, Long lexemeId) {

		String posGroupCode = lexCollocationGroupTuple.getPosGroupCode();
		Long orderBy = lexCollocationGroupTuple.getPosGroupOrderBy();

		return create
				.insertInto(LEX_COLLOC_POS_GROUP,
						LEX_COLLOC_POS_GROUP.LEXEME_ID,
						LEX_COLLOC_POS_GROUP.POS_GROUP_CODE,
						LEX_COLLOC_POS_GROUP.ORDER_BY)
				.values(lexemeId, posGroupCode, orderBy)
				.returning(LEX_COLLOC_POS_GROUP.ID)
				.fetchOne()
				.getId();
	}

	private Long createRelGroup(LexCollocationGroupTuple lexCollocationGroupTuple, Long posGroupId) {

		String name = lexCollocationGroupTuple.getRelGroupName();
		BigDecimal frequency = lexCollocationGroupTuple.getRelGroupFrequency() == null ? null : BigDecimal.valueOf(lexCollocationGroupTuple.getRelGroupFrequency());
		BigDecimal score = lexCollocationGroupTuple.getRelGroupScore() == null ? null : BigDecimal.valueOf(lexCollocationGroupTuple.getRelGroupScore());
		Long orderBy = lexCollocationGroupTuple.getRelGroupOrderBy();

		return create
				.insertInto(LEX_COLLOC_REL_GROUP,
						LEX_COLLOC_REL_GROUP.POS_GROUP_ID,
						LEX_COLLOC_REL_GROUP.NAME,
						LEX_COLLOC_REL_GROUP.FREQUENCY,
						LEX_COLLOC_REL_GROUP.SCORE,
						LEX_COLLOC_REL_GROUP.ORDER_BY)
				.values(posGroupId, name, frequency, score, orderBy)
				.returning(LEX_COLLOC_REL_GROUP.ID)
				.fetchOne()
				.getId();
	}

	private Long createLexColloc(LexCollocationTuple lexCollocationTuple, Long lexemeId, Long relGroupId, Long collocationId) {

		String memberForm = lexCollocationTuple.getMemberForm();
		String conjunct = lexCollocationTuple.getConjunct();
		BigDecimal weight = lexCollocationTuple.getWeight() == null ? null : BigDecimal.valueOf(lexCollocationTuple.getWeight());
		Integer memberOrder = lexCollocationTuple.getMemberOrder();
		Integer groupOrder = lexCollocationTuple.getGroupOrder();

		return create
				.insertInto(LEX_COLLOC,
						LEX_COLLOC.LEXEME_ID,
						LEX_COLLOC.REL_GROUP_ID,
						LEX_COLLOC.COLLOCATION_ID,
						LEX_COLLOC.MEMBER_FORM,
						LEX_COLLOC.CONJUNCT,
						LEX_COLLOC.WEIGHT,
						LEX_COLLOC.MEMBER_ORDER,
						LEX_COLLOC.GROUP_ORDER)
				.values(lexemeId, relGroupId, collocationId, memberForm, conjunct, weight, memberOrder, groupOrder)
				.returning(LEX_COLLOC.ID)
				.fetchOne()
				.getId();
	}

	public Long cloneMeaning(Long meaningId) {

		MeaningRecord meaning = create.selectFrom(MEANING).where(MEANING.ID.eq(meaningId)).fetchOne();
		MeaningRecord clonedMeaning;
		if (meaning.fields().length == 1) {
			clonedMeaning = create.insertInto(MEANING).defaultValues().returning(MEANING.ID).fetchOne();
		} else {
			clonedMeaning = meaning.copy();
			clonedMeaning.store();
		}
		Long clonedMeaningId = clonedMeaning.getId();
		return clonedMeaningId;
	}

	public void cloneMeaningDomains(Long meaningId, Long clonedMeaningId) {

		Result<MeaningDomainRecord> meaningDomains = create.selectFrom(MEANING_DOMAIN)
				.where(MEANING_DOMAIN.MEANING_ID.eq(meaningId))
				.orderBy(MEANING_DOMAIN.ORDER_BY)
				.fetch();
		meaningDomains.stream().map(MeaningDomainRecord::copy).forEach(clonedDomain -> {
			clonedDomain.setMeaningId(clonedMeaningId);
			clonedDomain.changed(MEANING_DOMAIN.ORDER_BY, false);
			clonedDomain.store();
		});
	}

	public void cloneMeaningRelations(Long meaningId, Long clonedMeaningId) {

		Result<MeaningRelationRecord> meaningRelations = create.selectFrom(MEANING_RELATION)
				.where(MEANING_RELATION.MEANING1_ID.eq(meaningId).or(MEANING_RELATION.MEANING2_ID.eq(meaningId)))
				.orderBy(MEANING_RELATION.ORDER_BY)
				.fetch();
		meaningRelations.stream().map(MeaningRelationRecord::copy).forEach(clonedRelation -> {
			if (clonedRelation.getMeaning1Id().equals(meaningId)) {
				clonedRelation.setMeaning1Id(clonedMeaningId);
			} else {
				clonedRelation.setMeaning2Id(clonedMeaningId);
			}
			clonedRelation.changed(MEANING_RELATION.ORDER_BY, false);
			clonedRelation.store();
		});
	}

	public void cloneMeaningFreeforms(Long meaningId, Long clonedMeaningId, boolean publicDataOnly) {

		Condition where = MEANING_FREEFORM.MEANING_ID.eq(meaningId).and(MEANING_FREEFORM.FREEFORM_ID.eq(FREEFORM.ID));
		if (publicDataOnly) {
			where = where.and(FREEFORM.IS_PUBLIC.isTrue());
		}
		List<Long> meaningFreeformIds = create.select(FREEFORM.ID).from(FREEFORM, MEANING_FREEFORM).where(where).orderBy(MEANING_FREEFORM.ID).fetchInto(Long.class);
		for (Long meaningFreeformId : meaningFreeformIds) {
			Long clonedFreeformId = cloneFreeform(meaningFreeformId, null);
			MeaningFreeformRecord clonedMeaningFreeform = create.newRecord(MEANING_FREEFORM);
			clonedMeaningFreeform.setMeaningId(clonedMeaningId);
			clonedMeaningFreeform.setFreeformId(clonedFreeformId);
			clonedMeaningFreeform.store();
		}
	}

	public Long cloneMeaningDefinition(Long definitionId, Long meaningId) {

		DefinitionRecord definition = create.selectFrom(DEFINITION).where(DEFINITION.ID.eq(definitionId)).fetchOne();
		DefinitionRecord clonedDefinition = definition.copy();
		clonedDefinition.setMeaningId(meaningId);
		clonedDefinition.changed(DEFINITION.ORDER_BY, false);
		clonedDefinition.store();
		return clonedDefinition.getId();
	}

	public void cloneDefinitionFreeforms(Long definitionId, Long clonedDefinitionId) {

		Result<DefinitionFreeformRecord> definitionFreeforms = create.selectFrom(DEFINITION_FREEFORM)
				.where(DEFINITION_FREEFORM.DEFINITION_ID.eq(definitionId))
				.orderBy(DEFINITION_FREEFORM.ID)
				.fetch();
		for (DefinitionFreeformRecord definitionFreeform : definitionFreeforms) {
			Long clonedFreeformId = cloneFreeform(definitionFreeform.getFreeformId(), null);
			DefinitionFreeformRecord clonedDefinitionFreeform = create.newRecord(DEFINITION_FREEFORM);
			clonedDefinitionFreeform.setDefinitionId(clonedDefinitionId);
			clonedDefinitionFreeform.setFreeformId(clonedFreeformId);
			clonedDefinitionFreeform.store();
		}
	}

	public void cloneDefinitionDatasets(Long definitionId, Long clonedDefinintionId) {

		Result<DefinitionDatasetRecord> definitionDatasets = create
				.selectFrom(DEFINITION_DATASET)
				.where(DEFINITION_DATASET.DEFINITION_ID.eq(definitionId)).fetch();
		for (DefinitionDatasetRecord definitionDataset : definitionDatasets) {
			DefinitionDatasetRecord clonedDefinitionDataset = definitionDataset.copy();
			clonedDefinitionDataset.setDefinitionId(clonedDefinintionId);
			clonedDefinitionDataset.setDatasetCode(definitionDataset.getDatasetCode());
			clonedDefinitionDataset.store();
		}
	}

	public void cloneDefinitionSourceLinks(Long definitionId, Long clonedDefinintionId) {

		Result<DefinitionSourceLinkRecord> definitionSourceLinks = create.selectFrom(DEFINITION_SOURCE_LINK)
				.where(DEFINITION_SOURCE_LINK.DEFINITION_ID.eq(definitionId))
				.orderBy(DEFINITION_SOURCE_LINK.ORDER_BY)
				.fetch();
		definitionSourceLinks.stream().map(DefinitionSourceLinkRecord::copy).forEach(clonedDefinitionSourceLink -> {
			clonedDefinitionSourceLink.setDefinitionId(clonedDefinintionId);
			clonedDefinitionSourceLink.changed(DEFINITION_SOURCE_LINK.ORDER_BY, false);
			clonedDefinitionSourceLink.store();
		});
	}

	private Long cloneFreeform(Long freeformId, Long parentFreeformId) {
		FreeformRecord freeform = create.selectFrom(FREEFORM).where(FREEFORM.ID.eq(freeformId)).fetchOne();
		FreeformRecord clonedFreeform = freeform.copy();
		clonedFreeform.setParentId(parentFreeformId);
		clonedFreeform.changed(FREEFORM.ORDER_BY, false);
		clonedFreeform.store();
		Result<FreeformSourceLinkRecord> freeformSourceLinks = create.selectFrom(FREEFORM_SOURCE_LINK)
				.where(FREEFORM_SOURCE_LINK.FREEFORM_ID.eq(freeformId))
				.orderBy(FREEFORM_SOURCE_LINK.ORDER_BY)
				.fetch();
		freeformSourceLinks.forEach(sl -> {
			FreeformSourceLinkRecord clonedSourceLink = sl.copy();
			clonedSourceLink.setFreeformId(clonedFreeform.getId());
			clonedSourceLink.changed(FREEFORM_SOURCE_LINK.ORDER_BY, false);
			clonedSourceLink.store();
		});
		List<FreeformRecord> childFreeforms = create.selectFrom(FREEFORM)
				.where(FREEFORM.PARENT_ID.eq(freeformId))
				.orderBy(FREEFORM.ORDER_BY)
				.fetch();
		childFreeforms.forEach(f -> {
			cloneFreeform(f.getId(), clonedFreeform.getId());
		});
		return clonedFreeform.getId();
	}

	public Long cloneWord(SimpleWord simpleWord) {

		Long wordId = simpleWord.getWordId();
		String wordValue = simpleWord.getWordValue();
		String lang = simpleWord.getLang();

		Integer currentHomonymNumber = create
				.select(DSL.max(WORD.HOMONYM_NR))
				.from(WORD)
				.where(WORD.LANG.eq(lang).and(WORD.VALUE.eq(wordValue)))
				.fetchOneInto(Integer.class);

		int homonymNumber = currentHomonymNumber + 1;

		WordRecord word = create.selectFrom(WORD).where(WORD.ID.eq(wordId)).fetchOne();
		WordRecord clonedWord = word.copy();
		clonedWord.setHomonymNr(homonymNumber);
		clonedWord.store();
		return clonedWord.getId();
	}


	public void cloneWordParadigmsAndForms(Long wordId, Long clonedWordId) {

		Result<ParadigmRecord> paradigms = create.selectFrom(PARADIGM).where(PARADIGM.WORD_ID.eq(wordId)).fetch();
		paradigms.forEach(paradigm -> {
			ParadigmRecord clonedParadigm = paradigm.copy();
			clonedParadigm.setWordId(clonedWordId);
			clonedParadigm.store();

			Long paradigmId = paradigm.getId();
			Long clonedParadigmId = clonedParadigm.getId();

			Result<FormRecord> forms = create.selectFrom(FORM).where(FORM.PARADIGM_ID.eq(paradigmId)).orderBy(FORM.ORDER_BY).fetch();
			forms.stream().map(FormRecord::copy).forEach(clonedForm -> {
				clonedForm.setParadigmId(clonedParadigmId);
				clonedForm.changed(FORM.ORDER_BY, false);
				clonedForm.store();
			});
		});
	}

	public void cloneWordTypes(Long wordId, Long clonedWordId) {

		Result<WordWordTypeRecord> wordTypes = create
				.selectFrom(WORD_WORD_TYPE)
				.where(WORD_WORD_TYPE.WORD_ID.eq(wordId))
				.orderBy(WORD_WORD_TYPE.ORDER_BY)
				.fetch();
		wordTypes.stream().map(WordWordTypeRecord::copy).forEach(clonedWordType -> {
			clonedWordType.setWordId(clonedWordId);
			clonedWordType.changed(WORD_WORD_TYPE.ORDER_BY, false);
			clonedWordType.store();
		});
	}

	public void cloneWordRelations(Long wordId, Long clonedWordId) {

		Result<WordRelationRecord> wordRelations = create
				.selectFrom(WORD_RELATION)
				.where(WORD_RELATION.WORD1_ID.eq(wordId).or(WORD_RELATION.WORD2_ID.eq(wordId)))
				.orderBy(WORD_RELATION.ORDER_BY)
				.fetch();
		wordRelations.stream().map(WordRelationRecord::copy).forEach(clonedRelation -> {
			if (clonedRelation.getWord1Id().equals(wordId)) {
				clonedRelation.setWord1Id(clonedWordId);
			} else {
				clonedRelation.setWord2Id(clonedWordId);
			}
			clonedRelation.changed(WORD_RELATION.ORDER_BY, false);
			clonedRelation.store();
		});
	}

	public void cloneWordFreeforms(Long wordId, Long clonedWordId) {

		Result<WordFreeformRecord> wordFreeforms = create
				.selectFrom(WORD_FREEFORM)
				.where(WORD_FREEFORM.WORD_ID.eq(wordId))
				.orderBy(WORD_FREEFORM.ID)
				.fetch();
		for (WordFreeformRecord wordFreeform : wordFreeforms) {
			Long clonedFreeformId = cloneFreeform(wordFreeform.getFreeformId(), null);
			WordFreeformRecord clonedWordFreeform = create.newRecord(WORD_FREEFORM);
			clonedWordFreeform.setWordId(clonedWordId);
			clonedWordFreeform.setFreeformId(clonedFreeformId);
			clonedWordFreeform.store();
		}
	}

	public void cloneWordGroupMembers(Long wordId, Long clonedWordId) {

		Result<WordGroupMemberRecord> wordGroupMembers = create
				.selectFrom(WORD_GROUP_MEMBER)
				.where(WORD_GROUP_MEMBER.WORD_ID.eq(wordId))
				.orderBy(WORD_GROUP_MEMBER.ORDER_BY)
				.fetch();
		wordGroupMembers.stream().map(WordGroupMemberRecord::copy).forEach(clonedWordGroupMember -> {
			clonedWordGroupMember.setWordId(clonedWordId);
			clonedWordGroupMember.changed(WORD_GROUP_MEMBER.ORDER_BY, false);
			clonedWordGroupMember.store();
		});
	}

	public void cloneWordEtymology(Long wordId, Long clonedWordId) {

		Result<WordEtymologyRecord> etyms = create
				.selectFrom(WORD_ETYMOLOGY)
				.where(WORD_ETYMOLOGY.WORD_ID.eq(wordId))
				.orderBy(WORD_ETYMOLOGY.ORDER_BY)
				.fetch();

		etyms.forEach(etym -> {
			WordEtymologyRecord clonedEtym = etym.copy();
			clonedEtym.setWordId(clonedWordId);
			clonedEtym.changed(WORD_ETYMOLOGY.ORDER_BY, false);
			clonedEtym.store();

			Long etymId = etym.getId();
			Long clonedEtymId = clonedEtym.getId();

			Result<WordEtymologyRelationRecord> etymRelations = create
					.selectFrom(WORD_ETYMOLOGY_RELATION)
					.where(WORD_ETYMOLOGY_RELATION.WORD_ETYM_ID.eq(etymId))
					.orderBy(WORD_ETYMOLOGY_RELATION.ORDER_BY)
					.fetch();
			etymRelations.stream().map(WordEtymologyRelationRecord::copy).forEach(clonedEtymRel -> {
				clonedEtymRel.setWordEtymId(clonedEtymId);
				clonedEtymRel.changed(WORD_ETYMOLOGY_RELATION.ORDER_BY, false);
				clonedEtymRel.store();
			});

			Result<WordEtymologySourceLinkRecord> etymSourceLinks = create
					.selectFrom(WORD_ETYMOLOGY_SOURCE_LINK)
					.where(WORD_ETYMOLOGY_SOURCE_LINK.WORD_ETYM_ID.eq(etymId))
					.orderBy(WORD_ETYMOLOGY_SOURCE_LINK.ORDER_BY)
					.fetch();
			etymSourceLinks.stream().map(WordEtymologySourceLinkRecord::copy).forEach(clonedEtymSourceLink -> {
				clonedEtymSourceLink.setWordEtymId(clonedEtymId);
				clonedEtymSourceLink.changed(WORD_ETYMOLOGY_SOURCE_LINK.ORDER_BY, false);
				clonedEtymSourceLink.store();
			});
		});
	}

	public void joinWordData(Long targetWordId, Long sourceWordId) {

		joinWordFreeforms(targetWordId, sourceWordId);
		joinWordRelations(targetWordId, sourceWordId);
		joinWordTypeCodes(targetWordId, sourceWordId);
		joinWordGroupMembers(targetWordId, sourceWordId);

		create.update(WORD_ETYMOLOGY)
				.set(WORD_ETYMOLOGY.WORD_ID, targetWordId)
				.where(WORD_ETYMOLOGY.WORD_ID.eq(sourceWordId))
				.execute();

		joinWordEtymologyRelations(targetWordId, sourceWordId);

		WordActivityLog wals = WORD_ACTIVITY_LOG.as("wals");
		WordActivityLog walt = WORD_ACTIVITY_LOG.as("walt");
		create.update(wals)
				.set(wals.WORD_ID, targetWordId)
				.where(wals.WORD_ID.eq(sourceWordId)
						.andNotExists(DSL
								.select(walt.ID)
								.from(walt)
								.where(
										walt.WORD_ID.eq(targetWordId)
												.and(walt.ACTIVITY_LOG_ID.eq(wals.ACTIVITY_LOG_ID)))))
				.execute();
	}

	private void joinWordEtymologyRelations(Long targetWordId, Long sourceWordId) {

		WordEtymologyRelation wer1 = WORD_ETYMOLOGY_RELATION.as("wer1");
		WordEtymologyRelation wer2 = WORD_ETYMOLOGY_RELATION.as("wer2");

		create.update(wer1)
				.set(wer1.RELATED_WORD_ID, targetWordId)
				.where(wer1.RELATED_WORD_ID.eq(sourceWordId))
				.andNotExists(DSL
						.select(wer2.ID)
						.from(wer2)
						.where(
								wer2.RELATED_WORD_ID.eq(targetWordId)
										.and(wer2.WORD_ETYM_ID.eq(wer1.WORD_ETYM_ID))))
				.execute();
	}

	private void joinWordGroupMembers(Long targetWordId, Long sourceWordId) {

		WordGroupMember wgm1 = WORD_GROUP_MEMBER.as("wgm1");
		WordGroupMember wgm2 = WORD_GROUP_MEMBER.as("wgm2");

		create.update(wgm1)
				.set(wgm1.WORD_ID, targetWordId)
				.where(wgm1.WORD_ID.eq(sourceWordId))
				.andNotExists(DSL
						.select(wgm2.ID)
						.from(wgm2)
						.where(
								wgm2.WORD_ID.eq(targetWordId)
										.and(wgm2.WORD_GROUP_ID.eq(wgm1.WORD_GROUP_ID))))
				.execute();
	}

	private void joinWordFreeforms(Long targetWordId, Long sourceWordId) {

		Result<FreeformRecord> wordFreeforms = create
				.selectFrom(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(WORD_FREEFORM.FREEFORM_ID).from(WORD_FREEFORM).where(WORD_FREEFORM.WORD_ID.eq(targetWordId))))
				.fetch();
		Result<FreeformRecord> sourceWordFreeforms = create
				.selectFrom(FREEFORM)
				.where(FREEFORM.ID.in(DSL.select(WORD_FREEFORM.FREEFORM_ID).from(WORD_FREEFORM).where(WORD_FREEFORM.WORD_ID.eq(sourceWordId))))
				.fetch();

		List<Long> nonDublicateFreeformIds = getNonDuplicateFreeformIds(wordFreeforms, sourceWordFreeforms);

		create.update(WORD_FREEFORM)
				.set(WORD_FREEFORM.WORD_ID, targetWordId)
				.where(WORD_FREEFORM.WORD_ID.eq(sourceWordId)
						.and(WORD_FREEFORM.FREEFORM_ID.in(nonDublicateFreeformIds)))
				.execute();

		create.delete(FREEFORM)
				.where(FREEFORM.ID.in(DSL
						.select(WORD_FREEFORM.FREEFORM_ID)
						.from(WORD_FREEFORM)
						.where(WORD_FREEFORM.WORD_ID.eq(sourceWordId))))
				.execute();

		create.delete(WORD_FREEFORM).where(WORD_FREEFORM.WORD_ID.eq(sourceWordId)).execute();
	}

	private void joinWordRelations(Long targetWordId, Long sourceWordId) {

		WordRelation wr1 = WORD_RELATION.as("wr1");
		WordRelation wr2 = WORD_RELATION.as("wr2");

		create.update(wr1)
				.set(wr1.WORD1_ID, targetWordId)
				.where(
						wr1.WORD1_ID.eq(sourceWordId)
								.and(wr1.WORD2_ID.ne(targetWordId)))
				.andNotExists(DSL
						.select(wr2.ID)
						.from(wr2)
						.where(
								wr2.WORD1_ID.eq(targetWordId)
										.and(wr2.WORD2_ID.eq(wr1.WORD2_ID))
										.and(wr2.WORD_REL_TYPE_CODE.eq(wr1.WORD_REL_TYPE_CODE))))
				.execute();

		create.update(wr1)
				.set(wr1.WORD2_ID, targetWordId)
				.where(
						wr1.WORD2_ID.eq(sourceWordId)
								.and(wr1.WORD1_ID.ne(targetWordId)))
				.andNotExists(DSL
						.select(wr2.ID)
						.from(wr2)
						.where(
								wr2.WORD2_ID.eq(targetWordId)
										.and(wr2.WORD1_ID.eq(wr1.WORD1_ID))
										.and(wr2.WORD_REL_TYPE_CODE.eq(wr1.WORD_REL_TYPE_CODE))))
				.execute();
	}

	private void joinWordTypeCodes(Long targetWordId, Long sourceWordId) {

		WordWordType wwt1 = WORD_WORD_TYPE.as("wwt1");
		WordWordType wwt2 = WORD_WORD_TYPE.as("wwt2");

		create.update(wwt1)
				.set(wwt1.WORD_ID, targetWordId)
				.where(wwt1.WORD_ID.eq(sourceWordId))
				.andNotExists(DSL
						.select(wwt2.ID)
						.from(wwt2)
						.where(wwt2.WORD_ID.eq(targetWordId)
								.and(wwt2.WORD_TYPE_CODE.eq(wwt1.WORD_TYPE_CODE))))
				.execute();
	}

	public Integer getWordHomonymNum(Long wordId) {

		return create.
				select(WORD.HOMONYM_NR)
				.from(WORD)
				.where(WORD.ID.eq(wordId))
				.fetchOneInto(Integer.class);
	}

	private List<Long> getNonDuplicateFreeformIds(List<FreeformRecord> targetFreeforms, List<FreeformRecord> sourceFreeforms) {

		return sourceFreeforms.stream()
				.filter(sf -> targetFreeforms.stream()
						.noneMatch(
								tf -> tf.getType().equals(sf.getType()) &&
								((Objects.nonNull(tf.getValueText()) && tf.getValueText().equals(sf.getValueText())) ||
								(Objects.nonNull(tf.getValueNumber()) && tf.getValueNumber().equals(sf.getValueNumber())) ||
								(Objects.nonNull(tf.getClassifCode()) && tf.getClassifCode().equals(sf.getClassifCode())) ||
								(Objects.nonNull(tf.getValueDate()) && tf.getValueDate().equals(sf.getValueDate())))))
				.map(FreeformRecord::getId)
				.collect(Collectors.toList());
	}

	public void updateLexemeWordIdAndLevels(Long lexemeId, Long wordId, int level1, int level2) {

		create.update(LEXEME)
				.set(LEXEME.WORD_ID, wordId)
				.set(LEXEME.LEVEL1, level1)
				.set(LEXEME.LEVEL2, level2)
				.where(LEXEME.ID.eq(lexemeId))
				.execute();
	}

	public void joinParadigms(Long wordId, Long sourceWordId) {

		create.delete(PARADIGM)
				.where(PARADIGM.WORD_ID.eq(wordId))
				.execute();

		create.update(PARADIGM)
				.set(PARADIGM.WORD_ID, wordId)
				.where(PARADIGM.WORD_ID.eq(sourceWordId))
				.execute();
	}

}
