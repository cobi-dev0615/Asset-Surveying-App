package crc64e2b69022553a5666;

import com.rfid.trans.ReadTag;
import com.rfid.trans.TagCallback;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class RfidCallback implements IGCUserPeer, TagCallback {
    public static final String __md_methods = "n_CRCErrorCallBack:(I)I:GetCRCErrorCallBack_IHandler:Com.Rfid.Trans.ITagCallbackInvoker, RugLineRT501.SDK.Binding\nn_FinishCallBack:()V:GetFinishCallBackHandler:Com.Rfid.Trans.ITagCallbackInvoker, RugLineRT501.SDK.Binding\nn_tagCallback:(Lcom/rfid/trans/ReadTag;)V:GetTagCallback_Lcom_rfid_trans_ReadTag_Handler:Com.Rfid.Trans.ITagCallbackInvoker, RugLineRT501.SDK.Binding\nn_tagCallbackFailed:(I)I:GetTagCallbackFailed_IHandler:Com.Rfid.Trans.ITagCallbackInvoker, RugLineRT501.SDK.Binding\n";
    private ArrayList refList;

    private native int n_CRCErrorCallBack(int i);

    private native void n_FinishCallBack();

    private native void n_tagCallback(ReadTag readTag);

    private native int n_tagCallbackFailed(int i);

    static {
        Runtime.register("RfidCallback, AuditoriaActivoFijo", RfidCallback.class, __md_methods);
    }

    public RfidCallback() {
        if (getClass() == RfidCallback.class) {
            TypeManager.Activate("RfidCallback, AuditoriaActivoFijo", "", this, new Object[0]);
        }
    }

    @Override // com.rfid.trans.TagCallback
    public int CRCErrorCallBack(int i) {
        return n_CRCErrorCallBack(i);
    }

    @Override // com.rfid.trans.TagCallback
    public void FinishCallBack() {
        n_FinishCallBack();
    }

    @Override // com.rfid.trans.TagCallback
    public void tagCallback(ReadTag readTag) {
        n_tagCallback(readTag);
    }

    @Override // com.rfid.trans.TagCallback
    public int tagCallbackFailed(int i) {
        return n_tagCallbackFailed(i);
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
