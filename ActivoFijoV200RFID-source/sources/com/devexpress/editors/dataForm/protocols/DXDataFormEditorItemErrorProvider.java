package com.devexpress.editors.dataForm.protocols;

import kotlin.Metadata;

/* compiled from: DXDataFormEditorItemErrorProvider.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItemErrorProvider;", "", "()V", "updateError", "", "hasError", "", "errorText", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DXDataFormEditorItemErrorProvider {
    public abstract void updateError(boolean hasError, CharSequence errorText);
}
