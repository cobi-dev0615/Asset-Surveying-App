package com.devexpress.dxcharts;

/* compiled from: AxisBase.java */
/* loaded from: classes.dex */
class QualitativeAxisLabelTextProvider extends AxisLabelTextProvider {
    QualitativeAxisLabelTextProvider(AxisBase axisBase) {
        super(axisBase);
    }

    public String getLabelText(String str) {
        AxisLabelTextFormatter customFormatter = getCustomFormatter();
        if (customFormatter != null) {
            str = customFormatter.format(str);
        }
        return str != null ? str : "";
    }
}
