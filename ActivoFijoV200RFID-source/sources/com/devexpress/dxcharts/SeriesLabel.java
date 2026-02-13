package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class SeriesLabel extends StyledElement {
    private NativeObjectWrapper _labelNative;
    private String _textPattern = getDefaultTextPattern();
    private SeriesLabelTextProviderInternal _textProvider = new SeriesLabelTextProviderInternal();
    private Boolean _visibility;

    private enum Property {
        TEXT_PROVIDER
    }

    native long nativeCreateLabel();

    native float nativeGetIndent(long j);

    native void nativeSetHidden(int i, long j);

    native void nativeSetIndent(float f, long j);

    native void nativeSetSeriesLabelTextProvider(long j, SeriesLabelTextProviderInternal seriesLabelTextProviderInternal);

    native void nativeSetTextPattern(String str, long j);

    public SeriesLabel() {
        setVisible(true);
    }

    long getNativeLabel() {
        if (this._labelNative == null) {
            this._labelNative = new NativeObjectWrapper(nativeCreateLabel());
        }
        return this._labelNative.getObject();
    }

    void initLabel(SeriesBase seriesBase) {
        applyCurrentTheme(seriesBase.getContext(), new Object[0]);
        this._textProvider.setOwner(seriesBase);
    }

    SeriesLabelStyle getStyleInternal() {
        return (SeriesLabelStyle) getUserStyleFromContainer(SeriesLabelStyle.class);
    }

    String getDefaultTextPattern() {
        return "{V}";
    }

    @Override // com.devexpress.dxcharts.StyledElement
    StyleContainer<? extends StyleBase> createStyleContainer() {
        return new StyleContainer<>(SeriesLabelStyle.class);
    }

    public String getTextPattern() {
        return this._textPattern;
    }

    public void setTextPattern(String str) {
        this._textPattern = str;
        if (str == null) {
            str = getDefaultTextPattern();
        }
        nativeSetTextPattern(str, getNativeLabel());
    }

    public SeriesLabelTextProvider getTextProvider() {
        SeriesLabelTextProviderInternal seriesLabelTextProviderInternal = this._textProvider;
        if (seriesLabelTextProviderInternal != null) {
            return seriesLabelTextProviderInternal.getProvider();
        }
        return null;
    }

    public void setTextProvider(SeriesLabelTextProvider seriesLabelTextProvider) {
        SeriesLabelTextProviderInternal seriesLabelTextProviderInternal = this._textProvider;
        if (seriesLabelTextProviderInternal == null || seriesLabelTextProviderInternal.getProvider() == seriesLabelTextProvider) {
            return;
        }
        this._textProvider.setProvider(seriesLabelTextProvider);
        nativeSetSeriesLabelTextProvider(getNativeLabel(), seriesLabelTextProvider != null ? this._textProvider : null);
        notifyListeners(Property.TEXT_PROVIDER);
    }

    public int getIndent() {
        return (int) nativeGetIndent(getNativeLabel());
    }

    public void setIndent(int i) {
        nativeSetIndent(i, getNativeLabel());
    }

    public Boolean isVisible() {
        return this._visibility;
    }

    public void setVisible(Boolean bool) {
        int i;
        if (this._visibility != bool) {
            this._visibility = bool;
            if (bool != null) {
                i = bool.booleanValue() ? 1 : 0;
            } else {
                i = 2;
            }
            nativeSetHidden(i, getNativeLabel());
        }
    }
}
