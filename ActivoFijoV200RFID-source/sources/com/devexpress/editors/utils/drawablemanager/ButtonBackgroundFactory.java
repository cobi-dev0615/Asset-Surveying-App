package com.devexpress.editors.utils.drawablemanager;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import com.devexpress.editors.Constants;
import com.devexpress.editors.model.BorderRounds;
import com.devexpress.editors.model.Thickness;
import com.devexpress.editors.model.drawables.CornerTreatment;
import com.devexpress.editors.model.drawables.MaterialRectDrawable;
import com.devexpress.editors.style.SimpleButtonStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: ButtonBackgroundFactory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory;", "", "()V", "delegate", "Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory$ButtonBackgroundFactoryDelegate;", "create", "Landroid/graphics/drawable/Drawable;", "style", "Lcom/devexpress/editors/style/SimpleButtonStyle;", "Api21ButtonBackgroundFactoryDelegate", "ButtonBackgroundFactoryDelegate", "ButtonBackgroundFactoryDelegateBase", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ButtonBackgroundFactory {
    public static final ButtonBackgroundFactory INSTANCE = new ButtonBackgroundFactory();
    private static final ButtonBackgroundFactoryDelegate delegate = new Api21ButtonBackgroundFactoryDelegate();

    /* compiled from: ButtonBackgroundFactory.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory$ButtonBackgroundFactoryDelegate;", "", "create", "Landroid/graphics/drawable/Drawable;", "style", "Lcom/devexpress/editors/style/SimpleButtonStyle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private interface ButtonBackgroundFactoryDelegate {
        Drawable create(SimpleButtonStyle style);
    }

    private ButtonBackgroundFactory() {
    }

    public final Drawable create(SimpleButtonStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        return delegate.create(style);
    }

    /* compiled from: ButtonBackgroundFactory.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory$ButtonBackgroundFactoryDelegateBase;", "Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory$ButtonBackgroundFactoryDelegate;", "()V", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static abstract class ButtonBackgroundFactoryDelegateBase implements ButtonBackgroundFactoryDelegate {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: ButtonBackgroundFactory.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jz\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006¨\u0006\u0017"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory$ButtonBackgroundFactoryDelegateBase$Companion;", "", "()V", "createDrawable", "Landroid/graphics/drawable/Drawable;", "fill", "", "stroke", "strokeWidth", "", "cornerTreatment", "Lcom/devexpress/editors/model/drawables/CornerTreatment;", "borderRounds", "Lcom/devexpress/editors/model/BorderRounds;", "padding", "Lcom/devexpress/editors/model/Thickness;", "paintStyle", "Landroid/graphics/Paint$Style;", "hasShadow", "", "shadowRadius", "shadowOffset", "shadowRotation", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Drawable createDrawable$default(Companion companion, int i, int i2, float f, CornerTreatment cornerTreatment, BorderRounds borderRounds, Thickness thickness, Paint.Style style, boolean z, int i3, int i4, int i5, int i6, Object obj) {
                if ((i6 & 1) != 0) {
                    i = 0;
                }
                if ((i6 & 2) != 0) {
                    i2 = 0;
                }
                if ((i6 & 4) != 0) {
                    f = 0.0f;
                }
                if ((i6 & 8) != 0) {
                    cornerTreatment = null;
                }
                if ((i6 & 16) != 0) {
                    borderRounds = null;
                }
                if ((i6 & 32) != 0) {
                    thickness = null;
                }
                if ((i6 & 64) != 0) {
                    style = Paint.Style.FILL_AND_STROKE;
                }
                if ((i6 & 128) != 0) {
                    z = false;
                }
                if ((i6 & 256) != 0) {
                    i3 = 0;
                }
                if ((i6 & 512) != 0) {
                    i4 = 0;
                }
                if ((i6 & 1024) != 0) {
                    i5 = 0;
                }
                return companion.createDrawable(i, i2, f, cornerTreatment, borderRounds, thickness, style, z, i3, i4, i5);
            }

            public final Drawable createDrawable(int fill, int stroke, float strokeWidth, CornerTreatment cornerTreatment, BorderRounds borderRounds, Thickness padding, Paint.Style paintStyle, boolean hasShadow, int shadowRadius, int shadowOffset, int shadowRotation) {
                Intrinsics.checkNotNullParameter(paintStyle, "paintStyle");
                MaterialRectDrawable materialRectDrawable = new MaterialRectDrawable(null, null, null, false, 0, 0, 0, WorkQueueKt.MASK, null);
                materialRectDrawable.setFillColor(fill);
                materialRectDrawable.setStrokeColor(stroke);
                materialRectDrawable.setStrokeWidth(strokeWidth);
                materialRectDrawable.setPaintStyle(paintStyle);
                if (cornerTreatment != null) {
                    materialRectDrawable.setCornerTreatment(cornerTreatment);
                }
                if (borderRounds != null) {
                    materialRectDrawable.setCornerSize(borderRounds);
                }
                if (padding != null) {
                    materialRectDrawable.setPadding(padding.getStart(), padding.getTop(), padding.getEnd(), padding.getBottom());
                }
                materialRectDrawable.setHasShadow(hasShadow);
                materialRectDrawable.setShadowCompatRadius(shadowRadius);
                materialRectDrawable.setShadowCompatOffset(shadowOffset);
                materialRectDrawable.setShadowCompatRotation(shadowRotation);
                return materialRectDrawable;
            }
        }
    }

    /* compiled from: ButtonBackgroundFactory.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory$Api21ButtonBackgroundFactoryDelegate;", "Lcom/devexpress/editors/utils/drawablemanager/ButtonBackgroundFactory$ButtonBackgroundFactoryDelegateBase;", "()V", "create", "Landroid/graphics/drawable/Drawable;", "style", "Lcom/devexpress/editors/style/SimpleButtonStyle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Api21ButtonBackgroundFactoryDelegate extends ButtonBackgroundFactoryDelegateBase {
        @Override // com.devexpress.editors.utils.drawablemanager.ButtonBackgroundFactory.ButtonBackgroundFactoryDelegate
        public Drawable create(SimpleButtonStyle style) {
            Intrinsics.checkNotNullParameter(style, "style");
            CornerTreatment createCornerTreatment = CornerTreatmentFactory.createCornerTreatment(style.getCornerMode());
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable createDrawable$default = ButtonBackgroundFactoryDelegateBase.Companion.createDrawable$default(ButtonBackgroundFactoryDelegateBase.INSTANCE, style.getDisabledBackgroundColor(), style.getDisabledBorderColor(), style.getBorderThickness(), createCornerTreatment, style.getBorderRounds(), null, null, false, 0, 0, 0, 2016, null);
            Drawable createDrawable$default2 = ButtonBackgroundFactoryDelegateBase.Companion.createDrawable$default(ButtonBackgroundFactoryDelegateBase.INSTANCE, style.getBackgroundColor(), style.getBorderColor(), style.getBorderThickness(), createCornerTreatment, style.getBorderRounds(), null, null, false, 0, 0, 0, 2016, null);
            Drawable createDrawable$default3 = ButtonBackgroundFactoryDelegateBase.Companion.createDrawable$default(ButtonBackgroundFactoryDelegateBase.INSTANCE, style.getBackgroundColor(), style.getPressedBorderColor(), style.getBorderThickness(), createCornerTreatment, style.getBorderRounds(), null, null, false, 0, 0, 0, 2016, null);
            Drawable createDrawable$default4 = ButtonBackgroundFactoryDelegateBase.Companion.createDrawable$default(ButtonBackgroundFactoryDelegateBase.INSTANCE, style.getBackgroundColor(), style.getBorderColor(), style.getBorderThickness(), createCornerTreatment, style.getBorderRounds(), null, null, false, 0, 0, 0, 2016, null);
            stateListDrawable.addState(Constants.DISABLED_STATE, createDrawable$default);
            stateListDrawable.addState(Constants.PRESSED_STATE, createDrawable$default3);
            stateListDrawable.addState(Constants.FOCUSED_STATE, createDrawable$default2);
            stateListDrawable.addState(Constants.DEFAULT_STATE, createDrawable$default4);
            if (style.getUseRippleEffect()) {
                return new RippleDrawable(ColorStateList.valueOf(style.getActualPressedBackgroundColor()), stateListDrawable, ButtonBackgroundFactoryDelegateBase.Companion.createDrawable$default(ButtonBackgroundFactoryDelegateBase.INSTANCE, -1, 0, 0.0f, createCornerTreatment, style.getBorderRounds(), null, Paint.Style.FILL, false, 0, 0, 0, 1958, null));
            }
            return stateListDrawable;
        }
    }
}
