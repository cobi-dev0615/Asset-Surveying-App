package com.devexpress.dxcharts;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class BandPointColorizerBase extends ChartElement {
    private ArrayList<ColorStop> colorStopValues = new ArrayList<>();

    enum Property {
        COLOR_STOP_VALUES
    }

    class BandPointColorizerBasePrimitives {
        private int[] colors;
        private double[] values1;
        private double[] values2;

        public BandPointColorizerBasePrimitives(ArrayList<ColorStop> arrayList) {
            this.colors = new int[arrayList.size()];
            this.values1 = new double[arrayList.size()];
            this.values2 = new double[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.colors[i] = arrayList.get(i).getColor();
                this.values1[i] = arrayList.get(i).getValue1();
                this.values2[i] = arrayList.get(i).getValue2();
            }
        }

        public int[] getColors() {
            return this.colors;
        }

        public double[] getValues1() {
            return this.values1;
        }

        public double[] getValues2() {
            return this.values2;
        }
    }

    public void addColorStop(ColorStop colorStop) {
        this.colorStopValues.add(colorStop);
        notifyListeners(Property.COLOR_STOP_VALUES);
    }

    public void removeColorStop(ColorStop colorStop) {
        this.colorStopValues.remove(colorStop);
        notifyListeners(Property.COLOR_STOP_VALUES);
    }

    public void removeAll() {
        this.colorStopValues.clear();
        notifyListeners(Property.COLOR_STOP_VALUES);
    }

    ColorStop[] getColorStops() {
        return (ColorStop[]) Arrays.copyOf(this.colorStopValues.toArray(), this.colorStopValues.size(), ColorStop[].class);
    }

    BandPointColorizerBasePrimitives createBandColorizerBasePrimitives() {
        return new BandPointColorizerBasePrimitives(this.colorStopValues);
    }
}
