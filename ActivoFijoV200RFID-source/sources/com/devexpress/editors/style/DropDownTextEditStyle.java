package com.devexpress.editors.style;

import android.graphics.drawable.Drawable;
import com.devexpress.editors.DXBorderMode;
import com.devexpress.editors.utils.drawablemanager.DropDownDrawableManager;
import com.devexpress.editors.utils.drawablemanager.DropDownDrawableManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DropDownTextEditStyle.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/devexpress/editors/style/DropDownTextEditStyle;", "Lcom/devexpress/editors/style/TextEditStyle;", "()V", "value", "Lcom/devexpress/editors/DXBorderMode;", "borderMode", "getBorderMode", "()Lcom/devexpress/editors/DXBorderMode;", "setBorderMode", "(Lcom/devexpress/editors/DXBorderMode;)V", "dropDownBackgroundColor", "", "getDropDownBackgroundColor", "()I", "setDropDownBackgroundColor", "(I)V", "dropDownBorderColor", "getDropDownBorderColor", "setDropDownBorderColor", "dropDownBorderThickness", "", "getDropDownBorderThickness", "()F", "setDropDownBorderThickness", "(F)V", "dropDownDrawableManager", "Lcom/devexpress/editors/utils/drawablemanager/DropDownDrawableManager;", "createDropDownBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DropDownTextEditStyle extends TextEditStyle {
    private int dropDownBackgroundColor = -1;
    private int dropDownBorderColor = -7829368;
    private float dropDownBorderThickness = 1.0f;
    private DropDownDrawableManager dropDownDrawableManager = DropDownDrawableManagerFactory.INSTANCE.createManager(getBorderMode());

    @Override // com.devexpress.editors.style.TextEditStyle
    public DXBorderMode getBorderMode() {
        return super.getBorderMode();
    }

    @Override // com.devexpress.editors.style.TextEditStyle
    public void setBorderMode(DXBorderMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (super.getBorderMode() == value) {
            return;
        }
        super.setBorderMode(value);
        this.dropDownDrawableManager = DropDownDrawableManagerFactory.INSTANCE.createManager(getBorderMode());
    }

    public final int getDropDownBackgroundColor() {
        return this.dropDownBackgroundColor;
    }

    public final void setDropDownBackgroundColor(int i) {
        this.dropDownBackgroundColor = i;
    }

    public final int getDropDownBorderColor() {
        return this.dropDownBorderColor;
    }

    public final void setDropDownBorderColor(int i) {
        this.dropDownBorderColor = i;
    }

    public final float getDropDownBorderThickness() {
        return this.dropDownBorderThickness;
    }

    public final void setDropDownBorderThickness(float f) {
        this.dropDownBorderThickness = f;
    }

    public final Drawable createDropDownBackgroundDrawable() {
        this.dropDownDrawableManager.recreateDrawable(this);
        return this.dropDownDrawableManager.getDrawable();
    }
}
