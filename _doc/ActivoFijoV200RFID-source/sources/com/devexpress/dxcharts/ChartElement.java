package com.devexpress.dxcharts;

/* loaded from: classes.dex */
public abstract class ChartElement {
    private ChangedObject changedObject = new ChangedObject();
    private NotifyPropertyChanged propertyChangedListener = new NotifyPropertyChanged() { // from class: com.devexpress.dxcharts.ChartElement.1
        @Override // com.devexpress.dxcharts.NotifyPropertyChanged
        public void onPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
            ChartElement.this.onChartElementPropertyChanged(obj, propertyChangedArgs);
        }
    };

    void addListener(NotifyPropertyChanged notifyPropertyChanged) {
        this.changedObject.addListener(notifyPropertyChanged);
    }

    void removeListener(NotifyPropertyChanged notifyPropertyChanged) {
        this.changedObject.removeListener(notifyPropertyChanged);
    }

    void notifyListeners(Enum<?> r3) {
        this.changedObject.notifyListeners(this, new PropertyChangedArgs(r3));
    }

    void notifyListeners(Object obj, Enum<?> r4) {
        this.changedObject.notifyListeners(obj, new PropertyChangedArgs(r4));
    }

    void notifyListeners(Object obj, PropertyChangedArgs propertyChangedArgs) {
        this.changedObject.notifyListeners(obj, propertyChangedArgs);
    }

    NotifyPropertyChanged getSelfListener() {
        return this.propertyChangedListener;
    }

    void onChartElementPropertyChanged(Object obj, PropertyChangedArgs propertyChangedArgs) {
        notifyListeners(obj, propertyChangedArgs);
    }

    void setUpdatesEnabled(boolean z) {
        this.changedObject.setUpdatesEnabled(z);
    }
}
