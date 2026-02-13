package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class MarkerSeriesLabel extends SeriesLabel {
    @Override // com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    native float nativeGetAngle(long j);

    native void nativeSetAngle(float f, long j);

    public float getAngle() {
        return nativeGetAngle(getNativeLabel());
    }

    public void setAngle(float f) {
        nativeSetAngle(f, getNativeLabel());
    }

    public SeriesLabelStyle getStyle() {
        return (SeriesLabelStyle) getUserStyleFromContainer(SeriesLabelStyle.class);
    }

    public void setStyle(SeriesLabelStyle seriesLabelStyle) {
        trySetStyle(seriesLabelStyle);
    }
}
