package com.devexpress.dxcharts;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class LabelFormatAutoReplaceOptions extends ChartElement {
    private boolean enabled = true;
    private Map<DateTimeMeasureUnit, String> labelFormats = new TreeMap();

    enum Property {
        ENABLE_LABEL_FORMATS,
        LABEL_FORMATS
    }

    Map<DateTimeMeasureUnit, String> getLabelFormatMap() {
        return this.labelFormats;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            notifyListeners(Property.ENABLE_LABEL_FORMATS);
        }
    }

    public void setLabelFormat(DateTimeMeasureUnit dateTimeMeasureUnit, String str) {
        this.labelFormats.put(dateTimeMeasureUnit, str);
        notifyListeners(Property.LABEL_FORMATS);
    }

    public void removeLabelFormat(DateTimeMeasureUnit dateTimeMeasureUnit) {
        this.labelFormats.remove(dateTimeMeasureUnit);
        notifyListeners(Property.LABEL_FORMATS);
    }

    public void removeAll() {
        this.labelFormats.clear();
        notifyListeners(Property.LABEL_FORMATS);
    }

    public DateTimeLabelFormat[] getLabelFormats() {
        ArrayList arrayList = new ArrayList();
        for (DateTimeMeasureUnit dateTimeMeasureUnit : this.labelFormats.keySet()) {
            arrayList.add(new DateTimeLabelFormat(dateTimeMeasureUnit, this.labelFormats.get(dateTimeMeasureUnit)));
        }
        return (DateTimeLabelFormat[]) arrayList.toArray();
    }
}
