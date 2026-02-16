package crc64a3de810b23927aec;

import com.devexpress.dxlistview.swipes.DXSwipeGroup;
import com.devexpress.dxlistview.swipes.SwipeViewListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SwipeViewDelegate implements IGCUserPeer, SwipeViewListener {
    public static final String __md_methods = "n_getRaiseItemTapImmediately:()Z:GetGetRaiseItemTapImmediatelyHandler:DevExpress.Android.CollectionView.Swipes.ISwipeViewListenerInvoker, DXCollectionView.a\nn_swipeItemTap:(IILcom/devexpress/dxlistview/swipes/DXSwipeGroup;)V:GetSwipeItemTap_IILcom_devexpress_dxlistview_swipes_DXSwipeGroup_Handler:DevExpress.Android.CollectionView.Swipes.ISwipeViewListenerInvoker, DXCollectionView.a\n";
    private ArrayList refList;

    private native boolean n_getRaiseItemTapImmediately();

    private native void n_swipeItemTap(int i, int i2, DXSwipeGroup dXSwipeGroup);

    static {
        Runtime.register("DevExpress.Maui.CollectionView.Android.Internal.SwipeViewDelegate, DevExpress.Maui.CollectionView", SwipeViewDelegate.class, __md_methods);
    }

    public SwipeViewDelegate() {
        if (getClass() == SwipeViewDelegate.class) {
            TypeManager.Activate("DevExpress.Maui.CollectionView.Android.Internal.SwipeViewDelegate, DevExpress.Maui.CollectionView", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxlistview.swipes.SwipeViewListener
    public boolean getRaiseItemTapImmediately() {
        return n_getRaiseItemTapImmediately();
    }

    @Override // com.devexpress.dxlistview.swipes.SwipeViewListener
    public void swipeItemTap(int i, int i2, DXSwipeGroup dXSwipeGroup) {
        n_swipeItemTap(i, i2, dXSwipeGroup);
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
