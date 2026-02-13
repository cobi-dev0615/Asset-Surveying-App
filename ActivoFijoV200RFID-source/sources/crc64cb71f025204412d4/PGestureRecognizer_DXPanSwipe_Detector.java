package crc64cb71f025204412d4;

import android.content.Context;
import android.view.GestureDetector;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PGestureRecognizer_DXPanSwipe_Detector extends GestureDetector implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXPanSwipe+Detector, DevExpress.Maui.Core", PGestureRecognizer_DXPanSwipe_Detector.class, "");
    }

    public PGestureRecognizer_DXPanSwipe_Detector(Context context, GestureDetector.OnGestureListener onGestureListener) {
        super(context, onGestureListener);
        if (getClass() == PGestureRecognizer_DXPanSwipe_Detector.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXPanSwipe+Detector, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Views.GestureDetector+IOnGestureListener, Mono.Android", this, new Object[]{context, onGestureListener});
        }
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
