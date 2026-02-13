package crc64e1247576af304310;

import com.devexpress.dxcharts.RangeQualitativeSeriesData;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class RangeQualitativeSeriesDataAdapter extends XYSeriesDataAdapter implements IGCUserPeer, RangeQualitativeSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.IRangeQualitativeSeriesDataInvoker, DXCharts.a\nn_getArgument:(I)Ljava/lang/String;:GetGetArgument_IHandler:DevExpress.Android.Charts.IRangeQualitativeSeriesDataInvoker, DXCharts.a\nn_getValue1:(I)D:GetGetValue1_IHandler:DevExpress.Android.Charts.IRangeQualitativeSeriesDataInvoker, DXCharts.a\nn_getValue2:(I)D:GetGetValue2_IHandler:DevExpress.Android.Charts.IRangeQualitativeSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native String n_getArgument(int i);

    private native int n_getDataCount();

    private native double n_getValue1(int i);

    private native double n_getValue2(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.RangeQualitativeSeriesDataAdapter, DevExpress.Maui.Charts", RangeQualitativeSeriesDataAdapter.class, __md_methods);
    }

    public RangeQualitativeSeriesDataAdapter() {
        if (getClass() == RangeQualitativeSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.RangeQualitativeSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.RangeQualitativeSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // com.devexpress.dxcharts.RangeQualitativeSeriesData
    public String getArgument(int i) {
        return n_getArgument(i);
    }

    @Override // com.devexpress.dxcharts.RangeQualitativeSeriesData
    public double getValue1(int i) {
        return n_getValue1(i);
    }

    @Override // com.devexpress.dxcharts.RangeQualitativeSeriesData
    public double getValue2(int i) {
        return n_getValue2(i);
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
