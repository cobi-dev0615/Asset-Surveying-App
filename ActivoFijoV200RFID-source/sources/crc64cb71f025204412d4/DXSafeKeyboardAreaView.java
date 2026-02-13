package crc64cb71f025204412d4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXSafeKeyboardAreaView extends PView implements IGCUserPeer {
    public static final String __md_methods = "n_dispatchVisibilityChanged:(Landroid/view/View;I)V:GetDispatchVisibilityChanged_Landroid_view_View_IHandler\n";
    private ArrayList refList;

    private native void n_dispatchVisibilityChanged(View view, int i);

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.DXSafeKeyboardAreaView, DevExpress.Maui.Core", DXSafeKeyboardAreaView.class, __md_methods);
    }

    public DXSafeKeyboardAreaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getClass() == DXSafeKeyboardAreaView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.DXSafeKeyboardAreaView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public DXSafeKeyboardAreaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getClass() == DXSafeKeyboardAreaView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.DXSafeKeyboardAreaView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public DXSafeKeyboardAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getClass() == DXSafeKeyboardAreaView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.DXSafeKeyboardAreaView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new Object[]{context, attributeSet});
        }
    }

    public DXSafeKeyboardAreaView(Context context) {
        super(context);
        if (getClass() == DXSafeKeyboardAreaView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.DXSafeKeyboardAreaView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchVisibilityChanged(View view, int i) {
        n_dispatchVisibilityChanged(view, i);
    }

    @Override // crc64cb71f025204412d4.PView, crc647a19118a24842bb1.DiagnosticViewGroup, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64cb71f025204412d4.PView, crc647a19118a24842bb1.DiagnosticViewGroup, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
