package mono.com.devexpress.dxcharts;

import com.devexpress.dxcharts.SelectionChangedInfo;
import com.devexpress.dxcharts.SelectionChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class SelectionChangedListenerImplementor implements IGCUserPeer, SelectionChangedListener {
    public static final String __md_methods = "n_onSelectionChanged:(Lcom/devexpress/dxcharts/SelectionChangedInfo;)V:GetOnSelectionChanged_Lcom_devexpress_dxcharts_SelectionChangedInfo_Handler:DevExpress.Android.Charts.ISelectionChangedListenerInvoker, DXCharts.a\n";
    private ArrayList refList;

    private native void n_onSelectionChanged(SelectionChangedInfo selectionChangedInfo);

    static {
        Runtime.register("DevExpress.Android.Charts.ISelectionChangedListenerImplementor, DXCharts.a", SelectionChangedListenerImplementor.class, __md_methods);
    }

    public SelectionChangedListenerImplementor() {
        if (getClass() == SelectionChangedListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Charts.ISelectionChangedListenerImplementor, DXCharts.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.SelectionChangedListener
    public void onSelectionChanged(SelectionChangedInfo selectionChangedInfo) {
        n_onSelectionChanged(selectionChangedInfo);
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
