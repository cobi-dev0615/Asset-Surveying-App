package com.devexpress.dxgrid.utils.providers;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.appearance.GroupRowCellContainerAppearance;
import com.devexpress.dxgrid.appearance.TemplateCellContainerAppearance;
import com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider;
import com.devexpress.dxgrid.appearance.visitors.GridCellContainerAppearanceVisitor;
import com.devexpress.dxgrid.appearance.visitors.GridTextAppearanceVisitor;
import com.devexpress.dxgrid.interfaces.CellContainerCreator;
import com.devexpress.dxgrid.layout.RunnablesQueue;
import com.devexpress.dxgrid.models.FixedStyle;
import com.devexpress.dxgrid.models.GridControlModel;
import com.devexpress.dxgrid.models.GroupInfo;
import com.devexpress.dxgrid.models.SwipeButtonModel;
import com.devexpress.dxgrid.models.appearance.CellAppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.ColumnHeaderViewProvider;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.providers.GroupRowValueViewProvider;
import com.devexpress.dxgrid.providers.GroupRowValueViewProviderBase;
import com.devexpress.dxgrid.providers.GroupRowViewProvider;
import com.devexpress.dxgrid.providers.TotalSummaryViewProvider;
import com.devexpress.dxgrid.providers.TotalSummaryViewProviderBase;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.ColumnInfoHelper;
import com.devexpress.dxgrid.utils.InplaceEditingService;
import com.devexpress.dxgrid.utils.ObjectLambda;
import com.devexpress.dxgrid.utils.TotalSummaryViewProviderNative;
import com.devexpress.dxgrid.views.GridCellContainer;
import com.devexpress.dxgrid.views.GridContainerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class ServiceProvider implements com.devexpress.dxgrid.providers.ServiceProvider {
    private ColumnHeaderViewProviderNative columnHeaderViewProvider;
    private GridContainerView gridContainerView;
    private GridControlModel gridControlModel;
    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase groupRowViewProviderValueNative_SummaryTemplate;
    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase groupRowViewProviderValueTemplate_SummaryNative;
    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase groupRowViewProviderValueTemplate_SummaryTemplate;
    private SwipeButtonModel[] leftSwipeButtons;
    private GroupRowSummaryViewProviderNative nativeGroupRowSummaryViewProvider;
    private GroupRowValueViewProviderNative nativeGroupRowValueViewProvider;
    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase nativeGroupRowViewProvider;
    private SwipeButtonModel[] rightSwipeButtons;
    private TotalSummaryViewProviderNative totalSummaryViewProvider;
    private final ColumnInfoHelper columnInfoHelper = new ColumnInfoHelper();
    private final InplaceEditingService inplaceEditingService = new InplaceEditingService(this);
    private final Map<GridColumnModel, GridCellContainerAppearanceVisitor> appearanceVisitors = new HashMap();
    private final Map<GridColumnModel, GridTextAppearanceVisitor> gridTextAppearanceVisitors = new HashMap();
    private GroupRowCellContainerAppearance groupHeaderTemplateAppearance = new GroupRowCellContainerAppearance();
    private TemplateCellContainerAppearance totalSummaryTemplateAppearance = new TemplateCellContainerAppearance();

    public ServiceProvider(GridContainerView gridContainerView) {
        this.gridContainerView = gridContainerView;
    }

    public void setGridDataModel(GridControlModel gridControlModel, GridAction gridAction) {
        this.gridControlModel = gridControlModel;
        this.columnInfoHelper.setGridControlModel(gridControlModel);
        this.inplaceEditingService.setGridAction(gridAction);
        this.appearanceVisitors.clear();
        this.gridTextAppearanceVisitors.clear();
        updateSwipeButtons(gridControlModel.getSwipeButtons());
    }

    @Override // com.devexpress.dxgrid.utils.providers.ColumnsProvider
    public int getColumnCount() {
        return this.columnInfoHelper.getColumnCount();
    }

    @Override // com.devexpress.dxgrid.utils.providers.ColumnsProvider
    public Pair<Integer, Integer>[] getHeights(int[] iArr, ItemHeightProvider itemHeightProvider) {
        return this.columnInfoHelper.getHeights(iArr, itemHeightProvider);
    }

    @Override // com.devexpress.dxgrid.utils.providers.ColumnsProvider
    public ColumnInfo getColumn(int i) {
        return this.columnInfoHelper.getColumn(i);
    }

    @Override // com.devexpress.dxgrid.utils.providers.RowHeightProvider
    public boolean getFixedRowHeight() {
        return this.gridControlModel.getFixedRowHeight();
    }

    @Override // com.devexpress.dxgrid.utils.providers.RowHeightProvider
    public int getRowHeight() {
        return this.gridControlModel.getRowHeight();
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public Object getValue(String str, int i) {
        return this.gridControlModel.getValue(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public void getValueAsync(String str, int i, ObjectLambda objectLambda) {
        this.gridControlModel.getValueAsync(str, i, objectLambda);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getDisplayText(String str, int i) {
        return this.gridControlModel.getDisplayText(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getDisplayText(Object obj, String str, int i) {
        return this.gridControlModel.getDisplayText(obj, str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getCellErrorText(String str, int i) {
        return this.gridControlModel.getCellErrorText(str, i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public int getRowCount() {
        return this.gridControlModel.getRowCount();
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public GroupInfo getGroupInfo(int i) {
        return this.gridControlModel.getGroupInfo(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public boolean isGroupRow(int i) {
        return this.gridControlModel.isGroupRow(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public boolean isSelected(int i) {
        return this.gridControlModel.isSelected(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String getTotalSummary(int i) {
        return this.gridControlModel.getTotalSummary(i);
    }

    @Override // com.devexpress.dxgrid.providers.DataProvider
    public String setCellValue(String str, int i, Object obj) {
        return this.gridControlModel.setCellValue(str, i, obj);
    }

    @Override // com.devexpress.dxgrid.utils.providers.CellAppearanceProvider
    public GridCellContainerAppearance getCellAppearance(GridColumnModel gridColumnModel) {
        GridCellContainerAppearanceVisitor gridCellContainerAppearanceVisitor;
        if (!this.appearanceVisitors.containsKey(gridColumnModel)) {
            gridCellContainerAppearanceVisitor = new GridCellContainerAppearanceVisitor();
            this.appearanceVisitors.put(gridColumnModel, gridCellContainerAppearanceVisitor);
        } else {
            gridCellContainerAppearanceVisitor = this.appearanceVisitors.get(gridColumnModel);
        }
        gridCellContainerAppearanceVisitor.setAppearanceBase(gridColumnModel.getCellAppearance());
        gridColumnModel.accept(gridCellContainerAppearanceVisitor);
        return gridCellContainerAppearanceVisitor.getAppearance();
    }

    @Override // com.devexpress.dxgrid.utils.providers.CellAppearanceProvider
    public GridTextAppearance getCellTextAppearance(GridColumnModel gridColumnModel) {
        GridTextAppearanceVisitor gridTextAppearanceVisitor;
        if (!this.gridTextAppearanceVisitors.containsKey(gridColumnModel)) {
            gridTextAppearanceVisitor = new GridTextAppearanceVisitor();
            this.gridTextAppearanceVisitors.put(gridColumnModel, gridTextAppearanceVisitor);
        } else {
            gridTextAppearanceVisitor = this.gridTextAppearanceVisitors.get(gridColumnModel);
        }
        gridTextAppearanceVisitor.setTextAppearance(gridColumnModel.getCellAppearance());
        gridColumnModel.accept(gridTextAppearanceVisitor);
        return gridTextAppearanceVisitor.getTextAppearance();
    }

    @Override // com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider
    public GridCellContainerAppearance getGroupHeaderAppearance() {
        this.groupHeaderTemplateAppearance.setCellAppearance(this.gridControlModel.getGroupRowAppearance());
        return this.groupHeaderTemplateAppearance;
    }

    @Override // com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider
    public GridTextAppearance getGroupHeaderTextAppearance() {
        return this.gridControlModel.getGroupRowAppearance();
    }

    @Override // com.devexpress.dxgrid.appearance.providers.TotalSummaryAppearanceProvider
    public GridCellContainerAppearance getSummaryAppearance(Context context, int i) {
        CellAppearanceBase totalSummaryAppearance = this.gridControlModel.getTotalSummaryAppearance();
        TotalSummaryViewProvider totalSummaryViewProvider = this.gridControlModel.getTotalSummaryViewProvider();
        if ((totalSummaryViewProvider == null || !totalSummaryViewProvider.canGet(i)) && getTotalSummary(i) != null) {
            return totalSummaryAppearance;
        }
        this.totalSummaryTemplateAppearance.setCellAppearance(totalSummaryAppearance);
        return this.totalSummaryTemplateAppearance;
    }

    @Override // com.devexpress.dxgrid.appearance.providers.TotalSummaryAppearanceProvider
    public GridTextAppearance getSummaryTextAppearance(GridColumnModel gridColumnModel) {
        GridTextAppearanceVisitor gridTextAppearanceVisitor;
        if (!this.gridTextAppearanceVisitors.containsKey(gridColumnModel)) {
            gridTextAppearanceVisitor = new GridTextAppearanceVisitor();
            this.gridTextAppearanceVisitors.put(gridColumnModel, gridTextAppearanceVisitor);
        } else {
            gridTextAppearanceVisitor = this.gridTextAppearanceVisitors.get(gridColumnModel);
        }
        gridTextAppearanceVisitor.setTextAppearance(this.gridControlModel.getTotalSummaryAppearance());
        gridColumnModel.accept(gridTextAppearanceVisitor);
        return gridTextAppearanceVisitor.getTextAppearance();
    }

    public void setViewPortWidth(int i) {
        this.columnInfoHelper.setViewPortWidth(i);
    }

    public int getAbsoluteWidth() {
        return this.columnInfoHelper.getAbsoluteWidth();
    }

    @Override // com.devexpress.dxgrid.utils.providers.GridFooterHeightProvider
    public boolean getFixedFooterHeight() {
        return !this.gridControlModel.getIsGridFooterVisible() || this.gridControlModel.getGridFooterHeight() >= 0;
    }

    @Override // com.devexpress.dxgrid.utils.providers.GridFooterHeightProvider
    public int getFooterHeight() {
        if (this.gridControlModel.getIsGridFooterVisible()) {
            return this.gridControlModel.getGridFooterHeight();
        }
        return 0;
    }

    @Override // com.devexpress.dxgrid.utils.providers.GridHeaderHeightProvider
    public boolean getFixedHeaderHeight() {
        return !this.gridControlModel.getIsGridHeaderVisible() || this.gridControlModel.getGridHeaderHeight() >= 0;
    }

    @Override // com.devexpress.dxgrid.utils.providers.GridHeaderHeightProvider
    public int getHeaderHeight() {
        if (this.gridControlModel.getIsGridHeaderVisible()) {
            return this.gridControlModel.getGridHeaderHeight();
        }
        return 0;
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public boolean startInplaceEditing(Context context, Runnable runnable, CellContainerCreator cellContainerCreator, int i, int i2) {
        return this.inplaceEditingService.startInplaceEditing(context, runnable, cellContainerCreator, i, i2);
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public boolean finishInplaceEditing(boolean z) {
        return this.inplaceEditingService.finishInplaceEditing(z);
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public int getInplaceEditingColumnIndex() {
        return this.inplaceEditingService.getInplaceEditingColumnIndex();
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public int getInplaceEditingRowIndex() {
        return this.inplaceEditingService.getInplaceEditingRowIndex();
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public GridCellContainer getInplaceEditorContainer() {
        return this.inplaceEditingService.getInplaceEditorContainer();
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public void tap(int i, int i2, float f, float f2) {
        this.inplaceEditingService.tap(i, i2, f, f2);
    }

    public void updateSwipeButtons(SwipeButtonModel[] swipeButtonModelArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SwipeButtonModel swipeButtonModel : swipeButtonModelArr) {
            if (swipeButtonModel.getLocation() == SwipeButtonModel.Location.Start) {
                arrayList.add(swipeButtonModel);
            } else {
                arrayList2.add(0, swipeButtonModel);
            }
        }
        this.leftSwipeButtons = (SwipeButtonModel[]) arrayList.toArray(new SwipeButtonModel[0]);
        this.rightSwipeButtons = (SwipeButtonModel[]) arrayList2.toArray(new SwipeButtonModel[0]);
    }

    @Override // com.devexpress.dxgrid.utils.providers.SwipeProvider
    public boolean getSwipeEnabled() {
        SwipeButtonModel[] swipeButtons = this.gridControlModel.getSwipeButtons();
        return swipeButtons != null && swipeButtons.length > 0;
    }

    @Override // com.devexpress.dxgrid.utils.providers.SwipeProvider
    public boolean getAllowStartFullSwipe() {
        return this.gridControlModel.getAllowStartFullSwipe();
    }

    @Override // com.devexpress.dxgrid.utils.providers.SwipeProvider
    public boolean getAllowEndFullSwipe() {
        return this.gridControlModel.getAllowEndFullSwipe();
    }

    @Override // com.devexpress.dxgrid.utils.providers.SwipeProvider
    public SwipeButtonModel[] getLeftSwipeButtons() {
        return this.leftSwipeButtons;
    }

    @Override // com.devexpress.dxgrid.utils.providers.SwipeProvider
    public SwipeButtonModel[] getRightSwipeButtons() {
        return this.rightSwipeButtons;
    }

    @Override // com.devexpress.dxgrid.appearance.providers.IndicatorAppearanceProvider
    public int getIndicatorColor() {
        return this.gridControlModel.getIndicatorColor();
    }

    private GroupRowValueViewProviderBase getNativeGroupRowValueViewProvider() {
        if (this.nativeGroupRowValueViewProvider == null) {
            this.nativeGroupRowValueViewProvider = new GroupRowValueViewProviderNative(this, this);
        }
        return this.nativeGroupRowValueViewProvider;
    }

    private GroupRowValueViewProviderBase getNativeGroupRowSummaryViewProvider() {
        if (this.nativeGroupRowSummaryViewProvider == null) {
            this.nativeGroupRowSummaryViewProvider = new GroupRowSummaryViewProviderNative(this, this);
        }
        return this.nativeGroupRowSummaryViewProvider;
    }

    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase getGroupRowValueTemplate_SummaryNativeProvider() {
        if (this.groupRowViewProviderValueTemplate_SummaryNative == null) {
            this.groupRowViewProviderValueTemplate_SummaryNative = new GroupRowViewProviderBase(this.gridControlModel.getGroupRowValueViewProvider(), getNativeGroupRowSummaryViewProvider(), this);
        }
        return this.groupRowViewProviderValueTemplate_SummaryNative;
    }

    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase getGroupRowValueTemplate_SummaryTemplateProvider() {
        if (this.groupRowViewProviderValueTemplate_SummaryTemplate == null) {
            this.groupRowViewProviderValueTemplate_SummaryTemplate = new GroupRowViewProviderBase(this.gridControlModel.getGroupRowValueViewProvider(), this.gridControlModel.getGroupRowSummaryViewProvider(), this);
        }
        return this.groupRowViewProviderValueTemplate_SummaryTemplate;
    }

    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase getGroupRowValueNative_SummaryTemplateProvider() {
        if (this.groupRowViewProviderValueNative_SummaryTemplate == null) {
            this.groupRowViewProviderValueNative_SummaryTemplate = new GroupRowViewProviderBase(getNativeGroupRowValueViewProvider(), this.gridControlModel.getGroupRowSummaryViewProvider(), this);
        }
        return this.groupRowViewProviderValueNative_SummaryTemplate;
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public GroupHeaderAppearanceProvider getNativeGroupHeaderAppearanceProvider() {
        return this.gridControlModel;
    }

    @Override // com.devexpress.dxgrid.utils.providers.CellAppearanceProvider
    public boolean isUpdateShouldRequestCustomCellStyle() {
        return this.gridContainerView.isUpdateShouldRequestCustomCellStyle();
    }

    @Override // com.devexpress.dxgrid.utils.providers.ColumnsProvider
    public int getRowsDefinitionsCount() {
        return this.gridControlModel.getRowDefinitions().length;
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public boolean getIsRefreshing() {
        return this.gridContainerView.isRefreshing();
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public boolean isColumnInScreen(ColumnInfo columnInfo) {
        if (this.gridContainerView.getHorizontalVirtualizationEnabled() && columnInfo.getGridColumnModel().getFixedStyle() == FixedStyle.None && !this.gridControlModel.getIsAdvancedLayout()) {
            return columnInfo.getRight() > getLeft() && columnInfo.getLeft() < getRight();
        }
        return true;
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public int getLeft() {
        return this.gridContainerView.getOffsetX() + this.columnInfoHelper.getFixedStartColumnsWidth();
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public int getRight() {
        return this.gridContainerView.getOffsetX() + (this.gridContainerView.getViewPortWidth() - this.columnInfoHelper.getFixedEndColumnsWidth());
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public RunnablesQueue getRunnablesQueue() {
        return this.gridContainerView.getRunnablesQueue();
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public com.devexpress.dxgrid.providers.GroupRowViewProviderBase getGroupRowProvider(boolean z, boolean z2, boolean z3) {
        if (z) {
            return getGroupRowTemplateProvider();
        }
        if (z2) {
            if (z3) {
                return getGroupRowValueTemplate_SummaryTemplateProvider();
            }
            return getGroupRowValueTemplate_SummaryNativeProvider();
        }
        if (z3) {
            return getGroupRowValueNative_SummaryTemplateProvider();
        }
        return getNativeGroupRowProvider();
    }

    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase getNativeGroupRowProvider() {
        if (this.nativeGroupRowViewProvider == null) {
            this.nativeGroupRowViewProvider = new GroupRowViewProviderBase(getNativeGroupRowValueViewProvider(), getNativeGroupRowSummaryViewProvider(), this);
        }
        return this.nativeGroupRowViewProvider;
    }

    private com.devexpress.dxgrid.providers.GroupRowViewProviderBase getGroupRowTemplateProvider() {
        return this.gridControlModel.getGroupRowViewProvider();
    }

    @Override // com.devexpress.dxgrid.providers.ColumnHeaderViewProvider
    public View getColumnHeaderView(Context context, int i) {
        ColumnHeaderViewProvider columnHeaderViewProvider = this.gridControlModel.getColumnHeaderViewProvider();
        View columnHeaderView = columnHeaderViewProvider != null ? columnHeaderViewProvider.getColumnHeaderView(context, i) : null;
        return columnHeaderView != null ? columnHeaderView : getColumnHeaderViewProvider().getColumnHeaderView(context, i);
    }

    private ColumnHeaderViewProvider getColumnHeaderViewProvider() {
        if (this.columnHeaderViewProvider == null) {
            this.columnHeaderViewProvider = new ColumnHeaderViewProviderNative(this);
        }
        return this.columnHeaderViewProvider;
    }

    @Override // com.devexpress.dxgrid.interfaces.GroupHeaderTemplateChecker
    public boolean hasGroupRowTemplate(int i) {
        GroupRowViewProvider groupRowViewProvider = this.gridControlModel.getGroupRowViewProvider();
        return groupRowViewProvider != null && groupRowViewProvider.canUpdate(i);
    }

    @Override // com.devexpress.dxgrid.providers.TotalSummaryViewProviderBase
    public View getTotalSummaryView(Context context, int i) {
        TotalSummaryViewProvider totalSummaryViewProvider = this.gridControlModel.getTotalSummaryViewProvider();
        if (totalSummaryViewProvider != null && totalSummaryViewProvider.canGet(i)) {
            return totalSummaryViewProvider.getTotalSummaryView(context, i);
        }
        return getTotalSummaryViewProviderNative().getTotalSummaryView(context, i);
    }

    private TotalSummaryViewProviderBase getTotalSummaryViewProviderNative() {
        if (this.totalSummaryViewProvider == null) {
            this.totalSummaryViewProvider = new TotalSummaryViewProviderNative(this, this, this);
        }
        return this.totalSummaryViewProvider;
    }

    @Override // com.devexpress.dxgrid.interfaces.GroupHeaderValueTemplateChecker
    public boolean hasGroupRowValueTemplate(int i) {
        GroupRowValueViewProvider groupRowValueViewProvider = this.gridControlModel.getGroupRowValueViewProvider();
        return groupRowValueViewProvider != null && groupRowValueViewProvider.canUpdate(i);
    }

    @Override // com.devexpress.dxgrid.interfaces.GroupHeaderSummaryTemplateChecker
    public boolean hasGroupRowSummaryTemplate(int i) {
        GroupRowValueViewProvider groupRowSummaryViewProvider = this.gridControlModel.getGroupRowSummaryViewProvider();
        return groupRowSummaryViewProvider != null && groupRowSummaryViewProvider.canUpdate(i);
    }

    @Override // com.devexpress.dxgrid.utils.providers.GroupRowHeightProvider
    public boolean getFixedGroupRowHeight() {
        return this.gridControlModel.getFixedGroupRowHeight();
    }

    @Override // com.devexpress.dxgrid.utils.providers.GroupRowHeightProvider
    public int getGroupRowHeight() {
        return this.gridControlModel.getGroupRowHeight();
    }

    @Override // com.devexpress.dxgrid.providers.DragPreviewTemplateProvider
    public View getDragPreview(Context context, int i) {
        if (this.gridControlModel.getDragPreviewTemplateProvider() != null) {
            return this.gridControlModel.getDragPreviewTemplateProvider().getDragPreview(context, i);
        }
        return null;
    }

    @Override // com.devexpress.dxgrid.providers.UpdateProvider
    public boolean isLocked() {
        return this.gridContainerView.isLocked();
    }

    @Override // com.devexpress.dxgrid.providers.UpdateProvider
    public void beginUpdate() {
        this.gridContainerView.beginUpdate();
    }

    @Override // com.devexpress.dxgrid.providers.UpdateProvider
    public void endUpdate() {
        this.gridContainerView.endUpdate();
    }

    @Override // com.devexpress.dxgrid.utils.providers.ColumnsProvider
    public int getRowWidth() {
        return this.columnInfoHelper.getRowWidth();
    }

    @Override // com.devexpress.dxgrid.providers.FilterProvider
    public boolean isAutoFilterPanelVisible() {
        return this.gridContainerView.isFilterRowVisible();
    }

    @Override // com.devexpress.dxgrid.providers.FilterProvider
    public int getFilterRowHeight() {
        return this.gridContainerView.getFilterRowHeight();
    }

    @Override // com.devexpress.dxgrid.providers.ServiceProvider
    public void updateColumns(GridColumnModel[] gridColumnModelArr) {
        this.gridControlModel.setGridColumns(gridColumnModelArr);
        this.columnInfoHelper.setGridControlModel(this.gridControlModel);
    }
}
