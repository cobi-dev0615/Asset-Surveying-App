package crc64e1247576af304310;

import com.devexpress.dxcharts.CalculatedSeriesData;
import com.devexpress.dxcharts.Series;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CalculatedSeriesDataAdapter implements IGCUserPeer, CalculatedSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getSource:()Lcom/devexpress/dxcharts/Series;:GetGetSourceHandler:DevExpress.Android.Charts.ICalculatedSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native Series n_getSource();

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.CalculatedSeriesDataAdapter, DevExpress.Maui.Charts", CalculatedSeriesDataAdapter.class, __md_methods);
    }

    public CalculatedSeriesDataAdapter() {
        if (getClass() == CalculatedSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.CalculatedSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.CalculatedSeriesData
    public Series getSource() {
        return n_getSource();
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
