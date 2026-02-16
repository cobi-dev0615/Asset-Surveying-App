package com.devexpress.editors.dropdown.placement;

import android.util.Size;
import com.devexpress.editors.dropdown.DXPlacement;
import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlignmentCalculationInfo.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lcom/devexpress/editors/dropdown/placement/AlignmentCalculationInfo;", "", "()V", "bounds", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "getBounds", "()Lcom/devexpress/editors/dropdown/utils/Rectangle;", "setBounds", "(Lcom/devexpress/editors/dropdown/utils/Rectangle;)V", "contentSize", "Landroid/util/Size;", "getContentSize", "()Landroid/util/Size;", "setContentSize", "(Landroid/util/Size;)V", "maxAnchorPoint", "", "getMaxAnchorPoint", "()I", "setMaxAnchorPoint", "(I)V", "minAnchorPoint", "getMinAnchorPoint", "setMinAnchorPoint", "placement", "Lcom/devexpress/editors/dropdown/DXPlacement;", "getPlacement", "()Lcom/devexpress/editors/dropdown/DXPlacement;", "setPlacement", "(Lcom/devexpress/editors/dropdown/DXPlacement;)V", "threshold", "getThreshold", "setThreshold", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AlignmentCalculationInfo {
    private int maxAnchorPoint;
    private int minAnchorPoint;
    private int threshold;
    private Size contentSize = new Size(0, 0);
    private Rectangle bounds = new Rectangle();
    private DXPlacement placement = DXPlacement.Left;

    public final Size getContentSize() {
        return this.contentSize;
    }

    public final void setContentSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.contentSize = size;
    }

    public final Rectangle getBounds() {
        return this.bounds;
    }

    public final void setBounds(Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "<set-?>");
        this.bounds = rectangle;
    }

    public final int getMinAnchorPoint() {
        return this.minAnchorPoint;
    }

    public final void setMinAnchorPoint(int i) {
        this.minAnchorPoint = i;
    }

    public final int getMaxAnchorPoint() {
        return this.maxAnchorPoint;
    }

    public final void setMaxAnchorPoint(int i) {
        this.maxAnchorPoint = i;
    }

    public final DXPlacement getPlacement() {
        return this.placement;
    }

    public final void setPlacement(DXPlacement dXPlacement) {
        Intrinsics.checkNotNullParameter(dXPlacement, "<set-?>");
        this.placement = dXPlacement;
    }

    public final int getThreshold() {
        return this.threshold;
    }

    public final void setThreshold(int i) {
        this.threshold = i;
    }
}
