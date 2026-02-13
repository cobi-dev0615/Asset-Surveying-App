package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class GradientPointBasedStackedSegmentColorizer extends ChartElement implements StackedSegmentColorizer {
    private StackedPointColorizerHolder colorizerHolder = new StackedPointColorizerHolder();

    enum Property {
        POINT_COLORIZER
    }

    public StackedPointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(StackedPointColorizer stackedPointColorizer) {
        if (this.colorizerHolder.getColorizer() != stackedPointColorizer) {
            this.colorizerHolder.setColorizer(stackedPointColorizer);
            notifyListeners(Property.POINT_COLORIZER);
        }
    }

    long getNativeColorizer() {
        if (this.colorizerHolder.getColorizer() == null) {
            return 0L;
        }
        return this.colorizerHolder.getNativeColorizer();
    }
}
