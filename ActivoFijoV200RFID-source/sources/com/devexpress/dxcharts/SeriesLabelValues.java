package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SeriesLabelValues extends SeriesLabelValuesBase {
    private Object argument;
    private double value;

    SeriesLabelValues(String str, int[] iArr, Object obj, double d) {
        super(str, iArr);
        this.argument = obj;
        this.value = d;
    }

    public Object getArgument() {
        return this.argument;
    }

    public double getValue() {
        return this.value;
    }
}
