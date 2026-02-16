package crc64e1247576af304310;

import com.devexpress.dxcharts.RangeNumericSeriesData;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class RangeNumericSeriesDataAdapter extends XYSeriesDataAdapter implements IGCUserPeer, RangeNumericSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.IRangeNumericSeriesDataInvoker, DXCharts.a\nn_getArgument:(I)D:GetGetArgument_IHandler:DevExpress.Android.Charts.IRangeNumericSeriesDataInvoker, DXCharts.a\nn_getValue1:(I)D:GetGetValue1_IHandler:DevExpress.Android.Charts.IRangeNumericSeriesDataInvoker, DXCharts.a\nn_getValue2:(I)D:GetGetValue2_IHandler:DevExpress.Android.Charts.IRangeNumericSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native double n_getArgument(int i);

    private native int n_getDataCount();

    private native double n_getValue1(int i);

    private native double n_getValue2(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.RangeNumericSeriesDataAdapter, DevExpress.Maui.Charts", RangeNumericSeriesDataAdapter.class, __md_methods);
    }

    public RangeNumericSeriesDataAdapter() {
        if (getClass() == RangeNumericSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.RangeNumericSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
    public double getArgument(int i) {
        return n_getArgument(i);
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
    public double getValue1(int i) {
        return n_getValue1(i);
    }

    @Override // com.devexpress.dxcharts.RangeNumericSeriesData
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
