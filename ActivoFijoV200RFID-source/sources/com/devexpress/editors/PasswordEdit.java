package com.devexpress.editors;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.content.res.AppCompatResources;
import com.devexpress.editors.layout.factories.PasswordLayoutElementsFactory;
import com.devexpress.editors.style.PasswordEditStyle;
import com.devexpress.editors.utils.CheckableImageButton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordEdit.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0001@B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0014J(\u00100\u001a\u00020-2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J\b\u00106\u001a\u00020-H\u0014J\b\u00107\u001a\u00020-H\u0002J\b\u00108\u001a\u00020-H\u0014J\u0010\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020\u0013H\u0014J\b\u0010;\u001a\u00020-H\u0014J\u0010\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u00020-H\u0002R\u0014\u0010\t\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\u0010R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\f\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006A"}, d2 = {"Lcom/devexpress/editors/PasswordEdit;", "Lcom/devexpress/editors/TextEditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualEditorInputType", "getActualEditorInputType", "()I", "value", "disabledPasswordIconColor", "getDisabledPasswordIconColor", "setDisabledPasswordIconColor", "(I)V", "internalStyle", "Lcom/devexpress/editors/style/PasswordEditStyle;", "", "isPasswordShown", "()Z", "setPasswordShown", "(Z)V", "passwordIconColor", "getPasswordIconColor", "setPasswordIconColor", "Lcom/devexpress/editors/DXIconVisibility;", "passwordIconVisibility", "getPasswordIconVisibility", "()Lcom/devexpress/editors/DXIconVisibility;", "setPasswordIconVisibility", "(Lcom/devexpress/editors/DXIconVisibility;)V", "Landroid/graphics/drawable/Drawable;", "passwordVisibilityIcon", "getPasswordVisibilityIcon", "()Landroid/graphics/drawable/Drawable;", "setPasswordVisibilityIcon", "(Landroid/graphics/drawable/Drawable;)V", "passwordVisibilityImage", "Lcom/devexpress/editors/utils/CheckableImageButton;", "style", "getStyle", "()Lcom/devexpress/editors/style/PasswordEditStyle;", "changeTransformationMethod", "", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "doOnTextChanged", "s", "", "start", "before", "count", "onEditorInputTypeChange", "onPasswordIconColorsChanged", "onReadOnlyChanged", "setChildrenEnabled", "enabled", "updateAll", "updateDrawablesTintMode", "state", "", "updatePasswordIconsVisibility", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PasswordEdit extends TextEditBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PasswordEditStyle internalStyle;
    private boolean isPasswordShown;
    private DXIconVisibility passwordIconVisibility;
    private final CheckableImageButton passwordVisibilityImage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PasswordEdit(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PasswordEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    public static final Drawable getDefaultPasswordHideIcon(Context context) {
        return INSTANCE.getDefaultPasswordHideIcon(context);
    }

    @JvmStatic
    public static final Drawable getDefaultPasswordShowIcon(Context context) {
        return INSTANCE.getDefaultPasswordShowIcon(context);
    }

    @JvmStatic
    public static final Drawable getDefaultPasswordVisibilityIcon(Context context) {
        return INSTANCE.getDefaultPasswordVisibilityIcon(context);
    }

    public /* synthetic */ PasswordEdit(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* compiled from: PasswordEdit.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/PasswordEdit$Companion;", "", "()V", "getDefaultPasswordHideIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "getDefaultPasswordShowIcon", "getDefaultPasswordVisibilityIcon", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Drawable getDefaultPasswordVisibilityIcon(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppCompatResources.getDrawable(context, R.drawable.dxe_visibility);
        }

        @JvmStatic
        public final Drawable getDefaultPasswordShowIcon(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppCompatResources.getDrawable(context, R.drawable.dxe_visibility_on);
        }

        @JvmStatic
        public final Drawable getDefaultPasswordHideIcon(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppCompatResources.getDrawable(context, R.drawable.dxe_visibility_off);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.internalStyle = new PasswordEditStyle();
        CheckableImageButton checkableImageButton = new CheckableImageButton(context, null, 0, 6, null);
        this.passwordVisibilityImage = checkableImageButton;
        this.passwordIconVisibility = DXIconVisibility.Auto;
        finishInitialization(attributeSet, i);
        addView(checkableImageButton);
        setClearIconVisibility(DXIconVisibility.Never);
        setPasswordVisibilityIcon(null);
        checkableImageButton.setBackgroundColor(0);
        checkableImageButton.setPadding(0, 0, 0, 0);
        checkableImageButton.setClickable(true);
        checkableImageButton.setChecked(this.isPasswordShown);
        checkableImageButton.setOnCheckedChangeListener(new CheckableImageButton.OnCheckedChangeListener() { // from class: com.devexpress.editors.PasswordEdit.1
            @Override // com.devexpress.editors.utils.CheckableImageButton.OnCheckedChangeListener
            public void onCheckedChanged(Checkable checkable, boolean isChecked) {
                Intrinsics.checkNotNullParameter(checkable, "checkable");
                PasswordEdit.this.setPasswordShown(isChecked);
            }
        });
        updatePasswordIconsVisibility();
    }

    /* renamed from: isPasswordShown, reason: from getter */
    public final boolean getIsPasswordShown() {
        return this.isPasswordShown;
    }

    public final void setPasswordShown(boolean z) {
        if (this.isPasswordShown == z) {
            return;
        }
        this.isPasswordShown = z;
        changeTransformationMethod();
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected LayoutElementsFactory createLayoutElementsFactory() {
        return new PasswordLayoutElementsFactory(getInternalEditor(), this.labelTextView, this.startImage, this.endImage, this.errorImage, this.errorTextView, this.helpTextView, this.suffixView, this.prefixView, this.clearImage, this.characterCounterView, this.passwordVisibilityImage);
    }

    @Override // com.devexpress.editors.EditBase
    /* renamed from: getStyle, reason: from getter */
    public PasswordEditStyle getInternalStyle() {
        return this.internalStyle;
    }

    public final Drawable getPasswordVisibilityIcon() {
        return this.passwordVisibilityImage.getDrawable();
    }

    public final void setPasswordVisibilityIcon(Drawable drawable) {
        if (drawable == null) {
            Companion companion = INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawable = companion.getDefaultPasswordVisibilityIcon(context);
        }
        if (Intrinsics.areEqual(this.passwordVisibilityImage.getDrawable(), drawable)) {
            return;
        }
        this.passwordVisibilityImage.setImageDrawable(drawable);
    }

    public final DXIconVisibility getPasswordIconVisibility() {
        return this.passwordIconVisibility;
    }

    public final void setPasswordIconVisibility(DXIconVisibility value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.passwordIconVisibility == value) {
            return;
        }
        this.passwordIconVisibility = value;
        updatePasswordIconsVisibility();
        requestLayout();
    }

    public final int getPasswordIconColor() {
        return getInternalStyle().getPasswordIconColor();
    }

    public final void setPasswordIconColor(int i) {
        if (getInternalStyle().getPasswordIconColor() == i) {
            return;
        }
        getInternalStyle().setPasswordIconColor(i);
        onPasswordIconColorsChanged();
    }

    public final int getDisabledPasswordIconColor() {
        return getInternalStyle().getDisabledPasswordIconColor();
    }

    public final void setDisabledPasswordIconColor(int i) {
        if (getInternalStyle().getDisabledPasswordIconColor() == i) {
            return;
        }
        getInternalStyle().setDisabledPasswordIconColor(i);
        onPasswordIconColorsChanged();
    }

    private final void updatePasswordIconsVisibility() {
        this.passwordVisibilityImage.setVisibility(this.passwordIconVisibility == DXIconVisibility.Always || (this.passwordIconVisibility == DXIconVisibility.Auto && getTextStrategy$dxeditors_release().getCanBeCleared()) ? 0 : 8);
    }

    @Override // com.devexpress.editors.TextEditBase
    protected void doOnTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        super.doOnTextChanged(s, start, before, count);
        updatePasswordIconsVisibility();
    }

    @Override // com.devexpress.editors.EditBase
    protected int getActualEditorInputType() {
        int actualEditorInputType = super.getActualEditorInputType();
        int i = actualEditorInputType & 15;
        if (i == 1) {
            actualEditorInputType |= 128;
        } else if (i == 2) {
            actualEditorInputType |= 16;
        }
        return getIsReadOnly() ? actualEditorInputType : (actualEditorInputType & (-409601)) | 524288;
    }

    @Override // com.devexpress.editors.EditBase
    protected void onEditorInputTypeChange() {
        super.onEditorInputTypeChange();
        changeTransformationMethod();
        getInternalEditor().setTypeface(getTextTypeface());
    }

    @Override // com.devexpress.editors.TextEditBase, com.devexpress.editors.EditBase
    protected void setChildrenEnabled(boolean enabled) {
        super.setChildrenEnabled(enabled);
        this.passwordVisibilityImage.setEnabled(enabled);
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateAll() {
        super.updateAll();
        onPasswordIconColorsChanged();
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateDrawablesTintMode(int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.updateDrawablesTintMode(state);
        updateDrawableTintMode(this.passwordVisibilityImage, state);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onReadOnlyChanged() {
        super.onReadOnlyChanged();
        changeTransformationMethod();
    }

    private final void onPasswordIconColorsChanged() {
        updateIconTintList(this.passwordVisibilityImage, getInternalStyle().getPasswordIconColor(), getInternalStyle().getDisabledPasswordIconColor());
    }

    private final void changeTransformationMethod() {
        if (getIsReadOnly()) {
            setInternalEditorTextSelectable(this.isPasswordShown);
        }
        getInternalEditor().setTransformationMethod(this.isPasswordShown ? null : PasswordTransformationMethod.getInstance());
        setSelection(getInternalEditor().getText().length());
    }
}
