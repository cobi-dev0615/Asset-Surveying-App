package crc646b09977338b7360e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class EmptyView extends View implements IGCUserPeer {
    public static final String __md_methods = "n_getVisibility:()I:GetGetVisibilityHandler\nn_setVisibility:(I)V:GetSetVisibility_IHandler\nn_getAlpha:()F:GetGetAlphaHandler\nn_setAlpha:(F)V:GetSetAlpha_FHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\nn_setBackgroundColor:(I)V:GetSetBackgroundColor_IHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\n";
    private ArrayList refList;

    private native float n_getAlpha();

    private native int n_getVisibility();

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMeasure(int i, int i2);

    private native void n_setAlpha(float f);

    private native void n_setBackgroundColor(int i);

    private native void n_setVisibility(int i);

    static {
        Runtime.register("DevExpress.Maui.Controls.Internal.EmptyView, DevExpress.Maui.Controls", EmptyView.class, __md_methods);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getClass() == EmptyView.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.EmptyView, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getClass() == EmptyView.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.EmptyView, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getClass() == EmptyView.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.EmptyView, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new Object[]{context, attributeSet});
        }
    }

    public EmptyView(Context context) {
        super(context);
        if (getClass() == EmptyView.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.EmptyView, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    @Override // android.view.View
    public int getVisibility() {
        return n_getVisibility();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        n_setVisibility(i);
    }

    @Override // android.view.View
    public float getAlpha() {
        return n_getAlpha();
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        n_setAlpha(f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        n_onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        n_setBackgroundColor(i);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
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
