package com.devexpress.dxgrid.interfaces;

import android.content.Context;
import com.devexpress.dxgrid.views.GridCellContainer;

/* loaded from: classes.dex */
public interface InplaceEditingService {
    boolean finishInplaceEditing(boolean z);

    int getInplaceEditingColumnIndex();

    int getInplaceEditingRowIndex();

    GridCellContainer getInplaceEditorContainer();

    boolean startInplaceEditing(Context context, Runnable runnable, CellContainerCreator cellContainerCreator, int i, int i2);

    void tap(int i, int i2, float f, float f2);
}
