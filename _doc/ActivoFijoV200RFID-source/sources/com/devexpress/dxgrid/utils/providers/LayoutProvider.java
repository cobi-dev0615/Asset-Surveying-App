package com.devexpress.dxgrid.utils.providers;

import android.view.View;

/* loaded from: classes2.dex */
public interface LayoutProvider {
    void finishDrag();

    int getDefaultRowHeight();

    boolean getDidStructureChanged();

    void startDrag(View view);
}
