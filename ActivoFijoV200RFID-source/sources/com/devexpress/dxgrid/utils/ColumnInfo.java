package com.devexpress.dxgrid.utils;

import com.devexpress.dxgrid.models.columns.GridColumnModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColumnInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/devexpress/dxgrid/utils/ColumnInfo;", "", "gridColumnModel", "Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "index", "", "left", "width", "rowIndex", "fixedColumnSeparatorStyle", "Lcom/devexpress/dxgrid/utils/FixedColumnSeparatorStyle;", "shouldDrawRightBorder", "", "shouldDrawLeftBorder", "bottomColumn", "(Lcom/devexpress/dxgrid/models/columns/GridColumnModel;IIIILcom/devexpress/dxgrid/utils/FixedColumnSeparatorStyle;ZZZ)V", "getBottomColumn", "()Z", "getFixedColumnSeparatorStyle", "()Lcom/devexpress/dxgrid/utils/FixedColumnSeparatorStyle;", "getGridColumnModel", "()Lcom/devexpress/dxgrid/models/columns/GridColumnModel;", "getIndex", "()I", "getLeft", "right", "getRight", "getRowIndex", "getShouldDrawLeftBorder", "getShouldDrawRightBorder", "getWidth", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ColumnInfo {
    private final boolean bottomColumn;
    private final FixedColumnSeparatorStyle fixedColumnSeparatorStyle;
    private final GridColumnModel gridColumnModel;
    private final int index;
    private final int left;
    private final int rowIndex;
    private final boolean shouldDrawLeftBorder;
    private final boolean shouldDrawRightBorder;
    private final int width;

    public ColumnInfo(GridColumnModel gridColumnModel, int i, int i2, int i3, int i4, FixedColumnSeparatorStyle fixedColumnSeparatorStyle, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(gridColumnModel, "gridColumnModel");
        Intrinsics.checkNotNullParameter(fixedColumnSeparatorStyle, "fixedColumnSeparatorStyle");
        this.gridColumnModel = gridColumnModel;
        this.index = i;
        this.left = i2;
        this.width = i3;
        this.rowIndex = i4;
        this.fixedColumnSeparatorStyle = fixedColumnSeparatorStyle;
        this.shouldDrawRightBorder = z;
        this.shouldDrawLeftBorder = z2;
        this.bottomColumn = z3;
    }

    public final GridColumnModel getGridColumnModel() {
        return this.gridColumnModel;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final FixedColumnSeparatorStyle getFixedColumnSeparatorStyle() {
        return this.fixedColumnSeparatorStyle;
    }

    public final boolean getShouldDrawRightBorder() {
        return this.shouldDrawRightBorder;
    }

    public final boolean getShouldDrawLeftBorder() {
        return this.shouldDrawLeftBorder;
    }

    public final boolean getBottomColumn() {
        return this.bottomColumn;
    }

    public final int getRight() {
        return this.left + this.width;
    }
}
