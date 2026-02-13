package com.devexpress.editors;

import com.devexpress.editors.layout.Element;
import com.devexpress.editors.layout.TextViewHolder;
import java.util.List;
import kotlin.Metadata;

/* compiled from: LayoutElementsFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0012\u0010\u0018\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/devexpress/editors/LayoutElementsFactory;", "", "counterElement", "Lcom/devexpress/editors/layout/Element;", "getCounterElement", "()Lcom/devexpress/editors/layout/Element;", "editorElement", "Lcom/devexpress/editors/layout/TextViewHolder;", "getEditorElement", "()Lcom/devexpress/editors/layout/TextViewHolder;", "endImageElements", "", "getEndImageElements", "()Ljava/util/List;", "errorTextElement", "getErrorTextElement", "helpTextElement", "getHelpTextElement", "labelElement", "getLabelElement", "prefixElement", "getPrefixElement", "startImageElements", "getStartImageElements", "suffixElement", "getSuffixElement", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LayoutElementsFactory {
    Element getCounterElement();

    TextViewHolder getEditorElement();

    List<Element> getEndImageElements();

    Element getErrorTextElement();

    Element getHelpTextElement();

    TextViewHolder getLabelElement();

    TextViewHolder getPrefixElement();

    List<Element> getStartImageElements();

    TextViewHolder getSuffixElement();
}
