package com.devexpress.editors.dataForm.protocols;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFormValuesValidationErrors.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DataFormValuesValidationErrors;", "", "()V", "errors", "", "", "getErrors", "()Ljava/util/Map;", "setErrors", "(Ljava/util/Map;)V", "hasErrors", "", "getHasErrors", "()Z", "setHasErrors", "(Z)V", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DataFormValuesValidationErrors {
    private Map<String, String> errors = new HashMap();
    private boolean hasErrors;

    public final boolean getHasErrors() {
        return this.hasErrors;
    }

    public final void setHasErrors(boolean z) {
        this.hasErrors = z;
    }

    public final Map<String, String> getErrors() {
        return this.errors;
    }

    public final void setErrors(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.errors = map;
    }
}
