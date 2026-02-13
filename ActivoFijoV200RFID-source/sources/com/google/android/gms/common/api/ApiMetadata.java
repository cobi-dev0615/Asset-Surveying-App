package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
/* loaded from: classes2.dex */
public final class ApiMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApiMetadata> CREATOR = zza.zza();
    private static final ApiMetadata zza = newBuilder().build();
    private final ComplianceOptions zzb;

    /* compiled from: com.google.android.gms:play-services-basement@@18.7.0 */
    public static final class Builder {
        private ComplianceOptions zza;

        public ApiMetadata build() {
            return new ApiMetadata(this.zza);
        }

        public Builder setComplianceOptions(ComplianceOptions complianceOptions) {
            this.zza = complianceOptions;
            return this;
        }
    }

    ApiMetadata(ComplianceOptions complianceOptions) {
        this.zzb = complianceOptions;
    }

    public static final ApiMetadata fromComplianceOptions(ComplianceOptions complianceOptions) {
        Builder newBuilder = newBuilder();
        newBuilder.setComplianceOptions(complianceOptions);
        return newBuilder.build();
    }

    public static final ApiMetadata getEmptyInstance() {
        return zza;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ApiMetadata) {
            return Objects.equals(this.zzb, ((ApiMetadata) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("ApiMetadata(complianceOptions=");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(-204102970);
        ComplianceOptions complianceOptions = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, complianceOptions, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
