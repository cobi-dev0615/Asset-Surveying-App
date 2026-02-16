package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class PointSeriesStyle extends BubbleSeriesStyle {
    private Integer size;

    enum Property {
        SIZE
    }

    @Override // com.devexpress.dxcharts.BubbleSeriesStyle, com.devexpress.dxcharts.StyleBase
    void initDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        super.initDefaultStyle(contextProvider, objArr);
        this.size = Integer.valueOf(getSizeFromResources(contextProvider));
    }

    @Override // com.devexpress.dxcharts.BubbleSeriesStyle
    StyleContainer<? extends MarkerStyle> createMarkerStyle() {
        return new StyleContainer<>(PointMarkerStyle.class, MarkerStyle.class);
    }

    int getSizeFromResources(ContextProvider contextProvider) {
        return (int) contextProvider.getResources().getDimension(R.dimen.point_series_marker_size);
    }

    public Integer getMarkerSize() {
        return this.size;
    }

    public void setMarkerSize(Integer num) {
        if (CompareHelper.areNotEquals(this.size, num)) {
            this.size = num;
            notifyListeners(Property.SIZE);
        }
    }
}
