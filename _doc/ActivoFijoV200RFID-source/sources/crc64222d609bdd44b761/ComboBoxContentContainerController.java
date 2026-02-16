package crc64222d609bdd44b761;

import com.devexpress.editors.ContentContainerControllerListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ComboBoxContentContainerController implements IGCUserPeer, ContentContainerControllerListener {
    public static final String __md_methods = "n_isOpened:()Z:GetIsOpenedHandler:DevExpress.Android.Editors.IContentContainerControllerListenerInvoker, DXEditors.a\nn_close:(Z)Z:GetClose_ZHandler:DevExpress.Android.Editors.IContentContainerControllerListenerInvoker, DXEditors.a\nn_show:()V:GetShowHandler:DevExpress.Android.Editors.IContentContainerControllerListenerInvoker, DXEditors.a\nn_update:()V:GetUpdateHandler:DevExpress.Android.Editors.IContentContainerControllerListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_close(boolean z);

    private native boolean n_isOpened();

    private native void n_show();

    private native void n_update();

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.ComboBoxContentContainerController, DevExpress.Maui.Editors", ComboBoxContentContainerController.class, __md_methods);
    }

    public ComboBoxContentContainerController() {
        if (getClass() == ComboBoxContentContainerController.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.ComboBoxContentContainerController, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.ContentContainerControllerListener
    public boolean isOpened() {
        return n_isOpened();
    }

    @Override // com.devexpress.editors.ContentContainerControllerListener
    public boolean close(boolean z) {
        return n_close(z);
    }

    @Override // com.devexpress.editors.ContentContainerControllerListener
    public void show() {
        n_show();
    }

    @Override // com.devexpress.editors.ContentContainerControllerListener
    public void update() {
        n_update();
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
