package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class RangeBarSeriesLabel extends BarSeriesLabelBase {
    private RangeBarSeriesLabelPosition mPosition = getDefaultPosition();
    private RangeSeriesLabelKind mKind = getDefaultKind();

    boolean isValidKind(RangeSeriesLabelKind rangeSeriesLabelKind) {
        return true;
    }

    boolean isValidPosition(RangeBarSeriesLabelPosition rangeBarSeriesLabelPosition) {
        return true;
    }

    @Override // com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    native void nativeSetKind(int i, long j);

    native void nativeSetPosition(int i, long j);

    RangeBarSeriesLabelPosition getDefaultPosition() {
        return RangeBarSeriesLabelPosition.OUTSIDE;
    }

    RangeSeriesLabelKind getDefaultKind() {
        return RangeSeriesLabelKind.TWO_LABELS;
    }

    public RangeBarSeriesLabelPosition getPosition() {
        return this.mPosition;
    }

    public void setPosition(RangeBarSeriesLabelPosition rangeBarSeriesLabelPosition) {
        RangeBarSeriesLabelPosition defaultPosition = isValidPosition(rangeBarSeriesLabelPosition) ? rangeBarSeriesLabelPosition : getDefaultPosition();
        if (rangeBarSeriesLabelPosition == null || this.mPosition == defaultPosition) {
            return;
        }
        this.mPosition = defaultPosition;
        nativeSetPosition(rangeBarSeriesLabelPosition.ordinal(), getNativeLabel());
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
}
