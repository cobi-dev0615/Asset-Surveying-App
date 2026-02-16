package org.apache.cordova.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import java.util.Arrays;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

/* loaded from: classes.dex */
public class StatusBar extends CordovaPlugin {
    private static final String TAG = "StatusBar";

    @Override // org.apache.cordova.CordovaPlugin
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        LOG.v(TAG, "StatusBar: initialization");
        super.initialize(cordova, webView);
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.1
            @Override // java.lang.Runnable
            public void run() {
                cordova.getActivity().getWindow().clearFlags(2048);
                StatusBar statusBar = StatusBar.this;
                statusBar.setStatusBarTransparent(statusBar.preferences.getBoolean("StatusBarOverlaysWebView", true));
                StatusBar statusBar2 = StatusBar.this;
                statusBar2.setStatusBarBackgroundColor(statusBar2.preferences.getString("StatusBarBackgroundColor", "#000000"));
                String string = StatusBar.this.preferences.getString("StatusBarStyle", "lightcontent");
                if (string.equalsIgnoreCase("blacktranslucent") || string.equalsIgnoreCase("blackopaque")) {
                    LOG.w(StatusBar.TAG, string + " is deprecated and will be removed in next major release, use lightcontent");
                }
                StatusBar.this.setStatusBarStyle(string);
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
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Build.VERSION.SDK_INT >= 19) {
                        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-1025) & (-5));
                    }
                    window.clearFlags(1024);
                }
            });
            return true;
        }
        if ("hide".equals(action)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.3
                @Override // java.lang.Runnable
                public void run() {
                    if (Build.VERSION.SDK_INT >= 19) {
                        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 4);
                    }
                    window.addFlags(1024);
                }
            });
            return true;
        }
        if ("backgroundColorByHexString".equals(action)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        StatusBar.this.setStatusBarBackgroundColor(args.getString(0));
                    } catch (JSONException unused) {
                        LOG.e(StatusBar.TAG, "Invalid hexString argument, use f.i. '#777777'");
                    }
                }
            });
            return true;
        }
        if ("overlaysWebView".equals(action)) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            StatusBar.this.setStatusBarTransparent(args.getBoolean(0));
                        } catch (JSONException unused) {
                            LOG.e(StatusBar.TAG, "Invalid boolean argument");
                        }
                    }
                });
                return true;
            }
            return !args.getBoolean(0);
        }
        if ("styleDefault".equals(action)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.6
                @Override // java.lang.Runnable
                public void run() {
                    StatusBar.this.setStatusBarStyle("default");
                }
            });
            return true;
        }
        if ("styleLightContent".equals(action)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.7
                @Override // java.lang.Runnable
                public void run() {
                    StatusBar.this.setStatusBarStyle("lightcontent");
                }
            });
            return true;
        }
        if ("styleBlackTranslucent".equals(action)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.8
                @Override // java.lang.Runnable
                public void run() {
                    StatusBar.this.setStatusBarStyle("blacktranslucent");
                }
            });
            return true;
        }
        if (!"styleBlackOpaque".equals(action)) {
            return false;
        }
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.StatusBar.9
            @Override // java.lang.Runnable
            public void run() {
                StatusBar.this.setStatusBarStyle("blackopaque");
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusBarBackgroundColor(final String colorPref) {
        if (Build.VERSION.SDK_INT < 21 || colorPref == null || colorPref.isEmpty()) {
            return;
        }
        Window window = this.cordova.getActivity().getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        try {
            window.getClass().getMethod("setStatusBarColor", Integer.TYPE).invoke(window, Integer.valueOf(Color.parseColor(colorPref)));
        } catch (IllegalArgumentException unused) {
            LOG.e(TAG, "Invalid hexString argument, use f.i. '#999999'");
        } catch (Exception unused2) {
            LOG.w(TAG, "Method window.setStatusBarColor not found for SDK level " + Build.VERSION.SDK_INT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusBarTransparent(final boolean transparent) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.cordova.getActivity().getWindow();
            if (transparent) {
                window.getDecorView().setSystemUiVisibility(1280);
                window.setStatusBarColor(0);
            } else {
                window.getDecorView().setSystemUiVisibility(256);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusBarStyle(final String style) {
        if (Build.VERSION.SDK_INT < 23 || style == null || style.isEmpty()) {
            return;
        }
        View decorView = this.cordova.getActivity().getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        String[] strArr = {"lightcontent", "blacktranslucent", "blackopaque"};
        if (Arrays.asList("default").contains(style.toLowerCase())) {
            decorView.setSystemUiVisibility(systemUiVisibility | 8192);
        } else if (Arrays.asList(strArr).contains(style.toLowerCase())) {
            decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
        } else {
            LOG.e(TAG, "Invalid style, must be either 'default', 'lightcontent' or the deprecated 'blacktranslucent' and 'blackopaque'");
        }
    }
}
