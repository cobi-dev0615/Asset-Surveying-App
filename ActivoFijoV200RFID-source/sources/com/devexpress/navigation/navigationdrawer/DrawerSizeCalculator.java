package com.devexpress.navigation.navigationdrawer;

import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.models.TabSizeInPixels;
import com.devexpress.navigation.tabs.utils.SizeConverter;

/* loaded from: classes2.dex */
public class DrawerSizeCalculator {
    private SizeConverter mSizeConverter;
    private TabSize mSizeDp;
    private TabSizeInPixels mSizePx;

    public DrawerSizeCalculator(SizeConverter sizeConverter, TabSize tabSize) {
        this.mSizeConverter = sizeConverter;
        setSize(tabSize);
    }

    public void setSize(TabSize tabSize) {
        this.mSizeDp = tabSize;
        this.mSizePx = this.mSizeConverter.convertSize(tabSize);
    }

    public int calculateSize(int i, int i2) {
        int size = this.mSizePx.getSize();
        if (!this.mSizePx.getIsAuto()) {
            i = this.mSizePx.getIsStar() ? (int) (i2 * this.mSizeDp.getSize()) : size;
        }
        return correctItemSize(i, this.mSizePx.getMinSize(), this.mSizePx.getMaxSize(), i2);
    }

    public int calculateMaxSize(int i) {
        return calculateSize(i, i);
    }

    public static int correctItemSize(int i, int i2, int i3, int i4) {
        int max = Math.max(0, i4);
        int min = Math.min(i2, max);
        if (i3 > 0) {
            max = Math.min(i3, max);
        }
        return correctItemSize(i, min, max);
    }

    public static int correctItemSize(int i, int i2, int i3) {
        int max = Math.max(i2, 0);
        if (i3 < max) {
            i3 = -1;
        }
        return (max <= 0 || i >= max) ? (i3 <= 0 || i3 < max || i <= i3) ? Math.max(0, i) : i3 : max;
    }
}
