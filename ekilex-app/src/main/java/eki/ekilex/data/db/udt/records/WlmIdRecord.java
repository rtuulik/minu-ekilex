/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.udt.records;


import eki.ekilex.data.db.udt.WlmId;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UDTRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WlmIdRecord extends UDTRecordImpl<WlmIdRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = -115881806;

    /**
     * Setter for <code>public.wlm_id.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.wlm_id.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.wlm_id.word_id</code>.
     */
    public void setWordId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.wlm_id.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.wlm_id.meaning_id</code>.
     */
    public void setMeaningId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.wlm_id.meaning_id</code>.
     */
    public Long getMeaningId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return WlmId.LEXEME_ID;
    }

    @Override
    public Field<Long> field2() {
        return WlmId.WORD_ID;
    }

    @Override
    public Field<Long> field3() {
        return WlmId.MEANING_ID;
    }

    @Override
    public Long component1() {
        return getLexemeId();
    }

    @Override
    public Long component2() {
        return getWordId();
    }

    @Override
    public Long component3() {
        return getMeaningId();
    }

    @Override
    public Long value1() {
        return getLexemeId();
    }

    @Override
    public Long value2() {
        return getWordId();
    }

    @Override
    public Long value3() {
        return getMeaningId();
    }

    @Override
    public WlmIdRecord value1(Long value) {
        setLexemeId(value);
        return this;
    }

    @Override
    public WlmIdRecord value2(Long value) {
        setWordId(value);
        return this;
    }

    @Override
    public WlmIdRecord value3(Long value) {
        setMeaningId(value);
        return this;
    }

    @Override
    public WlmIdRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WlmIdRecord
     */
    public WlmIdRecord() {
        super(WlmId.WLM_ID);
    }

    /**
     * Create a detached, initialised WlmIdRecord
     */
    public WlmIdRecord(Long lexemeId, Long wordId, Long meaningId) {
        super(WlmId.WLM_ID);

        set(0, lexemeId);
        set(1, wordId);
        set(2, meaningId);
    }
}
