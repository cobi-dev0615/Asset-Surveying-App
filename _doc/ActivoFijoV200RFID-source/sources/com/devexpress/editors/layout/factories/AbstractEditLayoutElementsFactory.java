package com.devexpress.editors.layout.factories;

import android.view.View;
import android.widget.TextView;
import com.devexpress.editors.LayoutElementsFactory;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.TextViewHolder;
import com.devexpress.editors.layout.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractEditLayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u0014\u0010%\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0012R\u0011\u0010'\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010)\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0014\u0010+\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0012R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0011\u0010/\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001a¨\u00061"}, d2 = {"Lcom/devexpress/editors/layout/factories/AbstractEditLayoutElementsFactory;", "Lcom/devexpress/editors/LayoutElementsFactory;", "editorView", "Landroid/widget/TextView;", "labelView", "leadingImage", "Landroid/view/View;", "trailingImage", "clearImage", "errorImage", "errorView", "helperView", "suffixView", "prefixView", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/widget/TextView;)V", "clearImageElement", "Lcom/devexpress/editors/layout/ViewHolder;", "getClearImageElement", "()Lcom/devexpress/editors/layout/ViewHolder;", "counterElement", "Lcom/devexpress/editors/layout/Element;", "getCounterElement", "()Lcom/devexpress/editors/layout/Element;", "editorElement", "Lcom/devexpress/editors/layout/TextViewHolder;", "getEditorElement", "()Lcom/devexpress/editors/layout/TextViewHolder;", "endImageElement", "getEndImageElement", "endImageElements", "", "getEndImageElements", "()Ljava/util/List;", "errorImageElement", "getErrorImageElement", "errorTextElement", "getErrorTextElement", "helpTextElement", "getHelpTextElement", "labelElement", "getLabelElement", "prefixElement", "getPrefixElement", "startImageElement", "getStartImageElement", "startImageElements", "getStartImageElements", "suffixElement", "getSuffixElement", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractEditLayoutElementsFactory implements LayoutElementsFactory {
    private final ViewHolder clearImageElement;
    private final Element counterElement;
    private final TextViewHolder editorElement;
    private final ViewHolder endImageElement;
    private final List<Element> endImageElements;
    private final ViewHolder errorImageElement;
    private final ViewHolder errorTextElement;
    private final ViewHolder helpTextElement;
    private final TextViewHolder labelElement;
    private final TextViewHolder prefixElement;
    private final ViewHolder startImageElement;
    private final List<Element> startImageElements;
    private final TextViewHolder suffixElement;

    public AbstractEditLayoutElementsFactory(TextView editorView, TextView labelView, View leadingImage, View trailingImage, View clearImage, View errorImage, View errorView, View helperView, TextView suffixView, TextView prefixView) {
        Intrinsics.checkNotNullParameter(editorView, "editorView");
        Intrinsics.checkNotNullParameter(labelView, "labelView");
        Intrinsics.checkNotNullParameter(leadingImage, "leadingImage");
        Intrinsics.checkNotNullParameter(trailingImage, "trailingImage");
        Intrinsics.checkNotNullParameter(clearImage, "clearImage");
        Intrinsics.checkNotNullParameter(errorImage, "errorImage");
        Intrinsics.checkNotNullParameter(errorView, "errorView");
        Intrinsics.checkNotNullParameter(helperView, "helperView");
        Intrinsics.checkNotNullParameter(suffixView, "suffixView");
        Intrinsics.checkNotNullParameter(prefixView, "prefixView");
        this.labelElement = new TextViewHolder("label", labelView, null, null, false, 28, null);
        TextViewHolder textViewHolder = new TextViewHolder("editor", editorView, null, null, false, 28, null);
        this.editorElement = textViewHolder;
        TextViewHolder textViewHolder2 = new TextViewHolder("suffix", suffixView, null, null, false, 28, null);
        this.suffixElement = textViewHolder2;
        TextViewHolder textViewHolder3 = new TextViewHolder("prefix", prefixView, null, null, false, 28, null);
        this.prefixElement = textViewHolder3;
        ViewHolder viewHolder = new ViewHolder("start_icon", leadingImage, null, null, false, 28, null);
        this.startImageElement = viewHolder;
        ViewHolder viewHolder2 = new ViewHolder("clear_icon", clearImage, null, null, false, 28, null);
        this.clearImageElement = viewHolder2;
        ViewHolder viewHolder3 = new ViewHolder("end_icon", trailingImage, null, null, false, 28, null);
        this.endImageElement = viewHolder3;
        ViewHolder viewHolder4 = new ViewHolder("error_icon", errorImage, null, null, false, 28, null);
        this.errorImageElement = viewHolder4;
        this.errorTextElement = new ViewHolder("error_text", errorView, null, null, false, 28, null);
        this.helpTextElement = new ViewHolder("helper_text", helperView, null, null, false, 28, null);
        this.startImageElements = CollectionsKt.listOf(viewHolder);
        this.endImageElements = CollectionsKt.listOf((Object[]) new ViewHolder[]{viewHolder2, viewHolder3, viewHolder4});
        textViewHolder.setGravity(17);
        textViewHolder3.setGravity(17);
        textViewHolder2.setGravity(17);
        viewHolder.setGravity(113);
        viewHolder2.setGravity(113);
        viewHolder3.setGravity(113);
        viewHolder4.setGravity(113);
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public final TextViewHolder getLabelElement() {
        return this.labelElement;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public final TextViewHolder getEditorElement() {
        return this.editorElement;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public final TextViewHolder getSuffixElement() {
        return this.suffixElement;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public final TextViewHolder getPrefixElement() {
        return this.prefixElement;
    }

    protected final ViewHolder getStartImageElement() {
        return this.startImageElement;
    }

    protected final ViewHolder getClearImageElement() {
        return this.clearImageElement;
    }

    protected final ViewHolder getEndImageElement() {
        return this.endImageElement;
    }

    protected final ViewHolder getErrorImageElement() {
        return this.errorImageElement;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public ViewHolder getErrorTextElement() {
        return this.errorTextElement;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public ViewHolder getHelpTextElement() {
        return this.helpTextElement;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public List<Element> getStartImageElements() {
        return this.startImageElements;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public List<Element> getEndImageElements() {
        return this.endImageElements;
    }

    @Override // com.devexpress.editors.LayoutElementsFactory
    public Element getCounterElement() {
        return this.counterElement;
    }
}
