package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.providers.TotalSummaryViewProviderBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TotalSummaryViewProvider extends ViewProviderBase implements IGCUserPeer, com.devexpress.dxgrid.providers.TotalSummaryViewProvider, TotalSummaryViewProviderBase {
    public static final String __md_methods = "n_canGet:(I)Z:GetCanGet_IHandler:DevExpress.Android.Grid.Providers.ITotalSummaryViewProviderInvoker, DXGrid.a\nn_getTotalSummaryView:(Landroid/content/Context;I)Landroid/view/View;:GetGetTotalSummaryView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.ITotalSummaryViewProviderBaseInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native boolean n_canGet(int i);

    private native View n_getTotalSummaryView(Context context, int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.TotalSummaryViewProvider, DevExpress.Maui.DataGrid", TotalSummaryViewProvider.class, __md_methods);
    }

    public TotalSummaryViewProvider() {
        if (getClass() == TotalSummaryViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.TotalSummaryViewProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.TotalSummaryViewProvider
    public boolean canGet(int i) {
        return n_canGet(i);
    }

    @Override // com.devexpress.dxgrid.providers.TotalSummaryViewProviderBase
    public View getTotalSummaryView(Context context, int i) {
        return n_getTotalSummaryView(context, i);
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
