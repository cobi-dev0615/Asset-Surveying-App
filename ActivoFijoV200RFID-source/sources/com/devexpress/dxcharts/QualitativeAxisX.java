package com.devexpress.dxcharts;

import com.devexpress.dxcharts.ConstantLineBase;
import com.devexpress.dxcharts.RangeBase;
import com.devexpress.dxcharts.StripBase;

/* loaded from: classes.dex */
public class QualitativeAxisX extends AxisX {
    @Override // com.devexpress.dxcharts.AxisBase
    native void nativeAddConstantLine(long j);

    @Override // com.devexpress.dxcharts.AxisBase
    native void nativeAddStrip(long j);

    native String[] nativeGetQualitativeVisualRange(long j);

    native String[] nativeGetQualitativeWholeRange(long j);

    native void nativeSetQualitativeConstantLineAxisValue(long j, int i, String str);

    native void nativeSetQualitativeStripMaxLimit(long j, int i, String str);

    native void nativeSetQualitativeStripMinLimit(long j, int i, String str);

    native void nativeSetQualitativeVisualRange(long j, String[] strArr, boolean[] zArr);

    native void nativeSetQualitativeWholeRange(long j, String[] strArr, boolean[] zArr);

    @Override // com.devexpress.dxcharts.AxisBase
    long createNativeAxis(IAxisLabelTextProvider iAxisLabelTextProvider) {
        return nativeCreateQualitativeAxis(iAxisLabelTextProvider);
    }

    @Override // com.devexpress.dxcharts.AxisBase
    IAxisLabelTextProvider createLabelTextProvider() {
        return new QualitativeAxisLabelTextProvider(this);
    }

    @Override // com.devexpress.dxcharts.AxisBase
    RangeBase createAxisRange() {
        return new QualitativeRange();
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void onRangeChanged(RangeBase rangeBase, RangeBase.Property property) {
        QualitativeRange qualitativeRange = (QualitativeRange) rangeBase;
        int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$RangeBase$Property[property.ordinal()];
        if (i == 1) {
            synchronized (ChartBase.syncObject) {
                nativeSetQualitativeWholeRange(getNativeAxis(), calculateQualitativeRange(qualitativeRange.getMin(), qualitativeRange.getMax(), qualitativeRange.isDefaultWholeMin(), qualitativeRange.isDefaultWholeMax()), new boolean[]{qualitativeRange.isDefaultWholeMin(), qualitativeRange.isDefaultWholeMax()});
            }
            return;
        }
        if (i == 2) {
            synchronized (ChartBase.syncObject) {
                nativeSetQualitativeVisualRange(getNativeAxis(), calculateQualitativeRange(qualitativeRange.getVisualMin(), qualitativeRange.getVisualMax(), qualitativeRange.isDefaultVisualMin(), qualitativeRange.isDefaultVisualMax()), new boolean[]{qualitativeRange.isDefaultVisualMin(), qualitativeRange.isDefaultVisualMax()});
            }
            return;
        }
        if (i != 3) {
            return;
        }
        synchronized (ChartBase.syncObject) {
            nativeSetSideMargin(getNativeAxis(), qualitativeRange.getSideMargin());
        }
    }

    private String[] calculateQualitativeRange(String str, String str2, boolean z, boolean z2) {
        String[] strArr = new String[2];
        if (z && z2) {
            strArr[1] = "";
            strArr[0] = "";
        } else if (!z && !z2) {
            strArr[0] = str;
            strArr[1] = str2;
        } else if (!z) {
            strArr[1] = str;
            strArr[0] = str;
        } else if (!z2) {
            strArr[1] = str2;
            strArr[0] = str2;
        }
        return strArr;
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void applyStripChanging(StripBase stripBase, int i, Enum<?> r6) {
        super.applyStripChanging(stripBase, i, r6);
        synchronized (ChartBase.syncObject) {
            if (r6 instanceof StripBase.Property) {
                QualitativeStrip qualitativeStrip = (QualitativeStrip) stripBase;
                int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StripBase$Property[((StripBase.Property) r6).ordinal()];
                if (i2 == 1) {
                    if (qualitativeStrip.getMinLimit() != null) {
                        nativeSetQualitativeStripMinLimit(getNativeAxis(), i, qualitativeStrip.getMinLimit());
                    }
                } else if (i2 == 2 && qualitativeStrip.getMaxLimit() != null) {
                    nativeSetQualitativeStripMaxLimit(getNativeAxis(), i, qualitativeStrip.getMaxLimit());
                }
            }
        }
    }

    @Override // com.devexpress.dxcharts.AxisBase
    void applyConstantLineChanging(ConstantLineBase constantLineBase, int i, Enum<?> r6) {
        super.applyConstantLineChanging(constantLineBase, i, r6);
        synchronized (ChartBase.syncObject) {
            if (r6 instanceof ConstantLineBase.Property) {
                QualitativeConstantLine qualitativeConstantLine = (QualitativeConstantLine) constantLineBase;
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property[((ConstantLineBase.Property) r6).ordinal()] == 1 && qualitativeConstantLine.getAxisValue() != null) {
                    nativeSetQualitativeConstantLineAxisValue(getNativeAxis(), i, qualitativeConstantLine.getAxisValue());
                }
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.QualitativeAxisX$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$RangeBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StripBase$Property;

        static {
            int[] iArr = new int[ConstantLineBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property = iArr;
            try {
                iArr[ConstantLineBase.Property.AXIS_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[StripBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$StripBase$Property = iArr2;
            try {
                iArr2[StripBase.Property.MIN_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StripBase$Property[StripBase.Property.MAX_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[RangeBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$RangeBase$Property = iArr3;
            try {
                iArr3[RangeBase.Property.WHOLE_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RangeBase$Property[RangeBase.Property.VISUAL_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$RangeBase$Property[RangeBase.Property.SIDE_MARGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public QualitativeRange getRange() {
        return (QualitativeRange) getRangeInternal();
    }

    public void setRange(QualitativeRange qualitativeRange) {
        setRangeInternal(qualitativeRange);
    }

    public void addStrip(QualitativeStrip qualitativeStrip) {
        addStripInternal(qualitativeStrip);
    }

    public void removeStrip(QualitativeStrip qualitativeStrip) {
        removeStripInternal(qualitativeStrip);
    }

    public void addConstantLine(QualitativeConstantLine qualitativeConstantLine) {
        addConstantLineInternal(qualitativeConstantLine);
    }

    public void removeConstantLine(QualitativeConstantLine qualitativeConstantLine) {
        removeConstantLineInternal(qualitativeConstantLine);
    }
}
