package com.devexpress.dxcharts;

/* loaded from: classes.dex */
final class XYFinancialSeriesDataAdapter extends XYSeriesDataAdapterBase implements XYSeriesData {
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

    XYFinancialSeriesDataAdapter(FinancialSeriesData financialSeriesData) {
        super(financialSeriesData);
    }

    public int getDataCount() {
        return ((FinancialSeriesData) getData()).getDataCount();
    }

    double getArgument(int i) {
        return ((FinancialSeriesData) getData()).getArgument(i).getTime() / 1000.0d;
    }

    double getHighValue(int i) {
        return ((FinancialSeriesData) getData()).getHighValue(i);
    }

    double getLowValue(int i) {
        return ((FinancialSeriesData) getData()).getLowValue(i);
    }

    double getOpenValue(int i) {
        return ((FinancialSeriesData) getData()).getOpenValue(i);
    }

    double getCloseValue(int i) {
        return ((FinancialSeriesData) getData()).getCloseValue(i);
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
