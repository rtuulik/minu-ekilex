/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.WordFreq;

import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WordFreqRecord extends UpdatableRecordImpl<WordFreqRecord> implements Record5<Long, Long, Long, BigDecimal, Long> {

    private static final long serialVersionUID = -217462988;

    /**
     * Setter for <code>public.word_freq.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.word_freq.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.word_freq.freq_corp_id</code>.
     */
    public void setFreqCorpId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.word_freq.freq_corp_id</code>.
     */
    public Long getFreqCorpId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.word_freq.word_id</code>.
     */
    public void setWordId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.word_freq.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.word_freq.value</code>.
     */
    public void setValue(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.word_freq.value</code>.
     */
    public BigDecimal getValue() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.word_freq.rank</code>.
     */
    public void setRank(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.word_freq.rank</code>.
     */
    public Long getRank() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Long, BigDecimal, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Long, Long, BigDecimal, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return WordFreq.WORD_FREQ.ID;
    }

    @Override
    public Field<Long> field2() {
        return WordFreq.WORD_FREQ.FREQ_CORP_ID;
    }

    @Override
    public Field<Long> field3() {
        return WordFreq.WORD_FREQ.WORD_ID;
    }

    @Override
    public Field<BigDecimal> field4() {
        return WordFreq.WORD_FREQ.VALUE;
    }

    @Override
    public Field<Long> field5() {
        return WordFreq.WORD_FREQ.RANK;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getFreqCorpId();
    }

    @Override
    public Long component3() {
        return getWordId();
    }

    @Override
    public BigDecimal component4() {
        return getValue();
    }

    @Override
    public Long component5() {
        return getRank();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getFreqCorpId();
    }

    @Override
    public Long value3() {
        return getWordId();
    }

    @Override
    public BigDecimal value4() {
        return getValue();
    }

    @Override
    public Long value5() {
        return getRank();
    }

    @Override
    public WordFreqRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public WordFreqRecord value2(Long value) {
        setFreqCorpId(value);
        return this;
    }

    @Override
    public WordFreqRecord value3(Long value) {
        setWordId(value);
        return this;
    }

    @Override
    public WordFreqRecord value4(BigDecimal value) {
        setValue(value);
        return this;
    }

    @Override
    public WordFreqRecord value5(Long value) {
        setRank(value);
        return this;
    }

    @Override
    public WordFreqRecord values(Long value1, Long value2, Long value3, BigDecimal value4, Long value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WordFreqRecord
     */
    public WordFreqRecord() {
        super(WordFreq.WORD_FREQ);
    }

    /**
     * Create a detached, initialised WordFreqRecord
     */
    public WordFreqRecord(Long id, Long freqCorpId, Long wordId, BigDecimal value, Long rank) {
        super(WordFreq.WORD_FREQ);

        set(0, id);
        set(1, freqCorpId);
        set(2, wordId);
        set(3, value);
        set(4, rank);
    }
}
