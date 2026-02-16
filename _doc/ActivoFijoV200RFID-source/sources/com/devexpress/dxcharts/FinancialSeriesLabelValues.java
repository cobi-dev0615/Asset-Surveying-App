package com.devexpress.dxcharts;

import java.util.Date;

/* loaded from: classes.dex */
public class FinancialSeriesLabelValues extends SeriesLabelValuesBase {
    private Date argument;
    private double closeValue;
    private double highValue;
    private double lowValue;
    private double openValue;

    FinancialSeriesLabelValues(String str, int[] iArr, Date date, double d, double d2, double d3, double d4) {
        super(str, iArr);
        this.argument = date;
        this.highValue = d;
        this.lowValue = d2;
        this.openValue = d3;
        this.closeValue = d4;
    }

    public Date getArgument() {
        return this.argument;
    }

    public double getHighValue() {
        return this.highValue;
    }

    public double getLowValue() {
        return this.lowValue;
    }

    public double getOpenValue() {
        return this.openValue;
    }

    public double getCloseValue() {
        return this.closeValue;
    }
}
