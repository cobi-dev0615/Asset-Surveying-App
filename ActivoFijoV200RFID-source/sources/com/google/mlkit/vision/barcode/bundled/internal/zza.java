package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.Image;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzam;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzau;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzav;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbe;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbm;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzci;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.MultiScaleDecodingOptions;
import com.google.android.libraries.barhopper.MultiScaleDetectionOptions;
import com.google.android.libraries.barhopper.RecognitionOptions;
import com.google.barhopper.deeplearning.BarhopperV3Options;
import com.google.barhopper.deeplearning.zzab;
import com.google.barhopper.deeplearning.zzac;
import com.google.barhopper.deeplearning.zze;
import com.google.barhopper.deeplearning.zzf;
import com.google.barhopper.deeplearning.zzh;
import com.google.barhopper.deeplearning.zzi;
import com.google.barhopper.deeplearning.zzk;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.photos.vision.barhopper.BarhopperProto$BarhopperResponse;
import com.google.photos.vision.barhopper.zzae;
import com.google.photos.vision.barhopper.zzaf;
import com.google.photos.vision.barhopper.zzah;
import com.google.photos.vision.barhopper.zzak;
import com.google.photos.vision.barhopper.zzb;
import com.google.photos.vision.barhopper.zzc;
import com.google.photos.vision.barhopper.zzl;
import com.google.photos.vision.barhopper.zzn;
import com.google.photos.vision.barhopper.zzp;
import com.google.photos.vision.barhopper.zzr;
import com.google.photos.vision.barhopper.zzv;
import com.google.photos.vision.barhopper.zzz;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes3.dex */
final class zza extends zzbm {
    private static final int[] zza = {5, 7, 7, 7, 5, 5};
    private static final double[][] zzb = {new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, new double[]{0.5d, 1.0d}, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};
    private final Context zzc;
    private final zzba zzd;
    private BarhopperV3 zze;

    zza(Context context, zzba zzbaVar) {
        this.zzc = context;
        this.zzd = zzbaVar;
    }

    private final RecognitionOptions zzg() {
        RecognitionOptions recognitionOptions = new RecognitionOptions();
        recognitionOptions.setBarcodeFormats(this.zzd.zza());
        recognitionOptions.setOutputUnrecognizedBarcodes(this.zzd.zzb());
        recognitionOptions.setEnableQrAlignmentGrid(true);
        recognitionOptions.setEnableUseKeypointAsFinderPattern(true);
        return recognitionOptions;
    }

    private static zzan zzh(zzl zzlVar, String str, String str2) {
        if (zzlVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzan(zzlVar.zzf(), zzlVar.zzd(), zzlVar.zza(), zzlVar.zzb(), zzlVar.zzc(), zzlVar.zze(), zzlVar.zzj(), matcher.find() ? matcher.group(1) : null);
    }

    private final BarhopperProto$BarhopperResponse zzi(ByteBuffer byteBuffer, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperV3 barhopperV3 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
        if (((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).isDirect()) {
            return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), byteBuffer, recognitionOptions);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), byteBuffer.array(), recognitionOptions);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), bArr, recognitionOptions);
    }

    private final List zzj(IObjectWrapper iObjectWrapper, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperProto$BarhopperResponse recognize;
        zzar zzarVar;
        zzau zzauVar;
        zzav zzavVar;
        zzax zzaxVar;
        zzaw zzawVar;
        zzas zzasVar;
        zzao zzaoVar;
        int i;
        zzap zzapVar;
        zzaq zzaqVar;
        int i2;
        Point[] pointArr;
        int i3;
        zzau[] zzauVarArr;
        zzar[] zzarVarArr;
        zzam[] zzamVarArr;
        int zzb2 = zzccVar.zzb();
        int i4 = -1;
        int i5 = 0;
        if (zzb2 != -1) {
            if (zzb2 != 17) {
                if (zzb2 == 35) {
                    recognize = zzi(((Image) Preconditions.checkNotNull((Image) ObjectWrapper.unwrap(iObjectWrapper))).getPlanes()[0].getBuffer(), zzccVar, recognitionOptions);
                } else if (zzb2 != 842094169) {
                    throw new IllegalArgumentException("Unsupported image format: " + zzccVar.zzb());
                }
            }
            recognize = zzi((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzccVar, recognitionOptions);
        } else {
            recognize = ((BarhopperV3) Preconditions.checkNotNull(this.zze)).recognize((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), recognitionOptions);
        }
        ArrayList arrayList = new ArrayList();
        Matrix uprightRotationMatrix = ImageUtils.getInstance().getUprightRotationMatrix(zzccVar.zzd(), zzccVar.zza(), zzccVar.zzc());
        for (zzc zzcVar : recognize.zzc()) {
            if (zzcVar.zza() > 0 && uprightRotationMatrix != null) {
                float[] fArr = new float[8];
                List zzo = zzcVar.zzo();
                int zza2 = zzcVar.zza();
                for (int i6 = i5; i6 < zza2; i6++) {
                    int i7 = i6 + i6;
                    fArr[i7] = ((zzaf) zzo.get(i6)).zza();
                    fArr[i7 + 1] = ((zzaf) zzo.get(i6)).zzb();
                }
                uprightRotationMatrix.mapPoints(fArr);
                int zzc = zzccVar.zzc();
                for (int i8 = i5; i8 < zza2; i8++) {
                    zzb zzbVar = (zzb) zzcVar.zzH();
                    int i9 = i8 + i8;
                    zzae zzc2 = zzaf.zzc();
                    zzc2.zza((int) fArr[i9]);
                    zzc2.zzb((int) fArr[i9 + 1]);
                    zzbVar.zza((i8 + zzc) % zza2, (zzaf) zzc2.zzj());
                    zzcVar = (zzc) zzbVar.zzj();
                }
            }
            if (zzcVar.zzt()) {
                zzv zzh = zzcVar.zzh();
                zzarVar = new zzar(zzh.zzf() + i4, zzh.zzc(), zzh.zze(), zzh.zzd());
            } else {
                zzarVar = null;
            }
            if (zzcVar.zzv()) {
                zzco zzb3 = zzcVar.zzb();
                zzauVar = new zzau(zzb3.zzd() + i4, zzb3.zzc());
            } else {
                zzauVar = null;
            }
            if (zzcVar.zzw()) {
                zzah zzj = zzcVar.zzj();
                zzavVar = new zzav(zzj.zzc(), zzj.zzd());
            } else {
                zzavVar = null;
            }
            if (zzcVar.zzy()) {
                com.google.photos.vision.barhopper.zzao zzl = zzcVar.zzl();
                zzaxVar = new zzax(zzl.zzd(), zzl.zzc(), zzl.zze() + i4);
            } else {
                zzaxVar = null;
            }
            if (zzcVar.zzx()) {
                zzak zzk = zzcVar.zzk();
                zzawVar = new zzaw(zzk.zzc(), zzk.zzd());
            } else {
                zzawVar = null;
            }
            if (zzcVar.zzu()) {
                zzz zzi = zzcVar.zzi();
                zzasVar = new zzas(zzi.zza(), zzi.zzb());
            } else {
                zzasVar = null;
            }
            if (zzcVar.zzq()) {
                zzn zzd = zzcVar.zzd();
                zzaoVar = new zzao(zzd.zzj(), zzd.zze(), zzd.zzf(), zzd.zzh(), zzd.zzi(), zzh(zzd.zzb(), zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null, "DTSTART:([0-9TZ]*)"), zzh(zzd.zza(), zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null, "DTEND:([0-9TZ]*)"));
            } else {
                zzaoVar = null;
            }
            if (zzcVar.zzr()) {
                zzp zze = zzcVar.zze();
                zzck zza3 = zze.zza();
                zzat zzatVar = zza3 != null ? new zzat(zza3.zzd(), zza3.zzi(), zza3.zzh(), zza3.zzc(), zza3.zzf(), zza3.zze(), zza3.zzj()) : null;
                String zzd2 = zze.zzd();
                String zze2 = zze.zze();
                List zzi2 = zze.zzi();
                if (zzi2.isEmpty()) {
                    zzauVarArr = null;
                } else {
                    zzau[] zzauVarArr2 = new zzau[zzi2.size()];
                    for (int i10 = 0; i10 < zzi2.size(); i10++) {
                        zzauVarArr2[i10] = new zzau(((zzco) zzi2.get(i10)).zzd() + i4, ((zzco) zzi2.get(i10)).zzc());
                    }
                    zzauVarArr = zzauVarArr2;
                }
                List zzh2 = zze.zzh();
                if (zzh2.isEmpty()) {
                    zzarVarArr = null;
                } else {
                    zzar[] zzarVarArr2 = new zzar[zzh2.size()];
                    int i11 = 0;
                    while (i11 < zzh2.size()) {
                        zzarVarArr2[i11] = new zzar(((zzv) zzh2.get(i11)).zzf() + i4, ((zzv) zzh2.get(i11)).zzc(), ((zzv) zzh2.get(i11)).zze(), ((zzv) zzh2.get(i11)).zzd());
                        i11++;
                        i4 = -1;
                    }
                    zzarVarArr = zzarVarArr2;
                }
                String[] strArr = (String[]) zze.zzj().toArray(new String[0]);
                List zzf = zze.zzf();
                if (zzf.isEmpty()) {
                    i = 0;
                    zzamVarArr = null;
                } else {
                    zzam[] zzamVarArr2 = new zzam[zzf.size()];
                    for (int i12 = 0; i12 < zzf.size(); i12++) {
                        zzamVarArr2[i12] = new zzam(((zzci) zzf.get(i12)).zzc() - 1, (String[]) ((zzci) zzf.get(i12)).zzb().toArray(new String[0]));
                    }
                    i = 0;
                    zzamVarArr = zzamVarArr2;
                }
                zzapVar = new zzap(zzatVar, zzd2, zze2, zzauVarArr, zzarVarArr, strArr, zzamVarArr);
            } else {
                i = 0;
                zzapVar = null;
            }
            if (zzcVar.zzs()) {
                zzr zzf2 = zzcVar.zzf();
                zzaqVar = new zzaq(zzf2.zzi(), zzf2.zzk(), zzf2.zzq(), zzf2.zzo(), zzf2.zzl(), zzf2.zze(), zzf2.zzc(), zzf2.zzd(), zzf2.zzf(), zzf2.zzp(), zzf2.zzm(), zzf2.zzj(), zzf2.zzh(), zzf2.zzn());
            } else {
                zzaqVar = null;
            }
            int i13 = 2;
            switch (zzcVar.zzz() - 1) {
                case 0:
                    i2 = i;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 8;
                    break;
                case 5:
                    i2 = 16;
                    break;
                case 6:
                    i2 = 32;
                    break;
                case 7:
                    i2 = 64;
                    break;
                case 8:
                    i2 = 128;
                    break;
                case 9:
                    i2 = 256;
                    break;
                case 10:
                    i2 = 512;
                    break;
                case 11:
                    i2 = 1024;
                    break;
                case 12:
                    i2 = 2048;
                    break;
                case 13:
                    i2 = 4096;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            String zzn = zzcVar.zzn();
            String zzt = zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null;
            byte[] zzw = zzcVar.zzm().zzw();
            List zzo2 = zzcVar.zzo();
            if (zzo2.isEmpty()) {
                pointArr = null;
            } else {
                Point[] pointArr2 = new Point[zzo2.size()];
                for (int i14 = i; i14 < zzo2.size(); i14++) {
                    pointArr2[i14] = new Point(((zzaf) zzo2.get(i14)).zza(), ((zzaf) zzo2.get(i14)).zzb());
                }
                pointArr = pointArr2;
            }
            switch (zzcVar.zzA() - 1) {
                case 1:
                    i3 = 1;
                    continue;
                case 2:
                    break;
                case 3:
                    i13 = 3;
                    break;
                case 4:
                    i3 = 4;
                    continue;
                case 5:
                    i13 = 5;
                    break;
                case 6:
                    i13 = 6;
                    break;
                case 7:
                    i13 = 7;
                    break;
                case 8:
                    i3 = 8;
                    continue;
                case 9:
                    i13 = 9;
                    break;
                case 10:
                    i13 = 10;
                    break;
                case 11:
                    i13 = 11;
                    break;
                case 12:
                    i13 = 12;
                    break;
                default:
                    i3 = i;
                    continue;
            }
            i3 = i13;
            arrayList.add(new zzay(i2, zzn, zzt, zzw, pointArr, i3, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
            i4 = -1;
            i5 = i;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzb(IObjectWrapper iObjectWrapper, zzcc zzccVar) {
        return zzj(iObjectWrapper, zzccVar, zzg());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzc(IObjectWrapper iObjectWrapper, zzcc zzccVar, zzbc zzbcVar) {
        RecognitionOptions zzg = zzg();
        MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();
        multiScaleDecodingOptions.setExtraScales(zzbcVar.zza().zzc());
        multiScaleDecodingOptions.setMinimumDetectedDimension(zzbcVar.zza().zza());
        multiScaleDecodingOptions.setSkipProcessingIfBarcodeFound(zzbcVar.zza().zzb());
        zzg.setMultiScaleDecodingOptions(multiScaleDecodingOptions);
        MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();
        multiScaleDetectionOptions.setExtraScales(zzbcVar.zza().zzc());
        zzg.setMultiScaleDetectionOptions(multiScaleDetectionOptions);
        zzg.setQrEnableFourthCornerApproximation(zzbcVar.zzb());
        return zzj(iObjectWrapper, zzccVar, zzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzd() {
        if (this.zze != null) {
            return;
        }
        this.zze = new BarhopperV3();
        zzh zza2 = zzi.zza();
        zze zza3 = zzf.zza();
        int i = 16;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            com.google.barhopper.deeplearning.zzb zza4 = com.google.barhopper.deeplearning.zzc.zza();
            zza4.zzc(i);
            zza4.zzd(i);
            for (int i4 = 0; i4 < zza[i3]; i4++) {
                double[] dArr = zzb[i2];
                double d = dArr[0] * 320.0d;
                float sqrt = (float) Math.sqrt(dArr[1]);
                float f = (float) d;
                zza4.zza(f / sqrt);
                zza4.zzb(f * sqrt);
                i2++;
            }
            i += i;
            zza3.zza(zza4);
        }
        zza2.zza(zza3);
        try {
            InputStream open = this.zzc.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
            try {
                InputStream open2 = this.zzc.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                try {
                    InputStream open3 = this.zzc.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                    try {
                        BarhopperV3 barhopperV3 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
                        zzk zza5 = BarhopperV3Options.zza();
                        zza2.zzb(zzdf.zzs(open));
                        zza5.zza(zza2);
                        zzab zza6 = zzac.zza();
                        zza6.zza(zzdf.zzs(open2));
                        zza6.zzb(zzdf.zzs(open3));
                        zza5.zzb(zza6);
                        barhopperV3.create(zza5.zzj());
                        if (open3 != null) {
                            open3.close();
                        }
                        if (open2 != null) {
                            open2.close();
                        }
                        if (open != null) {
                            open.close();
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to open Barcode models", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zze(zzbe zzbeVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzf() {
        BarhopperV3 barhopperV3 = this.zze;
        if (barhopperV3 != null) {
            barhopperV3.close();
            this.zze = null;
        }
    }
}
