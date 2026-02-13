package com.devexpress.editors.model.drawables;

import android.graphics.Path;
import android.graphics.PointF;
import kotlin.Metadata;

/* compiled from: CornerTreatments.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/model/drawables/CornerTreatment;", "", "addCornerToPath", "", "path", "Landroid/graphics/Path;", "startPoint", "Landroid/graphics/PointF;", "endPoint", "cornerIndex", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CornerTreatment {
    void addCornerToPath(Path path, PointF startPoint, PointF endPoint, int cornerIndex);
}
