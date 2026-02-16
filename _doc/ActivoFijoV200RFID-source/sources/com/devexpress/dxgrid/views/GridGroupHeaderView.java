package com.devexpress.dxgrid.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider;
import com.devexpress.dxgrid.models.ContentAlignment;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.providers.GroupRowViewProviderBase;
import com.devexpress.dxgrid.utils.FixedColumnSeparatorStyle;
import com.devexpress.dxgrid.utils.GridContainerViewInfo;
import com.devexpress.dxgrid.utils.providers.GroupRowHeightProvider;
import com.devexpress.dxgrid.utils.providers.LayoutProvider;
import com.devexpress.dxgrid.utils.providers.OffsetProvider;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.dxgrid.utils.providers.ViewPortWidthProvider;

/* loaded from: classes2.dex */
public class GridGroupHeaderView extends GridRowViewBase {
    private GroupHeaderAppearanceProvider appearanceProvider;
    private GridAction gridAction;
    private GridCellContainer gridCellContainer;
    private final GroupRowHeightProvider groupRowHeightProvider;
    private GroupRowViewProviderBase groupRowViewProvider;
    private ViewGroup.LayoutParams layoutParams;
    private GroupHeaderOnTouchListener touchListener;
    private final ViewPortWidthProvider viewPortWidthProvider;

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected View.OnTouchListener getTouchListener(int i) {
        return null;
    }

    public GridGroupHeaderView(Context context, LayoutProvider layoutProvider, GroupHeaderAppearanceProvider groupHeaderAppearanceProvider, GroupRowHeightProvider groupRowHeightProvider, ViewPortWidthProvider viewPortWidthProvider, GroupRowViewProviderBase groupRowViewProviderBase, GridAction gridAction) {
        super(context, layoutProvider);
        this.groupRowHeightProvider = groupRowHeightProvider;
        this.groupRowViewProvider = groupRowViewProviderBase;
        this.appearanceProvider = groupHeaderAppearanceProvider;
        this.viewPortWidthProvider = viewPortWidthProvider;
        this.gridAction = gridAction;
        this.layoutParams = new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    public void initialize(OffsetProvider offsetProvider, ServiceProvider serviceProvider) {
        super.initialize(offsetProvider, serviceProvider);
        initView();
    }

    private void initView() {
        GridCellContainer gridCellContainer = new GridCellContainer(getContext(), this.appearanceProvider.getGroupHeaderAppearance(), new GridContainerViewInfo(FixedColumnSeparatorStyle.None, false, false, false, true, true), 0);
        this.gridCellContainer = gridCellContainer;
        gridCellContainer.setVerticalAlignment(ContentAlignment.Center);
        addView(this.gridCellContainer, -1, new LinearLayout.LayoutParams(-1, -2));
        GroupHeaderOnTouchListener groupHeaderOnTouchListener = new GroupHeaderOnTouchListener(getContext(), this.gridAction);
        this.touchListener = groupHeaderOnTouchListener;
        this.gridCellContainer.setOnTouchListener(groupHeaderOnTouchListener);
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    public void layoutChildren() {
        this.gridCellContainer.layout(getOffset(), 0, getOffset() + this.gridCellContainer.getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public void updateContent() {
        View cell = this.gridCellContainer.getCell();
        if (cell == null) {
            cell = this.groupRowViewProvider.getView(getContext(), getRowIndex());
            this.gridCellContainer.addView(cell, this.layoutParams);
        } else {
            this.groupRowViewProvider.updateView(getContext(), cell, getRowIndex());
        }
        this.gridCellContainer.setAppearance(this.appearanceProvider.getGroupHeaderAppearance());
        cell.requestLayout();
        showAll();
    }

    @Override // com.devexpress.dxgrid.views.GridRowViewBase
    public void update(int i) {
        super.update(i);
        this.touchListener.setRowIndex(i);
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultHeight;
        int makeMeasureSpec;
        if (this.gridCellContainer.getCell() != null) {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.viewPortWidthProvider.getViewPortWidth()), BasicMeasure.EXACTLY);
            if (this.groupRowHeightProvider.getFixedGroupRowHeight()) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.groupRowHeightProvider.getGroupRowHeight(), Integer.MIN_VALUE);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            this.gridCellContainer.measure(makeMeasureSpec2, makeMeasureSpec);
            if (this.groupRowHeightProvider.getFixedGroupRowHeight()) {
                defaultHeight = this.groupRowHeightProvider.getGroupRowHeight();
            } else {
                defaultHeight = this.gridCellContainer.getMeasuredHeight();
            }
        } else {
            defaultHeight = getDefaultHeight();
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), defaultHeight);
    }
}
