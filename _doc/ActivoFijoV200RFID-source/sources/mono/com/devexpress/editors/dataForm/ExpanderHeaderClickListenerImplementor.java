package mono.com.devexpress.editors.dataForm;

import com.devexpress.editors.dataForm.ExpanderHeaderClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ExpanderHeaderClickListenerImplementor implements IGCUserPeer, ExpanderHeaderClickListener {
    public static final String __md_methods = "n_onHeaderClicked:()V:GetOnHeaderClickedHandler:DevExpress.Android.Editors.DataForm.IExpanderHeaderClickListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onHeaderClicked();

    static {
        Runtime.register("DevExpress.Android.Editors.DataForm.IExpanderHeaderClickListenerImplementor, DXEditors.a", ExpanderHeaderClickListenerImplementor.class, __md_methods);
    }

    public ExpanderHeaderClickListenerImplementor() {
        if (getClass() == ExpanderHeaderClickListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.DataForm.IExpanderHeaderClickListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.dataForm.ExpanderHeaderClickListener
    public void onHeaderClicked() {
        n_onHeaderClicked();
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
