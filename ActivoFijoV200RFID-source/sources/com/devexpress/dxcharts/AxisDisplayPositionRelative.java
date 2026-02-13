package com.devexpress.dxcharts;

import java.util.Date;

/* loaded from: classes.dex */
public class AxisDisplayPositionRelative extends AxisDisplayPositionBase {
    private Date dateTimePosition;
    private double numericPosition;
    private String qualitativePosition;
    private AxisBase relativeAxis;

    public double getNumericPosition() {
        return this.numericPosition;
    }

    public void setNumericPosition(double d) {
        this.numericPosition = d;
    }

    public Date getDateTimePosition() {
        return this.dateTimePosition;
    }

    public void setDateTimePosition(Date date) {
        this.dateTimePosition = date;
    }

    public String getQualitativePosition() {
        return this.qualitativePosition;
    }

    public void setQualitativePosition(String str) {
        this.qualitativePosition = str;
    }

    public AxisBase getRelativeAxis() {
        return this.relativeAxis;
    }

    public void setRelativeAxis(AxisBase axisBase) {
        this.relativeAxis = axisBase;
    }
}
