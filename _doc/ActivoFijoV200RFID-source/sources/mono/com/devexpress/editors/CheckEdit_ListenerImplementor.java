package mono.com.devexpress.editors;

import com.devexpress.editors.CheckEdit;
import com.devexpress.editors.DXCheckEditValue;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CheckEdit_ListenerImplementor implements IGCUserPeer, CheckEdit.Listener {
    public static final String __md_methods = "n_onValueChanged:(Lcom/devexpress/editors/DXCheckEditValue;)V:GetOnValueChanged_Lcom_devexpress_editors_DXCheckEditValue_Handler:DevExpress.Android.Editors.CheckEdit/IListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onValueChanged(DXCheckEditValue dXCheckEditValue);

    static {
        Runtime.register("DevExpress.Android.Editors.CheckEdit+IListenerImplementor, DXEditors.a", CheckEdit_ListenerImplementor.class, "n_onValueChanged:(Lcom/devexpress/editors/DXCheckEditValue;)V:GetOnValueChanged_Lcom_devexpress_editors_DXCheckEditValue_Handler:DevExpress.Android.Editors.CheckEdit/IListenerInvoker, DXEditors.a\n");
    }

    public CheckEdit_ListenerImplementor() {
        if (getClass() == CheckEdit_ListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.CheckEdit+IListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.CheckEdit.Listener
    public void onValueChanged(DXCheckEditValue dXCheckEditValue) {
        n_onValueChanged(dXCheckEditValue);
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
