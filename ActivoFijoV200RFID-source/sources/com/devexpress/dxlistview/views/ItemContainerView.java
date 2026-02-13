package com.devexpress.dxlistview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.devexpress.dxlistview.core.DXSize;
import com.devexpress.dxlistview.layouts.ItemContainerLayout;
import com.devexpress.dxlistview.layouts.LayoutElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemContainerView.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0014J0\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0014J\u0018\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0014J\b\u00107\u001a\u00020+H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR$\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\r¨\u00068"}, d2 = {"Lcom/devexpress/dxlistview/views/ItemContainerView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowRequestLayout", "", "value", "", "bottomSeparatorThickness", "getBottomSeparatorThickness", "()I", "setBottomSeparatorThickness", "(I)V", "bounds", "Landroid/graphics/Rect;", "Lcom/devexpress/dxlistview/layouts/ItemContainerLayout;", "containerLayout", "getContainerLayout", "()Lcom/devexpress/dxlistview/layouts/ItemContainerLayout;", "setContainerLayout", "(Lcom/devexpress/dxlistview/layouts/ItemContainerLayout;)V", "endSeparatorCapMargin", "getEndSeparatorCapMargin", "setEndSeparatorCapMargin", "isVisible", "()Z", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "rightSeparatorThickness", "getRightSeparatorThickness", "setRightSeparatorThickness", "separatorColor", "getSeparatorColor", "setSeparatorColor", "separatorPaint", "Landroid/graphics/Paint;", "startSeparatorCapMargin", "getStartSeparatorCapMargin", "setStartSeparatorCapMargin", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ItemContainerView extends ViewGroup {
    private boolean allowRequestLayout;
    private int bottomSeparatorThickness;
    private final Rect bounds;
    private ItemContainerLayout containerLayout;
    private int endSeparatorCapMargin;
    private int rightSeparatorThickness;
    private int separatorColor;
    private final Paint separatorPaint;
    private int startSeparatorCapMargin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemContainerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.separatorPaint = new Paint(1);
        this.bounds = new Rect();
        this.allowRequestLayout = true;
        setWillNotDraw(false);
    }

    public final int getSeparatorColor() {
        return this.separatorColor;
    }

    public final void setSeparatorColor(int i) {
        if (this.separatorColor != i) {
            this.separatorColor = i;
            this.separatorPaint.setColor(i);
            invalidate();
        }
    }

    public final int getBottomSeparatorThickness() {
        return this.bottomSeparatorThickness;
    }

    public final void setBottomSeparatorThickness(int i) {
        if (this.bottomSeparatorThickness != i) {
            this.bottomSeparatorThickness = i;
            forceLayout();
        }
    }

    public final int getRightSeparatorThickness() {
        return this.rightSeparatorThickness;
    }

    public final void setRightSeparatorThickness(int i) {
        if (this.rightSeparatorThickness != i) {
            this.rightSeparatorThickness = i;
            forceLayout();
        }
    }

    public final int getStartSeparatorCapMargin() {
        return this.startSeparatorCapMargin;
    }

    public final void setStartSeparatorCapMargin(int i) {
        if (this.startSeparatorCapMargin != i) {
            this.startSeparatorCapMargin = i;
            invalidate();
        }
    }

    public final int getEndSeparatorCapMargin() {
        return this.endSeparatorCapMargin;
    }

    public final void setEndSeparatorCapMargin(int i) {
        if (this.endSeparatorCapMargin != i) {
            this.endSeparatorCapMargin = i;
            invalidate();
        }
    }

    public final ItemContainerLayout getContainerLayout() {
        return this.containerLayout;
    }

    public final void setContainerLayout(ItemContainerLayout itemContainerLayout) {
        if (Intrinsics.areEqual(this.containerLayout, itemContainerLayout)) {
            return;
        }
        this.containerLayout = itemContainerLayout;
        if (itemContainerLayout != null) {
            Intrinsics.checkNotNull(itemContainerLayout);
            View view = itemContainerLayout.getContentElement().getView();
            Intrinsics.checkNotNull(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            addViewInLayout(view, -1, layoutParams, true);
        }
    }

    public final View getItemView() {
        LayoutElement contentElement;
        ItemContainerLayout itemContainerLayout = this.containerLayout;
        if (itemContainerLayout == null || (contentElement = itemContainerLayout.getContentElement()) == null) {
            return null;
        }
        return contentElement.getView();
    }

    private final boolean isVisible() {
        return getAlpha() > 0.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isVisible() || this.containerLayout == null) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int max = Math.max(0, size - this.rightSeparatorThickness);
        int max2 = Math.max(0, size2 - this.bottomSeparatorThickness);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        ItemContainerLayout itemContainerLayout = this.containerLayout;
        Intrinsics.checkNotNull(itemContainerLayout);
        DXSize measure = itemContainerLayout.measure(View.MeasureSpec.makeMeasureSpec(max, mode), View.MeasureSpec.makeMeasureSpec(max2, mode2));
        int i = measure.width + this.rightSeparatorThickness;
        if (mode != 0) {
            i = Math.min(size, i);
        }
        int i2 = measure.height + this.bottomSeparatorThickness;
        if (mode2 != 0) {
            i2 = Math.min(size2, i2);
        }
        setMeasuredDimension(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (!isVisible() || this.containerLayout == null) {
            return;
        }
        int max = Math.max(0, (r - l) - this.rightSeparatorThickness);
        int max2 = Math.max(0, (b - t) - this.bottomSeparatorThickness);
        ItemContainerLayout itemContainerLayout = this.containerLayout;
        Intrinsics.checkNotNull(itemContainerLayout);
        itemContainerLayout.layoutSubviews(new Rect(0, 0, max, max2));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.allowRequestLayout) {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.getClipBounds(this.bounds);
        if (this.bottomSeparatorThickness > 0) {
            canvas.drawRect(this.bounds.left + this.startSeparatorCapMargin, this.bounds.bottom - this.bottomSeparatorThickness, this.bounds.right - this.endSeparatorCapMargin, this.bounds.bottom, this.separatorPaint);
        }
        if (this.rightSeparatorThickness > 0) {
            canvas.drawRect(this.bounds.right - this.rightSeparatorThickness, this.bounds.top + this.startSeparatorCapMargin, this.bounds.right, this.bounds.bottom - this.endSeparatorCapMargin, this.separatorPaint);
        }
    }
}
