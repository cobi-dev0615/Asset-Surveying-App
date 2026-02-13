package crc64588f1aa41a024a66;

import android.view.View;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItemErrorProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public abstract class DataFormAbstractEditorBase extends DXDataFormEditorItem implements IGCUserPeer {
    public static final String __md_methods = "n_commitEditorValue:()Z:GetCommitEditorValueHandler\nn_validateEditorValue:()Z:GetValidateEditorValueHandler\nn_resetEditorValue:()V:GetResetEditorValueHandler\nn_getEditorWrappedValue:()Ljava/lang/Object;:GetGetEditorWrappedValueHandler\n";
    private ArrayList refList;

    private native boolean n_commitEditorValue();

    private native Object n_getEditorWrappedValue();

    private native void n_resetEditorValue();

    private native boolean n_validateEditorValue();

    static {
        Runtime.register("DevExpress.Maui.DataForm.Internal.DataFormAbstractEditorBase, DevExpress.Maui.Editors", DataFormAbstractEditorBase.class, __md_methods);
    }

    public DataFormAbstractEditorBase(View view) {
        super(view);
        if (getClass() == DataFormAbstractEditorBase.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormAbstractEditorBase, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android", this, new Object[]{view});
        }
    }

    public DataFormAbstractEditorBase(View view, DXDataFormEditorItemErrorProvider dXDataFormEditorItemErrorProvider) {
        super(view, dXDataFormEditorItemErrorProvider);
        if (getClass() == DataFormAbstractEditorBase.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormAbstractEditorBase, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android:DevExpress.Android.Editors.DataForm.Protocols.DXDataFormEditorItemErrorProvider, DXEditors.a", this, new Object[]{view, dXDataFormEditorItemErrorProvider});
        }
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem
    public boolean commitEditorValue() {
        return n_commitEditorValue();
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem
    public boolean validateEditorValue() {
        return n_validateEditorValue();
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem
    public void resetEditorValue() {
        n_resetEditorValue();
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem
    public Object getEditorWrappedValue() {
        return n_getEditorWrappedValue();
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
