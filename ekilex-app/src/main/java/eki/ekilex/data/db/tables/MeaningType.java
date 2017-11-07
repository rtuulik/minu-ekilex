/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.MeaningTypeRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MeaningType extends TableImpl<MeaningTypeRecord> {

    private static final long serialVersionUID = 733156551;

    /**
     * The reference instance of <code>public.meaning_type</code>
     */
    public static final MeaningType MEANING_TYPE = new MeaningType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeaningTypeRecord> getRecordType() {
        return MeaningTypeRecord.class;
    }

    /**
     * The column <code>public.meaning_type.code</code>.
     */
    public final TableField<MeaningTypeRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.meaning_type.datasets</code>.
     */
    public final TableField<MeaningTypeRecord, String[]> DATASETS = createField("datasets", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * Create a <code>public.meaning_type</code> table reference
     */
    public MeaningType() {
        this(DSL.name("meaning_type"), null);
    }

    /**
     * Create an aliased <code>public.meaning_type</code> table reference
     */
    public MeaningType(String alias) {
        this(DSL.name(alias), MEANING_TYPE);
    }

    /**
     * Create an aliased <code>public.meaning_type</code> table reference
     */
    public MeaningType(Name alias) {
        this(alias, MEANING_TYPE);
    }

    private MeaningType(Name alias, Table<MeaningTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private MeaningType(Name alias, Table<MeaningTypeRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.MEANING_TYPE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MeaningTypeRecord> getPrimaryKey() {
        return Keys.MEANING_TYPE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MeaningTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<MeaningTypeRecord>>asList(Keys.MEANING_TYPE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningType as(String alias) {
        return new MeaningType(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningType as(Name alias) {
        return new MeaningType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningType rename(String name) {
        return new MeaningType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningType rename(Name name) {
        return new MeaningType(name, null);
    }
}
