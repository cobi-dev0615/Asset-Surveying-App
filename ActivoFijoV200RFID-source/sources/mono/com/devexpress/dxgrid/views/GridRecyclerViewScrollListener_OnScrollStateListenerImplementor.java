package mono.com.devexpress.dxgrid.views;

import com.devexpress.dxgrid.views.GridRecyclerViewScrollListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class GridRecyclerViewScrollListener_OnScrollStateListenerImplementor implements IGCUserPeer, GridRecyclerViewScrollListener.OnScrollStateListener {
    public static final String __md_methods = "n_onScrolled:(II)V:GetOnScrolled_IIHandler:DevExpress.Android.Grid.Views.GridRecyclerViewScrollListener/IOnScrollStateListenerInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native void n_onScrolled(int i, int i2);

    static {
        Runtime.register("DevExpress.Android.Grid.Views.GridRecyclerViewScrollListener+IOnScrollStateListenerImplementor, DXGrid.a", GridRecyclerViewScrollListener_OnScrollStateListenerImplementor.class, __md_methods);
    }

    public GridRecyclerViewScrollListener_OnScrollStateListenerImplementor() {
        if (getClass() == GridRecyclerViewScrollListener_OnScrollStateListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Grid.Views.GridRecyclerViewScrollListener+IOnScrollStateListenerImplementor, DXGrid.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.views.GridRecyclerViewScrollListener.OnScrollStateListener
    public void onScrolled(int i, int i2) {
        n_onScrolled(i, i2);
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
