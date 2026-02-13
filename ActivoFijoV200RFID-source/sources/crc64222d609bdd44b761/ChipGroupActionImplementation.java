package crc64222d609bdd44b761;

import com.devexpress.editors.ChipGroupAction;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ChipGroupActionImplementation implements IGCUserPeer, ChipGroupAction {
    public static final String __md_methods = "n_onLayoutChanged:()V:GetOnLayoutChangedHandler:DevExpress.Android.Editors.IChipGroupActionInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onLayoutChanged();

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.ChipGroupActionImplementation, DevExpress.Maui.Editors", ChipGroupActionImplementation.class, __md_methods);
    }

    public ChipGroupActionImplementation() {
        if (getClass() == ChipGroupActionImplementation.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.ChipGroupActionImplementation, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.ChipGroupAction
    public void onLayoutChanged() {
        n_onLayoutChanged();
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
