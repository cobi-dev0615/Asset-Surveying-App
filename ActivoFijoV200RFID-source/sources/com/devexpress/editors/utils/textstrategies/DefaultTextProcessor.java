package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.DXCharacterCasing;
import com.devexpress.editors.model.MathUtilsKt;
import com.devexpress.editors.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultTextProcessor.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J*\u0010*\u001a\u00020\"2\n\u0010+\u001a\u00060,j\u0002`-2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020)H\u0016J(\u00104\u001a\u0002022\u0006\u0010(\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0016H\u0016J0\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0016J\u0016\u0010:\u001a\u00020\u00162\u0006\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\"J(\u0010;\u001a\u0002022\u0006\u0010(\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0016H\u0016J\u0012\u0010<\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/DefaultTextProcessor;", "Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "()V", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "hasFocus", "", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasPlaceholder", "getHasPlaceholder", "setHasPlaceholder", "isViewUpdateRequired", "rangeWasSelected", "getRangeWasSelected", "selectionEnd", "", "getSelectionEnd", "()I", "setSelectionEnd", "(I)V", "selectionStart", "getSelectionStart", "setSelectionStart", "shouldReplaceEditorText", "getShouldReplaceEditorText", "setShouldReplaceEditorText", "text", "", "getText", "()Ljava/lang/CharSequence;", "textInternal", "textInternalWasChanged", "afterTextChanged", "s", "Landroid/text/Editable;", "applyCharacterCasing", "value", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "start", "before", "count", "applyDisplayText", "", TypedValues.AttributesType.S_TARGET, "beforeTextChanged", "after", "getActualStartAndCount", "Lcom/devexpress/editors/utils/textstrategies/DefaultTextProcessor$ActualStartAndCount;", "currentValue", "newValue", "getStartIndexOfChange", "onTextChanged", "setText", "ActualStartAndCount", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DefaultTextProcessor implements TextProcessor {
    private boolean hasFocus;
    private boolean hasPlaceholder;
    private final boolean isViewUpdateRequired;
    private int selectionEnd;
    private int selectionStart;
    private boolean shouldReplaceEditorText;
    private boolean textInternalWasChanged;
    private CharSequence textInternal = "";
    private DXCharacterCasing characterCasing = DXCharacterCasing.Normal;

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    private final boolean getRangeWasSelected() {
        return getSelectionEnd() != getSelectionStart();
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    /* renamed from: isViewUpdateRequired, reason: from getter */
    public boolean getIsViewUpdateRequired() {
        return this.isViewUpdateRequired;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    /* renamed from: getText, reason: from getter */
    public CharSequence getTextInternal() {
        return this.textInternal;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean getHasFocus() {
        return this.hasFocus;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setHasFocus(boolean z) {
        this.hasFocus = z;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean getHasPlaceholder() {
        return this.hasPlaceholder;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setHasPlaceholder(boolean z) {
        this.hasPlaceholder = z;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public int getSelectionStart() {
        return this.selectionStart;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setSelectionStart(int i) {
        this.selectionStart = i;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setSelectionEnd(int i) {
        this.selectionEnd = i;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public DXCharacterCasing getCharacterCasing() {
        return this.characterCasing;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setCharacterCasing(DXCharacterCasing dXCharacterCasing) {
        Intrinsics.checkNotNullParameter(dXCharacterCasing, "<set-?>");
        this.characterCasing = dXCharacterCasing;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean getShouldReplaceEditorText() {
        return this.shouldReplaceEditorText;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void setShouldReplaceEditorText(boolean z) {
        this.shouldReplaceEditorText = z;
    }

    public final int getStartIndexOfChange(CharSequence currentValue, CharSequence newValue) {
        Intrinsics.checkNotNullParameter(currentValue, "currentValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int min = Math.min(newValue.length(), currentValue.length());
        int i = min - 1;
        if (i >= 0) {
            int i2 = 0;
            while (newValue.charAt(i2) == currentValue.charAt(i2)) {
                if (i2 != i) {
                    i2++;
                }
            }
            return i2;
        }
        return min;
    }

    /* compiled from: DefaultTextProcessor.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/DefaultTextProcessor$ActualStartAndCount;", "", "startSymbolIndex", "", "newSymbolsCount", "(II)V", "getNewSymbolsCount", "()I", "getStartSymbolIndex", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ActualStartAndCount {
        private final int newSymbolsCount;
        private final int startSymbolIndex;

        public static /* synthetic */ ActualStartAndCount copy$default(ActualStartAndCount actualStartAndCount, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = actualStartAndCount.startSymbolIndex;
            }
            if ((i3 & 2) != 0) {
                i2 = actualStartAndCount.newSymbolsCount;
            }
            return actualStartAndCount.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartSymbolIndex() {
            return this.startSymbolIndex;
        }

        /* renamed from: component2, reason: from getter */
        public final int getNewSymbolsCount() {
            return this.newSymbolsCount;
        }

        public final ActualStartAndCount copy(int startSymbolIndex, int newSymbolsCount) {
            return new ActualStartAndCount(startSymbolIndex, newSymbolsCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActualStartAndCount)) {
                return false;
            }
            ActualStartAndCount actualStartAndCount = (ActualStartAndCount) other;
            return this.startSymbolIndex == actualStartAndCount.startSymbolIndex && this.newSymbolsCount == actualStartAndCount.newSymbolsCount;
        }

        public int hashCode() {
            return (this.startSymbolIndex * 31) + this.newSymbolsCount;
        }

        public String toString() {
            return "ActualStartAndCount(startSymbolIndex=" + this.startSymbolIndex + ", newSymbolsCount=" + this.newSymbolsCount + ')';
        }

        public ActualStartAndCount(int i, int i2) {
            this.startSymbolIndex = i;
            this.newSymbolsCount = i2;
        }

        public final int getNewSymbolsCount() {
            return this.newSymbolsCount;
        }

        public final int getStartSymbolIndex() {
            return this.startSymbolIndex;
        }
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public ActualStartAndCount getActualStartAndCount(CharSequence currentValue, CharSequence newValue, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(currentValue, "currentValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (!getRangeWasSelected()) {
            int min = Math.min(getStartIndexOfChange(currentValue, newValue), getSelectionStart());
            count += start - min;
            start = min;
        }
        return new ActualStartAndCount(start, Math.max(0, count));
    }

    public final CharSequence applyCharacterCasing(StringBuilder value, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sb = value;
        ActualStartAndCount actualStartAndCount = getActualStartAndCount(this.textInternal, sb, start, before, count);
        if (actualStartAndCount.getNewSymbolsCount() <= 0) {
            return sb;
        }
        CharSequence applyCharacterCasing = ProcessorTextStrategy.INSTANCE.applyCharacterCasing(sb, getCharacterCasing(), actualStartAndCount.getStartSymbolIndex(), actualStartAndCount.getNewSymbolsCount());
        String sb2 = value.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        if (!sb2.contentEquals(applyCharacterCasing)) {
            setShouldReplaceEditorText(true);
        }
        setSelectionStart(actualStartAndCount.getStartSymbolIndex() + actualStartAndCount.getNewSymbolsCount());
        setSelectionEnd(getSelectionStart());
        return applyCharacterCasing;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean setText(CharSequence value) {
        if (TextUtils.equals(this.textInternal, value)) {
            return false;
        }
        if (value == null || value.length() == 0) {
            this.textInternal = "";
        } else {
            this.textInternal = UtilsKt.copy(value);
        }
        setSelectionStart(MathUtilsKt.clamp(getSelectionStart(), 0, this.textInternal.length()));
        setSelectionEnd(MathUtilsKt.clamp(getSelectionEnd(), 0, this.textInternal.length()));
        return true;
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void applyDisplayText(Editable target) {
        Intrinsics.checkNotNullParameter(target, "target");
        target.replace(0, target.length(), getTextInternal());
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (getCharacterCasing() != DXCharacterCasing.Normal) {
            s = applyCharacterCasing(new StringBuilder(s), start, before, count);
        }
        this.textInternalWasChanged = setText(s);
    }

    @Override // com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (getShouldReplaceEditorText()) {
            setShouldReplaceEditorText(false);
            s.replace(0, s.length(), this.textInternal);
        }
        return this.textInternalWasChanged;
    }
}
