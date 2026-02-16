package crc64cb71f025204412d4;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PView_BackgroundBrushDrawable extends LayerDrawable implements IGCUserPeer {
    public static final String __md_methods = "n_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.PView+BackgroundBrushDrawable, DevExpress.Maui.Core", PView_BackgroundBrushDrawable.class, "n_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\n");
    }

    public PView_BackgroundBrushDrawable(Drawable[] drawableArr) {
        super(drawableArr);
        if (getClass() == PView_BackgroundBrushDrawable.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView+BackgroundBrushDrawable, DevExpress.Maui.Core", "Android.Graphics.Drawables.Drawable[], Mono.Android", this, new Object[]{drawableArr});
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
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
