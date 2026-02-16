package com.devexpress.dxgrid.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmoothValueAnimator.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006H$J\b\u0010\u0014\u001a\u00020\u000bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/devexpress/dxgrid/utils/SmoothValueAnimator;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "step", "", "total", "getView", "()Landroid/view/View;", "animate", "", "value", "cancel", "f", "", "x", "onFinish", "onNewDeltaValue", "delta", "onStart", "Companion", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SmoothValueAnimator {
    public static final int FRAMES = 10;
    private int step;
    private int total;
    private final View view;

    protected void onFinish() {
    }

    protected abstract void onNewDeltaValue(int delta);

    protected void onStart() {
    }

    public SmoothValueAnimator(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final View getView() {
        return this.view;
    }

    public final void animate(final int value) {
        this.total = 0;
        this.step = 0;
        Runnable runnable = new Runnable() { // from class: com.devexpress.dxgrid.utils.SmoothValueAnimator$animate$step$1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                i = SmoothValueAnimator.this.step;
                if (i <= 10) {
                    i2 = SmoothValueAnimator.this.step;
                    int f = (int) (SmoothValueAnimator.this.f(i2 / 10.0d) * value);
                    i3 = SmoothValueAnimator.this.total;
                    int i6 = f - i3;
                    SmoothValueAnimator smoothValueAnimator = SmoothValueAnimator.this;
                    i4 = smoothValueAnimator.total;
                    smoothValueAnimator.total = i4 + i6;
                    SmoothValueAnimator smoothValueAnimator2 = SmoothValueAnimator.this;
                    i5 = smoothValueAnimator2.step;
                    smoothValueAnimator2.step = i5 + 1;
                    SmoothValueAnimator.this.onNewDeltaValue(i6);
                    SmoothValueAnimator.this.getView().postDelayed(this, 4L);
                    return;
                }
                SmoothValueAnimator.this.onFinish();
            }
        };
        onStart();
        this.view.post(runnable);
    }

    public final void cancel() {
        this.step = 10;
    }

    protected double f(double x) {
        return Math.pow(x, 0.25d);
    }
}
