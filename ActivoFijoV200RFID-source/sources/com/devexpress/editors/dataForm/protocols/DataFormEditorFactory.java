package com.devexpress.editors.dataForm.protocols;

import android.content.Context;
import kotlin.Metadata;

/* compiled from: DataFormEditorFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DataFormEditorFactory;", "", "()V", "create", "Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItem;", "context", "Landroid/content/Context;", "kind", "Lcom/devexpress/editors/dataForm/protocols/EditorType;", "groupId", "", "editorIndex", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DataFormEditorFactory {
    public abstract DXDataFormEditorItem create(Context context, EditorType kind, int groupId, int editorIndex);
}
