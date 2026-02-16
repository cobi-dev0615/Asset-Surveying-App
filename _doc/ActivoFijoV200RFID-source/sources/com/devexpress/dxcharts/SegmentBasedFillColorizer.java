package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SegmentBasedFillColorizer extends ChartElement implements FillColorizer {
    private SegmentColorizerHolder segmentColorizerHolder = new SegmentColorizerHolder();

    enum Property {
        SEGMENT_COLORIZER
    }

    public SegmentColorizer getSegmentColorizer() {
        return this.segmentColorizerHolder.getColorizer();
    }

    public void setSegmentColorizer(SegmentColorizer segmentColorizer) {
        this.segmentColorizerHolder.setColorizer(segmentColorizer);
        notifyListeners(Property.SEGMENT_COLORIZER);
    }

    long getNativeSegmentColorizer() {
        if (this.segmentColorizerHolder.getColorizer() == null) {
            return 0L;
        }
        return this.segmentColorizerHolder.getNativeColorizer();
    }
}
