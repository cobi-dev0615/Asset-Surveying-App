package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class SelectionChangedInfo {
    private SelectionAction action;
    private SeriesPointInfo deselectedInfo;
    private SeriesPointInfo selectedInfo;

    SelectionChangedInfo(int i, int i2, int[] iArr, int i3, int[] iArr2) {
        this.action = SelectionAction.values()[i];
        SeriesPointInfo seriesPointInfo = null;
        this.selectedInfo = (i2 < 0 || iArr == null) ? null : new SeriesPointInfo(i2, iArr);
        if (i3 >= 0 && iArr2 != null) {
            seriesPointInfo = new SeriesPointInfo(i3, iArr2);
        }
        this.deselectedInfo = seriesPointInfo;
    }

    public SelectionAction getAction() {
        return this.action;
    }

    public SeriesPointInfo getSelectedInfo() {
        return this.selectedInfo;
    }

    public SeriesPointInfo getDeselectedInfo() {
        return this.deselectedInfo;
    }
}
