package mono.com.devexpress.dxgrid.views;

import com.devexpress.dxgrid.views.SwipeActionButton;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SwipeActionButton_OnTapListenerImplementor implements IGCUserPeer, SwipeActionButton.OnTapListener {
    public static final String __md_methods = "n_onSwipeButtonTap:(Lcom/devexpress/dxgrid/views/SwipeActionButton;)V:GetOnSwipeButtonTap_Lcom_devexpress_dxgrid_views_SwipeActionButton_Handler:DevExpress.Android.Grid.Views.SwipeActionButton/IOnTapListenerInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native void n_onSwipeButtonTap(SwipeActionButton swipeActionButton);

    static {
        Runtime.register("DevExpress.Android.Grid.Views.SwipeActionButton+IOnTapListenerImplementor, DXGrid.a", SwipeActionButton_OnTapListenerImplementor.class, __md_methods);
    }

    public SwipeActionButton_OnTapListenerImplementor() {
        if (getClass() == SwipeActionButton_OnTapListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Grid.Views.SwipeActionButton+IOnTapListenerImplementor, DXGrid.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.views.SwipeActionButton.OnTapListener
    public void onSwipeButtonTap(SwipeActionButton swipeActionButton) {
        n_onSwipeButtonTap(swipeActionButton);
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
