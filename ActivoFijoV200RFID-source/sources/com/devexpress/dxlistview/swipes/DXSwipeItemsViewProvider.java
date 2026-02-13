package com.devexpress.dxlistview.swipes;

import android.view.View;
import java.util.List;

/* loaded from: classes2.dex */
public interface DXSwipeItemsViewProvider {
    Boolean getAllowFullSwipe(int i, DXSwipeGroup dXSwipeGroup);

    List<Integer> getSwipeViewColors(int i, DXSwipeGroup dXSwipeGroup);

    List<Integer> getSwipeViewSizes(int i, DXSwipeGroup dXSwipeGroup);

    List<View> getSwipeViews(int i, DXSwipeGroup dXSwipeGroup);

    Boolean isSwipeAllowed(int i, DXSwipeGroup dXSwipeGroup);

    void recycleViews(int i, DXSwipeGroup dXSwipeGroup, List<View> list);
}
