package crc64588f1aa41a024a66;

import android.view.View;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItemErrorProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DataFormCustomViewEditor extends DataFormAbstractEditorBase implements IGCUserPeer {
    public static final String __md_methods = "n_getView:()Landroid/view/View;:GetGetViewHandler\nn_commitEditorValue:()Z:GetCommitEditorValueHandler\nn_configure:()V:GetConfigureHandler\n";
    private ArrayList refList;

    private native boolean n_commitEditorValue();

    private native void n_configure();

    private native View n_getView();

    static {
        Runtime.register("DevExpress.Maui.DataForm.Internal.DataFormCustomViewEditor, DevExpress.Maui.Editors", DataFormCustomViewEditor.class, __md_methods);
    }

    public DataFormCustomViewEditor(View view) {
        super(view);
        if (getClass() == DataFormCustomViewEditor.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormCustomViewEditor, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android", this, new Object[]{view});
        }
    }

    public DataFormCustomViewEditor(View view, DXDataFormEditorItemErrorProvider dXDataFormEditorItemErrorProvider) {
        super(view, dXDataFormEditorItemErrorProvider);
        if (getClass() == DataFormCustomViewEditor.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormCustomViewEditor, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android:DevExpress.Android.Editors.DataForm.Protocols.DXDataFormEditorItemErrorProvider, DXEditors.a", this, new Object[]{view, dXDataFormEditorItemErrorProvider});
        }
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem
    public View getView() {
        return n_getView();
    }

    @Override // crc64588f1aa41a024a66.DataFormAbstractEditorBase, com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem
    public boolean commitEditorValue() {
        return n_commitEditorValue();
    }

    @Override // com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem
    public void configure() {
        n_configure();
    }

    @Override // crc64588f1aa41a024a66.DataFormAbstractEditorBase, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64588f1aa41a024a66.DataFormAbstractEditorBase, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
