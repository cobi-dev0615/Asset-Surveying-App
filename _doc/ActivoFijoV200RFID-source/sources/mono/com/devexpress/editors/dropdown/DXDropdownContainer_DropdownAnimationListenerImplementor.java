package mono.com.devexpress.editors.dropdown;

import com.devexpress.editors.dropdown.DXDropdownContainer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXDropdownContainer_DropdownAnimationListenerImplementor implements IGCUserPeer, DXDropdownContainer.DropdownAnimationListener {
    public static final String __md_methods = "n_closingAnimationComplete:()V:GetClosingAnimationCompleteHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\nn_closingAnimationWillStart:()V:GetClosingAnimationWillStartHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\nn_openingAnimationComplete:()V:GetOpeningAnimationCompleteHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\nn_openingAnimationWillStart:()V:GetOpeningAnimationWillStartHandler:DevExpress.Android.Editors.Dropdown.DXDropdownContainer/IDropdownAnimationListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_closingAnimationComplete();

    private native void n_closingAnimationWillStart();

    private native void n_openingAnimationComplete();

    private native void n_openingAnimationWillStart();

    static {
        Runtime.register("DevExpress.Android.Editors.Dropdown.DXDropdownContainer+IDropdownAnimationListenerImplementor, DXEditors.a", DXDropdownContainer_DropdownAnimationListenerImplementor.class, __md_methods);
    }

    public DXDropdownContainer_DropdownAnimationListenerImplementor() {
        if (getClass() == DXDropdownContainer_DropdownAnimationListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.Dropdown.DXDropdownContainer+IDropdownAnimationListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
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
