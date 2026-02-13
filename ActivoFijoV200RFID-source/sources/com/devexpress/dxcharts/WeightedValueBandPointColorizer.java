package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BandPointColorizerBase;

/* loaded from: classes.dex */
public class WeightedValueBandPointColorizer extends BandPointColorizerBase implements WeightedPointColorizer {
    WeightedValueColorizerPrimitives createPrimitives() {
        return new WeightedValueColorizerPrimitives();
    }

    class WeightedValueColorizerPrimitives {
        private BandPointColorizerBase.BandPointColorizerBasePrimitives basePrimitives;

        public WeightedValueColorizerPrimitives() {
            this.basePrimitives = WeightedValueBandPointColorizer.this.createBandColorizerBasePrimitives();
        }

        public BandPointColorizerBase.BandPointColorizerBasePrimitives getBasePrimitives() {
            return this.basePrimitives;
        }
    }
}
