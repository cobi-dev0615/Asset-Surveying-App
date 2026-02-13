package com.devexpress.dxcharts;

import com.devexpress.dxcharts.AxisLabelResolveOverlappingOptions;

/* loaded from: classes.dex */
public class AxisLabel extends AxisLabelBase {
    static final double DEFAULT_ANGLE = 0.0d;
    static final String DEFAULT_FORMAT = null;
    static final AxisLabelPosition DEFAULT_POSITION = AxisLabelPosition.OUTSIDE;
    static final boolean DEFAULT_VISIBILITY = true;
    private String mTextFormat = DEFAULT_FORMAT;
    private AxisLabelPosition mPosition = DEFAULT_POSITION;
    private AxisLabelResolveOverlappingOptions mResolveOverlappingOptions = null;
    private boolean staggered = false;
    private double angle = 0.0d;

    enum Property {
        FORMAT,
        POSITION,
        RESOLVE_OVERLAPPING_OPTIONS,
        STAGGERED,
        ANGLE
    }

    @Override // com.devexpress.dxcharts.StyledElement, com.devexpress.dxcharts.ChartElement
    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        super.onChartElementPropertyChanged(obj, propertyChangedArgs);
        if (obj instanceof AxisLabelResolveOverlappingOptions) {
            notifyListeners(obj, propertyChangedArgs.getProperty());
        } else if (obj instanceof AxisLabelStyle) {
            notifyListeners(obj, propertyChangedArgs.getProperty());
        }
    }

    public String getTextFormat() {
        return this.mTextFormat;
    }

    public void setTextFormat(String str) {
        if (CompareHelper.areNotEquals(this.mTextFormat, str)) {
            this.mTextFormat = str;
            notifyListeners(Property.FORMAT);
        }
    }

    public AxisLabelPosition getPosition() {
        return this.mPosition;
    }

    public void setPosition(AxisLabelPosition axisLabelPosition) {
        if (axisLabelPosition == null || this.mPosition == axisLabelPosition) {
            return;
        }
        this.mPosition = axisLabelPosition;
        notifyListeners(Property.POSITION);
    }

    public AxisLabelResolveOverlappingOptions getResolveOverlappingOptions() {
        return this.mResolveOverlappingOptions;
    }

    public void setResolveOverlappingOptions(AxisLabelResolveOverlappingOptions axisLabelResolveOverlappingOptions) {
        AxisLabelResolveOverlappingOptions axisLabelResolveOverlappingOptions2 = this.mResolveOverlappingOptions;
        if (axisLabelResolveOverlappingOptions2 != axisLabelResolveOverlappingOptions) {
            if (axisLabelResolveOverlappingOptions2 != null) {
                axisLabelResolveOverlappingOptions2.removeListener(getSelfListener());
            }
            this.mResolveOverlappingOptions = axisLabelResolveOverlappingOptions;
            if (axisLabelResolveOverlappingOptions != null) {
                axisLabelResolveOverlappingOptions.addListener(getSelfListener());
            }
            for (AxisLabelResolveOverlappingOptions.Property property : AxisLabelResolveOverlappingOptions.Property.values()) {
                notifyListeners(property);
            }
        }
    }

    public boolean isStaggered() {
        return this.staggered;
    }

    public void setStaggered(boolean z) {
        if (this.staggered != z) {
            this.staggered = z;
            notifyListeners(Property.STAGGERED);
        }
    }

    public double getAngle() {
        return this.angle;
    }

    public void setAngle(double d) {
        if (this.angle != d) {
            this.angle = d;
            notifyListeners(Property.ANGLE);
        }
    }
}
