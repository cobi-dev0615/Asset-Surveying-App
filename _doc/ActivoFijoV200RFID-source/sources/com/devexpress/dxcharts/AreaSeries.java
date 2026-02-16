package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public class AreaSeries extends AreaSeriesBase {
    private PointColorizerHolder colorizerHolder = new PointColorizerHolder();
    private SegmentColorizerHolder segmentColorizerHolder = new SegmentColorizerHolder();
    private FillColorizerHolder fillColorizerHolder = new FillColorizerHolder();

    native void nativeSetColorizer(long j);

    native void nativeSetFillColorizer(long j);

    native void nativeSetSegmentColorizer(long j);

    public PointColorizer getPointColorizer() {
        return this.colorizerHolder.getColorizer();
    }

    public void setPointColorizer(PointColorizer pointColorizer) {
        this.colorizerHolder.setColorizer(pointColorizer);
        nativeSetColorizer(this.colorizerHolder.getNativeColorizer());
    }

    public void setSegmentColorizer(SegmentColorizer segmentColorizer) {
        this.segmentColorizerHolder.setColorizer(segmentColorizer);
        nativeSetSegmentColorizer(this.segmentColorizerHolder.getNativeColorizer());
    }

    public SegmentColorizer getSegmentColorizer() {
        return this.segmentColorizerHolder.getColorizer();
    }

    public void setFillColorizer(FillColorizer fillColorizer) {
        this.fillColorizerHolder.setColorizer(fillColorizer);
        nativeSetFillColorizer(this.fillColorizerHolder.getNativeColorizer());
    }

    public FillColorizer getFillColorizer() {
        return this.fillColorizerHolder.getColorizer();
    }
}
