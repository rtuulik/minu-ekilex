/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.SourceFreeform;

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
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SourceFreeformRecord extends UpdatableRecordImpl<SourceFreeformRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = -382492975;

    /**
     * Setter for <code>public.source_freeform.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.source_freeform.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.source_freeform.source_id</code>.
     */
    public void setSourceId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.source_freeform.source_id</code>.
     */
    public Long getSourceId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.source_freeform.freeform_id</code>.
     */
    public void setFreeformId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.source_freeform.freeform_id</code>.
     */
    public Long getFreeformId() {
        return (Long) get(2);
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
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return SourceFreeform.SOURCE_FREEFORM.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return SourceFreeform.SOURCE_FREEFORM.SOURCE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return SourceFreeform.SOURCE_FREEFORM.FREEFORM_ID;
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
        return getSourceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getFreeformId();
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
        return getSourceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getFreeformId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceFreeformRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceFreeformRecord value2(Long value) {
        setSourceId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceFreeformRecord value3(Long value) {
        setFreeformId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SourceFreeformRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SourceFreeformRecord
     */
    public SourceFreeformRecord() {
        super(SourceFreeform.SOURCE_FREEFORM);
    }

    /**
     * Create a detached, initialised SourceFreeformRecord
     */
    public SourceFreeformRecord(Long id, Long sourceId, Long freeformId) {
        super(SourceFreeform.SOURCE_FREEFORM);

        set(0, id);
        set(1, sourceId);
        set(2, freeformId);
    }
}
