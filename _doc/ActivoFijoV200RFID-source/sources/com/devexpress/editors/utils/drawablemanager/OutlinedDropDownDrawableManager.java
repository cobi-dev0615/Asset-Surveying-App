package com.devexpress.editors.utils.drawablemanager;

import android.graphics.drawable.Drawable;
import com.devexpress.editors.style.DropDownTextEditStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DropDownDrawableManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/OutlinedDropDownDrawableManager;", "Lcom/devexpress/editors/utils/drawablemanager/DropDownDrawableManager;", "()V", "<set-?>", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "recreateDrawable", "", "style", "Lcom/devexpress/editors/style/DropDownTextEditStyle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OutlinedDropDownDrawableManager implements DropDownDrawableManager {
    private Drawable drawable;

    @Override // com.devexpress.editors.utils.drawablemanager.DropDownDrawableManager
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.devexpress.editors.utils.drawablemanager.DropDownDrawableManager
    public void recreateDrawable(DropDownTextEditStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawable = MaterialRectDrawableCreator.INSTANCE.create(style, CornerTreatmentFactory.createCornerTreatment(style.getCornerMode()));
    }
}
