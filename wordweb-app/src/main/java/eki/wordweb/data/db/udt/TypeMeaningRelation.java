/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.udt;


import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.udt.records.TypeMeaningRelationRecord;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.DSL;
import org.jooq.impl.SchemaImpl;
import org.jooq.impl.UDTImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TypeMeaningRelation extends UDTImpl<TypeMeaningRelationRecord> {

    private static final long serialVersionUID = -1318743132;

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
     * The attribute <code>public.type_meaning_relation.word_id</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.word</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.word_prese</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> WORD_PRESE = createField("word_prese", org.jooq.impl.SQLDataType.CLOB, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.homonym_nr</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, Integer> HOMONYM_NR = createField("homonym_nr", org.jooq.impl.SQLDataType.INTEGER, TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.lang</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR(3), TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.aspect_code</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> ASPECT_CODE = createField("aspect_code", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.word_type_codes</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String[]> WORD_TYPE_CODES = createField("word_type_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.complexity</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String> COMPLEXITY = createField("complexity", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.lex_value_state_codes</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String[]> LEX_VALUE_STATE_CODES = createField("lex_value_state_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.lex_register_codes</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String[]> LEX_REGISTER_CODES = createField("lex_register_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), TYPE_MEANING_RELATION, "");

    /**
     * The attribute <code>public.type_meaning_relation.lex_government_values</code>.
     */
    public static final UDTField<TypeMeaningRelationRecord, String[]> LEX_GOVERNMENT_VALUES = createField("lex_government_values", org.jooq.impl.SQLDataType.CLOB.getArrayDataType(), TYPE_MEANING_RELATION, "");

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
        return Public.PUBLIC != null ? Public.PUBLIC : new SchemaImpl(DSL.name("public"));
    }
}
