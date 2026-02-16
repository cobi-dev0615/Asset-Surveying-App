package com.devexpress.dxcharts;

import java.util.Date;

/* compiled from: AxisBase.java */
/* loaded from: classes.dex */
class DateTimeAxisLabelTextProvider extends AxisLabelTextProvider {
    DateTimeAxisLabelTextProvider(AxisBase axisBase) {
        super(axisBase);
    }

    public String getLabelText(double d, String str) {
        AxisLabelTextFormatter customFormatter = getCustomFormatter();
        Date date = new Date((long) (d * 1000.0d));
        String format = customFormatter != null ? customFormatter.format(date) : FormatHelper.formatDate(date, str);
        return format != null ? format : "";
    }

    String getDefaultDateFormat(int i) {
        return FormatHelper.getDefaultDateFormat(i);
    }
}
