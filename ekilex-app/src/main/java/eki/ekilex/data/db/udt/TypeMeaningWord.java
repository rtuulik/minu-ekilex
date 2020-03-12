/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.udt;


import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.udt.records.TypeFreeformRecord;
import eki.ekilex.data.db.udt.records.TypeMeaningWordRecord;

import java.math.BigDecimal;

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
public class TypeMeaningWord extends UDTImpl<TypeMeaningWordRecord> {

    private static final long serialVersionUID = -558886732;

    /**
     * The reference instance of <code>public.type_meaning_word</code>
     */
    public static final TypeMeaningWord TYPE_MEANING_WORD = new TypeMeaningWord();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypeMeaningWordRecord> getRecordType() {
        return TypeMeaningWordRecord.class;
    }

    /**
     * The attribute <code>public.type_meaning_word.lexeme_id</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.meaning_id</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.mw_lexeme_id</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, Long> MW_LEXEME_ID = createField("mw_lexeme_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.mw_lex_complexity</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String> MW_LEX_COMPLEXITY = createField("mw_lex_complexity", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.mw_lex_weight</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, BigDecimal> MW_LEX_WEIGHT = createField("mw_lex_weight", org.jooq.impl.SQLDataType.NUMERIC(5, 4), TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.mw_lex_governments</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, TypeFreeformRecord[]> MW_LEX_GOVERNMENTS = createField("mw_lex_governments", eki.ekilex.data.db.udt.TypeFreeform.TYPE_FREEFORM.getDataType().getArrayDataType(), TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.mw_lex_register_codes</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String[]> MW_LEX_REGISTER_CODES = createField("mw_lex_register_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.mw_lex_value_state_code</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String> MW_LEX_VALUE_STATE_CODE = createField("mw_lex_value_state_code", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.word_id</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.word</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB, TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.word_prese</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String> WORD_PRESE = createField("word_prese", org.jooq.impl.SQLDataType.CLOB, TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.homonym_nr</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, Integer> HOMONYM_NR = createField("homonym_nr", org.jooq.impl.SQLDataType.INTEGER, TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.lang</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR(3), TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.word_type_codes</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String[]> WORD_TYPE_CODES = createField("word_type_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), TYPE_MEANING_WORD, "");

    /**
     * The attribute <code>public.type_meaning_word.aspect_code</code>.
     */
    public static final UDTField<TypeMeaningWordRecord, String> ASPECT_CODE = createField("aspect_code", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_MEANING_WORD, "");

    /**
     * No further instances allowed
     */
    private TypeMeaningWord() {
        super("type_meaning_word", null, null, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC != null ? Public.PUBLIC : new SchemaImpl(DSL.name("public"));
    }
}
