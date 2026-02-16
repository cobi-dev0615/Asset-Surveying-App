package com.devexpress.dxcharts;

/* loaded from: classes.dex */
class CalculatedSeriesDataWrapper implements XYSeriesData {
    CalculatedSeriesData _seriesData;

    CalculatedSeriesDataWrapper(CalculatedSeriesData calculatedSeriesData) {
        this._seriesData = calculatedSeriesData;
    }

    long getSource() {
        return this._seriesData.getSource().getNativeSeries();
    }
}
