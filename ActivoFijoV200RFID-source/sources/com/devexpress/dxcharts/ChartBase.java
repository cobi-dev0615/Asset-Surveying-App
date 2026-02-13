package com.devexpress.dxcharts;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import com.devexpress.dxcharts.ChartStyleBase;
import com.devexpress.dxcharts.HintBase;
import com.devexpress.dxcharts.TextElementStyleBase;
import com.devexpress.dxcharts.TextStyle;
import com.devexpress.dxcore.DXNativeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ChartBase extends DXNativeView {
    static final int CAF_HIDE_SCROLL_IND = 8;
    static final int CAF_HIDE_TOOLTIP = 2;
    static final int CAF_NONE = 0;
    static final int CAF_RENDER = 1;
    static final int CAF_SHOW_SCROLL_IND = 4;
    static final int CAF_UPDATE_TOOLTIP = 16;
    private boolean canDraw;
    private NativeObjectWrapper changedListener;
    private ChartViewHolder chartView;
    private ContextProvider contextProvider;
    private Integer currentThemeID;
    private HitTestController hitTestController;
    private boolean isHintShown;
    private LegendContainer legend;
    private Drawable loadingDrawable;
    private SelectionMode mSelectionMode;
    private final TouchListenersCombiner mTouchListeners;
    private NativeObjectWrapper nativeChart;
    private NativeLibraryLoader nativeLibraryLoader;
    private OverlayController overlayController;
    private OverlayView overlayView;
    private Paint paint;
    private Rect rect;
    private RenderMode renderMode;
    private GLRenderer renderer;
    private SelectionChangedListener selectionChangedListener;
    private List<SeriesBase> series;
    private ChartStyledElementBase styledElement;
    private TextStyleProviderInterface textStyleProvider;
    private OnTouchEventListener touchEventListener;
    static final Object syncObject = new Object();
    static final int DEFAULT_THEME_ID = R.style.ChartTheme_Light;

    static native void nativeCreateScreenMapping(float f);

    abstract ChartStyledElementBase createChartStyleElement();

    abstract NativeObjectWrapper createNativeChart(LegendContainer legendContainer, HintContainer hintContainer, TextStyleProviderInterface textStyleProviderInterface);

    abstract TextStyleProviderInterface createTextStyleProvider();

    abstract OnTouchEventListener createTouchEventListener();

    native void nativeAddSeries(long j);

    native int[] nativeCalcHitInfo(int[] iArr);

    native void nativeChartAddChangedListener(long j);

    native long nativeCreateListener();

    native int[] nativeGetPaneRect();

    native Object[] nativeGetSelectedItems();

    native int nativeGetSelectionKind();

    native OverlayInfo[] nativeGetUserHintInfo(int i, int i2, int i3, int i4, int i5, int i6);

    native OverlayInfo[] nativeGetUserPointOverlayInfo(int i, int i2, int i3, int i4, int i5, int i6);

    native void nativeHideUserHint();

    native NavigationProcessResult nativeProcessGestureDownAction(float f, float f2, int i, int i2, int i3, int i4);

    native void nativeProcessGestureEndAction(float f, float f2);

    native NavigationProcessResult nativeProcessGestureLongPressAction(float f, float f2, int i, int i2, int i3, int i4);

    native void nativeProcessGesturePanAction(float f, float f2);

    native void nativeProcessGesturePinchAction(float f, float f2, float f3, float f4);

    native NavigationProcessResult nativeProcessGestureTapAction(float f, float f2, int i, int i2, int i3, int i4);

    native SelectionChangedInfo nativeProcessUserSelection(int i, int i2, boolean z);

    native void nativeRemoveAllSeries();

    native void nativeRemoveSeries(long j);

    native void nativeSetChartBackgroundColor(int i);

    native void nativeSetChartPadding(int i, int i2, int i3, int i4);

    native void nativeSetHintEnabled(int i);

    native void nativeSetHintShowMode(int i);

    native void nativeSetPalette(int[] iArr);

    native void nativeSetSelectionKind(int i);

    native void nativeSetSelectionMode(int i);

    native void nativeStopScrollingAnimation();

    native NavigationProcessResult nativeUpdateHint();

    abstract class ChartStyledElementBase extends StyledElement {
        ChartStyledElementBase() {
        }

        @Override // com.devexpress.dxcharts.StyledElement
        List<Enum<?>> getListenPropertiesNames() {
            List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
            Collections.addAll(listenPropertiesNames, ChartStyleBase.Property.values());
            return listenPropertiesNames;
        }

        @Override // com.devexpress.dxcharts.StyledElement
        void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r6) {
            ChartStyleBase chartStyleBase = (ChartStyleBase) styleContainer.getActualStyle(contextProvider, new Object[0]);
            ChartStyleBase chartStyleBase2 = (ChartStyleBase) styleContainer.getDefaultStyle();
            if (r6 instanceof ChartStyleBase.Property) {
                int i = AnonymousClass2.$SwitchMap$com$devexpress$dxcharts$ChartStyleBase$Property[((ChartStyleBase.Property) r6).ordinal()];
                if (i == 1) {
                    ChartBase chartBase = ChartBase.this;
                    if (chartStyleBase.getPalette() == null) {
                        chartStyleBase = chartStyleBase2;
                    }
                    chartBase.nativeSetPalette(chartStyleBase.getPalette());
                    return;
                }
                if (i == 2) {
                    int intValue = (chartStyleBase.getPaddingLeft() != null ? chartStyleBase : chartStyleBase2).getPaddingLeft().intValue();
                    int intValue2 = (chartStyleBase.getPaddingTop() != null ? chartStyleBase : chartStyleBase2).getPaddingTop().intValue();
                    int intValue3 = (chartStyleBase.getPaddingRight() != null ? chartStyleBase : chartStyleBase2).getPaddingRight().intValue();
                    if (chartStyleBase.getPaddingBottom() == null) {
                        chartStyleBase = chartStyleBase2;
                    }
                    ChartBase.this.nativeSetChartPadding(intValue, intValue2, intValue3, chartStyleBase.getPaddingBottom().intValue());
                    return;
                }
                if (i == 3) {
                    synchronized (ChartBase.syncObject) {
                        ChartBase chartBase2 = ChartBase.this;
                        if (chartStyleBase.getBackgroundColor() == null) {
                            chartStyleBase = chartStyleBase2;
                        }
                        chartBase2.nativeSetChartBackgroundColor(chartStyleBase.getBackgroundColor().intValue());
                    }
                    return;
                }
                if (i == 4) {
                    ChartBase.this.setBackgroundColor(getSubstrateBackgroundColor());
                } else {
                    if (i != 5) {
                        return;
                    }
                    ChartBase.this.invalidateChart();
                }
            }
        }

        @Override // com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
        void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
            if ((obj instanceof Legend) || (obj instanceof SeriesLabel) || (obj instanceof AxisBase) || (obj instanceof AxisLabelStyle) || (propertyChangedArgs.getProperty() instanceof TextElementStyleBase.Property) || (propertyChangedArgs.getProperty() instanceof TextStyle.TextStyleProperty)) {
                ChartBase.this.invalidateChart();
                return;
            }
            if ((obj instanceof LegendContainer) || (obj instanceof PieSeries)) {
                ChartBase.this.invalidateOverlay();
                return;
            }
            if ((obj instanceof HintContainer) || (obj instanceof HintBase) || (obj instanceof HintBehavior) || (obj instanceof CrosshairLabelPositionBase)) {
                applyHintProperties(propertyChangedArgs.getProperty());
            } else {
                super.onChartElementPropertyChanged(obj, propertyChangedArgs);
            }
        }

        void applyHintProperties(Enum<?> r4) {
            HintBase userHint = ChartBase.this.getUserHint();
            if (r4 instanceof HintBase.Property) {
                int i = AnonymousClass2.$SwitchMap$com$devexpress$dxcharts$HintBase$Property[((HintBase.Property) r4).ordinal()];
                int i2 = 2;
                if (i != 1 && i != 2) {
                    if (i == 3 && userHint != null) {
                        ChartBase.this.nativeSetHintShowMode(userHint.getShowMode().ordinal());
                        return;
                    }
                    return;
                }
                if (userHint == null || !userHint.isEnabled()) {
                    i2 = 0;
                } else if (!(userHint.getBehaviorInternal() instanceof CrosshairHintBehavior)) {
                    i2 = 1;
                }
                ChartBase.this.nativeSetHintEnabled(i2);
            }
        }

        int getSubstrateBackgroundColor() {
            ChartStyleBase chartStyleBase = (ChartStyleBase) getActualStyleFromContainer(ChartStyleBase.class, new Object[0]);
            ChartStyleBase chartStyleBase2 = (ChartStyleBase) getDefaultStyleFromContainer(ChartStyleBase.class);
            if (chartStyleBase.getBorderColor() == null) {
                chartStyleBase = chartStyleBase2;
            }
            Integer borderColor = chartStyleBase.getBorderColor();
            if (borderColor != null) {
                return borderColor.intValue();
            }
            return -1;
        }
    }

    public ChartBase(Context context) {
        this(context, null);
    }

    public ChartBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canDraw = true;
        this.isHintShown = false;
        this.mSelectionMode = SelectionMode.SINGLE;
        this.renderMode = RenderMode.SURFACE;
        this.currentThemeID = null;
        this.paint = new Paint();
        this.rect = new Rect();
        TouchListenersCombiner touchListenersCombiner = new TouchListenersCombiner();
        this.mTouchListeners = touchListenersCombiner;
        this.contextProvider = new ContextProvider() { // from class: com.devexpress.dxcharts.ChartBase.1
            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getBaseTheme() {
                return getContext().getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getUserChartTheme() {
                if (ChartBase.this.currentThemeID != null) {
                    return new ContextThemeWrapper(getContext(), ChartBase.this.currentThemeID.intValue()).getTheme();
                }
                return null;
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getDefaultChartTheme() {
                return new ContextThemeWrapper(getContext(), ChartBase.DEFAULT_THEME_ID).getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Context getContext() {
                return ChartBase.this.getContext();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources getResources() {
                return getContext().getResources();
            }
        };
        UIHandler.init(context);
        if (!isInEditMode()) {
            initArguments(context, attributeSet, i, 0);
            initView(context);
        }
        touchListenersCombiner.addListener(new SimpleTouchListener(new OnTouchEventFunction() { // from class: com.devexpress.dxcharts.ChartBase$$ExternalSyntheticLambda0
            @Override // com.devexpress.dxcharts.OnTouchEventFunction
            public final boolean onTouch(MotionEvent motionEvent) {
                boolean onTouch;
                onTouch = ChartBase.this.onTouch(motionEvent);
                return onTouch;
            }
        }));
        super.setOnTouchListener(touchListenersCombiner);
    }

    public ChartBase(Context context, AttributeSet attributeSet, int i, RenderMode renderMode) {
        super(context, attributeSet, i);
        this.canDraw = true;
        this.isHintShown = false;
        this.mSelectionMode = SelectionMode.SINGLE;
        this.renderMode = RenderMode.SURFACE;
        this.currentThemeID = null;
        this.paint = new Paint();
        this.rect = new Rect();
        TouchListenersCombiner touchListenersCombiner = new TouchListenersCombiner();
        this.mTouchListeners = touchListenersCombiner;
        this.contextProvider = new ContextProvider() { // from class: com.devexpress.dxcharts.ChartBase.1
            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getBaseTheme() {
                return getContext().getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getUserChartTheme() {
                if (ChartBase.this.currentThemeID != null) {
                    return new ContextThemeWrapper(getContext(), ChartBase.this.currentThemeID.intValue()).getTheme();
                }
                return null;
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getDefaultChartTheme() {
                return new ContextThemeWrapper(getContext(), ChartBase.DEFAULT_THEME_ID).getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Context getContext() {
                return ChartBase.this.getContext();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources getResources() {
                return getContext().getResources();
            }
        };
        UIHandler.init(context);
        if (!isInEditMode()) {
            initArguments(renderMode, attributeSet, i, 0);
            initView(context);
        }
        touchListenersCombiner.addListener(new SimpleTouchListener(new OnTouchEventFunction() { // from class: com.devexpress.dxcharts.ChartBase$$ExternalSyntheticLambda0
            @Override // com.devexpress.dxcharts.OnTouchEventFunction
            public final boolean onTouch(MotionEvent motionEvent) {
                boolean onTouch;
                onTouch = ChartBase.this.onTouch(motionEvent);
                return onTouch;
            }
        }));
        super.setOnTouchListener(touchListenersCombiner);
    }

    public ChartBase(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.canDraw = true;
        this.isHintShown = false;
        this.mSelectionMode = SelectionMode.SINGLE;
        this.renderMode = RenderMode.SURFACE;
        this.currentThemeID = null;
        this.paint = new Paint();
        this.rect = new Rect();
        this.mTouchListeners = new TouchListenersCombiner();
        this.contextProvider = new ContextProvider() { // from class: com.devexpress.dxcharts.ChartBase.1
            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getBaseTheme() {
                return getContext().getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getUserChartTheme() {
                if (ChartBase.this.currentThemeID != null) {
                    return new ContextThemeWrapper(getContext(), ChartBase.this.currentThemeID.intValue()).getTheme();
                }
                return null;
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getDefaultChartTheme() {
                return new ContextThemeWrapper(getContext(), ChartBase.DEFAULT_THEME_ID).getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Context getContext() {
                return ChartBase.this.getContext();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources getResources() {
                return getContext().getResources();
            }
        };
        UIHandler.init(context);
        if (isInEditMode()) {
            return;
        }
        initArguments(context, attributeSet, i, i2);
        initView(context);
    }

    public ChartBase(Context context, AttributeSet attributeSet, int i, int i2, RenderMode renderMode) {
        super(context, attributeSet, i, i2);
        this.canDraw = true;
        this.isHintShown = false;
        this.mSelectionMode = SelectionMode.SINGLE;
        this.renderMode = RenderMode.SURFACE;
        this.currentThemeID = null;
        this.paint = new Paint();
        this.rect = new Rect();
        this.mTouchListeners = new TouchListenersCombiner();
        this.contextProvider = new ContextProvider() { // from class: com.devexpress.dxcharts.ChartBase.1
            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getBaseTheme() {
                return getContext().getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getUserChartTheme() {
                if (ChartBase.this.currentThemeID != null) {
                    return new ContextThemeWrapper(getContext(), ChartBase.this.currentThemeID.intValue()).getTheme();
                }
                return null;
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources.Theme getDefaultChartTheme() {
                return new ContextThemeWrapper(getContext(), ChartBase.DEFAULT_THEME_ID).getTheme();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Context getContext() {
                return ChartBase.this.getContext();
            }

            @Override // com.devexpress.dxcharts.ContextProvider
            public Resources getResources() {
                return getContext().getResources();
            }
        };
        UIHandler.init(context);
        if (isInEditMode()) {
            return;
        }
        initArguments(renderMode, attributeSet, i, i2);
        initView(context);
    }

    static RenderMode readRenderMode(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ChartBase, 0, 0);
        try {
            return RenderMode.parse(obtainStyledAttributes.getInteger(R.styleable.ChartBase_renderMode, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    void initArguments(Context context, AttributeSet attributeSet, int i, int i2) {
        this.renderMode = readRenderMode(context, attributeSet);
        initTheme(context, attributeSet, i, i2);
    }

    void initArguments(RenderMode renderMode, AttributeSet attributeSet, int i, int i2) {
        this.renderMode = renderMode;
        initTheme(getContext(), attributeSet, i, i2);
    }

    void initView(Context context) {
        this.nativeLibraryLoader = new NativeLibraryLoader();
        this.textStyleProvider = createTextStyleProvider();
        this.styledElement = createChartStyleElement();
        this.series = new ArrayList();
        LegendContainer legendContainer = new LegendContainer(this.contextProvider);
        this.legend = legendContainer;
        legendContainer.addListener(getPropertyChangedListener());
        OverlayController overlayController = new OverlayController(this.contextProvider, this, getPropertyChangedListener());
        this.overlayController = overlayController;
        this.nativeChart = createNativeChart(this.legend, overlayController.getHintContainer(), this.textStyleProvider);
        NativeObjectWrapper nativeObjectWrapper = new NativeObjectWrapper(nativeCreateListener());
        this.changedListener = nativeObjectWrapper;
        nativeChartAddChangedListener(nativeObjectWrapper.getObject());
        RenderMode renderMode = this.renderMode;
        Object obj = syncObject;
        this.chartView = createChartView(renderMode, context, obj);
        GLRenderer gLRenderer = new GLRenderer(this.contextProvider, obj, this.nativeChart, this.textStyleProvider, this);
        this.renderer = gLRenderer;
        this.chartView.setRenderer(gLRenderer);
        this.overlayView = new OverlayView(this.contextProvider);
        addOverlayDrawableToView(this.overlayController.getOverlayLineContainer());
        addOverlayDrawableToView(this.legend);
        addOverlayDrawableToView(this.overlayController.getOverlayContainer());
        addView(this.chartView.getView());
        addView(this.overlayView);
        getHitTestController().registerHitTestableObject(new LegendHitTestableObject(this.legend));
        this.touchEventListener = createTouchEventListener();
        applyTheme(this.contextProvider);
    }

    /* renamed from: com.devexpress.dxcharts.ChartBase$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ChartStyleBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$HintBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$RenderMode;

        static {
            int[] iArr = new int[RenderMode.values().length];
            $SwitchMap$com$devexpress$dxcharts$RenderMode = iArr;
            try {
                iArr[RenderMode.SURFACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RenderMode[RenderMode.TEXTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[HintBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$HintBase$Property = iArr2;
            try {
                iArr2[HintBase.Property.BEHAVIOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$HintBase$Property[HintBase.Property.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$HintBase$Property[HintBase.Property.SHOW_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[ChartStyleBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$ChartStyleBase$Property = iArr3;
            try {
                iArr3[ChartStyleBase.Property.PALETTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ChartStyleBase$Property[ChartStyleBase.Property.PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ChartStyleBase$Property[ChartStyleBase.Property.BACKGROUND_COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ChartStyleBase$Property[ChartStyleBase.Property.BORDER_COLOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ChartStyleBase$Property[ChartStyleBase.Property.BORDER_THICKNESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static ChartViewHolder createChartView(RenderMode renderMode, Context context, Object obj) {
        int i = AnonymousClass2.$SwitchMap$com$devexpress$dxcharts$RenderMode[renderMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new GLTextureView(context);
            }
            throw new IllegalArgumentException("unknown renderMode");
        }
        ChartView chartView = new ChartView(context, obj);
        if (Build.VERSION.SDK_INT == 24) {
            chartView.getHolder().addCallback(new SurfaceBinder(chartView, context));
        }
        return chartView;
    }

    void addOverlayDrawableToView(OverlayDrawableInterface overlayDrawableInterface) {
        this.overlayView.addDrawable(overlayDrawableInterface);
    }

    Object getSyncObject() {
        return syncObject;
    }

    NotifyPropertyChanged getPropertyChangedListener() {
        return this.styledElement.getSelfListener();
    }

    private HitTestInfoInternal calcHitInfoInternal(float f, float f2) {
        int i = -1;
        new HitTestInfo(-1, new int[0], false);
        HitTestInfo calcHitInfo = getHitTestController().calcHitInfo(f, f2);
        if (calcHitInfo != null) {
            int[] dataPointIndices = calcHitInfo.getDataPointIndices();
            if (dataPointIndices != null && dataPointIndices.length > 0) {
                i = dataPointIndices[0];
            }
        } else {
            int[] nativeCalcHitInfo = nativeCalcHitInfo(new int[]{(int) f, (int) f2});
            int[] iArr = new int[Math.max(nativeCalcHitInfo.length - 2, 0)];
            System.arraycopy(nativeCalcHitInfo, 2, iArr, 0, nativeCalcHitInfo.length - 2);
            calcHitInfo = new HitTestInfo(nativeCalcHitInfo[0], iArr, false);
            i = nativeCalcHitInfo[1];
        }
        return new HitTestInfoInternal(calcHitInfo, i);
    }

    private Rect getPaneRectInternal() {
        int[] nativeGetPaneRect = nativeGetPaneRect();
        int i = nativeGetPaneRect[0];
        int i2 = nativeGetPaneRect[1];
        return new Rect(i, i2, nativeGetPaneRect[2] + i, nativeGetPaneRect[3] + i2);
    }

    Rect getAvailableScreenRelativeChart() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        if (getContextProvider().getContext() instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) getContextProvider().getContext()).getBaseContext();
            if (baseContext instanceof Activity) {
                Activity activity = (Activity) baseContext;
                if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                    Rect rect = new Rect();
                    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    i -= rect.left;
                    i2 -= rect.top;
                    i3 = rect.width();
                    i4 = rect.height();
                }
            }
        }
        return new Rect(-i, -i2, i3 - i, i4 - i2);
    }

    long getNativeChart() {
        return this.nativeChart.getObject();
    }

    ContextProvider getContextProvider() {
        return this.contextProvider;
    }

    OverlayController getOverlayController() {
        return this.overlayController;
    }

    HitTestController getHitTestController() {
        if (this.hitTestController == null) {
            this.hitTestController = new HitTestController();
        }
        return this.hitTestController;
    }

    void invalidateChart() {
        if (this.canDraw) {
            this.renderer.notifyStartDrawing();
            this.chartView.requestRender();
        }
    }

    void onChanged(int i) {
        if ((i & 16) == 16) {
            synchronized (syncObject) {
                if (this.isHintShown) {
                    updateHint();
                }
            }
        }
        if ((i & 2) == 2) {
            synchronized (syncObject) {
                hideHintInternal(true);
            }
        }
        if ((i & 1) == 1) {
            invalidateChart();
        }
    }

    void addSeriesInternal(SeriesBase seriesBase) {
        Object obj = syncObject;
        synchronized (obj) {
            if (seriesBase != null) {
                if (!this.series.contains(seriesBase)) {
                    seriesBase.setSyncObject(obj);
                    seriesBase.applyCurrentTheme(getContextProvider(), new Object[0]);
                    seriesBase.addListener(getPropertyChangedListener());
                    this.series.add(seriesBase);
                    nativeAddSeries(seriesBase.getNativeSeries());
                }
            }
        }
    }

    void removeSeriesInternal(SeriesBase seriesBase) {
        synchronized (syncObject) {
            if (seriesBase != null) {
                if (this.series.contains(seriesBase)) {
                    seriesBase.setSyncObject(null);
                }
                this.series.remove(seriesBase);
                seriesBase.removeListener(getPropertyChangedListener());
                nativeRemoveSeries(seriesBase.getNativeSeries());
            }
        }
    }

    void removeAllSeriesInternal() {
        synchronized (syncObject) {
            for (SeriesBase seriesBase : this.series) {
                seriesBase.setSyncObject(null);
                seriesBase.removeListener(getPropertyChangedListener());
            }
            this.series.clear();
            nativeRemoveAllSeries();
        }
    }

    int getSeriesCount() {
        return this.series.size();
    }

    SeriesBase getSeriesAt(long j) {
        if (j < 0 || j >= this.series.size()) {
            return null;
        }
        return this.series.get((int) j);
    }

    void setStyleBase(StyleBase styleBase) {
        this.styledElement.trySetStyle(styleBase);
    }

    TextStyle getTextStyleInternal() {
        return getActualStyleInternal().getTextStyleInternal(getContextProvider());
    }

    Paint getTextStylePaintInternal() {
        return getActualStyleInternal().getTextStylePaintInternal(getContextProvider());
    }

    ChartStyleBase getDefaultStyleInternal() {
        return (ChartStyleBase) this.styledElement.getDefaultStyleFromContainer(ChartStyleBase.class);
    }

    ChartStyleBase getUserStyleInternal() {
        return (ChartStyleBase) this.styledElement.getUserStyleFromContainer(ChartStyleBase.class);
    }

    ChartStyleBase getActualStyleInternal() {
        return (ChartStyleBase) this.styledElement.getActualStyleFromContainer(ChartStyleBase.class, getContextProvider(), new Object[0]);
    }

    void invalidateOverlay() {
        this.overlayView.postInvalidate();
    }

    Rect getPaneRect() {
        Rect paneRectInternal;
        synchronized (syncObject) {
            paneRectInternal = getPaneRectInternal();
        }
        return paneRectInternal;
    }

    boolean singleTap(float f, float f2) {
        SelectionChangedInfo selectionChangedInfo;
        Object obj = syncObject;
        synchronized (obj) {
            Rect availableScreenRelativeChart = getAvailableScreenRelativeChart();
            NavigationProcessResult processGestureTapAction = processGestureTapAction(f, f2, availableScreenRelativeChart.left, availableScreenRelativeChart.top, availableScreenRelativeChart.right, availableScreenRelativeChart.bottom);
            if (processGestureTapAction != null) {
                selectionChangedInfo = processGestureTapAction.getSelectionInfo();
                if (selectionChangedInfo != null) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (this.overlayController.canUpdateOverlay()) {
                    showHintInternal(processGestureTapAction.getOverlayInfos(), processGestureTapAction.getHintInfo());
                }
            } else {
                selectionChangedInfo = null;
            }
        }
        SelectionChangedListener selectionChangedListener = this.selectionChangedListener;
        if (selectionChangedListener == null || selectionChangedInfo == null) {
            return false;
        }
        selectionChangedListener.onSelectionChanged(selectionChangedInfo);
        return false;
    }

    void longPress(float f, float f2) {
        synchronized (syncObject) {
            if (getOverlayController().canUpdateOverlay()) {
                Rect availableScreenRelativeChart = getAvailableScreenRelativeChart();
                NavigationProcessResult processGestureLongPressAction = processGestureLongPressAction(f, f2, availableScreenRelativeChart.left, availableScreenRelativeChart.top, availableScreenRelativeChart.right, availableScreenRelativeChart.bottom);
                if (processGestureLongPressAction != null) {
                    showHintInternal(processGestureLongPressAction.getOverlayInfos(), processGestureLongPressAction.getHintInfo());
                }
            }
        }
    }

    List<SeriesBase> getSeriesInternal() {
        return this.series;
    }

    Size getSize() {
        return this.renderer.getSize();
    }

    void initTheme(Context context, AttributeSet attributeSet, int i, int i2) {
        int i3 = i != 0 ? i : i2;
        if (i3 == 0) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ChartBase, i, i2);
            try {
                i3 = obtainStyledAttributes.getResourceId(R.styleable.ChartBase_android_theme, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        if (i3 != 0) {
            setThemeInternal(i3, false);
        }
    }

    void setThemeInternal(int i, boolean z) {
        if (i == 0) {
            i = DEFAULT_THEME_ID;
        }
        Integer num = this.currentThemeID;
        if (num == null || num.intValue() != i) {
            this.currentThemeID = Integer.valueOf(i);
            if (z) {
                synchronized (syncObject) {
                    applyTheme(getContextProvider());
                }
                invalidateChart();
            }
        }
    }

    void applyTheme(ContextProvider contextProvider) {
        this.styledElement.applyCurrentTheme(contextProvider, new Object[0]);
        this.overlayController.applyTheme(contextProvider);
        this.legend.applyTheme(contextProvider);
        Iterator<SeriesBase> it = this.series.iterator();
        while (it.hasNext()) {
            it.next().applyCurrentTheme(contextProvider, new Object[0]);
        }
    }

    void processGestureEndAction() {
        synchronized (getSyncObject()) {
            nativeProcessGestureEndAction(0.0f, 0.0f);
        }
    }

    void processGesturePanAction(float f, float f2) {
        synchronized (getSyncObject()) {
            nativeProcessGesturePanAction(f, f2);
        }
    }

    void processGestureEndAction(float f, float f2) {
        synchronized (getSyncObject()) {
            nativeProcessGestureEndAction(f, f2);
        }
    }

    void processGesturePinchAction(float f, float f2, float f3, float f4) {
        synchronized (getSyncObject()) {
            nativeProcessGesturePinchAction(f, f2, f3, f4);
        }
    }

    NavigationProcessResult processGestureTapAction(float f, float f2, int i, int i2, int i3, int i4) {
        NavigationProcessResult nativeProcessGestureTapAction;
        synchronized (getSyncObject()) {
            nativeProcessGestureTapAction = nativeProcessGestureTapAction(f, f2, i, i2, i3, i4);
        }
        return nativeProcessGestureTapAction;
    }

    NavigationProcessResult processGestureLongPressAction(float f, float f2, int i, int i2, int i3, int i4) {
        NavigationProcessResult nativeProcessGestureLongPressAction;
        synchronized (getSyncObject()) {
            nativeProcessGestureLongPressAction = nativeProcessGestureLongPressAction(f, f2, i, i2, i3, i4);
        }
        invalidateChart();
        return nativeProcessGestureLongPressAction;
    }

    NavigationProcessResult processGestureDownAction(float f, float f2, int i, int i2, int i3, int i4) {
        NavigationProcessResult nativeProcessGestureDownAction;
        synchronized (getSyncObject()) {
            nativeProcessGestureDownAction = nativeProcessGestureDownAction(f, f2, i, i2, i3, i4);
        }
        invalidateChart();
        return nativeProcessGestureDownAction;
    }

    void updateHint() {
        NavigationProcessResult nativeUpdateHint = nativeUpdateHint();
        if (nativeUpdateHint != null) {
            showHintInternal(nativeUpdateHint.getOverlayInfos(), nativeUpdateHint.getHintInfo());
        }
    }

    HintBase getUserHint() {
        return this.overlayController.getHint();
    }

    HintBase getActualHint() {
        return this.overlayController.getActualHint();
    }

    void setHintInternal(HintBase hintBase) {
        this.overlayController.setHint(hintBase);
    }

    void showHintInternal(OverlayInfo[] overlayInfoArr, HintInfo hintInfo) {
        if (overlayInfoArr != null) {
            updateHintInternal(overlayInfoArr, hintInfo, true);
            this.isHintShown = true;
        }
    }

    void hideHintInternal(boolean z) {
        if (this.isHintShown) {
            this.isHintShown = false;
            updateHintInternal(null, null, z);
        }
    }

    private void updateHintInternal(OverlayInfo[] overlayInfoArr, HintInfo hintInfo, boolean z) {
        this.overlayController.updateOverlay(overlayInfoArr, hintInfo, getPaneRectInternal(), z);
        invalidateOverlay();
    }

    void stopScrollingAnimation() {
        nativeStopScrollingAnimation();
    }

    public void setTheme(int i) {
        setThemeInternal(i, true);
    }

    public Legend getLegend() {
        return this.legend.getLegend();
    }

    public void setLegend(Legend legend) {
        synchronized (syncObject) {
            this.legend.setLegend(legend);
        }
        invalidateChart();
    }

    public void setHintListener(HintListener hintListener) {
        this.overlayController.setHintListener(hintListener);
    }

    public void showHint(int i, int i2) {
        synchronized (syncObject) {
            Rect availableScreenRelativeChart = getAvailableScreenRelativeChart();
            showHintInternal(nativeGetUserHintInfo(i, i2, availableScreenRelativeChart.left, availableScreenRelativeChart.top, availableScreenRelativeChart.right, availableScreenRelativeChart.bottom), null);
        }
    }

    public void showHint(Point point) {
        synchronized (syncObject) {
            Rect availableScreenRelativeChart = getAvailableScreenRelativeChart();
            showHintInternal(nativeGetUserPointOverlayInfo(point.x, point.y, availableScreenRelativeChart.left, availableScreenRelativeChart.top, availableScreenRelativeChart.right, availableScreenRelativeChart.bottom), null);
        }
    }

    public void hideHint() {
        synchronized (syncObject) {
            hideHintInternal(false);
            nativeHideUserHint();
        }
    }

    public SelectionMode getSelectionMode() {
        return this.mSelectionMode;
    }

    public void setSelectionMode(SelectionMode selectionMode) {
        if (selectionMode != null) {
            this.mSelectionMode = selectionMode;
            nativeSetSelectionMode(selectionMode.ordinal());
        }
    }

    public SelectionKind getSelectionKind() {
        return SelectionKind.values()[nativeGetSelectionKind()];
    }

    public void setSelectionKind(SelectionKind selectionKind) {
        if (selectionKind != null) {
            nativeSetSelectionKind(selectionKind.ordinal());
        }
    }

    public SeriesPointInfo[] getSelectedItems() {
        Object[] nativeGetSelectedItems = nativeGetSelectedItems();
        SeriesPointInfo[] seriesPointInfoArr = new SeriesPointInfo[nativeGetSelectedItems.length];
        for (int i = 0; i < nativeGetSelectedItems.length; i++) {
            seriesPointInfoArr[i] = (SeriesPointInfo) nativeGetSelectedItems[i];
        }
        return seriesPointInfoArr;
    }

    public void setSelected(int i, int i2, boolean z) {
        SelectionChangedInfo nativeProcessUserSelection;
        synchronized (syncObject) {
            nativeProcessUserSelection = nativeProcessUserSelection(i, i2, z);
        }
        SelectionChangedListener selectionChangedListener = this.selectionChangedListener;
        if (selectionChangedListener == null || nativeProcessUserSelection == null) {
            return;
        }
        selectionChangedListener.onSelectionChanged(nativeProcessUserSelection);
    }

    public void setSelectionChangedListener(SelectionChangedListener selectionChangedListener) {
        this.selectionChangedListener = selectionChangedListener;
    }

    public void setDrawingListener(DrawingListener drawingListener) {
        this.renderer.setDrawingListener(drawingListener);
    }

    public HitTestInfo calcHitInfo(float f, float f2) {
        HitTestInfo hitInfo;
        synchronized (syncObject) {
            hitInfo = calcHitInfoInternal(f, f2).getHitInfo();
        }
        return hitInfo;
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.loadingDrawable = drawable;
    }

    public void suspendRender() {
        this.canDraw = false;
        if (this.renderMode == RenderMode.SURFACE && this.renderer.isReady().booleanValue()) {
            this.overlayView.setBackgroundBitmap(this.renderer.drawFrameToBitmap(this.chartView));
        }
    }

    public void resumeRender() {
        if (this.renderMode == RenderMode.SURFACE) {
            this.overlayView.setBackgroundBitmap(null);
            this.renderer.resetCurrentImage();
        }
        this.canDraw = true;
        invalidateChart();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.rect.set(0, 0, getWidth(), getHeight());
        canvas.clipRect(this.rect);
        if (this.chartView.canFixFlicker()) {
            ChartStyleBase actualStyleInternal = getActualStyleInternal();
            Drawable drawable = this.loadingDrawable;
            if (drawable != null) {
                drawable.onDraw(canvas);
                if (actualStyleInternal.getBorderThickness() == null) {
                    actualStyleInternal = getDefaultStyleInternal();
                }
                int intValue = actualStyleInternal.getBorderThickness().intValue();
                int substrateBackgroundColor = this.styledElement.getSubstrateBackgroundColor();
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(substrateBackgroundColor);
                float f = intValue;
                canvas.drawRect(0.0f, 0.0f, f, getHeight(), this.paint);
                canvas.drawRect(getWidth() - intValue, 0.0f, getWidth(), getHeight(), this.paint);
                canvas.drawRect(f, 0.0f, getWidth() - intValue, f, this.paint);
                canvas.drawRect(f, getHeight() - intValue, getWidth() - intValue, getHeight(), this.paint);
            } else {
                if (actualStyleInternal.getBackgroundColor() == null) {
                    actualStyleInternal = getDefaultStyleInternal();
                }
                canvas.drawColor(actualStyleInternal.getBackgroundColor().intValue());
            }
        }
        invalidateChart();
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (isInEditMode()) {
            return;
        }
        ChartStyleBase actualStyleInternal = getActualStyleInternal();
        if (actualStyleInternal.getBorderThickness() == null) {
            actualStyleInternal = getDefaultStyleInternal();
        }
        int intValue = actualStyleInternal.getBorderThickness().intValue();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(intValue, intValue, (i3 - i) - intValue, (i4 - i2) - intValue);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.touchEventListener.onInterceptTouchEvent(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mTouchListeners.addListener(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onTouch(MotionEvent motionEvent) {
        return this.touchEventListener.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onAnimationStart() {
        super.onAnimationStart();
        synchronized (syncObject) {
            hideHintInternal(true);
        }
        suspendRender();
    }

    @Override // android.view.View
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        resumeRender();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.overlayController.hide();
    }
}
