package com.devexpress.dxgrid.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import com.devexpress.dxgrid.appearance.GridTextAppearance;
import com.devexpress.dxgrid.appearance.providers.TotalSummaryAppearanceProvider;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.providers.DataProvider;
import com.devexpress.dxgrid.providers.TotalSummaryViewProviderBase;
import com.devexpress.dxgrid.utils.providers.ColumnHeaderViewProviderNative;
import com.devexpress.dxgrid.utils.providers.ColumnsProvider;
import com.devexpress.editors.DisplayEdit;

/* loaded from: classes2.dex */
public class TotalSummaryViewProviderNative implements TotalSummaryViewProviderBase {
    private final TotalSummaryAppearanceProvider appearanceProvider;
    private ColumnsProvider columnsProvider;
    private final DataProvider dataProvider;

    public TotalSummaryViewProviderNative(ColumnsProvider columnsProvider, TotalSummaryAppearanceProvider totalSummaryAppearanceProvider, DataProvider dataProvider) {
        this.columnsProvider = columnsProvider;
        this.appearanceProvider = totalSummaryAppearanceProvider;
        this.dataProvider = dataProvider;
    }

    @Override // com.devexpress.dxgrid.providers.TotalSummaryViewProviderBase
    public View getTotalSummaryView(Context context, int i) {
        String totalSummary = this.dataProvider.getTotalSummary(i);
        DisplayEdit displayEdit = new DisplayEdit(context);
        GridColumnModel gridColumnModel = this.columnsProvider.getColumn(i).getGridColumnModel();
        GridTextAppearance summaryTextAppearance = this.appearanceProvider.getSummaryTextAppearance(gridColumnModel);
        displayEdit.setTextSize(summaryTextAppearance.getTextSize() * context.getResources().getDisplayMetrics().density);
        displayEdit.setTypeface(summaryTextAppearance.getTypeface());
        displayEdit.setTextColors(ColorStateList.valueOf(summaryTextAppearance.getTextColor()));
        displayEdit.setPaintFlags(BitMaskHelper.INSTANCE.setFlag(displayEdit.getPaintFlags(), 8, summaryTextAppearance.getTextIsUnderlined()));
        displayEdit.setPaintFlags(BitMaskHelper.INSTANCE.setFlag(displayEdit.getPaintFlags(), 16, summaryTextAppearance.getTextIsStrikethrough()));
        displayEdit.setTextGravity(ColumnHeaderViewProviderNative.getTextGravity(gridColumnModel.getHorizontalContentAlignment()));
        if (totalSummary == null) {
            totalSummary = "";
        }
        displayEdit.setText(totalSummary);
        return displayEdit;
    }
}
