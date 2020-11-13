/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.MeaningSemanticTypeRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MeaningSemanticType extends TableImpl<MeaningSemanticTypeRecord> {

    private static final long serialVersionUID = 280203610;

    /**
     * The reference instance of <code>public.meaning_semantic_type</code>
     */
    public static final MeaningSemanticType MEANING_SEMANTIC_TYPE = new MeaningSemanticType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeaningSemanticTypeRecord> getRecordType() {
        return MeaningSemanticTypeRecord.class;
    }

    /**
     * The column <code>public.meaning_semantic_type.id</code>.
     */
    public final TableField<MeaningSemanticTypeRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_semantic_type_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.meaning_semantic_type.meaning_id</code>.
     */
    public final TableField<MeaningSemanticTypeRecord, Long> MEANING_ID = createField(DSL.name("meaning_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.meaning_semantic_type.semantic_type_code</code>.
     */
    public final TableField<MeaningSemanticTypeRecord, String> SEMANTIC_TYPE_CODE = createField(DSL.name("semantic_type_code"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.meaning_semantic_type.order_by</code>.
     */
    public final TableField<MeaningSemanticTypeRecord, Long> ORDER_BY = createField(DSL.name("order_by"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('meaning_semantic_type_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.meaning_semantic_type</code> table reference
     */
    public MeaningSemanticType() {
        this(DSL.name("meaning_semantic_type"), null);
    }

    /**
     * Create an aliased <code>public.meaning_semantic_type</code> table reference
     */
    public MeaningSemanticType(String alias) {
        this(DSL.name(alias), MEANING_SEMANTIC_TYPE);
    }

    /**
     * Create an aliased <code>public.meaning_semantic_type</code> table reference
     */
    public MeaningSemanticType(Name alias) {
        this(alias, MEANING_SEMANTIC_TYPE);
    }

    private MeaningSemanticType(Name alias, Table<MeaningSemanticTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private MeaningSemanticType(Name alias, Table<MeaningSemanticTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> MeaningSemanticType(Table<O> child, ForeignKey<O, MeaningSemanticTypeRecord> key) {
        super(child, key, MEANING_SEMANTIC_TYPE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.MEANING_SEMANTIC_TYPE_MEANING_ID_IDX);
    }

    @Override
    public Identity<MeaningSemanticTypeRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEANING_SEMANTIC_TYPE;
    }

    @Override
    public UniqueKey<MeaningSemanticTypeRecord> getPrimaryKey() {
        return Keys.MEANING_SEMANTIC_TYPE_PKEY;
    }

    @Override
    public List<UniqueKey<MeaningSemanticTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<MeaningSemanticTypeRecord>>asList(Keys.MEANING_SEMANTIC_TYPE_PKEY, Keys.MEANING_SEMANTIC_TYPE_MEANING_ID_SEMANTIC_TYPE_CODE_KEY);
    }

    @Override
    public List<ForeignKey<MeaningSemanticTypeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MeaningSemanticTypeRecord, ?>>asList(Keys.MEANING_SEMANTIC_TYPE__MEANING_SEMANTIC_TYPE_MEANING_ID_FKEY, Keys.MEANING_SEMANTIC_TYPE__MEANING_SEMANTIC_TYPE_SEMANTIC_TYPE_CODE_FKEY);
    }

    public Meaning meaning() {
        return new Meaning(this, Keys.MEANING_SEMANTIC_TYPE__MEANING_SEMANTIC_TYPE_MEANING_ID_FKEY);
    }

    public SemanticType semanticType() {
        return new SemanticType(this, Keys.MEANING_SEMANTIC_TYPE__MEANING_SEMANTIC_TYPE_SEMANTIC_TYPE_CODE_FKEY);
    }

    @Override
    public MeaningSemanticType as(String alias) {
        return new MeaningSemanticType(DSL.name(alias), this);
    }

    @Override
    public MeaningSemanticType as(Name alias) {
        return new MeaningSemanticType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningSemanticType rename(String name) {
        return new MeaningSemanticType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MeaningSemanticType rename(Name name) {
        return new MeaningSemanticType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, String, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
