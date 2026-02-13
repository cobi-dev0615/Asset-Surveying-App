package com.devexpress.dxcharts;

import com.devexpress.dxcharts.CustomValueBandPointColorizer;
import com.devexpress.dxcharts.RangeValueBandPointColorizer;

/* compiled from: ColorizerHolderBase.java */
/* loaded from: classes.dex */
class RangePointColorizerHolder extends ColorizerHolderBase<RangePointColorizer> {
    native long nativeCreateBandCustomValueColorizer(int[] iArr, double[] dArr, double[] dArr2, CustomColorizerNumericValueProvider customColorizerNumericValueProvider);

    native long nativeCreateColorEachColorizer(int[] iArr);

    native long nativeCreateIndexBasedCustomColorizer(IndexBasedCustomPointColorizer indexBasedCustomPointColorizer);

    native long nativeCreatePointCustomColorizer(RangeCustomPointColorizer rangeCustomPointColorizer);

    native long nativeCreateRangePointBandValueColorizer(int[] iArr, double[] dArr, double[] dArr2, int i);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetColorDataAdapter(long j, CustomColorizerNumericValueProvider customColorizerNumericValueProvider);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetColorStopValues(long j, int[] iArr, double[] dArr, double[] dArr2);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetPalette(long j, int[] iArr);

    RangePointColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (getColorizer() instanceof ColorEachPointColorizer) {
            return new NativeObjectWrapper(nativeCreateColorEachColorizer(((ColorEachPointColorizer) getColorizer()).getPalette()));
        }
        if (getColorizer() instanceof RangeValueBandPointColorizer) {
            RangeValueBandPointColorizer rangeValueBandPointColorizer = (RangeValueBandPointColorizer) getColorizer();
            RangeValueBandPointColorizer.RangeValueBandPointColorizerPrimitives createPrimitives = rangeValueBandPointColorizer.createPrimitives();
            return new NativeObjectWrapper(nativeCreateRangePointBandValueColorizer(createPrimitives.getBasePrimitives().getColors(), createPrimitives.getBasePrimitives().getValues1(), createPrimitives.getBasePrimitives().getValues2(), rangeValueBandPointColorizer.getValueLevel().ordinal()));
        }
        if (getColorizer() instanceof CustomValueBandPointColorizer) {
            CustomValueBandPointColorizer customValueBandPointColorizer = (CustomValueBandPointColorizer) getColorizer();
            CustomValueBandPointColorizer.CustomValueBandPointColorizerPrimitives createPrimitives2 = customValueBandPointColorizer.createPrimitives();
            return new NativeObjectWrapper(nativeCreateBandCustomValueColorizer(createPrimitives2.getBasePrimitives().getColors(), createPrimitives2.getBasePrimitives().getValues1(), createPrimitives2.getBasePrimitives().getValues2(), customValueBandPointColorizer.getValueProvider()));
        }
        if (getColorizer() instanceof RangeCustomPointColorizer) {
            return new NativeObjectWrapper(nativeCreatePointCustomColorizer((RangeCustomPointColorizer) getColorizer()));
        }
        if (getColorizer() instanceof IndexBasedCustomPointColorizer) {
            return new NativeObjectWrapper(nativeCreateIndexBasedCustomColorizer((IndexBasedCustomPointColorizer) getColorizer()));
        }
        return null;
    }
}
