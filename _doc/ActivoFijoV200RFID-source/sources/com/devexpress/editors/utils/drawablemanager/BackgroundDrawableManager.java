package com.devexpress.editors.utils.drawablemanager;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/BackgroundDrawableManager;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "applyLabelCutOut", "", "bounds", "Landroid/graphics/Rect;", "left", "", "top", "right", "bottom", "updateCornerSize", "updateCornerTreatment", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface BackgroundDrawableManager {
    void applyLabelCutOut(float left, float top, float right, float bottom);

    void applyLabelCutOut(Rect bounds);

    Drawable getDrawable();

    void updateCornerSize();

    void updateCornerTreatment();

    /* compiled from: BackgroundManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void applyLabelCutOut(BackgroundDrawableManager backgroundDrawableManager, Rect bounds) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            backgroundDrawableManager.applyLabelCutOut(bounds.left, bounds.top, bounds.right, bounds.bottom);
        }
    }
}
