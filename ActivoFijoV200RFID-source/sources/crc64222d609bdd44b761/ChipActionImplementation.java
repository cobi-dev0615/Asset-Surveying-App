package crc64222d609bdd44b761;

import com.devexpress.editors.BaseGestureListener;
import com.devexpress.editors.ChipAction;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ChipActionImplementation implements IGCUserPeer, ChipAction, BaseGestureListener {
    public static final String __md_methods = "n_onCloseIconTap:()Z:GetOnCloseIconTapHandler:DevExpress.Android.Editors.IChipActionInvoker, DXEditors.a\nn_onLayoutChanged:()V:GetOnLayoutChangedHandler:DevExpress.Android.Editors.IChipActionInvoker, DXEditors.a\nn_onSingleTapConfirmed:()Z:GetOnSingleTapConfirmedHandler:DevExpress.Android.Editors.IChipActionInvoker, DXEditors.a\nn_onDoubleTap:()Z:GetOnDoubleTapHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\nn_onLongPress:()Z:GetOnLongPressHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\nn_onSingleTapUp:()Z:GetOnSingleTapUpHandler:DevExpress.Android.Editors.IBaseGestureListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_onCloseIconTap();

    private native boolean n_onDoubleTap();

    private native void n_onLayoutChanged();

    private native boolean n_onLongPress();

    private native boolean n_onSingleTapConfirmed();

    private native boolean n_onSingleTapUp();

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.ChipActionImplementation, DevExpress.Maui.Editors", ChipActionImplementation.class, __md_methods);
    }

    public ChipActionImplementation() {
        if (getClass() == ChipActionImplementation.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.ChipActionImplementation, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.ChipAction
    public boolean onCloseIconTap() {
        return n_onCloseIconTap();
    }

    @Override // com.devexpress.editors.ChipAction
    public void onLayoutChanged() {
        n_onLayoutChanged();
    }

    @Override // com.devexpress.editors.ChipAction
    public boolean onSingleTapConfirmed() {
        return n_onSingleTapConfirmed();
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
