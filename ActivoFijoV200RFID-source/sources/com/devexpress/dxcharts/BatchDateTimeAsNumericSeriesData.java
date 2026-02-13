package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public interface BatchDateTimeAsNumericSeriesData extends XYSeriesData {
    int fillArguments(double[] dArr, int i, int i2);

    int fillValues(double[] dArr, int i, int i2);

    double getArgument(int i);

    int getDataCount();

    double getValue(int i);
}
