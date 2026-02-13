package crc64a59bfe4fc515a8dd;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SwipeButtonAction implements IGCUserPeer, com.devexpress.dxgrid.providers.SwipeButtonAction {
    public static final String __md_methods = "n_onTap:(I)V:GetOnTap_IHandler:DevExpress.Android.Grid.Providers.ISwipeButtonActionInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native void n_onTap(int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.SwipeButtonAction, DevExpress.Maui.DataGrid", SwipeButtonAction.class, __md_methods);
    }

    public SwipeButtonAction() {
        if (getClass() == SwipeButtonAction.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.SwipeButtonAction, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.SwipeButtonAction
    public void onTap(int i) {
        n_onTap(i);
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
