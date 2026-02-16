package com.devexpress.dxcharts;

import java.util.Date;

/* loaded from: classes.dex */
public interface FinancialSeriesData extends XYSeriesData {
    Date getArgument(int i);

    double getCloseValue(int i);

    int getDataCount();

    double getHighValue(int i);

    double getLowValue(int i);

    double getOpenValue(int i);
}
