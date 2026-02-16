package com.devexpress.dxcharts;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.devexpress.dxcharts.ChartBase;
import com.devexpress.dxcharts.CrosshairHintBehavior;
import com.devexpress.dxcharts.HintBase;
import com.devexpress.dxcharts.StaticCrosshairLabelPosition;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Chart extends ChartBase {
    private AnimationTimer animationTimer;
    private IAxesContainer axesContainer;
    private AxisNavigationMode axisXNavigation;
    private AxisNavigationMode axisYNavigation;
    private StyleContainer<AxisStyle> defaultAxisXStyle;
    private StyleContainer<AxisStyle> defaultAxisYStyle;
    private IAxisLabelTextProvider defaultDateTimeLabelTextProvider;
    private IAxisLabelTextProvider defaultNumericLabelTextProvider;
    private QualitativeAxisLabelTextProvider defaultQualitativeLabelTextProvider;
    private ScrollIndicatorsContainer scrollIndicatorsContainer;

    native long nativeCreateChart(IAxisLabelTextProvider iAxisLabelTextProvider, IAxisLabelTextProvider iAxisLabelTextProvider2, QualitativeAxisLabelTextProvider qualitativeAxisLabelTextProvider, AxisStyle axisStyle, AxisStyle axisStyle2, long j, LegendContainer legendContainer, HintContainer hintContainer, long j2, HitTestController hitTestController);

    native double nativeGetAxisMaxZoomPercent();

    native double[] nativeGetAxisXVisualRange();

    native double[] nativeGetAxisXWholeRange();

    native double[] nativeGetAxisYVisualRange();

    native double[] nativeGetAxisYWholeRange();

    native boolean nativeGetRotated();

    native void nativeSetAxisMaxZoomPercent(double d);

    native void nativeSetAxisX(long j);

    native void nativeSetAxisY(long j, boolean z);

    native void nativeSetAxisYNavigationEnabled(boolean z);

    native void nativeSetCrosshairLabelHorizontalAlignment(int i);

    native void nativeSetCrosshairLabelMode(int i);

    native void nativeSetCrosshairLabelVerticalAlignment(int i);

    native void nativeSetRotated(boolean z);

    native void nativeUpdateDefaultDrawOptions(AxisStyle axisStyle, AxisStyle axisStyle2);

    private class ChartStyledElement extends ChartBase.ChartStyledElementBase {
        private ChartStyledElement() {
            super();
        }

        /* synthetic */ ChartStyledElement(Chart chart, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.devexpress.dxcharts.StyledElement
        StyleContainer<? extends StyleBase> createStyleContainer() {
            return new StyleContainer<>(ChartStyle.class);
        }

        @Override // com.devexpress.dxcharts.ChartBase.ChartStyledElementBase
        void applyHintProperties(Enum<?> r6) {
            CrosshairHintBehavior crosshairHintBehavior;
            super.applyHintProperties(r6);
            Hint hint = (Hint) Chart.this.getUserHint();
            StaticCrosshairLabelPosition staticCrosshairLabelPosition = (hint == null || !(hint.getBehaviorInternal() instanceof CrosshairHintBehavior) || (crosshairHintBehavior = (CrosshairHintBehavior) hint.getBehaviorInternal()) == null || !(crosshairHintBehavior.getLabelPosition() instanceof StaticCrosshairLabelPosition)) ? null : (StaticCrosshairLabelPosition) crosshairHintBehavior.getLabelPosition();
            if ((r6 instanceof HintBase.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$HintBase$Property[((HintBase.Property) r6).ordinal()] == 1) {
                Chart.this.nativeSetCrosshairLabelMode(staticCrosshairLabelPosition != null ? 1 : 0);
                Chart.this.nativeSetCrosshairLabelHorizontalAlignment((staticCrosshairLabelPosition != null ? staticCrosshairLabelPosition.getHorizontalAlignment() : StaticCrosshairLabelPosition.DEFAULT_HORIZONTAL_ALIGNMENT).ordinal());
                Chart.this.nativeSetCrosshairLabelVerticalAlignment((staticCrosshairLabelPosition != null ? staticCrosshairLabelPosition.getVerticalAlignment() : StaticCrosshairLabelPosition.DEFAULT_VERTICAL_ALIGNMENT).ordinal());
            }
            if (r6 instanceof CrosshairHintBehavior.Property) {
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$CrosshairHintBehavior$Property[((CrosshairHintBehavior.Property) r6).ordinal()] != 1) {
                    return;
                }
                Chart.this.nativeSetCrosshairLabelMode(staticCrosshairLabelPosition != null ? 1 : 0);
            } else if (r6 instanceof StaticCrosshairLabelPosition.Property) {
                int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StaticCrosshairLabelPosition$Property[((StaticCrosshairLabelPosition.Property) r6).ordinal()];
                if (i == 1) {
                    Chart.this.nativeSetCrosshairLabelHorizontalAlignment((staticCrosshairLabelPosition != null ? staticCrosshairLabelPosition.getHorizontalAlignment() : StaticCrosshairLabelPosition.DEFAULT_HORIZONTAL_ALIGNMENT).ordinal());
                } else {
                    if (i != 2) {
                        return;
                    }
                    Chart.this.nativeSetCrosshairLabelVerticalAlignment((staticCrosshairLabelPosition != null ? staticCrosshairLabelPosition.getVerticalAlignment() : StaticCrosshairLabelPosition.DEFAULT_VERTICAL_ALIGNMENT).ordinal());
                }
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.Chart$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$CrosshairHintBehavior$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$HintBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StaticCrosshairLabelPosition$Property;

        static {
            int[] iArr = new int[StaticCrosshairLabelPosition.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$StaticCrosshairLabelPosition$Property = iArr;
            try {
                iArr[StaticCrosshairLabelPosition.Property.HORIZONTAL_ALIGNMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StaticCrosshairLabelPosition$Property[StaticCrosshairLabelPosition.Property.VERTICAL_ALIGNMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CrosshairHintBehavior.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$CrosshairHintBehavior$Property = iArr2;
            try {
                iArr2[CrosshairHintBehavior.Property.LABEL_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[HintBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$HintBase$Property = iArr3;
            try {
                iArr3[HintBase.Property.BEHAVIOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Chart(Context context) {
        this(context, null);
    }

    public Chart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axisXNavigation = AxisNavigationMode.NONE;
        this.axisYNavigation = AxisNavigationMode.NONE;
    }

    public Chart(Context context, AttributeSet attributeSet, int i, RenderMode renderMode) {
        super(context, attributeSet, i, renderMode);
        this.axisXNavigation = AxisNavigationMode.NONE;
        this.axisYNavigation = AxisNavigationMode.NONE;
    }

    public Chart(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.axisXNavigation = AxisNavigationMode.NONE;
        this.axisYNavigation = AxisNavigationMode.NONE;
    }

    public Chart(Context context, AttributeSet attributeSet, int i, int i2, RenderMode renderMode) {
        super(context, attributeSet, i, i2, renderMode);
        this.axisXNavigation = AxisNavigationMode.NONE;
        this.axisYNavigation = AxisNavigationMode.NONE;
    }

    @Override // com.devexpress.dxcharts.ChartBase
    NativeObjectWrapper createNativeChart(LegendContainer legendContainer, HintContainer hintContainer, TextStyleProviderInterface textStyleProviderInterface) {
        ContextProvider contextProvider = getContextProvider();
        this.defaultNumericLabelTextProvider = new NumericAxisLabelTextProvider(null);
        this.defaultDateTimeLabelTextProvider = new DateTimeAxisLabelTextProvider(null);
        this.defaultQualitativeLabelTextProvider = new QualitativeAxisLabelTextProvider(null);
        this.defaultAxisXStyle = new StyleContainer<>(AxisStyle.class);
        this.defaultAxisYStyle = new StyleContainer<>(AxisStyle.class);
        this.animationTimer = new AnimationTimer();
        return new NativeObjectWrapper(nativeCreateChart(this.defaultNumericLabelTextProvider, this.defaultDateTimeLabelTextProvider, this.defaultQualitativeLabelTextProvider, this.defaultAxisXStyle.getDefaultStyle(contextProvider, true), this.defaultAxisYStyle.getDefaultStyle(contextProvider, false), textStyleProviderInterface.getNativeProvider(), legendContainer, hintContainer, this.animationTimer.getNativeTimer(), getHitTestController()));
    }

    @Override // com.devexpress.dxcharts.ChartBase
    TextStyleProviderInterface createTextStyleProvider() {
        return new ChartTextStyleProvider(this.axesContainer);
    }

    @Override // com.devexpress.dxcharts.ChartBase
    OnTouchEventListener createTouchEventListener() {
        return new GestureScaleListener(getContext(), this);
    }

    @Override // com.devexpress.dxcharts.ChartBase
    void initView(Context context) {
        this.axesContainer = new AxesRepository(this);
        super.initView(context);
        ScrollIndicatorsContainer scrollIndicatorsContainer = new ScrollIndicatorsContainer(context, this);
        this.scrollIndicatorsContainer = scrollIndicatorsContainer;
        addOverlayDrawableToView(scrollIndicatorsContainer);
    }

    @Override // com.devexpress.dxcharts.ChartBase, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.animationTimer.stop();
        super.onDetachedFromWindow();
    }

    @Override // com.devexpress.dxcharts.ChartBase
    void onChanged(int i) {
        super.onChanged(i);
        if ((i & 4) == 4) {
            this.scrollIndicatorsContainer.showIndicators();
        }
        if ((i & 8) == 8) {
            this.scrollIndicatorsContainer.hideIndicators();
        }
    }

    MinMaxValues getAxisXWholeRange() {
        MinMaxValues minMaxValues;
        synchronized (ChartBase.syncObject) {
            double[] nativeGetAxisYWholeRange = isRotated() ? nativeGetAxisYWholeRange() : nativeGetAxisXWholeRange();
            minMaxValues = new MinMaxValues(nativeGetAxisYWholeRange[0], nativeGetAxisYWholeRange[1]);
        }
        return minMaxValues;
    }

    MinMaxValues getAxisXVisualRange() {
        MinMaxValues minMaxValues;
        synchronized (ChartBase.syncObject) {
            double[] nativeGetAxisYVisualRange = isRotated() ? nativeGetAxisYVisualRange() : nativeGetAxisXVisualRange();
            minMaxValues = new MinMaxValues(nativeGetAxisYVisualRange[0], nativeGetAxisYVisualRange[1]);
        }
        return minMaxValues;
    }

    MinMaxValues getAxisYWholeRange() {
        MinMaxValues minMaxValues;
        synchronized (ChartBase.syncObject) {
            double[] nativeGetAxisXWholeRange = isRotated() ? nativeGetAxisXWholeRange() : nativeGetAxisYWholeRange();
            minMaxValues = new MinMaxValues(nativeGetAxisXWholeRange[0], nativeGetAxisXWholeRange[1]);
        }
        return minMaxValues;
    }

    MinMaxValues getAxisYVisualRange() {
        MinMaxValues minMaxValues;
        synchronized (ChartBase.syncObject) {
            double[] nativeGetAxisXVisualRange = isRotated() ? nativeGetAxisXVisualRange() : nativeGetAxisYVisualRange();
            minMaxValues = new MinMaxValues(nativeGetAxisXVisualRange[0], nativeGetAxisXVisualRange[1]);
        }
        return minMaxValues;
    }

    @Override // com.devexpress.dxcharts.ChartBase
    ChartBase.ChartStyledElementBase createChartStyleElement() {
        return new ChartStyledElement(this, null);
    }

    @Override // com.devexpress.dxcharts.ChartBase
    void applyTheme(ContextProvider contextProvider) {
        super.applyTheme(contextProvider);
        IAxesContainer iAxesContainer = this.axesContainer;
        if (iAxesContainer != null) {
            iAxesContainer.applyTheme(contextProvider);
        }
        this.defaultAxisXStyle.resetDefaultStyle();
        this.defaultAxisYStyle.resetDefaultStyle();
        nativeUpdateDefaultDrawOptions(this.defaultAxisXStyle.getDefaultStyle(contextProvider, true), this.defaultAxisYStyle.getDefaultStyle(contextProvider, false));
    }

    void longPressEnd() {
        if (getOverlayController().canUpdateOverlay()) {
            synchronized (getSyncObject()) {
                processGestureEndAction();
            }
        }
    }

    boolean down(float f, float f2) {
        synchronized (getSyncObject()) {
            if (getOverlayController().canUpdateOverlay()) {
                Rect availableScreenRelativeChart = getAvailableScreenRelativeChart();
                NavigationProcessResult processGestureDownAction = processGestureDownAction(f, f2, availableScreenRelativeChart.left, availableScreenRelativeChart.top, availableScreenRelativeChart.right, availableScreenRelativeChart.bottom);
                if (processGestureDownAction != null) {
                    OverlayInfo[] overlayInfos = processGestureDownAction.getOverlayInfos();
                    showHintInternal(overlayInfos, processGestureDownAction.getHintInfo());
                    return overlayInfos != null;
                }
            }
            return false;
        }
    }

    void up() {
        if (getOverlayController().canUpdateOverlay()) {
            synchronized (getSyncObject()) {
                processGestureEndAction();
            }
        }
    }

    IAxesContainer getAxesContainer() {
        return this.axesContainer;
    }

    public AxisX getAxisX() {
        return this.axesContainer.getAxisXByElement(this);
    }

    public void setAxisX(AxisX axisX) {
        synchronized (getSyncObject()) {
            if (getAxisX() != axisX) {
                if (getAxisX() != null) {
                    getAxisX().setPrimary(false);
                    getAxisX().removeListener(getPropertyChangedListener());
                }
                if (axisX != null) {
                    axisX.setPrimary(true);
                }
                this.axesContainer.addAxisXForElement(axisX, this);
                if (getAxisX() != null) {
                    getAxisX().addListener(getPropertyChangedListener());
                    nativeSetAxisX(getAxisX().getNativeAxis());
                }
            }
        }
    }

    public NumericAxisY getAxisY() {
        return this.axesContainer.getAxisYByElement(this);
    }

    public void setAxisY(NumericAxisY numericAxisY) {
        synchronized (getSyncObject()) {
            if (getAxisY() != numericAxisY) {
                if (getAxisY() != null) {
                    getAxisY().setPrimary(false);
                    getAxisY().removeListener(getPropertyChangedListener());
                }
                if (numericAxisY != null) {
                    numericAxisY.setPrimary(true);
                }
                this.axesContainer.addAxisYForElement(numericAxisY, this);
                if (getAxisY() != null) {
                    getAxisY().addListener(getPropertyChangedListener());
                    nativeSetAxisY(getAxisY().getNativeAxis(), getAxisY().isAlwaysShowZeroLevel());
                }
            }
        }
    }

    public Series[] getSeries() {
        List<SeriesBase> seriesInternal = getSeriesInternal();
        return (Series[]) Arrays.copyOf(seriesInternal.toArray(), seriesInternal.size(), Series[].class);
    }

    public void addSeries(Series series) {
        if (series != null) {
            series.setAxesContainer(this.axesContainer);
        }
        addSeriesInternal(series);
    }

    public void removeSeries(int i) {
        List<SeriesBase> seriesInternal = getSeriesInternal();
        removeSeries((i >= seriesInternal.size() || i < 0) ? null : (Series) seriesInternal.get(i));
    }

    public void removeSeries(Series series) {
        if (series != null) {
            series.setAxesContainer(null);
        }
        removeSeriesInternal(series);
    }

    public void removeAllSeries() {
        Iterator<SeriesBase> it = getSeriesInternal().iterator();
        while (it.hasNext()) {
            ((Series) it.next()).setAxesContainer(null);
        }
        removeAllSeriesInternal();
    }

    public AxisNavigationMode getAxisXNavigationMode() {
        return this.axisXNavigation;
    }

    public void setAxisXNavigationMode(AxisNavigationMode axisNavigationMode) {
        if (axisNavigationMode == null || this.axisXNavigation == axisNavigationMode) {
            return;
        }
        this.axisXNavigation = axisNavigationMode;
    }

    public AxisNavigationMode getAxisYNavigationMode() {
        return this.axisYNavigation;
    }

    public void setAxisYNavigationMode(AxisNavigationMode axisNavigationMode) {
        if (axisNavigationMode == null || this.axisYNavigation == axisNavigationMode) {
            return;
        }
        this.axisYNavigation = axisNavigationMode;
        nativeSetAxisYNavigationEnabled(axisNavigationMode != AxisNavigationMode.NONE);
    }

    public ChartStyle getStyle() {
        return (ChartStyle) getUserStyleInternal();
    }

    public void setStyle(ChartStyle chartStyle) {
        setStyleBase(chartStyle);
    }

    public boolean isRotated() {
        return nativeGetRotated();
    }

    public void setRotated(boolean z) {
        nativeSetRotated(z);
    }

    public double getAxisMaxZoomPercent() {
        return nativeGetAxisMaxZoomPercent();
    }

    public void setAxisMaxZoomPercent(double d) {
        nativeSetAxisMaxZoomPercent(d);
    }

    public boolean isScrollIndicatorsEnabled() {
        return this.scrollIndicatorsContainer.isIndicatorsEnabled();
    }

    public void setScrollIndicatorsEnabled(boolean z) {
        this.scrollIndicatorsContainer.setIndicatorsEnabled(z);
    }

    public Hint getHint() {
        return (Hint) getUserHint();
    }

    public void setHint(Hint hint) {
        setHintInternal(hint);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected android.util.Size onMeasureCore(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 0) {
            size = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 0) {
            size2 = getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY);
        if (!isInEditMode()) {
            ChartStyleBase chartStyleBase = (ChartStyle) getActualStyleInternal();
            if (chartStyleBase.getBorderThickness() == null) {
                chartStyleBase = getDefaultStyleInternal();
            }
            int intValue = chartStyleBase.getBorderThickness().intValue() * 2;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                measureChild(getChildAt(i3), makeMeasureSpec - intValue, makeMeasureSpec2 - intValue);
            }
        }
        return new android.util.Size(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
