package com.devexpress.navigation.tabs.utils.calculators;

import com.devexpress.navigation.TabsView;

/* loaded from: classes2.dex */
abstract class BaseScrollingCalculator {
    protected final int mEdgeOffset;
    protected ScrollDirection mScrollDirection;
    TabsView mTabsView;
    protected int mScrollPosition = 0;
    protected float mScrollOffset = 0.0f;

    protected enum ScrollDirection {
        Empty,
        ToIncrease,
        ToDecrease
    }

    BaseScrollingCalculator(TabsView tabsView, int i) {
        this.mTabsView = tabsView;
        this.mEdgeOffset = i;
    }

    public void update(int i, float f) {
        this.mScrollDirection = getScrollDirection(i, f);
        this.mScrollPosition = i;
        this.mScrollOffset = f;
    }

    ScrollDirection getScrollDirection(int i, float f) {
        float f2 = i + f;
        int i2 = this.mScrollPosition;
        float f3 = this.mScrollOffset;
        if (f2 > i2 + f3) {
            return ScrollDirection.ToIncrease;
        }
        if (f2 < i2 + f3) {
            return ScrollDirection.ToDecrease;
        }
        return ScrollDirection.Empty;
    }

    int getDifferenceOffset(int i, int i2, float f, ScrollDirection scrollDirection) {
        float f2;
        int i3 = i2 - i;
        if (scrollDirection == ScrollDirection.ToIncrease) {
            f2 = i3 * f;
        } else {
            if (scrollDirection != ScrollDirection.ToDecrease) {
                return 0;
            }
            f2 = i3 * (1.0f - f);
        }
        return (int) f2;
    }
}
