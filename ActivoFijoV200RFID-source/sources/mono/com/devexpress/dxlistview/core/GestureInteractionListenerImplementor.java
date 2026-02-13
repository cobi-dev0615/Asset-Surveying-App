package mono.com.devexpress.dxlistview.core;

import android.view.MotionEvent;
import com.devexpress.dxlistview.core.GestureInteractionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class GestureInteractionListenerImplementor implements IGCUserPeer, GestureInteractionListener {
    public static final String __md_methods = "n_down:(Landroid/view/MotionEvent;)V:GetDown_Landroid_view_MotionEvent_Handler:DevExpress.Android.CollectionView.Core.IGestureInteractionListenerInvoker, DXCollectionView.a\nn_move:(Landroid/view/MotionEvent;)Z:GetMove_Landroid_view_MotionEvent_Handler:DevExpress.Android.CollectionView.Core.IGestureInteractionListenerInvoker, DXCollectionView.a\nn_onDoubleTap:(Landroid/view/MotionEvent;)Z:GetOnDoubleTap_Landroid_view_MotionEvent_Handler:DevExpress.Android.CollectionView.Core.IGestureInteractionListenerInvoker, DXCollectionView.a\nn_onLongPress:(Landroid/view/MotionEvent;)V:GetOnLongPress_Landroid_view_MotionEvent_Handler:DevExpress.Android.CollectionView.Core.IGestureInteractionListenerInvoker, DXCollectionView.a\nn_onSingleTapConfirmed:(Landroid/view/MotionEvent;)Z:GetOnSingleTapConfirmed_Landroid_view_MotionEvent_Handler:DevExpress.Android.CollectionView.Core.IGestureInteractionListenerInvoker, DXCollectionView.a\nn_onSingleTapUp:(Landroid/view/MotionEvent;)Z:GetOnSingleTapUp_Landroid_view_MotionEvent_Handler:DevExpress.Android.CollectionView.Core.IGestureInteractionListenerInvoker, DXCollectionView.a\nn_up:(Landroid/view/MotionEvent;)Z:GetUp_Landroid_view_MotionEvent_Handler:DevExpress.Android.CollectionView.Core.IGestureInteractionListenerInvoker, DXCollectionView.a\n";
    private ArrayList refList;

    private native void n_down(MotionEvent motionEvent);

    private native boolean n_move(MotionEvent motionEvent);

    private native boolean n_onDoubleTap(MotionEvent motionEvent);

    private native void n_onLongPress(MotionEvent motionEvent);

    private native boolean n_onSingleTapConfirmed(MotionEvent motionEvent);

    private native boolean n_onSingleTapUp(MotionEvent motionEvent);

    private native boolean n_up(MotionEvent motionEvent);

    static {
        Runtime.register("DevExpress.Android.CollectionView.Core.IGestureInteractionListenerImplementor, DXCollectionView.a", GestureInteractionListenerImplementor.class, __md_methods);
    }

    public GestureInteractionListenerImplementor() {
        if (getClass() == GestureInteractionListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.CollectionView.Core.IGestureInteractionListenerImplementor, DXCollectionView.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public void down(MotionEvent motionEvent) {
        n_down(motionEvent);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean move(MotionEvent motionEvent) {
        return n_move(motionEvent);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return n_onDoubleTap(motionEvent);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public void onLongPress(MotionEvent motionEvent) {
        n_onLongPress(motionEvent);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return n_onSingleTapConfirmed(motionEvent);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return n_onSingleTapUp(motionEvent);
    }

    @Override // com.devexpress.dxlistview.core.GestureInteractionListener
    public boolean up(MotionEvent motionEvent) {
        return n_up(motionEvent);
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
