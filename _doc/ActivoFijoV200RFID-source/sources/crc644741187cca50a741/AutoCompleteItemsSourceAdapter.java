package crc644741187cca50a741;

import android.content.Context;
import android.widget.Filter;
import android.widget.Filterable;
import com.devexpress.editors.SimpleComboBoxAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AutoCompleteItemsSourceAdapter extends SimpleComboBoxAdapter implements IGCUserPeer, Filterable {
    public static final String __md_methods = "n_getCount:()I:GetGetCountHandler\nn_getPosition:(Ljava/lang/Object;)I:GetGetPosition_Ljava_lang_Object_Handler\nn_getSourcePosition:(Ljava/lang/Object;)I:GetGetSourcePosition_Ljava_lang_Object_Handler\nn_getItem:(I)Ljava/lang/Object;:GetGetItem_IHandler\nn_getSourceItem:(I)Ljava/lang/Object;:GetGetSourceItem_IHandler\nn_getText:(I)Ljava/lang/CharSequence;:GetGetText_IHandler\nn_getFilter:()Landroid/widget/Filter;:GetGetFilterHandler:Android.Widget.IFilterableInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native int n_getCount();

    private native Filter n_getFilter();

    private native Object n_getItem(int i);

    private native int n_getPosition(Object obj);

    private native Object n_getSourceItem(int i);

    private native int n_getSourcePosition(Object obj);

    private native CharSequence n_getText(int i);

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.AutoCompleteItemsSourceAdapter, DevExpress.Maui.Editors", AutoCompleteItemsSourceAdapter.class, __md_methods);
    }

    public AutoCompleteItemsSourceAdapter(Context context) {
        super(context);
        if (getClass() == AutoCompleteItemsSourceAdapter.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.AutoCompleteItemsSourceAdapter, DevExpress.Maui.Editors", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return n_getCount();
    }

    @Override // com.devexpress.editors.ComboBoxAdapter
    public int getPosition(Object obj) {
        return n_getPosition(obj);
    }

    @Override // com.devexpress.editors.ComboBoxAdapter
    public int getSourcePosition(Object obj) {
        return n_getSourcePosition(obj);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return n_getItem(i);
    }

    @Override // com.devexpress.editors.ComboBoxAdapter
    public Object getSourceItem(int i) {
        return n_getSourceItem(i);
    }

    @Override // com.devexpress.editors.SimpleComboBoxAdapter
    public CharSequence getText(int i) {
        return n_getText(i);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return n_getFilter();
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
