package crc64a59bfe4fc515a8dd;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class GroupRowValueViewProvider extends GroupRowValueViewProviderBase implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.GroupRowValueViewProvider, DevExpress.Maui.DataGrid", GroupRowValueViewProvider.class, "");
    }

    public GroupRowValueViewProvider() {
        if (getClass() == GroupRowValueViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.GroupRowValueViewProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // crc64a59bfe4fc515a8dd.GroupRowValueViewProviderBase, crc64a59bfe4fc515a8dd.ViewProviderBase, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64a59bfe4fc515a8dd.GroupRowValueViewProviderBase, crc64a59bfe4fc515a8dd.ViewProviderBase, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
