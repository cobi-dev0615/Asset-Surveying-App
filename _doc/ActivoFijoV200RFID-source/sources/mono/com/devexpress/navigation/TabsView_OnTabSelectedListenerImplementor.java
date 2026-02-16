package mono.com.devexpress.navigation;

import com.devexpress.navigation.TabsView;
import com.devexpress.navigation.tabs.views.TabItemView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TabsView_OnTabSelectedListenerImplementor implements IGCUserPeer, TabsView.OnTabSelectedListener {
    public static final String __md_methods = "n_onTabSelected:(Lcom/devexpress/navigation/tabs/views/TabItemView;II)V:GetOnTabSelected_Lcom_devexpress_navigation_tabs_views_TabItemView_IIHandler:DevExpress.Android.Navigation.TabsView/IOnTabSelectedListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onTabSelected(TabItemView tabItemView, int i, int i2);

    static {
        Runtime.register("DevExpress.Android.Navigation.TabsView+IOnTabSelectedListenerImplementor, DXNavigation.a", TabsView_OnTabSelectedListenerImplementor.class, __md_methods);
    }

    public TabsView_OnTabSelectedListenerImplementor() {
        if (getClass() == TabsView_OnTabSelectedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.TabsView+IOnTabSelectedListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.TabsView.OnTabSelectedListener
    public void onTabSelected(TabItemView tabItemView, int i, int i2) {
        n_onTabSelected(tabItemView, i, i2);
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
