package com.devexpress.dxcharts;

/* loaded from: classes.dex */
abstract class ValueLevelDataAdapter extends XYSeriesDataAdapterBase {
    ValueLevel _valueLevel;

    ValueLevelDataAdapter(CalculatedSeriesDataWrapper calculatedSeriesDataWrapper, ValueLevel valueLevel) {
        super(calculatedSeriesDataWrapper);
        this._valueLevel = valueLevel;
    }

    ValueLevel getValueLevel() {
        return this._valueLevel;
    }
}
