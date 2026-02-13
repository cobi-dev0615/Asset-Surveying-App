package com.devexpress.editors;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipLayout.kt */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0002J0\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0014J\u0018\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014J\u000e\u00105\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\u0010R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u00066"}, d2 = {"Lcom/devexpress/editors/ChipLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chipsAnimator", "com/devexpress/editors/ChipLayout$chipsAnimator$1", "Lcom/devexpress/editors/ChipLayout$chipsAnimator$1;", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/devexpress/editors/ChipGroupLayoutDelegate;", "value", "horizontalItemSpacing", "getHorizontalItemSpacing$dxeditors_release", "()I", "setHorizontalItemSpacing$dxeditors_release", "(I)V", "", "isMultiline", "isMultiline$dxeditors_release", "()Z", "setMultiline$dxeditors_release", "(Z)V", "provider", "Lcom/devexpress/editors/ChipItemViewProvider;", "getProvider$dxeditors_release", "()Lcom/devexpress/editors/ChipItemViewProvider;", "setProvider$dxeditors_release", "(Lcom/devexpress/editors/ChipItemViewProvider;)V", "rowCount", "verticalItemSpacing", "getVerticalItemSpacing$dxeditors_release", "setVerticalItemSpacing$dxeditors_release", "getMeasuredDimension", "size", "mode", "childrenEdge", "onLayout", "", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDelegate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChipLayout extends ViewGroup {
    private final ChipLayout$chipsAnimator$1 chipsAnimator;
    private WeakReference<ChipGroupLayoutDelegate> delegate;
    private int horizontalItemSpacing;
    private boolean isMultiline;
    private ChipItemViewProvider provider;
    private int rowCount;
    private int verticalItemSpacing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isMultiline = true;
        this.delegate = new WeakReference<>(null);
        final ChipLayout$chipsAnimator$1 chipLayout$chipsAnimator$1 = new ChipLayout$chipsAnimator$1();
        chipLayout$chipsAnimator$1.setFloatValues(1.0f, 0.0f);
        chipLayout$chipsAnimator$1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.ChipLayout$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ChipLayout.chipsAnimator$lambda$2$lambda$1(ChipLayout$chipsAnimator$1.this, valueAnimator);
            }
        });
        this.chipsAnimator = chipLayout$chipsAnimator$1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.isMultiline = true;
        this.delegate = new WeakReference<>(null);
        final ChipLayout$chipsAnimator$1 chipLayout$chipsAnimator$1 = new ChipLayout$chipsAnimator$1();
        chipLayout$chipsAnimator$1.setFloatValues(1.0f, 0.0f);
        chipLayout$chipsAnimator$1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.ChipLayout$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ChipLayout.chipsAnimator$lambda$2$lambda$1(ChipLayout$chipsAnimator$1.this, valueAnimator);
            }
        });
        this.chipsAnimator = chipLayout$chipsAnimator$1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipLayout(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.isMultiline = true;
        this.delegate = new WeakReference<>(null);
        final ChipLayout$chipsAnimator$1 chipLayout$chipsAnimator$1 = new ChipLayout$chipsAnimator$1();
        chipLayout$chipsAnimator$1.setFloatValues(1.0f, 0.0f);
        chipLayout$chipsAnimator$1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.ChipLayout$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ChipLayout.chipsAnimator$lambda$2$lambda$1(ChipLayout$chipsAnimator$1.this, valueAnimator);
            }
        });
        this.chipsAnimator = chipLayout$chipsAnimator$1;
    }

    /* renamed from: getProvider$dxeditors_release, reason: from getter */
    public final ChipItemViewProvider getProvider() {
        return this.provider;
    }

    public final void setProvider$dxeditors_release(ChipItemViewProvider chipItemViewProvider) {
        this.provider = chipItemViewProvider;
    }

    /* renamed from: isMultiline$dxeditors_release, reason: from getter */
    public final boolean getIsMultiline() {
        return this.isMultiline;
    }

    public final void setMultiline$dxeditors_release(boolean z) {
        if (this.isMultiline != z) {
            this.isMultiline = z;
            ChipGroupLayoutDelegate chipGroupLayoutDelegate = this.delegate.get();
            if (chipGroupLayoutDelegate != null) {
                chipGroupLayoutDelegate.onMultilineChange();
            }
        }
    }

    /* renamed from: getVerticalItemSpacing$dxeditors_release, reason: from getter */
    public final int getVerticalItemSpacing() {
        return this.verticalItemSpacing;
    }

    public final void setVerticalItemSpacing$dxeditors_release(int i) {
        if (this.verticalItemSpacing != i) {
            this.verticalItemSpacing = i;
            requestLayout();
        }
    }

    /* renamed from: getHorizontalItemSpacing$dxeditors_release, reason: from getter */
    public final int getHorizontalItemSpacing() {
        return this.horizontalItemSpacing;
    }

    public final void setHorizontalItemSpacing$dxeditors_release(int i) {
        if (this.horizontalItemSpacing != i) {
            this.horizontalItemSpacing = i;
            requestLayout();
        }
    }

    public final void setDelegate(ChipGroupLayoutDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = new WeakReference<>(delegate);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int minimumWidth;
        int i2;
        int makeMeasureSpec;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int i3 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i3 - getPaddingRight();
        int i4 = 0;
        int childCount = getChildCount() - 1;
        int i5 = paddingTop;
        while (-1 < childCount) {
            View childAt = getChildAt(childCount);
            ChipItemViewProvider chipItemViewProvider = this.provider;
            if (chipItemViewProvider != null) {
                Intrinsics.checkNotNull(childAt);
                chipItemViewProvider.updateView(childAt, (getChildCount() - 1) - childCount);
            }
            if (childAt.getVisibility() == 8) {
                i = i3;
            } else {
                if (childAt.getLayoutParams().width == -1) {
                    if (childAt.getMinimumWidth() + paddingLeft > paddingRight) {
                        int max = Math.max(childAt.getMinimumWidth(), i3 - getPaddingLeft());
                        i2 = BasicMeasure.EXACTLY;
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY);
                    } else {
                        if (!this.isMultiline || mode == 0) {
                            minimumWidth = childAt.getMinimumWidth();
                        } else {
                            minimumWidth = Math.max(childAt.getMinimumWidth(), i3 - paddingLeft);
                        }
                        i2 = BasicMeasure.EXACTLY;
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(minimumWidth, BasicMeasure.EXACTLY);
                    }
                    i = i3;
                    measureChild(childAt, makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(paddingTop - i5, childAt.getMinimumHeight()), i2));
                } else {
                    i = i3;
                    measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
                }
                if (childAt.getMeasuredWidth() + paddingLeft > paddingRight && this.isMultiline) {
                    paddingLeft = getPaddingLeft();
                    i5 = this.verticalItemSpacing + paddingTop;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                paddingTop = Math.max(paddingTop, i5 + childAt.getMeasuredHeight());
                if (measuredWidth > i4) {
                    i4 = measuredWidth;
                }
                paddingLeft += childAt.getMeasuredWidth() + this.horizontalItemSpacing;
            }
            childCount--;
            i3 = i;
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i4 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    private final int getMeasuredDimension(int size, int mode, int childrenEdge) {
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? childrenEdge : size;
        }
        return Math.min(childrenEdge, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chipsAnimator$lambda$2$lambda$1(ChipLayout$chipsAnimator$1 this_apply, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Iterator<T> it2 = this_apply.getDeltas().iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            View view = (View) pair.component1();
            PointF pointF = (PointF) pair.component2();
            float f = -floatValue;
            view.setTranslationX(pointF.x * f);
            view.setTranslationY(f * pointF.y);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.chipsAnimator.reset();
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        int paddingStart = getPaddingStart() + l;
        int paddingTop = getPaddingTop() + t;
        int paddingEnd = r - getPaddingEnd();
        int i = paddingTop;
        for (int childCount = getChildCount() - 1; -1 < childCount; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 8) {
                childAt.layout(paddingStart, paddingTop, paddingStart, paddingTop);
            } else {
                int measuredWidth = childAt.getMeasuredWidth() + paddingStart;
                if (this.isMultiline && measuredWidth > paddingEnd) {
                    paddingStart = getPaddingStart() + l;
                    paddingTop = this.verticalItemSpacing + i;
                    this.rowCount++;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + paddingStart;
                int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                i = Math.max(measuredHeight, i);
                if (childAt.getWidth() > 0 && childAt.getHeight() > 0) {
                    ChipLayout$chipsAnimator$1 chipLayout$chipsAnimator$1 = this.chipsAnimator;
                    Intrinsics.checkNotNull(childAt);
                    chipLayout$chipsAnimator$1.add(childAt, paddingStart - childAt.getLeft(), paddingTop - childAt.getTop());
                }
                childAt.layout(paddingStart, paddingTop, measuredWidth2, measuredHeight);
                paddingStart += childAt.getMeasuredWidth() + this.horizontalItemSpacing;
            }
        }
        this.chipsAnimator.start();
    }
}
