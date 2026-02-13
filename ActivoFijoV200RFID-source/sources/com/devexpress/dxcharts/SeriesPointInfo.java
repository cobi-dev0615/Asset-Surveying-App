package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SeriesPointInfo {
    private int[] dataPointIndices;
    private int seriesIndex;

    SeriesPointInfo(int i, int[] iArr) {
        this.seriesIndex = i;
        this.dataPointIndices = iArr;
    }

    public int getSeriesIndex() {
        return this.seriesIndex;
    }

    public int[] getDataPointIndices() {
        return this.dataPointIndices;
    }
}
