package com.devexpress.dxcharts;

import android.widget.ImageView;

/* loaded from: classes.dex */
public enum PieCenterImageLabelScaleType {
    CENTER(ImageView.ScaleType.CENTER),
    CENTER_INSIDE(ImageView.ScaleType.CENTER_INSIDE),
    FIT_CENTER(ImageView.ScaleType.FIT_CENTER);

    final ImageView.ScaleType value;

    PieCenterImageLabelScaleType(ImageView.ScaleType scaleType) {
        this.value = scaleType;
    }
}
