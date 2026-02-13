package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.providers.EditViewProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ComplexEditViewProvider implements IGCUserPeer, EditViewProvider {
    public static final String __md_methods = "n_isPaddingInEditor:()Z:GetIsPaddingInEditorHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_getEditableView:(Landroid/content/Context;I)Landroid/view/View;:GetGetEditableView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_open:(ZI)V:GetOpen_ZIHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_setRequestUpdateRunnable:(Ljava/lang/Runnable;I)V:GetSetRequestUpdateRunnable_Ljava_lang_Runnable_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_submitEditValue:(Landroid/view/View;I)Ljava/lang/String;:GetSubmitEditValue_Landroid_view_View_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_updateAppearance:(Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;I)V:GetUpdateAppearance_Lcom_devexpress_dxgrid_models_appearance_AppearanceBase_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_updateAppearance:(I)V:GetUpdateAppearance_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_updateContent:(I)V:GetUpdateContent_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native View n_getEditableView(Context context, int i);

    private native boolean n_isPaddingInEditor();

    private native void n_open(boolean z, int i);

    private native void n_setRequestUpdateRunnable(Runnable runnable, int i);

    private native String n_submitEditValue(View view, int i);

    private native void n_updateAppearance(int i);

    private native void n_updateAppearance(AppearanceBase appearanceBase, int i);

    private native void n_updateContent(int i);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.ComplexEditViewProvider, DevExpress.Maui.DataGrid", ComplexEditViewProvider.class, "n_isPaddingInEditor:()Z:GetIsPaddingInEditorHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_getEditableView:(Landroid/content/Context;I)Landroid/view/View;:GetGetEditableView_Landroid_content_Context_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_open:(ZI)V:GetOpen_ZIHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_setRequestUpdateRunnable:(Ljava/lang/Runnable;I)V:GetSetRequestUpdateRunnable_Ljava_lang_Runnable_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_submitEditValue:(Landroid/view/View;I)Ljava/lang/String;:GetSubmitEditValue_Landroid_view_View_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_updateAppearance:(Lcom/devexpress/dxgrid/models/appearance/AppearanceBase;I)V:GetUpdateAppearance_Lcom_devexpress_dxgrid_models_appearance_AppearanceBase_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_updateAppearance:(I)V:GetUpdateAppearance_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\nn_updateContent:(I)V:GetUpdateContent_IHandler:DevExpress.Android.Grid.Providers.IEditViewProviderInvoker, DXGrid.a\n");
    }

    public ComplexEditViewProvider() {
        if (getClass() == ComplexEditViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.ComplexEditViewProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public boolean isPaddingInEditor() {
        return n_isPaddingInEditor();
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public View getEditableView(Context context, int i) {
        return n_getEditableView(context, i);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void open(boolean z, int i) {
        n_open(z, i);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void setRequestUpdateRunnable(Runnable runnable, int i) {
        n_setRequestUpdateRunnable(runnable, i);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public String submitEditValue(View view, int i) {
        return n_submitEditValue(view, i);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void updateAppearance(AppearanceBase appearanceBase, int i) {
        n_updateAppearance(appearanceBase, i);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void updateAppearance(int i) {
        n_updateAppearance(i);
    }

    @Override // com.devexpress.dxgrid.providers.EditViewProvider
    public void updateContent(int i) {
        n_updateContent(i);
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
