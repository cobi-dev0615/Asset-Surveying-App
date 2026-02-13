package com.devexpress.editors.popupmanagers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.devexpress.editors.DXAutoCompleteTextChangeReason;
import com.devexpress.editors.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoCompletePopupManager.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020:H\u0002J\b\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020:H\u0002J\u000e\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020:J&\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u0010J\u0012\u0010H\u001a\u00020:2\b\u0010I\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020'@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR$\u00104\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006J"}, d2 = {"Lcom/devexpress/editors/popupmanagers/AutoCompletePopupManager;", "Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManager;", "context", "Landroid/content/Context;", "delegate", "Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;", "(Landroid/content/Context;Lcom/devexpress/editors/popupmanagers/CollectionViewPopupManagerDelegate;)V", "loadIndicatorView", "Landroid/widget/ProgressBar;", "manageWaitIndicatorAutomatically", "", "getManageWaitIndicatorAutomatically", "()Z", "setManageWaitIndicatorAutomatically", "(Z)V", "noResultsFoundPaddingBottom", "", "noResultsFoundPaddingEnd", "noResultsFoundPaddingStart", "noResultsFoundPaddingTop", "value", "", "noResultsFoundText", "getNoResultsFoundText", "()Ljava/lang/CharSequence;", "setNoResultsFoundText", "(Ljava/lang/CharSequence;)V", "", "noResultsFoundTextSize", "getNoResultsFoundTextSize", "()F", "setNoResultsFoundTextSize", "(F)V", "Landroid/content/res/ColorStateList;", "noResultsFoundTextTint", "getNoResultsFoundTextTint", "()Landroid/content/res/ColorStateList;", "setNoResultsFoundTextTint", "(Landroid/content/res/ColorStateList;)V", "Landroid/graphics/Typeface;", "noResultsFoundTextTypeface", "getNoResultsFoundTextTypeface", "()Landroid/graphics/Typeface;", "setNoResultsFoundTextTypeface", "(Landroid/graphics/Typeface;)V", "noResultsFoundView", "Landroid/widget/TextView;", "noResultsFoundWrapper", "Landroid/widget/FrameLayout;", "showWaitIndicator", "getShowWaitIndicator", "setShowWaitIndicator", "waitIndicatorColor", "getWaitIndicatorColor", "()I", "setWaitIndicatorColor", "(I)V", "buildContent", "", "buildLoadIndicator", "buildNoResultsFound", "createLoadIndicatorView", "createNoResultsFoundView", "handleTextChanged", "reason", "Lcom/devexpress/editors/DXAutoCompleteTextChangeReason;", "resetPadding", "setPaddingRelative", "start", "top", "end", "bottom", "updateWaitIndicatorColor", "indicatorView", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AutoCompletePopupManager extends CollectionViewPopupManager {
    private ProgressBar loadIndicatorView;
    private boolean manageWaitIndicatorAutomatically;
    private int noResultsFoundPaddingBottom;
    private int noResultsFoundPaddingEnd;
    private int noResultsFoundPaddingStart;
    private int noResultsFoundPaddingTop;
    private CharSequence noResultsFoundText;
    private float noResultsFoundTextSize;
    private ColorStateList noResultsFoundTextTint;
    private Typeface noResultsFoundTextTypeface;
    private TextView noResultsFoundView;
    private FrameLayout noResultsFoundWrapper;
    private boolean showWaitIndicator;
    private int waitIndicatorColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCompletePopupManager(Context context, CollectionViewPopupManagerDelegate delegate) {
        super(context, delegate);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.noResultsFoundPaddingStart = -1;
        this.noResultsFoundPaddingTop = -1;
        this.noResultsFoundPaddingEnd = -1;
        this.noResultsFoundPaddingBottom = -1;
        this.noResultsFoundText = "";
        ColorStateList valueOf = ColorStateList.valueOf(-16777216);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        this.noResultsFoundTextTint = valueOf;
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.noResultsFoundTextTypeface = DEFAULT;
    }

    public final boolean getManageWaitIndicatorAutomatically() {
        return this.manageWaitIndicatorAutomatically;
    }

    public final void setManageWaitIndicatorAutomatically(boolean z) {
        this.manageWaitIndicatorAutomatically = z;
    }

    public final boolean getShowWaitIndicator() {
        return this.showWaitIndicator;
    }

    public final void setShowWaitIndicator(boolean z) {
        if (this.showWaitIndicator == z) {
            return;
        }
        this.showWaitIndicator = z;
        showPopup();
    }

    public final int getWaitIndicatorColor() {
        return this.waitIndicatorColor;
    }

    public final void setWaitIndicatorColor(int i) {
        if (this.waitIndicatorColor == i) {
            return;
        }
        this.waitIndicatorColor = i;
        updateWaitIndicatorColor(this.loadIndicatorView);
    }

    public final CharSequence getNoResultsFoundText() {
        return this.noResultsFoundText;
    }

    public final void setNoResultsFoundText(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.noResultsFoundText, value)) {
            return;
        }
        this.noResultsFoundText = value;
        TextView textView = this.noResultsFoundView;
        if (textView == null) {
            return;
        }
        textView.setText(value);
    }

    public final ColorStateList getNoResultsFoundTextTint() {
        return this.noResultsFoundTextTint;
    }

    public final void setNoResultsFoundTextTint(ColorStateList value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.noResultsFoundTextTint, value)) {
            return;
        }
        this.noResultsFoundTextTint = value;
        TextView textView = this.noResultsFoundView;
        if (textView != null) {
            textView.setTextColor(value);
        }
    }

    public final Typeface getNoResultsFoundTextTypeface() {
        return this.noResultsFoundTextTypeface;
    }

    public final void setNoResultsFoundTextTypeface(Typeface value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.noResultsFoundTextTypeface, value)) {
            return;
        }
        this.noResultsFoundTextTypeface = value;
        TextView textView = this.noResultsFoundView;
        if (textView == null) {
            return;
        }
        textView.setTypeface(value);
    }

    public final float getNoResultsFoundTextSize() {
        return this.noResultsFoundTextSize;
    }

    public final void setNoResultsFoundTextSize(float f) {
        if (this.noResultsFoundTextSize == f) {
            return;
        }
        this.noResultsFoundTextSize = f;
        TextView textView = this.noResultsFoundView;
        if (textView != null) {
            textView.setTextSize(0, f);
        }
    }

    public final void handleTextChanged(DXAutoCompleteTextChangeReason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (reason != DXAutoCompleteTextChangeReason.ItemSelected && this.manageWaitIndicatorAutomatically) {
            setShowWaitIndicator(getDelegate().isDataSourceEmpty());
            if (isPopupShowing()) {
                return;
            }
            showPopup();
        }
    }

    public final void setPaddingRelative(int start, int top, int end, int bottom) {
        this.noResultsFoundPaddingStart = start;
        this.noResultsFoundPaddingTop = top;
        this.noResultsFoundPaddingEnd = end;
        this.noResultsFoundPaddingBottom = bottom;
        TextView textView = this.noResultsFoundView;
        if (textView != null) {
            textView.setPaddingRelative(start, top, end, bottom);
        }
    }

    public final void resetPadding() {
        this.noResultsFoundPaddingStart = getContext().getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingStart);
        this.noResultsFoundPaddingTop = getContext().getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingVertical);
        this.noResultsFoundPaddingEnd = getContext().getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingEnd);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.editor_dropDownItem_paddingVertical);
        this.noResultsFoundPaddingBottom = dimensionPixelSize;
        TextView textView = this.noResultsFoundView;
        if (textView != null) {
            textView.setPaddingRelative(this.noResultsFoundPaddingStart, this.noResultsFoundPaddingTop, this.noResultsFoundPaddingEnd, dimensionPixelSize);
        }
    }

    @Override // com.devexpress.editors.popupmanagers.CollectionViewPopupManager
    public void buildContent() {
        if (this.showWaitIndicator) {
            buildLoadIndicator();
        } else if (getDelegate().isDataSourceEmpty()) {
            buildNoResultsFound();
        } else {
            super.buildContent();
        }
    }

    private final void buildLoadIndicator() {
        if (this.loadIndicatorView == null) {
            createLoadIndicatorView();
        }
        ProgressBar progressBar = this.loadIndicatorView;
        if (progressBar == null) {
            throw new Exception("Wait indicator is not created!");
        }
        setContentView(progressBar);
        updateWaitIndicatorColor(progressBar);
    }

    private final void buildNoResultsFound() {
        if (this.noResultsFoundView == null) {
            createNoResultsFoundView();
        }
        FrameLayout frameLayout = this.noResultsFoundWrapper;
        if (frameLayout == null) {
            throw new Exception("No results found TextView is not created!");
        }
        setContentView(frameLayout);
    }

    private final void createLoadIndicatorView() {
        this.loadIndicatorView = new ProgressBar(getContext());
    }

    private final void createNoResultsFoundView() {
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setText(this.noResultsFoundText);
        appCompatTextView.setTypeface(this.noResultsFoundTextTypeface);
        appCompatTextView.setTextSize(0, this.noResultsFoundTextSize);
        appCompatTextView.setTextColor(this.noResultsFoundTextTint);
        appCompatTextView.setPaddingRelative(this.noResultsFoundPaddingStart, this.noResultsFoundPaddingTop, this.noResultsFoundPaddingEnd, this.noResultsFoundPaddingBottom);
        this.noResultsFoundView = appCompatTextView;
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(appCompatTextView, new FrameLayout.LayoutParams(-1, -2, 8388627));
        this.noResultsFoundWrapper = frameLayout;
    }

    private final void updateWaitIndicatorColor(ProgressBar indicatorView) {
        if (indicatorView != null) {
            if (this.waitIndicatorColor != 0) {
                indicatorView.getIndeterminateDrawable().setColorFilter(new PorterDuffColorFilter(this.waitIndicatorColor, PorterDuff.Mode.SRC_ATOP));
            } else {
                indicatorView.getIndeterminateDrawable().clearColorFilter();
            }
        }
    }
}
