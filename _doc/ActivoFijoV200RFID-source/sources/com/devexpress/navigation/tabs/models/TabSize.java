package com.devexpress.navigation.tabs.models;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TabSize.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/devexpress/navigation/tabs/models/TabSize;", "", "()V", "size", "", "minSize", "maxSize", "isStar", "", "isAuto", "(FFFZZ)V", "()Z", "getMaxSize", "()F", "getMinSize", "getSize", "setSize", "(F)V", "Companion", "dxnavigation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TabSize {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isAuto;
    private final boolean isStar;
    private final float maxSize;
    private final float minSize;
    private float size;

    @JvmStatic
    public static final TabSize Auto() {
        return INSTANCE.Auto();
    }

    @JvmStatic
    public static final TabSize Auto(float f, float f2) {
        return INSTANCE.Auto(f, f2);
    }

    @JvmStatic
    public static final TabSize Fixed(float f) {
        return INSTANCE.Fixed(f);
    }

    @JvmStatic
    public static final TabSize Fixed(float f, float f2, float f3) {
        return INSTANCE.Fixed(f, f2, f3);
    }

    @JvmStatic
    public static final TabSize Star() {
        return INSTANCE.Star();
    }

    @JvmStatic
    public static final TabSize Star(float f) {
        return INSTANCE.Star(f);
    }

    @JvmStatic
    public static final TabSize Star(float f, float f2) {
        return INSTANCE.Star(f, f2);
    }

    @JvmStatic
    public static final TabSize Star(float f, float f2, float f3) {
        return INSTANCE.Star(f, f2, f3);
    }

    @JvmStatic
    public static final TabSize createDefaultHorizontalTabSize() {
        return INSTANCE.createDefaultHorizontalTabSize();
    }

    @JvmStatic
    public static final TabSize createDefaultVerticalTabSize() {
        return INSTANCE.createDefaultVerticalTabSize();
    }

    public TabSize(float f, float f2, float f3, boolean z, boolean z2) {
        this.size = f;
        this.minSize = f2;
        this.maxSize = f3;
        this.isStar = z;
        this.isAuto = z2;
    }

    public final float getSize() {
        return this.size;
    }

    public final void setSize(float f) {
        this.size = f;
    }

    public final float getMinSize() {
        return this.minSize;
    }

    public final float getMaxSize() {
        return this.maxSize;
    }

    /* renamed from: isStar, reason: from getter */
    public final boolean getIsStar() {
        return this.isStar;
    }

    /* renamed from: isAuto, reason: from getter */
    public final boolean getIsAuto() {
        return this.isAuto;
    }

    public TabSize() {
        this(1.0f, 48.0f, 72.0f, true, false);
    }

    /* compiled from: TabSize.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007¨\u0006\r"}, d2 = {"Lcom/devexpress/navigation/tabs/models/TabSize$Companion;", "", "()V", "Auto", "Lcom/devexpress/navigation/tabs/models/TabSize;", "minSize", "", "maxSize", "Fixed", "size", "Star", "createDefaultHorizontalTabSize", "createDefaultVerticalTabSize", "dxnavigation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TabSize Auto() {
            return new TabSize(0.0f, 0.0f, 0.0f, false, true);
        }

        @JvmStatic
        public final TabSize Auto(float minSize, float maxSize) {
            return new TabSize(0.0f, minSize, maxSize, false, true);
        }

        @JvmStatic
        public final TabSize Star() {
            return new TabSize(1.0f, 0.0f, 0.0f, true, false);
        }

        @JvmStatic
        public final TabSize Star(float size) {
            return new TabSize(size, 0.0f, 0.0f, true, false);
        }

        @JvmStatic
        public final TabSize Star(float minSize, float maxSize) {
            return new TabSize(1.0f, minSize, maxSize, true, false);
        }

        @JvmStatic
        public final TabSize Star(float size, float minSize, float maxSize) {
            return new TabSize(size, minSize, maxSize, true, false);
        }

        @JvmStatic
        public final TabSize Fixed(float size) {
            return new TabSize(size, 0.0f, 0.0f, false, false);
        }

        @JvmStatic
        public final TabSize Fixed(float size, float minSize, float maxSize) {
            return new TabSize(size, minSize, maxSize, false, false);
        }

        @JvmStatic
        public final TabSize createDefaultHorizontalTabSize() {
            return new TabSize(1.0f, 90.0f, 360.0f, true, false);
        }

        @JvmStatic
        public final TabSize createDefaultVerticalTabSize() {
            return new TabSize(1.0f, 0.0f, 0.0f, false, true);
        }
    }
}
