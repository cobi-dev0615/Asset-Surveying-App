package crc64386635862eb82281;

import android.os.Bundle;
import android.view.KeyEvent;
import crc6488302ad6e9e4df1a.MauiAppCompatActivity;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class MainActivity extends MauiAppCompatActivity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onKeyDown:(ILandroid/view/KeyEvent;)Z:GetOnKeyDown_ILandroid_view_KeyEvent_Handler\nn_onKeyUp:(ILandroid/view/KeyEvent;)Z:GetOnKeyUp_ILandroid_view_KeyEvent_Handler\nn_onDestroy:()V:GetOnDestroyHandler\n";
    private ArrayList refList;

    private native void n_onCreate(Bundle bundle);

    private native void n_onDestroy();

    private native boolean n_onKeyDown(int i, KeyEvent keyEvent);

    private native boolean n_onKeyUp(int i, KeyEvent keyEvent);

    static {
        Runtime.register("AuditoriaActivoFijo.MainActivity, AuditoriaActivoFijo", MainActivity.class, __md_methods);
    }

    public MainActivity() {
        if (getClass() == MainActivity.class) {
            TypeManager.Activate("AuditoriaActivoFijo.MainActivity, AuditoriaActivoFijo", "", this, new Object[0]);
        }
    }

    public MainActivity(int i) {
        super(i);
        if (getClass() == MainActivity.class) {
            TypeManager.Activate("AuditoriaActivoFijo.MainActivity, AuditoriaActivoFijo", "System.Int32, System.Private.CoreLib", this, new Object[]{Integer.valueOf(i)});
        }
    }

    @Override // crc6488302ad6e9e4df1a.MauiAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return n_onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return n_onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        n_onDestroy();
    }

    @Override // crc6488302ad6e9e4df1a.MauiAppCompatActivity, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc6488302ad6e9e4df1a.MauiAppCompatActivity, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
