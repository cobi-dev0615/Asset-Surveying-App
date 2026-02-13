package com.devexpress.editors.utils;

import kotlin.Metadata;

/* compiled from: KeyCodeUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"isConfirmKeyCode", "", "keyCode", "", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KeyCodeUtilsKt {
    public static final boolean isConfirmKeyCode(int i) {
        return i == 23 || i == 62 || i == 66 || i == 160;
    }
}
