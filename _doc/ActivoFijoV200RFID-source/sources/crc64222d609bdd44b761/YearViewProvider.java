package crc64222d609bdd44b761;

import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class YearViewProvider extends CellViewProvider_2 implements IGCUserPeer, com.devexpress.editors.pickers.providers.YearViewProvider {
    public static final String __md_methods = "n_check:(Landroid/view/View;II)Z:GetCheck_Landroid_view_View_IIHandler:DevExpress.Android.Editors.Pickers.Providers.IYearViewProviderInvoker, DXEditors.a\nn_recycle:(Landroid/view/View;)V:GetRecycle_Landroid_view_View_Handler:DevExpress.Android.Editors.Pickers.Providers.IYearViewProviderInvoker, DXEditors.a\nn_request:(II)Landroid/view/View;:GetRequest_IIHandler:DevExpress.Android.Editors.Pickers.Providers.IYearViewProviderInvoker, DXEditors.a\nn_update:(Landroid/view/View;II)V:GetUpdate_Landroid_view_View_IIHandler:DevExpress.Android.Editors.Pickers.Providers.IYearViewProviderInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_check(View view, int i, int i2);

    private native void n_recycle(View view);

    private native View n_request(int i, int i2);

    private native void n_update(View view, int i, int i2);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.YearViewProvider, DevExpress.Maui.Editors", YearViewProvider.class, __md_methods);
    }

    public YearViewProvider() {
        if (getClass() == YearViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.YearViewProvider, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.pickers.providers.YearViewProvider
    public boolean check(View view, int i, int i2) {
        return n_check(view, i, i2);
    }

    @Override // com.devexpress.editors.pickers.providers.YearViewProvider
    public void recycle(View view) {
        n_recycle(view);
    }

    @Override // com.devexpress.editors.pickers.providers.YearViewProvider
    public View request(int i, int i2) {
        return n_request(i, i2);
    }

    @Override // com.devexpress.editors.pickers.providers.YearViewProvider
    public void update(View view, int i, int i2) {
        n_update(view, i, i2);
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
