package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXSimpleButtonContentAlignment.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/DXSimpleButtonContentAlignment;", "", "(Ljava/lang/String;I)V", "Start", "Center", "End", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXSimpleButtonContentAlignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXSimpleButtonContentAlignment[] $VALUES;
    public static final DXSimpleButtonContentAlignment Start = new DXSimpleButtonContentAlignment("Start", 0);
    public static final DXSimpleButtonContentAlignment Center = new DXSimpleButtonContentAlignment("Center", 1);
    public static final DXSimpleButtonContentAlignment End = new DXSimpleButtonContentAlignment("End", 2);

    private static final /* synthetic */ DXSimpleButtonContentAlignment[] $values() {
        return new DXSimpleButtonContentAlignment[]{Start, Center, End};
    }

    public static EnumEntries<DXSimpleButtonContentAlignment> getEntries() {
        return $ENTRIES;
    }

    public static DXSimpleButtonContentAlignment valueOf(String str) {
        return (DXSimpleButtonContentAlignment) Enum.valueOf(DXSimpleButtonContentAlignment.class, str);
    }

    public static DXSimpleButtonContentAlignment[] values() {
        return (DXSimpleButtonContentAlignment[]) $VALUES.clone();
    }

    private DXSimpleButtonContentAlignment(String str, int i) {
    }

    static {
        DXSimpleButtonContentAlignment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
