package com.devexpress.dxcharts;

import androidx.camera.video.AudioStats;
import com.devexpress.dxcharts.AxisHintOptions;
import com.devexpress.dxcharts.AxisLabel;
import com.devexpress.dxcharts.AxisLabelBase;
import com.devexpress.dxcharts.AxisLabelResolveOverlappingOptions;
import com.devexpress.dxcharts.AxisLayout;
import com.devexpress.dxcharts.AxisStyle;
import com.devexpress.dxcharts.AxisTitle;
import com.devexpress.dxcharts.ConstantLineBase;
import com.devexpress.dxcharts.ConstantLineStyle;
import com.devexpress.dxcharts.ConstantLineTitle;
import com.devexpress.dxcharts.RangeBase;
import com.devexpress.dxcharts.StripAxisLabel;
import com.devexpress.dxcharts.StripBase;
import com.devexpress.dxcharts.StripStyle;
import com.devexpress.dxcharts.TitleBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AxisBase extends StyledElement {
    private AxisDisplayPositionBase displayPosition;
    private AxisLabel mAxisLabel;
    private NativeObjectWrapper mAxisNative;
    private List<ConstantLineBase> mConstantLines;
    private AxisHintOptions mHintOptions;
    private IAxisLabelTextProvider mLabelTextProvider;
    private AxisLayout mLayout;
    private RangeBase mRange;
    private List<StripBase> mStrips;
    private ChartSynchronizer mSynchronizer;
    private AxisLabelTextFormatter mTextFormatter;
    private AxisTitle mTitle;
    private boolean primary;
    private Object syncObject = this;

    private enum Property {
        FORMATTER
    }

    abstract RangeBase createAxisRange();

    abstract IAxisLabelTextProvider createLabelTextProvider();

    abstract long createNativeAxis(IAxisLabelTextProvider iAxisLabelTextProvider);

    native void nativeAddConstantLine(long j);

    native void nativeAddStrip(long j);

    native long nativeCreateDateTimeAxis(IAxisLabelTextProvider iAxisLabelTextProvider);

    native long nativeCreateNumericAxis(boolean z, IAxisLabelTextProvider iAxisLabelTextProvider);

    native long nativeCreateQualitativeAxis(IAxisLabelTextProvider iAxisLabelTextProvider);

    native double nativeGetGridOffset(long j);

    native int nativeGetPosition(long j);

    native boolean nativeGetVisible(long j);

    native double[] nativeGetVisualRange(long j);

    native double[] nativeGetWholeRange(long j);

    native void nativeRemoveAllConstantLines(long j);

    native void nativeRemoveAllStrips(long j);

    native void nativeRemoveConstantLine(long j, int i);

    native void nativeRemoveStrip(long j, int i);

    native void nativeSetAbsolutePosition(long j, double d);

    native void nativeSetConstantLineAxisValue(long j, int i, double d);

    native void nativeSetConstantLineColor(long j, int i, int i2);

    native void nativeSetConstantLineLegendText(long j, int i, String str);

    native void nativeSetConstantLineMask(long j, int i, float[] fArr);

    native void nativeSetConstantLineShowBehind(long j, int i, boolean z);

    native void nativeSetConstantLineShowTitleBelowLine(long j, int i, boolean z);

    native void nativeSetConstantLineThickness(long j, int i, float f);

    native void nativeSetConstantLineTitleAlignment(long j, int i, int i2);

    native void nativeSetConstantLineTitleText(long j, int i, String str);

    native void nativeSetConstantLineTitleVisible(long j, int i, boolean z);

    native void nativeSetConstantLineVisible(long j, int i, boolean z);

    native void nativeSetConstantLineVisibleInLegend(long j, int i, boolean z);

    native void nativeSetEdges(long j, double d, double d2);

    native void nativeSetGridOffset(long j, double d);

    native void nativeSetHintLabelVisible(long j, boolean z);

    native void nativeSetHintLineVisible(long j, boolean z);

    native void nativeSetInterlacedColor(long j, int i);

    native void nativeSetLabelPosition(long j, int i);

    native void nativeSetLabelResolveOverlappigAllowHide(long j, boolean z);

    native void nativeSetLabelResolveOverlappigStagger(long j, boolean z);

    native void nativeSetLabelRotationAngle(long j, double d);

    native void nativeSetLabelTextFormat(long j, String str);

    native void nativeSetLabelVisible(long j, boolean z);

    native void nativeSetLineColor(long j, int i);

    native void nativeSetLineThickness(long j, float f);

    native void nativeSetMajorGridlinesColor(long j, int i);

    native void nativeSetMajorGridlinesMask(long j, float[] fArr);

    native void nativeSetMajorGridlinesThickness(long j, float f);

    native void nativeSetMajorTickmarkLength(long j, float f);

    native void nativeSetMajorTickmarkMask(long j, float[] fArr);

    native void nativeSetMajorTickmarkThickness(long j, float f);

    native void nativeSetMinorGridlinesColor(long j, int i);

    native void nativeSetMinorGridlinesMask(long j, float[] fArr);

    native void nativeSetMinorGridlinesThickness(long j, float f);

    native void nativeSetMinorTickmarkLength(long j, float f);

    native void nativeSetMinorTickmarkMask(long j, float[] fArr);

    native void nativeSetMinorTickmarkThickness(long j, float f);

    native void nativeSetPosition(long j, int i);

    native void nativeSetRelativePosition(long j, double d, double d2, String str, long j2);

    native void nativeSetShowInterlaced(long j, boolean z);

    native void nativeSetShowLine(long j, boolean z);

    native void nativeSetShowMajorGridlines(long j, boolean z);

    native void nativeSetShowMajorTickmarks(long j, boolean z);

    native void nativeSetShowMinorGridlines(long j, boolean z);

    native void nativeSetShowMinorTickmarks(long j, boolean z);

    native void nativeSetSideMargin(long j, double d);

    native void nativeSetStripAxisLabelText(long j, int i, String str);

    native void nativeSetStripAxisLabelVisible(long j, int i, boolean z);

    native void nativeSetStripColor(long j, int i, int i2);

    native void nativeSetStripLegendText(long j, int i, String str);

    native void nativeSetStripMaxLimit(long j, int i, double d);

    native void nativeSetStripMaxLimitEnabled(long j, int i, boolean z);

    native void nativeSetStripMinLimit(long j, int i, double d);

    native void nativeSetStripMinLimitEnabled(long j, int i, boolean z);

    native void nativeSetStripVisible(long j, int i, boolean z);

    native void nativeSetStripVisibleInLegend(long j, int i, boolean z);

    native void nativeSetSynchronizer(long j, long j2);

    native void nativeSetTitleAlignment(long j, int i);

    native void nativeSetTitleText(long j, String str);

    native void nativeSetTitleVisible(long j, boolean z);

    native void nativeSetVisible(long j, boolean z);

    native void nativeSetVisualRange(long j, double[] dArr, boolean[] zArr);

    native void nativeSetWholeRange(long j, double[] dArr, boolean[] zArr);

    abstract void onRangeChanged(RangeBase rangeBase, RangeBase.Property property);

    AxisBase() {
        IAxisLabelTextProvider createLabelTextProvider = createLabelTextProvider();
        this.mLabelTextProvider = createLabelTextProvider;
        this.mAxisNative = new NativeObjectWrapper(createNativeAxis(createLabelTextProvider));
        this.mStrips = new ArrayList();
        this.mConstantLines = new ArrayList();
        this.primary = false;
        this.displayPosition = null;
    }

    long getNativeAxis() {
        return this.mAxisNative.getObject();
    }

    boolean compareNativeAxes(long j) {
        return this.mAxisNative.compare(j);
    }

    RangeBase getRangeInternal() {
        return this.mRange;
    }

    void setRangeInternal(RangeBase rangeBase) {
        RangeBase rangeBase2 = this.mRange;
        if (rangeBase2 != rangeBase) {
            if (rangeBase2 != null) {
                rangeBase2.removeListener(getSelfListener());
            }
            this.mRange = rangeBase;
            boolean z = rangeBase == null;
            if (z) {
                this.mRange = createAxisRange();
            }
            this.mRange.addListener(getSelfListener());
            onRangeChanged(this.mRange, RangeBase.Property.WHOLE_RANGE);
            onRangeChanged(this.mRange, RangeBase.Property.VISUAL_RANGE);
            onRangeChanged(this.mRange, RangeBase.Property.SIDE_MARGIN);
            if (z) {
                this.mRange.removeListener(getSelfListener());
                this.mRange = null;
            }
        }
    }

    private void applyLabelChanging(Enum<?> r7) {
        synchronized (ChartBase.syncObject) {
            if (r7 instanceof AxisLabelBase.Property) {
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisLabelBase$Property[((AxisLabelBase.Property) r7).ordinal()] == 1) {
                    nativeSetLabelVisible(getNativeAxis(), getLabel() != null ? getLabel().isVisible() : true);
                }
            } else if (r7 instanceof AxisLabel.Property) {
                int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisLabel$Property[((AxisLabel.Property) r7).ordinal()];
                if (i == 1) {
                    nativeSetLabelTextFormat(getNativeAxis(), getLabel() != null ? getLabel().getTextFormat() : AxisLabel.DEFAULT_FORMAT);
                } else if (i == 2) {
                    nativeSetLabelPosition(getNativeAxis(), (getLabel() != null ? getLabel().getPosition() : AxisLabel.DEFAULT_POSITION).ordinal());
                } else if (i == 3) {
                    long nativeAxis = getNativeAxis();
                    if (getLabel() == null || !getLabel().isStaggered()) {
                        r2 = false;
                    }
                    nativeSetLabelResolveOverlappigStagger(nativeAxis, r2);
                } else if (i == 4) {
                    nativeSetLabelRotationAngle(getNativeAxis(), getLabel() != null ? getLabel().getAngle() : AudioStats.AUDIO_AMPLITUDE_NONE);
                }
            } else if ((r7 instanceof AxisLabelResolveOverlappingOptions.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisLabelResolveOverlappingOptions$Property[((AxisLabelResolveOverlappingOptions.Property) r7).ordinal()] == 1) {
                long nativeAxis2 = getNativeAxis();
                if (getLabel().getResolveOverlappingOptions() == null || !getLabel().getResolveOverlappingOptions().isAllowHide()) {
                    r2 = false;
                }
                nativeSetLabelResolveOverlappigAllowHide(nativeAxis2, r2);
            }
        }
    }

    private void applyTitleChanging(Enum<?> r6) {
        synchronized (ChartBase.syncObject) {
            if (r6 instanceof TitleBase.Property) {
                int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$TitleBase$Property[((TitleBase.Property) r6).ordinal()];
                if (i == 1) {
                    nativeSetTitleText(getNativeAxis(), getTitle() != null ? getTitle().getText() : AxisTitle.DEFAULT_TEXT);
                } else if (i == 2) {
                    nativeSetTitleVisible(getNativeAxis(), getTitle() != null ? getTitle().isVisible() : true);
                }
            } else if ((r6 instanceof AxisTitle.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisTitle$Property[((AxisTitle.Property) r6).ordinal()] == 1) {
                nativeSetTitleAlignment(getNativeAxis(), (getTitle() != null ? getTitle().getAlignment() : AxisTitle.DEFAULT_ALIGNMENT).ordinal());
            }
        }
    }

    void applyStripChanging(StripBase stripBase, int i, Enum<?> r7) {
        synchronized (ChartBase.syncObject) {
            if (r7 instanceof StripBase.Property) {
                int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StripBase$Property[((StripBase.Property) r7).ordinal()];
                if (i2 == 1) {
                    nativeSetStripVisible(getNativeAxis(), i, stripBase.isVisible());
                } else if (i2 == 2) {
                    nativeSetStripMinLimitEnabled(getNativeAxis(), i, stripBase.isMinLimitEnabled());
                } else if (i2 == 3) {
                    nativeSetStripMaxLimitEnabled(getNativeAxis(), i, stripBase.isMaxLimitEnabled());
                } else if (i2 == 4) {
                    nativeSetStripLegendText(getNativeAxis(), i, stripBase.getLegendText());
                } else if (i2 == 5) {
                    nativeSetStripVisibleInLegend(getNativeAxis(), i, stripBase.isVisibleInLegend());
                }
            } else if (r7 instanceof AxisLabelBase.Property) {
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisLabelBase$Property[((AxisLabelBase.Property) r7).ordinal()] == 1) {
                    nativeSetStripAxisLabelVisible(getNativeAxis(), i, stripBase.getAxisLabel() != null ? stripBase.getAxisLabel().isVisible() : StripAxisLabel.DEFAULT_VISIBILITY);
                }
            } else if (r7 instanceof StripAxisLabel.Property) {
                if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StripAxisLabel$Property[((StripAxisLabel.Property) r7).ordinal()] == 1) {
                    nativeSetStripAxisLabelText(getNativeAxis(), i, stripBase.getAxisLabel() != null ? stripBase.getAxisLabel().getText() : StripAxisLabel.DEFAULT_TEXT);
                }
            } else if ((r7 instanceof StripStyle.Property) && AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$StripStyle$Property[((StripStyle.Property) r7).ordinal()] == 1 && getContext() != null) {
                StripStyle actualStyle = stripBase.getActualStyle(getContext(), Boolean.valueOf(this instanceof AxisX));
                StripStyle defaultStyle = stripBase.getDefaultStyle();
                long nativeAxis = getNativeAxis();
                if (actualStyle.getFill() == null) {
                    actualStyle = defaultStyle;
                }
                nativeSetStripColor(nativeAxis, i, ColorHelper.convertToNativeColor(actualStyle.getFill()));
            }
        }
    }

    void applyConstantLineChanging(ConstantLineBase constantLineBase, int i, Enum<?> r11) {
        synchronized (ChartBase.syncObject) {
            if (r11 instanceof ConstantLineBase.Property) {
                int i2 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property[((ConstantLineBase.Property) r11).ordinal()];
                if (i2 == 1) {
                    nativeSetConstantLineVisible(getNativeAxis(), i, constantLineBase.isVisible());
                } else if (i2 == 2) {
                    nativeSetConstantLineLegendText(getNativeAxis(), i, constantLineBase.getLegendText());
                } else if (i2 == 3) {
                    nativeSetConstantLineVisibleInLegend(getNativeAxis(), i, constantLineBase.isVisibleInLegend());
                } else if (i2 == 4) {
                    nativeSetConstantLineShowBehind(getNativeAxis(), i, constantLineBase.isShowBehind());
                }
            } else if (r11 instanceof TitleBase.Property) {
                int i3 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$TitleBase$Property[((TitleBase.Property) r11).ordinal()];
                if (i3 == 1) {
                    nativeSetConstantLineTitleText(getNativeAxis(), i, constantLineBase.getTitle() != null ? constantLineBase.getTitle().getText() : ConstantLineTitle.DEFAULT_TEXT);
                } else if (i3 == 2) {
                    nativeSetConstantLineTitleVisible(getNativeAxis(), i, constantLineBase.getTitle() != null ? constantLineBase.getTitle().isVisible() : true);
                }
            } else if (r11 instanceof ConstantLineTitle.Property) {
                int i4 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ConstantLineTitle$Property[((ConstantLineTitle.Property) r11).ordinal()];
                if (i4 == 1) {
                    nativeSetConstantLineShowTitleBelowLine(getNativeAxis(), i, constantLineBase.getTitle() != null ? constantLineBase.getTitle().isShowBelowLine() : ConstantLineTitle.DEFAULT_SHOW_BELOW_LINE);
                } else if (i4 == 2) {
                    nativeSetConstantLineTitleAlignment(getNativeAxis(), i, (constantLineBase.getTitle() != null ? constantLineBase.getTitle().getAlignment() : ConstantLineTitle.DEFAULT_ALIGNMENT).ordinal());
                }
            } else if (r11 instanceof ConstantLineStyle.Property) {
                ConstantLineStyle actualStyle = constantLineBase.getActualStyle(getContext(), Boolean.valueOf(this instanceof AxisX));
                ConstantLineStyle defaultStyle = constantLineBase.getDefaultStyle();
                int i5 = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$ConstantLineStyle$Property[((ConstantLineStyle.Property) r11).ordinal()];
                if (i5 == 1) {
                    long nativeAxis = getNativeAxis();
                    if (actualStyle.getStroke() == null) {
                        actualStyle = defaultStyle;
                    }
                    nativeSetConstantLineColor(nativeAxis, i, ColorHelper.convertToNativeColor(actualStyle.getStroke()));
                } else if (i5 == 2) {
                    long nativeAxis2 = getNativeAxis();
                    if (actualStyle.getThickness() == null) {
                        actualStyle = defaultStyle;
                    }
                    nativeSetConstantLineThickness(nativeAxis2, i, actualStyle.getThickness().floatValue());
                } else if (i5 == 3) {
                    nativeSetConstantLineMask(getNativeAxis(), i, actualStyle.getDashes() == null ? new float[0] : actualStyle.getDashes());
                }
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(AxisStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<StyledElement> getInnerStyledElements(ContextProvider contextProvider) {
        List<StyledElement> innerStyledElements = super.getInnerStyledElements(contextProvider);
        innerStyledElements.add(this.mAxisLabel);
        innerStyledElements.add(this.mTitle);
        innerStyledElements.addAll(this.mStrips);
        innerStyledElements.addAll(this.mConstantLines);
        return innerStyledElements;
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<Enum<?>> getListenPropertiesNames() {
        List<Enum<?>> listenPropertiesNames = super.getListenPropertiesNames();
        Collections.addAll(listenPropertiesNames, AxisStyle.Property.values());
        return listenPropertiesNames;
    }

    @Override // com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof RangeBase) {
            onRangeChanged(this.mRange, (RangeBase.Property) propertyChangedArgs.getProperty());
            return;
        }
        if (obj instanceof AxisLabel) {
            applyLabelChanging(propertyChangedArgs.getProperty());
            return;
        }
        if (obj instanceof AxisTitle) {
            applyTitleChanging(propertyChangedArgs.getProperty());
            return;
        }
        if (obj instanceof StripBase) {
            applyStripChanging((StripBase) obj, this.mStrips.indexOf(obj), propertyChangedArgs.getProperty());
            return;
        }
        if (obj instanceof ConstantLineBase) {
            applyConstantLineChanging((ConstantLineBase) obj, this.mConstantLines.indexOf(obj), propertyChangedArgs.getProperty());
            return;
        }
        if (obj instanceof AxisHintOptions) {
            applyHintOptionsChanges((AxisHintOptions.Property) propertyChangedArgs.getProperty());
            return;
        }
        if (obj instanceof AxisLayout) {
            applyLayoutChanges((AxisLayout.Property) propertyChangedArgs.getProperty());
            return;
        }
        if (obj instanceof AxisLabelResolveOverlappingOptions) {
            applyLabelChanging((AxisLabelResolveOverlappingOptions.Property) propertyChangedArgs.getProperty());
        } else if (obj instanceof AxisLabelStyle) {
            notifyListeners(obj, propertyChangedArgs);
        } else {
            super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    void applyStyleAttribute(ContextProvider contextProvider, StyleContainer styleContainer, Enum<?> r7) {
        super.applyStyleAttribute(contextProvider, styleContainer, r7);
        AxisStyle axisStyle = (AxisStyle) styleContainer.getActualStyle(contextProvider, Boolean.valueOf(this instanceof AxisX), Boolean.valueOf(isPrimary()));
        AxisStyle axisStyle2 = (AxisStyle) styleContainer.getDefaultStyle();
        synchronized (ChartBase.syncObject) {
            if (r7 instanceof AxisStyle.Property) {
                switch (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[((AxisStyle.Property) r7).ordinal()]) {
                    case 1:
                        long nativeAxis = getNativeAxis();
                        if (axisStyle.isLineVisible() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetShowLine(nativeAxis, axisStyle.isLineVisible().booleanValue());
                        break;
                    case 2:
                        long nativeAxis2 = getNativeAxis();
                        if (axisStyle.getLineColor() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetLineColor(nativeAxis2, ColorHelper.convertToNativeColor(axisStyle.getLineColor()));
                        break;
                    case 3:
                        long nativeAxis3 = getNativeAxis();
                        if (axisStyle.getLineThickness() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetLineThickness(nativeAxis3, axisStyle.getLineThickness().floatValue());
                        break;
                    case 4:
                        long nativeAxis4 = getNativeAxis();
                        if (axisStyle.isMajorGridlinesVisible() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetShowMajorGridlines(nativeAxis4, axisStyle.isMajorGridlinesVisible().booleanValue());
                        break;
                    case 5:
                        long nativeAxis5 = getNativeAxis();
                        if (axisStyle.getMajorGridlinesThickness() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMajorGridlinesThickness(nativeAxis5, axisStyle.getMajorGridlinesThickness().floatValue());
                        break;
                    case 6:
                        long nativeAxis6 = getNativeAxis();
                        if (axisStyle.getMajorGridlinesColor() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMajorGridlinesColor(nativeAxis6, ColorHelper.convertToNativeColor(axisStyle.getMajorGridlinesColor()));
                        break;
                    case 7:
                        long nativeAxis7 = getNativeAxis();
                        if (axisStyle.getMajorGridlineDashes() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMajorGridlinesMask(nativeAxis7, axisStyle.getMajorGridlineDashes());
                        break;
                    case 8:
                        long nativeAxis8 = getNativeAxis();
                        if (axisStyle.isMinorGridlinesVisible() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetShowMinorGridlines(nativeAxis8, axisStyle.isMinorGridlinesVisible().booleanValue());
                        break;
                    case 9:
                        long nativeAxis9 = getNativeAxis();
                        if (axisStyle.getMinorGridlinesThickness() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMinorGridlinesThickness(nativeAxis9, axisStyle.getMinorGridlinesThickness().floatValue());
                        break;
                    case 10:
                        long nativeAxis10 = getNativeAxis();
                        if (axisStyle.getMinorGridlinesColor() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMinorGridlinesColor(nativeAxis10, ColorHelper.convertToNativeColor(axisStyle.getMinorGridlinesColor()));
                        break;
                    case 11:
                        long nativeAxis11 = getNativeAxis();
                        if (axisStyle.getMinorGridlineDashes() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMinorGridlinesMask(nativeAxis11, axisStyle.getMinorGridlineDashes());
                        break;
                    case 12:
                        long nativeAxis12 = getNativeAxis();
                        if (axisStyle.isMajorTickmarksVisible() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetShowMajorTickmarks(nativeAxis12, axisStyle.isMajorTickmarksVisible().booleanValue());
                        break;
                    case 13:
                        long nativeAxis13 = getNativeAxis();
                        if (axisStyle.getMajorTickmarksLength() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMajorTickmarkLength(nativeAxis13, axisStyle.getMajorTickmarksLength().floatValue());
                        break;
                    case 14:
                        long nativeAxis14 = getNativeAxis();
                        if (axisStyle.getMajorTickmarksThickness() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMajorTickmarkThickness(nativeAxis14, axisStyle.getMajorTickmarksThickness().floatValue());
                        break;
                    case 15:
                        long nativeAxis15 = getNativeAxis();
                        if (axisStyle.getMajorTickmarkDashes() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMajorTickmarkMask(nativeAxis15, axisStyle.getMajorTickmarkDashes());
                        break;
                    case 16:
                        long nativeAxis16 = getNativeAxis();
                        if (axisStyle.isMinorTickmarksVisible() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetShowMinorTickmarks(nativeAxis16, axisStyle.isMinorTickmarksVisible().booleanValue());
                        break;
                    case 17:
                        long nativeAxis17 = getNativeAxis();
                        if (axisStyle.getMinorTickmarksLength() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMinorTickmarkLength(nativeAxis17, axisStyle.getMinorTickmarksLength().floatValue());
                        break;
                    case 18:
                        long nativeAxis18 = getNativeAxis();
                        if (axisStyle.getMinorTickmarksThickness() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMinorTickmarkThickness(nativeAxis18, axisStyle.getMinorTickmarksThickness().floatValue());
                        break;
                    case 19:
                        long nativeAxis19 = getNativeAxis();
                        if (axisStyle.getMinorTickmarkDashes() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetMinorTickmarkMask(nativeAxis19, axisStyle.getMinorTickmarkDashes());
                        break;
                    case 20:
                        long nativeAxis20 = getNativeAxis();
                        if (axisStyle.isInterlacedVisible() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetShowInterlaced(nativeAxis20, axisStyle.isInterlacedVisible().booleanValue());
                        break;
                    case 21:
                        long nativeAxis21 = getNativeAxis();
                        if (axisStyle.getInterlacedColor() == null) {
                            axisStyle = axisStyle2;
                        }
                        nativeSetInterlacedColor(nativeAxis21, ColorHelper.convertToNativeColor(axisStyle.getInterlacedColor()));
                        break;
                }
            }
        }
    }

    public boolean isPrimary() {
        return this.primary;
    }

    public void setPrimary(boolean z) {
        if (this.primary != z) {
            this.primary = z;
        }
    }

    protected double[] calculateRange(double d, double d2, boolean z, boolean z2) {
        double[] dArr = new double[2];
        if (z && z2) {
            dArr[1] = 0.0d;
            dArr[0] = 0.0d;
        } else if (!z && !z2) {
            dArr[0] = d;
            dArr[1] = d2;
        } else if (!z) {
            dArr[1] = d;
            dArr[0] = d;
        } else if (!z2) {
            dArr[1] = d2;
            dArr[0] = d2;
        }
        return dArr;
    }

    void setSyncObject(Object obj) {
        if (obj == null) {
            obj = this;
        }
        this.syncObject = obj;
    }

    protected Object getSyncObject() {
        return this.syncObject;
    }

    void addStripInternal(StripBase stripBase) {
        if (stripBase == null || this.mStrips.contains(stripBase)) {
            return;
        }
        this.mStrips.add(stripBase);
        synchronized (ChartBase.syncObject) {
            nativeAddStrip(getNativeAxis());
        }
        stripBase.addListener(getSelfListener());
        stripBase.applyCurrentTheme(true, getContext(), new Object[0]);
        for (AxisLabelBase.Property property : AxisLabelBase.Property.values()) {
            applyStripChanging(stripBase, this.mStrips.size() - 1, property);
        }
        for (AxisLabel.Property property2 : AxisLabel.Property.values()) {
            applyStripChanging(stripBase, this.mStrips.size() - 1, property2);
        }
        for (StripAxisLabel.Property property3 : StripAxisLabel.Property.values()) {
            applyStripChanging(stripBase, this.mStrips.size() - 1, property3);
        }
        for (StripBase.Property property4 : StripBase.Property.values()) {
            applyStripChanging(stripBase, this.mStrips.size() - 1, property4);
        }
    }

    void removeStripInternal(StripBase stripBase) {
        if (stripBase != null) {
            removeStripInternal(this.mStrips.indexOf(stripBase));
        }
    }

    private void removeStripInternal(int i) {
        if (i < 0 || i >= this.mStrips.size()) {
            return;
        }
        this.mStrips.get(i).removeListener(getSelfListener());
        this.mStrips.remove(i);
        synchronized (ChartBase.syncObject) {
            nativeRemoveStrip(getNativeAxis(), i);
        }
    }

    void addConstantLineInternal(ConstantLineBase constantLineBase) {
        if (constantLineBase == null || this.mConstantLines.contains(constantLineBase)) {
            return;
        }
        this.mConstantLines.add(constantLineBase);
        synchronized (ChartBase.syncObject) {
            nativeAddConstantLine(getNativeAxis());
        }
        constantLineBase.addListener(getSelfListener());
        constantLineBase.applyCurrentTheme(true, getContext(), new Object[0]);
        for (TitleBase.Property property : TitleBase.Property.values()) {
            applyConstantLineChanging(constantLineBase, this.mConstantLines.size() - 1, property);
        }
        for (ConstantLineTitle.Property property2 : ConstantLineTitle.Property.values()) {
            applyConstantLineChanging(constantLineBase, this.mConstantLines.size() - 1, property2);
        }
        for (ConstantLineBase.Property property3 : ConstantLineBase.Property.values()) {
            applyConstantLineChanging(constantLineBase, this.mConstantLines.size() - 1, property3);
        }
    }

    void removeConstantLineInternal(ConstantLineBase constantLineBase) {
        if (constantLineBase != null) {
            removeConstantLineInternal(this.mConstantLines.indexOf(constantLineBase));
        }
    }

    private void removeConstantLineInternal(int i) {
        if (i < 0 || i >= this.mConstantLines.size()) {
            return;
        }
        this.mConstantLines.get(i).removeListener(getSelfListener());
        synchronized (ChartBase.syncObject) {
            this.mConstantLines.remove(i);
            nativeRemoveConstantLine(getNativeAxis(), i);
        }
    }

    private void applyHintOptionsChanges(AxisHintOptions.Property property) {
        synchronized (ChartBase.syncObject) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisHintOptions$Property[property.ordinal()];
            if (i == 1) {
                long nativeAxis = getNativeAxis();
                AxisHintOptions axisHintOptions = this.mHintOptions;
                nativeSetHintLabelVisible(nativeAxis, axisHintOptions != null ? axisHintOptions.isLabelVisible() : true);
            } else if (i == 2) {
                long nativeAxis2 = getNativeAxis();
                AxisHintOptions axisHintOptions2 = this.mHintOptions;
                nativeSetHintLineVisible(nativeAxis2, axisHintOptions2 != null ? axisHintOptions2.isLineVisible() : true);
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.AxisBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AxisHintOptions$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AxisLabel$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AxisLabelBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AxisLabelResolveOverlappingOptions$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AxisLayout$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$AxisTitle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ConstantLineStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$ConstantLineTitle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StripAxisLabel$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StripBase$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$StripStyle$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$TitleBase$Property;

        static {
            int[] iArr = new int[AxisLayout.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AxisLayout$Property = iArr;
            try {
                iArr[AxisLayout.Property.ANCHOR_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisLayout$Property[AxisLayout.Property.ANCHOR_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[AxisHintOptions.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AxisHintOptions$Property = iArr2;
            try {
                iArr2[AxisHintOptions.Property.LABEL_VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisHintOptions$Property[AxisHintOptions.Property.LINE_VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[AxisStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property = iArr3;
            try {
                iArr3[AxisStyle.Property.SHOW_LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.THICKNESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.SHOW_MAJOR_GRIDLINES.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MAJOR_GRIDLINES_THICKNESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MAJOR_GRIDLINES_COLOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MAJOR_GRIDLINE_DASHES.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.SHOW_MINOR_GRIDLINES.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MINOR_GRIDLINES_THICKNESS.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MINOR_GRIDLINES_COLOR.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MINOR_GRIDLINE_DASHES.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.SHOW_MAJOR_TICKMARKS.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MAJOR_TICKMARKS_LENGTH.ordinal()] = 13;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MAJOR_TICKMARKS_THICKNESS.ordinal()] = 14;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MAJOR_TICKMARK_DASHES.ordinal()] = 15;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.SHOW_MINOR_TICKMARKS.ordinal()] = 16;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MINOR_TICKMARKS_LENGTH.ordinal()] = 17;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MINOR_TICKMARKS_THICKNESS.ordinal()] = 18;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.MINOR_TICKMARK_DASHES.ordinal()] = 19;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.SHOW_INTERLACED.ordinal()] = 20;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisStyle$Property[AxisStyle.Property.INTERLACED_COLOR.ordinal()] = 21;
            } catch (NoSuchFieldError unused25) {
            }
            int[] iArr4 = new int[ConstantLineStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$ConstantLineStyle$Property = iArr4;
            try {
                iArr4[ConstantLineStyle.Property.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ConstantLineStyle$Property[ConstantLineStyle.Property.THICKNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ConstantLineStyle$Property[ConstantLineStyle.Property.DASHES.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            int[] iArr5 = new int[ConstantLineTitle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$ConstantLineTitle$Property = iArr5;
            try {
                iArr5[ConstantLineTitle.Property.SHOW_BELOW_LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ConstantLineTitle$Property[ConstantLineTitle.Property.ALIGNMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused30) {
            }
            int[] iArr6 = new int[ConstantLineBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property = iArr6;
            try {
                iArr6[ConstantLineBase.Property.VISIBILITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property[ConstantLineBase.Property.LEGEND_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property[ConstantLineBase.Property.VISIBLE_IN_LEGEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$ConstantLineBase$Property[ConstantLineBase.Property.SHOW_BEHIND.ordinal()] = 4;
            } catch (NoSuchFieldError unused34) {
            }
            int[] iArr7 = new int[StripStyle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$StripStyle$Property = iArr7;
            try {
                iArr7[StripStyle.Property.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            int[] iArr8 = new int[StripAxisLabel.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$StripAxisLabel$Property = iArr8;
            try {
                iArr8[StripAxisLabel.Property.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            int[] iArr9 = new int[StripBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$StripBase$Property = iArr9;
            try {
                iArr9[StripBase.Property.VISIBILITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StripBase$Property[StripBase.Property.MIN_LIMIT_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StripBase$Property[StripBase.Property.MAX_LIMIT_ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StripBase$Property[StripBase.Property.LEGEND_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$StripBase$Property[StripBase.Property.VISIBLE_IN_LEGEND.ordinal()] = 5;
            } catch (NoSuchFieldError unused41) {
            }
            int[] iArr10 = new int[AxisTitle.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AxisTitle$Property = iArr10;
            try {
                iArr10[AxisTitle.Property.ALIGNMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            int[] iArr11 = new int[TitleBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$TitleBase$Property = iArr11;
            try {
                iArr11[TitleBase.Property.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$TitleBase$Property[TitleBase.Property.VISIBILITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused44) {
            }
            int[] iArr12 = new int[AxisLabelResolveOverlappingOptions.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AxisLabelResolveOverlappingOptions$Property = iArr12;
            try {
                iArr12[AxisLabelResolveOverlappingOptions.Property.ALLOW_HIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused45) {
            }
            int[] iArr13 = new int[AxisLabel.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AxisLabel$Property = iArr13;
            try {
                iArr13[AxisLabel.Property.FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisLabel$Property[AxisLabel.Property.POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisLabel$Property[AxisLabel.Property.STAGGERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$AxisLabel$Property[AxisLabel.Property.ANGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            int[] iArr14 = new int[AxisLabelBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$AxisLabelBase$Property = iArr14;
            try {
                iArr14[AxisLabelBase.Property.VISIBILITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused50) {
            }
        }
    }

    private void applyLayoutChanges(AxisLayout.Property property) {
        synchronized (ChartBase.syncObject) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$AxisLayout$Property[property.ordinal()];
            if (i == 1 || i == 2) {
                AxisLayout axisLayout = this.mLayout;
                double anchor1 = axisLayout != null ? axisLayout.getAnchor1() : AudioStats.AUDIO_AMPLITUDE_NONE;
                AxisLayout axisLayout2 = this.mLayout;
                nativeSetEdges(getNativeAxis(), anchor1, axisLayout2 != null ? axisLayout2.getAnchor2() : 1.0d);
            }
        }
    }

    public boolean isVisible() {
        return nativeGetVisible(getNativeAxis());
    }

    public void setVisible(boolean z) {
        synchronized (ChartBase.syncObject) {
            nativeSetVisible(getNativeAxis(), z);
        }
    }

    public AxisPosition getPosition() {
        return AxisPosition.values()[nativeGetPosition(getNativeAxis())];
    }

    public AxisDisplayPositionBase getDisplayPosition() {
        return this.displayPosition;
    }

    public void setDisplayPosition(AxisDisplayPositionBase axisDisplayPositionBase) {
        if (axisDisplayPositionBase == this.displayPosition) {
            return;
        }
        this.displayPosition = axisDisplayPositionBase;
        if (axisDisplayPositionBase instanceof AxisDisplayPositionNear) {
            nativeSetPosition(getNativeAxis(), 0);
            return;
        }
        if (axisDisplayPositionBase instanceof AxisDisplayPositionFar) {
            nativeSetPosition(getNativeAxis(), 1);
            return;
        }
        if (axisDisplayPositionBase instanceof AxisDisplayPositionAbsolute) {
            nativeSetAbsolutePosition(getNativeAxis(), ((AxisDisplayPositionAbsolute) axisDisplayPositionBase).getValue());
            return;
        }
        if (axisDisplayPositionBase instanceof AxisDisplayPositionRelative) {
            AxisDisplayPositionRelative axisDisplayPositionRelative = (AxisDisplayPositionRelative) axisDisplayPositionBase;
            double time = axisDisplayPositionRelative.getDateTimePosition() != null ? axisDisplayPositionRelative.getDateTimePosition().getTime() / 1000.0d : AudioStats.AUDIO_AMPLITUDE_NONE;
            if (axisDisplayPositionRelative.getRelativeAxis() != null) {
                nativeSetRelativePosition(getNativeAxis(), axisDisplayPositionRelative.getNumericPosition(), time, axisDisplayPositionRelative.getQualitativePosition(), axisDisplayPositionRelative.getRelativeAxis().getNativeAxis());
            }
        }
    }

    public AxisStyle getStyle() {
        return (AxisStyle) getUserStyleFromContainer(AxisStyle.class);
    }

    public void setStyle(AxisStyle axisStyle) {
        super.trySetStyle(axisStyle);
    }

    public AxisLabel getLabel() {
        return this.mAxisLabel;
    }

    public void setLabel(AxisLabel axisLabel) {
        AxisLabel axisLabel2 = this.mAxisLabel;
        if (axisLabel2 != axisLabel) {
            if (axisLabel2 != null) {
                axisLabel2.removeListener(getSelfListener());
            }
            this.mAxisLabel = axisLabel;
            if (axisLabel != null) {
                axisLabel.applyCurrentTheme(getContext(), new Object[0]);
                this.mAxisLabel.addListener(getSelfListener());
            }
            for (AxisLabelBase.Property property : AxisLabelBase.Property.values()) {
                applyLabelChanging(property);
            }
            for (AxisLabel.Property property2 : AxisLabel.Property.values()) {
                applyLabelChanging(property2);
            }
        }
    }

    public AxisLabelTextFormatter getLabelTextFormatter() {
        return this.mTextFormatter;
    }

    public void setLabelTextFormatter(AxisLabelTextFormatter axisLabelTextFormatter) {
        synchronized (ChartBase.syncObject) {
            if (this.mTextFormatter != axisLabelTextFormatter) {
                this.mTextFormatter = axisLabelTextFormatter;
                notifyListeners(this, Property.FORMATTER);
            }
        }
    }

    public AxisTitle getTitle() {
        return this.mTitle;
    }

    public void setTitle(AxisTitle axisTitle) {
        AxisTitle axisTitle2 = this.mTitle;
        if (axisTitle2 != axisTitle) {
            if (axisTitle2 != null) {
                axisTitle2.removeListener(getSelfListener());
            }
            this.mTitle = axisTitle;
            if (axisTitle != null) {
                axisTitle.applyCurrentTheme(getContext(), new Object[0]);
                this.mTitle.addListener(getSelfListener());
            }
            for (TitleBase.Property property : TitleBase.Property.values()) {
                applyTitleChanging(property);
            }
            for (AxisTitle.Property property2 : AxisTitle.Property.values()) {
                applyTitleChanging(property2);
            }
        }
    }

    public StripBase[] getStrips() {
        return (StripBase[]) Arrays.copyOf(this.mStrips.toArray(), this.mStrips.size(), StripBase[].class);
    }

    public void removeStrip(int i) {
        removeStripInternal(i);
    }

    public void removeAllStrips() {
        this.mStrips.clear();
        nativeRemoveAllStrips(getNativeAxis());
    }

    public ConstantLineBase[] getConstantLines() {
        return (ConstantLineBase[]) Arrays.copyOf(this.mConstantLines.toArray(), this.mConstantLines.size(), ConstantLineBase[].class);
    }

    public void removeConstantLine(int i) {
        removeConstantLineInternal(i);
    }

    public void removeAllConstantLines() {
        synchronized (ChartBase.syncObject) {
            this.mConstantLines.clear();
            nativeRemoveAllConstantLines(getNativeAxis());
        }
    }

    public AxisHintOptions getHintOptions() {
        return this.mHintOptions;
    }

    public void setHintOptions(AxisHintOptions axisHintOptions) {
        AxisHintOptions axisHintOptions2 = this.mHintOptions;
        if (axisHintOptions2 != axisHintOptions) {
            if (axisHintOptions2 != null) {
                axisHintOptions2.removeListener(getSelfListener());
            }
            this.mHintOptions = axisHintOptions;
            if (axisHintOptions != null) {
                axisHintOptions.addListener(getSelfListener());
            }
            for (AxisHintOptions.Property property : AxisHintOptions.Property.values()) {
                applyHintOptionsChanges(property);
            }
        }
    }

    public AxisLayout getLayout() {
        return this.mLayout;
    }

    public void setLayout(AxisLayout axisLayout) {
        AxisLayout axisLayout2 = this.mLayout;
        if (axisLayout2 != axisLayout) {
            if (axisLayout2 != null) {
                axisLayout2.removeListener(getSelfListener());
            }
            this.mLayout = axisLayout;
            if (axisLayout != null) {
                axisLayout.addListener(getSelfListener());
            }
            for (AxisLayout.Property property : AxisLayout.Property.values()) {
                applyLayoutChanges(property);
            }
        }
    }

    public ChartSynchronizer getSynchronizer() {
        return this.mSynchronizer;
    }

    public void setSynchronizer(ChartSynchronizer chartSynchronizer) {
        synchronized (this.syncObject) {
            if (this.mSynchronizer != chartSynchronizer) {
                this.mSynchronizer = chartSynchronizer;
                nativeSetSynchronizer(getNativeAxis(), this.mSynchronizer != null ? chartSynchronizer.getNativeAxisSynchronizer() : 0L);
            }
        }
    }
}
