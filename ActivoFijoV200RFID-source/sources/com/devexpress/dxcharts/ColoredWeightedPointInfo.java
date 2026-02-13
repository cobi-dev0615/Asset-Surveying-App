package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class ColoredWeightedPointInfo extends ColoredPointInfo {
    private double weightPercent;

    public ColoredWeightedPointInfo(int[] iArr, double d, double d2, String str, double d3, double d4) {
        super(iArr, d, d2, str, d3);
        this.weightPercent = d4;
    }

    public double getWeightPercent() {
        return this.weightPercent;
    }
}
