package org.apache.cordova.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
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
    private static final String ACTION_BACKGROUND_COLOR_BY_HEX_STRING = "backgroundColorByHexString";
    private static final String ACTION_HIDE = "hide";
    private static final String ACTION_OVERLAYS_WEB_VIEW = "overlaysWebView";
    private static final String ACTION_READY = "_ready";
    private static final String ACTION_SHOW = "show";
    private static final String ACTION_STYLE_DEFAULT = "styleDefault";
    private static final String ACTION_STYLE_LIGHT_CONTENT = "styleLightContent";
    private static final String STYLE_DEFAULT = "default";
    private static final String STYLE_LIGHT_CONTENT = "lightcontent";
    private static final String TAG = "StatusBar";
    private AppCompatActivity activity;
    private Window window;

    @Override // org.apache.cordova.CordovaPlugin
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        LOG.v(TAG, "StatusBar: initialization");
        super.initialize(cordova, webView);
        AppCompatActivity activity = this.cordova.getActivity();
        this.activity = activity;
        this.window = activity.getWindow();
        this.activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.-$$Lambda$StatusBar$IFkSli92rmswvQvJNmZL9CZZ_oA
            @Override // java.lang.Runnable
            public final void run() {
                StatusBar.this.lambda$initialize$0$StatusBar();
            }
        });
    }

    public /* synthetic */ void lambda$initialize$0$StatusBar() {
        this.window.clearFlags(2048);
        setStatusBarTransparent(this.preferences.getBoolean("StatusBarOverlaysWebView", true));
        setStatusBarBackgroundColor(this.preferences.getString("StatusBarBackgroundColor", "#000000"));
        setStatusBarStyle(this.preferences.getString("StatusBarStyle", STYLE_LIGHT_CONTENT).toLowerCase());
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) {
        LOG.v(TAG, "Executing action: " + action);
        action.hashCode();
        switch (action) {
            case "_ready":
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (this.window.getAttributes().flags & 1024) == 0));
                return true;
            case "styleDefault":
                this.activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.-$$Lambda$StatusBar$Aqb-OZrTmtx2Uk7qdGZSeqCvuA8
                    @Override // java.lang.Runnable
                    public final void run() {
                        StatusBar.this.lambda$execute$5$StatusBar();
                    }
                });
                return true;
            case "styleLightContent":
                this.activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.-$$Lambda$StatusBar$_6IylXTGHghUQ281rcHz0azkNsM
                    @Override // java.lang.Runnable
                    public final void run() {
                        StatusBar.this.lambda$execute$6$StatusBar();
                    }
                });
                return true;
            case "hide":
                this.activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.-$$Lambda$StatusBar$mDXVVGYy6wz9bb_EAkhMi0i3Hbg
                    @Override // java.lang.Runnable
                    public final void run() {
                        StatusBar.this.lambda$execute$2$StatusBar();
                    }
                });
                return true;
            case "show":
                this.activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.-$$Lambda$StatusBar$ZqOpf8P9g-jt9RU4jq6vBNLd4OY
                    @Override // java.lang.Runnable
                    public final void run() {
                        StatusBar.this.lambda$execute$1$StatusBar();
                    }
                });
                return true;
            case "overlaysWebView":
                this.activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.-$$Lambda$StatusBar$KlxGolRyCa652NUeoAcxTLG1rwQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        StatusBar.this.lambda$execute$4$StatusBar(args);
                    }
                });
                return true;
            case "backgroundColorByHexString":
                this.activity.runOnUiThread(new Runnable() { // from class: org.apache.cordova.statusbar.-$$Lambda$StatusBar$weplUSFFTLC1cNUl4eSBiES-Q4o
                    @Override // java.lang.Runnable
                    public final void run() {
                        StatusBar.this.lambda$execute$3$StatusBar(args);
                    }
                });
                return true;
            default:
                return false;
        }
    }

    public /* synthetic */ void lambda$execute$1$StatusBar() {
        this.window.getDecorView().setSystemUiVisibility(this.window.getDecorView().getSystemUiVisibility() & (-1025) & (-5));
        this.window.clearFlags(1024);
    }

    public /* synthetic */ void lambda$execute$2$StatusBar() {
        this.window.getDecorView().setSystemUiVisibility(this.window.getDecorView().getSystemUiVisibility() | 1024 | 4);
        this.window.addFlags(1024);
    }

    public /* synthetic */ void lambda$execute$3$StatusBar(CordovaArgs cordovaArgs) {
        try {
            setStatusBarBackgroundColor(cordovaArgs.getString(0));
        } catch (JSONException unused) {
            LOG.e(TAG, "Invalid hexString argument, use f.i. '#777777'");
        }
    }

    public /* synthetic */ void lambda$execute$4$StatusBar(CordovaArgs cordovaArgs) {
        try {
            setStatusBarTransparent(cordovaArgs.getBoolean(0));
        } catch (JSONException unused) {
            LOG.e(TAG, "Invalid boolean argument");
        }
    }

    public /* synthetic */ void lambda$execute$5$StatusBar() {
        setStatusBarStyle(STYLE_DEFAULT);
    }

    public /* synthetic */ void lambda$execute$6$StatusBar() {
        setStatusBarStyle(STYLE_LIGHT_CONTENT);
    }

    private void setStatusBarBackgroundColor(final String colorPref) {
        if (colorPref.isEmpty()) {
            return;
        }
        try {
            int parseColor = Color.parseColor(colorPref);
            this.window.clearFlags(67108864);
            this.window.addFlags(Integer.MIN_VALUE);
            this.window.setStatusBarColor(parseColor);
        } catch (IllegalArgumentException unused) {
            LOG.e(TAG, "Invalid hexString argument, use f.i. '#999999'");
        }
    }

    private void setStatusBarTransparent(final boolean isTransparent) {
        Window window = this.cordova.getActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(isTransparent ? 1280 : 256);
        if (isTransparent) {
            window.setStatusBarColor(0);
        }
    }

    private void setStatusBarStyle(final String style) {
        if (Build.VERSION.SDK_INT < 23 || style.isEmpty()) {
            return;
        }
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(this.window, this.window.getDecorView());
        if (style.equals(STYLE_DEFAULT)) {
            insetsController.setAppearanceLightStatusBars(true);
        } else if (style.equals(STYLE_LIGHT_CONTENT)) {
            insetsController.setAppearanceLightStatusBars(false);
        } else {
            LOG.e(TAG, "Invalid style, must be either 'default' or 'lightcontent'");
        }
    }
}
