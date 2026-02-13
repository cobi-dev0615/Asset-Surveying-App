package crc64e1247576af304310;

import com.devexpress.dxcharts.ColoredStackedPointInfo;
import com.devexpress.dxcharts.LegendItemProvider;
import com.devexpress.dxcharts.StackedCustomPointColorizer;
import com.devexpress.dxcharts.StackedPointColorizer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class StackedPointCustomColorizer implements IGCUserPeer, StackedCustomPointColorizer, StackedPointColorizer {
    public static final String __md_methods = "n_getLegendItemProvider:()Lcom/devexpress/dxcharts/LegendItemProvider;:GetGetLegendItemProviderHandler:DevExpress.Android.Charts.IStackedCustomPointColorizerInvoker, DXCharts.a\nn_getColor:(Lcom/devexpress/dxcharts/ColoredStackedPointInfo;)I:GetGetColor_Lcom_devexpress_dxcharts_ColoredStackedPointInfo_Handler:DevExpress.Android.Charts.IStackedCustomPointColorizerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native int n_getColor(ColoredStackedPointInfo coloredStackedPointInfo);

    private native LegendItemProvider n_getLegendItemProvider();

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.StackedPointCustomColorizer, DevExpress.Maui.Charts", StackedPointCustomColorizer.class, __md_methods);
    }

    public StackedPointCustomColorizer() {
        if (getClass() == StackedPointCustomColorizer.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.StackedPointCustomColorizer, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.StackedCustomPointColorizer
    public LegendItemProvider getLegendItemProvider() {
        return n_getLegendItemProvider();
    }

    @Override // com.devexpress.dxcharts.StackedCustomPointColorizer
    public int getColor(ColoredStackedPointInfo coloredStackedPointInfo) {
        return n_getColor(coloredStackedPointInfo);
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
