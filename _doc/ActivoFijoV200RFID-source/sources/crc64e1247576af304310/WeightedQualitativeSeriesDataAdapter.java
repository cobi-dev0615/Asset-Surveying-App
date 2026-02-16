package crc64e1247576af304310;

import com.devexpress.dxcharts.QualitativeSeriesData;
import com.devexpress.dxcharts.WeightedQualitativeSeriesData;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class WeightedQualitativeSeriesDataAdapter extends QualitativeSeriesDataAdapter implements IGCUserPeer, WeightedQualitativeSeriesData, QualitativeSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getWeight:(I)D:GetGetWeight_IHandler:DevExpress.Android.Charts.IWeightedQualitativeSeriesDataInvoker, DXCharts.a\nn_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.IQualitativeSeriesDataInvoker, DXCharts.a\nn_getArgument:(I)Ljava/lang/String;:GetGetArgument_IHandler:DevExpress.Android.Charts.IQualitativeSeriesDataInvoker, DXCharts.a\nn_getValue:(I)D:GetGetValue_IHandler:DevExpress.Android.Charts.IQualitativeSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native String n_getArgument(int i);

    private native int n_getDataCount();

    private native double n_getValue(int i);

    private native double n_getWeight(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.WeightedQualitativeSeriesDataAdapter, DevExpress.Maui.Charts", WeightedQualitativeSeriesDataAdapter.class, __md_methods);
    }

    public WeightedQualitativeSeriesDataAdapter() {
        if (getClass() == WeightedQualitativeSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.WeightedQualitativeSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.WeightedQualitativeSeriesData
    public double getWeight(int i) {
        return n_getWeight(i);
    }

    @Override // crc64e1247576af304310.QualitativeSeriesDataAdapter, com.devexpress.dxcharts.QualitativeSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // crc64e1247576af304310.QualitativeSeriesDataAdapter, com.devexpress.dxcharts.QualitativeSeriesData
    public String getArgument(int i) {
        return n_getArgument(i);
    }

    @Override // crc64e1247576af304310.QualitativeSeriesDataAdapter, com.devexpress.dxcharts.QualitativeSeriesData
    public double getValue(int i) {
        return n_getValue(i);
    }

    @Override // crc64e1247576af304310.QualitativeSeriesDataAdapter, crc64e1247576af304310.XYSeriesDataAdapter, crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64e1247576af304310.QualitativeSeriesDataAdapter, crc64e1247576af304310.XYSeriesDataAdapter, crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
