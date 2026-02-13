package mono.com.devexpress.editors.dropdown;

import com.devexpress.editors.dropdown.DXDropdownContainer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXDropdownContainer_CoerceValueListenerImplementor implements IGCUserPeer, DXDropdownContainer.CoerceValueListener {
    public static final String __md_methods = "n_coerceIsDropdownOpen:()V:GetCoerceIsDropdownOpenHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/ICoerceValueListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_coerceIsDropdownOpen();

    static {
        Runtime.register("DevExpress.Android.Editors.Dropdown.DXDropdownContainer+ICoerceValueListenerImplementor, DXEditors.a", DXDropdownContainer_CoerceValueListenerImplementor.class, __md_methods);
    }

    public DXDropdownContainer_CoerceValueListenerImplementor() {
        if (getClass() == DXDropdownContainer_CoerceValueListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.Dropdown.DXDropdownContainer+ICoerceValueListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.CoerceValueListener
    public void coerceIsDropdownOpen() {
        n_coerceIsDropdownOpen();
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
