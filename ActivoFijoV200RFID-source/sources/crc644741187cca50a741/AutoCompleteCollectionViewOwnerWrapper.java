package crc644741187cca50a741;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AutoCompleteCollectionViewOwnerWrapper extends SingleSelectionCollectionViewOwnerWrapper_1 implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.AutoCompleteCollectionViewOwnerWrapper, DevExpress.Maui.Editors", AutoCompleteCollectionViewOwnerWrapper.class, "");
    }

    public AutoCompleteCollectionViewOwnerWrapper() {
        if (getClass() == AutoCompleteCollectionViewOwnerWrapper.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.AutoCompleteCollectionViewOwnerWrapper, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // crc644741187cca50a741.SingleSelectionCollectionViewOwnerWrapper_1, crc644741187cca50a741.CollectionViewOwnerWrapper_1, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc644741187cca50a741.SingleSelectionCollectionViewOwnerWrapper_1, crc644741187cca50a741.CollectionViewOwnerWrapper_1, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
