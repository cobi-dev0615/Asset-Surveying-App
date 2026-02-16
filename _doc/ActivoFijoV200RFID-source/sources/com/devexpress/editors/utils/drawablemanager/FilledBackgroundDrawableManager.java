package com.devexpress.editors.utils.drawablemanager;

import android.graphics.drawable.Drawable;
import com.devexpress.editors.model.drawables.AnimationManagerDrawable;
import com.devexpress.editors.model.drawables.UnderlinedMaterialRectDrawable;
import com.devexpress.editors.style.TextEditStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilledBackgroundDrawableManager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/FilledBackgroundDrawableManager;", "Lcom/devexpress/editors/utils/drawablemanager/AbstractBackgroundDrawableManager;", "Lcom/devexpress/editors/model/drawables/UnderlinedMaterialRectDrawable;", "style", "Lcom/devexpress/editors/style/TextEditStyle;", "(Lcom/devexpress/editors/style/TextEditStyle;)V", "d", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "applyLabelCutOut", "", "left", "", "top", "right", "bottom", "updateCornerSize", "updateCornerTreatment", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FilledBackgroundDrawableManager extends AbstractBackgroundDrawableManager<UnderlinedMaterialRectDrawable> {
    private AnimationManagerDrawable<UnderlinedMaterialRectDrawable> d;

    @Override // com.devexpress.editors.utils.drawablemanager.BackgroundDrawableManager
    public void applyLabelCutOut(float left, float top, float right, float bottom) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilledBackgroundDrawableManager(TextEditStyle style) {
        super(style);
        Intrinsics.checkNotNullParameter(style, "style");
        AnimationManagerDrawable<UnderlinedMaterialRectDrawable> animationManagerDrawable = new AnimationManagerDrawable<>(new UnderlinedMaterialRectDrawable(null, null, null, 7, null), new FilledBackgroundDrawableManager$d$1(style));
        this.d = animationManagerDrawable;
        UnderlinedMaterialRectDrawable managedDrawable = animationManagerDrawable.getManagedDrawable();
        managedDrawable.setFillColor(style.getBoxBackgroundColor());
        managedDrawable.setStrokeColor(style.getBorderColor());
        managedDrawable.setStrokeWidth(style.getBorderThickness());
        managedDrawable.setCornerSize(style.getBorderRounds());
        managedDrawable.setCornerTreatment(CornerTreatmentFactory.createCornerTreatment(style.getCornerMode()));
    }

    @Override // com.devexpress.editors.utils.drawablemanager.BackgroundDrawableManager
    public Drawable getDrawable() {
        return this.d;
    }

    @Override // com.devexpress.editors.utils.drawablemanager.BackgroundDrawableManager
    public void updateCornerSize() {
        this.d.getManagedDrawable().setCornerSize(getStyle().getBorderRounds());
    }

    @Override // com.devexpress.editors.utils.drawablemanager.BackgroundDrawableManager
    public void updateCornerTreatment() {
        this.d.getManagedDrawable().setCornerTreatment(CornerTreatmentFactory.createCornerTreatment(getStyle().getCornerMode()));
    }
}
