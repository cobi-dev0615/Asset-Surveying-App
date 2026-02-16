package com.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.util.Log;
import com.android.usbserial.driver.UsbSerialPort;
import com.android.usbserial.util.MonotonicClock;
import com.google.android.material.internal.ViewUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FtdiSerialDriver implements UsbSerialDriver {
    private static final String TAG = FtdiSerialPort.class.getSimpleName();
    private final UsbDevice mDevice;
    private final List<UsbSerialPort> mPorts = new ArrayList();

    public FtdiSerialDriver(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
        for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
            this.mPorts.add(new FtdiSerialPort(this.mDevice, i));
        }
    }

    @Override // com.android.usbserial.driver.UsbSerialDriver
    public UsbDevice getDevice() {
        return this.mDevice;
    }

    @Override // com.android.usbserial.driver.UsbSerialDriver
    public List<UsbSerialPort> getPorts() {
        return this.mPorts;
    }

    @Override // com.android.usbserial.driver.UsbSerialDriver
    public String getDriverName() {
        return TAG;
    }

    public class FtdiSerialPort extends CommonUsbSerialPort {
        private static final int GET_LATENCY_TIMER_REQUEST = 10;
        private static final int GET_MODEM_STATUS_REQUEST = 5;
        private static final int MODEM_CONTROL_DTR_DISABLE = 256;
        private static final int MODEM_CONTROL_DTR_ENABLE = 257;
        private static final int MODEM_CONTROL_REQUEST = 1;
        private static final int MODEM_CONTROL_RTS_DISABLE = 512;
        private static final int MODEM_CONTROL_RTS_ENABLE = 514;
        private static final int MODEM_STATUS_CD = 128;
        private static final int MODEM_STATUS_CTS = 16;
        private static final int MODEM_STATUS_DSR = 32;
        private static final int MODEM_STATUS_RI = 64;
        private static final int READ_HEADER_LENGTH = 2;
        private static final int REQTYPE_DEVICE_TO_HOST = 192;
        private static final int REQTYPE_HOST_TO_DEVICE = 64;
        private static final int RESET_ALL = 0;
        private static final int RESET_PURGE_RX = 1;
        private static final int RESET_PURGE_TX = 2;
        private static final int RESET_REQUEST = 0;
        private static final int SET_BAUD_RATE_REQUEST = 3;
        private static final int SET_DATA_REQUEST = 4;
        private static final int SET_LATENCY_TIMER_REQUEST = 9;
        private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
        private boolean baudRateWithPort;
        private int breakConfig;
        private boolean dtr;
        private boolean rts;

        public FtdiSerialPort(UsbDevice usbDevice, int i) {
            super(usbDevice, i);
            this.baudRateWithPort = false;
            this.dtr = false;
            this.rts = false;
            this.breakConfig = 0;
        }

        @Override // com.android.usbserial.driver.UsbSerialPort
        public UsbSerialDriver getDriver() {
            return FtdiSerialDriver.this;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort
        protected void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException {
            boolean z = true;
            if (!usbDeviceConnection.claimInterface(this.mDevice.getInterface(this.mPortNumber), true)) {
                throw new IOException("Could not claim interface " + this.mPortNumber);
            }
            if (this.mDevice.getInterface(this.mPortNumber).getEndpointCount() < 2) {
                throw new IOException("Not enough endpoints");
            }
            this.mReadEndpoint = this.mDevice.getInterface(this.mPortNumber).getEndpoint(0);
            this.mWriteEndpoint = this.mDevice.getInterface(this.mPortNumber).getEndpoint(1);
            int controlTransfer = this.mConnection.controlTransfer(64, 0, 0, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer != 0) {
                throw new IOException("Reset failed: result=" + controlTransfer);
            }
            int controlTransfer2 = this.mConnection.controlTransfer(64, 1, (this.dtr ? 257 : 256) | (this.rts ? MODEM_CONTROL_RTS_ENABLE : 512), this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer2 != 0) {
                throw new IOException("Init RTS,DTR failed: result=" + controlTransfer2);
            }
            byte[] rawDescriptors = usbDeviceConnection.getRawDescriptors();
            if (rawDescriptors == null || rawDescriptors.length < 14) {
                throw new IOException("Could not get device descriptors");
            }
            byte b = rawDescriptors[13];
            if (b != 7 && b != 8 && b != 9 && this.mDevice.getInterfaceCount() <= 1) {
                z = false;
            }
            this.baudRateWithPort = z;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort
        protected void closeInt() {
            try {
                this.mConnection.releaseInterface(this.mDevice.getInterface(this.mPortNumber));
            } catch (Exception unused) {
            }
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public int read(byte[] bArr, int i) throws IOException {
            int read;
            int i2;
            if (bArr.length <= 2) {
                throw new IllegalArgumentException("Read buffer to small");
            }
            if (i != 0) {
                long millis = MonotonicClock.millis() + i;
                do {
                    i2 = super.read(bArr, Math.max(1, (int) (millis - MonotonicClock.millis())), false);
                    if (i2 != 2) {
                        break;
                    }
                } while (MonotonicClock.millis() < millis);
                if (i2 <= 0 && MonotonicClock.millis() < millis) {
                    testConnection();
                }
            } else {
                do {
                    read = super.read(bArr, i, false);
                } while (read == 2);
                i2 = read;
            }
            return readFilter(bArr, i2);
        }

        protected int readFilter(byte[] bArr, int i) throws IOException {
            int maxPacketSize = this.mReadEndpoint.getMaxPacketSize();
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i2 + maxPacketSize;
                int i5 = i2 + 2;
                int min = Math.min(i4, i) - i5;
                if (min < 0) {
                    throw new IOException("Expected at least 2 bytes");
                }
                System.arraycopy(bArr, i5, bArr, i3, min);
                i3 += min;
                i2 = i4;
            }
            return i3;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0052. Please report as an issue. */
        private void setBaudrate(int i) throws IOException {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            if (i > 3500000) {
                throw new UnsupportedOperationException("Baud rate to high");
            }
            if (i >= 2500000) {
                i4 = 3000000;
                i3 = 0;
                i2 = 0;
            } else if (i >= 1750000) {
                i4 = 2000000;
                i2 = 0;
                i3 = 1;
            } else {
                int i9 = (48000000 / i) + 1;
                i2 = (i9 >> 1) & 7;
                i3 = i9 >> 4;
                if (i3 > 16383) {
                    throw new UnsupportedOperationException("Baud rate to low");
                }
                i4 = ((48000000 / ((i3 << 3) + i2)) + 1) >> 1;
            }
            double abs = Math.abs(1.0d - (i4 / i));
            if (abs >= 0.031d) {
                throw new UnsupportedOperationException(String.format("Baud rate deviation %.1f%% is higher than allowed 3%%", Double.valueOf(abs * 100.0d)));
            }
            switch (i2) {
                case 1:
                    i5 = i3 | 49152;
                    i7 = i5;
                    i6 = 0;
                    break;
                case 2:
                    i5 = 32768 | i3;
                    i7 = i5;
                    i6 = 0;
                    break;
                case 3:
                    i6 = 1;
                    i7 = i3;
                    break;
                case 4:
                    i5 = i3 | 16384;
                    i7 = i5;
                    i6 = 0;
                    break;
                case 5:
                    i8 = i3 | 16384;
                    i7 = i8;
                    i6 = 1;
                    break;
                case 6:
                    i8 = 32768 | i3;
                    i7 = i8;
                    i6 = 1;
                    break;
                case 7:
                    i8 = i3 | 49152;
                    i7 = i8;
                    i6 = 1;
                    break;
                default:
                    i6 = 0;
                    i7 = i3;
                    break;
            }
            if (this.baudRateWithPort) {
                i6 = (i6 << 8) | (this.mPortNumber + 1);
            }
            int i10 = i6;
            Log.d(FtdiSerialDriver.TAG, String.format("baud rate=%d, effective=%d, error=%.1f%%, value=0x%04x, index=0x%04x, divisor=%d, subdivisor=%d", Integer.valueOf(i), Integer.valueOf(i4), Double.valueOf(abs * 100.0d), Integer.valueOf(i7), Integer.valueOf(i10), Integer.valueOf(i3), Integer.valueOf(i2)));
            int controlTransfer = this.mConnection.controlTransfer(64, 3, i7, i10, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer == 0) {
                return;
            }
            throw new IOException("Setting baudrate failed: result=" + controlTransfer);
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public void setParameters(int i, int i2, int i3, int i4) throws IOException {
            if (i <= 0) {
                throw new IllegalArgumentException("Invalid baud rate: " + i);
            }
            setBaudrate(i);
            if (i2 == 5 || i2 == 6) {
                throw new UnsupportedOperationException("Unsupported data bits: " + i2);
            }
            if (i2 != 7 && i2 != 8) {
                throw new IllegalArgumentException("Invalid data bits: " + i2);
            }
            if (i4 != 0) {
                if (i4 == 1) {
                    i2 |= 256;
                } else if (i4 == 2) {
                    i2 |= 512;
                } else if (i4 == 3) {
                    i2 |= ViewUtils.EDGE_TO_EDGE_FLAGS;
                } else {
                    if (i4 != 4) {
                        throw new IllegalArgumentException("Invalid parity: " + i4);
                    }
                    i2 |= 1024;
                }
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        throw new UnsupportedOperationException("Unsupported stop bits: 1.5");
                    }
                    throw new IllegalArgumentException("Invalid stop bits: " + i3);
                }
                i2 |= 4096;
            }
            int controlTransfer = this.mConnection.controlTransfer(64, 4, i2, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer != 0) {
                throw new IOException("Setting parameters failed: result=" + controlTransfer);
            }
            this.breakConfig = i2;
        }

        private int getStatus() throws IOException {
            byte[] bArr = new byte[2];
            int controlTransfer = this.mConnection.controlTransfer(REQTYPE_DEVICE_TO_HOST, 5, 0, this.mPortNumber + 1, bArr, 2, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer != 2) {
                throw new IOException("Get modem status failed: result=" + controlTransfer);
            }
            return bArr[0];
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public boolean getCD() throws IOException {
            return (getStatus() & 128) != 0;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public boolean getCTS() throws IOException {
            return (getStatus() & 16) != 0;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public boolean getDSR() throws IOException {
            return (getStatus() & 32) != 0;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public boolean getDTR() throws IOException {
            return this.dtr;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public void setDTR(boolean z) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(64, 1, z ? 257 : 256, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer != 0) {
                throw new IOException("Set DTR failed: result=" + controlTransfer);
            }
            this.dtr = z;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public boolean getRI() throws IOException {
            return (getStatus() & 64) != 0;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public boolean getRTS() throws IOException {
            return this.rts;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public void setRTS(boolean z) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(64, 1, z ? MODEM_CONTROL_RTS_ENABLE : 512, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer != 0) {
                throw new IOException("Set DTR failed: result=" + controlTransfer);
            }
            this.rts = z;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException {
            int status = getStatus();
            EnumSet<UsbSerialPort.ControlLine> noneOf = EnumSet.noneOf(UsbSerialPort.ControlLine.class);
            if (this.rts) {
                noneOf.add(UsbSerialPort.ControlLine.RTS);
            }
            if ((status & 16) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CTS);
            }
            if (this.dtr) {
                noneOf.add(UsbSerialPort.ControlLine.DTR);
            }
            if ((status & 32) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.DSR);
            }
            if ((status & 128) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.CD);
            }
            if ((status & 64) != 0) {
                noneOf.add(UsbSerialPort.ControlLine.RI);
            }
            return noneOf;
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException {
            return EnumSet.allOf(UsbSerialPort.ControlLine.class);
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public void purgeHwBuffers(boolean z, boolean z2) throws IOException {
            int controlTransfer;
            int controlTransfer2;
            if (z && (controlTransfer2 = this.mConnection.controlTransfer(64, 0, 1, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS)) != 0) {
                throw new IOException("Purge write buffer failed: result=" + controlTransfer2);
            }
            if (!z2 || (controlTransfer = this.mConnection.controlTransfer(64, 0, 2, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS)) == 0) {
                return;
            }
            throw new IOException("Purge read buffer failed: result=" + controlTransfer);
        }

        @Override // com.android.usbserial.driver.CommonUsbSerialPort, com.android.usbserial.driver.UsbSerialPort
        public void setBreak(boolean z) throws IOException {
            int i = this.breakConfig;
            if (z) {
                i |= 16384;
            }
            int controlTransfer = this.mConnection.controlTransfer(64, 4, i, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer == 0) {
                return;
            }
            throw new IOException("Setting BREAK failed: result=" + controlTransfer);
        }

        public void setLatencyTimer(int i) throws IOException {
            int controlTransfer = this.mConnection.controlTransfer(64, 9, i, this.mPortNumber + 1, null, 0, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer == 0) {
                return;
            }
            throw new IOException("Set latency timer failed: result=" + controlTransfer);
        }

        public int getLatencyTimer() throws IOException {
            byte[] bArr = new byte[1];
            int controlTransfer = this.mConnection.controlTransfer(REQTYPE_DEVICE_TO_HOST, 10, 0, this.mPortNumber + 1, bArr, 1, USB_WRITE_TIMEOUT_MILLIS);
            if (controlTransfer != 1) {
                throw new IOException("Get latency timer failed: result=" + controlTransfer);
            }
            return bArr[0];
        }
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf(UsbId.VENDOR_FTDI), new int[]{UsbId.FTDI_FT232R, UsbId.FTDI_FT232H, UsbId.FTDI_FT2232H, UsbId.FTDI_FT4232H, UsbId.FTDI_FT231X});
        return linkedHashMap;
    }
}
