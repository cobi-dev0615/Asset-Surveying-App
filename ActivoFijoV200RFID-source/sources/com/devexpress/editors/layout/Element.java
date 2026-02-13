package com.devexpress.editors.layout;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Size;
import com.devexpress.editors.model.Thickness;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Interfaces.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0017J(\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH&J\u0018\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001dX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010$R\u0012\u0010+\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0017¨\u00069"}, d2 = {"Lcom/devexpress/editors/layout/Element;", "", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "baseline", "", "getBaseline", "()I", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "gravity", "getGravity", "setGravity", "(I)V", "heightRequest", "Lcom/devexpress/editors/layout/SizeDefinition;", "getHeightRequest", "()Lcom/devexpress/editors/layout/SizeDefinition;", "id", "", "getId", "()Ljava/lang/String;", "isVisible", "", "()Z", "setVisible", "(Z)V", "margin", "Lcom/devexpress/editors/model/Thickness;", "getMargin", "()Lcom/devexpress/editors/model/Thickness;", "measuredSize", "Landroid/util/Size;", "getMeasuredSize", "()Landroid/util/Size;", "padding", "getPadding", "widthRequest", "getWidthRequest", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "left", "top", "right", "bottom", "measure", "widthSpec", "heightSpec", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Element {
    void draw(Canvas canvas);

    Drawable getBackgroundDrawable();

    int getBaseline();

    Rect getBounds();

    int getGravity();

    SizeDefinition getHeightRequest();

    String getId();

    Thickness getMargin();

    Size getMeasuredSize();

    Thickness getPadding();

    SizeDefinition getWidthRequest();

    boolean isVisible();

    void layout(int left, int top, int right, int bottom);

    void measure(int widthSpec, int heightSpec);

    void setBackgroundDrawable(Drawable drawable);

    void setGravity(int i);

    void setVisible(boolean z);

    /* compiled from: Interfaces.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void draw(Element element, Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Drawable backgroundDrawable = element.getBackgroundDrawable();
            if (backgroundDrawable == null) {
                return;
            }
            backgroundDrawable.getBounds().set(element.getBounds());
            backgroundDrawable.draw(canvas);
        }
    }
}
