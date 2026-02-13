package com.devexpress.editors.utils.drawablemanager;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import com.devexpress.editors.Constants;
import com.devexpress.editors.style.CheckEditStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckBoxBackgroundFactory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/CheckBoxBackgroundFactory;", "", "()V", "delegate", "Lcom/devexpress/editors/utils/drawablemanager/CheckBoxBackgroundFactory$Delegate;", "create", "Landroid/graphics/drawable/Drawable;", "style", "Lcom/devexpress/editors/style/CheckEditStyle;", "Api21Delegate", "Delegate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckBoxBackgroundFactory {
    public static final CheckBoxBackgroundFactory INSTANCE = new CheckBoxBackgroundFactory();
    private static final Delegate delegate = new Api21Delegate();

    /* compiled from: CheckBoxBackgroundFactory.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/CheckBoxBackgroundFactory$Delegate;", "", "create", "Landroid/graphics/drawable/Drawable;", "style", "Lcom/devexpress/editors/style/CheckEditStyle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Delegate {
        Drawable create(CheckEditStyle style);
    }

    private CheckBoxBackgroundFactory() {
    }

    public final Drawable create(CheckEditStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        return delegate.create(style);
    }

    /* compiled from: CheckBoxBackgroundFactory.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/CheckBoxBackgroundFactory$Api21Delegate;", "Lcom/devexpress/editors/utils/drawablemanager/CheckBoxBackgroundFactory$Delegate;", "()V", "create", "Landroid/graphics/drawable/Drawable;", "style", "Lcom/devexpress/editors/style/CheckEditStyle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Api21Delegate implements Delegate {
        @Override // com.devexpress.editors.utils.drawablemanager.CheckBoxBackgroundFactory.Delegate
        public Drawable create(CheckEditStyle style) {
            Intrinsics.checkNotNullParameter(style, "style");
            return new RippleDrawable(new ColorStateList(new int[][]{Constants.CHECKED_STATE, Constants.DEFAULT_STATE}, new int[]{style.getActualCheckedPressedBackgroundColor(), style.getActualPressedBackgroundColor()}), null, null);
        }
    }
}
