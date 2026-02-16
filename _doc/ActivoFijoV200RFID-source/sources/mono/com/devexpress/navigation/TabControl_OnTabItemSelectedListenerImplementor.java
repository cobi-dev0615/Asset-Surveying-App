package mono.com.devexpress.navigation;

import com.devexpress.navigation.TabControl;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TabControl_OnTabItemSelectedListenerImplementor implements IGCUserPeer, TabControl.OnTabItemSelectedListener {
    public static final String __md_methods = "n_onTabItemSelected:(II)V:GetOnTabItemSelected_IIHandler:DevExpress.Android.Navigation.TabControl/IOnTabItemSelectedListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onTabItemSelected(int i, int i2);

    static {
        Runtime.register("DevExpress.Android.Navigation.TabControl+IOnTabItemSelectedListenerImplementor, DXNavigation.a", TabControl_OnTabItemSelectedListenerImplementor.class, __md_methods);
    }

    public TabControl_OnTabItemSelectedListenerImplementor() {
        if (getClass() == TabControl_OnTabItemSelectedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.TabControl+IOnTabItemSelectedListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.TabControl.OnTabItemSelectedListener
    public void onTabItemSelected(int i, int i2) {
        n_onTabItemSelected(i, i2);
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
