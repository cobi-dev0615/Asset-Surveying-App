package org.apache.cordova.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AudioPlayer implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    private static final String LOG_TAG = "AudioPlayer";
    private static int MEDIA_DURATION = 2;
    private static int MEDIA_ERROR = 9;
    private static int MEDIA_ERR_ABORTED = 1;
    private static int MEDIA_ERR_NONE_ACTIVE = 0;
    private static int MEDIA_POSITION = 3;
    private static int MEDIA_STATE = 1;
    private String audioFile;
    private Context context;
    private AudioHandler handler;
    private String id;
    private LinkedList<String> tempFiles;
    private MODE mode = MODE.NONE;
    private STATE state = STATE.MEDIA_NONE;
    private float duration = -1.0f;
    private MediaRecorder recorder = null;
    private String tempFile = null;
    private MediaPlayer player = null;
    private boolean prepareOnly = true;
    private int seekOnPrepared = 0;
    private float setRateOnPrepared = -1.0f;

    public enum MODE {
        NONE,
        PLAY,
        RECORD
    }

    public enum STATE {
        MEDIA_NONE,
        MEDIA_STARTING,
        MEDIA_RUNNING,
        MEDIA_PAUSED,
        MEDIA_STOPPED,
        MEDIA_LOADING
    }

    public AudioPlayer(AudioHandler handler, String id, String file) {
        this.audioFile = null;
        this.tempFiles = null;
        this.handler = handler;
        this.context = handler.getApplicationContext();
        this.id = id;
        this.audioFile = file;
        this.tempFiles = new LinkedList<>();
    }

    private String createAudioFilePath(String fileName) {
        File cacheDir;
        if (Environment.getExternalStorageState().equals("mounted")) {
            cacheDir = this.context.getExternalFilesDir(null);
        } else {
            cacheDir = this.context.getCacheDir();
        }
        if (fileName == null || fileName.isEmpty()) {
            fileName = String.format("tmprecording-%d.3gp", Long.valueOf(System.currentTimeMillis()));
        }
        return cacheDir.getAbsolutePath() + File.separator + fileName;
    }

    public void destroy() {
        if (this.player != null) {
            if (this.state == STATE.MEDIA_RUNNING || this.state == STATE.MEDIA_PAUSED) {
                this.player.stop();
                setState(STATE.MEDIA_STOPPED);
            }
            this.player.release();
            this.player = null;
        }
        if (this.recorder != null) {
            if (this.state != STATE.MEDIA_STOPPED) {
                stopRecording(true);
            }
            this.recorder.release();
            this.recorder = null;
        }
    }

    public void startRecording(String file) {
        int i = AnonymousClass1.$SwitchMap$org$apache$cordova$media$AudioPlayer$MODE[this.mode.ordinal()];
        if (i == 1) {
            sendErrorStatus(MEDIA_ERR_ABORTED, "AudioPlayer Error: Can't record in play mode.");
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            sendErrorStatus(MEDIA_ERR_ABORTED, "AudioPlayer Error: Already recording.");
            return;
        }
        this.audioFile = file;
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.recorder = mediaRecorder;
        mediaRecorder.setAudioSource(1);
        this.recorder.setOutputFormat(6);
        this.recorder.setAudioEncoder(3);
        String createAudioFilePath = createAudioFilePath(null);
        this.tempFile = createAudioFilePath;
        this.recorder.setOutputFile(createAudioFilePath);
        try {
            this.recorder.prepare();
            this.recorder.start();
            setState(STATE.MEDIA_RUNNING);
        } catch (IOException e) {
            e.printStackTrace();
            sendErrorStatus(MEDIA_ERR_ABORTED, null);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            sendErrorStatus(MEDIA_ERR_ABORTED, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b A[Catch: Exception -> 0x012a, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x012a, blocks: (B:25:0x00c7, B:75:0x010b), top: B:8:0x005d }] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x012b -> B:28:0x01f6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void moveFile(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.media.AudioPlayer.moveFile(java.lang.String):void");
    }

    private static long copy(InputStream from, OutputStream to, boolean skipHeader) throws IOException {
        byte[] bArr = new byte[8096];
        if (skipHeader) {
            from.skip(6L);
        }
        long j = 0;
        while (true) {
            int read = from.read(bArr);
            if (read == -1) {
                return j;
            }
            to.write(bArr, 0, read);
            j += read;
        }
    }

    public void stopRecording(boolean stop) {
        if (this.recorder != null) {
            try {
                if (this.state == STATE.MEDIA_RUNNING) {
                    this.recorder.stop();
                }
                this.recorder.reset();
                if (!this.tempFiles.contains(this.tempFile)) {
                    this.tempFiles.add(this.tempFile);
                }
                if (stop) {
                    LOG.d(LOG_TAG, "stopping recording");
                    setState(STATE.MEDIA_STOPPED);
                    moveFile(this.audioFile);
                } else {
                    LOG.d(LOG_TAG, "pause recording");
                    setState(STATE.MEDIA_PAUSED);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resumeRecording() {
        startRecording(this.audioFile);
    }

    public void startPlaying(String file) {
        MediaPlayer mediaPlayer;
        if (readyPlayer(file) && (mediaPlayer = this.player) != null) {
            mediaPlayer.start();
            setState(STATE.MEDIA_RUNNING);
            this.seekOnPrepared = 0;
            return;
        }
        this.prepareOnly = false;
    }

    public void seekToPlaying(int milliseconds) {
        if (readyPlayer(this.audioFile)) {
            if (milliseconds > 0) {
                this.player.seekTo(milliseconds);
            }
            LOG.d(LOG_TAG, "Send a onStatus update for the new seek");
            sendStatusChange(MEDIA_POSITION, null, Float.valueOf(milliseconds / 1000.0f), null);
            return;
        }
        this.seekOnPrepared = milliseconds;
    }

    public void pausePlaying() {
        MediaPlayer mediaPlayer;
        if (this.state == STATE.MEDIA_RUNNING && (mediaPlayer = this.player) != null) {
            mediaPlayer.pause();
            setState(STATE.MEDIA_PAUSED);
        } else {
            sendErrorStatus(MEDIA_ERR_NONE_ACTIVE, "AudioPlayer Error: pausePlaying() called during invalid state: " + this.state.ordinal());
        }
    }

    public void stopPlaying() {
        if (this.state == STATE.MEDIA_RUNNING || this.state == STATE.MEDIA_PAUSED) {
            this.player.pause();
            this.player.seekTo(0);
            LOG.d(LOG_TAG, "stopPlaying is calling stopped");
            setState(STATE.MEDIA_STOPPED);
            return;
        }
        sendErrorStatus(MEDIA_ERR_NONE_ACTIVE, "AudioPlayer Error: stopPlaying() called during invalid state: " + this.state.ordinal());
    }

    public void resumePlaying() {
        startPlaying(this.audioFile);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer player) {
        LOG.d(LOG_TAG, "on completion is calling stopped");
        setState(STATE.MEDIA_STOPPED);
    }

    public long getCurrentPosition() {
        if (this.state != STATE.MEDIA_RUNNING && this.state != STATE.MEDIA_PAUSED) {
            return -1L;
        }
        int currentPosition = this.player.getCurrentPosition();
        sendStatusChange(MEDIA_POSITION, null, Float.valueOf(currentPosition / 1000.0f), null);
        return currentPosition;
    }

    public boolean isStreaming(String file) {
        return file.contains("http://") || file.contains("https://") || file.contains("rtsp://");
    }

    public float getDuration(String file) {
        if (this.recorder != null) {
            return -2.0f;
        }
        if (this.player != null) {
            return this.duration;
        }
        this.prepareOnly = true;
        startPlaying(file);
        return this.duration;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer player) {
        this.player.setOnCompletionListener(this);
        seekToPlaying(this.seekOnPrepared);
        if (this.setRateOnPrepared >= 0.0f) {
            MediaPlayer mediaPlayer = this.player;
            mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(this.setRateOnPrepared));
        }
        if (!this.prepareOnly) {
            this.player.start();
            setState(STATE.MEDIA_RUNNING);
            this.seekOnPrepared = 0;
        } else {
            setState(STATE.MEDIA_STARTING);
        }
        float durationInSeconds = getDurationInSeconds();
        this.duration = durationInSeconds;
        this.prepareOnly = true;
        sendStatusChange(MEDIA_DURATION, null, Float.valueOf(durationInSeconds), null);
    }

    private float getDurationInSeconds() {
        return this.player.getDuration() / 1000.0f;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer player, int arg1, int arg2) {
        this.state = STATE.MEDIA_STOPPED;
        destroy();
        sendErrorStatus(arg1, "AudioPlayer.onError(" + arg1 + ", " + arg2 + ")");
        return false;
    }

    private void setState(STATE state) {
        if (this.state != state) {
            sendStatusChange(MEDIA_STATE, null, Float.valueOf(state.ordinal()), null);
        }
        this.state = state;
    }

    private void setMode(MODE mode) {
        this.mode = mode;
    }

    public int getState() {
        return this.state.ordinal();
    }

    public void setVolume(float volume) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume, volume);
        } else {
            sendErrorStatus(MEDIA_ERR_NONE_ACTIVE, "AudioPlayer Error: Cannot set volume until the audio file is initialized.");
        }
    }

    private boolean playMode() {
        int i = AnonymousClass1.$SwitchMap$org$apache$cordova$media$AudioPlayer$MODE[this.mode.ordinal()];
        if (i == 2) {
            setMode(MODE.PLAY);
            return true;
        }
        if (i != 3) {
            return true;
        }
        sendErrorStatus(MEDIA_ERR_ABORTED, "AudioPlayer Error: Can't play in record mode.");
        return false;
    }

    /* renamed from: org.apache.cordova.media.AudioPlayer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$cordova$media$AudioPlayer$MODE;
        static final /* synthetic */ int[] $SwitchMap$org$apache$cordova$media$AudioPlayer$STATE;

        static {
            int[] iArr = new int[STATE.values().length];
            $SwitchMap$org$apache$cordova$media$AudioPlayer$STATE = iArr;
            try {
                iArr[STATE.MEDIA_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$cordova$media$AudioPlayer$STATE[STATE.MEDIA_LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$cordova$media$AudioPlayer$STATE[STATE.MEDIA_STARTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$cordova$media$AudioPlayer$STATE[STATE.MEDIA_RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$cordova$media$AudioPlayer$STATE[STATE.MEDIA_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$cordova$media$AudioPlayer$STATE[STATE.MEDIA_STOPPED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[MODE.values().length];
            $SwitchMap$org$apache$cordova$media$AudioPlayer$MODE = iArr2;
            try {
                iArr2[MODE.PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$cordova$media$AudioPlayer$MODE[MODE.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$cordova$media$AudioPlayer$MODE[MODE.RECORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private boolean readyPlayer(String file) {
        if (playMode()) {
            switch (AnonymousClass1.$SwitchMap$org$apache$cordova$media$AudioPlayer$STATE[this.state.ordinal()]) {
                case 1:
                    if (this.player == null) {
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        this.player = mediaPlayer;
                        mediaPlayer.setOnErrorListener(this);
                    }
                    try {
                        loadAudioFile(file);
                        break;
                    } catch (Exception e) {
                        sendErrorStatus(MEDIA_ERR_ABORTED, e.getMessage());
                        break;
                    }
                case 2:
                    LOG.d(LOG_TAG, "AudioPlayer Loading: startPlaying() called during media preparation: " + STATE.MEDIA_STARTING.ordinal());
                    this.prepareOnly = false;
                    return false;
                case 3:
                case 4:
                case 5:
                    return true;
                case 6:
                    if (file != null && this.audioFile.compareTo(file) == 0) {
                        MediaPlayer mediaPlayer2 = this.player;
                        if (mediaPlayer2 == null) {
                            MediaPlayer mediaPlayer3 = new MediaPlayer();
                            this.player = mediaPlayer3;
                            mediaPlayer3.setOnErrorListener(this);
                            this.prepareOnly = false;
                            try {
                                loadAudioFile(file);
                            } catch (Exception e2) {
                                sendErrorStatus(MEDIA_ERR_ABORTED, e2.getMessage());
                            }
                            return false;
                        }
                        mediaPlayer2.seekTo(0);
                        this.player.pause();
                        return true;
                    }
                    this.player.reset();
                    try {
                        loadAudioFile(file);
                    } catch (Exception e3) {
                        sendErrorStatus(MEDIA_ERR_ABORTED, e3.getMessage());
                    }
                    return false;
                default:
                    sendErrorStatus(MEDIA_ERR_ABORTED, "AudioPlayer Error: startPlaying() called during invalid state: " + this.state);
                    break;
            }
        }
        return false;
    }

    private void loadAudioFile(String file) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (isStreaming(file)) {
            this.player.setDataSource(file);
            this.player.setAudioStreamType(3);
            setMode(MODE.PLAY);
            setState(STATE.MEDIA_STARTING);
            this.player.setOnPreparedListener(this);
            this.player.prepareAsync();
            return;
        }
        if (file.startsWith("/android_asset/")) {
            AssetFileDescriptor openFd = this.handler.cordova.getActivity().getAssets().openFd(file.substring(15));
            this.player.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
        } else if (new File(file).exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            this.player.setDataSource(fileInputStream.getFD());
            fileInputStream.close();
        } else {
            this.player.setDataSource(createAudioFilePath(file));
        }
        setState(STATE.MEDIA_STARTING);
        this.player.setOnPreparedListener(this);
        this.player.prepare();
        this.duration = getDurationInSeconds();
    }

    private void sendErrorStatus(int errorCode, String errorMessage) {
        sendStatusChange(MEDIA_ERROR, Integer.valueOf(errorCode), null, errorMessage);
    }

    private void sendStatusChange(int messageType, Integer additionalCode, Float value, String errorMessage) {
        if (additionalCode != null && value != null) {
            throw new IllegalArgumentException("Only one of additionalCode or value can be specified, not both");
        }
        if (errorMessage != null) {
            LOG.d(LOG_TAG, errorMessage);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("msgType", messageType);
            if (additionalCode != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", additionalCode.intValue());
                if (errorMessage != null) {
                    jSONObject2.put("message", errorMessage);
                }
                jSONObject.put("value", jSONObject2);
            } else if (value != null) {
                jSONObject.put("value", value.floatValue());
            }
        } catch (JSONException e) {
            LOG.e(LOG_TAG, "Failed to create status details", e);
        }
        this.handler.sendEventMessage(NotificationCompat.CATEGORY_STATUS, jSONObject);
    }

    public float getCurrentAmplitude() {
        if (this.recorder == null) {
            return 0.0f;
        }
        try {
            if (this.state == STATE.MEDIA_RUNNING) {
                return this.recorder.getMaxAmplitude() / 32762.0f;
            }
            return 0.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public void setRate(float rate) {
        if (Build.VERSION.SDK_INT < 23) {
            LOG.d(LOG_TAG, "AudioPlayer Warning: Request to set playback rate not supported on current OS version");
            return;
        }
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            try {
                boolean isPlaying = mediaPlayer.isPlaying();
                MediaPlayer mediaPlayer2 = this.player;
                mediaPlayer2.setPlaybackParams(mediaPlayer2.getPlaybackParams().setSpeed(rate));
                if (isPlaying || !this.player.isPlaying()) {
                    return;
                }
                this.player.pause();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.setRateOnPrepared = rate;
    }
}
