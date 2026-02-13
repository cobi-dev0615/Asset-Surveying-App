package com.devexpress.editors.layout;

import android.util.Size;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.devexpress.editors.model.Thickness;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ZStack.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J0\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001e\u0010\u001b\u001a\u00020\r*\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u001c¢\u0006\u0002\b\u001dH\u0086\u0002¨\u0006\u001e"}, d2 = {"Lcom/devexpress/editors/layout/ZStack;", "Lcom/devexpress/editors/layout/AbstractContainer;", "id", "", "children", "", "Lcom/devexpress/editors/layout/Element;", "gravity", "", "padding", "Lcom/devexpress/editors/model/Thickness;", "(Ljava/lang/String;Ljava/util/List;ILcom/devexpress/editors/model/Thickness;)V", "layout", "", "left", "top", "right", "bottom", "layoutChild", "child", "l", "t", "r", "b", "measure", "widthSpec", "heightSpec", "invoke", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ZStack extends AbstractContainer {
    public ZStack() {
        this(null, null, 0, null, 15, null);
    }

    public /* synthetic */ ZStack(String str, List list, int i, Thickness thickness, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? 8388659 : i, (i2 & 8) != 0 ? new Thickness() : thickness);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZStack(String id, List<? extends Element> list, int i, Thickness padding) {
        super(id, list, i, padding, 0, 16, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(padding, "padding");
    }

    @Override // com.devexpress.editors.layout.Element
    public void measure(int widthSpec, int heightSpec) {
        int size = View.MeasureSpec.getSize(widthSpec);
        int mode = View.MeasureSpec.getMode(widthSpec);
        int size2 = View.MeasureSpec.getSize(heightSpec);
        int mode2 = View.MeasureSpec.getMode(heightSpec);
        int horizontal = getPadding().getHorizontal();
        int vertical = getPadding().getVertical();
        int i = 0;
        int i2 = 0;
        for (Element element : getChildren()) {
            measureChild(element, widthSpec, horizontal, heightSpec, vertical);
            i = Math.max(i, element.getMeasuredSize().getWidth() + element.getMargin().getHorizontal());
            i2 = Math.max(i2, element.getMeasuredSize().getHeight() + element.getMargin().getVertical());
        }
        if (mode == Integer.MIN_VALUE || mode == 0) {
            size = i + horizontal;
        } else if (mode != 1073741824) {
            size = 0;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            size2 = i2 + vertical;
        } else if (mode2 != 1073741824) {
            size2 = 0;
        }
        setMeasuredSize(new Size(size, size2));
    }

    @Override // com.devexpress.editors.layout.Element
    public void layout(int left, int top, int right, int bottom) {
        if (getChildren().size() != 0) {
            getPadding().resolve(getLayoutDirection());
            int top2 = getPadding().getTop() + top;
            int left2 = left + getPadding().getLeft();
            int bottom2 = bottom - getPadding().getBottom();
            int right2 = right - getPadding().getRight();
            int size = getChildren().size();
            for (int i = 0; i < size; i++) {
                layoutChild(getChildren().get(i), left2, top2, right2, bottom2);
            }
        }
        getBounds().set(left, top, right, bottom);
    }

    public final void invoke(Function1<? super ZStack, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        function1.invoke(this);
    }

    private final void layoutChild(Element child, int l, int t, int r, int b) {
        int horizontal;
        int i;
        int i2;
        child.getMargin().resolve(getLayoutDirection());
        int absoluteGravity = GravityCompat.getAbsoluteGravity(child.getGravity(), getLayoutDirection());
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int i5 = 0;
        if (i3 == 1) {
            Thickness margin = child.getMargin();
            int width = child.getMeasuredSize().getWidth();
            horizontal = l + ((((r - l) - width) - margin.getHorizontal()) / 2) + margin.getLeft();
            i = horizontal + width;
        } else if (i3 == 3) {
            horizontal = l + child.getMargin().getStart();
            i = child.getMeasuredSize().getWidth() + horizontal;
        } else if (i3 == 5) {
            i = r - child.getMargin().getEnd();
            horizontal = i - child.getMeasuredSize().getWidth();
        } else if (i3 != 7) {
            horizontal = 0;
            i = 0;
        } else {
            horizontal = l + child.getMargin().getLeft();
            i = r - child.getMargin().getRight();
        }
        if (i4 == 16) {
            Thickness margin2 = child.getMargin();
            int height = child.getMeasuredSize().getHeight();
            i5 = t + ((((b - t) - height) - margin2.getVertical()) / 2) + margin2.getTop();
            i2 = i5 + height;
        } else if (i4 == 48) {
            i5 = t + child.getMargin().getStart();
            i2 = child.getMeasuredSize().getHeight() + i5;
        } else if (i4 == 80) {
            int end = b - child.getMargin().getEnd();
            i5 = end - child.getMeasuredSize().getWidth();
            i2 = end;
        } else if (i4 != 112) {
            i2 = 0;
        } else {
            i5 = t + child.getMargin().getTop();
            i2 = b - child.getMargin().getBottom();
        }
        child.layout(horizontal, i5, i, i2);
    }
}
