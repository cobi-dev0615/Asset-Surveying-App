package crc64a3de810b23927aec;

import android.view.View;
import com.devexpress.dxlistview.core.DXListItemViewProvider;
import com.devexpress.dxlistview.swipes.DXSwipeGroup;
import com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider;
import java.util.ArrayList;
import java.util.List;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ViewProvider implements IGCUserPeer, DXListItemViewProvider, DXSwipeItemsViewProvider {
    public static final String __md_methods = "n_isItemsSourceGrouped:()Z:GetIsItemsSourceGroupedHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getItemCount:()I:GetGetItemCountHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_calculateNodePosition:(I)I:GetCalculateNodePosition_IHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_checkView:(Landroid/view/View;I)Z:GetCheckView_Landroid_view_View_IHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_clearCache:()V:GetClearCacheHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getEndVisibleIndexInNodeByItem:(I)I:GetGetEndVisibleIndexInNodeByItem_IHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getGroupItemIndexForItem:(I)I:GetGetGroupItemIndexForItem_IHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getStartVisibleIndexInNode:(I)I:GetGetStartVisibleIndexInNode_IHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getStartVisibleIndexInNodeByItem:(I)I:GetGetStartVisibleIndexInNodeByItem_IHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getViewByIndex:(II)Landroid/view/View;:GetGetViewByIndex_IIHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getViewTypeByIndex:(I)I:GetGetViewTypeByIndex_IHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_recycleView:(Landroid/view/View;II)V:GetRecycleView_Landroid_view_View_IIHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_updateView:(Landroid/view/View;II)V:GetUpdateView_Landroid_view_View_IIHandler:DevExpress.Android.CollectionView.Core.IDXListItemViewProviderInvoker, DXCollectionView.a\nn_getAllowFullSwipe:(ILcom/devexpress/dxlistview/swipes/DXSwipeGroup;)Ljava/lang/Boolean;:GetGetAllowFullSwipe_ILcom_devexpress_dxlistview_swipes_DXSwipeGroup_Handler:DevExpress.Android.CollectionView.Swipes.IDXSwipeItemsViewProviderInvoker, DXCollectionView.a\nn_getSwipeViewColors:(ILcom/devexpress/dxlistview/swipes/DXSwipeGroup;)Ljava/util/List;:GetGetSwipeViewColors_ILcom_devexpress_dxlistview_swipes_DXSwipeGroup_Handler:DevExpress.Android.CollectionView.Swipes.IDXSwipeItemsViewProviderInvoker, DXCollectionView.a\nn_getSwipeViewSizes:(ILcom/devexpress/dxlistview/swipes/DXSwipeGroup;)Ljava/util/List;:GetGetSwipeViewSizes_ILcom_devexpress_dxlistview_swipes_DXSwipeGroup_Handler:DevExpress.Android.CollectionView.Swipes.IDXSwipeItemsViewProviderInvoker, DXCollectionView.a\nn_getSwipeViews:(ILcom/devexpress/dxlistview/swipes/DXSwipeGroup;)Ljava/util/List;:GetGetSwipeViews_ILcom_devexpress_dxlistview_swipes_DXSwipeGroup_Handler:DevExpress.Android.CollectionView.Swipes.IDXSwipeItemsViewProviderInvoker, DXCollectionView.a\nn_isSwipeAllowed:(ILcom/devexpress/dxlistview/swipes/DXSwipeGroup;)Ljava/lang/Boolean;:GetIsSwipeAllowed_ILcom_devexpress_dxlistview_swipes_DXSwipeGroup_Handler:DevExpress.Android.CollectionView.Swipes.IDXSwipeItemsViewProviderInvoker, DXCollectionView.a\nn_recycleViews:(ILcom/devexpress/dxlistview/swipes/DXSwipeGroup;Ljava/util/List;)V:GetRecycleViews_ILcom_devexpress_dxlistview_swipes_DXSwipeGroup_Ljava_util_List_Handler:DevExpress.Android.CollectionView.Swipes.IDXSwipeItemsViewProviderInvoker, DXCollectionView.a\n";
    private ArrayList refList;

    private native int n_calculateNodePosition(int i);

    private native boolean n_checkView(View view, int i);

    private native void n_clearCache();

    private native Boolean n_getAllowFullSwipe(int i, DXSwipeGroup dXSwipeGroup);

    private native int n_getEndVisibleIndexInNodeByItem(int i);

    private native int n_getGroupItemIndexForItem(int i);

    private native int n_getItemCount();

    private native int n_getStartVisibleIndexInNode(int i);

    private native int n_getStartVisibleIndexInNodeByItem(int i);

    private native List n_getSwipeViewColors(int i, DXSwipeGroup dXSwipeGroup);

    private native List n_getSwipeViewSizes(int i, DXSwipeGroup dXSwipeGroup);

    private native List n_getSwipeViews(int i, DXSwipeGroup dXSwipeGroup);

    private native View n_getViewByIndex(int i, int i2);

    private native int n_getViewTypeByIndex(int i);

    private native boolean n_isItemsSourceGrouped();

    private native Boolean n_isSwipeAllowed(int i, DXSwipeGroup dXSwipeGroup);

    private native void n_recycleView(View view, int i, int i2);

    private native void n_recycleViews(int i, DXSwipeGroup dXSwipeGroup, List list);

    private native void n_updateView(View view, int i, int i2);

    static {
        Runtime.register("DevExpress.Maui.CollectionView.Android.Internal.ViewProvider, DevExpress.Maui.CollectionView", ViewProvider.class, __md_methods);
    }

    public ViewProvider() {
        if (getClass() == ViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.CollectionView.Android.Internal.ViewProvider, DevExpress.Maui.CollectionView", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public boolean isItemsSourceGrouped() {
        return n_isItemsSourceGrouped();
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getItemCount() {
        return n_getItemCount();
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int calculateNodePosition(int i) {
        return n_calculateNodePosition(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public boolean checkView(View view, int i) {
        return n_checkView(view, i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public void clearCache() {
        n_clearCache();
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getEndVisibleIndexInNodeByItem(int i) {
        return n_getEndVisibleIndexInNodeByItem(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getGroupItemIndexForItem(int i) {
        return n_getGroupItemIndexForItem(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getStartVisibleIndexInNode(int i) {
        return n_getStartVisibleIndexInNode(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getStartVisibleIndexInNodeByItem(int i) {
        return n_getStartVisibleIndexInNodeByItem(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public View getViewByIndex(int i, int i2) {
        return n_getViewByIndex(i, i2);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public int getViewTypeByIndex(int i) {
        return n_getViewTypeByIndex(i);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public void recycleView(View view, int i, int i2) {
        n_recycleView(view, i, i2);
    }

    @Override // com.devexpress.dxlistview.core.DXListItemViewProvider
    public void updateView(View view, int i, int i2) {
        n_updateView(view, i, i2);
    }

    @Override // com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider
    public Boolean getAllowFullSwipe(int i, DXSwipeGroup dXSwipeGroup) {
        return n_getAllowFullSwipe(i, dXSwipeGroup);
    }

    @Override // com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider
    public List getSwipeViewColors(int i, DXSwipeGroup dXSwipeGroup) {
        return n_getSwipeViewColors(i, dXSwipeGroup);
    }

    @Override // com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider
    public List getSwipeViewSizes(int i, DXSwipeGroup dXSwipeGroup) {
        return n_getSwipeViewSizes(i, dXSwipeGroup);
    }

    @Override // com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider
    public List getSwipeViews(int i, DXSwipeGroup dXSwipeGroup) {
        return n_getSwipeViews(i, dXSwipeGroup);
    }

    @Override // com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider
    public Boolean isSwipeAllowed(int i, DXSwipeGroup dXSwipeGroup) {
        return n_isSwipeAllowed(i, dXSwipeGroup);
    }

    @Override // com.devexpress.dxlistview.swipes.DXSwipeItemsViewProvider
    public void recycleViews(int i, DXSwipeGroup dXSwipeGroup, List list) {
        n_recycleViews(i, dXSwipeGroup, list);
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
