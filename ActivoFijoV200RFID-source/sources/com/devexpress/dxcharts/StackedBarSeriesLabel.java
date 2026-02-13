package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class StackedBarSeriesLabel extends BarSeriesLabel {
    @Override // com.devexpress.dxcharts.BarSeriesLabel, com.devexpress.dxcharts.SeriesLabel
    native long nativeCreateLabel();

    @Override // com.devexpress.dxcharts.BarSeriesLabel
    BarSeriesLabelPosition getDefaultPosition() {
        return BarSeriesLabelPosition.CENTER;
    }

    @Override // com.devexpress.dxcharts.BarSeriesLabel
    boolean isValidPosition(BarSeriesLabelPosition barSeriesLabelPosition) {
        return barSeriesLabelPosition != BarSeriesLabelPosition.OUTSIDE;
    }
}
