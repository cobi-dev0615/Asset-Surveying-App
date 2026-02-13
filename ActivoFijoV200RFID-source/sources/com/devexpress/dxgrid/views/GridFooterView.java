package com.devexpress.dxgrid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.devexpress.dxgrid.models.GridElement;
import com.devexpress.dxgrid.models.columns.GridColumnModel;
import com.devexpress.dxgrid.utils.ColumnInfo;
import com.devexpress.dxgrid.utils.FixedColumnSeparatorStyle;
import com.devexpress.dxgrid.utils.GridColumnsOnTouchListener;
import com.devexpress.dxgrid.utils.GridContainerViewInfo;
import com.devexpress.dxgrid.utils.providers.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GridFooterView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/devexpress/dxgrid/views/GridFooterView;", "Lcom/devexpress/dxgrid/views/GridColumnsViewBase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasTotalSummaries", "", "Ljava/lang/Boolean;", "isFixedHeight", "()Z", "createCellContainer", "Lcom/devexpress/dxgrid/views/GridCellContainer;", "columnIndex", "serviceProvider", "Lcom/devexpress/dxgrid/utils/providers/ServiceProvider;", "getFixedHeight", "getTouchListener", "Landroid/view/View$OnTouchListener;", "isVisible", "reset", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GridFooterView extends GridColumnsViewBase {
    private Boolean hasTotalSummaries;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridFooterView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridFooterView(Context context, AttributeSet attrs) {
        super(context, attrs, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridFooterView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    @Override // com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public boolean isFixedHeight() {
        return getServiceProvider().getFixedFooterHeight();
    }

    @Override // com.devexpress.dxgrid.utils.providers.ItemHeightProvider
    public int getFixedHeight() {
        return getServiceProvider().getFooterHeight();
    }

    @Override // com.devexpress.dxgrid.views.GridColumnsViewBase
    protected boolean isVisible() {
        return hasTotalSummaries();
    }

    @Override // com.devexpress.dxgrid.views.GridColumnsViewBase
    protected void reset() {
        this.hasTotalSummaries = null;
        super.reset();
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected GridCellContainer createCellContainer(Context context, int columnIndex, ServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        ColumnInfo column = serviceProvider.getColumn(columnIndex);
        Intrinsics.checkNotNullExpressionValue(column, "getColumn(...)");
        GridColumnModel gridColumnModel = column.getGridColumnModel();
        GridCellContainer gridCellContainer = new GridCellContainer(context, serviceProvider.getTotalSummaryView(context, columnIndex), serviceProvider.getSummaryAppearance(getContext(), columnIndex), new GridContainerViewInfo(FixedColumnSeparatorStyle.None, false, false, gridColumnModel.getRowIndex() == 0, false, false), columnIndex);
        gridCellContainer.setHorizontalAlignment(gridColumnModel.getBaseHorizontalContentAlignment());
        gridCellContainer.setVerticalAlignment(gridColumnModel.getVerticalContentAlignment());
        return gridCellContainer;
    }

    @Override // com.devexpress.dxgrid.views.GridViewBase
    protected View.OnTouchListener getTouchListener(int columnIndex) {
        return new GridColumnsOnTouchListener(getContext(), GridElement.TotalSummary, getGridAction(), columnIndex);
    }

    private final boolean hasTotalSummaries() {
        if (this.hasTotalSummaries == null) {
            int i = 0;
            this.hasTotalSummaries = false;
            if (getServiceProvider().getFooterHeight() != 0) {
                int columnCount = getServiceProvider().getColumnCount();
                while (true) {
                    if (i >= columnCount) {
                        break;
                    }
                    if (getServiceProvider().getTotalSummary(i) != null) {
                        this.hasTotalSummaries = true;
                        break;
                    }
                    i++;
                }
            }
        }
        Boolean bool = this.hasTotalSummaries;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }
}
