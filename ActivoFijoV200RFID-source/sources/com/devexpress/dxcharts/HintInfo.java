package com.devexpress.dxcharts;

import android.graphics.Point;

/* loaded from: classes.dex */
public class HintInfo {
    private Point screenPoint;
    private SeriesPointInfo[] seriesPointInfos;

    HintInfo(int i, int i2, SeriesPointInfo[] seriesPointInfoArr) {
        this.screenPoint = new Point(i, i2);
        this.seriesPointInfos = seriesPointInfoArr;
    }

    public Point getScreenPoint() {
        return this.screenPoint;
    }

    public SeriesPointInfo[] getSeriesPointInfos() {
        return this.seriesPointInfos;
    }
}
