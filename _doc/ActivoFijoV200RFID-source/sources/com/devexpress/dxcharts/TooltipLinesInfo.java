package com.devexpress.dxcharts;

/* compiled from: OverlayInfo.java */
/* loaded from: classes.dex */
class TooltipLinesInfo {
    private double mArgumentLineValue;
    private double[] mPointLineValues;

    TooltipLinesInfo(double d, double[] dArr) {
        this.mArgumentLineValue = d;
        this.mPointLineValues = dArr;
    }

    double getArgumentLineValue() {
        return this.mArgumentLineValue;
    }

    double[] getPointLineValues() {
        return this.mPointLineValues;
    }
}
