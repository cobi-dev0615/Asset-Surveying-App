package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class MassIndexIndicator extends CalculatedSeries {
    int _movingAveragePointsCount = 9;
    int _sumPointsCount = 25;

    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (xYSeriesData instanceof CalculatedSeriesData) {
            return MassIndexDataAdapter.create(new CalculatedSeriesDataWrapper((CalculatedSeriesData) xYSeriesData), getNativeSeries(), getSyncObject(), this._movingAveragePointsCount, this._sumPointsCount);
        }
        return null;
    }

    public int getMovingAveragePointsCount() {
        return this._movingAveragePointsCount;
    }

    public void setMovingAveragePointsCount(int i) {
        if (this._movingAveragePointsCount != i) {
            this._movingAveragePointsCount = i;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public int getSumPointsCount() {
        return this._sumPointsCount;
    }

    public void setSumPointsCount(int i) {
        if (this._sumPointsCount != i) {
            this._sumPointsCount = i;
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
