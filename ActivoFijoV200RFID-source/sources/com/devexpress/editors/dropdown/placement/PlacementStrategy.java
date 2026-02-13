package com.devexpress.editors.dropdown.placement;

import android.util.Size;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.devexpress.editors.dropdown.DXDropdownHorizontalAlignment;
import com.devexpress.editors.dropdown.DXDropdownVerticalAlignment;
import com.devexpress.editors.dropdown.DXPlacement;
import com.devexpress.editors.dropdown.calculators.BottomVerticalAlignmentCalculator;
import com.devexpress.editors.dropdown.calculators.CenterHorizontalAlignmentCalculator;
import com.devexpress.editors.dropdown.calculators.CenterVerticalAlignmentCalculator;
import com.devexpress.editors.dropdown.calculators.LeftHorizontalAlignmentCalculator;
import com.devexpress.editors.dropdown.calculators.RightHorizontalAlignmentCalculator;
import com.devexpress.editors.dropdown.calculators.StretchHorizontalAlignmentCalculator;
import com.devexpress.editors.dropdown.calculators.TopVerticalAlignmentCalculator;
import com.devexpress.editors.dropdown.utils.Rectangle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlacementStrategy.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020#J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0002J&\u0010(\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/devexpress/editors/dropdown/placement/PlacementStrategy;", "", "verticalAlignmentCalculator", "Lcom/devexpress/editors/dropdown/placement/VerticalAlignmentCalculator;", "horizontalAlignmentCalculator", "Lcom/devexpress/editors/dropdown/placement/HorizontalAlignmentCalculator;", "placement", "Lcom/devexpress/editors/dropdown/DXPlacement;", "(Lcom/devexpress/editors/dropdown/placement/VerticalAlignmentCalculator;Lcom/devexpress/editors/dropdown/placement/HorizontalAlignmentCalculator;Lcom/devexpress/editors/dropdown/DXPlacement;)V", "<set-?>", "Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "actualHorizontalAlignment", "getActualHorizontalAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "actualPlacement", "getActualPlacement", "()Lcom/devexpress/editors/dropdown/DXPlacement;", "Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "actualVerticalAlignment", "getActualVerticalAlignment", "()Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "Lcom/devexpress/editors/dropdown/utils/Rectangle;", TypedValues.AttributesType.S_FRAME, "getFrame", "()Lcom/devexpress/editors/dropdown/utils/Rectangle;", "horizontalCalculator", "getHorizontalCalculator", "()Lcom/devexpress/editors/dropdown/placement/HorizontalAlignmentCalculator;", "targetPlacement", "verticalCalculator", "getVerticalCalculator", "()Lcom/devexpress/editors/dropdown/placement/VerticalAlignmentCalculator;", "calculateFrame", "", "contentSize", "Landroid/util/Size;", "windowBounds", "placementRectangle", "thresholds", "originalPlacement", "resizeFrame", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PlacementStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DXDropdownHorizontalAlignment actualHorizontalAlignment;
    private DXPlacement actualPlacement;
    private DXDropdownVerticalAlignment actualVerticalAlignment;
    private Rectangle frame;
    private final HorizontalAlignmentCalculator horizontalCalculator;
    private final DXPlacement targetPlacement;
    private final VerticalAlignmentCalculator verticalCalculator;

    /* compiled from: PlacementStrategy.kt */
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
            try {
                iArr[DXPlacement.Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DXPlacement.Left.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ PlacementStrategy(VerticalAlignmentCalculator verticalAlignmentCalculator, HorizontalAlignmentCalculator horizontalAlignmentCalculator, DXPlacement dXPlacement, DefaultConstructorMarker defaultConstructorMarker) {
        this(verticalAlignmentCalculator, horizontalAlignmentCalculator, dXPlacement);
    }

    /* compiled from: PlacementStrategy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/dropdown/placement/PlacementStrategy$Companion;", "", "()V", "create", "Lcom/devexpress/editors/dropdown/placement/PlacementStrategy;", "placement", "Lcom/devexpress/editors/dropdown/DXPlacement;", "verticalAlignment", "Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "horizontalAlignment", "Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: PlacementStrategy.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;

            static {
                int[] iArr = new int[DXDropdownVerticalAlignment.values().length];
                try {
                    iArr[DXDropdownVerticalAlignment.Default.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DXDropdownVerticalAlignment.Bottom.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DXDropdownVerticalAlignment.Top.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DXDropdownVerticalAlignment.Center.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[DXPlacement.values().length];
                try {
                    iArr2[DXPlacement.Bottom.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[DXPlacement.Top.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[DXPlacement.Right.ordinal()] = 3;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[DXPlacement.Left.ordinal()] = 4;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$1 = iArr2;
                int[] iArr3 = new int[DXDropdownHorizontalAlignment.values().length];
                try {
                    iArr3[DXDropdownHorizontalAlignment.Default.ordinal()] = 1;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr3[DXDropdownHorizontalAlignment.Stretch.ordinal()] = 2;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr3[DXDropdownHorizontalAlignment.Left.ordinal()] = 3;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr3[DXDropdownHorizontalAlignment.Right.ordinal()] = 4;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr3[DXDropdownHorizontalAlignment.Center.ordinal()] = 5;
                } catch (NoSuchFieldError unused13) {
                }
                $EnumSwitchMapping$2 = iArr3;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlacementStrategy create(DXPlacement placement, DXDropdownVerticalAlignment verticalAlignment, DXDropdownHorizontalAlignment horizontalAlignment) {
            TopVerticalAlignmentCalculator topVerticalAlignmentCalculator;
            StretchHorizontalAlignmentCalculator stretchHorizontalAlignmentCalculator;
            Intrinsics.checkNotNullParameter(placement, "placement");
            Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
            Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
            int i = WhenMappings.$EnumSwitchMapping$0[verticalAlignment.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    topVerticalAlignmentCalculator = new BottomVerticalAlignmentCalculator();
                } else if (i == 3) {
                    topVerticalAlignmentCalculator = new TopVerticalAlignmentCalculator();
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    topVerticalAlignmentCalculator = new CenterVerticalAlignmentCalculator();
                }
            } else if (placement == DXPlacement.Bottom) {
                topVerticalAlignmentCalculator = new BottomVerticalAlignmentCalculator();
            } else {
                topVerticalAlignmentCalculator = new TopVerticalAlignmentCalculator();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$2[horizontalAlignment.ordinal()];
            if (i2 == 1) {
                int i3 = WhenMappings.$EnumSwitchMapping$1[placement.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    stretchHorizontalAlignmentCalculator = new StretchHorizontalAlignmentCalculator();
                } else if (i3 == 3) {
                    stretchHorizontalAlignmentCalculator = new RightHorizontalAlignmentCalculator();
                } else {
                    if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    stretchHorizontalAlignmentCalculator = new LeftHorizontalAlignmentCalculator();
                }
            } else if (i2 == 2) {
                stretchHorizontalAlignmentCalculator = new StretchHorizontalAlignmentCalculator();
            } else if (i2 == 3) {
                stretchHorizontalAlignmentCalculator = new LeftHorizontalAlignmentCalculator();
            } else if (i2 == 4) {
                stretchHorizontalAlignmentCalculator = new RightHorizontalAlignmentCalculator();
            } else {
                if (i2 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                stretchHorizontalAlignmentCalculator = new CenterHorizontalAlignmentCalculator();
            }
            return new PlacementStrategy(topVerticalAlignmentCalculator, stretchHorizontalAlignmentCalculator, placement, null);
        }
    }

    private PlacementStrategy(VerticalAlignmentCalculator verticalAlignmentCalculator, HorizontalAlignmentCalculator horizontalAlignmentCalculator, DXPlacement dXPlacement) {
        this.targetPlacement = dXPlacement;
        this.verticalCalculator = verticalAlignmentCalculator;
        this.horizontalCalculator = horizontalAlignmentCalculator;
        this.frame = new Rectangle();
        this.actualPlacement = DXPlacement.Left;
        this.actualVerticalAlignment = DXDropdownVerticalAlignment.Default;
        this.actualHorizontalAlignment = DXDropdownHorizontalAlignment.Default;
    }

    public final VerticalAlignmentCalculator getVerticalCalculator() {
        return this.verticalCalculator;
    }

    public final HorizontalAlignmentCalculator getHorizontalCalculator() {
        return this.horizontalCalculator;
    }

    public final Rectangle getFrame() {
        return this.frame;
    }

    public final DXPlacement getActualPlacement() {
        return this.actualPlacement;
    }

    public final DXDropdownVerticalAlignment getActualVerticalAlignment() {
        return this.actualVerticalAlignment;
    }

    public final DXDropdownHorizontalAlignment getActualHorizontalAlignment() {
        return this.actualHorizontalAlignment;
    }

    public final void calculateFrame(Size contentSize, Rectangle windowBounds, Rectangle placementRectangle, Size thresholds) {
        Intrinsics.checkNotNullParameter(contentSize, "contentSize");
        Intrinsics.checkNotNullParameter(windowBounds, "windowBounds");
        Intrinsics.checkNotNullParameter(placementRectangle, "placementRectangle");
        Intrinsics.checkNotNullParameter(thresholds, "thresholds");
        AlignmentCalculationInfo alignmentCalculationInfo = new AlignmentCalculationInfo();
        alignmentCalculationInfo.setContentSize(contentSize);
        alignmentCalculationInfo.setBounds(windowBounds);
        alignmentCalculationInfo.setPlacement(this.targetPlacement);
        alignmentCalculationInfo.setMinAnchorPoint(placementRectangle.getTop());
        alignmentCalculationInfo.setMaxAnchorPoint(placementRectangle.bottom());
        alignmentCalculationInfo.setThreshold(thresholds.getHeight());
        this.verticalCalculator.calcContentFrame(this.frame, alignmentCalculationInfo);
        alignmentCalculationInfo.setMinAnchorPoint(placementRectangle.getLeft());
        alignmentCalculationInfo.setMaxAnchorPoint(placementRectangle.right());
        alignmentCalculationInfo.setThreshold(thresholds.getWidth());
        this.horizontalCalculator.calcContentFrame(this.frame, alignmentCalculationInfo);
        this.actualPlacement = getActualPlacement(this.targetPlacement);
        this.actualVerticalAlignment = this.verticalCalculator.getActualAlignment();
        this.actualHorizontalAlignment = this.horizontalCalculator.getActualAlignment();
        if (this.frame.getWidth() <= 0 || this.frame.getHeight() <= 0) {
            this.frame = new Rectangle(0, 0, contentSize.getWidth(), contentSize.getHeight());
        }
    }

    public final void resizeFrame(Rectangle frame, Size contentSize, Rectangle windowBounds, Rectangle placementRectangle) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        Intrinsics.checkNotNullParameter(contentSize, "contentSize");
        Intrinsics.checkNotNullParameter(windowBounds, "windowBounds");
        Intrinsics.checkNotNullParameter(placementRectangle, "placementRectangle");
        AlignmentCalculationInfo alignmentCalculationInfo = new AlignmentCalculationInfo();
        alignmentCalculationInfo.setContentSize(contentSize);
        alignmentCalculationInfo.setPlacement(this.targetPlacement);
        alignmentCalculationInfo.setBounds(windowBounds);
        this.frame = frame;
        alignmentCalculationInfo.setMinAnchorPoint(placementRectangle.getTop());
        alignmentCalculationInfo.setMaxAnchorPoint(placementRectangle.bottom());
        this.verticalCalculator.recalcContentFrame(this.frame, alignmentCalculationInfo);
        alignmentCalculationInfo.setMinAnchorPoint(placementRectangle.getLeft());
        alignmentCalculationInfo.setMaxAnchorPoint(placementRectangle.right());
        this.horizontalCalculator.recalcContentFrame(this.frame, alignmentCalculationInfo);
        if (this.frame.getWidth() <= 0 || this.frame.getHeight() <= 0) {
            this.frame = new Rectangle(0, 0, contentSize.getWidth(), contentSize.getHeight());
        }
    }

    private final DXPlacement getActualPlacement(DXPlacement originalPlacement) {
        int i = WhenMappings.$EnumSwitchMapping$0[originalPlacement.ordinal()];
        if (i == 1 || i == 2) {
            return this.verticalCalculator.getActualPlacement();
        }
        if (i == 3 || i == 4) {
            return this.horizontalCalculator.getActualPlacement();
        }
        throw new NoWhenBranchMatchedException();
    }
}
