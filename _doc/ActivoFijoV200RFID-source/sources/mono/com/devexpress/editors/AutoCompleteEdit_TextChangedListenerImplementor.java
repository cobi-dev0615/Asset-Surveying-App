package mono.com.devexpress.editors;

import com.devexpress.editors.AutoCompleteEdit;
import com.devexpress.editors.DXAutoCompleteTextChangeReason;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AutoCompleteEdit_TextChangedListenerImplementor implements IGCUserPeer, AutoCompleteEdit.TextChangedListener {
    public static final String __md_methods = "n_onTextChanged:(Lcom/devexpress/editors/AutoCompleteEdit;Lcom/devexpress/editors/DXAutoCompleteTextChangeReason;)V:GetOnTextChanged_Lcom_devexpress_editors_AutoCompleteEdit_Lcom_devexpress_editors_DXAutoCompleteTextChangeReason_Handler:DevExpress.Android.Editors.AutoCompleteEdit/ITextChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onTextChanged(AutoCompleteEdit autoCompleteEdit, DXAutoCompleteTextChangeReason dXAutoCompleteTextChangeReason);

    static {
        Runtime.register("DevExpress.Android.Editors.AutoCompleteEdit+ITextChangedListenerImplementor, DXEditors.a", AutoCompleteEdit_TextChangedListenerImplementor.class, __md_methods);
    }

    public AutoCompleteEdit_TextChangedListenerImplementor() {
        if (getClass() == AutoCompleteEdit_TextChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.AutoCompleteEdit+ITextChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.AutoCompleteEdit.TextChangedListener
    public void onTextChanged(AutoCompleteEdit autoCompleteEdit, DXAutoCompleteTextChangeReason dXAutoCompleteTextChangeReason) {
        n_onTextChanged(autoCompleteEdit, dXAutoCompleteTextChangeReason);
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
