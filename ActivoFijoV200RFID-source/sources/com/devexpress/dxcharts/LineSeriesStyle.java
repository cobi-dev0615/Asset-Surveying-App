package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class LineSeriesStyle extends PointSeriesStyle {
    private Integer stroke;
    private Float strokeThickness;

    enum Property {
        STROKE,
        STROKE_THICKNESS
    }

    @Override // com.devexpress.dxcharts.PointSeriesStyle, com.devexpress.dxcharts.BubbleSeriesStyle, com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.stroke = Integer.valueOf(getStrokeFromResources(contextProvider));
        this.strokeThickness = Float.valueOf(getStrokeThicknessFromResources(contextProvider));
    }

    int getStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_line_series);
    }

    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.line_series_stroke_thickness);
    }

    @Override // com.devexpress.dxcharts.PointSeriesStyle
    int getSizeFromResources(ContextProvider contextProvider) {
        return (int) contextProvider.getResources().getDimension(R.dimen.line_series_marker_size);
    }

    @Override // com.devexpress.dxcharts.PointSeriesStyle, com.devexpress.dxcharts.BubbleSeriesStyle
    StyleContainer<? extends MarkerStyle> createMarkerStyle() {
        return new StyleContainer<>(LineMarkerStyle.class, MarkerStyle.class);
    }

    public Integer getStroke() {
        return this.stroke;
    }

    public void setStroke(Integer num) {
        if (CompareHelper.areNotEquals(this.stroke, num)) {
            this.stroke = num;
            notifyListeners(Property.STROKE);
        }
    }

    public Float getStrokeThickness() {
        return this.strokeThickness;
    }

    public void setStrokeThickness(Float f) {
        if (CompareHelper.areNotEquals(this.strokeThickness, f)) {
            this.strokeThickness = f;
            notifyListeners(Property.STROKE_THICKNESS);
        }
    }
}
