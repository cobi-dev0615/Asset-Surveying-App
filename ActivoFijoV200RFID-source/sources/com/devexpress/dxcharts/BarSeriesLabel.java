package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class BarSeriesLabel extends BarSeriesLabelBase {
    private BarSeriesLabelPosition mPosition = getDefaultPosition();

    boolean isValidPosition(BarSeriesLabelPosition barSeriesLabelPosition) {
        return true;
    }

    @Override // com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    native void nativeSetPosition(int i, long j);

    BarSeriesLabelPosition getDefaultPosition() {
        return BarSeriesLabelPosition.OUTSIDE;
    }

    public BarSeriesLabelPosition getPosition() {
        return this.mPosition;
    }

    public void setPosition(BarSeriesLabelPosition barSeriesLabelPosition) {
        BarSeriesLabelPosition defaultPosition = isValidPosition(barSeriesLabelPosition) ? barSeriesLabelPosition : getDefaultPosition();
        if (barSeriesLabelPosition == null || this.mPosition == defaultPosition) {
            return;
        }
        this.mPosition = defaultPosition;
        nativeSetPosition(barSeriesLabelPosition.ordinal(), getNativeLabel());
    }
}
