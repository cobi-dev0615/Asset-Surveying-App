package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.DXCharacterCasing;
import com.devexpress.editors.utils.textstrategies.DefaultTextProcessor;
import kotlin.Metadata;

/* compiled from: TextProcessor.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020$H&J(\u0010(\u001a\u00020&2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0013H&J0\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H&J(\u00101\u001a\u00020&2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H&J\u0012\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u001fH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0012\u0010\u0011\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0018\u0010\u0012\u001a\u00020\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0018\u0010\u001b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/TextProcessor;", "", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "hasFocus", "", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasPlaceholder", "getHasPlaceholder", "setHasPlaceholder", "isViewUpdateRequired", "selectionEnd", "", "getSelectionEnd", "()I", "setSelectionEnd", "(I)V", "selectionStart", "getSelectionStart", "setSelectionStart", "shouldReplaceEditorText", "getShouldReplaceEditorText", "setShouldReplaceEditorText", "text", "", "getText", "()Ljava/lang/CharSequence;", "afterTextChanged", "s", "Landroid/text/Editable;", "applyDisplayText", "", TypedValues.AttributesType.S_TARGET, "beforeTextChanged", "start", "count", "after", "getActualStartAndCount", "Lcom/devexpress/editors/utils/textstrategies/DefaultTextProcessor$ActualStartAndCount;", "currentValue", "newValue", "before", "onTextChanged", "setText", "value", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TextProcessor {
    boolean afterTextChanged(Editable s);

    void applyDisplayText(Editable target);

    void beforeTextChanged(CharSequence s, int start, int count, int after);

    DefaultTextProcessor.ActualStartAndCount getActualStartAndCount(CharSequence currentValue, CharSequence newValue, int start, int before, int count);

    DXCharacterCasing getCharacterCasing();

    boolean getHasFocus();

    boolean getHasPlaceholder();

    int getSelectionEnd();

    int getSelectionStart();

    boolean getShouldReplaceEditorText();

    /* renamed from: getText */
    CharSequence getTextInternal();

    /* renamed from: isViewUpdateRequired */
    boolean getIsViewUpdateRequired();

    void onTextChanged(CharSequence s, int start, int before, int count);

    void setCharacterCasing(DXCharacterCasing dXCharacterCasing);

    void setHasFocus(boolean z);

    void setHasPlaceholder(boolean z);

    void setSelectionEnd(int i);

    void setSelectionStart(int i);

    void setShouldReplaceEditorText(boolean z);

    boolean setText(CharSequence value);
}
