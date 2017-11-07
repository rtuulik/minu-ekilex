/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.definition_freeform_id_seq</code>
     */
    public static final Sequence<Long> DEFINITION_FREEFORM_ID_SEQ = new SequenceImpl<Long>("definition_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.definition_id_seq</code>
     */
    public static final Sequence<Long> DEFINITION_ID_SEQ = new SequenceImpl<Long>("definition_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.eki_user_id_seq</code>
     */
    public static final Sequence<Long> EKI_USER_ID_SEQ = new SequenceImpl<Long>("eki_user_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.form_id_seq</code>
     */
    public static final Sequence<Long> FORM_ID_SEQ = new SequenceImpl<Long>("form_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.form_relation_id_seq</code>
     */
    public static final Sequence<Long> FORM_RELATION_ID_SEQ = new SequenceImpl<Long>("form_relation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.freeform_id_seq</code>
     */
    public static final Sequence<Long> FREEFORM_ID_SEQ = new SequenceImpl<Long>("freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.grammar_id_seq</code>
     */
    public static final Sequence<Long> GRAMMAR_ID_SEQ = new SequenceImpl<Long>("grammar_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lex_relation_id_seq</code>
     */
    public static final Sequence<Long> LEX_RELATION_ID_SEQ = new SequenceImpl<Long>("lex_relation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_deriv_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_DERIV_ID_SEQ = new SequenceImpl<Long>("lexeme_deriv_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_freeform_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_FREEFORM_ID_SEQ = new SequenceImpl<Long>("lexeme_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_ID_SEQ = new SequenceImpl<Long>("lexeme_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_pos_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_POS_ID_SEQ = new SequenceImpl<Long>("lexeme_pos_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lexeme_register_id_seq</code>
     */
    public static final Sequence<Long> LEXEME_REGISTER_ID_SEQ = new SequenceImpl<Long>("lexeme_register_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.lifecycle_log_id_seq</code>
     */
    public static final Sequence<Long> LIFECYCLE_LOG_ID_SEQ = new SequenceImpl<Long>("lifecycle_log_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_domain_id_seq</code>
     */
    public static final Sequence<Long> MEANING_DOMAIN_ID_SEQ = new SequenceImpl<Long>("meaning_domain_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_freeform_id_seq</code>
     */
    public static final Sequence<Long> MEANING_FREEFORM_ID_SEQ = new SequenceImpl<Long>("meaning_freeform_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.meaning_id_seq</code>
     */
    public static final Sequence<Long> MEANING_ID_SEQ = new SequenceImpl<Long>("meaning_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.paradigm_id_seq</code>
     */
    public static final Sequence<Long> PARADIGM_ID_SEQ = new SequenceImpl<Long>("paradigm_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.rection_id_seq</code>
     */
    public static final Sequence<Long> RECTION_ID_SEQ = new SequenceImpl<Long>("rection_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.usage_id_seq</code>
     */
    public static final Sequence<Long> USAGE_ID_SEQ = new SequenceImpl<Long>("usage_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.usage_translation_id_seq</code>
     */
    public static final Sequence<Long> USAGE_TRANSLATION_ID_SEQ = new SequenceImpl<Long>("usage_translation_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.word_id_seq</code>
     */
    public static final Sequence<Long> WORD_ID_SEQ = new SequenceImpl<Long>("word_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
