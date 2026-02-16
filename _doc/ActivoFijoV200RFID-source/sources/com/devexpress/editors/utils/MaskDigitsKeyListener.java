package com.devexpress.editors.utils;

import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskDigitsKeyListener.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B%\b\u0017\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/utils/MaskDigitsKeyListener;", "Landroid/text/method/DigitsKeyListener;", "sign", "", "decimal", "(ZZ)V", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;ZZ)V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MaskDigitsKeyListener extends DigitsKeyListener {
    @Deprecated(message = "Use the constructor with a locale if on SDK 26+.")
    public MaskDigitsKeyListener(boolean z, boolean z2) {
        super(z, z2);
    }

    public /* synthetic */ MaskDigitsKeyListener(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public MaskDigitsKeyListener(Locale locale, boolean z, boolean z2) {
        super(locale, z, z2);
    }

    public /* synthetic */ MaskDigitsKeyListener(Locale locale, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }

    @Override // android.text.method.DigitsKeyListener, android.text.method.NumberKeyListener, android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        StringBuilder sb = new StringBuilder();
        char[] acceptedChars = getAcceptedChars();
        Intrinsics.checkNotNullExpressionValue(acceptedChars, "getAcceptedChars(...)");
        for (int i = 0; i < source.length(); i++) {
            char charAt = source.charAt(i);
            if (ArraysKt.contains(acceptedChars, charAt)) {
                sb.append(charAt);
            }
        }
        return sb;
    }
}
