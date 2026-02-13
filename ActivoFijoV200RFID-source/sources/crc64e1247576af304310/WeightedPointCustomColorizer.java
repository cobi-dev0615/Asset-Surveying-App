package crc64e1247576af304310;

import com.devexpress.dxcharts.ColoredWeightedPointInfo;
import com.devexpress.dxcharts.LegendItemProvider;
import com.devexpress.dxcharts.WeightedCustomPointColorizer;
import com.devexpress.dxcharts.WeightedPointColorizer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class WeightedPointCustomColorizer implements IGCUserPeer, WeightedCustomPointColorizer, WeightedPointColorizer {
    public static final String __md_methods = "n_getLegendItemProvider:()Lcom/devexpress/dxcharts/LegendItemProvider;:GetGetLegendItemProviderHandler:DevExpress.Android.Charts.IWeightedCustomPointColorizerInvoker, DXCharts.a\nn_getColor:(Lcom/devexpress/dxcharts/ColoredWeightedPointInfo;)I:GetGetColor_Lcom_devexpress_dxcharts_ColoredWeightedPointInfo_Handler:DevExpress.Android.Charts.IWeightedCustomPointColorizerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native int n_getColor(ColoredWeightedPointInfo coloredWeightedPointInfo);

    private native LegendItemProvider n_getLegendItemProvider();

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.WeightedPointCustomColorizer, DevExpress.Maui.Charts", WeightedPointCustomColorizer.class, __md_methods);
    }

    public WeightedPointCustomColorizer() {
        if (getClass() == WeightedPointCustomColorizer.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.WeightedPointCustomColorizer, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.WeightedCustomPointColorizer
    public LegendItemProvider getLegendItemProvider() {
        return n_getLegendItemProvider();
    }

    @Override // com.devexpress.dxcharts.WeightedCustomPointColorizer
    public int getColor(ColoredWeightedPointInfo coloredWeightedPointInfo) {
        return n_getColor(coloredWeightedPointInfo);
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
