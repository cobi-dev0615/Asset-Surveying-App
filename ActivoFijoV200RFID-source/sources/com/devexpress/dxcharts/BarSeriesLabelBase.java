package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class BarSeriesLabelBase extends SeriesLabel {
    private BarSeriesLabelBehavior mBehavior;

    native void nativeSetBehavior(int i, long j);

    public BarSeriesLabelBehavior getBehavior() {
        return this.mBehavior;
    }

    public void setBehavior(BarSeriesLabelBehavior barSeriesLabelBehavior) {
        if (barSeriesLabelBehavior == null || this.mBehavior == barSeriesLabelBehavior) {
            return;
        }
        this.mBehavior = barSeriesLabelBehavior;
        nativeSetBehavior(barSeriesLabelBehavior.ordinal(), getNativeLabel());
    }

    public SeriesLabelStyle getStyle() {
        return (SeriesLabelStyle) getUserStyleFromContainer(SeriesLabelStyle.class);
    }

    public void setStyle(SeriesLabelStyle seriesLabelStyle) {
        trySetStyle(seriesLabelStyle);
    }
}
