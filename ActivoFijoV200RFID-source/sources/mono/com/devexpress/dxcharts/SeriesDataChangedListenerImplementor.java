package mono.com.devexpress.dxcharts;

import com.devexpress.dxcharts.SeriesDataChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SeriesDataChangedListenerImplementor implements IGCUserPeer, SeriesDataChangedListener {
    public static final String __md_methods = "n_onItemAdded:()V:GetOnItemAddedHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onItemChanged:(I)V:GetOnItemChanged_IHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onItemInserted:(I)V:GetOnItemInserted_IHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onItemRemoved:(I)V:GetOnItemRemoved_IHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onItemsAdded:(I)V:GetOnItemsAdded_IHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onItemsChanged:(II)V:GetOnItemsChanged_IIHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onItemsInserted:(II)V:GetOnItemsInserted_IIHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onItemsRemoved:(II)V:GetOnItemsRemoved_IIHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\nn_onReloaded:()V:GetOnReloadedHandler:DevExpress.Android.Charts.ISeriesDataChangedListenerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native void n_onItemAdded();

    private native void n_onItemChanged(int i);

    private native void n_onItemInserted(int i);

    private native void n_onItemRemoved(int i);

    private native void n_onItemsAdded(int i);

    private native void n_onItemsChanged(int i, int i2);

    private native void n_onItemsInserted(int i, int i2);

    private native void n_onItemsRemoved(int i, int i2);

    private native void n_onReloaded();

    static {
        Runtime.register("DevExpress.Android.Charts.ISeriesDataChangedListenerImplementor, DXCharts.a", SeriesDataChangedListenerImplementor.class, __md_methods);
    }

    public SeriesDataChangedListenerImplementor() {
        if (getClass() == SeriesDataChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Charts.ISeriesDataChangedListenerImplementor, DXCharts.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemAdded() {
        n_onItemAdded();
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemChanged(int i) {
        n_onItemChanged(i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemInserted(int i) {
        n_onItemInserted(i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemRemoved(int i) {
        n_onItemRemoved(i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsAdded(int i) {
        n_onItemsAdded(i);
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsChanged(int i, int i2) {
        n_onItemsChanged(i, i2);
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsInserted(int i, int i2) {
        n_onItemsInserted(i, i2);
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onItemsRemoved(int i, int i2) {
        n_onItemsRemoved(i, i2);
    }

    @Override // com.devexpress.dxcharts.SeriesDataChangedListener
    public void onReloaded() {
        n_onReloaded();
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
