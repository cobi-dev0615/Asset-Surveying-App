package com.devexpress.editors.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006\u001a&\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a&\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u001a\f\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\n\u001a\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0086\u0004\u001a\u0012\u0010\u000e\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¨\u0006\u0011"}, d2 = {"max3", "", "a", "b", "c", "", "", "max4", "d", "copy", "", "has", "", "flag", "intersects", "Lkotlin/ranges/IntRange;", "other", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UtilsKt {
    public static final boolean has(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final CharSequence copy(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final boolean intersects(IntRange intRange, IntRange other) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return intRange.contains(other.getFirst()) || intRange.contains(other.getLast()) || other.contains(intRange.getFirst()) || other.contains(intRange.getLast());
    }

    public static final int max3(int i, int i2, int i3) {
        return Math.max(i, Math.max(i2, i3));
    }

    public static final float max3(float f, float f2, float f3) {
        return Math.max(f, Math.max(f2, f3));
    }

    public static final double max3(double d, double d2, double d3) {
        return Math.max(d, Math.max(d2, d3));
    }

    public static final int max4(int i, int i2, int i3, int i4) {
        return Math.max(i, max3(i2, i3, i4));
    }

    public static final float max4(float f, float f2, float f3, float f4) {
        return Math.max(f, max3(f2, f3, f4));
    }

    public static final double max4(double d, double d2, double d3, double d4) {
        return Math.max(d, max3(d2, d3, d4));
    }
}
