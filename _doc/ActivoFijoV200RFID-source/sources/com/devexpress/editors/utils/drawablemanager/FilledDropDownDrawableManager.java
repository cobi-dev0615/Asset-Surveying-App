package com.devexpress.editors.utils.drawablemanager;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.devexpress.editors.Constants;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.drawables.CornerTreatment;
import com.devexpress.editors.style.DropDownTextEditStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DropDownDrawableManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/FilledDropDownDrawableManager;", "Lcom/devexpress/editors/utils/drawablemanager/DropDownDrawableManager;", "()V", "belowCornerSize", "Lcom/devexpress/editors/model/BorderRounds;", "<set-?>", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "recreateDrawable", "", "style", "Lcom/devexpress/editors/style/DropDownTextEditStyle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FilledDropDownDrawableManager implements DropDownDrawableManager {
    private BorderRounds belowCornerSize = new BorderRounds();
    private Drawable drawable;

    @Override // com.devexpress.editors.utils.drawablemanager.DropDownDrawableManager
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.devexpress.editors.utils.drawablemanager.DropDownDrawableManager
    public void recreateDrawable(DropDownTextEditStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        CornerTreatment createCornerTreatment = CornerTreatmentFactory.createCornerTreatment(style.getCornerMode());
        this.belowCornerSize.set(0.0f, 0.0f, style.getBorderRounds().bottomLeft, style.getBorderRounds().bottomRight);
        Drawable create = MaterialRectDrawableCreator.INSTANCE.create(style, createCornerTreatment, this.belowCornerSize);
        Drawable create2 = MaterialRectDrawableCreator.INSTANCE.create(style, createCornerTreatment);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(Constants.ABOVE_STATE, create2);
        stateListDrawable.addState(Constants.DEFAULT_STATE, create);
        this.drawable = stateListDrawable;
    }
}
