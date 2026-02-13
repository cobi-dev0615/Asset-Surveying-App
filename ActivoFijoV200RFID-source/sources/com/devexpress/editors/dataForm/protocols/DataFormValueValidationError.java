package com.devexpress.editors.dataForm.protocols;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormValueValidationError.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DataFormValueValidationError;", "", "()V", "errorText", "", "getErrorText", "()Ljava/lang/String;", "setErrorText", "(Ljava/lang/String;)V", "hasError", "", "getHasError", "()Z", "setHasError", "(Z)V", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DataFormValueValidationError {
    private String errorText = "";
    private boolean hasError;

    public final boolean getHasError() {
        return this.hasError;
    }

    public final void setHasError(boolean z) {
        this.hasError = z;
    }

    public final String getErrorText() {
        return this.errorText;
    }

    public final void setErrorText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorText = str;
    }
}
