package crc64588f1aa41a024a66;

import android.view.View;
import com.devexpress.editors.dataForm.protocols.DXDataFormEditorItemErrorProvider;
import com.devexpress.editors.dataForm.protocols.DataFormPickerItem;
import com.devexpress.editors.dataForm.protocols.DataFormPickerItemDataProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DataFormComboBoxEditor extends DataFormEditorBase_1 implements IGCUserPeer, DataFormPickerItem {
    public static final String __md_methods = "n_setPickerDataProvider:(Lcom/devexpress/editors/dataForm/protocols/DataFormPickerItemDataProvider;)V:GetSetPickerDataProvider_Lcom_devexpress_editors_dataForm_protocols_DataFormPickerItemDataProvider_Handler:DevExpress.Android.Editors.DataForm.Protocols.IDataFormPickerItemInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_setPickerDataProvider(DataFormPickerItemDataProvider dataFormPickerItemDataProvider);

    static {
        Runtime.register("DevExpress.Maui.DataForm.Internal.DataFormComboBoxEditor, DevExpress.Maui.Editors", DataFormComboBoxEditor.class, __md_methods);
    }

    public DataFormComboBoxEditor(View view) {
        super(view);
        if (getClass() == DataFormComboBoxEditor.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormComboBoxEditor, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android", this, new Object[]{view});
        }
    }

    public DataFormComboBoxEditor(View view, DXDataFormEditorItemErrorProvider dXDataFormEditorItemErrorProvider) {
        super(view, dXDataFormEditorItemErrorProvider);
        if (getClass() == DataFormComboBoxEditor.class) {
            TypeManager.Activate("DevExpress.Maui.DataForm.Internal.DataFormComboBoxEditor, DevExpress.Maui.Editors", "Android.Views.View, Mono.Android:DevExpress.Android.Editors.DataForm.Protocols.DXDataFormEditorItemErrorProvider, DXEditors.a", this, new Object[]{view, dXDataFormEditorItemErrorProvider});
        }
    }

    @Override // com.devexpress.editors.dataForm.protocols.DataFormPickerItem
    public void setPickerDataProvider(DataFormPickerItemDataProvider dataFormPickerItemDataProvider) {
        n_setPickerDataProvider(dataFormPickerItemDataProvider);
    }

    @Override // crc64588f1aa41a024a66.DataFormEditorBase_1, crc64588f1aa41a024a66.DataFormAbstractEditorBase, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64588f1aa41a024a66.DataFormEditorBase_1, crc64588f1aa41a024a66.DataFormAbstractEditorBase, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
