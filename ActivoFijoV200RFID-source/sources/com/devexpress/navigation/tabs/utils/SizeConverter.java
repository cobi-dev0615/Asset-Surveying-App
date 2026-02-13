package com.devexpress.navigation.tabs.utils;

import android.content.Context;
import com.devexpress.navigation.navigationdrawer.DrawerSizeCalculator;
import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.models.TabSizeInPixels;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SizeConverter {
    Map<Float, Integer> dpToPxCache = new HashMap();
    float mDensity;

    public SizeConverter(float f) {
        this.mDensity = f;
    }

    public int convertDpToPx(float f) {
        if (f < 0.0f) {
            return (int) f;
        }
        Integer num = this.dpToPxCache.get(Float.valueOf(f));
        if (num == null) {
            num = Integer.valueOf((int) (this.mDensity * f));
            this.dpToPxCache.put(Float.valueOf(f), num);
        }
        return num.intValue();
    }

    public TabSizeInPixels convertSize(TabSize tabSize) {
        TabSizeInPixels tabSizeInPixels = new TabSizeInPixels(convertDpToPx(tabSize.getSize()), convertDpToPx(tabSize.getMinSize()), convertDpToPx(tabSize.getMaxSize()), tabSize.getIsStar(), tabSize.getIsAuto());
        tabSizeInPixels.setSize(DrawerSizeCalculator.correctItemSize(tabSizeInPixels.getIsAuto() ? 0 : tabSizeInPixels.getSize(), tabSizeInPixels.getMinSize(), tabSizeInPixels.getMaxSize()));
        return tabSizeInPixels;
    }

    public float convertPxToDp(float f) {
        return f < 0.0f ? f : f / this.mDensity;
    }

    public static int convertDpToPx(Context context, float f) {
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    public static int convertSpToPx(Context context, float f) {
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    public static float convertPxToDp(Context context, int i) {
        return i / context.getResources().getDisplayMetrics().density;
    }
}
