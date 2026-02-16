package mono.com.devexpress.editors;

import com.devexpress.editors.OnEditActionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class OnEditActionListenerImplementor implements IGCUserPeer, OnEditActionListener {
    public static final String __md_methods = "n_onEditorAction:(I)Z:GetOnEditorAction_IHandler:DevExpress.Android.Editors.IOnEditActionListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_onEditorAction(int i);

    static {
        Runtime.register("DevExpress.Android.Editors.IOnEditActionListenerImplementor, DXEditors.a", OnEditActionListenerImplementor.class, "n_onEditorAction:(I)Z:GetOnEditorAction_IHandler:DevExpress.Android.Editors.IOnEditActionListenerInvoker, DXEditors.a\n");
    }

    public OnEditActionListenerImplementor() {
        if (getClass() == OnEditActionListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.IOnEditActionListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.OnEditActionListener
    public boolean onEditorAction(int i) {
        return n_onEditorAction(i);
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
