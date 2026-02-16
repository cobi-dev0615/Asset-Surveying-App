package com.devexpress.dxlistview.swipes;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DXSwipeItemsViewAdapter {
    private final int containerIndex;
    private final Context context;
    private final boolean isListViewVertical;
    private final SwipeViewListener listener;
    private final DXSwipeItemsViewProvider swipeItemsProvider;

    public DXSwipeItemsViewAdapter(Context context, SwipeViewListener swipeViewListener, boolean z, int i, DXSwipeItemsViewProvider dXSwipeItemsViewProvider) {
        this.context = context;
        this.containerIndex = i;
        this.swipeItemsProvider = dXSwipeItemsViewProvider;
        this.isListViewVertical = z;
        this.listener = swipeViewListener;
    }

    public int getContainerIndex() {
        return this.containerIndex;
    }

    public boolean getRaiseItemTapImmediately() {
        return this.listener.getRaiseItemTapImmediately();
    }

    public boolean getIsListViewVertical() {
        return this.isListViewVertical;
    }

    public SwipeItemsInfo getSwipeItemsInfo(DXSwipeGroup dXSwipeGroup) {
        DXSwipeItemAnchor dXSwipeItemAnchor;
        List<View> swipeViews = this.swipeItemsProvider.getSwipeViews(this.containerIndex, dXSwipeGroup);
        if (swipeViews == null) {
            return null;
        }
        List<Integer> swipeViewSizes = this.swipeItemsProvider.getSwipeViewSizes(this.containerIndex, dXSwipeGroup);
        List<Integer> swipeViewColors = this.swipeItemsProvider.getSwipeViewColors(this.containerIndex, dXSwipeGroup);
        ArrayList arrayList = new ArrayList();
        boolean z = swipeViews.size() == 1;
        for (int i = 0; i < swipeViews.size(); i++) {
            View view = swipeViews.get(i);
            int intValue = swipeViewSizes.get(i).intValue();
            int intValue2 = swipeViewColors.get(i).intValue();
            if (z) {
                if (this.isListViewVertical) {
                    dXSwipeItemAnchor = dXSwipeGroup == DXSwipeGroup.Start ? DXSwipeItemAnchor.Left : DXSwipeItemAnchor.Right;
                } else {
                    dXSwipeItemAnchor = dXSwipeGroup == DXSwipeGroup.Start ? DXSwipeItemAnchor.Top : DXSwipeItemAnchor.Bottom;
                }
            } else if (this.isListViewVertical) {
                dXSwipeItemAnchor = dXSwipeGroup == DXSwipeGroup.Start ? DXSwipeItemAnchor.Right : DXSwipeItemAnchor.Left;
            } else {
                dXSwipeItemAnchor = dXSwipeGroup == DXSwipeGroup.Start ? DXSwipeItemAnchor.Bottom : DXSwipeItemAnchor.Top;
            }
            SwipeItemContainerView swipeItemContainerView = new SwipeItemContainerView(this.context);
            swipeItemContainerView.setSwipeItemView(view);
            swipeItemContainerView.setSwipeItemSize(intValue);
            swipeItemContainerView.setBackgroundColor(intValue2);
            swipeItemContainerView.setAnchor(dXSwipeItemAnchor);
            arrayList.add(swipeItemContainerView);
        }
        return new SwipeItemsInfo(arrayList, swipeViewSizes, swipeViewColors);
    }

    public void recycleViews(DXSwipeGroup dXSwipeGroup, List<SwipeItemContainerView> list) {
        ArrayList arrayList = new ArrayList();
        for (SwipeItemContainerView swipeItemContainerView : list) {
            arrayList.add(swipeItemContainerView.getSwipeItemView());
            swipeItemContainerView.removeAllViews();
        }
        this.swipeItemsProvider.recycleViews(this.containerIndex, dXSwipeGroup, arrayList);
    }

    public boolean isSwipeAllowed(DXSwipeGroup dXSwipeGroup) {
        DXSwipeItemsViewProvider dXSwipeItemsViewProvider = this.swipeItemsProvider;
        if (dXSwipeItemsViewProvider == null) {
            return false;
        }
        return dXSwipeItemsViewProvider.isSwipeAllowed(this.containerIndex, dXSwipeGroup).booleanValue();
    }

    public boolean isFullSwipeAllowed(DXSwipeGroup dXSwipeGroup) {
        return this.swipeItemsProvider.getAllowFullSwipe(this.containerIndex, dXSwipeGroup).booleanValue();
    }

    public void itemTap(int i, DXSwipeGroup dXSwipeGroup) {
        SwipeViewListener swipeViewListener = this.listener;
        if (swipeViewListener != null) {
            swipeViewListener.swipeItemTap(this.containerIndex, i, dXSwipeGroup);
        }
    }
}
