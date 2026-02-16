package mono.com.devexpress.editors;

import com.devexpress.editors.TimeEdit;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TimeEdit_TimeChangedListenerImplementor implements IGCUserPeer, TimeEdit.TimeChangedListener {
    public static final String __md_methods = "n_onTimeChanged:(Lcom/devexpress/editors/TimeEdit;II)V:GetOnTimeChanged_Lcom_devexpress_editors_TimeEdit_IIHandler:DevExpress.Android.Editors.TimeEdit/ITimeChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onTimeChanged(TimeEdit timeEdit, int i, int i2);

    static {
        Runtime.register("DevExpress.Android.Editors.TimeEdit+ITimeChangedListenerImplementor, DXEditors.a", TimeEdit_TimeChangedListenerImplementor.class, __md_methods);
    }

    public TimeEdit_TimeChangedListenerImplementor() {
        if (getClass() == TimeEdit_TimeChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.TimeEdit+ITimeChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.TimeEdit.TimeChangedListener
    public void onTimeChanged(TimeEdit timeEdit, int i, int i2) {
        n_onTimeChanged(timeEdit, i, i2);
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
