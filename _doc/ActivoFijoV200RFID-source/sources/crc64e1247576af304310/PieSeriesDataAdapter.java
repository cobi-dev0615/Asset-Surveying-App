package crc64e1247576af304310;

import com.devexpress.dxcharts.PieSeriesData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PieSeriesDataAdapter extends ChangableSeriesDataAdapter implements IGCUserPeer, PieSeriesData {
    public static final String __md_methods = "n_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.IPieSeriesDataInvoker, DXCharts.a\nn_getLabel:(I)Ljava/lang/String;:GetGetLabel_IHandler:DevExpress.Android.Charts.IPieSeriesDataInvoker, DXCharts.a\nn_getValue:(I)D:GetGetValue_IHandler:DevExpress.Android.Charts.IPieSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native int n_getDataCount();

    private native String n_getLabel(int i);

    private native double n_getValue(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.PieSeriesDataAdapter, DevExpress.Maui.Charts", PieSeriesDataAdapter.class, __md_methods);
    }

    public PieSeriesDataAdapter() {
        if (getClass() == PieSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.PieSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.PieSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // com.devexpress.dxcharts.PieSeriesData
    public String getLabel(int i) {
        return n_getLabel(i);
    }

    @Override // com.devexpress.dxcharts.PieSeriesData
    public double getValue(int i) {
        return n_getValue(i);
    }

    @Override // crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64e1247576af304310.ChangableSeriesDataAdapter, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
