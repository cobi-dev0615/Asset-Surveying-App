package com.devexpress.dxgrid.layout;

import android.view.View;
import com.devexpress.dxgrid.DXGridViewScrolledEventArgs;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.providers.GridAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridActionAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0005H\u0016J \u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/devexpress/dxgrid/layout/GridActionAdapter;", "Lcom/devexpress/dxgrid/providers/GridAction;", "gridAction", "(Lcom/devexpress/dxgrid/providers/GridAction;)V", "lastTargetPosition", "", "lastTargetResult", "", "canDragRow", "rowIndex", "canDropRow", "sourceRowIndex", "targetRowIndex", "canLoadMore", "canPullToRefresh", "cellDoubleTap", "", "gridElement", "Lcom/devexpress/dxgrid/models/GridElement;", "rowVisibleIndex", "columnIndex", "cellLongPress", "cellTap", "cellTapConfirmed", "closeEditor", "applyChanges", "dropRow", "loadMore", "pullTeRefresh", "scrolled", "args", "Lcom/devexpress/dxgrid/DXGridViewScrolledEventArgs;", "selectionChanged", "cellView", "Landroid/view/View;", "setTopRowIndex", "index", "swipeButtonShowing", "leadingSwipe", "swipeItemIndex", "updateExtentSize", "extentWidth", "extentHeight", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GridActionAdapter implements GridAction {
    private final GridAction gridAction;
    private int lastTargetPosition;
    private boolean lastTargetResult;

    public GridActionAdapter(GridAction gridAction) {
        Intrinsics.checkNotNullParameter(gridAction, "gridAction");
        this.gridAction = gridAction;
        this.lastTargetPosition = -1;
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void pullTeRefresh() {
        this.gridAction.pullTeRefresh();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canPullToRefresh() {
        return this.gridAction.canPullToRefresh();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void loadMore() {
        this.gridAction.loadMore();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canLoadMore() {
        return this.gridAction.canLoadMore();
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellTap(GridElement gridElement, int rowVisibleIndex, int columnIndex) {
        Intrinsics.checkNotNullParameter(gridElement, "gridElement");
        this.gridAction.cellTap(gridElement, rowVisibleIndex, columnIndex);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellTapConfirmed(GridElement gridElement, int rowVisibleIndex, int columnIndex) {
        Intrinsics.checkNotNullParameter(gridElement, "gridElement");
        this.gridAction.cellTapConfirmed(gridElement, rowVisibleIndex, columnIndex);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellDoubleTap(GridElement gridElement, int rowVisibleIndex, int columnIndex) {
        Intrinsics.checkNotNullParameter(gridElement, "gridElement");
        this.gridAction.cellDoubleTap(gridElement, rowVisibleIndex, columnIndex);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void cellLongPress(GridElement gridElement, int rowVisibleIndex, int columnIndex) {
        Intrinsics.checkNotNullParameter(gridElement, "gridElement");
        this.gridAction.cellLongPress(gridElement, rowVisibleIndex, columnIndex);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean closeEditor(boolean applyChanges) {
        return this.gridAction.closeEditor(applyChanges);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void scrolled(DXGridViewScrolledEventArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.gridAction.scrolled(args);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canDropRow(int sourceRowIndex, int targetRowIndex) {
        if (this.lastTargetPosition != targetRowIndex) {
            this.lastTargetResult = this.gridAction.canDropRow(sourceRowIndex, targetRowIndex);
            this.lastTargetPosition = targetRowIndex;
        }
        return this.lastTargetResult;
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean canDragRow(int rowIndex) {
        return this.gridAction.canDragRow(rowIndex);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void dropRow(int sourceRowIndex, int targetRowIndex) {
        this.gridAction.dropRow(sourceRowIndex, targetRowIndex);
        this.lastTargetPosition = -1;
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void selectionChanged(View cellView, int rowIndex, int columnIndex) {
        this.gridAction.selectionChanged(cellView, rowIndex, columnIndex);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public boolean swipeButtonShowing(boolean leadingSwipe, int rowIndex, int swipeItemIndex) {
        return this.gridAction.swipeButtonShowing(leadingSwipe, rowIndex, swipeItemIndex);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void updateExtentSize(int extentWidth, int extentHeight) {
        this.gridAction.updateExtentSize(extentWidth, extentHeight);
    }

    @Override // com.devexpress.dxgrid.providers.GridAction
    public void setTopRowIndex(int index) {
        this.gridAction.setTopRowIndex(index);
    }
}
