package com.devexpress.editors.dropdown.calculators;

import com.devexpress.editors.dropdown.DXDropdownHorizontalAlignment;
import com.devexpress.editors.dropdown.DXPlacement;
import com.devexpress.editors.dropdown.placement.AlignmentCalculationInfo;
import com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator;
import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeftHorizontalAlignmentCalculator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/dropdown/calculators/LeftHorizontalAlignmentCalculator;", "Lcom/devexpress/editors/dropdown/placement/HorizontalAlignmentCalculator;", "()V", "<set-?>", "Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "actualAlignment", "getActualAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "Lcom/devexpress/editors/dropdown/DXPlacement;", "actualPlacement", "getActualPlacement", "()Lcom/devexpress/editors/dropdown/DXPlacement;", "isContentSizeDependent", "", "()Z", "calcContentFrame", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "currentContentFrame", "info", "Lcom/devexpress/editors/dropdown/placement/AlignmentCalculationInfo;", "recalcContentFrame", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LeftHorizontalAlignmentCalculator implements HorizontalAlignmentCalculator {
    private DXPlacement actualPlacement = DXPlacement.Left;
    private DXDropdownHorizontalAlignment actualAlignment = DXDropdownHorizontalAlignment.Default;

    @Override // com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator
    public boolean isContentSizeDependent() {
        return true;
    }

    @Override // com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator
    public DXPlacement getActualPlacement() {
        return this.actualPlacement;
    }

    @Override // com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator
    public DXDropdownHorizontalAlignment getActualAlignment() {
        return this.actualAlignment;
    }

    @Override // com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator
    public Rectangle calcContentFrame(Rectangle currentContentFrame, AlignmentCalculationInfo info) {
        int right;
        int maxAnchorPoint;
        DXPlacement dXPlacement;
        DXPlacement dXPlacement2;
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();
        if (info.getPlacement() == DXPlacement.Left) {
            right = info.getMinAnchorPoint() - info.getBounds().getLeft();
            maxAnchorPoint = info.getBounds().right() - info.getMaxAnchorPoint();
            rectangle.set(info.getMinAnchorPoint() - info.getContentSize().getWidth(), 0, info.getContentSize().getWidth(), 0);
            rectangle2.set(info.getMinAnchorPoint() - right, 0, right, 0);
            rectangle3.set(info.getMaxAnchorPoint(), 0, info.getContentSize().getWidth(), 0);
            rectangle4.set(info.getMaxAnchorPoint(), 0, maxAnchorPoint, 0);
            dXPlacement = DXPlacement.Left;
            dXPlacement2 = DXPlacement.Right;
        } else {
            right = info.getBounds().right() - info.getMinAnchorPoint();
            maxAnchorPoint = info.getMaxAnchorPoint() - info.getBounds().getLeft();
            rectangle.set(info.getMinAnchorPoint(), 0, info.getContentSize().getWidth(), 0);
            rectangle2.set(info.getMinAnchorPoint(), 0, right, 0);
            rectangle3.set(info.getMaxAnchorPoint() - info.getContentSize().getWidth(), 0, info.getContentSize().getWidth(), 0);
            rectangle4.set(info.getMaxAnchorPoint() - maxAnchorPoint, 0, maxAnchorPoint, 0);
            dXPlacement = DXPlacement.Right;
            dXPlacement2 = DXPlacement.Left;
        }
        if (info.getContentSize().getWidth() <= right) {
            currentContentFrame.setLeft(rectangle.getLeft());
            currentContentFrame.setWidth(rectangle.getWidth());
            this.actualPlacement = dXPlacement;
            this.actualAlignment = DXDropdownHorizontalAlignment.Left;
            return currentContentFrame;
        }
        if (info.getThreshold() > 0 && right > info.getThreshold()) {
            currentContentFrame.setLeft(rectangle2.getLeft());
            currentContentFrame.setWidth(rectangle2.getWidth());
            this.actualPlacement = dXPlacement;
            this.actualAlignment = DXDropdownHorizontalAlignment.Left;
            return currentContentFrame;
        }
        if (info.getContentSize().getWidth() <= maxAnchorPoint) {
            currentContentFrame.setLeft(rectangle3.getLeft());
            currentContentFrame.setWidth(rectangle3.getWidth());
            this.actualPlacement = dXPlacement2;
            this.actualAlignment = DXDropdownHorizontalAlignment.Right;
            return currentContentFrame;
        }
        if (right >= maxAnchorPoint) {
            currentContentFrame.setLeft(rectangle2.getLeft());
            currentContentFrame.setWidth(rectangle2.getWidth());
            this.actualPlacement = dXPlacement;
            this.actualAlignment = DXDropdownHorizontalAlignment.Left;
        } else {
            currentContentFrame.setLeft(rectangle4.getLeft());
            currentContentFrame.setWidth(rectangle4.getWidth());
            this.actualPlacement = dXPlacement2;
            this.actualAlignment = DXDropdownHorizontalAlignment.Right;
        }
        return currentContentFrame;
    }

    @Override // com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator
    public Rectangle recalcContentFrame(Rectangle currentContentFrame, AlignmentCalculationInfo info) {
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getPlacement() == DXPlacement.Left) {
            currentContentFrame.setWidth(Math.min(info.getContentSize().getWidth(), info.getMinAnchorPoint() - info.getBounds().getLeft()));
            currentContentFrame.setLeft(info.getMinAnchorPoint() - currentContentFrame.getWidth());
        } else {
            currentContentFrame.setWidth(Math.min(info.getContentSize().getWidth(), info.getBounds().right() - info.getMinAnchorPoint()));
        }
        return currentContentFrame;
    }
}
