package org.apache.cordova.geolocation;

import android.os.Build;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Geolocation extends CordovaPlugin {
    CallbackContext context;
    String[] permissionsToCheck;
    String[] permissionsToRequest;
    String TAG = "GeolocationPlugin";
    String[] highAccuracyPermissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    String[] lowAccuracyPermissions = {"android.permission.ACCESS_COARSE_LOCATION"};

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        LOG.d(this.TAG, "We are entering execute");
        this.context = callbackContext;
        if (!action.equals("getPermission")) {
            return false;
        }
        this.permissionsToCheck = args.getBoolean(0) ? this.highAccuracyPermissions : this.lowAccuracyPermissions;
        this.permissionsToRequest = Build.VERSION.SDK_INT <= 31 ? this.highAccuracyPermissions : this.permissionsToCheck;
        if (hasPermisssion(this.permissionsToCheck)) {
            this.context.sendPluginResult(new PluginResult(PluginResult.Status.OK, Build.VERSION.SDK_INT));
            return true;
        }
        PermissionHelper.requestPermissions(this, 0, this.permissionsToRequest);
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException {
        if (this.context != null) {
            for (int i = 0; i < grantResults.length; i++) {
                int i2 = grantResults[i];
                String str = permissions[i];
                if (i2 == -1 && arrayContains(this.permissionsToCheck, str)) {
                    LOG.d(this.TAG, "Permission Denied!");
                    this.context.sendPluginResult(new PluginResult(PluginResult.Status.ILLEGAL_ACCESS_EXCEPTION));
                    return;
                }
            }
            this.context.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        }
    }

    public boolean hasPermisssion(String[] permissions) {
        for (String str : permissions) {
            if (!PermissionHelper.hasPermission(this, str)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void requestPermissions(int requestCode) {
        PermissionHelper.requestPermissions(this, requestCode, this.permissionsToRequest);
    }

    private <T> boolean arrayContains(final T[] array, final T v) {
        if (v == null) {
            for (T t : array) {
                if (t == null) {
                    return true;
                }
            }
        } else {
            for (T t2 : array) {
                if (t2 == v || v.equals(t2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
