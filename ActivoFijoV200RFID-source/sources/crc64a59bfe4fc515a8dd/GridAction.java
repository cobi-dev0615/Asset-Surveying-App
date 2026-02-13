package crc64a59bfe4fc515a8dd;

import android.view.View;
import com.devexpress.dxgrid.DXGridViewScrolledEventArgs;
import com.devexpress.dxgrid.models.GridElement;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class GridAction implements IGCUserPeer, com.devexpress.dxgrid.providers.GridAction {
    public static final String __md_methods = "n_canDragRow:(I)Z:GetCanDragRow_IHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_canDropRow:(II)Z:GetCanDropRow_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_canLoadMore:()Z:GetCanLoadMoreHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_canPullToRefresh:()Z:GetCanPullToRefreshHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_cellDoubleTap:(Lcom/devexpress/dxgrid/models/GridElement;II)V:GetCellDoubleTap_Lcom_devexpress_dxgrid_models_GridElement_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_cellLongPress:(Lcom/devexpress/dxgrid/models/GridElement;II)V:GetCellLongPress_Lcom_devexpress_dxgrid_models_GridElement_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_cellTap:(Lcom/devexpress/dxgrid/models/GridElement;II)V:GetCellTap_Lcom_devexpress_dxgrid_models_GridElement_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_cellTapConfirmed:(Lcom/devexpress/dxgrid/models/GridElement;II)V:GetCellTapConfirmed_Lcom_devexpress_dxgrid_models_GridElement_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_closeEditor:(Z)Z:GetCloseEditor_ZHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_dropRow:(II)V:GetDropRow_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_loadMore:()V:GetLoadMoreHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_pullTeRefresh:()V:GetPullTeRefreshHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_scrolled:(Lcom/devexpress/dxgrid/DXGridViewScrolledEventArgs;)V:GetScrolled_Lcom_devexpress_dxgrid_DXGridViewScrolledEventArgs_Handler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_selectionChanged:(Landroid/view/View;II)V:GetSelectionChanged_Landroid_view_View_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_setTopRowIndex:(I)V:GetSetTopRowIndex_IHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_swipeButtonShowing:(ZII)Z:GetSwipeButtonShowing_ZIIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\nn_updateExtentSize:(II)V:GetUpdateExtentSize_IIHandler:DevExpress.Android.Grid.Providers.IGridActionInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native boolean n_canDragRow(int i);

    private native boolean n_canDropRow(int i, int i2);

    private native boolean n_canLoadMore();

    private native boolean n_canPullToRefresh();

    private native void n_cellDoubleTap(GridElement gridElement, int i, int i2);

    private native void n_cellLongPress(GridElement gridElement, int i, int i2);

    private native void n_cellTap(GridElement gridElement, int i, int i2);

    private native void n_cellTapConfirmed(GridElement gridElement, int i, int i2);

    private native boolean n_closeEditor(boolean z);

    private native void n_dropRow(int i, int i2);

    private native void n_loadMore();

    private native void n_pullTeRefresh();

    private native void n_scrolled(DXGridViewScrolledEventArgs dXGridViewScrolledEventArgs);

    private native void n_selectionChanged(View view, int i, int i2);

    private native void n_setTopRowIndex(int i);

    private native boolean n_swipeButtonShowing(boolean z, int i, int i2);

    private native void n_updateExtentSize(int i, int i2);

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.GridAction, DevExpress.Maui.DataGrid", GridAction.class, __md_methods);
    }

    public GridAction() {
        if (getClass() == GridAction.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.GridAction, DevExpress.Maui.DataGrid", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canDragRow(int i) {
        return n_canDragRow(i);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canDropRow(int i, int i2) {
        return n_canDropRow(i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canLoadMore() {
        return n_canLoadMore();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canPullToRefresh() {
        return n_canPullToRefresh();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellDoubleTap(GridElement gridElement, int i, int i2) {
        n_cellDoubleTap(gridElement, i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellLongPress(GridElement gridElement, int i, int i2) {
        n_cellLongPress(gridElement, i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellTap(GridElement gridElement, int i, int i2) {
        n_cellTap(gridElement, i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellTapConfirmed(GridElement gridElement, int i, int i2) {
        n_cellTapConfirmed(gridElement, i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean closeEditor(boolean z) {
        return n_closeEditor(z);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void dropRow(int i, int i2) {
        n_dropRow(i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void loadMore() {
        n_loadMore();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void pullTeRefresh() {
        n_pullTeRefresh();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void scrolled(DXGridViewScrolledEventArgs dXGridViewScrolledEventArgs) {
        n_scrolled(dXGridViewScrolledEventArgs);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void selectionChanged(View view, int i, int i2) {
        n_selectionChanged(view, i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void setTopRowIndex(int i) {
        n_setTopRowIndex(i);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean swipeButtonShowing(boolean z, int i, int i2) {
        return n_swipeButtonShowing(z, i, i2);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void updateExtentSize(int i, int i2) {
        n_updateExtentSize(i, i2);
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
