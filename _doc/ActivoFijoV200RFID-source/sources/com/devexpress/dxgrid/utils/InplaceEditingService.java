package com.devexpress.dxgrid.utils;

import android.content.Context;
import com.devexpress.dxgrid.interfaces.CellContainerCreator;
import com.devexpress.dxgrid.providers.GridAction;
import com.devexpress.dxgrid.providers.ServiceProvider;
import com.devexpress.dxgrid.views.GridCellContainer;

/* loaded from: classes2.dex */
public class InplaceEditingService implements com.devexpress.dxgrid.interfaces.InplaceEditingService {
    private int columnIndex;
    private GridAction gridAction;
    private InplaceEditor inplaceEditor;
    private int rowIndex;
    private ServiceProvider serviceProvider;
    private float tapX;
    private float tapY;

    public InplaceEditingService(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
        resetFields();
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public boolean startInplaceEditing(Context context, Runnable runnable, CellContainerCreator cellContainerCreator, int i, int i2) {
        if (this.columnIndex >= 0) {
            return false;
        }
        InplaceEditor inplaceEditor = this.serviceProvider.getColumn(i).getGridColumnModel().getInplaceEditor();
        if (inplaceEditor == null) {
            return true;
        }
        if (!inplaceEditor.isContainerFree()) {
            return false;
        }
        this.columnIndex = i;
        this.rowIndex = i2;
        this.inplaceEditor = inplaceEditor;
        ServiceProvider serviceProvider = this.serviceProvider;
        inplaceEditor.openInplaceEditor(context, runnable, cellContainerCreator, serviceProvider, serviceProvider, i2, this.gridAction, this.tapX, this.tapY);
        return true;
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public boolean finishInplaceEditing(boolean z) {
        InplaceEditor inplaceEditor = this.inplaceEditor;
        if (inplaceEditor == null) {
            return false;
        }
        String applyChanges = inplaceEditor.applyChanges(z);
        if (applyChanges != null && !applyChanges.isEmpty()) {
            return false;
        }
        resetFields();
        return true;
    }

    public void setGridAction(GridAction gridAction) {
        this.gridAction = gridAction;
    }

    private void resetFields() {
        this.inplaceEditor = null;
        this.columnIndex = -1;
        this.rowIndex = Integer.MIN_VALUE;
        this.tapX = -1.0f;
        this.tapY = -1.0f;
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public int getInplaceEditingColumnIndex() {
        return this.columnIndex;
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public int getInplaceEditingRowIndex() {
        return this.rowIndex;
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public GridCellContainer getInplaceEditorContainer() {
        InplaceEditor inplaceEditor = this.inplaceEditor;
        if (inplaceEditor != null) {
            return inplaceEditor.getInplaceEditorContainer();
        }
        return null;
    }

    @Override // com.devexpress.dxgrid.interfaces.InplaceEditingService
    public void tap(int i, int i2, float f, float f2) {
        this.tapX = f;
        this.tapY = f2;
        InplaceEditor inplaceEditor = this.inplaceEditor;
        if (inplaceEditor != null && this.rowIndex == i && this.columnIndex == i2) {
            inplaceEditor.postOpen();
        }
    }
}
