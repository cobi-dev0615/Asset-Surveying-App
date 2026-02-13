package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StackedAreaSeries extends AreaSeriesBase {
    private StackedPointColorizerHolder colorizerHolder = new StackedPointColorizerHolder();
    private StackedSegmentColorizerHolder segmentColorizerHolder = new StackedSegmentColorizerHolder();
    private StackedFillColorizerHolder fillColorizerHolder = new StackedFillColorizerHolder();

    @Override // com.devexpress.dxcharts.AreaSeriesBase, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetColorizer(long j);

    native void nativeSetFillColorizer(long j);

    native void nativeSetSegmentColorizer(long j);

    @Override // com.devexpress.dxcharts.Series, com.devexpress.dxcharts.SeriesBase
    SeriesLabelValuesBase createLabelValues(PointLabelInfo pointLabelInfo) {
        return new StackedSeriesLabelValues(pointLabelInfo.seriesName, pointLabelInfo.indexes, pointLabelInfo.argument, pointLabelInfo.value, pointLabelInfo.valueInPercent);
    }

    public StackedPointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(StackedPointColorizer stackedPointColorizer) {
        this.colorizerHolder.setColorizer(stackedPointColorizer);
        nativeSetColorizer(this.colorizerHolder.getNativeColorizer());
    }

    public StackedSegmentColorizer getSegmentColorizer() {
        return this.segmentColorizerHolder.getColorizer();
    }

    public void setSegmentColorizer(StackedSegmentColorizer stackedSegmentColorizer) {
        this.segmentColorizerHolder.setColorizer(stackedSegmentColorizer);
        nativeSetSegmentColorizer(this.segmentColorizerHolder.getNativeColorizer());
    }

    public StackedFillColorizer getFillColorizer() {
        return this.fillColorizerHolder.getColorizer();
    }

    public void setFillColorizer(StackedFillColorizer stackedFillColorizer) {
        this.fillColorizerHolder.setColorizer(stackedFillColorizer);
        nativeSetFillColorizer(this.fillColorizerHolder.getNativeColorizer());
    }
}
