package com.devexpress.editors.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BottomTextState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/utils/BottomTextState;", "", "(Ljava/lang/String;I)V", "NONE", "HELPER", "ERROR", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomTextState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BottomTextState[] $VALUES;
    public static final BottomTextState NONE = new BottomTextState("NONE", 0);
    public static final BottomTextState HELPER = new BottomTextState("HELPER", 1);
    public static final BottomTextState ERROR = new BottomTextState("ERROR", 2);

    private static final /* synthetic */ BottomTextState[] $values() {
        return new BottomTextState[]{NONE, HELPER, ERROR};
    }

    public static EnumEntries<BottomTextState> getEntries() {
        return $ENTRIES;
    }

    public static BottomTextState valueOf(String str) {
        return (BottomTextState) Enum.valueOf(BottomTextState.class, str);
    }

    public static BottomTextState[] values() {
        return (BottomTextState[]) $VALUES.clone();
    }

    private BottomTextState(String str, int i) {
    }

    static {
        BottomTextState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
