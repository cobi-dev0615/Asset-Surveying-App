package crc64e1247576af304310;

import com.devexpress.dxcharts.HintInfo;
import com.devexpress.dxcharts.HintListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ChartDelegate implements IGCUserPeer, HintListener {
    public static final String __md_methods = "n_onHide:()V:GetOnHideHandler:DevExpress.Android.Charts.IHintListenerInvoker, DXCharts.a\nn_onShow:(Lcom/devexpress/dxcharts/HintInfo;)V:GetOnShow_Lcom_devexpress_dxcharts_HintInfo_Handler:DevExpress.Android.Charts.IHintListenerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native void n_onHide();

    private native void n_onShow(HintInfo hintInfo);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.ChartDelegate, DevExpress.Maui.Charts", ChartDelegate.class, "n_onHide:()V:GetOnHideHandler:DevExpress.Android.Charts.IHintListenerInvoker, DXCharts.a\nn_onShow:(Lcom/devexpress/dxcharts/HintInfo;)V:GetOnShow_Lcom_devexpress_dxcharts_HintInfo_Handler:DevExpress.Android.Charts.IHintListenerInvoker, DXCharts.a\n");
    }

    public ChartDelegate() {
        if (getClass() == ChartDelegate.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.ChartDelegate, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.HintListener
    public void onHide() {
        n_onHide();
    }

    @Override // com.devexpress.dxcharts.HintListener
    public void onShow(HintInfo hintInfo) {
        n_onShow(hintInfo);
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
