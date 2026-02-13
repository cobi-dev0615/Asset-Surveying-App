package com.devexpress.dxcharts;

/* compiled from: AreaSeriesStyle.java */
/* loaded from: classes.dex */
class AreaMarkerStyle extends MarkerStyle {
    AreaMarkerStyle() {
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    int getFillFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_area_series_marker);
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    int getStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_area_series_marker_stroke);
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.area_series_marker_stroke_thickness);
    }
}
