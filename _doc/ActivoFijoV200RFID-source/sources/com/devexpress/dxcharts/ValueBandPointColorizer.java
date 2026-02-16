package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BandPointColorizerBase;

/* loaded from: classes.dex */
public class ValueBandPointColorizer extends BandPointColorizerBase implements PointColorizer, StackedPointColorizer, WeightedPointColorizer {
    ValueBandPointColorizerPrimitives createPrimitives() {
        return new ValueBandPointColorizerPrimitives();
    }

    class ValueBandPointColorizerPrimitives {
        private BandPointColorizerBase.BandPointColorizerBasePrimitives basePrimitives;

        public ValueBandPointColorizerPrimitives() {
            this.basePrimitives = ValueBandPointColorizer.this.createBandColorizerBasePrimitives();
        }

        public BandPointColorizerBase.BandPointColorizerBasePrimitives getBasePrimitives() {
            return this.basePrimitives;
        }
    }
}
