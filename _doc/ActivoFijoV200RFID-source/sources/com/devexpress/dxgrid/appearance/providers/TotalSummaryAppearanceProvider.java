package com.devexpress.dxgrid.appearance.providers;

import android.content.Context;
import com.devexpress.dxgrid.appearance.GridCellContainerAppearance;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.models.columns.GridColumnModel;

/* loaded from: classes.dex */
public interface TotalSummaryAppearanceProvider {
    GridCellContainerAppearance getSummaryAppearance(Context context, int i);

    GridTextAppearance getSummaryTextAppearance(GridColumnModel gridColumnModel);
}
