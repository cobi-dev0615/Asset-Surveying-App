package crc64222d609bdd44b761;

import android.view.View;
import com.devexpress.editors.pickers.CalendarViewStates;
import com.devexpress.editors.pickers.providers.HeaderViewProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CalendarHeaderViewProvider implements IGCUserPeer, HeaderViewProvider {
    public static final String __md_methods = "n_check:(Landroid/view/View;IIILcom/devexpress/editors/pickers/CalendarViewStates;)Z:GetCheck_Landroid_view_View_IIILcom_devexpress_editors_pickers_CalendarViewStates_Handler:DevExpress.Android.Editors.Pickers.Providers.IHeaderViewProviderInvoker, DXEditors.a\nn_recycle:(Landroid/view/View;Lcom/devexpress/editors/pickers/CalendarViewStates;)V:GetRecycle_Landroid_view_View_Lcom_devexpress_editors_pickers_CalendarViewStates_Handler:DevExpress.Android.Editors.Pickers.Providers.IHeaderViewProviderInvoker, DXEditors.a\nn_request:(IIILcom/devexpress/editors/pickers/CalendarViewStates;)Landroid/view/View;:GetRequest_IIILcom_devexpress_editors_pickers_CalendarViewStates_Handler:DevExpress.Android.Editors.Pickers.Providers.IHeaderViewProviderInvoker, DXEditors.a\nn_update:(Landroid/view/View;IIILcom/devexpress/editors/pickers/CalendarViewStates;)V:GetUpdate_Landroid_view_View_IIILcom_devexpress_editors_pickers_CalendarViewStates_Handler:DevExpress.Android.Editors.Pickers.Providers.IHeaderViewProviderInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native boolean n_check(View view, int i, int i2, int i3, CalendarViewStates calendarViewStates);

    private native void n_recycle(View view, CalendarViewStates calendarViewStates);

    private native View n_request(int i, int i2, int i3, CalendarViewStates calendarViewStates);

    private native void n_update(View view, int i, int i2, int i3, CalendarViewStates calendarViewStates);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.CalendarHeaderViewProvider, DevExpress.Maui.Editors", CalendarHeaderViewProvider.class, __md_methods);
    }

    public CalendarHeaderViewProvider() {
        if (getClass() == CalendarHeaderViewProvider.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.CalendarHeaderViewProvider, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public boolean check(View view, int i, int i2, int i3, CalendarViewStates calendarViewStates) {
        return n_check(view, i, i2, i3, calendarViewStates);
    }

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public void recycle(View view, CalendarViewStates calendarViewStates) {
        n_recycle(view, calendarViewStates);
    }

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public View request(int i, int i2, int i3, CalendarViewStates calendarViewStates) {
        return n_request(i, i2, i3, calendarViewStates);
    }

    @Override // com.devexpress.editors.pickers.providers.HeaderViewProvider
    public void update(View view, int i, int i2, int i3, CalendarViewStates calendarViewStates) {
        n_update(view, i, i2, i3, calendarViewStates);
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
