package com.devexpress.dxcharts;

import android.graphics.RectF;

/* compiled from: HitTestController.java */
/* loaded from: classes.dex */
class LegendHitTestInfo extends HitTestInfoBase {
    private final int pointIndex;
    private final int seriesIndex;

    LegendHitTestInfo(RectF rectF, int i, int i2) {
        super(rectF);
        this.seriesIndex = i;
        this.pointIndex = i2;
    }

    int getSeriesIndex() {
        return this.seriesIndex;
    }

    int getPointIndex() {
        return this.pointIndex;
    }
}
