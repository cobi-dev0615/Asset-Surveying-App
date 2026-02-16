package crc64222d609bdd44b761;

import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DayOfMonthViewProvider extends CellViewProvider_2 implements IGCUserPeer, com.devexpress.editors.pickers.providers.DayOfMonthViewProvider {
    public static final String __md_methods = "n_check:(Landroid/view/View;III)Z:GetCheck_Landroid_view_View_IIIHandler:DevExpress.Android.Editors.Pickers.Providers.IDayOfMonthViewProviderInvoker, DXEditors.a\nn_recycle:(Landroid/view/View;)V:GetRecycle_Landroid_view_View_Handler:DevExpress.Android.Editors.Pickers.Providers.IDayOfMonthViewProviderInvoker, DXEditors.a\nn_request:(III)Landroid/view/View;:GetRequest_IIIHandler:DevExpress.Android.Editors.Pickers.Providers.IDayOfMonthViewProviderInvoker, DXEditors.a\nn_update:(Landroid/view/View;III)V:GetUpdate_Landroid_view_View_IIIHandler:DevExpress.Android.Editors.Pickers.Providers.IDayOfMonthViewProviderInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_check(View view, int i, int i2, int i3);

    private native void n_recycle(View view);

    private native View n_request(int i, int i2, int i3);

    private native void n_update(View view, int i, int i2, int i3);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.DayOfMonthViewProvider, DevExpress.Maui.Editors", DayOfMonthViewProvider.class, __md_methods);
    }

    public DayOfMonthViewProvider() {
        if (getClass() == DayOfMonthViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.DayOfMonthViewProvider, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public boolean check(View view, int i, int i2, int i3) {
        return n_check(view, i, i2, i3);
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public void recycle(View view) {
        n_recycle(view);
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public View request(int i, int i2, int i3) {
        return n_request(i, i2, i3);
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfMonthViewProvider
    public void update(View view, int i, int i2, int i3) {
        n_update(view, i, i2, i3);
    }

    @Override // crc64222d609bdd44b761.CellViewProvider_2, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc64222d609bdd44b761.CellViewProvider_2, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
