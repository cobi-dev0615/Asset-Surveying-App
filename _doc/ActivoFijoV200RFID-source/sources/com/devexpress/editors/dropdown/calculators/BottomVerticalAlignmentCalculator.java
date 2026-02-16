package com.devexpress.editors.dropdown.calculators;

import com.devexpress.editors.dropdown.DXDropdownVerticalAlignment;
import com.devexpress.editors.dropdown.DXPlacement;
import com.devexpress.editors.dropdown.placement.AlignmentCalculationInfo;
import com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator;
import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomVerticalAlignmentCalculator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/dropdown/calculators/BottomVerticalAlignmentCalculator;", "Lcom/devexpress/editors/dropdown/placement/VerticalAlignmentCalculator;", "()V", "<set-?>", "Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "actualAlignment", "getActualAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "Lcom/devexpress/editors/dropdown/DXPlacement;", "actualPlacement", "getActualPlacement", "()Lcom/devexpress/editors/dropdown/DXPlacement;", "isContentSizeDependent", "", "()Z", "calcContentFrame", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "currentContentFrame", "info", "Lcom/devexpress/editors/dropdown/placement/AlignmentCalculationInfo;", "recalcContentFrame", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomVerticalAlignmentCalculator implements VerticalAlignmentCalculator {
    private DXPlacement actualPlacement = DXPlacement.Left;
    private DXDropdownVerticalAlignment actualAlignment = DXDropdownVerticalAlignment.Default;

    @Override // com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator
    public boolean isContentSizeDependent() {
        return true;
    }

    @Override // com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator
    public DXPlacement getActualPlacement() {
        return this.actualPlacement;
    }

    @Override // com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator
    public DXDropdownVerticalAlignment getActualAlignment() {
        return this.actualAlignment;
    }

    @Override // com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator
    public Rectangle calcContentFrame(Rectangle currentContentFrame, AlignmentCalculationInfo info) {
        int maxAnchorPoint;
        int bottom;
        DXPlacement dXPlacement;
        DXPlacement dXPlacement2;
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();
        if (info.getPlacement() == DXPlacement.Bottom) {
            maxAnchorPoint = info.getBounds().bottom() - info.getMaxAnchorPoint();
            bottom = info.getMinAnchorPoint() - info.getBounds().getTop();
            rectangle.set(0, info.getMaxAnchorPoint(), 0, info.getContentSize().getHeight());
            rectangle2.set(0, info.getMaxAnchorPoint(), 0, maxAnchorPoint);
            rectangle3.set(0, info.getMinAnchorPoint() - info.getContentSize().getHeight(), 0, info.getContentSize().getHeight());
            rectangle4.set(0, info.getMinAnchorPoint() - bottom, 0, bottom);
            dXPlacement = DXPlacement.Bottom;
            dXPlacement2 = DXPlacement.Top;
        } else {
            maxAnchorPoint = info.getMaxAnchorPoint() - info.getBounds().getTop();
            bottom = info.getBounds().bottom() - info.getMinAnchorPoint();
            rectangle.set(0, info.getMaxAnchorPoint() - info.getContentSize().getHeight(), 0, info.getContentSize().getHeight());
            rectangle2.set(0, info.getMaxAnchorPoint() - maxAnchorPoint, 0, maxAnchorPoint);
            rectangle3.set(0, info.getMinAnchorPoint(), 0, info.getContentSize().getHeight());
            rectangle4.set(0, info.getMinAnchorPoint(), 0, bottom);
            dXPlacement = DXPlacement.Top;
            dXPlacement2 = DXPlacement.Bottom;
        }
        if (info.getContentSize().getHeight() <= maxAnchorPoint) {
            currentContentFrame.setTop(rectangle.getTop());
            currentContentFrame.setHeight(rectangle.getHeight());
            this.actualPlacement = dXPlacement;
            this.actualAlignment = DXDropdownVerticalAlignment.Bottom;
            return currentContentFrame;
        }
        if (info.getThreshold() > 0 && maxAnchorPoint > info.getThreshold()) {
            currentContentFrame.setTop(rectangle2.getTop());
            currentContentFrame.setHeight(rectangle2.getHeight());
            this.actualPlacement = dXPlacement;
            this.actualAlignment = DXDropdownVerticalAlignment.Bottom;
            return currentContentFrame;
        }
        if (info.getContentSize().getHeight() <= bottom) {
            currentContentFrame.setTop(rectangle3.getTop());
            currentContentFrame.setHeight(rectangle3.getHeight());
            this.actualPlacement = dXPlacement2;
            this.actualAlignment = DXDropdownVerticalAlignment.Top;
            return currentContentFrame;
        }
        if (maxAnchorPoint >= bottom) {
            currentContentFrame.setTop(rectangle2.getTop());
            currentContentFrame.setHeight(rectangle2.getHeight());
            this.actualPlacement = dXPlacement;
            this.actualAlignment = DXDropdownVerticalAlignment.Bottom;
        } else {
            currentContentFrame.setTop(rectangle4.getTop());
            currentContentFrame.setHeight(rectangle4.getHeight());
            this.actualPlacement = dXPlacement2;
            this.actualAlignment = DXDropdownVerticalAlignment.Top;
        }
        return currentContentFrame;
    }

    @Override // com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator
    public Rectangle recalcContentFrame(Rectangle currentContentFrame, AlignmentCalculationInfo info) {
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getPlacement() == DXPlacement.Bottom) {
            currentContentFrame.setHeight(Math.min(info.getContentSize().getHeight(), info.getBounds().bottom() - currentContentFrame.getTop()));
        } else {
            currentContentFrame.setHeight(Math.min(info.getContentSize().getHeight(), info.getMaxAnchorPoint() - info.getBounds().getTop()));
            currentContentFrame.setTop(info.getMaxAnchorPoint() - currentContentFrame.getHeight());
        }
        return currentContentFrame;
    }
}
