package crc64222d609bdd44b761;

import android.view.View;
import com.devexpress.editors.ChipItemViewProvider;
import com.devexpress.editors.ChipItemsProviderViewType;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CGViewProvider_1 implements IGCUserPeer, ChipItemViewProvider {
    public static final String __md_methods = "n_getItemCount:()I:GetGetItemCountHandler:DevExpress.Android.Editors.IChipItemViewProviderInvoker, DXEditors.a\nn_getViewByIndex:(I)Landroid/view/View;:GetGetViewByIndex_IHandler:DevExpress.Android.Editors.IChipItemViewProviderInvoker, DXEditors.a\nn_getViewTypeByIndex:(I)Lcom/devexpress/editors/ChipItemsProviderViewType;:GetGetViewTypeByIndex_IHandler:DevExpress.Android.Editors.IChipItemViewProviderInvoker, DXEditors.a\nn_recycleView:(Landroid/view/View;II)V:GetRecycleView_Landroid_view_View_IIHandler:DevExpress.Android.Editors.IChipItemViewProviderInvoker, DXEditors.a\nn_updateView:(Landroid/view/View;I)V:GetUpdateView_Landroid_view_View_IHandler:DevExpress.Android.Editors.IChipItemViewProviderInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native int n_getItemCount();

    private native View n_getViewByIndex(int i);

    private native ChipItemsProviderViewType n_getViewTypeByIndex(int i);

    private native void n_recycleView(View view, int i, int i2);

    private native void n_updateView(View view, int i);

    static {
        Runtime.register("DevExpress.Maui.Editors.Internal.CGViewProvider`1, DevExpress.Maui.Editors", CGViewProvider_1.class, __md_methods);
    }

    public CGViewProvider_1() {
        if (getClass() == CGViewProvider_1.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Internal.CGViewProvider`1, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.ChipItemViewProvider
    public int getItemCount() {
        return n_getItemCount();
    }

    @Override // com.devexpress.editors.ChipItemViewProvider
    public View getViewByIndex(int i) {
        return n_getViewByIndex(i);
    }

    @Override // com.devexpress.editors.ChipItemViewProvider
    public ChipItemsProviderViewType getViewTypeByIndex(int i) {
        return n_getViewTypeByIndex(i);
    }

    @Override // com.devexpress.editors.ChipItemViewProvider
    public void recycleView(View view, int i, int i2) {
        n_recycleView(view, i, i2);
    }

    @Override // com.devexpress.editors.ChipItemViewProvider
    public void updateView(View view, int i) {
        n_updateView(view, i);
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
