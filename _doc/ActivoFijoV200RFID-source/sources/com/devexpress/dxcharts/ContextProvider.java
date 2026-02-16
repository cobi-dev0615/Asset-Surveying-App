package com.devexpress.dxcharts;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
interface ContextProvider {
    Resources.Theme getBaseTheme();

    Context getContext();

    Resources.Theme getDefaultChartTheme();

    Resources getResources();

    Resources.Theme getUserChartTheme();
}
