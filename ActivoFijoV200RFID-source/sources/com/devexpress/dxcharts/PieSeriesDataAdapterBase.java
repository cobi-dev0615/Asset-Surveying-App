package com.devexpress.dxcharts;

/* loaded from: classes.dex */
abstract class PieSeriesDataAdapterBase extends SeriesDataAdapterBase {
    private PieSeriesData _data;

    public static PieSeriesDataAdapterBase create(PieSeriesData pieSeriesData, long j, Object obj) {
        PieSeriesDataAdapter pieSeriesDataAdapter = new PieSeriesDataAdapter(pieSeriesData);
        pieSeriesDataAdapter.initialize(j);
        pieSeriesDataAdapter.setSyncObject(obj);
        return pieSeriesDataAdapter;
    }

    PieSeriesDataAdapterBase(PieSeriesData pieSeriesData) {
        super(pieSeriesData instanceof ChangeableSeriesData ? (ChangeableSeriesData) pieSeriesData : null);
        this._data = pieSeriesData;
    }

    public PieSeriesData getData() {
        return this._data;
    }
}
