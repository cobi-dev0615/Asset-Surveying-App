package mono.com.devexpress.editors;

import com.devexpress.editors.AutoCompleteEdit;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AutoCompleteEdit_ItemSelectedListenerImplementor implements IGCUserPeer, AutoCompleteEdit.ItemSelectedListener {
    public static final String __md_methods = "n_onItemSelected:(Lcom/devexpress/editors/AutoCompleteEdit;Ljava/lang/Object;)V:GetOnItemSelected_Lcom_devexpress_editors_AutoCompleteEdit_Ljava_lang_Object_Handler:DevExpress.Android.Editors.AutoCompleteEdit/IItemSelectedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onItemSelected(AutoCompleteEdit autoCompleteEdit, Object obj);

    static {
        Runtime.register("DevExpress.Android.Editors.AutoCompleteEdit+IItemSelectedListenerImplementor, DXEditors.a", AutoCompleteEdit_ItemSelectedListenerImplementor.class, __md_methods);
    }

    public AutoCompleteEdit_ItemSelectedListenerImplementor() {
        if (getClass() == AutoCompleteEdit_ItemSelectedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.AutoCompleteEdit+IItemSelectedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.AutoCompleteEdit.ItemSelectedListener
    public void onItemSelected(AutoCompleteEdit autoCompleteEdit, Object obj) {
        n_onItemSelected(autoCompleteEdit, obj);
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
