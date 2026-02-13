package com.devexpress.dxgrid;

import kotlin.Metadata;

/* compiled from: DXGridViewScrolledEventArgs.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JV\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u0011\u0010\u001f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u0010R\u0011\u0010!\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010¨\u0006%"}, d2 = {"Lcom/devexpress/dxgrid/DXGridViewScrolledEventArgs;", "", "()V", "_deltaX", "", "_deltaY", "_extentHeight", "_extentWidth", "_firstVisibleRowIndex", "_lastVisibleRowIndex", "_offsetX", "_offsetY", "_viewportHeight", "_viewportWidth", "deltaX", "getDeltaX", "()I", "deltaY", "getDeltaY", "extentHeight", "getExtentHeight", "extentWidth", "getExtentWidth", "firstVisibleRowIndex", "getFirstVisibleRowIndex", "lastVisibleRowIndex", "getLastVisibleRowIndex", "offsetX", "getOffsetX", "offsetY", "getOffsetY", "viewportHeight", "getViewportHeight", "viewportWidth", "getViewportWidth", "set", "", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DXGridViewScrolledEventArgs {
    private int _deltaX;
    private int _deltaY;
    private int _extentHeight;
    private int _extentWidth;
    private int _firstVisibleRowIndex;
    private int _lastVisibleRowIndex;
    private int _offsetX;
    private int _offsetY;
    private int _viewportHeight;
    private int _viewportWidth;

    public final void set(int deltaX, int deltaY, int offsetX, int offsetY, int firstVisibleRowIndex, int lastVisibleRowIndex, int viewportWidth, int viewportHeight, int extentWidth, int extentHeight) {
        this._deltaX = deltaX;
        this._deltaY = deltaY;
        this._offsetX = offsetX;
        this._offsetY = offsetY;
        this._firstVisibleRowIndex = firstVisibleRowIndex;
        this._lastVisibleRowIndex = lastVisibleRowIndex;
        this._viewportWidth = viewportWidth;
        this._viewportHeight = viewportHeight;
        this._extentWidth = extentWidth;
        this._extentHeight = extentHeight;
    }

    /* renamed from: getDeltaX, reason: from getter */
    public final int get_deltaX() {
        return this._deltaX;
    }

    /* renamed from: getDeltaY, reason: from getter */
    public final int get_deltaY() {
        return this._deltaY;
    }

    /* renamed from: getOffsetX, reason: from getter */
    public final int get_offsetX() {
        return this._offsetX;
    }

    /* renamed from: getOffsetY, reason: from getter */
    public final int get_offsetY() {
        return this._offsetY;
    }

    /* renamed from: getFirstVisibleRowIndex, reason: from getter */
    public final int get_firstVisibleRowIndex() {
        return this._firstVisibleRowIndex;
    }

    /* renamed from: getLastVisibleRowIndex, reason: from getter */
    public final int get_lastVisibleRowIndex() {
        return this._lastVisibleRowIndex;
    }

    /* renamed from: getViewportWidth, reason: from getter */
    public final int get_viewportWidth() {
        return this._viewportWidth;
    }

    /* renamed from: getViewportHeight, reason: from getter */
    public final int get_viewportHeight() {
        return this._viewportHeight;
    }

    /* renamed from: getExtentWidth, reason: from getter */
    public final int get_extentWidth() {
        return this._extentWidth;
    }

    /* renamed from: getExtentHeight, reason: from getter */
    public final int get_extentHeight() {
        return this._extentHeight;
    }
}
