package crc64e1247576af304310;

import com.devexpress.dxcharts.IndexBasedCustomPointColorizer;
import com.devexpress.dxcharts.LegendItemProvider;
import com.devexpress.dxcharts.PointColorizer;
import com.devexpress.dxcharts.RangePointColorizer;
import com.devexpress.dxcharts.StackedPointColorizer;
import com.devexpress.dxcharts.WeightedPointColorizer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class IndexBasedCustomColorizerNative implements IGCUserPeer, IndexBasedCustomPointColorizer, PointColorizer, RangePointColorizer, StackedPointColorizer, WeightedPointColorizer {
    public static final String __md_methods = "n_getLegendItemProvider:()Lcom/devexpress/dxcharts/LegendItemProvider;:GetGetLegendItemProviderHandler:DevExpress.Android.Charts.IIndexBasedCustomPointColorizerInvoker, DXCharts.a\nn_getColor:(I)I:GetGetColor_IHandler:DevExpress.Android.Charts.IIndexBasedCustomPointColorizerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native int n_getColor(int i);

    private native LegendItemProvider n_getLegendItemProvider();

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.IndexBasedCustomColorizerNative, DevExpress.Maui.Charts", IndexBasedCustomColorizerNative.class, __md_methods);
    }

    public IndexBasedCustomColorizerNative() {
        if (getClass() == IndexBasedCustomColorizerNative.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.IndexBasedCustomColorizerNative, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.IndexBasedCustomPointColorizer
    public LegendItemProvider getLegendItemProvider() {
        return n_getLegendItemProvider();
    }

    @Override // com.devexpress.dxcharts.IndexBasedCustomPointColorizer
    public int getColor(int i) {
        return n_getColor(i);
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
