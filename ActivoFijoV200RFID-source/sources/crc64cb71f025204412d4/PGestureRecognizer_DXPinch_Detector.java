package crc64cb71f025204412d4;

import android.content.Context;
import android.os.Handler;
import android.view.ScaleGestureDetector;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PGestureRecognizer_DXPinch_Detector extends ScaleGestureDetector implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXPinch+Detector, DevExpress.Maui.Core", PGestureRecognizer_DXPinch_Detector.class, "");
    }

    public PGestureRecognizer_DXPinch_Detector(Context context, ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener, Handler handler) {
        super(context, onScaleGestureListener, handler);
        if (getClass() == PGestureRecognizer_DXPinch_Detector.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXPinch+Detector, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Views.ScaleGestureDetector+IOnScaleGestureListener, Mono.Android:Android.OS.Handler, Mono.Android", this, new Object[]{context, onScaleGestureListener, handler});
        }
    }

    public PGestureRecognizer_DXPinch_Detector(Context context, ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        super(context, onScaleGestureListener);
        if (getClass() == PGestureRecognizer_DXPinch_Detector.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PGestureRecognizer+DXPinch+Detector, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Views.ScaleGestureDetector+IOnScaleGestureListener, Mono.Android", this, new Object[]{context, onScaleGestureListener});
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
