package mono.com.devexpress.dxgrid.layout;

import com.devexpress.dxgrid.layout.GridRowSwipeController;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class GridRowSwipeController_OnLayoutListenerImplementor implements IGCUserPeer, GridRowSwipeController.OnLayoutListener {
    public static final String __md_methods = "n_layoutViews:()V:GetLayoutViewsHandler:DevExpress.Android.Grid.Layout.GridRowSwipeController/IOnLayoutListenerInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native void n_layoutViews();

    static {
        Runtime.register("DevExpress.Android.Grid.Layout.GridRowSwipeController+IOnLayoutListenerImplementor, DXGrid.a", GridRowSwipeController_OnLayoutListenerImplementor.class, __md_methods);
    }

    public GridRowSwipeController_OnLayoutListenerImplementor() {
        if (getClass() == GridRowSwipeController_OnLayoutListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Grid.Layout.GridRowSwipeController+IOnLayoutListenerImplementor, DXGrid.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.layout.GridRowSwipeController.OnLayoutListener
    public void layoutViews() {
        n_layoutViews();
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
