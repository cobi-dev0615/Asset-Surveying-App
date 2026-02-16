package com.devexpress.dxgrid.utils.providers;

import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.models.columns.GridColumnModel;

/* loaded from: classes2.dex */
public interface CellAppearanceProvider {
    GridCellContainerAppearance getCellAppearance(GridColumnModel gridColumnModel);

    GridTextAppearance getCellTextAppearance(GridColumnModel gridColumnModel);

    boolean isUpdateShouldRequestCustomCellStyle();
}
