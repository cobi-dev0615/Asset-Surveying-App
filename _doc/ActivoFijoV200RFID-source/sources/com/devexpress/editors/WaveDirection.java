package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ShimmerDrawable.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/WaveDirection;", "", "(Ljava/lang/String;I)V", "LEFT_TO_RIGHT", "TOP_TO_BOTTOM", "RIGHT_TO_LEFT", "BOTTOM_TO_TOP", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WaveDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WaveDirection[] $VALUES;
    public static final WaveDirection LEFT_TO_RIGHT = new WaveDirection("LEFT_TO_RIGHT", 0);
    public static final WaveDirection TOP_TO_BOTTOM = new WaveDirection("TOP_TO_BOTTOM", 1);
    public static final WaveDirection RIGHT_TO_LEFT = new WaveDirection("RIGHT_TO_LEFT", 2);
    public static final WaveDirection BOTTOM_TO_TOP = new WaveDirection("BOTTOM_TO_TOP", 3);

    private static final /* synthetic */ WaveDirection[] $values() {
        return new WaveDirection[]{LEFT_TO_RIGHT, TOP_TO_BOTTOM, RIGHT_TO_LEFT, BOTTOM_TO_TOP};
    }

    public static EnumEntries<WaveDirection> getEntries() {
        return $ENTRIES;
    }

    public static WaveDirection valueOf(String str) {
        return (WaveDirection) Enum.valueOf(WaveDirection.class, str);
    }

    public static WaveDirection[] values() {
        return (WaveDirection[]) $VALUES.clone();
    }

    private WaveDirection(String str, int i) {
    }

    static {
        WaveDirection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
