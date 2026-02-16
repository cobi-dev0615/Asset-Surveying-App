package com.devexpress.editors;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.widget.NestedScrollView;
import com.devexpress.dxcore.DXNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipGroup.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J0\u00108\u001a\u0002062\u0006\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0014J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0014J\b\u0010B\u001a\u000206H\u0016J\b\u0010C\u001a\u000206H\u0016J\u0006\u0010D\u001a\u000206J\b\u0010E\u001a\u000206H\u0002J \u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010\u00162\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00160IH\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR$\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u000e\u0010)\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0017\u001a\u0004\u0018\u00010*@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/devexpress/editors/ChipGroup;", "Lcom/devexpress/dxcore/DXNativeView;", "Lcom/devexpress/editors/ChipGroupLayoutDelegate;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chipGroupAction", "Lcom/devexpress/editors/ChipGroupAction;", "getChipGroupAction", "()Lcom/devexpress/editors/ChipGroupAction;", "setChipGroupAction", "(Lcom/devexpress/editors/ChipGroupAction;)V", "chipLayout", "Lcom/devexpress/editors/ChipLayout;", "chips", "", "Landroid/view/View;", "value", "horizontalItemSpacing", "getHorizontalItemSpacing", "()I", "setHorizontalItemSpacing", "(I)V", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "inputViewMinimumWidth", "getInputViewMinimumWidth", "setInputViewMinimumWidth", "", "isMultiline", "()Z", "setMultiline", "(Z)V", "isScrollBarVisible", "setScrollBarVisible", "needsUpdateItems", "Lcom/devexpress/editors/ChipItemViewProvider;", "provider", "getProvider", "()Lcom/devexpress/editors/ChipItemViewProvider;", "setProvider", "(Lcom/devexpress/editors/ChipItemViewProvider;)V", "verticalItemSpacing", "getVerticalItemSpacing", "setVerticalItemSpacing", "verticalScrollView", "Landroidx/core/widget/NestedScrollView;", "changeScrollDirection", "", "getCurrentScrollView", "onLayout", "changed", "l", "t", "r", "b", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "onMultilineChange", "requestLayout", "setItemsNeedUpdate", "updateItems", "updateLayoutWithItems", "inputView", "items", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChipGroup extends DXNativeView implements ChipGroupLayoutDelegate {
    private ChipGroupAction chipGroupAction;
    private ChipLayout chipLayout;
    private final Set<View> chips;
    private HorizontalScrollView horizontalScrollView;
    private int inputViewMinimumWidth;
    private boolean needsUpdateItems;
    private ChipItemViewProvider provider;
    private NestedScrollView verticalScrollView;

    public final ChipItemViewProvider getProvider() {
        return this.provider;
    }

    public final void setProvider(ChipItemViewProvider chipItemViewProvider) {
        if (Intrinsics.areEqual(this.provider, chipItemViewProvider)) {
            return;
        }
        this.provider = chipItemViewProvider;
        this.chipLayout.setProvider$dxeditors_release(chipItemViewProvider);
        updateItems();
    }

    public final ChipGroupAction getChipGroupAction() {
        return this.chipGroupAction;
    }

    public final void setChipGroupAction(ChipGroupAction chipGroupAction) {
        this.chipGroupAction = chipGroupAction;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipGroup(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.horizontalScrollView = new HorizontalScrollView(getContext());
        this.verticalScrollView = new NestedScrollView(getContext());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.chipLayout = new ChipLayout(context2);
        setMultiline(true);
        this.verticalScrollView.setVerticalScrollBarEnabled(false);
        this.horizontalScrollView.setHorizontalScrollBarEnabled(false);
        changeScrollDirection();
        this.verticalScrollView.setClipChildren(false);
        this.verticalScrollView.setClipToPadding(false);
        this.horizontalScrollView.setClipChildren(false);
        this.horizontalScrollView.setClipToPadding(false);
        this.chipLayout.setClipChildren(false);
        this.chipLayout.setClipToPadding(false);
        this.chips = new LinkedHashSet();
        this.needsUpdateItems = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipGroup(Context context, AttributeSet attrs) {
        super(context, attrs, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.horizontalScrollView = new HorizontalScrollView(getContext());
        this.verticalScrollView = new NestedScrollView(getContext());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.chipLayout = new ChipLayout(context2);
        setMultiline(true);
        this.verticalScrollView.setVerticalScrollBarEnabled(false);
        this.horizontalScrollView.setHorizontalScrollBarEnabled(false);
        changeScrollDirection();
        this.verticalScrollView.setClipChildren(false);
        this.verticalScrollView.setClipToPadding(false);
        this.horizontalScrollView.setClipChildren(false);
        this.horizontalScrollView.setClipToPadding(false);
        this.chipLayout.setClipChildren(false);
        this.chipLayout.setClipToPadding(false);
        this.chips = new LinkedHashSet();
        this.needsUpdateItems = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipGroup(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.horizontalScrollView = new HorizontalScrollView(getContext());
        this.verticalScrollView = new NestedScrollView(getContext());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.chipLayout = new ChipLayout(context2);
        setMultiline(true);
        this.verticalScrollView.setVerticalScrollBarEnabled(false);
        this.horizontalScrollView.setHorizontalScrollBarEnabled(false);
        changeScrollDirection();
        this.verticalScrollView.setClipChildren(false);
        this.verticalScrollView.setClipToPadding(false);
        this.horizontalScrollView.setClipChildren(false);
        this.horizontalScrollView.setClipToPadding(false);
        this.chipLayout.setClipChildren(false);
        this.chipLayout.setClipToPadding(false);
        this.chips = new LinkedHashSet();
        this.needsUpdateItems = true;
    }

    public final boolean isMultiline() {
        return this.chipLayout.getIsMultiline();
    }

    public final void setMultiline(boolean z) {
        this.chipLayout.setMultiline$dxeditors_release(z);
    }

    public final int getVerticalItemSpacing() {
        return this.chipLayout.getVerticalItemSpacing();
    }

    public final void setVerticalItemSpacing(int i) {
        this.chipLayout.setVerticalItemSpacing$dxeditors_release(i);
    }

    public final int getHorizontalItemSpacing() {
        return this.chipLayout.getHorizontalItemSpacing();
    }

    public final void setHorizontalItemSpacing(int i) {
        this.chipLayout.setHorizontalItemSpacing$dxeditors_release(i);
    }

    public final int getInputViewMinimumWidth() {
        return this.inputViewMinimumWidth;
    }

    public final void setInputViewMinimumWidth(int i) {
        if (this.inputViewMinimumWidth != i) {
            this.inputViewMinimumWidth = i;
        }
    }

    public final boolean isScrollBarVisible() {
        return this.verticalScrollView.isVerticalScrollBarEnabled();
    }

    public final void setScrollBarVisible(boolean z) {
        this.horizontalScrollView.setHorizontalScrollBarEnabled(z);
        this.verticalScrollView.setVerticalScrollBarEnabled(z);
    }

    public final void setItemsNeedUpdate() {
        this.needsUpdateItems = true;
        requestLayout();
    }

    private final void updateItems() {
        ChipItemViewProvider chipItemViewProvider = this.provider;
        if (chipItemViewProvider == null) {
            return;
        }
        Intrinsics.checkNotNull(chipItemViewProvider);
        int itemCount = chipItemViewProvider.getItemCount();
        int i = itemCount - 1;
        if (chipItemViewProvider.getViewTypeByIndex(i) == ChipItemsProviderViewType.InputView) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(chipItemViewProvider.getViewByIndex(i2));
            }
            updateLayoutWithItems(chipItemViewProvider.getViewByIndex(i), arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList(itemCount);
            for (int i3 = 0; i3 < itemCount; i3++) {
                arrayList2.add(chipItemViewProvider.getViewByIndex(i3));
            }
            updateLayoutWithItems(null, arrayList2);
        }
        this.needsUpdateItems = false;
    }

    private final void updateLayoutWithItems(View inputView, List<? extends View> items) {
        if (inputView != null) {
            Iterator<View> it = this.chips.iterator();
            while (it.hasNext()) {
                this.chipLayout.removeView(it.next());
            }
            if (!Intrinsics.areEqual(this.chipLayout.getChildAt(0), inputView)) {
                if (this.chipLayout.getChildCount() == 1) {
                    this.chipLayout.removeViewAt(0);
                }
                if (inputView.getParent() != null) {
                    ViewParent parent = inputView.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(inputView);
                }
                this.chipLayout.addView(inputView, 0);
            }
        } else {
            this.chipLayout.removeAllViews();
        }
        this.chips.clear();
        for (int size = items.size() - 1; -1 < size; size--) {
            this.chipLayout.addView(items.get(size));
            this.chips.add(items.get(size));
        }
    }

    @Override // com.devexpress.editors.ChipGroupLayoutDelegate
    public void onMultilineChange() {
        changeScrollDirection();
    }

    private final void changeScrollDirection() {
        removeAllViews();
        if (isMultiline()) {
            this.horizontalScrollView.removeAllViews();
            this.verticalScrollView.addView(this.chipLayout);
            addView(this.verticalScrollView);
        } else {
            this.verticalScrollView.removeAllViews();
            this.horizontalScrollView.addView(this.chipLayout);
            addView(this.horizontalScrollView);
        }
        this.chipLayout.setDelegate(this);
    }

    private final View getCurrentScrollView() {
        if (isMultiline()) {
            return this.verticalScrollView;
        }
        return this.horizontalScrollView;
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.needsUpdateItems) {
            updateItems();
        }
        int makeMeasureSpec = View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824 ? View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight(), BasicMeasure.EXACTLY) : widthMeasureSpec;
        int makeMeasureSpec2 = View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824 ? View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom(), BasicMeasure.EXACTLY) : heightMeasureSpec;
        View childAt = getChildAt(0);
        measureChildren(makeMeasureSpec, makeMeasureSpec2);
        return new Size(View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824 ? View.MeasureSpec.getSize(widthMeasureSpec) : childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824 ? View.MeasureSpec.getSize(heightMeasureSpec) : childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.needsUpdateItems) {
            updateItems();
        }
        getCurrentScrollView().layout(getPaddingLeft(), getPaddingTop(), (r - l) - getPaddingRight(), (b - t) - getPaddingBottom());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        ChipGroupAction chipGroupAction = this.chipGroupAction;
        if (chipGroupAction != null) {
            chipGroupAction.onLayoutChanged();
        }
    }
}
