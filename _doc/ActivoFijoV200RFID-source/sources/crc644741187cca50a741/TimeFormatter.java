package crc644741187cca50a741;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TimeFormatter implements IGCUserPeer, com.devexpress.editors.TimeFormatter {
    public static final String __md_methods = "n_format:(IIZ)Ljava/lang/CharSequence;:GetFormat_IIZHandler:DevExpress.Android.Editors.ITimeFormatterInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native CharSequence n_format(int i, int i2, boolean z);

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.TimeFormatter, DevExpress.Maui.Editors", TimeFormatter.class, __md_methods);
    }

    public TimeFormatter() {
        if (getClass() == TimeFormatter.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.TimeFormatter, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.TimeFormatter
    public CharSequence format(int i, int i2, boolean z) {
        return n_format(i, i2, z);
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
