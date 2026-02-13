package com.devexpress.dxgrid.providers;

import android.view.View;
import com.devexpress.dxgrid.DXGridViewScrolledEventArgs;
import com.devexpress.dxgrid.models.GridElement;

/* loaded from: classes.dex */
public interface GridAction {
    boolean canDragRow(int i);

    boolean canDropRow(int i, int i2);

    boolean canLoadMore();

    boolean canPullToRefresh();

    void cellDoubleTap(GridElement gridElement, int i, int i2);

    void cellLongPress(GridElement gridElement, int i, int i2);

    void cellTap(GridElement gridElement, int i, int i2);

    void cellTapConfirmed(GridElement gridElement, int i, int i2);

    boolean closeEditor(boolean z);

    void dropRow(int i, int i2);

    void loadMore();

    void pullTeRefresh();

    void scrolled(DXGridViewScrolledEventArgs dXGridViewScrolledEventArgs);

    void selectionChanged(View view, int i, int i2);

    void setTopRowIndex(int i);

    boolean swipeButtonShowing(boolean z, int i, int i2);

    void updateExtentSize(int i, int i2);
}
