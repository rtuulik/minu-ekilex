/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.MeaningFreeformRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MeaningFreeform extends TableImpl<MeaningFreeformRecord> {

    private static final long serialVersionUID = -368622920;

    /**
     * The reference instance of <code>public.meaning_freeform</code>
     */
    public static final MeaningFreeform MEANING_FREEFORM = new MeaningFreeform();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeaningFreeformRecord> getRecordType() {
        return MeaningFreeformRecord.class;
    }

    /**
     * The column <code>public.meaning_freeform.id</code>.
     */
    public final TableField<MeaningFreeformRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_freeform_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.meaning_freeform.meaning_id</code>.
     */
    public final TableField<MeaningFreeformRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.meaning_freeform.freeform_id</code>.
     */
    public final TableField<MeaningFreeformRecord, Long> FREEFORM_ID = createField("freeform_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.meaning_freeform</code> table reference
     */
    public MeaningFreeform() {
        this(DSL.name("meaning_freeform"), null);
    }

    /**
     * Create an aliased <code>public.meaning_freeform</code> table reference
     */
    public MeaningFreeform(String alias) {
        this(DSL.name(alias), MEANING_FREEFORM);
    }

    /**
     * Create an aliased <code>public.meaning_freeform</code> table reference
     */
    public MeaningFreeform(Name alias) {
        this(alias, MEANING_FREEFORM);
    }

    private MeaningFreeform(Name alias, Table<MeaningFreeformRecord> aliased) {
        this(alias, aliased, null);
    }

    private MeaningFreeform(Name alias, Table<MeaningFreeformRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.MEANING_FREEFORM_FREEFORM_ID_IDX, Indexes.MEANING_FREEFORM_MEANING_ID_FREEFORM_ID_KEY, Indexes.MEANING_FREEFORM_MEANING_ID_IDX, Indexes.MEANING_FREEFORM_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MeaningFreeformRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEANING_FREEFORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MeaningFreeformRecord> getPrimaryKey() {
        return Keys.MEANING_FREEFORM_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MeaningFreeformRecord>> getKeys() {
        return Arrays.<UniqueKey<MeaningFreeformRecord>>asList(Keys.MEANING_FREEFORM_PKEY, Keys.MEANING_FREEFORM_MEANING_ID_FREEFORM_ID_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MeaningFreeformRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MeaningFreeformRecord, ?>>asList(Keys.MEANING_FREEFORM__MEANING_FREEFORM_MEANING_ID_FKEY, Keys.MEANING_FREEFORM__MEANING_FREEFORM_FREEFORM_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningFreeform as(String alias) {
        return new MeaningFreeform(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningFreeform as(Name alias) {
        return new MeaningFreeform(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningFreeform rename(String name) {
        return new MeaningFreeform(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningFreeform rename(Name name) {
        return new MeaningFreeform(name, null);
    }
}
