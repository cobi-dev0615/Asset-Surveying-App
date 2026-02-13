package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes2.dex */
public final class zzbi implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzat zzatVar = null;
        String str = null;
        String str2 = null;
        zzau[] zzauVarArr = null;
        zzar[] zzarVarArr = null;
        String[] strArr = null;
        zzam[] zzamVarArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzatVar = (zzat) SafeParcelReader.createParcelable(parcel, readHeader, zzat.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    zzauVarArr = (zzau[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzau.CREATOR);
                    break;
                case 5:
                    zzarVarArr = (zzar[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzar.CREATOR);
                    break;
                case 6:
                    strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    break;
                case 7:
                    zzamVarArr = (zzam[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzam.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzap(zzatVar, str, str2, zzauVarArr, zzarVarArr, strArr, zzamVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzap[i];
    }
}
