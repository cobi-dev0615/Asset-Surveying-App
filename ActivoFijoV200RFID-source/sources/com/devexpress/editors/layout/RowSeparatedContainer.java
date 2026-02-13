package com.devexpress.editors.layout;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.devexpress.editors.layout.Container;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowSeparatedContainer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u0004\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/layout/RowSeparatedContainer;", "Lcom/devexpress/editors/layout/Container;", "isLastRow", "", "()Z", "setLastRow", "(Z)V", "isLastRowSeparatorVisible", "setLastRowSeparatorVisible", "separatorDrawable", "Landroid/graphics/drawable/Drawable;", "getSeparatorDrawable", "()Landroid/graphics/drawable/Drawable;", "setSeparatorDrawable", "(Landroid/graphics/drawable/Drawable;)V", "separatorHeight", "", "getSeparatorHeight", "()I", "setSeparatorHeight", "(I)V", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RowSeparatedContainer extends Container {
    Drawable getSeparatorDrawable();

    int getSeparatorHeight();

    boolean isLastRow();

    boolean isLastRowSeparatorVisible();

    void setLastRow(boolean z);

    void setLastRowSeparatorVisible(boolean z);

    void setSeparatorDrawable(Drawable drawable);

    void setSeparatorHeight(int i);

    /* compiled from: RowSeparatedContainer.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void draw(RowSeparatedContainer rowSeparatedContainer, Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Container.DefaultImpls.draw(rowSeparatedContainer, canvas);
        }
    }
}
