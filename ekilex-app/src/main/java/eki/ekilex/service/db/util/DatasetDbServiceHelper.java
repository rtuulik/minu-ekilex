package eki.ekilex.service.db.util;

import static eki.ekilex.data.db.Tables.COLLOCATION;
import static eki.ekilex.data.db.Tables.COLLOCATION_FREEFORM;
import static eki.ekilex.data.db.Tables.DEFINITION;
import static eki.ekilex.data.db.Tables.DEFINITION_DATASET;
import static eki.ekilex.data.db.Tables.DEFINITION_FREEFORM;
import static eki.ekilex.data.db.Tables.FREEFORM;
import static eki.ekilex.data.db.Tables.LEXEME;
import static eki.ekilex.data.db.Tables.LEXEME_FREEFORM;
import static eki.ekilex.data.db.Tables.LEXEME_LIFECYCLE_LOG;
import static eki.ekilex.data.db.Tables.LEX_COLLOC;
import static eki.ekilex.data.db.Tables.LIFECYCLE_LOG;
import static eki.ekilex.data.db.Tables.MEANING;
import static eki.ekilex.data.db.Tables.MEANING_FREEFORM;
import static eki.ekilex.data.db.Tables.MEANING_LIFECYCLE_LOG;
import static eki.ekilex.data.db.Tables.WORD;
import static eki.ekilex.data.db.Tables.WORD_FREEFORM;
import static eki.ekilex.data.db.Tables.WORD_LIFECYCLE_LOG;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;

import eki.ekilex.data.db.tables.Collocation;
import eki.ekilex.data.db.tables.CollocationFreeform;
import eki.ekilex.data.db.tables.Definition;
import eki.ekilex.data.db.tables.DefinitionDataset;
import eki.ekilex.data.db.tables.DefinitionFreeform;
import eki.ekilex.data.db.tables.Freeform;
import eki.ekilex.data.db.tables.LexColloc;
import eki.ekilex.data.db.tables.Lexeme;
import eki.ekilex.data.db.tables.LexemeFreeform;
import eki.ekilex.data.db.tables.LexemeLifecycleLog;
import eki.ekilex.data.db.tables.LifecycleLog;
import eki.ekilex.data.db.tables.Meaning;
import eki.ekilex.data.db.tables.MeaningFreeform;
import eki.ekilex.data.db.tables.MeaningLifecycleLog;
import eki.ekilex.data.db.tables.Word;
import eki.ekilex.data.db.tables.WordFreeform;
import eki.ekilex.data.db.tables.WordLifecycleLog;

@Component
public class DatasetDbServiceHelper {

	public List<Long> getWordIds(String datasetCode, DSLContext create) {

		Word w = WORD.as("w");
		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");

		// collect word ids
		List<Long> wordIds = create
				.select(w.ID)
				.from(w)
				.whereExists(DSL
						.select(l1.ID)
						.from(l1)
						.where(l1.WORD_ID.eq(w.ID).and(l1.DATASET_CODE.eq(datasetCode))))
				.andNotExists(DSL
						.select(l2.ID)
						.from(l2)
						.where(l2.WORD_ID.eq(w.ID).and(l2.DATASET_CODE.ne(datasetCode))))
				.fetchInto(Long.class);

		return wordIds;
	}

	public List<Long> getMeaningIds(String datasetCode, DSLContext create) {

		Meaning m = MEANING.as("m");
		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");

		List<Long> meaningIds = create
				.select(m.ID)
				.from(m)
				.whereExists(DSL
						.select(l1.ID)
						.from(l1)
						.where(l1.MEANING_ID.eq(m.ID).and(l1.DATASET_CODE.eq(datasetCode))))
				.andNotExists(DSL
						.select(l2.ID)
						.from(l2)
						.where(l2.MEANING_ID.eq(m.ID).and(l2.DATASET_CODE.ne(datasetCode))))
				.fetchInto(Long.class);

		return meaningIds;
	}

	public void deleteDefinitionFreeforms(String datasetCode, DSLContext create) {

		Freeform ff = FREEFORM.as("ff");
		DefinitionFreeform dff = DEFINITION_FREEFORM.as("dff");
		DefinitionDataset dd1 = DEFINITION_DATASET.as("dd1");
		DefinitionDataset dd2 = DEFINITION_DATASET.as("dd2");

		create
				.deleteFrom(ff)
				.where(ff.ID.in(DSL
						.select(dff.FREEFORM_ID)
						.from(dff)
						.whereExists(DSL
								.select(dd1.DEFINITION_ID)
								.from(dd1)
								.where(dd1.DEFINITION_ID.eq(dff.DEFINITION_ID).and(dd1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(dd2.DEFINITION_ID)
								.from(dd2)
								.where(dd2.DEFINITION_ID.eq(dff.DEFINITION_ID).and(dd2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}

	public void deleteMeaningFreeforms(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		Freeform ff = FREEFORM.as("ff");
		MeaningFreeform mff = MEANING_FREEFORM.as("mff");

		create
				.deleteFrom(ff)
				.where(ff.ID.in(DSL
						.select(mff.FREEFORM_ID)
						.from(mff)
						.whereExists(DSL
								.select(l1.ID)
								.from(l1)
								.where(l1.MEANING_ID.eq(mff.MEANING_ID).and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(l2.ID)
								.from(l2)
								.where(l2.MEANING_ID.eq(mff.MEANING_ID).and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}

	public void deleteLexemeFreeforms(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		Freeform ff = FREEFORM.as("ff");
		LexemeFreeform lff = LEXEME_FREEFORM.as("lff");

		create
				.deleteFrom(ff)
				.where(ff.ID.in(DSL
						.select(lff.FREEFORM_ID)
						.from(lff)
						.whereExists(DSL
								.select(l1.ID)
								.from(l1)
								.where(l1.ID.eq(lff.LEXEME_ID).and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(l2.ID)
								.from(l2)
								.where(l2.ID.eq(lff.LEXEME_ID).and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}

	public void deleteCollocationFreeforms(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		Freeform ff = FREEFORM.as("ff");
		LexColloc lc1 = LEX_COLLOC.as("lc1");
		LexColloc lc2 = LEX_COLLOC.as("lc2");
		CollocationFreeform cff = COLLOCATION_FREEFORM.as("cff");

		create
				.deleteFrom(ff)
				.where(ff.ID.in(DSL
						.select(cff.FREEFORM_ID)
						.from(cff)
						.whereExists(DSL
								.select(lc1.ID)
								.from(l1, lc1)
								.where(
										lc1.LEXEME_ID.eq(l1.ID)
												.and(lc1.COLLOCATION_ID.eq(cff.COLLOCATION_ID))
												.and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(lc2.ID)
								.from(l2, lc2)
								.where(
										lc2.LEXEME_ID.eq(l2.ID)
												.and(lc2.COLLOCATION_ID.eq(cff.COLLOCATION_ID))
												.and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}


	public void deleteWordFreeforms(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		Freeform ff = FREEFORM.as("ff");
		WordFreeform wff = WORD_FREEFORM.as("wff");

		create
				.deleteFrom(ff)
				.where(ff.ID.in(DSL
						.select(wff.FREEFORM_ID)
						.from(wff)
						.whereExists(DSL
								.select(l1.ID)
								.from(l1)
								.where(l1.WORD_ID.eq(wff.WORD_ID)
										.and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(l2.ID)
								.from(l2)
								.where(l2.WORD_ID.eq(wff.WORD_ID)
										.and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}

	public void deleteDefinitions(String datasetCode, DSLContext create) {

		Definition d = DEFINITION.as("d");
		DefinitionDataset dd1 = DEFINITION_DATASET.as("dd1");
		DefinitionDataset dd2 = DEFINITION_DATASET.as("dd2");

		create
				.deleteFrom(d)
				.whereExists(DSL
						.select(dd1.DEFINITION_ID)
						.from(dd1)
						.where(dd1.DEFINITION_ID.eq(d.ID).and(dd1.DATASET_CODE.eq(datasetCode))))
				.andNotExists(DSL
						.select(dd2.DEFINITION_ID)
						.from(dd2)
						.where(dd2.DEFINITION_ID.eq(d.ID).and(dd2.DATASET_CODE.ne(datasetCode))))
				.execute();
	}

	public void deleteCollocations(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		Collocation c = COLLOCATION.as("c");
		LexColloc lc = LEX_COLLOC.as("lc");

		create
				.deleteFrom(c)
				.where(c.ID.in(DSL
						.select(lc.COLLOCATION_ID)
						.from(lc)
						.whereExists(DSL
								.select(l1.ID)
								.from(l1)
								.where(l1.ID.eq(lc.LEXEME_ID).and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(l2.ID)
								.from(l2)
								.where(l2.ID.eq(lc.LEXEME_ID).and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}

	public void deleteWordLifecycleLogs(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		LifecycleLog lcl = LIFECYCLE_LOG.as("lcl");
		WordLifecycleLog wlcl = WORD_LIFECYCLE_LOG.as("wlcl");

		create
				.deleteFrom(lcl)
				.where(lcl.ID.in(DSL
						.select(wlcl.LIFECYCLE_LOG_ID)
						.from(wlcl)
						.whereExists(DSL
								.select(l1.ID)
								.from(l1)
								.where(l1.WORD_ID.eq(wlcl.WORD_ID)
										.and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(l2.ID)
								.from(l2)
								.where(l2.WORD_ID.eq(wlcl.WORD_ID)
										.and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}

	public void deleteLexemeLifecycleLogs(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		LifecycleLog lcl = LIFECYCLE_LOG.as("lcl");
		LexemeLifecycleLog llcl = LEXEME_LIFECYCLE_LOG.as("llcl");

		create
				.deleteFrom(lcl)
				.where(lcl.ID.in(DSL
						.select(llcl.LIFECYCLE_LOG_ID)
						.from(llcl)
						.whereExists(DSL
								.select(l1.ID)
								.from(l1)
								.where(l1.ID.eq(llcl.LEXEME_ID).and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(l2.ID)
								.from(l2)
								.where(l2.ID.eq(llcl.LEXEME_ID).and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}

	public void deleteMeaningLifecycleLogs(String datasetCode, DSLContext create) {

		Lexeme l1 = LEXEME.as("l1");
		Lexeme l2 = LEXEME.as("l2");
		LifecycleLog lcl = LIFECYCLE_LOG.as("lcl");
		MeaningLifecycleLog mlcl = MEANING_LIFECYCLE_LOG.as("mlcl");

		create
				.deleteFrom(lcl)
				.where(lcl.ID.in(DSL
						.select(mlcl.LIFECYCLE_LOG_ID)
						.from(mlcl)
						.whereExists(DSL
								.select(l1.ID)
								.from(l1)
								.where(l1.MEANING_ID.eq(mlcl.MEANING_ID).and(l1.DATASET_CODE.eq(datasetCode))))
						.andNotExists(DSL
								.select(l2.ID)
								.from(l2)
								.where(l2.MEANING_ID.eq(mlcl.MEANING_ID).and(l2.DATASET_CODE.ne(datasetCode))))))
				.execute();
	}
}
