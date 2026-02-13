package com.devexpress.dxcharts;

import java.util.Date;

/* loaded from: classes.dex */
public interface DateTimeSeriesData extends XYSeriesData {
    Date getArgument(int i);

    int getDataCount();

    double getValue(int i);
}
