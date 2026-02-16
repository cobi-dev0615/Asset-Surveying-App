package crc644741187cca50a741;

import android.widget.Filter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PassthroughFilter extends Filter implements IGCUserPeer {
    public static final String __md_methods = "n_performFiltering:(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;:GetPerformFiltering_Ljava_lang_CharSequence_Handler\nn_publishResults:(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V:GetPublishResults_Ljava_lang_CharSequence_Landroid_widget_Filter_FilterResults_Handler\n";
    private ArrayList refList;

    private native Filter.FilterResults n_performFiltering(CharSequence charSequence);

    private native void n_publishResults(CharSequence charSequence, Filter.FilterResults filterResults);

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.PassthroughFilter, DevExpress.Maui.Editors", PassthroughFilter.class, "n_performFiltering:(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;:GetPerformFiltering_Ljava_lang_CharSequence_Handler\nn_publishResults:(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V:GetPublishResults_Ljava_lang_CharSequence_Landroid_widget_Filter_FilterResults_Handler\n");
    }

    public PassthroughFilter() {
        if (getClass() == PassthroughFilter.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.PassthroughFilter, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    public PassthroughFilter(AutoCompleteItemsSourceAdapter autoCompleteItemsSourceAdapter) {
        if (getClass() == PassthroughFilter.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.PassthroughFilter, DevExpress.Maui.Editors", "DevExpress.Maui.Editors.Android.Internal.AutoCompleteItemsSourceAdapter, DevExpress.Maui.Editors", this, new Object[]{autoCompleteItemsSourceAdapter});
        }
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        return n_performFiltering(charSequence);
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        n_publishResults(charSequence, filterResults);
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
