/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.LexemeRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
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
public class Lexeme extends TableImpl<LexemeRecord> {

    private static final long serialVersionUID = 1581310405;

    /**
     * The reference instance of <code>public.lexeme</code>
     */
    public static final Lexeme LEXEME = new Lexeme();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexemeRecord> getRecordType() {
        return LexemeRecord.class;
    }

    /**
     * The column <code>public.lexeme.id</code>.
     */
    public final TableField<LexemeRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme.word_id</code>.
     */
    public final TableField<LexemeRecord, Long> WORD_ID = createField(DSL.name("word_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme.meaning_id</code>.
     */
    public final TableField<LexemeRecord, Long> MEANING_ID = createField(DSL.name("meaning_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme.dataset_code</code>.
     */
    public final TableField<LexemeRecord, String> DATASET_CODE = createField(DSL.name("dataset_code"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>public.lexeme.level1</code>.
     */
    public final TableField<LexemeRecord, Integer> LEVEL1 = createField(DSL.name("level1"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.lexeme.level2</code>.
     */
    public final TableField<LexemeRecord, Integer> LEVEL2 = createField(DSL.name("level2"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.lexeme.value_state_code</code>.
     */
    public final TableField<LexemeRecord, String> VALUE_STATE_CODE = createField(DSL.name("value_state_code"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lexeme.complexity</code>.
     */
    public final TableField<LexemeRecord, String> COMPLEXITY = createField(DSL.name("complexity"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.lexeme.order_by</code>.
     */
    public final TableField<LexemeRecord, Long> ORDER_BY = createField(DSL.name("order_by"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme.weight</code>.
     */
    public final TableField<LexemeRecord, BigDecimal> WEIGHT = createField(DSL.name("weight"), org.jooq.impl.SQLDataType.NUMERIC(5, 4).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.NUMERIC)), this, "");

    /**
     * The column <code>public.lexeme.is_public</code>.
     */
    public final TableField<LexemeRecord, Boolean> IS_PUBLIC = createField(DSL.name("is_public"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>public.lexeme</code> table reference
     */
    public Lexeme() {
        this(DSL.name("lexeme"), null);
    }

    /**
     * Create an aliased <code>public.lexeme</code> table reference
     */
    public Lexeme(String alias) {
        this(DSL.name(alias), LEXEME);
    }

    /**
     * Create an aliased <code>public.lexeme</code> table reference
     */
    public Lexeme(Name alias) {
        this(alias, LEXEME);
    }

    private Lexeme(Name alias, Table<LexemeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Lexeme(Name alias, Table<LexemeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Lexeme(Table<O> child, ForeignKey<O, LexemeRecord> key) {
        super(child, key, LEXEME);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.LEXEME_COMPLEXITY_IDX, Indexes.LEXEME_DATASET_CODE_IDX, Indexes.LEXEME_IS_PUBLIC_IDX, Indexes.LEXEME_MEANING_ID_IDX, Indexes.LEXEME_WORD_ID_IDX);
    }

    @Override
    public Identity<LexemeRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXEME;
    }

    @Override
    public UniqueKey<LexemeRecord> getPrimaryKey() {
        return Keys.LEXEME_PKEY;
    }

    @Override
    public List<UniqueKey<LexemeRecord>> getKeys() {
        return Arrays.<UniqueKey<LexemeRecord>>asList(Keys.LEXEME_PKEY, Keys.LEXEME_WORD_ID_MEANING_ID_DATASET_CODE_KEY);
    }

    @Override
    public List<ForeignKey<LexemeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexemeRecord, ?>>asList(Keys.LEXEME__LEXEME_WORD_ID_FKEY, Keys.LEXEME__LEXEME_MEANING_ID_FKEY, Keys.LEXEME__LEXEME_DATASET_CODE_FKEY, Keys.LEXEME__LEXEME_VALUE_STATE_CODE_FKEY);
    }

    public Word word() {
        return new Word(this, Keys.LEXEME__LEXEME_WORD_ID_FKEY);
    }

    public Meaning meaning() {
        return new Meaning(this, Keys.LEXEME__LEXEME_MEANING_ID_FKEY);
    }

    public Dataset dataset() {
        return new Dataset(this, Keys.LEXEME__LEXEME_DATASET_CODE_FKEY);
    }

    public ValueState valueState() {
        return new ValueState(this, Keys.LEXEME__LEXEME_VALUE_STATE_CODE_FKEY);
    }

    @Override
    public Lexeme as(String alias) {
        return new Lexeme(DSL.name(alias), this);
    }

    @Override
    public Lexeme as(Name alias) {
        return new Lexeme(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Lexeme rename(String name) {
        return new Lexeme(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Lexeme rename(Name name) {
        return new Lexeme(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, Long, Long, String, Integer, Integer, String, String, Long, BigDecimal, Boolean> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}
