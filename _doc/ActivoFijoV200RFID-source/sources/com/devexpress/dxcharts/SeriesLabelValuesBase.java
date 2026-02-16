package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class SeriesLabelValuesBase {
    private int[] pointIndexes;
    private String seriesName;

    SeriesLabelValuesBase(String str, int[] iArr) {
        this.seriesName = str;
        this.pointIndexes = iArr;
    }

    public String getSeriesName() {
        return this.seriesName;
    }

    public int[] getPointIndexes() {
        return this.pointIndexes;
    }
}
