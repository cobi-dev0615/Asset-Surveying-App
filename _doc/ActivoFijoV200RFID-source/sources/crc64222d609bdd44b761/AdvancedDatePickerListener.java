package crc64222d609bdd44b761;

import com.devexpress.editors.DateEditPickerListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AdvancedDatePickerListener implements IGCUserPeer, DateEditPickerListener {
    public static final String __md_methods = "n_dismiss:()V:GetDismissHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\nn_show:()V:GetShowHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_dismiss();

    private native void n_show();

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.AdvancedDatePickerListener, DevExpress.Maui.Editors", AdvancedDatePickerListener.class, "n_dismiss:()V:GetDismissHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\nn_show:()V:GetShowHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\n");
    }

    public AdvancedDatePickerListener() {
        if (getClass() == AdvancedDatePickerListener.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.AdvancedDatePickerListener, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.DateEditPickerListener
    public void dismiss() {
        n_dismiss();
    }

    @Override // com.devexpress.editors.DateEditPickerListener
    public void show() {
        n_show();
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
