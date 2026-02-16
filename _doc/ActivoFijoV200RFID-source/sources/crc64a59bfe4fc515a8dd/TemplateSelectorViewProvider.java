package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.ViewProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TemplateSelectorViewProvider extends ViewProviderBase implements IGCUserPeer, ViewProvider {
    public static final String __md_methods = "n_requestView:(Landroid/content/Context;I)Landroid/view/View;:GetRequestView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\nn_storeAsFree:(Landroid/view/View;)V:GetStoreAsFree_Landroid_view_View_Handler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\nn_updateAppearance:(Landroid/view/View;Lcom/devexpress/dxgrid/models/columns/GridColumnModel;Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;I)V:GetUpdateAppearance_Landroid_view_View_Lcom_devexpress_dxgrid_models_columns_GridColumnModel_Lcom_devexpress_dxgrid_models_appearance_AppearanceBase_IHandler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\nn_updateContent:(Landroid/view/View;Lcom/devexpress/dxgrid/providers/DataProvider;Ljava/lang/String;I)V:GetUpdateContent_Landroid_view_View_Lcom_devexpress_dxgrid_providers_DataProvider_Ljava_lang_String_IHandler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native View n_requestView(Context context, int i);

    private native void n_storeAsFree(View view);

    private native void n_updateAppearance(View view, GridColumnModel gridColumnModel, AppearanceBase appearanceBase, int i);

    private native void n_updateContent(View view, com.devexpress.dxgrid.providers.DataProvider dataProvider, String str, int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.TemplateSelectorViewProvider, DevExpress.Maui.DataGrid", TemplateSelectorViewProvider.class, "n_requestView:(Landroid/content/Context;I)Landroid/view/View;:GetRequestView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\nn_storeAsFree:(Landroid/view/View;)V:GetStoreAsFree_Landroid_view_View_Handler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\nn_updateAppearance:(Landroid/view/View;Lcom/devexpress/dxgrid/models/columns/GridColumnModel;Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;I)V:GetUpdateAppearance_Landroid_view_View_Lcom_devexpress_dxgrid_models_columns_GridColumnModel_Lcom_devexpress_dxgrid_models_appearance_AppearanceBase_IHandler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\nn_updateContent:(Landroid/view/View;Lcom/devexpress/dxgrid/providers/DataProvider;Ljava/lang/String;I)V:GetUpdateContent_Landroid_view_View_Lcom_devexpress_dxgrid_providers_DataProvider_Ljava_lang_String_IHandler:DevExpress.Android.Grid.Providers.IViewProviderInvoker, DXGrid.a\n");
    }

    public TemplateSelectorViewProvider() {
        if (getClass() == TemplateSelectorViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.TemplateSelectorViewProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public View requestView(Context context, int i) {
        return n_requestView(context, i);
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void storeAsFree(View view) {
        n_storeAsFree(view);
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateAppearance(View view, GridColumnModel gridColumnModel, AppearanceBase appearanceBase, int i) {
        n_updateAppearance(view, gridColumnModel, appearanceBase, i);
    }

    @Override // com.devexpress.dxgrid.providers.ViewProvider
    public void updateContent(View view, com.devexpress.dxgrid.providers.DataProvider dataProvider, String str, int i) {
        n_updateContent(view, dataProvider, str, i);
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
