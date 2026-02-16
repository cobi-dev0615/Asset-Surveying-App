package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class TypicalPriceIndicator extends CalculatedSeries {
    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (xYSeriesData instanceof CalculatedSeriesData) {
            return TypicalPriceDataAdapter.create(new CalculatedSeriesDataWrapper((CalculatedSeriesData) xYSeriesData), getNativeSeries(), getSyncObject());
        }
        return null;
    }

    public void setStyle(LineIndicatorStyle lineIndicatorStyle) {
        trySetStyle(lineIndicatorStyle);
    }

    public LineIndicatorStyle getStyle() {
        return (LineIndicatorStyle) getUserStyleFromContainer(LineIndicatorStyle.class);
    }
}
