package com.devexpress.dxcharts;

import android.graphics.Rect;

/* compiled from: OverlayInfo.java */
/* loaded from: classes.dex */
class TooltipAxesLabelsInfo {
    private Rect[] mLabelRects;
    private String[] mLabelTexts;

    TooltipAxesLabelsInfo(float[] fArr, String[] strArr) {
        this.mLabelRects = new Rect[fArr.length / 4];
        for (int i = 0; i < fArr.length / 4; i++) {
            int i2 = i * 4;
            this.mLabelRects[i] = new Rect((int) fArr[i2], (int) fArr[i2 + 1], (int) fArr[i2 + 2], (int) fArr[i2 + 3]);
        }
        this.mLabelTexts = strArr;
    }

    Rect getLabelRects(int i) {
        return this.mLabelRects[i];
    }

    String getLabelTexts(int i) {
        return this.mLabelTexts[i];
    }

    int getLabelCount() {
        return Math.min(this.mLabelRects.length, this.mLabelTexts.length);
    }
}
