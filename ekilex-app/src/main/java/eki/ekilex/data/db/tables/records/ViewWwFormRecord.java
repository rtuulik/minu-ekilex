/*
 * This file is generated by jOOQ.
*/
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.ViewWwForm;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.TableRecordImpl;


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
public class ViewWwFormRecord extends TableRecordImpl<ViewWwFormRecord> implements Record10<Long, Long, Long, String, String, String[], String, String, String, Boolean> {

    private static final long serialVersionUID = -586948238;

    /**
     * Setter for <code>public.view_ww_form.word_id</code>.
     */
    public void setWordId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.view_ww_form.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.view_ww_form.paradigm_id</code>.
     */
    public void setParadigmId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.view_ww_form.paradigm_id</code>.
     */
    public Long getParadigmId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.view_ww_form.form_id</code>.
     */
    public void setFormId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.view_ww_form.form_id</code>.
     */
    public Long getFormId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.view_ww_form.form</code>.
     */
    public void setForm(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.view_ww_form.form</code>.
     */
    public String getForm() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.view_ww_form.morph_code</code>.
     */
    public void setMorphCode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.view_ww_form.morph_code</code>.
     */
    public String getMorphCode() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.view_ww_form.components</code>.
     */
    public void setComponents(String... value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.view_ww_form.components</code>.
     */
    public String[] getComponents() {
        return (String[]) get(5);
    }

    /**
     * Setter for <code>public.view_ww_form.display_form</code>.
     */
    public void setDisplayForm(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.view_ww_form.display_form</code>.
     */
    public String getDisplayForm() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.view_ww_form.vocal_form</code>.
     */
    public void setVocalForm(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.view_ww_form.vocal_form</code>.
     */
    public String getVocalForm() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.view_ww_form.sound_file</code>.
     */
    public void setSoundFile(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.view_ww_form.sound_file</code>.
     */
    public String getSoundFile() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.view_ww_form.is_word</code>.
     */
    public void setIsWord(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.view_ww_form.is_word</code>.
     */
    public Boolean getIsWord() {
        return (Boolean) get(9);
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Long, Long, Long, String, String, String[], String, String, String, Boolean> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Long, Long, Long, String, String, String[], String, String, String, Boolean> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ViewWwForm.VIEW_WW_FORM.WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ViewWwForm.VIEW_WW_FORM.PARADIGM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return ViewWwForm.VIEW_WW_FORM.FORM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ViewWwForm.VIEW_WW_FORM.FORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return ViewWwForm.VIEW_WW_FORM.MORPH_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field6() {
        return ViewWwForm.VIEW_WW_FORM.COMPONENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return ViewWwForm.VIEW_WW_FORM.DISPLAY_FORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return ViewWwForm.VIEW_WW_FORM.VOCAL_FORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return ViewWwForm.VIEW_WW_FORM.SOUND_FILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field10() {
        return ViewWwForm.VIEW_WW_FORM.IS_WORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getParadigmId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getFormId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getMorphCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component6() {
        return getComponents();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getDisplayForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getVocalForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getSoundFile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component10() {
        return getIsWord();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getParadigmId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getFormId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMorphCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value6() {
        return getComponents();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getDisplayForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getVocalForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getSoundFile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value10() {
        return getIsWord();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value1(Long value) {
        setWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value2(Long value) {
        setParadigmId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value3(Long value) {
        setFormId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value4(String value) {
        setForm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value5(String value) {
        setMorphCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value6(String... value) {
        setComponents(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value7(String value) {
        setDisplayForm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value8(String value) {
        setVocalForm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value9(String value) {
        setSoundFile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord value10(Boolean value) {
        setIsWord(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwFormRecord values(Long value1, Long value2, Long value3, String value4, String value5, String[] value6, String value7, String value8, String value9, Boolean value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ViewWwFormRecord
     */
    public ViewWwFormRecord() {
        super(ViewWwForm.VIEW_WW_FORM);
    }

    /**
     * Create a detached, initialised ViewWwFormRecord
     */
    public ViewWwFormRecord(Long wordId, Long paradigmId, Long formId, String form, String morphCode, String[] components, String displayForm, String vocalForm, String soundFile, Boolean isWord) {
        super(ViewWwForm.VIEW_WW_FORM);

        set(0, wordId);
        set(1, paradigmId);
        set(2, formId);
        set(3, form);
        set(4, morphCode);
        set(5, components);
        set(6, displayForm);
        set(7, vocalForm);
        set(8, soundFile);
        set(9, isWord);
    }
}
