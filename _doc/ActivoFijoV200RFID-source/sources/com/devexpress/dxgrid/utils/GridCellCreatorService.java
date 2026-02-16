package com.devexpress.dxgrid.utils;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.utils.providers.ColumnsProvider;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import com.devexpress.dxgrid.views.GridCellContainer;

/* loaded from: classes2.dex */
public class GridCellCreatorService {
    private static GridContainerViewInfo createGridContainerViewInfo(ColumnInfo columnInfo) {
        return new GridContainerViewInfo(columnInfo.getFixedColumnSeparatorStyle(), columnInfo.getShouldDrawLeftBorder(), columnInfo.getShouldDrawRightBorder(), false, true, columnInfo.getBottomColumn());
    }

    public static GridCellContainer createCellContainer(Context context, int i, ServiceProvider serviceProvider) {
        ColumnInfo column = serviceProvider.getColumn(i);
        GridContainerViewInfo createGridContainerViewInfo = createGridContainerViewInfo(column);
        GridColumnModel gridColumnModel = column.getGridColumnModel();
        GridCellContainer gridCellContainer = new GridCellContainer(context, serviceProvider.getCellAppearance(gridColumnModel), createGridContainerViewInfo, i);
        gridCellContainer.setHorizontalAlignment(gridColumnModel.getHorizontalContentAlignment());
        gridCellContainer.setVerticalAlignment(gridColumnModel.getVerticalContentAlignment());
        return gridCellContainer;
    }

    public static View createCell(Context context, int i, int i2, ColumnsProvider columnsProvider) {
        return columnsProvider.getColumn(i2).getGridColumnModel().getViewProvider().requestView(context, i);
    }

    public static View createCell(Context context, int i, GridColumnModel gridColumnModel) {
        return gridColumnModel.getViewProvider().requestView(context, i);
    }
}
