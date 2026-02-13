package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.DXCharacterCasing;
import com.devexpress.editors.DXLocker;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ProcessorTextStrategy.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b(\b\u0016\u0018\u0000 F2\u00020\u0001:\u0001FB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u001aH\u0002J\u0018\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\fH\u0004J(\u0010;\u001a\u00020\t2\u0006\u00107\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u001fH\u0016J\u0010\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\fH\u0016J(\u0010A\u001a\u00020\t2\u0006\u00107\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u001fH\u0016J\b\u0010C\u001a\u00020\tH\u0004J\u0018\u0010D\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010E\u001a\u00020\tH\u0016R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u000eR(\u0010*\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010-R*\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006G"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/ProcessorTextStrategy;", "Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "textProcessor", "Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "editor", "Landroid/widget/EditText;", "textChangedCallback", "Lkotlin/Function1;", "", "", "(Lcom/devexpress/editors/utils/textstrategies/TextProcessor;Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;)V", "canBeCleared", "", "getCanBeCleared", "()Z", "value", "Lcom/devexpress/editors/DXCharacterCasing;", "characterCasing", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "displayText", "getDisplayText", "()Ljava/lang/CharSequence;", "displayTextValue", "Landroid/text/Editable;", "getEditor", "()Landroid/widget/EditText;", "locker", "Lcom/devexpress/editors/DXLocker;", "", "selectionEnd", "getSelectionEnd", "()I", "setSelectionEnd", "(I)V", "selectionStart", "getSelectionStart", "setSelectionStart", "shouldReapplyEditorText", "getShouldReapplyEditorText", "text", "getText", "setText", "(Ljava/lang/CharSequence;)V", "getTextChangedCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "getTextProcessor", "()Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "setTextProcessor", "(Lcom/devexpress/editors/utils/textstrategies/TextProcessor;)V", "afterTextChanged", "s", "applyActualText", TypedValues.AttributesType.S_TARGET, "onFocusChange", "beforeTextChanged", "start", "count", "after", "onFocusChanged", "hasFocus", "onTextChanged", "before", "raiseTextChanged", "setInnerSelectionIndicies", "updateEditorText", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ProcessorTextStrategy implements TextStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final InputFilter[] emptyFilters = new InputFilter[0];
    private final Editable displayTextValue;
    private final EditText editor;
    private final DXLocker locker;
    private Function1<? super CharSequence, Unit> textChangedCallback;
    private TextProcessor textProcessor;

    /* compiled from: ProcessorTextStrategy.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/ProcessorTextStrategy$Companion;", "", "()V", "emptyFilters", "", "Landroid/text/InputFilter;", "getEmptyFilters", "()[Landroid/text/InputFilter;", "[Landroid/text/InputFilter;", "applyCharacterCasing", "", "value", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "startSymbolIndex", "", "newSymbolsCount", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: ProcessorTextStrategy.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DXCharacterCasing.values().length];
                try {
                    iArr[DXCharacterCasing.Upper.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DXCharacterCasing.Lower.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InputFilter[] getEmptyFilters() {
            return ProcessorTextStrategy.emptyFilters;
        }

        public final CharSequence applyCharacterCasing(CharSequence value, DXCharacterCasing characterCasing, int startSymbolIndex, int newSymbolsCount) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(characterCasing, "characterCasing");
            int i = WhenMappings.$EnumSwitchMapping$0[characterCasing.ordinal()];
            if (i == 1) {
                int i2 = newSymbolsCount + startSymbolIndex;
                String obj = value.subSequence(startSymbolIndex, i2).toString();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = obj.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                return StringsKt.replaceRange(value, startSymbolIndex, i2, upperCase);
            }
            if (i != 2) {
                return value;
            }
            int i3 = newSymbolsCount + startSymbolIndex;
            String obj2 = value.subSequence(startSymbolIndex, i3).toString();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase = obj2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return StringsKt.replaceRange(value, startSymbolIndex, i3, lowerCase);
        }
    }

    public ProcessorTextStrategy(TextProcessor textProcessor, EditText editor, Function1<? super CharSequence, Unit> function1) {
        Intrinsics.checkNotNullParameter(textProcessor, "textProcessor");
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.textProcessor = textProcessor;
        this.editor = editor;
        this.textChangedCallback = function1;
        this.locker = new DXLocker();
        this.displayTextValue = new SpannableStringBuilder();
    }

    protected final EditText getEditor() {
        return this.editor;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public Function1<CharSequence, Unit> getTextChangedCallback() {
        return this.textChangedCallback;
    }

    public final TextProcessor getTextProcessor() {
        return this.textProcessor;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void setTextChangedCallback(Function1<? super CharSequence, Unit> function1) {
        this.textChangedCallback = function1;
    }

    public final void setTextProcessor(TextProcessor textProcessor) {
        Intrinsics.checkNotNullParameter(textProcessor, "<set-?>");
        this.textProcessor = textProcessor;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public CharSequence getText() {
        return this.textProcessor.getTextInternal();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void setText(CharSequence charSequence) {
        this.textProcessor.setSelectionStart(this.editor.getSelectionStart());
        this.textProcessor.setSelectionEnd(this.editor.getSelectionEnd());
        if (this.textProcessor.setText(charSequence)) {
            Editable text = this.editor.getText();
            Intrinsics.checkNotNull(text);
            applyActualText(text);
            raiseTextChanged();
        }
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public CharSequence getDisplayText() {
        this.textProcessor.applyDisplayText(this.displayTextValue);
        return this.displayTextValue;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public boolean getCanBeCleared() {
        CharSequence text = getText();
        return !(text == null || text.length() == 0);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public DXCharacterCasing getCharacterCasing() {
        return this.textProcessor.getCharacterCasing();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void setCharacterCasing(DXCharacterCasing value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.textProcessor.setCharacterCasing(value);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public boolean getShouldReapplyEditorText() {
        return this.textProcessor.getShouldReplaceEditorText();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public int getSelectionStart() {
        return this.textProcessor.getSelectionStart();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void setSelectionStart(int i) {
        this.textProcessor.setSelectionStart(i);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public int getSelectionEnd() {
        return this.textProcessor.getSelectionEnd();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void setSelectionEnd(int i) {
        this.textProcessor.setSelectionEnd(i);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void updateEditorText() {
        Editable text = this.editor.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        applyActualText(text);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void onFocusChanged(boolean hasFocus) {
        this.textProcessor.setHasFocus(hasFocus);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (this.locker.isLocked()) {
            return;
        }
        this.textProcessor.beforeTextChanged(s, start, count, after);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (this.locker.isLocked()) {
            return;
        }
        this.textProcessor.onTextChanged(s, start, before, count);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        DXLocker dXLocker = this.locker;
        if (dXLocker.isLocked()) {
            return;
        }
        try {
            dXLocker.lock();
            if (this.textProcessor.getIsViewUpdateRequired()) {
                updateEditorText();
            }
            if (this.textProcessor.afterTextChanged(s)) {
                raiseTextChanged();
            }
        } finally {
            dXLocker.unlock();
        }
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextStrategy
    public void setInnerSelectionIndicies(int selectionStart, int selectionEnd) {
        setSelectionStart(selectionStart);
        setSelectionEnd(selectionEnd);
    }

    protected final void applyActualText(Editable target, boolean onFocusChange) {
        boolean z;
        Intrinsics.checkNotNullParameter(target, "target");
        DXLocker dXLocker = this.locker;
        try {
            dXLocker.lock();
            InputFilter[] filters = target.getFilters();
            target.setFilters(emptyFilters);
            TextProcessor textProcessor = this.textProcessor;
            CharSequence hint = this.editor.getHint();
            if (hint != null && hint.length() != 0) {
                z = true;
                textProcessor.setHasPlaceholder(z);
                this.textProcessor.applyDisplayText(target);
                target.setFilters(filters);
                if (this.textProcessor.getHasFocus() && !onFocusChange) {
                    Selection.setSelection(target, this.textProcessor.getSelectionStart(), this.textProcessor.getSelectionEnd());
                }
            }
            z = false;
            textProcessor.setHasPlaceholder(z);
            this.textProcessor.applyDisplayText(target);
            target.setFilters(filters);
            if (this.textProcessor.getHasFocus()) {
                Selection.setSelection(target, this.textProcessor.getSelectionStart(), this.textProcessor.getSelectionEnd());
            }
        } finally {
            dXLocker.unlock();
        }
    }

    protected final void raiseTextChanged() {
        Function1<CharSequence, Unit> textChangedCallback = getTextChangedCallback();
        if (textChangedCallback != null) {
            textChangedCallback.invoke(this.textProcessor.getTextInternal());
        }
    }

    private final void applyActualText(Editable target) {
        applyActualText(target, false);
    }
}
