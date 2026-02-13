package com.devexpress.dxlistview.swipes;

import android.content.Context;
import android.view.View;
import com.devexpress.dxlistview.core.DXListItemViewProvider;
import com.devexpress.dxlistview.layouts.ItemContainerLayout;
import com.devexpress.dxlistview.views.ItemContainerView;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class DXListItemViewContainerProvider implements DXListItemViewProvider, IInnerItemExtractor {
    private final Context context;
    private final HashMap<View, ItemContainerView> map = new HashMap<>();
    private final DXListItemViewProvider provider;

    public DXListItemViewContainerProvider(Context context, DXListItemViewProvider dXListItemViewProvider) {
        this.context = context;
        this.provider = dXListItemViewProvider;
    }

    @Override // com.devexpress.dxlistview.swipes.IInnerItemExtractor
    public ItemContainerLayout extractContainerLayout(View view) {
        ItemContainerView itemContainerView = getItemContainerView(view);
        if (itemContainerView != null) {
            return itemContainerView.getContainerLayout();
        }
        return null;
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getItemCount() {
        return this.provider.getItemCount();
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public boolean isItemsSourceGrouped() {
        return this.provider.isItemsSourceGrouped();
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public View getViewByIndex(int i, int i2) {
        View viewByIndex = this.provider.getViewByIndex(i, i2);
        ItemContainerView itemContainerView = this.map.get(viewByIndex);
        if (itemContainerView == null) {
            itemContainerView = new ItemContainerView(this.context);
            itemContainerView.setContainerLayout(new ItemContainerLayout(itemContainerView, viewByIndex));
            this.map.put(viewByIndex, itemContainerView);
        }
        itemContainerView.setTag(Integer.valueOf(i));
        return itemContainerView;
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public void updateView(View view, int i, int i2) {
        this.provider.updateView(extractItemView(view), i, i2);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public void recycleView(View view, int i, int i2) {
        View extractItemView = extractItemView(view);
        view.setTag(-1);
        this.provider.recycleView(extractItemView, i, i2);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public void clearCache() {
        this.provider.clearCache();
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public boolean checkView(View view, int i) {
        return this.provider.checkView(extractItemView(view), i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getViewTypeByIndex(int i) {
        return this.provider.getViewTypeByIndex(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int calculateNodePosition(int i) {
        return this.provider.calculateNodePosition(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getStartVisibleIndexInNodeByItem(int i) {
        return this.provider.getStartVisibleIndexInNodeByItem(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getEndVisibleIndexInNodeByItem(int i) {
        return this.provider.getEndVisibleIndexInNodeByItem(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getStartVisibleIndexInNode(int i) {
        return this.provider.getStartVisibleIndexInNode(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getGroupItemIndexForItem(int i) {
        return this.provider.getGroupItemIndexForItem(i);
    }

    private View extractItemView(View view) {
        return extractItemView(getItemContainerView(view));
    }

    private ItemContainerView getItemContainerView(View view) {
        if (view instanceof ItemContainerView) {
            return (ItemContainerView) view;
        }
        return null;
    }

    private View extractItemView(ItemContainerView itemContainerView) {
        return (itemContainerView == null || itemContainerView.getContainerLayout() == null) ? itemContainerView : itemContainerView.getContainerLayout().getItemView();
    }
}
