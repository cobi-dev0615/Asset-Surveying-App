package com.google.crypto.tink.internal;

import android.os.Build;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class BuildDispatchedCode {
    private BuildDispatchedCode() {
    }

    @Nullable
    public static Integer getApiLevel() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
