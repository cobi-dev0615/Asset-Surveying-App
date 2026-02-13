package com.devexpress.editors.dataForm;

import com.devexpress.editors.dataForm.protocols.DXDataFormDataProvider;
import com.devexpress.editors.dataForm.protocols.DataFormEditorInfo;
import com.devexpress.editors.dataForm.protocols.DataFormItemDataProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormItemDataProviderImpl.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/dataForm/DataFormItemDataProviderImpl;", "Lcom/devexpress/editors/dataForm/protocols/DataFormItemDataProvider;", "dataProvider", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;", "groupId", "", "editorId", "(Lcom/devexpress/editors/dataForm/protocols/DXDataFormDataProvider;II)V", "getEditorId", "()I", "setEditorId", "(I)V", "getGroupId", "setGroupId", "getEditorInfo", "Lcom/devexpress/editors/dataForm/protocols/DataFormEditorInfo;", "getPickerDataSource", "", "", "sourceUpdated", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataFormItemDataProviderImpl implements DataFormItemDataProvider {
    private final DXDataFormDataProvider dataProvider;
    private int editorId;
    private int groupId;

    public DataFormItemDataProviderImpl(DXDataFormDataProvider dataProvider, int i, int i2) {
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.dataProvider = dataProvider;
        this.groupId = i;
        this.editorId = i2;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(int i) {
        this.groupId = i;
    }

    public final int getEditorId() {
        return this.editorId;
    }

    public final void setEditorId(int i) {
        this.editorId = i;
    }

    @Override // com.devexpress.editors.dataForm.protocols.DataFormItemEditorInfoProvider
    public DataFormEditorInfo getEditorInfo() {
        return this.dataProvider.getEditor(this.groupId, this.editorId);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DataFormPickerItemDataProvider
    public boolean sourceUpdated() {
        return this.dataProvider.isSourceUpdated(this.groupId, this.editorId);
    }

    @Override // com.devexpress.editors.dataForm.protocols.DataFormPickerItemDataProvider
    public List<Object> getPickerDataSource() {
        return this.dataProvider.getPickerDataSource(this.groupId, this.editorId);
    }
}
