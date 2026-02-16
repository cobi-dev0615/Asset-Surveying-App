package com.devexpress.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.devexpress.navigation.pagercontrol.DXViewPager;
import com.devexpress.navigation.pagercontrol.InternalPagerControlAdapter;
import com.devexpress.navigation.pagercontrol.InternalPagerFragmentAdapter;
import com.devexpress.navigation.pagercontrol.PagePositionProvider;
import com.devexpress.navigation.pagercontrol.TestVerticalViewPager;
import com.devexpress.navigation.tabcontrol.ITabControlAdapter;
import com.devexpress.navigation.tabs.utils.ResetFlag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PagerControl extends ViewGroup {
    private PagerAdapter mAdapter;
    private boolean mAnimateScrollEnabled;
    private ITabControlAdapter mBaseAdapter;
    private boolean mLoopEnabled;
    private final ViewPager.OnPageChangeListener mOnPageChangeListener;
    private final List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
    private int mOrientation;
    private final PagePositionProvider mPagePositionProvider;
    private DXViewPager mPager;
    private final ResetFlag mResetFlag;
    private int mSelectedIndex;
    private boolean mSwipeEnabled;

    public PagerControl(Context context) {
        super(context);
        this.mSwipeEnabled = true;
        this.mAnimateScrollEnabled = true;
        this.mLoopEnabled = false;
        this.mOrientation = 0;
        this.mOnPageChangeListeners = new ArrayList();
        this.mOnPageChangeListener = createPageChangedListener();
        this.mSelectedIndex = 0;
        this.mPagePositionProvider = new PagePositionProvider();
        this.mResetFlag = new ResetFlag();
        init();
    }

    public PagerControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSwipeEnabled = true;
        this.mAnimateScrollEnabled = true;
        this.mLoopEnabled = false;
        this.mOrientation = 0;
        this.mOnPageChangeListeners = new ArrayList();
        this.mOnPageChangeListener = createPageChangedListener();
        this.mSelectedIndex = 0;
        this.mPagePositionProvider = new PagePositionProvider();
        this.mResetFlag = new ResetFlag();
        init();
    }

    public PagerControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSwipeEnabled = true;
        this.mAnimateScrollEnabled = true;
        this.mLoopEnabled = false;
        this.mOrientation = 0;
        this.mOnPageChangeListeners = new ArrayList();
        this.mOnPageChangeListener = createPageChangedListener();
        this.mSelectedIndex = 0;
        this.mPagePositionProvider = new PagePositionProvider();
        this.mResetFlag = new ResetFlag();
        init();
    }

    public PagerControl(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSwipeEnabled = true;
        this.mAnimateScrollEnabled = true;
        this.mLoopEnabled = false;
        this.mOrientation = 0;
        this.mOnPageChangeListeners = new ArrayList();
        this.mOnPageChangeListener = createPageChangedListener();
        this.mSelectedIndex = 0;
        this.mPagePositionProvider = new PagePositionProvider();
        this.mResetFlag = new ResetFlag();
        init();
    }

    public boolean getSwipeEnabled() {
        return this.mSwipeEnabled;
    }

    public void setSwipeEnabled(boolean z) {
        this.mSwipeEnabled = z;
        DXViewPager dXViewPager = this.mPager;
        if (dXViewPager != null) {
            dXViewPager.setSwipeEnabled(z);
        }
    }

    public boolean getAnimateScrollEnabled() {
        return this.mAnimateScrollEnabled;
    }

    public void setAnimateScrollEnabled(boolean z) {
        this.mAnimateScrollEnabled = z;
    }

    public boolean getLoopEnabled() {
        return this.mLoopEnabled;
    }

    public void setLoopEnabled(boolean z) {
        if (this.mLoopEnabled != z) {
            this.mLoopEnabled = z;
            recreateLayout();
        }
    }

    public int getPagerOrientation() {
        return this.mOrientation;
    }

    public void setPagerOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            recreateLayout();
        }
    }

    public void setAdapter(ITabControlAdapter iTabControlAdapter) {
        if (this.mBaseAdapter != iTabControlAdapter) {
            this.mBaseAdapter = iTabControlAdapter;
            if (iTabControlAdapter == null) {
                this.mAdapter = null;
            } else {
                iTabControlAdapter.addItemsSetChangedListener(new ItemSetChangedListener());
            }
            recreateLayout();
        }
    }

    public ITabControlAdapter getAdapter() {
        return this.mBaseAdapter;
    }

    public void setSelectedPage(int i) {
        this.mSelectedIndex = i;
        this.mPager.clearFocus();
        DXViewPager dXViewPager = this.mPager;
        if (dXViewPager != null) {
            dXViewPager.setCurrentItem(this.mSelectedIndex, this.mAnimateScrollEnabled);
        }
    }

    public int getSelectedPage() {
        return this.mSelectedIndex;
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void clear() {
        DXViewPager dXViewPager = this.mPager;
        if (dXViewPager != null) {
            dXViewPager.removeOnPageChangeListener(this.mOnPageChangeListener);
            this.mPager.setAdapter(null);
        }
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            if (this.mBaseAdapter != null) {
                pagerAdapter.notifyDataSetChanged();
            }
            this.mAdapter = null;
        }
        if (getChildCount() > 0) {
            removeAllViews();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mPager.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.mPager.measure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    private void init() {
        recreateLayout();
    }

    private void recreateLayout() {
        clear();
        if (this.mBaseAdapter == null) {
            return;
        }
        if (this.mOrientation == 0) {
            this.mPager = new DXViewPager(getContext());
        } else {
            this.mPager = new TestVerticalViewPager(getContext());
        }
        this.mPager.setSwipeEnabled(this.mSwipeEnabled);
        this.mPager.addOnPageChangeListener(this.mOnPageChangeListener);
        if (this.mAdapter == null) {
            this.mResetFlag.setReset(false);
            if (this.mBaseAdapter.isFragmentAdapter()) {
                this.mAdapter = new InternalPagerFragmentAdapter(this.mBaseAdapter, (FragmentManager) this.mBaseAdapter.getFragmentManager(), this.mPagePositionProvider, this.mResetFlag);
            } else {
                this.mAdapter = new InternalPagerControlAdapter(this.mBaseAdapter, this.mPagePositionProvider, this.mResetFlag);
            }
        }
        this.mPager.setAdapter(this.mAdapter);
        this.mPager.clearFocus();
        this.mPager.setCurrentItem(this.mSelectedIndex, this.mAnimateScrollEnabled);
        if (this.mLoopEnabled) {
            this.mPager.setCurrentItem(this.mSelectedIndex, this.mAnimateScrollEnabled);
        }
        addView(this.mPager, -1, -1);
        requestLayout();
        invalidate();
    }

    private ViewPager.OnPageChangeListener createPageChangedListener() {
        return new ViewPager.OnPageChangeListener() { // from class: com.devexpress.navigation.PagerControl.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                Iterator it = PagerControl.this.mOnPageChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PagerControl.this.mSelectedIndex = i;
                Iterator it = PagerControl.this.mOnPageChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageSelected(PagerControl.this.mSelectedIndex);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                Iterator it = PagerControl.this.mOnPageChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrollStateChanged(i);
                }
            }
        };
    }

    class ItemSetChangedListener implements ITabControlAdapter.ItemsChangedListener {
        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onHeaderContentChanged(int i) {
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onHeaderTemplateChanged() {
        }

        ItemSetChangedListener() {
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onAddItem(int i) {
            if (PagerControl.this.mAdapter == null) {
                return;
            }
            PagerControl.this.mAdapter.notifyDataSetChanged();
            PagerControl.this.mPager.requestLayout();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onRemoveItem(int i) {
            if (PagerControl.this.mAdapter == null) {
                return;
            }
            PagerControl.this.mPagePositionProvider.setChangedPagePosition(i);
            PagerControl.this.mAdapter.notifyDataSetChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onSetItem(int i) {
            if (PagerControl.this.mAdapter == null) {
                return;
            }
            PagerControl.this.mAdapter.notifyDataSetChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onClearItems() {
            if (PagerControl.this.mAdapter == null) {
                return;
            }
            PagerControl.this.mResetFlag.setReset(true);
            PagerControl.this.mAdapter.notifyDataSetChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onContentTemplateChanged() {
            if (PagerControl.this.mAdapter == null) {
                return;
            }
            PagerControl.this.mResetFlag.setReset(true);
            PagerControl.this.mAdapter.notifyDataSetChanged();
        }

        @Override // com.devexpress.navigation.tabcontrol.ITabControlAdapter.ItemsChangedListener
        public void onContentChanged(int i) {
            if (PagerControl.this.mAdapter == null) {
                return;
            }
            PagerControl.this.mPagePositionProvider.setChangedPagePosition(i);
            PagerControl.this.mAdapter.notifyDataSetChanged();
            PagerControl.this.mPagePositionProvider.reset();
        }
    }
}
