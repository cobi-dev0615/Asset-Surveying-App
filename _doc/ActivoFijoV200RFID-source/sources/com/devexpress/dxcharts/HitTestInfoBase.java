package com.devexpress.dxcharts;

import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: HitTestController.java */
/* loaded from: classes.dex */
class HitTestInfoBase {
    private final RectF rect;

    HitTestInfoBase(RectF rectF) {
        this.rect = rectF;
    }

    boolean hitTest(PointF pointF) {
        return this.rect.contains(pointF.x, pointF.y);
    }
}
