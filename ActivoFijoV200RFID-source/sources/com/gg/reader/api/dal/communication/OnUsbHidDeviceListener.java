package com.gg.reader.api.dal.communication;

/* loaded from: classes2.dex */
public interface OnUsbHidDeviceListener {
    void onDeviceConnectFailed(AndroidUsbHidClient androidUsbHidClient);

    void onDeviceConnected(AndroidUsbHidClient androidUsbHidClient);
}
