package com.devexpress.dxcore;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DXNativeView.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B'\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H$R$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/devexpress/dxcore/DXNativeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "maximumHeight", "getMaximumHeight", "()I", "setMaximumHeight", "(I)V", "maximumWidth", "getMaximumWidth", "setMaximumWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasureCore", "Landroid/util/Size;", "dxcore_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DXNativeView extends ViewGroup {
    private int maximumHeight;
    private int maximumWidth;

    public DXNativeView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DXNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    protected abstract Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec);

    public /* synthetic */ DXNativeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public DXNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maximumWidth = Integer.MAX_VALUE;
        this.maximumHeight = Integer.MAX_VALUE;
    }

    public DXNativeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.maximumWidth = Integer.MAX_VALUE;
        this.maximumHeight = Integer.MAX_VALUE;
    }

    public final int getMaximumWidth() {
        return this.maximumWidth;
    }

    public final void setMaximumWidth(int i) {
        if (this.maximumWidth == i) {
            return;
        }
        this.maximumWidth = i;
        requestLayout();
    }

    public final int getMaximumHeight() {
        return this.maximumHeight;
    }

    public final void setMaximumHeight(int i) {
        if (this.maximumHeight == i) {
            return;
        }
        this.maximumHeight = i;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Size onMeasureCore = onMeasureCore(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(Math.min(Math.max(onMeasureCore.getWidth(), getSuggestedMinimumWidth()), this.maximumWidth), Math.min(Math.max(onMeasureCore.getHeight(), getSuggestedMinimumHeight()), this.maximumHeight));
    }
}
