package crc64e1247576af304310;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AxisLabelTextFormatter implements IGCUserPeer, com.devexpress.dxcharts.AxisLabelTextFormatter {
    public static final String __md_methods = "n_format:(Ljava/lang/Object;)Ljava/lang/String;:GetFormat_Ljava_lang_Object_Handler:DevExpress.Android.Charts.IAxisLabelTextFormatterInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native String n_format(Object obj);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.AxisLabelTextFormatter, DevExpress.Maui.Charts", AxisLabelTextFormatter.class, __md_methods);
    }

    public AxisLabelTextFormatter() {
        if (getClass() == AxisLabelTextFormatter.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.AxisLabelTextFormatter, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.AxisLabelTextFormatter
    public String format(Object obj) {
        return n_format(obj);
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
