package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXCheckBoxPosition.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/DXCheckBoxPosition;", "", "(Ljava/lang/String;I)V", "Start", "End", "Top", "Bottom", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXCheckBoxPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXCheckBoxPosition[] $VALUES;
    public static final DXCheckBoxPosition Start = new DXCheckBoxPosition("Start", 0);
    public static final DXCheckBoxPosition End = new DXCheckBoxPosition("End", 1);
    public static final DXCheckBoxPosition Top = new DXCheckBoxPosition("Top", 2);
    public static final DXCheckBoxPosition Bottom = new DXCheckBoxPosition("Bottom", 3);

    private static final /* synthetic */ DXCheckBoxPosition[] $values() {
        return new DXCheckBoxPosition[]{Start, End, Top, Bottom};
    }

    public static EnumEntries<DXCheckBoxPosition> getEntries() {
        return $ENTRIES;
    }

    public static DXCheckBoxPosition valueOf(String str) {
        return (DXCheckBoxPosition) Enum.valueOf(DXCheckBoxPosition.class, str);
    }

    public static DXCheckBoxPosition[] values() {
        return (DXCheckBoxPosition[]) $VALUES.clone();
    }

    private DXCheckBoxPosition(String str, int i) {
    }

    static {
        DXCheckBoxPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
