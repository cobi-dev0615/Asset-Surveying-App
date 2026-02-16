package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BandPointColorizerBase;

/* loaded from: classes.dex */
public class StackedValueBandPointColorizer extends BandPointColorizerBase implements StackedPointColorizer {
    StackedValueBandPointColorizerPrimitives createPrimitives() {
        return new StackedValueBandPointColorizerPrimitives();
    }

    class StackedValueBandPointColorizerPrimitives {
        private BandPointColorizerBase.BandPointColorizerBasePrimitives basePrimitives;

        public StackedValueBandPointColorizerPrimitives() {
            this.basePrimitives = StackedValueBandPointColorizer.this.createBandColorizerBasePrimitives();
        }

        public BandPointColorizerBase.BandPointColorizerBasePrimitives getBasePrimitives() {
            return this.basePrimitives;
        }
    }
}
