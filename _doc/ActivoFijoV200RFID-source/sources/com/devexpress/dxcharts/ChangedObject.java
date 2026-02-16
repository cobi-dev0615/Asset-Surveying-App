package com.devexpress.dxcharts;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Chart.java */
/* loaded from: classes.dex */
class ChangedObject {
    private ArrayList<NotifyPropertyChanged> listeners = new ArrayList<>();
    private boolean isUpdatesEnabled = true;

    ChangedObject() {
    }

    void addListener(NotifyPropertyChanged notifyPropertyChanged) {
        if (this.listeners.contains(notifyPropertyChanged)) {
            return;
        }
        this.listeners.add(notifyPropertyChanged);
    }

    void removeListener(NotifyPropertyChanged notifyPropertyChanged) {
        if (this.listeners.contains(notifyPropertyChanged)) {
            this.listeners.remove(notifyPropertyChanged);
        }
    }

    void notifyListeners(Object obj, PropertyChangedArgs propertyChangedArgs) {
        if (this.isUpdatesEnabled) {
            Iterator<NotifyPropertyChanged> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPropertyChanged(obj, propertyChangedArgs);
            }
        }
    }

    void notifyListeners(Object obj, Enum<?> r3) {
        notifyListeners(obj, new PropertyChangedArgs(r3));
    }

    void setUpdatesEnabled(boolean z) {
        this.isUpdatesEnabled = z;
    }
}
