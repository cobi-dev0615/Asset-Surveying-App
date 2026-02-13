package com.devexpress.editors.model.drawables;

import android.graphics.Path;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CornerTreatments.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/model/drawables/CutCornerTreatment;", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "()V", "addCornerToPath", "", "path", "Landroid/graphics/Path;", "startPoint", "Landroid/graphics/PointF;", "endPoint", "cornerIndex", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CutCornerTreatment implements CornerTreatment {
    @Override // com.devexpress.editors.model.drawables.CornerTreatment
    public void addCornerToPath(Path path, PointF startPoint, PointF endPoint, int cornerIndex) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        path.lineTo(endPoint.x, endPoint.y);
    }
}
