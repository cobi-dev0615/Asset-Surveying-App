package mono.com.devexpress.editors.pickers;

import com.devexpress.editors.pickers.DateEditPicker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DateEditPicker_DateEditPickerListenerImplementor implements IGCUserPeer, DateEditPicker.DateEditPickerListener {
    public static final String __md_methods = "n_onActiveViewChanged:(Lcom/devexpress/editors/pickers/DateEditPicker;I)V:GetOnActiveViewChanged_Lcom_devexpress_editors_pickers_DateEditPicker_IHandler:DevExpress.Android.Editors.Pickers.DateEditPicker/IDateEditPickerListenerInvoker, DXEditors.a\nn_onDayCellTap:(Lcom/devexpress/editors/pickers/DateEditPicker;III)V:GetOnDayCellTap_Lcom_devexpress_editors_pickers_DateEditPicker_IIIHandler:DevExpress.Android.Editors.Pickers.DateEditPicker/IDateEditPickerListenerInvoker, DXEditors.a\nn_onDisplayYearMonthChanged:(Lcom/devexpress/editors/pickers/DateEditPicker;II)V:GetOnDisplayYearMonthChanged_Lcom_devexpress_editors_pickers_DateEditPicker_IIHandler:DevExpress.Android.Editors.Pickers.DateEditPicker/IDateEditPickerListenerInvoker, DXEditors.a\nn_onSizeChanged:()V:GetOnSizeChangedHandler:DevExpress.Android.Editors.Pickers.DateEditPicker/IDateEditPickerListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onActiveViewChanged(DateEditPicker dateEditPicker, int i);

    private native void n_onDayCellTap(DateEditPicker dateEditPicker, int i, int i2, int i3);

    private native void n_onDisplayYearMonthChanged(DateEditPicker dateEditPicker, int i, int i2);

    private native void n_onSizeChanged();

    static {
        Runtime.register("DevExpress.Android.Editors.Pickers.DateEditPicker+IDateEditPickerListenerImplementor, DXEditors.a", DateEditPicker_DateEditPickerListenerImplementor.class, __md_methods);
    }

    public DateEditPicker_DateEditPickerListenerImplementor() {
        if (getClass() == DateEditPicker_DateEditPickerListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.Pickers.DateEditPicker+IDateEditPickerListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.pickers.DateEditPicker.DateEditPickerListener
    public void onActiveViewChanged(DateEditPicker dateEditPicker, int i) {
        n_onActiveViewChanged(dateEditPicker, i);
    }

    @Override // com.devexpress.editors.pickers.DateEditPicker.DateEditPickerListener
    public void onDayCellTap(DateEditPicker dateEditPicker, int i, int i2, int i3) {
        n_onDayCellTap(dateEditPicker, i, i2, i3);
    }

    @Override // com.devexpress.editors.pickers.DateEditPicker.DateEditPickerListener
    public void onDisplayYearMonthChanged(DateEditPicker dateEditPicker, int i, int i2) {
        n_onDisplayYearMonthChanged(dateEditPicker, i, i2);
    }

    @Override // com.devexpress.editors.pickers.DateEditPicker.DateEditPickerListener
    public void onSizeChanged() {
        n_onSizeChanged();
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
