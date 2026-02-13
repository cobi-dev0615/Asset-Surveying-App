package com.devexpress.editors.model.drawables;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CornerTreatments.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/model/drawables/RoundCornerTreatment;", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "()V", "ovalRect", "Landroid/graphics/RectF;", "addCornerToPath", "", "path", "Landroid/graphics/Path;", "startPoint", "Landroid/graphics/PointF;", "endPoint", "cornerIndex", "", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoundCornerTreatment implements CornerTreatment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function3<PointF, PointF, RectF, Float>[] ovalCalculators = {new Function3<PointF, PointF, RectF, Float>() { // from class: com.devexpress.editors.model.drawables.RoundCornerTreatment$Companion$ovalCalculators$1
        @Override // kotlin.jvm.functions.Function3
        public final Float invoke(PointF sp, PointF ep, RectF oval) {
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(oval, "oval");
            float f = 2;
            oval.set(sp.x, ep.y, (ep.x * f) - sp.x, (f * sp.y) - ep.y);
            return Float.valueOf(180.0f);
        }
    }, new Function3<PointF, PointF, RectF, Float>() { // from class: com.devexpress.editors.model.drawables.RoundCornerTreatment$Companion$ovalCalculators$2
        @Override // kotlin.jvm.functions.Function3
        public final Float invoke(PointF sp, PointF ep, RectF oval) {
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(oval, "oval");
            float f = 2;
            oval.set((sp.x * f) - ep.x, sp.y, ep.x, (f * ep.y) - sp.y);
            return Float.valueOf(270.0f);
        }
    }, new Function3<PointF, PointF, RectF, Float>() { // from class: com.devexpress.editors.model.drawables.RoundCornerTreatment$Companion$ovalCalculators$3
        @Override // kotlin.jvm.functions.Function3
        public final Float invoke(PointF sp, PointF ep, RectF oval) {
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(oval, "oval");
            float f = 2;
            oval.set((ep.x * f) - sp.x, (f * sp.y) - ep.y, sp.x, ep.y);
            return Float.valueOf(0.0f);
        }
    }, new Function3<PointF, PointF, RectF, Float>() { // from class: com.devexpress.editors.model.drawables.RoundCornerTreatment$Companion$ovalCalculators$4
        @Override // kotlin.jvm.functions.Function3
        public final Float invoke(PointF sp, PointF ep, RectF oval) {
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            Intrinsics.checkNotNullParameter(oval, "oval");
            float f = 2;
            oval.set(ep.x, (ep.y * f) - sp.y, (f * sp.x) - ep.x, sp.y);
            return Float.valueOf(90.0f);
        }
    }};
    public static final float rectAngle = 90.0f;
    private final RectF ovalRect = new RectF();

    /* compiled from: CornerTreatments.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R1\u0010\u0003\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/devexpress/editors/model/drawables/RoundCornerTreatment$Companion;", "", "()V", "ovalCalculators", "", "Lkotlin/Function3;", "Landroid/graphics/PointF;", "Landroid/graphics/RectF;", "", "getOvalCalculators", "()[Lkotlin/jvm/functions/Function3;", "[Lkotlin/jvm/functions/Function3;", "rectAngle", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function3<PointF, PointF, RectF, Float>[] getOvalCalculators() {
            return RoundCornerTreatment.ovalCalculators;
        }
    }

    @Override // com.devexpress.editors.model.drawables.CornerTreatment
    public void addCornerToPath(Path path, PointF startPoint, PointF endPoint, int cornerIndex) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        path.arcTo(this.ovalRect, ovalCalculators[cornerIndex].invoke(startPoint, endPoint, this.ovalRect).floatValue(), 90.0f);
    }
}
