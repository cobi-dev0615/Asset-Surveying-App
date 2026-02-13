package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes2.dex */
public final class zzyh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzxw zzxwVar = null;
        String str = null;
        String str2 = null;
        zzxx[] zzxxVarArr = null;
        zzxu[] zzxuVarArr = null;
        String[] strArr = null;
        zzxp[] zzxpVarArr = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzxwVar = (zzxw) SafeParcelReader.createParcelable(parcel, readHeader, zzxw.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    zzxxVarArr = (zzxx[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzxx.CREATOR);
                    break;
                case 5:
                    zzxuVarArr = (zzxu[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzxu.CREATOR);
                    break;
                case 6:
                    strArr = SafeParcelReader.createStringArray(parcel, readHeader);
                    break;
                case 7:
                    zzxpVarArr = (zzxp[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzxp.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzxs(zzxwVar, str, str2, zzxxVarArr, zzxuVarArr, strArr, zzxpVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzxs[i];
    }
}
