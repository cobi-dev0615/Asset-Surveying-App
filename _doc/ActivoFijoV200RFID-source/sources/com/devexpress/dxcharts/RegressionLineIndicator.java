package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class RegressionLineIndicator extends CalculatedSeries {
    ValueLevel _valueLevel = ValueLevel.AUTO;

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (!(xYSeriesData instanceof CalculatedSeriesData)) {
            return null;
        }
        CalculatedSeriesData calculatedSeriesData = (CalculatedSeriesData) xYSeriesData;
        return RegressionLineDataAdapter.create(new CalculatedSeriesDataWrapper(calculatedSeriesData), getNativeSeries(), getActualValueLevel(this._valueLevel, calculatedSeriesData), getSyncObject());
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

    public void setStyle(LineIndicatorStyle lineIndicatorStyle) {
        trySetStyle(lineIndicatorStyle);
    }

    public LineIndicatorStyle getStyle() {
        return (LineIndicatorStyle) getUserStyleFromContainer(LineIndicatorStyle.class);
    }
}
