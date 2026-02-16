package mono.com.devexpress.editors.dropdown;

import com.devexpress.editors.dropdown.DXDropdownContainer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXDropdownContainer_DropdownListenerImplementor implements IGCUserPeer, DXDropdownContainer.DropdownListener {
    public static final String __md_methods = "n_dropdownClosed:()V:GetDropdownClosedHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownOpened:()V:GetDropdownOpenedHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownResized:()V:GetDropdownResizedHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownWillClose:()Z:GetDropdownWillCloseHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownWillOpen:()Z:GetDropdownWillOpenHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_dropdownClosed();

    private native void n_dropdownOpened();

    private native void n_dropdownResized();

    private native boolean n_dropdownWillClose();

    private native boolean n_dropdownWillOpen();

    static {
        Runtime.register("DevExpress.Android.Editors.Dropdown.DXDropdownContainer+IDropdownListenerImplementor, DXEditors.a", DXDropdownContainer_DropdownListenerImplementor.class, __md_methods);
    }

    public DXDropdownContainer_DropdownListenerImplementor() {
        if (getClass() == DXDropdownContainer_DropdownListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.Dropdown.DXDropdownContainer+IDropdownListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
    public void dropdownClosed() {
        n_dropdownClosed();
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
    public void dropdownOpened() {
        n_dropdownOpened();
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
    public void dropdownResized() {
        n_dropdownResized();
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
    public boolean dropdownWillClose() {
        return n_dropdownWillClose();
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownListener
    public boolean dropdownWillOpen() {
        return n_dropdownWillOpen();
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
