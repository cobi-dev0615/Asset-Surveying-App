package crc64588f1aa41a024a66;

import com.devexpress.editors.DataFormView;
import com.devexpress.editors.OnDataFromChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DataFormWrapperDelegate implements IGCUserPeer, OnDataFromChangedListener {
    public static final String __md_methods = "n_groupCollapseChanged:(IZ)V:GetGroupCollapseChanged_IZHandler:DevExpress.Android.Editors.IOnDataFromChangedListenerInvoker, DXEditors.a\nn_sizeChanged:(Lcom/devexpress/editors/DataFormView;)V:GetSizeChanged_Lcom_devexpress_editors_DataFormView_Handler:DevExpress.Android.Editors.IOnDataFromChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_groupCollapseChanged(int i, boolean z);

    private native void n_sizeChanged(DataFormView dataFormView);

    static {
        Runtime.register("DevExpress.Maui.DataForm.Internal.DataFormWrapperDelegate, DevExpress.Maui.Editors", DataFormWrapperDelegate.class, "n_groupCollapseChanged:(IZ)V:GetGroupCollapseChanged_IZHandler:DevExpress.Android.Editors.IOnDataFromChangedListenerInvoker, DXEditors.a\nn_sizeChanged:(Lcom/devexpress/editors/DataFormView;)V:GetSizeChanged_Lcom_devexpress_editors_DataFormView_Handler:DevExpress.Android.Editors.IOnDataFromChangedListenerInvoker, DXEditors.a\n");
    }

    public DataFormWrapperDelegate() {
        if (getClass() == DataFormWrapperDelegate.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormWrapperDelegate, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.OnDataFromChangedListener
    public void groupCollapseChanged(int i, boolean z) {
        n_groupCollapseChanged(i, z);
    }

    @Override // com.devexpress.editors.OnDataFromChangedListener
    public void sizeChanged(DataFormView dataFormView) {
        n_sizeChanged(dataFormView);
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
