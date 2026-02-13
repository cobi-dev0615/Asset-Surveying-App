package com.devexpress.dxlistview.core;

import android.animation.TimeInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DragDropManager.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/dxlistview/core/AnimationOptions;", "", TypedValues.TransitionType.S_DURATION, "", "interpolator", "Landroid/animation/TimeInterpolator;", "(JLandroid/animation/TimeInterpolator;)V", "getDuration", "()J", "getInterpolator", "()Landroid/animation/TimeInterpolator;", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnimationOptions {
    private final long duration;
    private final TimeInterpolator interpolator;

    public AnimationOptions(long j, TimeInterpolator timeInterpolator) {
        this.duration = j;
        this.interpolator = timeInterpolator;
    }

    public /* synthetic */ AnimationOptions(long j, TimeInterpolator timeInterpolator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : timeInterpolator);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final TimeInterpolator getInterpolator() {
        return this.interpolator;
    }
}
