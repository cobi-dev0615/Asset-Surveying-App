package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StepLineSeries extends LineSeries {
    @Override // com.devexpress.dxcharts.LineSeries, com.devexpress.dxcharts.SeriesBase
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
