package com.devexpress.dxcharts;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Legend.java */
/* loaded from: classes.dex */
final class LegendLayoutCalculator {
    private final List<Point> mItemsLayouts;
    private final Size mMeasurementSize;

    native int[] nativeCalculate(int[] iArr, int[] iArr2, boolean z, int[] iArr3, int[] iArr4);

    public LegendLayoutCalculator(boolean z, int i, int i2, int i3, int i4, Size size, List<TextSize> list) {
        int[] iArr = new int[list.size() * 2];
        for (int i5 = 0; i5 < list.size(); i5++) {
            int i6 = i5 * 2;
            iArr[i6] = ((int) list.get(i5).getWidth()) + i + i2;
            iArr[i6 + 1] = (int) list.get(i5).getHeight();
        }
        int size2 = list.size() * 2;
        int[] iArr2 = new int[size2];
        int[] nativeCalculate = nativeCalculate(new int[]{size.getWidth(), size.getWidth()}, new int[]{i3, i4}, z, iArr, iArr2);
        if (nativeCalculate.length == 2) {
            this.mMeasurementSize = new Size(nativeCalculate[0], nativeCalculate[1]);
        } else {
            this.mMeasurementSize = new Size(0, 0);
        }
        this.mItemsLayouts = new ArrayList(list.size());
        if (size2 == list.size() * 2) {
            for (int i7 = 0; i7 < list.size(); i7++) {
                int i8 = i7 * 2;
                this.mItemsLayouts.add(new Point(iArr2[i8], iArr2[i8 + 1]));
            }
        }
    }

    public Size getMeasurementSize() {
        return this.mMeasurementSize;
    }

    public List<Point> getItemsLocations() {
        return this.mItemsLayouts;
    }
}
