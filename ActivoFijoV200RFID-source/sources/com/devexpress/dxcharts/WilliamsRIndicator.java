package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class WilliamsRIndicator extends CalculatedSeries {
    int _pointsCount = 14;

    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (xYSeriesData instanceof CalculatedSeriesData) {
            return WilliamsRDataAdapter.create(new CalculatedSeriesDataWrapper((CalculatedSeriesData) xYSeriesData), getNativeSeries(), getSyncObject(), this._pointsCount);
        }
        return null;
    }

    public int getPointsCount() {
        return this._pointsCount;
    }

    public void setPointsCount(int i) {
        if (this._pointsCount != i) {
            this._pointsCount = i;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public void setStyle(LineIndicatorStyle lineIndicatorStyle) {
        trySetStyle(lineIndicatorStyle);
    }

    public LineIndicatorStyle getStyle() {
        return (LineIndicatorStyle) getUserStyleFromContainer(LineIndicatorStyle.class);
    }
}
