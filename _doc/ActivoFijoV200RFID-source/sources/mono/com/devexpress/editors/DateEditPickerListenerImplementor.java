package mono.com.devexpress.editors;

import com.devexpress.editors.DateEditPickerListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DateEditPickerListenerImplementor implements IGCUserPeer, DateEditPickerListener {
    public static final String __md_methods = "n_dismiss:()V:GetDismissHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\nn_show:()V:GetShowHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_dismiss();

    private native void n_show();

    static {
        Runtime.register("DevExpress.Android.Editors.IDateEditPickerListenerImplementor, DXEditors.a", DateEditPickerListenerImplementor.class, "n_dismiss:()V:GetDismissHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\nn_show:()V:GetShowHandler:DevExpress.Android.Editors.IDateEditPickerListenerInvoker, DXEditors.a\n");
    }

    public DateEditPickerListenerImplementor() {
        if (getClass() == DateEditPickerListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.IDateEditPickerListenerImplementor, DXEditors.a", "", this, new Object[0]);
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
