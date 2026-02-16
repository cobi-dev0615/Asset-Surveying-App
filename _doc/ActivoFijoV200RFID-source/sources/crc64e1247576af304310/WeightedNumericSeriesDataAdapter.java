package crc64e1247576af304310;

import com.devexpress.dxcharts.NumericSeriesData;
import com.devexpress.dxcharts.WeightedNumericSeriesData;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class WeightedNumericSeriesDataAdapter extends NumericalSeriesDataAdapter implements IGCUserPeer, WeightedNumericSeriesData, NumericSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getWeight:(I)D:GetGetWeight_IHandler:DevExpress.Android.Charts.IWeightedNumericSeriesDataInvoker, DXCharts.a\nn_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.INumericSeriesDataInvoker, DXCharts.a\nn_getArgument:(I)D:GetGetArgument_IHandler:DevExpress.Android.Charts.INumericSeriesDataInvoker, DXCharts.a\nn_getValue:(I)D:GetGetValue_IHandler:DevExpress.Android.Charts.INumericSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native double n_getArgument(int i);

    private native int n_getDataCount();

    private native double n_getValue(int i);

    private native double n_getWeight(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.WeightedNumericSeriesDataAdapter, DevExpress.Maui.Charts", WeightedNumericSeriesDataAdapter.class, __md_methods);
    }

    public WeightedNumericSeriesDataAdapter() {
        if (getClass() == WeightedNumericSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.WeightedNumericSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.WeightedNumericSeriesData
    public double getWeight(int i) {
        return n_getWeight(i);
    }

    @Override // crc64e1247576af304310.NumericalSeriesDataAdapter, com.devexpress.dxcharts.NumericSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // crc64e1247576af304310.NumericalSeriesDataAdapter, com.devexpress.dxcharts.NumericSeriesData
    public double getArgument(int i) {
        return n_getArgument(i);
    }

    @Override // crc64e1247576af304310.NumericalSeriesDataAdapter, com.devexpress.dxcharts.NumericSeriesData
    public double getValue(int i) {
        return n_getValue(i);
    }

    @Override // crc64e1247576af304310.NumericalSeriesDataAdapter, crc64e1247576af304310.XYSeriesDataAdapter, crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64e1247576af304310.NumericalSeriesDataAdapter, crc64e1247576af304310.XYSeriesDataAdapter, crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
