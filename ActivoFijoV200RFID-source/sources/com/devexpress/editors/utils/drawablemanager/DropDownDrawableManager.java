package com.devexpress.editors.utils.drawablemanager;

import android.graphics.drawable.Drawable;
import com.devexpress.editors.style.DropDownTextEditStyle;
import kotlin.Metadata;

/* compiled from: DropDownDrawableManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/DropDownDrawableManager;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "recreateDrawable", "", "style", "Lcom/devexpress/editors/style/DropDownTextEditStyle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DropDownDrawableManager {
    Drawable getDrawable();

    void recreateDrawable(DropDownTextEditStyle style);
}
