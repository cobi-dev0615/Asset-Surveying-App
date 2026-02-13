package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzmu;
import com.google.android.gms.internal.mlkit_common.zzna;
import com.google.android.gms.internal.mlkit_common.zzsh;
import com.google.android.gms.internal.mlkit_common.zzsk;
import com.google.android.gms.internal.mlkit_common.zzss;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes3.dex */
public class RemoteModelDownloadManager {
    private static final GmsLogger zza = new GmsLogger("ModelDownloadManager", "");
    private static final Map zzb = new HashMap();
    private final LongSparseArray zzc = new LongSparseArray();
    private final LongSparseArray zzd = new LongSparseArray();
    private final MlKitContext zze;
    private final DownloadManager zzf;
    private final RemoteModel zzg;
    private final ModelType zzh;
    private final zzsh zzi;
    private final SharedPrefManager zzj;
    private final ModelFileHelper zzk;
    private final ModelInfoRetrieverInterop zzl;
    private final RemoteModelFileManager zzm;
    private DownloadConditions zzn;

    RemoteModelDownloadManager(MlKitContext mlKitContext, RemoteModel remoteModel, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop, zzsh zzshVar) {
        this.zze = mlKitContext;
        this.zzh = remoteModel.getModelType();
        this.zzg = remoteModel;
        DownloadManager downloadManager = (DownloadManager) mlKitContext.getApplicationContext().getSystemService("download");
        this.zzf = downloadManager;
        this.zzi = zzshVar;
        if (downloadManager == null) {
            zza.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.zzk = modelFileHelper;
        this.zzj = SharedPrefManager.getInstance(mlKitContext);
        this.zzl = modelInfoRetrieverInterop;
        this.zzm = remoteModelFileManager;
    }

    public static synchronized RemoteModelDownloadManager getInstance(MlKitContext mlKitContext, RemoteModel remoteModel, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        RemoteModelDownloadManager remoteModelDownloadManager;
        synchronized (RemoteModelDownloadManager.class) {
            Map map = zzb;
            if (!map.containsKey(remoteModel)) {
                map.put(remoteModel, new RemoteModelDownloadManager(mlKitContext, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop, zzss.zzb("common")));
            }
            remoteModelDownloadManager = (RemoteModelDownloadManager) map.get(remoteModel);
        }
        return remoteModelDownloadManager;
    }

    private final Task zzj(long j) {
        MlKitContext mlKitContext = this.zze;
        ContextCompat.registerReceiver(mlKitContext.getApplicationContext(), zzm(j), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, MLTaskExecutor.getInstance().getHandler(), 2);
        return zzk(j).getTask();
    }

    private final synchronized TaskCompletionSource zzk(long j) {
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzd.get(j);
        if (taskCompletionSource != null) {
            return taskCompletionSource;
        }
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        this.zzd.put(j, taskCompletionSource2);
        return taskCompletionSource2;
    }

    private final synchronized zzc zzm(long j) {
        zzc zzcVar = (zzc) this.zzc.get(j);
        if (zzcVar != null) {
            return zzcVar;
        }
        zzc zzcVar2 = new zzc(this, j, zzk(j), null);
        this.zzc.put(j, zzcVar2);
        return zzcVar2;
    }

    private final synchronized Long zzn(DownloadManager.Request request, ModelInfo modelInfo) {
        DownloadManager downloadManager = this.zzf;
        if (downloadManager == null) {
            return null;
        }
        long enqueue = downloadManager.enqueue(request);
        zza.d("ModelDownloadManager", "Schedule a new downloading task: " + enqueue);
        this.zzj.setDownloadingModelInfo(enqueue, modelInfo);
        this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, false, modelInfo.getModelType(), zzna.SCHEDULED);
        return Long.valueOf(enqueue);
    }

    private final synchronized Long zzo(ModelInfo modelInfo, DownloadConditions downloadConditions) throws MlKitException {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        String downloadingModelHash = this.zzj.getDownloadingModelHash(this.zzg);
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        if (downloadingModelHash != null && downloadingModelHash.equals(modelInfo.getModelHash()) && downloadingModelStatusCode != null) {
            Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
            if (downloadingModelStatusCode2 == null || (downloadingModelStatusCode2.intValue() != 8 && downloadingModelStatusCode2.intValue() != 16)) {
                zzsh zzshVar = this.zzi;
                RemoteModel remoteModel = this.zzg;
                zzshVar.zzf(zzsk.zzg(), remoteModel, zzmu.NO_ERROR, false, remoteModel.getModelType(), zzna.DOWNLOADING);
            }
            zza.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
            return null;
        }
        GmsLogger gmsLogger = zza;
        gmsLogger.d("ModelDownloadManager", "Need to download a new model.");
        removeOrCancelDownload();
        DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
        if (this.zzk.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
            gmsLogger.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
            this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, false, modelInfo.getModelType(), zzna.UPDATE_AVAILABLE);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            request.setRequiresCharging(downloadConditions.isChargingRequired());
        }
        if (downloadConditions.isWifiRequired()) {
            request.setAllowedNetworkTypes(2);
        }
        return zzn(request, modelInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
    
        r1 = zzo(r1, r13.zzn);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b2, code lost:
    
        if (r1 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
    
        return zzj(r1.longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.zza.i("ModelDownloadManager", "Didn't schedule download for the updated model");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.tasks.Task<java.lang.Void> ensureModelDownloaded() {
        /*
            r13 = this;
            com.google.android.gms.internal.mlkit_common.zzsh r0 = r13.zzi
            com.google.android.gms.internal.mlkit_common.zzry r1 = com.google.android.gms.internal.mlkit_common.zzsk.zzg()
            com.google.mlkit.common.model.RemoteModel r2 = r13.zzg
            com.google.android.gms.internal.mlkit_common.zzmu r3 = com.google.android.gms.internal.mlkit_common.zzmu.NO_ERROR
            com.google.mlkit.common.sdkinternal.ModelType r5 = com.google.mlkit.common.sdkinternal.ModelType.UNKNOWN
            com.google.android.gms.internal.mlkit_common.zzna r6 = com.google.android.gms.internal.mlkit_common.zzna.EXPLICITLY_REQUESTED
            r4 = 0
            r0.zzf(r1, r2, r3, r4, r5, r6)
            r0 = 0
            com.google.mlkit.common.sdkinternal.ModelInfo r1 = r13.zzg()     // Catch: com.google.mlkit.common.MlKitException -> L19
            r2 = r0
            goto L1c
        L19:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L1c:
            r3 = 13
            java.lang.Integer r4 = r13.getDownloadingModelStatusCode()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.Long r5 = r13.getDownloadingId()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            boolean r6 = r13.modelExistsLocally()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            if (r6 != 0) goto Laa
            if (r4 == 0) goto L38
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 8
            if (r6 != r7) goto L38
            goto Laa
        L38:
            if (r4 == 0) goto L4e
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 16
            if (r6 != r7) goto L4e
            com.google.mlkit.common.MlKitException r0 = r13.zzl(r5)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r13.removeOrCancelDownload()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        L4e:
            if (r4 == 0) goto L8a
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 4
            if (r6 == r7) goto L65
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 2
            if (r6 == r7) goto L65
            int r4 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r6 = 1
            if (r4 != r6) goto L8a
        L65:
            if (r5 == 0) goto L8a
            java.lang.String r4 = r13.getDownloadingModelHash()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            if (r4 == 0) goto L8a
            com.google.android.gms.internal.mlkit_common.zzsh r6 = r13.zzi     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.internal.mlkit_common.zzry r7 = com.google.android.gms.internal.mlkit_common.zzsk.zzg()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.mlkit.common.model.RemoteModel r8 = r13.zzg     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.internal.mlkit_common.zzmu r9 = com.google.android.gms.internal.mlkit_common.zzmu.NO_ERROR     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.mlkit.common.sdkinternal.ModelType r11 = r8.getModelType()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.internal.mlkit_common.zzna r12 = com.google.android.gms.internal.mlkit_common.zzna.DOWNLOADING     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r10 = 0
            r6.zzf(r7, r8, r9, r10, r11, r12)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            long r0 = r5.longValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = r13.zzj(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        L8a:
            if (r1 != 0) goto L8d
            goto L93
        L8d:
            com.google.mlkit.common.model.DownloadConditions r0 = r13.zzn     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.Long r0 = r13.zzo(r1, r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
        L93:
            if (r0 != 0) goto La1
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.String r1 = "Failed to schedule the download task"
            r0.<init>(r1, r3, r2)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        La1:
            long r0 = r0.longValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = r13.zzj(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        Laa:
            if (r1 == 0) goto Lc6
            com.google.mlkit.common.model.DownloadConditions r2 = r13.zzn     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.Long r1 = r13.zzo(r1, r2)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            if (r1 == 0) goto Lbd
            long r0 = r1.longValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = r13.zzj(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        Lbd:
            com.google.android.gms.common.internal.GmsLogger r1 = com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.zza     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.String r2 = "ModelDownloadManager"
            java.lang.String r4 = "Didn't schedule download for the updated model"
            r1.i(r2, r4)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
        Lc6:
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        Lcb:
            r0 = move-exception
            com.google.mlkit.common.MlKitException r1 = new com.google.mlkit.common.MlKitException
            java.lang.String r2 = "Failed to ensure the model is downloaded."
            r1.<init>(r2, r3, r0)
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.ensureModelDownloaded():com.google.android.gms.tasks.Task");
    }

    public synchronized ParcelFileDescriptor getDownloadedFile() {
        DownloadManager downloadManager = this.zzf;
        Long downloadingId = getDownloadingId();
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (downloadManager == null || downloadingId == null) {
            return null;
        }
        try {
            parcelFileDescriptor = downloadManager.openDownloadedFile(downloadingId.longValue());
        } catch (FileNotFoundException unused) {
            zza.e("ModelDownloadManager", "Downloaded file is not found");
        }
        return parcelFileDescriptor;
    }

    public synchronized Long getDownloadingId() {
        return this.zzj.getDownloadingModelId(this.zzg);
    }

    public synchronized String getDownloadingModelHash() {
        return this.zzj.getDownloadingModelHash(this.zzg);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        if (r3.intValue() != 16) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[Catch: all -> 0x003c, TRY_ENTER, TryCatch #1 {all -> 0x003c, blocks: (B:38:0x0027, B:40:0x002d, B:13:0x0047, B:15:0x004e, B:17:0x0055, B:19:0x005b, B:21:0x0063), top: B:37:0x0027, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.lang.Integer getDownloadingModelStatusCode() {
        /*
            r8 = this;
            monitor-enter(r8)
            android.app.DownloadManager r0 = r8.zzf     // Catch: java.lang.Throwable -> L7d
            java.lang.Long r1 = r8.getDownloadingId()     // Catch: java.lang.Throwable -> L7d
            r2 = 0
            if (r0 == 0) goto L7b
            if (r1 != 0) goto Le
            goto L7b
        Le:
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query     // Catch: java.lang.Throwable -> L7d
            r3.<init>()     // Catch: java.lang.Throwable -> L7d
            long r4 = r1.longValue()     // Catch: java.lang.Throwable -> L7d
            r1 = 1
            long[] r6 = new long[r1]     // Catch: java.lang.Throwable -> L7d
            r7 = 0
            r6[r7] = r4     // Catch: java.lang.Throwable -> L7d
            android.app.DownloadManager$Query r3 = r3.setFilterById(r6)     // Catch: java.lang.Throwable -> L7d
            android.database.Cursor r0 = r0.query(r3)     // Catch: java.lang.Throwable -> L7d
            if (r0 == 0) goto L3e
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            java.lang.String r3 = "status"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3c
            int r3 = r0.getInt(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3c
            goto L3f
        L3c:
            r1 = move-exception
            goto L72
        L3e:
            r3 = r2
        L3f:
            if (r3 != 0) goto L47
            if (r0 == 0) goto L7b
            r0.close()     // Catch: java.lang.Throwable -> L7d
            goto L7b
        L47:
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r5 = 2
            if (r4 == r5) goto L6c
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r5 = 4
            if (r4 == r5) goto L6c
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            if (r4 == r1) goto L6c
            int r1 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r4 = 8
            if (r1 == r4) goto L6c
            int r1 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r4 = 16
            if (r1 == r4) goto L6c
            goto L6d
        L6c:
            r2 = r3
        L6d:
            r0.close()     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r8)
            return r2
        L72:
            r0.close()     // Catch: java.lang.Throwable -> L76
            goto L7a
        L76:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L7d
        L7a:
            throw r1     // Catch: java.lang.Throwable -> L7d
        L7b:
            monitor-exit(r8)
            return r2
        L7d:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L7d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.getDownloadingModelStatusCode():java.lang.Integer");
    }

    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            zza.d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            zza.d("ModelDownloadManager", "No new model is downloading.");
            removeOrCancelDownload();
            return false;
        }
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        GmsLogger gmsLogger = zza;
        Objects.toString(downloadingModelStatusCode);
        gmsLogger.d("ModelDownloadManager", "Download Status code: ".concat(String.valueOf(downloadingModelStatusCode)));
        if (downloadingModelStatusCode != null) {
            return com.google.android.gms.common.internal.Objects.equal(downloadingModelStatusCode, 8) && zzi(downloadingModelHash) != null;
        }
        removeOrCancelDownload();
        return false;
    }

    public boolean modelExistsLocally() throws MlKitException {
        return this.zzk.modelExistsLocally(this.zzg.getUniqueModelNameForPersist(), this.zzh);
    }

    public synchronized void removeOrCancelDownload() throws MlKitException {
        DownloadManager downloadManager = this.zzf;
        Long downloadingId = getDownloadingId();
        if (downloadManager != null && downloadingId != null) {
            GmsLogger gmsLogger = zza;
            Objects.toString(downloadingId);
            gmsLogger.d("ModelDownloadManager", "Cancel or remove existing downloading task: ".concat(downloadingId.toString()));
            if (this.zzf.remove(downloadingId.longValue()) > 0 || getDownloadingModelStatusCode() == null) {
                ModelFileHelper modelFileHelper = this.zzk;
                RemoteModel remoteModel = this.zzg;
                modelFileHelper.deleteTempFilesInPrivateFolder(remoteModel.getUniqueModelNameForPersist(), remoteModel.getModelType());
                this.zzj.clearDownloadingModelInfo(this.zzg);
            }
        }
    }

    public void setDownloadConditions(DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.zzn = downloadConditions;
    }

    public synchronized void updateLatestModelHashAndType(String str) throws MlKitException {
        this.zzj.setLatestModelHash(this.zzg, str);
        removeOrCancelDownload();
    }

    final synchronized ModelInfo zzg() throws MlKitException {
        boolean modelExistsLocally = modelExistsLocally();
        if (modelExistsLocally) {
            zzsh zzshVar = this.zzi;
            RemoteModel remoteModel = this.zzg;
            zzshVar.zzf(zzsk.zzg(), remoteModel, zzmu.NO_ERROR, false, remoteModel.getModelType(), zzna.LIVE);
        }
        ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.zzl;
        if (modelInfoRetrieverInterop == null) {
            throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
        }
        ModelInfo retrieveRemoteModelInfo = modelInfoRetrieverInterop.retrieveRemoteModelInfo(this.zzg);
        if (retrieveRemoteModelInfo == null) {
            return null;
        }
        MlKitContext mlKitContext = this.zze;
        RemoteModel remoteModel2 = this.zzg;
        String modelHash = retrieveRemoteModelInfo.getModelHash();
        SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(mlKitContext);
        boolean equals = modelHash.equals(sharedPrefManager.getIncompatibleModelHash(remoteModel2));
        boolean z = false;
        boolean z2 = true;
        if (equals && CommonUtils.getAppVersion(mlKitContext.getApplicationContext()).equals(sharedPrefManager.getPreviousAppVersion())) {
            zza.e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
            z2 = false;
        }
        if (!modelExistsLocally) {
            this.zzj.clearLatestModelHash(this.zzg);
        }
        boolean equals2 = retrieveRemoteModelInfo.getModelHash().equals(SharedPrefManager.getInstance(this.zze).getLatestModelHash(this.zzg));
        boolean z3 = !equals2;
        if (!z2) {
            z = z3;
        } else if (!modelExistsLocally || !equals2) {
            return retrieveRemoteModelInfo;
        }
        if (modelExistsLocally && (z ^ z2)) {
            return null;
        }
        throw new MlKitException("The model " + this.zzg.getModelName() + " is incompatible with TFLite runtime", 100);
    }

    public final File zzi(String str) throws MlKitException {
        GmsLogger gmsLogger = zza;
        gmsLogger.d("ModelDownloadManager", "Model downloaded successfully");
        this.zzi.zzf(zzsk.zzg(), this.zzg, zzmu.NO_ERROR, true, this.zzh, zzna.SUCCEEDED);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.zzm.moveModelToPrivateFolder(downloadedFile, str, this.zzg);
        } finally {
            removeOrCancelDownload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MlKitException zzl(Long l) {
        DownloadManager downloadManager = this.zzf;
        Cursor cursor = null;
        if (downloadManager != null && l != null) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        int i = 13;
        String str = "Model downloading failed";
        if (cursor != null && cursor.moveToFirst()) {
            int i2 = cursor.getInt(cursor.getColumnIndex("reason"));
            if (i2 == 1006) {
                str = "Model downloading failed due to insufficient space on the device.";
                i = 101;
            } else {
                str = "Model downloading failed due to error code: " + i2 + " from Android DownloadManager";
            }
        }
        return new MlKitException(str, i);
    }

    public int getFailureReason(Long l) {
        int columnIndex;
        DownloadManager downloadManager = this.zzf;
        Cursor cursor = null;
        if (downloadManager != null && l != null) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        if (cursor == null || !cursor.moveToFirst() || (columnIndex = cursor.getColumnIndex("reason")) == -1) {
            return 0;
        }
        return cursor.getInt(columnIndex);
    }
}
