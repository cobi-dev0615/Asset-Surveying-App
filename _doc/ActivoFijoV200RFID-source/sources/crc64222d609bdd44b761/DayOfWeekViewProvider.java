package crc64222d609bdd44b761;

import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DayOfWeekViewProvider extends CellViewProvider_2 implements IGCUserPeer, com.devexpress.editors.pickers.providers.DayOfWeekViewProvider {
    public static final String __md_methods = "n_check:(Landroid/view/View;I)Z:GetCheck_Landroid_view_View_IHandler:DevExpress.Android.Editors.Pickers.Providers.IDayOfWeekViewProviderInvoker, DXEditors.a\nn_recycle:(Landroid/view/View;)V:GetRecycle_Landroid_view_View_Handler:DevExpress.Android.Editors.Pickers.Providers.IDayOfWeekViewProviderInvoker, DXEditors.a\nn_request:(I)Landroid/view/View;:GetRequest_IHandler:DevExpress.Android.Editors.Pickers.Providers.IDayOfWeekViewProviderInvoker, DXEditors.a\nn_update:(Landroid/view/View;I)V:GetUpdate_Landroid_view_View_IHandler:DevExpress.Android.Editors.Pickers.Providers.IDayOfWeekViewProviderInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_check(View view, int i);

    private native void n_recycle(View view);

    private native View n_request(int i);

    private native void n_update(View view, int i);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.DayOfWeekViewProvider, DevExpress.Maui.Editors", DayOfWeekViewProvider.class, __md_methods);
    }

    public DayOfWeekViewProvider() {
        if (getClass() == DayOfWeekViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.DayOfWeekViewProvider, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public boolean check(View view, int i) {
        return n_check(view, i);
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public void recycle(View view) {
        n_recycle(view);
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public View request(int i) {
        return n_request(i);
    }

    @Override // com.devexpress.editors.pickers.providers.DayOfWeekViewProvider
    public void update(View view, int i) {
        n_update(view, i);
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
