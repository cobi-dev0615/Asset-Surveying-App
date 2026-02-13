package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class BarSeries extends BarSeriesBase {
    private PointColorizerHolder colorizerHolder = new PointColorizerHolder();

    @Override // com.devexpress.dxcharts.SeriesBase
    native long nativeCreateView();

    native void nativeSetColorizer(long j);

    @Override // com.devexpress.dxcharts.BarSeriesBase, com.devexpress.dxcharts.SeriesBase
    SeriesLabel getDefaultLabel() {
        return new BarSeriesLabel();
    }

    @Override // com.devexpress.dxcharts.SeriesBase
    public BarSeriesLabel getLabel() {
        return (BarSeriesLabel) super.getLabel();
    }

    public void setLabel(BarSeriesLabel barSeriesLabel) {
        super.setLabel((SeriesLabel) barSeriesLabel);
    }

    public PointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(PointColorizer pointColorizer) {
        this.colorizerHolder.setColorizer(pointColorizer);
        nativeSetColorizer(this.colorizerHolder.getNativeColorizer());
    }

    @Override // com.devexpress.dxcharts.BarSeriesBase
    @Deprecated
    public boolean isColorEach() {
        return super.isColorEach();
    }

    @Override // com.devexpress.dxcharts.BarSeriesBase
    @Deprecated
    public void setColorEach(boolean z) {
        super.setColorEach(z);
    }
}
