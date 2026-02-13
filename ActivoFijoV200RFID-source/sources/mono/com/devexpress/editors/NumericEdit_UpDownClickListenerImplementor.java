package mono.com.devexpress.editors;

import com.devexpress.editors.NumericEdit;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class NumericEdit_UpDownClickListenerImplementor implements IGCUserPeer, NumericEdit.UpDownClickListener {
    public static final String __md_methods = "n_clearClicked:()V:GetClearClickedHandler:DevExpress.Android.Editors.NumericEdit/IUpDownClickListenerInvoker, DXEditors.a\nn_downClicked:()V:GetDownClickedHandler:DevExpress.Android.Editors.NumericEdit/IUpDownClickListenerInvoker, DXEditors.a\nn_upClicked:()V:GetUpClickedHandler:DevExpress.Android.Editors.NumericEdit/IUpDownClickListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_clearClicked();

    private native void n_downClicked();

    private native void n_upClicked();

    static {
        Runtime.register("DevExpress.Android.Editors.NumericEdit+IUpDownClickListenerImplementor, DXEditors.a", NumericEdit_UpDownClickListenerImplementor.class, __md_methods);
    }

    public NumericEdit_UpDownClickListenerImplementor() {
        if (getClass() == NumericEdit_UpDownClickListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.NumericEdit+IUpDownClickListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.NumericEdit.UpDownClickListener
    public void clearClicked() {
        n_clearClicked();
    }

    @Override // com.devexpress.editors.NumericEdit.UpDownClickListener
    public void downClicked() {
        n_downClicked();
    }

    @Override // com.devexpress.editors.NumericEdit.UpDownClickListener
    public void upClicked() {
        n_upClicked();
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
