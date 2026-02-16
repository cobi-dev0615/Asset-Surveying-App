package com.devexpress.dxgrid.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.wrappers.CustomGridCellContainerAppearanceWrapper;
import com.devexpress.dxgrid.layout.RunnablesQueue;
import com.devexpress.dxgrid.models.ContentAlignment;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.columns.CustomAppearanceProvider;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.utils.FixedColumnSeparatorStyle;
import com.devexpress.dxgrid.utils.GridContainerViewInfo;
import com.devexpress.dxgrid.utils.providers.CellAppearanceProvider;

/* loaded from: classes2.dex */
public class GridCellContainer extends ViewGroup {
    private Paint backgroundPaint;
    private Paint borderPaint;
    private Paint bottomBorderPaint;
    private Rect bounds;
    private GridCellContainerAppearance cellAppearance;
    private int columnIndex;
    private ContentAlignment horizontalAlignment;
    private RunnablesQueue.Item updateRunnable;
    private ContentAlignment verticalAlignment;
    private GridContainerViewInfo viewInfo;

    public void setUpdateRunnable(Runnable runnable) {
        this.updateRunnable.setRunnable(runnable);
    }

    public RunnablesQueue.Item getUpdateRunnable() {
        return this.updateRunnable;
    }

    public GridCellContainer(Context context, GridCellContainerAppearance gridCellContainerAppearance, GridContainerViewInfo gridContainerViewInfo, int i) {
        super(context);
        this.borderPaint = new Paint();
        this.bottomBorderPaint = new Paint();
        this.backgroundPaint = new Paint();
        this.bounds = new Rect();
        this.horizontalAlignment = ContentAlignment.Start;
        this.verticalAlignment = ContentAlignment.Start;
        this.updateRunnable = new RunnablesQueue.Item();
        setWillNotDraw(false);
        this.viewInfo = gridContainerViewInfo;
        this.columnIndex = i;
        setAppearance(gridCellContainerAppearance);
    }

    public GridCellContainer(Context context, View view, GridCellContainerAppearance gridCellContainerAppearance, GridContainerViewInfo gridContainerViewInfo, ViewGroup.LayoutParams layoutParams, int i) {
        this(context, gridCellContainerAppearance, gridContainerViewInfo, i);
        addViewInLayout(view, 0, layoutParams, false);
    }

    public GridCellContainer(Context context, View view, GridCellContainerAppearance gridCellContainerAppearance, GridContainerViewInfo gridContainerViewInfo, int i) {
        this(context, view, gridCellContainerAppearance, gridContainerViewInfo, new ViewGroup.LayoutParams(-2, -2), i);
    }

    public View getCell() {
        return getChildAt(0);
    }

    public void setHorizontalAlignment(ContentAlignment contentAlignment) {
        if (contentAlignment == null) {
            contentAlignment = ContentAlignment.Start;
        }
        this.horizontalAlignment = contentAlignment;
    }

    public ContentAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public void setVerticalAlignment(ContentAlignment contentAlignment) {
        if (contentAlignment == null) {
            contentAlignment = ContentAlignment.Start;
        }
        this.verticalAlignment = contentAlignment;
    }

    public ContentAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.getClipBounds(this.bounds);
        if (this.viewInfo == null || this.cellAppearance == null) {
            return;
        }
        this.backgroundPaint.setColor(isSelected() ? this.cellAppearance.getSelectionColor() : this.cellAppearance.getBackgroundColor());
        canvas.drawRect(this.bounds, this.backgroundPaint);
        if (this.viewInfo.getDrawLeftBorder()) {
            canvas.drawRect(this.bounds.left, this.bounds.top, this.bounds.left + this.cellAppearance.getVerticalLineThickness(), this.bounds.bottom, this.borderPaint);
        }
        if (this.viewInfo.getDrawTopBorder()) {
            canvas.drawRect(this.bounds.left, this.bounds.top, this.bounds.right, this.bounds.top + this.cellAppearance.getHorizontalLineThickness(), this.borderPaint);
        }
        if (this.viewInfo.getDrawRightBorder()) {
            canvas.drawRect(this.bounds.right - this.cellAppearance.getVerticalLineThickness(), this.bounds.top, this.bounds.right, this.bounds.bottom, this.borderPaint);
        }
        if (this.viewInfo.getDrawBottomBorder()) {
            canvas.drawRect(this.bounds.left, this.bounds.bottom - this.cellAppearance.getHorizontalLineThickness(), this.bounds.right, this.bounds.bottom, this.viewInfo.getBottomContainer() ? this.bottomBorderPaint : this.borderPaint);
        }
        if (this.viewInfo.getFixedColumnSeparatorStyle() == FixedColumnSeparatorStyle.Right) {
            canvas.drawRect(this.bounds.right - this.cellAppearance.getFixedColumnSeparatorWidth(), this.bounds.top, this.bounds.right, this.bounds.bottom, this.borderPaint);
        } else if (this.viewInfo.getFixedColumnSeparatorStyle() == FixedColumnSeparatorStyle.Left) {
            canvas.drawRect(this.bounds.left, this.bounds.top, this.bounds.left + this.cellAppearance.getFixedColumnSeparatorWidth(), this.bounds.bottom, this.borderPaint);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        View cell = getCell();
        if (cell == null || cell.getAlpha() != 1.0f) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = ((i3 - i) - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = cell.getMeasuredHeight();
        int i5 = AnonymousClass1.$SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[this.verticalAlignment.ordinal()];
        if (i5 == 1) {
            paddingTop = getPaddingTop();
        } else if (i5 == 2) {
            paddingTop = getPaddingTop() + (((((i4 - i2) - getPaddingTop()) - getPaddingBottom()) - measuredHeight) / 2);
        } else if (i5 == 3) {
            paddingTop = ((i4 - i2) - getPaddingBottom()) - measuredHeight;
        } else if (i5 != 4) {
            paddingTop = 0;
        } else {
            measuredHeight = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        cell.layout(paddingLeft, paddingTop, paddingLeft2 + paddingLeft, measuredHeight + paddingTop);
    }

    /* renamed from: com.devexpress.dxgrid.views.GridCellContainer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment;

        static {
            int[] iArr = new int[ContentAlignment.values().length];
            $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment = iArr;
            try {
                iArr[ContentAlignment.Start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[ContentAlignment.Center.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[ContentAlignment.End.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxgrid$models$ContentAlignment[ContentAlignment.Stretch.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View cell = getCell();
        int size = View.MeasureSpec.getSize(i);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (size - getPaddingLeft()) - getPaddingRight()), BasicMeasure.EXACTLY);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE) {
            cell.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(0, size2 - paddingTop), mode));
        } else {
            cell.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            if (mode == 1073741824 && cell.getMeasuredHeight() + paddingTop > size2) {
                cell.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode));
            }
        }
        setMeasuredDimension(size, cell.getMeasuredHeight() + paddingTop);
    }

    public GridCellContainerAppearance getAppearance() {
        return this.cellAppearance;
    }

    public void updateAppearance(GridColumnModel gridColumnModel, CellAppearanceProvider cellAppearanceProvider, int i) {
        setHorizontalAlignment(gridColumnModel.getHorizontalContentAlignment());
        setVerticalAlignment(gridColumnModel.getVerticalContentAlignment());
        if (cellAppearanceProvider == null) {
            return;
        }
        CustomAppearanceProvider customAppearanceProvider = gridColumnModel.getCustomAppearanceProvider();
        AppearanceBase customAppearance = (!cellAppearanceProvider.isUpdateShouldRequestCustomCellStyle() || customAppearanceProvider == null) ? null : customAppearanceProvider.getCustomAppearance(i);
        setAppearance(new CustomGridCellContainerAppearanceWrapper(cellAppearanceProvider.getCellAppearance(gridColumnModel), customAppearance));
        View cell = getCell();
        if (cell == null) {
            return;
        }
        gridColumnModel.getViewProvider().updateAppearance(cell, gridColumnModel, customAppearance, i);
    }

    public void setAppearance(GridCellContainerAppearance gridCellContainerAppearance) {
        this.cellAppearance = gridCellContainerAppearance;
        if (this.viewInfo == null || gridCellContainerAppearance == null) {
            return;
        }
        int i = gridCellContainerAppearance.getNoPadding().left;
        if (this.viewInfo.getDrawLeftBorder()) {
            i += gridCellContainerAppearance.getVerticalLineThickness();
        }
        int i2 = gridCellContainerAppearance.getNoPadding().right;
        if (this.viewInfo.getDrawRightBorder()) {
            i2 += gridCellContainerAppearance.getVerticalLineThickness();
        }
        int i3 = gridCellContainerAppearance.getNoPadding().top;
        if (this.viewInfo.getDrawTopBorder()) {
            i3 += gridCellContainerAppearance.getHorizontalLineThickness();
        }
        if (this.viewInfo.getFixedColumnSeparatorStyle() == FixedColumnSeparatorStyle.Right) {
            i2 += gridCellContainerAppearance.getFixedColumnSeparatorWidth();
        } else if (this.viewInfo.getFixedColumnSeparatorStyle() == FixedColumnSeparatorStyle.Left) {
            i += gridCellContainerAppearance.getFixedColumnSeparatorWidth();
        }
        setPadding(i, i3, i2, gridCellContainerAppearance.getNoPadding().bottom + gridCellContainerAppearance.getHorizontalLineThickness());
        this.borderPaint.setColor(gridCellContainerAppearance.getBorderColor());
        this.borderPaint.setStrokeWidth(0.0f);
        this.bottomBorderPaint.setColor(gridCellContainerAppearance.getBottomBorderColor());
        this.bottomBorderPaint.setStrokeWidth(0.0f);
    }

    public void show() {
        View cell = getCell();
        if (cell == null || cell.getAlpha() != 0.0f) {
            return;
        }
        cell.setAlpha(1.0f);
        if (getVisibility() != 4) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            cell.startAnimation(alphaAnimation);
        }
    }

    public void hide() {
        View cell = getCell();
        if (cell != null) {
            cell.setAlpha(0.0f);
        }
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }
}
