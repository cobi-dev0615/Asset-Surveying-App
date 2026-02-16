package mono.com.devexpress.dxgrid.utils;

import com.devexpress.dxgrid.utils.OnSwipeOffsetChangeListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class OnSwipeOffsetChangeListenerImplementor implements IGCUserPeer, OnSwipeOffsetChangeListener {
    public static final String __md_methods = "n_rowSwipeOffsetChanged:()V:GetRowSwipeOffsetChangedHandler:DevExpress.Android.Grid.Utils.IOnSwipeOffsetChangeListenerInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native void n_rowSwipeOffsetChanged();

    static {
        Runtime.register("DevExpress.Android.Grid.Utils.IOnSwipeOffsetChangeListenerImplementor, DXGrid.a", OnSwipeOffsetChangeListenerImplementor.class, __md_methods);
    }

    public OnSwipeOffsetChangeListenerImplementor() {
        if (getClass() == OnSwipeOffsetChangeListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Grid.Utils.IOnSwipeOffsetChangeListenerImplementor, DXGrid.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.utils.OnSwipeOffsetChangeListener
    public void rowSwipeOffsetChanged() {
        n_rowSwipeOffsetChanged();
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
