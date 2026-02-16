package com.devexpress.dxgrid.models;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* compiled from: GridLength.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/devexpress/dxgrid/models/GridLength;", "", "value", "", "minWidth", "", "maxWidth", "star", "", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "(DIIZZ)V", "getAuto", "()Z", "setAuto", "(Z)V", "getMaxWidth", "()I", "getMinWidth", "getStar", "setStar", "getValue", "()D", "setValue", "(D)V", "dxgrid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GridLength {
    private boolean auto;
    private final int maxWidth;
    private final int minWidth;
    private boolean star;
    private double value;

    public GridLength() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, 0, 0, false, false, 31, null);
    }

    public GridLength(double d) {
        this(d, 0, 0, false, false, 30, null);
    }

    public GridLength(double d, int i) {
        this(d, i, 0, false, false, 28, null);
    }

    public GridLength(double d, int i, int i2) {
        this(d, i, i2, false, false, 24, null);
    }

    public GridLength(double d, int i, int i2, boolean z) {
        this(d, i, i2, z, false, 16, null);
    }

    public GridLength(double d, int i, int i2, boolean z, boolean z2) {
        this.value = d;
        this.minWidth = i;
        this.maxWidth = i2;
        this.star = z;
        this.auto = z2;
    }

    public /* synthetic */ GridLength(double d, int i, int i2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0d : d, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? false : z2);
    }

    public final double getValue() {
        return this.value;
    }

    public final void setValue(double d) {
        this.value = d;
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    public final boolean getStar() {
        return this.star;
    }

    public final void setStar(boolean z) {
        this.star = z;
    }

    public final boolean getAuto() {
        return this.auto;
    }

    public final void setAuto(boolean z) {
        this.auto = z;
    }
}
