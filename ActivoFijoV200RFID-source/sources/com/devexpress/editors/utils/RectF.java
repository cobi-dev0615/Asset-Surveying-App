package com.devexpress.editors.utils;

import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RectF.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000J\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/devexpress/editors/utils/RectF;", "", "()V", "height", "", "getHeight", "()F", "setHeight", "(F)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "flipHorizontal", "", "relative", "flipVertical", "rotateLeft", "rotateRight", "toInt", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RectF {
    private float height;
    private float width;
    private float x;
    private float y;

    public final float getX() {
        return this.x;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float f) {
        this.y = f;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setWidth(float f) {
        this.width = f;
    }

    public final float getHeight() {
        return this.height;
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public final Rectangle toInt() {
        return new Rectangle((int) this.x, (int) this.y, (int) this.width, (int) this.height);
    }

    public final void rotateLeft(RectF relative) {
        Intrinsics.checkNotNullParameter(relative, "relative");
        float f = this.height;
        float f2 = this.width;
        float f3 = 2;
        float f4 = relative.x + (relative.width / f3);
        float f5 = relative.y + (relative.height / f3);
        float f6 = (f4 - f5) + this.y;
        float f7 = (f4 + f5) - (this.x + f2);
        this.x = f6;
        this.y = f7;
        this.width = f;
        this.height = f2;
    }

    public final void rotateRight(RectF relative) {
        Intrinsics.checkNotNullParameter(relative, "relative");
        float f = this.height;
        float f2 = this.width;
        float f3 = 2;
        float f4 = relative.x + (relative.width / f3);
        float f5 = relative.y + (relative.height / f3);
        float f6 = (f4 + f5) - (this.y + f);
        float f7 = (-f4) + f5 + this.x;
        this.x = f6;
        this.y = f7;
        this.width = f;
        this.height = f2;
    }

    public final void flipVertical(RectF relative) {
        Intrinsics.checkNotNullParameter(relative, "relative");
        float f = relative.x;
        float f2 = relative.width;
        float f3 = 2;
        float f4 = this.x;
        float f5 = ((f2 / f3) + f) - f4;
        float f6 = (this.width + f4) - (f + (f2 / f3));
        if (f5 < f6) {
            this.x = f4 - (f6 - f5);
        } else {
            this.x = f4 + (f5 - f6);
        }
    }

    public final void flipHorizontal(RectF relative) {
        Intrinsics.checkNotNullParameter(relative, "relative");
        float f = relative.y;
        float f2 = relative.height;
        float f3 = 2;
        float f4 = this.y;
        float f5 = ((f2 / f3) + f) - f4;
        float f6 = (this.height + f4) - (f + (f2 / f3));
        if (f5 < f6) {
            this.y = f4 - (f6 - f5);
        } else {
            this.y = f4 + (f5 - f6);
        }
    }
}
