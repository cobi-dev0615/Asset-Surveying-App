package com.devexpress.dxcharts;

/* compiled from: XYDateTimeSeriesDataAdapter.java */
/* loaded from: classes.dex */
final class XYBatchDateTimeAsNumericSeriesDataAdapter extends XYSeriesDataAdapterBase {
    private FastXYData _fastData;

    native void nativeOnItemAdded(long j);

    native void nativeOnItemChanged(long j, int i);

    native void nativeOnItemInserted(long j, int i);

    native void nativeOnItemRemoved(long j, int i);

    native void nativeOnItemsAdded(long j, int i);

    native void nativeOnItemsChanged(long j, int i, int i2);

    native void nativeOnItemsInserted(long j, int i, int i2);

    native void nativeOnItemsRemoved(long j, int i, int i2);

    native void nativeOnReloaded(long j);

    native long nativeSetData(Object obj, Object obj2, long j);

    XYBatchDateTimeAsNumericSeriesDataAdapter(BatchDateTimeAsNumericSeriesData batchDateTimeAsNumericSeriesData) {
        super(batchDateTimeAsNumericSeriesData);
    }

    public int getDataCount() {
        return ((BatchDateTimeAsNumericSeriesData) getData()).getDataCount();
    }

    public double getArgument(int i) {
        return ((BatchDateTimeAsNumericSeriesData) getData()).getArgument(i);
    }

    public double getValue(int i) {
        return ((BatchDateTimeAsNumericSeriesData) getData()).getValue(i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataAdapterBase
    long createNativeAdapter(long j) {
        FastBatchXYDateTimeAsNumericData fastBatchXYDateTimeAsNumericData = new FastBatchXYDateTimeAsNumericData((BatchDateTimeAsNumericSeriesData) getData());
        this._fastData = fastBatchXYDateTimeAsNumericData;
        return nativeSetData(this, fastBatchXYDateTimeAsNumericData, j);
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
