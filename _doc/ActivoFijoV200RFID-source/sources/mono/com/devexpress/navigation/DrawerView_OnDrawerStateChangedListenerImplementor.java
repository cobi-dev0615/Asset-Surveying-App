package mono.com.devexpress.navigation;

import com.devexpress.navigation.DrawerView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DrawerView_OnDrawerStateChangedListenerImplementor implements IGCUserPeer, DrawerView.OnDrawerStateChangedListener {
    public static final String __md_methods = "n_OnDrawerStateChanged:(Z)V:GetOnDrawerStateChanged_ZHandler:DevExpress.Android.Navigation.DrawerView/IOnDrawerStateChangedListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_OnDrawerStateChanged(boolean z);

    static {
        Runtime.register("DevExpress.Android.Navigation.DrawerView+IOnDrawerStateChangedListenerImplementor, DXNavigation.a", DrawerView_OnDrawerStateChangedListenerImplementor.class, __md_methods);
    }

    public DrawerView_OnDrawerStateChangedListenerImplementor() {
        if (getClass() == DrawerView_OnDrawerStateChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.DrawerView+IOnDrawerStateChangedListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.DrawerView.OnDrawerStateChangedListener
    public void OnDrawerStateChanged(boolean z) {
        n_OnDrawerStateChanged(z);
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
