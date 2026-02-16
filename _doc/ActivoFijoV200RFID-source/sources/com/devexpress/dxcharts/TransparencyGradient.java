package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class TransparencyGradient extends StyleBase {
    private Float baselineAlpha;
    private Float seriesLineAlpha;

    enum Property {
        BASELINE_ALPHA,
        SERIESLINE_ALPHA
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.baselineAlpha = Float.valueOf(0.8f);
        this.seriesLineAlpha = Float.valueOf(0.0f);
    }

    public Float getBaselineAlpha() {
        return this.baselineAlpha;
    }

    public void setBaselineAlpha(Float f) {
        if (CompareHelper.areNotEquals(this.baselineAlpha, f)) {
            this.baselineAlpha = f;
            notifyListeners(Property.BASELINE_ALPHA);
        }
    }

    public Float getSeriesLineAlpha() {
        return this.seriesLineAlpha;
    }

    public void setSeriesLineAlpha(Float f) {
        if (CompareHelper.areNotEquals(this.seriesLineAlpha, f)) {
            this.seriesLineAlpha = f;
            notifyListeners(Property.SERIESLINE_ALPHA);
        }
    }
}
