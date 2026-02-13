package crc644741187cca50a741;

import android.view.View;
import com.devexpress.editors.popupmanagers.CollectionViewOwner;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public abstract class CollectionViewOwnerWrapper_1 implements IGCUserPeer, CollectionViewOwner {
    public static final String __md_methods = "n_getCollectionView:()Landroid/view/View;:GetGetCollectionViewHandler:DevExpress.Android.Editors.Popupmanagers.ICollectionViewOwnerInvoker, DXEditors.a\nn_hasValue:()Z:GetHasValueHandler:DevExpress.Android.Editors.Popupmanagers.ICollectionViewOwnerInvoker, DXEditors.a\nn_isDataSourceEmpty:()Z:GetIsDataSourceEmptyHandler:DevExpress.Android.Editors.Popupmanagers.ICollectionViewOwnerInvoker, DXEditors.a\nn_getSelectedItemText:()Ljava/lang/CharSequence;:GetGetSelectedItemTextHandler:DevExpress.Android.Editors.Popupmanagers.ICollectionViewOwnerInvoker, DXEditors.a\nn_clearValue:()V:GetClearValueHandler:DevExpress.Android.Editors.Popupmanagers.ICollectionViewOwnerInvoker, DXEditors.a\nn_ensureSelectionVisible:()V:GetEnsureSelectionVisibleHandler:DevExpress.Android.Editors.Popupmanagers.ICollectionViewOwnerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_clearValue();

    private native void n_ensureSelectionVisible();

    private native View n_getCollectionView();

    private native CharSequence n_getSelectedItemText();

    private native boolean n_hasValue();

    private native boolean n_isDataSourceEmpty();

    static {
        Runtime.register("DevExpress.Maui.Editors.Android.Internal.CollectionViewOwnerWrapper`1, DevExpress.Maui.Editors", CollectionViewOwnerWrapper_1.class, __md_methods);
    }

    public CollectionViewOwnerWrapper_1() {
        if (getClass() == CollectionViewOwnerWrapper_1.class) {
            TypeManager.Activate("DevExpress.Maui.Editors.Android.Internal.CollectionViewOwnerWrapper`1, DevExpress.Maui.Editors", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.popupmanagers.CollectionViewOwner
    public View getCollectionView() {
        return n_getCollectionView();
    }

    @Override // com.devexpress.editors.popupmanagers.CollectionViewOwner
    public boolean hasValue() {
        return n_hasValue();
    }

    @Override // com.devexpress.editors.popupmanagers.CollectionViewOwner
    public boolean isDataSourceEmpty() {
        return n_isDataSourceEmpty();
    }

    @Override // com.devexpress.editors.popupmanagers.CollectionViewOwner
    public CharSequence getSelectedItemText() {
        return n_getSelectedItemText();
    }

    @Override // com.devexpress.editors.popupmanagers.CollectionViewOwner
    public void clearValue() {
        n_clearValue();
    }

    @Override // com.devexpress.editors.popupmanagers.CollectionViewOwner
    public void ensureSelectionVisible() {
        n_ensureSelectionVisible();
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
