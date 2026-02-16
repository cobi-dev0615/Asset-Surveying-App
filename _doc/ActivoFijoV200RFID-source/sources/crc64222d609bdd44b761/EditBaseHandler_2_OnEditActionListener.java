package crc64222d609bdd44b761;

import com.devexpress.editors.OnEditActionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class EditBaseHandler_2_OnEditActionListener implements IGCUserPeer, OnEditActionListener {
    public static final String __md_methods = "n_onEditorAction:(I)Z:GetOnEditorAction_IHandler:DevExpress.Android.Editors.IOnEditActionListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_onEditorAction(int i);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.EditBaseHandler`2+OnEditActionListener, DevExpress.Maui.Editors", EditBaseHandler_2_OnEditActionListener.class, "n_onEditorAction:(I)Z:GetOnEditorAction_IHandler:DevExpress.Android.Editors.IOnEditActionListenerInvoker, DXEditors.a\n");
    }

    public EditBaseHandler_2_OnEditActionListener() {
        if (getClass() == EditBaseHandler_2_OnEditActionListener.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.EditBaseHandler`2+OnEditActionListener, DevExpress.Maui.Editors", "", this, new Object[0]);
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
