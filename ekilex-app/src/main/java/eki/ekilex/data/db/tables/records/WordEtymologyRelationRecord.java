/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.WordEtymologyRelation;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


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
public class WordEtymologyRelationRecord extends UpdatableRecordImpl<WordEtymologyRelationRecord> implements Record8<Long, Long, Long, String, String, Boolean, Boolean, Long> {

    private static final long serialVersionUID = 244585789;

    /**
     * Setter for <code>public.word_etymology_relation.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.word_etymology_relation.word_etym_id</code>.
     */
    public void setWordEtymId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.word_etym_id</code>.
     */
    public Long getWordEtymId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.word_etymology_relation.related_word_id</code>.
     */
    public void setRelatedWordId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.related_word_id</code>.
     */
    public Long getRelatedWordId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.word_etymology_relation.comment</code>.
     */
    public void setComment(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.comment</code>.
     */
    public String getComment() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.word_etymology_relation.comment_prese</code>.
     */
    public void setCommentPrese(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.comment_prese</code>.
     */
    public String getCommentPrese() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.word_etymology_relation.is_questionable</code>.
     */
    public void setIsQuestionable(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.is_questionable</code>.
     */
    public Boolean getIsQuestionable() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>public.word_etymology_relation.is_compound</code>.
     */
    public void setIsCompound(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.is_compound</code>.
     */
    public Boolean getIsCompound() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>public.word_etymology_relation.order_by</code>.
     */
    public void setOrderBy(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.word_etymology_relation.order_by</code>.
     */
    public Long getOrderBy() {
        return (Long) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, Long, String, String, Boolean, Boolean, Long> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, Long, String, String, Boolean, Boolean, Long> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.WORD_ETYM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.RELATED_WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.COMMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.COMMENT_PRESE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.IS_QUESTIONABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.IS_COMPOUND;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return WordEtymologyRelation.WORD_ETYMOLOGY_RELATION.ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getWordEtymId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getRelatedWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCommentPrese();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component6() {
        return getIsQuestionable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component7() {
        return getIsCompound();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getWordEtymId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getRelatedWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCommentPrese();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getIsQuestionable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getIsCompound();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value2(Long value) {
        setWordEtymId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value3(Long value) {
        setRelatedWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value4(String value) {
        setComment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value5(String value) {
        setCommentPrese(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value6(Boolean value) {
        setIsQuestionable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value7(Boolean value) {
        setIsCompound(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord value8(Long value) {
        setOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelationRecord values(Long value1, Long value2, Long value3, String value4, String value5, Boolean value6, Boolean value7, Long value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WordEtymologyRelationRecord
     */
    public WordEtymologyRelationRecord() {
        super(WordEtymologyRelation.WORD_ETYMOLOGY_RELATION);
    }

    /**
     * Create a detached, initialised WordEtymologyRelationRecord
     */
    public WordEtymologyRelationRecord(Long id, Long wordEtymId, Long relatedWordId, String comment, String commentPrese, Boolean isQuestionable, Boolean isCompound, Long orderBy) {
        super(WordEtymologyRelation.WORD_ETYMOLOGY_RELATION);

        set(0, id);
        set(1, wordEtymId);
        set(2, relatedWordId);
        set(3, comment);
        set(4, commentPrese);
        set(5, isQuestionable);
        set(6, isCompound);
        set(7, orderBy);
    }
}
