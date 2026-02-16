package org.apache.cordova.media;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import barcodescanner.xservices.nl.barcodescanner.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.LOG;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.apache.cordova.media.AudioPlayer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AudioHandler extends CordovaPlugin {
    public static final int PERMISSION_DENIED_ERROR = 20;
    public static String TAG = "AudioHandler";
    private String fileUriStr;
    private CallbackContext messageChannel;
    private String recordId;
    public static String[] permissions = {"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static int RECORD_AUDIO = 0;
    public static int WRITE_EXTERNAL_STORAGE = 1;
    private int origVolumeStream = -1;
    private AudioManager.OnAudioFocusChangeListener focusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: org.apache.cordova.media.AudioHandler.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == -3 || focusChange == -2 || focusChange == -1) {
                AudioHandler.this.pauseAllLostFocus();
            } else {
                if (focusChange != 1) {
                    return;
                }
                AudioHandler.this.resumeAllGainedFocus();
            }
        }
    };
    HashMap<String, AudioPlayer> players = new HashMap<>();
    ArrayList<AudioPlayer> pausedForPhone = new ArrayList<>();
    ArrayList<AudioPlayer> pausedForFocus = new ArrayList<>();

    public Context getApplicationContext() {
        return this.cordova.getActivity().getApplicationContext();
    }

    protected void getWritePermission(int requestCode) {
        PermissionHelper.requestPermission(this, requestCode, permissions[WRITE_EXTERNAL_STORAGE]);
    }

    protected void getMicPermission(int requestCode) {
        PermissionHelper.requestPermission(this, requestCode, permissions[RECORD_AUDIO]);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        CordovaResourceApi resourceApi = this.webView.getResourceApi();
        PluginResult.Status status = PluginResult.Status.OK;
        if (action.equals("startRecordingAudio")) {
            this.recordId = args.getString(0);
            String string = args.getString(1);
            try {
                this.fileUriStr = resourceApi.remapUri(Uri.parse(string)).toString();
            } catch (IllegalArgumentException unused) {
                this.fileUriStr = string;
            }
            promptForRecord();
        } else if (action.equals("stopRecordingAudio")) {
            stopRecordingAudio(args.getString(0), true);
        } else if (action.equals("pauseRecordingAudio")) {
            stopRecordingAudio(args.getString(0), false);
        } else if (action.equals("resumeRecordingAudio")) {
            resumeRecordingAudio(args.getString(0));
        } else if (action.equals("startPlayingAudio")) {
            String string2 = args.getString(1);
            try {
                string2 = resourceApi.remapUri(Uri.parse(string2)).toString();
            } catch (IllegalArgumentException unused2) {
            }
            startPlayingAudio(args.getString(0), FileHelper.stripFileProtocol(string2));
        } else if (action.equals("seekToAudio")) {
            seekToAudio(args.getString(0), args.getInt(1));
        } else if (action.equals("pausePlayingAudio")) {
            pausePlayingAudio(args.getString(0));
        } else if (action.equals("stopPlayingAudio")) {
            stopPlayingAudio(args.getString(0));
        } else if (action.equals("setVolume")) {
            try {
                setVolume(args.getString(0), Float.parseFloat(args.getString(1)));
            } catch (NumberFormatException unused3) {
            }
        } else {
            if (action.equals("getCurrentPositionAudio")) {
                callbackContext.sendPluginResult(new PluginResult(status, getCurrentPositionAudio(args.getString(0))));
                return true;
            }
            if (action.equals("getDurationAudio")) {
                callbackContext.sendPluginResult(new PluginResult(status, getDurationAudio(args.getString(0), args.getString(1))));
                return true;
            }
            if (action.equals("create")) {
                getOrCreatePlayer(args.getString(0), FileHelper.stripFileProtocol(args.getString(1)));
            } else {
                if (action.equals("release")) {
                    callbackContext.sendPluginResult(new PluginResult(status, release(args.getString(0))));
                    return true;
                }
                if (action.equals("messageChannel")) {
                    this.messageChannel = callbackContext;
                    return true;
                }
                if (!action.equals("getCurrentAmplitudeAudio")) {
                    return false;
                }
                callbackContext.sendPluginResult(new PluginResult(status, getCurrentAmplitudeAudio(args.getString(0))));
                return true;
            }
        }
        callbackContext.sendPluginResult(new PluginResult(status, BuildConfig.FLAVOR));
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        if (!this.players.isEmpty()) {
            onLastPlayerReleased();
        }
        Iterator<AudioPlayer> it = this.players.values().iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.players.clear();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onReset() {
        onDestroy();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Object onMessage(String id, Object data) {
        if (id.equals("telephone")) {
            if ("ringing".equals(data) || "offhook".equals(data)) {
                for (AudioPlayer audioPlayer : this.players.values()) {
                    if (audioPlayer.getState() == AudioPlayer.STATE.MEDIA_RUNNING.ordinal()) {
                        this.pausedForPhone.add(audioPlayer);
                        audioPlayer.pausePlaying();
                    }
                }
            } else if ("idle".equals(data)) {
                Iterator<AudioPlayer> it = this.pausedForPhone.iterator();
                while (it.hasNext()) {
                    it.next().startPlaying(null);
                }
                this.pausedForPhone.clear();
            }
        }
        return null;
    }

    private AudioPlayer getOrCreatePlayer(String id, String file) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            return audioPlayer;
        }
        if (this.players.isEmpty()) {
            onFirstPlayerCreated();
        }
        AudioPlayer audioPlayer2 = new AudioPlayer(this, id, file);
        this.players.put(id, audioPlayer2);
        return audioPlayer2;
    }

    private boolean release(String id) {
        AudioPlayer remove = this.players.remove(id);
        if (remove == null) {
            return false;
        }
        if (this.players.isEmpty()) {
            onLastPlayerReleased();
        }
        remove.destroy();
        return true;
    }

    public void startRecordingAudio(String id, String file) {
        getOrCreatePlayer(id, file).startRecording(file);
    }

    public void stopRecordingAudio(String id, boolean stop) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            audioPlayer.stopRecording(stop);
        }
    }

    public void resumeRecordingAudio(String id) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            audioPlayer.resumeRecording();
        }
    }

    public void startPlayingAudio(String id, String file) {
        getOrCreatePlayer(id, file).startPlaying(file);
        getAudioFocus();
    }

    public void seekToAudio(String id, int milliseconds) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            audioPlayer.seekToPlaying(milliseconds);
        }
    }

    public void pausePlayingAudio(String id) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            audioPlayer.pausePlaying();
        }
    }

    public void stopPlayingAudio(String id) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            audioPlayer.stopPlaying();
        }
    }

    public float getCurrentPositionAudio(String id) {
        if (this.players.get(id) != null) {
            return r3.getCurrentPosition() / 1000.0f;
        }
        return -1.0f;
    }

    public float getDurationAudio(String id, String file) {
        return getOrCreatePlayer(id, file).getDuration(file);
    }

    public void setAudioOutputDevice(int output) {
        AudioManager audioManager = (AudioManager) this.cordova.getActivity().getSystemService("audio");
        if (output == 2) {
            audioManager.setRouting(0, 2, -1);
        } else if (output == 1) {
            audioManager.setRouting(0, 1, -1);
        } else {
            LOG.e("AudioHandler.setAudioOutputDevice(): Error : ", " Unknown output device");
        }
    }

    public void pauseAllLostFocus() {
        for (AudioPlayer audioPlayer : this.players.values()) {
            if (audioPlayer.getState() == AudioPlayer.STATE.MEDIA_RUNNING.ordinal()) {
                this.pausedForFocus.add(audioPlayer);
                audioPlayer.pausePlaying();
            }
        }
    }

    public void resumeAllGainedFocus() {
        Iterator<AudioPlayer> it = this.pausedForFocus.iterator();
        while (it.hasNext()) {
            it.next().resumePlaying();
        }
        this.pausedForFocus.clear();
    }

    public void getAudioFocus() {
        int requestAudioFocus = ((AudioManager) this.cordova.getActivity().getSystemService("audio")).requestAudioFocus(this.focusChangeListener, 3, 1);
        if (requestAudioFocus != 1) {
            LOG.e("AudioHandler.getAudioFocus(): Error : ", requestAudioFocus + " instead of 1");
        }
    }

    public int getAudioOutputDevice() {
        AudioManager audioManager = (AudioManager) this.cordova.getActivity().getSystemService("audio");
        if (audioManager.getRouting(0) == 1) {
            return 1;
        }
        return audioManager.getRouting(0) == 2 ? 2 : -1;
    }

    public void setVolume(String id, float volume) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            audioPlayer.setVolume(volume);
            return;
        }
        LOG.e("AudioHandler.setVolume(): Error : ", "Unknown Audio Player " + id);
    }

    private void onFirstPlayerCreated() {
        this.origVolumeStream = this.cordova.getActivity().getVolumeControlStream();
        this.cordova.getActivity().setVolumeControlStream(3);
    }

    private void onLastPlayerReleased() {
        if (this.origVolumeStream != -1) {
            this.cordova.getActivity().setVolumeControlStream(this.origVolumeStream);
            this.origVolumeStream = -1;
        }
    }

    void sendEventMessage(String action, JSONObject actionData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", action);
            if (actionData != null) {
                jSONObject.put(action, actionData);
            }
        } catch (JSONException e) {
            LOG.e(TAG, "Failed to create event message", e);
        }
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, jSONObject);
        pluginResult.setKeepCallback(true);
        CallbackContext callbackContext = this.messageChannel;
        if (callbackContext != null) {
            callbackContext.sendPluginResult(pluginResult);
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onRequestPermissionResult(int requestCode, String[] permissions2, int[] grantResults) throws JSONException {
        for (int i : grantResults) {
            if (i == -1) {
                this.messageChannel.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 20));
                return;
            }
        }
        promptForRecord();
    }

    private void promptForRecord() {
        if (PermissionHelper.hasPermission(this, permissions[WRITE_EXTERNAL_STORAGE]) && PermissionHelper.hasPermission(this, permissions[RECORD_AUDIO])) {
            startRecordingAudio(this.recordId, FileHelper.stripFileProtocol(this.fileUriStr));
        } else if (PermissionHelper.hasPermission(this, permissions[RECORD_AUDIO])) {
            getWritePermission(WRITE_EXTERNAL_STORAGE);
        } else {
            getMicPermission(RECORD_AUDIO);
        }
    }

    public float getCurrentAmplitudeAudio(String id) {
        AudioPlayer audioPlayer = this.players.get(id);
        if (audioPlayer != null) {
            return audioPlayer.getCurrentAmplitude();
        }
        return 0.0f;
    }
}
