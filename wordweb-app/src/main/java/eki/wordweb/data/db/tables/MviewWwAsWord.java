/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db.tables;


import eki.wordweb.data.db.Indexes;
import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.tables.records.MviewWwAsWordRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MviewWwAsWord extends TableImpl<MviewWwAsWordRecord> {

    private static final long serialVersionUID = 935946218;

    /**
     * The reference instance of <code>public.mview_ww_as_word</code>
     */
    public static final MviewWwAsWord MVIEW_WW_AS_WORD = new MviewWwAsWord();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MviewWwAsWordRecord> getRecordType() {
        return MviewWwAsWordRecord.class;
    }

    /**
     * The column <code>public.mview_ww_as_word.word_id</code>.
     */
    public final TableField<MviewWwAsWordRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_as_word.word</code>.
     */
    public final TableField<MviewWwAsWordRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.mview_ww_as_word.as_word</code>.
     */
    public final TableField<MviewWwAsWordRecord, String> AS_WORD = createField("as_word", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.mview_ww_as_word</code> table reference
     */
    public MviewWwAsWord() {
        this(DSL.name("mview_ww_as_word"), null);
    }

    /**
     * Create an aliased <code>public.mview_ww_as_word</code> table reference
     */
    public MviewWwAsWord(String alias) {
        this(DSL.name(alias), MVIEW_WW_AS_WORD);
    }

    /**
     * Create an aliased <code>public.mview_ww_as_word</code> table reference
     */
    public MviewWwAsWord(Name alias) {
        this(alias, MVIEW_WW_AS_WORD);
    }

    private MviewWwAsWord(Name alias, Table<MviewWwAsWordRecord> aliased) {
        this(alias, aliased, null);
    }

    private MviewWwAsWord(Name alias, Table<MviewWwAsWordRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.MVIEW_WW_AS_WORD_VALUE_IDX, Indexes.MVIEW_WW_AS_WORD_VALUE_PREFIX_IDX, Indexes.MVIEW_WW_AS_WORD_WORD_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwAsWord as(String alias) {
        return new MviewWwAsWord(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwAsWord as(Name alias) {
        return new MviewWwAsWord(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwAsWord rename(String name) {
        return new MviewWwAsWord(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwAsWord rename(Name name) {
        return new MviewWwAsWord(name, null);
    }
}
