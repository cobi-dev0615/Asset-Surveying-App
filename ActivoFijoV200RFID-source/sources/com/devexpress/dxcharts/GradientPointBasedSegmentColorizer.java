package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class GradientPointBasedSegmentColorizer extends ChartElement implements SegmentColorizer {
    private PointColorizerHolder colorizerHolder = new PointColorizerHolder();

    enum Property {
        POINT_COLORIZER
    }

    public PointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(PointColorizer pointColorizer) {
        if (this.colorizerHolder.getColorizer() != pointColorizer) {
            this.colorizerHolder.setColorizer(pointColorizer);
            notifyListeners(Property.POINT_COLORIZER);
        }
    }

    long getNativePointColorizer() {
        if (this.colorizerHolder.getColorizer() == null) {
            return 0L;
        }
        return this.colorizerHolder.getNativeColorizer();
    }
}
