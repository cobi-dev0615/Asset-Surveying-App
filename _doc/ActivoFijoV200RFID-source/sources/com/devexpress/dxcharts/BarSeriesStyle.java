package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class BarSeriesStyle extends StyleBase {
    private Integer fill;
    private Integer stroke;
    private Float strokeThickness;

    enum Property {
        STROKE,
        STROKE_THICKNESS,
        FILL
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.stroke = Integer.valueOf(ResourceHelper.getSimpleColor(contextProvider, R.color.color_bar_series_stroke));
        this.strokeThickness = Float.valueOf(contextProvider.getResources().getDimension(R.dimen.bar_series_stroke_thickness));
        this.fill = Integer.valueOf(ResourceHelper.getSimpleColor(contextProvider, R.color.color_bar_series));
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
