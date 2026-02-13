package com.devexpress.dxcharts;

import com.devexpress.dxcharts.ConstantLineBase;
import java.util.Date;

/* loaded from: classes.dex */
public class DateTimeConstantLine extends ConstantLineBase {
    private Date mAxisValue;

    public DateTimeConstantLine() {
    }

    public DateTimeConstantLine(Date date) {
        this.mAxisValue = date;
    }

    public Date getAxisValue() {
        return this.mAxisValue;
    }

    public void setAxisValue(Date date) {
        if (CompareHelper.areNotEquals(this.mAxisValue, date)) {
            this.mAxisValue = date;
            notifyListeners(ConstantLineBase.Property.AXIS_VALUE);
        }
    }
}
