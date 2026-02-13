package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes2.dex */
public abstract class zzbp extends zzb implements zzbq {
    public zzbp() {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
    }

    public static zzbq asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
        return queryLocalInterface instanceof zzbq ? (zzbq) queryLocalInterface : new zzbo(iBinder);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        zzba zzbaVar = (zzba) zzc.zza(parcel, zzba.CREATOR);
        zzc.zzb(parcel);
        zzbn newBarcodeScanner = newBarcodeScanner(asInterface, zzbaVar);
        parcel2.writeNoException();
        if (newBarcodeScanner == null) {
            parcel2.writeStrongBinder(null);
        } else {
            parcel2.writeStrongBinder(newBarcodeScanner.asBinder());
        }
        return true;
    }
}
