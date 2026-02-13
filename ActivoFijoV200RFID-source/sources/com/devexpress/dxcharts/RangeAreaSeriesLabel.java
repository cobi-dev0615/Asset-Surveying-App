package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class RangeAreaSeriesLabel extends SeriesLabel {
    private RangeSeriesLabelKind mKind = getDefaultKind();

    boolean isValidKind(RangeSeriesLabelKind rangeSeriesLabelKind) {
        return true;
    }

    @Override // com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    native float nativeGetHighValueAngle(long j);

    native float nativeGetLowValueAngle(long j);

    native void nativeSetHighValueAngle(float f, long j);

    native void nativeSetKind(int i, long j);

    native void nativeSetLowValueAngle(float f, long j);

    RangeSeriesLabelKind getDefaultKind() {
        return RangeSeriesLabelKind.TWO_LABELS;
    }

    public RangeSeriesLabelKind getKind() {
        return this.mKind;
    }

    public void setKind(RangeSeriesLabelKind rangeSeriesLabelKind) {
        RangeSeriesLabelKind defaultKind = isValidKind(rangeSeriesLabelKind) ? rangeSeriesLabelKind : getDefaultKind();
        if (rangeSeriesLabelKind == null || this.mKind == defaultKind) {
            return;
        }
        this.mKind = defaultKind;
        nativeSetKind(rangeSeriesLabelKind.ordinal(), getNativeLabel());
    }

    public float getHighValueAngle() {
        return nativeGetHighValueAngle(getNativeLabel());
    }

    public void setHighValueAngle(float f) {
        nativeSetHighValueAngle(f, getNativeLabel());
    }

    public float getLowValueAngle() {
        return nativeGetLowValueAngle(getNativeLabel());
    }

    public void setLowValueAngle(float f) {
        nativeSetLowValueAngle(f, getNativeLabel());
    }

    public SeriesLabelStyle getStyle() {
        return (SeriesLabelStyle) getUserStyleFromContainer(SeriesLabelStyle.class);
    }

    public void setStyle(SeriesLabelStyle seriesLabelStyle) {
        trySetStyle(seriesLabelStyle);
    }
}
