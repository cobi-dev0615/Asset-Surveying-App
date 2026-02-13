package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXCornerMode.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/devexpress/editors/DXCornerMode;", "", "(Ljava/lang/String;I)V", "Round", "Cut", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXCornerMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXCornerMode[] $VALUES;
    public static final DXCornerMode Round = new DXCornerMode("Round", 0);
    public static final DXCornerMode Cut = new DXCornerMode("Cut", 1);

    private static final /* synthetic */ DXCornerMode[] $values() {
        return new DXCornerMode[]{Round, Cut};
    }

    public static EnumEntries<DXCornerMode> getEntries() {
        return $ENTRIES;
    }

    public static DXCornerMode valueOf(String str) {
        return (DXCornerMode) Enum.valueOf(DXCornerMode.class, str);
    }

    public static DXCornerMode[] values() {
        return (DXCornerMode[]) $VALUES.clone();
    }

    private DXCornerMode(String str, int i) {
    }

    static {
        DXCornerMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
