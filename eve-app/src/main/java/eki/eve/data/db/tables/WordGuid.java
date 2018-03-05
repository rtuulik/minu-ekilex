/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Indexes;
import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.WordGuidRecord;

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
public class WordGuid extends TableImpl<WordGuidRecord> {

    private static final long serialVersionUID = 779343691;

    /**
     * The reference instance of <code>public.word_guid</code>
     */
    public static final WordGuid WORD_GUID = new WordGuid();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WordGuidRecord> getRecordType() {
        return WordGuidRecord.class;
    }

    /**
     * The column <code>public.word_guid.id</code>.
     */
    public final TableField<WordGuidRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('word_guid_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.word_guid.word_id</code>.
     */
    public final TableField<WordGuidRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.word_guid.guid</code>.
     */
    public final TableField<WordGuidRecord, String> GUID = createField("guid", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.word_guid.dataset_code</code>.
     */
    public final TableField<WordGuidRecord, String> DATASET_CODE = createField("dataset_code", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>public.word_guid</code> table reference
     */
    public WordGuid() {
        this(DSL.name("word_guid"), null);
    }

    /**
     * Create an aliased <code>public.word_guid</code> table reference
     */
    public WordGuid(String alias) {
        this(DSL.name(alias), WORD_GUID);
    }

    /**
     * Create an aliased <code>public.word_guid</code> table reference
     */
    public WordGuid(Name alias) {
        this(alias, WORD_GUID);
    }

    private WordGuid(Name alias, Table<WordGuidRecord> aliased) {
        this(alias, aliased, null);
    }

    private WordGuid(Name alias, Table<WordGuidRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.WORD_GUID_PKEY, Indexes.WORD_GUID_WORD_ID_GUID_DATASET_CODE_KEY, Indexes.WORD_GUID_WORD_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<WordGuidRecord, Long> getIdentity() {
        return Keys.IDENTITY_WORD_GUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<WordGuidRecord> getPrimaryKey() {
        return Keys.WORD_GUID_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<WordGuidRecord>> getKeys() {
        return Arrays.<UniqueKey<WordGuidRecord>>asList(Keys.WORD_GUID_PKEY, Keys.WORD_GUID_WORD_ID_GUID_DATASET_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<WordGuidRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<WordGuidRecord, ?>>asList(Keys.WORD_GUID__WORD_GUID_WORD_ID_FKEY, Keys.WORD_GUID__WORD_GUID_DATASET_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordGuid as(String alias) {
        return new WordGuid(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordGuid as(Name alias) {
        return new WordGuid(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WordGuid rename(String name) {
        return new WordGuid(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WordGuid rename(Name name) {
        return new WordGuid(name, null);
    }
}
