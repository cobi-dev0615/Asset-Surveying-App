package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class BubbleSeriesStyle extends StyleBase {
    private StyleContainer<? extends MarkerStyle> markerStyle = createMarkerStyle();

    private enum Property {
        MARKER_STYLE
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.markerStyle.getDefaultStyle(contextProvider, new Object[0]);
    }

    StyleContainer<? extends MarkerStyle> createMarkerStyle() {
        return new StyleContainer<>(BubbleMarkerStyle.class, MarkerStyle.class);
    }

    MarkerStyle getActualMarkerStyle(ContextProvider contextProvider) {
        return this.markerStyle.getActualStyle(contextProvider, new Object[0]);
    }

    public MarkerStyle getMarkerStyle() {
        return this.markerStyle.getUserStyle();
    }

    public void setMarkerStyle(MarkerStyle markerStyle) {
        if (this.markerStyle.trySetUserStyle(markerStyle, getSelfListener())) {
            notifyListeners(Property.MARKER_STYLE);
        }
    }
}
