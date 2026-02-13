package com.devexpress.dxlistview.core;

import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.devexpress.dxlistview.VirtualScrollPanel;

/* loaded from: classes2.dex */
public class DXAsyncViewAdapter {
    private static final int BIG_TOP = -100000;
    public static final int FOOTER_ITEM = 4;
    public static final int GROUP_ITEM = 2;
    public static final int HEADER_ITEM = 3;
    public static final int ITEM = 0;
    public static final int LOAD_MORE_ITEM = -1;
    public static final int SELECTED_ITEM = 1;
    private final DXAsyncActionQueue actionQueue;
    private ItemsViewAdapterListener itemsViewAdapterlistener;
    private DXItemViewProvider loadMoreProvider;
    private final DXListItemViewProvider provider;
    private boolean showFooter;
    private boolean showHeader;
    private int spanCount;
    private final VirtualScrollPanel viewsHolder;
    private final SparseArray<View> frozenViews = new SparseArray<>();
    private final SparseArray<ViewHolder> shouldRecycleViews = new SparseArray<>();
    private boolean allowCascadeUpdate = true;

    public static final boolean IS_GROUP(int i) {
        return i == 2;
    }

    public static final boolean IS_ITEM(int i) {
        return i == 1 || i == 0;
    }

    private static class ViewHolder {
        private final View _view;
        private final int _viewType;

        public ViewHolder(View view, int i) {
            this._view = view;
            this._viewType = i;
        }

        public View getView() {
            return this._view;
        }

        public int getViewType() {
            return this._viewType;
        }
    }

    public static final boolean IS_ITEM_OR_GROUP(int i) {
        return IS_ITEM(i) || i == 2;
    }

    public DXAsyncViewAdapter(DXListItemViewProvider dXListItemViewProvider, VirtualScrollPanel virtualScrollPanel, DXAsyncActionQueue dXAsyncActionQueue) {
        this.provider = dXListItemViewProvider;
        this.actionQueue = dXAsyncActionQueue;
        this.viewsHolder = virtualScrollPanel;
    }

    public boolean getShowHeader() {
        return this.showHeader;
    }

    public void setShowHeader(boolean z) {
        this.showHeader = z;
    }

    public boolean getShowFooter() {
        return this.showFooter;
    }

    public void setShowFooter(boolean z) {
        this.showFooter = z;
    }

    public int getSpanCount() {
        return this.spanCount;
    }

    public void setSpanCount(int i) {
        this.spanCount = i;
    }

    public boolean isItemsSourceGrouped() {
        return this.provider.isItemsSourceGrouped();
    }

    public boolean isLastInGroup(int i, int i2, int i3, int i4, boolean z) {
        return !isLast(i, i4) && z && IS_ITEM(i3) && !IS_ITEM(getViewTypeByIndex(i + 1, i2 + 1));
    }

    public boolean isLast(int i, int i2) {
        int i3 = i2 - 1;
        if (this.showFooter) {
            i3 = i2 - 2;
        }
        return i == i3;
    }

    public boolean getAllowCascadeUpdate() {
        return this.allowCascadeUpdate;
    }

    public void setAllowCascadeUpdate(boolean z) {
        this.allowCascadeUpdate = z;
    }

    public ItemsViewAdapterListener getItemsViewAdapterListener() {
        return this.itemsViewAdapterlistener;
    }

    public void setLoadMoreProvider(DXItemViewProvider dXItemViewProvider) {
        this.loadMoreProvider = dXItemViewProvider;
    }

    public void setItemsViewAdapterListener(ItemsViewAdapterListener itemsViewAdapterListener) {
        this.itemsViewAdapterlistener = itemsViewAdapterListener;
    }

    public DXListItemViewProvider getProvider() {
        return this.provider;
    }

    public boolean isItemIndexExist(int i) {
        return i >= 0 && i < this.provider.getItemCount();
    }

    public boolean checkView(View view, int i, int i2) {
        if (isLoadMorePosition(i2)) {
            return true;
        }
        return this.provider.checkView(view, i);
    }

    public int getItemCount() {
        int itemCount = this.provider.getItemCount();
        DXItemViewProvider dXItemViewProvider = this.loadMoreProvider;
        return itemCount + (dXItemViewProvider == null ? 0 : dXItemViewProvider.getItemCount());
    }

    public int calculateNodePosition(int i) {
        return this.provider.calculateNodePosition(i);
    }

    public int getStartVisibleIndexInNodeByItem(int i, boolean z) {
        return allowGetValueFromProvider(z) ? this.provider.getStartVisibleIndexInNodeByItem(i) : i;
    }

    public int getEndVisibleIndexInNodeByItem(int i, boolean z) {
        return allowGetValueFromProvider(z) ? this.provider.getEndVisibleIndexInNodeByItem(i) : i;
    }

    public int getStartVisibleIndexInNode(int i) {
        return this.provider.getStartVisibleIndexInNode(i);
    }

    public int getGroupItemIndexForItem(int i) {
        return this.provider.getGroupItemIndexForItem(i);
    }

    public View getViewByIndex(int i, int i2) {
        View viewByIndex;
        View view = this.frozenViews.get(i);
        if (view == null) {
            if (i2 == -1) {
                viewByIndex = this.loadMoreProvider.getView();
            } else {
                viewByIndex = this.provider.getViewByIndex(i, i2);
            }
            view = viewByIndex;
            if (view.getParent() == null) {
                view.setAlpha(0.0f);
                this.viewsHolder.addViewInLayout(view);
            }
        } else if (this.shouldRecycleViews.get(i) != null) {
            this.shouldRecycleViews.remove(i);
        }
        return view;
    }

    public void freezeView(int i, View view) {
        this.frozenViews.put(i, view);
    }

    public void defrostView(int i) {
        this.frozenViews.remove(i);
        ViewHolder viewHolder = this.shouldRecycleViews.get(i);
        if (viewHolder != null) {
            recycleView(viewHolder.getView(), i, viewHolder.getViewType());
            this.shouldRecycleViews.remove(i);
        }
    }

    public boolean updateView(View view, int i, int i2, int i3) {
        return updateView(view, i2, i, false, i3);
    }

    public boolean updateView(View view, int i, int i2, boolean z, int i3) {
        if (this.frozenViews.get(i2) != null) {
            return false;
        }
        if (!getAllowCascadeUpdate() || z) {
            updateViewSilently(view, i2, i, i3);
            view.setAlpha(1.0f);
            return true;
        }
        this.actionQueue.pushAction(new QueueItemAction() { // from class: com.devexpress.dxlistview.core.DXAsyncViewAdapter$$ExternalSyntheticLambda0
            @Override // com.devexpress.dxlistview.core.QueueItemAction
            public final boolean run(View view2, int i4, int i5, int i6) {
                return DXAsyncViewAdapter.this.m451x596e97f3(view2, i4, i5, i6);
            }
        }, new QueueItemCompleteAction() { // from class: com.devexpress.dxlistview.core.DXAsyncViewAdapter$$ExternalSyntheticLambda1
            @Override // com.devexpress.dxlistview.core.QueueItemCompleteAction
            public final void run(View view2, int i4, int i5) {
                DXAsyncViewAdapter.this.m452x9cf9b5b4(view2, i4, i5);
            }
        }, view, i, i2, i3);
        return false;
    }

    /* renamed from: lambda$updateView$0$com-devexpress-dxlistview-core-DXAsyncViewAdapter, reason: not valid java name */
    /* synthetic */ boolean m451x596e97f3(View view, int i, int i2, int i3) {
        updateViewSilently(view, i2, i, i3);
        return false;
    }

    /* renamed from: lambda$updateView$1$com-devexpress-dxlistview-core-DXAsyncViewAdapter, reason: not valid java name */
    /* synthetic */ void m452x9cf9b5b4(View view, int i, int i2) {
        view.setAlpha(1.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
        raiseViewDidUpdate(view, i, i2);
    }

    public int getViewTypeByIndex(int i, int i2) {
        if (isLoadMorePosition(i)) {
            return this.loadMoreProvider.getViewType();
        }
        return this.provider.getViewTypeByIndex(i2);
    }

    private void recycleView(View view, int i, int i2) {
        recycleView(view, i, i, i2);
    }

    public void recycleView(View view, int i, int i2, int i3) {
        if (this.frozenViews.get(i) == null) {
            this.actionQueue.removeAction(i, view);
            if (i3 == -1) {
                this.loadMoreProvider.recycleView();
            } else {
                this.provider.recycleView(view, i, i3);
            }
            view.setAlpha(0.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.offsetTopAndBottom(BIG_TOP - view.getTop());
            return;
        }
        this.shouldRecycleViews.put(i, new ViewHolder(view, i3));
    }

    private boolean allowGetValueFromProvider(boolean z) {
        return z && this.spanCount > 1;
    }

    private void raiseViewDidUpdate(View view, int i, int i2) {
        ItemsViewAdapterListener itemsViewAdapterListener = this.itemsViewAdapterlistener;
        if (itemsViewAdapterListener != null) {
            itemsViewAdapterListener.viewDidUpdate(view, i, i2);
        }
    }

    private void updateViewSilently(View view, int i, int i2, int i3) {
        if (this.frozenViews.get(i) == null) {
            if (i3 == -1) {
                this.loadMoreProvider.updateView();
            } else {
                this.provider.updateView(view, i, i3);
            }
        }
    }

    private boolean isLoadMorePosition(int i) {
        DXItemViewProvider dXItemViewProvider = this.loadMoreProvider;
        if (dXItemViewProvider == null || dXItemViewProvider.getItemCount() == 0) {
            return false;
        }
        return !this.showFooter ? i >= this.provider.getItemCount() : i == getItemCount() + (-2);
    }
}
