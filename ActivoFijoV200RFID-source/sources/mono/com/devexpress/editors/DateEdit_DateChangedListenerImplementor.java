package mono.com.devexpress.editors;

import com.devexpress.editors.DateEdit;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DateEdit_DateChangedListenerImplementor implements IGCUserPeer, DateEdit.DateChangedListener {
    public static final String __md_methods = "n_onDateChanged:(Lcom/devexpress/editors/DateEdit;III)V:GetOnDateChanged_Lcom_devexpress_editors_DateEdit_IIIHandler:DevExpress.Android.Editors.DateEdit/IDateChangedListenerInvoker, DXEditors.a\nn_onMaxDateChanged:(Lcom/devexpress/editors/DateEdit;III)V:GetOnMaxDateChanged_Lcom_devexpress_editors_DateEdit_IIIHandler:DevExpress.Android.Editors.DateEdit/IDateChangedListenerInvoker, DXEditors.a\nn_onMinDateChanged:(Lcom/devexpress/editors/DateEdit;III)V:GetOnMinDateChanged_Lcom_devexpress_editors_DateEdit_IIIHandler:DevExpress.Android.Editors.DateEdit/IDateChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onDateChanged(DateEdit dateEdit, int i, int i2, int i3);

    private native void n_onMaxDateChanged(DateEdit dateEdit, int i, int i2, int i3);

    private native void n_onMinDateChanged(DateEdit dateEdit, int i, int i2, int i3);

    static {
        Runtime.register("DevExpress.Android.Editors.DateEdit+IDateChangedListenerImplementor, DXEditors.a", DateEdit_DateChangedListenerImplementor.class, __md_methods);
    }

    public DateEdit_DateChangedListenerImplementor() {
        if (getClass() == DateEdit_DateChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.DateEdit+IDateChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.DateEdit.DateChangedListener
    public void onDateChanged(DateEdit dateEdit, int i, int i2, int i3) {
        n_onDateChanged(dateEdit, i, i2, i3);
    }

    @Override // com.devexpress.editors.DateEdit.DateChangedListener
    public void onMaxDateChanged(DateEdit dateEdit, int i, int i2, int i3) {
        n_onMaxDateChanged(dateEdit, i, i2, i3);
    }

    @Override // com.devexpress.editors.DateEdit.DateChangedListener
    public void onMinDateChanged(DateEdit dateEdit, int i, int i2, int i3) {
        n_onMinDateChanged(dateEdit, i, i2, i3);
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
