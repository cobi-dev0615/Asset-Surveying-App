package mono.com.devexpress.editors;

import com.devexpress.editors.OnTextChangedListener;
import com.devexpress.editors.TextEditBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class OnTextChangedListenerImplementor implements IGCUserPeer, OnTextChangedListener {
    public static final String __md_methods = "n_onTextChanged:(Lcom/devexpress/editors/TextEditBase;Ljava/lang/CharSequence;)V:GetOnTextChanged_Lcom_devexpress_editors_TextEditBase_Ljava_lang_CharSequence_Handler:DevExpress.Android.Editors.IOnTextChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onTextChanged(TextEditBase textEditBase, CharSequence charSequence);

    static {
        Runtime.register("DevExpress.Android.Editors.IOnTextChangedListenerImplementor, DXEditors.a", OnTextChangedListenerImplementor.class, "n_onTextChanged:(Lcom/devexpress/editors/TextEditBase;Ljava/lang/CharSequence;)V:GetOnTextChanged_Lcom_devexpress_editors_TextEditBase_Ljava_lang_CharSequence_Handler:DevExpress.Android.Editors.IOnTextChangedListenerInvoker, DXEditors.a\n");
    }

    public OnTextChangedListenerImplementor() {
        if (getClass() == OnTextChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.IOnTextChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.OnTextChangedListener
    public void onTextChanged(TextEditBase textEditBase, CharSequence charSequence) {
        n_onTextChanged(textEditBase, charSequence);
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
