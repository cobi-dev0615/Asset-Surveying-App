package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class PieSeriesLabelValues extends SeriesLabelValuesBase {
    private String label;
    private double value;
    private double valueInPercent;

    PieSeriesLabelValues(String str, int[] iArr, String str2, double d, double d2) {
        super(str, iArr);
        this.label = str2;
        this.value = d;
        this.valueInPercent = d2;
    }

    public String getLabel() {
        return this.label;
    }

    public double getValue() {
        return this.value;
    }

    public double getValueInPercent() {
        return this.valueInPercent;
    }
}
