package crc64a59bfe4fc515a8dd;

import android.content.Context;
import android.util.AttributeSet;
import crc647a19118a24842bb1.DXViewContainer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXGridViewContainer extends DXViewContainer implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.DataGrid.Android.Internal.DXGridViewContainer, DevExpress.Maui.DataGrid", DXGridViewContainer.class, "");
    }

    public DXGridViewContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getClass() == DXGridViewContainer.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.DXGridViewContainer, DevExpress.Maui.DataGrid", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public DXGridViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getClass() == DXGridViewContainer.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.DXGridViewContainer, DevExpress.Maui.DataGrid", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public DXGridViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getClass() == DXGridViewContainer.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.DXGridViewContainer, DevExpress.Maui.DataGrid", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new Object[]{context, attributeSet});
        }
    }

    public DXGridViewContainer(Context context) {
        super(context);
        if (getClass() == DXGridViewContainer.class) {
            TypeManager.Activate("DevExpress.Maui.DataGrid.Android.Internal.DXGridViewContainer, DevExpress.Maui.DataGrid", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    @Override // crc647a19118a24842bb1.DXViewContainer, crc647a19118a24842bb1.DiagnosticViewGroup, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc647a19118a24842bb1.DXViewContainer, crc647a19118a24842bb1.DiagnosticViewGroup, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
