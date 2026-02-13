package crc644741187cca50a741;

import com.devexpress.editors.ComboBoxEdit;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ItemFormatterWrapper implements IGCUserPeer, ComboBoxEdit.Formatter {
    public static final String __md_methods = "n_format:(Ljava/lang/Object;)Ljava/lang/String;:GetFormat_Ljava_lang_Object_Handler:DevExpress.Android.Editors.ComboBoxEdit/IFormatterInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native String n_format(Object obj);

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.ItemFormatterWrapper, DevExpress.Maui.Editors", ItemFormatterWrapper.class, __md_methods);
    }

    public ItemFormatterWrapper() {
        if (getClass() == ItemFormatterWrapper.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.ItemFormatterWrapper, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.ComboBoxEdit.Formatter
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
