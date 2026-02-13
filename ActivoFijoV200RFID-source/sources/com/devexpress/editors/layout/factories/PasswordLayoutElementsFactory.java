package com.devexpress.editors.layout.factories;

import android.view.View;
import android.widget.TextView;
import com.devexpress.editors.layout.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PasswordLayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/devexpress/editors/layout/factories/PasswordLayoutElementsFactory;", "Lcom/devexpress/editors/layout/factories/TextEditLayoutElementsFactory;", "editorView", "Landroid/widget/TextView;", "labelView", "leadingImage", "Landroid/view/View;", "trailingImage", "errorImage", "errorView", "helperView", "suffixView", "prefixView", "clearImage", "counterView", "passwordImage", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "endImageElements", "", "Lcom/devexpress/editors/layout/ViewHolder;", "getEndImageElements", "()Ljava/util/List;", "passwordImageElement", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class PasswordLayoutElementsFactory extends TextEditLayoutElementsFactory {
    private final List<ViewHolder> endImageElements;
    private final ViewHolder passwordImageElement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordLayoutElementsFactory(TextView editorView, TextView labelView, View leadingImage, View trailingImage, View errorImage, View errorView, View helperView, TextView suffixView, TextView prefixView, View clearImage, View counterView, View passwordImage) {
        super(editorView, labelView, leadingImage, trailingImage, errorImage, errorView, helperView, suffixView, prefixView, clearImage, counterView);
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
        Intrinsics.checkNotNullParameter(passwordImage, "passwordImage");
        ViewHolder viewHolder = new ViewHolder("password_icon", passwordImage, null, null, false, 28, null);
        this.passwordImageElement = viewHolder;
        this.endImageElements = CollectionsKt.listOf((Object[]) new ViewHolder[]{getClearImageElement(), viewHolder, getEndImageElement(), getErrorImageElement()});
        viewHolder.setGravity(113);
    }

    @Override // com.devexpress.editors.layout.factories.AbstractEditLayoutElementsFactory, com.devexpress.editors.LayoutElementsFactory
    public List<ViewHolder> getEndImageElements() {
        return this.endImageElements;
    }
}
