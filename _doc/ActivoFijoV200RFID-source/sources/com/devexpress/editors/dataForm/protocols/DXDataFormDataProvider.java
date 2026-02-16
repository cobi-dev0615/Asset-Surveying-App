package com.devexpress.editors.dataForm.protocols;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: DXDataFormDataProvider.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\"\u0010\u0018\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\"\u0010\u0019\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u001e\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dH&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;", "", "()V", "groups", "", "Lcom/devexpress/editors/dataForm/protocols/ExpanderInfo;", "getGroups", "()Ljava/util/List;", "getEditor", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;", "groupId", "", "editorId", "getEditors", "getGroup", "getPickerDataSource", "isLastElementInLine", "", "isSourceUpdated", "postValidate", "Lcom/devexpress/editors/dataForm/protocols/DataFormValueValidationError;", "postValue", "", "value", "preValidate", "validate", "validateValues", "Lcom/devexpress/editors/dataForm/protocols/DataFormValuesValidationErrors;", "newValues", "", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DXDataFormDataProvider {
    public abstract DataFormEditorInfo getEditor(int groupId, int editorId);

    public abstract List<DataFormEditorInfo> getEditors(int groupId);

    public abstract ExpanderInfo getGroup(int groupId);

    public abstract List<ExpanderInfo> getGroups();

    public abstract List<Object> getPickerDataSource(int groupId, int editorId);

    public abstract boolean isLastElementInLine(int groupId, int editorId);

    public abstract boolean isSourceUpdated(int groupId, int editorId);

    public abstract DataFormValueValidationError postValidate(int groupId, int editorId);

    public abstract void postValue(Object value, int groupId, int editorId);

    public abstract DataFormValueValidationError preValidate(Object value, int groupId, int editorId);

    public abstract DataFormValueValidationError validate(Object value, int groupId, int editorId);

    public abstract DataFormValuesValidationErrors validateValues(Map<String, ? extends Object> newValues);
}
