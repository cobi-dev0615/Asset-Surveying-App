package mono.com.devexpress.editors.dataForm.protocols;

import com.devexpress.editors.dataForm.protocols.AsyncImageInfo;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class AsyncImageInfo_AsyncImageInfoListenerImplementor implements IGCUserPeer, AsyncImageInfo.AsyncImageInfoListener {
    public static final String __md_methods = "n_onImageLoaded:()V:GetOnImageLoadedHandler:DevExpress.Android.Editors.DataForm.Protocols.AsyncImageInfo/IAsyncImageInfoListenerInvoker, DXEditors.a\n";
    private ArrayList refList;

    private native void n_onImageLoaded();

    static {
        Runtime.register("DevExpress.Android.Editors.DataForm.Protocols.AsyncImageInfo+IAsyncImageInfoListenerImplementor, DXEditors.a", AsyncImageInfo_AsyncImageInfoListenerImplementor.class, __md_methods);
    }

    public AsyncImageInfo_AsyncImageInfoListenerImplementor() {
        if (getClass() == AsyncImageInfo_AsyncImageInfoListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Editors.DataForm.Protocols.AsyncImageInfo+IAsyncImageInfoListenerImplementor, DXEditors.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.editors.dataForm.protocols.AsyncImageInfo.AsyncImageInfoListener
    public void onImageLoaded() {
        n_onImageLoaded();
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
