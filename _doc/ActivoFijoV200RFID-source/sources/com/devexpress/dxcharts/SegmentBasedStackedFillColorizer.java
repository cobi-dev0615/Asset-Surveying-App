package com.devexpress.dxcharts;

import com.devexpress.dxcharts.SegmentBasedFillColorizer;

/* loaded from: classes.dex */
public class SegmentBasedStackedFillColorizer extends ChartElement implements StackedFillColorizer {
    private StackedSegmentColorizerHolder segmentColorizerHolder = new StackedSegmentColorizerHolder();

    enum Property {
        SEGMENT_COLORIZER
    }

    public StackedSegmentColorizer getSegmentColorizer() {
        return this.segmentColorizerHolder.getColorizer();
    }

    public void setSegmentColorizer(StackedSegmentColorizer stackedSegmentColorizer) {
        this.segmentColorizerHolder.setColorizer(stackedSegmentColorizer);
        notifyListeners(SegmentBasedFillColorizer.Property.SEGMENT_COLORIZER);
    }

    long getNativeSegmentColorizer() {
        if (this.segmentColorizerHolder.getColorizer() == null) {
            return 0L;
        }
        return this.segmentColorizerHolder.getNativeColorizer();
    }
}
