package com.devexpress.dxcharts;

import android.graphics.PointF;
import java.util.Arrays;

/* loaded from: classes.dex */
class OverlayInfo {
    static final int OLT_AXIS_LABEL_ARG = 1;
    static final int OLT_AXIS_LABEL_VAL = 2;
    static final int OLT_CROSSHAIR_LABEL = 3;
    static final int OLT_TOOLTIP_LABEL = 0;
    private PointF mAnchorPoint;
    private int mOverlayLabelType;
    private int mTailPosition;
    private TooltipAxesLabelsInfo mTooltipAxesLabelsInfo;
    private TooltipLinesInfo mTooltipLinesInfo;

    OverlayInfo(float f, float f2, int i, double[] dArr, float[] fArr, String[] strArr, int i2) {
        this.mAnchorPoint = new PointF(f, f2);
        this.mOverlayLabelType = i2;
        this.mTailPosition = i;
        if (dArr != null) {
            this.mTooltipLinesInfo = new TooltipLinesInfo(dArr[0], dArr.length > 1 ? Arrays.copyOfRange(dArr, 1, dArr.length) : new double[0]);
        } else {
            if (fArr == null || strArr == null) {
                return;
            }
            this.mTooltipAxesLabelsInfo = new TooltipAxesLabelsInfo(fArr, strArr);
        }
    }

    PointF getAnchorPoint() {
        return this.mAnchorPoint;
    }

    int getTailPosition() {
        return this.mTailPosition;
    }

    TooltipLinesInfo getTooltipLinesInfo() {
        return this.mTooltipLinesInfo;
    }

    TooltipAxesLabelsInfo getTooltipAxesLabelsInfo() {
        return this.mTooltipAxesLabelsInfo;
    }

    int getOverlayLabelType() {
        return this.mOverlayLabelType;
    }
}
