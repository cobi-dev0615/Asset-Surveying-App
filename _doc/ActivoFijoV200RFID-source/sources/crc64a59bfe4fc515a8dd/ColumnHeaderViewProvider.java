package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ColumnHeaderViewProvider extends ViewProviderBase implements IGCUserPeer, com.devexpress.dxgrid.providers.ColumnHeaderViewProvider {
    public static final String __md_methods = "n_getColumnHeaderView:(Landroid/content/Context;I)Landroid/view/View;:GetGetColumnHeaderView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.IColumnHeaderViewProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native View n_getColumnHeaderView(Context context, int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.ColumnHeaderViewProvider, DevExpress.Maui.DataGrid", ColumnHeaderViewProvider.class, __md_methods);
    }

    public ColumnHeaderViewProvider() {
        if (getClass() == ColumnHeaderViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.ColumnHeaderViewProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.ColumnHeaderViewProvider
    public View getColumnHeaderView(Context context, int i) {
        return n_getColumnHeaderView(context, i);
    }

    @Override // crc64a59bfe4fc515a8dd.ViewProviderBase, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64a59bfe4fc515a8dd.ViewProviderBase, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
