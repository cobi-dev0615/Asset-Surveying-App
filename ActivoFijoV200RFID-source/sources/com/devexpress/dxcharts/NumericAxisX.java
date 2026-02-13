package com.devexpress.dxcharts;

import androidx.camera.video.AudioStats;
import com.devexpress.dxcharts.ConstantLineBase;
import com.devexpress.dxcharts.LogarithmicOptions;
import com.devexpress.dxcharts.RangeBase;
import com.devexpress.dxcharts.StripBase;

/* loaded from: classes.dex */
public class NumericAxisX extends AxisX {
    private AxisLabelNotationBase mLabelNotation;
    private LogarithmicOptions mLogarithmicOptions;

    native double nativeGetGridAlignment(long j);

    native void nativeSetGridAlignment(long j, double d);

    native void nativeSetLabelNotation(long j, int i);

    native void nativeSetLogarithmic(long j, boolean z);

    native void nativeSetLogarithmicBase(long j, double d);

    @Override // com.devexpress.dxcharts.AxisBase
    long createNativeAxis(IAxisLabelTextProvider iAxisLabelTextProvider) {
        return nativeCreateNumericAxis(false, iAxisLabelTextProvider);
    }

    @Override // com.devexpress.dxcharts.AxisBase
    IAxisLabelTextProvider createLabelTextProvider() {
        return new NumericAxisLabelTextProvider(this);
    }

    @Override // com.devexpress.dxcharts.AxisBase
    RangeBase createAxisRange() {
        return new NumericRange();
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void onRangeChanged(RangeBase rangeBase, RangeBase.Property property) {
        NumericRange numericRange = (NumericRange) rangeBase;
        int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$RangeBase$Property[property.ordinal()];
        if (i == 1) {
            synchronized (ChartBase.syncObject) {
                nativeSetWholeRange(getNativeAxis(), calculateRange(numericRange.getMin(), numericRange.getMax(), numericRange.isDefaultWholeMin(), numericRange.isDefaultWholeMax()), new boolean[]{numericRange.isDefaultWholeMin(), numericRange.isDefaultWholeMax()});
            }
            return;
        }
        if (i == 2) {
            synchronized (ChartBase.syncObject) {
                nativeSetVisualRange(getNativeAxis(), calculateRange(numericRange.getVisualMin(), numericRange.getVisualMax(), numericRange.isDefaultVisualMin(), numericRange.isDefaultVisualMax()), new boolean[]{numericRange.isDefaultVisualMin(), numericRange.isDefaultVisualMax()});
            }
            return;
        }
        if (i != 3) {
            return;
        }
        synchronized (ChartBase.syncObject) {
            nativeSetSideMargin(getNativeAxis(), numericRange.getSideMargin());
        }
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void applyStripChanging(StripBase stripBase, int i, Enum<?> r11) {
        super.applyStripChanging(stripBase, i, r11);
        synchronized (ChartBase.syncObject) {
            if (r11 instanceof StripBase.Property) {
                NumericStrip numericStrip = (NumericStrip) stripBase;
                int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StripBase$Property[((StripBase.Property) r11).ordinal()];
                if (i2 == 1) {
                    nativeSetStripMinLimit(getNativeAxis(), i, numericStrip.getMinLimit());
                } else if (i2 == 2) {
                    nativeSetStripMaxLimit(getNativeAxis(), i, numericStrip.getMaxLimit());
                }
            }
        }
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void applyConstantLineChanging(ConstantLineBase constantLineBase, int i, Enum<?> r11) {
        super.applyConstantLineChanging(constantLineBase, i, r11);
        synchronized (ChartBase.syncObject) {
            if (r11 instanceof ConstantLineBase.Property) {
                NumericConstantLine numericConstantLine = (NumericConstantLine) constantLineBase;
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property[((ConstantLineBase.Property) r11).ordinal()] == 1) {
                    nativeSetConstantLineAxisValue(getNativeAxis(), i, numericConstantLine.getAxisValue());
                }
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.NumericAxisX$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LogarithmicOptions$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$RangeBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StripBase$Property;

        static {
            int[] iArr = new int[LogarithmicOptions.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$LogarithmicOptions$Property = iArr;
            try {
                iArr[LogarithmicOptions.Property.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$LogarithmicOptions$Property[LogarithmicOptions.Property.BASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ConstantLineBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property = iArr2;
            try {
                iArr2[ConstantLineBase.Property.AXIS_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[StripBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$StripBase$Property = iArr3;
            try {
                iArr3[StripBase.Property.MIN_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StripBase$Property[StripBase.Property.MAX_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr4 = new int[RangeBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$RangeBase$Property = iArr4;
            try {
                iArr4[RangeBase.Property.WHOLE_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RangeBase$Property[RangeBase.Property.VISUAL_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RangeBase$Property[RangeBase.Property.SIDE_MARGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    void onLogarithmicOptionsChange(LogarithmicOptions logarithmicOptions, LogarithmicOptions.Property property) {
        int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LogarithmicOptions$Property[property.ordinal()];
        if (i == 1) {
            nativeSetLogarithmic(getNativeAxis(), logarithmicOptions.isEnabled());
        } else {
            if (i != 2) {
                return;
            }
            nativeSetLogarithmicBase(getNativeAxis(), logarithmicOptions.getBase());
        }
    }

    void applyLabelNotation(AxisLabelNotationBase axisLabelNotationBase) {
        if (axisLabelNotationBase instanceof AxisLabelEngineeringNotation) {
            nativeSetLabelNotation(getNativeAxis(), ScientificNotation.values().length);
        } else if (axisLabelNotationBase instanceof AxisLabelScientificNotation) {
            nativeSetLabelNotation(getNativeAxis(), ((AxisLabelScientificNotation) axisLabelNotationBase).getScientificNotation().ordinal());
        }
    }

    @Override // com.devexpress.dxcharts.AxisBase, com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof LogarithmicOptions) {
            onLogarithmicOptionsChange(this.mLogarithmicOptions, (LogarithmicOptions.Property) propertyChangedArgs.getProperty());
        } else if (obj instanceof AxisLabelScientificNotation) {
            applyLabelNotation((AxisLabelNotationBase) obj);
        } else {
            super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        }
    }

    public NumericRange getRange() {
        return (NumericRange) getRangeInternal();
    }

    public void setRange(NumericRange numericRange) {
        setRangeInternal(numericRange);
    }

    public Double getGridAlignment() {
        double nativeGetGridAlignment = nativeGetGridAlignment(getNativeAxis());
        if (nativeGetGridAlignment > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return Double.valueOf(nativeGetGridAlignment);
        }
        return null;
    }

    public void setGridAlignment(Double d) {
        synchronized (ChartBase.syncObject) {
            nativeSetGridAlignment(getNativeAxis(), d != null ? d.doubleValue() : -1.0d);
        }
    }

    public Double getGridOffset() {
        return Double.valueOf(nativeGetGridOffset(getNativeAxis()));
    }

    public void setGridOffset(Double d) {
        synchronized (ChartBase.syncObject) {
            nativeSetGridOffset(getNativeAxis(), d != null ? d.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
        }
    }

    public void addStrip(NumericStrip numericStrip) {
        addStripInternal(numericStrip);
    }

    public void removeStrip(NumericStrip numericStrip) {
        removeStripInternal(numericStrip);
    }

    public void addConstantLine(NumericConstantLine numericConstantLine) {
        addConstantLineInternal(numericConstantLine);
    }

    public void removeConstantLine(NumericConstantLine numericConstantLine) {
        removeConstantLineInternal(numericConstantLine);
    }

    public LogarithmicOptions getLogarithmicOptions() {
        return this.mLogarithmicOptions;
    }

    public void setLogarithmicOptions(LogarithmicOptions logarithmicOptions) {
        if (logarithmicOptions == null) {
            LogarithmicOptions logarithmicOptions2 = this.mLogarithmicOptions;
            if (logarithmicOptions2 != null) {
                logarithmicOptions2.removeListener(getSelfListener());
                this.mLogarithmicOptions = null;
                nativeSetLogarithmic(getNativeAxis(), false);
                return;
            }
            return;
        }
        LogarithmicOptions logarithmicOptions3 = this.mLogarithmicOptions;
        if (logarithmicOptions3 != logarithmicOptions) {
            if (logarithmicOptions3 != null) {
                removeListener(logarithmicOptions3.getSelfListener());
            }
            this.mLogarithmicOptions = logarithmicOptions;
            logarithmicOptions.addListener(getSelfListener());
            onLogarithmicOptionsChange(this.mLogarithmicOptions, LogarithmicOptions.Property.ENABLED);
            onLogarithmicOptionsChange(this.mLogarithmicOptions, LogarithmicOptions.Property.BASE);
        }
    }

    public AxisLabelNotationBase getLabelValueNotation() {
        return this.mLabelNotation;
    }

    public void setLabelValueNotation(AxisLabelNotationBase axisLabelNotationBase) {
        AxisLabelNotationBase axisLabelNotationBase2 = this.mLabelNotation;
        if (axisLabelNotationBase2 != axisLabelNotationBase) {
            if (axisLabelNotationBase2 != null) {
                axisLabelNotationBase2.removeListener(getSelfListener());
            }
            this.mLabelNotation = axisLabelNotationBase;
            if (axisLabelNotationBase != null) {
                axisLabelNotationBase.addListener(getSelfListener());
            }
            applyLabelNotation(this.mLabelNotation);
        }
    }
}
