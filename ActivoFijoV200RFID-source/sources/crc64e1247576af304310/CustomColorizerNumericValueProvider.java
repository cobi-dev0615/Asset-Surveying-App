package crc64e1247576af304310;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CustomColorizerNumericValueProvider implements IGCUserPeer, com.devexpress.dxcharts.CustomColorizerNumericValueProvider {
    public static final String __md_methods = "n_getValueForColorizer:(I)D:GetGetValueForColorizer_IHandler:DevExpress.Android.Charts.ICustomColorizerNumericValueProviderInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native double n_getValueForColorizer(int i);

    static {
        Runtime.register("DevExpress.Maui.Charts.Android.Internal.CustomColorizerNumericValueProvider, DevExpress.Maui.Charts", CustomColorizerNumericValueProvider.class, __md_methods);
    }

    public CustomColorizerNumericValueProvider() {
        if (getClass() == CustomColorizerNumericValueProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Charts.Android.Internal.CustomColorizerNumericValueProvider, DevExpress.Maui.Charts", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.CustomColorizerNumericValueProvider
    public double getValueForColorizer(int i) {
        return n_getValueForColorizer(i);
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
