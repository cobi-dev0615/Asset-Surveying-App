package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SplineSeries extends LineSeries {
    @Override // com.devexpress.dxcharts.LineSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native double nativeGetLineTension();

    native void nativeSetLineTension(double d);

    public double getLineTension() {
        return nativeGetLineTension();
    }

    public void setLineTension(double d) {
        nativeSetLineTension(d);
    }
}
