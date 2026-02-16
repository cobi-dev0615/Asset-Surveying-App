package com.devexpress.dxcharts;

/* compiled from: ChartTextStyleProvider.java */
/* loaded from: classes.dex */
class StyleID {
    short axisNumber;
    short elemNumber;
    AxisElemType elemType;
    boolean isAxisVertical;

    StyleID(boolean z, short s, AxisElemType axisElemType, short s2) {
        this.isAxisVertical = z;
        this.axisNumber = s;
        this.elemType = axisElemType;
        this.elemNumber = s2;
    }

    long toLong() {
        return ((((((this.isAxisVertical ? 2L : 1L) << 16) + this.axisNumber) << 3) + this.elemType.getAxisElemType()) << 16) + this.elemNumber;
    }

    static StyleID toStruct(long j) {
        return new StyleID((j >> 35) == 2, (short) (65535 & (j >> 19)), AxisElemType.values()[((int) ((j >> 16) & 7)) - 1], (short) (j & 65535));
    }
}
