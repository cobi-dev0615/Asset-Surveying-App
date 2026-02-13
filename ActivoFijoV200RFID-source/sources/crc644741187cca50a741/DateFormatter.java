package crc644741187cca50a741;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DateFormatter implements IGCUserPeer, com.devexpress.editors.DateFormatter {
    public static final String __md_methods = "n_format:(III)Ljava/lang/CharSequence;:GetFormat_IIIHandler:DevExpress.Android.Editors.IDateFormatterInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native CharSequence n_format(int i, int i2, int i3);

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.DateFormatter, DevExpress.Maui.Editors", DateFormatter.class, __md_methods);
    }

    public DateFormatter() {
        if (getClass() == DateFormatter.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.DateFormatter, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.DateFormatter
    public CharSequence format(int i, int i2, int i3) {
        return n_format(i, i2, i3);
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
