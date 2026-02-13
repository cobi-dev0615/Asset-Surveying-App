package com.devexpress.dxgrid.providers;

import android.content.Context;
import android.view.View;
import com.devexpress.dxgrid.models.appearance.AppearanceBase;

/* loaded from: classes.dex */
public interface EditViewProvider {
    View getEditableView(Context context, int i);

    boolean isPaddingInEditor();

    void open(boolean z, int i);

    void setRequestUpdateRunnable(Runnable runnable, int i);

    String submitEditValue(View view, int i);

    void updateAppearance(int i);

    void updateAppearance(AppearanceBase appearanceBase, int i);

    void updateContent(int i);
}
