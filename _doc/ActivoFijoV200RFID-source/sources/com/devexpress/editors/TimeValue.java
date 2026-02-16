package com.devexpress.editors;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TimeValue.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\rJ\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/devexpress/editors/TimeValue;", "", "hour", "", "minute", "(II)V", "getHour", "()I", "getMinute", "component1", "component2", "copy", "equals", "", "other", "getMillisecondsForCurrentLocale", "", "hashCode", "isDefault", "toString", "", "Companion", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TimeValue {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: default, reason: not valid java name */
    private static final TimeValue f1default = new TimeValue(-1, -1);
    private final int hour;
    private final int minute;

    public static /* synthetic */ TimeValue copy$default(TimeValue timeValue, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = timeValue.hour;
        }
        if ((i3 & 2) != 0) {
            i2 = timeValue.minute;
        }
        return timeValue.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinute() {
        return this.minute;
    }

    public final TimeValue copy(int hour, int minute) {
        return new TimeValue(hour, minute);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeValue)) {
            return false;
        }
        TimeValue timeValue = (TimeValue) other;
        return this.hour == timeValue.hour && this.minute == timeValue.minute;
    }

    public int hashCode() {
        return (this.hour * 31) + this.minute;
    }

    public String toString() {
        return "TimeValue(hour=" + this.hour + ", minute=" + this.minute + ')';
    }

    /* compiled from: TimeValue.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/devexpress/editors/TimeValue$Companion;", "", "()V", "default", "Lcom/devexpress/editors/TimeValue;", "getDefault", "()Lcom/devexpress/editors/TimeValue;", "fromMillisecondsInCurrentLocale", "milliseconds", "", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TimeValue getDefault() {
            return TimeValue.f1default;
        }

        public final TimeValue fromMillisecondsInCurrentLocale(long milliseconds) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(milliseconds);
            return new TimeValue(calendar.get(10), calendar.get(12));
        }
    }

    public TimeValue(int i, int i2) {
        this.hour = i;
        this.minute = i2;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final long getMillisecondsForCurrentLocale() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0L);
        calendar.set(0, 0, 0, this.hour, this.minute);
        return calendar.getTimeInMillis();
    }

    public final boolean isDefault() {
        return this.hour == -1 || this.minute == -1;
    }
}
