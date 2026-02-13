package com.devexpress.dxcharts;

import com.devexpress.dxcharts.StyleBase;

/* compiled from: StyleBase.java */
/* loaded from: classes.dex */
class StyleContainer<T extends StyleBase> {
    private T defaultStyle;
    private Class<? extends T> mDefaultClass;
    private Class<T> mUserClass;
    private T userStyle;

    StyleContainer(Class<? extends T> cls, Class<T> cls2) {
        this.mDefaultClass = cls;
        this.mUserClass = cls2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    StyleContainer(Class<T> cls) {
        this.mDefaultClass = cls;
        this.mUserClass = cls;
    }

    private T createInstance() {
        try {
            return this.mDefaultClass.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    T getActualStyle(ContextProvider contextProvider, Object... objArr) {
        T defaultStyle = getDefaultStyle(contextProvider, objArr);
        T t = this.userStyle;
        return t != null ? t : defaultStyle;
    }

    T getDefaultStyle(ContextProvider contextProvider, Object... objArr) {
        if (this.defaultStyle == null && contextProvider != null) {
            T createInstance = createInstance();
            this.defaultStyle = createInstance;
            if (createInstance != null) {
                createInstance.initDefaultStyle(contextProvider, objArr);
            }
        }
        return this.defaultStyle;
    }

    T getDefaultStyle() {
        return this.defaultStyle;
    }

    T getUserStyle() {
        return this.userStyle;
    }

    boolean trySetUserStyle(StyleBase styleBase, NotifyPropertyChanged notifyPropertyChanged) {
        boolean z = styleBase == null || styleBase.getClass().isAssignableFrom(this.mUserClass);
        T t = this.userStyle;
        if (t == styleBase || !z) {
            return false;
        }
        if (t != null) {
            t.removeListener(notifyPropertyChanged);
        }
        T cast = styleBase != null ? this.mUserClass.cast(styleBase) : null;
        this.userStyle = cast;
        if (cast != null) {
            cast.addListener(notifyPropertyChanged);
        }
        return true;
    }

    Class<? extends T> getStyleClass() {
        return this.mUserClass;
    }

    void resetDefaultStyle() {
        this.defaultStyle = null;
    }
}
