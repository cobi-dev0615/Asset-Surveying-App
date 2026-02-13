package com.devexpress.dxcharts;

import android.view.View;

/* loaded from: classes.dex */
interface ChartViewHolder {
    boolean canFixFlicker();

    View getView();

    void requestRender();

    void setRenderer(GLRenderer gLRenderer);
}
