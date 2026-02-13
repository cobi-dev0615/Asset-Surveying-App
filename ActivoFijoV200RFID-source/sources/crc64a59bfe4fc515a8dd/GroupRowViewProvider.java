package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.providers.GroupRowViewProviderBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class GroupRowViewProvider extends ViewProviderBase implements IGCUserPeer, com.devexpress.dxgrid.providers.GroupRowViewProvider, GroupRowViewProviderBase {
    public static final String __md_methods = "n_canUpdate:(I)Z:GetCanUpdate_IHandler:DevExpress.Android.Grid.Providers.IGroupRowViewProviderInvoker, DXGrid.a\nn_getView:(Landroid/content/Context;I)Landroid/view/View;:GetGetView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.IGroupRowViewProviderBaseInvoker, DXGrid.a\nn_updateView:(Landroid/content/Context;Landroid/view/View;I)V:GetUpdateView_Landroid_content_Context_Landroid_view_View_IHandler:DevExpress.Android.Grid.Providers.IGroupRowViewProviderBaseInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native boolean n_canUpdate(int i);

    private native View n_getView(Context context, int i);

    private native void n_updateView(Context context, View view, int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.GroupRowViewProvider, DevExpress.Maui.DataGrid", GroupRowViewProvider.class, __md_methods);
    }

    public GroupRowViewProvider() {
        if (getClass() == GroupRowViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.GroupRowViewProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.GroupRowViewProvider
    public boolean canUpdate(int i) {
        return n_canUpdate(i);
    }

    @Override // com.devexpress.dxgrid.providers.GroupRowViewProviderBase
    public View getView(Context context, int i) {
        return n_getView(context, i);
    }

    @Override // com.devexpress.dxgrid.providers.GroupRowViewProviderBase
    public void updateView(Context context, View view, int i) {
        n_updateView(context, view, i);
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
