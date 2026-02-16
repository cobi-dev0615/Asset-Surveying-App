package com.devexpress.editors;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DXKeyboardType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/devexpress/editors/DXKeyboardType;", "", "(Ljava/lang/String;I)V", "Default", "Text", "Chat", "Email", "Uri", "Numeric", ExifInterface.TAG_DATETIME, "Phone", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DXKeyboardType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DXKeyboardType[] $VALUES;
    public static final DXKeyboardType Default = new DXKeyboardType("Default", 0);
    public static final DXKeyboardType Text = new DXKeyboardType("Text", 1);
    public static final DXKeyboardType Chat = new DXKeyboardType("Chat", 2);
    public static final DXKeyboardType Email = new DXKeyboardType("Email", 3);
    public static final DXKeyboardType Uri = new DXKeyboardType("Uri", 4);
    public static final DXKeyboardType Numeric = new DXKeyboardType("Numeric", 5);
    public static final DXKeyboardType DateTime = new DXKeyboardType(ExifInterface.TAG_DATETIME, 6);
    public static final DXKeyboardType Phone = new DXKeyboardType("Phone", 7);

    private static final /* synthetic */ DXKeyboardType[] $values() {
        return new DXKeyboardType[]{Default, Text, Chat, Email, Uri, Numeric, DateTime, Phone};
    }

    public static EnumEntries<DXKeyboardType> getEntries() {
        return $ENTRIES;
    }

    public static DXKeyboardType valueOf(String str) {
        return (DXKeyboardType) Enum.valueOf(DXKeyboardType.class, str);
    }

    public static DXKeyboardType[] values() {
        return (DXKeyboardType[]) $VALUES.clone();
    }

    private DXKeyboardType(String str, int i) {
    }

    static {
        DXKeyboardType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
