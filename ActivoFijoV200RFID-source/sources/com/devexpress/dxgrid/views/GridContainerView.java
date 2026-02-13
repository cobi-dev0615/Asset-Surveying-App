package com.devexpress.dxgrid.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.devexpress.dxgrid.DXGridViewScrolledEventArgs;
import com.devexpress.dxgrid.EndlessScrollMode;
import com.devexpress.dxgrid.R;
import com.devexpress.dxgrid.interfaces.CellContainerCreator;
import com.devexpress.dxgrid.layout.GridRowsAdapter;
import com.devexpress.dxgrid.layout.RowTouchHelperCallback;
import com.devexpress.dxgrid.layout.RunnablesQueue;
import com.devexpress.dxgrid.layout.SimpleItemAnimator;
import com.devexpress.dxgrid.layout.SimpleLayoutManager;
import com.devexpress.dxgrid.layout.SimpleViewCacheExtension;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridControlModel;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.models.SwipeButtonModel;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.GestureManager;
import com.devexpress.dxgrid.utils.GridCellCreatorService;
import com.devexpress.dxgrid.utils.OnGridScrollChangeListener;
import com.devexpress.dxgrid.utils.OnSwipeOffsetChangeListener;
import com.devexpress.dxgrid.utils.SwipeActionsContainerCache;
import com.devexpress.dxgrid.utils.VerticalRecyclerViewSmoothScroller;
import com.devexpress.dxgrid.utils.providers.LoadMoreActionProvider;
import com.devexpress.dxgrid.utils.providers.OffsetProvider;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.dxgrid.utils.providers.SwipeCacheProvider;
import com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider;
import com.devexpress.dxgrid.views.GridContainerView;
import com.devexpress.dxgrid.views.GridRecyclerViewScrollListener;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class GridContainerView extends ViewGroup implements OffsetProvider, ViewPortWidthProvider, OnGridScrollChangeListener, SwipeCacheProvider, LoadMoreActionProvider, OnSwipeOffsetChangeListener, GridRecyclerViewScrollListener.OnScrollStateListener {
    private final GridRowsAdapter adapter;
    private final SimpleViewCacheExtension cacheExtension;
    private final RowTouchHelperCallback callback;
    private GridRowView currentHitRowView;
    private EndlessScrollMode endlessScrollMode;
    private int extentHeight;
    private int extentWidth;
    private int filterRowHeight;
    private final Runnable fixTopOverScrollEffectPosition;
    private GridAction gridAction;
    private GridFilterView gridFilterView;
    private final GridFooterView gridFooterView;
    private final GridHeaderView gridHeaderView;
    private final GridRecyclerView gridRowsScrollView;
    private boolean isFilterRowVisible;
    private boolean isHorizontalVirtualizationEnabled;
    private boolean isLoadMoreProcessing;
    private final SimpleLayoutManager layoutManager;
    private int offsetX;
    private int offsetY;
    private int previousAutoLoadMoreRowsCount;
    private final SwipeRefreshLayout pullToRefreshContainer;
    private final View pullToRefreshProgressView;
    private final Runnable requestUpdateRunnable;
    private final RunnablesQueue runnablesQueue;
    private DXGridViewScrolledEventArgs scrolledEventArgs;
    private final ServiceProvider serviceProvider;
    private SwipeActionsContainerCache swipeCache;
    private final GestureDetector tapUpGestureDetector;
    private int topRowIndex;
    private int updateLocker;
    private boolean updateShouldRequestCustomCellStyle;
    private int viewportWidth;

    /* renamed from: com.devexpress.dxgrid.views.GridContainerView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GridContainerView.this.layoutManager.setOnTopOverScrolledRunnable(null);
            GridContainerView.this.gridRowsScrollView.setPadding(0, 0, 0, 0);
            GridContainerView.this.gridRowsScrollView.scrollBy(0, -1);
            GridContainerView.this.post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GridContainerView.AnonymousClass1.this.m449lambda$run$0$comdevexpressdxgridviewsGridContainerView$1();
                }
            });
        }

        /* renamed from: lambda$run$0$com-devexpress-dxgrid-views-GridContainerView$1, reason: not valid java name */
        /* synthetic */ void m449lambda$run$0$comdevexpressdxgridviewsGridContainerView$1() {
            GridContainerView.this.correctVerticalScrollbarPosition();
        }
    }

    public GridContainerView(Context context) {
        this(context, null);
    }

    public GridContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewportWidth = 0;
        this.endlessScrollMode = EndlessScrollMode.None;
        this.currentHitRowView = null;
        this.isLoadMoreProcessing = false;
        this.previousAutoLoadMoreRowsCount = -1;
        this.updateShouldRequestCustomCellStyle = false;
        this.updateLocker = 0;
        this.filterRowHeight = -1;
        this.runnablesQueue = new RunnablesQueue();
        this.isHorizontalVirtualizationEnabled = false;
        this.isFilterRowVisible = false;
        this.fixTopOverScrollEffectPosition = new AnonymousClass1();
        setWillNotDraw(false);
        inflate(getContext(), R.layout.grid_container_view, this);
        ServiceProvider serviceProvider = new ServiceProvider(this);
        this.serviceProvider = serviceProvider;
        this.scrolledEventArgs = new DXGridViewScrolledEventArgs();
        GridHeaderView gridHeaderView = (GridHeaderView) findViewById(R.id.grid_header_view);
        this.gridHeaderView = gridHeaderView;
        gridHeaderView.initialize(this, serviceProvider);
        GridRecyclerView gridRecyclerView = (GridRecyclerView) findViewById(R.id.grid_rows_scrollview);
        this.gridRowsScrollView = gridRecyclerView;
        gridRecyclerView.setFocusable(false);
        gridRecyclerView.setItemAnimator(new SimpleItemAnimator());
        gridRecyclerView.addOnScrollListener(new GridRecyclerViewScrollListener(this));
        GridFooterView gridFooterView = (GridFooterView) findViewById(R.id.grid_footer_view);
        this.gridFooterView = gridFooterView;
        gridFooterView.initialize(this, serviceProvider);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.pull_to_refresh_container);
        this.pullToRefreshContainer = swipeRefreshLayout;
        SimpleLayoutManager simpleLayoutManager = new SimpleLayoutManager(serviceProvider);
        this.layoutManager = simpleLayoutManager;
        simpleLayoutManager.setOnBottomOverScrolledRunnable(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (GridContainerView.this.canSetAdapterToIncrementalLoadingMode()) {
                    GridContainerView gridContainerView = GridContainerView.this;
                    final GridRowsAdapter gridRowsAdapter = gridContainerView.adapter;
                    Objects.requireNonNull(gridRowsAdapter);
                    gridContainerView.post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            GridRowsAdapter.this.addLoadMoreRow();
                        }
                    });
                }
            }
        });
        SimpleViewCacheExtension simpleViewCacheExtension = new SimpleViewCacheExtension(gridRecyclerView);
        this.cacheExtension = simpleViewCacheExtension;
        gridRecyclerView.setViewCacheExtension(simpleViewCacheExtension);
        gridRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, 100);
        gridRecyclerView.setItemViewCacheSize(0);
        gridRecyclerView.setHasFixedSize(false);
        gridRecyclerView.setScrollbarFadingEnabled(true);
        gridRecyclerView.setLayoutManager(simpleLayoutManager);
        RowTouchHelperCallback rowTouchHelperCallback = new RowTouchHelperCallback(serviceProvider);
        this.callback = rowTouchHelperCallback;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(rowTouchHelperCallback);
        GridRowsAdapter gridRowsAdapter = new GridRowsAdapter(getContext(), serviceProvider, this, this, this, this, this, itemTouchHelper, simpleLayoutManager, serviceProvider);
        this.adapter = gridRowsAdapter;
        simpleLayoutManager.setGridRowsAdapter(gridRowsAdapter);
        gridRecyclerView.setOnScrollChangeRunnable(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GridContainerView.this.layoutInplaceEditor();
            }
        });
        rowTouchHelperCallback.setAdapter(gridRowsAdapter);
        gridRecyclerView.setAdapter(gridRowsAdapter);
        itemTouchHelper.attachToRecyclerView(gridRecyclerView);
        this.pullToRefreshProgressView = swipeRefreshLayout.getChildAt(0);
        swipeRefreshLayout.setEnabled(false);
        swipeRefreshLayout.setProgressViewOffset(false, ((-swipeRefreshLayout.getProgressCircleDiameter()) * 11) / 10, swipeRefreshLayout.getProgressViewEndOffset());
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.devexpress.dxgrid.views.GridContainerView.3
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (GridContainerView.this.gridAction != null) {
                    if (GridContainerView.this.gridAction.canPullToRefresh()) {
                        GridContainerView.this.gridAction.pullTeRefresh();
                    } else {
                        GridContainerView.this.setRefreshing(false);
                    }
                }
            }
        });
        this.requestUpdateRunnable = new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GridContainerView.this.m445lambda$new$0$comdevexpressdxgridviewsGridContainerView();
            }
        };
        this.tapUpGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.dxgrid.views.GridContainerView.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y <= GridContainerView.this.gridHeaderView.getHeight()) {
                    return false;
                }
                if (GridContainerView.this.findGridRowView(x, y) != null && x <= GridContainerView.this.serviceProvider.getRowWidth()) {
                    return false;
                }
                GridContainerView.this.gridAction.cellTap(GridElement.Row, Integer.MIN_VALUE, Integer.MIN_VALUE);
                return false;
            }
        });
    }

    /* renamed from: lambda$new$0$com-devexpress-dxgrid-views-GridContainerView, reason: not valid java name */
    /* synthetic */ void m445lambda$new$0$comdevexpressdxgridviewsGridContainerView() {
        int inplaceEditingRowIndex = this.serviceProvider.getInplaceEditingRowIndex();
        if (inplaceEditingRowIndex >= 0) {
            updateRow(inplaceEditingRowIndex);
        } else if (inplaceEditingRowIndex == -2147483647) {
            this.gridFilterView.update(inplaceEditingRowIndex);
        }
    }

    public int getAbsoluteWidth() {
        return this.serviceProvider.getAbsoluteWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layoutInplaceEditor() {
        int inplaceEditingColumnIndex;
        GridCellContainer containerWithColumnIndex;
        int top;
        int measuredHeight;
        int inplaceEditingRowIndex = this.serviceProvider.getInplaceEditingRowIndex();
        if (inplaceEditingRowIndex == Integer.MIN_VALUE || this.serviceProvider.getInplaceEditorContainer() == null) {
            return;
        }
        GridCellContainer inplaceEditorContainer = this.serviceProvider.getInplaceEditorContainer();
        GridRowView findRowView = findRowView(inplaceEditingRowIndex);
        if (findRowView != null && (containerWithColumnIndex = findRowView.getContainerWithColumnIndex((inplaceEditingColumnIndex = this.serviceProvider.getInplaceEditingColumnIndex()))) != null) {
            if (inplaceEditingRowIndex == -2147483647) {
                top = findRowView.layoutInfos[inplaceEditingColumnIndex].getTop();
                measuredHeight = this.gridHeaderView.getMeasuredHeight();
            } else {
                top = findRowView.getTop() + findRowView.layoutInfos[inplaceEditingColumnIndex].getTop() + this.gridHeaderView.getMeasuredHeight();
                measuredHeight = this.gridFilterView.getMeasuredHeight();
            }
            int i = top + measuredHeight;
            inplaceEditorContainer.layout(containerWithColumnIndex.getLeft(), i, containerWithColumnIndex.getRight(), findRowView.layoutInfos[inplaceEditingColumnIndex].getHeight() + i);
            if (this.serviceProvider.getColumn(containerWithColumnIndex.getColumnIndex()).getGridColumnModel().getFixedStyle() == FixedStyle.None) {
                inplaceEditorContainer.setClipBounds(new Rect(Math.max(0, this.serviceProvider.getLeft() - inplaceEditorContainer.getLeft()), 0, Math.max(0, Math.min(inplaceEditorContainer.getWidth(), (this.serviceProvider.getRight() - inplaceEditorContainer.getRight()) + inplaceEditorContainer.getWidth())), findRowView.layoutInfos[inplaceEditingColumnIndex].getHeight()));
                return;
            } else {
                inplaceEditorContainer.setClipBounds(null);
                return;
            }
        }
        inplaceEditorContainer.layout(inplaceEditorContainer.getLeft(), (-inplaceEditorContainer.getMeasuredHeight()) - 1, inplaceEditorContainer.getRight(), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void correctVerticalScrollbarPosition() {
        this.gridRowsScrollView.setPadding(0, 0, (this.gridRowsScrollView.getWidth() - this.viewportWidth) - this.offsetX, 0);
    }

    private void correctPullToRefreshIndicatorPosition() {
        this.pullToRefreshProgressView.setTranslationX(this.offsetX - ((getWidth() - this.viewportWidth) / 2));
    }

    @Override // com.devexpress.dxgrid.utils.providers.LoadMoreActionProvider
    public void sendLoadMore() {
        GridAction gridAction;
        if (this.isLoadMoreProcessing || (gridAction = this.gridAction) == null) {
            return;
        }
        this.isLoadMoreProcessing = true;
        gridAction.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GridRowView findGridRowView(int i, int i2) {
        GridFilterView gridFilterView;
        Rect rect = new Rect();
        this.pullToRefreshContainer.getHitRect(rect);
        if (rect.contains(i, i2)) {
            i -= this.pullToRefreshContainer.getLeft();
            i2 -= this.pullToRefreshContainer.getTop();
            for (int i3 = 0; i3 < this.gridRowsScrollView.getChildCount(); i3++) {
                View childAt = this.gridRowsScrollView.getChildAt(i3);
                childAt.getHitRect(rect);
                if (rect.contains(i, i2) && (childAt instanceof GridRowView)) {
                    return (GridRowView) childAt;
                }
            }
        }
        if (!this.isFilterRowVisible || (gridFilterView = this.gridFilterView) == null) {
            return null;
        }
        gridFilterView.getHitRect(rect);
        if (rect.contains(i, i2)) {
            return this.gridFilterView;
        }
        return null;
    }

    private boolean onGridRowActionDown(GridRowView gridRowView) {
        GridRowView gridRowView2 = this.currentHitRowView;
        if (gridRowView2 == null) {
            this.currentHitRowView = gridRowView;
            return false;
        }
        if (gridRowView2 != gridRowView) {
            gridRowView2.focusLost();
            this.currentHitRowView = gridRowView;
            return false;
        }
        gridRowView2.onActionDown();
        return true;
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.pullToRefreshContainer.setEnabled(z);
    }

    public void setCascadeUpdateEnabled(boolean z) {
        this.adapter.setCascadeUpdateEnabled(z);
    }

    public void setCascadeTreeCreationEnabled(boolean z) {
        this.adapter.setCascadeTreeCreationEnabled(z);
    }

    public void setGestureRecognizer(GestureManager gestureManager) {
        this.gridRowsScrollView.setGestureRecognizer(gestureManager);
        gestureManager.setVerticalScrollChecker(this.gridRowsScrollView);
    }

    public void setRefreshing(boolean z) {
        this.pullToRefreshContainer.setRefreshing(z);
        if (z) {
            return;
        }
        this.isLoadMoreProcessing = false;
        this.adapter.removeLoadMoreRow();
        if (canSetAdapterToIncrementalLoadingMode()) {
            int rowCount = this.serviceProvider.getRowCount();
            if (rowCount == this.previousAutoLoadMoreRowsCount) {
                this.previousAutoLoadMoreRowsCount = -1;
                return;
            }
            this.previousAutoLoadMoreRowsCount = rowCount;
            this.adapter.addLoadMoreRow();
            this.adapter.notifyDataSetChanged();
        }
    }

    public void setEndlessScrollMode(EndlessScrollMode endlessScrollMode) {
        this.endlessScrollMode = endlessScrollMode;
        if (endlessScrollMode == EndlessScrollMode.None) {
            this.adapter.removeLoadMoreRow();
        } else {
            this.adapter.addLoadMoreRow();
        }
    }

    public void updateSelectedRows() {
        for (int i = 0; i < this.gridRowsScrollView.getChildCount(); i++) {
            GridRowViewBase gridRowViewBase = (GridRowViewBase) this.gridRowsScrollView.getChildAt(i);
            int rowIndex = gridRowViewBase.getRowIndex();
            gridRowViewBase.setSelected(this.serviceProvider.isSelected(rowIndex));
            gridRowViewBase.updateAppearance();
            if (this.isFilterRowVisible && rowIndex == -2147483647) {
                this.gridFilterView.setSelected(rowIndex == -2147483647);
                this.gridFilterView.updateAppearance();
            }
        }
    }

    private int validateRowIndex(int i) {
        if (i < 0) {
            return 0;
        }
        return i >= this.serviceProvider.getRowCount() ? this.serviceProvider.getRowCount() - 1 : i;
    }

    public void scrollToRow(int i) {
        if (i != -2147483647) {
            this.gridRowsScrollView.scrollToPosition(validateRowIndex(i));
        }
    }

    private int validateColumnIndex(int i) {
        if (i < 0) {
            return 0;
        }
        return i >= this.serviceProvider.getColumnCount() ? this.serviceProvider.getColumnCount() - 1 : i;
    }

    public void scrollToColumn(int i) {
        if (this.serviceProvider.getColumnCount() == 0) {
            return;
        }
        ColumnInfo column = this.serviceProvider.getColumn(validateColumnIndex(i));
        int left = this.serviceProvider.getLeft() - column.getLeft();
        int right = column.getRight() - this.serviceProvider.getRight();
        if (left > 0 || right > 0) {
            if (left <= 0 || right <= 0) {
                View view = (View) getParent();
                if (left > 0) {
                    right = -left;
                }
                view.scrollBy(right, 0);
            }
        }
    }

    public void updateRows() {
        GridFilterView gridFilterView;
        if (isLocked()) {
            return;
        }
        this.adapter.notifyDataSetChanged();
        if (!this.isFilterRowVisible || (gridFilterView = this.gridFilterView) == null) {
            return;
        }
        gridFilterView.setIsReady(true);
        this.gridFilterView.update(GridFilterView.FILTER_ROW_HANDLE);
    }

    private GridRowViewBase findRowViewByVisibleIndex(int i) {
        for (int i2 = 0; i2 < this.gridRowsScrollView.getChildCount(); i2++) {
            GridRowViewBase gridRowViewBase = (GridRowViewBase) this.gridRowsScrollView.getChildAt(i2);
            if (gridRowViewBase.getRowIndex() == i) {
                return gridRowViewBase;
            }
        }
        return null;
    }

    public void updateRow(int i) {
        GridRowView findRowView = findRowView(i);
        if (findRowView != null) {
            findRowView.updateContent();
            findRowView.updateAppearance();
        }
    }

    private static void setZ(View view, float f) {
        if (view != null) {
            view.setZ(f);
        }
    }

    public void notifyItemMoved(int i, int i2, final Runnable runnable) {
        beginUpdate();
        final GridRowViewBase findRowViewByVisibleIndex = findRowViewByVisibleIndex(i);
        setZ(findRowViewByVisibleIndex, 1.0f);
        this.adapter.setMovePositions(i, i2);
        this.layoutManager.setLayoutDirectionForItemMove(i, i2);
        this.adapter.notifyItemMoved(i, i2);
        post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GridContainerView.this.m447xb6b36f18(runnable, findRowViewByVisibleIndex);
            }
        });
    }

    /* renamed from: lambda$notifyItemMoved$2$com-devexpress-dxgrid-views-GridContainerView, reason: not valid java name */
    /* synthetic */ void m447xb6b36f18(final Runnable runnable, final View view) {
        this.gridRowsScrollView.getItemAnimator().isRunning(new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
            public final void onAnimationsFinished() {
                GridContainerView.this.m446x413948d7(runnable, view);
            }
        });
    }

    /* renamed from: lambda$notifyItemMoved$1$com-devexpress-dxgrid-views-GridContainerView, reason: not valid java name */
    /* synthetic */ void m446x413948d7(Runnable runnable, View view) {
        this.adapter.setMovePositions(-1, -1);
        runnable.run();
        setZ(view, 0.0f);
        endUpdate();
    }

    public void updateColumnsLayout(GridControlModel gridControlModel) {
        this.serviceProvider.setGridDataModel(gridControlModel, this.gridAction);
        this.gridHeaderView.requestLayout();
        for (int i = 0; i < this.gridRowsScrollView.getChildCount(); i++) {
            ((GridViewBase) this.gridRowsScrollView.getChildAt(i)).requestLayout();
        }
        this.gridFooterView.requestLayout();
        correctVerticalScrollbarPosition();
    }

    public void setGridAction(GridAction gridAction) {
        this.gridAction = gridAction;
    }

    private void updateFilterView(GridAction gridAction, boolean z) {
        Boolean bool;
        GridFilterView gridFilterView = this.gridFilterView;
        if (gridFilterView != null) {
            bool = Boolean.valueOf(gridFilterView.getIsShowFilterIcon());
            removeView(this.gridFilterView);
        } else {
            bool = null;
        }
        GridFilterView gridFilterView2 = new GridFilterView(getContext(), this, gridAction, null, null, this.layoutManager);
        this.gridFilterView = gridFilterView2;
        gridFilterView2.setRowIndex(GridFilterView.FILTER_ROW_HANDLE);
        this.gridFilterView.setFocusableInTouchMode(true);
        this.gridFilterView.isCascadeUpdateEnabled = z;
        this.gridFilterView.setDescendantFocusability(131072);
        if (bool != null) {
            this.gridFilterView.setShowFilterIcon(bool.booleanValue());
        }
        this.gridFilterView.initialize(this, this.serviceProvider);
        addView(this.gridFilterView);
    }

    public void setGridControlModel(GridControlModel gridControlModel) {
        this.swipeCache = null;
        this.gridRowsScrollView.removeAllViews();
        this.callback.setRowDragPreviewShadowColor(gridControlModel.getRowDragPreviewShadowColor());
        this.adapter.setGridAction(this.gridAction);
        this.adapter.setCascadeUpdateEnabled(gridControlModel.getIsCascadeUpdateEnabled());
        this.adapter.setCascadeTreeCreationEnabled(gridControlModel.getIsCascadeTreeCreationEnabled());
        this.serviceProvider.setGridDataModel(gridControlModel, this.gridAction);
        this.gridHeaderView.initialize(this.serviceProvider, this.gridAction);
        updateFilterView(this.gridAction, gridControlModel.getIsCascadeUpdateEnabled());
        this.gridFooterView.initialize(this.serviceProvider, this.gridAction);
        this.gridRowsScrollView.setVerticalScrollBarEnabled(gridControlModel.getVerticalScrollBarVisibility());
        this.cacheExtension.clear();
        setPullToRefreshEnabled(gridControlModel.getIsPullToRefreshEnabled());
        setEndlessScrollMode(gridControlModel.getIsLoadMoreEnabled() ? EndlessScrollMode.IncrementalLoading : EndlessScrollMode.None);
        setHorizontalVirtualizationEnabled(gridControlModel.getIsHorizontalVirtualizationEnabled());
    }

    public void updateHeaderView(GridColumnModel[] gridColumnModelArr) {
        this.serviceProvider.updateColumns(gridColumnModelArr);
        this.gridHeaderView.updateViewsInContainers();
    }

    public void populateTotalSummary() {
        this.gridFooterView.update();
    }

    public void setViewportWidth(int i) {
        if (this.viewportWidth != i) {
            this.viewportWidth = i;
            this.serviceProvider.setViewPortWidth(i);
            this.gridHeaderView.forceLayout();
            this.gridFooterView.forceLayout();
            GridFilterView gridFilterView = this.gridFilterView;
            if (gridFilterView != null) {
                gridFilterView.forceLayout();
            }
            correctPullToRefreshIndicatorPosition();
            this.adapter.notifyDataSetChanged();
            this.layoutManager.setOnTopOverScrolledRunnable(this.fixTopOverScrollEffectPosition);
        }
    }

    public ServiceProvider getServiceProvider() {
        return this.serviceProvider;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int bottom;
        if (i != i3) {
            correctPullToRefreshIndicatorPosition();
        }
        if (i2 >= i4 || !isInplace() || this.serviceProvider.getInplaceEditingRowIndex() == -2147483647 || this.serviceProvider.getInplaceEditorContainer() == null || (bottom = this.serviceProvider.getInplaceEditorContainer().getBottom() - (this.pullToRefreshContainer.getBottom() - (i4 - i2))) <= 0) {
            return;
        }
        new VerticalRecyclerViewSmoothScroller(this.adapter, this.serviceProvider, this.gridRowsScrollView).smoothScrollBy(bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        GridHeaderView gridHeaderView = this.gridHeaderView;
        gridHeaderView.layout(i, i2, i3, gridHeaderView.getMeasuredHeight());
        if (this.gridFilterView.isLayoutRequested()) {
            int i5 = this.filterRowHeight;
            this.gridFilterView.measure(i3 - i, i5 >= 0 ? View.MeasureSpec.makeMeasureSpec(i5, BasicMeasure.EXACTLY) : View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        this.gridFilterView.layout(i, this.gridHeaderView.getBottom(), i3, this.gridHeaderView.getBottom() + this.gridFilterView.getMeasuredHeight());
        this.pullToRefreshContainer.layout(i, this.gridFilterView.getBottom(), i3, this.gridFilterView.getBottom() + this.pullToRefreshContainer.getMeasuredHeight());
        this.gridFooterView.layout(i, this.pullToRefreshContainer.getBottom(), i3, i4);
        layoutInplaceEditor();
        post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                GridContainerView.this.correctVerticalScrollbarPosition();
            }
        });
        int extentWidth = this.layoutManager.getExtentWidth();
        int extentHeight = this.layoutManager.getExtentHeight();
        if (extentWidth != this.extentWidth || extentHeight != this.extentHeight) {
            this.gridAction.updateExtentSize(extentWidth, extentHeight);
        }
        this.extentWidth = extentWidth;
        this.extentHeight = extentHeight;
        int topIndex = this.layoutManager.getTopIndex();
        if (this.topRowIndex != topIndex) {
            this.topRowIndex = topIndex;
            this.gridAction.setTopRowIndex(topIndex);
        }
    }

    public void layoutInnerPanel() {
        this.pullToRefreshContainer.layout(0, this.gridFilterView.getBottom(), getMeasuredWidth(), this.gridFilterView.getBottom() + this.pullToRefreshContainer.getMeasuredHeight());
    }

    public int getContentHeight() {
        return this.gridHeaderView.getMeasuredHeight() + this.gridFilterView.getMeasuredHeight() + this.gridFooterView.getMeasuredHeight() + this.layoutManager.getCurrentHeight();
    }

    public Boolean isScrolled() {
        return Boolean.valueOf(this.gridRowsScrollView.computeVerticalScrollOffset() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canSetAdapterToIncrementalLoadingMode() {
        GridAction gridAction;
        return (this.endlessScrollMode != EndlessScrollMode.IncrementalLoading || this.isLoadMoreProcessing || (gridAction = this.gridAction) == null || !gridAction.canLoadMore() || this.adapter.getLoadMoreRowExists()) ? false : true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int absoluteWidth = this.serviceProvider.getAbsoluteWidth();
        int max = Math.max(this.viewportWidth, absoluteWidth);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.gridHeaderView.measure(makeMeasureSpec, makeMeasureSpec2);
        this.gridFooterView.measure(makeMeasureSpec, makeMeasureSpec2);
        this.gridFilterView.measure(makeMeasureSpec, makeMeasureSpec2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredHeight = ((size - this.gridHeaderView.getMeasuredHeight()) - this.gridFooterView.getMeasuredHeight()) - this.gridFilterView.getMeasuredHeight();
        int mode = View.MeasureSpec.getMode(i2);
        if (this.viewportWidth > absoluteWidth && absoluteWidth != 0 && absoluteWidth == this.serviceProvider.getRowWidth()) {
            this.pullToRefreshContainer.measure(View.MeasureSpec.makeMeasureSpec(absoluteWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(Math.max(measuredHeight, 0), mode));
        } else {
            this.pullToRefreshContainer.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(measuredHeight, 0), mode));
        }
        setMeasuredDimension(max, size);
    }

    @Override // com.devexpress.dxgrid.utils.providers.OffsetProvider
    public int getOffsetX() {
        return this.offsetX;
    }

    @Override // com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider
    public int getViewPortWidth() {
        return this.viewportWidth;
    }

    @Override // com.devexpress.dxgrid.utils.OnGridScrollChangeListener
    public void onHorizontalScrollChange(int i) {
        int i2 = i - this.offsetX;
        this.offsetX = i;
        correctPullToRefreshIndicatorPosition();
        if (!this.serviceProvider.getRunnablesQueue().getHasItems()) {
            this.layoutManager.setTopToBottom(true);
        }
        TreeMap treeMap = new TreeMap();
        for (int i3 = 0; i3 < this.gridRowsScrollView.getChildCount(); i3++) {
            GridRowViewBase gridRowViewBase = (GridRowViewBase) this.gridRowsScrollView.getChildAt(i3);
            if (gridRowViewBase.getBottom() > 0) {
                treeMap.put(Integer.valueOf(gridRowViewBase.getRowIndex() * (this.layoutManager.getTopToBottom() ? 1 : -1)), gridRowViewBase);
            }
        }
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            ((GridRowViewBase) it.next()).layoutChildren();
        }
        this.gridHeaderView.layoutChildren();
        this.gridFilterView.layoutChildren();
        this.gridFooterView.layoutChildren();
        layoutInplaceEditor();
        correctVerticalScrollbarPosition();
        raiseScrolled(i2, 0);
    }

    @Override // com.devexpress.dxgrid.views.GridRecyclerViewScrollListener.OnScrollStateListener
    public void onScrolled(int i, int i2) {
        int offsetY = this.layoutManager.getOffsetY();
        raiseScrolled(i, offsetY - this.offsetY);
        this.offsetY = offsetY;
    }

    void raiseScrolled(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.scrolledEventArgs.set(i, i2, this.offsetX, this.layoutManager.getOffsetY(), this.layoutManager.getTopIndex(), this.layoutManager.getBottomIndex(), this.viewportWidth, getMeasuredHeight(), this.layoutManager.getExtentWidth(), this.layoutManager.getExtentHeight());
        this.gridAction.scrolled(this.scrolledEventArgs);
    }

    @Override // com.devexpress.dxgrid.utils.OnGridScrollChangeListener
    public void onHorizontalOverScroll(float f) {
        GridRowView gridRowView = this.currentHitRowView;
        if (gridRowView != null) {
            gridRowView.onHorizontalOverScroll((int) f);
        }
    }

    @Override // com.devexpress.dxgrid.utils.OnGridScrollChangeListener
    public void onActionUp() {
        GridRowView gridRowView = this.currentHitRowView;
        if (gridRowView != null) {
            gridRowView.onActionUp();
        }
    }

    @Override // com.devexpress.dxgrid.utils.OnGridScrollChangeListener
    public int getSwipeOffset() {
        GridRowView gridRowView = this.currentHitRowView;
        if (gridRowView != null) {
            return gridRowView.getSwipeOffset();
        }
        return 0;
    }

    @Override // com.devexpress.dxgrid.utils.OnGridScrollChangeListener
    public boolean isMotionInsideSwipedContainer(MotionEvent motionEvent) {
        return this.currentHitRowView == findGridRowView((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.tapUpGestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 0) {
            return false;
        }
        onGridRowActionDown(findGridRowView((int) motionEvent.getX(), (int) motionEvent.getY()));
        return false;
    }

    @Override // com.devexpress.dxgrid.utils.providers.SwipeCacheProvider
    public SwipeActionsContainerCache getActionsContainerCache() {
        if (this.swipeCache == null) {
            this.swipeCache = new SwipeActionsContainerCache(getContext(), this.serviceProvider, this.gridAction);
        }
        return this.swipeCache;
    }

    private GridRowView findRowView(int i) {
        for (int i2 = 0; i2 < this.gridRowsScrollView.getChildCount(); i2++) {
            GridViewBase gridViewBase = (GridViewBase) this.gridRowsScrollView.getChildAt(i2);
            if (gridViewBase instanceof GridRowView) {
                GridRowView gridRowView = (GridRowView) gridViewBase;
                if (gridRowView.getRowIndex() == i) {
                    return gridRowView;
                }
            }
        }
        if (i == -2147483647) {
            return this.gridFilterView;
        }
        return null;
    }

    /* renamed from: lambda$openInplaceEditor$3$com-devexpress-dxgrid-views-GridContainerView, reason: not valid java name */
    /* synthetic */ GridCellContainer m448x438a6367() {
        return GridCellCreatorService.createCellContainer(getContext(), this.serviceProvider.getInplaceEditingColumnIndex(), getServiceProvider());
    }

    public boolean openInplaceEditor(int i, int i2) {
        boolean z;
        CellContainerCreator cellContainerCreator = new CellContainerCreator() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda6
            @Override // com.devexpress.dxgrid.interfaces.CellContainerCreator
            public final GridCellContainer getCellContainer() {
                return GridContainerView.this.m448x438a6367();
            }
        };
        if (i == -2147483647) {
            z = this.serviceProvider.getColumn(i2).getGridColumnModel().isAllowAutoFilter();
        } else {
            z = findRowView(i) != null;
        }
        if (!z || !this.serviceProvider.startInplaceEditing(getContext(), this.requestUpdateRunnable, cellContainerCreator, i2, i)) {
            return false;
        }
        if (this.serviceProvider.getInplaceEditorContainer() != null) {
            addView(this.serviceProvider.getInplaceEditorContainer(), 1);
            this.serviceProvider.getInplaceEditorContainer().measure(View.MeasureSpec.makeMeasureSpec(this.serviceProvider.getColumn(i2).getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        return true;
    }

    public boolean closeInplaceEditor(boolean z) {
        int inplaceEditingRowIndex = this.serviceProvider.getInplaceEditingRowIndex();
        final GridCellContainer inplaceEditorContainer = this.serviceProvider.getInplaceEditorContainer();
        if (inplaceEditingRowIndex == Integer.MIN_VALUE) {
            return false;
        }
        if (!this.serviceProvider.finishInplaceEditing(z)) {
            if (inplaceEditorContainer == null) {
                return false;
            }
            inplaceEditorContainer.post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    GridContainerView.this.requestFocus();
                }
            });
            return false;
        }
        if (inplaceEditorContainer == null) {
            return true;
        }
        post(new Runnable() { // from class: com.devexpress.dxgrid.views.GridContainerView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GridContainerView.this.m444xd3358854(inplaceEditorContainer);
            }
        });
        updateRow(inplaceEditingRowIndex);
        return true;
    }

    /* renamed from: lambda$closeInplaceEditor$4$com-devexpress-dxgrid-views-GridContainerView, reason: not valid java name */
    /* synthetic */ void m444xd3358854(View view) {
        removeView(view);
    }

    public void setSwipeButtons(SwipeButtonModel[] swipeButtonModelArr) {
        this.serviceProvider.updateSwipeButtons(swipeButtonModelArr);
    }

    public boolean isInplace() {
        return this.serviceProvider.getInplaceEditingColumnIndex() >= 0;
    }

    @Override // com.devexpress.dxgrid.utils.OnSwipeOffsetChangeListener
    public void rowSwipeOffsetChanged() {
        layoutInplaceEditor();
    }

    public boolean isUpdateShouldRequestCustomCellStyle() {
        return this.updateShouldRequestCustomCellStyle;
    }

    public void setUpdateShouldRequestCustomCellStyle(boolean z) {
        this.updateShouldRequestCustomCellStyle = z;
    }

    public boolean isRefreshing() {
        return this.pullToRefreshContainer.isRefreshing();
    }

    public boolean isLocked() {
        return this.updateLocker > 0;
    }

    public void beginUpdate() {
        if (this.updateLocker < 0) {
            this.updateLocker = 0;
        }
        this.updateLocker++;
    }

    public void endUpdate() {
        int i = this.updateLocker - 1;
        this.updateLocker = i;
        if (i < 0) {
            this.updateLocker = 0;
        }
        updateRows();
    }

    public void setHorizontalVirtualizationEnabled(boolean z) {
        this.isHorizontalVirtualizationEnabled = z;
        this.swipeCache = null;
        this.gridRowsScrollView.removeAllViews();
        updateRows();
    }

    public boolean getHorizontalVirtualizationEnabled() {
        return this.isHorizontalVirtualizationEnabled;
    }

    public RunnablesQueue getRunnablesQueue() {
        return this.runnablesQueue;
    }

    public boolean isFilterRowVisible() {
        return this.isFilterRowVisible;
    }

    public void setFilterRowVisible(boolean z) {
        this.isFilterRowVisible = z;
        this.gridFilterView.update();
    }

    public void setFilterRowHeight(int i) {
        this.filterRowHeight = i;
        this.gridFilterView.requestLayout();
    }

    public int getFilterRowHeight() {
        return this.filterRowHeight;
    }

    public void setShowFilterIcon(boolean z) {
        this.gridFilterView.setShowFilterIcon(z);
        this.gridFilterView.update();
    }

    public void setShowFilterIcon(Boolean bool, int i) {
        this.serviceProvider.getColumn(i).getGridColumnModel().setShowFilterIcon(bool);
        this.gridFilterView.update();
    }

    public void setFilterIconColor(int i) {
        this.gridFilterView.setFilterIconColor(i);
    }
}
