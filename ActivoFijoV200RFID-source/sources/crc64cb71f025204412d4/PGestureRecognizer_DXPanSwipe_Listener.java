package crc64cb71f025204412d4;

import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PGestureRecognizer_DXPanSwipe_Listener extends GestureDetector.SimpleOnGestureListener implements IGCUserPeer {
    public static final String __md_methods = "n_onDown:(Landroid/view/MotionEvent;)Z:GetOnDown_Landroid_view_MotionEvent_Handler\nn_onFling:(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z:GetOnFling_Landroid_view_MotionEvent_Landroid_view_MotionEvent_FFHandler\n";
    private ArrayList refList;

    private native boolean n_onDown(MotionEvent motionEvent);

    private native boolean n_onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXPanSwipe+Listener, DevExpress.Maui.Core", PGestureRecognizer_DXPanSwipe_Listener.class, __md_methods);
    }

    public PGestureRecognizer_DXPanSwipe_Listener() {
        if (getClass() == PGestureRecognizer_DXPanSwipe_Listener.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXPanSwipe+Listener, DevExpress.Maui.Core", "", this, new Object[0]);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return n_onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return n_onFling(motionEvent, motionEvent2, f, f2);
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
