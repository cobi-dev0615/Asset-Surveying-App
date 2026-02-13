package crc644741187cca50a741;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CSObjectWrapper implements IGCUserPeer {
    public static final String __md_methods = "n_toString:()Ljava/lang/String;:GetToStringHandler\n";
    private ArrayList refList;

    private native String n_toString();

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.CSObjectWrapper, DevExpress.Maui.Editors", CSObjectWrapper.class, "n_toString:()Ljava/lang/String;:GetToStringHandler\n");
    }

    public CSObjectWrapper() {
        if (getClass() == CSObjectWrapper.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.CSObjectWrapper, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    public String toString() {
        return n_toString();
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
