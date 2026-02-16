package com.devexpress.dxlistview.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DragDropManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/devexpress/dxlistview/core/MotionDirection;", "", "(Ljava/lang/String;I)V", "None", "LeftToRight", "RightToLeft", "TopToBottom", "BottomToTop", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MotionDirection[] $VALUES;
    public static final MotionDirection None = new MotionDirection("None", 0);
    public static final MotionDirection LeftToRight = new MotionDirection("LeftToRight", 1);
    public static final MotionDirection RightToLeft = new MotionDirection("RightToLeft", 2);
    public static final MotionDirection TopToBottom = new MotionDirection("TopToBottom", 3);
    public static final MotionDirection BottomToTop = new MotionDirection("BottomToTop", 4);

    private static final /* synthetic */ MotionDirection[] $values() {
        return new MotionDirection[]{None, LeftToRight, RightToLeft, TopToBottom, BottomToTop};
    }

    public static EnumEntries<MotionDirection> getEntries() {
        return $ENTRIES;
    }

    public static MotionDirection valueOf(String str) {
        return (MotionDirection) Enum.valueOf(MotionDirection.class, str);
    }

    public static MotionDirection[] values() {
        return (MotionDirection[]) $VALUES.clone();
    }

    private MotionDirection(String str, int i) {
    }

    static {
        MotionDirection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
