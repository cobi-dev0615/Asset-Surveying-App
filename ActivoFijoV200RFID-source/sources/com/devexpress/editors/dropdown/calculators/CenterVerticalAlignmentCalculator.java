package com.devexpress.editors.dropdown.calculators;

import com.devexpress.editors.dropdown.DXDropdownVerticalAlignment;
import com.devexpress.editors.dropdown.DXPlacement;
import com.devexpress.editors.dropdown.placement.AlignmentCalculationInfo;
import com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator;
import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CenterVerticalAlignmentCalculator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/devexpress/editors/dropdown/calculators/CenterVerticalAlignmentCalculator;", "Lcom/devexpress/editors/dropdown/placement/VerticalAlignmentCalculator;", "()V", "actualAlignment", "Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "getActualAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "<set-?>", "Lcom/devexpress/editors/dropdown/DXPlacement;", "actualPlacement", "getActualPlacement", "()Lcom/devexpress/editors/dropdown/DXPlacement;", "isContentSizeDependent", "", "()Z", "calcContentFrame", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", "currentContentFrame", "info", "Lcom/devexpress/editors/dropdown/placement/AlignmentCalculationInfo;", "recalcContentFrame", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CenterVerticalAlignmentCalculator implements VerticalAlignmentCalculator {
    private DXPlacement actualPlacement = DXPlacement.Left;
    private final DXDropdownVerticalAlignment actualAlignment = DXDropdownVerticalAlignment.Center;

    /* compiled from: CenterVerticalAlignmentCalculator.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DXPlacement.values().length];
            try {
                iArr[DXPlacement.Bottom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DXPlacement.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

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
        int bottom;
        int top;
        DXPlacement dXPlacement;
        DXPlacement dXPlacement2;
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();
        Rectangle rectangle4 = new Rectangle();
        int minAnchorPoint = (info.getMinAnchorPoint() + info.getMaxAnchorPoint()) / 2;
        int i = WhenMappings.$EnumSwitchMapping$0[info.getPlacement().ordinal()];
        if (i == 1) {
            bottom = info.getBounds().bottom() - minAnchorPoint;
            top = minAnchorPoint - info.getBounds().getTop();
            rectangle.set(0, minAnchorPoint, 0, info.getContentSize().getHeight());
            rectangle2.set(0, minAnchorPoint, 0, bottom);
            rectangle3.set(0, minAnchorPoint - info.getContentSize().getHeight(), 0, info.getContentSize().getHeight());
            rectangle4.set(0, minAnchorPoint - top, 0, top);
            dXPlacement = DXPlacement.Bottom;
            dXPlacement2 = DXPlacement.Top;
        } else if (i == 2) {
            bottom = minAnchorPoint - info.getBounds().getTop();
            top = info.getBounds().bottom() - minAnchorPoint;
            rectangle.set(0, minAnchorPoint - info.getContentSize().getHeight(), 0, info.getContentSize().getHeight());
            rectangle2.set(0, minAnchorPoint - bottom, 0, bottom);
            rectangle3.set(0, minAnchorPoint, 0, info.getContentSize().getHeight());
            rectangle4.set(0, minAnchorPoint, 0, top);
            dXPlacement = DXPlacement.Top;
            dXPlacement2 = DXPlacement.Bottom;
        } else {
            bottom = Math.min(info.getBounds().bottom() - minAnchorPoint, minAnchorPoint - info.getBounds().getTop()) * 2;
            top = info.getBounds().getHeight();
            rectangle.set(0, minAnchorPoint - (info.getContentSize().getHeight() / 2), 0, info.getContentSize().getHeight());
            rectangle2.set(0, minAnchorPoint - (bottom / 2), 0, bottom);
            rectangle3.set(0, info.getBounds().centerY() - (info.getContentSize().getHeight() / 2), 0, info.getContentSize().getHeight());
            rectangle4.set(0, info.getBounds().getTop(), 0, top);
            dXPlacement = info.getPlacement();
            dXPlacement2 = info.getPlacement();
        }
        if (info.getContentSize().getHeight() <= bottom) {
            currentContentFrame.setTop(rectangle.getTop());
            currentContentFrame.setHeight(rectangle.getHeight());
            this.actualPlacement = dXPlacement;
            return currentContentFrame;
        }
        if (info.getThreshold() > 0 && bottom > info.getThreshold()) {
            currentContentFrame.setTop(rectangle2.getTop());
            currentContentFrame.setHeight(rectangle2.getHeight());
            this.actualPlacement = dXPlacement;
            return currentContentFrame;
        }
        if (info.getContentSize().getHeight() <= top) {
            currentContentFrame.setTop(rectangle3.getTop());
            currentContentFrame.setHeight(rectangle3.getHeight());
            this.actualPlacement = dXPlacement2;
            return currentContentFrame;
        }
        if (bottom >= top) {
            currentContentFrame.setTop(rectangle2.getTop());
            currentContentFrame.setHeight(rectangle2.getHeight());
            this.actualPlacement = dXPlacement;
        } else {
            currentContentFrame.setTop(rectangle4.getTop());
            currentContentFrame.setHeight(rectangle4.getHeight());
            this.actualPlacement = dXPlacement2;
        }
        return currentContentFrame;
    }

    @Override // com.devexpress.editors.dropdown.placement.VerticalAlignmentCalculator
    public Rectangle recalcContentFrame(Rectangle currentContentFrame, AlignmentCalculationInfo info) {
        Intrinsics.checkNotNullParameter(currentContentFrame, "currentContentFrame");
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getPlacement() == DXPlacement.Bottom) {
            currentContentFrame.setHeight(Math.min(info.getContentSize().getHeight(), info.getBounds().getHeight()));
            return currentContentFrame;
        }
        if (info.getPlacement() == DXPlacement.Top) {
            int bottom = currentContentFrame.bottom();
            currentContentFrame.setHeight(Math.min(bottom - info.getContentSize().getHeight(), bottom - info.getBounds().getTop()));
            currentContentFrame.setTop(bottom - currentContentFrame.getHeight());
            return currentContentFrame;
        }
        int minAnchorPoint = (info.getMinAnchorPoint() + info.getMaxAnchorPoint()) / 2;
        currentContentFrame.setHeight(Math.min(Math.min(info.getBounds().bottom() - minAnchorPoint, minAnchorPoint - info.getBounds().getTop()) * 2, info.getContentSize().getHeight()));
        currentContentFrame.setTop(minAnchorPoint - (currentContentFrame.getHeight() / 2));
        return currentContentFrame;
    }
}
