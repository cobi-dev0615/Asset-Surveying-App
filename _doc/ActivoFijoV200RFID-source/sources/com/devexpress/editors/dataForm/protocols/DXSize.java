package com.devexpress.editors.dataForm.protocols;

import com.devexpress.editors.layout.SizeDefinition;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* compiled from: DXSize.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DXSize;", "", "size", "", "minSize", "", "maxSize", "isStar", "", "isAuto", "(FIIZZ)V", "()Z", "getMaxSize", "()I", "getMinSize", "getSize", "()F", "setSize", "(F)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toSizeDefinition", "Lcom/devexpress/editors/layout/SizeDefinition;", "toString", "", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DXSize {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isAuto;
    private final boolean isStar;
    private final int maxSize;
    private final int minSize;
    private float size;

    public DXSize() {
        this(0.0f, 0, 0, false, false, 31, null);
    }

    public static /* synthetic */ DXSize copy$default(DXSize dXSize, float f, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f = dXSize.size;
        }
        if ((i3 & 2) != 0) {
            i = dXSize.minSize;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = dXSize.maxSize;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            z = dXSize.isStar;
        }
        boolean z3 = z;
        if ((i3 & 16) != 0) {
            z2 = dXSize.isAuto;
        }
        return dXSize.copy(f, i4, i5, z3, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getSize() {
        return this.size;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinSize() {
        return this.minSize;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxSize() {
        return this.maxSize;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsStar() {
        return this.isStar;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsAuto() {
        return this.isAuto;
    }

    public final DXSize copy(float size, int minSize, int maxSize, boolean isStar, boolean isAuto) {
        return new DXSize(size, minSize, maxSize, isStar, isAuto);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DXSize)) {
            return false;
        }
        DXSize dXSize = (DXSize) other;
        return Float.compare(this.size, dXSize.size) == 0 && this.minSize == dXSize.minSize && this.maxSize == dXSize.maxSize && this.isStar == dXSize.isStar && this.isAuto == dXSize.isAuto;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.size) * 31) + this.minSize) * 31) + this.maxSize) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isStar)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isAuto);
    }

    public String toString() {
        return "DXSize(size=" + this.size + ", minSize=" + this.minSize + ", maxSize=" + this.maxSize + ", isStar=" + this.isStar + ", isAuto=" + this.isAuto + ')';
    }

    public DXSize(float f, int i, int i2, boolean z, boolean z2) {
        this.size = f;
        this.minSize = i;
        this.maxSize = i2;
        this.isStar = z;
        this.isAuto = z2;
    }

    public /* synthetic */ DXSize(float f, int i, int i2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0f : f, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? Integer.MAX_VALUE : i2, (i3 & 8) != 0 ? false : z, (i3 & 16) == 0 ? z2 : false);
    }

    public final float getSize() {
        return this.size;
    }

    public final void setSize(float f) {
        this.size = f;
    }

    public final int getMinSize() {
        return this.minSize;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final boolean isStar() {
        return this.isStar;
    }

    public final boolean isAuto() {
        return this.isAuto;
    }

    /* compiled from: DXSize.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/DXSize$Companion;", "", "()V", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "Lcom/devexpress/editors/dataForm/protocols/DXSize;", "fixed", "size", "", "star", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DXSize auto() {
            return new DXSize(0.0f, 0, 0, false, true, 15, null);
        }

        public final DXSize star() {
            return new DXSize(1.0f, 0, 0, true, false, 22, null);
        }

        public final DXSize star(float size) {
            return new DXSize(size, 0, 0, true, false, 22, null);
        }

        public final DXSize fixed(int size) {
            return new DXSize(size, 0, 0, false, false, 30, null);
        }
    }

    public final SizeDefinition toSizeDefinition() {
        int i;
        if (this.isStar) {
            i = 2;
        } else {
            i = this.isAuto ? 1 : 0;
        }
        int i2 = this.maxSize;
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        return new SizeDefinition(this.size, this.minSize, i2, i);
    }
}
