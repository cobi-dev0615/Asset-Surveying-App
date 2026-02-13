package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class PieSeriesStyle extends StyleBase {
    private static final float MAX_EXPLODED_DISTANCE = 10000.0f;
    private Float explodedDistance;
    private Integer stroke;
    private Float strokeThickness;

    enum Property {
        EXPLODED_DISTANCE,
        STROKE,
        STROKE_THICKNESS
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.explodedDistance = Float.valueOf(contextProvider.getResources().getInteger(R.integer.pie_exploded_distance));
        this.stroke = Integer.valueOf(ResourceHelper.getColorOrDefault(contextProvider, R.attr.dxPieChartSeriesStroke));
        this.strokeThickness = Float.valueOf(ResourceHelper.getDimensionOrDefault(contextProvider, R.attr.dxPieChartSeriesStrokeThickness));
    }

    public Float getExplodedDistance() {
        return this.explodedDistance;
    }

    public void setExplodedDistance(Float f) {
        if (f.floatValue() <= 0.0f || f.floatValue() > 10000.0f) {
            throw new IllegalArgumentException("distance");
        }
        if (CompareHelper.areNotEquals(this.explodedDistance, f)) {
            this.explodedDistance = f;
            notifyListeners(Property.EXPLODED_DISTANCE);
        }
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
