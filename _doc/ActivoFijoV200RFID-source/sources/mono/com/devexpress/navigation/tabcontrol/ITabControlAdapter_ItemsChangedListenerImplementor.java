package mono.com.devexpress.navigation.tabcontrol;

import com.devexpress.navigation.tabcontrol.ITabControlAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ITabControlAdapter_ItemsChangedListenerImplementor implements IGCUserPeer, ITabControlAdapter.ItemsChangedListener {
    public static final String __md_methods = "n_onAddItem:(I)V:GetOnAddItem_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\nn_onClearItems:()V:GetOnClearItemsHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\nn_onContentChanged:(I)V:GetOnContentChanged_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\nn_onContentTemplateChanged:()V:GetOnContentTemplateChangedHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\nn_onHeaderContentChanged:(I)V:GetOnHeaderContentChanged_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\nn_onHeaderTemplateChanged:()V:GetOnHeaderTemplateChangedHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\nn_onRemoveItem:(I)V:GetOnRemoveItem_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\nn_onSetItem:(I)V:GetOnSetItem_IHandler:DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter/IItemsChangedListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onAddItem(int i);

    private native void n_onClearItems();

    private native void n_onContentChanged(int i);

    private native void n_onContentTemplateChanged();

    private native void n_onHeaderContentChanged(int i);

    private native void n_onHeaderTemplateChanged();

    private native void n_onRemoveItem(int i);

    private native void n_onSetItem(int i);

    static {
        Runtime.register("DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter+IItemsChangedListenerImplementor, DXNavigation.a", ITabControlAdapter_ItemsChangedListenerImplementor.class, __md_methods);
    }

    public ITabControlAdapter_ItemsChangedListenerImplementor() {
        if (getClass() == ITabControlAdapter_ItemsChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.Tabcontrol.ITabControlAdapter+IItemsChangedListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onAddItem(int i) {
        n_onAddItem(i);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onClearItems() {
        n_onClearItems();
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onContentChanged(int i) {
        n_onContentChanged(i);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onContentTemplateChanged() {
        n_onContentTemplateChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onHeaderContentChanged(int i) {
        n_onHeaderContentChanged(i);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onHeaderTemplateChanged() {
        n_onHeaderTemplateChanged();
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onRemoveItem(int i) {
        n_onRemoveItem(i);
    }

    @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
    public void onSetItem(int i) {
        n_onSetItem(i);
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
