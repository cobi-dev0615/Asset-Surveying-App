package crc64a59bfe4fc515a8dd;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PickerDataProvider implements IGCUserPeer, com.devexpress.dxgrid.providers.PickerDataProvider {
    public static final String __md_methods = "n_getItemCount:(I)I:GetGetItemCount_IHandler:DevExpress.Android.Grid.Providers.IPickerDataProviderInvoker, DXGrid.a\nn_getItemIndex:(I)I:GetGetItemIndex_IHandler:DevExpress.Android.Grid.Providers.IPickerDataProviderInvoker, DXGrid.a\nn_getText:(II)Ljava/lang/String;:GetGetText_IIHandler:DevExpress.Android.Grid.Providers.IPickerDataProviderInvoker, DXGrid.a\nn_setItemIndex:(II)Ljava/lang/String;:GetSetItemIndex_IIHandler:DevExpress.Android.Grid.Providers.IPickerDataProviderInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native int n_getItemCount(int i);

    private native int n_getItemIndex(int i);

    private native String n_getText(int i, int i2);

    private native String n_setItemIndex(int i, int i2);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.PickerDataProvider, DevExpress.Maui.DataGrid", PickerDataProvider.class, __md_methods);
    }

    public PickerDataProvider() {
        if (getClass() == PickerDataProvider.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.PickerDataProvider, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.PickerDataProvider
    public int getItemCount(int i) {
        return n_getItemCount(i);
    }

    @Override // com.devexpress.dxgrid.providers.PickerDataProvider
    public int getItemIndex(int i) {
        return n_getItemIndex(i);
    }

    @Override // com.devexpress.dxgrid.providers.PickerDataProvider
    public String getText(int i, int i2) {
        return n_getText(i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.PickerDataProvider
    public String setItemIndex(int i, int i2) {
        return n_setItemIndex(i, i2);
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
