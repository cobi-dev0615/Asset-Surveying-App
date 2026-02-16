package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AreaSeriesStyle extends LineSeriesStyle {
    private Float alpha;
    private Integer fill;
    private StyleContainer fillEffectStyleContainer = new StyleContainer(TransparencyGradient.class);

    enum Property {
        FILL_EFFECT,
        FILL,
        ALPHA
    }

    TransparencyGradient getActualFillEffectStyle(ContextProvider contextProvider) {
        return (TransparencyGradient) this.fillEffectStyleContainer.getActualStyle(contextProvider, new Object[0]);
    }

    @Override // com.devexpress.dxcharts.LineSeriesStyle, com.devexpress.dxcharts.PointSeriesStyle, com.devexpress.dxcharts.BubbleSeriesStyle
    StyleContainer<? extends MarkerStyle> createMarkerStyle() {
        return new StyleContainer<>(AreaMarkerStyle.class, MarkerStyle.class);
    }

    @Override // com.devexpress.dxcharts.LineSeriesStyle, com.devexpress.dxcharts.PointSeriesStyle, com.devexpress.dxcharts.BubbleSeriesStyle, com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.fillEffectStyleContainer.getDefaultStyle(contextProvider, new Object[0]);
        this.fill = Integer.valueOf(ResourceHelper.getSimpleColor(contextProvider, R.color.color_area_series));
        this.alpha = Float.valueOf(contextProvider.getResources().getDimension(R.dimen.area_series_alpha));
    }

    @Override // com.devexpress.dxcharts.LineSeriesStyle
    int getStrokeFromResources(ContextProvider contextProvider) {
        return ResourceHelper.getSimpleColor(contextProvider, R.color.color_area_series_stroke);
    }

    @Override // com.devexpress.dxcharts.LineSeriesStyle
    float getStrokeThicknessFromResources(ContextProvider contextProvider) {
        return contextProvider.getResources().getDimension(R.dimen.area_series_stroke_thickness);
    }

    @Override // com.devexpress.dxcharts.LineSeriesStyle, com.devexpress.dxcharts.PointSeriesStyle
    int getSizeFromResources(ContextProvider contextProvider) {
        return (int) contextProvider.getResources().getDimension(R.dimen.area_series_marker_size);
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

    public Float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(Float f) {
        if (CompareHelper.areNotEquals(this.alpha, f)) {
            if (f.floatValue() < 0.0f || f.floatValue() > 1.0f) {
                f = null;
            }
            this.alpha = f;
            notifyListeners(Property.ALPHA);
        }
    }

    public TransparencyGradient getFillEffect() {
        return (TransparencyGradient) this.fillEffectStyleContainer.getUserStyle();
    }

    public void setFillEffect(TransparencyGradient transparencyGradient) {
        if (this.fillEffectStyleContainer.trySetUserStyle(transparencyGradient, getSelfListener())) {
            notifyListeners(Property.FILL_EFFECT);
        }
    }
}
