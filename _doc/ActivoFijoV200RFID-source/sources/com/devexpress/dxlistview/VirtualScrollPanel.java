package com.devexpress.dxlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VirtualScrollPanel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J0\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0014J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0014J\b\u0010&\u001a\u00020\u0017H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/devexpress/dxlistview/VirtualScrollPanel;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionMoveProcessed", "", "allowRequestLayout", "mTouchSlop", "value", "Lcom/devexpress/dxlistview/DXVirtualScrollView;", "scrollView", "getScrollView", "()Lcom/devexpress/dxlistview/DXVirtualScrollView;", "setScrollView", "(Lcom/devexpress/dxlistview/DXVirtualScrollView;)V", "addViewInLayout", "", "child", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class VirtualScrollPanel extends ViewGroup {
    private boolean actionMoveProcessed;
    private boolean allowRequestLayout;
    private final int mTouchSlop;
    private DXVirtualScrollView scrollView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualScrollPanel(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.allowRequestLayout = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualScrollPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.allowRequestLayout = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualScrollPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.allowRequestLayout = true;
    }

    public final DXVirtualScrollView getScrollView() {
        return this.scrollView;
    }

    public final void setScrollView(DXVirtualScrollView dXVirtualScrollView) {
        this.scrollView = dXVirtualScrollView;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        DXVirtualScrollView dXVirtualScrollView = this.scrollView;
        if (dXVirtualScrollView != null) {
            dXVirtualScrollView.layoutSubviews();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DXVirtualScrollView dXVirtualScrollView = this.scrollView;
        if (dXVirtualScrollView == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        Intrinsics.checkNotNull(dXVirtualScrollView);
        dXVirtualScrollView.measureSubviews();
        DXVirtualScrollView dXVirtualScrollView2 = this.scrollView;
        Intrinsics.checkNotNull(dXVirtualScrollView2);
        int i = dXVirtualScrollView2.getExtentContentSize().width;
        DXVirtualScrollView dXVirtualScrollView3 = this.scrollView;
        Intrinsics.checkNotNull(dXVirtualScrollView3);
        setMeasuredDimension(i, dXVirtualScrollView3.getExtentContentSize().height);
    }

    public void addViewInLayout(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(child, -1, layoutParams, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r1 != 3) goto L18;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = super.dispatchTouchEvent(r12)
            int r1 = r12.getAction()
            r2 = 1
            if (r1 == 0) goto L50
            if (r1 == r2) goto L25
            r3 = 2
            if (r1 == r3) goto L19
            r3 = 3
            if (r1 == r3) goto L25
            goto L5b
        L19:
            com.devexpress.dxlistview.DXVirtualScrollView r0 = r11.scrollView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r12 = r0.processTouchEvent(r12)
            r11.actionMoveProcessed = r12
            goto L5b
        L25:
            boolean r1 = r11.actionMoveProcessed
            if (r1 != 0) goto L47
            if (r0 != 0) goto L2c
            goto L47
        L2c:
            r9 = 0
            r10 = 0
            r3 = 0
            r5 = 0
            r7 = 3
            r8 = 0
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r3, r5, r7, r8, r9, r10)
            com.devexpress.dxlistview.DXVirtualScrollView r0 = r11.scrollView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r0.processTouchEvent(r12)
            r12.recycle()
            goto L5b
        L47:
            com.devexpress.dxlistview.DXVirtualScrollView r0 = r11.scrollView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.processTouchEvent(r12)
            goto L5b
        L50:
            r0 = 0
            r11.actionMoveProcessed = r0
            com.devexpress.dxlistview.DXVirtualScrollView r0 = r11.scrollView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.processTouchEvent(r12)
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.dxlistview.VirtualScrollPanel.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.allowRequestLayout) {
            super.requestLayout();
        }
    }
}
