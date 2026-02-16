package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class LineIndicatorStyle extends StyleBase {
    private Integer stroke;
    private Float strokeThickness;

    enum Property {
        STROKE,
        STROKE_THICKNESS
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.stroke = Integer.valueOf(getStrokeFromResources(contextProvider));
        this.strokeThickness = Float.valueOf(getStrokeThicknessFromResources(contextProvider));
    }

    protected int getStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_line_series);
    }

    protected float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.line_series_stroke_thickness);
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
