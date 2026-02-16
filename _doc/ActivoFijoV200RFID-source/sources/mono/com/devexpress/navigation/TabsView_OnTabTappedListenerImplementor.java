package mono.com.devexpress.navigation;

import com.devexpress.navigation.TabsView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TabsView_OnTabTappedListenerImplementor implements IGCUserPeer, TabsView.OnTabTappedListener {
    public static final String __md_methods = "n_onTabTapped:(I)Z:GetOnTabTapped_IHandler:DevExpress.Android.Navigation.TabsView/IOnTabTappedListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native boolean n_onTabTapped(int i);

    static {
        Runtime.register("DevExpress.Android.Navigation.TabsView+IOnTabTappedListenerImplementor, DXNavigation.a", TabsView_OnTabTappedListenerImplementor.class, __md_methods);
    }

    public TabsView_OnTabTappedListenerImplementor() {
        if (getClass() == TabsView_OnTabTappedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.TabsView+IOnTabTappedListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.TabsView.OnTabTappedListener
    public boolean onTabTapped(int i) {
        return n_onTabTapped(i);
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
