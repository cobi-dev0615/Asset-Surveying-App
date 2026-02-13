package crc646b09977338b7360e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXBottomSheetDialog_ContentContainer extends ViewGroup implements IGCUserPeer {
    public static final String __md_methods = "n_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\n";
    private ArrayList refList;

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMeasure(int i, int i2);

    static {
        Runtime.register("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog+ContentContainer, DevExpress.Maui.Controls", DXBottomSheetDialog_ContentContainer.class, "n_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\n");
    }

    public DXBottomSheetDialog_ContentContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getClass() == DXBottomSheetDialog_ContentContainer.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog+ContentContainer, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public DXBottomSheetDialog_ContentContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getClass() == DXBottomSheetDialog_ContentContainer.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog+ContentContainer, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public DXBottomSheetDialog_ContentContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getClass() == DXBottomSheetDialog_ContentContainer.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog+ContentContainer, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new Object[]{context, attributeSet});
        }
    }

    public DXBottomSheetDialog_ContentContainer(Context context) {
        super(context);
        if (getClass() == DXBottomSheetDialog_ContentContainer.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog+ContentContainer, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        n_onMeasure(i, i2);
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
