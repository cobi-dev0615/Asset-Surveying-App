package com.devexpress.editors.dropdown;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DropdownTypes.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownVerticalAlignment;", "", "(Ljava/lang/String;I)V", "Default", "Top", "Center", "Bottom", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXDropdownVerticalAlignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXDropdownVerticalAlignment[] $VALUES;
    public static final DXDropdownVerticalAlignment Default = new DXDropdownVerticalAlignment("Default", 0);
    public static final DXDropdownVerticalAlignment Top = new DXDropdownVerticalAlignment("Top", 1);
    public static final DXDropdownVerticalAlignment Center = new DXDropdownVerticalAlignment("Center", 2);
    public static final DXDropdownVerticalAlignment Bottom = new DXDropdownVerticalAlignment("Bottom", 3);

    private static final /* synthetic */ DXDropdownVerticalAlignment[] $values() {
        return new DXDropdownVerticalAlignment[]{Default, Top, Center, Bottom};
    }

    public static EnumEntries<DXDropdownVerticalAlignment> getEntries() {
        return $ENTRIES;
    }

    public static DXDropdownVerticalAlignment valueOf(String str) {
        return (DXDropdownVerticalAlignment) Enum.valueOf(DXDropdownVerticalAlignment.class, str);
    }

    public static DXDropdownVerticalAlignment[] values() {
        return (DXDropdownVerticalAlignment[]) $VALUES.clone();
    }

    private DXDropdownVerticalAlignment(String str, int i) {
    }

    static {
        DXDropdownVerticalAlignment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
