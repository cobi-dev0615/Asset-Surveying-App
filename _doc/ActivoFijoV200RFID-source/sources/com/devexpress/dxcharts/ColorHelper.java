package com.devexpress.dxcharts;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class ColorHelper {
    static final int EmptyColor = 16777215;

    ColorHelper() {
    }

    static Integer convertFromNativeColor(int i) {
        if (i == 16777215) {
            return null;
        }
        return Integer.valueOf(i);
    }

    static int convertToNativeColor(Integer num) {
        if (num == null) {
            return 16777215;
        }
        return num.intValue();
    }
}
