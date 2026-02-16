package crc646b09977338b7360e;

import com.devexpress.editors.dropdown.DXDropdownContainer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXPopupListenerImplementation implements IGCUserPeer, DXDropdownContainer.DropdownListener, DXDropdownContainer.DropdownAnimationListener, DXDropdownContainer.CoerceValueListener {
    public static final String __md_methods = "n_dropdownClosed:()V:GetDropdownClosedHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownOpened:()V:GetDropdownOpenedHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownResized:()V:GetDropdownResizedHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownWillClose:()Z:GetDropdownWillCloseHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_dropdownWillOpen:()Z:GetDropdownWillOpenHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownListenerInvoker, DXEditors.a\nn_closingAnimationComplete:()V:GetClosingAnimationCompleteHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\nn_closingAnimationWillStart:()V:GetClosingAnimationWillStartHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\nn_openingAnimationComplete:()V:GetOpeningAnimationCompleteHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\nn_openingAnimationWillStart:()V:GetOpeningAnimationWillStartHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\nn_coerceIsDropdownOpen:()V:GetCoerceIsDropdownOpenHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/ICoerceValueListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_closingAnimationComplete();

    private native void n_closingAnimationWillStart();

    private native void n_coerceIsDropdownOpen();

    private native void n_dropdownClosed();

    private native void n_dropdownOpened();

    private native void n_dropdownResized();

    private native boolean n_dropdownWillClose();

    private native boolean n_dropdownWillOpen();

    private native void n_openingAnimationComplete();

    private native void n_openingAnimationWillStart();

    static {
        Runtime.register("DevExpress.Maui.Controls.Internal.DXPopupListenerImplementation, DevExpress.Maui.Controls", DXPopupListenerImplementation.class, __md_methods);
    }

    public DXPopupListenerImplementation() {
        if (getClass() == DXPopupListenerImplementation.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXPopupListenerImplementation, DevExpress.Maui.Controls", "", this, new Object[0]);
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

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
    public void closingAnimationComplete() {
        n_closingAnimationComplete();
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
    public void closingAnimationWillStart() {
        n_closingAnimationWillStart();
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
    public void openingAnimationComplete() {
        n_openingAnimationComplete();
    }

    @Override // com.devexpress.editors.dropdown.DXDropdownContainer.DropdownAnimationListener
    public void openingAnimationWillStart() {
        n_openingAnimationWillStart();
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
