package com.devexpress.dxcharts;

/* compiled from: PointSeriesStyle.java */
/* loaded from: classes.dex */
class PointMarkerStyle extends MarkerStyle {
    PointMarkerStyle() {
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    int getFillFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_point_series);
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    int getStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_point_series_stroke);
    }

    @Override // com.devexpress.dxcharts.MarkerStyle
    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.point_series_stroke_thickness);
    }
}
