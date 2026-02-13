package com.devexpress.navigation.tabcontrol;

import android.view.View;
import android.view.ViewGroup;
import com.devexpress.navigation.tabs.models.HeaderItemModel;
import java.util.List;

/* loaded from: classes2.dex */
public interface ITabControlAdapter {

    public interface ItemsChangedListener {
        void onAddItem(int i);

        void onClearItems();

        void onContentChanged(int i);

        void onContentTemplateChanged();

        void onHeaderContentChanged(int i);

        void onHeaderTemplateChanged();

        void onRemoveItem(int i);

        void onSetItem(int i);
    }

    void addItemsSetChangedListener(ItemsChangedListener itemsChangedListener);

    void clearItemsSetChangedListener();

    Object getFragment(int i);

    Object getFragmentManager();

    HeaderItemModel getHeaderView(ViewGroup viewGroup, int i);

    List<HeaderItemModel> getHeaderViews(ViewGroup viewGroup);

    int getItemsCount();

    View getView(ViewGroup viewGroup, int i);

    boolean isFragmentAdapter();

    void setFragmentManager(Object obj);
}
