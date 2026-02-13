package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class ColoredStackedPointInfo extends ColoredPointInfo {
    private double stackedValue;
    private double valueInPercent;

    public ColoredStackedPointInfo(int[] iArr, double d, double d2, String str, double d3, double d4, double d5) {
        super(iArr, d, d2, str, d3);
        this.stackedValue = d4;
        this.valueInPercent = d5;
    }

    public double getStackedValue() {
        return this.stackedValue;
    }

    public double getValueInPercent() {
        return this.valueInPercent;
    }
}
