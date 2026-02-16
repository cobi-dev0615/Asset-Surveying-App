package com.devexpress.dxcharts;

/* loaded from: classes.dex */
interface IAxesContainer {
    void addAxisXForElement(AxisX axisX, Object obj);

    void addAxisYForElement(NumericAxisY numericAxisY, Object obj);

    void applyTheme(ContextProvider contextProvider);

    AxisX getAxisXByElement(Object obj);

    AxisX getAxisXById(int i);

    int getAxisXIDByAxisData(long j);

    NumericAxisY getAxisYByElement(Object obj);

    NumericAxisY getAxisYById(int i);

    int getAxisYIDByAxisData(long j);

    Object getRenderDelegate();
}
