package crc64222d609bdd44b761;

import android.view.View;
import com.devexpress.editors.OnClickHandledListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class IconClickedListener extends OnClickHandledListener implements IGCUserPeer {
    public static final String __md_methods = "n_onHandledClick:(Landroid/view/View;)Z:GetOnHandledClick_Landroid_view_View_Handler\n";
    private ArrayList refList;

    private native boolean n_onHandledClick(View view);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.IconClickedListener, DevExpress.Maui.Editors", IconClickedListener.class, __md_methods);
    }

    public IconClickedListener() {
        if (getClass() == IconClickedListener.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.IconClickedListener, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.OnClickHandledListener
    public boolean onHandledClick(View view) {
        return n_onHandledClick(view);
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
