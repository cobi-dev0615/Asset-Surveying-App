package com.devexpress.dxlistview.core;

import android.view.View;

/* loaded from: classes2.dex */
public interface DXItemViewProvider {
    int getItemCount();

    View getView();

    int getViewType();

    void recycleView();

    void updateView();
}
