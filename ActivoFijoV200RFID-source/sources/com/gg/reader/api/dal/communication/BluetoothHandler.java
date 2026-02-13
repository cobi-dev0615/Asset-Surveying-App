package com.gg.reader.api.dal.communication;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes2.dex */
public interface BluetoothHandler {
    void dispense(BluetoothDevice bluetoothDevice);

    void finishDiscover();

    void startDiscover();
}
