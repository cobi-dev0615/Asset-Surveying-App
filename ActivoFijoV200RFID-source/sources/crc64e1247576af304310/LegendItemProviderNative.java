package crc64e1247576af304310;

import com.devexpress.dxcharts.CustomLegendItem;
import com.devexpress.dxcharts.LegendItemProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class LegendItemProviderNative implements IGCUserPeer, LegendItemProvider {
    public static final String __md_methods = "n_getLegendItemCount:()I:GetGetLegendItemCountHandler:DevExpress.Android.Charts.ILegendItemProviderInvoker, DXCharts.a\nn_getLegendItem:(I)Lcom/devexpress/dxcharts/CustomLegendItem;:GetGetLegendItem_IHandler:DevExpress.Android.Charts.ILegendItemProviderInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native CustomLegendItem n_getLegendItem(int i);

    private native int n_getLegendItemCount();

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.LegendItemProviderNative, DevExpress.Maui.Charts", LegendItemProviderNative.class, __md_methods);
    }

    public LegendItemProviderNative() {
        if (getClass() == LegendItemProviderNative.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.LegendItemProviderNative, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.LegendItemProvider
    public int getLegendItemCount() {
        return n_getLegendItemCount();
    }

    @Override // com.devexpress.dxcharts.LegendItemProvider
    public CustomLegendItem getLegendItem(int i) {
        return n_getLegendItem(i);
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
