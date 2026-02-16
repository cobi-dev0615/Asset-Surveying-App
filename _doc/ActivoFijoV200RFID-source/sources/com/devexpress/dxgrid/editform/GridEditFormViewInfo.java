package com.devexpress.dxgrid.editform;

import com.devexpress.dxgrid.models.columns.GridColumnModel;

/* loaded from: classes.dex */
public class GridEditFormViewInfo {
    private final GridColumnModel columnModel;
    private final String fieldCaption;
    private final boolean isReadonly;

    public String getFieldCaption() {
        return this.fieldCaption;
    }

    public GridColumnModel getGridColumnModel() {
        return this.columnModel;
    }

    public boolean isReadonly() {
        return this.isReadonly;
    }

    public GridEditFormViewInfo(GridColumnModel gridColumnModel, String str, boolean z) {
        this.fieldCaption = str;
        this.columnModel = gridColumnModel;
        this.isReadonly = z;
    }
}
