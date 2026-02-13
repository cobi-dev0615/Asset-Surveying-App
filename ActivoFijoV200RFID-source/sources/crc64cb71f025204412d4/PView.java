package crc64cb71f025204412d4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import crc647a19118a24842bb1.DiagnosticViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* loaded from: classes3.dex */
public class PView extends DiagnosticViewGroup implements IGCUserPeer {
    public static final String __md_methods = "n_onAttachedToWindow:()V:GetOnAttachedToWindowHandler\nn_onDetachedFromWindow:()V:GetOnDetachedFromWindowHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_dispatchDraw:(Landroid/graphics/Canvas;)V:GetDispatchDraw_Landroid_graphics_Canvas_Handler\nn_requestDisallowInterceptTouchEvent:(Z)V:GetRequestDisallowInterceptTouchEvent_ZHandler\nn_dispatchTouchEvent:(Landroid/view/MotionEvent;)Z:GetDispatchTouchEvent_Landroid_view_MotionEvent_Handler\nn_onInterceptTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnInterceptTouchEvent_Landroid_view_MotionEvent_Handler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\nn_invalidateDrawable:(Landroid/graphics/drawable/Drawable;)V:GetInvalidateDrawable_Landroid_graphics_drawable_Drawable_Handler\nn_onDrawForeground:(Landroid/graphics/Canvas;)V:GetOnDrawForeground_Landroid_graphics_Canvas_Handler\n";
    private ArrayList refList;

    private native void n_dispatchDraw(Canvas canvas);

    private native boolean n_dispatchTouchEvent(MotionEvent motionEvent);

    private native void n_invalidateDrawable(Drawable drawable);

    private native void n_onAttachedToWindow();

    private native void n_onDetachedFromWindow();

    private native void n_onDrawForeground(Canvas canvas);

    private native boolean n_onInterceptTouchEvent(MotionEvent motionEvent);

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMeasure(int i, int i2);

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    private native void n_requestDisallowInterceptTouchEvent(boolean z);

    static {
        Runtime.register("DevExpress.Maui.Core.Android.Internal.PView, DevExpress.Maui.Core", PView.class, __md_methods);
    }

    public PView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getClass() == PView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public PView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getClass() == PView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, System.Private.CoreLib", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public PView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getClass() == PView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new Object[]{context, attributeSet});
        }
    }

    public PView(Context context) {
        super(context);
        if (getClass() == PView.class) {
            TypeManager.Activate("DevExpress.Maui.Core.Android.Internal.PView, DevExpress.Maui.Core", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        n_onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        n_onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        n_onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        n_dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        n_requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return n_dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return n_onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        n_invalidateDrawable(drawable);
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        n_onDrawForeground(canvas);
    }

    @Override // crc647a19118a24842bb1.DiagnosticViewGroup, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc647a19118a24842bb1.DiagnosticViewGroup, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
