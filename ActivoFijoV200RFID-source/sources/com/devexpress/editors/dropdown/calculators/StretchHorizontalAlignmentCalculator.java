package com.devexpress.editors.dropdown.calculators;

import com.devexpress.editors.dropdown.DXDropdownHorizontalAlignment;
import com.devexpress.editors.dropdown.DXPlacement;
import com.devexpress.editors.dropdown.placement.AlignmentCalculationInfo;
import com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator;
import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StretchHorizontalAlignmentCalculator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/dropdown/calculators/StretchHorizontalAlignmentCalculator;", "Lcom/devexpress/editors/dropdown/placement/HorizontalAlignmentCalculator;", "()V", "actualAlignment", "Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "getActualAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "<set-?>", "Lcom/devexpress/editors/dropdown/DXPlacement;", "actualPlacement", "getActualPlacement", "()Lcom/devexpress/editors/dropdown/DXPlacement;", "isContentSizeDependent", "", "()Z", "calcContentFrame", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "currentContentFrame", "info", "Lcom/devexpress/editors/dropdown/placement/AlignmentCalculationInfo;", "recalcContentFrame", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StretchHorizontalAlignmentCalculator implements HorizontalAlignmentCalculator {
    private DXPlacement actualPlacement = DXPlacement.Left;
    private final DXDropdownHorizontalAlignment actualAlignment = DXDropdownHorizontalAlignment.Stretch;

    @Override // com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator
    public boolean isContentSizeDependent() {
        return false;
    }

    @Override // com.devexpress.editors.dropdown.placement.HorizontalAlignmentCalculator
    public Rectangle recalcContentFrame(Rectangle currentContentFrame, AlignmentCalculationInfo info) {
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        return currentContentFrame;
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
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getPlacement() == DXPlacement.Top || info.getPlacement() == DXPlacement.Bottom) {
            currentContentFrame.setLeft(info.getMinAnchorPoint());
            currentContentFrame.setWidth(info.getMaxAnchorPoint() - info.getMinAnchorPoint());
            this.actualPlacement = info.getPlacement();
            return currentContentFrame;
        }
        if (info.getPlacement() == DXPlacement.Right) {
            currentContentFrame.setLeft(info.getMaxAnchorPoint());
            currentContentFrame.setWidth(info.getBounds().right() - info.getMaxAnchorPoint());
            this.actualPlacement = info.getPlacement();
        } else {
            currentContentFrame.setLeft(info.getBounds().getLeft());
            currentContentFrame.setWidth(info.getMinAnchorPoint() - info.getBounds().getLeft());
            this.actualPlacement = info.getPlacement();
        }
        return currentContentFrame;
    }
}
