package crc64cb71f025204412d4;

import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PGestureRecognizer_DXTap_Listener extends GestureDetector.SimpleOnGestureListener implements IGCUserPeer {
    public static final String __md_methods = "n_onDown:(Landroid/view/MotionEvent;)Z:GetOnDown_Landroid_view_MotionEvent_Handler\nn_onSingleTapUp:(Landroid/view/MotionEvent;)Z:GetOnSingleTapUp_Landroid_view_MotionEvent_Handler\nn_onDoubleTap:(Landroid/view/MotionEvent;)Z:GetOnDoubleTap_Landroid_view_MotionEvent_Handler\nn_onLongPress:(Landroid/view/MotionEvent;)V:GetOnLongPress_Landroid_view_MotionEvent_Handler\n";
    private ArrayList refList;

    private native boolean n_onDoubleTap(MotionEvent motionEvent);

    private native boolean n_onDown(MotionEvent motionEvent);

    private native void n_onLongPress(MotionEvent motionEvent);

    private native boolean n_onSingleTapUp(MotionEvent motionEvent);

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXTap+Listener, DevExpress.Maui.Core", PGestureRecognizer_DXTap_Listener.class, __md_methods);
    }

    public PGestureRecognizer_DXTap_Listener() {
        if (getClass() == PGestureRecognizer_DXTap_Listener.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXTap+Listener, DevExpress.Maui.Core", "", this, new Object[0]);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return n_onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return n_onSingleTapUp(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return n_onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        n_onLongPress(motionEvent);
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
