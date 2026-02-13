package com.devexpress.dxcharts;

import java.util.Date;

/* compiled from: SeriesLabel.java */
/* loaded from: classes.dex */
class PointLabelInfo {
    final Object argument;
    final double close;
    final double high;
    final double highRangeValue;
    final int[] indexes;
    final LabelPosition labelPosition;
    final double low;
    final double lowRangeValue;
    final double open;
    final String seriesName;
    final double value;
    final double valueInPercent;

    PointLabelInfo(String str, int[] iArr, int i, double d, String str2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i2) {
        this.seriesName = str;
        this.indexes = iArr;
        this.value = d2;
        this.valueInPercent = d3;
        this.high = d4;
        this.low = d5;
        this.open = d6;
        this.close = d7;
        this.highRangeValue = d8;
        this.lowRangeValue = d9;
        if (i2 == 0) {
            this.labelPosition = LabelPosition.LOW_VALUE_LABEL;
        } else if (i2 == 1) {
            this.labelPosition = LabelPosition.HIGH_VALUE_LABEL;
        } else if (i2 == 2) {
            this.labelPosition = LabelPosition.CENTER_LABEL;
        } else {
            this.labelPosition = null;
        }
        if (i == 0) {
            this.argument = Double.valueOf(d);
            return;
        }
        if (i == 1) {
            this.argument = new Date((long) (d2 * 1000.0d));
        } else if (i == 2) {
            this.argument = str2;
        } else {
            this.argument = null;
        }
    }
}
