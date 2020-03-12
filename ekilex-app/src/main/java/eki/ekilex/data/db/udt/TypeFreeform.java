/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.udt;


import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.udt.records.TypeFreeformRecord;

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
public class TypeFreeform extends UDTImpl<TypeFreeformRecord> {

    private static final long serialVersionUID = -279076511;

    /**
     * The reference instance of <code>public.type_freeform</code>
     */
    public static final TypeFreeform TYPE_FREEFORM = new TypeFreeform();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TypeFreeformRecord> getRecordType() {
        return TypeFreeformRecord.class;
    }

    /**
     * The attribute <code>public.type_freeform.freeform_id</code>.
     */
    public static final UDTField<TypeFreeformRecord, Long> FREEFORM_ID = createField("freeform_id", org.jooq.impl.SQLDataType.BIGINT, TYPE_FREEFORM, "");

    /**
     * The attribute <code>public.type_freeform.type</code>.
     */
    public static final UDTField<TypeFreeformRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_FREEFORM, "");

    /**
     * The attribute <code>public.type_freeform.value</code>.
     */
    public static final UDTField<TypeFreeformRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB, TYPE_FREEFORM, "");

    /**
     * The attribute <code>public.type_freeform.complexity</code>.
     */
    public static final UDTField<TypeFreeformRecord, String> COMPLEXITY = createField("complexity", org.jooq.impl.SQLDataType.VARCHAR(100), TYPE_FREEFORM, "");

    /**
     * No further instances allowed
     */
    private TypeFreeform() {
        super("type_freeform", null, null, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC != null ? Public.PUBLIC : new SchemaImpl(DSL.name("public"));
    }
}
