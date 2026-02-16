package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class RangeAreaSeriesStyle extends StyleBase {
    private Float alpha;
    private Integer fill;
    private StyleContainer line1Style = createLineStyle();
    private StyleContainer line2Style = createLineStyle();

    enum Property {
        FILL,
        ALPHA,
        LINE1_STYLE,
        LINE2_STYLE
    }

    StyleContainer createLineStyle() {
        return new StyleContainer(LineSeriesStyle.class);
    }

    @Override // com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.fill = Integer.valueOf(ResourceHelper.getSimpleColor(contextProvider, R.color.color_area_series));
        this.alpha = Float.valueOf(contextProvider.getResources().getDimension(R.dimen.area_series_alpha));
        this.line1Style.getDefaultStyle();
        this.line2Style.getDefaultStyle();
    }

    LineSeriesStyle getActualLine1Style(ContextProvider contextProvider) {
        return (LineSeriesStyle) this.line1Style.getActualStyle(contextProvider, new Object[0]);
    }

    LineSeriesStyle getActualLine2Style(ContextProvider contextProvider) {
        return (LineSeriesStyle) this.line2Style.getActualStyle(contextProvider, new Object[0]);
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

    public LineSeriesStyle getLine1Style() {
        return (LineSeriesStyle) this.line1Style.getUserStyle();
    }

    public void setLine1Style(LineSeriesStyle lineSeriesStyle) {
        if (this.line1Style.trySetUserStyle(lineSeriesStyle, getSelfListener())) {
            notifyListeners(Property.LINE1_STYLE);
        }
    }

    public LineSeriesStyle getLine2Style() {
        return (LineSeriesStyle) this.line2Style.getUserStyle();
    }

    public void setLine2Style(LineSeriesStyle lineSeriesStyle) {
        if (this.line2Style.trySetUserStyle(lineSeriesStyle, getSelfListener())) {
            notifyListeners(Property.LINE2_STYLE);
        }
    }
}
