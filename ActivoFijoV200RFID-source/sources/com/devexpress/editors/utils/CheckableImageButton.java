package com.devexpress.editors.utils;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import com.devexpress.editors.DXLocker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckableImageButton.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002\"#B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/devexpress/editors/utils/CheckableImageButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locker", "Lcom/devexpress/editors/DXLocker;", "mChecked", "", "onCheckedChangeListener", "Lcom/devexpress/editors/utils/CheckableImageButton$OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Lcom/devexpress/editors/utils/CheckableImageButton$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/devexpress/editors/utils/CheckableImageButton$OnCheckedChangeListener;)V", "toggleOnClick", "getToggleOnClick", "()Z", "setToggleOnClick", "(Z)V", "isChecked", "onCreateDrawableState", "", "extraSpace", "performClick", "setChecked", "", "checked", "toggle", "Companion", "OnCheckedChangeListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private DXLocker locker;
    private boolean mChecked;
    private OnCheckedChangeListener onCheckedChangeListener;
    private boolean toggleOnClick;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};

    /* compiled from: CheckableImageButton.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/devexpress/editors/utils/CheckableImageButton$OnCheckedChangeListener;", "", "onCheckedChanged", "", "checkable", "Landroid/widget/Checkable;", "isChecked", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnCheckedChangeListener {
        void onCheckedChanged(Checkable checkable, boolean isChecked);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.toggleOnClick = true;
        this.locker = new DXLocker();
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    public /* synthetic */ CheckableImageButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public final boolean getToggleOnClick() {
        return this.toggleOnClick;
    }

    public final void setToggleOnClick(boolean z) {
        this.toggleOnClick = z;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] onCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        Intrinsics.checkNotNullExpressionValue(onCreateDrawableState, "onCreateDrawableState(...)");
        if (isChecked()) {
            AppCompatImageButton.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.toggleOnClick) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.mChecked == checked) {
            return;
        }
        this.mChecked = checked;
        DXLocker dXLocker = this.locker;
        if (!dXLocker.isLocked()) {
            try {
                dXLocker.lock();
                OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(this, this.mChecked);
                }
            } finally {
                dXLocker.unlock();
            }
        }
        refreshDrawableState();
    }
}
