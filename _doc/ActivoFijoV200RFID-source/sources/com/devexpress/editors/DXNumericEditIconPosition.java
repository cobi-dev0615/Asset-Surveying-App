package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXNumericEditIconPosition.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/DXNumericEditIconPosition;", "", "(Ljava/lang/String;I)V", "DownStartUpEnd", "DownEndUpEnd", "DownStartUpStart", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXNumericEditIconPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXNumericEditIconPosition[] $VALUES;
    public static final DXNumericEditIconPosition DownStartUpEnd = new DXNumericEditIconPosition("DownStartUpEnd", 0);
    public static final DXNumericEditIconPosition DownEndUpEnd = new DXNumericEditIconPosition("DownEndUpEnd", 1);
    public static final DXNumericEditIconPosition DownStartUpStart = new DXNumericEditIconPosition("DownStartUpStart", 2);

    private static final /* synthetic */ DXNumericEditIconPosition[] $values() {
        return new DXNumericEditIconPosition[]{DownStartUpEnd, DownEndUpEnd, DownStartUpStart};
    }

    public static EnumEntries<DXNumericEditIconPosition> getEntries() {
        return $ENTRIES;
    }

    public static DXNumericEditIconPosition valueOf(String str) {
        return (DXNumericEditIconPosition) Enum.valueOf(DXNumericEditIconPosition.class, str);
    }

    public static DXNumericEditIconPosition[] values() {
        return (DXNumericEditIconPosition[]) $VALUES.clone();
    }

    private DXNumericEditIconPosition(String str, int i) {
    }

    static {
        DXNumericEditIconPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
