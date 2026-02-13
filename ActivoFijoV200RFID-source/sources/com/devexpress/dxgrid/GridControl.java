package com.devexpress.dxgrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.dxgrid.models.GridControlModel;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.models.GroupInfo;
import com.devexpress.dxgrid.models.SwipeButtonModel;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.DataProvider;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.utils.GestureManager;
import com.devexpress.dxgrid.utils.ObjectLambda;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.dxgrid.views.GridContainerView;
import com.devexpress.dxgrid.views.GridHorizontalScrollView;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* loaded from: classes.dex */
public class GridControl extends DXNativeView {
    private boolean autoBestFitColumns;
    private Paint borderPaint;
    private Rect bounds;
    private final GestureManager gestureRecognizer;
    private final GridContainerView gridContainerView;
    private final GridHorizontalScrollView horizontalScrollView;
    private boolean reduceHeightToContent;
    private ImageView watermarkImageView;
    private static final GridControlModel GRID_CONTROL_MODEL = new GridControlModel(new DataProvider() { // from class: com.devexpress.dxgrid.GridControl.1
        @Override // com.devexpress.dxgrid.providers.DataProvider
        public String getCellErrorText(String str, int i) {
            return null;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public String getDisplayText(Object obj, String str, int i) {
            return null;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public String getDisplayText(String str, int i) {
            return null;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public GroupInfo getGroupInfo(int i) {
            return null;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public int getRowCount() {
            return 0;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public String getTotalSummary(int i) {
            return null;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public Object getValue(String str, int i) {
            return null;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public void getValueAsync(String str, int i, ObjectLambda objectLambda) {
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public boolean isGroupRow(int i) {
            return false;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public boolean isSelected(int i) {
            return false;
        }

        @Override // com.devexpress.dxgrid.providers.DataProvider
        public String setCellValue(String str, int i, Object obj) {
            return null;
        }
    }, new GridColumnModel[0]);
    private static final GridAction GRID_ACTION = new GridAction() { // from class: com.devexpress.dxgrid.GridControl.2
        @Override // com.devexpress.dxgrid.providers.GridAction
        public boolean canDragRow(int i) {
            return false;
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public boolean canDropRow(int i, int i2) {
            return false;
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public boolean canLoadMore() {
            return false;
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public boolean canPullToRefresh() {
            return false;
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void cellDoubleTap(GridElement gridElement, int i, int i2) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void cellLongPress(GridElement gridElement, int i, int i2) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void cellTap(GridElement gridElement, int i, int i2) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void cellTapConfirmed(GridElement gridElement, int i, int i2) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public boolean closeEditor(boolean z) {
            return true;
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void dropRow(int i, int i2) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void loadMore() {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void pullTeRefresh() {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void scrolled(DXGridViewScrolledEventArgs dXGridViewScrolledEventArgs) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void selectionChanged(View view, int i, int i2) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void setTopRowIndex(int i) {
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public boolean swipeButtonShowing(boolean z, int i, int i2) {
            return true;
        }

        @Override // com.devexpress.dxgrid.providers.GridAction
        public void updateExtentSize(int i, int i2) {
        }
    };

    public GridControl(Context context) {
        this(context, null);
    }

    public GridControl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bounds = new Rect();
        this.borderPaint = new Paint();
        setWillNotDraw(false);
        inflate(getContext(), R.layout.grid_control, this);
        GridHorizontalScrollView gridHorizontalScrollView = (GridHorizontalScrollView) findViewById(R.id.horizontal_scroll_view);
        this.horizontalScrollView = gridHorizontalScrollView;
        GridContainerView gridContainerView = (GridContainerView) findViewById(R.id.grid_container_view);
        this.gridContainerView = gridContainerView;
        GestureManager gestureManager = new GestureManager(ViewConfiguration.get(context).getScaledTouchSlop());
        this.gestureRecognizer = gestureManager;
        gestureManager.setHorizontalScrollChecker(gridHorizontalScrollView);
        gridHorizontalScrollView.setOnScrollChangeListener(gridContainerView);
        gridHorizontalScrollView.setGestureRecognizer(gestureManager);
        gridContainerView.setGestureRecognizer(gestureManager);
        this.borderPaint.setStrokeWidth(0.0f);
        setGridAction(GRID_ACTION);
        setGridControlModel(GRID_CONTROL_MODEL);
    }

    private void setEndlessScrollMode(EndlessScrollMode endlessScrollMode) {
        this.gridContainerView.setEndlessScrollMode(endlessScrollMode);
    }

    public void setGridAction(GridAction gridAction) {
        this.gridContainerView.setGridAction(gridAction);
    }

    public void setReduceHeightToContent(boolean z) {
        this.reduceHeightToContent = z;
        requestLayout();
    }

    public void setAutoBestFitColumns(boolean z) {
        if (this.autoBestFitColumns == z) {
            return;
        }
        this.autoBestFitColumns = z;
        this.gridContainerView.setViewportWidth(0);
        requestLayout();
    }

    public void setGridControlModel(GridControlModel gridControlModel) {
        this.gridContainerView.setGridControlModel(gridControlModel);
        this.horizontalScrollView.setHorizontalScrollBarEnabled(gridControlModel.getHorizontalScrollBarVisibility());
        this.gestureRecognizer.setPullToRefreshEnabled(gridControlModel.getIsPullToRefreshEnabled());
        ServiceProvider serviceProvider = this.gridContainerView.getServiceProvider();
        this.gestureRecognizer.setLeftSwipeEnabled(serviceProvider.getLeftSwipeButtons() != null && serviceProvider.getLeftSwipeButtons().length > 0);
        this.gestureRecognizer.setRightSwipeEnabled(serviceProvider.getRightSwipeButtons() != null && serviceProvider.getRightSwipeButtons().length > 0);
        setPadding(Math.max(0, gridControlModel.getBorderThickness().left), Math.max(0, gridControlModel.getBorderThickness().top), Math.max(0, gridControlModel.getBorderThickness().right), Math.max(0, gridControlModel.getBorderThickness().bottom));
        this.borderPaint.setColor(gridControlModel.getBorderColor());
    }

    public void updateHeaderView(GridColumnModel[] gridColumnModelArr) {
        this.gridContainerView.updateHeaderView(gridColumnModelArr);
    }

    public boolean openInplaceEditor(int i, int i2) {
        return this.gridContainerView.openInplaceEditor(i, i2);
    }

    public boolean closeInplaceEditor(boolean z) {
        return this.gridContainerView.closeInplaceEditor(z);
    }

    public void setLoadMoreEnabled(boolean z) {
        setEndlessScrollMode(z ? EndlessScrollMode.IncrementalLoading : EndlessScrollMode.None);
    }

    public void setCascadeUpdateEnabled(boolean z) {
        this.gridContainerView.setCascadeUpdateEnabled(z);
    }

    public void setHorizontalVirtualizationEnabled(boolean z) {
        this.gridContainerView.setHorizontalVirtualizationEnabled(z);
    }

    public void setCascadeTreeCreationEnabled(boolean z) {
        this.gridContainerView.setCascadeTreeCreationEnabled(z);
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.gestureRecognizer.setPullToRefreshEnabled(z);
        this.gridContainerView.setPullToRefreshEnabled(z);
    }

    public void setUpdateShouldRequestCustomCellStyle(boolean z) {
        this.gridContainerView.setUpdateShouldRequestCustomCellStyle(z);
    }

    public void setRefreshing(boolean z) {
        this.gridContainerView.setRefreshing(z);
    }

    public void scrollToRow(int i) {
        this.gridContainerView.scrollToRow(i);
    }

    public void scrollToColumn(int i) {
        this.gridContainerView.scrollToColumn(i);
    }

    public void updateRows() {
        this.gridContainerView.updateRows();
    }

    public void updateSelectedRows() {
        this.gridContainerView.updateSelectedRows();
    }

    public void updateRow(int i) {
        this.gridContainerView.updateRow(i);
    }

    public void notifyItemMoved(int i, int i2, Runnable runnable) {
        this.gridContainerView.notifyItemMoved(i, i2, runnable);
    }

    public void populateTotalSummary() {
        this.gridContainerView.populateTotalSummary();
    }

    public void updateColumnsLayout(GridControlModel gridControlModel) {
        this.gridContainerView.updateColumnsLayout(gridControlModel);
    }

    public void updateTotalSummary() {
        this.gridContainerView.populateTotalSummary();
    }

    public void setSwipeButtons(SwipeButtonModel[] swipeButtonModelArr) {
        this.gridContainerView.setSwipeButtons(swipeButtonModelArr);
        ServiceProvider serviceProvider = this.gridContainerView.getServiceProvider();
        this.gestureRecognizer.setLeftSwipeEnabled(serviceProvider.getLeftSwipeButtons() != null && serviceProvider.getLeftSwipeButtons().length > 0);
        this.gestureRecognizer.setRightSwipeEnabled(serviceProvider.getRightSwipeButtons() != null && serviceProvider.getRightSwipeButtons().length > 0);
    }

    public void setFilterRowVisible(boolean z) {
        this.gridContainerView.setFilterRowVisible(z);
    }

    public void setFilterRowHeight(int i) {
        this.gridContainerView.setFilterRowHeight(i);
    }

    public void setShowFilterIcon(boolean z) {
        this.gridContainerView.setShowFilterIcon(z);
    }

    public void setShowFilterIcon(Boolean bool, int i) {
        this.gridContainerView.setShowFilterIcon(bool, i);
    }

    public void setFilterIconColor(int i) {
        this.gridContainerView.setFilterIconColor(i);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int i, int i2) {
        int size;
        int size2;
        int mode = View.MeasureSpec.getMode(i);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (this.autoBestFitColumns) {
            int absoluteWidth = this.gridContainerView.getAbsoluteWidth();
            size = mode == 0 ? absoluteWidth : View.MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(absoluteWidth, size);
            }
        } else {
            size = mode == 0 ? displayMetrics.widthPixels : View.MeasureSpec.getSize(i);
        }
        int max = Math.max(0, (size - getPaddingLeft()) - getPaddingRight());
        this.gridContainerView.setViewportWidth(max);
        if (View.MeasureSpec.getMode(i2) == 0) {
            size2 = this.reduceHeightToContent ? Integer.MAX_VALUE : displayMetrics.heightPixels;
        } else {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (size2 - getPaddingTop()) - getPaddingBottom()), this.reduceHeightToContent ? Integer.MIN_VALUE : 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY);
        this.horizontalScrollView.measure(makeMeasureSpec2, makeMeasureSpec);
        return new Size(size, correctHeightIfNeeded(size2, makeMeasureSpec2, makeMeasureSpec));
    }

    int correctHeightIfNeeded(int i, int i2, int i3) {
        if (!this.reduceHeightToContent || this.gridContainerView.isScrolled().booleanValue()) {
            return i;
        }
        this.gridContainerView.layoutInnerPanel();
        int contentHeight = this.gridContainerView.getContentHeight();
        if (contentHeight == i) {
            return i;
        }
        if (View.MeasureSpec.getMode(i3) != 0) {
            contentHeight = Math.min(i, contentHeight);
        }
        this.horizontalScrollView.measure(i2, View.MeasureSpec.makeMeasureSpec(contentHeight, View.MeasureSpec.getMode(i3)));
        return contentHeight;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.horizontalScrollView.layout(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        layoutWatermark(i, i2, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.getClipBounds(this.bounds);
        canvas.drawRect(this.bounds.left, this.bounds.top, this.bounds.left + getPaddingLeft(), this.bounds.bottom, this.borderPaint);
        canvas.drawRect(this.bounds.right - getPaddingRight(), this.bounds.top, this.bounds.right, this.bounds.bottom, this.borderPaint);
        canvas.drawRect(this.bounds.left, this.bounds.top, this.bounds.right, this.bounds.top + getPaddingTop(), this.borderPaint);
        canvas.drawRect(this.bounds.left, this.bounds.bottom - getPaddingBottom(), this.bounds.right, this.bounds.bottom, this.borderPaint);
    }

    private void initWatermark() {
        ImageView imageView = new ImageView(getContext());
        this.watermarkImageView = imageView;
        imageView.setImageResource(R.drawable.dxg_watermark);
        this.watermarkImageView.setAdjustViewBounds(true);
        float f = getResources().getDisplayMetrics().density;
        int intrinsicWidth = (int) ((this.watermarkImageView.getDrawable().getIntrinsicWidth() / f) + 0.5f);
        this.watermarkImageView.setMaxWidth(intrinsicWidth);
        this.watermarkImageView.setMaxHeight((int) ((this.watermarkImageView.getDrawable().getIntrinsicHeight() / f) + 0.5f));
        this.watermarkImageView.setImageAlpha(WorkQueueKt.MASK);
        addView(this.watermarkImageView);
    }

    private void layoutWatermark(int i, int i2, int i3, int i4) {
        ImageView imageView = this.watermarkImageView;
        if (imageView == null) {
            return;
        }
        int maxWidth = imageView.getMaxWidth();
        int maxHeight = this.watermarkImageView.getMaxHeight();
        int i5 = (i3 / 2) - (maxWidth / 2);
        int i6 = (i4 / 2) - (maxHeight / 2);
        this.watermarkImageView.layout(i5, i6, maxWidth + i5, maxHeight + i6);
    }

    public boolean isInplace() {
        return this.gridContainerView.isInplace();
    }
}
