package com.devexpress.dxlistview.swipes;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxlistview.helpers.MathHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeItemContainerView.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0014J\u0018\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0014R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeItemContainerView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lcom/devexpress/dxlistview/swipes/DXSwipeItemAnchor;", "anchor", "getAnchor", "()Lcom/devexpress/dxlistview/swipes/DXSwipeItemAnchor;", "setAnchor", "(Lcom/devexpress/dxlistview/swipes/DXSwipeItemAnchor;)V", "", "swipeItemSize", "getSwipeItemSize", "()I", "setSwipeItemSize", "(I)V", "Landroid/view/View;", "swipeItemView", "getSwipeItemView", "()Landroid/view/View;", "setSwipeItemView", "(Landroid/view/View;)V", "", "translationContentProgress", "getTranslationContentProgress", "()F", "setTranslationContentProgress", "(F)V", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SwipeItemContainerView extends ViewGroup {
    private DXSwipeItemAnchor anchor;
    private int swipeItemSize;
    private View swipeItemView;
    private float translationContentProgress;

    /* compiled from: SwipeItemContainerView.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXSwipeItemAnchor.values().length];
            try {
                iArr[DXSwipeItemAnchor.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXSwipeItemAnchor.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DXSwipeItemAnchor.Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DXSwipeItemAnchor.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeItemContainerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.anchor = DXSwipeItemAnchor.Left;
    }

    public final DXSwipeItemAnchor getAnchor() {
        return this.anchor;
    }

    public final void setAnchor(DXSwipeItemAnchor value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.anchor != value) {
            this.anchor = value;
            requestLayout();
        }
    }

    public final int getSwipeItemSize() {
        return this.swipeItemSize;
    }

    public final void setSwipeItemSize(int i) {
        if (this.swipeItemSize != i) {
            this.swipeItemSize = i;
            requestLayout();
        }
    }

    public final View getSwipeItemView() {
        return this.swipeItemView;
    }

    public final void setSwipeItemView(View view) {
        if (Intrinsics.areEqual(this.swipeItemView, view)) {
            return;
        }
        View view2 = this.swipeItemView;
        if (view2 != null) {
            removeView(view2);
        }
        this.swipeItemView = view;
        if (view != null) {
            addView(view);
        }
    }

    public final float getTranslationContentProgress() {
        return this.translationContentProgress;
    }

    public final void setTranslationContentProgress(float f) {
        if (this.translationContentProgress == f) {
            return;
        }
        this.translationContentProgress = f;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view;
        View view2;
        if ((this.anchor == DXSwipeItemAnchor.Left || this.anchor == DXSwipeItemAnchor.Right) && (view = this.swipeItemView) != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(this.swipeItemSize, BasicMeasure.EXACTLY), heightMeasureSpec);
        }
        if ((this.anchor == DXSwipeItemAnchor.Top || this.anchor == DXSwipeItemAnchor.Bottom) && (view2 = this.swipeItemView) != null) {
            view2.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.swipeItemSize, BasicMeasure.EXACTLY));
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Rect rect;
        Rect rect2 = new Rect(0, 0, r - l, b - t);
        int i = WhenMappings.$EnumSwitchMapping$0[this.anchor.ordinal()];
        if (i == 1) {
            int round = MathHelper.round((rect2.width() - this.swipeItemSize) * this.translationContentProgress);
            rect = new Rect(round, 0, this.swipeItemSize + round, rect2.height());
        } else if (i == 2) {
            int round2 = MathHelper.round((rect2.height() - this.swipeItemSize) * this.translationContentProgress);
            rect = new Rect(0, round2, rect2.width(), this.swipeItemSize + round2);
        } else if (i == 3) {
            int round3 = MathHelper.round((rect2.width() - this.swipeItemSize) * this.translationContentProgress);
            rect = new Rect((rect2.width() - this.swipeItemSize) - round3, 0, rect2.width() - round3, rect2.height());
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            int round4 = MathHelper.round((rect2.height() - this.swipeItemSize) * this.translationContentProgress);
            rect = new Rect(0, (rect2.height() - this.swipeItemSize) - round4, rect2.width(), rect2.height() - round4);
        }
        View view = this.swipeItemView;
        if (view != null) {
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
