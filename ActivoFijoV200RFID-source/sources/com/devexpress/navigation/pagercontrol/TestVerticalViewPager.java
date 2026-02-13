package com.devexpress.navigation.pagercontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class TestVerticalViewPager extends DXViewPager {
    boolean mIsHorizontal;

    public TestVerticalViewPager(Context context) {
        super(context);
        this.mIsHorizontal = false;
        init();
    }

    public TestVerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsHorizontal = false;
        init();
    }

    private void init() {
        setPageTransformer(true, new VerticalPageTransformer());
        setOverScrollMode(2);
    }

    public void setOrientation(boolean z) {
        if (this.mIsHorizontal != z) {
            this.mIsHorizontal = z;
            if (z) {
                setPageTransformer(false, null);
            } else {
                setPageTransformer(true, new VerticalPageTransformer());
            }
        }
    }

    private class VerticalPageTransformer implements ViewPager.PageTransformer {
        private VerticalPageTransformer() {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f) {
            if (f < -1.0f) {
                view.setAlpha(0.0f);
            } else {
                if (f <= 1.0f) {
                    view.setAlpha(1.0f);
                    view.setTranslationX(view.getWidth() * (-f));
                    view.setTranslationY(f * view.getHeight());
                    return;
                }
                view.setAlpha(0.0f);
            }
        }
    }

    private MotionEvent swapXY(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    @Override // com.devexpress.navigation.pagercontrol.DXViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mIsHorizontal) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(swapXY(motionEvent));
        swapXY(motionEvent);
        return onInterceptTouchEvent;
    }

    @Override // com.devexpress.navigation.pagercontrol.DXViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsHorizontal) {
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(swapXY(motionEvent));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
