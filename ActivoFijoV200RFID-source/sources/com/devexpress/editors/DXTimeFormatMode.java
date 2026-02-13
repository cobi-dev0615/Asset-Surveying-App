package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXTimeFormatMode.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/DXTimeFormatMode;", "", "(Ljava/lang/String;I)V", "Auto", "H12", "H24", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXTimeFormatMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXTimeFormatMode[] $VALUES;
    public static final DXTimeFormatMode Auto = new DXTimeFormatMode("Auto", 0);
    public static final DXTimeFormatMode H12 = new DXTimeFormatMode("H12", 1);
    public static final DXTimeFormatMode H24 = new DXTimeFormatMode("H24", 2);

    private static final /* synthetic */ DXTimeFormatMode[] $values() {
        return new DXTimeFormatMode[]{Auto, H12, H24};
    }

    public static EnumEntries<DXTimeFormatMode> getEntries() {
        return $ENTRIES;
    }

    public static DXTimeFormatMode valueOf(String str) {
        return (DXTimeFormatMode) Enum.valueOf(DXTimeFormatMode.class, str);
    }

    public static DXTimeFormatMode[] values() {
        return (DXTimeFormatMode[]) $VALUES.clone();
    }

    private DXTimeFormatMode(String str, int i) {
    }

    static {
        DXTimeFormatMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
