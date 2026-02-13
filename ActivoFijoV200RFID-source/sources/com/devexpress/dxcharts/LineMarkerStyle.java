package com.devexpress.dxcharts;

/* compiled from: LineSeriesStyle.java */
/* loaded from: classes.dex */
class LineMarkerStyle extends MarkerStyle {
    LineMarkerStyle() {
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    int getFillFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_line_series_marker);
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    int getStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_line_series_marker_stroke);
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.line_series_marker_stroke_thickness);
    }
}
