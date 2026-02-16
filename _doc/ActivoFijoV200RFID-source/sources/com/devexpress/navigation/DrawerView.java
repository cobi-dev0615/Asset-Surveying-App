package com.devexpress.navigation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.devexpress.navigation.common.Position;
import com.devexpress.navigation.common.ShadowDrawer;
import com.devexpress.navigation.navigationdrawer.ContentView;
import com.devexpress.navigation.navigationdrawer.DXDrawer;
import com.devexpress.navigation.navigationdrawer.DrawerInnerContainer;
import com.devexpress.navigation.navigationdrawer.DrawerSizeCalculator;
import com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter;
import com.devexpress.navigation.navigationdrawer.Transition;
import com.devexpress.navigation.navigationdrawer.transitionstrategy.BaseTransitionStrategy;
import com.devexpress.navigation.navigationdrawer.transitionstrategy.PushStrategy;
import com.devexpress.navigation.navigationdrawer.transitionstrategy.RevealStrategy;
import com.devexpress.navigation.navigationdrawer.transitionstrategy.SlideOnTopStrategy;
import com.devexpress.navigation.navigationdrawer.transitionstrategy.SplitStrategy;
import com.devexpress.navigation.tabs.models.TabSize;
import com.devexpress.navigation.tabs.utils.SizeConverter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DrawerView extends ViewGroup {
    private float density;
    private IDrawerViewAdapter mAdapter;
    private boolean mAreGesturesEnabled;
    private final IDrawerViewAdapter.ContentChangedListener mContentChangedListener;
    private ViewDragHelper mDragHelper;
    private ViewDragHelper.Callback mDragHelperCallback;
    private int mDrawerBackgroundColor;
    private DXDrawer mDrawerContent;
    private TabSize mDrawerHeight;
    private ScrollView mDrawerPanel;
    private int mDrawerShadowColor;
    private float mDrawerShadowHeight;
    private float mDrawerShadowRadius;
    private TabSize mDrawerWidth;
    private WeakReference<View> mHandledList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private DrawerInnerContainer mInnerContainer;
    private boolean mIsDrawerShadowVisible;
    private boolean mIsScrimEnabled;
    private ContentView mMainContent;
    private final List<OnDrawerStateChangedListener> mOnDrawerStateChangedListeners;
    private Position mPosition;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private DrawerSizeCalculator mSizeCalculator;
    private SizeConverter mSizeConverter;
    private BaseTransitionStrategy mStrategy;
    private Transition mTransition;
    private float minVelocity;

    public interface OnDrawerStateChangedListener {
        void OnDrawerStateChanged(boolean z);
    }

    public boolean getIsOpened() {
        return this.mStrategy.getIsOpened();
    }

    public boolean getAreGesturesEnabled() {
        return this.mAreGesturesEnabled;
    }

    public Transition getDrawerTransition() {
        return this.mTransition;
    }

    public Position getDrawerPosition() {
        return this.mPosition;
    }

    public boolean getAnimationEnabled() {
        return this.mStrategy.getAnimationEnabled();
    }

    public IDrawerViewAdapter getAdapter() {
        return this.mAdapter;
    }

    public TabSize getDrawerWidth() {
        return this.mDrawerWidth;
    }

    public TabSize getDrawerHeight() {
        return this.mDrawerHeight;
    }

    public TabSize getDrawerContentHeight() {
        return this.mDrawerContent.getDrawerContentHeight();
    }

    public TabSize getDrawerHeaderContentHeight() {
        return this.mDrawerContent.getDrawerHeaderContentHeight();
    }

    public TabSize getDrawerFooterContentHeight() {
        return this.mDrawerContent.getDrawerFooterContentHeight();
    }

    public int getDrawerBackgroundColor() {
        return this.mDrawerBackgroundColor;
    }

    public int getScrimColor() {
        return this.mScrimColor;
    }

    public float getScrimOpacity() {
        return this.mScrimOpacity;
    }

    public boolean getIsScrimEnabled() {
        return this.mIsScrimEnabled;
    }

    public int getDrawerShadowColor() {
        return this.mDrawerShadowColor;
    }

    public float getDrawerShadowRadius() {
        return this.mDrawerShadowRadius;
    }

    public float getDrawerShadowHeight() {
        return this.mDrawerShadowHeight;
    }

    public boolean getIsDrawerShadowVisible() {
        return this.mIsDrawerShadowVisible;
    }

    public void setIsOpened(boolean z) {
        this.mStrategy.setIsOpened(z);
    }

    public void setAreGesturesEnabled(boolean z) {
        if (this.mAreGesturesEnabled != z) {
            this.mAreGesturesEnabled = z;
        }
    }

    public void setDrawerWidth(TabSize tabSize) {
        if (this.mDrawerWidth != tabSize) {
            this.mDrawerWidth = tabSize;
            if (isHorizontal()) {
                this.mSizeCalculator.setSize(this.mDrawerWidth);
                if (this.mPosition == Position.Left || this.mPosition == Position.Right) {
                    this.mDrawerContent.setDrawerSize(this.mDrawerWidth);
                }
                requestLayout();
            }
        }
    }

    public void setDrawerHeight(TabSize tabSize) {
        if (this.mDrawerHeight != tabSize) {
            this.mDrawerHeight = tabSize;
            if (isHorizontal()) {
                return;
            }
            this.mSizeCalculator.setSize(this.mDrawerHeight);
            if (this.mPosition == Position.Top || this.mPosition == Position.Bottom) {
                this.mDrawerContent.setDrawerSize(this.mDrawerHeight);
            }
            requestLayout();
        }
    }

    public void setDrawerTransition(Transition transition) {
        if (this.mTransition != transition) {
            this.mTransition = transition;
            this.mStrategy = createStrategy(transition);
            requestLayout();
        }
    }

    public void setDrawerPosition(Position position) {
        if (position != this.mPosition) {
            this.mPosition = position;
            this.mSizeCalculator.setSize(isHorizontal() ? this.mDrawerWidth : this.mDrawerHeight);
            this.mStrategy.updatePosition(this.mPosition);
            this.mDrawerContent.setPosition(position);
            if (this.mPosition == Position.Top || this.mPosition == Position.Bottom) {
                this.mDrawerContent.setDrawerSize(this.mDrawerHeight);
            } else if (this.mPosition == Position.Left || this.mPosition == Position.Right) {
                this.mDrawerContent.setDrawerSize(this.mDrawerWidth);
            }
            requestLayout();
        }
    }

    public void setAnimationEnabled(boolean z) {
        this.mStrategy.setAnimationEnabled(z);
    }

    public void setAdapter(IDrawerViewAdapter iDrawerViewAdapter) {
        IDrawerViewAdapter iDrawerViewAdapter2 = this.mAdapter;
        if (iDrawerViewAdapter2 != iDrawerViewAdapter) {
            if (iDrawerViewAdapter2 != null) {
                removeAllViews();
                this.mAdapter.removeContentChangedListener(this.mContentChangedListener);
            }
            this.mAdapter = iDrawerViewAdapter;
            applyContent();
            IDrawerViewAdapter iDrawerViewAdapter3 = this.mAdapter;
            if (iDrawerViewAdapter3 != null) {
                iDrawerViewAdapter3.addContentChangedListener(this.mContentChangedListener);
            }
        }
    }

    public void setDrawerContentHeight(TabSize tabSize) {
        this.mDrawerContent.setDrawerContentHeight(tabSize);
    }

    public void setDrawerHeaderContentHeight(TabSize tabSize) {
        this.mDrawerContent.setDrawerHeaderContentHeight(tabSize);
    }

    public void setDrawerFooterContentHeight(TabSize tabSize) {
        this.mDrawerContent.setDrawerFooterContentHeight(tabSize);
    }

    public void setDrawerBackgroundColor(int i) {
        if (this.mDrawerBackgroundColor != i) {
            this.mDrawerBackgroundColor = i;
            this.mDrawerPanel.setBackgroundColor(i);
            this.mDrawerContent.setBackgroundColor(this.mDrawerBackgroundColor);
            invalidate();
        }
    }

    public void setScrimColor(int i) {
        if (this.mScrimColor != i) {
            this.mScrimColor = i;
            this.mInnerContainer.invalidate();
        }
    }

    public void setScrimOpacity(float f) {
        if (this.mScrimOpacity != f) {
            this.mScrimOpacity = f;
            this.mInnerContainer.invalidate();
        }
    }

    public void setIsScrimEnabled(boolean z) {
        if (this.mIsScrimEnabled != z) {
            this.mIsScrimEnabled = z;
            this.mInnerContainer.invalidate();
        }
    }

    public void setDrawerShadowColor(int i) {
        if (this.mDrawerShadowColor != i) {
            this.mDrawerShadowColor = i;
            this.mInnerContainer.invalidate();
        }
    }

    public void setDrawerShadowRadius(float f) {
        if (this.mDrawerShadowRadius != f) {
            this.mDrawerShadowRadius = f;
            this.mInnerContainer.invalidate();
        }
    }

    public void setDrawerShadowHeight(float f) {
        if (this.mDrawerShadowHeight != f) {
            this.mDrawerShadowHeight = f;
            this.mInnerContainer.invalidate();
        }
    }

    public void setIsDrawerShadowVisible(boolean z) {
        if (this.mIsDrawerShadowVisible != z) {
            this.mIsDrawerShadowVisible = z;
            this.mInnerContainer.invalidate();
        }
    }

    public void addOnDrawerStateChangedListener(OnDrawerStateChangedListener onDrawerStateChangedListener) {
        this.mOnDrawerStateChangedListeners.add(onDrawerStateChangedListener);
    }

    public void removeOnDrawerStateChangedListener(OnDrawerStateChangedListener onDrawerStateChangedListener) {
        this.mOnDrawerStateChangedListeners.remove(onDrawerStateChangedListener);
    }

    public void clearOnDrawerStateChangedListener() {
        this.mOnDrawerStateChangedListeners.clear();
    }

    public DrawerView(Context context) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        this.minVelocity = f * 400.0f;
        this.mInitialMotionX = 0.0f;
        this.mInitialMotionY = 0.0f;
        this.mScrimPaint = new Paint();
        this.mScrimColor = -16777216;
        this.mScrimOpacity = 0.5f;
        this.mAreGesturesEnabled = true;
        this.mDrawerWidth = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mDrawerHeight = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mTransition = Transition.SlideOnTop;
        this.mPosition = Position.Left;
        this.mContentChangedListener = createListener();
        this.mIsScrimEnabled = true;
        this.mDrawerShadowColor = -7829368;
        this.mDrawerShadowRadius = 15.0f;
        this.mDrawerShadowHeight = 5.0f;
        this.mIsDrawerShadowVisible = true;
        this.mOnDrawerStateChangedListeners = new ArrayList();
        initialize();
    }

    public DrawerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        this.minVelocity = f * 400.0f;
        this.mInitialMotionX = 0.0f;
        this.mInitialMotionY = 0.0f;
        this.mScrimPaint = new Paint();
        this.mScrimColor = -16777216;
        this.mScrimOpacity = 0.5f;
        this.mAreGesturesEnabled = true;
        this.mDrawerWidth = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mDrawerHeight = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mTransition = Transition.SlideOnTop;
        this.mPosition = Position.Left;
        this.mContentChangedListener = createListener();
        this.mIsScrimEnabled = true;
        this.mDrawerShadowColor = -7829368;
        this.mDrawerShadowRadius = 15.0f;
        this.mDrawerShadowHeight = 5.0f;
        this.mIsDrawerShadowVisible = true;
        this.mOnDrawerStateChangedListeners = new ArrayList();
        initialize();
    }

    public DrawerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        this.minVelocity = f * 400.0f;
        this.mInitialMotionX = 0.0f;
        this.mInitialMotionY = 0.0f;
        this.mScrimPaint = new Paint();
        this.mScrimColor = -16777216;
        this.mScrimOpacity = 0.5f;
        this.mAreGesturesEnabled = true;
        this.mDrawerWidth = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mDrawerHeight = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mTransition = Transition.SlideOnTop;
        this.mPosition = Position.Left;
        this.mContentChangedListener = createListener();
        this.mIsScrimEnabled = true;
        this.mDrawerShadowColor = -7829368;
        this.mDrawerShadowRadius = 15.0f;
        this.mDrawerShadowHeight = 5.0f;
        this.mIsDrawerShadowVisible = true;
        this.mOnDrawerStateChangedListeners = new ArrayList();
        initialize();
    }

    public DrawerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        this.minVelocity = f * 400.0f;
        this.mInitialMotionX = 0.0f;
        this.mInitialMotionY = 0.0f;
        this.mScrimPaint = new Paint();
        this.mScrimColor = -16777216;
        this.mScrimOpacity = 0.5f;
        this.mAreGesturesEnabled = true;
        this.mDrawerWidth = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mDrawerHeight = new TabSize(0.5f, -1.0f, -1.0f, true, false);
        this.mTransition = Transition.SlideOnTop;
        this.mPosition = Position.Left;
        this.mContentChangedListener = createListener();
        this.mIsScrimEnabled = true;
        this.mDrawerShadowColor = -7829368;
        this.mDrawerShadowRadius = 15.0f;
        this.mDrawerShadowHeight = 5.0f;
        this.mIsDrawerShadowVisible = true;
        this.mOnDrawerStateChangedListeners = new ArrayList();
        initialize();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
            this.mStrategy.RaiseDrawerStateChanged();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View findTopChildUnder;
        if (!this.mAreGesturesEnabled || this.mTransition == Transition.Split || !nestedContentScrolledToEnd(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean shouldInterceptTouchEvent = this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
        if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        }
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            if (this.mScrimOpacity > 0.0f && this.mStrategy.getIsOpened() && (findTopChildUnder = this.mDragHelper.findTopChildUnder((int) x, (int) y)) != null && isContentView(findTopChildUnder)) {
                z = true;
                return !shouldInterceptTouchEvent || z;
            }
        }
        z = false;
        if (shouldInterceptTouchEvent) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mAreGesturesEnabled && this.mTransition != Transition.Split) {
            this.mDragHelper.processTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
            } else if (actionMasked == 1) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View findTopChildUnder = this.mDragHelper.findTopChildUnder((int) x2, (int) y2);
                if (findTopChildUnder != null && isContentView(findTopChildUnder)) {
                    float f = x2 - this.mInitialMotionX;
                    float f2 = y2 - this.mInitialMotionY;
                    int touchSlop = this.mDragHelper.getTouchSlop();
                    if ((f * f) + (f2 * f2) < touchSlop * touchSlop) {
                        this.mStrategy.setIsOpened(false);
                    }
                }
            } else if (actionMasked == 3) {
                this.mStrategy.setIsOpened(false);
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size;
        int size2;
        this.mDrawerContent.setViewPort(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.mDrawerContent.measure(i, i2);
        measureChild(this.mDrawerPanel, View.MeasureSpec.makeMeasureSpec(this.mDrawerContent.getRealWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.mDrawerContent.getRealHeight(), BasicMeasure.EXACTLY));
        if (this.mTransition == Transition.Split) {
            if (this.mPosition == Position.Left || this.mPosition == Position.Right) {
                size = View.MeasureSpec.getSize(i) - this.mDrawerContent.getRealWidth();
            } else {
                size = View.MeasureSpec.getSize(i);
            }
            if (this.mPosition == Position.Top || this.mPosition == Position.Bottom) {
                size2 = View.MeasureSpec.getSize(i2) - this.mDrawerContent.getRealHeight();
            } else {
                size2 = View.MeasureSpec.getSize(i2);
            }
            this.mMainContent.measure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
        } else {
            this.mMainContent.measure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInnerContainer.layout(0, 0, i3 - i, i4 - i2);
        this.mStrategy.layout(z, i, i2, i3, i4);
        DXDrawer dXDrawer = this.mDrawerContent;
        dXDrawer.layout(0, 0, dXDrawer.getMeasuredWidth(), this.mDrawerContent.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyContent() {
        IDrawerViewAdapter iDrawerViewAdapter = this.mAdapter;
        if (iDrawerViewAdapter != null) {
            this.mDrawerContent.refill(iDrawerViewAdapter.getDrawerContent(this), this.mAdapter.getDrawerHeaderContent(this), this.mAdapter.getDrawerFooterContent(this));
            this.mAdapter.ApplyMainContent(this.mMainContent);
        } else {
            this.mDrawerContent.refill(null, null, null);
            this.mMainContent.setContent(null);
        }
    }

    private boolean isContentView(View view) {
        return this.mMainContent == view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHorizontal() {
        return this.mPosition == Position.Left || this.mPosition == Position.Right;
    }

    private void initialize() {
        SizeConverter sizeConverter = new SizeConverter(this.density);
        this.mSizeConverter = sizeConverter;
        this.mSizeCalculator = new DrawerSizeCalculator(sizeConverter, this.mDrawerWidth);
        DrawerInnerContainer drawerInnerContainer = new DrawerInnerContainer(getContext());
        this.mInnerContainer = drawerInnerContainer;
        drawerInnerContainer.setOnNativeDrawListener(new DrawerInnerContainer.IOnDrawListener() { // from class: com.devexpress.navigation.DrawerView.1
            @Override // com.devexpress.navigation.navigationdrawer.DrawerInnerContainer.IOnDrawListener
            public void drawChild(Canvas canvas, View view, long j) {
                if (DrawerView.this.mTransition != Transition.Split) {
                    DrawerView.this.drawScrim(canvas, view, j);
                }
                if (!DrawerView.this.mIsDrawerShadowVisible || DrawerView.this.mStrategy.getDrawerVisibleRegion() <= 0.0f) {
                    return;
                }
                ShadowDrawer.drawHeaderPanelShadow(canvas, DrawerView.this.mSizeConverter.convertDpToPx(DrawerView.this.mDrawerShadowHeight), DrawerView.this.mSizeConverter.convertDpToPx(DrawerView.this.mDrawerShadowRadius), DrawerView.this.mStrategy.getDraggableView(), DrawerView.this.mTransition == Transition.Reveal ? DrawerView.this.MirrorPosition() : DrawerView.this.mPosition, DrawerView.this.mDrawerShadowColor);
            }
        });
        this.mDrawerPanel = new ScrollView(getContext());
        DXDrawer dXDrawer = new DXDrawer(getContext());
        this.mDrawerContent = dXDrawer;
        dXDrawer.setSizeCalculator(this.mSizeCalculator);
        this.mMainContent = new ContentView(getContext());
        DragHelperCallback dragHelperCallback = new DragHelperCallback();
        this.mDragHelperCallback = dragHelperCallback;
        ViewDragHelper create = ViewDragHelper.create(this.mInnerContainer, 1.0f, dragHelperCallback);
        this.mDragHelper = create;
        create.setMinVelocity(this.minVelocity);
        this.mDragHelper.setEdgeTrackingEnabled(1);
        this.mDrawerPanel.addView(this.mDrawerContent);
        addView(this.mInnerContainer, -1, -1);
        this.mInnerContainer.addView(this.mMainContent, -1, -1);
        this.mInnerContainer.addView(this.mDrawerPanel, -2, -1);
        this.mStrategy = createStrategy(this.mTransition);
        setId(View.generateViewId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        if (r0 != 3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0022, code lost:
    
        if (r6 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean nestedContentScrolledToEnd(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devexpress.navigation.DrawerView.nestedContentScrolledToEnd(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Position MirrorPosition() {
        int i = AnonymousClass3.$SwitchMap$com$devexpress$navigation$common$Position[this.mPosition.ordinal()];
        if (i == 1) {
            return Position.Bottom;
        }
        if (i == 2) {
            return Position.Right;
        }
        if (i == 3) {
            return Position.Top;
        }
        if (i == 4) {
            return Position.Left;
        }
        return Position.Left;
    }

    /* renamed from: com.devexpress.navigation.DrawerView$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$navigation$common$Position;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$navigation$navigationdrawer$Transition;

        static {
            int[] iArr = new int[Transition.values().length];
            $SwitchMap$com$devexpress$navigation$navigationdrawer$Transition = iArr;
            try {
                iArr[Transition.Push.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$navigationdrawer$Transition[Transition.Reveal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$navigationdrawer$Transition[Transition.Split.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$navigationdrawer$Transition[Transition.SlideOnTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Position.values().length];
            $SwitchMap$com$devexpress$navigation$common$Position = iArr2;
            try {
                iArr2[Position.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Left.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$devexpress$navigation$common$Position[Position.Right.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private BaseTransitionStrategy createStrategy(Transition transition) {
        BaseTransitionStrategy baseTransitionStrategy = this.mStrategy;
        boolean isOpened = baseTransitionStrategy == null ? false : baseTransitionStrategy.getIsOpened();
        int i = AnonymousClass3.$SwitchMap$com$devexpress$navigation$navigationdrawer$Transition[transition.ordinal()];
        if (i == 1) {
            return new PushStrategy(this.mDrawerPanel, this.mMainContent, this, this.mDragHelper, this.mSizeCalculator, this.mPosition, isOpened, this.mOnDrawerStateChangedListeners);
        }
        if (i == 2) {
            return new RevealStrategy(this.mDrawerPanel, this.mMainContent, this, this.mDragHelper, this.mSizeCalculator, this.mPosition, isOpened, this.mOnDrawerStateChangedListeners);
        }
        if (i == 3) {
            return new SplitStrategy(this.mDrawerPanel, this.mMainContent, this, this.mDragHelper, this.mSizeCalculator, this.mPosition, isOpened, this.mOnDrawerStateChangedListeners);
        }
        return new SlideOnTopStrategy(this.mDrawerPanel, this.mMainContent, this, this.mDragHelper, this.mSizeCalculator, this.mPosition, isOpened, this.mOnDrawerStateChangedListeners);
    }

    private IDrawerViewAdapter.ContentChangedListener createListener() {
        return new IDrawerViewAdapter.ContentChangedListener() { // from class: com.devexpress.navigation.DrawerView.2
            @Override // com.devexpress.navigation.navigationdrawer.IDrawerViewAdapter.ContentChangedListener
            public void onContentChanged() {
                DrawerView.this.post(new Runnable() { // from class: com.devexpress.navigation.DrawerView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawerView.this.applyContent();
                    }
                });
            }
        };
    }

    class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, i, i2, i3, i4);
            DrawerView.this.mStrategy.onViewPositionChanged();
            DrawerView.this.mInnerContainer.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return view == DrawerView.this.mStrategy.getDraggableView();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            DrawerView.this.mDragHelper.captureChildView(DrawerView.this.mStrategy.getDraggableView(), i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return DrawerView.this.mStrategy.clampViewPositionHorizontal(i);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return DrawerView.this.mStrategy.clampViewPositionVertical(i);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            DrawerView.this.mStrategy.onViewReleased(f, f2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            if (DrawerView.this.isHorizontal() && view == DrawerView.this.mStrategy.getDraggableView()) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            if (DrawerView.this.isHorizontal() || view != DrawerView.this.mStrategy.getDraggableView()) {
                return 0;
            }
            return view.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawScrim(Canvas canvas, View view, long j) {
        if (this.mIsScrimEnabled && view == this.mMainContent) {
            this.mScrimPaint.setColor((((int) (((this.mScrimColor & (-16777216)) >>> 24) * this.mStrategy.getDrawerVisibleRegion())) << 24) | (this.mScrimColor & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), this.mScrimPaint);
        }
    }
}
