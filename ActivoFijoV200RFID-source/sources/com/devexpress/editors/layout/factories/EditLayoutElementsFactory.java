package com.devexpress.editors.layout.factories;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditLayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/devexpress/editors/layout/factories/EditLayoutElementsFactory;", "Lcom/devexpress/editors/layout/factories/AbstractEditLayoutElementsFactory;", "editorView", "Landroid/widget/TextView;", "labelView", "leadingImage", "Landroid/view/View;", "trailingImage", "errorImage", "errorView", "helperView", "suffixView", "prefixView", "clearImage", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;)V", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditLayoutElementsFactory extends AbstractEditLayoutElementsFactory {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditLayoutElementsFactory(TextView editorView, TextView labelView, View leadingImage, View trailingImage, View errorImage, View errorView, View helperView, TextView suffixView, TextView prefixView, View clearImage) {
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
    }
}
