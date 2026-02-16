package com.devexpress.dxcharts;

/* compiled from: XYDateTimeSeriesDataAdapter.java */
/* loaded from: classes.dex */
final class XYRangeDateTimeSeriesDataAdapter extends XYSeriesDataAdapterBase implements RangeNumericSeriesData {
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

    XYRangeDateTimeSeriesDataAdapter(RangeDateTimeSeriesData rangeDateTimeSeriesData) {
        super(rangeDateTimeSeriesData);
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
    public int getDataCount() {
        return ((RangeDateTimeSeriesData) getData()).getDataCount();
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
    public double getArgument(int i) {
        return ((RangeDateTimeSeriesData) getData()).getArgument(i).getTime() / 1000.0d;
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
    public double getValue1(int i) {
        return ((RangeDateTimeSeriesData) getData()).getValue1(i);
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
    public double getValue2(int i) {
        return ((RangeDateTimeSeriesData) getData()).getValue2(i);
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
