package com.devexpress.dxcharts;

import android.graphics.Paint;

/* loaded from: classes.dex */
class ChartTextStyleProvider extends TextStyleProvider {
    private static final long INVALID_ID = -1;
    static final long NOT_INITED = -255;
    private static final long Series_InitialID = 100;
    private IAxesContainer axesContainer;

    @Override // com.devexpress.dxcharts.TextStyleProvider
    native long nativeCreateTextStyleProvider();

    ChartTextStyleProvider(IAxesContainer iAxesContainer) {
        this.axesContainer = iAxesContainer;
    }

    long tryGetAxisLabelID(long j, short s) {
        int axisXIDByAxisData = this.axesContainer.getAxisXIDByAxisData(j);
        if (axisXIDByAxisData != -1) {
            return new StyleID(false, (short) axisXIDByAxisData, AxisElemType.ET_Label, s).toLong();
        }
        int axisYIDByAxisData = this.axesContainer.getAxisYIDByAxisData(j);
        if (axisYIDByAxisData != -1) {
            return new StyleID(true, (short) axisYIDByAxisData, AxisElemType.ET_Label, s).toLong();
        }
        return -1L;
    }

    private long tryGetAxisTitleID(long j) {
        int axisXIDByAxisData = this.axesContainer.getAxisXIDByAxisData(j);
        if (axisXIDByAxisData != -1) {
            return new StyleID(false, (short) axisXIDByAxisData, AxisElemType.ET_Title, (short) 0).toLong();
        }
        int axisYIDByAxisData = this.axesContainer.getAxisYIDByAxisData(j);
        if (axisYIDByAxisData != -1) {
            return new StyleID(true, (short) axisYIDByAxisData, AxisElemType.ET_Title, (short) 0).toLong();
        }
        return -1L;
    }

    private long tryGetSeriesID(long j) {
        Chart chart = (Chart) this.axesContainer.getRenderDelegate();
        for (int i = 0; i < chart.getSeries().length; i++) {
            if (chart.getSeries()[i].compareNativeSeries(j)) {
                return i + Series_InitialID;
            }
        }
        return -1L;
    }

    private long tryGetAxisStripID(long j, short s) {
        int axisXIDByAxisData = this.axesContainer.getAxisXIDByAxisData(j);
        if (axisXIDByAxisData != -1) {
            return new StyleID(false, (short) axisXIDByAxisData, AxisElemType.ET_Strip, s).toLong();
        }
        int axisYIDByAxisData = this.axesContainer.getAxisYIDByAxisData(j);
        if (axisYIDByAxisData != -1) {
            return new StyleID(true, (short) axisYIDByAxisData, AxisElemType.ET_Strip, s).toLong();
        }
        return -1L;
    }

    private long tryGetAxisConstantLineID(long j, short s) {
        int axisXIDByAxisData = this.axesContainer.getAxisXIDByAxisData(j);
        if (axisXIDByAxisData != -1) {
            return new StyleID(false, (short) axisXIDByAxisData, AxisElemType.ET_ConstantLine, s).toLong();
        }
        int axisYIDByAxisData = this.axesContainer.getAxisYIDByAxisData(j);
        if (axisYIDByAxisData != -1) {
            return new StyleID(true, (short) axisYIDByAxisData, AxisElemType.ET_ConstantLine, s).toLong();
        }
        return -1L;
    }

    private long tryGetCrosshairAxisLabelStyleID(long j) {
        int axisXIDByAxisData = this.axesContainer.getAxisXIDByAxisData(j);
        if (axisXIDByAxisData != -1) {
            return new StyleID(false, (short) axisXIDByAxisData, AxisElemType.ET_Crosshair, (short) 0).toLong();
        }
        int axisYIDByAxisData = this.axesContainer.getAxisYIDByAxisData(j);
        if (axisYIDByAxisData != -1) {
            return new StyleID(true, (short) axisYIDByAxisData, AxisElemType.ET_Crosshair, (short) 0).toLong();
        }
        return -1L;
    }

    @Override // com.devexpress.dxcharts.TextStyleProviderInterface
    public Paint getTextStylePaint(long j) {
        Paint actualTextStylePaint;
        Chart chart = (Chart) this.axesContainer.getRenderDelegate();
        ContextProvider contextProvider = chart.getContextProvider();
        Paint paint = null;
        if (j >= Series_InitialID) {
            long j2 = j - Series_InitialID;
            if (j2 <= chart.getSeries().length) {
                SeriesLabel label = chart.getSeriesAt(j2).getLabel();
                if (label != null && label.getStyleInternal() != null) {
                    paint = label.getStyleInternal().getActualTextStylePaint(contextProvider, new Object[0]);
                }
                return paint != null ? paint : chart.getTextStylePaintInternal();
            }
        }
        if (j == -1) {
            return chart.getTextStylePaintInternal();
        }
        StyleID struct = StyleID.toStruct(j);
        if (struct.elemType == AxisElemType.ET_Label && !struct.isAxisVertical) {
            AxisLabel label2 = this.axesContainer.getAxisXById(struct.axisNumber).getLabel();
            if (struct.elemNumber == 0) {
                if (label2 != null) {
                    paint = label2.getActualStyle(contextProvider, new Object[0]).getActualTextStylePaint(contextProvider, new Object[0]);
                }
            } else if (label2 != null) {
                paint = label2.getActualStyle(contextProvider, new Object[0]).getActualSuperscriptTextStylePaint(contextProvider, new Object[0]);
            }
        } else if (struct.elemType == AxisElemType.ET_Label && struct.isAxisVertical) {
            AxisLabel label3 = this.axesContainer.getAxisYById(struct.axisNumber).getLabel();
            if (struct.elemNumber == 0) {
                if (label3 != null) {
                    paint = label3.getActualStyle(contextProvider, new Object[0]).getActualTextStylePaint(contextProvider, new Object[0]);
                }
            } else if (label3 != null) {
                paint = label3.getActualStyle(contextProvider, new Object[0]).getActualSuperscriptTextStylePaint(contextProvider, new Object[0]);
            }
        } else if (struct.elemType == AxisElemType.ET_Title && !struct.isAxisVertical) {
            AxisTitle title = this.axesContainer.getAxisXById(struct.axisNumber).getTitle();
            if (title != null) {
                actualTextStylePaint = title.getActualStyle(contextProvider, new Object[0]).getActualTextStylePaint(contextProvider, null, Integer.valueOf(R.attr.dxChartAxisXTitleSize));
                paint = actualTextStylePaint;
            }
        } else if (struct.elemType == AxisElemType.ET_Title && struct.isAxisVertical) {
            AxisTitle title2 = this.axesContainer.getAxisYById(struct.axisNumber).getTitle();
            if (title2 != null) {
                actualTextStylePaint = title2.getActualStyle(contextProvider, new Object[0]).getActualTextStylePaint(contextProvider, null, Integer.valueOf(R.attr.dxChartAxisYTitleSize));
                paint = actualTextStylePaint;
            }
        } else if (struct.elemType == AxisElemType.ET_Crosshair && !struct.isAxisVertical) {
            Hint hint = (Hint) chart.getActualHint();
            if (hint != null) {
                actualTextStylePaint = hint.getActualStyle(contextProvider, new Object[0]).getActualArgumentLineStyle(contextProvider).getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartCrosshairArgumentLabelTextColor));
                paint = actualTextStylePaint;
            }
        } else if (struct.elemType == AxisElemType.ET_Crosshair && struct.isAxisVertical) {
            Hint hint2 = (Hint) chart.getActualHint();
            if (hint2 != null) {
                actualTextStylePaint = hint2.getActualStyle(contextProvider, new Object[0]).getActualValueLineStyle(contextProvider).getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartCrosshairValueLabelTextColor));
                paint = actualTextStylePaint;
            }
        } else if (struct.elemType == AxisElemType.ET_Strip && !struct.isAxisVertical) {
            StripBase stripBase = this.axesContainer.getAxisXById(struct.axisNumber).getStrips()[struct.elemNumber];
            if (stripBase.getAxisLabel() != null) {
                actualTextStylePaint = stripBase.getAxisLabel().getActualStyle(contextProvider, true).getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartAxisXStripLabelColor), Integer.valueOf(R.attr.dxChartAxisXStripLabelSize));
                paint = actualTextStylePaint;
            }
        } else if (struct.elemType == AxisElemType.ET_Strip && struct.isAxisVertical) {
            StripBase stripBase2 = this.axesContainer.getAxisYById(struct.axisNumber).getStrips()[struct.elemNumber];
            if (stripBase2.getAxisLabel() != null) {
                actualTextStylePaint = stripBase2.getAxisLabel().getActualStyle(contextProvider, false).getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartAxisYStripLabelColor), Integer.valueOf(R.attr.dxChartAxisYStripLabelSize));
                paint = actualTextStylePaint;
            }
        } else if (struct.elemType == AxisElemType.ET_ConstantLine && !struct.isAxisVertical) {
            paint = this.axesContainer.getAxisXById(struct.axisNumber).getConstantLines()[struct.elemNumber].getTitleInternal().getActualStyle(contextProvider, true).getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartAxisXConstantLineTitleColor), Integer.valueOf(R.attr.dxChartAxisXConstantLineTitleSize));
        } else if (struct.elemType == AxisElemType.ET_ConstantLine && struct.isAxisVertical) {
            paint = this.axesContainer.getAxisYById(struct.axisNumber).getConstantLines()[struct.elemNumber].getTitleInternal().getActualStyle(contextProvider, false).getActualTextStylePaint(contextProvider, Integer.valueOf(R.attr.dxChartAxisYConstantLineTitleColor), Integer.valueOf(R.attr.dxChartAxisYConstantLineTitleSize));
        }
        return paint == null ? chart.getTextStylePaintInternal() : paint;
    }
}
