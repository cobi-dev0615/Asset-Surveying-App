package com.devexpress.editors;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipLayout.kt */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\fR,\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"com/devexpress/editors/ChipLayout$chipsAnimator$1", "Landroid/animation/ValueAnimator;", "deltas", "", "Lkotlin/Pair;", "Landroid/view/View;", "Landroid/graphics/PointF;", "getDeltas", "()Ljava/util/List;", "setDeltas", "(Ljava/util/List;)V", "add", "", "view", "dx", "", "dy", "reset", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChipLayout$chipsAnimator$1 extends ValueAnimator {
    private List<Pair<View, PointF>> deltas = new ArrayList();

    ChipLayout$chipsAnimator$1() {
    }

    public final List<Pair<View, PointF>> getDeltas() {
        return this.deltas;
    }

    public final void setDeltas(List<Pair<View, PointF>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.deltas = list;
    }

    public final void reset() {
        if (isRunning()) {
            end();
        }
        this.deltas.clear();
    }

    public final void add(View view, int dx, int dy) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.deltas.add(new Pair<>(view, new PointF(dx, dy)));
    }
}
