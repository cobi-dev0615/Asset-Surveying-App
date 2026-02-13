package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StackedSeriesLabelValues extends SeriesLabelValues {
    private double valueInPercent;

    StackedSeriesLabelValues(String str, int[] iArr, Object obj, double d, double d2) {
        super(str, iArr, obj, d);
        this.valueInPercent = d2;
    }

    public double getValueInPercent() {
        return this.valueInPercent;
    }
}
