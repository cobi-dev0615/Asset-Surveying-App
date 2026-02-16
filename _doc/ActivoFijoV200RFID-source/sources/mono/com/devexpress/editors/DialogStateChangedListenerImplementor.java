package mono.com.devexpress.editors;

import com.devexpress.editors.DialogStateChangedListener;
import com.devexpress.editors.EditBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DialogStateChangedListenerImplementor implements IGCUserPeer, DialogStateChangedListener {
    public static final String __md_methods = "n_onDialogStateChanged:(Lcom/devexpress/editors/EditBase;Z)V:GetOnDialogStateChanged_Lcom_devexpress_editors_EditBase_ZHandler:DevExpress.Android.Editors.IDialogStateChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onDialogStateChanged(EditBase editBase, boolean z);

    static {
        Runtime.register("DevExpress.Android.Editors.IDialogStateChangedListenerImplementor, DXEditors.a", DialogStateChangedListenerImplementor.class, __md_methods);
    }

    public DialogStateChangedListenerImplementor() {
        if (getClass() == DialogStateChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.IDialogStateChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.DialogStateChangedListener
    public void onDialogStateChanged(EditBase editBase, boolean z) {
        n_onDialogStateChanged(editBase, z);
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
