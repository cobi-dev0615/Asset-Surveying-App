package com.devexpress.navigation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.navigation.common.HeaderElements;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabcontrol.ITabControlAdapter;
import com.devexpress.navigation.tabcontrol.TabControlAppearance;
import com.devexpress.navigation.tabs.models.HeaderItemModel;
import com.devexpress.navigation.tabs.models.HeaderSingleItemAppearance;
import com.devexpress.navigation.tabs.models.IReadonlyHeaderItemModel;
import com.devexpress.navigation.tabs.models.SelectedStyleProperty;
import com.devexpress.navigation.tabs.models.StyleProperty;
import com.devexpress.navigation.tabs.models.TabItemSettings;
import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.utils.PositionHelper;
import com.devexpress.navigation.tabs.utils.SizeConverter;
import com.devexpress.navigation.tabs.utils.calculators.ActiveIndicatorScrollingCalculator;
import com.devexpress.navigation.tabs.utils.calculators.HeaderItemSizeCalculator;
import com.devexpress.navigation.tabs.utils.calculators.TabPanelScrollingCalculator;
import com.devexpress.navigation.tabs.views.TabItemView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TabsView extends ViewGroup {
    public static final int ALIGNMENT_CENTER = 2;
    public static final int ALIGNMENT_END = 1;
    public static final int ALIGNMENT_START = 0;
    private static final int EDGE_OFFSET_DIPS = 24;
    public static final int INDICATOR_SCROLL_ALIGNMENT_CENTER = 0;
    public static final int INDICATOR_SCROLL_ALIGNMENT_EDGES = 1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private final int edgeOffset;
    private final ActiveIndicatorScrollingCalculator indicatorPositionCalculator;
    private final TabControlAppearance.OnAppearancePropertyChangeListener listenerAppearance;
    private ITabControlAdapter mAdapter;
    private int mAlignment;
    private boolean mAnimateIndicatorEnabled;
    private TabControlAppearance mAppearance;
    HeaderItemModel.OnHeaderChangeListener mHeaderChangelistener;
    private int mHorizontalLayoutHeight;
    private int mIndent;
    private final Paint mIndicatorPaint;
    private boolean mIsHorizontal;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMinHeight;
    private int mMinWidth;
    private final List<OnTabSelectedListener> mOnTabSelectedListeners;
    private final List<OnTabTappedListener> mOnTabTappedListeners;
    private int mPanelCrossSize;
    private Position mPosition;
    private int mScrollMode;
    private ViewGroup mScrollView;
    private int mSelectedIndex;
    private HeaderItemModel mSelectedModel;
    private final HeaderItemSizeCalculator mSizeCalculator;
    private final SizeConverter mSizeConverter;
    private final TabItemSettings mTabCommonSettings;
    View.OnClickListener mTabItemClickListener;
    private final List<IReadonlyHeaderItemModel> mTabItemModels;
    private final List<TabItemView> mTabItems;
    private final TabsLayout mTabsLayout;
    private int mVerticalLayoutWidth;
    private boolean needRelayout;
    private final TabPanelScrollingCalculator panelScrollingCalculator;

    public interface OnTabSelectedListener {
        void onTabSelected(TabItemView tabItemView, int i, int i2);
    }

    public interface OnTabTappedListener {
        boolean onTabTapped(int i);
    }

    public int getPanelCrossSize() {
        return this.mPanelCrossSize;
    }

    public TabItemSettings getHeaderSettings() {
        return this.mTabCommonSettings;
    }

    public int getTabsAlignment() {
        return this.mAlignment;
    }

    public boolean isHorizontal() {
        return this.mIsHorizontal;
    }

    public List<TabItemView> getTabItems() {
        return this.mTabItems;
    }

    public List<IReadonlyHeaderItemModel> getTabItemModels() {
        return this.mTabItemModels;
    }

    public int getHorizontalLayoutHeight() {
        return this.mHorizontalLayoutHeight;
    }

    public int getVerticalLayoutWidth() {
        return this.mVerticalLayoutWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public boolean getAnimateIndicatorEnabled() {
        return this.mAnimateIndicatorEnabled;
    }

    public IReadonlyHeaderItemModel getSelectedItem(int i) {
        return this.mTabItemModels.get(i);
    }

    public int getSelectedItemIndex() {
        return this.mSelectedIndex;
    }

    public int getTabsCount() {
        return this.mTabItems.size();
    }

    public ViewGroup getTabsLayout() {
        return this.mTabsLayout;
    }

    public ViewGroup getScrollView() {
        return this.mScrollView;
    }

    public int getScrollViewPosition() {
        return this.mIsHorizontal ? this.mScrollView.getScrollX() : this.mScrollView.getScrollY();
    }

    public int getElementSpacing() {
        return this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelItemSpacing());
    }

    public Position getPosition() {
        return this.mPosition;
    }

    private TabItemView getSelectedItemView() {
        int i = this.mSelectedIndex;
        if (i < 0 || i >= this.mTabItems.size()) {
            return null;
        }
        return this.mTabItems.get(this.mSelectedIndex);
    }

    public int getIndicatorScrollAlignment() {
        return this.mScrollMode;
    }

    public void setAppearance(TabControlAppearance tabControlAppearance) {
        TabControlAppearance tabControlAppearance2 = this.mAppearance;
        if (tabControlAppearance2 == tabControlAppearance) {
            return;
        }
        if (tabControlAppearance2 != null) {
            tabControlAppearance2.removeOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
        this.mAppearance = tabControlAppearance;
        tabControlAppearance.addOnAppearanceProperyChangeListener(this.listenerAppearance);
        requestRelayout();
        invalidate();
    }

    public void setTabsAlignment(int i) {
        if (this.mAlignment != i) {
            this.mAlignment = i;
            requestRelayout();
        }
    }

    public void setHorizontalLayoutHeight(int i) {
        if (this.mHorizontalLayoutHeight != i) {
            this.mHorizontalLayoutHeight = i;
            this.mSizeCalculator.setCrossHeight(i, this.mMinHeight, this.mMaxHeight);
            requestRelayout();
        }
    }

    public void setVerticalLayoutWidth(int i) {
        if (this.mVerticalLayoutWidth != i) {
            this.mVerticalLayoutWidth = i;
            this.mSizeCalculator.setCrossWidth(i, this.mMinWidth, this.mMaxWidth);
            requestRelayout();
        }
    }

    public void setMinHeight(int i) {
        if (this.mMinHeight != i) {
            this.mMinHeight = i;
            this.mSizeCalculator.setCrossHeight(this.mHorizontalLayoutHeight, i, this.mMaxHeight);
            requestRelayout();
        }
    }

    public void setMaxHeight(int i) {
        if (this.mMaxHeight != i) {
            this.mMaxHeight = i;
            this.mSizeCalculator.setCrossHeight(this.mHorizontalLayoutHeight, this.mMinHeight, i);
            requestRelayout();
        }
    }

    public void setMinWidth(int i) {
        if (this.mMinWidth != i) {
            this.mMinWidth = i;
            this.mSizeCalculator.setCrossWidth(this.mVerticalLayoutWidth, i, this.mMaxWidth);
            requestRelayout();
        }
    }

    public void setMaxWidth(int i) {
        if (this.mMaxWidth != i) {
            this.mMaxWidth = i;
            this.mSizeCalculator.setCrossWidth(this.mVerticalLayoutWidth, this.mMinWidth, i);
            requestRelayout();
        }
    }

    public void setAnimateIndicatorEnabled(boolean z) {
        this.mAnimateIndicatorEnabled = z;
    }

    public void setSelectedItem(HeaderItemModel headerItemModel) {
        int indexOf = this.mTabItems.indexOf(headerItemModel);
        if (indexOf > -1) {
            this.mSelectedModel = headerItemModel;
            setSelectedItemViewByIndex(indexOf);
        }
    }

    public void setSelectedItemIndex(int i) {
        int i2 = this.mSelectedIndex;
        int i3 = (i2 < 0 || i2 >= this.mTabItems.size()) ? -1 : this.mSelectedIndex;
        this.mSelectedIndex = i;
        if (i < this.mTabItems.size() && i != i3) {
            selectItem(i3, i);
        }
    }

    public void setAdapter(ITabControlAdapter iTabControlAdapter, ViewGroup viewGroup) {
        if (this.mAdapter != iTabControlAdapter) {
            this.mAdapter = iTabControlAdapter;
            if (iTabControlAdapter != null) {
                iTabControlAdapter.addItemsSetChangedListener(new ItemsChangeListener());
                recreateLayout();
            }
        }
    }

    public void setPosition(Position position) {
        if (this.mPosition != position) {
            boolean z = !PositionHelper.isLeftOrRightPosition(position);
            boolean z2 = this.mIsHorizontal != z;
            if (z2) {
                setTabOrientation(z);
                setLayoutParams(getLayoutParams(z));
            }
            this.mPosition = position;
            if (z2) {
                changeScrollLayout();
            }
            requestLayout();
        }
    }

    public void setIndicatorScrollAlignment(int i) {
        this.mScrollMode = i;
    }

    private void setTabOrientation(boolean z) {
        if (this.mIsHorizontal != z) {
            this.mIsHorizontal = z;
            this.mSizeCalculator.setOrientation(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedItemViewByIndex(int i) {
        setSelectedItemIndex(i);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean raiseTabItemTapped(int i) {
        Iterator<OnTabTappedListener> it = this.mOnTabTappedListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onTabTapped(i)) {
                return true;
            }
        }
        return false;
    }

    public TabsView(Context context, TabControlAppearance tabControlAppearance) {
        super(context);
        this.mIsHorizontal = true;
        this.mAlignment = 2;
        this.mPosition = Position.Top;
        this.mScrollMode = 0;
        this.mTabItems = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.mTabItemModels = arrayList;
        this.mSelectedIndex = -1;
        this.mAnimateIndicatorEnabled = true;
        this.mOnTabSelectedListeners = new ArrayList();
        this.mOnTabTappedListeners = new ArrayList();
        this.mIndicatorPaint = new Paint();
        this.mHorizontalLayoutHeight = -2;
        this.mVerticalLayoutWidth = -2;
        this.mMinHeight = -1;
        this.mMaxHeight = -1;
        this.mMinWidth = -1;
        this.mMaxWidth = -1;
        this.mTabCommonSettings = new TabItemSettings();
        this.mPanelCrossSize = 0;
        this.needRelayout = true;
        this.mHeaderChangelistener = new HeaderItemModel.OnHeaderChangeListener() { // from class: com.devexpress.navigation.TabsView.1
            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderHeightOnVerticalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderIconPositionChanged(Position position, Position position2) {
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderVisibleElementsChanged(HeaderElements headerElements, HeaderElements headerElements2) {
            }

            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onViewChanged(View view, View view2) {
            }

            @Override // com.devexpress.navigation.tabs.models.TabItemSettings.OnSettingsChangeListener
            public void onHeaderWidthOnHorizontalPanelChanged(Object obj, TabSize tabSize, TabSize tabSize2) {
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onIconChanged(Drawable drawable, Drawable drawable2) {
                TabsView.this.mTabsLayout.requestLayout();
            }

            @Override // com.devexpress.navigation.tabs.models.HeaderItemModel.OnHeaderChangeListener
            public void onTextChanged(CharSequence charSequence, CharSequence charSequence2) {
                TabsView.this.requestRelayout();
            }
        };
        this.mTabItemClickListener = new View.OnClickListener() { // from class: com.devexpress.navigation.TabsView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOf = TabsView.this.mTabItems.indexOf(view);
                if (indexOf <= -1 || TabsView.this.raiseTabItemTapped(indexOf)) {
                    return;
                }
                TabsView.this.setSelectedItemViewByIndex(indexOf);
            }
        };
        TabControlAppearance.OnAppearancePropertyChangeListener onAppearancePropertyChangeListener = new TabControlAppearance.OnAppearancePropertyChangeListener() { // from class: com.devexpress.navigation.TabsView.3
            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemStylePropertyChanged(StyleProperty styleProperty) {
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemSpacingPropertyChanged() {
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemCornerRadiusPropertyChanged() {
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemPaddingPropertyChanged() {
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelIndentPropertyChanged() {
                TabsView.this.applyIndent();
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelSpacingPropertyChanged() {
                TabsView.this.refreshItemsSpacing();
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelPaddingPropertyChanged() {
                TabsView.this.requestRelayout();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelBackgroundPropertyChanged() {
                TabsView.this.drawBackground();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onIndicatorPropertyChanged() {
                TabsView.this.invalidate();
            }
        };
        this.listenerAppearance = onAppearancePropertyChangeListener;
        this.mAppearance = tabControlAppearance;
        tabControlAppearance.addOnAppearanceProperyChangeListener(onAppearancePropertyChangeListener);
        this.mTabsLayout = new TabsLayout(getContext());
        SizeConverter sizeConverter = new SizeConverter(getContext().getResources().getDisplayMetrics().density);
        this.mSizeConverter = sizeConverter;
        HeaderItemSizeCalculator headerItemSizeCalculator = new HeaderItemSizeCalculator(arrayList, this.mIsHorizontal, getElementSpacing(), this.mVerticalLayoutWidth, this.mHorizontalLayoutHeight, sizeConverter);
        this.mSizeCalculator = headerItemSizeCalculator;
        headerItemSizeCalculator.setCrossWidth(this.mVerticalLayoutWidth, this.mMinWidth, this.mMaxWidth);
        headerItemSizeCalculator.setCrossHeight(this.mHorizontalLayoutHeight, this.mMinHeight, this.mMaxHeight);
        int i = (int) (getResources().getDisplayMetrics().density * 24.0f);
        this.edgeOffset = i;
        this.indicatorPositionCalculator = new ActiveIndicatorScrollingCalculator(this, i);
        this.panelScrollingCalculator = new TabPanelScrollingCalculator(this, i);
    }

    public void onPageScrolled(int i, float f, int i2) {
        int childCount = this.mTabsLayout.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount) {
            return;
        }
        scrollToTab(i, f);
        this.indicatorPositionCalculator.update(i, f);
        invalidate();
    }

    public void addOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListeners.add(onTabSelectedListener);
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListeners.remove(onTabSelectedListener);
    }

    public void clearOnTabSelectedListener() {
        this.mOnTabSelectedListeners.clear();
    }

    public void addOnTabTappedListener(OnTabTappedListener onTabTappedListener) {
        this.mOnTabTappedListeners.add(onTabTappedListener);
    }

    public void removeOnTabTappedListener(OnTabTappedListener onTabTappedListener) {
        this.mOnTabTappedListeners.remove(onTabTappedListener);
    }

    public void clearOnTabTappedListener() {
        this.mOnTabTappedListeners.clear();
    }

    public void setViewPort(int i, int i2) {
        this.mSizeCalculator.setViewPort(i, i2);
    }

    public void scrollToSelectedItem() {
        TabItemView selectedItemView;
        if (getParent() == null || (selectedItemView = getSelectedItemView()) == null) {
            return;
        }
        selectedItemView.post(new Runnable() { // from class: com.devexpress.navigation.TabsView.4
            @Override // java.lang.Runnable
            public void run() {
                TabsView tabsView = TabsView.this;
                tabsView.scrollToTab(tabsView.mSelectedIndex, 0.0f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void correctSelectionIfNeeded() {
        int i = this.mSelectedIndex;
        if (i >= this.mTabItems.size()) {
            i = this.mTabItems.isEmpty() ? -1 : this.mTabItems.size() - 1;
        } else if (this.mSelectedIndex < 0 && !this.mTabItems.isEmpty()) {
            i = 0;
        }
        if (i != this.mSelectedIndex) {
            this.indicatorPositionCalculator.update(i, 0.0f);
            setSelectedItemIndex(i);
        }
    }

    public static int getLengthForIndicator(TabItemView tabItemView, Position position) {
        return PositionHelper.isLeftOrRightPosition(position) ? tabItemView.getHeight() : tabItemView.getWidth();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setPadding(this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getLeft()), this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getTop()), this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getRight()), this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getBottom()));
        checkIsHeaderItemsSizeChanged();
        boolean z = this.mSizeCalculator.needRecalculate() || this.needRelayout;
        this.needRelayout = z;
        if (z) {
            this.mSizeCalculator.calculateHeaderItemMainSizes();
            int calculateCrossSize = this.mSizeCalculator.calculateCrossSize() + this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getTop()) + this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getBottom());
            int headerPanelMainSize = this.mSizeCalculator.getHeaderPanelMainSize();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(calculateCrossSize, BasicMeasure.EXACTLY);
            if (this.mIsHorizontal) {
                i2 = makeMeasureSpec;
            } else {
                i = makeMeasureSpec;
            }
            setHeaderPanelSize(calculateCrossSize, headerPanelMainSize + applyIndent());
            this.mPanelCrossSize = calculateCrossSize;
            applyTabItemSizes(this.mSizeCalculator, this.mIsHorizontal);
            invalidate();
        }
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mPanelCrossSize, BasicMeasure.EXACTLY);
        if (this.mIsHorizontal) {
            i2 = makeMeasureSpec2;
        } else {
            i = makeMeasureSpec2;
        }
        if (this.needRelayout) {
            this.mScrollView.measure(i, i2);
            scrollToSelectedItem();
        }
        if (this.mIsHorizontal) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.mPanelCrossSize);
        } else {
            setMeasuredDimension(this.mPanelCrossSize, View.MeasureSpec.getSize(i2));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mScrollView.layout(this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getLeft()), this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getTop()), (i3 - i) - this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getRight()), (i4 - i2) - this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelPadding().getBottom()));
        this.needRelayout = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.needRelayout = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestRelayout() {
        ViewGroup viewGroup = this.mScrollView;
        if (viewGroup != null) {
            viewGroup.requestLayout();
        }
        TabsLayout tabsLayout = this.mTabsLayout;
        if (tabsLayout != null) {
            tabsLayout.requestLayout();
        }
        requestLayout();
    }

    private void setHeaderPanelSize(int i, int i2) {
        if (this.mIsHorizontal) {
            this.mTabsLayout.getLayoutParams().height = i;
            this.mTabsLayout.getLayoutParams().width = i2;
        } else {
            this.mTabsLayout.getLayoutParams().width = i;
            this.mTabsLayout.getLayoutParams().height = i2;
        }
    }

    private void checkIsHeaderItemsSizeChanged() {
        for (TabItemView tabItemView : this.mTabItems) {
            tabItemView.measure(View.MeasureSpec.makeMeasureSpec(this.mSizeCalculator.getViewPortWidth(), 0), View.MeasureSpec.makeMeasureSpec(this.mSizeCalculator.getViewPortHeight(), 0));
            this.mSizeCalculator.checkSizeChanged(tabItemView.getModel(), tabItemView.getMeasuredWidth(), tabItemView.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int applyIndent() {
        int convertDpToPx = this.mSizeCalculator.isMainSizeFitToViewPort() ? 0 : this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelIndent());
        if (this.mIndent != convertDpToPx) {
            this.mIndent = convertDpToPx;
            requestLayout();
        }
        return convertDpToPx;
    }

    private void recreateLayout() {
        clearLayout();
        this.indicatorPositionCalculator.update(0, 0.0f);
        this.panelScrollingCalculator.update(0, 0.0f);
        if (this.mAdapter == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams(this.mIsHorizontal);
        setLayoutParams(new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height));
        createLayout(layoutParams.width, layoutParams.height);
    }

    private void changeScrollLayout() {
        if (this.mAdapter == null) {
            return;
        }
        ViewGroup viewGroup = this.mScrollView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams(this.mIsHorizontal);
        setLayoutParams(new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height));
        ViewGroup createScrollView = createScrollView();
        this.mScrollView = createScrollView;
        createScrollView.addView(this.mTabsLayout, new ViewGroup.LayoutParams(-2, -2));
        addView(this.mScrollView, new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height));
        scrollToSelectedItem();
    }

    private void createLayout(int i, int i2) {
        int i3;
        this.mScrollView = createScrollView();
        this.mTabsLayout.createLayout();
        this.mScrollView.addView(this.mTabsLayout, new ViewGroup.LayoutParams(-2, -2));
        addView(this.mScrollView, new ViewGroup.LayoutParams(i, i2));
        scrollToSelectedItem();
        if (this.mTabItems.size() > 0 && (i3 = this.mSelectedIndex) < 0) {
            selectItem(i3, 0);
        }
        drawBackground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{this.mAppearance.getHeaderPanelBackgroundColor(), this.mAppearance.getHeaderPanelBackgroundColor()});
        gradientDrawable.setShape(0);
        int convertDpToPx = this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderPanelBorderHeight());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{this.mAppearance.getHeaderPanelBorderColor(), this.mAppearance.getHeaderPanelBorderColor()}), gradientDrawable});
        if (!this.mAppearance.getHeaderPanelShadowVisibility() && this.mAppearance.getHeaderPanelBorderVisibility()) {
            if (this.mPosition == Position.Top) {
                layerDrawable.setLayerInset(1, 0, 0, 0, convertDpToPx);
            } else if (this.mPosition == Position.Right) {
                layerDrawable.setLayerInset(1, convertDpToPx, 0, 0, 0);
            } else if (this.mPosition == Position.Bottom) {
                layerDrawable.setLayerInset(1, 0, convertDpToPx, 0, 0);
            } else if (this.mPosition == Position.Left) {
                layerDrawable.setLayerInset(1, 0, 0, convertDpToPx, 0);
            }
        }
        setBackground(layerDrawable);
    }

    private ViewGroup.LayoutParams getLayoutParams(boolean z) {
        if (z) {
            return new ViewGroup.LayoutParams(-1, -2);
        }
        return new ViewGroup.LayoutParams(-2, -1);
    }

    private void clearLayout() {
        if (getChildCount() == 0) {
            return;
        }
        this.mScrollView.removeAllViews();
        this.mScrollView = null;
        removeAllViewsInLayout();
    }

    private ViewGroup createScrollView() {
        ViewGroup tabsHorizontalScrollView = this.mIsHorizontal ? new TabsHorizontalScrollView(getContext()) : new TabsScrollView(getContext());
        tabsHorizontalScrollView.setVerticalScrollBarEnabled(false);
        tabsHorizontalScrollView.setHorizontalScrollBarEnabled(false);
        return tabsHorizontalScrollView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTabItems(ITabControlAdapter iTabControlAdapter, TabItemSettings tabItemSettings) {
        if (iTabControlAdapter == null) {
            return;
        }
        this.mTabItems.clear();
        this.mTabItemModels.clear();
        for (int i = 0; i < iTabControlAdapter.getItemsCount(); i++) {
            addTabItem(i);
        }
        this.mSizeCalculator.headerItemsUpdated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTabItem(int i) {
        HeaderItemModel headerItemModel = getHeaderItemModel(i);
        TabItemView createTabItemView = createTabItemView(headerItemModel);
        this.mTabItems.add(i, createTabItemView);
        this.mTabItemModels.add(i, headerItemModel);
        headerItemModel.addListener(this.mHeaderChangelistener);
        if (headerItemModel == this.mSelectedModel || i == this.mSelectedIndex) {
            createTabItemView.select();
        }
    }

    private TabItemView createTabItemView(HeaderItemModel headerItemModel) {
        TabItemView tabItemView = new TabItemView(getContext(), this.mSizeConverter);
        tabItemView.setModel(headerItemModel, headerItemModel.getHeaderItemAppearance());
        tabItemView.setOnClickListener(this.mTabItemClickListener);
        return tabItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HeaderItemModel getHeaderItemModel(int i) {
        HeaderItemModel headerView = this.mAdapter.getHeaderView(this, i);
        if (headerView == this.mSelectedModel && this.mSelectedIndex != i) {
            this.mSelectedIndex = i;
        }
        headerView.setCommonSettings(this.mTabCommonSettings);
        HeaderSingleItemAppearance headerItemAppearance = headerView.getHeaderItemAppearance();
        if (headerItemAppearance.getCommonAppearance() == null) {
            headerItemAppearance.setCommonAppearance(this.mAppearance.getHeaderItemAppearance());
        }
        return headerView;
    }

    private void applyTabItemSizes(HeaderItemSizeCalculator headerItemSizeCalculator, boolean z) {
        for (int i = 0; i < this.mTabItems.size(); i++) {
            TabItemView tabItemView = this.mTabItems.get(i);
            int headerItemSize = headerItemSizeCalculator.getHeaderItemSize(i);
            if (z) {
                tabItemView.getLayoutParams().width = headerItemSize;
                tabItemView.getLayoutParams().height = -1;
            } else {
                tabItemView.getLayoutParams().width = -1;
                tabItemView.getLayoutParams().height = headerItemSize;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectItem(int i, int i2) {
        TabItemView tabItemView = (i <= -1 || i >= this.mTabItems.size()) ? null : this.mTabItems.get(i);
        this.mSelectedIndex = i2;
        TabItemView selectedItemView = getSelectedItemView();
        if (tabItemView != null) {
            tabItemView.deselect();
        }
        if (selectedItemView != null) {
            selectedItemView.select();
            this.mSelectedModel = (HeaderItemModel) selectedItemView.getModel();
        } else {
            this.mSelectedModel = null;
        }
        invalidate();
        Iterator<OnTabSelectedListener> it = this.mOnTabSelectedListeners.iterator();
        while (it.hasNext()) {
            it.next().onTabSelected(selectedItemView, i2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToTab(int i, float f) {
        if (i >= 0 && this.mTabItems.size() != 0) {
            if (this.mScrollMode == 0) {
                scrollTo(this.panelScrollingCalculator.getCenterTargetScroll(i, f));
            } else {
                scrollTo(this.panelScrollingCalculator.getEdgeTargetScroll(i, f));
            }
        }
    }

    private void scrollTo(int i) {
        if (this.mIsHorizontal) {
            this.mScrollView.scrollTo(i, 0);
        } else {
            this.mScrollView.scrollTo(0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshItemsSpacing() {
        this.mSizeCalculator.setSpacing(getElementSpacing());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateOffset(int i, int i2, int i3) {
        if (i <= i2) {
            return i3;
        }
        int i4 = this.mAlignment;
        if (i4 == 1) {
            return i - i2;
        }
        if (i4 != 2) {
            return 0;
        }
        return (i - i2) / 2;
    }

    public class TabsLayout extends ViewGroup {
        public TabsLayout(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int i3 = TabsView.this.mIndent;
            int elementSpacing = TabsView.this.getElementSpacing();
            for (int i4 = 0; i4 < TabsView.this.mTabItems.size(); i4++) {
                i3 += TabsView.this.mSizeCalculator.getHeaderItemSize(i4) + elementSpacing;
            }
            int i5 = i3 - elementSpacing;
            if (TabsView.this.mIsHorizontal) {
                setMeasuredDimension(i5, View.MeasureSpec.getSize(i2));
            } else {
                setMeasuredDimension(View.MeasureSpec.getSize(i), i5);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (TabsView.this.needRelayout) {
                int elementSpacing = TabsView.this.getElementSpacing();
                if (TabsView.this.mIsHorizontal) {
                    int i7 = 0;
                    for (int i8 = 0; i8 < TabsView.this.mTabItems.size(); i8++) {
                        TabItemView tabItemView = (TabItemView) TabsView.this.mTabItems.get(i8);
                        int headerItemSize = TabsView.this.mSizeCalculator.getHeaderItemSize(i8) + i7;
                        tabItemView.layout(i7, 0, headerItemSize, i6);
                        i7 = headerItemSize + elementSpacing;
                    }
                    return;
                }
                int i9 = 0;
                for (int i10 = 0; i10 < TabsView.this.mTabItems.size(); i10++) {
                    TabItemView tabItemView2 = (TabItemView) TabsView.this.mTabItems.get(i10);
                    int headerItemSize2 = TabsView.this.mSizeCalculator.getHeaderItemSize(i10) + i9;
                    tabItemView2.layout(0, i9, i5, headerItemSize2);
                    i9 = headerItemSize2 + elementSpacing;
                }
            }
        }

        public void createLayout() {
            removeAllViews();
            TabsView tabsView = TabsView.this;
            tabsView.createTabItems(tabsView.mAdapter, TabsView.this.mTabCommonSettings);
            for (int i = 0; i < TabsView.this.mTabItems.size(); i++) {
                addView((TabItemView) TabsView.this.mTabItems.get(i));
            }
        }
    }

    class TabsScrollView extends ScrollView {
        public TabsScrollView(Context context) {
            super(context);
        }

        @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            TabsView tabsView = TabsView.this;
            int calculateOffset = tabsView.calculateOffset(tabsView.mSizeCalculator.getActualViewPortHeight(), TabsView.this.mTabsLayout.getMeasuredHeight(), TabsView.this.mIndent);
            TabsView.this.mTabsLayout.layout(0, calculateOffset, i3 - i, TabsView.this.mTabsLayout.getMeasuredHeight() + calculateOffset);
        }
    }

    class TabsHorizontalScrollView extends HorizontalScrollView {
        public TabsHorizontalScrollView(Context context) {
            super(context);
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            TabsView tabsView = TabsView.this;
            int calculateOffset = tabsView.calculateOffset(tabsView.mSizeCalculator.getActualViewPortWidth(), TabsView.this.mTabsLayout.getMeasuredWidth(), TabsView.this.mIndent);
            TabsView.this.mTabsLayout.layout(calculateOffset, 0, TabsView.this.mTabsLayout.getMeasuredWidth() + calculateOffset, i4 - i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!this.mAppearance.getHeaderIndicatorVisibility() || this.mTabItems.size() == 0) {
            return;
        }
        Rect layoutRect = getLayoutRect(getMeasuredWidth(), getMeasuredHeight(), this.indicatorPositionCalculator.getIndicatorLength(this.mPosition, this.mTabItems), this.mSizeConverter.convertDpToPx(this.mAppearance.getHeaderIndicatorHeight()), this.indicatorPositionCalculator.getIndicatorOffset());
        this.mIndicatorPaint.setColor(this.mAppearance.getHeaderIndicatorColor());
        canvas.drawRect(layoutRect.left, layoutRect.top, layoutRect.right, layoutRect.bottom, this.mIndicatorPaint);
    }

    /* renamed from: com.devexpress.navigation.TabsView$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
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

    public Rect getLayoutRect(int i, int i2, int i3, int i4, int i5) {
        int i6 = AnonymousClass5.$SwitchMap$com$devexpress$navigation$common$Position[this.mPosition.ordinal()];
        if (i6 == 1) {
            return new Rect(i - i4, i5, i, i3 + i5);
        }
        if (i6 == 2) {
            return new Rect(0, i5, i4, i3 + i5);
        }
        if (i6 == 3) {
            return new Rect(i5, 0, i3 + i5, i4);
        }
        return new Rect(i5, i2 - i4, i3 + i5, i2);
    }

    class ItemsChangeListener implements ITabControlAdapter.ItemsChangedListener {
        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onContentChanged(int i) {
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onContentTemplateChanged() {
        }

        ItemsChangeListener() {
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onAddItem(int i) {
            onAddItemInternal(i);
            TabsView.this.mSizeCalculator.headerItemsUpdated();
            TabsView.this.correctSelectionIfNeeded();
            TabsView.this.scrollToSelectedItem();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onRemoveItem(int i) {
            TabsView.this.mTabsLayout.removeView((View) TabsView.this.mTabItems.get(i));
            TabsView.this.mTabItems.remove(i);
            TabsView.this.mTabItemModels.remove(i);
            TabsView.this.mSizeCalculator.headerItemsUpdated();
            TabsView.this.correctSelectionIfNeeded();
            TabsView.this.scrollToSelectedItem();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onSetItem(int i) {
            HeaderItemModel headerItemModel = TabsView.this.getHeaderItemModel(i);
            TabsView.this.mTabItemModels.set(i, headerItemModel);
            ((TabItemView) TabsView.this.mTabItems.get(i)).setModel(headerItemModel, headerItemModel.getHeaderItemAppearance());
            TabsView.this.mSizeCalculator.headerItemsUpdated();
            TabsView.this.scrollToSelectedItem();
            TabsView.this.mTabsLayout.requestLayout();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onClearItems() {
            int i;
            Iterator it = TabsView.this.mTabItems.iterator();
            while (it.hasNext()) {
                TabsView.this.mTabsLayout.removeView((TabItemView) it.next());
            }
            TabsView.this.mTabItems.clear();
            TabsView.this.mTabItemModels.clear();
            if (TabsView.this.mAdapter.getItemsCount() != 0) {
                i = 0;
                for (int i2 = 0; i2 < TabsView.this.mAdapter.getItemsCount(); i2++) {
                    onAddItemInternal(i2);
                }
            } else {
                i = -1;
            }
            TabsView.this.mSizeCalculator.headerItemsUpdated();
            TabsView.this.selectItem(-1, i);
            TabsView.this.scrollToSelectedItem();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onHeaderTemplateChanged() {
            for (int i = 0; i < TabsView.this.mAdapter.getItemsCount(); i++) {
                HeaderItemModel headerItemModel = TabsView.this.getHeaderItemModel(i);
                TabsView.this.mTabItemModels.set(i, headerItemModel);
                ((TabItemView) TabsView.this.mTabItems.get(i)).setModel(headerItemModel, headerItemModel.getHeaderItemAppearance());
            }
            TabsView.this.mSizeCalculator.headerItemsUpdated();
            TabsView.this.scrollToSelectedItem();
            TabsView.this.mTabsLayout.requestLayout();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onHeaderContentChanged(int i) {
            HeaderItemModel headerItemModel = TabsView.this.getHeaderItemModel(i);
            TabsView.this.mTabItemModels.set(i, headerItemModel);
            ((TabItemView) TabsView.this.mTabItems.get(i)).setModel(headerItemModel, headerItemModel.getHeaderItemAppearance());
            TabsView.this.mSizeCalculator.headerItemsUpdated();
            TabsView.this.mTabsLayout.requestLayout();
        }

        private void onAddItemInternal(int i) {
            TabsView.this.addTabItem(i);
            TabsView.this.mTabsLayout.addView((View) TabsView.this.mTabItems.get(i));
        }
    }
}
