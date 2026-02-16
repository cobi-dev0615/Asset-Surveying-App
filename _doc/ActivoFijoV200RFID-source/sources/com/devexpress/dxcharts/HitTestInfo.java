package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class HitTestInfo extends SeriesPointInfo {
    private final boolean inLegend;

    HitTestInfo(int i, int[] iArr, boolean z) {
        super(i, iArr);
        this.inLegend = z;
    }

    public boolean isInSeries() {
        return getSeriesIndex() >= 0;
    }

    public boolean isInPoint() {
        return getDataPointIndices().length > 0;
    }

    public boolean isInLegend() {
        return this.inLegend;
    }
}
