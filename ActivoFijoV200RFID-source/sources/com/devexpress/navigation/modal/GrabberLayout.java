package com.devexpress.navigation.modal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewGroupKt;
import com.devexpress.navigation.tabs.models.Padding;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GrabberLayout.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0018\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\rH\u0002J\u0010\u0010@\u001a\u00020:2\u0006\u0010>\u001a\u00020\rH\u0002J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020CH\u0014J\u0010\u0010D\u001a\u00020:2\u0006\u0010B\u001a\u00020CH\u0016J0\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0014J\u0018\u0010K\u001a\u00020:2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R$\u0010.\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R$\u00101\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R$\u00104\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006N"}, d2 = {"Lcom/devexpress/navigation/modal/GrabberLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_drawGrabberLine", "", "_grabberColor", "_grabberHeight", "", "_grabberTopOffset", "_grabberWidth", "_layoutCornerRadius", "_padding", "Lcom/devexpress/navigation/tabs/models/Padding;", "clipPath", "Landroid/graphics/Path;", "clipRect", "Landroid/graphics/RectF;", "value", "drawGrabberLine", "getDrawGrabberLine", "()Z", "setDrawGrabberLine", "(Z)V", "grabberColor", "getGrabberColor", "()I", "setGrabberColor", "(I)V", "grabberHeight", "getGrabberHeight", "()F", "setGrabberHeight", "(F)V", "grabberPaint", "Landroid/graphics/Paint;", "grabberPath", "grabberRect", "grabberTopOffset", "getGrabberTopOffset", "setGrabberTopOffset", "grabberWidth", "getGrabberWidth", "setGrabberWidth", "layoutCornerRadius", "getLayoutCornerRadius", "setLayoutCornerRadius", "padding", "getPadding", "()Lcom/devexpress/navigation/tabs/models/Padding;", "setPadding", "(Lcom/devexpress/navigation/tabs/models/Padding;)V", "addView", "", "child", "Landroid/view/View;", "calculateClipPath", "width", "height", "calculateGrabberRect", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDrawForeground", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dxnavigation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GrabberLayout extends ViewGroup {
    private boolean _drawGrabberLine;
    private int _grabberColor;
    private float _grabberHeight;
    private float _grabberTopOffset;
    private float _grabberWidth;
    private float _layoutCornerRadius;
    private Padding _padding;
    private final Path clipPath;
    private final RectF clipRect;
    private final Paint grabberPaint;
    private final Path grabberPath;
    private final RectF grabberRect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GrabberLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GrabberLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrabberLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._grabberColor = Color.parseColor("#C4BFC7");
        this._padding = new Padding();
        this.clipPath = new Path();
        this.clipRect = new RectF();
        this.grabberPath = new Path();
        this.grabberRect = new RectF();
        Paint paint = new Paint();
        this.grabberPaint = paint;
        setWillNotDraw(false);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(get_grabberColor());
    }

    public /* synthetic */ GrabberLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: getGrabberWidth, reason: from getter */
    public final float get_grabberWidth() {
        return this._grabberWidth;
    }

    public final void setGrabberWidth(float f) {
        this._grabberWidth = f;
        invalidate();
    }

    /* renamed from: getGrabberHeight, reason: from getter */
    public final float get_grabberHeight() {
        return this._grabberHeight;
    }

    public final void setGrabberHeight(float f) {
        this._grabberHeight = f;
        invalidate();
    }

    /* renamed from: getGrabberTopOffset, reason: from getter */
    public final float get_grabberTopOffset() {
        return this._grabberTopOffset;
    }

    public final void setGrabberTopOffset(float f) {
        this._grabberTopOffset = f;
        invalidate();
    }

    /* renamed from: getDrawGrabberLine, reason: from getter */
    public final boolean get_drawGrabberLine() {
        return this._drawGrabberLine;
    }

    public final void setDrawGrabberLine(boolean z) {
        this._drawGrabberLine = z;
        invalidate();
    }

    /* renamed from: getLayoutCornerRadius, reason: from getter */
    public final float get_layoutCornerRadius() {
        return this._layoutCornerRadius;
    }

    public final void setLayoutCornerRadius(float f) {
        this._layoutCornerRadius = f;
        requestLayout();
    }

    /* renamed from: getGrabberColor, reason: from getter */
    public final int get_grabberColor() {
        return this._grabberColor;
    }

    public final void setGrabberColor(int i) {
        this._grabberColor = i;
        this.grabberPaint.setColor(i);
    }

    /* renamed from: getPadding, reason: from getter */
    public final Padding get_padding() {
        return this._padding;
    }

    public final void setPadding(Padding value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._padding = value;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        float f = r - l;
        calculateClipPath(f, b - t);
        calculateGrabberRect(f);
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (it.hasNext()) {
            it.next().layout(((int) get_padding().getLeft()) + l, ((int) get_padding().getTop()) + t, r - ((int) get_padding().getRight()), b - ((int) get_padding().getBottom()));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (getChildCount() == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (it.hasNext()) {
            it.next().measure(View.MeasureSpec.makeMeasureSpec((size - ((int) get_padding().getLeft())) - ((int) get_padding().getRight()), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((size2 - ((int) get_padding().getTop())) - ((int) get_padding().getBottom()), BasicMeasure.EXACTLY));
        }
        View childAt = getChildAt(0);
        setMeasuredDimension(childAt.getMeasuredWidth() + ((int) get_padding().getLeft()) + ((int) get_padding().getRight()), childAt.getMeasuredHeight() + ((int) get_padding().getTop()) + ((int) get_padding().getBottom()));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.clipPath(this.clipPath);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDrawForeground(canvas);
        if (get_drawGrabberLine()) {
            canvas.drawPath(this.grabberPath, this.grabberPaint);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        if (getChildCount() > 0) {
            throw new Exception("Grabber layout can wrap only one child!");
        }
        super.addView(child);
    }

    private final void calculateClipPath(float width, float height) {
        this.clipRect.set(0.0f, 0.0f, width, height);
        float[] fArr = {get_layoutCornerRadius(), get_layoutCornerRadius(), get_layoutCornerRadius(), get_layoutCornerRadius(), 0.0f, 0.0f, 0.0f, 0.0f};
        this.clipPath.reset();
        this.clipPath.addRoundRect(this.clipRect, fArr, Path.Direction.CW);
    }

    private final void calculateGrabberRect(float width) {
        this.grabberPath.reset();
        float f = 2;
        float f2 = (width - this._grabberWidth) / f;
        float f3 = this._grabberHeight;
        float f4 = f3 / f;
        float[] fArr = {f4, f4, f4, f4, f4, f4, f4, f4};
        RectF rectF = this.grabberRect;
        float f5 = this._grabberTopOffset;
        rectF.set(f2, f5, width - f2, f3 + f5);
        this.grabberPath.addRoundRect(this.grabberRect, fArr, Path.Direction.CW);
    }
}
