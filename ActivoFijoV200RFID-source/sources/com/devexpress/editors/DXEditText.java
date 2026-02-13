package com.devexpress.editors;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import com.devexpress.editors.utils.GestureHandler;
import com.devexpress.editors.utils.Utils;
import com.devexpress.editors.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DXEditText.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001YB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u00105\u001a\u000206J\u0012\u00107\u001a\u0002062\b\u0010.\u001a\u0004\u0018\u000108H\u0017J\u0012\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\bH\u0017J\n\u0010=\u001a\u0004\u0018\u000108H\u0017J\b\u0010>\u001a\u000206H\u0016J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020BH\u0016J\"\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\u0018\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\b2\u0006\u0010:\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\b2\u0006\u0010:\u001a\u00020JH\u0016J\u0018\u0010L\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\b2\u0006\u0010:\u001a\u00020JH\u0016J\u001a\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020\bH\u0017J\u0018\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0014J\b\u0010T\u001a\u000206H\u0002J\u0016\u0010T\u001a\u0002062\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bJ\u0018\u0010W\u001a\u0002062\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J\b\u0010X\u001a\u000206H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u00100\u001a\u0004\u0018\u00010/2\b\u0010.\u001a\u0004\u0018\u00010/@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006Z"}, d2 = {"Lcom/devexpress/editors/DXEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/devexpress/editors/SelectionChangedListenable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autofillDelegate", "Lcom/devexpress/editors/AutofillDelegate;", "getAutofillDelegate", "()Lcom/devexpress/editors/AutofillDelegate;", "setAutofillDelegate", "(Lcom/devexpress/editors/AutofillDelegate;)V", "delayedSelection", "", "delayedSelectionStart", "delayedSelectionStop", "delayedSelectionValidatedStart", "delayedSelectionValidatedStop", "gestureDelegate", "Lcom/devexpress/editors/GestureDelegate;", "getGestureDelegate", "()Lcom/devexpress/editors/GestureDelegate;", "setGestureDelegate", "(Lcom/devexpress/editors/GestureDelegate;)V", "gestureHandler", "Lcom/devexpress/editors/utils/GestureHandler;", "isKeyInputEnabled", "()Z", "setKeyInputEnabled", "(Z)V", "keyDelegate", "Lcom/devexpress/editors/DXEditText$KeyDelegate;", "getKeyDelegate", "()Lcom/devexpress/editors/DXEditText$KeyDelegate;", "setKeyDelegate", "(Lcom/devexpress/editors/DXEditText$KeyDelegate;)V", "selectionChangedListener", "Lcom/devexpress/editors/SelectionChangedListener;", "getSelectionChangedListener", "()Lcom/devexpress/editors/SelectionChangedListener;", "setSelectionChangedListener", "(Lcom/devexpress/editors/SelectionChangedListener;)V", "value", "Lcom/devexpress/editors/DXEditTextChangedWatcher;", "textChangedWatcher", "getTextChangedWatcher", "()Lcom/devexpress/editors/DXEditTextChangedWatcher;", "setTextChangedWatcher", "(Lcom/devexpress/editors/DXEditTextChangedWatcher;)V", "applyTextAlignment", "", "autofill", "Landroid/view/autofill/AutofillValue;", "dispatchTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "getAutofillType", "getAutofillValue", "onBeginBatchEdit", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyPreIme", "onKeyUp", "onProvideAutofillStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onSelectionChanged", "selStart", "selEnd", "setDelayedSelection", "start", "stop", "setValidatedSelection", "setupLongClickListener", "KeyDelegate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXEditText extends AppCompatEditText implements SelectionChangedListenable {
    private AutofillDelegate autofillDelegate;
    private boolean delayedSelection;
    private int delayedSelectionStart;
    private int delayedSelectionStop;
    private int delayedSelectionValidatedStart;
    private int delayedSelectionValidatedStop;
    private GestureDelegate gestureDelegate;
    private final GestureHandler gestureHandler;
    private boolean isKeyInputEnabled;
    private KeyDelegate keyDelegate;
    private SelectionChangedListener selectionChangedListener;
    private DXEditTextChangedWatcher textChangedWatcher;

    /* compiled from: DXEditText.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\tH&JX\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e26\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\tH&JP\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\tH&¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/DXEditText$KeyDelegate;", "", "onKeyDown", "", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "onKeyPreIme", "state", "Landroid/view/KeyEvent$DispatcherState;", "onKeyUp", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface KeyDelegate {
        boolean onKeyDown(int keyCode, KeyEvent event, Function2<? super Integer, ? super KeyEvent, Boolean> callback);

        boolean onKeyPreIme(int keyCode, KeyEvent event, KeyEvent.DispatcherState state, Function2<? super Integer, ? super KeyEvent, Boolean> callback);

        boolean onKeyUp(int keyCode, KeyEvent event, Function2<? super Integer, ? super KeyEvent, Boolean> callback);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DXEditText(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DXEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DXEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isKeyInputEnabled = true;
        this.delayedSelectionStart = -1;
        this.delayedSelectionStop = -1;
        this.delayedSelectionValidatedStart = -1;
        this.delayedSelectionValidatedStop = -1;
        this.gestureHandler = new GestureHandler();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLongClickable(true);
        setupLongClickListener();
    }

    public /* synthetic */ DXEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? androidx.appcompat.R.attr.editTextStyle : i);
    }

    @Override // com.devexpress.editors.SelectionChangedListenable
    public SelectionChangedListener getSelectionChangedListener() {
        return this.selectionChangedListener;
    }

    @Override // com.devexpress.editors.SelectionChangedListenable
    public void setSelectionChangedListener(SelectionChangedListener selectionChangedListener) {
        this.selectionChangedListener = selectionChangedListener;
    }

    public final DXEditTextChangedWatcher getTextChangedWatcher() {
        return this.textChangedWatcher;
    }

    public final void setTextChangedWatcher(DXEditTextChangedWatcher dXEditTextChangedWatcher) {
        if (Intrinsics.areEqual(this.textChangedWatcher, dXEditTextChangedWatcher)) {
            return;
        }
        removeTextChangedListener(this.textChangedWatcher);
        this.textChangedWatcher = dXEditTextChangedWatcher;
        addTextChangedListener(dXEditTextChangedWatcher);
    }

    public final KeyDelegate getKeyDelegate() {
        return this.keyDelegate;
    }

    public final void setKeyDelegate(KeyDelegate keyDelegate) {
        this.keyDelegate = keyDelegate;
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

    /* renamed from: isKeyInputEnabled, reason: from getter */
    public final boolean getIsKeyInputEnabled() {
        return this.isKeyInputEnabled;
    }

    public final void setKeyInputEnabled(boolean z) {
        this.isKeyInputEnabled = z;
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(AutofillValue value) {
        AutofillDelegate autofillDelegate = this.autofillDelegate;
        if (autofillDelegate != null) {
            autofillDelegate.autofill(value);
        }
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

    @Override // android.view.View
    public void onProvideAutofillStructure(ViewStructure structure, int flags) {
        String[] autofillHints;
        super.onProvideAutofillStructure(structure, flags);
        if (getAutofillType() != 3 || (autofillHints = getAutofillHints()) == null || autofillHints.length == 0 || structure == null) {
            return;
        }
        AutofillDelegate autofillDelegate = this.autofillDelegate;
        structure.setAutofillOptions(autofillDelegate != null ? autofillDelegate.provideAutofillOptions() : null);
    }

    public final void setDelayedSelection(int start, int stop) {
        if (isFocused()) {
            if (this.delayedSelection) {
                setValidatedSelection(this.delayedSelectionStart, this.delayedSelectionStop);
                return;
            } else {
                setValidatedSelection(start, stop);
                return;
            }
        }
        this.delayedSelectionStart = start;
        this.delayedSelectionStop = stop;
    }

    private final void setDelayedSelection() {
        setDelayedSelection(this.delayedSelectionStart, this.delayedSelectionStop);
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
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.devexpress.editors.DXEditText$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean z;
                z = DXEditText.setupLongClickListener$lambda$0(DXEditText.this, view);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupLongClickListener$lambda$0(DXEditText this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.gestureHandler.getTouchEventHandled()) {
            return false;
        }
        this$0.gestureHandler.setLongTapHandled(true);
        GestureDelegate gestureDelegate = this$0.gestureDelegate;
        if (gestureDelegate != null) {
            return gestureDelegate.onLongPress();
        }
        return false;
    }

    private final void setValidatedSelection(int start, int stop) {
        int i;
        int i2;
        int length = length();
        if (stop < 0) {
            i = start;
            i2 = length;
        } else if (start <= stop) {
            i = start;
            i2 = stop;
        } else {
            i2 = start;
            i = stop;
        }
        int clamp = Utils.clamp(i, 0, length);
        int clamp2 = Utils.clamp(i2, clamp, length);
        this.delayedSelectionValidatedStart = clamp;
        this.delayedSelectionValidatedStop = clamp2;
        setSelection(clamp, clamp2);
        if (clamp == start && clamp2 == stop) {
            return;
        }
        onSelectionChanged(clamp, clamp2);
    }

    public final void applyTextAlignment() {
        Editable text = getText();
        Editable editable = text;
        if (editable == null || editable.length() == 0) {
            return;
        }
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment != 2) {
                if (textAlignment != 3) {
                    if (textAlignment != 5) {
                        if (textAlignment != 6) {
                            return;
                        }
                    }
                }
                setSelection(text.length());
                return;
            }
            setSelection(0);
            return;
        }
        if (UtilsKt.has(getGravity(), GravityCompat.END)) {
            setSelection(text.length());
        }
        if (UtilsKt.has(getGravity(), GravityCompat.START)) {
            setSelection(0);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (isFocused() && this.delayedSelectionStart > -1 && this.delayedSelectionStop > -1) {
            this.delayedSelection = true;
        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (this.delayedSelection) {
            setDelayedSelection();
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        if (this.delayedSelection && selStart == this.delayedSelectionValidatedStart && selEnd == this.delayedSelectionValidatedStop) {
            this.delayedSelection = false;
        }
        super.onSelectionChanged(selStart, selEnd);
        SelectionChangedListener selectionChangedListener = getSelectionChangedListener();
        if (selectionChangedListener != null) {
            selectionChangedListener.onSelectionChanged(selStart, selEnd);
        }
    }

    @Override // android.widget.TextView
    public void onBeginBatchEdit() {
        super.onBeginBatchEdit();
        DXEditTextChangedWatcher dXEditTextChangedWatcher = this.textChangedWatcher;
        if (dXEditTextChangedWatcher != null) {
            dXEditTextChangedWatcher.onBeginBatchEdit();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isKeyInputEnabled) {
            return false;
        }
        if (event.getAction() == 1 && (keyCode == 66 || keyCode == 160)) {
            return true;
        }
        KeyDelegate keyDelegate = this.keyDelegate;
        if (keyDelegate == null) {
            return super.onKeyPreIme(keyCode, event);
        }
        KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
        Intrinsics.checkNotNullExpressionValue(keyDispatcherState, "getKeyDispatcherState(...)");
        return keyDelegate.onKeyPreIme(keyCode, event, keyDispatcherState, new Function2<Integer, KeyEvent, Boolean>() { // from class: com.devexpress.editors.DXEditText$onKeyPreIme$1
            {
                super(2);
            }

            public final Boolean invoke(int i, KeyEvent e) {
                boolean onKeyPreIme;
                Intrinsics.checkNotNullParameter(e, "e");
                onKeyPreIme = super/*androidx.appcompat.widget.AppCompatEditText*/.onKeyPreIme(i, e);
                return Boolean.valueOf(onKeyPreIme);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, KeyEvent keyEvent) {
                return invoke(num.intValue(), keyEvent);
            }
        });
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isKeyInputEnabled) {
            return false;
        }
        KeyDelegate keyDelegate = this.keyDelegate;
        return keyDelegate != null ? keyDelegate.onKeyDown(keyCode, event, new Function2<Integer, KeyEvent, Boolean>() { // from class: com.devexpress.editors.DXEditText$onKeyDown$1
            {
                super(2);
            }

            public final Boolean invoke(int i, KeyEvent e) {
                boolean onKeyDown;
                Intrinsics.checkNotNullParameter(e, "e");
                onKeyDown = super/*androidx.appcompat.widget.AppCompatEditText*/.onKeyDown(i, e);
                return Boolean.valueOf(onKeyDown);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, KeyEvent keyEvent) {
                return invoke(num.intValue(), keyEvent);
            }
        }) : super.onKeyDown(keyCode, event);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isKeyInputEnabled) {
            return false;
        }
        KeyDelegate keyDelegate = this.keyDelegate;
        return keyDelegate != null ? keyDelegate.onKeyUp(keyCode, event, new Function2<Integer, KeyEvent, Boolean>() { // from class: com.devexpress.editors.DXEditText$onKeyUp$1
            {
                super(2);
            }

            public final Boolean invoke(int i, KeyEvent e) {
                boolean onKeyUp;
                Intrinsics.checkNotNullParameter(e, "e");
                onKeyUp = super/*androidx.appcompat.widget.AppCompatEditText*/.onKeyUp(i, e);
                return Boolean.valueOf(onKeyUp);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, KeyEvent keyEvent) {
                return invoke(num.intValue(), keyEvent);
            }
        }) : super.onKeyUp(keyCode, event);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        outAttrs.imeOptions = (outAttrs.imeOptions & (-1073741825)) | 33554432;
        return onCreateInputConnection;
    }
}
