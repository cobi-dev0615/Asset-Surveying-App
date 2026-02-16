package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import com.devexpress.editors.DXCharacterCasing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: TextStrategy.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H&J(\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H&J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u0003H&J(\u0010/\u001a\u00020!2\u0006\u0010'\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H&J\u0018\u00101\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u00102\u001a\u00020!H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0012\u0010\u0019\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\rX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020!\u0018\u00010 X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00063"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/TextStrategy;", "", "canBeCleared", "", "getCanBeCleared", "()Z", "characterCasing", "Lcom/devexpress/editors/DXCharacterCasing;", "getCharacterCasing", "()Lcom/devexpress/editors/DXCharacterCasing;", "setCharacterCasing", "(Lcom/devexpress/editors/DXCharacterCasing;)V", "displayText", "", "getDisplayText", "()Ljava/lang/CharSequence;", "selectionEnd", "", "getSelectionEnd", "()I", "setSelectionEnd", "(I)V", "selectionStart", "getSelectionStart", "setSelectionStart", "shouldReapplyEditorText", "getShouldReapplyEditorText", "text", "getText", "setText", "(Ljava/lang/CharSequence;)V", "textChangedCallback", "Lkotlin/Function1;", "", "getTextChangedCallback", "()Lkotlin/jvm/functions/Function1;", "setTextChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "afterTextChanged", "s", "Landroid/text/Editable;", "beforeTextChanged", "start", "count", "after", "onFocusChanged", "hasFocus", "onTextChanged", "before", "setInnerSelectionIndicies", "updateEditorText", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TextStrategy {
    void afterTextChanged(Editable s);

    void beforeTextChanged(CharSequence s, int start, int count, int after);

    boolean getCanBeCleared();

    DXCharacterCasing getCharacterCasing();

    CharSequence getDisplayText();

    int getSelectionEnd();

    int getSelectionStart();

    boolean getShouldReapplyEditorText();

    CharSequence getText();

    Function1<CharSequence, Unit> getTextChangedCallback();

    void onFocusChanged(boolean hasFocus);

    void onTextChanged(CharSequence s, int start, int before, int count);

    void setCharacterCasing(DXCharacterCasing dXCharacterCasing);

    void setInnerSelectionIndicies(int selectionStart, int selectionEnd);

    void setSelectionEnd(int i);

    void setSelectionStart(int i);

    void setText(CharSequence charSequence);

    void setTextChangedCallback(Function1<? super CharSequence, Unit> function1);

    void updateEditorText();
}
