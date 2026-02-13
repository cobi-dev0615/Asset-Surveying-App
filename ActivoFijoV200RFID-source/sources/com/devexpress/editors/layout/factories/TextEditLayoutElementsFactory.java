package com.devexpress.editors.layout.factories;

import android.view.View;
import android.widget.TextView;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextEditLayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/devexpress/editors/layout/factories/TextEditLayoutElementsFactory;", "Lcom/devexpress/editors/layout/factories/AbstractEditLayoutElementsFactory;", "editorView", "Landroid/widget/TextView;", "labelView", "leadingImage", "Landroid/view/View;", "trailingImage", "errorImage", "errorView", "helperView", "suffixView", "prefixView", "clearImage", "counterView", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;)V", "counterElement", "Lcom/devexpress/editors/layout/Element;", "getCounterElement", "()Lcom/devexpress/editors/layout/Element;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class TextEditLayoutElementsFactory extends AbstractEditLayoutElementsFactory {
    private final Element counterElement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextEditLayoutElementsFactory(TextView editorView, TextView labelView, View leadingImage, View trailingImage, View errorImage, View errorView, View helperView, TextView suffixView, TextView prefixView, View clearImage, View counterView) {
        super(editorView, labelView, leadingImage, trailingImage, clearImage, errorImage, errorView, helperView, suffixView, prefixView);
        Intrinsics.checkNotNullParameter(editorView, "editorView");
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(leadingImage, "leadingImage");
        Intrinsics.checkNotNullParameter(trailingImage, "trailingImage");
        Intrinsics.checkNotNullParameter(errorImage, "errorImage");
        Intrinsics.checkNotNullParameter(errorView, "errorView");
        Intrinsics.checkNotNullParameter(helperView, "helperView");
        Intrinsics.checkNotNullParameter(suffixView, "suffixView");
        Intrinsics.checkNotNullParameter(prefixView, "prefixView");
        Intrinsics.checkNotNullParameter(clearImage, "clearImage");
        Intrinsics.checkNotNullParameter(counterView, "counterView");
        this.counterElement = new ViewHolder("counter", counterView, null, null, false, 28, null);
    }

    @Override // com.devexpress.editors.layout.factories.AbstractEditLayoutElementsFactory, com.devexpress.editors.LayoutElementsFactory
    public Element getCounterElement() {
        return this.counterElement;
    }
}
