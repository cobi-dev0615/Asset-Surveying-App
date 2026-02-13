package com.devexpress.dxcharts;

/* compiled from: ChartBase.java */
/* loaded from: classes.dex */
class NavigationProcessResult {
    private HintInfo mHitInfo;
    private OverlayInfo[] mOverlayInfos;
    private SelectionChangedInfo mSelectionInfo;

    public NavigationProcessResult(SelectionChangedInfo selectionChangedInfo, OverlayInfo[] overlayInfoArr, HintInfo hintInfo) {
        this.mSelectionInfo = selectionChangedInfo;
        this.mOverlayInfos = overlayInfoArr;
        this.mHitInfo = hintInfo;
    }

    SelectionChangedInfo getSelectionInfo() {
        return this.mSelectionInfo;
    }

    OverlayInfo[] getOverlayInfos() {
        return this.mOverlayInfos;
    }

    HintInfo getHintInfo() {
        return this.mHitInfo;
    }
}
