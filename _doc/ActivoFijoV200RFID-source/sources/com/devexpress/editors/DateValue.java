package com.devexpress.editors;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateValue.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0012J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/devexpress/editors/DateValue;", "", "year", "", "month", "dayOfMonth", "(III)V", "getDayOfMonth", "()I", "getMonth", "getYear", "compareTo", "other", "component1", "component2", "component3", "copy", "equals", "", "", "getMillisecondsForCurrentLocale", "", "hashCode", "isDefault", "toString", "", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DateValue implements Comparable<DateValue> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: default, reason: not valid java name */
    private static final DateValue f0default = new DateValue(-1, -1, -1);
    private final int dayOfMonth;
    private final int month;
    private final int year;

    public static /* synthetic */ DateValue copy$default(DateValue dateValue, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = dateValue.year;
        }
        if ((i4 & 2) != 0) {
            i2 = dateValue.month;
        }
        if ((i4 & 4) != 0) {
            i3 = dateValue.dayOfMonth;
        }
        return dateValue.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final DateValue copy(int year, int month, int dayOfMonth) {
        return new DateValue(year, month, dayOfMonth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateValue)) {
            return false;
        }
        DateValue dateValue = (DateValue) other;
        return this.year == dateValue.year && this.month == dateValue.month && this.dayOfMonth == dateValue.dayOfMonth;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.dayOfMonth;
    }

    public String toString() {
        return "DateValue(year=" + this.year + ", month=" + this.month + ", dayOfMonth=" + this.dayOfMonth + ')';
    }

    /* compiled from: DateValue.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/DateValue$Companion;", "", "()V", "default", "Lcom/devexpress/editors/DateValue;", "getDefault", "()Lcom/devexpress/editors/DateValue;", "fromMillisecondsInCurrentLocale", "milliseconds", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DateValue getDefault() {
            return DateValue.f0default;
        }

        public final DateValue fromMillisecondsInCurrentLocale(long milliseconds) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(milliseconds);
            return new DateValue(calendar.get(1), calendar.get(2), calendar.get(5));
        }
    }

    public DateValue(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    @Override // java.lang.Comparable
    public int compareTo(DateValue other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(this, other)) {
            return 0;
        }
        if (isDefault() && other.isDefault()) {
            return 0;
        }
        int compare = Intrinsics.compare(this.year, other.year);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Intrinsics.compare(this.month, other.month);
        return compare2 != 0 ? compare2 : Intrinsics.compare(this.dayOfMonth, other.dayOfMonth);
    }

    public final long getMillisecondsForCurrentLocale() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0L);
        calendar.set(this.year, this.month, this.dayOfMonth);
        return calendar.getTimeInMillis();
    }

    public final boolean isDefault() {
        return this.year == -1 || this.month == -1 || this.dayOfMonth == -1;
    }
}
