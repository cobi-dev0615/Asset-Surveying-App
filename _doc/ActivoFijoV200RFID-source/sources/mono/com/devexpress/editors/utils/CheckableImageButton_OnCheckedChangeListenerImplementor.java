package mono.com.devexpress.editors.utils;

import android.widget.Checkable;
import com.devexpress.editors.utils.CheckableImageButton;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class CheckableImageButton_OnCheckedChangeListenerImplementor implements IGCUserPeer, CheckableImageButton.OnCheckedChangeListener {
    public static final String __md_methods = "n_onCheckedChanged:(Landroid/widget/Checkable;Z)V:GetOnCheckedChanged_Landroid_widget_Checkable_ZHandler:DevExpress.Android.Editors.Util.CheckableImageButton/IOnCheckedChangeListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onCheckedChanged(Checkable checkable, boolean z);

    static {
        Runtime.register("DevExpress.Android.Editors.Util.CheckableImageButton+IOnCheckedChangeListenerImplementor, DXEditors.a", CheckableImageButton_OnCheckedChangeListenerImplementor.class, __md_methods);
    }

    public CheckableImageButton_OnCheckedChangeListenerImplementor() {
        if (getClass() == CheckableImageButton_OnCheckedChangeListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.Util.CheckableImageButton+IOnCheckedChangeListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.utils.CheckableImageButton.OnCheckedChangeListener
    public void onCheckedChanged(Checkable checkable, boolean z) {
        n_onCheckedChanged(checkable, z);
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
