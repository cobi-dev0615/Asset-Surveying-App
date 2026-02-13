package mono.com.devexpress.dxlistview.core;

import android.view.View;
import com.devexpress.dxlistview.core.ItemsViewAdapterListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ItemsViewAdapterListenerImplementor implements IGCUserPeer, ItemsViewAdapterListener {
    public static final String __md_methods = "n_viewDidUpdate:(Landroid/view/View;II)V:GetViewDidUpdate_Landroid_view_View_IIHandler:DevExpress.Android.CollectionView.Core.IItemsViewAdapterListenerInvoker, DXCollectionView.a\n";
    private ArrayList refList;

    private native void n_viewDidUpdate(View view, int i, int i2);

    static {
        Runtime.register("DevExpress.Android.CollectionView.Core.IItemsViewAdapterListenerImplementor, DXCollectionView.a", ItemsViewAdapterListenerImplementor.class, __md_methods);
    }

    public ItemsViewAdapterListenerImplementor() {
        if (getClass() == ItemsViewAdapterListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.CollectionView.Core.IItemsViewAdapterListenerImplementor, DXCollectionView.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxlistview.core.ItemsViewAdapterListener
    public void viewDidUpdate(View view, int i, int i2) {
        n_viewDidUpdate(view, i, i2);
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
