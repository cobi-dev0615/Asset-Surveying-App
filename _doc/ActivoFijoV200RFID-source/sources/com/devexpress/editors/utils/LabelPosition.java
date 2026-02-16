package com.devexpress.editors.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BottomTextState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/utils/LabelPosition;", "", "(Ljava/lang/String;I)V", "NONE", "ON_TOP", "DEFAULT", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LabelPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LabelPosition[] $VALUES;
    public static final LabelPosition NONE = new LabelPosition("NONE", 0);
    public static final LabelPosition ON_TOP = new LabelPosition("ON_TOP", 1);
    public static final LabelPosition DEFAULT = new LabelPosition("DEFAULT", 2);

    private static final /* synthetic */ LabelPosition[] $values() {
        return new LabelPosition[]{NONE, ON_TOP, DEFAULT};
    }

    public static EnumEntries<LabelPosition> getEntries() {
        return $ENTRIES;
    }

    public static LabelPosition valueOf(String str) {
        return (LabelPosition) Enum.valueOf(LabelPosition.class, str);
    }

    public static LabelPosition[] values() {
        return (LabelPosition[]) $VALUES.clone();
    }

    private LabelPosition(String str, int i) {
    }

    static {
        LabelPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
