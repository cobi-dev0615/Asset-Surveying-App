package com.devexpress.editors;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.editors.TextEditBase;
import com.devexpress.editors.layout.factories.TextEditLayoutElementsFactory;
import com.devexpress.editors.utils.WeakProperty;
import com.devexpress.editors.utils.WeakPropertyKt;
import com.devexpress.editors.utils.textstrategies.DefaultTextStrategy;
import com.devexpress.editors.utils.textstrategies.TextStrategy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: TextEditBase.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 \u0091\u00012\u00020\u0001:\n\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010U\u001a\u00020VH\u0004J\u0006\u0010W\u001a\u00020VJ\b\u0010X\u001a\u00020YH\u0014J\u0017\u0010Z\u001a\u00020Q2\b\u0010[\u001a\u0004\u0018\u00010QH\u0010¢\u0006\u0002\b\\J\u0010\u0010]\u001a\u00020V2\u0006\u0010^\u001a\u00020_H\u0005J(\u0010`\u001a\u00020V2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0007H\u0005J(\u0010d\u001a\u00020V2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0015J\u001a\u0010f\u001a\u00020V2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010g\u001a\u00020\nH\u0002J\b\u0010h\u001a\u00020VH\u0004J\u0018\u0010i\u001a\u00020V2\u0006\u0010j\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020kH\u0014J\u0012\u0010l\u001a\u00020V2\b\u0010m\u001a\u0004\u0018\u00010nH\u0014J\b\u0010o\u001a\u00020VH\u0014J\b\u0010p\u001a\u00020VH\u0014J\b\u0010q\u001a\u00020VH\u0014J0\u0010r\u001a\u00020V2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u0007H\u0014J\u0018\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u0007H\u0014J\u0012\u0010|\u001a\u00020V2\b\u0010^\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010}\u001a\u00020VH\u0014J\b\u0010~\u001a\u00020VH\u0004J\u0006\u0010\u007f\u001a\u00020VJ\u0012\u0010\u0080\u0001\u001a\u00020V2\u0007\u0010\u0081\u0001\u001a\u00020\nH\u0014J\u0014\u0010\u0082\u0001\u001a\u00020V2\t\u0010\r\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020V2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0014J\u0010\u0010\u0086\u0001\u001a\u00020V2\u0007\u0010\u0087\u0001\u001a\u00020\u0007J\u0018\u0010\u0086\u0001\u001a\u00020V2\u0006\u0010a\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u0007J\t\u0010\u0089\u0001\u001a\u00020VH\u0002J\t\u0010\u008a\u0001\u001a\u00020VH\u0002J\t\u0010\u008b\u0001\u001a\u00020VH\u0002J\t\u0010\u008c\u0001\u001a\u00020VH\u0002J\t\u0010\u008d\u0001\u001a\u00020VH\u0014J\t\u0010\u008e\u0001\u001a\u00020VH\u0002J\t\u0010\u008f\u0001\u001a\u00020VH\u0014J\t\u0010\u0090\u0001\u001a\u00020VH\u0002R\u0014\u0010\t\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R(\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\fR(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010*8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R$\u00103\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u00105R$\u00106\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u00105R$\u00108\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\f\"\u0004\b:\u00105R\u000e\u0010;\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\r\u001a\u0004\u0018\u00010<@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010D\u001a\u0004\u0018\u00010C2\b\u0010B\u001a\u0004\u0018\u00010C8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bJ\u0010\u0018R\u0011\u0010K\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bL\u0010\u0018R(\u0010M\u001a\u0004\u0018\u00010\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bN\u0010\u001e\"\u0004\bO\u0010&R \u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u00020Q8@@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006\u0096\u0001"}, d2 = {"Lcom/devexpress/editors/TextEditBase;", "Lcom/devexpress/editors/EditBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualIsCharactersCounterVisible", "", "getActualIsCharactersCounterVisible$dxeditors_release", "()Z", "value", "Lcom/devexpress/editors/DXCharacterCasing;", "characterCasing", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "characterCounterView", "Landroid/widget/TextView;", "charactersCount", "getCharactersCount", "()I", "setCharactersCount", "(I)V", "displayText", "", "getDisplayText", "()Ljava/lang/CharSequence;", "editText", "Lcom/devexpress/editors/DXEditText;", "getEditText", "()Lcom/devexpress/editors/DXEditText;", "format", "getFormat", "setFormat", "(Ljava/lang/CharSequence;)V", "hasValue", "getHasValue", "locales", "Landroid/os/LocaleList;", "imeHintLocales", "getImeHintLocales", "()Landroid/os/LocaleList;", "setImeHintLocales", "(Landroid/os/LocaleList;)V", "internalEditor", "getInternalEditor", "()Landroid/widget/TextView;", "isCharactersCounterVisible", "setCharactersCounterVisible", "(Z)V", "isSpellCheckEnabled", "setSpellCheckEnabled", "limitTextByCharactersCount", "getLimitTextByCharactersCount", "setLimitTextByCharactersCount", "needsRecreateTextStrategy", "Lcom/devexpress/editors/OnTextChangedListener;", "onTextChangedListener", "getOnTextChangedListener", "()Lcom/devexpress/editors/OnTextChangedListener;", "setOnTextChangedListener", "(Lcom/devexpress/editors/OnTextChangedListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/devexpress/editors/SelectionChangedListener;", "selectionChangedListener", "getSelectionChangedListener", "()Lcom/devexpress/editors/SelectionChangedListener;", "setSelectionChangedListener", "(Lcom/devexpress/editors/SelectionChangedListener;)V", "selectionEnd", "getSelectionEnd", "selectionStart", "getSelectionStart", "text", "getText", "setText", "<set-?>", "Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "textStrategy", "getTextStrategy$dxeditors_release", "()Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "changeTextStrategy", "", "clearComposingText", "createLayoutElementsFactory", "Lcom/devexpress/editors/LayoutElementsFactory;", "createTextStrategy", "oldStrategy", "createTextStrategy$dxeditors_release", "doAfterTextChanged", "s", "Landroid/text/Editable;", "doBeforeTextChanged", "start", "count", "after", "doOnTextChanged", "before", "finishInitialization", "needLimitText", "onBeginBatchEdit", "onBottomTextSizeChanged", "unit", "", "onBottomTextTypefaceChanged", "typeface", "Landroid/graphics/Typeface;", "onContainsFocusChange", "onErrorColorChanged", "onHelpTextColorChanged", "onLayout", "changed", "l", "t", "r", "b", "onMeasureCore", "Landroid/util/Size;", "widthMeasureSpec", "heightMeasureSpec", "onTextChanged", "onValueChanged", "requestTextStrategyChange", "selectAll", "setChildrenEnabled", "enabled", "setClearIconClickedListener", "Lcom/devexpress/editors/OnClickHandledListener;", "setInternalEditorEditable", "isEditable", "setSelection", "index", "stop", "setupCharacterCounter", "updateCharacterCounterColors", "updateCharactersCountText", "updateCharactersCounterVisibility", "updateClearImageVisibility", "updateFilters", "updateStrategyText", "updateTextAlignment", "Companion", "EditTextChangedWatcher", "EmptyTextEditBaseGestureDelegate", "TextEditBaseAutofillDelegate", "TextEditBaseGestureDelegate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TextEditBase extends EditBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final TextView characterCounterView;
    private int charactersCount;
    private final DXEditText editText;
    private CharSequence format;
    private boolean isCharactersCounterVisible;
    private boolean isSpellCheckEnabled;
    private boolean limitTextByCharactersCount;
    private boolean needsRecreateTextStrategy;
    private OnTextChangedListener onTextChangedListener;
    private TextStrategy textStrategy;

    /* compiled from: TextEditBase.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/TextEditBase$EmptyTextEditBaseGestureDelegate;", "Lcom/devexpress/editors/GestureDelegate;", "()V", "onDoubleTap", "", "onLongPress", "onSingleTapUp", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EmptyTextEditBaseGestureDelegate implements GestureDelegate {
        @Override // com.devexpress.editors.GestureDelegate
        public boolean onDoubleTap() {
            return false;
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onLongPress() {
            return false;
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onSingleTapUp() {
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextEditBase(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextEditBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    public static final Function1<CharSequence, Unit> createTextChangedCallback(TextEditBase textEditBase) {
        return INSTANCE.createTextChangedCallback(textEditBase);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextEditBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        DXEditText dXEditText = new DXEditText(context, null, 0, 6, null);
        this.editText = dXEditText;
        this.characterCounterView = new AppCompatTextView(context);
        this.textStrategy = new DefaultTextStrategy(dXEditText, INSTANCE.createTextChangedCallback(this));
        this.isSpellCheckEnabled = true;
        this.isCharactersCounterVisible = true;
        dXEditText.setDuplicateParentStateEnabled(true);
        dXEditText.setMinWidth(2);
        setInputType(1);
    }

    public /* synthetic */ TextEditBase(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    protected final DXEditText getEditText() {
        return this.editText;
    }

    @Override // com.devexpress.editors.EditBase
    public TextView getInternalEditor() {
        return this.editText;
    }

    public final TextStrategy getTextStrategy$dxeditors_release() {
        if (this.needsRecreateTextStrategy) {
            this.needsRecreateTextStrategy = false;
            CharSequence text = this.textStrategy.getText();
            String obj = text != null ? text.toString() : null;
            DXCharacterCasing characterCasing = this.textStrategy.getCharacterCasing();
            TextStrategy createTextStrategy$dxeditors_release = createTextStrategy$dxeditors_release(this.textStrategy);
            this.textStrategy = createTextStrategy$dxeditors_release;
            createTextStrategy$dxeditors_release.setText(obj);
            this.textStrategy.setCharacterCasing(characterCasing);
            updateLabelState(getAllowAnimations());
            updateClearImageVisibility();
        }
        return this.textStrategy;
    }

    @Override // com.devexpress.editors.EditBase
    public CharSequence getDisplayText() {
        return getTextStrategy$dxeditors_release().getDisplayText();
    }

    public final CharSequence getFormat() {
        return this.format;
    }

    public final void setFormat(CharSequence charSequence) {
        if (Intrinsics.areEqual(this.format, charSequence)) {
            return;
        }
        this.format = charSequence;
        changeTextStrategy();
    }

    @Override // com.devexpress.editors.EditBase
    protected boolean getHasValue() {
        CharSequence text = getTextStrategy$dxeditors_release().getText();
        return !(text == null || text.length() == 0);
    }

    public CharSequence getText() {
        return getTextStrategy$dxeditors_release().getText();
    }

    public void setText(CharSequence charSequence) {
        if (needLimitText()) {
            CharSequence text = getText();
            if ((text != null ? text.length() : 0) > this.charactersCount) {
                return;
            }
        }
        getTextStrategy$dxeditors_release().setText(charSequence);
        onValueChanged();
        updateTextAlignment();
    }

    public final OnTextChangedListener getOnTextChangedListener() {
        return this.onTextChangedListener;
    }

    public final void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        if (Intrinsics.areEqual(this.onTextChangedListener, onTextChangedListener)) {
            return;
        }
        this.onTextChangedListener = onTextChangedListener;
    }

    public final SelectionChangedListener getSelectionChangedListener() {
        return this.editText.getSelectionChangedListener();
    }

    public final void setSelectionChangedListener(SelectionChangedListener selectionChangedListener) {
        this.editText.setSelectionChangedListener(selectionChangedListener);
    }

    /* renamed from: isSpellCheckEnabled, reason: from getter */
    public final boolean getIsSpellCheckEnabled() {
        return this.isSpellCheckEnabled;
    }

    public final void setSpellCheckEnabled(boolean z) {
        int inputType;
        if (this.isSpellCheckEnabled == z) {
            return;
        }
        this.isSpellCheckEnabled = z;
        DXEditText dXEditText = this.editText;
        dXEditText.setInputType(z ? dXEditText.getInputType() & (-524289) : dXEditText.getInputType() | 524288);
        if (z) {
            inputType = getInputType() & (-524289);
        } else {
            inputType = getInputType() | 524288;
        }
        setInputType(inputType);
    }

    public final int getCharactersCount() {
        return this.charactersCount;
    }

    public final void setCharactersCount(int i) {
        if (this.charactersCount == i) {
            return;
        }
        this.charactersCount = i;
        updateFilters();
        updateCharactersCountText();
        updateCharactersCounterVisibility();
        requestLayout();
    }

    /* renamed from: isCharactersCounterVisible, reason: from getter */
    public final boolean getIsCharactersCounterVisible() {
        return this.isCharactersCounterVisible;
    }

    public final void setCharactersCounterVisible(boolean z) {
        if (this.isCharactersCounterVisible == z) {
            return;
        }
        this.isCharactersCounterVisible = z;
        updateCharactersCounterVisibility();
    }

    public final boolean getActualIsCharactersCounterVisible$dxeditors_release() {
        return this.isCharactersCounterVisible && this.charactersCount > 0;
    }

    @Override // com.devexpress.editors.EditBase
    public DXCharacterCasing getCharacterCasing() {
        return getTextStrategy$dxeditors_release().getCharacterCasing();
    }

    @Override // com.devexpress.editors.EditBase
    public void setCharacterCasing(DXCharacterCasing value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getTextStrategy$dxeditors_release().setCharacterCasing(value);
        onEditorInputTypeChange();
    }

    public final boolean getLimitTextByCharactersCount() {
        return this.limitTextByCharactersCount;
    }

    public final void setLimitTextByCharactersCount(boolean z) {
        if (this.limitTextByCharactersCount == z) {
            return;
        }
        this.limitTextByCharactersCount = z;
        updateFilters();
    }

    public final int getSelectionStart() {
        return this.editText.getSelectionStart();
    }

    public final int getSelectionEnd() {
        return this.editText.getSelectionEnd();
    }

    public final LocaleList getImeHintLocales() {
        return this.editText.getImeHintLocales();
    }

    public final void setImeHintLocales(LocaleList localeList) {
        this.editText.setImeHintLocales(localeList);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onHelpTextColorChanged() {
        super.onHelpTextColorChanged();
        updateCharacterCounterColors();
    }

    @Override // com.devexpress.editors.EditBase
    protected void onErrorColorChanged() {
        super.onErrorColorChanged();
        updateCharacterCounterColors();
    }

    private final void updateCharacterCounterColors() {
        this.characterCounterView.setTextColor(new ColorStateList(new int[][]{Constants.DISABLED_STATE, Constants.ERROR_STATE, Constants.DEFAULT_STATE}, new int[]{getInternalStyle().getDisabledHelpTextColor(), getInternalStyle().getErrorColor(), getInternalStyle().getHelpTextColor()}));
    }

    private final void updateTextAlignment() {
        if (isFocused() || getInternalEditor().isFocused()) {
            return;
        }
        this.editText.applyTextAlignment();
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateStrategyText() {
        getTextStrategy$dxeditors_release().updateEditorText();
    }

    @Override // com.devexpress.editors.EditBase
    protected void finishInitialization(AttributeSet attrs, int defStyleAttr) {
        super.finishInitialization(attrs, defStyleAttr);
        addView(this.characterCounterView);
        this.editText.setTextChangedWatcher(new EditTextChangedWatcher(this));
        updateEditorTextSettings();
        setupCharacterCounter();
        this.characterCounterView.setDuplicateParentStateEnabled(true);
        this.characterCounterView.setTextSize(0, getBottomTextSize());
        this.characterCounterView.setGravity(5);
        this.editText.setGestureDelegate(new TextEditBaseGestureDelegate(this));
        if (Build.VERSION.SDK_INT >= 26) {
            this.editText.setAutofillDelegate(new TextEditBaseAutofillDelegate(this));
        }
    }

    public final void setSelection(int start, int stop) {
        this.editText.setDelayedSelection(start, stop);
    }

    public final void setSelection(int index) {
        setSelection(index, index);
    }

    public final void selectAll() {
        this.editText.selectAll();
    }

    public final void clearComposingText() {
        this.editText.clearComposingText();
    }

    @Override // com.devexpress.editors.EditBase, com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int widthMeasureSpec, int heightMeasureSpec) {
        Size onMeasureCore = super.onMeasureCore(widthMeasureSpec, heightMeasureSpec);
        this.characterCounterView.forceLayout();
        this.characterCounterView.measure(View.MeasureSpec.makeMeasureSpec(getContentLayout().getCharCounterAreaFrame().getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getContentLayout().getCharCounterAreaFrame().getHeight(), BasicMeasure.EXACTLY));
        return onMeasureCore;
    }

    @Override // com.devexpress.editors.EditBase, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.characterCounterView.layout(getContentLayout().getCharCounterAreaFrame().getLeft(), getContentLayout().getCharCounterAreaFrame().getTop(), getContentLayout().getCharCounterAreaFrame().right(), getContentLayout().getCharCounterAreaFrame().bottom());
    }

    private final void setupCharacterCounter() {
        this.characterCounterView.setSingleLine();
        this.characterCounterView.setVisibility(getReserveBottomTextLine() ? 4 : 8);
        this.characterCounterView.setGravity(80);
    }

    private final void updateCharactersCounterVisibility() {
        this.characterCounterView.setVisibility(getActualIsCharactersCounterVisible$dxeditors_release() ? 0 : 8);
    }

    @Override // com.devexpress.editors.EditBase
    protected void updateClearImageVisibility() {
        updateIconVisibility(this.clearImage, getClearIconVisibility() == DXIconVisibility.Always || (!getIsReadOnly() && isEnabled() && getClearIconVisibility() == DXIconVisibility.Auto && getTextStrategy$dxeditors_release().getCanBeCleared()));
        updateTextAlignment();
    }

    @Override // com.devexpress.editors.EditBase
    public void setClearIconClickedListener(OnClickHandledListener value) {
        if (value != null) {
            value.setClickListener(new View.OnClickListener() { // from class: com.devexpress.editors.TextEditBase$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TextEditBase.setClearIconClickedListener$lambda$0(TextEditBase.this, view);
                }
            });
        }
        this.clearImage.setOnClickListener(value != null ? value : new View.OnClickListener() { // from class: com.devexpress.editors.TextEditBase$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextEditBase.setClearIconClickedListener$lambda$1(TextEditBase.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$0(TextEditBase this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClearIconClickedListener$lambda$1(TextEditBase this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setText("");
    }

    @Override // com.devexpress.editors.EditBase
    protected void setInternalEditorEditable(boolean isEditable) {
        super.setInternalEditorEditable(isEditable);
        this.editText.setKeyInputEnabled(isEditable);
    }

    private final void updateFilters() {
        if (needLimitText()) {
            this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.charactersCount)});
            CharSequence text = getTextStrategy$dxeditors_release().getText();
            if (text == null || text.length() <= this.charactersCount) {
                return;
            }
            int selectionStart = this.editText.getSelectionStart();
            setText(text.subSequence(0, this.charactersCount));
            if (selectionStart > text.length()) {
                selectionStart = text.length();
            }
            this.editText.setSelection(selectionStart);
            updateCharactersCountText();
            return;
        }
        this.editText.setFilters(new InputFilter[0]);
    }

    private final void updateCharactersCountText() {
        if (this.charactersCount > 0) {
            CharSequence text = getText();
            this.characterCounterView.setText((text != null ? text.length() : 0) + " / " + this.charactersCount);
        }
    }

    private final boolean needLimitText() {
        return this.limitTextByCharactersCount && this.charactersCount > 0;
    }

    protected final void doBeforeTextChanged(CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (getLocker().isLocked()) {
            return;
        }
        getTextStrategy$dxeditors_release().beforeTextChanged(s, start, count, after);
    }

    protected void doOnTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (getLocker().isLocked()) {
            return;
        }
        getTextStrategy$dxeditors_release().onTextChanged(s, start, before, count);
        updateClearImageVisibility();
    }

    protected final void doAfterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (getLocker().isLocked()) {
            return;
        }
        getTextStrategy$dxeditors_release().afterTextChanged(s);
    }

    protected final void onBeginBatchEdit() {
        getTextStrategy$dxeditors_release().setInnerSelectionIndicies(this.editText.getSelectionStart(), this.editText.getSelectionEnd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTextChanged(CharSequence s) {
        updateCharactersCountText();
        OnTextChangedListener onTextChangedListener = this.onTextChangedListener;
        if (onTextChangedListener != null) {
            onTextChangedListener.onTextChanged(this, s);
        }
    }

    @Override // com.devexpress.editors.EditBase
    protected void setChildrenEnabled(boolean enabled) {
        super.setChildrenEnabled(enabled);
        this.characterCounterView.setEnabled(enabled);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onBottomTextTypefaceChanged(Typeface typeface) {
        super.onBottomTextTypefaceChanged(typeface);
        this.characterCounterView.setTypeface(typeface);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onBottomTextSizeChanged(int unit, float value) {
        super.onBottomTextSizeChanged(unit, value);
        this.characterCounterView.setTextSize(unit, value);
    }

    @Override // com.devexpress.editors.EditBase
    protected void onContainsFocusChange() {
        super.onContainsFocusChange();
        if (!getIsReadOnly()) {
            getTextStrategy$dxeditors_release().onFocusChanged(getContainsFocus());
        }
        if (getContainsFocus()) {
            return;
        }
        this.editText.applyTextAlignment();
    }

    @Override // com.devexpress.editors.EditBase
    protected void onValueChanged() {
        updateCharactersCountText();
        super.onValueChanged();
    }

    @Override // com.devexpress.editors.EditBase
    protected LayoutElementsFactory createLayoutElementsFactory() {
        return new TextEditLayoutElementsFactory(this.editText, this.labelTextView, this.startImage, this.endImage, this.errorImage, this.errorTextView, this.helpTextView, this.suffixView, this.prefixView, this.clearImage, this.characterCounterView);
    }

    protected final void requestTextStrategyChange() {
        this.needsRecreateTextStrategy = true;
    }

    protected final void changeTextStrategy() {
        requestTextStrategyChange();
        getTextStrategy$dxeditors_release().updateEditorText();
    }

    public TextStrategy createTextStrategy$dxeditors_release(TextStrategy oldStrategy) {
        return new DefaultTextStrategy(this.editText, INSTANCE.createTextChangedCallback(this));
    }

    /* compiled from: TextEditBase.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0016"}, d2 = {"Lcom/devexpress/editors/TextEditBase$EditTextChangedWatcher;", "Lcom/devexpress/editors/WeakHolder;", "Lcom/devexpress/editors/TextEditBase;", "Lcom/devexpress/editors/DXEditTextChangedWatcher;", "edit", "(Lcom/devexpress/editors/TextEditBase;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onBeginBatchEdit", "onSelectionChanged", "selStart", "selEnd", "onTextChanged", "before", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class EditTextChangedWatcher extends WeakHolder<TextEditBase> implements DXEditTextChangedWatcher {
        public EditTextChangedWatcher(TextEditBase textEditBase) {
            super(textEditBase);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s, "s");
            TextEditBase edit = getEdit();
            if (edit != null) {
                edit.doBeforeTextChanged(s, start, count, after);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s, "s");
            TextEditBase edit = getEdit();
            if (edit != null) {
                edit.doOnTextChanged(s, start, before, count);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Intrinsics.checkNotNullParameter(s, "s");
            TextEditBase edit = getEdit();
            if (edit != null) {
                edit.doAfterTextChanged(s);
            }
        }

        @Override // com.devexpress.editors.DXEditTextChangedWatcher
        public void onBeginBatchEdit() {
            TextEditBase edit = getEdit();
            if (edit != null) {
                edit.onBeginBatchEdit();
            }
        }

        @Override // com.devexpress.editors.DXEditTextChangedWatcher
        public void onSelectionChanged(int selStart, int selEnd) {
            SelectionChangedListener selectionChangedListener;
            TextEditBase edit = getEdit();
            if (edit == null || (selectionChangedListener = edit.getSelectionChangedListener()) == null) {
                return;
            }
            selectionChangedListener.onSelectionChanged(selStart, selEnd);
        }
    }

    /* compiled from: TextEditBase.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/TextEditBase$TextEditBaseAutofillDelegate;", "Lcom/devexpress/editors/AutofillDelegate;", "edit", "Lcom/devexpress/editors/TextEditBase;", "(Lcom/devexpress/editors/TextEditBase;)V", "autofill", "", "value", "Landroid/view/autofill/AutofillValue;", "provideAutofillOptions", "", "", "()[Ljava/lang/CharSequence;", "provideAutofillType", "", "provideAutofillValue", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TextEditBaseAutofillDelegate implements AutofillDelegate {
        private final TextEditBase edit;

        @Override // com.devexpress.editors.AutofillDelegate
        public CharSequence[] provideAutofillOptions() {
            return new CharSequence[0];
        }

        public TextEditBaseAutofillDelegate(TextEditBase edit) {
            Intrinsics.checkNotNullParameter(edit, "edit");
            this.edit = edit;
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public int provideAutofillType() {
            return (!this.edit.isEnabled() || this.edit.getIsReadOnly()) ? 0 : 1;
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public AutofillValue provideAutofillValue() {
            return AutofillValue.forText(this.edit.getText());
        }

        @Override // com.devexpress.editors.AutofillDelegate
        public void autofill(AutofillValue value) {
            if (value != null) {
                this.edit.setText(value.getTextValue());
            }
        }
    }

    /* compiled from: TextEditBase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/TextEditBase$TextEditBaseGestureDelegate;", "Lcom/devexpress/editors/GestureDelegate;", "edit", "Lcom/devexpress/editors/TextEditBase;", "(Lcom/devexpress/editors/TextEditBase;)V", "onDoubleTap", "", "onLongPress", "onSingleTapUp", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TextEditBaseGestureDelegate implements GestureDelegate {
        private final TextEditBase edit;

        public TextEditBaseGestureDelegate(TextEditBase edit) {
            Intrinsics.checkNotNullParameter(edit, "edit");
            this.edit = edit;
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onSingleTapUp() {
            return this.edit.onSingleTapUp();
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onDoubleTap() {
            return this.edit.onDoubleTap();
        }

        @Override // com.devexpress.editors.GestureDelegate
        public boolean onLongPress() {
            return this.edit.onLongPress();
        }
    }

    /* compiled from: TextEditBase.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\bX\u008a\u0084\u0002"}, d2 = {"Lcom/devexpress/editors/TextEditBase$Companion;", "", "()V", "createTextChangedCallback", "Lkotlin/Function1;", "", "", "textEdit", "Lcom/devexpress/editors/TextEditBase;", "dxeditors_release", "weakEdit"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(Companion.class, "weakEdit", "<v#0>", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextEditBase createTextChangedCallback$lambda$0(WeakProperty<TextEditBase> weakProperty) {
            return weakProperty.getValue(null, $$delegatedProperties[0]);
        }

        @JvmStatic
        public final Function1<CharSequence, Unit> createTextChangedCallback(TextEditBase textEdit) {
            final WeakProperty weak = WeakPropertyKt.weak(textEdit);
            return new Function1<CharSequence, Unit>() { // from class: com.devexpress.editors.TextEditBase$Companion$createTextChangedCallback$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                    invoke2(charSequence);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CharSequence charSequence) {
                    TextEditBase createTextChangedCallback$lambda$0;
                    createTextChangedCallback$lambda$0 = TextEditBase.Companion.createTextChangedCallback$lambda$0(weak);
                    if (createTextChangedCallback$lambda$0 != null) {
                        createTextChangedCallback$lambda$0.onTextChanged(charSequence);
                    }
                }
            };
        }
    }
}
