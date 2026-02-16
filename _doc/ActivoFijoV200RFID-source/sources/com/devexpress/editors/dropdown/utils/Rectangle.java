package com.devexpress.editors.dropdown.utils;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Rectangle.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0002\u0010\tB\u0005¢\u0006\u0002\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0000J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0013\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\u0003H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u001bJ\u0016\u0010(\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0000J&\u0010*\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010,\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020#J\u000e\u0010.\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\u001bJ\u0006\u00103\u001a\u000204J\b\u00105\u001a\u000206H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u00068"}, d2 = {"Lcom/devexpress/editors/dropdown/utils/Rectangle;", "", "left", "", "top", "width", "height", "(IIII)V", "rectangle", "(Lcom/devexpress/editors/dropdown/utils/Rectangle;)V", "()V", "getHeight", "()I", "setHeight", "(I)V", "getLeft", "setLeft", "getTop", "setTop", "getWidth", "setWidth", "bottom", "centerX", "centerY", "contains", "", "r", "Landroid/graphics/Rect;", "x", "y", "right", "equals", "other", "hashCode", "inset", "", "insets", "dx", "dy", "isEmpty", TypedValues.CycleType.S_WAVE_OFFSET, "offsets", "set", "src", "setBottom", "setEmpty", "setRight", "setSize", "size", "Landroid/util/Size;", "toRect", "toRectF", "Landroid/graphics/RectF;", "toString", "", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Rectangle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int height;
    private int left;
    private int top;
    private int width;

    /* compiled from: Rectangle.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/devexpress/editors/dropdown/utils/Rectangle$Companion;", "", "()V", "fromLTRB", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "l", "", "t", "r", "b", "fromRect", "rect", "Landroid/graphics/Rect;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Rectangle fromLTRB(int l, int t, int r, int b) {
            return new Rectangle(l, t, r - l, b - t);
        }

        public final Rectangle fromRect(Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            return new Rectangle(rect.left, rect.top, rect.width(), rect.height());
        }
    }

    public Rectangle() {
    }

    public final int getLeft() {
        return this.left;
    }

    public final void setLeft(int i) {
        this.left = i;
    }

    public final int getTop() {
        return this.top;
    }

    public final void setTop(int i) {
        this.top = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public Rectangle(int i, int i2, int i3, int i4) {
        this();
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rectangle(Rectangle rectangle) {
        this(rectangle.left, rectangle.top, rectangle.width, rectangle.height);
        Intrinsics.checkNotNullParameter(rectangle, "rectangle");
    }

    public final int right() {
        return this.left + this.width;
    }

    public final int bottom() {
        return this.top + this.height;
    }

    public final void set(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public final void set(Rectangle src) {
        Intrinsics.checkNotNullParameter(src, "src");
        this.left = src.left;
        this.top = src.top;
        this.width = src.width;
        this.height = src.height;
    }

    public final void setSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.width = size.getWidth();
        this.height = size.getHeight();
    }

    public final void setRight(int right) {
        this.width = right - this.left;
    }

    public final void setBottom(int bottom) {
        this.height = bottom - this.top;
    }

    public final boolean isEmpty() {
        return this.width <= 0 || this.height <= 0;
    }

    public final void setEmpty() {
        this.left = 0;
        this.top = 0;
        this.width = 0;
        this.height = 0;
    }

    public final int centerX() {
        return (this.left + right()) >> 1;
    }

    public final int centerY() {
        return (this.top + bottom()) >> 1;
    }

    public final void offset(int dx, int dy) {
        this.left += dx;
        this.top += dy;
        this.width += dx * 2;
        this.height += dy * 2;
    }

    public final void offset(Rect offsets) {
        Intrinsics.checkNotNullParameter(offsets, "offsets");
        this.left -= offsets.left;
        this.top -= offsets.top;
        this.width += offsets.right + offsets.left;
        this.height += offsets.bottom + offsets.top;
    }

    public final void inset(int dx, int dy) {
        this.left += dx;
        this.top += dy;
        this.width = Math.max(this.width - (dx * 2), 0);
        this.height = Math.max(this.height - (dy * 2), 0);
    }

    public final void inset(Rect insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        this.left += insets.left;
        this.top += insets.top;
        this.width = Math.max(this.width - (insets.right + insets.left), 0);
        this.height = Math.max(this.height - (insets.bottom + insets.top), 0);
    }

    public final boolean contains(int x, int y) {
        return !isEmpty() && x >= this.left && x < right() && y >= this.top && y < bottom();
    }

    public final boolean contains(int left, int top, int right, int bottom) {
        return !isEmpty() && this.left <= left && this.top <= top && right() >= right && bottom() >= bottom;
    }

    public final boolean contains(Rect r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return !isEmpty() && this.left <= r.left && this.top <= r.top && right() >= r.right && bottom() >= r.bottom;
    }

    public final boolean contains(Rectangle r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return !isEmpty() && this.left <= r.left && this.top <= r.top && right() >= r.right() && bottom() >= r.bottom();
    }

    public final Rect toRect() {
        return new Rect(this.left, this.top, right(), bottom());
    }

    public final RectF toRectF() {
        return new RectF(this.left, this.top, right(), bottom());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        Rectangle rectangle = (Rectangle) other;
        return this.left == rectangle.left && this.top == rectangle.top && this.width == rectangle.width && this.height == rectangle.height;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Rectangle(");
        sb.append(this.left);
        sb.append(", ");
        sb.append(this.top);
        sb.append(" - ");
        sb.append(right());
        sb.append(", ");
        sb.append(bottom());
        sb.append("; W: ");
        sb.append(this.width);
        sb.append(", H: ");
        sb.append(this.height);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
