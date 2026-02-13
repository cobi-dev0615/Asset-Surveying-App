package com.devexpress.navigation.tabs.utils.calculators;

import android.view.ViewGroup;
import com.devexpress.navigation.TabsView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabs.utils.PositionHelper;
import com.devexpress.navigation.tabs.utils.calculators.BaseScrollingCalculator;
import com.devexpress.navigation.tabs.views.TabItemView;
import java.util.List;

/* loaded from: classes2.dex */
public class TabPanelScrollingCalculator extends BaseScrollingCalculator {
    @Override // com.devexpress.navigation.tabs.utils.calculators.BaseScrollingCalculator
    public /* bridge */ /* synthetic */ void update(int i, float f) {
        super.update(i, f);
    }

    public TabPanelScrollingCalculator(TabsView tabsView, int i) {
        super(tabsView, i);
    }

    public int getEdgeTargetScroll(int i, float f) {
        int left;
        int left2;
        int height;
        int height2;
        List<TabItemView> tabItems = this.mTabsView.getTabItems();
        Position position = this.mTabsView.getPosition();
        ViewGroup tabsLayout = this.mTabsView.getTabsLayout();
        ViewGroup scrollView = this.mTabsView.getScrollView();
        int i2 = this.mEdgeOffset;
        TabItemView tabItemView = this.mTabsView.getTabItems().get(i);
        if (tabItemView == null) {
            return 0;
        }
        int lengthForIndicator = TabsView.getLengthForIndicator(tabItemView, position);
        int lengthForIndicator2 = (int) (((i < tabItems.size() + (-1) ? TabsView.getLengthForIndicator(tabItems.get(i + 1), position) : 0) - lengthForIndicator) * f);
        int elementSpacing = (int) (f * (lengthForIndicator + this.mTabsView.getElementSpacing()));
        if (PositionHelper.isLeftOrRightPosition(position)) {
            left = tabItemView.getTop();
            left2 = tabsLayout.getTop();
        } else {
            left = tabItemView.getLeft();
            left2 = tabsLayout.getLeft();
        }
        int i3 = left + left2;
        int currentScroll = getCurrentScroll(scrollView, this.mTabsView.isHorizontal());
        if (this.mTabsView.isHorizontal()) {
            height = (i3 + elementSpacing) - scrollView.getWidth();
            height2 = tabItemView.getWidth();
        } else {
            height = (i3 + elementSpacing) - scrollView.getHeight();
            height2 = tabItemView.getHeight();
        }
        int i4 = height + height2 + i2 + lengthForIndicator2;
        int i5 = (i3 + elementSpacing) - i2;
        return i4 > currentScroll ? i4 : i5 < currentScroll ? i5 : currentScroll;
    }

    public int getCenterTargetScroll(int i, float f) {
        int centerItemOffset;
        int centerItemOffset2;
        BaseScrollingCalculator.ScrollDirection scrollDirection = getScrollDirection(i, f);
        List<TabItemView> tabItems = this.mTabsView.getTabItems();
        if (scrollDirection == BaseScrollingCalculator.ScrollDirection.ToIncrease) {
            r3 = i < tabItems.size() + (-1) ? getCenterItemOffset(i + 1) : 0;
            centerItemOffset = getCenterItemOffset(i);
        } else {
            if (scrollDirection == BaseScrollingCalculator.ScrollDirection.ToDecrease) {
                centerItemOffset2 = getCenterItemOffset(i);
                if (i < tabItems.size() - 1) {
                    r3 = getCenterItemOffset(i + 1);
                }
                return r3 + getDifferenceOffset(r3, centerItemOffset2, f, scrollDirection);
            }
            centerItemOffset = getCenterItemOffset(i);
        }
        centerItemOffset2 = r3;
        r3 = centerItemOffset;
        return r3 + getDifferenceOffset(r3, centerItemOffset2, f, scrollDirection);
    }

    private int getCenterItemOffsetDelta(int i) {
        int width;
        Position position = this.mTabsView.getPosition();
        ViewGroup scrollView = this.mTabsView.getScrollView();
        if (PositionHelper.isLeftOrRightPosition(position)) {
            width = scrollView.getHeight();
        } else {
            width = scrollView.getWidth();
        }
        return (width - i) / 2;
    }

    private int getCenterItemOffset(int i) {
        int left;
        int centerItemOffsetDelta;
        List<TabItemView> tabItems = this.mTabsView.getTabItems();
        Position position = this.mTabsView.getPosition();
        int lengthForIndicator = TabsView.getLengthForIndicator(tabItems.get(i), position);
        ViewGroup tabsLayout = this.mTabsView.getTabsLayout();
        if (PositionHelper.isLeftOrRightPosition(position)) {
            left = tabItems.get(i).getTop() + tabsLayout.getTop();
            centerItemOffsetDelta = getCenterItemOffsetDelta(lengthForIndicator);
        } else {
            left = tabItems.get(i).getLeft() + tabsLayout.getLeft();
            centerItemOffsetDelta = getCenterItemOffsetDelta(lengthForIndicator);
        }
        return left - centerItemOffsetDelta;
    }

    private int getCurrentScroll(ViewGroup viewGroup, boolean z) {
        return z ? viewGroup.getScrollX() : viewGroup.getScrollY();
    }
}
