package com.devexpress.dxcharts;

import com.devexpress.dxcharts.LineIndicatorStyle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class CalculatedSeries extends Series {
    @Override // com.devexpress.dxcharts.Series, com.devexpress.dxcharts.SeriesBase
    native long nativeCreateSeries(long j);

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    @Override // com.devexpress.dxcharts.Series
    native void nativeSetColor(int i);

    native void nativeSetStrokeThickness(float f);

    private static ValueLevel getDefaultValueLevel(CalculatedSeriesData calculatedSeriesData) {
        if (calculatedSeriesData.getSource() instanceof FinancialSeries) {
            return ValueLevel.CLOSE;
        }
        return ValueLevel.VALUE;
    }

    protected static ValueLevel getActualValueLevel(ValueLevel valueLevel, CalculatedSeriesData calculatedSeriesData) {
        Series source = calculatedSeriesData.getSource();
        switch (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ValueLevel[valueLevel.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                if (!(source instanceof FinancialSeries)) {
                    break;
                }
                break;
            case 5:
                if (!(source instanceof BubbleSeries)) {
                    break;
                }
                break;
            case 6:
                if (source instanceof FinancialSeries) {
                    break;
                }
                break;
        }
        return getDefaultValueLevel(calculatedSeriesData);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(LineIndicatorStyle.class);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new MarkerSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, LineIndicatorStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r4) {
        super.applyStyleAttribute(contextProvider, styleContainer, r4);
        LineIndicatorStyle lineIndicatorStyle = (LineIndicatorStyle) styleContainer.getActualStyle(contextProvider, new Object[0]);
        LineIndicatorStyle lineIndicatorStyle2 = (LineIndicatorStyle) styleContainer.getDefaultStyle();
        if (r4 instanceof LineIndicatorStyle.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property[((LineIndicatorStyle.Property) r4).ordinal()];
            if (i == 1) {
                if (lineIndicatorStyle.getStroke() == null) {
                    lineIndicatorStyle = lineIndicatorStyle2;
                }
                nativeSetColor(ColorHelper.convertToNativeColor(lineIndicatorStyle.getStroke()));
            } else {
                if (i != 2) {
                    return;
                }
                if (lineIndicatorStyle.getStrokeThickness() == null) {
                    lineIndicatorStyle = lineIndicatorStyle2;
                }
                nativeSetStrokeThickness(lineIndicatorStyle.getStrokeThickness().floatValue());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.CalculatedSeries$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ValueLevel;

        static {
            int[] iArr = new int[LineIndicatorStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property = iArr;
            try {
                iArr[LineIndicatorStyle.Property.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$LineIndicatorStyle$Property[LineIndicatorStyle.Property.STROKE_THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ValueLevel.values().length];
            $SwitchMap$com$devexpress$dxcharts$ValueLevel = iArr2;
            try {
                iArr2[ValueLevel.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ValueLevel[ValueLevel.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ValueLevel[ValueLevel.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ValueLevel[ValueLevel.CLOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ValueLevel[ValueLevel.WEIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ValueLevel[ValueLevel.VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ValueLevel[ValueLevel.AUTO.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
