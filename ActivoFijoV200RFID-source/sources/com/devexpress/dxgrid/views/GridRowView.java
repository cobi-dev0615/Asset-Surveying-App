package com.devexpress.dxgrid.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.dxgrid.layout.GridRowSwipeController;
import com.devexpress.dxgrid.layout.RunnablesQueue;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.GridCellCreatorService;
import com.devexpress.dxgrid.utils.LayoutInfo;
import com.devexpress.dxgrid.utils.OnSwipeOffsetChangeListener;
import com.devexpress.dxgrid.utils.SwipeActionsContainerCache;
import com.devexpress.dxgrid.utils.providers.LayoutProvider;
import com.devexpress.dxgrid.utils.providers.OffsetProvider;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridRowView.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020(J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u0004\u0018\u00010\u0019J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0014H\u0014J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u0014H\u0014J\u0018\u00107\u001a\u00020(2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0014H\u0002J\b\u0010=\u001a\u00020(H\u0016J\b\u0010>\u001a\u00020(H\u0016J\b\u0010?\u001a\u00020\u0011H\u0002J\u0006\u0010@\u001a\u00020(J\u0006\u0010A\u001a\u00020(J\b\u0010B\u001a\u00020(H\u0014J\u000e\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u0014J\b\u0010E\u001a\u00020\u0011H\u0016J\b\u0010F\u001a\u00020(H\u0002J\u000e\u0010G\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020\u0011H\u0016J\u0010\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020\u0014H\u0016J\b\u0010L\u001a\u00020(H\u0016J\u0010\u0010L\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020(H\u0016J\u0010\u0010M\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/devexpress/dxgrid/views/GridRowView;", "Lcom/devexpress/dxgrid/views/GridRowViewBase;", "Lcom/devexpress/dxgrid/layout/GridRowSwipeController$OnLayoutListener;", "context", "Landroid/content/Context;", "viewPortWidthProvider", "Lcom/devexpress/dxgrid/utils/providers/ViewPortWidthProvider;", "gridAction", "Lcom/devexpress/dxgrid/providers/GridAction;", "swipeCache", "Lcom/devexpress/dxgrid/utils/SwipeActionsContainerCache;", "onSwipeOffsetChangeListener", "Lcom/devexpress/dxgrid/utils/OnSwipeOffsetChangeListener;", "layoutProvider", "Lcom/devexpress/dxgrid/utils/providers/LayoutProvider;", "(Landroid/content/Context;Lcom/devexpress/dxgrid/utils/providers/ViewPortWidthProvider;Lcom/devexpress/dxgrid/providers/GridAction;Lcom/devexpress/dxgrid/utils/SwipeActionsContainerCache;Lcom/devexpress/dxgrid/utils/OnSwipeOffsetChangeListener;Lcom/devexpress/dxgrid/utils/providers/LayoutProvider;)V", "isFixedHeight", "", "()Z", "lastOffset", "", "lastViewPortWidth", "layoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "longPressRunnable", "Ljava/lang/Runnable;", "showAllRunnable", "Lcom/devexpress/dxgrid/layout/RunnablesQueue$Item;", "swipeController", "Lcom/devexpress/dxgrid/layout/GridRowSwipeController;", "swipeOffset", "getSwipeOffset", "()I", "updateInProgress", "viewPortWidth", "getViewPortWidth", "visibleColumns", "", "Lcom/devexpress/dxgrid/utils/ColumnInfo;", "beforeDrag", "", "cancelUpdateContent", "ensureCellExists", "container", "Lcom/devexpress/dxgrid/views/GridCellContainer;", "focusLost", "forceLayoutAll", "getChildCount", "getFixedHeight", "getLongPressRunnable", "getTouchListener", "Landroid/view/View$OnTouchListener;", "columnIndex", "getView", "index", "initialize", "offsetProvider", "Lcom/devexpress/dxgrid/utils/providers/OffsetProvider;", "serviceProvider", "Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;", "isCellInInplace", "layoutChildren", "layoutViews", "needActualizeColumns", "onActionDown", "onActionUp", "onDetachedFromWindow", "onHorizontalOverScroll", TypedValues.CycleType.S_WAVE_OFFSET, "onSingleTapUp", "removeAllContainers", "setLongPressRunnable", "setSelected", "selected", "update", "rowIndex", "updateAppearance", "updateContent", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class GridRowView extends GridRowViewBase implements GridRowSwipeController.OnLayoutListener {
    private final GridAction gridAction;
    private int lastOffset;
    private int lastViewPortWidth;
    private final LinearLayout.LayoutParams layoutParams;
    private Runnable longPressRunnable;
    private final OnSwipeOffsetChangeListener onSwipeOffsetChangeListener;
    private final RunnablesQueue.Item showAllRunnable;
    private final SwipeActionsContainerCache swipeCache;
    private GridRowSwipeController swipeController;
    private boolean updateInProgress;
    private final ViewPortWidthProvider viewPortWidthProvider;
    private final Set<ColumnInfo> visibleColumns;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridRowView(Context context, ViewPortWidthProvider viewPortWidthProvider, GridAction gridAction, SwipeActionsContainerCache swipeActionsContainerCache, OnSwipeOffsetChangeListener onSwipeOffsetChangeListener, LayoutProvider layoutProvider) {
        super(context, layoutProvider);
        Intrinsics.checkNotNullParameter(viewPortWidthProvider, "viewPortWidthProvider");
        Intrinsics.checkNotNullParameter(gridAction, "gridAction");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        this.viewPortWidthProvider = viewPortWidthProvider;
        this.gridAction = gridAction;
        this.swipeCache = swipeActionsContainerCache;
        this.onSwipeOffsetChangeListener = onSwipeOffsetChangeListener;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        this.lastOffset = Integer.MIN_VALUE;
        this.lastViewPortWidth = Integer.MIN_VALUE;
        this.visibleColumns = new HashSet();
        setLayoutParams(layoutParams);
        this.showAllRunnable = new RunnablesQueue.Item(new Runnable() { // from class: com.devexpress.dxgrid.views.GridRowView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GridRowView.showAllRunnable$lambda$4(GridRowView.this);
            }
        }, true);
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    public void initialize(OffsetProvider offsetProvider, ServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        super.initialize(offsetProvider, serviceProvider);
        SwipeActionsContainerCache swipeActionsContainerCache = this.swipeCache;
        if (swipeActionsContainerCache != null) {
            GridRowSwipeController gridRowSwipeController = new GridRowSwipeController(this, this.viewPortWidthProvider, serviceProvider, swipeActionsContainerCache);
            this.swipeController = gridRowSwipeController;
            Intrinsics.checkNotNull(gridRowSwipeController);
            gridRowSwipeController.setOnLayoutListener(this);
        }
    }

    public final void setLongPressRunnable(Runnable longPressRunnable) {
        Intrinsics.checkNotNullParameter(longPressRunnable, "longPressRunnable");
        this.longPressRunnable = longPressRunnable;
    }

    public final Runnable getLongPressRunnable() {
        return this.longPressRunnable;
    }

    public final void onHorizontalOverScroll(int offset) {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController != null) {
            gridRowSwipeController.onHorizontalOverScroll(offset);
        }
    }

    public final void onActionDown() {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController != null) {
            gridRowSwipeController.onActionDown();
        }
    }

    public final void onActionUp() {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController != null) {
            gridRowSwipeController.onActionUp();
        }
    }

    public final void focusLost() {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController != null) {
            gridRowSwipeController.closeSwipeContainer();
        }
    }

    public final void beforeDrag() {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController != null) {
            gridRowSwipeController.closeSwipeContainer();
        }
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public boolean onSingleTapUp() {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController == null) {
            return false;
        }
        Intrinsics.checkNotNull(gridRowSwipeController);
        return gridRowSwipeController.closeSwipeContainer();
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        int childCount = super.getChildCount();
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        int i = 0;
        if (gridRowSwipeController != null && gridRowSwipeController.isAdditionalView()) {
            i = 1;
        }
        return childCount - i;
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase, com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public int getFixedHeight() {
        return getServiceProvider().getRowHeight();
    }

    @Override // com.devexpress.dxgrid.layout.GridRowSwipeController.OnLayoutListener
    public void layoutViews() {
        layoutChildren();
        OnSwipeOffsetChangeListener onSwipeOffsetChangeListener = this.onSwipeOffsetChangeListener;
        if (onSwipeOffsetChangeListener != null) {
            onSwipeOffsetChangeListener.rowSwipeOffsetChanged();
        }
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected View.OnTouchListener getTouchListener(int columnIndex) {
        return new OnTouchListener(getContext(), this.gridAction, this, getServiceProvider(), columnIndex, new Function0<Runnable>() { // from class: com.devexpress.dxgrid.views.GridRowView$getTouchListener$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Runnable invoke() {
                return GridRowView.this.getLongPressRunnable();
            }
        });
    }

    public final int getSwipeOffset() {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController == null) {
            return 0;
        }
        Intrinsics.checkNotNull(gridRowSwipeController);
        return gridRowSwipeController.getSwipeOffset();
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase, com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public boolean isFixedHeight() {
        return getServiceProvider().getFixedRowHeight();
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    public void layoutChildren() {
        if (needActualizeColumns()) {
            removeOutOfScreenContainers();
            int columnCount = getServiceProvider().getColumnCount();
            boolean z = false;
            for (int i = 0; i < columnCount; i++) {
                ColumnInfo column = getServiceProvider().getColumn(i);
                Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
                if (getServiceProvider().isColumnInScreen(column) && getContainerWithColumnIndex(i) == null) {
                    final GridCellContainer obtainAndAddContainer = obtainAndAddContainer(i);
                    updateAppearance(obtainAndAddContainer);
                    if (this.isCascadeUpdateEnabled) {
                        this.updateInProgress = true;
                        setIsReady(false);
                        if (!this.showAllRunnable.isInQueue()) {
                            getServiceProvider().getRunnablesQueue().add(this.showAllRunnable);
                        } else {
                            getServiceProvider().getRunnablesQueue().moveIntervalToEnd(getServiceProvider().getRunnablesQueue().findIntervalStart(this.showAllRunnable), this.showAllRunnable);
                        }
                        obtainAndAddContainer.getUpdateRunnable().setRunnable(new Runnable() { // from class: com.devexpress.dxgrid.views.GridRowView$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                GridRowView.layoutChildren$lambda$0(GridRowView.this, obtainAndAddContainer);
                            }
                        });
                        obtainAndAddContainer.getUpdateRunnable().remove();
                        RunnablesQueue.Item item = this.showAllRunnable;
                        RunnablesQueue.Item updateRunnable = obtainAndAddContainer.getUpdateRunnable();
                        Intrinsics.checkNotNullExpressionValue(updateRunnable, "getUpdateRunnable(...)");
                        item.insertBefore(updateRunnable);
                    } else {
                        updateContent(obtainAndAddContainer);
                        obtainAndAddContainer.getCell().setAlpha(1.0f);
                        z = true;
                    }
                    if (obtainAndAddContainer.isSelected() != isSelected()) {
                        this.gridAction.selectionChanged(obtainAndAddContainer.getCell(), getRowIndex(), obtainAndAddContainer.getColumnIndex());
                        obtainAndAddContainer.setSelected(isSelected());
                    }
                }
            }
            if (!this.isCascadeUpdateEnabled && z) {
                this.updateInProgress = true;
                this.showAllRunnable.getRunnable().run();
            }
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            GridCellContainer gridCellContainer = (GridCellContainer) childAt;
            int columnIndex = gridCellContainer.getColumnIndex();
            int offset = (getServiceProvider().getColumn(columnIndex).getGridColumnModel().getFixedStyle() != FixedStyle.None ? getOffset() : 0) + getSwipeOffset();
            LayoutInfo layoutInfo = getLayoutInfos()[gridCellContainer.getColumnIndex()];
            gridCellContainer.layout(layoutInfo.getLeft() + offset, layoutInfo.getTop(), layoutInfo.getRight() + offset, layoutInfo.getBottom());
            gridCellContainer.setVisibility((getServiceProvider().getInplaceEditingColumnIndex() == columnIndex && getServiceProvider().getInplaceEditingRowIndex() == getRowIndex()) ? 4 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutChildren$lambda$0(GridRowView this$0, GridCellContainer container) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        if (!this$0.updateInProgress || container.getParent() == null) {
            return;
        }
        ViewParent parent = container.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        if (((ViewGroup) parent).getBottom() >= 0) {
            this$0.updateContent(container);
            container.hide();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            GridCellContainer gridCellContainer = (GridCellContainer) childAt;
            View cell = gridCellContainer.getCell();
            if (cell != null) {
                this.gridAction.selectionChanged(cell, getRowIndex(), gridCellContainer.getColumnIndex());
            }
        }
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected GridCellContainer getView(int index) {
        GridCellContainer view = super.getView(index);
        if (!isCellInInplace(view.getColumnIndex())) {
            return view;
        }
        GridCellContainer inplaceEditorContainer = getServiceProvider().getInplaceEditorContainer();
        Intrinsics.checkNotNullExpressionValue(inplaceEditorContainer, "getInplaceEditorContainer(...)");
        return inplaceEditorContainer;
    }

    private final boolean isCellInInplace(int index) {
        return getServiceProvider().getInplaceEditingRowIndex() == getRowIndex() && getServiceProvider().getInplaceEditingColumnIndex() == index && getServiceProvider().getInplaceEditorContainer() != null;
    }

    private final void forceLayoutAll() {
        forceLayout();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof GridCellContainer) {
                childAt.forceLayout();
                GridCellContainer gridCellContainer = (GridCellContainer) childAt;
                if (gridCellContainer.getChildCount() > 0) {
                    gridCellContainer.getCell().forceLayout();
                }
            }
        }
    }

    private final void ensureCellExists(GridCellContainer container) {
        if (container.getCell() == null) {
            View createCell = GridCellCreatorService.createCell(getContext(), getRowIndex(), container.getColumnIndex(), getServiceProvider());
            createCell.setSelected(isSelected());
            container.addView(createCell);
            container.hide();
            updateAppearance(container);
        }
    }

    private final void updateAppearance(GridCellContainer container) {
        container.updateAppearance(getServiceProvider().getColumn(container.getColumnIndex()).getGridColumnModel(), getServiceProvider(), getRowIndex());
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public void updateAppearance() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            updateAppearance((GridCellContainer) childAt);
        }
    }

    protected void updateContent(GridCellContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        ensureCellExists(container);
        GridColumnModel gridColumnModel = getServiceProvider().getColumn(container.getColumnIndex()).getGridColumnModel();
        gridColumnModel.getViewProvider().updateContent(container.getCell(), getServiceProvider(), gridColumnModel.getFieldName(), getRowIndex());
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public void updateContent() {
        if (this.updateInProgress) {
            return;
        }
        this.updateInProgress = true;
        boolean z = this.isCascadeUpdateEnabled && !getIsReady();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            final GridCellContainer gridCellContainer = (GridCellContainer) childAt;
            if (z) {
                gridCellContainer.setUpdateRunnable(new Runnable() { // from class: com.devexpress.dxgrid.views.GridRowView$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GridRowView.updateContent$lambda$2(GridRowView.this, gridCellContainer);
                    }
                });
                RunnablesQueue runnablesQueue = getServiceProvider().getRunnablesQueue();
                RunnablesQueue.Item updateRunnable = gridCellContainer.getUpdateRunnable();
                Intrinsics.checkNotNullExpressionValue(updateRunnable, "getUpdateRunnable(...)");
                runnablesQueue.add(updateRunnable);
            } else {
                updateContent(gridCellContainer);
                gridCellContainer.getCell().setAlpha(1.0f);
            }
        }
        if (z) {
            getServiceProvider().getRunnablesQueue().add(this.showAllRunnable);
        } else {
            this.showAllRunnable.getRunnable().run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateContent$lambda$2(GridRowView this$0, GridCellContainer container) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$container");
        if (!this$0.updateInProgress || container.getParent() == null) {
            return;
        }
        ViewParent parent = container.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        if (((ViewGroup) parent).getBottom() >= 0) {
            this$0.updateContent(container);
        }
    }

    public final void cancelUpdateContent() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof GridCellContainer) {
                ((GridCellContainer) childAt).getUpdateRunnable().remove();
            }
        }
        this.showAllRunnable.remove();
        this.updateInProgress = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cancelUpdateContent();
        super.onDetachedFromWindow();
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public void update(int rowIndex) {
        GridRowSwipeController gridRowSwipeController = this.swipeController;
        if (gridRowSwipeController != null) {
            gridRowSwipeController.resetSwipe();
        }
        int i = 0;
        if (getChildCount() != getServiceProvider().getColumnCount() && needActualizeColumns()) {
            removeOutOfScreenContainers();
            int columnCount = getServiceProvider().getColumnCount();
            while (i < columnCount) {
                if (getContainerWithColumnIndex(i) == null) {
                    ColumnInfo column = getServiceProvider().getColumn(i);
                    Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
                    if (getServiceProvider().isColumnInScreen(column)) {
                        obtainAndAddContainer(i);
                    }
                }
                i++;
            }
        } else if (getChildCount() != getServiceProvider().getColumnCount()) {
            removeAllContainers();
            int columnCount2 = getServiceProvider().getColumnCount();
            while (i < columnCount2) {
                ColumnInfo column2 = getServiceProvider().getColumn(i);
                Intrinsics.checkNotNullExpressionValue(column2, "getColumn(...)");
                if (getServiceProvider().isColumnInScreen(column2)) {
                    obtainAndAddContainer(i);
                }
                i++;
            }
        }
        super.update(rowIndex);
    }

    private final void removeAllContainers() {
        while (getChildCount() != 0) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            GridCellContainer gridCellContainer = (GridCellContainer) childAt;
            storeFreeCell(gridCellContainer);
            removeViewInLayout(gridCellContainer);
            gridCellContainer.getUpdateRunnable().remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAllRunnable$lambda$4(final GridRowView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.updateInProgress) {
            this$0.setIsReady(true);
            this$0.forceLayoutAll();
            this$0.requestLayout();
            this$0.showAll();
            this$0.post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridRowView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GridRowView.showAllRunnable$lambda$4$lambda$3(GridRowView.this);
                }
            });
        }
        this$0.updateInProgress = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAllRunnable$lambda$4$lambda$3(GridRowView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GridRowSwipeController gridRowSwipeController = this$0.swipeController;
        if (gridRowSwipeController != null) {
            gridRowSwipeController.relayout();
        }
    }

    private final int getViewPortWidth() {
        return getServiceProvider().getRight() - getServiceProvider().getLeft();
    }

    private final boolean needActualizeColumns() {
        if (getOffset() == this.lastOffset && getViewPortWidth() == this.lastViewPortWidth) {
            return false;
        }
        this.lastOffset = getOffset();
        this.lastViewPortWidth = getViewPortWidth();
        int columnCount = getServiceProvider().getColumnCount();
        boolean z = false;
        for (int i = 0; i < columnCount; i++) {
            ColumnInfo column = getServiceProvider().getColumn(i);
            Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
            boolean contains = this.visibleColumns.contains(column);
            if (getServiceProvider().isColumnInScreen(column)) {
                if (!contains) {
                    this.visibleColumns.add(column);
                    z = true;
                }
            } else if (contains) {
                this.visibleColumns.remove(column);
                z = true;
            }
        }
        return z;
    }
}
