package com.devexpress.editors.model.drawables;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.devexpress.editors.model.BorderRounds;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathBuilder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J0\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\fH\u0014J&\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006 "}, d2 = {"Lcom/devexpress/editors/model/drawables/PathBuilder;", "", "()V", "cornerEnd", "Landroid/graphics/PointF;", "cornerStart", "keyPoints", "", "[Landroid/graphics/PointF;", "addCornerPointsToKeyPoints", "", "cornerIndex", "", "rect", "Landroid/graphics/RectF;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "addCornerToPath", "path", "Landroid/graphics/Path;", "startPoint", "endPoint", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "addEdgeToPath", "edgeIndex", "buildPath", "getCornerEndIndex", "getCornerStartIndex", "getEdgeEndIndex", "getEdgeStartIndex", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class PathBuilder {
    public static final int BOTTOM_LEFT_CORNER_INDEX = 3;
    public static final int BOTTOM_RIGHT_CORNER_INDEX = 2;
    private static final int CORNER_COUNT = 4;
    private static final int KEY_POINT_COUNT = 9;
    public static final int TOP_LEFT_CORNER_INDEX = 0;
    public static final int TOP_RIGHT_CORNER_INDEX = 1;
    private final PointF cornerEnd;
    private final PointF cornerStart;
    private final PointF[] keyPoints;
    private static final Function4<RectF, BorderRounds, PointF, PointF, Unit>[] cornerPointsCalculators = {new Function4<RectF, BorderRounds, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.PathBuilder$Companion$cornerPointsCalculators$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(RectF rectF, BorderRounds borderRounds, PointF pointF, PointF pointF2) {
            invoke2(rectF, borderRounds, pointF, pointF2);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RectF r, BorderRounds s, PointF sp, PointF ep) {
            Intrinsics.checkNotNullParameter(r, "r");
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            sp.set(r.left, r.top + s.topLeft);
            ep.set(r.left + s.topLeft, r.top);
        }
    }, new Function4<RectF, BorderRounds, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.PathBuilder$Companion$cornerPointsCalculators$2
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(RectF rectF, BorderRounds borderRounds, PointF pointF, PointF pointF2) {
            invoke2(rectF, borderRounds, pointF, pointF2);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RectF r, BorderRounds s, PointF sp, PointF ep) {
            Intrinsics.checkNotNullParameter(r, "r");
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            sp.set(r.right - s.topRight, r.top);
            ep.set(r.right, r.top + s.topRight);
        }
    }, new Function4<RectF, BorderRounds, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.PathBuilder$Companion$cornerPointsCalculators$3
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(RectF rectF, BorderRounds borderRounds, PointF pointF, PointF pointF2) {
            invoke2(rectF, borderRounds, pointF, pointF2);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RectF r, BorderRounds s, PointF sp, PointF ep) {
            Intrinsics.checkNotNullParameter(r, "r");
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            sp.set(r.right, r.bottom - s.bottomRight);
            ep.set(r.right - s.bottomRight, r.bottom);
        }
    }, new Function4<RectF, BorderRounds, PointF, PointF, Unit>() { // from class: com.devexpress.editors.model.drawables.PathBuilder$Companion$cornerPointsCalculators$4
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(RectF rectF, BorderRounds borderRounds, PointF pointF, PointF pointF2) {
            invoke2(rectF, borderRounds, pointF, pointF2);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RectF r, BorderRounds s, PointF sp, PointF ep) {
            Intrinsics.checkNotNullParameter(r, "r");
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(sp, "sp");
            Intrinsics.checkNotNullParameter(ep, "ep");
            sp.set(r.left + s.bottomLeft, r.bottom);
            ep.set(r.left, r.bottom - s.bottomLeft);
        }
    }};

    private final int getCornerEndIndex(int cornerIndex) {
        return (cornerIndex * 2) + 1;
    }

    private final int getCornerStartIndex(int cornerIndex) {
        return cornerIndex * 2;
    }

    private final int getEdgeEndIndex(int cornerIndex) {
        return (cornerIndex * 2) + 2;
    }

    private final int getEdgeStartIndex(int cornerIndex) {
        return (cornerIndex * 2) + 1;
    }

    public PathBuilder() {
        PointF[] pointFArr = new PointF[9];
        for (int i = 0; i < 9; i++) {
            pointFArr[i] = new PointF();
        }
        this.keyPoints = pointFArr;
        this.cornerStart = new PointF();
        this.cornerEnd = new PointF();
    }

    public final void buildPath(RectF rect, CornerTreatment cornerTreatment, BorderRounds cornerSize, Path path) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        Intrinsics.checkNotNullParameter(path, "path");
        path.reset();
        for (int i = 0; i < 4; i++) {
            addCornerPointsToKeyPoints(i, rect, cornerSize);
        }
        PointF[] pointFArr = this.keyPoints;
        pointFArr[8].set(pointFArr[0]);
        path.moveTo(this.keyPoints[0].x, this.keyPoints[0].y);
        for (int i2 = 0; i2 < 4; i2++) {
            PointF pointF = this.keyPoints[getCornerStartIndex(i2)];
            PointF pointF2 = this.keyPoints[getCornerEndIndex(i2)];
            if (!Intrinsics.areEqual(pointF, pointF2)) {
                addCornerToPath(path, pointF, pointF2, i2, cornerTreatment);
            }
            addEdgeToPath(path, this.keyPoints[getEdgeStartIndex(i2)], this.keyPoints[getEdgeEndIndex(i2)], i2);
        }
        path.close();
    }

    protected void addCornerToPath(Path path, PointF startPoint, PointF endPoint, int cornerIndex, CornerTreatment cornerTreatment) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        Intrinsics.checkNotNullParameter(cornerTreatment, "cornerTreatment");
        cornerTreatment.addCornerToPath(path, startPoint, endPoint, cornerIndex);
    }

    protected void addEdgeToPath(Path path, PointF startPoint, PointF endPoint, int edgeIndex) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        path.lineTo(endPoint.x, endPoint.y);
    }

    private final void addCornerPointsToKeyPoints(int cornerIndex, RectF rect, BorderRounds cornerSize) {
        cornerPointsCalculators[cornerIndex].invoke(rect, cornerSize, this.cornerStart, this.cornerEnd);
        this.keyPoints[getCornerStartIndex(cornerIndex)].set(this.cornerStart.x, this.cornerStart.y);
        this.keyPoints[getCornerEndIndex(cornerIndex)].set(this.cornerEnd.x, this.cornerEnd.y);
    }
}
