package com.devexpress.dxlistview.swipes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SwipeViewManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeViewPreviousState;", "", "(Ljava/lang/String;I)V", "Unknown", "Opened", "Closed", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SwipeViewPreviousState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SwipeViewPreviousState[] $VALUES;
    public static final SwipeViewPreviousState Unknown = new SwipeViewPreviousState("Unknown", 0);
    public static final SwipeViewPreviousState Opened = new SwipeViewPreviousState("Opened", 1);
    public static final SwipeViewPreviousState Closed = new SwipeViewPreviousState("Closed", 2);

    private static final /* synthetic */ SwipeViewPreviousState[] $values() {
        return new SwipeViewPreviousState[]{Unknown, Opened, Closed};
    }

    public static EnumEntries<SwipeViewPreviousState> getEntries() {
        return $ENTRIES;
    }

    public static SwipeViewPreviousState valueOf(String str) {
        return (SwipeViewPreviousState) Enum.valueOf(SwipeViewPreviousState.class, str);
    }

    public static SwipeViewPreviousState[] values() {
        return (SwipeViewPreviousState[]) $VALUES.clone();
    }

    private SwipeViewPreviousState(String str, int i) {
    }

    static {
        SwipeViewPreviousState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
