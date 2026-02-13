package com.devexpress.dxcharts;

/* compiled from: AxisBase.java */
/* loaded from: classes.dex */
abstract class AxisLabelTextProvider implements IAxisLabelTextProvider {
    private AxisBase mAxis;

    AxisLabelTextProvider(AxisBase axisBase) {
        this.mAxis = axisBase;
    }

    AxisLabelTextFormatter getCustomFormatter() {
        AxisBase axisBase = this.mAxis;
        if (axisBase != null) {
            return axisBase.getLabelTextFormatter();
        }
        return null;
    }

    boolean hasCustomFormatter() {
        AxisBase axisBase = this.mAxis;
        return (axisBase == null || axisBase.getLabelTextFormatter() == null) ? false : true;
    }
}
