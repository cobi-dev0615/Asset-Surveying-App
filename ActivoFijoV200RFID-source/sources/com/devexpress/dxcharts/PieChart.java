package com.devexpress.dxcharts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.devexpress.dxcharts.ChartBase;
import com.devexpress.dxcharts.PieChartStyle;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class PieChart extends ChartBase {
    native long nativeCreatePieChart(long j, LegendContainer legendContainer, HintContainer hintContainer, HitTestController hitTestController);

    native int nativeGetSelectionBehavior();

    native int[] nativeGetSeriesBounds(long j);

    native void nativeSetSelectionBehavior(int i);

    native void nativeSetSeriesIndent(float f);

    private class PieChartStyledElement extends ChartBase.ChartStyledElementBase {
        private PieChartStyledElement() {
            super();
        }

        @Override // com.devexpress.dxcharts.StyledElement
        StyleContainer<? extends StyleBase> createStyleContainer() {
            return new StyleContainer<>(PieChartStyle.class);
        }

        @Override // com.devexpress.dxcharts.ChartBase.ChartStyledElementBase, com.devexpress.dxcharts.StyledElement
        List<Enum<?>> getListenPropertiesNames() {
            List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
            Collections.addAll(listenPropertiesNames, PieChartStyle.Property.values());
            return listenPropertiesNames;
        }

        @Override // com.devexpress.dxcharts.ChartBase.ChartStyledElementBase, com.devexpress.dxcharts.StyledElement
        void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
            super.applyStyleAttribute(contextProvider, styleContainer, r4);
            if ((r4 instanceof PieChartStyle.Property) && AnonymousClass2.$SwitchMap$com$devexpress$dxcharts$PieChartStyle$Property[((PieChartStyle.Property) r4).ordinal()] == 1) {
                PieChartStyle pieChartStyle = (PieChartStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
                PieChartStyle pieChartStyle2 = (PieChartStyle) styleContainer.getDefaultStyle();
                PieChart pieChart = PieChart.this;
                if (pieChartStyle.getSeriesIndent() == null) {
                    pieChartStyle = pieChartStyle2;
                }
                pieChart.nativeSetSeriesIndent(pieChartStyle.getSeriesIndent().intValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.PieChart$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$PieChartStyle$Property;

        static {
            int[] iArr = new int[PieChartStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$PieChartStyle$Property = iArr;
            try {
                iArr[PieChartStyle.Property.SERIES_INDENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public PieChart(Context context) {
        super(context);
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i, RenderMode renderMode) {
        super(context, attributeSet, i, renderMode);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i, int i2, RenderMode renderMode) {
        super(context, attributeSet, i, i2, renderMode);
    }

    Rect getSeriesBounds(PieSeries pieSeries) {
        int[] nativeGetSeriesBounds = nativeGetSeriesBounds(pieSeries.getNativeSeries());
        return new Rect(nativeGetSeriesBounds[0], nativeGetSeriesBounds[1], nativeGetSeriesBounds[2], nativeGetSeriesBounds[3]);
    }

    @Override // com.devexpress.dxcharts.ChartBase
    void initView(Context context) {
        super.initView(context);
        addOverlayDrawableToView(new OverlayDrawableInterface() { // from class: com.devexpress.dxcharts.PieChart.1
            @Override // com.devexpress.dxcharts.OverlayDrawableInterface
            public boolean canDraw() {
                for (int i = 0; i < PieChart.this.getSeriesCount(); i++) {
                    PieSeries pieSeries = (PieSeries) PieChart.this.getSeriesAt(i);
                    if (pieSeries.isVisible() && pieSeries.getCenterLabel() != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override // com.devexpress.dxcharts.OverlayDrawableInterface
            public void draw(Canvas canvas, ContextProvider contextProvider) {
                for (int i = 0; i < PieChart.this.getSeriesCount(); i++) {
                    PieSeries pieSeries = (PieSeries) PieChart.this.getSeriesAt(i);
                    PieCenterLabel centerLabel = pieSeries.getCenterLabel();
                    if (centerLabel != null) {
                        Rect rect = new Rect();
                        Rect calculateDrawBounds = calculateDrawBounds(PieChart.this.getSeriesBounds(pieSeries), 1.0f);
                        float nativeGetHoleRadius = pieSeries.nativeGetHoleRadius();
                        if (nativeGetHoleRadius > 0.0f) {
                            rect.set(calculateDrawBounds(PieChart.this.getSeriesBounds(pieSeries), nativeGetHoleRadius));
                        }
                        canvas.save();
                        centerLabel.draw(canvas, calculateDrawBounds, rect, pieSeries);
                        canvas.restore();
                    }
                }
            }

            private Rect calculateDrawBounds(Rect rect, float f) {
                float min = Math.min(rect.width(), rect.height()) * f;
                return new Rect(((int) ((rect.left + rect.right) - min)) / 2, ((int) ((rect.top + rect.bottom) - min)) / 2, ((int) ((rect.left + rect.right) + min)) / 2, ((int) ((rect.top + rect.bottom) + min)) / 2);
            }
        });
    }

    @Override // com.devexpress.dxcharts.ChartBase
    TextStyleProviderInterface createTextStyleProvider() {
        return new PieTextStyleProvider(this);
    }

    @Override // com.devexpress.dxcharts.ChartBase
    ChartBase.ChartStyledElementBase createChartStyleElement() {
        return new PieChartStyledElement();
    }

    @Override // com.devexpress.dxcharts.ChartBase
    NativeObjectWrapper createNativeChart(LegendContainer legendContainer, HintContainer hintContainer, TextStyleProviderInterface textStyleProviderInterface) {
        return new NativeObjectWrapper(nativeCreatePieChart(textStyleProviderInterface.getNativeProvider(), legendContainer, hintContainer, getHitTestController()));
    }

    @Override // com.devexpress.dxcharts.ChartBase
    OnTouchEventListener createTouchEventListener() {
        return new GestureListener(getContext(), this);
    }

    @Override // com.devexpress.dxcore.DXNativeView
    protected android.util.Size onMeasureCore(int i, int i2) {
        return new android.util.Size(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public PieSeries[] getSeries() {
        List<SeriesBase> seriesInternal = getSeriesInternal();
        return (PieSeries[]) Arrays.copyOf(seriesInternal.toArray(), seriesInternal.size(), PieSeries[].class);
    }

    public void addSeries(PieSeries pieSeries) {
        addSeriesInternal(pieSeries);
    }

    public void removeSeries(PieSeries pieSeries) {
        removeSeriesInternal(pieSeries);
    }

    public void removeSeries(int i) {
        removeSeriesInternal(getSeriesInternal().get(i));
    }

    public void removeAllSeries() {
        removeAllSeriesInternal();
    }

    public PieChartStyle getStyle() {
        return (PieChartStyle) getUserStyleInternal();
    }

    public void setStyle(PieChartStyle pieChartStyle) {
        setStyleBase(pieChartStyle);
    }

    public SelectionBehavior getSelectionBehavior() {
        return SelectionBehavior.values()[nativeGetSelectionBehavior()];
    }

    public void setSelectionBehavior(SelectionBehavior selectionBehavior) {
        if (selectionBehavior != null) {
            nativeSetSelectionBehavior(selectionBehavior.ordinal());
        }
    }

    public PieHint getHint() {
        return (PieHint) getUserHint();
    }

    public void setHint(PieHint pieHint) {
        setHintInternal(pieHint);
    }
}
