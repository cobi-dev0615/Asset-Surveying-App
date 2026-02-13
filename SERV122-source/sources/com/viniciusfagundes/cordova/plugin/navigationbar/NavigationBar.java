package com.viniciusfagundes.cordova.plugin.navigationbar;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

/* loaded from: classes.dex */
public class NavigationBar extends CordovaPlugin {
    private static final String TAG = "NavigationBar";

    @Override // org.apache.cordova.CordovaPlugin
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        LOG.v(TAG, "NavigationBar: initialization");
        super.initialize(cordova, webView);
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: com.viniciusfagundes.cordova.plugin.navigationbar.NavigationBar.1
            @Override // java.lang.Runnable
            public void run() {
                cordova.getActivity().getWindow().clearFlags(2048);
                NavigationBar navigationBar = NavigationBar.this;
                navigationBar.setNavigationBarBackgroundColor(navigationBar.preferences.getString("NavigationBarBackgroundColor", "#000000"), Boolean.valueOf(NavigationBar.this.preferences.getBoolean("NavigationBarLight", false)));
            }
        });
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        LOG.v(TAG, "Executing action: " + action);
        final Window window = this.cordova.getActivity().getWindow();
        if ("_ready".equals(action)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (window.getAttributes().flags & 1024) == 0));
            return true;
        }
        if ("show".equals(action)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: com.viniciusfagundes.cordova.plugin.navigationbar.NavigationBar.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Build.VERSION.SDK_INT >= 19) {
                        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-513) & (-4097));
                        window.getDecorView().setOnFocusChangeListener(null);
                        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
                    }
                    window.clearFlags(1024);
                }
            });
            return true;
        }
        if ("hide".equals(action)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: com.viniciusfagundes.cordova.plugin.navigationbar.NavigationBar.3
                @Override // java.lang.Runnable
                public void run() {
                    if (Build.VERSION.SDK_INT >= 19) {
                        final int systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 2 | 4096;
                        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
                        window.getDecorView().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.viniciusfagundes.cordova.plugin.navigationbar.NavigationBar.3.1
                            @Override // android.view.View.OnFocusChangeListener
                            public void onFocusChange(View v, boolean hasFocus) {
                                if (hasFocus) {
                                    window.getDecorView().setSystemUiVisibility(systemUiVisibility);
                                }
                            }
                        });
                        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.viniciusfagundes.cordova.plugin.navigationbar.NavigationBar.3.2
                            @Override // android.view.View.OnSystemUiVisibilityChangeListener
                            public void onSystemUiVisibilityChange(int visibility) {
                                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
                            }
                        });
                    }
                }
            });
            return true;
        }
        if (!"backgroundColorByHexString".equals(action)) {
            return false;
        }
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: com.viniciusfagundes.cordova.plugin.navigationbar.NavigationBar.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    NavigationBar.this.setNavigationBarBackgroundColor(args.getString(0), Boolean.valueOf(args.getBoolean(1)));
                } catch (JSONException unused) {
                    LOG.e(NavigationBar.TAG, "Invalid hexString argument, use f.i. '#777777'");
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationBarBackgroundColor(final String colorPref, Boolean lightNavigationBar) {
        Boolean valueOf = Boolean.valueOf(lightNavigationBar == null ? false : lightNavigationBar.booleanValue());
        if (Build.VERSION.SDK_INT < 21 || colorPref == null || colorPref.isEmpty()) {
            return;
        }
        Window window = this.cordova.getActivity().getWindow();
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility() | Integer.MIN_VALUE;
        window.getDecorView().setSystemUiVisibility((Build.VERSION.SDK_INT < 26 || !valueOf.booleanValue()) ? systemUiVisibility & (-17) : systemUiVisibility | 16);
        try {
            window.getClass().getDeclaredMethod("setNavigationBarColor", Integer.TYPE).invoke(window, Integer.valueOf(Color.parseColor(colorPref)));
        } catch (IllegalArgumentException unused) {
            LOG.e(TAG, "Invalid hexString argument, use f.i. '#999999'");
        } catch (Exception unused2) {
            LOG.w(TAG, "Method window.setNavigationBarColor not found for SDK level " + Build.VERSION.SDK_INT);
        }
    }
}
