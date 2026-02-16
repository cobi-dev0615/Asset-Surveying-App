package com.devexpress.dxcharts;

import androidx.camera.video.AudioStats;
import com.devexpress.dxcharts.ConstantLineBase;
import com.devexpress.dxcharts.LabelFormatAutoReplaceOptions;
import com.devexpress.dxcharts.RangeBase;
import com.devexpress.dxcharts.StripBase;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class DateTimeAxisX extends AxisX {
    private LabelFormatAutoReplaceOptions labelFormatAutoReplaceOptions;

    native int nativeGetAggregationType(long j);

    native boolean nativeGetEmptyRangesVivsible(long j);

    native int nativeGetGridAlignment(long j);

    native int nativeGetGridSpacing(long j);

    native int nativeGetMeasureUnit(long j);

    native void nativeSetAggregationType(long j, int i);

    native void nativeSetEmptyRangesVivsible(long j, boolean z);

    native void nativeSetGridAlignment(long j, int i);

    native void nativeSetGridSpacing(long j, int i);

    native void nativeSetLabelFormatAutoReplaceEnabled(long j, boolean z);

    native void nativeSetLabelFormatAutoReplaceLF(long j, int i, int[] iArr, String[] strArr);

    native void nativeSetMeasureUnit(long j, int i);

    @Override // com.devexpress.dxcharts.AxisBase
    long createNativeAxis(IAxisLabelTextProvider iAxisLabelTextProvider) {
        return nativeCreateDateTimeAxis(iAxisLabelTextProvider);
    }

    @Override // com.devexpress.dxcharts.AxisBase
    IAxisLabelTextProvider createLabelTextProvider() {
        return new DateTimeAxisLabelTextProvider(this);
    }

    @Override // com.devexpress.dxcharts.AxisBase
    RangeBase createAxisRange() {
        return new DateTimeRange();
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void onRangeChanged(RangeBase rangeBase, RangeBase.Property property) {
        DateTimeRange dateTimeRange = (DateTimeRange) rangeBase;
        int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$RangeBase$Property[property.ordinal()];
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (i == 1) {
            synchronized (ChartBase.syncObject) {
                Date min = dateTimeRange.getMin();
                Date max = dateTimeRange.getMax();
                double time = min != null ? min.getTime() / 1000.0d : 0.0d;
                if (max != null) {
                    d = max.getTime() / 1000.0d;
                }
                nativeSetWholeRange(getNativeAxis(), calculateRange(time, d, dateTimeRange.isDefaultWholeMin(), dateTimeRange.isDefaultWholeMax()), new boolean[]{dateTimeRange.isDefaultWholeMin(), dateTimeRange.isDefaultWholeMax()});
            }
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            synchronized (ChartBase.syncObject) {
                nativeSetSideMargin(getNativeAxis(), dateTimeRange.getSideMargin());
            }
            return;
        }
        synchronized (ChartBase.syncObject) {
            Date visualMin = dateTimeRange.getVisualMin();
            Date visualMax = dateTimeRange.getVisualMax();
            double time2 = visualMin != null ? visualMin.getTime() / 1000.0d : 0.0d;
            if (visualMax != null) {
                d = visualMax.getTime() / 1000.0d;
            }
            nativeSetVisualRange(getNativeAxis(), calculateRange(time2, d, dateTimeRange.isDefaultVisualMin(), dateTimeRange.isDefaultVisualMax()), new boolean[]{dateTimeRange.isDefaultVisualMin(), dateTimeRange.isDefaultVisualMax()});
        }
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void applyStripChanging(StripBase stripBase, int i, Enum<?> r13) {
        super.applyStripChanging(stripBase, i, r13);
        synchronized (ChartBase.syncObject) {
            if (r13 instanceof StripBase.Property) {
                DateTimeStrip dateTimeStrip = (DateTimeStrip) stripBase;
                int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StripBase$Property[((StripBase.Property) r13).ordinal()];
                if (i2 == 1) {
                    if (dateTimeStrip.getMinLimit() != null) {
                        nativeSetStripMinLimit(getNativeAxis(), i, dateTimeStrip.getMinLimit().getTime() / 1000.0d);
                    }
                } else if (i2 == 2 && dateTimeStrip.getMaxLimit() != null) {
                    nativeSetStripMaxLimit(getNativeAxis(), i, dateTimeStrip.getMaxLimit().getTime() / 1000.0d);
                }
            }
        }
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void applyConstantLineChanging(ConstantLineBase constantLineBase, int i, Enum<?> r11) {
        super.applyConstantLineChanging(constantLineBase, i, r11);
        synchronized (ChartBase.syncObject) {
            if (r11 instanceof ConstantLineBase.Property) {
                DateTimeConstantLine dateTimeConstantLine = (DateTimeConstantLine) constantLineBase;
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property[((ConstantLineBase.Property) r11).ordinal()] == 1 && dateTimeConstantLine.getAxisValue() != null) {
                    nativeSetConstantLineAxisValue(getNativeAxis(), i, dateTimeConstantLine.getAxisValue().getTime() / 1000.0d);
                }
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.DateTimeAxisX$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$LabelFormatAutoReplaceOptions$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$RangeBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StripBase$Property;

        static {
            int[] iArr = new int[LabelFormatAutoReplaceOptions.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$LabelFormatAutoReplaceOptions$Property = iArr;
            try {
                iArr[LabelFormatAutoReplaceOptions.Property.LABEL_FORMATS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$LabelFormatAutoReplaceOptions$Property[LabelFormatAutoReplaceOptions.Property.ENABLE_LABEL_FORMATS.ordinal()] = 2;
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

    void applyLabelFormatAutoReplaceOptionsChanging(LabelFormatAutoReplaceOptions labelFormatAutoReplaceOptions, Enum<?> r5) {
        synchronized (ChartBase.syncObject) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$LabelFormatAutoReplaceOptions$Property[((LabelFormatAutoReplaceOptions.Property) r5).ordinal()];
            if (i == 1) {
                setLabelFormatsToNative(labelFormatAutoReplaceOptions.getLabelFormatMap());
            } else if (i == 2) {
                nativeSetLabelFormatAutoReplaceEnabled(getNativeAxis(), labelFormatAutoReplaceOptions.isEnabled());
            }
        }
    }

    @Override // com.devexpress.dxcharts.AxisBase, com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof LabelFormatAutoReplaceOptions) {
            applyLabelFormatAutoReplaceOptionsChanging((LabelFormatAutoReplaceOptions) obj, propertyChangedArgs.getProperty());
        } else {
            super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        }
    }

    private void setLabelFormatsToNative(Map<DateTimeMeasureUnit, String> map) {
        int[] iArr = new int[map.size()];
        String[] strArr = new String[map.size()];
        int i = 0;
        for (DateTimeMeasureUnit dateTimeMeasureUnit : map.keySet()) {
            iArr[i] = dateTimeMeasureUnit.ordinal();
            strArr[i] = map.get(dateTimeMeasureUnit);
            i++;
        }
        nativeSetLabelFormatAutoReplaceLF(getNativeAxis(), map.size(), iArr, strArr);
    }

    public DateTimeRange getRange() {
        return (DateTimeRange) getRangeInternal();
    }

    public void setRange(DateTimeRange dateTimeRange) {
        setRangeInternal(dateTimeRange);
    }

    public DateTimeMeasureUnit getMeasureUnit() {
        return DateTimeMeasureUnit.values()[nativeGetMeasureUnit(getNativeAxis())];
    }

    public void setMeasureUnit(DateTimeMeasureUnit dateTimeMeasureUnit) {
        synchronized (ChartBase.syncObject) {
            if (dateTimeMeasureUnit != null) {
                nativeSetMeasureUnit(getNativeAxis(), dateTimeMeasureUnit.ordinal());
            }
        }
    }

    public AggregationType getAggregationType() {
        return AggregationType.values()[nativeGetAggregationType(getNativeAxis())];
    }

    public void setAggregationType(AggregationType aggregationType) {
        synchronized (ChartBase.syncObject) {
            if (aggregationType != null) {
                nativeSetAggregationType(getNativeAxis(), aggregationType.ordinal());
            }
        }
    }

    public Integer getGridSpacing() {
        int nativeGetGridSpacing = nativeGetGridSpacing(getNativeAxis());
        if (nativeGetGridSpacing >= 1) {
            return Integer.valueOf(nativeGetGridSpacing);
        }
        return null;
    }

    public void setGridSpacing(Integer num) {
        synchronized (ChartBase.syncObject) {
            nativeSetGridSpacing(getNativeAxis(), (num == null || num.intValue() < 1) ? -1 : num.intValue());
        }
    }

    public DateTimeMeasureUnit getGridAlignment() {
        return DateTimeMeasureUnit.values()[nativeGetGridAlignment(getNativeAxis())];
    }

    public void setGridAlignment(DateTimeMeasureUnit dateTimeMeasureUnit) {
        synchronized (ChartBase.syncObject) {
            if (dateTimeMeasureUnit != null) {
                nativeSetGridAlignment(getNativeAxis(), dateTimeMeasureUnit.ordinal());
            }
        }
    }

    public Integer getGridOffset() {
        return Integer.valueOf((int) nativeGetGridOffset(getNativeAxis()));
    }

    public void setGridOffset(Integer num) {
        synchronized (ChartBase.syncObject) {
            nativeSetGridOffset(getNativeAxis(), num != null ? num.intValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
        }
    }

    public void addStrip(DateTimeStrip dateTimeStrip) {
        addStripInternal(dateTimeStrip);
    }

    public void removeStrip(DateTimeStrip dateTimeStrip) {
        removeStripInternal(dateTimeStrip);
    }

    public void addConstantLine(DateTimeConstantLine dateTimeConstantLine) {
        addConstantLineInternal(dateTimeConstantLine);
    }

    public void removeConstantLine(DateTimeConstantLine dateTimeConstantLine) {
        removeConstantLineInternal(dateTimeConstantLine);
    }

    public void setEmptyRangesVisible(boolean z) {
        synchronized (ChartBase.syncObject) {
            nativeSetEmptyRangesVivsible(getNativeAxis(), z);
        }
    }

    public boolean getEmptyRangesVisible() {
        return nativeGetEmptyRangesVivsible(getNativeAxis());
    }

    public LabelFormatAutoReplaceOptions getLabelFormatAutoReplaceOptions() {
        return this.labelFormatAutoReplaceOptions;
    }

    public void setLabelFormatAutoReplaceOptions(LabelFormatAutoReplaceOptions labelFormatAutoReplaceOptions) {
        LabelFormatAutoReplaceOptions labelFormatAutoReplaceOptions2 = this.labelFormatAutoReplaceOptions;
        if (labelFormatAutoReplaceOptions2 != labelFormatAutoReplaceOptions) {
            if (labelFormatAutoReplaceOptions2 != null) {
                labelFormatAutoReplaceOptions2.removeListener(getSelfListener());
            }
            this.labelFormatAutoReplaceOptions = labelFormatAutoReplaceOptions;
            if (labelFormatAutoReplaceOptions != null) {
                labelFormatAutoReplaceOptions.addListener(getSelfListener());
                nativeSetLabelFormatAutoReplaceEnabled(getNativeAxis(), this.labelFormatAutoReplaceOptions.isEnabled());
                setLabelFormatsToNative(labelFormatAutoReplaceOptions.getLabelFormatMap());
            } else {
                nativeSetLabelFormatAutoReplaceEnabled(getNativeAxis(), false);
                setLabelFormatsToNative(new TreeMap());
            }
        }
    }
}
