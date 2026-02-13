package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SideBySideStackedBarSeries extends StackedBarSeries {
    @Override // com.devexpress.dxcharts.StackedBarSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native int nativeGetStackedGroup();

    native void nativeSetStackedGroup(int i, long j);

    public int getStackedGroup() {
        return nativeGetStackedGroup();
    }

    public void setStackedGroup(int i) {
        nativeSetStackedGroup(i, getNativeSeries());
    }
}
