package com.devexpress.dxcharts;

import java.util.Date;

/* loaded from: classes.dex */
public class ColoredPointInfo extends ColoredPointInfoBase {
    private Date dateTimeArgument;
    private double numericArgument;
    private String qualitativeArgument;
    private double value;

    public ColoredPointInfo(int[] iArr, double d, double d2, String str, double d3) {
        super(iArr);
        this.numericArgument = d;
        this.dateTimeArgument = new Date((long) (d2 * 1000.0d));
        this.qualitativeArgument = str;
        this.value = d3;
    }

    public double getNumericArgument() {
        return this.numericArgument;
    }

    public Date getDateTimeArgument() {
        return this.dateTimeArgument;
    }

    public String getQualitativeArgument() {
        return this.qualitativeArgument;
    }

    public double getValue() {
        return this.value;
    }
}
