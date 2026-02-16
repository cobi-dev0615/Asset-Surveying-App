package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.providers.SwipeButtonViewProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SwipeItemViewProvider extends ViewProviderBase implements IGCUserPeer, SwipeButtonViewProvider {
    public static final String __md_methods = "n_getView:(Landroid/content/Context;I)Landroid/view/View;:GetGetView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.ISwipeButtonViewProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native View n_getView(Context context, int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.SwipeItemViewProvider, DevExpress.Maui.DataGrid", SwipeItemViewProvider.class, __md_methods);
    }

    public SwipeItemViewProvider() {
        if (getClass() == SwipeItemViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.SwipeItemViewProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.SwipeButtonViewProvider
    public View getView(Context context, int i) {
        return n_getView(context, i);
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
