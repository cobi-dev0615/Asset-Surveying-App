package com.devexpress.dxgrid.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.devexpress.dxgrid.R;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.utils.OnSwipeOffsetChangeListener;
import com.devexpress.dxgrid.utils.SwipeActionsContainerCache;
import com.devexpress.dxgrid.utils.providers.LayoutProvider;
import com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider;
import com.devexpress.editors.DisplayEdit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridFilterView.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001aH\u0016J0\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0014J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0018H\u0014J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0018J\u0006\u00102\u001a\u00020\u001aJ\b\u00103\u001a\u00020\u001aH\u0016J\u0010\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u000206H\u0014R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/devexpress/dxgrid/views/GridFilterView;", "Lcom/devexpress/dxgrid/views/GridRowView;", "context", "Landroid/content/Context;", "viewPortWidthProvider", "Lcom/devexpress/dxgrid/utils/providers/ViewPortWidthProvider;", "gridAction", "Lcom/devexpress/dxgrid/providers/GridAction;", "swipeCache", "Lcom/devexpress/dxgrid/utils/SwipeActionsContainerCache;", "onSwipeOffsetChangeListener", "Lcom/devexpress/dxgrid/utils/OnSwipeOffsetChangeListener;", "layoutProvider", "Lcom/devexpress/dxgrid/utils/providers/LayoutProvider;", "(Landroid/content/Context;Lcom/devexpress/dxgrid/utils/providers/ViewPortWidthProvider;Lcom/devexpress/dxgrid/providers/GridAction;Lcom/devexpress/dxgrid/utils/SwipeActionsContainerCache;Lcom/devexpress/dxgrid/utils/OnSwipeOffsetChangeListener;Lcom/devexpress/dxgrid/utils/providers/LayoutProvider;)V", "filterIcon", "Landroid/graphics/drawable/Drawable;", "isFixedHeight", "", "()Z", "isShowFilterIcon", "setShowFilterIcon", "(Z)V", "lastHeight", "", "addFilterIcon", "", "view", "Landroid/view/View;", "getActualIsShowFilterIcon", "columnIndex", "getDefaultHeight", "getFixedHeight", "getIsReady", "getRowIndex", "isContainsFilterIcon", "Lcom/devexpress/editors/DisplayEdit;", "layoutChildren", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeFilterIcon", "setFilterIconColor", TypedValues.Custom.S_COLOR, "update", "updateAppearance", "updateContent", "container", "Lcom/devexpress/dxgrid/views/GridCellContainer;", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GridFilterView extends GridRowView {
    public static final int FILTER_ROW_HANDLE = -2147483647;
    private final Drawable filterIcon;
    private boolean isShowFilterIcon;
    private int lastHeight;

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public boolean getIsReady() {
        return true;
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public int getRowIndex() {
        return FILTER_ROW_HANDLE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridFilterView(Context context, ViewPortWidthProvider viewPortWidthProvider, GridAction gridAction, SwipeActionsContainerCache swipeActionsContainerCache, OnSwipeOffsetChangeListener onSwipeOffsetChangeListener, LayoutProvider layoutProvider) {
        super(context, viewPortWidthProvider, gridAction, swipeActionsContainerCache, onSwipeOffsetChangeListener, layoutProvider);
        Intrinsics.checkNotNullParameter(viewPortWidthProvider, "viewPortWidthProvider");
        Intrinsics.checkNotNullParameter(gridAction, "gridAction");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        this.filterIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.dxg_filter, null);
    }

    /* renamed from: isShowFilterIcon, reason: from getter */
    public final boolean getIsShowFilterIcon() {
        return this.isShowFilterIcon;
    }

    public final void setShowFilterIcon(boolean z) {
        this.isShowFilterIcon = z;
    }

    public final void setFilterIconColor(int color) {
        Drawable drawable = this.filterIcon;
        Intrinsics.checkNotNull(drawable);
        DrawableCompat.setTint(drawable, color);
        invalidate();
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getServiceProvider().isAutoFilterPanelVisible()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            this.lastHeight = getMeasuredHeight();
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), 0);
        }
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getServiceProvider().isAutoFilterPanelVisible()) {
            super.onLayout(changed, l, t, r, b);
        }
    }

    @Override // com.devexpress.dxgrid.views.GridRowView, com.devexpress.dxgrid.views.GridViewBase
    public void layoutChildren() {
        if (getServiceProvider().isAutoFilterPanelVisible()) {
            super.layoutChildren();
        }
    }

    @Override // com.devexpress.dxgrid.views.GridRowView, com.devexpress.dxgrid.views.GridRowViewBase, com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public boolean isFixedHeight() {
        return getServiceProvider().getFilterRowHeight() >= 0;
    }

    @Override // com.devexpress.dxgrid.views.GridRowView, com.devexpress.dxgrid.views.GridRowViewBase, com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public int getFixedHeight() {
        return getServiceProvider().getFilterRowHeight();
    }

    @Override // com.devexpress.dxgrid.views.GridRowView, com.devexpress.dxgrid.views.GridRowViewBase
    public void updateAppearance() {
        if (getServiceProvider().isAutoFilterPanelVisible()) {
            super.updateAppearance();
        }
    }

    @Override // com.devexpress.dxgrid.views.GridRowView
    protected void updateContent(GridCellContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        super.updateContent(container);
        if (!getActualIsShowFilterIcon(container.getColumnIndex())) {
            View cell = container.getCell();
            Intrinsics.checkNotNullExpressionValue(cell, "getCell(...)");
            removeFilterIcon(cell);
            return;
        }
        View cell2 = container.getCell();
        if (cell2 == null || !(cell2 instanceof DisplayEdit)) {
            return;
        }
        CharSequence text = ((DisplayEdit) cell2).getText();
        if (text == null || text.length() == 0) {
            addFilterIcon(cell2);
        } else {
            removeFilterIcon(cell2);
        }
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase, com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public int getDefaultHeight() {
        if (isFixedHeight()) {
            return getFixedHeight();
        }
        int i = this.lastHeight;
        if (i > 0) {
            return i;
        }
        return 150;
    }

    public final void update() {
        if (getServiceProvider().isAutoFilterPanelVisible()) {
            super.update(getRowIndex());
        } else {
            requestLayout();
        }
    }

    private final boolean getActualIsShowFilterIcon(int columnIndex) {
        Boolean isShowFilterIcon = getServiceProvider().getColumn(columnIndex).getGridColumnModel().isShowFilterIcon();
        return isShowFilterIcon == null ? this.isShowFilterIcon : isShowFilterIcon.booleanValue();
    }

    private final void removeFilterIcon(View view) {
        if (view instanceof DisplayEdit) {
            DisplayEdit displayEdit = (DisplayEdit) view;
            if (isContainsFilterIcon(displayEdit)) {
                Drawable drawable = this.filterIcon;
                Intrinsics.checkNotNull(drawable);
                displayEdit.removeStartDrawable(drawable);
            }
        }
    }

    private final void addFilterIcon(View view) {
        if (view instanceof DisplayEdit) {
            DisplayEdit displayEdit = (DisplayEdit) view;
            if (isContainsFilterIcon(displayEdit)) {
                return;
            }
            Drawable drawable = this.filterIcon;
            Intrinsics.checkNotNull(drawable);
            displayEdit.addStartDrawable(drawable);
        }
    }

    private final boolean isContainsFilterIcon(DisplayEdit view) {
        if (view.getStartDrawables() == null) {
            return false;
        }
        List<Drawable> startDrawables = view.getStartDrawables();
        Intrinsics.checkNotNull(startDrawables);
        return CollectionsKt.contains(startDrawables, this.filterIcon);
    }
}
