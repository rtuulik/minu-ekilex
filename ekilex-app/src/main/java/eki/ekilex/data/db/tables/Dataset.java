/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.DatasetRecord;

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
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Dataset extends TableImpl<DatasetRecord> {

    private static final long serialVersionUID = -1967281684;

    /**
     * The reference instance of <code>public.dataset</code>
     */
    public static final Dataset DATASET = new Dataset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatasetRecord> getRecordType() {
        return DatasetRecord.class;
    }

    /**
     * The column <code>public.dataset.code</code>.
     */
    public final TableField<DatasetRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>public.dataset.name</code>.
     */
    public final TableField<DatasetRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.dataset.description</code>.
     */
    public final TableField<DatasetRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.dataset.is_public</code>.
     */
    public final TableField<DatasetRecord, Boolean> IS_PUBLIC = createField("is_public", org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>public.dataset</code> table reference
     */
    public Dataset() {
        this(DSL.name("dataset"), null);
    }

    /**
     * Create an aliased <code>public.dataset</code> table reference
     */
    public Dataset(String alias) {
        this(DSL.name(alias), DATASET);
    }

    /**
     * Create an aliased <code>public.dataset</code> table reference
     */
    public Dataset(Name alias) {
        this(alias, DATASET);
    }

    private Dataset(Name alias, Table<DatasetRecord> aliased) {
        this(alias, aliased, null);
    }

    private Dataset(Name alias, Table<DatasetRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.DATASET_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DatasetRecord> getPrimaryKey() {
        return Keys.DATASET_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DatasetRecord>> getKeys() {
        return Arrays.<UniqueKey<DatasetRecord>>asList(Keys.DATASET_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dataset as(String alias) {
        return new Dataset(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dataset as(Name alias) {
        return new Dataset(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dataset rename(String name) {
        return new Dataset(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Dataset rename(Name name) {
        return new Dataset(name, null);
    }
}
