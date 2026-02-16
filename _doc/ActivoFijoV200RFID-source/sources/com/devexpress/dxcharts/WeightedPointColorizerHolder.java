package com.devexpress.dxcharts;

import com.devexpress.dxcharts.CustomValueBandPointColorizer;
import com.devexpress.dxcharts.ValueBandPointColorizer;
import com.devexpress.dxcharts.WeightedValueBandPointColorizer;

/* compiled from: ColorizerHolderBase.java */
/* loaded from: classes.dex */
class WeightedPointColorizerHolder extends ColorizerHolderBase<WeightedPointColorizer> {
    native long nativeCreateBandCustomValueColorizer(int[] iArr, double[] dArr, double[] dArr2, CustomColorizerNumericValueProvider customColorizerNumericValueProvider);

    native long nativeCreateColorEachColorizer(int[] iArr);

    native long nativeCreateIndexBasedCustomColorizer(IndexBasedCustomPointColorizer indexBasedCustomPointColorizer);

    native long nativeCreatePointBandValueColorizer(int[] iArr, double[] dArr, double[] dArr2);

    native long nativeCreatePointCustomColorizer(WeightedCustomPointColorizer weightedCustomPointColorizer);

    native long nativeCreateWeightValueColorizer(int[] iArr, double[] dArr, double[] dArr2);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetColorDataAdapter(long j, CustomColorizerNumericValueProvider customColorizerNumericValueProvider);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetColorStopValues(long j, int[] iArr, double[] dArr, double[] dArr2);

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    native void nativeSetPalette(long j, int[] iArr);

    WeightedPointColorizerHolder() {
    }

    @Override // com.devexpress.dxcharts.ColorizerHolderBase
    protected NativeObjectWrapper createNativeColorizer() {
        if (getColorizer() instanceof ColorEachPointColorizer) {
            return new NativeObjectWrapper(nativeCreateColorEachColorizer(((ColorEachPointColorizer) getColorizer()).getPalette()));
        }
        if (getColorizer() instanceof WeightedValueBandPointColorizer) {
            WeightedValueBandPointColorizer.WeightedValueColorizerPrimitives createPrimitives = ((WeightedValueBandPointColorizer) getColorizer()).createPrimitives();
            return new NativeObjectWrapper(nativeCreateWeightValueColorizer(createPrimitives.getBasePrimitives().getColors(), createPrimitives.getBasePrimitives().getValues1(), createPrimitives.getBasePrimitives().getValues2()));
        }
        if (getColorizer() instanceof ValueBandPointColorizer) {
            ValueBandPointColorizer.ValueBandPointColorizerPrimitives createPrimitives2 = ((ValueBandPointColorizer) getColorizer()).createPrimitives();
            return new NativeObjectWrapper(nativeCreatePointBandValueColorizer(createPrimitives2.getBasePrimitives().getColors(), createPrimitives2.getBasePrimitives().getValues1(), createPrimitives2.getBasePrimitives().getValues2()));
        }
        if (getColorizer() instanceof CustomValueBandPointColorizer) {
            CustomValueBandPointColorizer customValueBandPointColorizer = (CustomValueBandPointColorizer) getColorizer();
            CustomValueBandPointColorizer.CustomValueBandPointColorizerPrimitives createPrimitives3 = customValueBandPointColorizer.createPrimitives();
            return new NativeObjectWrapper(nativeCreateBandCustomValueColorizer(createPrimitives3.getBasePrimitives().getColors(), createPrimitives3.getBasePrimitives().getValues1(), createPrimitives3.getBasePrimitives().getValues2(), customValueBandPointColorizer.getValueProvider()));
        }
        if (getColorizer() instanceof WeightedCustomPointColorizer) {
            return new NativeObjectWrapper(nativeCreatePointCustomColorizer((WeightedCustomPointColorizer) getColorizer()));
        }
        if (getColorizer() instanceof IndexBasedCustomPointColorizer) {
            return new NativeObjectWrapper(nativeCreateIndexBasedCustomColorizer((IndexBasedCustomPointColorizer) getColorizer()));
        }
        return null;
    }
}
