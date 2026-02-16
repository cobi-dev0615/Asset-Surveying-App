package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class DateTimeLabelFormat {
    private String format;
    private DateTimeMeasureUnit measureUnit;

    public DateTimeLabelFormat(DateTimeMeasureUnit dateTimeMeasureUnit, String str) {
        this.measureUnit = dateTimeMeasureUnit;
        this.format = str;
    }

    public DateTimeMeasureUnit getMeasureUnit() {
        return this.measureUnit;
    }

    public String getFormat() {
        return this.format;
    }
}
