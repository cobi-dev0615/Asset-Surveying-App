package com.devexpress.navigation.pagercontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class DXViewPager extends ViewPager {
    private boolean mSwipeEnabled;

    public DXViewPager(Context context) {
        super(context);
        setId(View.generateViewId());
    }

    public DXViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mSwipeEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mSwipeEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setSwipeEnabled(boolean z) {
        this.mSwipeEnabled = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        PagerAdapter adapter;
        super.onAttachedToWindow();
        if (getChildCount() > 0 || isLayoutRequested() || (adapter = getAdapter()) == null || adapter.getCount() <= 0) {
            return;
        }
        requestLayout();
    }
}
