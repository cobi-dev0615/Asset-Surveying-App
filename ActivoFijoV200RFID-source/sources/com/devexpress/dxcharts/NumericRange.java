package com.devexpress.dxcharts;

import androidx.camera.video.AudioStats;
import com.devexpress.dxcharts.RangeBase;

/* loaded from: classes.dex */
public class NumericRange extends RangeBase {
    private double max;
    private double min;
    private double visualMax;
    private double visualMin;

    public NumericRange() {
    }

    public NumericRange(double d, double d2) {
        setUpdatesEnabled(false);
        setMin(d);
        setMax(d2);
        setUpdatesEnabled(true);
    }

    @Override // com.devexpress.dxcharts.RangeBase
    void resetWholeMinMaxValues() {
        this.min = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.max = 1.0d;
    }

    @Override // com.devexpress.dxcharts.RangeBase
    void resetVisualMinMaxValues() {
        this.visualMax = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.visualMin = 1.0d;
    }

    public double getMin() {
        return this.min;
    }

    public void setMin(double d) {
        if (isDefaultWholeMin() || this.min != d) {
            this.min = d;
            if (canUpdateWholeMin()) {
                notifyListeners(RangeBase.Property.WHOLE_RANGE);
            }
        }
    }

    public double getMax() {
        return this.max;
    }

    public void setMax(double d) {
        if (isDefaultWholeMax() || this.max != d) {
            this.max = d;
            if (canUpdateWholeMax()) {
                notifyListeners(RangeBase.Property.WHOLE_RANGE);
            }
        }
    }

    public double getVisualMin() {
        return this.visualMin;
    }

    public void setVisualMin(double d) {
        if (isDefaultVisualMin() || this.visualMin != d) {
            this.visualMin = d;
            if (canUpdateVisualMin()) {
                notifyListeners(RangeBase.Property.VISUAL_RANGE);
            }
        }
    }

    public double getVisualMax() {
        return this.visualMax;
    }

    public void setVisualMax(double d) {
        if (isDefaultVisualMax() || this.visualMax != d) {
            this.visualMax = d;
            if (canUpdateVisualMax()) {
                notifyListeners(RangeBase.Property.VISUAL_RANGE);
            }
        }
    }
}
