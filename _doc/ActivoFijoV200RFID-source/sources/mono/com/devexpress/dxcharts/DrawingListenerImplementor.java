package mono.com.devexpress.dxcharts;

import com.devexpress.dxcharts.DrawingListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DrawingListenerImplementor implements IGCUserPeer, DrawingListener {
    public static final String __md_methods = "n_onDrawingFinished:()V:GetOnDrawingFinishedHandler:DevExpress.Android.Charts.IDrawingListenerInvoker, DXCharts.a\nn_onDrawingStarted:()V:GetOnDrawingStartedHandler:DevExpress.Android.Charts.IDrawingListenerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native void n_onDrawingFinished();

    private native void n_onDrawingStarted();

    static {
        Runtime.register("DevExpress.Android.Charts.IDrawingListenerImplementor, DXCharts.a", DrawingListenerImplementor.class, __md_methods);
    }

    public DrawingListenerImplementor() {
        if (getClass() == DrawingListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Charts.IDrawingListenerImplementor, DXCharts.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.DrawingListener
    public void onDrawingFinished() {
        n_onDrawingFinished();
    }

    @Override // com.devexpress.dxcharts.DrawingListener
    public void onDrawingStarted() {
        n_onDrawingStarted();
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
