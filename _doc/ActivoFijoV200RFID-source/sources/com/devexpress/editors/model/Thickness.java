package com.devexpress.editors.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tickness.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u0006\u0010$\u001a\u00020\u0000J1\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J&\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J\b\u0010,\u001a\u00020\u0004H\u0016J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0004J\u000e\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u0000J\u000e\u00100\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u00100\u001a\u00020.2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J&\u00100\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J\u0006\u00102\u001a\u00020.J\t\u00103\u001a\u000204HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u001e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0005R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0005R\u0011\u0010\u001e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000f¨\u00066"}, d2 = {"Lcom/devexpress/editors/model/Thickness;", "", "()V", "all", "", "(I)V", "h", "v", "(II)V", "start", "top", "end", "bottom", "(IIII)V", "getBottom", "()I", "setBottom", "getEnd", "setEnd", "horizontal", "getHorizontal", "<set-?>", "left", "getLeft", "right", "getRight", "getStart", "setStart", "getTop", "setTop", "vertical", "getVertical", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "s", "t", "e", "b", "hashCode", "resolve", "", "layoutDirection", "set", "thickness", "setEmpty", "toString", "", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Thickness {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Thickness empty = new Thickness(0);
    private int bottom;
    private int end;
    private int left;
    private int right;
    private int start;
    private int top;

    public static /* synthetic */ Thickness copy$default(Thickness thickness, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = thickness.start;
        }
        if ((i5 & 2) != 0) {
            i2 = thickness.top;
        }
        if ((i5 & 4) != 0) {
            i3 = thickness.end;
        }
        if ((i5 & 8) != 0) {
            i4 = thickness.bottom;
        }
        return thickness.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    public final Thickness copy(int start, int top, int end, int bottom) {
        return new Thickness(start, top, end, bottom);
    }

    public String toString() {
        return "Thickness(start=" + this.start + ", top=" + this.top + ", end=" + this.end + ", bottom=" + this.bottom + ')';
    }

    public Thickness(int i, int i2, int i3, int i4) {
        this.start = i;
        this.top = i2;
        this.end = i3;
        this.bottom = i4;
    }

    public final int getStart() {
        return this.start;
    }

    public final void setStart(int i) {
        this.start = i;
    }

    public final int getTop() {
        return this.top;
    }

    public final void setTop(int i) {
        this.top = i;
    }

    public final int getEnd() {
        return this.end;
    }

    public final void setEnd(int i) {
        this.end = i;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final void setBottom(int i) {
        this.bottom = i;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getHorizontal() {
        return this.start + this.end;
    }

    public final int getVertical() {
        return this.top + this.bottom;
    }

    public Thickness() {
        this(0);
    }

    public Thickness(int i) {
        this(i, i, i, i);
    }

    public Thickness(int i, int i2) {
        this(i, i2, i, i2);
    }

    public final Thickness copy() {
        return new Thickness(this.start, this.top, this.end, this.bottom);
    }

    public final void resolve(int layoutDirection) {
        if (layoutDirection == 1) {
            this.left = this.end;
            this.right = this.start;
        } else {
            this.left = this.start;
            this.right = this.end;
        }
    }

    public final void set(int all) {
        this.start = all;
        this.top = all;
        this.end = all;
        this.bottom = all;
    }

    public final void set(int h, int v) {
        this.start = h;
        this.top = v;
        this.end = h;
        this.bottom = v;
    }

    public final void set(int s, int t, int e, int b) {
        this.start = s;
        this.top = t;
        this.end = e;
        this.bottom = b;
    }

    public final void set(Thickness thickness) {
        Intrinsics.checkNotNullParameter(thickness, "thickness");
        this.start = thickness.start;
        this.top = thickness.top;
        this.end = thickness.end;
        this.bottom = thickness.bottom;
    }

    public final void setEmpty() {
        set(0);
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        Thickness thickness = other instanceof Thickness ? (Thickness) other : null;
        if (thickness == null) {
            return false;
        }
        return equals(thickness.start, thickness.top, thickness.end, thickness.bottom);
    }

    public final boolean equals(int all) {
        return this.start == all && this.top == all && this.end == all && this.bottom == all;
    }

    public final boolean equals(int h, int v) {
        return this.start == h && this.top == v && this.end == h && this.bottom == v;
    }

    public final boolean equals(int s, int t, int e, int b) {
        return this.start == s && this.top == t && this.end == e && this.bottom == b;
    }

    public int hashCode() {
        return (((((this.start * 31) + this.top) * 31) + this.end) * 31) + this.bottom;
    }

    /* compiled from: Tickness.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/model/Thickness$Companion;", "", "()V", "empty", "Lcom/devexpress/editors/model/Thickness;", "getEmpty", "()Lcom/devexpress/editors/model/Thickness;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Thickness getEmpty() {
            return Thickness.empty;
        }
    }
}
