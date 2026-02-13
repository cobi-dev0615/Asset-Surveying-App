package com.devexpress.dxcharts;

import androidx.camera.video.AudioStats;
import com.devexpress.dxcharts.StripBase;

/* loaded from: classes.dex */
public class NumericStrip extends StripBase {
    private double mMinLimit = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double mMaxLimit = 1.0d;

    public NumericStrip() {
    }

    public NumericStrip(double d, double d2) {
        setMinLimit(d);
        setMaxLimit(d2);
    }

    public double getMinLimit() {
        return this.mMinLimit;
    }

    public void setMinLimit(double d) {
        if (this.mMinLimit != d) {
            this.mMinLimit = d;
            notifyListeners(StripBase.Property.MIN_LIMIT);
        }
    }

    public double getMaxLimit() {
        return this.mMaxLimit;
    }

    public void setMaxLimit(double d) {
        if (this.mMaxLimit != d) {
            this.mMaxLimit = d;
            notifyListeners(StripBase.Property.MAX_LIMIT);
        }
    }
}
