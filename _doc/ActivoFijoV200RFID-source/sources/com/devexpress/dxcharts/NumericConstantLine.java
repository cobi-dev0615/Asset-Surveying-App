package com.devexpress.dxcharts;

import com.devexpress.dxcharts.ConstantLineBase;

/* loaded from: classes.dex */
public class NumericConstantLine extends ConstantLineBase {
    private double mAxisValue;

    public NumericConstantLine() {
        this.mAxisValue = 1.0d;
    }

    public NumericConstantLine(double d) {
        this.mAxisValue = d;
    }

    public double getAxisValue() {
        return this.mAxisValue;
    }

    public void setAxisValue(double d) {
        if (this.mAxisValue != d) {
            this.mAxisValue = d;
            notifyListeners(ConstantLineBase.Property.AXIS_VALUE);
        }
    }
}
