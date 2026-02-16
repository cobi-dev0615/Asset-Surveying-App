package com.devexpress.dxgrid.utils.providers;

import com.devexpress.dxgrid.models.SwipeButtonModel;

/* loaded from: classes2.dex */
public interface SwipeProvider {
    boolean getAllowEndFullSwipe();

    boolean getAllowStartFullSwipe();

    SwipeButtonModel[] getLeftSwipeButtons();

    SwipeButtonModel[] getRightSwipeButtons();

    boolean getSwipeEnabled();
}
