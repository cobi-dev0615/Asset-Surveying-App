package com.devexpress.editors;

import android.view.autofill.AutofillValue;
import kotlin.Metadata;

/* compiled from: AutofillDelegate.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/devexpress/editors/AutofillDelegate;", "", "autofill", "", "value", "Landroid/view/autofill/AutofillValue;", "provideAutofillOptions", "", "", "()[Ljava/lang/CharSequence;", "provideAutofillType", "", "provideAutofillValue", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AutofillDelegate {
    void autofill(AutofillValue value);

    CharSequence[] provideAutofillOptions();

    int provideAutofillType();

    AutofillValue provideAutofillValue();
}
