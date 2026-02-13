package com.devexpress.editors.utils.drawablemanager;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.drawables.CornerTreatment;
import com.devexpress.editors.model.drawables.MaterialRectDrawable;
import com.devexpress.editors.style.DropDownTextEditStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: DropDownDrawableManager.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/MaterialRectDrawableCreator;", "", "()V", "create", "Landroid/graphics/drawable/Drawable;", "style", "Lcom/devexpress/editors/style/DropDownTextEditStyle;", "treatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "cornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class MaterialRectDrawableCreator {
    public static final MaterialRectDrawableCreator INSTANCE = new MaterialRectDrawableCreator();

    private MaterialRectDrawableCreator() {
    }

    public final Drawable create(DropDownTextEditStyle style, CornerTreatment treatment) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(treatment, "treatment");
        return create(style, treatment, style.getBorderRounds());
    }

    public final Drawable create(DropDownTextEditStyle style, CornerTreatment treatment, BorderRounds cornerSize) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(treatment, "treatment");
        Intrinsics.checkNotNullParameter(cornerSize, "cornerSize");
        float dropDownBorderThickness = style.getDropDownBorderThickness();
        MaterialRectDrawable materialRectDrawable = new MaterialRectDrawable(null, null, null, false, 0, 0, 0, WorkQueueKt.MASK, null);
        materialRectDrawable.setPaintStyle(Paint.Style.FILL_AND_STROKE);
        materialRectDrawable.setCornerSize(cornerSize);
        materialRectDrawable.setCornerTreatment(treatment);
        materialRectDrawable.setFillColor(style.getDropDownBackgroundColor());
        materialRectDrawable.setStrokeColor(style.getDropDownBorderColor());
        materialRectDrawable.setStrokeWidth(dropDownBorderThickness);
        int i = (int) (dropDownBorderThickness + 0.5f);
        materialRectDrawable.setPadding(i, (int) (Math.max(cornerSize.topLeft, cornerSize.topRight) + dropDownBorderThickness + 0.5f), i, (int) (Math.max(cornerSize.topLeft, cornerSize.topRight) + dropDownBorderThickness + 0.5f));
        return materialRectDrawable;
    }
}
