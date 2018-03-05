/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.MeaningRelationRecord;

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
public class MeaningRelation extends TableImpl<MeaningRelationRecord> {

    private static final long serialVersionUID = 154328742;

    /**
     * The reference instance of <code>public.meaning_relation</code>
     */
    public static final MeaningRelation MEANING_RELATION = new MeaningRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeaningRelationRecord> getRecordType() {
        return MeaningRelationRecord.class;
    }

    /**
     * The column <code>public.meaning_relation.id</code>.
     */
    public final TableField<MeaningRelationRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_relation_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.meaning_relation.meaning1_id</code>.
     */
    public final TableField<MeaningRelationRecord, Long> MEANING1_ID = createField("meaning1_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.meaning_relation.meaning2_id</code>.
     */
    public final TableField<MeaningRelationRecord, Long> MEANING2_ID = createField("meaning2_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.meaning_relation.meaning_rel_type_code</code>.
     */
    public final TableField<MeaningRelationRecord, String> MEANING_REL_TYPE_CODE = createField("meaning_rel_type_code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.meaning_relation.order_by</code>.
     */
    public final TableField<MeaningRelationRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_relation_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.meaning_relation</code> table reference
     */
    public MeaningRelation() {
        this(DSL.name("meaning_relation"), null);
    }

    /**
     * Create an aliased <code>public.meaning_relation</code> table reference
     */
    public MeaningRelation(String alias) {
        this(DSL.name(alias), MEANING_RELATION);
    }

    /**
     * Create an aliased <code>public.meaning_relation</code> table reference
     */
    public MeaningRelation(Name alias) {
        this(alias, MEANING_RELATION);
    }

    private MeaningRelation(Name alias, Table<MeaningRelationRecord> aliased) {
        this(alias, aliased, null);
    }

    private MeaningRelation(Name alias, Table<MeaningRelationRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.MEANING_RELATION_MEANING1_ID_IDX, Indexes.MEANING_RELATION_MEANING1_ID_MEANING2_ID_MEANING_REL_TYPE_C_KEY, Indexes.MEANING_RELATION_MEANING2_ID_IDX, Indexes.MEANING_RELATION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MeaningRelationRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEANING_RELATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MeaningRelationRecord> getPrimaryKey() {
        return Keys.MEANING_RELATION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MeaningRelationRecord>> getKeys() {
        return Arrays.<UniqueKey<MeaningRelationRecord>>asList(Keys.MEANING_RELATION_PKEY, Keys.MEANING_RELATION_MEANING1_ID_MEANING2_ID_MEANING_REL_TYPE_C_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MeaningRelationRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MeaningRelationRecord, ?>>asList(Keys.MEANING_RELATION__MEANING_RELATION_MEANING1_ID_FKEY, Keys.MEANING_RELATION__MEANING_RELATION_MEANING2_ID_FKEY, Keys.MEANING_RELATION__MEANING_RELATION_MEANING_REL_TYPE_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningRelation as(String alias) {
        return new MeaningRelation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeaningRelation as(Name alias) {
        return new MeaningRelation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningRelation rename(String name) {
        return new MeaningRelation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningRelation rename(Name name) {
        return new MeaningRelation(name, null);
    }
}
