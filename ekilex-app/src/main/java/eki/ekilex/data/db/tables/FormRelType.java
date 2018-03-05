/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.FormRelTypeRecord;

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
public class FormRelType extends TableImpl<FormRelTypeRecord> {

    private static final long serialVersionUID = 1438708730;

    /**
     * The reference instance of <code>public.form_rel_type</code>
     */
    public static final FormRelType FORM_REL_TYPE = new FormRelType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FormRelTypeRecord> getRecordType() {
        return FormRelTypeRecord.class;
    }

    /**
     * The column <code>public.form_rel_type.code</code>.
     */
    public final TableField<FormRelTypeRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.form_rel_type.datasets</code>.
     */
    public final TableField<FormRelTypeRecord, String[]> DATASETS = createField("datasets", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * Create a <code>public.form_rel_type</code> table reference
     */
    public FormRelType() {
        this(DSL.name("form_rel_type"), null);
    }

    /**
     * Create an aliased <code>public.form_rel_type</code> table reference
     */
    public FormRelType(String alias) {
        this(DSL.name(alias), FORM_REL_TYPE);
    }

    /**
     * Create an aliased <code>public.form_rel_type</code> table reference
     */
    public FormRelType(Name alias) {
        this(alias, FORM_REL_TYPE);
    }

    private FormRelType(Name alias, Table<FormRelTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private FormRelType(Name alias, Table<FormRelTypeRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.FORM_REL_TYPE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FormRelTypeRecord> getPrimaryKey() {
        return Keys.FORM_REL_TYPE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FormRelTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<FormRelTypeRecord>>asList(Keys.FORM_REL_TYPE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormRelType as(String alias) {
        return new FormRelType(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormRelType as(Name alias) {
        return new FormRelType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FormRelType rename(String name) {
        return new FormRelType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FormRelType rename(Name name) {
        return new FormRelType(name, null);
    }
}
