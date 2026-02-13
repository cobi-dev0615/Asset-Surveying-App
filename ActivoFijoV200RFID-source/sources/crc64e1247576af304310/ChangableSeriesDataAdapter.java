package crc64e1247576af304310;

import com.devexpress.dxcharts.ChangeableSeriesData;
import com.devexpress.dxcharts.SeriesDataChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public abstract class ChangableSeriesDataAdapter implements IGCUserPeer, ChangeableSeriesData {
    public static final String __md_methods = "n_addChangedListener:(Lcom/devexpress/dxcharts/SeriesDataChangedListener;)V:GetAddChangedListener_Lcom_devexpress_dxcharts_SeriesDataChangedListener_Handler:DevExpress.Android.Charts.IChangeableSeriesDataInvoker, DXCharts.a\nn_removeChangedListener:(Lcom/devexpress/dxcharts/SeriesDataChangedListener;)V:GetRemoveChangedListener_Lcom_devexpress_dxcharts_SeriesDataChangedListener_Handler:DevExpress.Android.Charts.IChangeableSeriesDataInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native void n_addChangedListener(SeriesDataChangedListener seriesDataChangedListener);

    private native void n_removeChangedListener(SeriesDataChangedListener seriesDataChangedListener);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.ChangableSeriesDataAdapter, DevExpress.Maui.Charts", ChangableSeriesDataAdapter.class, __md_methods);
    }

    public ChangableSeriesDataAdapter() {
        if (getClass() == ChangableSeriesDataAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.ChangableSeriesDataAdapter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.ChangeableSeriesData
    public void addChangedListener(SeriesDataChangedListener seriesDataChangedListener) {
        n_addChangedListener(seriesDataChangedListener);
    }

    @Override // com.devexpress.dxcharts.ChangeableSeriesData
    public void removeChangedListener(SeriesDataChangedListener seriesDataChangedListener) {
        n_removeChangedListener(seriesDataChangedListener);
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
