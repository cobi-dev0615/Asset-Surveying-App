package crc64e1247576af304310;

import com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DateTimeSeriesDataAdapter extends XYSeriesDataAdapter implements IGCUserPeer, BatchDateTimeAsNumericSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.IBatchDateTimeAsNumericSeriesDataInvoker, DXCharts.a\nn_fillArguments:([DII)I:GetFillArguments_arrayDIIHandler:DevExpress.Android.Charts.IBatchDateTimeAsNumericSeriesDataInvoker, DXCharts.a\nn_fillValues:([DII)I:GetFillValues_arrayDIIHandler:DevExpress.Android.Charts.IBatchDateTimeAsNumericSeriesDataInvoker, DXCharts.a\nn_getArgument:(I)D:GetGetArgument_IHandler:DevExpress.Android.Charts.IBatchDateTimeAsNumericSeriesDataInvoker, DXCharts.a\nn_getValue:(I)D:GetGetValue_IHandler:DevExpress.Android.Charts.IBatchDateTimeAsNumericSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native int n_fillArguments(double[] dArr, int i, int i2);

    private native int n_fillValues(double[] dArr, int i, int i2);

    private native double n_getArgument(int i);

    private native int n_getDataCount();

    private native double n_getValue(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.DateTimeSeriesDataAdapter, DevExpress.Maui.Charts", DateTimeSeriesDataAdapter.class, __md_methods);
    }

    public DateTimeSeriesDataAdapter() {
        if (getClass() == DateTimeSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.DateTimeSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData
    public int fillArguments(double[] dArr, int i, int i2) {
        return n_fillArguments(dArr, i, i2);
    }

    @Override // com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData
    public int fillValues(double[] dArr, int i, int i2) {
        return n_fillValues(dArr, i, i2);
    }

    @Override // com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData
    public double getArgument(int i) {
        return n_getArgument(i);
    }

    @Override // com.devexpress.dxcharts.BatchDateTimeAsNumericSeriesData
    public double getValue(int i) {
        return n_getValue(i);
    }

    @Override // crc64e1247576af304310.XYSeriesDataAdapter, crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64e1247576af304310.XYSeriesDataAdapter, crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
