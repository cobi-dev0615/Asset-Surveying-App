package com.devexpress.dxcharts;

/* loaded from: classes.dex */
abstract class SeriesDataAdapterBase implements SeriesDataChangedListener, Synchronized {
    ChangeableSeriesData _changebleData;
    private NativeObjectWrapper _pNativeAdapter;
    private Object _syncObject = this;

    abstract long createNativeAdapter(long j);

    protected abstract void itemAdded();

    protected abstract void itemChanged(int i);

    protected abstract void itemInserted(int i);

    protected abstract void itemRemoved(int i);

    protected abstract void itemsAdded(int i);

    protected abstract void itemsChanged(int i, int i2);

    protected abstract void itemsInserted(int i, int i2);

    protected abstract void itemsRemoved(int i, int i2);

    protected abstract void reloaded();

    protected long getNativeAdapter() {
        return this._pNativeAdapter.getObject();
    }

    SeriesDataAdapterBase(ChangeableSeriesData changeableSeriesData) {
        this._changebleData = changeableSeriesData;
    }

    public void initialize(long j) {
        this._pNativeAdapter = new NativeObjectWrapper(createNativeAdapter(j));
        ChangeableSeriesData changeableSeriesData = this._changebleData;
        if (changeableSeriesData != null) {
            changeableSeriesData.addChangedListener(this);
        }
    }

    protected void finalize() throws Throwable {
        try {
            ChangeableSeriesData changeableSeriesData = this._changebleData;
            if (changeableSeriesData != null) {
                changeableSeriesData.removeChangedListener(this);
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.devexpress.dxcharts.Synchronized
    public void setSyncObject(Object obj) {
        if (obj == null) {
            obj = this;
        }
        this._syncObject = obj;
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemAdded() {
        synchronized (this._syncObject) {
            itemAdded();
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemRemoved(int i) {
        synchronized (this._syncObject) {
            itemRemoved(i);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemChanged(int i) {
        synchronized (this._syncObject) {
            itemChanged(i);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemInserted(int i) {
        synchronized (this._syncObject) {
            itemInserted(i);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onReloaded() {
        synchronized (this._syncObject) {
            reloaded();
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsInserted(int i, int i2) {
        synchronized (this._syncObject) {
            itemsInserted(i, i2);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsRemoved(int i, int i2) {
        synchronized (this._syncObject) {
            itemsRemoved(i, i2);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsChanged(int i, int i2) {
        synchronized (this._syncObject) {
            itemsChanged(i, i2);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsAdded(int i) {
        synchronized (this._syncObject) {
            itemsAdded(i);
        }
    }
}
