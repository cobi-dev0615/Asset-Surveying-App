package com.devexpress.editors.layout2;

import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextSizeInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/devexpress/editors/layout2/TextSizeInfo;", "", "size", "Landroid/util/Size;", "textTopMargin", "", "textBottomMargin", "(Landroid/util/Size;II)V", "getSize", "()Landroid/util/Size;", "getTextBottomMargin", "()I", "getTextTopMargin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "sizeWithMargins", "toString", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TextSizeInfo {
    private final Size size;
    private final int textBottomMargin;
    private final int textTopMargin;

    public static /* synthetic */ TextSizeInfo copy$default(TextSizeInfo textSizeInfo, Size size, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            size = textSizeInfo.size;
        }
        if ((i3 & 2) != 0) {
            i = textSizeInfo.textTopMargin;
        }
        if ((i3 & 4) != 0) {
            i2 = textSizeInfo.textBottomMargin;
        }
        return textSizeInfo.copy(size, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTextTopMargin() {
        return this.textTopMargin;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTextBottomMargin() {
        return this.textBottomMargin;
    }

    public final TextSizeInfo copy(Size size, int textTopMargin, int textBottomMargin) {
        Intrinsics.checkNotNullParameter(size, "size");
        return new TextSizeInfo(size, textTopMargin, textBottomMargin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextSizeInfo)) {
            return false;
        }
        TextSizeInfo textSizeInfo = (TextSizeInfo) other;
        return Intrinsics.areEqual(this.size, textSizeInfo.size) && this.textTopMargin == textSizeInfo.textTopMargin && this.textBottomMargin == textSizeInfo.textBottomMargin;
    }

    public int hashCode() {
        return (((this.size.hashCode() * 31) + this.textTopMargin) * 31) + this.textBottomMargin;
    }

    public String toString() {
        return "TextSizeInfo(size=" + this.size + ", textTopMargin=" + this.textTopMargin + ", textBottomMargin=" + this.textBottomMargin + ')';
    }

    public TextSizeInfo(Size size, int i, int i2) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.size = size;
        this.textTopMargin = i;
        this.textBottomMargin = i2;
    }

    public final Size getSize() {
        return this.size;
    }

    public final int getTextBottomMargin() {
        return this.textBottomMargin;
    }

    public final int getTextTopMargin() {
        return this.textTopMargin;
    }

    public final Size sizeWithMargins() {
        return new Size(this.size.getWidth(), this.size.getHeight() + this.textTopMargin + this.textBottomMargin);
    }
}
