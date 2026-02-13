package com.devexpress.navigation.navigationdrawer.transitionstrategy;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import com.devexpress.navigation.DrawerView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.navigationdrawer.DrawerSizeCalculator;
import java.util.List;

/* loaded from: classes2.dex */
public class PushStrategy extends SlideOnTopStrategy {
    public PushStrategy(View view, View view2, View view3, ViewDragHelper viewDragHelper, DrawerSizeCalculator drawerSizeCalculator, Position position, boolean z, List<DrawerView.OnDrawerStateChangedListener> list) {
        super(view, view2, view3, viewDragHelper, drawerSizeCalculator, position, z, list);
    }

    /* renamed from: com.devexpress.navigation.navigationdrawer.transitionstrategy.PushStrategy$1, reason: invalid class name */
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
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public void onViewPositionChanged() {
        int i = AnonymousClass1.$SwitchMap$com$devexpress$navigation$common$Position[this.mSidePanelPosition.ordinal()];
        if (i == 1) {
            this.mParentView.setLeft(this.mSidePanel.getRight());
            return;
        }
        if (i == 2) {
            this.mParentView.setTop(this.mSidePanel.getBottom());
        } else if (i == 3) {
            this.mParentView.setLeft(this.mSidePanel.getLeft() - this.mParentViewRect.getViewSize());
        } else {
            this.mParentView.setTop(this.mSidePanel.getTop() - this.mParentViewRect.getViewSize());
        }
    }

    @Override // com.devexpress.navigation.navigationdrawer.transitionstrategy.SlideOnTopStrategy, com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy
    public void layout(boolean z, int i, int i2, int i3, int i4) {
        super.layout(z, i, i2, i3, i4);
        onViewPositionChanged();
    }
}
