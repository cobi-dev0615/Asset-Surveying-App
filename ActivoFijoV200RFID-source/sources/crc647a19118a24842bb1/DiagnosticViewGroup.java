package crc647a19118a24842bb1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public abstract class DiagnosticViewGroup extends ViewGroup implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.Core.Internal.DiagnosticViewGroup, DevExpress.Maui.Core", DiagnosticViewGroup.class, "");
    }

    public DiagnosticViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getClass() == DiagnosticViewGroup.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Internal.DiagnosticViewGroup, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public DiagnosticViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getClass() == DiagnosticViewGroup.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Internal.DiagnosticViewGroup, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public DiagnosticViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getClass() == DiagnosticViewGroup.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Internal.DiagnosticViewGroup, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new Object[]{context, attributeSet});
        }
    }

    public DiagnosticViewGroup(Context context) {
        super(context);
        if (getClass() == DiagnosticViewGroup.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Internal.DiagnosticViewGroup, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
