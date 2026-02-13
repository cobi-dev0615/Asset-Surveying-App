package crc64a59bfe4fc515a8dd;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ViewProviderBase implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.ViewProviderBase, DevExpress.Maui.DataGrid", ViewProviderBase.class, "");
    }

    public ViewProviderBase() {
        if (getClass() == ViewProviderBase.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.ViewProviderBase, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
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
