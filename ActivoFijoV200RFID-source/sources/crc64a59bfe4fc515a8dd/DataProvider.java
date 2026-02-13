package crc64a59bfe4fc515a8dd;

import com.devexpress.dxgrid.models.GroupInfo;
import com.devexpress.dxgrid.utils.ObjectLambda;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DataProvider implements IGCUserPeer, com.devexpress.dxgrid.providers.DataProvider {
    public static final String __md_methods = "n_getRowCount:()I:GetGetRowCountHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_getCellErrorText:(Ljava/lang/String;I)Ljava/lang/String;:GetGetCellErrorText_Ljava_lang_String_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_getDisplayText:(Ljava/lang/Object;Ljava/lang/String;I)Ljava/lang/String;:GetGetDisplayText_Ljava_lang_Object_Ljava_lang_String_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_getDisplayText:(Ljava/lang/String;I)Ljava/lang/String;:GetGetDisplayText_Ljava_lang_String_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_getGroupInfo:(I)Lcom/devexpress/dxgrid/models/GroupInfo;:GetGetGroupInfo_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_getTotalSummary:(I)Ljava/lang/String;:GetGetTotalSummary_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_getValue:(Ljava/lang/String;I)Ljava/lang/Object;:GetGetValue_Ljava_lang_String_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_getValueAsync:(Ljava/lang/String;ILcom/devexpress/dxgrid/utils/ObjectLambda;)V:GetGetValueAsync_Ljava_lang_String_ILcom_devexpress_dxgrid_utils_ObjectLambda_Handler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_isGroupRow:(I)Z:GetIsGroupRow_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_isSelected:(I)Z:GetIsSelected_IHandler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\nn_setCellValue:(Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;:GetSetCellValue_Ljava_lang_String_ILjava_lang_Object_Handler:DevExpress.Android.Grid.Providers.IDataProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native String n_getCellErrorText(String str, int i);

    private native String n_getDisplayText(Object obj, String str, int i);

    private native String n_getDisplayText(String str, int i);

    private native GroupInfo n_getGroupInfo(int i);

    private native int n_getRowCount();

    private native String n_getTotalSummary(int i);

    private native Object n_getValue(String str, int i);

    private native void n_getValueAsync(String str, int i, ObjectLambda objectLambda);

    private native boolean n_isGroupRow(int i);

    private native boolean n_isSelected(int i);

    private native String n_setCellValue(String str, int i, Object obj);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.DataProvider, DevExpress.Maui.DataGrid", DataProvider.class, __md_methods);
    }

    public DataProvider() {
        if (getClass() == DataProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.DataProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public int getRowCount() {
        return n_getRowCount();
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getCellErrorText(String str, int i) {
        return n_getCellErrorText(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getDisplayText(Object obj, String str, int i) {
        return n_getDisplayText(obj, str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getDisplayText(String str, int i) {
        return n_getDisplayText(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public GroupInfo getGroupInfo(int i) {
        return n_getGroupInfo(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getTotalSummary(int i) {
        return n_getTotalSummary(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public Object getValue(String str, int i) {
        return n_getValue(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public void getValueAsync(String str, int i, ObjectLambda objectLambda) {
        n_getValueAsync(str, i, objectLambda);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public boolean isGroupRow(int i) {
        return n_isGroupRow(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public boolean isSelected(int i) {
        return n_isSelected(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String setCellValue(String str, int i, Object obj) {
        return n_setCellValue(str, i, obj);
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
