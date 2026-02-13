package com.devexpress.editors.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditorContainer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"EditorBox", "Lcom/devexpress/editors/layout/EditorContainer;", "editorElement", "Lcom/devexpress/editors/layout/Element;", "startElement", "endElement", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "dxeditors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditorContainerKt {
    public static /* synthetic */ EditorContainer EditorBox$default(Element element, Element element2, Element element3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            element = null;
        }
        if ((i & 2) != 0) {
            element2 = null;
        }
        if ((i & 4) != 0) {
            element3 = null;
        }
        return EditorBox(element, element2, element3, function1);
    }

    public static final EditorContainer EditorBox(Element element, Element element2, Element element3, Function1<? super EditorContainer, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        EditorContainer editorContainer = new EditorContainer(element, element2, element3);
        init.invoke(editorContainer);
        return editorContainer;
    }
}
