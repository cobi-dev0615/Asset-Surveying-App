package com.devexpress.dxcharts;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;

/* loaded from: classes.dex */
class FastSingleXYNumericData implements FastXYData {
    private static final int MAX_BUFFER_SIZE = 8192;
    private static final int PAGE_SIZE = 4096;
    private static final int SIZE_OF_DOUBLE = 8;
    private NumericSeriesData _data;

    private static int getBufferSize(int i) {
        if (i < 8192) {
            return i;
        }
        return 8192;
    }

    public FastSingleXYNumericData(NumericSeriesData numericSeriesData) {
        this._data = numericSeriesData;
    }

    @Override // com.devexpress.dxcharts.FastXYData
    public void load(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byteBuffer2.order(ByteOrder.nativeOrder());
        int bufferSize = getBufferSize(i);
        double[] dArr = new double[bufferSize];
        double[] dArr2 = new double[bufferSize];
        DoubleBuffer asDoubleBuffer = byteBuffer.asDoubleBuffer();
        DoubleBuffer asDoubleBuffer2 = byteBuffer2.asDoubleBuffer();
        int i2 = 0;
        while (i > 0) {
            int min = Math.min(bufferSize, i);
            for (int i3 = 0; i3 < min; i3++) {
                int i4 = i2 + i3;
                double argument = this._data.getArgument(i4);
                double value = this._data.getValue(i4);
                dArr[i3] = argument;
                dArr2[i3] = value;
            }
            asDoubleBuffer.put(dArr, 0, min);
            asDoubleBuffer2.put(dArr2, 0, min);
            i2 += min;
            i -= min;
        }
    }
}
