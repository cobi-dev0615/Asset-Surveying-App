package com.devexpress.editors.model.drawables;

import android.graphics.Path;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnderlinePathBuilder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/model/drawables/UnderlinePathBuilder;", "Lcom/devexpress/editors/model/drawables/PathBuilder;", "()V", "addCornerToPath", "", "path", "Landroid/graphics/Path;", "startPoint", "Landroid/graphics/PointF;", "endPoint", "cornerIndex", "", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "addEdgeToPath", "edgeIndex", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UnderlinePathBuilder extends PathBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function3<Path, PointF, PointF, Unit>[] edgeBuilders = {new Function3<Path, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.UnderlinePathBuilder$Companion$edgeBuilders$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Path path, PointF pointF, PointF pointF2) {
            Intrinsics.checkNotNullParameter(path, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pointF, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(pointF2, "<anonymous parameter 2>");
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Path path, PointF pointF, PointF pointF2) {
            invoke2(path, pointF, pointF2);
            return Unit.INSTANCE;
        }
    }, new Function3<Path, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.UnderlinePathBuilder$Companion$edgeBuilders$2
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Path path, PointF pointF, PointF pointF2) {
            Intrinsics.checkNotNullParameter(path, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pointF, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(pointF2, "<anonymous parameter 2>");
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Path path, PointF pointF, PointF pointF2) {
            invoke2(path, pointF, pointF2);
            return Unit.INSTANCE;
        }
    }, new Function3<Path, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.UnderlinePathBuilder$Companion$edgeBuilders$3
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Path path, PointF pointF, PointF pointF2) {
            invoke2(path, pointF, pointF2);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Path p, PointF sp, PointF ep) {
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            p.moveTo(sp.x, sp.y);
            p.lineTo(ep.x, ep.y);
        }
    }, new Function3<Path, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.UnderlinePathBuilder$Companion$edgeBuilders$4
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Path path, PointF pointF, PointF pointF2) {
            Intrinsics.checkNotNullParameter(path, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pointF, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(pointF2, "<anonymous parameter 2>");
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Path path, PointF pointF, PointF pointF2) {
            invoke2(path, pointF, pointF2);
            return Unit.INSTANCE;
        }
    }};

    @Override // com.devexpress.editors.model.drawables.PathBuilder
    protected void addCornerToPath(Path path, PointF startPoint, PointF endPoint, int cornerIndex, CornerTreatment cornerTreatment) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
    }

    /* compiled from: UnderlinePathBuilder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R1\u0010\u0003\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/model/drawables/UnderlinePathBuilder$Companion;", "", "()V", "edgeBuilders", "", "Lkotlin/Function3;", "Landroid/graphics/Path;", "Landroid/graphics/PointF;", "", "getEdgeBuilders", "()[Lkotlin/jvm/functions/Function3;", "[Lkotlin/jvm/functions/Function3;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function3<Path, PointF, PointF, Unit>[] getEdgeBuilders() {
            return UnderlinePathBuilder.edgeBuilders;
        }
    }

    @Override // com.devexpress.editors.model.drawables.PathBuilder
    protected void addEdgeToPath(Path path, PointF startPoint, PointF endPoint, int edgeIndex) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        edgeBuilders[edgeIndex].invoke(path, startPoint, endPoint);
    }
}
