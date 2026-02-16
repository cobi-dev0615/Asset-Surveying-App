package mono.com.devexpress.editors;

import com.devexpress.editors.DropDownStateChangedListener;
import com.devexpress.editors.EditBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DropDownStateChangedListenerImplementor implements IGCUserPeer, DropDownStateChangedListener {
    public static final String __md_methods = "n_onDropDownStateChanged:(Lcom/devexpress/editors/EditBase;Z)V:GetOnDropDownStateChanged_Lcom_devexpress_editors_EditBase_ZHandler:DevExpress.Android.Editors.IDropDownStateChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onDropDownStateChanged(EditBase editBase, boolean z);

    static {
        Runtime.register("DevExpress.Android.Editors.IDropDownStateChangedListenerImplementor, DXEditors.a", DropDownStateChangedListenerImplementor.class, __md_methods);
    }

    public DropDownStateChangedListenerImplementor() {
        if (getClass() == DropDownStateChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.IDropDownStateChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.DropDownStateChangedListener
    public void onDropDownStateChanged(EditBase editBase, boolean z) {
        n_onDropDownStateChanged(editBase, z);
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
