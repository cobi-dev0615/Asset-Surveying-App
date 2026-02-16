package com.devexpress.dxcharts;

/* loaded from: classes.dex */
enum AxisElemType {
    ET_Label(1),
    ET_Title(2),
    ET_Crosshair(3),
    ET_Strip(4),
    ET_ConstantLine(5);

    final int value;

    AxisElemType(int i) {
        this.value = i;
    }

    int getAxisElemType() {
        return this.value;
    }
}
