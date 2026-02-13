package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class RangeSeriesLabelValues extends SeriesLabelValuesBase {
    private Object argument;
    private double highValue;
    private LabelPosition labelPosition;
    private double lowValue;

    RangeSeriesLabelValues(String str, int[] iArr, Object obj, double d, double d2, LabelPosition labelPosition) {
        super(str, iArr);
        this.highValue = d;
        this.lowValue = d2;
        this.argument = obj;
        this.labelPosition = labelPosition;
    }

    public Object getArgument() {
        return this.argument;
    }

    public double getHighValue() {
        return this.highValue;
    }

    public double getLowValue() {
        return this.lowValue;
    }

    public LabelPosition getLabelPosition() {
        return this.labelPosition;
    }
}
