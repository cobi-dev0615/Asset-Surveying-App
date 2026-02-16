package com.devexpress.editors.layout;

import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditorContainer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J#\u0010\u0002\u001a\u0002H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001b¢\u0006\u0002\u0010\u001cJ'\u0010\u0005\u001a\u0004\u0018\u0001H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u00032\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\u001b¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0016J'\u0010\u0004\u001a\u0004\u0018\u0001H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u00032\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00190\u001b¢\u0006\u0002\u0010\u001cJ\b\u0010!\u001a\u00020\u001eH\u0002R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000b¨\u0006\""}, d2 = {"Lcom/devexpress/editors/layout/EditorContainer;", "Lcom/devexpress/editors/layout/ZStack;", "editorElement", "Lcom/devexpress/editors/layout/Element;", "startElement", "endElement", "(Lcom/devexpress/editors/layout/Element;Lcom/devexpress/editors/layout/Element;Lcom/devexpress/editors/layout/Element;)V", "value", "getEditorElement", "()Lcom/devexpress/editors/layout/Element;", "setEditorElement", "(Lcom/devexpress/editors/layout/Element;)V", "getEndElement", "setEndElement", "minEditHeight", "", "getMinEditHeight", "()I", "setMinEditHeight", "(I)V", "minEditWidth", "getMinEditWidth", "setMinEditWidth", "getStartElement", "setStartElement", ExifInterface.GPS_DIRECTION_TRUE, "elementInit", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Lcom/devexpress/editors/layout/Element;", "measure", "", "widthSpec", "heightSpec", "updateChildren", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditorContainer extends ZStack {
    private Element editorElement;
    private Element endElement;
    private int minEditHeight;
    private int minEditWidth;
    private Element startElement;

    public EditorContainer() {
        this(null, null, null, 7, null);
    }

    public EditorContainer(Element element, Element element2, Element element3) {
        super(null, null, 0, null, 15, null);
        this.editorElement = element;
        this.startElement = element2;
        this.endElement = element3;
        updateChildren();
    }

    public /* synthetic */ EditorContainer(Element element, Element element2, Element element3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : element, (i & 2) != 0 ? null : element2, (i & 4) != 0 ? null : element3);
    }

    public final int getMinEditWidth() {
        return this.minEditWidth;
    }

    public final void setMinEditWidth(int i) {
        this.minEditWidth = i;
    }

    public final int getMinEditHeight() {
        return this.minEditHeight;
    }

    public final void setMinEditHeight(int i) {
        this.minEditHeight = i;
    }

    public final Element getEditorElement() {
        return this.editorElement;
    }

    public final void setEditorElement(Element element) {
        if (Intrinsics.areEqual(element, this.editorElement)) {
            return;
        }
        this.editorElement = element;
        updateChildren();
    }

    public final Element getStartElement() {
        return this.startElement;
    }

    public final void setStartElement(Element element) {
        if (Intrinsics.areEqual(this.startElement, element)) {
            return;
        }
        this.startElement = element;
        updateChildren();
    }

    public final Element getEndElement() {
        return this.endElement;
    }

    public final void setEndElement(Element element) {
        if (Intrinsics.areEqual(this.endElement, element)) {
            return;
        }
        this.endElement = element;
        updateChildren();
    }

    @Override // com.devexpress.editors.layout.ZStack, com.devexpress.editors.layout.Element
    public void measure(int widthSpec, int heightSpec) {
        int i;
        int i2;
        int i3;
        super.measure(widthSpec, heightSpec);
        Element element = this.editorElement;
        if (element == null) {
            return;
        }
        Element element2 = this.startElement;
        Element element3 = this.endElement;
        SizeDefinition widthRequest = element.getWidthRequest();
        SizeDefinition heightRequest = element.getHeightRequest();
        widthRequest.setMinSize(this.minEditWidth);
        int i4 = 0;
        if (element2 != null) {
            i2 = element2.getMeasuredSize().getHeight();
            i = element2.getMeasuredSize().getWidth();
        } else {
            i = 0;
            i2 = 0;
        }
        if (element3 != null) {
            i4 = element3.getMeasuredSize().getHeight();
            i3 = element3.getMeasuredSize().getWidth();
        } else {
            i3 = 0;
        }
        heightRequest.setMinSize(Math.max(Math.max(i2, i4), this.minEditHeight));
        element.getPadding().setStart(i);
        element.getPadding().setEnd(i3);
        super.measure(widthSpec, heightSpec);
    }

    public final <T extends Element> T editorElement(Function0<? extends T> elementInit) {
        Intrinsics.checkNotNullParameter(elementInit, "elementInit");
        T invoke = elementInit.invoke();
        setEditorElement(invoke);
        return invoke;
    }

    public final <T extends Element> T startElement(Function0<? extends T> elementInit) {
        Intrinsics.checkNotNullParameter(elementInit, "elementInit");
        T invoke = elementInit.invoke();
        setStartElement(invoke);
        return invoke;
    }

    public final <T extends Element> T endElement(Function0<? extends T> elementInit) {
        Intrinsics.checkNotNullParameter(elementInit, "elementInit");
        T invoke = elementInit.invoke();
        setEndElement(invoke);
        return invoke;
    }

    private final void updateChildren() {
        removeAllChildren();
        Element element = this.editorElement;
        if (element != null) {
            addChild(element);
            element.setGravity((element.getGravity() & 112) | 7);
        }
        Element element2 = this.startElement;
        if (element2 != null) {
            element2.setGravity((element2.getGravity() & 112) | GravityCompat.START);
            addChild(element2);
        }
        Element element3 = this.endElement;
        if (element3 != null) {
            element3.setGravity((element3.getGravity() & 112) | GravityCompat.END);
            addChild(element3);
        }
    }
}
