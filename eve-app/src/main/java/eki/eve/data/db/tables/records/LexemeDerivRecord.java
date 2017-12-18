/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables.records;


import eki.eve.data.db.tables.LexemeDeriv;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemeDerivRecord extends UpdatableRecordImpl<LexemeDerivRecord> implements Record3<Long, Long, String> {

    private static final long serialVersionUID = 2107743473;

    /**
     * Setter for <code>public.lexeme_deriv.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lexeme_deriv.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.lexeme_deriv.lexeme_id</code>.
     */
    public void setLexemeId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lexeme_deriv.lexeme_id</code>.
     */
    public Long getLexemeId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.lexeme_deriv.deriv_code</code>.
     */
    public void setDerivCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lexeme_deriv.deriv_code</code>.
     */
    public String getDerivCode() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return LexemeDeriv.LEXEME_DERIV.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return LexemeDeriv.LEXEME_DERIV.LEXEME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return LexemeDeriv.LEXEME_DERIV.DERIV_CODE;
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
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDerivCode();
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
        return getLexemeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDerivCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeDerivRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeDerivRecord value2(Long value) {
        setLexemeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeDerivRecord value3(String value) {
        setDerivCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeDerivRecord values(Long value1, Long value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LexemeDerivRecord
     */
    public LexemeDerivRecord() {
        super(LexemeDeriv.LEXEME_DERIV);
    }

    /**
     * Create a detached, initialised LexemeDerivRecord
     */
    public LexemeDerivRecord(Long id, Long lexemeId, String derivCode) {
        super(LexemeDeriv.LEXEME_DERIV);

        set(0, id);
        set(1, lexemeId);
        set(2, derivCode);
    }
}
