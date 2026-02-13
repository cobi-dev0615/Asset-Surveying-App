package com.devexpress.editors.layout;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.View;
import com.devexpress.editors.layout.Element;
import com.devexpress.editors.model.Thickness;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewHolder.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B9\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ(\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0019H\u0016J\u0018\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0019H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R$\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)¨\u0006E"}, d2 = {"Lcom/devexpress/editors/layout/ViewHolder;", "Lcom/devexpress/editors/layout/Element;", "item", "(Lcom/devexpress/editors/layout/ViewHolder;)V", "id", "", "view", "Landroid/view/View;", "padding", "Lcom/devexpress/editors/model/Thickness;", "margin", "applyMarginForZeroSize", "", "(Ljava/lang/String;Landroid/view/View;Lcom/devexpress/editors/model/Thickness;Lcom/devexpress/editors/model/Thickness;Z)V", "getApplyMarginForZeroSize", "()Z", "setApplyMarginForZeroSize", "(Z)V", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "baseline", "", "getBaseline", "()I", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "gravity", "getGravity", "setGravity", "(I)V", "heightRequest", "Lcom/devexpress/editors/layout/SizeDefinition;", "getHeightRequest", "()Lcom/devexpress/editors/layout/SizeDefinition;", "setHeightRequest", "(Lcom/devexpress/editors/layout/SizeDefinition;)V", "getId", "()Ljava/lang/String;", "innerMeasuredSize", "Landroid/util/Size;", "value", "isVisible", "setVisible", "getMargin", "()Lcom/devexpress/editors/model/Thickness;", "measuredSize", "getMeasuredSize", "()Landroid/util/Size;", "getPadding", "getView", "()Landroid/view/View;", "widthRequest", "getWidthRequest", "setWidthRequest", "layout", "", "left", "top", "right", "bottom", "measure", "widthSpec", "heightSpec", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ViewHolder implements Element {
    private boolean applyMarginForZeroSize;
    private Drawable backgroundDrawable;
    private final Rect bounds;
    private int gravity;
    private SizeDefinition heightRequest;
    private final String id;
    private Size innerMeasuredSize;
    private final Thickness margin;
    private final Thickness padding;
    private final View view;
    private SizeDefinition widthRequest;

    public ViewHolder(String id, View view, Thickness thickness, Thickness thickness2, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(view, "view");
        this.id = id;
        this.view = view;
        this.applyMarginForZeroSize = z;
        this.widthRequest = SizeDefinition.INSTANCE.getAuto();
        this.heightRequest = SizeDefinition.INSTANCE.getAuto();
        this.gravity = 8388627;
        this.bounds = new Rect();
        this.padding = thickness == null ? new Thickness(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom()) : thickness;
        this.margin = thickness2 == null ? new Thickness() : thickness2;
    }

    @Override // com.devexpress.editors.layout.Element
    public void draw(Canvas canvas) {
        Element.DefaultImpls.draw(this, canvas);
    }

    public /* synthetic */ ViewHolder(String str, View view, Thickness thickness, Thickness thickness2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, view, (i & 4) != 0 ? null : thickness, (i & 8) != 0 ? null : thickness2, (i & 16) != 0 ? true : z);
    }

    @Override // com.devexpress.editors.layout.Element
    public String getId() {
        return this.id;
    }

    public final View getView() {
        return this.view;
    }

    public final boolean getApplyMarginForZeroSize() {
        return this.applyMarginForZeroSize;
    }

    public final void setApplyMarginForZeroSize(boolean z) {
        this.applyMarginForZeroSize = z;
    }

    @Override // com.devexpress.editors.layout.Element
    public final SizeDefinition getWidthRequest() {
        return this.widthRequest;
    }

    public final void setWidthRequest(SizeDefinition sizeDefinition) {
        Intrinsics.checkNotNullParameter(sizeDefinition, "<set-?>");
        this.widthRequest = sizeDefinition;
    }

    @Override // com.devexpress.editors.layout.Element
    public final SizeDefinition getHeightRequest() {
        return this.heightRequest;
    }

    public final void setHeightRequest(SizeDefinition sizeDefinition) {
        Intrinsics.checkNotNullParameter(sizeDefinition, "<set-?>");
        this.heightRequest = sizeDefinition;
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
    public Rect getBounds() {
        return this.bounds;
    }

    @Override // com.devexpress.editors.layout.Element
    public Thickness getPadding() {
        return this.padding;
    }

    @Override // com.devexpress.editors.layout.Element
    public Thickness getMargin() {
        return this.margin;
    }

    @Override // com.devexpress.editors.layout.Element
    public Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @Override // com.devexpress.editors.layout.Element
    public void setBackgroundDrawable(Drawable drawable) {
        this.backgroundDrawable = drawable;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    protected ViewHolder(ViewHolder item) {
        this(item.getId(), item.view, item.getPadding(), item.getMargin(), item.applyMarginForZeroSize);
        Intrinsics.checkNotNullParameter(item, "item");
        setGravity(item.getGravity());
        this.widthRequest = item.widthRequest;
        this.heightRequest = item.heightRequest;
    }

    @Override // com.devexpress.editors.layout.Element
    public boolean isVisible() {
        return this.view.getVisibility() != 8;
    }

    @Override // com.devexpress.editors.layout.Element
    public void setVisible(boolean z) {
        this.view.setVisibility(z ? 0 : 8);
    }

    @Override // com.devexpress.editors.layout.Element
    public int getBaseline() {
        return this.view.getBaseline();
    }

    @Override // com.devexpress.editors.layout.Element
    public Size getMeasuredSize() {
        if (!isVisible()) {
            return new Size(0, 0);
        }
        Size size = this.innerMeasuredSize;
        if (size != null) {
            return size;
        }
        Intrinsics.throwUninitializedPropertyAccessException("innerMeasuredSize");
        return null;
    }

    @Override // com.devexpress.editors.layout.Element
    public void measure(int widthSpec, int heightSpec) {
        this.view.setPaddingRelative(getPadding().getStart(), getPadding().getTop(), getPadding().getEnd(), getPadding().getBottom());
        this.view.setMinimumWidth(this.widthRequest.getMinSize());
        this.view.setMinimumHeight(this.heightRequest.getMinSize());
        this.view.measure(widthSpec, heightSpec);
        this.innerMeasuredSize = new Size(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
    }

    @Override // com.devexpress.editors.layout.Element
    public void layout(int left, int top, int right, int bottom) {
        getBounds().set(left, top, right, bottom);
        this.view.layout(left, top, right, bottom);
    }
}
