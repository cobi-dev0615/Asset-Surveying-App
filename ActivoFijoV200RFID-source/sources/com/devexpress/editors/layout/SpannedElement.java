package com.devexpress.editors.layout;

import android.graphics.Canvas;
import com.devexpress.editors.layout.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannedElement.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/layout/SpannedElement;", "Lcom/devexpress/editors/layout/Element;", "bottomRowIndex", "", "getBottomRowIndex", "()I", "itemOrderInRow", "getItemOrderInRow", "rowIndex", "getRowIndex", "setRowIndex", "(I)V", "rowOrder", "getRowOrder", "rowSpan", "getRowSpan", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SpannedElement extends Element {
    int getBottomRowIndex();

    int getItemOrderInRow();

    int getRowIndex();

    int getRowOrder();

    int getRowSpan();

    void setRowIndex(int i);

    /* compiled from: SpannedElement.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void draw(SpannedElement spannedElement, Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Element.DefaultImpls.draw(spannedElement, canvas);
        }

        public static int getBottomRowIndex(SpannedElement spannedElement) {
            return Math.max((spannedElement.getRowIndex() + spannedElement.getRowSpan()) - 1, spannedElement.getRowIndex());
        }
    }
}
