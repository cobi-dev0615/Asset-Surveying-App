package com.devexpress.editors.dataForm.protocols;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: EditorLabelPosition.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/EditorLabelPosition;", "", "(Ljava/lang/String;I)V", "TOP", "LEFT", "RIGHT", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditorLabelPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EditorLabelPosition[] $VALUES;
    public static final EditorLabelPosition TOP = new EditorLabelPosition("TOP", 0);
    public static final EditorLabelPosition LEFT = new EditorLabelPosition("LEFT", 1);
    public static final EditorLabelPosition RIGHT = new EditorLabelPosition("RIGHT", 2);

    private static final /* synthetic */ EditorLabelPosition[] $values() {
        return new EditorLabelPosition[]{TOP, LEFT, RIGHT};
    }

    public static EnumEntries<EditorLabelPosition> getEntries() {
        return $ENTRIES;
    }

    public static EditorLabelPosition valueOf(String str) {
        return (EditorLabelPosition) Enum.valueOf(EditorLabelPosition.class, str);
    }

    public static EditorLabelPosition[] values() {
        return (EditorLabelPosition[]) $VALUES.clone();
    }

    private EditorLabelPosition(String str, int i) {
    }

    static {
        EditorLabelPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
