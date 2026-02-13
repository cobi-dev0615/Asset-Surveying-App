package com.devexpress.dxcharts;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class HitTestController {
    private List<HitTestableObject> hitTestObjects = new ArrayList();

    HitTestController() {
    }

    void registerHitTestableObject(HitTestableObject hitTestableObject) {
        this.hitTestObjects.add(hitTestableObject);
    }

    private HitTestInfoBase hitTest(PointF pointF) {
        Iterator<HitTestableObject> it = this.hitTestObjects.iterator();
        HitTestInfoBase hitTestInfoBase = null;
        while (it.hasNext()) {
            HitTestInfoBase hitTest = it.next().hitTest(pointF);
            if (hitTest != null) {
                hitTestInfoBase = hitTest;
            }
        }
        return hitTestInfoBase;
    }

    HitTestInfo calcHitInfo(float f, float f2) {
        HitTestInfoBase hitTest = hitTest(new PointF(f, f2));
        if (hitTest == null || !(hitTest instanceof LegendHitTestInfo)) {
            return null;
        }
        LegendHitTestInfo legendHitTestInfo = (LegendHitTestInfo) hitTest;
        int pointIndex = legendHitTestInfo.getPointIndex();
        return new HitTestInfo(legendHitTestInfo.getSeriesIndex(), pointIndex >= 0 ? new int[]{pointIndex} : new int[0], true);
    }

    int[] getHitInfoInternal(float f, float f2) {
        HitTestInfo calcHitInfo = calcHitInfo(f, f2);
        if (calcHitInfo == null) {
            return null;
        }
        int[] dataPointIndices = calcHitInfo.getDataPointIndices();
        return new int[]{calcHitInfo.getSeriesIndex(), (dataPointIndices == null || dataPointIndices.length <= 0) ? -1 : dataPointIndices[0], calcHitInfo.isInLegend()};
    }
}
