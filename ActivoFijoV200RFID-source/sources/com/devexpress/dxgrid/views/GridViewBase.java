package com.devexpress.dxgrid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.GridCellCreatorService;
import com.devexpress.dxgrid.utils.LayoutCalculator;
import com.devexpress.dxgrid.utils.LayoutInfo;
import com.devexpress.dxgrid.utils.MeasureHelper;
import com.devexpress.dxgrid.utils.providers.ItemHeightProvider;
import com.devexpress.dxgrid.utils.providers.OffsetProvider;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.editors.DisplayEdit;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* compiled from: GridViewBase.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0015\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B!\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\tJ\u0010\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\tH$J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\tH\u0014J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020/H&J\u0010\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0004J0\u00102\u001a\u00020/2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0014J\u0018\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0014J\b\u0010<\u001a\u00020/H\u0016J\b\u0010=\u001a\u00020/H\u0004J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020$H\u0004J\u0010\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020BH\u0002R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0084.¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/devexpress/dxgrid/views/GridViewBase;", "Landroid/view/ViewGroup;", "Lcom/devexpress/dxgrid/utils/providers/ItemHeightProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "containerLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getContainerLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "layoutInfos", "", "Lcom/devexpress/dxgrid/utils/LayoutInfo;", "getLayoutInfos", "()[Lcom/devexpress/dxgrid/utils/LayoutInfo;", "setLayoutInfos", "([Lcom/devexpress/dxgrid/utils/LayoutInfo;)V", "[Lcom/devexpress/dxgrid/utils/LayoutInfo;", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset", "()I", "offsetProvider", "Lcom/devexpress/dxgrid/utils/providers/OffsetProvider;", "serviceProvider", "Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;", "getServiceProvider", "()Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;", "setServiceProvider", "(Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;)V", "startFixedCount", "createCellContainer", "Lcom/devexpress/dxgrid/views/GridCellContainer;", "columnIndex", "getCellInsertPosition", "fixedStyle", "Lcom/devexpress/dxgrid/models/FixedStyle;", "getContainerWithColumnIndex", "getTouchListener", "Landroid/view/View$OnTouchListener;", "getView", "index", "initialize", "", "layoutChildren", "obtainAndAddContainer", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeAllViews", "removeOutOfScreenContainers", "storeFreeCell", "container", "updateLayoutInfosAndGetHeight", "heights", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class GridViewBase extends ViewGroup implements ItemHeightProvider {
    protected LayoutInfo[] layoutInfos;
    private OffsetProvider offsetProvider;
    protected ServiceProvider serviceProvider;
    private int startFixedCount;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridViewBase(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    protected abstract View.OnTouchListener getTouchListener(int columnIndex);

    public abstract void layoutChildren();

    protected final LayoutInfo[] getLayoutInfos() {
        LayoutInfo[] layoutInfoArr = this.layoutInfos;
        if (layoutInfoArr != null) {
            return layoutInfoArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutInfos");
        return null;
    }

    protected final void setLayoutInfos(LayoutInfo[] layoutInfoArr) {
        Intrinsics.checkNotNullParameter(layoutInfoArr, "<set-?>");
        this.layoutInfos = layoutInfoArr;
    }

    protected final ServiceProvider getServiceProvider() {
        ServiceProvider serviceProvider = this.serviceProvider;
        if (serviceProvider != null) {
            return serviceProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serviceProvider");
        return null;
    }

    protected final void setServiceProvider(ServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(serviceProvider, "<set-?>");
        this.serviceProvider = serviceProvider;
    }

    protected ViewGroup.LayoutParams getContainerLayoutParams() {
        return getLayoutParams();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridViewBase(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClipChildren(true);
        setWillNotDraw(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridViewBase(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setWillNotDraw(false);
    }

    public /* synthetic */ GridViewBase(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void initialize(OffsetProvider offsetProvider, ServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        this.offsetProvider = offsetProvider;
        setServiceProvider(serviceProvider);
    }

    public final int getOffset() {
        OffsetProvider offsetProvider = this.offsetProvider;
        if (offsetProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offsetProvider");
            offsetProvider = null;
        }
        return offsetProvider.getOffsetX();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        layoutChildren();
    }

    private final int getCellInsertPosition(FixedStyle fixedStyle) {
        if (fixedStyle == FixedStyle.End) {
            return getChildCount() - this.startFixedCount;
        }
        if (fixedStyle != FixedStyle.Start) {
            return 0;
        }
        this.startFixedCount++;
        return getChildCount();
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.startFixedCount = 0;
        super.removeAllViews();
    }

    public final GridCellContainer getContainerWithColumnIndex(int columnIndex) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof GridCellContainer) {
                GridCellContainer gridCellContainer = (GridCellContainer) childAt;
                if (gridCellContainer.getColumnIndex() == columnIndex) {
                    return gridCellContainer;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.collections.IntIterator] */
    private final int updateLayoutInfosAndGetHeight(int[] heights) {
        int fixedHeight;
        Ref.IntRef intRef = new Ref.IntRef();
        LayoutInfo[] calculate = LayoutCalculator.INSTANCE.calculate(heights, getServiceProvider(), this);
        if (!isFixedHeight()) {
            if (calculate.length == 0) {
                fixedHeight = getDefaultHeight();
            } else {
                if (calculate.length == 0) {
                    throw new NoSuchElementException();
                }
                LayoutInfo layoutInfo = calculate[0];
                int lastIndex = ArraysKt.getLastIndex(calculate);
                if (lastIndex != 0) {
                    int bottom = layoutInfo.getBottom();
                    ?? it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        LayoutInfo layoutInfo2 = calculate[it.nextInt()];
                        int bottom2 = layoutInfo2.getBottom();
                        if (bottom < bottom2) {
                            layoutInfo = layoutInfo2;
                            bottom = bottom2;
                        }
                    }
                }
                fixedHeight = layoutInfo.getBottom();
            }
        } else {
            fixedHeight = getFixedHeight();
        }
        intRef.element = fixedHeight;
        setLayoutInfos(calculate);
        return Math.max(intRef.element, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int columnCount = getServiceProvider().getColumnCount();
        int[] iArr = new int[columnCount];
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            GridCellContainer view = getView(i);
            View cell = view.getCell();
            if (cell != null && cell.getAlpha() > 0.0f) {
                MeasureHelper.INSTANCE.measureView(getServiceProvider(), view, getFixedHeight());
                z = z || view.getMeasuredHeight() > 0;
                iArr[view.getColumnIndex()] = view.getMeasuredHeight();
            }
        }
        if (!z) {
            for (int i2 = 0; i2 < columnCount; i2++) {
                iArr[i2] = getDefaultHeight() / getServiceProvider().getRowsDefinitionsCount();
            }
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), updateLayoutInfosAndGetHeight(iArr));
    }

    protected GridCellContainer getView(int index) {
        View childAt = getChildAt(index);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
        return (GridCellContainer) childAt;
    }

    protected final void removeOutOfScreenContainers() {
        int i = 0;
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.devexpress.dxgrid.views.GridCellContainer");
            GridCellContainer gridCellContainer = (GridCellContainer) childAt;
            ColumnInfo column = getServiceProvider().getColumn(gridCellContainer.getColumnIndex());
            Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
            if (getServiceProvider().isColumnInScreen(column)) {
                i++;
            } else {
                storeFreeCell(gridCellContainer);
                removeView(gridCellContainer);
                gridCellContainer.getUpdateRunnable().remove();
            }
        }
    }

    protected final void storeFreeCell(GridCellContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if ((container.getCell() instanceof DisplayEdit) || container.getCell() == null) {
            return;
        }
        getServiceProvider().getColumn(container.getColumnIndex()).getGridColumnModel().getViewProvider().storeAsFree(container.getCell());
    }

    protected GridCellContainer createCellContainer(Context context, int columnIndex, ServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        GridCellContainer createCellContainer = GridCellCreatorService.createCellContainer(context, columnIndex, serviceProvider);
        Intrinsics.checkNotNullExpressionValue(createCellContainer, "createCellContainer(...)");
        return createCellContainer;
    }

    protected final GridCellContainer obtainAndAddContainer(int columnIndex) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        GridCellContainer createCellContainer = createCellContainer(context, columnIndex, getServiceProvider());
        createCellContainer.setSelected(isSelected());
        FixedStyle fixedStyle = getServiceProvider().getColumn(columnIndex).getGridColumnModel().getFixedStyle();
        Intrinsics.checkNotNull(fixedStyle);
        addViewInLayout(createCellContainer, getCellInsertPosition(fixedStyle), getContainerLayoutParams(), true);
        createCellContainer.setOnTouchListener(getTouchListener(columnIndex));
        return createCellContainer;
    }
}
