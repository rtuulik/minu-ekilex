/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.FormRelationRecord;

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
public class FormRelation extends TableImpl<FormRelationRecord> {

    private static final long serialVersionUID = 1959477235;

    /**
     * The reference instance of <code>public.form_relation</code>
     */
    public static final FormRelation FORM_RELATION = new FormRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FormRelationRecord> getRecordType() {
        return FormRelationRecord.class;
    }

    /**
     * The column <code>public.form_relation.id</code>.
     */
    public final TableField<FormRelationRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('form_relation_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.form_relation.form1_id</code>.
     */
    public final TableField<FormRelationRecord, Long> FORM1_ID = createField("form1_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.form_relation.form2_id</code>.
     */
    public final TableField<FormRelationRecord, Long> FORM2_ID = createField("form2_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.form_relation.form_rel_type_code</code>.
     */
    public final TableField<FormRelationRecord, String> FORM_REL_TYPE_CODE = createField("form_rel_type_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.form_relation.order_by</code>.
     */
    public final TableField<FormRelationRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('form_relation_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.form_relation</code> table reference
     */
    public FormRelation() {
        this(DSL.name("form_relation"), null);
    }

    /**
     * Create an aliased <code>public.form_relation</code> table reference
     */
    public FormRelation(String alias) {
        this(DSL.name(alias), FORM_RELATION);
    }

    /**
     * Create an aliased <code>public.form_relation</code> table reference
     */
    public FormRelation(Name alias) {
        this(alias, FORM_RELATION);
    }

    private FormRelation(Name alias, Table<FormRelationRecord> aliased) {
        this(alias, aliased, null);
    }

    private FormRelation(Name alias, Table<FormRelationRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.FORM_RELATION_FORM1_ID_FORM2_ID_FORM_REL_TYPE_CODE_KEY, Indexes.FORM_RELATION_FORM1_ID_IDX, Indexes.FORM_RELATION_FORM2_ID_IDX, Indexes.FORM_RELATION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<FormRelationRecord, Long> getIdentity() {
        return Keys.IDENTITY_FORM_RELATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FormRelationRecord> getPrimaryKey() {
        return Keys.FORM_RELATION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FormRelationRecord>> getKeys() {
        return Arrays.<UniqueKey<FormRelationRecord>>asList(Keys.FORM_RELATION_PKEY, Keys.FORM_RELATION_FORM1_ID_FORM2_ID_FORM_REL_TYPE_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<FormRelationRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FormRelationRecord, ?>>asList(Keys.FORM_RELATION__FORM_RELATION_FORM1_ID_FKEY, Keys.FORM_RELATION__FORM_RELATION_FORM2_ID_FKEY, Keys.FORM_RELATION__FORM_RELATION_FORM_REL_TYPE_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormRelation as(String alias) {
        return new FormRelation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormRelation as(Name alias) {
        return new FormRelation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FormRelation rename(String name) {
        return new FormRelation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FormRelation rename(Name name) {
        return new FormRelation(name, null);
    }
}
