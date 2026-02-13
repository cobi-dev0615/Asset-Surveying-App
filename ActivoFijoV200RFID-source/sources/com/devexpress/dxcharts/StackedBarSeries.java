package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StackedBarSeries extends BarSeriesBase {
    private StackedPointColorizerHolder colorizerHolder = new StackedPointColorizerHolder();

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetColorizer(long j);

    @Override // com.devexpress.dxcharts.BarSeriesBase, com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new StackedBarSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.Series, com.devexpress.dxcharts.SeriesBase
    SeriesLabelValuesBase createLabelValues(PointLabelInfo pointLabelInfo) {
        return new StackedSeriesLabelValues(pointLabelInfo.seriesName, pointLabelInfo.indexes, pointLabelInfo.argument, pointLabelInfo.value, pointLabelInfo.valueInPercent);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public StackedBarSeriesLabel getLabel() {
        return (StackedBarSeriesLabel) super.getLabel();
    }

    public void setLabel(StackedBarSeriesLabel stackedBarSeriesLabel) {
        super.setLabel((SeriesLabel) stackedBarSeriesLabel);
    }

    public StackedPointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(StackedPointColorizer stackedPointColorizer) {
        this.colorizerHolder.setColorizer(stackedPointColorizer);
        nativeSetColorizer(this.colorizerHolder.getNativeColorizer());
    }

    @Override // com.devexpress.dxcharts.BarSeriesBase
    @Deprecated
    public boolean isColorEach() {
        return super.isColorEach();
    }

    @Override // com.devexpress.dxcharts.BarSeriesBase
    @Deprecated
    public void setColorEach(boolean z) {
        super.setColorEach(z);
    }
}
