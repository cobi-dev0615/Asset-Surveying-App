package com.devexpress.dxcharts;

import com.devexpress.dxcharts.StripBase;

/* loaded from: classes.dex */
public class QualitativeStrip extends StripBase {
    private String mMaxLimit;
    private String mMinLimit;

    public QualitativeStrip() {
    }

    public QualitativeStrip(String str, String str2) {
        setMinLimit(str);
        setMaxLimit(str2);
    }

    public String getMinLimit() {
        return this.mMinLimit;
    }

    public void setMinLimit(String str) {
        if (str == null) {
            setMinLimitEnabled(false);
        }
        if (CompareHelper.areNotEquals(this.mMinLimit, str)) {
            this.mMinLimit = str;
            notifyListeners(StripBase.Property.MIN_LIMIT);
        }
    }

    public String getMaxLimit() {
        return this.mMaxLimit;
    }

    public void setMaxLimit(String str) {
        if (str == null) {
            setMaxLimitEnabled(false);
        }
        if (CompareHelper.areNotEquals(this.mMaxLimit, str)) {
            this.mMaxLimit = str;
            notifyListeners(StripBase.Property.MAX_LIMIT);
        }
    }
}
