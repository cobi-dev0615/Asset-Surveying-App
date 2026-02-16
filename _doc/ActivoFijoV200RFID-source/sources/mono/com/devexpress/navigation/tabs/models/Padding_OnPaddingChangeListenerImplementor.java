package mono.com.devexpress.navigation.tabs.models;

import com.devexpress.navigation.tabs.models.Padding;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class Padding_OnPaddingChangeListenerImplementor implements IGCUserPeer, Padding.OnPaddingChangeListener {
    public static final String __md_methods = "n_onPaddingChanged:()V:GetOnPaddingChangedHandler:DevExpress.Android.Navigation.Tabs.Models.Padding/IOnPaddingChangeListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onPaddingChanged();

    static {
        Runtime.register("DevExpress.Android.Navigation.Tabs.Models.Padding+IOnPaddingChangeListenerImplementor, DXNavigation.a", Padding_OnPaddingChangeListenerImplementor.class, __md_methods);
    }

    public Padding_OnPaddingChangeListenerImplementor() {
        if (getClass() == Padding_OnPaddingChangeListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.Tabs.Models.Padding+IOnPaddingChangeListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.tabs.models.Padding.OnPaddingChangeListener
    public void onPaddingChanged() {
        n_onPaddingChanged();
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
