package com.devexpress.editors.layout;

import android.widget.TextView;
import com.devexpress.editors.model.Thickness;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewHolder.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/devexpress/editors/layout/TextViewHolder;", "Lcom/devexpress/editors/layout/ViewHolder;", "id", "", "textView", "Landroid/widget/TextView;", "padding", "Lcom/devexpress/editors/model/Thickness;", "margin", "applyMarginForZeroSize", "", "(Ljava/lang/String;Landroid/widget/TextView;Lcom/devexpress/editors/model/Thickness;Lcom/devexpress/editors/model/Thickness;Z)V", "getId", "()Ljava/lang/String;", "value", "", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "getTextView", "()Landroid/widget/TextView;", "", "unit", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextViewHolder extends ViewHolder {
    private final String id;
    private final TextView textView;

    public /* synthetic */ TextViewHolder(String str, TextView textView, Thickness thickness, Thickness thickness2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, textView, (i & 4) != 0 ? new Thickness() : thickness, (i & 8) != 0 ? new Thickness() : thickness2, (i & 16) != 0 ? true : z);
    }

    @Override // com.devexpress.editors.layout.ViewHolder, com.devexpress.editors.layout.Element
    public String getId() {
        return this.id;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewHolder(String id, TextView textView, Thickness padding, Thickness margin, boolean z) {
        super(id, textView, padding, margin, z);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        this.id = id;
        this.textView = textView;
    }

    public final float getTextSize() {
        return this.textView.getTextSize();
    }

    public final void setTextSize(float f) {
        this.textView.setTextSize(0, f);
    }

    public final void setTextSize(int unit, float value) {
        this.textView.setTextSize(unit, value);
    }
}
