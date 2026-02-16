package mono.com.devexpress.editors;

import android.view.View;
import com.devexpress.editors.ExpanderListener;
import com.devexpress.editors.dataForm.ExpanderView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class ExpanderListenerImplementor implements IGCUserPeer, ExpanderListener {
    public static final String __md_methods = "n_contentSizeChanged:(Landroid/view/View;)V:GetContentSizeChanged_Landroid_view_View_Handler:DevExpress.Android.Editors.IExpanderListenerInvoker, DXEditors.a\nn_isExpanderCollapsed:(Lcom/devexpress/editors/dataForm/ExpanderView;Z)V:GetIsExpanderCollapsed_Lcom_devexpress_editors_dataForm_ExpanderView_ZHandler:DevExpress.Android.Editors.IExpanderListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_contentSizeChanged(View view);

    private native void n_isExpanderCollapsed(ExpanderView expanderView, boolean z);

    static {
        Runtime.register("DevExpress.Android.Editors.IExpanderListenerImplementor, DXEditors.a", ExpanderListenerImplementor.class, __md_methods);
    }

    public ExpanderListenerImplementor() {
        if (getClass() == ExpanderListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.IExpanderListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.ExpanderListener
    public void contentSizeChanged(View view) {
        n_contentSizeChanged(view);
    }

    @Override // com.devexpress.editors.ExpanderListener
    public void isExpanderCollapsed(ExpanderView expanderView, boolean z) {
        n_isExpanderCollapsed(expanderView, z);
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
