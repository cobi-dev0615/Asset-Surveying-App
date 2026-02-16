package com.devexpress.editors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.navigation.tabs.models.HeaderItemAppearance;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXShimmerView.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020*H\u0014J\b\u00100\u001a\u00020*H\u0014J0\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0014J\u0010\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020.H\u0014R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR$\u0010&\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006="}, d2 = {"Lcom/devexpress/editors/DXShimmerView;", "Lcom/devexpress/dxcore/DXNativeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundWaveColor", "getBackgroundWaveColor", "()I", "setBackgroundWaveColor", "(I)V", "drawable", "Lcom/devexpress/editors/ShimmerDrawable;", "", "loading", "getLoading", "()Z", "setLoading", "(Z)V", "", "waveAngle", "getWaveAngle", "()F", "setWaveAngle", "(F)V", "", "waveDuration", "getWaveDuration", "()J", "setWaveDuration", "(J)V", "waveOpacity", "getWaveOpacity", "setWaveOpacity", "waveWidth", "getWaveWidth", "setWaveWidth", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "invalidateDrawable", "Landroid/graphics/drawable/Drawable;", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "verifyDrawable", "who", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXShimmerView extends DXNativeView {
    private ShimmerDrawable drawable;
    private boolean loading;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DXShimmerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DXShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DXShimmerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXShimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.drawable = new ShimmerDrawable();
        setWillNotDraw(false);
        this.drawable.setCallback(this);
        setLayerType(2, new Paint());
    }

    public final long getWaveDuration() {
        return this.drawable.getWaveDuration();
    }

    public final void setWaveDuration(long j) {
        this.drawable.setWaveDuration(j);
    }

    public final float getWaveAngle() {
        return this.drawable.getAngle();
    }

    public final void setWaveAngle(float f) {
        this.drawable.setAngle(f % HeaderItemAppearance.ITEM_MAX_WIDTH);
    }

    public final float getWaveWidth() {
        return this.drawable.getWaveWidth();
    }

    public final void setWaveWidth(float f) {
        this.drawable.setWaveWidth(f);
    }

    public final int getBackgroundWaveColor() {
        return this.drawable.getBackgroundColor();
    }

    public final void setBackgroundWaveColor(int i) {
        this.drawable.setBackgroundColor(i);
    }

    public final int getWaveOpacity() {
        return this.drawable.getWaveOpacity();
    }

    public final void setWaveOpacity(int i) {
        this.drawable.setWaveOpacity(i);
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setLoading(boolean z) {
        if (this.loading != z) {
            this.loading = z;
            if (z) {
                this.drawable.start();
            } else {
                this.drawable.stop();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (getChildCount() == 0) {
            return;
        }
        int i = right - left;
        int i2 = bottom - top;
        getChildAt(0).layout(0, 0, i, i2);
        this.drawable.setBounds(0, 0, i, i2);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() == 0) {
            return new Size(0, 0);
        }
        View childAt = getChildAt(0);
        childAt.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        return new Size(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        super.invalidateDrawable(drawable);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.loading) {
            this.drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return super.verifyDrawable(who) && Intrinsics.areEqual(who, this.drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.loading) {
            this.drawable.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.loading) {
            this.drawable.stop();
        }
    }
}
