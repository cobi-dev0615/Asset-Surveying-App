package crc646b09977338b7360e;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DXBottomSheetDialog extends BottomSheetDialog implements IGCUserPeer, DialogInterface.OnShowListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onShow:(Landroid/content/DialogInterface;)V:GetOnShow_Landroid_content_DialogInterface_Handler:Android.Content.IDialogInterfaceOnShowListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onCancel:(Landroid/content/DialogInterface;)V:GetOnCancel_Landroid_content_DialogInterface_Handler:Android.Content.IDialogInterfaceOnCancelListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onDismiss:(Landroid/content/DialogInterface;)V:GetOnDismiss_Landroid_content_DialogInterface_Handler:Android.Content.IDialogInterfaceOnDismissListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onCancel(DialogInterface dialogInterface);

    private native void n_onCreate(Bundle bundle);

    private native void n_onDismiss(DialogInterface dialogInterface);

    private native void n_onShow(DialogInterface dialogInterface);

    static {
        Runtime.register("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog, DevExpress.Maui.Controls", DXBottomSheetDialog.class, __md_methods);
    }

    public DXBottomSheetDialog(Context context) {
        super(context);
        if (getClass() == DXBottomSheetDialog.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    public DXBottomSheetDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        if (getClass() == DXBottomSheetDialog.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:System.Boolean, System.Private.CoreLib:Android.Content.IDialogInterfaceOnCancelListener, Mono.Android", this, new Object[]{context, Boolean.valueOf(z), onCancelListener});
        }
    }

    public DXBottomSheetDialog(Context context, int i) {
        super(context, i);
        if (getClass() == DXBottomSheetDialog.class) {
            TypeManager.Activate("DevExpress.Maui.Controls.Internal.DXBottomSheetDialog, DevExpress.Maui.Controls", "Android.Content.Context, Mono.Android:System.Int32, System.Private.CoreLib", this, new Object[]{context, Integer.valueOf(i)});
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        n_onShow(dialogInterface);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        n_onCancel(dialogInterface);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        n_onDismiss(dialogInterface);
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
