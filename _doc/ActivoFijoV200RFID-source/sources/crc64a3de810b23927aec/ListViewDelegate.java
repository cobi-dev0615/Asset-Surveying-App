package crc64a3de810b23927aec;

import android.view.View;
import com.devexpress.dxlistview.ListViewListener;
import com.devexpress.dxlistview.ListViewScrolledEventArgs;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ListViewDelegate implements IGCUserPeer, ListViewListener {
    public static final String __md_methods = "n_canDrop:(II)Z:GetCanDrop_IIHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_canLoadMore:()Z:GetCanLoadMoreHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_canPullToRefresh:()Z:GetCanPullToRefreshHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_canStartDrag:(I)Z:GetCanStartDrag_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_drop:(II)V:GetDrop_IIHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemDoubleTap:(I)V:GetItemDoubleTap_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemLongPress:(I)V:GetItemLongPress_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemPressed:(Landroid/view/View;FF)V:GetItemPressed_Landroid_view_View_FFHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemReleased:(Landroid/view/View;FF)V:GetItemReleased_Landroid_view_View_FFHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemTap:(I)V:GetItemTap_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemTapConfirmed:(I)V:GetItemTapConfirmed_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_loadMore:()V:GetLoadMoreHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_onAfterRebuild:()V:GetOnAfterRebuildHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_onAfterUpdateItems:()V:GetOnAfterUpdateItemsHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_pullToRefresh:()V:GetPullToRefreshHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_scrolled:(Lcom/devexpress/dxlistview/ListViewScrolledEventArgs;)V:GetScrolled_Lcom_devexpress_dxlistview_ListViewScrolledEventArgs_Handler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\n";
    private ArrayList refList;

    private native boolean n_canDrop(int i, int i2);

    private native boolean n_canLoadMore();

    private native boolean n_canPullToRefresh();

    private native boolean n_canStartDrag(int i);

    private native void n_drop(int i, int i2);

    private native void n_itemDoubleTap(int i);

    private native void n_itemLongPress(int i);

    private native void n_itemPressed(View view, float f, float f2);

    private native void n_itemReleased(View view, float f, float f2);

    private native void n_itemTap(int i);

    private native void n_itemTapConfirmed(int i);

    private native void n_loadMore();

    private native void n_onAfterRebuild();

    private native void n_onAfterUpdateItems();

    private native void n_pullToRefresh();

    private native void n_scrolled(ListViewScrolledEventArgs listViewScrolledEventArgs);

    static {
        Runtime.register("DevExpress.Maui.CollectionView.Android.Internal.ListViewDelegate, DevExpress.Maui.CollectionView", ListViewDelegate.class, "n_canDrop:(II)Z:GetCanDrop_IIHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_canLoadMore:()Z:GetCanLoadMoreHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_canPullToRefresh:()Z:GetCanPullToRefreshHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_canStartDrag:(I)Z:GetCanStartDrag_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_drop:(II)V:GetDrop_IIHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemDoubleTap:(I)V:GetItemDoubleTap_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemLongPress:(I)V:GetItemLongPress_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemPressed:(Landroid/view/View;FF)V:GetItemPressed_Landroid_view_View_FFHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemReleased:(Landroid/view/View;FF)V:GetItemReleased_Landroid_view_View_FFHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemTap:(I)V:GetItemTap_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_itemTapConfirmed:(I)V:GetItemTapConfirmed_IHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_loadMore:()V:GetLoadMoreHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_onAfterRebuild:()V:GetOnAfterRebuildHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_onAfterUpdateItems:()V:GetOnAfterUpdateItemsHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_pullToRefresh:()V:GetPullToRefreshHandler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\nn_scrolled:(Lcom/devexpress/dxlistview/ListViewScrolledEventArgs;)V:GetScrolled_Lcom_devexpress_dxlistview_ListViewScrolledEventArgs_Handler:DevExpress.Android.CollectionView.IListViewListenerInvoker, DXCollectionView.a\n");
    }

    public ListViewDelegate() {
        if (getClass() == ListViewDelegate.class) {
            TypeManager.Activate("DevExpress.Maui.CollectionView.Android.Internal.ListViewDelegate, DevExpress.Maui.CollectionView", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public boolean canDrop(int i, int i2) {
        return n_canDrop(i, i2);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public boolean canLoadMore() {
        return n_canLoadMore();
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public boolean canPullToRefresh() {
        return n_canPullToRefresh();
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public boolean canStartDrag(int i) {
        return n_canStartDrag(i);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void drop(int i, int i2) {
        n_drop(i, i2);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void itemDoubleTap(int i) {
        n_itemDoubleTap(i);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void itemLongPress(int i) {
        n_itemLongPress(i);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void itemPressed(View view, float f, float f2) {
        n_itemPressed(view, f, f2);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void itemReleased(View view, float f, float f2) {
        n_itemReleased(view, f, f2);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void itemTap(int i) {
        n_itemTap(i);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void itemTapConfirmed(int i) {
        n_itemTapConfirmed(i);
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void loadMore() {
        n_loadMore();
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void onAfterRebuild() {
        n_onAfterRebuild();
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void onAfterUpdateItems() {
        n_onAfterUpdateItems();
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void pullToRefresh() {
        n_pullToRefresh();
    }

    @Override // com.devexpress.dxlistview.ListViewListener
    public void scrolled(ListViewScrolledEventArgs listViewScrolledEventArgs) {
        n_scrolled(listViewScrolledEventArgs);
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
