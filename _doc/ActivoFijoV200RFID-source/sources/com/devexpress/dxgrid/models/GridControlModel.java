package com.devexpress.dxgrid.models;

import android.graphics.Rect;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.appearance.CellAppearance;
import com.devexpress.dxgrid.models.appearance.CellAppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.ColumnHeaderViewProvider;
import com.devexpress.dxgrid.providers.DataProvider;
import com.devexpress.dxgrid.providers.DragPreviewTemplateProvider;
import com.devexpress.dxgrid.providers.GroupRowValueViewProvider;
import com.devexpress.dxgrid.providers.GroupRowViewProvider;
import com.devexpress.dxgrid.providers.TotalSummaryViewProvider;
import com.devexpress.dxgrid.utils.ObjectLambda;

/* loaded from: classes.dex */
public class GridControlModel implements DataProvider, GroupHeaderAppearanceProvider {
    private boolean allowEndFullSwipe;
    private boolean allowStartFullSwipe;
    private int borderColor;
    private Rect borderThickness;
    private GridLength[] columnDefinitions;
    private ColumnHeaderViewProvider columnHeaderViewProvider;
    private GridColumnModel[] columns;
    private final DataProvider dataProvider;
    private DragPreviewTemplateProvider dragPreviewTemplateProvider;
    private int gridFooterHeight;
    private int gridHeaderHeight;
    private final AppearanceBase groupRowAppearance;
    private int groupRowHeight;
    private GroupRowValueViewProvider groupRowSummaryViewProvider;
    private GroupRowValueViewProvider groupRowValueViewProvider;
    private GroupRowViewProvider groupRowViewProvider;
    private boolean horizontalScrollBarVisibility;
    private int indicatorColor;
    private boolean isAdvancedLayout;
    private boolean isCascadeTreeCreationEnabled;
    private boolean isCascadeUpdateEnabled;
    private boolean isGridFooterVisible;
    private boolean isGridHeaderVisible;
    private boolean isHorizontalVirtualizationEnabled;
    private boolean isLoadMoreEnabled;
    private boolean isPullToRefreshEnabled;
    private GridLength[] rowDefinitions;
    private int rowDragPreviewShadowColor;
    private int rowHeight;
    private final SwipeButtonModel[] swipeButtons;
    private final CellAppearanceBase totalSummaryAppearance;
    private TotalSummaryViewProvider totalSummaryViewProvider;
    private boolean verticalScrollBarVisibility;

    public GridControlModel(DataProvider dataProvider, GridColumnModel[] gridColumnModelArr, SwipeButtonModel[] swipeButtonModelArr, CellAppearanceBase cellAppearanceBase, AppearanceBase appearanceBase) {
        this.rowDefinitions = new GridLength[]{new GridLength(1.0d, 0, 0, false, true)};
        this.borderThickness = new Rect(1, 1, 1, 1);
        this.borderColor = -7829368;
        this.indicatorColor = -7829368;
        this.rowDragPreviewShadowColor = -16777216;
        this.rowHeight = -1;
        this.groupRowHeight = -1;
        this.gridHeaderHeight = -1;
        this.gridFooterHeight = -1;
        this.isGridHeaderVisible = true;
        this.isGridFooterVisible = true;
        this.isPullToRefreshEnabled = false;
        this.isLoadMoreEnabled = false;
        this.isCascadeUpdateEnabled = true;
        this.isCascadeTreeCreationEnabled = false;
        this.isHorizontalVirtualizationEnabled = false;
        this.allowStartFullSwipe = false;
        this.allowEndFullSwipe = false;
        this.horizontalScrollBarVisibility = true;
        this.verticalScrollBarVisibility = true;
        this.isAdvancedLayout = false;
        this.dataProvider = dataProvider;
        this.columns = gridColumnModelArr;
        this.swipeButtons = swipeButtonModelArr;
        this.totalSummaryAppearance = cellAppearanceBase;
        this.groupRowAppearance = appearanceBase;
    }

    public GridControlModel(DataProvider dataProvider, GridColumnModel[] gridColumnModelArr, SwipeButtonModel[] swipeButtonModelArr) {
        this(dataProvider, gridColumnModelArr, swipeButtonModelArr, new CellAppearance(), new CellAppearance());
    }

    public GridControlModel(DataProvider dataProvider, GridColumnModel[] gridColumnModelArr) {
        this(dataProvider, gridColumnModelArr, new SwipeButtonModel[0]);
    }

    public GridColumnModel[] getGridColumns() {
        return this.columns;
    }

    public void setGridColumns(GridColumnModel[] gridColumnModelArr) {
        this.columns = gridColumnModelArr;
    }

    public SwipeButtonModel[] getSwipeButtons() {
        return this.swipeButtons;
    }

    public CellAppearanceBase getTotalSummaryAppearance() {
        return this.totalSummaryAppearance;
    }

    public AppearanceBase getGroupRowAppearance() {
        return this.groupRowAppearance;
    }

    public Rect getBorderThickness() {
        return this.borderThickness;
    }

    public void setBorderThickness(Rect rect) {
        this.borderThickness = rect;
    }

    public boolean getHorizontalScrollBarVisibility() {
        return this.horizontalScrollBarVisibility;
    }

    public void setHorizontalScrollBarVisibility(boolean z) {
        this.horizontalScrollBarVisibility = z;
    }

    public boolean getVerticalScrollBarVisibility() {
        return this.verticalScrollBarVisibility;
    }

    public void setVerticalScrollBarVisibility(boolean z) {
        this.verticalScrollBarVisibility = z;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
    }

    public void setIndicatorColor(int i) {
        this.indicatorColor = i;
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public int getRowHeight() {
        return this.rowHeight;
    }

    public void setRowHeight(int i) {
        this.rowHeight = i;
    }

    public boolean getFixedRowHeight() {
        return this.rowHeight > 0;
    }

    public int getGroupRowHeight() {
        return this.groupRowHeight;
    }

    public void setGroupRowHeight(int i) {
        this.groupRowHeight = i;
    }

    public boolean getFixedGroupRowHeight() {
        return this.groupRowHeight > 0;
    }

    public boolean getIsGridHeaderVisible() {
        return this.isGridHeaderVisible;
    }

    public void setIsGridHeaderVisible(boolean z) {
        this.isGridHeaderVisible = z;
    }

    public int getGridHeaderHeight() {
        return this.gridHeaderHeight;
    }

    public void setGridHeaderHeight(int i) {
        this.gridHeaderHeight = i;
    }

    public boolean getIsGridFooterVisible() {
        return this.isGridFooterVisible;
    }

    public void setIsGridFooterVisible(boolean z) {
        this.isGridFooterVisible = z;
    }

    public int getGridFooterHeight() {
        return this.gridFooterHeight;
    }

    public void setGridFooterHeight(int i) {
        this.gridFooterHeight = i;
    }

    public boolean getIsPullToRefreshEnabled() {
        return this.isPullToRefreshEnabled;
    }

    public void setIsPullToRefreshEnabled(boolean z) {
        this.isPullToRefreshEnabled = z;
    }

    public boolean getIsLoadMoreEnabled() {
        return this.isLoadMoreEnabled;
    }

    public void setIsLoadMoreEnabled(boolean z) {
        this.isLoadMoreEnabled = z;
    }

    public boolean getIsCascadeUpdateEnabled() {
        return this.isCascadeUpdateEnabled;
    }

    public void setIsCascadeUpdateEnabled(boolean z) {
        this.isCascadeUpdateEnabled = z;
    }

    public boolean getIsCascadeTreeCreationEnabled() {
        return this.isCascadeTreeCreationEnabled;
    }

    public void setIsCascadeTreeCreationEnabled(boolean z) {
        this.isCascadeTreeCreationEnabled = z;
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public Object getValue(String str, int i) {
        return this.dataProvider.getValue(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public void getValueAsync(String str, int i, ObjectLambda objectLambda) {
        this.dataProvider.getValueAsync(str, i, objectLambda);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getDisplayText(String str, int i) {
        return this.dataProvider.getDisplayText(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getDisplayText(Object obj, String str, int i) {
        return this.dataProvider.getDisplayText(obj, str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public int getRowCount() {
        return this.dataProvider.getRowCount();
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public GroupInfo getGroupInfo(int i) {
        return this.dataProvider.getGroupInfo(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public boolean isGroupRow(int i) {
        return this.dataProvider.isGroupRow(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public boolean isSelected(int i) {
        return this.dataProvider.isSelected(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getTotalSummary(int i) {
        return this.dataProvider.getTotalSummary(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String setCellValue(String str, int i, Object obj) {
        return this.dataProvider.setCellValue(str, i, obj);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getCellErrorText(String str, int i) {
        return this.dataProvider.getCellErrorText(str, i);
    }

    public boolean getAllowStartFullSwipe() {
        return this.allowStartFullSwipe;
    }

    public void setAllowStartFullSwipe(boolean z) {
        this.allowStartFullSwipe = z;
    }

    public boolean getAllowEndFullSwipe() {
        return this.allowEndFullSwipe;
    }

    public void setAllowEndFullSwipe(boolean z) {
        this.allowEndFullSwipe = z;
    }

    public ColumnHeaderViewProvider getColumnHeaderViewProvider() {
        return this.columnHeaderViewProvider;
    }

    public void setColumnHeaderViewProvider(ColumnHeaderViewProvider columnHeaderViewProvider) {
        this.columnHeaderViewProvider = columnHeaderViewProvider;
    }

    public GroupRowViewProvider getGroupRowViewProvider() {
        return this.groupRowViewProvider;
    }

    public void setGroupRowViewProvider(GroupRowViewProvider groupRowViewProvider) {
        this.groupRowViewProvider = groupRowViewProvider;
    }

    public TotalSummaryViewProvider getTotalSummaryViewProvider() {
        return this.totalSummaryViewProvider;
    }

    public void setTotalSummaryViewProvider(TotalSummaryViewProvider totalSummaryViewProvider) {
        this.totalSummaryViewProvider = totalSummaryViewProvider;
    }

    public GroupRowValueViewProvider getGroupRowValueViewProvider() {
        return this.groupRowValueViewProvider;
    }

    public void setGroupRowValueViewProvider(GroupRowValueViewProvider groupRowValueViewProvider) {
        this.groupRowValueViewProvider = groupRowValueViewProvider;
    }

    @Override // com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider
    public GridCellContainerAppearance getGroupHeaderAppearance() {
        return this.groupRowAppearance;
    }

    @Override // com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider
    public GridTextAppearance getGroupHeaderTextAppearance() {
        return this.groupRowAppearance;
    }

    public GroupRowValueViewProvider getGroupRowSummaryViewProvider() {
        return this.groupRowSummaryViewProvider;
    }

    public void setGroupRowSummaryViewProvider(GroupRowValueViewProvider groupRowValueViewProvider) {
        this.groupRowSummaryViewProvider = groupRowValueViewProvider;
    }

    public DragPreviewTemplateProvider getDragPreviewTemplateProvider() {
        return this.dragPreviewTemplateProvider;
    }

    public void setDragPreviewTemplateProvider(DragPreviewTemplateProvider dragPreviewTemplateProvider) {
        this.dragPreviewTemplateProvider = dragPreviewTemplateProvider;
    }

    public int getRowDragPreviewShadowColor() {
        return this.rowDragPreviewShadowColor;
    }

    public void setRowDragPreviewShadowColor(int i) {
        this.rowDragPreviewShadowColor = i;
    }

    public GridLength[] getColumnDefinitions() {
        return this.columnDefinitions;
    }

    public void setColumnDefinitions(GridLength[] gridLengthArr) {
        this.columnDefinitions = gridLengthArr;
        this.isAdvancedLayout = gridLengthArr != null && gridLengthArr.length > 0;
    }

    public GridLength[] getRowDefinitions() {
        return this.rowDefinitions;
    }

    public void setRowDefinitions(GridLength[] gridLengthArr) {
        this.rowDefinitions = gridLengthArr;
    }

    public boolean getIsHorizontalVirtualizationEnabled() {
        return this.isHorizontalVirtualizationEnabled;
    }

    public void setIsHorizontalVirtualizationEnabled(boolean z) {
        this.isHorizontalVirtualizationEnabled = z;
    }

    public boolean getIsAdvancedLayout() {
        return this.isAdvancedLayout;
    }
}
