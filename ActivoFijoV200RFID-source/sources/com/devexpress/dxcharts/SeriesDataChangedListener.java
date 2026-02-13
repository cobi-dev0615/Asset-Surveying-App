package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public interface SeriesDataChangedListener {
    void onItemAdded();

    void onItemChanged(int i);

    void onItemInserted(int i);

    void onItemRemoved(int i);

    void onItemsAdded(int i);

    void onItemsChanged(int i, int i2);

    void onItemsInserted(int i, int i2);

    void onItemsRemoved(int i, int i2);

    void onReloaded();
}
