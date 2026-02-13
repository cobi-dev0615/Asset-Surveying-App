package com.devexpress.dxgrid.layout;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider;
import com.devexpress.dxgrid.layout.GridRowsAdapter;
import com.devexpress.dxgrid.layout.RunnablesQueue;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.providers.GroupRowViewProviderBase;
import com.devexpress.dxgrid.utils.CascadeUpdateProvider;
import com.devexpress.dxgrid.utils.OnSwipeOffsetChangeListener;
import com.devexpress.dxgrid.utils.providers.LayoutProvider;
import com.devexpress.dxgrid.utils.providers.LoadMoreActionProvider;
import com.devexpress.dxgrid.utils.providers.OffsetProvider;
import com.devexpress.dxgrid.utils.providers.RowHeightProvider;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.dxgrid.utils.providers.SwipeCacheProvider;
import com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider;
import com.devexpress.dxgrid.views.GridGroupHeaderView;
import com.devexpress.dxgrid.views.GridProgressBarRow;
import com.devexpress.dxgrid.views.GridRowView;
import com.devexpress.dxgrid.views.GridRowViewBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridRowsAdapter.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002GHBU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020)H\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0016J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020)H\u0002J\u0014\u00103\u001a\u00020\u001a2\n\u00104\u001a\u00060\u0002R\u00020\u0000H\u0002J\u0010\u00105\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0002J\u001c\u00106\u001a\u00020,2\n\u00104\u001a\u00060\u0002R\u00020\u00002\u0006\u0010/\u001a\u00020)H\u0016J\u001c\u00107\u001a\u00060\u0002R\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020)H\u0016J\u000e\u0010;\u001a\u00020,2\u0006\u00104\u001a\u00020<J\u0006\u0010=\u001a\u00020,J\u0016\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<J\u0006\u0010A\u001a\u00020,J\u000e\u0010B\u001a\u00020,2\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010C\u001a\u00020,2\u0006\u0010 \u001a\u00020!J\u0016\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020)R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/devexpress/dxgrid/layout/GridRowsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devexpress/dxgrid/layout/GridRowsAdapter$ViewHolder;", "Lcom/devexpress/dxgrid/utils/CascadeUpdateProvider;", "context", "Landroid/content/Context;", "serviceProvider", "Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;", "offsetProvider", "Lcom/devexpress/dxgrid/utils/providers/OffsetProvider;", "viewPortWidthProvider", "Lcom/devexpress/dxgrid/utils/providers/ViewPortWidthProvider;", "swipeCacheProvider", "Lcom/devexpress/dxgrid/utils/providers/SwipeCacheProvider;", "loadMoreActionProvider", "Lcom/devexpress/dxgrid/utils/providers/LoadMoreActionProvider;", "onSwipeOffsetChangeListener", "Lcom/devexpress/dxgrid/utils/OnSwipeOffsetChangeListener;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "layoutProvider", "Lcom/devexpress/dxgrid/utils/providers/LayoutProvider;", "rowHeightProvider", "Lcom/devexpress/dxgrid/utils/providers/RowHeightProvider;", "(Landroid/content/Context;Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;Lcom/devexpress/dxgrid/utils/providers/OffsetProvider;Lcom/devexpress/dxgrid/utils/providers/ViewPortWidthProvider;Lcom/devexpress/dxgrid/utils/providers/SwipeCacheProvider;Lcom/devexpress/dxgrid/utils/providers/LoadMoreActionProvider;Lcom/devexpress/dxgrid/utils/OnSwipeOffsetChangeListener;Landroidx/recyclerview/widget/ItemTouchHelper;Lcom/devexpress/dxgrid/utils/providers/LayoutProvider;Lcom/devexpress/dxgrid/utils/providers/RowHeightProvider;)V", "value", "", "cascadeUpdateEnabled", "getCascadeUpdateEnabled", "()Z", "setCascadeUpdateEnabled", "(Z)V", "gridAction", "Lcom/devexpress/dxgrid/providers/GridAction;", "isCascadeTreeCreationEnabled", "isCascadeUpdateEnabled", "<set-?>", "loadMoreRowExists", "getLoadMoreRowExists", "prevLoadMoreRowExists", "sourceDragPosition", "", "targetDragPosition", "addLoadMoreRow", "", "getItemCount", "getItemViewType", "position", "getRowViewByType", "Lcom/devexpress/dxgrid/views/GridRowViewBase;", "type", "getViewIsReady", "viewHolder", "mapAdapterPosition", "onBindViewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "itemType", "onDrag", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onDrop", "onMove", "source", TypedValues.AttributesType.S_TARGET, "removeLoadMoreRow", "setCascadeTreeCreationEnabled", "setGridAction", "setMovePositions", "fromPosition", "toPosition", "Companion", "ViewHolder", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GridRowsAdapter extends RecyclerView.Adapter<ViewHolder> implements CascadeUpdateProvider {
    private static final int ITEM_TYPE_GROUP_HEADER_NATIVE = 1;
    private static final int ITEM_TYPE_GROUP_HEADER_TEMPLATE = 2;
    private static final int ITEM_TYPE_GROUP_HEADER_VALUE_NATIVE_SUMMARY_TEMPLATE = 5;
    private static final int ITEM_TYPE_GROUP_HEADER_VALUE_TEMPLATE_SUMMARY_NATIVE = 4;
    private static final int ITEM_TYPE_GROUP_HEADER_VALUE_TEMPLATE_SUMMARY_TEMPLATE = 3;
    private static final int ITEM_TYPE_PROGRESS = 6;
    private static final int ITEM_TYPE_ROW = 0;
    private final Context context;
    private GridAction gridAction;
    private boolean isCascadeTreeCreationEnabled;
    private boolean isCascadeUpdateEnabled;
    private final ItemTouchHelper itemTouchHelper;
    private final LayoutProvider layoutProvider;
    private final LoadMoreActionProvider loadMoreActionProvider;
    private boolean loadMoreRowExists;
    private final OffsetProvider offsetProvider;
    private final OnSwipeOffsetChangeListener onSwipeOffsetChangeListener;
    private boolean prevLoadMoreRowExists;
    private final RowHeightProvider rowHeightProvider;
    private final ServiceProvider serviceProvider;
    private int sourceDragPosition;
    private final SwipeCacheProvider swipeCacheProvider;
    private int targetDragPosition;
    private final ViewPortWidthProvider viewPortWidthProvider;

    public GridRowsAdapter(Context context, ServiceProvider serviceProvider, OffsetProvider offsetProvider, ViewPortWidthProvider viewPortWidthProvider, SwipeCacheProvider swipeCacheProvider, LoadMoreActionProvider loadMoreActionProvider, OnSwipeOffsetChangeListener onSwipeOffsetChangeListener, ItemTouchHelper itemTouchHelper, LayoutProvider layoutProvider, RowHeightProvider rowHeightProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        Intrinsics.checkNotNullParameter(viewPortWidthProvider, "viewPortWidthProvider");
        Intrinsics.checkNotNullParameter(swipeCacheProvider, "swipeCacheProvider");
        Intrinsics.checkNotNullParameter(loadMoreActionProvider, "loadMoreActionProvider");
        Intrinsics.checkNotNullParameter(onSwipeOffsetChangeListener, "onSwipeOffsetChangeListener");
        Intrinsics.checkNotNullParameter(itemTouchHelper, "itemTouchHelper");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        Intrinsics.checkNotNullParameter(rowHeightProvider, "rowHeightProvider");
        this.context = context;
        this.serviceProvider = serviceProvider;
        this.offsetProvider = offsetProvider;
        this.viewPortWidthProvider = viewPortWidthProvider;
        this.swipeCacheProvider = swipeCacheProvider;
        this.loadMoreActionProvider = loadMoreActionProvider;
        this.onSwipeOffsetChangeListener = onSwipeOffsetChangeListener;
        this.itemTouchHelper = itemTouchHelper;
        this.layoutProvider = layoutProvider;
        this.rowHeightProvider = rowHeightProvider;
        this.sourceDragPosition = -1;
        this.targetDragPosition = -1;
    }

    public final boolean getLoadMoreRowExists() {
        return this.loadMoreRowExists;
    }

    public final void addLoadMoreRow() {
        if (this.loadMoreRowExists || this.sourceDragPosition >= 0) {
            return;
        }
        this.loadMoreRowExists = true;
        notifyItemInserted(this.serviceProvider.getRowCount());
    }

    public final void removeLoadMoreRow() {
        if (this.loadMoreRowExists) {
            this.loadMoreRowExists = false;
            notifyItemRemoved(this.serviceProvider.getRowCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        final GridRowViewBase rowViewByType = getRowViewByType(itemType);
        final ViewHolder viewHolder = new ViewHolder(this, rowViewByType);
        if (rowViewByType instanceof GridRowView) {
            GridRowViewBase rowView = viewHolder.getRowView();
            Intrinsics.checkNotNull(rowView, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridRowView");
            ((GridRowView) rowView).setLongPressRunnable(new Runnable() { // from class: com.devexpress.dxgrid.layout.GridRowsAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GridRowsAdapter.onCreateViewHolder$lambda$0(GridRowsAdapter.this, viewHolder, rowViewByType);
                }
            });
        }
        return viewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$0(GridRowsAdapter this$0, ViewHolder viewHolder, GridRowViewBase view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (this$0.serviceProvider.getIsRefreshing()) {
            return;
        }
        GridAction gridAction = this$0.gridAction;
        if (gridAction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridAction");
            gridAction = null;
        }
        if (!gridAction.canDragRow(viewHolder.getBindingAdapterPosition()) || this$0.serviceProvider.getInplaceEditingRowIndex() >= -2147483647) {
            return;
        }
        GridRowView gridRowView = (GridRowView) view;
        if (gridRowView.getIsReady()) {
            gridRowView.beforeDrag();
            this$0.itemTouchHelper.startDrag(viewHolder);
        }
    }

    public final void setGridAction(GridAction gridAction) {
        Intrinsics.checkNotNullParameter(gridAction, "gridAction");
        this.gridAction = new GridActionAdapter(gridAction);
    }

    private final boolean getViewIsReady(ViewHolder viewHolder) {
        if (viewHolder.getItemViewType() == 6) {
            return true;
        }
        return (!this.isCascadeTreeCreationEnabled && this.layoutProvider.getDidStructureChanged()) || !this.isCascadeUpdateEnabled;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int mapAdapterPosition = mapAdapterPosition(position);
        viewHolder.getRowView().setSelected(this.serviceProvider.isSelected(mapAdapterPosition));
        boolean viewIsReady = getViewIsReady(viewHolder);
        viewHolder.getRowView().setIsReady(viewIsReady || viewHolder.getRowView().isVisibleAndReadyAfterScrollToRow);
        viewHolder.getRowView().setCascadeUpdateEnabled(this.isCascadeUpdateEnabled);
        viewHolder.getRowView().update(mapAdapterPosition);
        if (viewIsReady) {
            return;
        }
        if (viewHolder.getRowView() instanceof GridRowView) {
            ((GridRowView) viewHolder.getRowView()).cancelUpdateContent();
            viewHolder.getRowView().updateContent();
        } else {
            this.serviceProvider.getRunnablesQueue().add(viewHolder.getUpdateRunnable());
        }
        if (this.rowHeightProvider.getFixedRowHeight()) {
            return;
        }
        viewHolder.getRowView().requestLayout();
    }

    public final void setMovePositions(int fromPosition, int toPosition) {
        this.sourceDragPosition = fromPosition;
        this.targetDragPosition = toPosition;
    }

    private final int mapAdapterPosition(int position) {
        int i;
        int i2 = this.sourceDragPosition;
        if (i2 < 0 || (i = this.targetDragPosition) < 0) {
            return position;
        }
        if (position == i) {
            return i2;
        }
        if (position >= i || i2 > position) {
            return (position > i2 || i + 1 > position) ? position : position - 1;
        }
        return position + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int mapAdapterPosition = mapAdapterPosition(position);
        if (mapAdapterPosition >= this.serviceProvider.getRowCount()) {
            return this.loadMoreRowExists ? 6 : -1;
        }
        if (!this.serviceProvider.isGroupRow(mapAdapterPosition)) {
            return 0;
        }
        if (this.serviceProvider.hasGroupRowTemplate(mapAdapterPosition)) {
            return 2;
        }
        return this.serviceProvider.hasGroupRowValueTemplate(mapAdapterPosition) ? this.serviceProvider.hasGroupRowSummaryTemplate(mapAdapterPosition) ? 3 : 4 : this.serviceProvider.hasGroupRowSummaryTemplate(mapAdapterPosition) ? 5 : 1;
    }

    private final GridRowViewBase getRowViewByType(int type) {
        GridAction gridAction;
        GridRowView gridRowView;
        GridAction gridAction2;
        GridAction gridAction3;
        GridAction gridAction4;
        GridAction gridAction5;
        GridAction gridAction6;
        switch (type) {
            case 0:
                Context context = this.context;
                ViewPortWidthProvider viewPortWidthProvider = this.viewPortWidthProvider;
                GridAction gridAction7 = this.gridAction;
                if (gridAction7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                    gridAction = null;
                } else {
                    gridAction = gridAction7;
                }
                gridRowView = new GridRowView(context, viewPortWidthProvider, gridAction, this.swipeCacheProvider.getActionsContainerCache(), this.onSwipeOffsetChangeListener, this.layoutProvider);
                break;
            case 1:
                Context context2 = this.context;
                LayoutProvider layoutProvider = this.layoutProvider;
                GroupHeaderAppearanceProvider nativeGroupHeaderAppearanceProvider = this.serviceProvider.getNativeGroupHeaderAppearanceProvider();
                ServiceProvider serviceProvider = this.serviceProvider;
                ServiceProvider serviceProvider2 = serviceProvider;
                ViewPortWidthProvider viewPortWidthProvider2 = this.viewPortWidthProvider;
                GroupRowViewProviderBase groupRowProvider = serviceProvider.getGroupRowProvider(false, false, false);
                GridAction gridAction8 = this.gridAction;
                if (gridAction8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                    gridAction2 = null;
                } else {
                    gridAction2 = gridAction8;
                }
                gridRowView = new GridGroupHeaderView(context2, layoutProvider, nativeGroupHeaderAppearanceProvider, serviceProvider2, viewPortWidthProvider2, groupRowProvider, gridAction2);
                break;
            case 2:
                Context context3 = this.context;
                LayoutProvider layoutProvider2 = this.layoutProvider;
                ServiceProvider serviceProvider3 = this.serviceProvider;
                ServiceProvider serviceProvider4 = serviceProvider3;
                ServiceProvider serviceProvider5 = serviceProvider3;
                ViewPortWidthProvider viewPortWidthProvider3 = this.viewPortWidthProvider;
                GroupRowViewProviderBase groupRowProvider2 = serviceProvider3.getGroupRowProvider(true, false, false);
                GridAction gridAction9 = this.gridAction;
                if (gridAction9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                    gridAction3 = null;
                } else {
                    gridAction3 = gridAction9;
                }
                gridRowView = new GridGroupHeaderView(context3, layoutProvider2, serviceProvider4, serviceProvider5, viewPortWidthProvider3, groupRowProvider2, gridAction3);
                break;
            case 3:
                Context context4 = this.context;
                LayoutProvider layoutProvider3 = this.layoutProvider;
                GroupHeaderAppearanceProvider nativeGroupHeaderAppearanceProvider2 = this.serviceProvider.getNativeGroupHeaderAppearanceProvider();
                ServiceProvider serviceProvider6 = this.serviceProvider;
                ServiceProvider serviceProvider7 = serviceProvider6;
                ViewPortWidthProvider viewPortWidthProvider4 = this.viewPortWidthProvider;
                GroupRowViewProviderBase groupRowProvider3 = serviceProvider6.getGroupRowProvider(false, true, true);
                GridAction gridAction10 = this.gridAction;
                if (gridAction10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                    gridAction4 = null;
                } else {
                    gridAction4 = gridAction10;
                }
                gridRowView = new GridGroupHeaderView(context4, layoutProvider3, nativeGroupHeaderAppearanceProvider2, serviceProvider7, viewPortWidthProvider4, groupRowProvider3, gridAction4);
                break;
            case 4:
                Context context5 = this.context;
                LayoutProvider layoutProvider4 = this.layoutProvider;
                GroupHeaderAppearanceProvider nativeGroupHeaderAppearanceProvider3 = this.serviceProvider.getNativeGroupHeaderAppearanceProvider();
                ServiceProvider serviceProvider8 = this.serviceProvider;
                ServiceProvider serviceProvider9 = serviceProvider8;
                ViewPortWidthProvider viewPortWidthProvider5 = this.viewPortWidthProvider;
                GroupRowViewProviderBase groupRowProvider4 = serviceProvider8.getGroupRowProvider(false, true, false);
                GridAction gridAction11 = this.gridAction;
                if (gridAction11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                    gridAction5 = null;
                } else {
                    gridAction5 = gridAction11;
                }
                gridRowView = new GridGroupHeaderView(context5, layoutProvider4, nativeGroupHeaderAppearanceProvider3, serviceProvider9, viewPortWidthProvider5, groupRowProvider4, gridAction5);
                break;
            case 5:
                Context context6 = this.context;
                LayoutProvider layoutProvider5 = this.layoutProvider;
                GroupHeaderAppearanceProvider nativeGroupHeaderAppearanceProvider4 = this.serviceProvider.getNativeGroupHeaderAppearanceProvider();
                ServiceProvider serviceProvider10 = this.serviceProvider;
                ServiceProvider serviceProvider11 = serviceProvider10;
                ViewPortWidthProvider viewPortWidthProvider6 = this.viewPortWidthProvider;
                GroupRowViewProviderBase groupRowProvider5 = serviceProvider10.getGroupRowProvider(false, false, true);
                GridAction gridAction12 = this.gridAction;
                if (gridAction12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                    gridAction6 = null;
                } else {
                    gridAction6 = gridAction12;
                }
                gridRowView = new GridGroupHeaderView(context6, layoutProvider5, nativeGroupHeaderAppearanceProvider4, serviceProvider11, viewPortWidthProvider6, groupRowProvider5, gridAction6);
                break;
            case 6:
                gridRowView = new GridProgressBarRow(this.context, this.viewPortWidthProvider, this.loadMoreActionProvider, this.serviceProvider);
                break;
            default:
                throw new IllegalArgumentException();
        }
        gridRowView.initialize(this.offsetProvider, this.serviceProvider);
        return gridRowView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.serviceProvider.getRowCount() + (this.loadMoreRowExists ? 1 : 0);
    }

    public final void onMove(RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        int bindingAdapterPosition = (this.loadMoreRowExists && target.getBindingAdapterPosition() == getItemCount() + (-1)) ? target.getBindingAdapterPosition() - 1 : target.getBindingAdapterPosition();
        if (this.sourceDragPosition >= 0) {
            GridAction gridAction = this.gridAction;
            if (gridAction == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                gridAction = null;
            }
            if (gridAction.canDropRow(this.sourceDragPosition, bindingAdapterPosition)) {
                this.targetDragPosition = bindingAdapterPosition;
                notifyItemMoved(source.getBindingAdapterPosition(), bindingAdapterPosition);
            }
        }
    }

    public final void onDrop() {
        this.layoutProvider.finishDrag();
        int i = this.sourceDragPosition;
        if (i >= 0 && this.targetDragPosition < 0) {
            this.targetDragPosition = i;
        }
        if (i >= 0) {
            GridAction gridAction = this.gridAction;
            GridAction gridAction2 = null;
            if (gridAction == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                gridAction = null;
            }
            if (gridAction.canDropRow(this.sourceDragPosition, this.targetDragPosition)) {
                this.serviceProvider.beginUpdate();
                GridAction gridAction3 = this.gridAction;
                if (gridAction3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridAction");
                } else {
                    gridAction2 = gridAction3;
                }
                gridAction2.dropRow(this.sourceDragPosition, this.targetDragPosition);
                this.serviceProvider.endUpdate();
            }
        }
        this.sourceDragPosition = -1;
        this.targetDragPosition = -1;
        if (this.prevLoadMoreRowExists) {
            addLoadMoreRow();
        }
    }

    public final void setCascadeTreeCreationEnabled(boolean isCascadeTreeCreationEnabled) {
        this.isCascadeTreeCreationEnabled = isCascadeTreeCreationEnabled;
    }

    public final void onDrag(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.prevLoadMoreRowExists = this.loadMoreRowExists;
        removeLoadMoreRow();
        this.layoutProvider.startDrag(viewHolder.itemView);
        if (this.sourceDragPosition < 0) {
            this.sourceDragPosition = viewHolder.getBindingAdapterPosition();
        }
    }

    /* compiled from: GridRowsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/dxgrid/layout/GridRowsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rowView", "Lcom/devexpress/dxgrid/views/GridRowViewBase;", "(Lcom/devexpress/dxgrid/layout/GridRowsAdapter;Lcom/devexpress/dxgrid/views/GridRowViewBase;)V", "getRowView", "()Lcom/devexpress/dxgrid/views/GridRowViewBase;", "updateRunnable", "Lcom/devexpress/dxgrid/layout/RunnablesQueue$Item;", "getUpdateRunnable", "()Lcom/devexpress/dxgrid/layout/RunnablesQueue$Item;", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final GridRowViewBase rowView;
        final /* synthetic */ GridRowsAdapter this$0;
        private final RunnablesQueue.Item updateRunnable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(GridRowsAdapter gridRowsAdapter, GridRowViewBase rowView) {
            super(rowView);
            Intrinsics.checkNotNullParameter(rowView, "rowView");
            this.this$0 = gridRowsAdapter;
            this.rowView = rowView;
            this.updateRunnable = new RunnablesQueue.Item(new Runnable() { // from class: com.devexpress.dxgrid.layout.GridRowsAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GridRowsAdapter.ViewHolder.updateRunnable$lambda$0(GridRowsAdapter.ViewHolder.this);
                }
            }, false, 2, null);
        }

        public final GridRowViewBase getRowView() {
            return this.rowView;
        }

        public final RunnablesQueue.Item getUpdateRunnable() {
            return this.updateRunnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void updateRunnable$lambda$0(ViewHolder this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.rowView.getParent() == null || this$0.rowView.getBottom() < 0) {
                return;
            }
            this$0.rowView.setIsReady(true);
            this$0.rowView.updateContent();
        }
    }

    @Override // com.devexpress.dxgrid.utils.CascadeUpdateProvider
    /* renamed from: getCascadeUpdateEnabled, reason: from getter */
    public boolean getIsCascadeUpdateEnabled() {
        return this.isCascadeUpdateEnabled;
    }

    @Override // com.devexpress.dxgrid.utils.CascadeUpdateProvider
    public void setCascadeUpdateEnabled(boolean z) {
        this.isCascadeUpdateEnabled = z;
    }
}
