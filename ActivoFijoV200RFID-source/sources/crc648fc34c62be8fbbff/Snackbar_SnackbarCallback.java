package crc648fc34c62be8fbbff;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class Snackbar_SnackbarCallback extends BaseTransientBottomBar.BaseCallback implements IGCUserPeer {
    public static final String __md_methods = "n_onShown:(Ljava/lang/Object;)V:GetOnShown_Ljava_lang_Object_Handler\nn_onDismissed:(Ljava/lang/Object;I)V:GetOnDismissed_Ljava_lang_Object_IHandler\n";
    private ArrayList refList;

    private native void n_onDismissed(Object obj, int i);

    private native void n_onShown(Object obj);

    static {
        Runtime.register("CommunityToolkit.Maui.Alerts.Snackbar+SnackbarCallback, CommunityToolkit.Maui", Snackbar_SnackbarCallback.class, __md_methods);
    }

    public Snackbar_SnackbarCallback() {
        if (getClass() == Snackbar_SnackbarCallback.class) {
            TypeManager.Activate("CommunityToolkit.Maui.Alerts.Snackbar+SnackbarCallback, CommunityToolkit.Maui", "", this, new Object[0]);
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
    public void onShown(Object obj) {
        n_onShown(obj);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
    public void onDismissed(Object obj, int i) {
        n_onDismissed(obj, i);
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
