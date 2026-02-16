package crc64e1247576af304310;

import com.devexpress.dxcharts.ColoredRangePointInfo;
import com.devexpress.dxcharts.LegendItemProvider;
import com.devexpress.dxcharts.RangeCustomPointColorizer;
import com.devexpress.dxcharts.RangePointColorizer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class RangePointCustomColorizer implements IGCUserPeer, RangeCustomPointColorizer, RangePointColorizer {
    public static final String __md_methods = "n_getLegendItemProvider:()Lcom/devexpress/dxcharts/LegendItemProvider;:GetGetLegendItemProviderHandler:DevExpress.Android.Charts.IRangeCustomPointColorizerInvoker, DXCharts.a\nn_getColor:(Lcom/devexpress/dxcharts/ColoredRangePointInfo;)I:GetGetColor_Lcom_devexpress_dxcharts_ColoredRangePointInfo_Handler:DevExpress.Android.Charts.IRangeCustomPointColorizerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native int n_getColor(ColoredRangePointInfo coloredRangePointInfo);

    private native LegendItemProvider n_getLegendItemProvider();

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.RangePointCustomColorizer, DevExpress.Maui.Charts", RangePointCustomColorizer.class, __md_methods);
    }

    public RangePointCustomColorizer() {
        if (getClass() == RangePointCustomColorizer.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.RangePointCustomColorizer, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.RangeCustomPointColorizer
    public LegendItemProvider getLegendItemProvider() {
        return n_getLegendItemProvider();
    }

    @Override // com.devexpress.dxcharts.RangeCustomPointColorizer
    public int getColor(ColoredRangePointInfo coloredRangePointInfo) {
        return n_getColor(coloredRangePointInfo);
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
