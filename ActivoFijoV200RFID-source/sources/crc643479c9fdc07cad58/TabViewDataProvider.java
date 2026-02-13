package crc643479c9fdc07cad58;

import android.view.View;
import android.view.ViewGroup;
import com.devexpress.navigation.tabcontrol.ITabControlAdapter;
import com.devexpress.navigation.tabs.models.HeaderItemModel;
import java.util.ArrayList;
import java.util.List;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TabViewDataProvider implements IGCUserPeer, ITabControlAdapter {
    public static final String __md_methods = "n_getFragmentManager:()Ljava/lang/Object;:GetGetFragmentManagerHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_setFragmentManager:(Ljava/lang/Object;)V:GetSetFragmentManager_Ljava_lang_Object_Handler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_isFragmentAdapter:()Z:GetIsFragmentAdapterHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_getItemsCount:()I:GetGetItemsCountHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_addItemsSetChangedListener:(Lcom/devexpress/navigation/tabcontrol/ITabControlAdapter$ItemsChangedListener;)V:GetAddItemsSetChangedListener_Lcom_devexpress_navigation_tabcontrol_ITabControlAdapter_ItemsChangedListener_Handler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_clearItemsSetChangedListener:()V:GetClearItemsSetChangedListenerHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_getFragment:(I)Ljava/lang/Object;:GetGetFragment_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_getHeaderView:(Landroid/view/ViewGroup;I)Lcom/devexpress/navigation/tabs/models/HeaderItemModel;:GetGetHeaderView_Landroid_view_ViewGroup_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_getHeaderViews:(Landroid/view/ViewGroup;)Ljava/util/List;:GetGetHeaderViews_Landroid_view_ViewGroup_Handler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\nn_getView:(Landroid/view/ViewGroup;I)Landroid/view/View;:GetGetView_Landroid_view_ViewGroup_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapterInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_addItemsSetChangedListener(ITabControlAdapter.ItemsChangedListener itemsChangedListener);

    private native void n_clearItemsSetChangedListener();

    private native Object n_getFragment(int i);

    private native Object n_getFragmentManager();

    private native HeaderItemModel n_getHeaderView(ViewGroup viewGroup, int i);

    private native List n_getHeaderViews(ViewGroup viewGroup);

    private native int n_getItemsCount();

    private native View n_getView(ViewGroup viewGroup, int i);

    private native boolean n_isFragmentAdapter();

    private native void n_setFragmentManager(Object obj);

    static {
        Runtime.register("DevExpress.Maui.Controls.Android.Internal.TabViewDataProvider, DevExpress.Maui.Controls", TabViewDataProvider.class, __md_methods);
    }

    public TabViewDataProvider() {
        if (getClass() == TabViewDataProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Android.Internal.TabViewDataProvider, DevExpress.Maui.Controls", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public Object getFragmentManager() {
        return n_getFragmentManager();
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public void setFragmentManager(Object obj) {
        n_setFragmentManager(obj);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public boolean isFragmentAdapter() {
        return n_isFragmentAdapter();
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public int getItemsCount() {
        return n_getItemsCount();
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public void addItemsSetChangedListener(ITabControlAdapter.ItemsChangedListener itemsChangedListener) {
        n_addItemsSetChangedListener(itemsChangedListener);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public void clearItemsSetChangedListener() {
        n_clearItemsSetChangedListener();
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public Object getFragment(int i) {
        return n_getFragment(i);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public HeaderItemModel getHeaderView(ViewGroup viewGroup, int i) {
        return n_getHeaderView(viewGroup, i);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public List getHeaderViews(ViewGroup viewGroup) {
        return n_getHeaderViews(viewGroup);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter
    public View getView(ViewGroup viewGroup, int i) {
        return n_getView(viewGroup, i);
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
