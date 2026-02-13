package mono.com.devexpress.navigation.navigationdrawer;

import android.graphics.Canvas;
import android.view.View;
import com.devexpress.navigation.navigationdrawer.DrawerInnerContainer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class DrawerInnerContainer_IOnDrawListenerImplementor implements IGCUserPeer, DrawerInnerContainer.IOnDrawListener {
    public static final String __md_methods = "n_drawChild:(Landroid/graphics/Canvas;Landroid/view/View;J)V:GetDrawChild_Landroid_graphics_Canvas_Landroid_view_View_JHandler:DevExpress.Android.Navigation.Navigationdrawer.DrawerInnerContainer/IOnDrawListenerInvoker, DXNavigation.a\n";
    private ArrayList refList;

    private native void n_drawChild(Canvas canvas, View view, long j);

    static {
        Runtime.register("DevExpress.Android.Navigation.Navigationdrawer.DrawerInnerContainer+IOnDrawListenerImplementor, DXNavigation.a", DrawerInnerContainer_IOnDrawListenerImplementor.class, __md_methods);
    }

    public DrawerInnerContainer_IOnDrawListenerImplementor() {
        if (getClass() == DrawerInnerContainer_IOnDrawListenerImplementor.class) {
            TypeManager.Activate("DevExpress.Android.Navigation.Navigationdrawer.DrawerInnerContainer+IOnDrawListenerImplementor, DXNavigation.a", "", this, new Object[0]);
        }
    }

    @Override // com.devexpress.navigation.navigationdrawer.DrawerInnerContainer.IOnDrawListener
    public void drawChild(Canvas canvas, View view, long j) {
        n_drawChild(canvas, view, j);
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
