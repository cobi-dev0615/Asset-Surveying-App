package crc64e1247576af304310;

import com.devexpress.dxcharts.FinancialSeriesData;
import com.devexpress.dxcharts.XYSeriesData;
import java.util.ArrayList;
import java.util.Date;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class FinancialSeriesDataAdapter extends XYSeriesDataAdapter implements IGCUserPeer, FinancialSeriesData, XYSeriesData {
    public static final String __md_methods = "n_getDataCount:()I:GetGetDataCountHandler:DevExpress.Android.Charts.IFinancialSeriesDataInvoker, DXCharts.a\nn_getArgument:(I)Ljava/util/Date;:GetGetArgument_IHandler:DevExpress.Android.Charts.IFinancialSeriesDataInvoker, DXCharts.a\nn_getCloseValue:(I)D:GetGetCloseValue_IHandler:DevExpress.Android.Charts.IFinancialSeriesDataInvoker, DXCharts.a\nn_getHighValue:(I)D:GetGetHighValue_IHandler:DevExpress.Android.Charts.IFinancialSeriesDataInvoker, DXCharts.a\nn_getLowValue:(I)D:GetGetLowValue_IHandler:DevExpress.Android.Charts.IFinancialSeriesDataInvoker, DXCharts.a\nn_getOpenValue:(I)D:GetGetOpenValue_IHandler:DevExpress.Android.Charts.IFinancialSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native Date n_getArgument(int i);

    private native double n_getCloseValue(int i);

    private native int n_getDataCount();

    private native double n_getHighValue(int i);

    private native double n_getLowValue(int i);

    private native double n_getOpenValue(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.FinancialSeriesDataAdapter, DevExpress.Maui.Charts", FinancialSeriesDataAdapter.class, __md_methods);
    }

    public FinancialSeriesDataAdapter() {
        if (getClass() == FinancialSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.FinancialSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.FinancialSeriesData
    public int getDataCount() {
        return n_getDataCount();
    }

    @Override // com.devexpress.dxcharts.FinancialSeriesData
    public Date getArgument(int i) {
        return n_getArgument(i);
    }

    @Override // com.devexpress.dxcharts.FinancialSeriesData
    public double getCloseValue(int i) {
        return n_getCloseValue(i);
    }

    @Override // com.devexpress.dxcharts.FinancialSeriesData
    public double getHighValue(int i) {
        return n_getHighValue(i);
    }

    @Override // com.devexpress.dxcharts.FinancialSeriesData
    public double getLowValue(int i) {
        return n_getLowValue(i);
    }

    @Override // com.devexpress.dxcharts.FinancialSeriesData
    public double getOpenValue(int i) {
        return n_getOpenValue(i);
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
