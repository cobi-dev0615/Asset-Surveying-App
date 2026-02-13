package crc64222d609bdd44b761;

import android.graphics.Rect;
import com.devexpress.editors.layout.OnBoxMarginChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class BoxModeChangedListener extends OnBoxMarginChangedListener implements IGCUserPeer {
    public static final String __md_methods = "n_onChange:(Landroid/graphics/Rect;)V:GetOnChange_Landroid_graphics_Rect_Handler\n";
    private ArrayList refList;

    private native void n_onChange(Rect rect);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.BoxModeChangedListener, DevExpress.Maui.Editors", BoxModeChangedListener.class, __md_methods);
    }

    public BoxModeChangedListener() {
        if (getClass() == BoxModeChangedListener.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.BoxModeChangedListener, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.layout.OnBoxMarginChangedListener
    public void onChange(Rect rect) {
        n_onChange(rect);
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
