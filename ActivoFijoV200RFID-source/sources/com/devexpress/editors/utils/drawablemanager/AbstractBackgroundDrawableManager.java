package com.devexpress.editors.utils.drawablemanager;

import android.graphics.Rect;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.devexpress.editors.Constants;
import com.devexpress.editors.model.drawables.AbstractMaterialRectDrawable;
import com.devexpress.editors.model.drawables.AnimationManagerDrawable;
import com.devexpress.editors.style.TextEditStyle;
import com.devexpress.editors.utils.drawablemanager.BackgroundDrawableManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractBackgroundDrawableManager.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \t*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003:\u0001\tB\u000f\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/AbstractBackgroundDrawableManager;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/devexpress/editors/model/drawables/AbstractMaterialRectDrawable;", "Lcom/devexpress/editors/utils/drawablemanager/BackgroundDrawableManager;", "style", "Lcom/devexpress/editors/style/TextEditStyle;", "(Lcom/devexpress/editors/style/TextEditStyle;)V", "getStyle", "()Lcom/devexpress/editors/style/TextEditStyle;", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractBackgroundDrawableManager<T extends AbstractMaterialRectDrawable<?>> implements BackgroundDrawableManager {
    private final TextEditStyle style;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
    private static final Pair<int[], Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>>[] fillers = {TuplesKt.to(Constants.DISABLED_LABEL_MOVED_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getDisabledBorderColor();
            params.fillColor = style.getDisabledBoxBackgroundColor();
            params.strokeWidth = style.getDisabledBorderThickness();
            params.cutOutProgress = 1.0f;
        }
    }), TuplesKt.to(Constants.DISABLED_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$2
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getDisabledBorderColor();
            params.fillColor = style.getDisabledBoxBackgroundColor();
            params.strokeWidth = style.getDisabledBorderThickness();
            params.cutOutProgress = 0.0f;
        }
    }), TuplesKt.to(Constants.ERROR_FOCUSED_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$3
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getErrorColor();
            params.fillColor = style.getBoxBackgroundColor();
            params.strokeWidth = style.getFocusedBorderThickness();
            params.cutOutProgress = 1.0f;
        }
    }), TuplesKt.to(Constants.ERROR_LABEL_MOVED_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$4
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getErrorColor();
            params.fillColor = style.getBoxBackgroundColor();
            params.strokeWidth = style.getBorderThickness();
            params.cutOutProgress = 1.0f;
        }
    }), TuplesKt.to(Constants.ERROR_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$5
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getErrorColor();
            params.fillColor = style.getBoxBackgroundColor();
            params.strokeWidth = style.getBorderThickness();
            params.cutOutProgress = 0.0f;
        }
    }), TuplesKt.to(Constants.FOCUSED_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$6
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getFocusedBorderColor();
            params.fillColor = style.getBoxBackgroundColor();
            params.strokeWidth = style.getFocusedBorderThickness();
            params.cutOutProgress = 1.0f;
        }
    }), TuplesKt.to(Constants.LABEL_MOVED_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$7
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getBorderColor();
            params.fillColor = style.getBoxBackgroundColor();
            params.strokeWidth = style.getBorderThickness();
            params.cutOutProgress = 1.0f;
        }
    }), TuplesKt.to(Constants.DEFAULT_STATE, new Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>() { // from class: com.devexpress.editors.utils.drawablemanager.AbstractBackgroundDrawableManager$Companion$fillers$8
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TextEditStyle textEditStyle, AnimationManagerDrawable.DrawableParams drawableParams) {
            invoke2(textEditStyle, drawableParams);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextEditStyle style, AnimationManagerDrawable.DrawableParams params) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(params, "params");
            params.strokeColor = style.getBorderColor();
            params.fillColor = style.getBoxBackgroundColor();
            params.strokeWidth = style.getBorderThickness();
            params.cutOutProgress = 0.0f;
        }
    })};

    /* compiled from: AbstractBackgroundDrawableManager.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R:\u0010\u0003\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00070\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/utils/drawablemanager/AbstractBackgroundDrawableManager$Companion;", "", "()V", "fillers", "", "Lkotlin/Pair;", "", "Lkotlin/Function2;", "Lcom/devexpress/editors/style/TextEditStyle;", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;", "", "getFillers$dxeditors_release", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "interpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "getInterpolator", "()Landroid/view/animation/AccelerateDecelerateInterpolator;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AccelerateDecelerateInterpolator getInterpolator() {
            return AbstractBackgroundDrawableManager.interpolator;
        }

        public final Pair<int[], Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>>[] getFillers$dxeditors_release() {
            return AbstractBackgroundDrawableManager.fillers;
        }
    }

    protected AbstractBackgroundDrawableManager(TextEditStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
    }

    @Override // com.devexpress.editors.utils.drawablemanager.BackgroundDrawableManager
    public void applyLabelCutOut(Rect rect) {
        BackgroundDrawableManager.DefaultImpls.applyLabelCutOut(this, rect);
    }

    protected final TextEditStyle getStyle() {
        return this.style;
    }
}
