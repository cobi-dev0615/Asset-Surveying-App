package com.devexpress.dxcharts;

/* compiled from: AxisBase.java */
/* loaded from: classes.dex */
class NumericAxisLabelTextProvider extends AxisLabelTextProvider {
    NumericAxisLabelTextProvider(AxisBase axisBase) {
        super(axisBase);
    }

    public String getLabelText(double d, String str) {
        String formatDecimal;
        AxisLabelTextFormatter customFormatter = getCustomFormatter();
        if (customFormatter != null) {
            formatDecimal = customFormatter.format(Double.valueOf(d));
        } else {
            formatDecimal = FormatHelper.formatDecimal(d, str);
        }
        return formatDecimal != null ? formatDecimal : "";
    }
}
