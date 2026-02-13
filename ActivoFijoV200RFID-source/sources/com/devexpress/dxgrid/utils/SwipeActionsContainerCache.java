package com.devexpress.dxgrid.utils;

import android.content.Context;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.models.SwipeButtonModel;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.dxgrid.views.SwipeActionButton;
import com.devexpress.dxgrid.views.SwipeActionsContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class SwipeActionsContainerCache {
    private final ArrayList<SwipeActionsContainer> cache = new ArrayList<>();
    private final Context context;
    private final GridAction gridAction;
    private final ServiceProvider serviceProvider;

    private interface Action {
        SwipeButtonModel[] getButtons();
    }

    public SwipeActionsContainerCache(Context context, ServiceProvider serviceProvider, GridAction gridAction) {
        this.context = context;
        this.serviceProvider = serviceProvider;
        this.gridAction = gridAction;
    }

    private SwipeActionsContainer getSwipeActionsContainer(SwipeActionButton.OnTapListener onTapListener, SwipeActionsContainer.Position position, Action action, int i, int i2, int i3) {
        int i4;
        SwipeActionsContainer swipeActionsContainer;
        SwipeButtonModel[] buttons = action.getButtons();
        ArrayList arrayList = new ArrayList();
        boolean z = position == SwipeActionsContainer.Position.Left;
        int length = buttons.length - 1;
        while (i4 <= length) {
            GridAction gridAction = this.gridAction;
            if (gridAction != null) {
                i4 = gridAction.swipeButtonShowing(z, i, z ? i4 : length - i4) ? 0 : i4 + 1;
            }
            arrayList.add(buttons[i4]);
        }
        if (this.cache.size() > 0 && arrayList.size() == buttons.length) {
            Iterator<SwipeActionsContainer> it = this.cache.iterator();
            while (it.hasNext()) {
                swipeActionsContainer = it.next();
                if (swipeActionsContainer.getPosition() == position) {
                    this.cache.remove(swipeActionsContainer);
                    break;
                }
            }
        }
        swipeActionsContainer = null;
        if (swipeActionsContainer == null && arrayList.size() > 0) {
            swipeActionsContainer = new SwipeActionsContainer(this.context, position, arrayList);
        }
        if (swipeActionsContainer != null) {
            swipeActionsContainer.update(onTapListener, i, i2, i3);
        }
        return swipeActionsContainer;
    }

    public SwipeActionsContainer getRightSwipeActionsContainer(SwipeActionButton.OnTapListener onTapListener, int i) {
        GridCellContainerAppearance cellAppearance = this.serviceProvider.getCellAppearance(this.serviceProvider.getColumn(r0.getColumnCount() - 1).getGridColumnModel());
        return getSwipeActionsContainer(onTapListener, SwipeActionsContainer.Position.Right, new Action() { // from class: com.devexpress.dxgrid.utils.SwipeActionsContainerCache.1
            @Override // com.devexpress.dxgrid.utils.SwipeActionsContainerCache.Action
            public SwipeButtonModel[] getButtons() {
                return SwipeActionsContainerCache.this.serviceProvider.getRightSwipeButtons();
            }
        }, i, cellAppearance.getHorizontalLineThickness(), cellAppearance.getBorderColor());
    }

    public SwipeActionsContainer getLeftSwipeActionsContainer(SwipeActionButton.OnTapListener onTapListener, int i) {
        GridCellContainerAppearance cellAppearance = this.serviceProvider.getCellAppearance(this.serviceProvider.getColumn(0).getGridColumnModel());
        return getSwipeActionsContainer(onTapListener, SwipeActionsContainer.Position.Left, new Action() { // from class: com.devexpress.dxgrid.utils.SwipeActionsContainerCache.2
            @Override // com.devexpress.dxgrid.utils.SwipeActionsContainerCache.Action
            public SwipeButtonModel[] getButtons() {
                return SwipeActionsContainerCache.this.serviceProvider.getLeftSwipeButtons();
            }
        }, i, cellAppearance.getHorizontalLineThickness(), cellAppearance.getBorderColor());
    }

    private boolean canMoveContainerToCache(SwipeActionsContainer swipeActionsContainer) {
        int length;
        if (swipeActionsContainer.getPosition() == SwipeActionsContainer.Position.Left) {
            length = this.serviceProvider.getLeftSwipeButtons().length;
        } else {
            length = this.serviceProvider.getRightSwipeButtons().length;
        }
        return swipeActionsContainer.getSwipeItemsCount() == length;
    }

    public void recycle(SwipeActionsContainer swipeActionsContainer) {
        if (this.cache.contains(swipeActionsContainer) || !canMoveContainerToCache(swipeActionsContainer)) {
            return;
        }
        swipeActionsContainer.reset();
        this.cache.add(swipeActionsContainer);
    }
}
