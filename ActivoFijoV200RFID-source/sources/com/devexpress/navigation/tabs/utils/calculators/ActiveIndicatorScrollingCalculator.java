package com.devexpress.navigation.tabs.utils.calculators;

import android.view.ViewGroup;
import com.devexpress.navigation.TabsView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabs.utils.PositionHelper;
import com.devexpress.navigation.tabs.utils.calculators.BaseScrollingCalculator;
import com.devexpress.navigation.tabs.views.TabItemView;
import java.util.List;

/* loaded from: classes2.dex */
public class ActiveIndicatorScrollingCalculator extends BaseScrollingCalculator {
    @Override // com.devexpress.navigation.tabs.utils.calculators.BaseScrollingCalculator
    public /* bridge */ /* synthetic */ void update(int i, float f) {
        super.update(i, f);
    }

    public ActiveIndicatorScrollingCalculator(TabsView tabsView, int i) {
        super(tabsView, i);
    }

    public int getIndicatorLength(Position position, List<TabItemView> list) {
        int lengthForIndicator;
        if (this.mScrollDirection == BaseScrollingCalculator.ScrollDirection.ToIncrease) {
            r2 = this.mScrollPosition < list.size() + (-1) ? TabsView.getLengthForIndicator(list.get(this.mScrollPosition + 1), position) : 0;
            lengthForIndicator = TabsView.getLengthForIndicator(list.get(this.mScrollPosition), position);
            r2 = (int) ((r2 - lengthForIndicator) * this.mScrollOffset);
        } else if (this.mScrollDirection == BaseScrollingCalculator.ScrollDirection.ToDecrease) {
            int lengthForIndicator2 = TabsView.getLengthForIndicator(list.get(this.mScrollPosition), position);
            int lengthForIndicator3 = this.mScrollPosition < list.size() + (-1) ? TabsView.getLengthForIndicator(list.get(this.mScrollPosition + 1), position) : 0;
            r2 = (int) ((lengthForIndicator2 - r2) * (1.0f - this.mScrollOffset));
            lengthForIndicator = lengthForIndicator3;
        } else {
            lengthForIndicator = TabsView.getLengthForIndicator(list.get(this.mScrollPosition), position);
        }
        return lengthForIndicator + r2;
    }

    public int getIndicatorOffset() {
        int left;
        int scrollViewPosition;
        List<TabItemView> tabItems = this.mTabsView.getTabItems();
        Position position = this.mTabsView.getPosition();
        ViewGroup tabsLayout = this.mTabsView.getTabsLayout();
        TabItemView tabItemView = tabItems.get(this.mScrollPosition);
        if (PositionHelper.isLeftOrRightPosition(position)) {
            left = tabItemView.getTop() + tabsLayout.getTop();
            scrollViewPosition = this.mTabsView.getScrollViewPosition();
        } else {
            left = tabItemView.getLeft() + tabsLayout.getLeft();
            scrollViewPosition = this.mTabsView.getScrollViewPosition();
        }
        return (int) ((left - scrollViewPosition) + ((TabsView.getLengthForIndicator(tabItemView, position) + this.mTabsView.getElementSpacing()) * this.mScrollOffset));
    }
}
