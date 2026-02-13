package com.devexpress.dxgrid.providers;

import com.devexpress.dxgrid.appearance.providers.GroupHeaderAppearanceProvider;
import com.devexpress.dxgrid.appearance.providers.IndicatorAppearanceProvider;
import com.devexpress.dxgrid.appearance.providers.TotalSummaryAppearanceProvider;
import com.devexpress.dxgrid.interfaces.GroupHeaderSummaryTemplateChecker;
import com.devexpress.dxgrid.interfaces.GroupHeaderTemplateChecker;
import com.devexpress.dxgrid.interfaces.GroupHeaderValueTemplateChecker;
import com.devexpress.dxgrid.interfaces.InplaceEditingService;
import com.devexpress.dxgrid.layout.RunnablesQueue;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.providers.CellAppearanceProvider;
import com.devexpress.dxgrid.utils.providers.ColumnsProvider;
import com.devexpress.dxgrid.utils.providers.GridFooterHeightProvider;
import com.devexpress.dxgrid.utils.providers.GridHeaderHeightProvider;
import com.devexpress.dxgrid.utils.providers.GroupRowHeightProvider;
import com.devexpress.dxgrid.utils.providers.RowHeightProvider;
import com.devexpress.dxgrid.utils.providers.SwipeProvider;

/* loaded from: classes.dex */
public interface ServiceProvider extends DataProvider, RowHeightProvider, ColumnsProvider, CellAppearanceProvider, TotalSummaryAppearanceProvider, GroupHeaderAppearanceProvider, IndicatorAppearanceProvider, GridFooterHeightProvider, GridHeaderHeightProvider, SwipeProvider, InplaceEditingService, ColumnHeaderViewProvider, GroupHeaderTemplateChecker, TotalSummaryViewProviderBase, GroupHeaderValueTemplateChecker, GroupHeaderSummaryTemplateChecker, GroupRowHeightProvider, DragPreviewTemplateProvider, UpdateProvider, FilterProvider {
    GroupRowViewProviderBase getGroupRowProvider(boolean z, boolean z2, boolean z3);

    boolean getIsRefreshing();

    int getLeft();

    GroupHeaderAppearanceProvider getNativeGroupHeaderAppearanceProvider();

    int getRight();

    RunnablesQueue getRunnablesQueue();

    boolean isColumnInScreen(ColumnInfo columnInfo);

    void updateColumns(GridColumnModel[] gridColumnModelArr);
}
