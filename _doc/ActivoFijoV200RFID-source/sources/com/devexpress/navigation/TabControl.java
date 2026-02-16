package com.devexpress.navigation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.viewpager.widget.ViewPager;
import com.devexpress.dxcore.DXNativeView;
import com.devexpress.navigation.TabsView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabcontrol.ITabControlAdapter;
import com.devexpress.navigation.tabcontrol.TabControlAppearance;
import com.devexpress.navigation.tabs.models.CancelEventArgs;
import com.devexpress.navigation.tabs.models.HeaderItemModel;
import com.devexpress.navigation.tabs.models.SelectedStyleProperty;
import com.devexpress.navigation.tabs.models.StyleProperty;
import com.devexpress.navigation.tabs.models.TabItemSettings;
import com.devexpress.navigation.tabs.utils.SizeConverter;
import com.devexpress.navigation.tabs.views.TabItemView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TabControl extends DXNativeView {
    TabControlAppearance.OnAppearancePropertyChangeListener listenerAppearance;
    private ITabControlAdapter mAdapter;
    private TabControlAppearance mAppearance;
    private List<OnTabItemSelectedListener> mOnTabItemSelectedListeners;
    private List<OnTabItemTappedListener> mOnTabItemTappedListeners;
    private ViewPager.OnPageChangeListener mPageChangeListener;
    private PagerControl mPager;
    private Position mPosition;
    private int mSelectedIndex;
    private SizeConverter mSizeConverter;
    private TabsView mTabsView;

    public interface OnTabItemSelectedListener {
        void onTabItemSelected(int i, int i2);
    }

    public interface OnTabItemTappedListener {
        void onTabItemTapped(int i, CancelEventArgs cancelEventArgs);
    }

    public TabControl(Context context) {
        this(context, null);
    }

    public TabControl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnTabItemSelectedListeners = new ArrayList();
        this.mOnTabItemTappedListeners = new ArrayList();
        this.mAppearance = null;
        this.mSelectedIndex = -1;
        this.listenerAppearance = new TabControlAppearance.OnAppearancePropertyChangeListener() { // from class: com.devexpress.navigation.TabControl.4
            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemSelectedPropertyChanged(SelectedStyleProperty selectedStyleProperty) {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemPaddingPropertyChanged() {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemSpacingPropertyChanged() {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemCornerRadiusPropertyChanged() {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onItemStylePropertyChanged(StyleProperty styleProperty) {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelIndentPropertyChanged() {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelSpacingPropertyChanged() {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelPaddingPropertyChanged() {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onPanelBackgroundPropertyChanged() {
                TabControl.this.invalidate();
            }

            @Override // com.devexpress.navigation.tabcontrol.TabControlAppearance.OnAppearancePropertyChangeListener
            public void onIndicatorPropertyChanged() {
                TabControl.this.invalidate();
            }
        };
        initialize();
        setWillNotDraw(false);
    }

    public int getItemsCount() {
        ITabControlAdapter iTabControlAdapter = this.mAdapter;
        if (iTabControlAdapter != null) {
            return iTabControlAdapter.getItemsCount();
        }
        return 0;
    }

    public void setAdapter(ITabControlAdapter iTabControlAdapter) {
        if (this.mAdapter != iTabControlAdapter) {
            this.mAdapter = iTabControlAdapter;
            this.mPager.setAdapter(iTabControlAdapter);
            this.mTabsView.setAdapter(this.mAdapter, this);
        }
    }

    public ITabControlAdapter getAdapter() {
        return this.mAdapter;
    }

    public HeaderItemModel getSelectedItem() {
        return (HeaderItemModel) this.mTabsView.getSelectedItem(this.mSelectedIndex);
    }

    public void setSelectedItem(HeaderItemModel headerItemModel) {
        setSelectedItemIndex(this.mTabsView.getTabItemModels().indexOf(headerItemModel));
    }

    public int getSelectedItemIndex() {
        return this.mSelectedIndex;
    }

    public void setSelectedItemIndex(int i) {
        if (i < 0 || this.mSelectedIndex == i) {
            return;
        }
        this.mSelectedIndex = i;
        this.mTabsView.setSelectedItemIndex(i);
        this.mPager.setSelectedPage(i);
    }

    public TabsView getTabsView() {
        return this.mTabsView;
    }

    public void setHeaderPanelPosition(Position position) {
        if (this.mPosition != position) {
            this.mPosition = position;
            this.mTabsView.setPosition(position);
        }
    }

    public Position getHeaderPanelPosition() {
        return this.mPosition;
    }

    public void setHeaderPanelContentAlignment(int i) {
        this.mTabsView.setTabsAlignment(i);
    }

    public int getHeaderPanelContentAlignment() {
        return this.mTabsView.getTabsAlignment();
    }

    public boolean getScrollAnimationEnabled() {
        return this.mPager.getAnimateScrollEnabled();
    }

    public void setScrollAnimationEnabled(boolean z) {
        this.mPager.setAnimateScrollEnabled(z);
        this.mTabsView.setAnimateIndicatorEnabled(z);
    }

    public boolean getSwipeEnabled() {
        return this.mPager.getSwipeEnabled();
    }

    public void setSwipeEnabled(boolean z) {
        this.mPager.setSwipeEnabled(z);
    }

    public boolean getLoopEnabled() {
        return this.mPager.getLoopEnabled();
    }

    public void setLoopEnabled(boolean z) {
        this.mPager.setLoopEnabled(z);
        this.mPager.setSelectedPage(this.mTabsView.getSelectedItemIndex());
    }

    public int getScrollDirection() {
        return this.mPager.getPagerOrientation();
    }

    public void setScrollDirection(int i) {
        this.mPager.setPagerOrientation(i);
        this.mPager.setSelectedPage(this.mTabsView.getSelectedItemIndex());
    }

    public float getHeaderPanelHeight() {
        return this.mSizeConverter.convertPxToDp(this.mTabsView.getHorizontalLayoutHeight());
    }

    public void setHeaderPanelHeight(float f) {
        this.mTabsView.setHorizontalLayoutHeight(this.mSizeConverter.convertDpToPx(f));
    }

    public float getHeaderPanelWidth() {
        return this.mSizeConverter.convertPxToDp(this.mTabsView.getVerticalLayoutWidth());
    }

    public void setHeaderPanelWidth(float f) {
        this.mTabsView.setVerticalLayoutWidth(this.mSizeConverter.convertDpToPx(f));
    }

    public float getHeaderPanelMinHeight() {
        return this.mSizeConverter.convertPxToDp(this.mTabsView.getMinHeight());
    }

    public void setHeaderPanelMinHeight(float f) {
        this.mTabsView.setMinHeight(this.mSizeConverter.convertDpToPx(f));
    }

    public float getHeaderPanelMaxHeight() {
        return this.mSizeConverter.convertPxToDp(this.mTabsView.getMaxHeight());
    }

    public void setHeaderPanelMaxHeight(float f) {
        this.mTabsView.setMaxHeight(this.mSizeConverter.convertDpToPx(f));
    }

    public float getHeaderPanelMinWidth() {
        return this.mSizeConverter.convertPxToDp(this.mTabsView.getMinWidth());
    }

    public void setHeaderPanelMinWidth(float f) {
        this.mTabsView.setMinWidth(this.mSizeConverter.convertDpToPx(f));
    }

    public float getHeaderPanelMaxWidth() {
        return this.mSizeConverter.convertPxToDp(this.mTabsView.getMaxWidth());
    }

    public void setHeaderPanelMaxWidth(float f) {
        this.mTabsView.setMaxWidth(this.mSizeConverter.convertDpToPx(f));
    }

    public TabItemSettings getHeaderSettings() {
        return this.mTabsView.getHeaderSettings();
    }

    public void addOnTabItemSelectedListener(OnTabItemSelectedListener onTabItemSelectedListener) {
        this.mOnTabItemSelectedListeners.add(onTabItemSelectedListener);
    }

    public void removeOnTabItemSelectedListener(OnTabItemSelectedListener onTabItemSelectedListener) {
        this.mOnTabItemSelectedListeners.remove(onTabItemSelectedListener);
    }

    public void clearOnTabItemSelectedListener() {
        this.mOnTabItemSelectedListeners.clear();
    }

    public void addOnTabItemTappedListener(OnTabItemTappedListener onTabItemTappedListener) {
        this.mOnTabItemTappedListeners.add(onTabItemTappedListener);
    }

    public void removeOnTabItemTappedListener(OnTabItemTappedListener onTabItemTappedListener) {
        this.mOnTabItemTappedListeners.remove(onTabItemTappedListener);
    }

    public void clearOnTabItemTappedListener() {
        this.mOnTabItemTappedListeners.clear();
    }

    private void initialize() {
        this.mSizeConverter = new SizeConverter(getContext().getResources().getDisplayMetrics().density);
        this.mPager = new PagerControl(getContext());
        this.mTabsView = new TabsView(getContext(), getAppearance());
        this.mPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.devexpress.navigation.TabControl.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                TabControl.this.mSelectedIndex = i;
                if (TabControl.this.mTabsView.getSelectedItemIndex() != i) {
                    TabControl.this.mTabsView.setSelectedItemIndex(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                TabControl.this.mSelectedIndex = i;
                TabControl.this.mTabsView.onPageScrolled(i, f, i2);
            }
        };
        this.mTabsView.addOnTabSelectedListener(new TabsView.OnTabSelectedListener() { // from class: com.devexpress.navigation.TabControl.2
            @Override // com.devexpress.navigation.TabsView.OnTabSelectedListener
            public void onTabSelected(TabItemView tabItemView, int i, int i2) {
                TabControl.this.mSelectedIndex = i;
                if (TabControl.this.mPager.getSelectedPage() != i) {
                    TabControl.this.mPager.setSelectedPage(i);
                }
                Iterator it = TabControl.this.mOnTabItemSelectedListeners.iterator();
                while (it.hasNext()) {
                    ((OnTabItemSelectedListener) it.next()).onTabItemSelected(i2, i);
                }
            }
        });
        this.mTabsView.addOnTabTappedListener(new TabsView.OnTabTappedListener() { // from class: com.devexpress.navigation.TabControl.3
            @Override // com.devexpress.navigation.TabsView.OnTabTappedListener
            public boolean onTabTapped(int i) {
                CancelEventArgs cancelEventArgs = new CancelEventArgs();
                Iterator it = TabControl.this.mOnTabItemTappedListeners.iterator();
                while (it.hasNext()) {
                    ((OnTabItemTappedListener) it.next()).onTabItemTapped(i, cancelEventArgs);
                    if (cancelEventArgs.getCancel()) {
                        return true;
                    }
                }
                return false;
            }
        });
        this.mPager.addOnPageChangeListener(this.mPageChangeListener);
        addView(this.mTabsView);
        addView(this.mPager);
        setHeaderPanelPosition(Position.Top);
    }

    public void setAppearance(TabControlAppearance tabControlAppearance) {
        TabControlAppearance tabControlAppearance2 = this.mAppearance;
        if (tabControlAppearance2 != null) {
            tabControlAppearance2.removeOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
        this.mAppearance = tabControlAppearance;
        tabControlAppearance.addOnAppearanceProperyChangeListener(this.listenerAppearance);
        TabsView tabsView = this.mTabsView;
        if (tabsView != null) {
            tabsView.setAppearance(this.mAppearance);
        }
        ITabControlAdapter iTabControlAdapter = this.mAdapter;
        if (iTabControlAdapter != null) {
            Iterator<HeaderItemModel> it = iTabControlAdapter.getHeaderViews(this).iterator();
            while (it.hasNext()) {
                it.next().changeTabControlAppearance(this.mAppearance);
            }
        }
        invalidate();
    }

    public TabControlAppearance getAppearance() {
        if (this.mAppearance == null) {
            TabControlAppearance tabControlAppearance = new TabControlAppearance();
            this.mAppearance = tabControlAppearance;
            tabControlAppearance.addOnAppearanceProperyChangeListener(this.listenerAppearance);
        }
        return this.mAppearance;
    }

    public int getIndicatorScrollAlignment() {
        return this.mTabsView.getIndicatorScrollAlignment();
    }

    public void setIndicatorScrollAlignment(int i) {
        this.mTabsView.setIndicatorScrollAlignment(i);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected Size onMeasureCore(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode2 == 0) {
            return new Size(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mTabsView.setViewPort(size, size2);
        this.mTabsView.measure(i, i2);
        if (this.mPosition == Position.Top || this.mPosition == Position.Bottom) {
            this.mPager.measure(i, View.MeasureSpec.makeMeasureSpec(Math.max(size2 - this.mTabsView.getPanelCrossSize(), 0), BasicMeasure.EXACTLY));
        } else {
            this.mPager.measure(View.MeasureSpec.makeMeasureSpec(Math.max(size - this.mTabsView.getPanelCrossSize(), 0), BasicMeasure.EXACTLY), i2);
        }
        return new Size(size, size2);
    }

    /* renamed from: com.devexpress.navigation.TabControl$5, reason: invalid class name */
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i4 - i2;
        int i6 = i3 - i;
        int i7 = AnonymousClass5.$SwitchMap$com$devexpress$navigation$common$Position[this.mPosition.ordinal()];
        if (i7 == 1) {
            TabsView tabsView = this.mTabsView;
            tabsView.layout(0, 0, tabsView.getPanelCrossSize(), i5);
            this.mPager.layout(this.mTabsView.getPanelCrossSize(), 0, i6, i5);
        } else if (i7 == 2) {
            this.mPager.layout(0, 0, i6 - this.mTabsView.getPanelCrossSize(), i5);
            TabsView tabsView2 = this.mTabsView;
            tabsView2.layout(i6 - tabsView2.getPanelCrossSize(), 0, i6, i5);
        } else if (i7 == 3) {
            this.mPager.layout(0, 0, i6, i5 - this.mTabsView.getPanelCrossSize());
            TabsView tabsView3 = this.mTabsView;
            tabsView3.layout(0, i5 - tabsView3.getPanelCrossSize(), i6, i5);
        } else {
            TabsView tabsView4 = this.mTabsView;
            tabsView4.layout(0, 0, i6, tabsView4.getPanelCrossSize());
            this.mPager.layout(0, this.mTabsView.getPanelCrossSize(), i6, i5);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (view == this.mPager) {
            drawHeaderPanelShadow(canvas);
        }
        return drawChild;
    }

    private void drawHeaderPanelShadow(Canvas canvas) {
        int i;
        int i2;
        TabControlAppearance appearance = getAppearance();
        if (!appearance.getHeaderPanelShadowVisibility() || appearance.getHeaderPanelShadowHeight() == 0.0f) {
            return;
        }
        int convertDpToPx = SizeConverter.convertDpToPx(getContext(), appearance.getHeaderPanelShadowHeight());
        int convertDpToPx2 = appearance.getHeaderPanelShadowRadius() != -1 ? SizeConverter.convertDpToPx(getContext(), appearance.getHeaderPanelShadowRadius()) : convertDpToPx;
        int i3 = convertDpToPx - convertDpToPx2;
        if (i3 < 0) {
            i2 = (int) (255 * (convertDpToPx / convertDpToPx2));
            i = 0;
        } else {
            drawHeaderPanelShadowFiller(canvas, i3, appearance.getHeaderPanelShadowColorStart());
            i = i3;
            i2 = 255;
        }
        drawHeaderPanelShadowGradient(canvas, i2, i, convertDpToPx, appearance.getHeaderPanelShadowColorStart());
    }

    private void drawHeaderPanelShadowGradient(Canvas canvas, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        int i5 = AnonymousClass5.$SwitchMap$com$devexpress$navigation$common$Position[this.mTabsView.getPosition().ordinal()];
        if (i5 == 1) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            rect.left = i2;
            rect.right = i3;
            rect.bottom = this.mTabsView.getHeight();
            rect.offset(this.mTabsView.getWidth(), 0);
        } else if (i5 == 2) {
            orientation = GradientDrawable.Orientation.RIGHT_LEFT;
            rect.left = -i3;
            rect.right = -i2;
            rect.bottom = this.mTabsView.getHeight();
            rect.offset(this.mTabsView.getLeft(), 0);
        } else if (i5 == 3) {
            orientation = GradientDrawable.Orientation.BOTTOM_TOP;
            rect.top = -i3;
            rect.bottom = -i2;
            rect.right = this.mTabsView.getWidth();
            rect.offset(0, this.mTabsView.getTop());
        } else if (i5 == 4) {
            rect.top = i2;
            rect.bottom = i3;
            rect.right = this.mTabsView.getWidth();
            rect.offset(0, this.mTabsView.getBottom());
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{i4, 0});
        gradientDrawable.setBounds(rect);
        gradientDrawable.setAlpha(i);
        gradientDrawable.draw(canvas);
    }

    private void drawHeaderPanelShadowFiller(Canvas canvas, int i, int i2) {
        Rect rect = new Rect();
        int i3 = AnonymousClass5.$SwitchMap$com$devexpress$navigation$common$Position[this.mTabsView.getPosition().ordinal()];
        if (i3 == 1) {
            rect.left = this.mTabsView.getWidth();
            rect.right = rect.left + i;
            rect.bottom = this.mTabsView.getHeight();
        } else if (i3 == 2) {
            rect.left = this.mTabsView.getLeft() - i;
            rect.right = this.mTabsView.getLeft();
            rect.bottom = this.mTabsView.getHeight();
        } else if (i3 == 3) {
            rect.top = this.mTabsView.getTop() - i;
            rect.bottom = this.mTabsView.getTop();
            rect.right = this.mTabsView.getWidth();
        } else if (i3 == 4) {
            rect.top = this.mTabsView.getHeight();
            rect.bottom = rect.top + i;
            rect.right = this.mTabsView.getWidth();
        }
        Paint paint = new Paint();
        paint.setColor(i2);
        canvas.drawRect(rect, paint);
    }
}
