package com.devexpress.editors.dropdown;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DropdownTypes.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/devexpress/editors/dropdown/DXDropdownHorizontalAlignment;", "", "(Ljava/lang/String;I)V", "Default", "Left", "Center", "Right", "Stretch", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXDropdownHorizontalAlignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXDropdownHorizontalAlignment[] $VALUES;
    public static final DXDropdownHorizontalAlignment Default = new DXDropdownHorizontalAlignment("Default", 0);
    public static final DXDropdownHorizontalAlignment Left = new DXDropdownHorizontalAlignment("Left", 1);
    public static final DXDropdownHorizontalAlignment Center = new DXDropdownHorizontalAlignment("Center", 2);
    public static final DXDropdownHorizontalAlignment Right = new DXDropdownHorizontalAlignment("Right", 3);
    public static final DXDropdownHorizontalAlignment Stretch = new DXDropdownHorizontalAlignment("Stretch", 4);

    private static final /* synthetic */ DXDropdownHorizontalAlignment[] $values() {
        return new DXDropdownHorizontalAlignment[]{Default, Left, Center, Right, Stretch};
    }

    public static EnumEntries<DXDropdownHorizontalAlignment> getEntries() {
        return $ENTRIES;
    }

    public static DXDropdownHorizontalAlignment valueOf(String str) {
        return (DXDropdownHorizontalAlignment) Enum.valueOf(DXDropdownHorizontalAlignment.class, str);
    }

    public static DXDropdownHorizontalAlignment[] values() {
        return (DXDropdownHorizontalAlignment[]) $VALUES.clone();
    }

    private DXDropdownHorizontalAlignment(String str, int i) {
    }

    static {
        DXDropdownHorizontalAlignment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
