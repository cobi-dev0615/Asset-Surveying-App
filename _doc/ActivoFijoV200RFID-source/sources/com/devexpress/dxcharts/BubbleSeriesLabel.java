package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class BubbleSeriesLabel extends MarkerSeriesLabel {
    @Override // com.devexpress.dxcharts.MarkerSeriesLabel, com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    native int nativeGetPosition(long j);

    native void nativeSetPosition(int i, long j);

    public BubbleSeriesLabelPosition getPosition() {
        return BubbleSeriesLabelPosition.values()[nativeGetPosition(getNativeLabel())];
    }

    public void setPosition(BubbleSeriesLabelPosition bubbleSeriesLabelPosition) {
        if (bubbleSeriesLabelPosition != null) {
            nativeSetPosition(bubbleSeriesLabelPosition.ordinal(), getNativeLabel());
        }
    }
}
