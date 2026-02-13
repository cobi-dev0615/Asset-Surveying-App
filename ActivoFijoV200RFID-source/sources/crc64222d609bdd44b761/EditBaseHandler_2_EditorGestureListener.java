package crc64222d609bdd44b761;

import com.devexpress.editors.BaseGestureListener;
import com.devexpress.editors.EditorGestureListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class EditBaseHandler_2_EditorGestureListener implements IGCUserPeer, EditorGestureListener, BaseGestureListener {
    public static final String __md_methods = "n_onDoubleTap:()Z:GetOnDoubleTapHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\nn_onLongPress:()Z:GetOnLongPressHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\nn_onSingleTapUp:()Z:GetOnSingleTapUpHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_onDoubleTap();

    private native boolean n_onLongPress();

    private native boolean n_onSingleTapUp();

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.EditBaseHandler`2+EditorGestureListener, DevExpress.Maui.Editors", EditBaseHandler_2_EditorGestureListener.class, "n_onDoubleTap:()Z:GetOnDoubleTapHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\nn_onLongPress:()Z:GetOnLongPressHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\nn_onSingleTapUp:()Z:GetOnSingleTapUpHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\n");
    }

    public EditBaseHandler_2_EditorGestureListener() {
        if (getClass() == EditBaseHandler_2_EditorGestureListener.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.EditBaseHandler`2+EditorGestureListener, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.BaseGestureListener
    public boolean onDoubleTap() {
        return n_onDoubleTap();
    }

    @Override // com.devexpress.editors.BaseGestureListener
    public boolean onLongPress() {
        return n_onLongPress();
    }

    @Override // com.devexpress.editors.BaseGestureListener
    public boolean onSingleTapUp() {
        return n_onSingleTapUp();
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
