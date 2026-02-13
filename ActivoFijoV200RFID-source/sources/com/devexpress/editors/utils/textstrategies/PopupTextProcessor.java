package com.devexpress.editors.utils.textstrategies;

import android.text.Editable;
import com.devexpress.editors.popupmanagers.PopupPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupTextProcessor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/utils/textstrategies/PopupTextProcessor;", "Lcom/devexpress/editors/utils/textstrategies/DefaultTextProcessor;", "popupPresenter", "Lcom/devexpress/editors/popupmanagers/PopupPresenter;", "(Lcom/devexpress/editors/popupmanagers/PopupPresenter;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "updatePopupIfNeeded", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PopupTextProcessor extends DefaultTextProcessor {
    private final PopupPresenter popupPresenter;

    public PopupTextProcessor(PopupPresenter popupPresenter) {
        Intrinsics.checkNotNullParameter(popupPresenter, "popupPresenter");
        this.popupPresenter = popupPresenter;
    }

    @Override // com.devexpress.editors.utils.textstrategies.DefaultTextProcessor, com.devexpress.editors.utils.textstrategies.TextProcessor
    public boolean afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.popupPresenter.showPopup();
        updatePopupIfNeeded();
        return super.afterTextChanged(s);
    }

    private final void updatePopupIfNeeded() {
        if (this.popupPresenter.isPopupShowing()) {
            this.popupPresenter.updatePopup();
        }
    }
}
