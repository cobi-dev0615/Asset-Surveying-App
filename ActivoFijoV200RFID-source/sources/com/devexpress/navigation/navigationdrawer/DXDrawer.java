package com.devexpress.navigation.navigationdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.widget.NestedScrollView;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.models.TabSizeInPixels;
import com.devexpress.navigation.tabs.utils.SizeConverter;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class DXDrawer extends ViewGroup {
    DrawerSize mDrawerCalculatedSize;
    ArrayList<DXDrawerChild> mDrawerChildren;
    private View mDrawerContent;
    private TabSize mDrawerContentHeight;
    private TabSizeInPixels mDrawerContentHeightPx;
    private View mDrawerFooterContent;
    private TabSize mDrawerFooterContentHeight;
    private TabSizeInPixels mDrawerFooterContentHeightPx;
    private View mDrawerHeaderContent;
    private TabSize mDrawerHeaderContentHeight;
    private TabSizeInPixels mDrawerHeaderContentHeightPx;
    private TabSize mDrawerSize;
    private TabSizeInPixels mDrawerSizePx;
    private boolean mIsHorizontal;
    private int mMeasuredDrawerSize;
    DrawerSizeCalculator mSizeCalculator;
    SizeConverter mSizeConverter;
    private int mViewPortHeight;
    private int mViewPortWidth;
    private YViewCache mYViewCache;

    class DXDrawerChild {
        public boolean isMeasured = false;
        public TabSize sizeDP;
        public TabSizeInPixels sizePx;
        public View view;

        DXDrawerChild() {
        }
    }

    class DrawerSize {
        public int Height;
        public int MaxWidth;
        public int MeasureHeightSpec;
        public int MeasureWidthSpec;
        public int RealHeight;
        public int RealWidth;
        public int Width;

        DrawerSize() {
        }
    }

    public TabSize getDrawerContentHeight() {
        return this.mDrawerContentHeight;
    }

    public TabSize getDrawerHeaderContentHeight() {
        return this.mDrawerHeaderContentHeight;
    }

    public TabSize getDrawerFooterContentHeight() {
        return this.mDrawerFooterContentHeight;
    }

    public TabSize getDrawerSize() {
        return this.mDrawerSize;
    }

    public int getRealWidth() {
        return this.mDrawerCalculatedSize.RealWidth;
    }

    public int getRealHeight() {
        return this.mDrawerCalculatedSize.RealHeight;
    }

    public void setDrawerContentHeight(TabSize tabSize) {
        if (this.mDrawerContentHeight != tabSize) {
            this.mDrawerContentHeight = tabSize;
            this.mDrawerContentHeightPx = this.mSizeConverter.convertSize(tabSize);
            relayoutAll();
        }
    }

    public void setDrawerHeaderContentHeight(TabSize tabSize) {
        if (this.mDrawerHeaderContentHeight != tabSize) {
            this.mDrawerHeaderContentHeight = tabSize;
            this.mDrawerHeaderContentHeightPx = this.mSizeConverter.convertSize(tabSize);
            relayoutAll();
        }
    }

    public void setDrawerFooterContentHeight(TabSize tabSize) {
        if (this.mDrawerFooterContentHeight != tabSize) {
            this.mDrawerFooterContentHeight = tabSize;
            this.mDrawerFooterContentHeightPx = this.mSizeConverter.convertSize(tabSize);
            relayoutAll();
        }
    }

    public void setDrawerSize(TabSize tabSize) {
        if (this.mDrawerSize != tabSize) {
            this.mDrawerSize = tabSize;
            this.mDrawerSizePx = this.mSizeConverter.convertSize(tabSize);
            DrawerSizeCalculator drawerSizeCalculator = this.mSizeCalculator;
            if (drawerSizeCalculator != null) {
                drawerSizeCalculator.setSize(this.mDrawerSize);
            }
            relayoutAll();
        }
    }

    public DXDrawer(Context context) {
        super(context);
        this.mIsHorizontal = true;
        this.mDrawerChildren = new ArrayList<>();
        this.mDrawerCalculatedSize = new DrawerSize();
        initialize();
    }

    public DXDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsHorizontal = true;
        this.mDrawerChildren = new ArrayList<>();
        this.mDrawerCalculatedSize = new DrawerSize();
        initialize();
    }

    public DXDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsHorizontal = true;
        this.mDrawerChildren = new ArrayList<>();
        this.mDrawerCalculatedSize = new DrawerSize();
        initialize();
    }

    public DXDrawer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsHorizontal = true;
        this.mDrawerChildren = new ArrayList<>();
        this.mDrawerCalculatedSize = new DrawerSize();
    }

    private void initialize() {
        this.mSizeConverter = new SizeConverter(getResources().getDisplayMetrics().density);
        setDrawerContentHeight(TabSize.Star());
        setDrawerHeaderContentHeight(TabSize.Auto());
        setDrawerFooterContentHeight(TabSize.Auto());
        setDrawerSize(TabSize.Auto());
    }

    public void setSizeCalculator(DrawerSizeCalculator drawerSizeCalculator) {
        this.mSizeCalculator = drawerSizeCalculator;
    }

    public void refill(View view, View view2, View view3) {
        if (view == this.mDrawerContent && view2 == this.mDrawerHeaderContent && view3 == this.mDrawerFooterContent) {
            return;
        }
        removeAllViews();
        this.mDrawerContent = view;
        this.mDrawerHeaderContent = view2;
        this.mDrawerFooterContent = view3;
        if (view2 != null) {
            addView(view2, -2, -2);
        }
        View view4 = this.mDrawerContent;
        if (view4 != null) {
            addView(view4, -2, -2);
        }
        View view5 = this.mDrawerFooterContent;
        if (view5 != null) {
            addView(view5, -2, -2);
        }
        fillChildScrollableView();
        relayoutAll();
    }

    public void setViewPort(int i, int i2) {
        this.mViewPortWidth = i;
        this.mViewPortHeight = i2;
    }

    public void setPosition(Position position) {
        boolean z = position == Position.Left || position == Position.Right;
        if (z != this.mIsHorizontal) {
            this.mIsHorizontal = z;
            relayoutAll();
        }
    }

    private int getHeightSpec(TabSizeInPixels tabSizeInPixels, int i) {
        if (!tabSizeInPixels.getIsAuto()) {
            return View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY);
        }
        if (i <= 0) {
            return View.MeasureSpec.makeMeasureSpec(ModuleDescriptor.MODULE_VERSION, 0);
        }
        if (i == tabSizeInPixels.getMinSize()) {
            return View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY);
        }
        return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
    }

    private void refillDrawerChildren() {
        this.mDrawerChildren.clear();
        addChild(this.mDrawerChildren, this.mDrawerHeaderContent, this.mDrawerHeaderContentHeight, this.mDrawerHeaderContentHeightPx);
        addChild(this.mDrawerChildren, this.mDrawerContent, this.mDrawerContentHeight, this.mDrawerContentHeightPx);
        addChild(this.mDrawerChildren, this.mDrawerFooterContent, this.mDrawerFooterContentHeight, this.mDrawerFooterContentHeightPx);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int calculateMaxSize;
        boolean z;
        int size;
        int correctItemSize;
        int makeMeasureSpec;
        refillDrawerChildren();
        DrawerSize drawerSize = new DrawerSize();
        if (this.mIsHorizontal) {
            calculateMaxSize = this.mViewPortHeight;
            drawerSize.MaxWidth = this.mSizeCalculator.calculateMaxSize(this.mViewPortWidth);
            drawerSize.MeasureWidthSpec = View.MeasureSpec.makeMeasureSpec(drawerSize.MaxWidth, Integer.MIN_VALUE);
        } else {
            drawerSize.MaxWidth = this.mViewPortWidth;
            drawerSize.Width = this.mViewPortWidth;
            drawerSize.MeasureWidthSpec = View.MeasureSpec.makeMeasureSpec(drawerSize.MaxWidth, Integer.MIN_VALUE);
            calculateMaxSize = this.mSizeCalculator.calculateMaxSize(this.mViewPortHeight);
        }
        Iterator<DXDrawerChild> it = this.mDrawerChildren.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            DXDrawerChild next = it.next();
            if (next.sizeDP.getIsStar()) {
                i3 += Math.max(0, next.sizePx.getMinSize());
            } else {
                measureChild(next, next.sizePx.getSize(), drawerSize);
            }
        }
        if (i3 + drawerSize.Height >= calculateMaxSize) {
            Iterator<DXDrawerChild> it2 = this.mDrawerChildren.iterator();
            while (it2.hasNext()) {
                DXDrawerChild next2 = it2.next();
                if (next2.sizeDP.getIsStar()) {
                    measureChild(next2, next2.sizePx.getMinSize(), drawerSize);
                }
            }
        } else {
            Iterator<DXDrawerChild> it3 = this.mDrawerChildren.iterator();
            float f = 0.0f;
            while (it3.hasNext()) {
                DXDrawerChild next3 = it3.next();
                if (next3.sizeDP.getIsStar()) {
                    f += next3.sizeDP.getSize();
                }
            }
            if (f > 0.0f) {
                float f2 = (calculateMaxSize - drawerSize.Height) / f;
                DXDrawerChild dXDrawerChild = null;
                for (boolean z2 = true; z2; z2 = z) {
                    Iterator<DXDrawerChild> it4 = this.mDrawerChildren.iterator();
                    z = false;
                    while (it4.hasNext()) {
                        DXDrawerChild next4 = it4.next();
                        if (next4.sizeDP.getIsStar() && !next4.isMeasured && (correctItemSize = DrawerSizeCalculator.correctItemSize((size = (int) (next4.sizeDP.getSize() * f2)), next4.sizePx.getMinSize(), next4.sizePx.getMaxSize())) != size) {
                            measureChild(next4, correctItemSize, drawerSize);
                            f -= next4.sizeDP.getSize();
                            next4.isMeasured = true;
                            z = true;
                            dXDrawerChild = next4;
                        }
                    }
                    f2 = (calculateMaxSize - drawerSize.Height) / f;
                }
                Iterator<DXDrawerChild> it5 = this.mDrawerChildren.iterator();
                while (it5.hasNext()) {
                    DXDrawerChild next5 = it5.next();
                    if (next5.sizeDP.getIsStar() && !next5.isMeasured) {
                        measureChild(next5, (int) (next5.sizeDP.getSize() * f2), drawerSize);
                        dXDrawerChild = next5;
                    }
                }
                if (dXDrawerChild != null && calculateMaxSize - drawerSize.Height > 0) {
                    dXDrawerChild.view.requestLayout();
                    int measuredHeight = dXDrawerChild.view.getMeasuredHeight() + (calculateMaxSize - drawerSize.Height);
                    drawerSize.Height -= dXDrawerChild.view.getMeasuredHeight();
                    measureChild(dXDrawerChild, measuredHeight, drawerSize);
                }
            }
        }
        if (this.mIsHorizontal) {
            this.mDrawerCalculatedSize.RealHeight = this.mViewPortHeight;
            this.mDrawerCalculatedSize.RealWidth = this.mSizeCalculator.calculateSize(drawerSize.Width, this.mViewPortWidth);
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mDrawerCalculatedSize.RealWidth, BasicMeasure.EXACTLY);
        } else {
            this.mDrawerCalculatedSize.RealHeight = this.mSizeCalculator.calculateSize(drawerSize.Height, this.mViewPortHeight);
            this.mDrawerCalculatedSize.RealWidth = this.mViewPortWidth;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mViewPortWidth, BasicMeasure.EXACTLY);
        }
        super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(drawerSize.Height, BasicMeasure.EXACTLY));
    }

    private void measureChild(DXDrawerChild dXDrawerChild, int i, DrawerSize drawerSize) {
        dXDrawerChild.view.measure(drawerSize.MeasureWidthSpec, getHeightSpec(dXDrawerChild.sizePx, i));
        drawerSize.Width = Math.max(dXDrawerChild.view.getMeasuredWidth(), drawerSize.Width);
        drawerSize.Height += dXDrawerChild.view.getMeasuredHeight();
    }

    private void addChild(ArrayList<DXDrawerChild> arrayList, View view, TabSize tabSize, TabSizeInPixels tabSizeInPixels) {
        if (view == null) {
            return;
        }
        DXDrawerChild dXDrawerChild = new DXDrawerChild();
        dXDrawerChild.view = view;
        dXDrawerChild.sizeDP = tabSize;
        dXDrawerChild.sizePx = tabSizeInPixels;
        arrayList.add(dXDrawerChild);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterator<DXDrawerChild> it = this.mDrawerChildren.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            DXDrawerChild next = it.next();
            next.view.layout(0, i5, this.mDrawerCalculatedSize.RealWidth, next.view.getMeasuredHeight() + i5);
            i5 += next.view.getMeasuredHeight();
        }
        this.mDrawerChildren.clear();
        if (this.mIsHorizontal) {
            return;
        }
        refreshChildScrollableView();
    }

    private void relayoutAll() {
        View view = this.mDrawerContent;
        if (view != null) {
            view.requestLayout();
        }
        View view2 = this.mDrawerHeaderContent;
        if (view2 != null) {
            view2.requestLayout();
        }
        View view3 = this.mDrawerFooterContent;
        if (view3 != null) {
            view3.requestLayout();
        }
        requestLayout();
    }

    public void refreshChildScrollableView() {
        YViewCache yViewCache = this.mYViewCache;
        if (yViewCache == null) {
            fillChildScrollableView();
        } else {
            if (yViewCache.Empty()) {
                return;
            }
            this.mYViewCache.refreshY();
        }
    }

    public View getChildScrollableView(float f) {
        if (this.mYViewCache.Empty()) {
            return null;
        }
        return this.mYViewCache.getView(f);
    }

    private void fillChildScrollableView() {
        YViewCache yViewCache = this.mYViewCache;
        if (yViewCache == null) {
            this.mYViewCache = new YViewCache();
        } else {
            yViewCache.Clear();
        }
        fillChildScrollableView(this.mDrawerHeaderContent, ListView.class);
        fillChildScrollableView(this.mDrawerHeaderContent, ScrollView.class);
        fillChildScrollableView(this.mDrawerHeaderContent, NestedScrollView.class);
        fillChildScrollableView(this.mDrawerContent, ListView.class);
        fillChildScrollableView(this.mDrawerContent, ScrollView.class);
        fillChildScrollableView(this.mDrawerContent, NestedScrollView.class);
        fillChildScrollableView(this.mDrawerFooterContent, ListView.class);
        fillChildScrollableView(this.mDrawerFooterContent, ScrollView.class);
        fillChildScrollableView(this.mDrawerFooterContent, NestedScrollView.class);
    }

    private void fillChildScrollableView(View view, Class cls) {
        if (view == null) {
            return;
        }
        if (cls.isInstance(view)) {
            this.mYViewCache.Add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                fillChildScrollableView(viewGroup.getChildAt(i), cls);
            }
        }
    }
}
