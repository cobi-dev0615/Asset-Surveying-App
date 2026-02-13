package com.devexpress.navigation.pagercontrol;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MyPagerControl extends LinearLayout {
    int mCurrentPageIndex;
    int mCurrentPageSize;
    GestureDetector mGestureDetector;
    LinearLayout mLayout;
    private GestureDetector.OnGestureListener mOnGesture;
    ArrayList<View> mPages;
    HorizontalScrollView mScroll;

    public MyPagerControl(Context context) {
        super(context);
        this.mPages = new ArrayList<>();
        this.mCurrentPageIndex = 0;
        this.mCurrentPageSize = 0;
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.navigation.pagercontrol.MyPagerControl.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
        init();
    }

    public MyPagerControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPages = new ArrayList<>();
        this.mCurrentPageIndex = 0;
        this.mCurrentPageSize = 0;
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.navigation.pagercontrol.MyPagerControl.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
        init();
    }

    public MyPagerControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPages = new ArrayList<>();
        this.mCurrentPageIndex = 0;
        this.mCurrentPageSize = 0;
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.navigation.pagercontrol.MyPagerControl.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
        init();
    }

    public MyPagerControl(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPages = new ArrayList<>();
        this.mCurrentPageIndex = 0;
        this.mCurrentPageSize = 0;
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.devexpress.navigation.pagercontrol.MyPagerControl.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
        init();
    }

    private void init() {
        setBackgroundColor(-16776961);
        recreateLayout();
    }

    public void recreateLayout() {
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
        this.mScroll = horizontalScrollView;
        addView(horizontalScrollView, -2, -1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.mLayout = linearLayout;
        this.mScroll.addView(linearLayout);
        this.mPages.add(createDefaultView(SupportMenu.CATEGORY_MASK));
        this.mPages.add(createDefaultView(Color.rgb(255, 165, 0)));
        this.mPages.add(createDefaultView(InputDeviceCompat.SOURCE_ANY));
        this.mPages.add(createDefaultView(-16711936));
        this.mPages.add(createDefaultView(-16776961));
        this.mPages.add(createDefaultView(Color.rgb(238, 130, 238)));
        Iterator<View> it = this.mPages.iterator();
        while (it.hasNext()) {
            linearLayout.addView(it.next());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Iterator<View> it = this.mPages.iterator();
        while (it.hasNext()) {
            it.next().setLayoutParams(new LinearLayout.LayoutParams(getMeasuredWidth(), getMeasuredHeight()));
        }
        this.mCurrentPageSize = getMeasuredWidth();
    }

    private View createDefaultView(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(i);
        return linearLayout;
    }

    public void moveToPrevPage() {
        this.mCurrentPageIndex--;
        this.mLayout.animate().translationX((-this.mCurrentPageIndex) * this.mCurrentPageSize);
    }

    public void moveToNextPage() {
        this.mPages.size();
        this.mCurrentPageIndex++;
        this.mLayout.animate().translationX((-this.mCurrentPageIndex) * this.mCurrentPageSize);
    }
}
