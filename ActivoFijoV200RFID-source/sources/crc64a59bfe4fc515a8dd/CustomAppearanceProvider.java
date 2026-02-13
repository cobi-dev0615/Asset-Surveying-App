package crc64a59bfe4fc515a8dd;

import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CustomAppearanceProvider implements IGCUserPeer, com.devexpress.dxgrid.models.columns.CustomAppearanceProvider {
    public static final String __md_methods = "n_getCustomAppearance:(I)Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;:GetGetCustomAppearance_IHandler:DevExpress.Android.Grid.Models.Columns.ICustomAppearanceProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native AppearanceBase n_getCustomAppearance(int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.CustomAppearanceProvider, DevExpress.Maui.DataGrid", CustomAppearanceProvider.class, __md_methods);
    }

    public CustomAppearanceProvider() {
        if (getClass() == CustomAppearanceProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.CustomAppearanceProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.models.columns.CustomAppearanceProvider
    public AppearanceBase getCustomAppearance(int i) {
        return n_getCustomAppearance(i);
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
