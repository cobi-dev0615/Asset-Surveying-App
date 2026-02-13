package com.devexpress.dxcharts;

/* compiled from: OverlayInfo.java */
/* loaded from: classes.dex */
class TooltipItem {
    private boolean mIsAlignmentByCenter;
    private int mMarkerColor;
    private int mMarkerColor2;
    private boolean mShowMarker;
    private String mText;

    TooltipItem(String str, int i, int i2, boolean z, boolean z2) {
        this.mText = str;
        this.mMarkerColor = i;
        this.mMarkerColor2 = i2;
        this.mShowMarker = z;
        this.mIsAlignmentByCenter = z2;
    }

    String getText() {
        return this.mText;
    }

    int getMarkerColor() {
        return this.mMarkerColor;
    }

    int getMarkerColor2() {
        return this.mMarkerColor2;
    }

    boolean getShowMarker() {
        return this.mShowMarker;
    }

    boolean isAlignmentByCenter() {
        return this.mIsAlignmentByCenter;
    }
}
