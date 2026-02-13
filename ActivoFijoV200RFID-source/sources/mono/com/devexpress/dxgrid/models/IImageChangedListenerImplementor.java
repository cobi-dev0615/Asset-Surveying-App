package mono.com.devexpress.dxgrid.models;

import com.devexpress.dxgrid.models.IImageChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class IImageChangedListenerImplementor implements IGCUserPeer, IImageChangedListener {
    public static final String __md_methods = "n_onImageChanged:()V:GetOnImageChangedHandler:DevExpress.Android.Grid.Models.IImageChangedListenerInvoker, DXGrid.a\n";
    private ArrayList refList;

    private native void n_onImageChanged();

    static {
        Runtime.register("DevExpress.Android.Grid.Models.IImageChangedListenerImplementor, DXGrid.a", IImageChangedListenerImplementor.class, __md_methods);
    }

    public IImageChangedListenerImplementor() {
        if (getClass() == IImageChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Grid.Models.IImageChangedListenerImplementor, DXGrid.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxgrid.models.IImageChangedListener
    public void onImageChanged() {
        n_onImageChanged();
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
