package mono.com.devexpress.editors;

import com.devexpress.editors.ComboBoxEdit;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ComboBoxEdit_OnFilterTextChangedListenerImplementor implements IGCUserPeer, ComboBoxEdit.OnFilterTextChangedListener {
    public static final String __md_methods = "n_onFilterTextChanged:(Lcom/devexpress/editors/ComboBoxEdit;Ljava/lang/CharSequence;)V:GetOnFilterTextChanged_Lcom_devexpress_editors_ComboBoxEdit_Ljava_lang_CharSequence_Handler:DevExpress.Android.Editors.ComboBoxEdit/IOnFilterTextChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onFilterTextChanged(ComboBoxEdit comboBoxEdit, CharSequence charSequence);

    static {
        Runtime.register("DevExpress.Android.Editors.ComboBoxEdit+IOnFilterTextChangedListenerImplementor, DXEditors.a", ComboBoxEdit_OnFilterTextChangedListenerImplementor.class, __md_methods);
    }

    public ComboBoxEdit_OnFilterTextChangedListenerImplementor() {
        if (getClass() == ComboBoxEdit_OnFilterTextChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.ComboBoxEdit+IOnFilterTextChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.ComboBoxEdit.OnFilterTextChangedListener
    public void onFilterTextChanged(ComboBoxEdit comboBoxEdit, CharSequence charSequence) {
        n_onFilterTextChanged(comboBoxEdit, charSequence);
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
