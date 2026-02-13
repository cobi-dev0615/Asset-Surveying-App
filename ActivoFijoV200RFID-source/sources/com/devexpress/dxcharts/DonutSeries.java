package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class DonutSeries extends PieSeries {
    @Override // com.devexpress.dxcharts.PieSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    public float getHoleRadius() {
        return nativeGetHoleRadius();
    }

    public void setHoleRadius(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("radius");
        }
        nativeSetHoleRadius(f);
    }
}
