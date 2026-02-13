package com.devexpress.dxgrid.providers;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public interface GroupRowViewProviderBase {
    View getView(Context context, int i);

    void updateView(Context context, View view, int i);
}
