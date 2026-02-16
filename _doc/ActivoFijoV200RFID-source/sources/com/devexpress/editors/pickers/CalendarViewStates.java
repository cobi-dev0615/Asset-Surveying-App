package com.devexpress.editors.pickers;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CalendarViewStates.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/pickers/CalendarViewStates;", "", "(Ljava/lang/String;I)V", "STATE_MONTH", "STATE_YEAR", "STATE_DECADE", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CalendarViewStates {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CalendarViewStates[] $VALUES;
    public static final CalendarViewStates STATE_MONTH = new CalendarViewStates("STATE_MONTH", 0);
    public static final CalendarViewStates STATE_YEAR = new CalendarViewStates("STATE_YEAR", 1);
    public static final CalendarViewStates STATE_DECADE = new CalendarViewStates("STATE_DECADE", 2);

    private static final /* synthetic */ CalendarViewStates[] $values() {
        return new CalendarViewStates[]{STATE_MONTH, STATE_YEAR, STATE_DECADE};
    }

    public static EnumEntries<CalendarViewStates> getEntries() {
        return $ENTRIES;
    }

    public static CalendarViewStates valueOf(String str) {
        return (CalendarViewStates) Enum.valueOf(CalendarViewStates.class, str);
    }

    public static CalendarViewStates[] values() {
        return (CalendarViewStates[]) $VALUES.clone();
    }

    private CalendarViewStates(String str, int i) {
    }

    static {
        CalendarViewStates[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
