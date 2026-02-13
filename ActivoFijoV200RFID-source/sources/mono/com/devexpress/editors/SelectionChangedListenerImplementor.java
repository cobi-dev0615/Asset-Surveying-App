package mono.com.devexpress.editors;

import com.devexpress.editors.SelectionChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SelectionChangedListenerImplementor implements IGCUserPeer, SelectionChangedListener {
    public static final String __md_methods = "n_onSelectionChanged:(II)V:GetOnSelectionChanged_IIHandler:DevExpress.Android.Editors.ISelectionChangedListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onSelectionChanged(int i, int i2);

    static {
        Runtime.register("DevExpress.Android.Editors.ISelectionChangedListenerImplementor, DXEditors.a", SelectionChangedListenerImplementor.class, __md_methods);
    }

    public SelectionChangedListenerImplementor() {
        if (getClass() == SelectionChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.ISelectionChangedListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.SelectionChangedListener
    public void onSelectionChanged(int i, int i2) {
        n_onSelectionChanged(i, i2);
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
