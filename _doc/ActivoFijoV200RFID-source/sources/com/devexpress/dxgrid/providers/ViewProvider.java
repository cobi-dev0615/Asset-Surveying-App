package com.devexpress.dxgrid.providers;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;
import com.devexpress.dxgrid.models.columns.GridColumnModel;

/* loaded from: classes.dex */
public interface ViewProvider {
    View requestView(Context context, int i);

    void storeAsFree(View view);

    void updateAppearance(View view, GridColumnModel gridColumnModel, AppearanceBase appearanceBase, int i);

    void updateContent(View view, DataProvider dataProvider, String str, int i);
}
