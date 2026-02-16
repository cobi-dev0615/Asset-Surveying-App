package com.devexpress.editors.utils.drawablemanager;

import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;
import com.devexpress.editors.Constants;
import com.devexpress.editors.model.drawables.AnimationManagerDrawable;
import com.devexpress.editors.model.drawables.CutOutMaterialRectDrawable;
import com.devexpress.editors.style.TextEditStyle;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutlineBackgroundDrawableManager.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"com/devexpress/editors/utils/drawablemanager/OutlineBackgroundDrawableManager$d$1", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$Delegate;", "Lcom/devexpress/editors/model/drawables/CutOutMaterialRectDrawable;", "applyParams", "", "managedDrawable", "params", "Lcom/devexpress/editors/model/drawables/AnimationManagerDrawable$DrawableParams;", "createAnimator", "Landroid/animation/ValueAnimator;", "startParams", "endParams", "fillParamsForState", "state", "", "targetParams", "defaultParams", "fillParamsFromDrawable", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OutlineBackgroundDrawableManager$d$1 implements AnimationManagerDrawable.Delegate<CutOutMaterialRectDrawable> {
    final /* synthetic */ TextEditStyle $style;

    OutlineBackgroundDrawableManager$d$1(TextEditStyle textEditStyle) {
        this.$style = textEditStyle;
    }

    @Override // com.devexpress.editors.model.drawables.AnimationManagerDrawable.Delegate
    public ValueAnimator createAnimator(final CutOutMaterialRectDrawable managedDrawable, final AnimationManagerDrawable.DrawableParams startParams, final AnimationManagerDrawable.DrawableParams endParams) {
        Intrinsics.checkNotNullParameter(managedDrawable, "managedDrawable");
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        Intrinsics.checkNotNullParameter(endParams, "endParams");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.utils.drawablemanager.OutlineBackgroundDrawableManager$d$1$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OutlineBackgroundDrawableManager$d$1.createAnimator$lambda$0(CutOutMaterialRectDrawable.this, startParams, endParams, valueAnimator);
            }
        });
        ofFloat.setInterpolator(AbstractBackgroundDrawableManager.INSTANCE.getInterpolator());
        ofFloat.setDuration(Constants.ANIMATION_DURATION);
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAnimator$lambda$0(CutOutMaterialRectDrawable managedDrawable, AnimationManagerDrawable.DrawableParams startParams, AnimationManagerDrawable.DrawableParams endParams, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(managedDrawable, "$managedDrawable");
        Intrinsics.checkNotNullParameter(startParams, "$startParams");
        Intrinsics.checkNotNullParameter(endParams, "$endParams");
        Intrinsics.checkNotNullParameter(it, "it");
        float animatedFraction = it.getAnimatedFraction();
        managedDrawable.setCutOutProgress(startParams.cutOutProgress + ((endParams.cutOutProgress - startParams.cutOutProgress) * animatedFraction));
        managedDrawable.setFillColor(ColorUtils.blendARGB(startParams.fillColor, endParams.fillColor, animatedFraction));
        managedDrawable.setStrokeColor(ColorUtils.blendARGB(startParams.strokeColor, endParams.strokeColor, animatedFraction));
        managedDrawable.setStrokeWidth(startParams.strokeWidth + ((endParams.strokeWidth - startParams.strokeWidth) * animatedFraction));
    }

    @Override // com.devexpress.editors.model.drawables.AnimationManagerDrawable.Delegate
    public void applyParams(CutOutMaterialRectDrawable managedDrawable, AnimationManagerDrawable.DrawableParams params) {
        Intrinsics.checkNotNullParameter(managedDrawable, "managedDrawable");
        Intrinsics.checkNotNullParameter(params, "params");
        managedDrawable.setCutOutProgress(params.cutOutProgress);
        managedDrawable.setFillColor(params.fillColor);
        managedDrawable.setStrokeColor(params.strokeColor);
        managedDrawable.setStrokeWidth(params.strokeWidth);
    }

    @Override // com.devexpress.editors.model.drawables.AnimationManagerDrawable.Delegate
    public void fillParamsFromDrawable(CutOutMaterialRectDrawable managedDrawable, AnimationManagerDrawable.DrawableParams targetParams) {
        Intrinsics.checkNotNullParameter(managedDrawable, "managedDrawable");
        Intrinsics.checkNotNullParameter(targetParams, "targetParams");
        targetParams.cutOutProgress = managedDrawable.getCutOutProgress();
        targetParams.fillColor = managedDrawable.getFillColor();
        targetParams.strokeColor = managedDrawable.getStrokeColor();
        targetParams.strokeWidth = managedDrawable.getStrokeWidth();
    }

    @Override // com.devexpress.editors.model.drawables.AnimationManagerDrawable.Delegate
    public void fillParamsForState(int[] state, AnimationManagerDrawable.DrawableParams targetParams, AnimationManagerDrawable.DrawableParams defaultParams) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(targetParams, "targetParams");
        Intrinsics.checkNotNullParameter(defaultParams, "defaultParams");
        for (Pair<int[], Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit>> pair : AbstractBackgroundDrawableManager.INSTANCE.getFillers$dxeditors_release()) {
            int[] component1 = pair.component1();
            Function2<TextEditStyle, AnimationManagerDrawable.DrawableParams, Unit> component2 = pair.component2();
            if (StateSet.stateSetMatches(component1, state)) {
                component2.invoke(this.$style, targetParams);
                return;
            }
        }
        targetParams.set(defaultParams);
    }
}
