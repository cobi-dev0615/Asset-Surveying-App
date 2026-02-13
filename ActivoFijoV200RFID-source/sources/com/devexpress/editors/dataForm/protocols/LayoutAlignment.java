package com.devexpress.editors.dataForm.protocols;

import androidx.core.view.GravityCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LayoutAlignment.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/devexpress/editors/dataForm/protocols/LayoutAlignment;", "", "(Ljava/lang/String;I)V", "toGravity", "", "START", "CENTER", "END", "FILL", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutAlignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutAlignment[] $VALUES;
    public static final LayoutAlignment START = new LayoutAlignment("START", 0);
    public static final LayoutAlignment CENTER = new LayoutAlignment("CENTER", 1);
    public static final LayoutAlignment END = new LayoutAlignment("END", 2);
    public static final LayoutAlignment FILL = new LayoutAlignment("FILL", 3);

    /* compiled from: LayoutAlignment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutAlignment.values().length];
            try {
                iArr[LayoutAlignment.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutAlignment.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutAlignment.FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ LayoutAlignment[] $values() {
        return new LayoutAlignment[]{START, CENTER, END, FILL};
    }

    public static EnumEntries<LayoutAlignment> getEntries() {
        return $ENTRIES;
    }

    public static LayoutAlignment valueOf(String str) {
        return (LayoutAlignment) Enum.valueOf(LayoutAlignment.class, str);
    }

    public static LayoutAlignment[] values() {
        return (LayoutAlignment[]) $VALUES.clone();
    }

    private LayoutAlignment(String str, int i) {
    }

    static {
        LayoutAlignment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final int toGravity() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = GravityCompat.START;
        } else if (i != 2) {
            if (i == 3) {
                i2 = GravityCompat.END;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                i2 = 7;
            }
        }
        return i2 | 16;
    }
}
