package com.devexpress.editors.dataForm.protocols;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: EditorType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/EditorType;", "", "(Ljava/lang/String;I)V", "Text", "MultilineText", "Numeric", "Percent", "Currency", "Mask", ExifInterface.TAG_DATETIME, "Date", "Time", "Segment", "Switch", "Checkbox", "Picker", "AutoComplete", "Password", TypedValues.Custom.NAME, "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EditorType[] $VALUES;
    public static final EditorType Text = new EditorType("Text", 0);
    public static final EditorType MultilineText = new EditorType("MultilineText", 1);
    public static final EditorType Numeric = new EditorType("Numeric", 2);
    public static final EditorType Percent = new EditorType("Percent", 3);
    public static final EditorType Currency = new EditorType("Currency", 4);
    public static final EditorType Mask = new EditorType("Mask", 5);
    public static final EditorType DateTime = new EditorType(ExifInterface.TAG_DATETIME, 6);
    public static final EditorType Date = new EditorType("Date", 7);
    public static final EditorType Time = new EditorType("Time", 8);
    public static final EditorType Segment = new EditorType("Segment", 9);
    public static final EditorType Switch = new EditorType("Switch", 10);
    public static final EditorType Checkbox = new EditorType("Checkbox", 11);
    public static final EditorType Picker = new EditorType("Picker", 12);
    public static final EditorType AutoComplete = new EditorType("AutoComplete", 13);
    public static final EditorType Password = new EditorType("Password", 14);
    public static final EditorType Custom = new EditorType(TypedValues.Custom.NAME, 15);

    private static final /* synthetic */ EditorType[] $values() {
        return new EditorType[]{Text, MultilineText, Numeric, Percent, Currency, Mask, DateTime, Date, Time, Segment, Switch, Checkbox, Picker, AutoComplete, Password, Custom};
    }

    public static EnumEntries<EditorType> getEntries() {
        return $ENTRIES;
    }

    public static EditorType valueOf(String str) {
        return (EditorType) Enum.valueOf(EditorType.class, str);
    }

    public static EditorType[] values() {
        return (EditorType[]) $VALUES.clone();
    }

    private EditorType(String str, int i) {
    }

    static {
        EditorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
