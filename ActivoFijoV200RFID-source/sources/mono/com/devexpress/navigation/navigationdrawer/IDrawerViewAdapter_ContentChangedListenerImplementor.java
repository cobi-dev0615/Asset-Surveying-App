package mono.com.devexpress.navigation.navigationdrawer;

import com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class IDrawerViewAdapter_ContentChangedListenerImplementor implements IGCUserPeer, IDrawerViewAdapter.ContentChangedListener {
    public static final String __md_methods = "n_onContentChanged:()V:GetOnContentChangedHandler:DevExpress.Android.Navigation.Navigationdrawer.IDrawerViewAdapter/IContentChangedListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_onContentChanged();

    static {
        Runtime.register("DevExpress.Android.Navigation.Navigationdrawer.IDrawerViewAdapter+IContentChangedListenerImplementor, DXNavigation.a", IDrawerViewAdapter_ContentChangedListenerImplementor.class, __md_methods);
    }

    public IDrawerViewAdapter_ContentChangedListenerImplementor() {
        if (getClass() == IDrawerViewAdapter_ContentChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.Navigationdrawer.IDrawerViewAdapter+IContentChangedListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter.ContentChangedListener
    public void onContentChanged() {
        n_onContentChanged();
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
