package com.devexpress.dxlistview;

import android.view.View;

/* loaded from: classes2.dex */
public interface ListViewListener {
    boolean canDrop(int i, int i2);

    boolean canLoadMore();

    boolean canPullToRefresh();

    boolean canStartDrag(int i);

    void drop(int i, int i2);

    void itemDoubleTap(int i);

    void itemLongPress(int i);

    void itemPressed(View view, float f, float f2);

    void itemReleased(View view, float f, float f2);

    void itemTap(int i);

    void itemTapConfirmed(int i);

    void loadMore();

    void onAfterRebuild();

    void onAfterUpdateItems();

    void pullToRefresh();

    void scrolled(ListViewScrolledEventArgs listViewScrolledEventArgs);
}
