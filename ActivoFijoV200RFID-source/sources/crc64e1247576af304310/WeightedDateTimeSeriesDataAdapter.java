package crc64e1247576af304310;

import com.devexpress.dxcharts.DateTimeSeriesData;
import com.devexpress.dxcharts.WeightedDateTimeSeriesData;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import java.util.Date;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class WeightedDateTimeSeriesDataAdapter extends XYSeriesDataAdapter implements IGCUserPeer, WeightedDateTimeSeriesData, DateTimeSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getWeight:(I)D:GetGetWeight_IHandler:DevExpress.Android.Charts.IWeightedDateTimeSeriesDataInvoker, DXCharts.a\nn_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.IDateTimeSeriesDataInvoker, DXCharts.a\nn_getArgument:(I)Ljava/util/Date;:GetGetArgument_IHandler:DevExpress.Android.Charts.IDateTimeSeriesDataInvoker, DXCharts.a\nn_getValue:(I)D:GetGetValue_IHandler:DevExpress.Android.Charts.IDateTimeSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native Date n_getArgument(int i);

    private native int n_getDataCount();

    private native double n_getValue(int i);

    private native double n_getWeight(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.WeightedDateTimeSeriesDataAdapter, DevExpress.Maui.Charts", WeightedDateTimeSeriesDataAdapter.class, __md_methods);
    }

    public WeightedDateTimeSeriesDataAdapter() {
        if (getClass() == WeightedDateTimeSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.WeightedDateTimeSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.WeightedDateTimeSeriesData
    public double getWeight(int i) {
        return n_getWeight(i);
    }

    @Override // com.devexpress.dxcharts.DateTimeSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // com.devexpress.dxcharts.DateTimeSeriesData
    public Date getArgument(int i) {
        return n_getArgument(i);
    }

    @Override // com.devexpress.dxcharts.DateTimeSeriesData
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
