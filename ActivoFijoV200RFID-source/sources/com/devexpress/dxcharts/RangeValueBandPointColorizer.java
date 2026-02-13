package com.devexpress.dxcharts;

import com.devexpress.dxcharts.BandPointColorizerBase;

/* loaded from: classes.dex */
public class RangeValueBandPointColorizer extends BandPointColorizerBase implements RangePointColorizer {
    private RangeSeriesValueLevel valueLevel = RangeSeriesValueLevel.HIGH;

    public RangeSeriesValueLevel getValueLevel() {
        return this.valueLevel;
    }

    public void setValueLevel(RangeSeriesValueLevel rangeSeriesValueLevel) {
        this.valueLevel = rangeSeriesValueLevel;
    }

    RangeValueBandPointColorizerPrimitives createPrimitives() {
        return new RangeValueBandPointColorizerPrimitives();
    }

    class RangeValueBandPointColorizerPrimitives {
        private BandPointColorizerBase.BandPointColorizerBasePrimitives basePrimitives;

        public RangeValueBandPointColorizerPrimitives() {
            this.basePrimitives = RangeValueBandPointColorizer.this.createBandColorizerBasePrimitives();
        }

        public BandPointColorizerBase.BandPointColorizerBasePrimitives getBasePrimitives() {
            return this.basePrimitives;
        }
    }
}
