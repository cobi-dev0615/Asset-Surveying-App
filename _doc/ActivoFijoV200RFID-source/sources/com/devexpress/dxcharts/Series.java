package com.devexpress.dxcharts;

import com.devexpress.dxcharts.SeriesCrosshairOptions;
import com.devexpress.dxcharts.SeriesHintOptions;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Series extends SeriesBase {
    private XYSeriesData _data = null;
    private IAxesContainer axesContainer;
    private AxisX axisX;
    private NumericAxisY axisY;

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateSeries(long j);

    native void nativeSetAxisX(long j, long j2);

    native void nativeSetAxisY(long j, boolean z, long j2);

    native void nativeSetColor(int i);

    native void nativeSetCrosshairAxisLabelVisible(boolean z, long j);

    native void nativeSetCrosshairAxisLineVisible(boolean z, long j);

    native void nativeSetHintSeriesTextPattern(String str, long j);

    native void nativeSetShowInCrosshairLabel(boolean z, long j);

    @Override // com.devexpress.dxcharts.SeriesBase
    SeriesLabelValuesBase createLabelValues(PointLabelInfo pointLabelInfo) {
        return new SeriesLabelValues(pointLabelInfo.seriesName, pointLabelInfo.indexes, pointLabelInfo.argument, pointLabelInfo.value);
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    void applyHintOptionsInternal(Enum<?> r4) {
        super.applyHintOptionsInternal(r4);
        SeriesHintOptions hintOptions = getHintOptions();
        if (r4 instanceof SeriesHintOptions.Property) {
            if (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$SeriesHintOptions$Property[((SeriesHintOptions.Property) r4).ordinal()] != 1) {
                return;
            }
            nativeSetHintSeriesTextPattern(hintOptions != null ? hintOptions.getSeriesTextPattern() : SeriesHintOptions.DEFAULT_SERIES_TEXT_PATTERN, getNativeSeries());
        } else if (r4 instanceof SeriesCrosshairOptions.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$SeriesCrosshairOptions$Property[((SeriesCrosshairOptions.Property) r4).ordinal()];
            if (i == 1) {
                nativeSetCrosshairAxisLabelVisible(hintOptions instanceof SeriesCrosshairOptions ? ((SeriesCrosshairOptions) hintOptions).isAxisLabelVisible() : true, getNativeSeries());
            } else if (i == 2) {
                nativeSetCrosshairAxisLineVisible(hintOptions instanceof SeriesCrosshairOptions ? ((SeriesCrosshairOptions) hintOptions).isAxisLineVisible() : true, getNativeSeries());
            } else {
                if (i != 3) {
                    return;
                }
                nativeSetShowInCrosshairLabel(hintOptions instanceof SeriesCrosshairOptions ? ((SeriesCrosshairOptions) hintOptions).isShowInLabel() : true, getNativeSeries());
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.Series$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$SeriesCrosshairOptions$Property;
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$SeriesHintOptions$Property;

        static {
            int[] iArr = new int[SeriesCrosshairOptions.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$SeriesCrosshairOptions$Property = iArr;
            try {
                iArr[SeriesCrosshairOptions.Property.AXIS_LABEL_VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$SeriesCrosshairOptions$Property[SeriesCrosshairOptions.Property.AXIS_LINE_VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$SeriesCrosshairOptions$Property[SeriesCrosshairOptions.Property.SHOW_IN_LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SeriesHintOptions.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$SeriesHintOptions$Property = iArr2;
            try {
                iArr2[SeriesHintOptions.Property.SERIES_TEXT_PATTERN.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    SeriesDataAdapterBase createDataAdapter(XYSeriesData xYSeriesData) {
        return XYSeriesDataAdapterBase.create(xYSeriesData, getNativeSeries(), getSyncObject());
    }

    @Override // com.devexpress.dxcharts.SeriesBase, com.devexpress.dxcharts.StyledElement
    List<StyledElement> getInnerStyledElements(ContextProvider contextProvider) {
        List<StyledElement> innerStyledElements = super.getInnerStyledElements(contextProvider);
        innerStyledElements.add(getAxisX());
        innerStyledElements.add(getAxisY());
        return innerStyledElements;
    }

    private ContextProvider getContextProvider() {
        return getContext();
    }

    IAxesContainer getAxesContainer() {
        return this.axesContainer;
    }

    void setAxesContainer(IAxesContainer iAxesContainer) {
        if (this.axesContainer != iAxesContainer) {
            if (iAxesContainer != null && getAxisX() != null) {
                iAxesContainer.addAxisXForElement(getAxisX(), this);
            }
            if (iAxesContainer != null && getAxisY() != null) {
                iAxesContainer.addAxisYForElement(getAxisY(), this);
            }
            this.axesContainer = iAxesContainer;
        }
    }

    public AxisX getAxisX() {
        IAxesContainer iAxesContainer = this.axesContainer;
        return iAxesContainer != null ? iAxesContainer.getAxisXByElement(this) : this.axisX;
    }

    public void setAxisX(AxisX axisX) {
        synchronized (ChartBase.syncObject) {
            if (getAxisX() != axisX) {
                if (getAxisX() != null) {
                    getAxisX().removeListener(getSelfListener());
                }
                IAxesContainer iAxesContainer = this.axesContainer;
                if (iAxesContainer == null) {
                    this.axisX = axisX;
                } else {
                    iAxesContainer.addAxisXForElement(axisX, this);
                }
                if (getAxisX() != null) {
                    getAxisX().addListener(getSelfListener());
                    nativeSetAxisX(getAxisX().getNativeAxis(), getNativeSeries());
                }
            }
        }
    }

    public NumericAxisY getAxisY() {
        IAxesContainer iAxesContainer = this.axesContainer;
        return iAxesContainer != null ? iAxesContainer.getAxisYByElement(this) : this.axisY;
    }

    public void setAxisY(NumericAxisY numericAxisY) {
        synchronized (ChartBase.syncObject) {
            if (getAxisY() != numericAxisY) {
                if (getAxisY() != null) {
                    getAxisY().removeListener(getSelfListener());
                }
                IAxesContainer iAxesContainer = this.axesContainer;
                if (iAxesContainer == null) {
                    this.axisY = numericAxisY;
                } else {
                    iAxesContainer.addAxisYForElement(numericAxisY, this);
                }
                if (getAxisY() != null) {
                    getAxisY().addListener(getSelfListener());
                    nativeSetAxisY(getAxisY().getNativeAxis(), getAxisY().isAlwaysShowZeroLevel(), getNativeSeries());
                }
            }
        }
    }

    public XYSeriesData getData() {
        return this._data;
    }

    public void setData(XYSeriesData xYSeriesData) {
        synchronized (ChartBase.syncObject) {
            if (xYSeriesData != this._data) {
                this._data = xYSeriesData;
                setAdapterInternal(createDataAdapter(xYSeriesData));
            }
        }
    }

    public SeriesHintOptions getHintOptions() {
        return (SeriesHintOptions) getHintOptionsInternal();
    }

    public void setHintOptions(SeriesHintOptions seriesHintOptions) {
        setHintOptionsInternal(seriesHintOptions);
    }
}
