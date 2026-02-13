package com.devexpress.editors.layout;

import android.util.Size;
import android.view.View;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomTextContainer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016J0\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0014J\b\u0010\u0018\u001a\u00020\u0011H\u0002R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/devexpress/editors/layout/BottomTextContainer;", "Lcom/devexpress/editors/layout/ZStack;", "helpElement", "Lcom/devexpress/editors/layout/Element;", "errorElement", "(Lcom/devexpress/editors/layout/Element;Lcom/devexpress/editors/layout/Element;)V", "getErrorElement", "()Lcom/devexpress/editors/layout/Element;", "getHelpElement", "value", "", "state", "getState", "()I", "setState", "(I)V", "measure", "", "widthSpec", "heightSpec", "measureChild", "child", "usedWidth", "usedHeight", "updateChildrenVisibility", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomTextContainer extends ZStack {
    public static final int STATE_ERROR = 2;
    public static final int STATE_HELP = 1;
    public static final int STATE_NONE = 0;
    private final Element errorElement;
    private final Element helpElement;
    private int state;

    public final Element getHelpElement() {
        return this.helpElement;
    }

    public final Element getErrorElement() {
        return this.errorElement;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomTextContainer(Element helpElement, Element errorElement) {
        super("bottom_text_container", null, 0, null, 14, null);
        Intrinsics.checkNotNullParameter(helpElement, "helpElement");
        Intrinsics.checkNotNullParameter(errorElement, "errorElement");
        this.helpElement = helpElement;
        this.errorElement = errorElement;
        this.state = 1;
        getChildrenInternal().add(helpElement);
        getChildrenInternal().add(errorElement);
        helpElement.setGravity(8388659);
        errorElement.setGravity(8388659);
    }

    public final int getState() {
        return this.state;
    }

    public final void setState(int i) {
        if (i == this.state) {
            return;
        }
        this.state = i;
        updateChildrenVisibility();
    }

    @Override // com.devexpress.editors.layout.ZStack, com.devexpress.editors.layout.Element
    public void measure(int widthSpec, int heightSpec) {
        Size size;
        int size2 = View.MeasureSpec.getSize(widthSpec);
        int mode = View.MeasureSpec.getMode(widthSpec);
        int size3 = View.MeasureSpec.getSize(heightSpec);
        int mode2 = View.MeasureSpec.getMode(heightSpec);
        int horizontal = getPadding().getHorizontal();
        int vertical = getPadding().getVertical();
        Iterator<Element> it = getChildren().iterator();
        while (it.hasNext()) {
            measureChild(it.next(), widthSpec, horizontal, heightSpec, vertical);
        }
        int i = this.state;
        if (i == 1) {
            size = new Size(this.helpElement.getMeasuredSize().getWidth() + this.helpElement.getMargin().getHorizontal(), this.helpElement.getMeasuredSize().getHeight() + this.helpElement.getMargin().getVertical());
        } else if (i == 2) {
            size = new Size(this.errorElement.getMeasuredSize().getWidth() + this.errorElement.getMargin().getHorizontal(), this.errorElement.getMeasuredSize().getHeight() + this.errorElement.getMargin().getVertical());
        } else {
            size = new Size(0, 0);
        }
        if (mode == Integer.MIN_VALUE) {
            size2 = Math.max(size.getWidth() + horizontal, size2);
        } else if (mode == 0) {
            size2 = size.getWidth() + horizontal;
        } else if (mode != 1073741824) {
            size2 = 0;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size3 = Math.min(size.getHeight() + vertical, size3);
        } else if (mode2 == 0) {
            size3 = size.getHeight() + vertical;
        } else if (mode2 != 1073741824) {
            size3 = 0;
        }
        setMeasuredSize(new Size(size2, size3));
    }

    @Override // com.devexpress.editors.layout.AbstractContainer
    protected void measureChild(Element child, int widthSpec, int usedWidth, int heightSpec, int usedHeight) {
        Intrinsics.checkNotNullParameter(child, "child");
        child.measure(AbstractContainer.INSTANCE.makeChildMeasureSpec(widthSpec, usedWidth + child.getMargin().getHorizontal(), child.getWidthRequest()), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private final void updateChildrenVisibility() {
        int i = this.state;
        if (i == 0) {
            this.helpElement.setVisible(false);
            this.errorElement.setVisible(false);
        } else if (i == 1) {
            this.helpElement.setVisible(true);
            this.errorElement.setVisible(false);
        } else {
            if (i != 2) {
                return;
            }
            this.helpElement.setVisible(false);
            this.errorElement.setVisible(true);
        }
    }
}
