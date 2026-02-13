package crc64588f1aa41a024a66;

import android.content.Context;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItem;
import com.devexpress.editors.dataForm.protocols.DataFormEditorFactory;
import com.devexpress.editors.dataForm.protocols.EditorType;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class XamarinEditorsCreator extends DataFormEditorFactory implements IGCUserPeer {
    public static final String __md_methods = "n_create:(Landroid/content/Context;Lcom/devexpress/editors/dataForm/protocols/EditorType;II)Lcom/devexpress/editors/dataForm/protocols/DXDataFormEditorItem;:GetCreate_Landroid_content_Context_Lcom_devexpress_editors_dataForm_protocols_EditorType_IIHandler\n";
    private ArrayList refList;

    private native DXDataFormEditorItem n_create(Context context, EditorType editorType, int i, int i2);

    static {
        Runtime.register("DevExpress.Maui.DataForm.Internal.XamarinEditorsCreator, DevExpress.Maui.Editors", XamarinEditorsCreator.class, __md_methods);
    }

    public XamarinEditorsCreator() {
        if (getClass() == XamarinEditorsCreator.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.XamarinEditorsCreator, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.dataForm.protocols.DataFormEditorFactory
    public DXDataFormEditorItem create(Context context, EditorType editorType, int i, int i2) {
        return n_create(context, editorType, i, i2);
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
