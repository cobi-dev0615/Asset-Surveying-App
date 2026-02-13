package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SegmentBasedRangeFillColorizer extends ChartElement implements RangeFillColorizer {
    private SegmentColorizerHolder segmentColorizerHolder1 = new SegmentColorizerHolder();
    private SegmentColorizerHolder segmentColorizerHolder2 = new SegmentColorizerHolder();

    enum Property {
        SEGMENT_COLORIZER1,
        SEGMENT_COLORIZER2
    }

    public SegmentColorizer getSegmentColorizer1() {
        return this.segmentColorizerHolder1.getColorizer();
    }

    public void setSegmentColorizer1(SegmentColorizer segmentColorizer) {
        this.segmentColorizerHolder1.setColorizer(segmentColorizer);
        notifyListeners(Property.SEGMENT_COLORIZER1);
    }

    public SegmentColorizer getSegmentColorizer2() {
        return this.segmentColorizerHolder2.getColorizer();
    }

    public void setSegmentColorizer2(SegmentColorizer segmentColorizer) {
        this.segmentColorizerHolder2.setColorizer(segmentColorizer);
        notifyListeners(Property.SEGMENT_COLORIZER2);
    }

    long getNativeSegmentColorizer1() {
        if (this.segmentColorizerHolder1.getColorizer() == null) {
            return 0L;
        }
        return this.segmentColorizerHolder1.getNativeColorizer();
    }

    long getNativeSegmentColorizer2() {
        if (this.segmentColorizerHolder2.getColorizer() == null) {
            return 0L;
        }
        return this.segmentColorizerHolder2.getNativeColorizer();
    }
}
