/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.tables.records;


import eki.wordweb.data.db.tables.MviewWwWordSearch;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MviewWwWordSearchRecord extends TableRecordImpl<MviewWwWordSearchRecord> implements Record5<String, String, String, String, Long> {

    private static final long serialVersionUID = 87107768;

    /**
     * Setter for <code>public.mview_ww_word_search.sgroup</code>.
     */
    public void setSgroup(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.mview_ww_word_search.sgroup</code>.
     */
    public String getSgroup() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.mview_ww_word_search.word</code>.
     */
    public void setWord(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.mview_ww_word_search.word</code>.
     */
    public String getWord() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.mview_ww_word_search.crit</code>.
     */
    public void setCrit(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.mview_ww_word_search.crit</code>.
     */
    public String getCrit() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.mview_ww_word_search.unacrit</code>.
     */
    public void setUnacrit(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.mview_ww_word_search.unacrit</code>.
     */
    public String getUnacrit() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.mview_ww_word_search.lang_order_by</code>.
     */
    public void setLangOrderBy(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.mview_ww_word_search.lang_order_by</code>.
     */
    public Long getLangOrderBy() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return MviewWwWordSearch.MVIEW_WW_WORD_SEARCH.SGROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return MviewWwWordSearch.MVIEW_WW_WORD_SEARCH.WORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return MviewWwWordSearch.MVIEW_WW_WORD_SEARCH.CRIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return MviewWwWordSearch.MVIEW_WW_WORD_SEARCH.UNACRIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return MviewWwWordSearch.MVIEW_WW_WORD_SEARCH.LANG_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getSgroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getWord();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCrit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getUnacrit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getLangOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getSgroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getWord();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCrit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getUnacrit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getLangOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwWordSearchRecord value1(String value) {
        setSgroup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwWordSearchRecord value2(String value) {
        setWord(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwWordSearchRecord value3(String value) {
        setCrit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwWordSearchRecord value4(String value) {
        setUnacrit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwWordSearchRecord value5(Long value) {
        setLangOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwWordSearchRecord values(String value1, String value2, String value3, String value4, Long value5) {
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
     * Create a detached MviewWwWordSearchRecord
     */
    public MviewWwWordSearchRecord() {
        super(MviewWwWordSearch.MVIEW_WW_WORD_SEARCH);
    }

    /**
     * Create a detached, initialised MviewWwWordSearchRecord
     */
    public MviewWwWordSearchRecord(String sgroup, String word, String crit, String unacrit, Long langOrderBy) {
        super(MviewWwWordSearch.MVIEW_WW_WORD_SEARCH);

        set(0, sgroup);
        set(1, word);
        set(2, crit);
        set(3, unacrit);
        set(4, langOrderBy);
    }
}
