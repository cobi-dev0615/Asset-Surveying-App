package mono.com.devexpress.navigation;

import com.devexpress.navigation.TabControl;
import com.devexpress.navigation.tabs.models.CancelEventArgs;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TabControl_OnTabItemTappedListenerImplementor implements IGCUserPeer, TabControl.OnTabItemTappedListener {
    public static final String __md_methods = "n_onTabItemTapped:(ILcom/devexpress/navigation/tabs/models/CancelEventArgs;)V:GetOnTabItemTapped_ILcom_devexpress_navigation_tabs_models_CancelEventArgs_Handler:DevExpress.Android.Navigation.TabControl/IOnTabItemTappedListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onTabItemTapped(int i, CancelEventArgs cancelEventArgs);

    static {
        Runtime.register("DevExpress.Android.Navigation.TabControl+IOnTabItemTappedListenerImplementor, DXNavigation.a", TabControl_OnTabItemTappedListenerImplementor.class, __md_methods);
    }

    public TabControl_OnTabItemTappedListenerImplementor() {
        if (getClass() == TabControl_OnTabItemTappedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.TabControl+IOnTabItemTappedListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.TabControl.OnTabItemTappedListener
    public void onTabItemTapped(int i, CancelEventArgs cancelEventArgs) {
        n_onTabItemTapped(i, cancelEventArgs);
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
