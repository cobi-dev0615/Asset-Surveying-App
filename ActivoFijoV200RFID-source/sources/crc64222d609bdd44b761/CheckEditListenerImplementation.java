package crc64222d609bdd44b761;

import com.devexpress.editors.CheckEdit;
import com.devexpress.editors.DXCheckEditValue;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CheckEditListenerImplementation implements IGCUserPeer, CheckEdit.Listener {
    public static final String __md_methods = "n_onValueChanged:(Lcom/devexpress/editors/DXCheckEditValue;)V:GetOnValueChanged_Lcom_devexpress_editors_DXCheckEditValue_Handler:DevExpress.Android.Editors.CheckEdit/IListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onValueChanged(DXCheckEditValue dXCheckEditValue);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.CheckEditListenerImplementation, DevExpress.Maui.Editors", CheckEditListenerImplementation.class, "n_onValueChanged:(Lcom/devexpress/editors/DXCheckEditValue;)V:GetOnValueChanged_Lcom_devexpress_editors_DXCheckEditValue_Handler:DevExpress.Android.Editors.CheckEdit/IListenerInvoker, DXEditors.a\n");
    }

    public CheckEditListenerImplementation() {
        if (getClass() == CheckEditListenerImplementation.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.CheckEditListenerImplementation, DevExpress.Maui.Editors", "", this, new Object[0]);
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
