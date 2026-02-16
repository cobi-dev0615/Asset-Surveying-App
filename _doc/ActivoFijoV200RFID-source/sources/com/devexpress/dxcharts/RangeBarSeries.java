package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class RangeBarSeries extends BarSeriesBase {
    private RangePointColorizerHolder colorizerHolder = new RangePointColorizerHolder();

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetColorizer(long j);

    @Override // com.devexpress.dxcharts.BarSeriesBase, com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new RangeBarSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.Series, com.devexpress.dxcharts.SeriesBase
    SeriesLabelValuesBase createLabelValues(PointLabelInfo pointLabelInfo) {
        return new RangeSeriesLabelValues(pointLabelInfo.seriesName, pointLabelInfo.indexes, pointLabelInfo.argument, pointLabelInfo.highRangeValue, pointLabelInfo.lowRangeValue, pointLabelInfo.labelPosition);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public RangeBarSeriesLabel getLabel() {
        return (RangeBarSeriesLabel) super.getLabel();
    }

    public void setLabel(RangeBarSeriesLabel rangeBarSeriesLabel) {
        super.setLabel((SeriesLabel) rangeBarSeriesLabel);
    }

    public RangePointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(RangePointColorizer rangePointColorizer) {
        this.colorizerHolder.setColorizer(rangePointColorizer);
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
