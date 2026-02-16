package com.devexpress.dxcharts;

/* compiled from: HitTestInfo.java */
/* loaded from: classes.dex */
class HitTestInfoInternal {
    private HitTestInfo hitInfo;
    private int pointIndex;

    HitTestInfoInternal(HitTestInfo hitTestInfo, int i) {
        this.hitInfo = hitTestInfo;
        this.pointIndex = i;
    }

    HitTestInfo getHitInfo() {
        return this.hitInfo;
    }

    int getPointIndex() {
        return this.pointIndex;
    }
}
