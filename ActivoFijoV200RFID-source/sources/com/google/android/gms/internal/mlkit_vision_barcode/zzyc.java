package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes2.dex */
public final class zzyc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        Point[] pointArr = null;
        zzxu zzxuVar = null;
        zzxx zzxxVar = null;
        zzxy zzxyVar = null;
        zzya zzyaVar = null;
        zzxz zzxzVar = null;
        zzxv zzxvVar = null;
        zzxr zzxrVar = null;
        zzxs zzxsVar = null;
        zzxt zzxtVar = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 5:
                    pointArr = (Point[]) SafeParcelReader.createTypedArray(parcel, readHeader, Point.CREATOR);
                    break;
                case 6:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    zzxuVar = (zzxu) SafeParcelReader.createParcelable(parcel, readHeader, zzxu.CREATOR);
                    break;
                case 8:
                    zzxxVar = (zzxx) SafeParcelReader.createParcelable(parcel, readHeader, zzxx.CREATOR);
                    break;
                case 9:
                    zzxyVar = (zzxy) SafeParcelReader.createParcelable(parcel, readHeader, zzxy.CREATOR);
                    break;
                case 10:
                    zzyaVar = (zzya) SafeParcelReader.createParcelable(parcel, readHeader, zzya.CREATOR);
                    break;
                case 11:
                    zzxzVar = (zzxz) SafeParcelReader.createParcelable(parcel, readHeader, zzxz.CREATOR);
                    break;
                case 12:
                    zzxvVar = (zzxv) SafeParcelReader.createParcelable(parcel, readHeader, zzxv.CREATOR);
                    break;
                case 13:
                    zzxrVar = (zzxr) SafeParcelReader.createParcelable(parcel, readHeader, zzxr.CREATOR);
                    break;
                case 14:
                    zzxsVar = (zzxs) SafeParcelReader.createParcelable(parcel, readHeader, zzxs.CREATOR);
                    break;
                case 15:
                    zzxtVar = (zzxt) SafeParcelReader.createParcelable(parcel, readHeader, zzxt.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzyb(i, str, str2, bArr, pointArr, i2, zzxuVar, zzxxVar, zzxyVar, zzyaVar, zzxzVar, zzxvVar, zzxrVar, zzxsVar, zzxtVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzyb[i];
    }
}
