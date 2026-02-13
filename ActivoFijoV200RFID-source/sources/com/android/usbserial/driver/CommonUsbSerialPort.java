package com.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbRequest;
import com.android.usbserial.driver.UsbSerialPort;
import com.android.usbserial.util.MonotonicClock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.EnumSet;

/* loaded from: classes.dex */
public abstract class CommonUsbSerialPort implements UsbSerialPort {
    private static final int DEFAULT_WRITE_BUFFER_SIZE = 16384;
    private static final int MAX_READ_SIZE = 16384;
    private static final String TAG = "CommonUsbSerialPort";
    protected final UsbDevice mDevice;
    protected final int mPortNumber;
    protected UsbEndpoint mReadEndpoint;
    protected UsbRequest mUsbRequest;
    protected UsbEndpoint mWriteEndpoint;
    protected UsbDeviceConnection mConnection = null;
    protected final Object mWriteBufferLock = new Object();
    protected byte[] mWriteBuffer = new byte[16384];

    protected abstract void closeInt();

    @Override // com.android.usbserial.driver.UsbSerialPort
    public abstract EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException;

    @Override // com.android.usbserial.driver.UsbSerialPort
    public abstract EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException;

    protected abstract void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException;

    @Override // com.android.usbserial.driver.UsbSerialPort
    public abstract void setParameters(int i, int i2, int i3, int i4) throws IOException;

    public CommonUsbSerialPort(UsbDevice usbDevice, int i) {
        this.mDevice = usbDevice;
        this.mPortNumber = i;
    }

    public String toString() {
        return String.format("<%s device_name=%s device_id=%s port_number=%s>", getClass().getSimpleName(), this.mDevice.getDeviceName(), Integer.valueOf(this.mDevice.getDeviceId()), Integer.valueOf(this.mPortNumber));
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public UsbDevice getDevice() {
        return this.mDevice;
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public int getPortNumber() {
        return this.mPortNumber;
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public UsbEndpoint getWriteEndpoint() {
        return this.mWriteEndpoint;
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public UsbEndpoint getReadEndpoint() {
        return this.mReadEndpoint;
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public String getSerial() {
        return this.mConnection.getSerial();
    }

    public final void setWriteBufferSize(int i) {
        synchronized (this.mWriteBufferLock) {
            if (i == this.mWriteBuffer.length) {
                return;
            }
            this.mWriteBuffer = new byte[i];
        }
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public void open(UsbDeviceConnection usbDeviceConnection) throws IOException {
        if (this.mConnection != null) {
            throw new IOException("Already open");
        }
        if (usbDeviceConnection == null) {
            throw new IllegalArgumentException("Connection is null");
        }
        this.mConnection = usbDeviceConnection;
        try {
            openInt(usbDeviceConnection);
            if (this.mReadEndpoint == null || this.mWriteEndpoint == null) {
                throw new IOException("Could not get read & write endpoints");
            }
            UsbRequest usbRequest = new UsbRequest();
            this.mUsbRequest = usbRequest;
            usbRequest.initialize(this.mConnection, this.mReadEndpoint);
        } catch (Exception e) {
            try {
                close();
            } catch (Exception unused) {
            }
            throw e;
        }
    }

    @Override // com.android.usbserial.driver.UsbSerialPort, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mConnection == null) {
            throw new IOException("Already closed");
        }
        try {
            this.mUsbRequest.cancel();
        } catch (Exception unused) {
        }
        this.mUsbRequest = null;
        try {
            closeInt();
        } catch (Exception unused2) {
        }
        try {
            this.mConnection.close();
        } catch (Exception unused3) {
        }
        this.mConnection = null;
    }

    protected void testConnection() throws IOException {
        if (this.mConnection.controlTransfer(128, 0, 0, 0, new byte[2], 2, 200) < 0) {
            throw new IOException("USB get_status request failed");
        }
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public int read(byte[] bArr, int i) throws IOException {
        return read(bArr, i, true);
    }

    protected int read(byte[] bArr, int i, boolean z) throws IOException {
        int position;
        if (this.mConnection == null) {
            throw new IOException("Connection closed");
        }
        if (bArr.length <= 0) {
            throw new IllegalArgumentException("Read buffer to small");
        }
        if (i != 0) {
            long millis = z ? MonotonicClock.millis() + i : 0L;
            position = this.mConnection.bulkTransfer(this.mReadEndpoint, bArr, Math.min(bArr.length, 16384), i);
            if (position == -1 && z && MonotonicClock.millis() < millis) {
                testConnection();
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (!this.mUsbRequest.queue(wrap, bArr.length)) {
                throw new IOException("Queueing USB request failed");
            }
            if (this.mConnection.requestWait() == null) {
                throw new IOException("Waiting for USB request failed");
            }
            position = wrap.position();
            if (position == 0) {
                testConnection();
            }
        }
        return Math.max(position, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0040 A[Catch: all -> 0x00e0, TryCatch #0 {, blocks: (B:11:0x0017, B:17:0x0030, B:22:0x0048, B:35:0x0040, B:37:0x0024), top: B:10:0x0017 }] */
    @Override // com.android.usbserial.driver.UsbSerialPort
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(byte[] r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.usbserial.driver.CommonUsbSerialPort.write(byte[], int):void");
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public boolean isOpen() {
        return this.mConnection != null;
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public boolean getCD() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public boolean getCTS() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public boolean getDSR() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public boolean getDTR() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public void setDTR(boolean z) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public boolean getRI() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public boolean getRTS() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public void setRTS(boolean z) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public void purgeHwBuffers(boolean z, boolean z2) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.android.usbserial.driver.UsbSerialPort
    public void setBreak(boolean z) throws IOException {
        throw new UnsupportedOperationException();
    }
}
