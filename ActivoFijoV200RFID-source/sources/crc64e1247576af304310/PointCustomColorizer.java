package crc64e1247576af304310;

import com.devexpress.dxcharts.ColoredPointInfo;
import com.devexpress.dxcharts.CustomPointColorizer;
import com.devexpress.dxcharts.LegendItemProvider;
import com.devexpress.dxcharts.PointColorizer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PointCustomColorizer implements IGCUserPeer, CustomPointColorizer, PointColorizer {
    public static final String __md_methods = "n_getLegendItemProvider:()Lcom/devexpress/dxcharts/LegendItemProvider;:GetGetLegendItemProviderHandler:DevExpress.Android.Charts.ICustomPointColorizerInvoker, DXCharts.a\nn_getColor:(Lcom/devexpress/dxcharts/ColoredPointInfo;)I:GetGetColor_Lcom_devexpress_dxcharts_ColoredPointInfo_Handler:DevExpress.Android.Charts.ICustomPointColorizerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native int n_getColor(ColoredPointInfo coloredPointInfo);

    private native LegendItemProvider n_getLegendItemProvider();

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.PointCustomColorizer, DevExpress.Maui.Charts", PointCustomColorizer.class, __md_methods);
    }

    public PointCustomColorizer() {
        if (getClass() == PointCustomColorizer.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.PointCustomColorizer, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.CustomPointColorizer
    public LegendItemProvider getLegendItemProvider() {
        return n_getLegendItemProvider();
    }

    @Override // com.devexpress.dxcharts.CustomPointColorizer
    public int getColor(ColoredPointInfo coloredPointInfo) {
        return n_getColor(coloredPointInfo);
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
