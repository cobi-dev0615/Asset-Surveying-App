package com.devexpress.dxcharts;

import com.devexpress.dxcharts.SeriesCrosshairOptions;
import com.devexpress.dxcharts.SeriesHintOptions;
import com.devexpress.dxcharts.SeriesHintOptionsBase;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class SeriesBase extends StyledElement {
    private Synchronized _adapter;
    private SeriesHintOptionsBase _hintOptions;
    private SeriesLabel _seriesLabel;
    private NativeObjectWrapper _seriesNative;
    private NativeObjectWrapper _view;
    private Object _syncObject = this;
    private String _legendTextPattern = null;

    abstract SeriesLabelValuesBase createLabelValues(PointLabelInfo pointLabelInfo);

    abstract SeriesLabel getDefaultLabel();

    abstract long nativeCreateSeries(long j);

    abstract long nativeCreateView();

    native String nativeGetDisplayName(long j);

    native boolean nativeGetVisibility(long j);

    native boolean nativeGetVisibleInLegend(long j);

    native void nativeResetData(long j);

    native void nativeSetDisplayName(String str, long j);

    native void nativeSetHintEnabled(boolean z, long j);

    native void nativeSetHintPointTextPattern(String str, long j);

    native void nativeSetHintPointTextProvider(PointTextProvider pointTextProvider, long j);

    native void nativeSetLegendTextPattern(String str, long j);

    native void nativeSetSeriesLabel(long j, long j2);

    native void nativeSetVisibility(boolean z, long j);

    native void nativeSetVisibleInLegend(long j, boolean z);

    long getView() {
        if (this._view == null) {
            this._view = new NativeObjectWrapper(nativeCreateView());
        }
        return this._view.getObject();
    }

    long getNativeSeries() {
        if (this._seriesNative == null) {
            this._seriesNative = new NativeObjectWrapper(nativeCreateSeries(getView()));
            SeriesLabel defaultLabel = getDefaultLabel();
            defaultLabel.setVisible(false);
            nativeSetSeriesLabel(defaultLabel.getNativeLabel(), this._seriesNative.getObject());
        }
        return this._seriesNative.getObject();
    }

    boolean compareNativeSeries(long j) {
        return this._seriesNative.compare(j);
    }

    Object getSyncObject() {
        return this._syncObject;
    }

    void setSyncObject(Object obj) {
        if (obj == null) {
            obj = this;
        }
        this._syncObject = obj;
        Synchronized r0 = this._adapter;
        if (r0 != null) {
            r0.setSyncObject(obj);
        }
    }

    void setAdapterInternal(Synchronized r3) {
        this._adapter = r3;
        if (r3 == null) {
            nativeResetData(getNativeSeries());
        }
    }

    SeriesLabel getLabel() {
        return this._seriesLabel;
    }

    void setLabel(SeriesLabel seriesLabel) {
        synchronized (ChartBase.syncObject) {
            SeriesLabel seriesLabel2 = this._seriesLabel;
            if (seriesLabel != seriesLabel2) {
                if (seriesLabel2 != null) {
                    seriesLabel2.removeListener(getSelfListener());
                }
                this._seriesLabel = seriesLabel;
                if (seriesLabel != null) {
                    seriesLabel.initLabel(this);
                    this._seriesLabel.addListener(getSelfListener());
                    nativeSetSeriesLabel(this._seriesLabel.getNativeLabel(), getNativeSeries());
                } else {
                    SeriesLabel defaultLabel = getDefaultLabel();
                    defaultLabel.setVisible(false);
                    nativeSetSeriesLabel(defaultLabel.getNativeLabel(), getNativeSeries());
                }
            }
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (obj instanceof SeriesHintOptionsBase) {
            applyHintOptionsInternal(propertyChangedArgs.getProperty());
        } else {
            super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        }
    }

    @Override // com.devexpress.dxcharts.StyledElement
    List<StyledElement> getInnerStyledElements(ContextProvider contextProvider) {
        List<StyledElement> innerStyledElements = super.getInnerStyledElements(contextProvider);
        innerStyledElements.add(this._seriesLabel);
        return innerStyledElements;
    }

    SeriesHintOptionsBase getHintOptionsInternal() {
        return this._hintOptions;
    }

    void setHintOptionsInternal(SeriesHintOptionsBase seriesHintOptionsBase) {
        SeriesHintOptionsBase seriesHintOptionsBase2 = this._hintOptions;
        if (seriesHintOptionsBase2 != seriesHintOptionsBase) {
            if (seriesHintOptionsBase2 != null) {
                seriesHintOptionsBase2.removeListener(getSelfListener());
            }
            this._hintOptions = seriesHintOptionsBase;
            if (seriesHintOptionsBase != null) {
                seriesHintOptionsBase.addListener(getSelfListener());
            }
            for (SeriesHintOptionsBase.Property property : SeriesHintOptionsBase.Property.values()) {
                applyHintOptionsInternal(property);
            }
            for (SeriesHintOptions.Property property2 : SeriesHintOptions.Property.values()) {
                applyHintOptionsInternal(property2);
            }
            for (SeriesCrosshairOptions.Property property3 : SeriesCrosshairOptions.Property.values()) {
                applyHintOptionsInternal(property3);
            }
        }
    }

    /* renamed from: com.devexpress.dxcharts.SeriesBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$SeriesHintOptionsBase$Property;

        static {
            int[] iArr = new int[SeriesHintOptionsBase.Property.values().length];
            $SwitchMap$com$devexpress$dxcharts$SeriesHintOptionsBase$Property = iArr;
            try {
                iArr[SeriesHintOptionsBase.Property.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$SeriesHintOptionsBase$Property[SeriesHintOptionsBase.Property.POINT_TEXT_PATTERN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$SeriesHintOptionsBase$Property[SeriesHintOptionsBase.Property.POINT_TEXT_PROVIDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    void applyHintOptionsInternal(Enum<?> r4) {
        if (r4 instanceof SeriesHintOptionsBase.Property) {
            int i = AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$SeriesHintOptionsBase$Property[((SeriesHintOptionsBase.Property) r4).ordinal()];
            if (i == 1) {
                SeriesHintOptionsBase seriesHintOptionsBase = this._hintOptions;
                nativeSetHintEnabled(seriesHintOptionsBase != null ? seriesHintOptionsBase.isEnabled() : true, getNativeSeries());
            } else if (i == 2) {
                SeriesHintOptionsBase seriesHintOptionsBase2 = this._hintOptions;
                nativeSetHintPointTextPattern(seriesHintOptionsBase2 != null ? seriesHintOptionsBase2.getPointTextPattern() : SeriesHintOptionsBase.DEFAULT_POINT_TEXT_PATTERN, getNativeSeries());
            } else {
                if (i != 3) {
                    return;
                }
                SeriesHintOptionsBase seriesHintOptionsBase3 = this._hintOptions;
                nativeSetHintPointTextProvider(seriesHintOptionsBase3 != null ? seriesHintOptionsBase3.getPointTextProvider() : null, getNativeSeries());
            }
        }
    }

    public boolean isVisible() {
        return nativeGetVisibility(getNativeSeries());
    }

    public void setVisible(boolean z) {
        synchronized (ChartBase.syncObject) {
            nativeSetVisibility(z, getNativeSeries());
        }
    }

    public String getDisplayName() {
        return nativeGetDisplayName(getNativeSeries());
    }

    public void setDisplayName(String str) {
        nativeSetDisplayName(str, getNativeSeries());
    }

    public boolean isVisibleInLegend() {
        return nativeGetVisibleInLegend(getNativeSeries());
    }

    public void setVisibleInLegend(boolean z) {
        nativeSetVisibleInLegend(getNativeSeries(), z);
    }

    public String getLegendTextPattern() {
        return this._legendTextPattern;
    }

    public void setLegendTextPattern(String str) {
        if (Objects.equals(this._legendTextPattern, str)) {
            return;
        }
        this._legendTextPattern = str;
        nativeSetLegendTextPattern(str, getNativeSeries());
    }
}
