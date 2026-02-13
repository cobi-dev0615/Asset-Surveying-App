package com.devexpress.dxcharts;

import com.devexpress.dxcharts.LineIndicatorStyle;
import com.devexpress.dxcharts.MovingAverageConvergenceDivergenceIndicatorStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class MovingAverageConvergenceDivergenceIndicator extends CalculatedSeries {
    private final int DefaultShortPeriod = 12;
    private final int DefaultLongPeriod = 26;
    private final int DefaultSignalSmoothingPeriod = 9;
    ValueLevel _valueLevel = ValueLevel.AUTO;
    int _shortPeriod = 12;
    int _longPeriod = 26;
    int _signalSmoothingPeriod = 9;

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.Series
    native void nativeSetColor(int i);

    native void nativeSetSignalColor(int i);

    native void nativeSetSignalStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.CalculatedSeries
    native void nativeSetStrokeThickness(float f);

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(MovingAverageConvergenceDivergenceIndicatorStyle.class);
    }

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, MovingAverageConvergenceDivergenceIndicatorStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.Series
    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        if (!(xYSeriesData instanceof CalculatedSeriesData)) {
            return null;
        }
        CalculatedSeriesData calculatedSeriesData = (CalculatedSeriesData) xYSeriesData;
        return MACDDataAdapter.create(new CalculatedSeriesDataWrapper(calculatedSeriesData), getNativeSeries(), CalculatedSeries.getActualValueLevel(this._valueLevel, calculatedSeriesData), getSyncObject(), this._shortPeriod, this._longPeriod, this._signalSmoothingPeriod);
    }

    @Override // com.devexpress.dxcharts.CalculatedSeries, com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r7) {
        super.applyStyleAttribute(contextProvider, styleContainer, r7);
        MovingAverageConvergenceDivergenceIndicatorStyle movingAverageConvergenceDivergenceIndicatorStyle = (MovingAverageConvergenceDivergenceIndicatorStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        MovingAverageConvergenceDivergenceIndicatorStyle movingAverageConvergenceDivergenceIndicatorStyle2 = (MovingAverageConvergenceDivergenceIndicatorStyle) styleContainer.getDefaultStyle();
        if (r7 instanceof LineIndicatorStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property[((LineIndicatorStyle.Property) r7).ordinal()];
            if (i == 1) {
                nativeSetColor(ColorHelper.convertToNativeColor((movingAverageConvergenceDivergenceIndicatorStyle.getStroke() != null ? movingAverageConvergenceDivergenceIndicatorStyle : movingAverageConvergenceDivergenceIndicatorStyle2).getStroke()));
            } else if (i == 2) {
                nativeSetStrokeThickness((movingAverageConvergenceDivergenceIndicatorStyle.getStrokeThickness() != null ? movingAverageConvergenceDivergenceIndicatorStyle : movingAverageConvergenceDivergenceIndicatorStyle2).getStrokeThickness().floatValue());
            }
        }
        if (r7 instanceof MovingAverageConvergenceDivergenceIndicatorStyle.Property) {
            int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$MovingAverageConvergenceDivergenceIndicatorStyle$Property[((MovingAverageConvergenceDivergenceIndicatorStyle.Property) r7).ordinal()];
            if (i2 == 1) {
                if (movingAverageConvergenceDivergenceIndicatorStyle.getSignalStroke() == null) {
                    movingAverageConvergenceDivergenceIndicatorStyle = movingAverageConvergenceDivergenceIndicatorStyle2;
                }
                nativeSetSignalColor(ColorHelper.convertToNativeColor(movingAverageConvergenceDivergenceIndicatorStyle.getSignalStroke()));
            } else {
                if (i2 != 2) {
                    return;
                }
                if (movingAverageConvergenceDivergenceIndicatorStyle.getSignalStrokeThickness() == null) {
                    movingAverageConvergenceDivergenceIndicatorStyle = movingAverageConvergenceDivergenceIndicatorStyle2;
                }
                nativeSetSignalStrokeThickness(movingAverageConvergenceDivergenceIndicatorStyle.getSignalStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.MovingAverageConvergenceDivergenceIndicator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$MovingAverageConvergenceDivergenceIndicatorStyle$Property;

        static {
            int[] iArr = new int[MovingAverageConvergenceDivergenceIndicatorStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$MovingAverageConvergenceDivergenceIndicatorStyle$Property = iArr;
            try {
                iArr[MovingAverageConvergenceDivergenceIndicatorStyle.Property.SIGNAL_STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$MovingAverageConvergenceDivergenceIndicatorStyle$Property[MovingAverageConvergenceDivergenceIndicatorStyle.Property.SIGNAL_STROKE_THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[LineIndicatorStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property = iArr2;
            try {
                iArr2[LineIndicatorStyle.Property.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property[LineIndicatorStyle.Property.STROKE_THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ValueLevel getValueLevel() {
        return this._valueLevel;
    }

    public void setValueLevel(ValueLevel valueLevel) {
        if (this._valueLevel != valueLevel) {
            this._valueLevel = valueLevel;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public int getShortPeriod() {
        return this._shortPeriod;
    }

    public void setShortPeriod(int i) {
        if (this._shortPeriod != i) {
            if (i < 2) {
                i = 12;
            }
            this._shortPeriod = i;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public int getLongPeriod() {
        return this._longPeriod;
    }

    public void setLongPeriod(int i) {
        if (this._longPeriod != i) {
            if (i < 2) {
                i = 26;
            }
            this._longPeriod = i;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public int getSignalSmoothingPeriod() {
        return this._signalSmoothingPeriod;
    }

    public void setSignalSmoothingPeriod(int i) {
        if (this._signalSmoothingPeriod != i) {
            if (i < 2) {
                i = 9;
            }
            this._signalSmoothingPeriod = i;
            if (getData() != null) {
                setAdapterInternal(createDataAdapter(getData()));
            }
        }
    }

    public void setStyle(MovingAverageConvergenceDivergenceIndicatorStyle movingAverageConvergenceDivergenceIndicatorStyle) {
        trySetStyle(movingAverageConvergenceDivergenceIndicatorStyle);
    }

    public MovingAverageConvergenceDivergenceIndicatorStyle getStyle() {
        return (MovingAverageConvergenceDivergenceIndicatorStyle) getUserStyleFromContainer(MovingAverageConvergenceDivergenceIndicatorStyle.class);
    }
}
