package com.devexpress.editors.layout;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: SizeDefinition.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J1\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0000J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003J\u0012\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010(\u001a\u00020)H\u0016J\u000e\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0005R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/devexpress/editors/layout/SizeDefinition;", "", "value", "", "minSize", "", "maxSize", "unit", "(FIII)V", "isAuto", "", "()Z", "isStar", "getMaxSize", "()I", "setMaxSize", "(I)V", "getMinSize", "setMinSize", "getUnit", "setUnit", "getValue", "()F", "setValue", "(F)V", "assign", "", "layoutDimension", "component1", "component2", "component3", "component4", "copy", "equals", "other", TypedValues.TransitionType.S_FROM, "hashCode", "toAuto", "toFixed", "toStar", "toString", "", "validate", "size", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SizeDefinition {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int UNIT_AUTO = 1;
    public static final int UNIT_FIXED = 0;
    public static final int UNIT_STAR = 2;
    private int maxSize;
    private int minSize;
    private int unit;
    private float value;

    public SizeDefinition() {
        this(0.0f, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ SizeDefinition copy$default(SizeDefinition sizeDefinition, float f, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f = sizeDefinition.value;
        }
        if ((i4 & 2) != 0) {
            i = sizeDefinition.minSize;
        }
        if ((i4 & 4) != 0) {
            i2 = sizeDefinition.maxSize;
        }
        if ((i4 & 8) != 0) {
            i3 = sizeDefinition.unit;
        }
        return sizeDefinition.copy(f, i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getValue() {
        return this.value;
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
    public final int getUnit() {
        return this.unit;
    }

    public final SizeDefinition copy(float value, int minSize, int maxSize, int unit) {
        return new SizeDefinition(value, minSize, maxSize, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeDefinition)) {
            return false;
        }
        SizeDefinition sizeDefinition = (SizeDefinition) other;
        return Float.compare(this.value, sizeDefinition.value) == 0 && this.minSize == sizeDefinition.minSize && this.maxSize == sizeDefinition.maxSize && this.unit == sizeDefinition.unit;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.value) * 31) + this.minSize) * 31) + this.maxSize) * 31) + this.unit;
    }

    public final void toStar() {
        toStar$default(this, 0.0f, 1, null);
    }

    public SizeDefinition(float f, int i, int i2, int i3) {
        this.value = f;
        this.minSize = i;
        this.maxSize = i2;
        this.unit = i3;
    }

    public /* synthetic */ SizeDefinition(float f, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1.0f : f, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? Integer.MAX_VALUE : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    public final int getMinSize() {
        return this.minSize;
    }

    public final void setMinSize(int i) {
        this.minSize = i;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final void setMaxSize(int i) {
        this.maxSize = i;
    }

    /* compiled from: SizeDefinition.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/devexpress/editors/layout/SizeDefinition$Companion;", "", "()V", "UNIT_AUTO", "", "UNIT_FIXED", "UNIT_STAR", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "Lcom/devexpress/editors/layout/SizeDefinition;", "getAuto", "()Lcom/devexpress/editors/layout/SizeDefinition;", "star", "getStar", "fixed", "size", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SizeDefinition getAuto() {
            return new SizeDefinition(0.0f, 0, 0, 1, 7, null);
        }

        public final SizeDefinition getStar() {
            return new SizeDefinition(0.0f, 0, 0, 2, 7, null);
        }

        public final SizeDefinition star(float size) {
            return new SizeDefinition(size, 0, 0, 2, 6, null);
        }

        public final SizeDefinition fixed(float size) {
            return new SizeDefinition(size, 0, 0, 0, 6, null);
        }
    }

    public final int getUnit() {
        return this.unit;
    }

    public final void setUnit(int i) {
        this.unit = i;
    }

    public final boolean isStar() {
        return this.unit == 2;
    }

    public final boolean isAuto() {
        return this.unit == 1;
    }

    public final void assign(int layoutDimension) {
        if (layoutDimension >= 0) {
            this.unit = 2;
            this.value = 1.0f;
        } else if (layoutDimension == -1) {
            this.unit = 2;
            this.value = 1.0f;
        } else if (layoutDimension == -2) {
            this.unit = 1;
            this.value = 1.0f;
        }
    }

    public final void toFixed(float value) {
        this.unit = 0;
        this.value = value;
    }

    public final void toAuto() {
        this.unit = 1;
        this.value = 1.0f;
    }

    public final boolean validate(int size) {
        return size >= this.minSize && size <= this.maxSize;
    }

    public static /* synthetic */ void toStar$default(SizeDefinition sizeDefinition, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        sizeDefinition.toStar(f);
    }

    public final void toStar(float value) {
        this.unit = 2;
        this.value = value;
    }

    public final void from(SizeDefinition other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.value = other.value;
        this.unit = other.unit;
        this.minSize = other.minSize;
        this.maxSize = other.maxSize;
    }

    public String toString() {
        String str;
        int i = this.unit;
        if (i == 0) {
            str = "FIXED";
        } else if (i == 1) {
            str = "AUTO";
        } else if (i == 2) {
            str = "STAR";
        } else {
            str = "Undefined";
        }
        return "{ value = '" + this.value + "', unit = '" + str + "', minSize = '" + this.minSize + "', maxSize = '" + this.maxSize + "' }";
    }
}
