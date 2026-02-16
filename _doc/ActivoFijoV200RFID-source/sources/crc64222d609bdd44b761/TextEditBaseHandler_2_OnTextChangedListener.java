package crc64222d609bdd44b761;

import com.devexpress.editors.OnTextChangedListener;
import com.devexpress.editors.TextEditBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TextEditBaseHandler_2_OnTextChangedListener implements IGCUserPeer, OnTextChangedListener {
    public static final String __md_methods = "n_onTextChanged:(Lcom/devexpress/editors/TextEditBase;Ljava/lang/CharSequence;)V:GetOnTextChanged_Lcom_devexpress_editors_TextEditBase_Ljava_lang_CharSequence_Handler:DevExpress.Android.Editors.IOnTextChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onTextChanged(TextEditBase textEditBase, CharSequence charSequence);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.TextEditBaseHandler`2+OnTextChangedListener, DevExpress.Maui.Editors", TextEditBaseHandler_2_OnTextChangedListener.class, "n_onTextChanged:(Lcom/devexpress/editors/TextEditBase;Ljava/lang/CharSequence;)V:GetOnTextChanged_Lcom_devexpress_editors_TextEditBase_Ljava_lang_CharSequence_Handler:DevExpress.Android.Editors.IOnTextChangedListenerInvoker, DXEditors.a\n");
    }

    public TextEditBaseHandler_2_OnTextChangedListener() {
        if (getClass() == TextEditBaseHandler_2_OnTextChangedListener.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.TextEditBaseHandler`2+OnTextChangedListener, DevExpress.Maui.Editors", "", this, new Object[0]);
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
