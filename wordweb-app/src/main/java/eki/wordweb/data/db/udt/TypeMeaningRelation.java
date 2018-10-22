/*
 * This file is generated by jOOQ.
*/
package eki.wordweb.data.db.udt;


import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.udt.records.TypeMeaningRelationRecord;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.UDTImpl;


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
public class TypeMeaningRelation extends UDTImpl<TypeMeaningRelationRecord> {

    private static final long serialVersionUID = 1541101095;

    /**
     * The reference instance of <code>public.type_meaning_relation</code>
     */
    public static final TypeMeaningRelation TYPE_MEANING_RELATION = new TypeMeaningRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypeMeaningRelationRecord> getRecordType() {
        return TypeMeaningRelationRecord.class;
    }

    /**
     * The attribute <code>public.type_meaning_relation.meaning_id</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.lexeme_id</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.word_id</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.word</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.word_lang</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> WORD_LANG = createField("word_lang", org.jooq.impl.SQLDataType.CHAR(3), TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.meaning_rel_type_code</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> MEANING_REL_TYPE_CODE = createField("meaning_rel_type_code", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_MEANING_RELATION, "");

    /**
     * No further instances allowed
     */
    private TypeMeaningRelation() {
        super("type_meaning_relation", null, null, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }
}
