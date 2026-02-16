package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXSimpleButtonIconPosition.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/DXSimpleButtonIconPosition;", "", "(Ljava/lang/String;I)V", "Start", "Top", "End", "Bottom", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXSimpleButtonIconPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXSimpleButtonIconPosition[] $VALUES;
    public static final DXSimpleButtonIconPosition Start = new DXSimpleButtonIconPosition("Start", 0);
    public static final DXSimpleButtonIconPosition Top = new DXSimpleButtonIconPosition("Top", 1);
    public static final DXSimpleButtonIconPosition End = new DXSimpleButtonIconPosition("End", 2);
    public static final DXSimpleButtonIconPosition Bottom = new DXSimpleButtonIconPosition("Bottom", 3);

    private static final /* synthetic */ DXSimpleButtonIconPosition[] $values() {
        return new DXSimpleButtonIconPosition[]{Start, Top, End, Bottom};
    }

    public static EnumEntries<DXSimpleButtonIconPosition> getEntries() {
        return $ENTRIES;
    }

    public static DXSimpleButtonIconPosition valueOf(String str) {
        return (DXSimpleButtonIconPosition) Enum.valueOf(DXSimpleButtonIconPosition.class, str);
    }

    public static DXSimpleButtonIconPosition[] values() {
        return (DXSimpleButtonIconPosition[]) $VALUES.clone();
    }

    private DXSimpleButtonIconPosition(String str, int i) {
    }

    static {
        DXSimpleButtonIconPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
