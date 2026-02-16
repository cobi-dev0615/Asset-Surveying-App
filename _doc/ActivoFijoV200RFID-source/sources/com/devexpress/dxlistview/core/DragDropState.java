package com.devexpress.dxlistview.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DragDropManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/dxlistview/core/DragDropState;", "", "(Ljava/lang/String;I)V", "Unknown", "Dragging", "Dropping", "dxlistview_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DragDropState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DragDropState[] $VALUES;
    public static final DragDropState Unknown = new DragDropState("Unknown", 0);
    public static final DragDropState Dragging = new DragDropState("Dragging", 1);
    public static final DragDropState Dropping = new DragDropState("Dropping", 2);

    private static final /* synthetic */ DragDropState[] $values() {
        return new DragDropState[]{Unknown, Dragging, Dropping};
    }

    public static EnumEntries<DragDropState> getEntries() {
        return $ENTRIES;
    }

    public static DragDropState valueOf(String str) {
        return (DragDropState) Enum.valueOf(DragDropState.class, str);
    }

    public static DragDropState[] values() {
        return (DragDropState[]) $VALUES.clone();
    }

    private DragDropState(String str, int i) {
    }

    static {
        DragDropState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
