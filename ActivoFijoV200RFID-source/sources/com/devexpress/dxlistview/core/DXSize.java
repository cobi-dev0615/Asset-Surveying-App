package com.devexpress.dxlistview.core;

/* loaded from: classes2.dex */
public final class DXSize {
    public int height;
    public int width;

    public DXSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void set(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DXSize dXSize = (DXSize) obj;
        return this.width == dXSize.width && this.height == dXSize.height;
    }

    public int hashCode() {
        int i = this.height;
        int i2 = this.width;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
