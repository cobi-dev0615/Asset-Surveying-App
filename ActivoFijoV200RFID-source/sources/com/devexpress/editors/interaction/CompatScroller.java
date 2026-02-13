package com.devexpress.editors.interaction;

import android.content.Context;
import android.widget.OverScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompatScroller.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\fJF\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/devexpress/editors/interaction/CompatScroller;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currX", "", "getCurrX", "()I", "currY", "getCurrY", "isFinished", "", "()Z", "overScroller", "Landroid/widget/OverScroller;", "getOverScroller", "()Landroid/widget/OverScroller;", "setOverScroller", "(Landroid/widget/OverScroller;)V", "computeScrollOffset", "fling", "", "startX", "startY", "velocityX", "velocityY", "minX", "maxX", "minY", "maxY", "forceFinished", "finished", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CompatScroller {
    private OverScroller overScroller;

    public CompatScroller(Context context) {
        this.overScroller = new OverScroller(context);
    }

    public final OverScroller getOverScroller() {
        return this.overScroller;
    }

    public final void setOverScroller(OverScroller overScroller) {
        Intrinsics.checkNotNullParameter(overScroller, "<set-?>");
        this.overScroller = overScroller;
    }

    public final void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
        this.overScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
    }

    public final void forceFinished(boolean finished) {
        this.overScroller.forceFinished(finished);
    }

    public final boolean isFinished() {
        return this.overScroller.isFinished();
    }

    public final boolean computeScrollOffset() {
        this.overScroller.computeScrollOffset();
        return this.overScroller.computeScrollOffset();
    }

    public final int getCurrX() {
        return this.overScroller.getCurrX();
    }

    public final int getCurrY() {
        return this.overScroller.getCurrY();
    }
}
