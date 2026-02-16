package mono.com.devexpress.editors;

import com.devexpress.editors.AutoCompleteEdit;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AutoCompleteEdit_QuerySubmittedListenerImplementor implements IGCUserPeer, AutoCompleteEdit.QuerySubmittedListener {
    public static final String __md_methods = "n_onQuerySubmitted:(Lcom/devexpress/editors/AutoCompleteEdit;Ljava/lang/CharSequence;)V:GetOnQuerySubmitted_Lcom_devexpress_editors_AutoCompleteEdit_Ljava_lang_CharSequence_Handler:DevExpress.Android.Editors.AutoCompleteEdit/IQuerySubmittedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onQuerySubmitted(AutoCompleteEdit autoCompleteEdit, CharSequence charSequence);

    static {
        Runtime.register("DevExpress.Android.Editors.AutoCompleteEdit+IQuerySubmittedListenerImplementor, DXEditors.a", AutoCompleteEdit_QuerySubmittedListenerImplementor.class, __md_methods);
    }

    public AutoCompleteEdit_QuerySubmittedListenerImplementor() {
        if (getClass() == AutoCompleteEdit_QuerySubmittedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.AutoCompleteEdit+IQuerySubmittedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.AutoCompleteEdit.QuerySubmittedListener
    public void onQuerySubmitted(AutoCompleteEdit autoCompleteEdit, CharSequence charSequence) {
        n_onQuerySubmitted(autoCompleteEdit, charSequence);
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
