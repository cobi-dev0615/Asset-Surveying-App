package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class MarkerStyle extends StyleBase {
    private Integer fill;
    private Integer stroke;
    private Float strokeThickness;

    enum Property {
        FILL,
        STROKE,
        STROKE_THICKNESS
    }

    int getFillFromResources(ContextProvider contextProvider) {
        return 0;
    }

    int getStrokeFromResources(ContextProvider contextProvider) {
        return 0;
    }

    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return 0.0f;
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.fill = Integer.valueOf(getFillFromResources(contextProvider));
        this.stroke = Integer.valueOf(getStrokeFromResources(contextProvider));
        this.strokeThickness = Float.valueOf(getStrokeThicknessFromResources(contextProvider));
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

    public Integer getFill() {
        return this.fill;
    }

    public void setFill(Integer num) {
        if (CompareHelper.areNotEquals(this.fill, num)) {
            this.fill = num;
            notifyListeners(Property.FILL);
        }
    }
}
