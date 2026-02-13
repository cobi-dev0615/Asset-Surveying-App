package com.devexpress.navigation.common;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class MapExtension {
    public static <T, E> T getKeyByValue(Map<T, E> map, E e) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(e, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
