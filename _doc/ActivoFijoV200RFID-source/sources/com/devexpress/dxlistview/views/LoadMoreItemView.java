package com.devexpress.dxlistview.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LoadMoreItemView.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0014J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/devexpress/dxlistview/views/LoadMoreItemView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "progressBar", "Landroid/widget/ProgressBar;", "onLayout", "", "changed", "", "l", "", "t", "r", "b", "setIndicatorColor", TypedValues.Custom.S_COLOR, "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoadMoreItemView extends ViewGroup {
    private final ProgressBar progressBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ProgressBar progressBar = new ProgressBar(context);
        this.progressBar = progressBar;
        progressBar.setIndeterminate(true);
        addView(progressBar);
    }

    public final void setIndicatorColor(int color) {
        this.progressBar.getIndeterminateDrawable().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i = r - l;
        int i2 = b - t;
        int i3 = i / 2;
        int i4 = i2 / 2;
        int coerceAtMost = RangesKt.coerceAtMost(i, i2) / 2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(coerceAtMost, BasicMeasure.EXACTLY);
        this.progressBar.measure(makeMeasureSpec, makeMeasureSpec);
        int i5 = coerceAtMost / 2;
        this.progressBar.layout(i3 - i5, i4 - i5, i3 + i5, i4 + i5);
    }
}
