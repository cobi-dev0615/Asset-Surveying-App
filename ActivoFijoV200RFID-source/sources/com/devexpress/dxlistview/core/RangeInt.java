package com.devexpress.dxlistview.core;

/* loaded from: classes2.dex */
public final class RangeInt {
    private final int max;
    private final int min;

    public RangeInt(int i, int i2) {
        this.min = Math.min(i, i2);
        this.max = Math.max(i, i2);
    }

    int getMin() {
        return this.min;
    }

    int getMax() {
        return this.max;
    }

    boolean inRange(int i) {
        return i >= this.min && i <= this.max;
    }
}
