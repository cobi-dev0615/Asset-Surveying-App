package crc64e1247576af304310;

import com.devexpress.dxcharts.SeriesLabelValuesBase;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SeriesLabelTextProvider implements IGCUserPeer, com.devexpress.dxcharts.SeriesLabelTextProvider {
    public static final String __md_methods = "n_getText:(Lcom/devexpress/dxcharts/SeriesLabelValuesBase;)Ljava/lang/String;:GetGetText_Lcom_devexpress_dxcharts_SeriesLabelValuesBase_Handler:DevExpress.Android.Charts.ISeriesLabelTextProviderInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native String n_getText(SeriesLabelValuesBase seriesLabelValuesBase);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.SeriesLabelTextProvider, DevExpress.Maui.Charts", SeriesLabelTextProvider.class, __md_methods);
    }

    public SeriesLabelTextProvider() {
        if (getClass() == SeriesLabelTextProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.SeriesLabelTextProvider, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesLabelTextProvider
    public String getText(SeriesLabelValuesBase seriesLabelValuesBase) {
        return n_getText(seriesLabelValuesBase);
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
