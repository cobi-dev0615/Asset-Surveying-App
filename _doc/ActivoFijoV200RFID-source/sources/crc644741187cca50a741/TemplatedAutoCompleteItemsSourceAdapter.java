package crc644741187cca50a741;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class TemplatedAutoCompleteItemsSourceAdapter extends AutoCompleteItemsSourceAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\n";
    private ArrayList refList;

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.TemplatedAutoCompleteItemsSourceAdapter, DevExpress.Maui.Editors", TemplatedAutoCompleteItemsSourceAdapter.class, __md_methods);
    }

    public TemplatedAutoCompleteItemsSourceAdapter(Context context) {
        super(context);
        if (getClass() == TemplatedAutoCompleteItemsSourceAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.TemplatedAutoCompleteItemsSourceAdapter, DevExpress.Maui.Editors", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    @Override // com.devexpress.editors.SimpleComboBoxAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return n_getView(i, view, viewGroup);
    }

    @Override // crc644741187cca50a741.AutoCompleteItemsSourceAdapter, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc644741187cca50a741.AutoCompleteItemsSourceAdapter, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
