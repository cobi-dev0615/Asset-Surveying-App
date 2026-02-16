package com.devexpress.editors.dataForm.protocols;

import android.view.View;
import com.devexpress.editors.EditBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DXDataFormEditorItem.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0001H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItem;", "", "view", "Landroid/view/View;", "editorErrorProvider", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItemErrorProvider;", "(Landroid/view/View;Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItemErrorProvider;)V", "edit", "Lcom/devexpress/editors/EditBase;", "getEdit", "()Lcom/devexpress/editors/EditBase;", "getEditorErrorProvider", "()Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItemErrorProvider;", "setEditorErrorProvider", "(Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItemErrorProvider;)V", "getView", "()Landroid/view/View;", "commitEditorValue", "", "configure", "", "getEditorWrappedValue", "resetEditorValue", "validateEditorValue", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DXDataFormEditorItem {
    private final EditBase edit;
    private DXDataFormEditorItemErrorProvider editorErrorProvider;
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    public DXDataFormEditorItem(View view) {
        this(view, null, 2, 0 == true ? 1 : 0);
    }

    public boolean commitEditorValue() {
        return false;
    }

    public void configure() {
    }

    public void resetEditorValue() {
    }

    public boolean validateEditorValue() {
        return false;
    }

    public DXDataFormEditorItem(View view, DXDataFormEditorItemErrorProvider dXDataFormEditorItemErrorProvider) {
        this.view = view;
        this.editorErrorProvider = dXDataFormEditorItemErrorProvider;
    }

    public /* synthetic */ DXDataFormEditorItem(View view, DXDataFormEditorItemErrorProvider dXDataFormEditorItemErrorProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? null : dXDataFormEditorItemErrorProvider);
    }

    public View getView() {
        return this.view;
    }

    public final DXDataFormEditorItemErrorProvider getEditorErrorProvider() {
        return this.editorErrorProvider;
    }

    public final void setEditorErrorProvider(DXDataFormEditorItemErrorProvider dXDataFormEditorItemErrorProvider) {
        this.editorErrorProvider = dXDataFormEditorItemErrorProvider;
    }

    public EditBase getEdit() {
        return this.edit;
    }

    public Object getEditorWrappedValue() {
        return new Object();
    }
}
