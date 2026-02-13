package com.devexpress.editors.interaction;

import android.view.ScaleGestureDetector;
import com.devexpress.editors.utils.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScaleGestureListener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/devexpress/editors/interaction/ScaleGestureListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "frameTransformation", "Lcom/devexpress/editors/utils/RectF;", "imageTransformation", "maxImageTransformation", "(Lcom/devexpress/editors/utils/RectF;Lcom/devexpress/editors/utils/RectF;Lcom/devexpress/editors/utils/RectF;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
    private final RectF frameTransformation;
    private final RectF imageTransformation;
    private final RectF maxImageTransformation;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
    }

    public ScaleGestureListener(RectF frameTransformation, RectF imageTransformation, RectF maxImageTransformation) {
        Intrinsics.checkNotNullParameter(frameTransformation, "frameTransformation");
        Intrinsics.checkNotNullParameter(imageTransformation, "imageTransformation");
        Intrinsics.checkNotNullParameter(maxImageTransformation, "maxImageTransformation");
        this.frameTransformation = frameTransformation;
        this.imageTransformation = imageTransformation;
        this.maxImageTransformation = maxImageTransformation;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        if (this.imageTransformation.getHeight() * detector.getScaleFactor() < this.frameTransformation.getHeight() || this.imageTransformation.getWidth() * detector.getScaleFactor() < this.frameTransformation.getWidth() || this.imageTransformation.getHeight() * detector.getScaleFactor() > this.maxImageTransformation.getHeight() || this.imageTransformation.getWidth() * detector.getScaleFactor() > this.maxImageTransformation.getWidth()) {
            return false;
        }
        float focusX = detector.getFocusX() - this.imageTransformation.getX();
        float focusY = detector.getFocusY() - this.imageTransformation.getY();
        float scaleFactor = detector.getScaleFactor() * focusX;
        float scaleFactor2 = detector.getScaleFactor() * focusY;
        RectF rectF = this.imageTransformation;
        rectF.setX(rectF.getX() - (scaleFactor - focusX));
        RectF rectF2 = this.imageTransformation;
        rectF2.setY(rectF2.getY() - (scaleFactor2 - focusY));
        RectF rectF3 = this.imageTransformation;
        rectF3.setWidth(rectF3.getWidth() * detector.getScaleFactor());
        RectF rectF4 = this.imageTransformation;
        rectF4.setHeight(rectF4.getHeight() * detector.getScaleFactor());
        return true;
    }
}
