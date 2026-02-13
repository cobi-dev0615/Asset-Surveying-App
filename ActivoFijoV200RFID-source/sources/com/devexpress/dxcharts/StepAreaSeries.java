package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StepAreaSeries extends AreaSeries {
    @Override // com.devexpress.dxcharts.AreaSeriesBase, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native boolean nativeGetInvertedStep();

    native void nativeSetInvertedStep(boolean z);

    public boolean isInvertedStep() {
        return nativeGetInvertedStep();
    }

    public void setInvertedStep(boolean z) {
        nativeSetInvertedStep(z);
    }
}
