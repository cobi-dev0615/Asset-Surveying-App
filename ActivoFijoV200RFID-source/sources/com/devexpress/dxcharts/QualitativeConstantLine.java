package com.devexpress.dxcharts;

import com.devexpress.dxcharts.ConstantLineBase;

/* loaded from: classes.dex */
public class QualitativeConstantLine extends ConstantLineBase {
    private String mAxisValue;

    public QualitativeConstantLine() {
    }

    public QualitativeConstantLine(String str) {
        this.mAxisValue = str;
    }

    public String getAxisValue() {
        return this.mAxisValue;
    }

    public void setAxisValue(String str) {
        if (CompareHelper.areNotEquals(this.mAxisValue, str)) {
            this.mAxisValue = str;
            notifyListeners(ConstantLineBase.Property.AXIS_VALUE);
        }
    }
}
