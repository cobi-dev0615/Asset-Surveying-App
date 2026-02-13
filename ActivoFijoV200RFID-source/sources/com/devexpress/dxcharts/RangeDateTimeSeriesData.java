package com.devexpress.dxcharts;

import java.util.Date;

/* loaded from: classes.dex */
public interface RangeDateTimeSeriesData extends XYSeriesData {
    Date getArgument(int i);

    int getDataCount();

    double getValue1(int i);

    double getValue2(int i);
}
