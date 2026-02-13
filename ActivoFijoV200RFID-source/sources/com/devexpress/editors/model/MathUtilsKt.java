package com.devexpress.editors.model;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MathUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001e\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\b*\u00020\n\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Epsilon", "", "clamp", "v", "min", "max", "", "isNotZero", "", "isZero", "Landroid/graphics/Rect;", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MathUtilsKt {
    public static final float Epsilon = 1.0E-7f;

    public static final boolean isZero(float f) {
        return Math.abs(f) < 1.0E-7f;
    }

    public static final boolean isNotZero(float f) {
        return Math.abs(f) >= 1.0E-7f;
    }

    public static final boolean isZero(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0;
    }

    public static final int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static final float clamp(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }
}
