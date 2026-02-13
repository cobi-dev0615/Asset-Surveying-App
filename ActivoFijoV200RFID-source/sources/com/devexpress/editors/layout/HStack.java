package com.devexpress.editors.layout;

import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import com.devexpress.editors.model.MathUtilsKt;
import com.devexpress.editors.model.Thickness;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HStack.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001-B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J.\u0010\u0013\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0004J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016J6\u0010\u001f\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0004J \u0010&\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0002J \u0010'\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0002J \u0010(\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bH\u0002J\u001e\u0010*\u001a\u00020\u0014*\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140+¢\u0006\u0002\b,H\u0086\u0002R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/devexpress/editors/layout/HStack;", "Lcom/devexpress/editors/layout/AbstractContainer;", "id", "", "children", "", "Lcom/devexpress/editors/layout/Element;", "gravity", "", "padding", "Lcom/devexpress/editors/model/Thickness;", "(Ljava/lang/String;Ljava/util/List;ILcom/devexpress/editors/model/Thickness;)V", "itemSpacing", "getItemSpacing", "()I", "setItemSpacing", "(I)V", "measureVars", "Lcom/devexpress/editors/layout/HStack$MeasureVars;", "layout", "", "left", "top", "right", "bottom", "elements", "l", "t", "b", "layoutChild", "child", "measure", "widthSpec", "heightSpec", "Landroid/util/Size;", "items", "usedWidth", "usedHeight", "measureChildForKnownWidth", "measureChildForUnspecifiedWidth", "measureStarChildForKnownWidth", "measureStarChildForUnspecifiedWidth", "invoke", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "MeasureVars", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class HStack extends AbstractContainer {
    private int itemSpacing;
    private final MeasureVars measureVars;

    public HStack() {
        this(null, null, 0, null, 15, null);
    }

    public /* synthetic */ HStack(String str, List list, int i, Thickness thickness, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? 8388659 : i, (i2 & 8) != 0 ? new Thickness() : thickness);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HStack(String id, List<? extends Element> list, int i, Thickness padding) {
        super(id, list, i, padding, 0, 16, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.measureVars = new MeasureVars();
    }

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    @Override // com.devexpress.editors.layout.Element
    public void measure(int widthSpec, int heightSpec) {
        setMeasuredSize(measure(getChildren(), widthSpec, heightSpec, getPadding().getHorizontal(), getPadding().getVertical()));
    }

    @Override // com.devexpress.editors.layout.Element
    public void layout(int left, int top, int right, int bottom) {
        getPadding().resolve(getLayoutDirection());
        int top2 = getPadding().getTop() + top;
        layout(getChildren(), getPadding().getLeft() + left, top2, bottom - getPadding().getBottom());
        getBounds().set(left, top, right, bottom);
    }

    public final void invoke(Function1<? super HStack, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        function1.invoke(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final android.util.Size measure(java.util.List<? extends com.devexpress.editors.layout.Element> r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.layout.HStack.measure(java.util.List, int, int, int, int):android.util.Size");
    }

    protected final void layout(List<? extends Element> elements, int l, int t, int b) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (Element element : elements) {
            if (element.isVisible()) {
                layoutChild(element, l, t, b);
                l += element.getMeasuredSize().getWidth() + this.itemSpacing + element.getMargin().getHorizontal();
            }
        }
    }

    private final void measureChildForUnspecifiedWidth(Element child, int widthSpec, int heightSpec) {
        measureChild(child, widthSpec, this.measureVars.getUsedWidth(), heightSpec, this.measureVars.getUsedHeight());
        this.measureVars.setMaxHeight(Math.max(child.getMeasuredSize().getHeight() + child.getMargin().getVertical(), this.measureVars.getMaxHeight()));
        if (child.getWidthRequest().isStar()) {
            this.measureVars.getStarChildren().add(child);
            MeasureVars measureVars = this.measureVars;
            measureVars.setStarSize(Math.max(measureVars.getStarSize(), child.getMeasuredSize().getWidth() / child.getWidthRequest().getValue()));
        } else {
            MeasureVars measureVars2 = this.measureVars;
            measureVars2.setUsedWidth(measureVars2.getUsedWidth() + child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal());
        }
    }

    private final void measureStarChildForUnspecifiedWidth(Element child, int heightSpec) {
        SizeDefinition widthRequest = child.getWidthRequest();
        child.measure(View.MeasureSpec.makeMeasureSpec(Math.min(Math.max((int) (this.measureVars.getStarSize() * widthRequest.getValue()), widthRequest.getMinSize()), widthRequest.getMaxSize()), BasicMeasure.EXACTLY), AbstractContainer.INSTANCE.makeChildMeasureSpec(heightSpec, this.measureVars.getUsedHeight() + child.getMargin().getVertical(), child.getHeightRequest()));
        this.measureVars.setMaxHeight(Math.max(child.getMeasuredSize().getHeight() + child.getMargin().getVertical(), this.measureVars.getMaxHeight()));
        MeasureVars measureVars = this.measureVars;
        measureVars.setUsedWidth(measureVars.getUsedWidth() + child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal());
    }

    private final void measureChildForKnownWidth(Element child, int widthSpec, int heightSpec) {
        if (!child.getWidthRequest().isStar()) {
            measureChild(child, widthSpec, this.measureVars.getUsedWidth(), heightSpec, this.measureVars.getUsedHeight());
            this.measureVars.setMaxHeight(Math.max(child.getMeasuredSize().getHeight() + child.getMargin().getVertical(), this.measureVars.getMaxHeight()));
            MeasureVars measureVars = this.measureVars;
            measureVars.setUsedWidth(measureVars.getUsedWidth() + child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal());
            return;
        }
        this.measureVars.getStarChildren().add(child);
        MeasureVars measureVars2 = this.measureVars;
        measureVars2.setStarCount(measureVars2.getStarCount() + child.getWidthRequest().getValue());
        MeasureVars measureVars3 = this.measureVars;
        measureVars3.setStarChildrenMarginSize(measureVars3.getStarChildrenMarginSize() + child.getMargin().getHorizontal());
    }

    private final void measureStarChildForKnownWidth(Element child, int widthSpec, int heightSpec) {
        int max = Math.max((View.MeasureSpec.getSize(widthSpec) - this.measureVars.getUsedWidth()) - this.measureVars.getStarChildrenMarginSize(), 0);
        SizeDefinition widthRequest = child.getWidthRequest();
        child.measure(View.MeasureSpec.makeMeasureSpec(MathUtilsKt.clamp((int) Math.floor((max * widthRequest.getValue()) / this.measureVars.getStarCount()), widthRequest.getMinSize(), widthRequest.getMaxSize()), BasicMeasure.EXACTLY), AbstractContainer.INSTANCE.makeChildMeasureSpec(heightSpec, this.measureVars.getUsedHeight() + child.getMargin().getVertical(), child.getHeightRequest()));
        MeasureVars measureVars = this.measureVars;
        measureVars.setStarCount(measureVars.getStarCount() - widthRequest.getValue());
        MeasureVars measureVars2 = this.measureVars;
        measureVars2.setStarChildrenMarginSize(measureVars2.getStarChildrenMarginSize() - child.getMargin().getHorizontal());
        MeasureVars measureVars3 = this.measureVars;
        measureVars3.setUsedWidth(measureVars3.getUsedWidth() + child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal());
        this.measureVars.setMaxHeight(Math.max(child.getMeasuredSize().getHeight() + child.getMargin().getVertical(), this.measureVars.getMaxHeight()));
    }

    private final void layoutChild(Element child, int l, int t, int b) {
        int vertical;
        int i;
        child.getMargin().resolve(getLayoutDirection());
        int absoluteGravity = GravityCompat.getAbsoluteGravity(child.getGravity(), getLayoutDirection()) & 112;
        if (absoluteGravity == 16) {
            Thickness margin = child.getMargin();
            int height = child.getMeasuredSize().getHeight();
            vertical = t + ((((b - t) - height) - margin.getVertical()) / 2) + margin.getTop();
            i = vertical + height;
        } else if (absoluteGravity == 48) {
            vertical = t + child.getMargin().getTop();
            i = child.getMeasuredSize().getHeight() + vertical;
        } else if (absoluteGravity == 80) {
            i = b - child.getMargin().getEnd();
            vertical = i - child.getMeasuredSize().getHeight();
        } else {
            vertical = t + child.getMargin().getTop();
            i = b - child.getMargin().getBottom();
        }
        int left = l + child.getMargin().getLeft();
        child.layout(left, vertical, child.getMeasuredSize().getWidth() + left, i);
    }

    /* compiled from: HStack.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/devexpress/editors/layout/HStack$MeasureVars;", "", "()V", "maxHeight", "", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "starChildren", "", "Lcom/devexpress/editors/layout/Element;", "getStarChildren", "()Ljava/util/List;", "starChildrenMarginSize", "getStarChildrenMarginSize", "setStarChildrenMarginSize", "starCount", "", "getStarCount", "()F", "setStarCount", "(F)V", "starSize", "getStarSize", "setStarSize", "usedHeight", "getUsedHeight", "setUsedHeight", "usedWidth", "getUsedWidth", "setUsedWidth", "reset", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class MeasureVars {
        private int maxHeight;
        private final List<Element> starChildren = new ArrayList();
        private int starChildrenMarginSize;
        private float starCount;
        private float starSize;
        private int usedHeight;
        private int usedWidth;

        public final int getUsedWidth() {
            return this.usedWidth;
        }

        public final void setUsedWidth(int i) {
            this.usedWidth = i;
        }

        public final int getUsedHeight() {
            return this.usedHeight;
        }

        public final void setUsedHeight(int i) {
            this.usedHeight = i;
        }

        public final int getMaxHeight() {
            return this.maxHeight;
        }

        public final void setMaxHeight(int i) {
            this.maxHeight = i;
        }

        public final float getStarCount() {
            return this.starCount;
        }

        public final void setStarCount(float f) {
            this.starCount = f;
        }

        public final float getStarSize() {
            return this.starSize;
        }

        public final void setStarSize(float f) {
            this.starSize = f;
        }

        public final int getStarChildrenMarginSize() {
            return this.starChildrenMarginSize;
        }

        public final void setStarChildrenMarginSize(int i) {
            this.starChildrenMarginSize = i;
        }

        public final List<Element> getStarChildren() {
            return this.starChildren;
        }

        public final void reset() {
            this.usedWidth = 0;
            this.usedHeight = 0;
            this.maxHeight = 0;
            this.starCount = 0.0f;
            this.starSize = 0.0f;
            this.starChildrenMarginSize = 0;
            this.starChildren.clear();
        }
    }
}
