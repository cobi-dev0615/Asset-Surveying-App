package com.devexpress.dxcharts;

/* loaded from: classes.dex */
class MACDDataAdapter extends ValueLevelDataAdapter {
    int _longPeriod;
    int _shortPeriod;
    int _signalSmoothingPeriod;

    native void nativeOnItemAdded(long j);

    native void nativeOnItemChanged(long j, int i);

    native void nativeOnItemInserted(long j, int i);

    native void nativeOnItemRemoved(long j, int i);

    native void nativeOnItemsAdded(long j, int i);

    native void nativeOnItemsChanged(long j, int i, int i2);

    native void nativeOnItemsInserted(long j, int i, int i2);

    native void nativeOnItemsRemoved(long j, int i, int i2);

    native void nativeOnReloaded(long j);

    native long nativeSetData(Object obj, long j, int i, int i2, int i3, int i4);

    public static MACDDataAdapter create(CalculatedSeriesDataWrapper calculatedSeriesDataWrapper, long j, ValueLevel valueLevel, Object obj, int i, int i2, int i3) {
        MACDDataAdapter mACDDataAdapter = new MACDDataAdapter(calculatedSeriesDataWrapper, valueLevel, i, i2, i3);
        mACDDataAdapter.initialize(j);
        mACDDataAdapter.setSyncObject(obj);
        return mACDDataAdapter;
    }

    MACDDataAdapter(CalculatedSeriesDataWrapper calculatedSeriesDataWrapper, ValueLevel valueLevel, int i, int i2, int i3) {
        super(calculatedSeriesDataWrapper, valueLevel);
        this._shortPeriod = i;
        this._longPeriod = i2;
        this._signalSmoothingPeriod = i3;
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    long createNativeAdapter(long j) {
        return nativeSetData(getData(), j, getValueLevel().ordinal(), this._shortPeriod, this._longPeriod, this._signalSmoothingPeriod);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemAdded() {
        nativeOnItemAdded(super.getNativeAdapter());
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemRemoved(int i) {
        nativeOnItemRemoved(super.getNativeAdapter(), i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemChanged(int i) {
        nativeOnItemChanged(super.getNativeAdapter(), i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemInserted(int i) {
        nativeOnItemInserted(super.getNativeAdapter(), i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void reloaded() {
        nativeOnReloaded(super.getNativeAdapter());
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemsInserted(int i, int i2) {
        nativeOnItemsInserted(super.getNativeAdapter(), i, i2);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemsRemoved(int i, int i2) {
        nativeOnItemsRemoved(super.getNativeAdapter(), i, i2);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemsChanged(int i, int i2) {
        nativeOnItemsChanged(super.getNativeAdapter(), i, i2);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    protected void itemsAdded(int i) {
        nativeOnItemsAdded(super.getNativeAdapter(), i);
    }
}
