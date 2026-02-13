package com.devexpress.dxcharts;

import java.util.Date;

/* loaded from: classes.dex */
public class ColoredRangePointInfo extends ColoredPointInfoBase {
    private double argument;
    private Date dateTimeArgument;
    private double highValue;
    private double lowValue;
    private String qualitativeArgument;

    public ColoredRangePointInfo(int[] iArr, double d, double d2, String str, double d3, double d4) {
        super(iArr);
        this.argument = d;
        this.dateTimeArgument = new Date(((long) d2) * 1000);
        this.qualitativeArgument = str;
        this.lowValue = d3;
        this.highValue = d4;
    }

    public double getArgument() {
        return this.argument;
    }

    public Date getDateTimeArgument() {
        return this.dateTimeArgument;
    }

    public String getQualitativeArgument() {
        return this.qualitativeArgument;
    }

    public double getLowValue() {
        return this.lowValue;
    }

    public double getHighValue() {
        return this.highValue;
    }
}
