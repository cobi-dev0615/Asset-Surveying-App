package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class TriangularMovingAverageIndicator extends CalculatedSeries {
    ValueLevel _valueLevel = ValueLevel.AUTO;
    int _pointsCount = 20;

    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (!(xYSeriesData instanceof CalculatedSeriesData)) {
            return null;
        }
        CalculatedSeriesData calculatedSeriesData = (CalculatedSeriesData) xYSeriesData;
        return TriangularMovingAverageDataAdapter.create(new CalculatedSeriesDataWrapper(calculatedSeriesData), getNativeSeries(), getActualValueLevel(this._valueLevel, calculatedSeriesData), getSyncObject(), this._pointsCount);
    }

    public ValueLevel getValueLevel() {
        return this._valueLevel;
    }

    public void setValueLevel(ValueLevel valueLevel) {
        if (this._valueLevel != valueLevel) {
            this._valueLevel = valueLevel;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
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
