package com.devexpress.editors.pickers;

import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import kotlin.Metadata;

/* compiled from: DateEditPicker.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"com/devexpress/editors/pickers/DateEditPicker$velocityTracker$1", "", "<set-?>", "", "averageVelocity", "getAverageVelocity", "()D", "lastPosition", "", "lastTime", "", "startTracking", "", "position", "updatePosition", "dxeditors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DateEditPicker$velocityTracker$1 {
    private double averageVelocity;
    private float lastPosition;
    private long lastTime;

    DateEditPicker$velocityTracker$1() {
    }

    public final double getAverageVelocity() {
        return this.averageVelocity;
    }

    public final void startTracking(float position) {
        this.lastPosition = position;
        this.lastTime = SystemClock.elapsedRealtime();
        this.averageVelocity = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final void updatePosition(float position) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        float f = position - this.lastPosition;
        this.lastPosition = position;
        long j = elapsedRealtime - this.lastTime;
        this.lastTime = elapsedRealtime;
        double d = this.averageVelocity;
        this.averageVelocity = d + (((f / (j + 1)) - d) * 0.25f);
    }
}
