package com.devexpress.editors;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChipItemViewProvider.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/devexpress/editors/ChipItemsProviderViewType;", "", "(Ljava/lang/String;I)V", "Chip", "InputView", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChipItemsProviderViewType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChipItemsProviderViewType[] $VALUES;
    public static final ChipItemsProviderViewType Chip = new ChipItemsProviderViewType("Chip", 0);
    public static final ChipItemsProviderViewType InputView = new ChipItemsProviderViewType("InputView", 1);

    private static final /* synthetic */ ChipItemsProviderViewType[] $values() {
        return new ChipItemsProviderViewType[]{Chip, InputView};
    }

    public static EnumEntries<ChipItemsProviderViewType> getEntries() {
        return $ENTRIES;
    }

    public static ChipItemsProviderViewType valueOf(String str) {
        return (ChipItemsProviderViewType) Enum.valueOf(ChipItemsProviderViewType.class, str);
    }

    public static ChipItemsProviderViewType[] values() {
        return (ChipItemsProviderViewType[]) $VALUES.clone();
    }

    private ChipItemsProviderViewType(String str, int i) {
    }

    static {
        ChipItemsProviderViewType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
