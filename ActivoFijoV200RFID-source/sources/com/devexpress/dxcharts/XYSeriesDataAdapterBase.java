package com.devexpress.dxcharts;

/* loaded from: classes.dex */
abstract class XYSeriesDataAdapterBase extends SeriesDataAdapterBase {
    private XYSeriesData _data;

    /* JADX WARN: Removed duplicated region for block: B:6:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.devexpress.dxcharts.XYSeriesDataAdapterBase create(com.devexpress.dxcharts.XYSeriesData r1, long r2, java.lang.Object r4) {
        /*
            if (r1 == 0) goto L86
            boolean r0 = r1 instanceof com.devexpress.dxcharts.RangeNumericSeriesData
            if (r0 == 0) goto Lf
            com.devexpress.dxcharts.XYRangeNumericSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYRangeNumericSeriesDataAdapter
            com.devexpress.dxcharts.RangeNumericSeriesData r1 = (com.devexpress.dxcharts.RangeNumericSeriesData) r1
            r0.<init>(r1)
            goto L87
        Lf:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.WeightedNumericSeriesData
            if (r0 == 0) goto L1c
            com.devexpress.dxcharts.XYWeightedNumericSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYWeightedNumericSeriesDataAdapter
            com.devexpress.dxcharts.WeightedNumericSeriesData r1 = (com.devexpress.dxcharts.WeightedNumericSeriesData) r1
            r0.<init>(r1)
            goto L87
        L1c:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.NumericSeriesData
            if (r0 == 0) goto L26
            com.devexpress.dxcharts.XYNumericSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYNumericSeriesDataAdapter
            r0.<init>(r1)
            goto L87
        L26:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.RangeDateTimeSeriesData
            if (r0 == 0) goto L32
            com.devexpress.dxcharts.XYRangeDateTimeSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYRangeDateTimeSeriesDataAdapter
            com.devexpress.dxcharts.RangeDateTimeSeriesData r1 = (com.devexpress.dxcharts.RangeDateTimeSeriesData) r1
            r0.<init>(r1)
            goto L87
        L32:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.WeightedDateTimeSeriesData
            if (r0 == 0) goto L3e
            com.devexpress.dxcharts.XYWeightedDateTimeSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYWeightedDateTimeSeriesDataAdapter
            com.devexpress.dxcharts.WeightedDateTimeSeriesData r1 = (com.devexpress.dxcharts.WeightedDateTimeSeriesData) r1
            r0.<init>(r1)
            goto L87
        L3e:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData
            if (r0 == 0) goto L4a
            com.devexpress.dxcharts.XYBatchDateTimeAsNumericSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYBatchDateTimeAsNumericSeriesDataAdapter
            com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData r1 = (com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData) r1
            r0.<init>(r1)
            goto L87
        L4a:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.DateTimeSeriesData
            if (r0 == 0) goto L56
            com.devexpress.dxcharts.XYDateTimeSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYDateTimeSeriesDataAdapter
            com.devexpress.dxcharts.DateTimeSeriesData r1 = (com.devexpress.dxcharts.DateTimeSeriesData) r1
            r0.<init>(r1)
            goto L87
        L56:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.RangeQualitativeSeriesData
            if (r0 == 0) goto L62
            com.devexpress.dxcharts.XYRangeQualitativeSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYRangeQualitativeSeriesDataAdapter
            com.devexpress.dxcharts.RangeQualitativeSeriesData r1 = (com.devexpress.dxcharts.RangeQualitativeSeriesData) r1
            r0.<init>(r1)
            goto L87
        L62:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.WeightedQualitativeSeriesData
            if (r0 == 0) goto L6e
            com.devexpress.dxcharts.XYWeightedQualitativeSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYWeightedQualitativeSeriesDataAdapter
            com.devexpress.dxcharts.WeightedQualitativeSeriesData r1 = (com.devexpress.dxcharts.WeightedQualitativeSeriesData) r1
            r0.<init>(r1)
            goto L87
        L6e:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.QualitativeSeriesData
            if (r0 == 0) goto L7a
            com.devexpress.dxcharts.XYQualitativeSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYQualitativeSeriesDataAdapter
            com.devexpress.dxcharts.QualitativeSeriesData r1 = (com.devexpress.dxcharts.QualitativeSeriesData) r1
            r0.<init>(r1)
            goto L87
        L7a:
            boolean r0 = r1 instanceof com.devexpress.dxcharts.FinancialSeriesData
            if (r0 == 0) goto L86
            com.devexpress.dxcharts.XYFinancialSeriesDataAdapter r0 = new com.devexpress.dxcharts.XYFinancialSeriesDataAdapter
            com.devexpress.dxcharts.FinancialSeriesData r1 = (com.devexpress.dxcharts.FinancialSeriesData) r1
            r0.<init>(r1)
            goto L87
        L86:
            r0 = 0
        L87:
            if (r0 == 0) goto L8f
            r0.initialize(r2)
            r0.setSyncObject(r4)
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxcharts.XYSeriesDataAdapterBase.create(com.devexpress.dxcharts.XYSeriesData, long, java.lang.Object):com.devexpress.dxcharts.XYSeriesDataAdapterBase");
    }

    XYSeriesDataAdapterBase(XYSeriesData xYSeriesData) {
        super(xYSeriesData instanceof ChangeableSeriesData ? (ChangeableSeriesData) xYSeriesData : null);
        this._data = xYSeriesData;
    }

    XYSeriesData getData() {
        return this._data;
    }
}
