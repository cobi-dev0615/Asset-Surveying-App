package com.devexpress.editors.interaction;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.utils.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationGestureListener.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/interaction/TranslationGestureListener;", "", "imageTransformation", "Lcom/devexpress/editors/utils/RectF;", "(Lcom/devexpress/editors/utils/RectF;)V", "oldPointerCount", "", "oldTranslationX", "", "oldTranslationY", "centerize", "n1", "n2", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TranslationGestureListener {
    private final RectF imageTransformation;
    private int oldPointerCount;
    private float oldTranslationX;
    private float oldTranslationY;

    private final float centerize(float n1, float n2) {
        return (n1 + n2) / 2;
    }

    public TranslationGestureListener(RectF imageTransformation) {
        Intrinsics.checkNotNullParameter(imageTransformation, "imageTransformation");
        this.imageTransformation = imageTransformation;
    }

    public final void onTouchEvent(MotionEvent event) {
        if (event == null) {
            return;
        }
        float x = event.getX(0);
        float y = event.getY(0);
        float x2 = event.getPointerCount() == 2 ? event.getX(1) : x;
        float y2 = event.getPointerCount() == 2 ? event.getY(1) : y;
        if (event.getPointerCount() != this.oldPointerCount || event.getAction() == 0) {
            this.oldTranslationX = centerize(x, x2);
            this.oldTranslationY = centerize(y, y2);
            this.oldPointerCount = event.getPointerCount();
        }
        if (event.getAction() == 2) {
            float centerize = centerize(x, x2);
            float centerize2 = centerize(y, y2);
            float f = centerize - this.oldTranslationX;
            float f2 = centerize2 - this.oldTranslationY;
            RectF rectF = this.imageTransformation;
            rectF.setX(rectF.getX() + f);
            RectF rectF2 = this.imageTransformation;
            rectF2.setY(rectF2.getY() + f2);
            this.oldTranslationX = centerize;
            this.oldTranslationY = centerize2;
        }
    }
}
