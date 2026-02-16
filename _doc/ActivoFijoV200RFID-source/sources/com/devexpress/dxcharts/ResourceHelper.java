package com.devexpress.dxcharts;

import android.util.TypedValue;
import androidx.core.view.ViewCompat;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class ResourceHelper {
    ResourceHelper() {
    }

    private static TypedValue getThemeResource(ContextProvider contextProvider, int i) {
        TypedValue typedValue = new TypedValue();
        if ((contextProvider.getUserChartTheme() != null && contextProvider.getUserChartTheme().resolveAttribute(i, typedValue, true)) || contextProvider.getBaseTheme().resolveAttribute(i, typedValue, true) || contextProvider.getDefaultChartTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    static int getSimpleColor(ContextProvider contextProvider, int i) {
        return contextProvider.getResources().getColor(i, contextProvider.getBaseTheme());
    }

    static int getColorOrDefault(ContextProvider contextProvider, int i) {
        TypedValue themeResource = getThemeResource(contextProvider, i);
        return themeResource != null ? themeResource.data : ViewCompat.MEASURED_SIZE_MASK;
    }

    static float getDimensionOrDefault(ContextProvider contextProvider, int i) {
        TypedValue themeResource = getThemeResource(contextProvider, i);
        if (themeResource != null) {
            return themeResource.getDimension(contextProvider.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    static Float getDimension(ContextProvider contextProvider, int i) {
        TypedValue themeResource = getThemeResource(contextProvider, i);
        if (themeResource != null) {
            return Float.valueOf(themeResource.getDimension(contextProvider.getResources().getDisplayMetrics()));
        }
        return null;
    }

    static int[] getIntArrayOrDefault(ContextProvider contextProvider, int i) {
        TypedValue themeResource = getThemeResource(contextProvider, i);
        if (themeResource != null) {
            return contextProvider.getResources().getIntArray(themeResource.data);
        }
        return null;
    }

    static Boolean getBooleanOrDefault(ContextProvider contextProvider, int i) {
        TypedValue themeResource = getThemeResource(contextProvider, i);
        if (themeResource != null) {
            return Boolean.valueOf(contextProvider.getResources().getBoolean(themeResource.resourceId));
        }
        return null;
    }
}
