package com.megster.cordova;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.util.Iterator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BluetoothSerial extends CordovaPlugin {
    private static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    private static final String AVAILABLE = "available";
    private static final int CHECK_PERMISSIONS_REQ_CODE = 2;
    private static final String CLEAR = "clear";
    private static final String CLEAR_DEVICE_DISCOVERED_LISTENER = "clearDeviceDiscoveredListener";
    private static final String CONNECT = "connect";
    private static final String CONNECT_INSECURE = "connectInsecure";
    private static final boolean D = true;
    public static final String DEVICE_NAME = "device_name";
    private static final String DISCONNECT = "disconnect";
    private static final String DISCOVER_UNPAIRED = "discoverUnpaired";
    private static final String ENABLE = "enable";
    private static final String IS_CONNECTED = "isConnected";
    private static final String IS_ENABLED = "isEnabled";
    private static final String LIST = "list";
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_READ_RAW = 6;
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_TOAST = 5;
    public static final int MESSAGE_WRITE = 3;
    private static final String READ = "read";
    private static final String READ_UNTIL = "readUntil";
    private static final int REQUEST_ENABLE_BLUETOOTH = 1;
    private static final String SETTINGS = "showBluetoothSettings";
    private static final String SET_DEVICE_DISCOVERED_LISTENER = "setDeviceDiscoveredListener";
    private static final String SET_DISCOVERABLE = "setDiscoverable";
    private static final String SET_NAME = "setName";
    private static final String SUBSCRIBE = "subscribe";
    private static final String SUBSCRIBE_RAW = "subscribeRaw";
    private static final String TAG = "BluetoothSerial";
    public static final String TOAST = "toast";
    private static final String UNSUBSCRIBE = "unsubscribe";
    private static final String UNSUBSCRIBE_RAW = "unsubscribeRaw";
    private static final String WRITE = "write";
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSerialService bluetoothSerialService;
    private CallbackContext connectCallback;
    private CallbackContext dataAvailableCallback;
    private String delimiter;
    private CallbackContext deviceDiscoveredCallback;
    private CallbackContext enableBluetoothCallback;
    private CallbackContext permissionCallback;
    private CallbackContext rawDataAvailableCallback;
    StringBuffer buffer = new StringBuffer();
    private final Handler mHandler = new Handler() { // from class: com.megster.cordova.BluetoothSerial.2
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int i = msg.what;
            if (i != 1) {
                if (i == 2) {
                    BluetoothSerial.this.buffer.append((String) msg.obj);
                    if (BluetoothSerial.this.dataAvailableCallback != null) {
                        BluetoothSerial.this.sendDataToSubscriber();
                        return;
                    }
                    return;
                }
                if (i == 4) {
                    Log.i(BluetoothSerial.TAG, msg.getData().getString(BluetoothSerial.DEVICE_NAME));
                    return;
                }
                if (i != 5) {
                    if (i == 6 && BluetoothSerial.this.rawDataAvailableCallback != null) {
                        BluetoothSerial.this.sendRawDataToSubscriber((byte[]) msg.obj);
                        return;
                    }
                    return;
                }
                BluetoothSerial.this.notifyConnectionLost(msg.getData().getString(BluetoothSerial.TOAST));
                return;
            }
            Log.i(BluetoothSerial.TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
            int i2 = msg.arg1;
            if (i2 == 0) {
                Log.i(BluetoothSerial.TAG, "BluetoothSerialService.STATE_NONE");
                return;
            }
            if (i2 == 1) {
                Log.i(BluetoothSerial.TAG, "BluetoothSerialService.STATE_LISTEN");
                return;
            }
            if (i2 == 2) {
                Log.i(BluetoothSerial.TAG, "BluetoothSerialService.STATE_CONNECTING");
            } else {
                if (i2 != 3) {
                    return;
                }
                Log.i(BluetoothSerial.TAG, "BluetoothSerialService.STATE_CONNECTED");
                BluetoothSerial.this.notifyConnectionSuccess();
            }
        }
    };

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        LOG.d(TAG, "action = " + action);
        if (this.bluetoothAdapter == null) {
            this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.bluetoothSerialService == null) {
            this.bluetoothSerialService = new BluetoothSerialService(this.mHandler);
        }
        if (action.equals(LIST)) {
            listBondedDevices(callbackContext);
            return D;
        }
        if (action.equals(CONNECT)) {
            connect(args, D, callbackContext);
            return D;
        }
        if (action.equals(CONNECT_INSECURE)) {
            connect(args, false, callbackContext);
            return D;
        }
        if (action.equals(DISCONNECT)) {
            this.connectCallback = null;
            this.bluetoothSerialService.stop();
            callbackContext.success();
            return D;
        }
        if (action.equals(WRITE)) {
            this.bluetoothSerialService.write(args.getArrayBuffer(0));
            callbackContext.success();
            return D;
        }
        if (action.equals(AVAILABLE)) {
            callbackContext.success(available());
            return D;
        }
        if (action.equals(READ)) {
            callbackContext.success(read());
            return D;
        }
        if (action.equals(READ_UNTIL)) {
            callbackContext.success(readUntil(args.getString(0)));
            return D;
        }
        if (action.equals(SUBSCRIBE)) {
            this.delimiter = args.getString(0);
            this.dataAvailableCallback = callbackContext;
            PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(D);
            callbackContext.sendPluginResult(pluginResult);
            return D;
        }
        if (action.equals(UNSUBSCRIBE)) {
            this.delimiter = null;
            this.dataAvailableCallback.sendPluginResult(new PluginResult(PluginResult.Status.NO_RESULT));
            this.dataAvailableCallback = null;
            callbackContext.success();
            return D;
        }
        if (action.equals(SUBSCRIBE_RAW)) {
            this.rawDataAvailableCallback = callbackContext;
            PluginResult pluginResult2 = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult2.setKeepCallback(D);
            callbackContext.sendPluginResult(pluginResult2);
            return D;
        }
        if (action.equals(UNSUBSCRIBE_RAW)) {
            this.rawDataAvailableCallback = null;
            callbackContext.success();
            return D;
        }
        if (action.equals(IS_ENABLED)) {
            if (this.bluetoothAdapter.isEnabled()) {
                callbackContext.success();
                return D;
            }
            callbackContext.error("Bluetooth is disabled.");
            return D;
        }
        if (action.equals(IS_CONNECTED)) {
            if (this.bluetoothSerialService.getState() == 3) {
                callbackContext.success();
                return D;
            }
            callbackContext.error("Not connected.");
            return D;
        }
        if (action.equals(CLEAR)) {
            this.buffer.setLength(0);
            callbackContext.success();
            return D;
        }
        if (action.equals(SETTINGS)) {
            this.cordova.getActivity().startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
            callbackContext.success();
            return D;
        }
        if (action.equals(ENABLE)) {
            this.enableBluetoothCallback = callbackContext;
            this.cordova.startActivityForResult(this, new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
            return D;
        }
        if (action.equals(DISCOVER_UNPAIRED)) {
            if (this.cordova.hasPermission(ACCESS_COARSE_LOCATION)) {
                discoverUnpairedDevices(callbackContext);
                return D;
            }
            this.permissionCallback = callbackContext;
            this.cordova.requestPermission(this, 2, ACCESS_COARSE_LOCATION);
            return D;
        }
        if (action.equals(SET_DEVICE_DISCOVERED_LISTENER)) {
            this.deviceDiscoveredCallback = callbackContext;
            return D;
        }
        if (action.equals(CLEAR_DEVICE_DISCOVERED_LISTENER)) {
            this.deviceDiscoveredCallback = null;
            return D;
        }
        if (action.equals(SET_NAME)) {
            this.bluetoothAdapter.setName(args.getString(0));
            callbackContext.success();
            return D;
        }
        if (!action.equals(SET_DISCOVERABLE)) {
            return false;
        }
        int i = args.getInt(0);
        Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
        intent.putExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", i);
        this.cordova.getActivity().startActivity(intent);
        return D;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == -1) {
                Log.d(TAG, "User enabled Bluetooth");
                CallbackContext callbackContext = this.enableBluetoothCallback;
                if (callbackContext != null) {
                    callbackContext.success();
                }
            } else {
                Log.d(TAG, "User did *NOT* enable Bluetooth");
                CallbackContext callbackContext2 = this.enableBluetoothCallback;
                if (callbackContext2 != null) {
                    callbackContext2.error("User did not enable Bluetooth");
                }
            }
            this.enableBluetoothCallback = null;
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        super.onDestroy();
        BluetoothSerialService bluetoothSerialService = this.bluetoothSerialService;
        if (bluetoothSerialService != null) {
            bluetoothSerialService.stop();
        }
    }

    private void listBondedDevices(CallbackContext callbackContext) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<BluetoothDevice> it = this.bluetoothAdapter.getBondedDevices().iterator();
        while (it.hasNext()) {
            jSONArray.put(deviceToJSON(it.next()));
        }
        callbackContext.success(jSONArray);
    }

    private void discoverUnpairedDevices(final CallbackContext callbackContext) throws JSONException {
        final CallbackContext callbackContext2 = this.deviceDiscoveredCallback;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.megster.cordova.BluetoothSerial.1
            private JSONArray unpairedDevices = new JSONArray();

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.bluetooth.device.action.FOUND".equals(action)) {
                    try {
                        JSONObject deviceToJSON = BluetoothSerial.this.deviceToJSON((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
                        this.unpairedDevices.put(deviceToJSON);
                        if (callbackContext2 != null) {
                            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, deviceToJSON);
                            pluginResult.setKeepCallback(BluetoothSerial.D);
                            callbackContext2.sendPluginResult(pluginResult);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        Log.e(BluetoothSerial.TAG, "Problem converting device to JSON", e);
                        return;
                    }
                }
                if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    callbackContext.success(this.unpairedDevices);
                    BluetoothSerial.this.cordova.getActivity().unregisterReceiver(this);
                }
            }
        };
        AppCompatActivity activity = this.cordova.getActivity();
        activity.registerReceiver(broadcastReceiver, new IntentFilter("android.bluetooth.device.action.FOUND"));
        activity.registerReceiver(broadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED"));
        this.bluetoothAdapter.startDiscovery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject deviceToJSON(BluetoothDevice device) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", device.getName());
        jSONObject.put("address", device.getAddress());
        jSONObject.put("id", device.getAddress());
        if (device.getBluetoothClass() != null) {
            jSONObject.put("class", device.getBluetoothClass().getDeviceClass());
        }
        return jSONObject;
    }

    private void connect(CordovaArgs args, boolean secure, CallbackContext callbackContext) throws JSONException {
        String string = args.getString(0);
        BluetoothDevice remoteDevice = this.bluetoothAdapter.getRemoteDevice(string);
        if (remoteDevice != null) {
            this.connectCallback = callbackContext;
            this.bluetoothSerialService.connect(remoteDevice, secure);
            this.buffer.setLength(0);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(D);
            callbackContext.sendPluginResult(pluginResult);
            return;
        }
        callbackContext.error("Could not connect to " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionLost(String error) {
        CallbackContext callbackContext = this.connectCallback;
        if (callbackContext != null) {
            callbackContext.error(error);
            this.connectCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionSuccess() {
        if (this.connectCallback != null) {
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            pluginResult.setKeepCallback(D);
            this.connectCallback.sendPluginResult(pluginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRawDataToSubscriber(byte[] data) {
        if (data == null || data.length <= 0) {
            return;
        }
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, data);
        pluginResult.setKeepCallback(D);
        this.rawDataAvailableCallback.sendPluginResult(pluginResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataToSubscriber() {
        String readUntil = readUntil(this.delimiter);
        if (readUntil == null || readUntil.length() <= 0) {
            return;
        }
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, readUntil);
        pluginResult.setKeepCallback(D);
        this.dataAvailableCallback.sendPluginResult(pluginResult);
        sendDataToSubscriber();
    }

    private int available() {
        return this.buffer.length();
    }

    private String read() {
        int length = this.buffer.length();
        String substring = this.buffer.substring(0, length);
        this.buffer.delete(0, length);
        return substring;
    }

    private String readUntil(String c) {
        int indexOf = this.buffer.indexOf(c, 0);
        if (indexOf <= -1) {
            return BuildConfig.FLAVOR;
        }
        String substring = this.buffer.substring(0, c.length() + indexOf);
        this.buffer.delete(0, indexOf + c.length());
        return substring;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) throws JSONException {
        for (int i : grantResults) {
            if (i == -1) {
                LOG.d(TAG, "User *rejected* location permission");
                this.permissionCallback.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "Location permission is required to discover unpaired devices."));
                return;
            }
        }
        if (requestCode != 2) {
            return;
        }
        LOG.d(TAG, "User granted location permission");
        discoverUnpairedDevices(this.permissionCallback);
    }
}
