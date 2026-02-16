package com.devexpress.dxcharts;

import com.devexpress.dxcharts.RangeBase;
import java.util.Date;

/* loaded from: classes.dex */
public class DateTimeRange extends RangeBase {
    private Date max;
    private Date min;
    private Date visualMax;
    private Date visualMin;

    public DateTimeRange() {
    }

    public DateTimeRange(Date date, Date date2) {
        setUpdatesEnabled(false);
        setMin(date);
        setMax(date2);
        setUpdatesEnabled(true);
    }

    @Override // com.devexpress.dxcharts.RangeBase
    void resetWholeMinMaxValues() {
        this.min = null;
        this.max = null;
    }

    @Override // com.devexpress.dxcharts.RangeBase
    void resetVisualMinMaxValues() {
        this.visualMax = null;
        this.visualMin = null;
    }

    public Date getMin() {
        return this.min;
    }

    public void setMin(Date date) {
        if (date == null) {
            resetRange();
            return;
        }
        if (isDefaultWholeMin() || this.min != date) {
            this.min = date;
            if (canUpdateWholeMin()) {
                notifyListeners(RangeBase.Property.WHOLE_RANGE);
            }
        }
    }

    public Date getMax() {
        return this.max;
    }

    public void setMax(Date date) {
        if (date == null) {
            resetRange();
            return;
        }
        if (isDefaultWholeMax() || this.max != date) {
            this.max = date;
            if (canUpdateWholeMax()) {
                notifyListeners(RangeBase.Property.WHOLE_RANGE);
            }
        }
    }

    public Date getVisualMin() {
        return this.visualMin;
    }

    public void setVisualMin(Date date) {
        if (date == null) {
            resetVisualRange();
            return;
        }
        if (isDefaultVisualMin() || this.visualMin != date) {
            this.visualMin = date;
            if (canUpdateVisualMin()) {
                notifyListeners(RangeBase.Property.VISUAL_RANGE);
            }
        }
    }

    public Date getVisualMax() {
        return this.visualMax;
    }

    public void setVisualMax(Date date) {
        if (date == null) {
            resetVisualRange();
            return;
        }
        if (isDefaultVisualMax() || this.visualMax != date) {
            this.visualMax = date;
            if (canUpdateVisualMax()) {
                notifyListeners(RangeBase.Property.VISUAL_RANGE);
            }
        }
    }
}
