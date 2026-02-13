package crc644741187cca50a741;

import com.devexpress.editors.DisplayTextFormatter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DisplayTextProvider implements IGCUserPeer, DisplayTextFormatter {
    public static final String __md_methods = "n_format:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;:GetFormat_Ljava_lang_CharSequence_Ljava_lang_CharSequence_Handler:DevExpress.Android.Editors.IDisplayTextFormatterInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native CharSequence n_format(CharSequence charSequence, CharSequence charSequence2);

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.DisplayTextProvider, DevExpress.Maui.Editors", DisplayTextProvider.class, __md_methods);
    }

    public DisplayTextProvider() {
        if (getClass() == DisplayTextProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.DisplayTextProvider, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.DisplayTextFormatter
    public CharSequence format(CharSequence charSequence, CharSequence charSequence2) {
        return n_format(charSequence, charSequence2);
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
