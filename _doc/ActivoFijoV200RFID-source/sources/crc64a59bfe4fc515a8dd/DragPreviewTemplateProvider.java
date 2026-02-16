package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DragPreviewTemplateProvider extends ViewProviderBase implements IGCUserPeer, com.devexpress.dxgrid.providers.DragPreviewTemplateProvider {
    public static final String __md_methods = "n_getDragPreview:(Landroid/content/Context;I)Landroid/view/View;:GetGetDragPreview_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.IDragPreviewTemplateProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native View n_getDragPreview(Context context, int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.DragPreviewTemplateProvider, DevExpress.Maui.DataGrid", DragPreviewTemplateProvider.class, __md_methods);
    }

    public DragPreviewTemplateProvider() {
        if (getClass() == DragPreviewTemplateProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.DragPreviewTemplateProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.DragPreviewTemplateProvider
    public View getDragPreview(Context context, int i) {
        return n_getDragPreview(context, i);
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
