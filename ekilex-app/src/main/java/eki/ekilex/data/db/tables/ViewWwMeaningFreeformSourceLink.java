/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.ViewWwMeaningFreeformSourceLinkRecord;
import eki.ekilex.data.db.udt.records.TypeSourceLinkRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ViewWwMeaningFreeformSourceLink extends TableImpl<ViewWwMeaningFreeformSourceLinkRecord> {

    private static final long serialVersionUID = -881193861;

    /**
     * The reference instance of <code>public.view_ww_meaning_freeform_source_link</code>
     */
    public static final ViewWwMeaningFreeformSourceLink VIEW_WW_MEANING_FREEFORM_SOURCE_LINK = new ViewWwMeaningFreeformSourceLink();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ViewWwMeaningFreeformSourceLinkRecord> getRecordType() {
        return ViewWwMeaningFreeformSourceLinkRecord.class;
    }

    /**
     * The column <code>public.view_ww_meaning_freeform_source_link.meaning_id</code>.
     */
    public final TableField<ViewWwMeaningFreeformSourceLinkRecord, Long> MEANING_ID = createField(DSL.name("meaning_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.view_ww_meaning_freeform_source_link.source_links</code>.
     */
    public final TableField<ViewWwMeaningFreeformSourceLinkRecord, TypeSourceLinkRecord[]> SOURCE_LINKS = createField(DSL.name("source_links"), eki.ekilex.data.db.udt.TypeSourceLink.TYPE_SOURCE_LINK.getDataType().getArrayDataType(), this, "");

    /**
     * Create a <code>public.view_ww_meaning_freeform_source_link</code> table reference
     */
    public ViewWwMeaningFreeformSourceLink() {
        this(DSL.name("view_ww_meaning_freeform_source_link"), null);
    }

    /**
     * Create an aliased <code>public.view_ww_meaning_freeform_source_link</code> table reference
     */
    public ViewWwMeaningFreeformSourceLink(String alias) {
        this(DSL.name(alias), VIEW_WW_MEANING_FREEFORM_SOURCE_LINK);
    }

    /**
     * Create an aliased <code>public.view_ww_meaning_freeform_source_link</code> table reference
     */
    public ViewWwMeaningFreeformSourceLink(Name alias) {
        this(alias, VIEW_WW_MEANING_FREEFORM_SOURCE_LINK);
    }

    private ViewWwMeaningFreeformSourceLink(Name alias, Table<ViewWwMeaningFreeformSourceLinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private ViewWwMeaningFreeformSourceLink(Name alias, Table<ViewWwMeaningFreeformSourceLinkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("create view \"view_ww_meaning_freeform_source_link\" as  SELECT ffsl.meaning_id,\n    array_agg(ROW('FREEFORM'::character varying(100), ffsl.freeform_id, ffsl.source_link_id, ffsl.type, ffsl.name, ffsl.value, ffsl.order_by, ffsl.source_id, ffsl.source_props)::type_source_link ORDER BY ffsl.freeform_id, ffsl.order_by) AS source_links\n   FROM ( SELECT mff.meaning_id,\n            mff.freeform_id,\n            ffsl_1.id AS source_link_id,\n            ffsl_1.type,\n            ffsl_1.name,\n            ffsl_1.value,\n            ffsl_1.order_by,\n            s.source_id,\n            s.source_props\n           FROM lexeme l,\n            dataset ds,\n            meaning_freeform mff,\n            freeform_source_link ffsl_1,\n            ( SELECT s_1.id AS source_id,\n                    array_agg(ff.value_prese ORDER BY ff.order_by) AS source_props\n                   FROM source s_1,\n                    source_freeform sff,\n                    freeform ff\n                  WHERE ((sff.source_id = s_1.id) AND (sff.freeform_id = ff.id) AND ((ff.type)::text <> ALL (ARRAY[('SOURCE_FILE'::character varying)::text, ('EXTERNAL_SOURCE_ID'::character varying)::text])))\n                  GROUP BY s_1.id) s\n          WHERE ((l.is_public = true) AND (l.meaning_id = mff.meaning_id) AND (ffsl_1.freeform_id = mff.freeform_id) AND (ffsl_1.source_id = s.source_id) AND ((ds.code)::text = (l.dataset_code)::text) AND (ds.is_public = true))\n          GROUP BY mff.meaning_id, mff.freeform_id, ffsl_1.id, s.source_id, s.source_props) ffsl\n  GROUP BY ffsl.meaning_id\n  ORDER BY ffsl.meaning_id;"));
    }

    public <O extends Record> ViewWwMeaningFreeformSourceLink(Table<O> child, ForeignKey<O, ViewWwMeaningFreeformSourceLinkRecord> key) {
        super(child, key, VIEW_WW_MEANING_FREEFORM_SOURCE_LINK);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public ViewWwMeaningFreeformSourceLink as(String alias) {
        return new ViewWwMeaningFreeformSourceLink(DSL.name(alias), this);
    }

    @Override
    public ViewWwMeaningFreeformSourceLink as(Name alias) {
        return new ViewWwMeaningFreeformSourceLink(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwMeaningFreeformSourceLink rename(String name) {
        return new ViewWwMeaningFreeformSourceLink(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwMeaningFreeformSourceLink rename(Name name) {
        return new ViewWwMeaningFreeformSourceLink(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, TypeSourceLinkRecord[]> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
