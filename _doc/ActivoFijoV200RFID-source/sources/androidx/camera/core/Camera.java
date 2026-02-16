package androidx.camera.core;

import androidx.camera.core.impl.CameraConfig;

/* loaded from: classes.dex */
public interface Camera {
    CameraControl getCameraControl();

    CameraInfo getCameraInfo();

    CameraConfig getExtendedConfig();

    boolean isUseCasesCombinationSupported(boolean z, UseCase... useCaseArr);

    boolean isUseCasesCombinationSupported(UseCase... useCaseArr);

    boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr);

    /* renamed from: androidx.camera.core.Camera$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isUseCasesCombinationSupported(Camera _this, boolean z, UseCase... useCaseArr) {
            return true;
        }
    }
}
