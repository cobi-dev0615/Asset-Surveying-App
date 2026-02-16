package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class ColorEachPointColorizer extends ChartElement implements PointColorizer, RangePointColorizer, StackedPointColorizer, WeightedPointColorizer {
    private int[] palette = null;

    enum Property {
        PALETTE
    }

    public int[] getPalette() {
        return this.palette;
    }

    public void setPalette(int[] iArr) {
        this.palette = iArr;
        notifyListeners(Property.PALETTE);
    }
}
