package com.devexpress.dxcharts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class AxesRepository implements IAxesContainer {
    ContextProvider contextProvider;
    Object renderDelegate;
    int argIDCounter = 0;
    int valueIDCounter = 0;
    Map<Object, AxisX> argAxesRepository = new HashMap();
    Map<Object, NumericAxisY> valueAxesRepository = new HashMap();
    Map<Integer, AxisX> argAxesIDRepository = new HashMap();
    Map<Integer, NumericAxisY> valueAxesIDRepository = new HashMap();
    Set<Map<AxisBase, Object>> elementsCache = new HashSet();

    public AxesRepository(Object obj) {
        this.renderDelegate = obj;
    }

    private void addElementForAxis(Object obj, AxisBase axisBase) {
        Iterator<Map<AxisBase, Object>> it = this.elementsCache.iterator();
        while (it.hasNext()) {
            if (it.next().get(axisBase) == obj) {
                return;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(axisBase, obj);
        this.elementsCache.add(hashMap);
    }

    private void removeElementForAxis(Object obj, AxisBase axisBase) {
        Iterator<Map<AxisBase, Object>> it = this.elementsCache.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map<AxisBase, Object> next = it.next();
            if (next.get(axisBase) == obj) {
                this.elementsCache.remove(next);
                break;
            }
        }
        Iterator<Map<AxisBase, Object>> it2 = this.elementsCache.iterator();
        while (it2.hasNext()) {
            if (it2.next().get(axisBase) != null) {
                return;
            }
        }
        axisBase.setSyncObject(null);
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public void addAxisXForElement(AxisX axisX, Object obj) {
        if (this.argAxesRepository.get(obj) != null) {
            this.argAxesRepository.get(obj).applyCurrentTheme(this.contextProvider, new Object[0]);
            removeElementForAxis(obj, this.argAxesRepository.get(obj));
        }
        this.argAxesRepository.put(obj, axisX);
        this.argAxesIDRepository.put(Integer.valueOf(this.argIDCounter), axisX);
        this.argIDCounter++;
        if (this.argAxesRepository.get(obj) != null) {
            this.argAxesRepository.get(obj).applyCurrentTheme(this.contextProvider, new Object[0]);
            this.argAxesRepository.get(obj).setSyncObject(this.renderDelegate);
            addElementForAxis(obj, axisX);
        }
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public void addAxisYForElement(NumericAxisY numericAxisY, Object obj) {
        if (this.valueAxesRepository.get(obj) != null) {
            this.valueAxesRepository.get(obj).applyCurrentTheme(this.contextProvider, new Object[0]);
            removeElementForAxis(obj, this.valueAxesRepository.get(obj));
        }
        this.valueAxesRepository.put(obj, numericAxisY);
        this.valueAxesIDRepository.put(Integer.valueOf(this.valueIDCounter), numericAxisY);
        this.valueIDCounter++;
        if (this.valueAxesRepository.get(obj) != null) {
            this.valueAxesRepository.get(obj).applyCurrentTheme(this.contextProvider, new Object[0]);
            this.valueAxesRepository.get(obj).setSyncObject(this.renderDelegate);
            addElementForAxis(obj, numericAxisY);
        }
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public AxisX getAxisXByElement(Object obj) {
        if (this.argAxesIDRepository != null) {
            return this.argAxesRepository.get(obj);
        }
        return null;
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public NumericAxisY getAxisYByElement(Object obj) {
        Map<Object, NumericAxisY> map = this.valueAxesRepository;
        if (map != null) {
            return map.get(obj);
        }
        return null;
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public AxisX getAxisXById(int i) {
        return this.argAxesIDRepository.get(Integer.valueOf(i));
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public NumericAxisY getAxisYById(int i) {
        return this.valueAxesIDRepository.get(Integer.valueOf(i));
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public int getAxisXIDByAxisData(long j) {
        for (Integer num : this.argAxesIDRepository.keySet()) {
            int intValue = num.intValue();
            AxisX axisX = this.argAxesIDRepository.get(num);
            if (axisX != null && axisX.compareNativeAxes(j)) {
                return intValue;
            }
        }
        return -1;
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public int getAxisYIDByAxisData(long j) {
        for (Integer num : this.valueAxesIDRepository.keySet()) {
            int intValue = num.intValue();
            NumericAxisY numericAxisY = this.valueAxesIDRepository.get(num);
            if (numericAxisY != null && numericAxisY.compareNativeAxes(j)) {
                return intValue;
            }
        }
        return -1;
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public void applyTheme(ContextProvider contextProvider) {
        this.contextProvider = contextProvider;
        Iterator<Object> it = this.argAxesRepository.keySet().iterator();
        while (it.hasNext()) {
            this.argAxesRepository.get(it.next()).applyCurrentTheme(contextProvider, new Object[0]);
        }
        Iterator<Object> it2 = this.valueAxesRepository.keySet().iterator();
        while (it2.hasNext()) {
            this.valueAxesRepository.get(it2.next()).applyCurrentTheme(contextProvider, new Object[0]);
        }
    }

    @Override // com.devexpress.dxcharts.IAxesContainer
    public Object getRenderDelegate() {
        return this.renderDelegate;
    }
}
