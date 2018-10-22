/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db.tables.records;


import eki.wordweb.data.db.tables.MviewWwMeaning;
import eki.wordweb.data.db.udt.records.TypeDefinitionRecord;
import eki.wordweb.data.db.udt.records.TypeDomainRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MviewWwMeaningRecord extends TableRecordImpl<MviewWwMeaningRecord> implements Record18<Long, Long, Long, String, Long, Integer, Integer, Integer, Long, String[], String[], String[], TypeDomainRecord[], String[], String[], String[], String[], TypeDefinitionRecord[]> {

    private static final long serialVersionUID = 381549457;

    /**
     * Setter for <code>public.mview_ww_meaning.word_id</code>.
     */
    public void setWordId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.meaning_id</code>.
     */
    public void setMeaningId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.meaning_id</code>.
     */
    public Long getMeaningId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.dataset_code</code>.
     */
    public void setDatasetCode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.dataset_code</code>.
     */
    public String getDatasetCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.ds_order_by</code>.
     */
    public void setDsOrderBy(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.ds_order_by</code>.
     */
    public Long getDsOrderBy() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.level1</code>.
     */
    public void setLevel1(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.level1</code>.
     */
    public Integer getLevel1() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.level2</code>.
     */
    public void setLevel2(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.level2</code>.
     */
    public Integer getLevel2() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.level3</code>.
     */
    public void setLevel3(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.level3</code>.
     */
    public Integer getLevel3() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.lex_order_by</code>.
     */
    public void setLexOrderBy(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.lex_order_by</code>.
     */
    public Long getLexOrderBy() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.register_codes</code>.
     */
    public void setRegisterCodes(String... value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.register_codes</code>.
     */
    public String[] getRegisterCodes() {
        return (String[]) get(9);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.pos_codes</code>.
     */
    public void setPosCodes(String... value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.pos_codes</code>.
     */
    public String[] getPosCodes() {
        return (String[]) get(10);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.deriv_codes</code>.
     */
    public void setDerivCodes(String... value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.deriv_codes</code>.
     */
    public String[] getDerivCodes() {
        return (String[]) get(11);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.domain_codes</code>.
     */
    public void setDomainCodes(TypeDomainRecord... value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.domain_codes</code>.
     */
    public TypeDomainRecord[] getDomainCodes() {
        return (TypeDomainRecord[]) get(12);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.image_files</code>.
     */
    public void setImageFiles(String... value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.image_files</code>.
     */
    public String[] getImageFiles() {
        return (String[]) get(13);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.systematic_polysemy_patterns</code>.
     */
    public void setSystematicPolysemyPatterns(String... value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.systematic_polysemy_patterns</code>.
     */
    public String[] getSystematicPolysemyPatterns() {
        return (String[]) get(14);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.semantic_types</code>.
     */
    public void setSemanticTypes(String... value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.semantic_types</code>.
     */
    public String[] getSemanticTypes() {
        return (String[]) get(15);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.learner_comments</code>.
     */
    public void setLearnerComments(String... value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.learner_comments</code>.
     */
    public String[] getLearnerComments() {
        return (String[]) get(16);
    }

    /**
     * Setter for <code>public.mview_ww_meaning.definitions</code>.
     */
    public void setDefinitions(TypeDefinitionRecord... value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.mview_ww_meaning.definitions</code>.
     */
    public TypeDefinitionRecord[] getDefinitions() {
        return (TypeDefinitionRecord[]) get(17);
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, Long, Long, String, Long, Integer, Integer, Integer, Long, String[], String[], String[], TypeDomainRecord[], String[], String[], String[], String[], TypeDefinitionRecord[]> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, Long, Long, String, Long, Integer, Integer, Integer, Long, String[], String[], String[], TypeDomainRecord[], String[], String[], String[], String[], TypeDefinitionRecord[]> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return MviewWwMeaning.MVIEW_WW_MEANING.WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return MviewWwMeaning.MVIEW_WW_MEANING.MEANING_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return MviewWwMeaning.MVIEW_WW_MEANING.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return MviewWwMeaning.MVIEW_WW_MEANING.DATASET_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return MviewWwMeaning.MVIEW_WW_MEANING.DS_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return MviewWwMeaning.MVIEW_WW_MEANING.LEVEL1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return MviewWwMeaning.MVIEW_WW_MEANING.LEVEL2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return MviewWwMeaning.MVIEW_WW_MEANING.LEVEL3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return MviewWwMeaning.MVIEW_WW_MEANING.LEX_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field10() {
        return MviewWwMeaning.MVIEW_WW_MEANING.REGISTER_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field11() {
        return MviewWwMeaning.MVIEW_WW_MEANING.POS_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field12() {
        return MviewWwMeaning.MVIEW_WW_MEANING.DERIV_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TypeDomainRecord[]> field13() {
        return MviewWwMeaning.MVIEW_WW_MEANING.DOMAIN_CODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field14() {
        return MviewWwMeaning.MVIEW_WW_MEANING.IMAGE_FILES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field15() {
        return MviewWwMeaning.MVIEW_WW_MEANING.SYSTEMATIC_POLYSEMY_PATTERNS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field16() {
        return MviewWwMeaning.MVIEW_WW_MEANING.SEMANTIC_TYPES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field17() {
        return MviewWwMeaning.MVIEW_WW_MEANING.LEARNER_COMMENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TypeDefinitionRecord[]> field18() {
        return MviewWwMeaning.MVIEW_WW_MEANING.DEFINITIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDatasetCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getDsOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getLevel1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getLevel2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getLevel3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getLexOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component10() {
        return getRegisterCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component11() {
        return getPosCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component12() {
        return getDerivCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDomainRecord[] component13() {
        return getDomainCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component14() {
        return getImageFiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component15() {
        return getSystematicPolysemyPatterns();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component16() {
        return getSemanticTypes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component17() {
        return getLearnerComments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDefinitionRecord[] component18() {
        return getDefinitions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getMeaningId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDatasetCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getDsOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getLevel1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getLevel2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getLevel3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getLexOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value10() {
        return getRegisterCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value11() {
        return getPosCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value12() {
        return getDerivCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDomainRecord[] value13() {
        return getDomainCodes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value14() {
        return getImageFiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value15() {
        return getSystematicPolysemyPatterns();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value16() {
        return getSemanticTypes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value17() {
        return getLearnerComments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDefinitionRecord[] value18() {
        return getDefinitions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value1(Long value) {
        setWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value2(Long value) {
        setMeaningId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value3(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value4(String value) {
        setDatasetCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value5(Long value) {
        setDsOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value6(Integer value) {
        setLevel1(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value7(Integer value) {
        setLevel2(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value8(Integer value) {
        setLevel3(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value9(Long value) {
        setLexOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value10(String... value) {
        setRegisterCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value11(String... value) {
        setPosCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value12(String... value) {
        setDerivCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value13(TypeDomainRecord... value) {
        setDomainCodes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value14(String... value) {
        setImageFiles(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value15(String... value) {
        setSystematicPolysemyPatterns(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value16(String... value) {
        setSemanticTypes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value17(String... value) {
        setLearnerComments(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord value18(TypeDefinitionRecord... value) {
        setDefinitions(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwMeaningRecord values(Long value1, Long value2, Long value3, String value4, Long value5, Integer value6, Integer value7, Integer value8, Long value9, String[] value10, String[] value11, String[] value12, TypeDomainRecord[] value13, String[] value14, String[] value15, String[] value16, String[] value17, TypeDefinitionRecord[] value18) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MviewWwMeaningRecord
     */
    public MviewWwMeaningRecord() {
        super(MviewWwMeaning.MVIEW_WW_MEANING);
    }

    /**
     * Create a detached, initialised MviewWwMeaningRecord
     */
    public MviewWwMeaningRecord(Long wordId, Long meaningId, Long lexemeId, String datasetCode, Long dsOrderBy, Integer level1, Integer level2, Integer level3, Long lexOrderBy, String[] registerCodes, String[] posCodes, String[] derivCodes, TypeDomainRecord[] domainCodes, String[] imageFiles, String[] systematicPolysemyPatterns, String[] semanticTypes, String[] learnerComments, TypeDefinitionRecord[] definitions) {
        super(MviewWwMeaning.MVIEW_WW_MEANING);

        set(0, wordId);
        set(1, meaningId);
        set(2, lexemeId);
        set(3, datasetCode);
        set(4, dsOrderBy);
        set(5, level1);
        set(6, level2);
        set(7, level3);
        set(8, lexOrderBy);
        set(9, registerCodes);
        set(10, posCodes);
        set(11, derivCodes);
        set(12, domainCodes);
        set(13, imageFiles);
        set(14, systematicPolysemyPatterns);
        set(15, semanticTypes);
        set(16, learnerComments);
        set(17, definitions);
    }
}
