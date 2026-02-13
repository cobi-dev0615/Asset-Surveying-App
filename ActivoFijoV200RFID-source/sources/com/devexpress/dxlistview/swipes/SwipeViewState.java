package com.devexpress.dxlistview.swipes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SwipeViewManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/devexpress/dxlistview/swipes/SwipeViewState;", "", "(Ljava/lang/String;I)V", "Cancelled", "Opening", "Opened", "Closing", "Closed", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SwipeViewState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SwipeViewState[] $VALUES;
    public static final SwipeViewState Cancelled = new SwipeViewState("Cancelled", 0);
    public static final SwipeViewState Opening = new SwipeViewState("Opening", 1);
    public static final SwipeViewState Opened = new SwipeViewState("Opened", 2);
    public static final SwipeViewState Closing = new SwipeViewState("Closing", 3);
    public static final SwipeViewState Closed = new SwipeViewState("Closed", 4);

    private static final /* synthetic */ SwipeViewState[] $values() {
        return new SwipeViewState[]{Cancelled, Opening, Opened, Closing, Closed};
    }

    public static EnumEntries<SwipeViewState> getEntries() {
        return $ENTRIES;
    }

    public static SwipeViewState valueOf(String str) {
        return (SwipeViewState) Enum.valueOf(SwipeViewState.class, str);
    }

    public static SwipeViewState[] values() {
        return (SwipeViewState[]) $VALUES.clone();
    }

    private SwipeViewState(String str, int i) {
    }

    static {
        SwipeViewState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
