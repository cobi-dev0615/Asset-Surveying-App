package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public interface IndexBasedCustomPointColorizer extends PointColorizer, StackedPointColorizer, WeightedPointColorizer, RangePointColorizer {
    int getColor(int i);

    LegendItemProvider getLegendItemProvider();
}
