package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXCheckEditValue.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/DXCheckEditValue;", "", "(Ljava/lang/String;I)V", "Checked", "Unchecked", "Indeterminate", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXCheckEditValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXCheckEditValue[] $VALUES;
    public static final DXCheckEditValue Checked = new DXCheckEditValue("Checked", 0);
    public static final DXCheckEditValue Unchecked = new DXCheckEditValue("Unchecked", 1);
    public static final DXCheckEditValue Indeterminate = new DXCheckEditValue("Indeterminate", 2);

    private static final /* synthetic */ DXCheckEditValue[] $values() {
        return new DXCheckEditValue[]{Checked, Unchecked, Indeterminate};
    }

    public static EnumEntries<DXCheckEditValue> getEntries() {
        return $ENTRIES;
    }

    public static DXCheckEditValue valueOf(String str) {
        return (DXCheckEditValue) Enum.valueOf(DXCheckEditValue.class, str);
    }

    public static DXCheckEditValue[] values() {
        return (DXCheckEditValue[]) $VALUES.clone();
    }

    private DXCheckEditValue(String str, int i) {
    }

    static {
        DXCheckEditValue[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
