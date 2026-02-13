package com.devexpress.dxcharts;

import com.devexpress.dxcharts.RangeBase;

/* loaded from: classes.dex */
public class QualitativeRange extends RangeBase {
    private String max;
    private String min;
    private String visualMax;
    private String visualMin;

    public QualitativeRange() {
    }

    public QualitativeRange(String str, String str2) {
        setUpdatesEnabled(false);
        setMin(str);
        setMax(str2);
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

    public String getMin() {
        return this.min;
    }

    public void setMin(String str) {
        if (str == null) {
            resetRange();
            return;
        }
        if (isDefaultWholeMin() || CompareHelper.areNotEquals(this.min, str)) {
            this.min = str;
            if (canUpdateWholeMin()) {
                notifyListeners(RangeBase.Property.WHOLE_RANGE);
            }
        }
    }

    public String getMax() {
        return this.max;
    }

    public void setMax(String str) {
        if (str == null) {
            resetRange();
            return;
        }
        if (isDefaultWholeMax() || CompareHelper.areNotEquals(this.max, str)) {
            this.max = str;
            if (canUpdateWholeMax()) {
                notifyListeners(RangeBase.Property.WHOLE_RANGE);
            }
        }
    }

    public String getVisualMin() {
        return this.visualMin;
    }

    public void setVisualMin(String str) {
        if (str == null) {
            resetVisualRange();
            return;
        }
        if (isDefaultVisualMin() || CompareHelper.areNotEquals(this.visualMin, str)) {
            this.visualMin = str;
            if (canUpdateVisualMin()) {
                notifyListeners(RangeBase.Property.VISUAL_RANGE);
            }
        }
    }

    public String getVisualMax() {
        return this.visualMax;
    }

    public void setVisualMax(String str) {
        if (str == null) {
            resetVisualRange();
            return;
        }
        if (isDefaultVisualMax() || CompareHelper.areNotEquals(this.visualMax, str)) {
            this.visualMax = str;
            if (canUpdateVisualMax()) {
                notifyListeners(RangeBase.Property.VISUAL_RANGE);
            }
        }
    }
}
