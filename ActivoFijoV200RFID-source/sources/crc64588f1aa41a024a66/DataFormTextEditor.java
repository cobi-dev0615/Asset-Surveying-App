package crc64588f1aa41a024a66;

import android.view.View;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItemErrorProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DataFormTextEditor extends DataFormTextEditorBase_2 implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.DataForm.Internal.DataFormTextEditor, DevExpress.Maui.Editors", DataFormTextEditor.class, "");
    }

    public DataFormTextEditor(View view) {
        super(view);
        if (getClass() == DataFormTextEditor.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormTextEditor, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android", this, new Object[]{view});
        }
    }

    public DataFormTextEditor(View view, DXDataFormEditorItemErrorProvider dXDataFormEditorItemErrorProvider) {
        super(view, dXDataFormEditorItemErrorProvider);
        if (getClass() == DataFormTextEditor.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormTextEditor, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android:DevExpress.Android.Editors.DataForm.Protocols.DXDataFormEditorItemErrorProvider, DXEditors.a", this, new Object[]{view, dXDataFormEditorItemErrorProvider});
        }
    }

    @Override // crc64588f1aa41a024a66.DataFormTextEditorBase_2, crc64588f1aa41a024a66.DataFormEditorBase_1, crc64588f1aa41a024a66.DataFormAbstractEditorBase, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64588f1aa41a024a66.DataFormTextEditorBase_2, crc64588f1aa41a024a66.DataFormEditorBase_1, crc64588f1aa41a024a66.DataFormAbstractEditorBase, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
