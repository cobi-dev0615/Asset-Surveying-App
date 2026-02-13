package com.devexpress.dxcharts;

/* compiled from: XYDateTimeSeriesDataAdapter.java */
/* loaded from: classes.dex */
final class XYWeightedDateTimeSeriesDataAdapter extends XYSeriesDataAdapterBase implements WeightedNumericSeriesData {
    native void nativeOnItemAdded(long j);

    native void nativeOnItemChanged(long j, int i);

    native void nativeOnItemInserted(long j, int i);

    native void nativeOnItemRemoved(long j, int i);

    native void nativeOnItemsAdded(long j, int i);

    native void nativeOnItemsChanged(long j, int i, int i2);

    native void nativeOnItemsInserted(long j, int i, int i2);

    native void nativeOnItemsRemoved(long j, int i, int i2);

    native void nativeOnReloaded(long j);

    native long nativeSetData(Object obj, long j);

    XYWeightedDateTimeSeriesDataAdapter(WeightedDateTimeSeriesData weightedDateTimeSeriesData) {
        super(weightedDateTimeSeriesData);
    }

    @Override // com.devexpress.dxcharts.NumericSeriesData
    public int getDataCount() {
        return ((DateTimeSeriesData) getData()).getDataCount();
    }

    @Override // com.devexpress.dxcharts.NumericSeriesData
    public double getArgument(int i) {
        return ((WeightedDateTimeSeriesData) getData()).getArgument(i).getTime() / 1000.0d;
    }

    @Override // com.devexpress.dxcharts.NumericSeriesData
    public double getValue(int i) {
        return ((WeightedDateTimeSeriesData) getData()).getValue(i);
    }

    @Override // com.devexpress.dxcharts.WeightedNumericSeriesData
    public double getWeight(int i) {
        return ((WeightedDateTimeSeriesData) getData()).getWeight(i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    long createNativeAdapter(long j) {
        return nativeSetData(this, j);
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
