package crc64e1247576af304310;

import com.devexpress.dxcharts.SeriesPointInfo;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PointTextProvider implements IGCUserPeer, com.devexpress.dxcharts.PointTextProvider {
    public static final String __md_methods = "n_getText:(Lcom/devexpress/dxcharts/SeriesPointInfo;)Ljava/lang/String;:GetGetText_Lcom_devexpress_dxcharts_SeriesPointInfo_Handler:DevExpress.Android.Charts.IPointTextProviderInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native String n_getText(SeriesPointInfo seriesPointInfo);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.PointTextProvider, DevExpress.Maui.Charts", PointTextProvider.class, __md_methods);
    }

    public PointTextProvider() {
        if (getClass() == PointTextProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.PointTextProvider, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.PointTextProvider
    public String getText(SeriesPointInfo seriesPointInfo) {
        return n_getText(seriesPointInfo);
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
