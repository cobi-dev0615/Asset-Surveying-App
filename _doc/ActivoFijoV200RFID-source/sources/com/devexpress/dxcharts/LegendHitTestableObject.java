package com.devexpress.dxcharts;

import android.graphics.PointF;

/* compiled from: Legend.java */
/* loaded from: classes.dex */
class LegendHitTestableObject implements HitTestableObject {
    private LegendContainer legend;

    LegendHitTestableObject(LegendContainer legendContainer) {
        this.legend = legendContainer;
    }

    @Override // com.devexpress.dxcharts.HitTestableObject
    public HitTestInfoBase hitTest(PointF pointF) {
        return this.legend.hitTest(pointF);
    }
}
