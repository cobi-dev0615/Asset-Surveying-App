package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
class MeteringRepeatingSession {
    private static final int IMAGE_FORMAT = 34;
    private static final String TAG = "MeteringRepeating";
    private DeferrableSurface mDeferrableSurface;
    private final Size mMeteringRepeatingSize;
    private SessionConfig mSessionConfig;
    private final SurfaceResetCallback mSurfaceResetCallback;
    private final SupportedRepeatingSurfaceSize mSupportedRepeatingSurfaceSize = new SupportedRepeatingSurfaceSize();
    private SessionConfig.CloseableErrorListener mCloseableErrorListener = null;
    private final MeteringRepeatingConfig mConfigWithDefaults = new MeteringRepeatingConfig();

    interface SurfaceResetCallback {
        void onSurfaceReset();
    }

    MeteringRepeatingSession(CameraCharacteristicsCompat cameraCharacteristicsCompat, DisplayInfoManager displayInfoManager, SurfaceResetCallback surfaceResetCallback) {
        this.mSurfaceResetCallback = surfaceResetCallback;
        Size properPreviewSize = getProperPreviewSize(cameraCharacteristicsCompat, displayInfoManager);
        this.mMeteringRepeatingSize = properPreviewSize;
        Logger.d(TAG, "MeteringSession SurfaceTexture size: " + properPreviewSize);
        this.mSessionConfig = createSessionConfig();
    }

    SessionConfig createSessionConfig() {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(this.mMeteringRepeatingSize.getWidth(), this.mMeteringRepeatingSize.getHeight());
        final Surface surface = new Surface(surfaceTexture);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(this.mConfigWithDefaults, this.mMeteringRepeatingSize);
        createFrom.setTemplateType(1);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        this.mDeferrableSurface = immediateSurface;
        Futures.addCallback(immediateSurface.getTerminationFuture(), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.MeteringRepeatingSession.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
                surface.release();
                surfaceTexture.release();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            }
        }, CameraXExecutors.directExecutor());
        createFrom.addSurface(this.mDeferrableSurface);
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.camera2.internal.MeteringRepeatingSession$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                MeteringRepeatingSession.this.m78x1b0a2abb(sessionConfig, sessionError);
            }
        });
        this.mCloseableErrorListener = closeableErrorListener2;
        createFrom.setErrorListener(closeableErrorListener2);
        return createFrom.build();
    }

    /* renamed from: lambda$createSessionConfig$0$androidx-camera-camera2-internal-MeteringRepeatingSession, reason: not valid java name */
    /* synthetic */ void m78x1b0a2abb(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.mSessionConfig = createSessionConfig();
        SurfaceResetCallback surfaceResetCallback = this.mSurfaceResetCallback;
        if (surfaceResetCallback != null) {
            surfaceResetCallback.onSurfaceReset();
        }
    }

    UseCaseConfig<?> getUseCaseConfig() {
        return this.mConfigWithDefaults;
    }

    SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    Size getMeteringRepeatingSize() {
        return this.mMeteringRepeatingSize;
    }

    String getName() {
        return TAG;
    }

    void clear() {
        Logger.d(TAG, "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = null;
    }

    private static class MeteringRepeatingConfig implements UseCaseConfig<UseCase> {
        private final Config mConfig;

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ boolean containsOption(Config.Option option) {
            boolean containsOption;
            containsOption = getConfig().containsOption(option);
            return containsOption;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            getConfig().findOptions(str, optionMatcher);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this, optionUnpacker);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this, captureConfig);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig getDefaultSessionConfig() {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this, sessionConfig);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig
        public /* synthetic */ DynamicRange getDynamicRange() {
            return ImageInputConfig.CC.$default$getDynamicRange(this);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig
        public /* synthetic */ int getInputFormat() {
            int intValue;
            intValue = ((Integer) retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
            return intValue;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            Config.OptionPriority optionPriority;
            optionPriority = getConfig().getOptionPriority(option);
            return optionPriority;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ int getPreviewStabilizationMode() {
            int intValue;
            intValue = ((Integer) retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue();
            return intValue;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Set getPriorities(Config.Option option) {
            Set priorities;
            priorities = getConfig().getPriorities(option);
            return priorities;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this, optionUnpacker);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ int getSurfaceOccupancyPriority() {
            int intValue;
            intValue = ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
            return intValue;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ int getSurfaceOccupancyPriority(int i) {
            int intValue;
            intValue = ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i))).intValue();
            return intValue;
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public /* synthetic */ Class getTargetClass() {
            return TargetConfig.CC.$default$getTargetClass(this);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public /* synthetic */ Class getTargetClass(Class cls) {
            return TargetConfig.CC.$default$getTargetClass(this, cls);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ Range getTargetFrameRate() {
            return UseCaseConfig.CC.$default$getTargetFrameRate(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ Range getTargetFrameRate(Range range) {
            return UseCaseConfig.CC.$default$getTargetFrameRate(this, range);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public /* synthetic */ String getTargetName() {
            return TargetConfig.CC.$default$getTargetName(this);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public /* synthetic */ String getTargetName(String str) {
            return TargetConfig.CC.$default$getTargetName(this, str);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ int getVideoStabilizationMode() {
            int intValue;
            intValue = ((Integer) retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0)).intValue();
            return intValue;
        }

        @Override // androidx.camera.core.impl.ImageInputConfig
        public /* synthetic */ boolean hasDynamicRange() {
            boolean containsOption;
            containsOption = containsOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE);
            return containsOption;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ boolean isHighResolutionDisabled(boolean z) {
            boolean booleanValue;
            booleanValue = ((Boolean) retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z))).booleanValue();
            return booleanValue;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public /* synthetic */ boolean isZslDisabled(boolean z) {
            boolean booleanValue;
            booleanValue = ((Boolean) retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z))).booleanValue();
            return booleanValue;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Set listOptions() {
            Set listOptions;
            listOptions = getConfig().listOptions();
            return listOptions;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object retrieveOption(Config.Option option) {
            Object retrieveOption;
            retrieveOption = getConfig().retrieveOption(option);
            return retrieveOption;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            Object retrieveOption;
            retrieveOption = getConfig().retrieveOption(option, obj);
            return retrieveOption;
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            Object retrieveOptionWithPriority;
            retrieveOptionWithPriority = getConfig().retrieveOptionWithPriority(option, optionPriority);
            return retrieveOptionWithPriority;
        }

        MeteringRepeatingConfig() {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new Camera2SessionOptionUnpacker());
            create.insertOption(OPTION_INPUT_FORMAT, 34);
            setTargetConfigs(create);
            this.mConfig = create;
        }

        @Override // androidx.camera.core.impl.ReadableConfig
        public Config getConfig() {
            return this.mConfig;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public UseCaseConfigFactory.CaptureType getCaptureType() {
            return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        }

        private void setTargetConfigs(MutableOptionsBundle mutableOptionsBundle) {
            mutableOptionsBundle.insertOption(OPTION_TARGET_CLASS, MeteringRepeatingSession.class);
            mutableOptionsBundle.insertOption(OPTION_TARGET_NAME, MeteringRepeatingSession.class.getCanonicalName() + "-" + UUID.randomUUID());
        }
    }

    private Size getProperPreviewSize(CameraCharacteristicsCompat cameraCharacteristicsCompat, DisplayInfoManager displayInfoManager) {
        Size[] outputSizes = cameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(34);
        if (outputSizes == null) {
            Logger.e(TAG, "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] supportedSizes = this.mSupportedRepeatingSurfaceSize.getSupportedSizes(outputSizes);
        List asList = Arrays.asList(supportedSizes);
        Collections.sort(asList, new Comparator() { // from class: androidx.camera.camera2.internal.MeteringRepeatingSession$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int signum;
                Size size = (Size) obj;
                Size size2 = (Size) obj2;
                signum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
                return signum;
            }
        });
        Size previewSize = displayInfoManager.getPreviewSize();
        long min = Math.min(previewSize.getWidth() * previewSize.getHeight(), 307200L);
        int length = supportedSizes.length;
        Size size = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Size size2 = supportedSizes[i];
            long width = size2.getWidth() * size2.getHeight();
            if (width == min) {
                return size2;
            }
            if (width <= min) {
                i++;
                size = size2;
            } else if (size != null) {
                return size;
            }
        }
        return (Size) asList.get(0);
    }
}
