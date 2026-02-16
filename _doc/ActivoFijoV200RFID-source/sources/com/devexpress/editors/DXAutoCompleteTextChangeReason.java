package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXAutoCompleteTextChangeReason.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/DXAutoCompleteTextChangeReason;", "", "(Ljava/lang/String;I)V", "UserInput", "ItemSelected", "ProgrammaticChange", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXAutoCompleteTextChangeReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXAutoCompleteTextChangeReason[] $VALUES;
    public static final DXAutoCompleteTextChangeReason UserInput = new DXAutoCompleteTextChangeReason("UserInput", 0);
    public static final DXAutoCompleteTextChangeReason ItemSelected = new DXAutoCompleteTextChangeReason("ItemSelected", 1);
    public static final DXAutoCompleteTextChangeReason ProgrammaticChange = new DXAutoCompleteTextChangeReason("ProgrammaticChange", 2);

    private static final /* synthetic */ DXAutoCompleteTextChangeReason[] $values() {
        return new DXAutoCompleteTextChangeReason[]{UserInput, ItemSelected, ProgrammaticChange};
    }

    public static EnumEntries<DXAutoCompleteTextChangeReason> getEntries() {
        return $ENTRIES;
    }

    public static DXAutoCompleteTextChangeReason valueOf(String str) {
        return (DXAutoCompleteTextChangeReason) Enum.valueOf(DXAutoCompleteTextChangeReason.class, str);
    }

    public static DXAutoCompleteTextChangeReason[] values() {
        return (DXAutoCompleteTextChangeReason[]) $VALUES.clone();
    }

    private DXAutoCompleteTextChangeReason(String str, int i) {
    }

    static {
        DXAutoCompleteTextChangeReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
