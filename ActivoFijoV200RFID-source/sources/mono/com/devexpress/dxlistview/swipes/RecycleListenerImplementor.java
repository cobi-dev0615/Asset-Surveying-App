package mono.com.devexpress.dxlistview.swipes;

import com.devexpress.dxlistview.layouts.LayoutElement;
import com.devexpress.dxlistview.swipes.RecycleListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class RecycleListenerImplementor implements IGCUserPeer, RecycleListener {
    public static final String __md_methods = "n_recycleItem:(Lcom/devexpress/dxlistview/layouts/LayoutElement;)V:GetRecycleItem_Lcom_devexpress_dxlistview_layouts_LayoutElement_Handler:DevExpress.Android.CollectionView.Swipes.IRecycleListenerInvoker, DXCollectionView.a\n";
    private ArrayList refList;

    private native void n_recycleItem(LayoutElement layoutElement);

    static {
        Runtime.register("DevExpress.Android.CollectionView.Swipes.IRecycleListenerImplementor, DXCollectionView.a", RecycleListenerImplementor.class, __md_methods);
    }

    public RecycleListenerImplementor() {
        if (getClass() == RecycleListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.CollectionView.Swipes.IRecycleListenerImplementor, DXCollectionView.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxlistview.swipes.RecycleListener
    public void recycleItem(LayoutElement layoutElement) {
        n_recycleItem(layoutElement);
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
