package com.devexpress.editors.layout.factories;

import android.view.View;
import android.widget.TextView;
import com.devexpress.editors.layout.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PickerEditLayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/devexpress/editors/layout/factories/PickerEditLayoutElementsFactory;", "Lcom/devexpress/editors/layout/factories/AbstractEditLayoutElementsFactory;", "editorView", "Landroid/widget/TextView;", "labelView", "leadingImage", "Landroid/view/View;", "trailingImage", "clearImage", "primaryImage", "errorImage", "errorView", "helperView", "suffixView", "prefixView", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;)V", "endImageElements", "", "Lcom/devexpress/editors/layout/ViewHolder;", "getEndImageElements", "()Ljava/util/List;", "primaryImageElement", "getPrimaryImageElement", "()Lcom/devexpress/editors/layout/ViewHolder;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PickerEditLayoutElementsFactory extends AbstractEditLayoutElementsFactory {
    private final List<ViewHolder> endImageElements;
    private final ViewHolder primaryImageElement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerEditLayoutElementsFactory(TextView editorView, TextView labelView, View leadingImage, View trailingImage, View clearImage, View primaryImage, View errorImage, View errorView, View helperView, TextView suffixView, TextView prefixView) {
        super(editorView, labelView, leadingImage, trailingImage, clearImage, errorImage, errorView, helperView, suffixView, prefixView);
        Intrinsics.checkNotNullParameter(editorView, "editorView");
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(leadingImage, "leadingImage");
        Intrinsics.checkNotNullParameter(trailingImage, "trailingImage");
        Intrinsics.checkNotNullParameter(clearImage, "clearImage");
        Intrinsics.checkNotNullParameter(primaryImage, "primaryImage");
        Intrinsics.checkNotNullParameter(errorImage, "errorImage");
        Intrinsics.checkNotNullParameter(errorView, "errorView");
        Intrinsics.checkNotNullParameter(helperView, "helperView");
        Intrinsics.checkNotNullParameter(suffixView, "suffixView");
        Intrinsics.checkNotNullParameter(prefixView, "prefixView");
        ViewHolder viewHolder = new ViewHolder("primary_icon", primaryImage, null, null, false, 28, null);
        this.primaryImageElement = viewHolder;
        this.endImageElements = CollectionsKt.listOf((Object[]) new ViewHolder[]{getClearImageElement(), viewHolder, getEndImageElement(), getErrorImageElement()});
        viewHolder.setGravity(113);
    }

    protected final ViewHolder getPrimaryImageElement() {
        return this.primaryImageElement;
    }

    @Override // com.devexpress.editors.layout.factories.AbstractEditLayoutElementsFactory, com.devexpress.editors.LayoutElementsFactory
    public List<ViewHolder> getEndImageElements() {
        return this.endImageElements;
    }
}
