package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HitTestType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/devexpress/editors/HitTestType;", "", "(Ljava/lang/String;I)V", "None", "BoxEmptySpace", "TextInput", "LeadingIcons", "TrailingIcons", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HitTestType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HitTestType[] $VALUES;
    public static final HitTestType None = new HitTestType("None", 0);
    public static final HitTestType BoxEmptySpace = new HitTestType("BoxEmptySpace", 1);
    public static final HitTestType TextInput = new HitTestType("TextInput", 2);
    public static final HitTestType LeadingIcons = new HitTestType("LeadingIcons", 3);
    public static final HitTestType TrailingIcons = new HitTestType("TrailingIcons", 4);

    private static final /* synthetic */ HitTestType[] $values() {
        return new HitTestType[]{None, BoxEmptySpace, TextInput, LeadingIcons, TrailingIcons};
    }

    public static EnumEntries<HitTestType> getEntries() {
        return $ENTRIES;
    }

    public static HitTestType valueOf(String str) {
        return (HitTestType) Enum.valueOf(HitTestType.class, str);
    }

    public static HitTestType[] values() {
        return (HitTestType[]) $VALUES.clone();
    }

    private HitTestType(String str, int i) {
    }

    static {
        HitTestType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
