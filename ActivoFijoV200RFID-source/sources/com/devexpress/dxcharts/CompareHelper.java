package com.devexpress.dxcharts;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class CompareHelper {
    CompareHelper() {
    }

    static <T> boolean areEquals(T t, T t2) {
        if (t == null && t2 != null) {
            return false;
        }
        if (t != null && t2 == null) {
            return false;
        }
        if (t == null && t2 == null) {
            return true;
        }
        return t.equals(t2);
    }

    static <T> boolean areNotEquals(T t, T t2) {
        return !areEquals(t, t2);
    }
}
