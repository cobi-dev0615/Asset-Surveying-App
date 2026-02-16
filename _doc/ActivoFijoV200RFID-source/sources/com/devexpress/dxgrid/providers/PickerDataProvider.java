package com.devexpress.dxgrid.providers;

/* loaded from: classes.dex */
public interface PickerDataProvider {
    int getItemCount(int i);

    int getItemIndex(int i);

    String getText(int i, int i2);

    String setItemIndex(int i, int i2);
}
