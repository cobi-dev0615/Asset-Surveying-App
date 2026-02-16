package com.devexpress.editors.utils;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannableUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"appendSpan", "", "Landroid/text/Editable;", "charSequence", "", "what", "", "flags", "", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpannableUtilsKt {
    public static final void appendSpan(Editable editable, CharSequence charSequence, Object what, int i) {
        Intrinsics.checkNotNullParameter(editable, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(what, "what");
        int length = editable.length();
        editable.append(charSequence);
        editable.setSpan(what, length, editable.length(), i);
    }
}
