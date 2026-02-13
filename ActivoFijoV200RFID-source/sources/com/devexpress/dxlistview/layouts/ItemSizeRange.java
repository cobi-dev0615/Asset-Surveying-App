package com.devexpress.dxlistview.layouts;

/* loaded from: classes2.dex */
public final class ItemSizeRange {
    public final int maxValue;
    public final int minValue;

    public static ItemSizeRange create(int i, int i2, int i3) {
        return i < 0 ? new ItemSizeRange(i2, i3) : new ItemSizeRange(i, i);
    }

    ItemSizeRange(int i, int i2) {
        this.minValue = i;
        this.maxValue = i2;
    }
}
