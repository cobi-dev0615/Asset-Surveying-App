package com.devexpress.dxcharts;

import com.devexpress.dxcharts.StripBase;
import java.util.Date;

/* loaded from: classes.dex */
public class DateTimeStrip extends StripBase {
    private Date mMaxLimit;
    private Date mMinLimit;

    public DateTimeStrip() {
    }

    public DateTimeStrip(Date date, Date date2) {
        setMinLimit(date);
        setMaxLimit(date2);
    }

    public Date getMinLimit() {
        return this.mMinLimit;
    }

    public void setMinLimit(Date date) {
        if (date == null) {
            setMinLimitEnabled(false);
        }
        if (CompareHelper.areNotEquals(this.mMinLimit, date)) {
            this.mMinLimit = date;
            notifyListeners(StripBase.Property.MIN_LIMIT);
        }
    }

    public Date getMaxLimit() {
        return this.mMaxLimit;
    }

    public void setMaxLimit(Date date) {
        if (date == null) {
            setMaxLimitEnabled(false);
        }
        if (CompareHelper.areNotEquals(this.mMaxLimit, date)) {
            this.mMaxLimit = date;
            notifyListeners(StripBase.Property.MAX_LIMIT);
        }
    }
}
