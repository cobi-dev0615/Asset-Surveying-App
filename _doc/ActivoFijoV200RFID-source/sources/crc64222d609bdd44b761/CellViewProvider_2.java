package crc64222d609bdd44b761;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public abstract class CellViewProvider_2 implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.CellViewProvider`2, DevExpress.Maui.Editors", CellViewProvider_2.class, "");
    }

    public CellViewProvider_2() {
        if (getClass() == CellViewProvider_2.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.CellViewProvider`2, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
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
