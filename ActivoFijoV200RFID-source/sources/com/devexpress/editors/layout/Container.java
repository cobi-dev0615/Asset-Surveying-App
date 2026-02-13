package com.devexpress.editors.layout;

import android.graphics.Canvas;
import com.devexpress.editors.layout.Element;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Interfaces.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H&J!\u0010\u000f\u001a\u00020\r2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011\"\u00020\u0001H&¢\u0006\u0002\u0010\u0012J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H&J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0001H&J\b\u0010\u0016\u001a\u00020\rH&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H&J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/devexpress/editors/layout/Container;", "Lcom/devexpress/editors/layout/Element;", "children", "", "getChildren", "()Ljava/util/List;", "layoutDirection", "", "getLayoutDirection", "()I", "setLayoutDirection", "(I)V", "addChild", "", "element", "addChildren", "elements", "", "([Lcom/devexpress/editors/layout/Element;)V", "", "insertChild", "index", "removeAllChildren", "removeChild", "removeChildAt", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Container extends Element {
    void addChild(Element element);

    void addChildren(Iterable<? extends Element> elements);

    void addChildren(Element... elements);

    List<Element> getChildren();

    int getLayoutDirection();

    void insertChild(int index, Element element);

    void removeAllChildren();

    void removeChild(Element element);

    void removeChildAt(int index);

    void setLayoutDirection(int i);

    /* compiled from: Interfaces.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void draw(Container container, Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Element.DefaultImpls.draw(container, canvas);
        }
    }
}
