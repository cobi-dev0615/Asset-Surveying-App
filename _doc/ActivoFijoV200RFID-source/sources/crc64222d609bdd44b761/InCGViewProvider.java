package crc64222d609bdd44b761;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class InCGViewProvider extends CGViewProvider_1 implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.InCGViewProvider, DevExpress.Maui.Editors", InCGViewProvider.class, "");
    }

    public InCGViewProvider() {
        if (getClass() == InCGViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.InCGViewProvider, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // crc64222d609bdd44b761.CGViewProvider_1, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64222d609bdd44b761.CGViewProvider_1, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
