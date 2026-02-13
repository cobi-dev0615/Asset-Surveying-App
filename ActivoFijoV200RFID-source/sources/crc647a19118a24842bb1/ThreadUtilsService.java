package crc647a19118a24842bb1;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ThreadUtilsService implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.Core.Internal.ThreadUtilsService, DevExpress.Maui.Core", ThreadUtilsService.class, "");
    }

    public ThreadUtilsService() {
        if (getClass() == ThreadUtilsService.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Internal.ThreadUtilsService, DevExpress.Maui.Core", "", this, new Object[0]);
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
