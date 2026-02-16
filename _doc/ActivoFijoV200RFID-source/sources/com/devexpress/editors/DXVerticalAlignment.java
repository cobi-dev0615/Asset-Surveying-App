package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXVerticalAlignment.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/DXVerticalAlignment;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Center", "Top", "Bottom", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXVerticalAlignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXVerticalAlignment[] $VALUES;
    private final int value;
    public static final DXVerticalAlignment Center = new DXVerticalAlignment("Center", 0, 17);
    public static final DXVerticalAlignment Top = new DXVerticalAlignment("Top", 1, 49);
    public static final DXVerticalAlignment Bottom = new DXVerticalAlignment("Bottom", 2, 81);

    private static final /* synthetic */ DXVerticalAlignment[] $values() {
        return new DXVerticalAlignment[]{Center, Top, Bottom};
    }

    public static EnumEntries<DXVerticalAlignment> getEntries() {
        return $ENTRIES;
    }

    public static DXVerticalAlignment valueOf(String str) {
        return (DXVerticalAlignment) Enum.valueOf(DXVerticalAlignment.class, str);
    }

    public static DXVerticalAlignment[] values() {
        return (DXVerticalAlignment[]) $VALUES.clone();
    }

    private DXVerticalAlignment(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        DXVerticalAlignment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
