package com.devexpress.editors.layout.factories;

import android.view.View;
import android.widget.TextView;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoCompleteLayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/devexpress/editors/layout/factories/AutoCompleteLayoutElementsFactory;", "Lcom/devexpress/editors/layout/factories/AbstractEditLayoutElementsFactory;", "editorView", "Landroid/widget/TextView;", "labelView", "leadingImage", "Landroid/view/View;", "trailingImage", "errorImage", "errorView", "helperView", "suffixView", "prefixView", "clearImage", "submitImage", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;)V", "endImageElements", "", "Lcom/devexpress/editors/layout/Element;", "getEndImageElements", "()Ljava/util/List;", "submitImageElement", "Lcom/devexpress/editors/layout/ViewHolder;", "getSubmitImageElement", "()Lcom/devexpress/editors/layout/ViewHolder;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AutoCompleteLayoutElementsFactory extends AbstractEditLayoutElementsFactory {
    private final List<Element> endImageElements;
    private final ViewHolder submitImageElement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCompleteLayoutElementsFactory(TextView editorView, TextView labelView, View leadingImage, View trailingImage, View errorImage, View errorView, View helperView, TextView suffixView, TextView prefixView, View clearImage, View submitImage) {
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
        Intrinsics.checkNotNullParameter(submitImage, "submitImage");
        ViewHolder viewHolder = new ViewHolder("query_icon", submitImage, null, null, false, 28, null);
        this.submitImageElement = viewHolder;
        this.endImageElements = CollectionsKt.listOf((Object[]) new ViewHolder[]{getClearImageElement(), viewHolder, getEndImageElement(), getErrorImageElement()});
        viewHolder.setGravity(113);
    }

    protected final ViewHolder getSubmitImageElement() {
        return this.submitImageElement;
    }

    @Override // com.devexpress.editors.layout.factories.AbstractEditLayoutElementsFactory, com.devexpress.editors.LayoutElementsFactory
    public List<Element> getEndImageElements() {
        return this.endImageElements;
    }
}
