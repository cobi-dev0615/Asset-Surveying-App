package com.devexpress.editors.utils;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.devexpress.editors.model.mask.Mask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MaskManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001aJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/devexpress/editors/utils/MaskManager;", "", "mask", "Lcom/devexpress/editors/model/mask/Mask;", "(Lcom/devexpress/editors/model/mask/Mask;)V", "displayText", "", "getDisplayText", "()Ljava/lang/CharSequence;", "formattedValue", "Landroid/text/SpannableStringBuilder;", "isEmpty", "", "()Z", "value", "getMask", "()Lcom/devexpress/editors/model/mask/Mask;", "setMask", "maskChangedCallback", "Lkotlin/Function0;", "", "getMaskChangedCallback", "()Lkotlin/jvm/functions/Function0;", "setMaskChangedCallback", "(Lkotlin/jvm/functions/Function0;)V", "nextPosition", "", "getNextPosition", "()I", "oldValue", "text", "getText", "setText", "(Ljava/lang/CharSequence;)V", "onTextChanged", "s", "start", "before", "count", "populateWithFormattedValue", "e", "Landroid/text/Editable;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MaskManager {
    private final SpannableStringBuilder formattedValue;
    private Mask mask;
    private Function0<Unit> maskChangedCallback;
    private CharSequence oldValue;

    public MaskManager(Mask mask) {
        Intrinsics.checkNotNullParameter(mask, "mask");
        this.formattedValue = new SpannableStringBuilder();
        this.mask = mask;
    }

    public final Mask getMask() {
        return this.mask;
    }

    public final void setMask(Mask value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.mask)) {
            return;
        }
        String obj = this.mask.getRawValue().toString();
        StringsKt.replace$default(obj, this.mask.getPlaceholderChar(), value.getPlaceholderChar(), false, 4, (Object) null);
        this.mask = value;
        value.insert(0, obj);
        Function0<Unit> function0 = this.maskChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final CharSequence getText() {
        return this.mask.getRawValue();
    }

    public final void setText(CharSequence charSequence) {
        if (TextUtils.equals(this.mask.getRawValue(), charSequence)) {
            return;
        }
        if (charSequence != null) {
            Mask mask = this.mask;
            mask.replace(0, mask.getLength(), charSequence);
        } else {
            Mask mask2 = this.mask;
            mask2.remove(0, mask2.getLength());
        }
    }

    public final int getNextPosition() {
        return this.mask.getNextPosition();
    }

    public final Function0<Unit> getMaskChangedCallback() {
        return this.maskChangedCallback;
    }

    public final void setMaskChangedCallback(Function0<Unit> function0) {
        this.maskChangedCallback = function0;
    }

    public final CharSequence getDisplayText() {
        this.mask.populateWithFormattedValue(this.formattedValue);
        return this.formattedValue;
    }

    public final boolean isEmpty() {
        return this.mask.isEmpty();
    }

    public final void populateWithFormattedValue(Editable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.mask.populateWithFormattedValue(e);
    }

    public final void onTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.oldValue = UtilsKt.copy(this.mask.getRawValue());
        if (count == 0) {
            this.mask.remove(start, before);
        } else {
            this.mask.replace(start, before, s.subSequence(start, count + start));
        }
    }
}
