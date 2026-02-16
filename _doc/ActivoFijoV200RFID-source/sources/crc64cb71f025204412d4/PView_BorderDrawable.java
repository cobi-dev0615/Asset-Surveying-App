package crc64cb71f025204412d4;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PView_BorderDrawable extends ColorDrawable implements IGCUserPeer {
    public static final String __md_methods = "n_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.PView+BorderDrawable, DevExpress.Maui.Core", PView_BorderDrawable.class, "n_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\n");
    }

    public PView_BorderDrawable() {
        if (getClass() == PView_BorderDrawable.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView+BorderDrawable, DevExpress.Maui.Core", "", this, new Object[0]);
        }
    }

    public PView_BorderDrawable(int i) {
        super(i);
        if (getClass() == PView_BorderDrawable.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView+BorderDrawable, DevExpress.Maui.Core", "Android.Graphics.Color, Mono.Android", this, new Object[]{Integer.valueOf(i)});
        }
    }

    public PView_BorderDrawable(PView pView) {
        if (getClass() == PView_BorderDrawable.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView+BorderDrawable, DevExpress.Maui.Core", "DevExpress.Maui.Core.Android.Internal.PView, DevExpress.Maui.Core", this, new Object[]{pView});
        }
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        n_draw(canvas);
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
