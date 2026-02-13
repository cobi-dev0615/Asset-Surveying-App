package com.devexpress.dxlistview.core;

import android.view.View;

/* loaded from: classes2.dex */
public interface DXListItemViewProvider {
    int calculateNodePosition(int i);

    boolean checkView(View view, int i);

    void clearCache();

    int getEndVisibleIndexInNodeByItem(int i);

    int getGroupItemIndexForItem(int i);

    int getItemCount();

    int getStartVisibleIndexInNode(int i);

    int getStartVisibleIndexInNodeByItem(int i);

    View getViewByIndex(int i, int i2);

    int getViewTypeByIndex(int i);

    boolean isItemsSourceGrouped();

    void recycleView(View view, int i, int i2);

    void updateView(View view, int i, int i2);
}
