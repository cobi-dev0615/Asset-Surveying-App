package crc646b09977338b7360e;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class BottomSheetDialogCallback extends BottomSheetBehavior.BottomSheetCallback implements IGCUserPeer {
    public static final String __md_methods = "n_onSlide:(Landroid/view/View;F)V:GetOnSlide_Landroid_view_View_FHandler\nn_onStateChanged:(Landroid/view/View;I)V:GetOnStateChanged_Landroid_view_View_IHandler\n";
    private ArrayList refList;

    private native void n_onSlide(View view, float f);

    private native void n_onStateChanged(View view, int i);

    static {
        Runtime.register("DevExpress.Maui.Controls.Internal.BottomSheetDialogCallback, DevExpress.Maui.Controls", BottomSheetDialogCallback.class, __md_methods);
    }

    public BottomSheetDialogCallback() {
        if (getClass() == BottomSheetDialogCallback.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.BottomSheetDialogCallback, DevExpress.Maui.Controls", "", this, new Object[0]);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(View view, float f) {
        n_onSlide(view, f);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onStateChanged(View view, int i) {
        n_onStateChanged(view, i);
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
