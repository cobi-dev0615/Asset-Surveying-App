package com.devexpress.dxgrid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.LayoutInfo;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridColumnsViewBase.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\b\u0010\u001c\u001a\u00020\u0017H$J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0014J\u0006\u0010\u001f\u001a\u00020\u0015R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/devexpress/dxgrid/views/GridColumnsViewBase;", "Lcom/devexpress/dxgrid/views/GridViewBase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "containerLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getContainerLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "gridAction", "Lcom/devexpress/dxgrid/providers/GridAction;", "getGridAction", "()Lcom/devexpress/dxgrid/providers/GridAction;", "setGridAction", "(Lcom/devexpress/dxgrid/providers/GridAction;)V", "actualizeContainers", "", "shouldBeMeasureNewContainers", "", "getDefaultHeight", "initialize", "serviceProvider", "Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;", "isVisible", "layoutChildren", "reset", "update", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class GridColumnsViewBase extends GridViewBase {
    protected GridAction gridAction;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridColumnsViewBase(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected ViewGroup.LayoutParams getContainerLayoutParams() {
        return null;
    }

    protected abstract boolean isVisible();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridColumnsViewBase(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected final GridAction getGridAction() {
        GridAction gridAction = this.gridAction;
        if (gridAction != null) {
            return gridAction;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gridAction");
        return null;
    }

    protected final void setGridAction(GridAction gridAction) {
        Intrinsics.checkNotNullParameter(gridAction, "<set-?>");
        this.gridAction = gridAction;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridColumnsViewBase(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setWillNotDraw(false);
    }

    public /* synthetic */ GridColumnsViewBase(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public int getDefaultHeight() {
        return getFixedHeight();
    }

    protected final void initialize(ServiceProvider serviceProvider, GridAction gridAction) {
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        Intrinsics.checkNotNullParameter(gridAction, "gridAction");
        setServiceProvider(serviceProvider);
        setGridAction(gridAction);
        update();
    }

    private final void actualizeContainers(boolean shouldBeMeasureNewContainers) {
        if (!isVisible()) {
            reset();
            return;
        }
        if (getServiceProvider().getColumnCount() != getChildCount()) {
            removeOutOfScreenContainers();
            int columnCount = getServiceProvider().getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                ColumnInfo column = getServiceProvider().getColumn(i);
                Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
                if (getServiceProvider().isColumnInScreen(column) && getContainerWithColumnIndex(i) == null) {
                    GridCellContainer obtainAndAddContainer = obtainAndAddContainer(i);
                    if (shouldBeMeasureNewContainers) {
                        LayoutInfo layoutInfo = getLayoutInfos()[column.getIndex()];
                        obtainAndAddContainer.measure(layoutInfo.getWidth(), layoutInfo.getHeight());
                    }
                    forceLayout();
                }
            }
        }
    }

    public final void update() {
        reset();
        actualizeContainers(false);
    }

    protected void reset() {
        if (getChildCount() > 0) {
            removeAllViews();
        } else {
            requestLayout();
        }
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    public void layoutChildren() {
        actualizeContainers(true);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            GridCellContainer gridCellContainer = (GridCellContainer) childAt;
            int offset = getServiceProvider().getColumn(gridCellContainer.getColumnIndex()).getGridColumnModel().getFixedStyle() != FixedStyle.None ? getOffset() : 0;
            LayoutInfo layoutInfo = getLayoutInfos()[gridCellContainer.getColumnIndex()];
            gridCellContainer.layout(layoutInfo.getLeft() + offset, layoutInfo.getTop(), layoutInfo.getRight() + offset, layoutInfo.getBottom());
        }
    }
}
