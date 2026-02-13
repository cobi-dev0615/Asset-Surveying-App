package com.microsoft.maui;

import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class PlatformMauiAppCompatActivity {
    public static void onCreate(AppCompatActivity appCompatActivity, Bundle bundle, boolean z, int i, int i2) {
        if (!z && bundle != null) {
            bundle.remove("android:support:fragments");
            bundle.remove("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        TypedArray typedArray = null;
        try {
            typedArray = appCompatActivity.obtainStyledAttributes(new int[]{i});
            if (typedArray.getBoolean(0, false)) {
                appCompatActivity.setTheme(i2);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
