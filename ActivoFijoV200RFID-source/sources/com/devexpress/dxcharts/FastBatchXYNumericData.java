package com.devexpress.dxcharts;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class FastBatchXYNumericData implements FastXYData {
    private BatchNumericSeriesData data;

    public FastBatchXYNumericData(BatchNumericSeriesData batchNumericSeriesData) {
        this.data = batchNumericSeriesData;
    }

    @Override // com.devexpress.dxcharts.FastXYData
    public void load(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byteBuffer2.order(ByteOrder.nativeOrder());
        double[] dArr = new double[i];
        byteBuffer.asDoubleBuffer().put(dArr, 0, this.data.fillArguments(dArr, 0, i));
        byteBuffer2.asDoubleBuffer().put(dArr, 0, this.data.fillValues(dArr, 0, i));
    }
}
