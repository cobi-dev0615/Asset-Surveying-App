package com.devexpress.editors.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.autofill.AutofillValue;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import com.devexpress.editors.AutofillDelegate;
import com.devexpress.editors.GestureDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXTextView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0017J\n\u0010 \u001a\u0004\u0018\u00010\u001aH\u0017J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0018H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/devexpress/editors/utils/DXTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autofillDelegate", "Lcom/devexpress/editors/AutofillDelegate;", "getAutofillDelegate", "()Lcom/devexpress/editors/AutofillDelegate;", "setAutofillDelegate", "(Lcom/devexpress/editors/AutofillDelegate;)V", "gestureDelegate", "Lcom/devexpress/editors/GestureDelegate;", "getGestureDelegate", "()Lcom/devexpress/editors/GestureDelegate;", "setGestureDelegate", "(Lcom/devexpress/editors/GestureDelegate;)V", "gestureHandler", "Lcom/devexpress/editors/utils/GestureHandler;", "autofill", "", "value", "Landroid/view/autofill/AutofillValue;", "dispatchTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "getAutofillType", "getAutofillValue", "setInputType", "type", "setupLongClickListener", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXTextView extends AppCompatTextView {
    private AutofillDelegate autofillDelegate;
    private GestureDelegate gestureDelegate;
    private final GestureHandler gestureHandler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DXTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DXTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.TextView
    public void setInputType(int type) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gestureHandler = new GestureHandler();
        setupLongClickListener();
    }

    public /* synthetic */ DXTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    public final AutofillDelegate getAutofillDelegate() {
        return this.autofillDelegate;
    }

    public final void setAutofillDelegate(AutofillDelegate autofillDelegate) {
        this.autofillDelegate = autofillDelegate;
    }

    public final GestureDelegate getGestureDelegate() {
        return this.gestureDelegate;
    }

    public final void setGestureDelegate(GestureDelegate gestureDelegate) {
        this.gestureDelegate = gestureDelegate;
    }

    @Override // android.widget.TextView, android.view.View
    public int getAutofillType() {
        AutofillDelegate autofillDelegate = this.autofillDelegate;
        if (autofillDelegate != null) {
            return autofillDelegate.provideAutofillType();
        }
        return 0;
    }

    @Override // android.widget.TextView, android.view.View
    public AutofillValue getAutofillValue() {
        AutofillDelegate autofillDelegate = this.autofillDelegate;
        if (autofillDelegate != null) {
            return autofillDelegate.provideAutofillValue();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(AutofillValue value) {
        AutofillDelegate autofillDelegate = this.autofillDelegate;
        if (autofillDelegate != null) {
            autofillDelegate.autofill(value);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        GestureHandler gestureHandler = this.gestureHandler;
        Intrinsics.checkNotNull(event);
        if (gestureHandler.dispatchTouchEvent(event, this.gestureDelegate)) {
            return true;
        }
        super.dispatchTouchEvent(event);
        return true;
    }

    private final void setupLongClickListener() {
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.devexpress.editors.utils.DXTextView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean z;
                z = DXTextView.setupLongClickListener$lambda$0(DXTextView.this, view);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupLongClickListener$lambda$0(DXTextView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.gestureHandler.getTouchEventHandled()) {
            this$0.gestureHandler.setLongTapHandled(true);
            GestureDelegate gestureDelegate = this$0.gestureDelegate;
            if (gestureDelegate != null) {
                gestureDelegate.onLongPress();
            }
        }
        return true;
    }
}
