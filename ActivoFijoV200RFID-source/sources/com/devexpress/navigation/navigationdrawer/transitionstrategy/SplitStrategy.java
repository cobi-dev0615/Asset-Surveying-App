package com.devexpress.navigation.navigationdrawer.transitionstrategy;

import android.graphics.Rect;
import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import com.devexpress.navigation.DrawerView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.navigationdrawer.DrawerSizeCalculator;
import com.devexpress.navigation.navigationdrawer.transitionCalculators.BaseTransitionController;
import java.util.List;

/* loaded from: classes2.dex */
public class SplitStrategy extends BaseTransitionStrategy {
    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected BaseTransitionController createParentContentRect(Rect rect, int i) {
        return null;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected BaseTransitionController createSidePanelRect(Rect rect, int i) {
        return null;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected Rect getClosedRect() {
        return null;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public float getDrawerVisibleRegion() {
        return 100.0f;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    protected Rect getOpenedRect() {
        return null;
    }

    public SplitStrategy(View view, View view2, View view3, ViewDragHelper viewDragHelper, DrawerSizeCalculator drawerSizeCalculator, Position position, boolean z, List<DrawerView.OnDrawerStateChangedListener> list) {
        super(view, view2, view3, viewDragHelper, drawerSizeCalculator, position, z, list);
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public View getDraggableView() {
        return this.mSidePanel;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public void setIsOpened(boolean z) {
        this.mIsOpen = z;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public boolean getIsOpened() {
        return this.mIsOpen;
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public void layout(boolean z, int i, int i2, int i3, int i4) {
        int calculateSize;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (this.mSidePanelPosition == Position.Left || this.mSidePanelPosition == Position.Right) {
            calculateSize = this.mSizeCalculator.calculateSize(this.mSidePanel.getMeasuredWidth(), i5);
        } else {
            calculateSize = this.mSizeCalculator.calculateSize(this.mSidePanel.getMeasuredHeight(), i6);
        }
        int i7 = AnonymousClass1.$SwitchMap$com$devexpress$navigation$common$Position[this.mSidePanelPosition.ordinal()];
        if (i7 == 1) {
            this.mSidePanel.layout(0, 0, calculateSize, i6);
            this.mParentView.layout(calculateSize, 0, i5, i6);
            return;
        }
        if (i7 == 2) {
            int i8 = i5 - calculateSize;
            this.mSidePanel.layout(i8, 0, i5, i6);
            this.mParentView.layout(0, 0, i8, i6);
        } else if (i7 == 3) {
            int i9 = i6 - calculateSize;
            this.mSidePanel.layout(0, i9, i5, i6);
            this.mParentView.layout(0, 0, i5, i9);
        } else {
            if (i7 != 4) {
                return;
            }
            this.mSidePanel.layout(0, 0, i5, calculateSize);
            this.mParentView.layout(0, calculateSize, i5, i6);
        }
    }

    /* renamed from: com.devexpress.navigation.navigationdrawer.transitionstrategy.SplitStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$navigation$common$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$com$devexpress$navigation$common$Position = iArr;
            try {
                iArr[Position.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Top.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
