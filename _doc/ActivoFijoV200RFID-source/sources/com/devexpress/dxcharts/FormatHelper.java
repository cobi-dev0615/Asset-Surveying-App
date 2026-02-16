package com.devexpress.dxcharts;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: ChartTextRenderer.java */
/* loaded from: classes.dex */
class FormatHelper {
    private static final Map<String, DecimalFormat> formats = new HashMap();

    FormatHelper() {
    }

    private static DecimalFormat getFormat(String str) {
        Map<String, DecimalFormat> map = formats;
        DecimalFormat decimalFormat = map.get(str);
        if (decimalFormat != null) {
            return decimalFormat;
        }
        DecimalFormat decimalFormat2 = new DecimalFormat(str);
        map.put(str, decimalFormat2);
        return decimalFormat2;
    }

    static String formatDecimal(double d, String str) {
        return getFormat(str).format(d);
    }

    static String formatDate(Date date, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/GMT"));
        return simpleDateFormat.format(date);
    }

    static String formatString(String str, String str2) {
        return String.format(str2, str);
    }

    static String getDefaultDateFormat(int i) {
        DateTimeMeasureUnit dateTimeMeasureUnit = DateTimeMeasureUnit.values()[i];
        DateTimeFormat dateTimeFormat = new DateTimeFormat();
        switch (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[dateTimeMeasureUnit.ordinal()]) {
            case 1:
                dateTimeFormat.setTime("ss.SSS");
                break;
            case 2:
                dateTimeFormat.setTime((Integer) 2);
                break;
            case 3:
            case 4:
                dateTimeFormat.setTime((Integer) 3);
                break;
            case 5:
            case 6:
                dateTimeFormat.setDate((Integer) 3);
                break;
            case 7:
            case 8:
                dateTimeFormat.setDate("LLLL yyyy");
                break;
            case 9:
                dateTimeFormat.setDate("yyyy");
                break;
            default:
                dateTimeFormat.setDate((Integer) 2);
                dateTimeFormat.setTime((Integer) 2);
                break;
        }
        return dateTimeFormat.getFormat();
    }

    /* compiled from: ChartTextRenderer.java */
    /* renamed from: com.devexpress.dxcharts.FormatHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit;

        static {
            int[] iArr = new int[DateTimeMeasureUnit.values().length];
            $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit = iArr;
            try {
                iArr[DateTimeMeasureUnit.MILLISECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.MINUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.HOUR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.DAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.WEEK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.MONTH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.QUARTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[DateTimeMeasureUnit.DEFAULT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static Object[] getDefaultFormatMap(int i) {
        DateTimeMeasureUnit dateTimeMeasureUnit = DateTimeMeasureUnit.values()[i];
        HashMap hashMap = new HashMap();
        FormatBuilder formatBuilder = new FormatBuilder();
        switch (AnonymousClass1.$SwitchMap$com$devexpress$dxcharts$DateTimeMeasureUnit[dateTimeMeasureUnit.ordinal()]) {
            case 1:
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.MILLISECOND.ordinal()), formatBuilder.newFormat().setTime("SSS").getFormat());
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.SECOND.ordinal()), formatBuilder.newFormat().setTime((Integer) 2).getFormat());
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.DAY.ordinal()), formatBuilder.newFormat().setDate("d MMMM").setTime((Integer) 2).getFormat());
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.YEAR.ordinal()), formatBuilder.newFormat().setDate((Integer) 3).setTime((Integer) 2).getFormat());
                break;
            case 2:
            case 3:
            case 4:
            case 10:
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.SECOND.ordinal()), formatBuilder.newFormat().setTime((Integer) 2).getFormat());
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.DAY.ordinal()), formatBuilder.newFormat().setDate("d MMMM").setTime((Integer) 2).getFormat());
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.YEAR.ordinal()), formatBuilder.newFormat().setDate((Integer) 3).setTime((Integer) 2).getFormat());
                break;
            case 5:
            case 6:
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.DAY.ordinal()), formatBuilder.newFormat().setDate("d MMMM").getFormat());
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.YEAR.ordinal()), formatBuilder.newFormat().setDate((Integer) 1).getFormat());
                break;
            case 7:
            case 8:
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.MONTH.ordinal()), formatBuilder.newFormat().setDate("MMMM").getFormat());
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.YEAR.ordinal()), formatBuilder.newFormat().setDate("MMMM yyyy").getFormat());
                break;
            case 9:
                hashMap.put(Integer.valueOf(DateTimeMeasureUnit.YEAR.ordinal()), formatBuilder.newFormat().setDate("yyyy").getFormat());
                break;
        }
        return flatMap(hashMap);
    }

    private static Object[] flatMap(Map<Integer, String> map) {
        int size = map.size() * 2;
        Object[] objArr = new Object[size];
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        for (int i = 0; i < size; i += 2) {
            Map.Entry<Integer, String> next = it.next();
            objArr[i] = next.getKey();
            objArr[i + 1] = next.getValue();
        }
        return objArr;
    }

    /* compiled from: ChartTextRenderer.java */
    static class FormatBuilder {
        FormatBuilder() {
        }

        DateTimeFormat newFormat() {
            return new DateTimeFormat();
        }
    }

    /* compiled from: ChartTextRenderer.java */
    static class DateTimeFormat {
        private String datePattern = null;
        private String timePattern = null;

        DateTimeFormat() {
        }

        public String getFormat() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.datePattern;
            if (str2 != null) {
                sb.append(str2);
            }
            if (this.timePattern != null) {
                if (sb.toString().equals("")) {
                    str = this.timePattern;
                } else {
                    str = " " + this.timePattern;
                }
                sb.append(str);
            }
            return sb.toString();
        }

        public DateTimeFormat setDate(Integer num) {
            this.datePattern = ((SimpleDateFormat) DateFormat.getDateInstance(num.intValue(), Locale.getDefault())).toPattern();
            return this;
        }

        public DateTimeFormat setTime(Integer num) {
            this.timePattern = ((SimpleDateFormat) DateFormat.getTimeInstance(num.intValue(), Locale.getDefault())).toPattern();
            return this;
        }

        public DateTimeFormat setDate(String str) {
            this.datePattern = str;
            return this;
        }

        public DateTimeFormat setTime(String str) {
            this.timePattern = str;
            return this;
        }
    }
}
