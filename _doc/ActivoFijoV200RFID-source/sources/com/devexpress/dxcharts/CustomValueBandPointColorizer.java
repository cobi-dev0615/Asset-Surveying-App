package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BandPointColorizerBase;

/* loaded from: classes.dex */
public class CustomValueBandPointColorizer extends BandPointColorizerBase implements PointColorizer, StackedPointColorizer, RangePointColorizer, WeightedPointColorizer {
    private CustomColorizerNumericValueProvider valueProvider;

    enum Property {
        VALUE_PROVIDER
    }

    public CustomColorizerNumericValueProvider getValueProvider() {
        return this.valueProvider;
    }

    public void setValueProvider(CustomColorizerNumericValueProvider customColorizerNumericValueProvider) {
        synchronized (ChartBase.syncObject) {
            if (this.valueProvider != customColorizerNumericValueProvider) {
                this.valueProvider = customColorizerNumericValueProvider;
                notifyListeners(Property.VALUE_PROVIDER);
            }
        }
    }

    CustomValueBandPointColorizerPrimitives createPrimitives() {
        return new CustomValueBandPointColorizerPrimitives();
    }

    class CustomValueBandPointColorizerPrimitives {
        private BandPointColorizerBase.BandPointColorizerBasePrimitives basePrimitives;

        public CustomValueBandPointColorizerPrimitives() {
            this.basePrimitives = CustomValueBandPointColorizer.this.createBandColorizerBasePrimitives();
        }

        public BandPointColorizerBase.BandPointColorizerBasePrimitives getBasePrimitives() {
            return this.basePrimitives;
        }
    }
}
