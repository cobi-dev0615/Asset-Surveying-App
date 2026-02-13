package com.devexpress.editors.layout;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.exifinterface.media.ExifInterface;
import com.devexpress.editors.layout.Container;
import com.devexpress.editors.model.Thickness;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractContainer.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 ]2\u00020\u0001:\u0001]B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0006H\u0016J!\u0010G\u001a\u00020E2\u0012\u0010H\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060I\"\u00020\u0006H\u0016¢\u0006\u0002\u0010JJ\u0016\u0010G\u001a\u00020E2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060KH\u0016J\u0010\u0010L\u001a\u00020E2\u0006\u0010M\u001a\u00020NH\u0016J\u0018\u0010O\u001a\u00020E2\u0006\u0010P\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u0006H\u0016J0\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0014J\b\u0010W\u001a\u00020EH\u0016J\u0010\u0010X\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0006H\u0016J\u0010\u0010Y\u001a\u00020E2\u0006\u0010P\u001a\u00020\bH\u0016J\u001c\u0010Z\u001a\u0002H[\"\b\b\u0000\u0010[*\u00020\u0006*\u0002H[H\u0086\u0002¢\u0006\u0002\u0010\\R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020+8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u000b\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010!R\u001a\u00103\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010:\u001a\u0002092\u0006\u00108\u001a\u000209@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\u001a\u0010A\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'¨\u0006^"}, d2 = {"Lcom/devexpress/editors/layout/AbstractContainer;", "Lcom/devexpress/editors/layout/Container;", "id", "", "children", "", "Lcom/devexpress/editors/layout/Element;", "gravity", "", "padding", "Lcom/devexpress/editors/model/Thickness;", "layoutDirection", "(Ljava/lang/String;Ljava/util/List;ILcom/devexpress/editors/model/Thickness;I)V", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "baseline", "getBaseline", "()I", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "getChildren", "()Ljava/util/List;", "childrenInternal", "", "getChildrenInternal", "getGravity", "setGravity", "(I)V", "heightRequest", "Lcom/devexpress/editors/layout/SizeDefinition;", "getHeightRequest", "()Lcom/devexpress/editors/layout/SizeDefinition;", "setHeightRequest", "(Lcom/devexpress/editors/layout/SizeDefinition;)V", "getId", "()Ljava/lang/String;", "isContainerVisible", "", "v", "isVisible", "()Z", "setVisible", "(Z)V", "getLayoutDirection", "setLayoutDirection", "margin", "getMargin", "()Lcom/devexpress/editors/model/Thickness;", "setMargin", "(Lcom/devexpress/editors/model/Thickness;)V", "<set-?>", "Landroid/util/Size;", "measuredSize", "getMeasuredSize", "()Landroid/util/Size;", "setMeasuredSize", "(Landroid/util/Size;)V", "getPadding", "setPadding", "widthRequest", "getWidthRequest", "setWidthRequest", "addChild", "", "element", "addChildren", "elements", "", "([Lcom/devexpress/editors/layout/Element;)V", "", "draw", "canvas", "Landroid/graphics/Canvas;", "insertChild", "index", "measureChild", "child", "widthSpec", "usedWidth", "heightSpec", "usedHeight", "removeAllChildren", "removeChild", "removeChildAt", "unaryPlus", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/devexpress/editors/layout/Element;)Lcom/devexpress/editors/layout/Element;", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractContainer implements Container {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Drawable backgroundDrawable;
    private final Rect bounds;
    private final List<Element> childrenInternal;
    private int gravity;
    private SizeDefinition heightRequest;
    private final String id;
    private boolean isContainerVisible;
    private int layoutDirection;
    private Thickness margin;
    private Size measuredSize;
    private Thickness padding;
    private SizeDefinition widthRequest;

    @JvmStatic
    public static final int makeChildMeasureSpec(int i, int i2, SizeDefinition sizeDefinition) {
        return INSTANCE.makeChildMeasureSpec(i, i2, sizeDefinition);
    }

    public AbstractContainer(String id, List<? extends Element> list, int i, Thickness padding, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.id = id;
        this.gravity = i;
        this.padding = padding;
        this.layoutDirection = i2;
        ArrayList arrayList = new ArrayList();
        this.childrenInternal = arrayList;
        this.bounds = new Rect();
        this.isContainerVisible = true;
        this.margin = new Thickness(0);
        this.widthRequest = SizeDefinition.INSTANCE.getAuto();
        this.heightRequest = SizeDefinition.INSTANCE.getAuto();
        this.measuredSize = new Size(0, 0);
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public /* synthetic */ AbstractContainer(String str, List list, int i, Thickness thickness, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : list, i, thickness, (i3 & 16) != 0 ? 0 : i2);
    }

    @Override // com.devexpress.editors.layout.Element
    public String getId() {
        return this.id;
    }

    @Override // com.devexpress.editors.layout.Element
    public int getGravity() {
        return this.gravity;
    }

    @Override // com.devexpress.editors.layout.Element
    public void setGravity(int i) {
        this.gravity = i;
    }

    @Override // com.devexpress.editors.layout.Element
    public Thickness getPadding() {
        return this.padding;
    }

    public void setPadding(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.padding = thickness;
    }

    @Override // com.devexpress.editors.layout.Container
    public int getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // com.devexpress.editors.layout.Container
    public void setLayoutDirection(int i) {
        this.layoutDirection = i;
    }

    protected final List<Element> getChildrenInternal() {
        return this.childrenInternal;
    }

    @Override // com.devexpress.editors.layout.Element
    public Rect getBounds() {
        return this.bounds;
    }

    @Override // com.devexpress.editors.layout.Container
    public List<Element> getChildren() {
        return this.childrenInternal;
    }

    @Override // com.devexpress.editors.layout.Element
    public Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @Override // com.devexpress.editors.layout.Element
    public void setBackgroundDrawable(Drawable drawable) {
        this.backgroundDrawable = drawable;
    }

    @Override // com.devexpress.editors.layout.Element
    public Thickness getMargin() {
        return this.margin;
    }

    public void setMargin(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "<set-?>");
        this.margin = thickness;
    }

    @Override // com.devexpress.editors.layout.Element
    public SizeDefinition getWidthRequest() {
        return this.widthRequest;
    }

    public void setWidthRequest(SizeDefinition sizeDefinition) {
        Intrinsics.checkNotNullParameter(sizeDefinition, "<set-?>");
        this.widthRequest = sizeDefinition;
    }

    @Override // com.devexpress.editors.layout.Element
    public SizeDefinition getHeightRequest() {
        return this.heightRequest;
    }

    public void setHeightRequest(SizeDefinition sizeDefinition) {
        Intrinsics.checkNotNullParameter(sizeDefinition, "<set-?>");
        this.heightRequest = sizeDefinition;
    }

    @Override // com.devexpress.editors.layout.Element
    public boolean isVisible() {
        if (this.isContainerVisible) {
            List<Element> children = getChildren();
            if (!(children instanceof Collection) || !children.isEmpty()) {
                Iterator<T> it = children.iterator();
                while (it.hasNext()) {
                    if (((Element) it.next()).isVisible()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.devexpress.editors.layout.Element
    public void setVisible(boolean z) {
        this.isContainerVisible = z;
    }

    @Override // com.devexpress.editors.layout.Element
    public int getBaseline() {
        return getPadding().getTop() + (getMeasuredSize().getHeight() / 2);
    }

    @Override // com.devexpress.editors.layout.Element
    public Size getMeasuredSize() {
        return this.measuredSize;
    }

    protected void setMeasuredSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.measuredSize = size;
    }

    @Override // com.devexpress.editors.layout.Container
    public void addChild(Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.childrenInternal.add(element);
    }

    @Override // com.devexpress.editors.layout.Container
    public void addChildren(Element... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.addAll(this.childrenInternal, elements);
    }

    @Override // com.devexpress.editors.layout.Container
    public void addChildren(Iterable<? extends Element> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.addAll(this.childrenInternal, elements);
    }

    @Override // com.devexpress.editors.layout.Container
    public void insertChild(int index, Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.childrenInternal.add(index, element);
    }

    @Override // com.devexpress.editors.layout.Container
    public void removeChild(Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.childrenInternal.remove(element);
    }

    @Override // com.devexpress.editors.layout.Container
    public void removeChildAt(int index) {
        this.childrenInternal.remove(index);
    }

    @Override // com.devexpress.editors.layout.Container
    public void removeAllChildren() {
        this.childrenInternal.clear();
    }

    @Override // com.devexpress.editors.layout.Element
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Container.DefaultImpls.draw(this, canvas);
        Iterator<Element> it = getChildren().iterator();
        while (it.hasNext()) {
            it.next().draw(canvas);
        }
    }

    protected void measureChild(Element child, int widthSpec, int usedWidth, int heightSpec, int usedHeight) {
        Intrinsics.checkNotNullParameter(child, "child");
        int horizontal = usedWidth + child.getMargin().getHorizontal();
        int vertical = usedHeight + child.getMargin().getVertical();
        Companion companion = INSTANCE;
        child.measure(companion.makeChildMeasureSpec(widthSpec, horizontal, child.getWidthRequest()), companion.makeChildMeasureSpec(heightSpec, vertical, child.getHeightRequest()));
    }

    public final <T extends Element> T unaryPlus(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        this.childrenInternal.add(t);
        return t;
    }

    /* compiled from: AbstractContainer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/layout/AbstractContainer$Companion;", "", "()V", "makeChildMeasureSpec", "", "spec", "padding", "sizeRequest", "Lcom/devexpress/editors/layout/SizeDefinition;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int makeChildMeasureSpec(int spec, int padding, SizeDefinition sizeRequest) {
            float value;
            Intrinsics.checkNotNullParameter(sizeRequest, "sizeRequest");
            int mode = View.MeasureSpec.getMode(spec);
            int size = View.MeasureSpec.getSize(spec) - padding;
            int i = 0;
            int min = Math.min(Math.max(0, size), sizeRequest.getMaxSize());
            int unit = sizeRequest.getUnit();
            int i2 = BasicMeasure.EXACTLY;
            if (mode == Integer.MIN_VALUE) {
                if (unit != 0) {
                    if (unit != 1) {
                        if (unit == 2) {
                            value = min / sizeRequest.getValue();
                        }
                        i2 = 0;
                    }
                    i = min;
                    i2 = Integer.MIN_VALUE;
                } else {
                    value = sizeRequest.getValue();
                }
                i = (int) value;
            } else if (mode != 0) {
                if (mode == 1073741824) {
                    if (unit != 0) {
                        if (unit != 1) {
                            if (unit == 2) {
                                min = (int) (min / sizeRequest.getValue());
                                i = min;
                            }
                        }
                        i = min;
                        i2 = Integer.MIN_VALUE;
                    } else {
                        value = sizeRequest.getValue();
                        i = (int) value;
                    }
                }
                i2 = 0;
            } else if (unit != 0) {
                if (unit == 1 || unit == 2) {
                    i2 = 0;
                    i = min;
                }
                i2 = 0;
            } else {
                value = sizeRequest.getValue();
                i = (int) value;
            }
            return View.MeasureSpec.makeMeasureSpec(i, i2);
        }
    }
}
