package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-base@@18.7.0 */
/* loaded from: classes2.dex */
final class zag extends Drawable.ConstantState {
    int zaa;
    int zab;

    zag(zag zagVar) {
        if (zagVar != null) {
            this.zaa = zagVar.zaa;
            this.zab = zagVar.zab;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.zaa;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zah(this);
    }
}
