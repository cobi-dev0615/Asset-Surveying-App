package com.devexpress.editors.pickers;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.View;
import com.devexpress.editors.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: ViewsUpdater.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u00002\u00020\u0001B½\u0001\u0012*\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&R2\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/devexpress/editors/pickers/ViewsUpdater;", "", "addOrAttachViewToParent", "Lkotlin/Function3;", "Landroid/view/View;", "", "Lkotlin/Function1;", "", "detachViewFromParent", "requestView", "checkView", "Lkotlin/Function2;", "", "updateView", "recycleView", "calcIndex", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "views", "Landroid/util/SparseArray;", "createAndSetup", "viewIndex", "cellIndex", "getViewForCellWithIndex", "hide", "recycle", "recycleViewForCellWithIndex", "show", "update", "updateCellWithIndexToActualContent", "viewIndexToCellIndex", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ViewsUpdater {
    private final Function3<View, Integer, Function1<? super Integer, Integer>, Unit> addOrAttachViewToParent;
    private final Function1<Integer, Integer> calcIndex;
    private final Function2<View, Integer, Boolean> checkView;
    private final Function1<View, Unit> detachViewFromParent;
    private final Function2<View, Integer, Unit> recycleView;
    private final Function1<Integer, View> requestView;
    private final Function2<View, Integer, Unit> updateView;
    private final SparseArray<View> views;

    public abstract int viewIndexToCellIndex(int viewIndex);

    /* JADX WARN: Multi-variable type inference failed */
    public ViewsUpdater(Function3<? super View, ? super Integer, ? super Function1<? super Integer, Integer>, Unit> addOrAttachViewToParent, Function1<? super View, Unit> detachViewFromParent, Function1<? super Integer, ? extends View> requestView, Function2<? super View, ? super Integer, Boolean> checkView, Function2<? super View, ? super Integer, Unit> updateView, Function2<? super View, ? super Integer, Unit> recycleView, Function1<? super Integer, Integer> calcIndex) {
        Intrinsics.checkNotNullParameter(addOrAttachViewToParent, "addOrAttachViewToParent");
        Intrinsics.checkNotNullParameter(detachViewFromParent, "detachViewFromParent");
        Intrinsics.checkNotNullParameter(requestView, "requestView");
        Intrinsics.checkNotNullParameter(checkView, "checkView");
        Intrinsics.checkNotNullParameter(updateView, "updateView");
        Intrinsics.checkNotNullParameter(recycleView, "recycleView");
        Intrinsics.checkNotNullParameter(calcIndex, "calcIndex");
        this.addOrAttachViewToParent = addOrAttachViewToParent;
        this.detachViewFromParent = detachViewFromParent;
        this.requestView = requestView;
        this.checkView = checkView;
        this.updateView = updateView;
        this.recycleView = recycleView;
        this.calcIndex = calcIndex;
        this.views = new SparseArray<>();
    }

    private final void updateCellWithIndexToActualContent(int viewIndex, int cellIndex) {
        View view = this.views.get(viewIndex);
        if (view != null) {
            if (this.checkView.invoke(view, Integer.valueOf(cellIndex)).booleanValue()) {
                this.updateView.invoke(view, Integer.valueOf(cellIndex));
                return;
            }
            this.detachViewFromParent.invoke(view);
            this.views.remove(viewIndex);
            this.recycleView.invoke(view, Integer.valueOf(cellIndex));
            createAndSetup(viewIndex, cellIndex);
        }
    }

    public final View getViewForCellWithIndex(int cellIndex) {
        int intValue = this.calcIndex.invoke(Integer.valueOf(cellIndex)).intValue();
        View view = this.views.get(intValue);
        return view == null ? createAndSetup(intValue, cellIndex) : view;
    }

    public final void recycleViewForCellWithIndex(int cellIndex) {
        int intValue = this.calcIndex.invoke(Integer.valueOf(cellIndex)).intValue();
        View view = this.views.get(intValue);
        if (view != null) {
            this.detachViewFromParent.invoke(view);
            this.views.remove(intValue);
            this.recycleView.invoke(view, Integer.valueOf(cellIndex));
        }
    }

    public final void update() {
        IntRange until = RangesKt.until(0, this.views.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(this.views.keyAt(((IntIterator) it).nextInt())));
        }
        Iterator it2 = CollectionsKt.toList(arrayList).iterator();
        while (it2.hasNext()) {
            int intValue = ((Number) it2.next()).intValue();
            updateCellWithIndexToActualContent(intValue, viewIndexToCellIndex(intValue));
        }
    }

    public final void recycle() {
        Iterator<Integer> it = RangesKt.until(0, this.views.size()).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            View valueAt = this.views.valueAt(nextInt);
            Function1<View, Unit> function1 = this.detachViewFromParent;
            Intrinsics.checkNotNull(valueAt);
            function1.invoke(valueAt);
            this.recycleView.invoke(valueAt, Integer.valueOf(viewIndexToCellIndex(this.views.keyAt(nextInt))));
            valueAt.setAlpha(1.0f);
        }
        this.views.clear();
    }

    public final void show() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(Constants.ANIMATION_DURATION);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.pickers.ViewsUpdater$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewsUpdater.show$lambda$9$lambda$8(ViewsUpdater.this, valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$9$lambda$8(ViewsUpdater this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Iterator<Integer> it2 = RangesKt.until(0, this$0.views.size()).iterator();
        while (it2.hasNext()) {
            View valueAt = this$0.views.valueAt(((IntIterator) it2).nextInt());
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            valueAt.setAlpha(((Float) animatedValue).floatValue());
        }
    }

    public final void hide() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(Constants.ANIMATION_DURATION);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devexpress.editors.pickers.ViewsUpdater$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewsUpdater.hide$lambda$13$lambda$12(ViewsUpdater.this, valueAnimator);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.devexpress.editors.pickers.ViewsUpdater$hide$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ViewsUpdater.this.recycle();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ViewsUpdater.this.recycle();
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$13$lambda$12(ViewsUpdater this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Iterator<Integer> it2 = RangesKt.until(0, this$0.views.size()).iterator();
        while (it2.hasNext()) {
            View valueAt = this$0.views.valueAt(((IntIterator) it2).nextInt());
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            valueAt.setAlpha(((Float) animatedValue).floatValue());
        }
    }

    private final View createAndSetup(final int viewIndex, int cellIndex) {
        View invoke = this.requestView.invoke(Integer.valueOf(cellIndex));
        if (invoke == null) {
            return null;
        }
        this.views.put(viewIndex, invoke);
        this.addOrAttachViewToParent.invoke(invoke, Integer.valueOf(viewIndex), new Function1<Integer, Integer>() { // from class: com.devexpress.editors.pickers.ViewsUpdater$createAndSetup$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Integer invoke(int i) {
                return Integer.valueOf(ViewsUpdater.this.viewIndexToCellIndex(viewIndex));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
        return invoke;
    }
}
