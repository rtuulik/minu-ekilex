/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.DerivLabelRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DerivLabel extends TableImpl<DerivLabelRecord> {

    private static final long serialVersionUID = 92422931;

    /**
     * The reference instance of <code>public.deriv_label</code>
     */
    public static final DerivLabel DERIV_LABEL = new DerivLabel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DerivLabelRecord> getRecordType() {
        return DerivLabelRecord.class;
    }

    /**
     * The column <code>public.deriv_label.code</code>.
     */
    public final TableField<DerivLabelRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.deriv_label.value</code>.
     */
    public final TableField<DerivLabelRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.deriv_label.lang</code>.
     */
    public final TableField<DerivLabelRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR(3).nullable(false), this, "");

    /**
     * The column <code>public.deriv_label.type</code>.
     */
    public final TableField<DerivLabelRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>public.deriv_label</code> table reference
     */
    public DerivLabel() {
        this(DSL.name("deriv_label"), null);
    }

    /**
     * Create an aliased <code>public.deriv_label</code> table reference
     */
    public DerivLabel(String alias) {
        this(DSL.name(alias), DERIV_LABEL);
    }

    /**
     * Create an aliased <code>public.deriv_label</code> table reference
     */
    public DerivLabel(Name alias) {
        this(alias, DERIV_LABEL);
    }

    private DerivLabel(Name alias, Table<DerivLabelRecord> aliased) {
        this(alias, aliased, null);
    }

    private DerivLabel(Name alias, Table<DerivLabelRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.DERIV_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DerivLabelRecord>> getKeys() {
        return Arrays.<UniqueKey<DerivLabelRecord>>asList(Keys.DERIV_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<DerivLabelRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DerivLabelRecord, ?>>asList(Keys.DERIV_LABEL__DERIV_LABEL_CODE_FKEY, Keys.DERIV_LABEL__DERIV_LABEL_LANG_FKEY, Keys.DERIV_LABEL__DERIV_LABEL_TYPE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DerivLabel as(String alias) {
        return new DerivLabel(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DerivLabel as(Name alias) {
        return new DerivLabel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DerivLabel rename(String name) {
        return new DerivLabel(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DerivLabel rename(Name name) {
        return new DerivLabel(name, null);
    }
}
