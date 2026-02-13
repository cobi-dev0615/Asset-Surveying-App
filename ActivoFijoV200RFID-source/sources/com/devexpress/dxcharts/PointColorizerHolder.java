package com.devexpress.dxcharts;

import com.devexpress.dxcharts.CustomValueBandPointColorizer;
import com.devexpress.dxcharts.ValueBandPointColorizer;

/* compiled from: ColorizerHolderBase.java */
/* loaded from: classes.dex */
class PointColorizerHolder extends ColorizerHolderBase<PointColorizer> {
    native long nativeCreateBandCustomValueColorizer(int[] iArr, double[] dArr, double[] dArr2, CustomColorizerNumericValueProvider customColorizerNumericValueProvider);

    native long nativeCreateBandValueColorizer(int[] iArr, double[] dArr, double[] dArr2);

    native long nativeCreateColorEachColorizer(int[] iArr);

    native long nativeCreateIndexBasedCustomColorizer(IndexBasedCustomPointColorizer indexBasedCustomPointColorizer);

    native long nativeCreatePointCustomColorizer(CustomPointColorizer customPointColorizer);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetColorDataAdapter(long j, CustomColorizerNumericValueProvider customColorizerNumericValueProvider);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetColorStopValues(long j, int[] iArr, double[] dArr, double[] dArr2);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetPalette(long j, int[] iArr);

    PointColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (getColorizer() instanceof ColorEachPointColorizer) {
            return new NativeObjectWrapper(nativeCreateColorEachColorizer(((ColorEachPointColorizer) getColorizer()).getPalette()));
        }
        if (getColorizer() instanceof ValueBandPointColorizer) {
            ValueBandPointColorizer.ValueBandPointColorizerPrimitives createPrimitives = ((ValueBandPointColorizer) getColorizer()).createPrimitives();
            return new NativeObjectWrapper(nativeCreateBandValueColorizer(createPrimitives.getBasePrimitives().getColors(), createPrimitives.getBasePrimitives().getValues1(), createPrimitives.getBasePrimitives().getValues2()));
        }
        if (getColorizer() instanceof CustomValueBandPointColorizer) {
            CustomValueBandPointColorizer customValueBandPointColorizer = (CustomValueBandPointColorizer) getColorizer();
            CustomValueBandPointColorizer.CustomValueBandPointColorizerPrimitives createPrimitives2 = customValueBandPointColorizer.createPrimitives();
            return new NativeObjectWrapper(nativeCreateBandCustomValueColorizer(createPrimitives2.getBasePrimitives().getColors(), createPrimitives2.getBasePrimitives().getValues1(), createPrimitives2.getBasePrimitives().getValues2(), customValueBandPointColorizer.getValueProvider()));
        }
        if (getColorizer() instanceof CustomPointColorizer) {
            return new NativeObjectWrapper(nativeCreatePointCustomColorizer((CustomPointColorizer) getColorizer()));
        }
        if (getColorizer() instanceof IndexBasedCustomPointColorizer) {
            return new NativeObjectWrapper(nativeCreateIndexBasedCustomColorizer((IndexBasedCustomPointColorizer) getColorizer()));
        }
        return null;
    }
}
