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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VStack.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001,B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J(\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0016J6\u0010\u001e\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0004J \u0010%\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002J \u0010&\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002J \u0010'\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u001e\u0010)\u001a\u00020\u0014*\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140*¢\u0006\u0002\b+H\u0086\u0002R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/devexpress/editors/layout/VStack;", "Lcom/devexpress/editors/layout/AbstractContainer;", "id", "", "children", "", "Lcom/devexpress/editors/layout/Element;", "gravity", "", "padding", "Lcom/devexpress/editors/model/Thickness;", "(Ljava/lang/String;Ljava/util/List;ILcom/devexpress/editors/model/Thickness;)V", "itemSpacing", "getItemSpacing", "()I", "setItemSpacing", "(I)V", "measureVars", "Lcom/devexpress/editors/layout/VStack$MeasureVars;", "layout", "", "left", "top", "right", "bottom", "layoutChild", "child", "l", "t", "r", "measure", "widthSpec", "heightSpec", "Landroid/util/Size;", "elements", "usedWidth", "usedHeight", "measureChildForKnownHeight", "measureChildForUnspecifiedHeight", "measureStarChildForKnownHeight", "measureStarChildForUnspecifiedHeight", "invoke", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "MeasureVars", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class VStack extends AbstractContainer {
    private int itemSpacing;
    private final MeasureVars measureVars;

    public VStack() {
        this(null, null, 0, null, 15, null);
    }

    public /* synthetic */ VStack(String str, List list, int i, Thickness thickness, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? 8388659 : i, (i2 & 8) != 0 ? new Thickness() : thickness);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VStack(String id, List<? extends Element> list, int i, Thickness padding) {
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
        if (!getChildren().isEmpty()) {
            getPadding().resolve(getLayoutDirection());
            int top2 = getPadding().getTop() + top;
            int left2 = getPadding().getLeft() + left;
            int right2 = right - getPadding().getRight();
            int size = getChildren().size() - 1;
            for (int i = 0; i < size; i++) {
                Element element = getChildren().get(i);
                if (element.isVisible()) {
                    layoutChild(element, left2, top2, right2);
                    top2 += element.getMeasuredSize().getHeight() + this.itemSpacing + element.getMargin().getVertical();
                }
            }
            Element element2 = (Element) CollectionsKt.last((List) getChildren());
            if (element2.isVisible()) {
                layoutChild(element2, left2, top2, right2);
            }
        }
        getBounds().set(left, top, right, bottom);
    }

    public final void invoke(Function1<? super VStack, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        function1.invoke(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final android.util.Size measure(java.util.List<? extends com.devexpress.editors.layout.Element> r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.editors.layout.VStack.measure(java.util.List, int, int, int, int):android.util.Size");
    }

    private final void measureChildForUnspecifiedHeight(Element child, int widthSpec, int heightSpec) {
        measureChild(child, widthSpec, this.measureVars.getUsedWidth(), heightSpec, this.measureVars.getUsedHeight());
        this.measureVars.setMaxWidth(Math.max(child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal(), this.measureVars.getMaxWidth()));
        if (child.getHeightRequest().isStar()) {
            this.measureVars.getStarChildren().add(child);
            MeasureVars measureVars = this.measureVars;
            measureVars.setStarSize(Math.max(measureVars.getStarSize(), child.getMeasuredSize().getHeight() / child.getHeightRequest().getValue()));
        } else {
            MeasureVars measureVars2 = this.measureVars;
            measureVars2.setUsedHeight(measureVars2.getUsedHeight() + child.getMeasuredSize().getHeight() + child.getMargin().getVertical());
        }
    }

    private final void measureStarChildForUnspecifiedHeight(Element child, int widthSpec) {
        SizeDefinition heightRequest = child.getHeightRequest();
        child.measure(AbstractContainer.INSTANCE.makeChildMeasureSpec(widthSpec, this.measureVars.getUsedWidth() + child.getMargin().getHorizontal(), child.getWidthRequest()), View.MeasureSpec.makeMeasureSpec(Math.min(Math.max((int) (this.measureVars.getStarSize() * child.getHeightRequest().getValue()), heightRequest.getMinSize()), heightRequest.getMaxSize()), BasicMeasure.EXACTLY));
        this.measureVars.setMaxWidth(Math.max(child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal(), this.measureVars.getMaxWidth()));
        MeasureVars measureVars = this.measureVars;
        measureVars.setUsedHeight(measureVars.getUsedHeight() + child.getMeasuredSize().getHeight() + child.getMargin().getVertical());
    }

    private final void measureChildForKnownHeight(Element child, int widthSpec, int heightSpec) {
        if (!child.getHeightRequest().isStar()) {
            measureChild(child, widthSpec, this.measureVars.getUsedWidth(), heightSpec, this.measureVars.getUsedHeight());
            this.measureVars.setMaxWidth(Math.max(child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal(), this.measureVars.getMaxWidth()));
            MeasureVars measureVars = this.measureVars;
            measureVars.setUsedHeight(measureVars.getUsedHeight() + child.getMeasuredSize().getHeight() + child.getMargin().getVertical());
            return;
        }
        this.measureVars.getStarChildren().add(child);
        MeasureVars measureVars2 = this.measureVars;
        measureVars2.setStarCount(measureVars2.getStarCount() + child.getHeightRequest().getValue());
        MeasureVars measureVars3 = this.measureVars;
        measureVars3.setStartChildrenMarginSize(measureVars3.getStartChildrenMarginSize() + child.getMargin().getVertical());
    }

    private final void measureStarChildForKnownHeight(Element child, int widthSpec, int heightSpec) {
        int max = Math.max((View.MeasureSpec.getSize(heightSpec) - this.measureVars.getUsedHeight()) - this.measureVars.getStartChildrenMarginSize(), 0);
        SizeDefinition heightRequest = child.getHeightRequest();
        child.measure(AbstractContainer.INSTANCE.makeChildMeasureSpec(widthSpec, this.measureVars.getUsedWidth() + child.getMargin().getHorizontal(), child.getWidthRequest()), View.MeasureSpec.makeMeasureSpec(MathUtilsKt.clamp((int) Math.floor((max * heightRequest.getValue()) / this.measureVars.getStarCount()), heightRequest.getMinSize(), heightRequest.getMaxSize()), BasicMeasure.EXACTLY));
        MeasureVars measureVars = this.measureVars;
        measureVars.setStarCount(measureVars.getStarCount() - child.getHeightRequest().getValue());
        MeasureVars measureVars2 = this.measureVars;
        measureVars2.setStartChildrenMarginSize(measureVars2.getStartChildrenMarginSize() - child.getMargin().getVertical());
        MeasureVars measureVars3 = this.measureVars;
        measureVars3.setUsedHeight(measureVars3.getUsedHeight() + child.getMeasuredSize().getHeight() + child.getMargin().getVertical());
        this.measureVars.setMaxWidth(Math.max(child.getMeasuredSize().getWidth() + child.getMargin().getHorizontal(), this.measureVars.getMaxWidth()));
    }

    private final void layoutChild(Element child, int l, int t, int r) {
        int horizontal;
        int i;
        child.getMargin().resolve(getLayoutDirection());
        int absoluteGravity = GravityCompat.getAbsoluteGravity(child.getGravity(), getLayoutDirection()) & 7;
        if (absoluteGravity == 1) {
            Thickness margin = child.getMargin();
            int width = child.getMeasuredSize().getWidth();
            horizontal = l + ((((r - l) - width) - margin.getHorizontal()) / 2) + margin.getLeft();
            i = horizontal + width;
        } else if (absoluteGravity == 3) {
            horizontal = l + child.getMargin().getStart();
            i = child.getMeasuredSize().getWidth() + horizontal;
        } else if (absoluteGravity == 5) {
            i = r - child.getMargin().getEnd();
            horizontal = i - child.getMeasuredSize().getWidth();
        } else {
            horizontal = l + child.getMargin().getLeft();
            i = r - child.getMargin().getRight();
        }
        int top = t + child.getMargin().getTop();
        child.layout(horizontal, top, i, child.getMeasuredSize().getHeight() + top);
    }

    /* compiled from: VStack.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/devexpress/editors/layout/VStack$MeasureVars;", "", "()V", "maxWidth", "", "getMaxWidth", "()I", "setMaxWidth", "(I)V", "starChildren", "", "Lcom/devexpress/editors/layout/Element;", "getStarChildren", "()Ljava/util/List;", "starCount", "", "getStarCount", "()F", "setStarCount", "(F)V", "starSize", "getStarSize", "setStarSize", "startChildrenMarginSize", "getStartChildrenMarginSize", "setStartChildrenMarginSize", "usedHeight", "getUsedHeight", "setUsedHeight", "usedWidth", "getUsedWidth", "setUsedWidth", "reset", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class MeasureVars {
        private int maxWidth;
        private final List<Element> starChildren = new ArrayList();
        private float starCount;
        private float starSize;
        private int startChildrenMarginSize;
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

        public final int getMaxWidth() {
            return this.maxWidth;
        }

        public final void setMaxWidth(int i) {
            this.maxWidth = i;
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

        public final int getStartChildrenMarginSize() {
            return this.startChildrenMarginSize;
        }

        public final void setStartChildrenMarginSize(int i) {
            this.startChildrenMarginSize = i;
        }

        public final List<Element> getStarChildren() {
            return this.starChildren;
        }

        public final void reset() {
            this.usedWidth = 0;
            this.usedHeight = 0;
            this.maxWidth = 0;
            this.starCount = 0.0f;
            this.starSize = 0.0f;
            this.startChildrenMarginSize = 0;
            this.starChildren.clear();
        }
    }
}
