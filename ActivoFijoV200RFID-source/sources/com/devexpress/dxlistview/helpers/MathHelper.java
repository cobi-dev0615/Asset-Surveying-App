package com.devexpress.dxlistview.helpers;

import android.graphics.Point;

/* loaded from: classes2.dex */
public class MathHelper {
    private MathHelper() {
    }

    public static Point createPoint(float f, float f2, Point point) {
        return new Point(round(f) + point.x, round(f2) + point.y);
    }

    public static int round(double d) {
        return (int) (d + (Math.signum(d) * 0.5d));
    }

    public static int round(float f) {
        return (int) (f + (Math.signum(f) * 0.5f));
    }
}
