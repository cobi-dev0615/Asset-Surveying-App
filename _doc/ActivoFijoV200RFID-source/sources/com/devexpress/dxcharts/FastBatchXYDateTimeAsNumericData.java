package com.devexpress.dxcharts;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class FastBatchXYDateTimeAsNumericData implements FastXYData {
    private BatchDateTimeAsNumericSeriesData data;

    public FastBatchXYDateTimeAsNumericData(BatchDateTimeAsNumericSeriesData batchDateTimeAsNumericSeriesData) {
        this.data = batchDateTimeAsNumericSeriesData;
    }

    @Override // com.devexpress.dxcharts.FastXYData
    public void load(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byteBuffer2.order(ByteOrder.nativeOrder());
        double[] dArr = new double[i];
        double[] dArr2 = new double[i];
        byteBuffer.asDoubleBuffer().put(dArr, 0, this.data.fillArguments(dArr, 0, i));
        byteBuffer2.asDoubleBuffer().put(dArr2, 0, this.data.fillValues(dArr2, 0, i));
    }
}
