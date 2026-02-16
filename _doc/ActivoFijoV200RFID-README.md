# Activo Fijo SER RFID (ActivoFijoV200RFID.apk)

**Mobile Fixed Asset Inventory with UHF RFID Hardware Integration**

| Field       | Value                                          |
|-------------|------------------------------------------------|
| App Name    | Activo Fijo SER                                |
| Package     | `maui.cf.activofijoser`                        |
| Version     | 2.0.0 (build 1)                               |
| Developer   | Codigo Fractal                                 |
| Platform    | Android 6.0 - 15 (SDK 23-35)                  |
| Framework   | .NET MAUI (C#) with Xamarin Android bindings   |
| Runtime     | Mono AOT (Ahead-of-Time compiled)              |
| UI Toolkit  | DevExpress MAUI Controls                       |

---

## Overview

Activo Fijo SER RFID v2.0.0 is a complete rewrite of the Activo Fijo inventory app, migrated from Apache Cordova (HTML/JS) to .NET MAUI (C#/native). It is designed for industrial Android PDA devices with built-in UHF RFID readers, enabling bulk fixed asset scanning via radio frequency identification. The app supports dual RFID reader vendors (Gexiang GX series and generic UHF readers), ML Kit barcode scanning, Bluetooth/serial/network connectivity, and DevExpress enterprise UI controls.

---

## Key Differences from V1.1.3 (Cordova)

| Feature | V1.1.3 (Cordova) | V2.0.0 RFID (MAUI) |
|---------|-------------------|---------------------|
| Framework | Apache Cordova (HTML/JS/CSS) | .NET MAUI (C#/native) |
| Runtime | WebView + JavaScript | Mono AOT compiled |
| RFID Support | None | Dual-vendor UHF Gen2 |
| Barcode Scanner | Camera + ZXing JS | Google ML Kit (TensorFlow) |
| UI Controls | Bootstrap MDB + jQuery | DevExpress MAUI (Charts, Grid, Editors) |
| Serial Port | None | JNI serial drivers for hardware |
| Bluetooth | BluetoothSerial plugin | Classic BT + BLE GATT |
| Network Protocol | HTTP/AJAX | TCP/UDP sockets + HTTP |
| Target Device | Any Android phone/tablet | Industrial PDA with RFID hardware |
| APK Size | 22 MB | 112 MB |
| Java Classes | 1,173 | 10,798 |
| Native Libraries | ~20 | 167 per architecture |

---

## Features

### UHF RFID Tag Operations

- EPC Class 1 Gen 2 (ISO 18000-63) compliant
- Real-time tag inventory with anti-collision
- EPC, TID, and User data area reading and writing
- Tag locking and killing with password-based security
- RSSI (signal strength) monitoring per tag
- Multi-antenna support with multiplexing
- Per-antenna tag detection and filtering
- Configurable RF power output
- Configurable frequency region
- Continuous and single-shot scanning modes
- Session management (Sessions 0-3) with Q-value settings
- Return loss measurement for antenna diagnostics
- Temperature monitoring

### Dual RFID Reader Support

The app uses a factory pattern to support two RFID hardware vendors:

#### Gexiang GX Series (RFID Type 32)

| Parameter | Value |
|-----------|-------|
| SDK | `com.gg.reader.api` (206 Java files) |
| Protocol | GG Protocol (200+ message types) |
| Connectivity | TCP, Bluetooth, USB, Serial |
| Communication | Message-based with CRC checksums |
| Callbacks | Async tag events (onTagEpcLog, onTagEpcOver) |
| Keep-alive | Heartbeat mechanism |

Advanced capabilities:
- WiFi management (hotspot, connect, status)
- GPIO input/output control
- Firmware upgrade (app and baseband)
- Carrier wave and VSWR testing
- Environmental RSSI detection
- DC bias and power calibration
- MonzaQT and hybrid inventory modes

#### Generic UHF Reader (RFID Type 0)

| Parameter | Value |
|-----------|-------|
| SDK | `com.rfid.trans.BaseReader` |
| Protocol | Serial command protocol with CRC16 |
| Connectivity | Serial port only |
| Default Port | `/dev/ttyS3` (SDK 28+) or `/dev/ttyS2` |
| Baud Rate | 115200 |
| Scan Time | 20ms default |

### Barcode Scanning

- Google ML Kit Vision barcode detection
- Three embedded TensorFlow Lite models:
  - SSD MobileNet for barcode localization
  - 1D barcode feature extraction
  - 1D barcode autoregression
- Camera-based scanning with image processing
- Support for 1D and 2D barcode formats

### Data Visualization

- DevExpress Charts (pie charts, range area series, numeric axes)
- DevExpress Grid for tabular data display
- DevExpress Editors for form input
- DevExpress CollectionView and ListView
- DevExpress NavigationView for app navigation
- SkiaSharp graphics rendering engine

### Audio Feedback

- `success.wav` — Success confirmation beep
- `error.wav` — Error alert sound
- `decode.wav` — Barcode decode notification

### Connectivity

- **Serial Port**: JNI-based UART communication (ttyS0-ttyS3)
- **Classic Bluetooth**: SPP profile for legacy devices
- **Bluetooth Low Energy**: GATT service (UUID fff0) with notify/write characteristics
- **TCP/UDP**: Socket-based network communication
- **UDP Multicast**: Network device discovery
- **USB**: OTG device management

---

## Technical Architecture

```
+-----------------------------------------------------------+
|  .NET MAUI Frontend (C#)                                  |
|  AuditoriaActivoFijo.dll (AOT compiled)                   |
|  DevExpress Charts / Grid / Editors                       |
+-----------------------------------------------------------+
|  MAUI Interop Layer                                       |
|  HybridJavaScriptInterface + PlatformInterop              |
+-----------------------------------------------------------+
|  Hardware Abstraction (LCKJ Factory Pattern)              |
|  +--------------------------+---------------------------+ |
|  | GxUhfProduct             | RfidUhfProduct            | |
|  | (Gexiang via TCP/BT)     | (Legacy via Serial)       | |
|  +--------------------------+---------------------------+ |
+-----------------------------------------------------------+
|  Communication Layer                                      |
|  Serial | BT Classic | BLE | TCP | UDP | USB             |
+-----------------------------------------------------------+
|  JNI Native Libraries                                     |
|  libSerialPort.so | libserial_port.so | libdevapi.so     |
+-----------------------------------------------------------+
|  Linux Hardware Layer                                     |
|  /dev/ttyS0-3 | GPIO | USB OTG | Bluetooth               |
+-----------------------------------------------------------+
```

### .NET MAUI Stack

- **Main App DLL**: `AuditoriaActivoFijo.dll` (AOT compiled to `libaot-AuditoriaActivoFijo.dll.so`, 1.6 MB)
- **RFID Binding**: `RugLineRT501.SDK.Binding.dll` (AOT compiled)
- **UI Framework**: DevExpress MAUI (6 libraries)
- **Graphics**: SkiaSharp (5 libraries)
- **Database**: SQLitePCLRaw (5 libraries)
- **JSON**: Newtonsoft.Json
- **Audio**: Plugin.Maui.Audio
- **Icons**: UraniumUI Icons
- **Community**: CommunityToolkit.Maui

### Native Libraries (167 per architecture)

**Architectures**: arm64-v8a, armeabi-v7a, x86, x86_64

Key native libraries:

| Library | Purpose |
|---------|---------|
| `libaot-AuditoriaActivoFijo.dll.so` | Main app logic (1.6 MB) |
| `libaot-RugLineRT501.SDK.Binding.dll.so` | RFID SDK binding |
| `libSerialPort.so` | GXWL serial port JNI |
| `libserial_port.so` | Generic serial port JNI |
| `libe_sqlite3.so` | SQLite database engine (2.8 MB) |
| `libSkiaSharp.so` | Graphics rendering |
| `libDXChartsNative.so` | DevExpress charts native |
| `libbarhopper_v3.so` | Barcode detection |
| `libimage_processing_util_jni.so` | Image processing |
| `libInvertBytes.so` | Data transformation |
| `libmonodroid.so` | Mono runtime for Android |
| `libmonosgen-2.0.so` | Mono garbage collector |
| `libxamarin-app.so` | Xamarin app runtime |

---

## Hardware Power Management

The app controls industrial PDA hardware modules via GPIO:

| Function | Description |
|----------|-------------|
| `rfidPoweron()` / `rfidPoweroff()` | RFID module power control |
| `scanerpoweron()` / `scanerpoweroff()` | Barcode scanner power |
| `scanertrigeron()` / `scanertrigeroff()` | Scanner trigger control |
| `power_3v3on()` / `power_3v3off()` | 3.3V power rail |
| `zigbeepoweron()` / `zigbeepoweroff()` | Zigbee module (5V) |
| `psampoweron()` / `psampoweroff()` | PSAM card reader |
| `irdapoweron()` / `irdapoweroff()` | IrDA infrared module |
| `usbOTGpowerOn()` / `usbOTGpowerOff()` | USB OTG power |
| `setGPIOhigh()` / `setGPIOlow()` | Direct GPIO control |

GPIO control paths:
- `/proc/gpiocontrol/set_id` — ID device power
- `/proc/gpiocontrol/set_uhf` — UHF RFID reader power

Serial port assignments:

| Port | Device |
|------|--------|
| `/dev/ttyS0` | SPO2 (oxygen saturation sensor) |
| `/dev/ttyS1` | Printer |
| `/dev/ttyS2` | Wireless FHR / NIBP / Barcode scanner |
| `/dev/ttyS3` | RFID reader (primary) |

---

## Android Permissions

| Permission | Purpose |
|------------|---------|
| `INTERNET` | Network communication |
| `ACCESS_NETWORK_STATE` | Network monitoring |
| `BLUETOOTH` | Legacy BT (max SDK 30) |
| `BLUETOOTH_ADMIN` | Legacy BT admin (max SDK 30) |
| `BLUETOOTH_CONNECT` | Modern BT connections |
| `BLUETOOTH_SCAN` | BT device scanning |
| `BLUETOOTH_ADVERTISE` | BT advertising |
| `BLUETOOTH_PRIVILEGED` | Privileged BT operations |
| `ACCESS_FINE_LOCATION` | GPS coordinates |
| `ACCESS_COARSE_LOCATION` | Network location |
| `CAMERA` | Barcode scanning and photos |
| `RECORD_AUDIO` | Audio features |
| `READ_EXTERNAL_STORAGE` | File import |
| `WRITE_EXTERNAL_STORAGE` | File export |
| `SERIAL_PORT` | Serial device access |
| `MANAGE_USB` | USB device management |
| `WAKE_LOCK` | Prevent sleep during scanning |
| `READ_PHONE_STATE` | Device identification |

**Required hardware**: OpenGL ES 2.0

**Custom permission**: `maui.cf.activofijoser.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`

---

## Data Storage

| Technology | Library | Purpose |
|------------|---------|---------|
| SQLite | `libe_sqlite3.so` + `SQLitePCLRaw` | Local database |
| In-memory | `ConcurrentLinkedQueue`, `Hashtable` | RFID tag buffering |
| File system | MAUI Essentials FileProvider | Import/export |

Database operations are handled in the C# MAUI layer (`AuditoriaActivoFijo.dll`), which is AOT-compiled to native code. The SQLite schema is not directly visible in the decompiled Java layer but is managed through SQLitePCLRaw bindings.

---

## Services and Receivers

### Background Services

| Service | Purpose |
|---------|---------|
| `KeepAliveService` | Keeps app running during long RFID scan sessions |
| `MetadataHolderService` | Camera metadata handling |
| DataTransport services | Firebase analytics telemetry |
| ML Kit services | Barcode model management |

### Broadcast Receivers

| Receiver | Purpose |
|----------|---------|
| `ConnectivityBroadcastReceiver` | Network state changes |
| `BatteryBroadcastReceiver` | Battery level monitoring |
| `EnergySaverBroadcastReceiver` | Power saving mode detection |
| `ProfileInstallReceiver` | AndroidX profile installation |

---

## RFID Communication Protocol (GG Protocol)

The Gexiang GX reader uses 200+ message types organized by function:

### Inventory Messages
- `MsgBaseInventoryEpc` — Standard EPC Gen2 inventory
- `MsgBaseInventory6b` — ISO 18000-6B inventory
- `MsgBaseInventoryGb` — GB standard inventory
- `MsgBaseInventoryGJb` — GJB standard inventory
- `MsgBaseInventoryMonzaQT` — Impinj Monza QT mode
- `MsgBaseInventoryHybrid` — Multi-protocol hybrid scan

### Read/Write Messages
- `MsgBaseReadEpc` / `MsgBaseWriteEpc` — EPC data access
- `MsgBaseLockEpc` / `MsgBaseLock6b` — Tag security locking
- `MsgBaseDestroyEpc` / `MsgBaseKill` — Tag decommissioning

### Configuration Messages
- `MsgBaseSetPower` — RF output power
- `MsgBaseSetFrequency` — Frequency band selection
- `MsgBaseSetBaseband` — Baseband configuration
- `MsgBaseSetAntennaHub` — Antenna multiplexer setup
- `MsgAppSetTcpMode` — Network mode
- `MsgAppSetSerialParam` — Serial port parameters

### Diagnostic Messages
- `MsgTestCarrierWave` — Carrier wave test
- `MsgTestVSWRcheck` — VSWR antenna diagnostics
- `MsgTestEnvRssiDetection` — Environment RF noise
- `MsgTestDCbias` — DC bias measurement
- `MsgTestPowerCalibration` — Power calibration

### Device Management
- `MsgAppSetGpo` / `MsgAppGetGpiState` — GPIO control
- `MsgAppSetGpiTrigger` — GPIO trigger events
- `MsgAppHeartbeat` — Connection keep-alive
- `MsgAppSetWifiOnOff` / `MsgAppSetWifiHotspot` — WiFi management
- `MsgUpgradeApp` / `MsgUpgradeBaseband` — Firmware updates

---

## Third-Party Dependencies

### Enterprise UI
- **DevExpress MAUI** — Charts, Grid, Editors, CollectionView, NavigationView, ListView
- **SkiaSharp** — 2D graphics rendering engine
- **UraniumUI Icons** — Icon library
- **CommunityToolkit.Maui** — Extended MAUI components
- **Lottie Animation** — Loading/success animations

### Google Services
- **ML Kit Vision** — Barcode scanning with TensorFlow Lite
- **Play Services** — Base services and crypto
- **Firebase** — Analytics and telemetry

### Image Loading
- **Bumptech Glide** — Async image loading with caching

### Serialization
- **Newtonsoft.Json** — JSON processing
- **Kotlinx Serialization** — Kotlin object serialization
- **Google Gson** — Additional JSON support

### Cryptography
- **Google Tink** — Encryption utilities

### Audio
- **Plugin.Maui.Audio** — Sound playback

---

## RFID Scan Workflow

```
1. App startup
   └── Factory detects RFID hardware type
       ├── Type 32 → GxUhfProduct (Gexiang)
       └── Type 0  → RfidUhfProduct (Legacy)

2. Connection established
   ├── Serial: /dev/ttyS3 @ 115200 baud
   ├── Bluetooth: SPP or BLE GATT
   └── Network: TCP socket

3. Reader configured
   ├── RF power level set
   ├── Frequency region configured
   ├── Antenna(s) selected
   └── Session/Q-value set

4. Inventory scan started
   ├── Anti-collision protocol active
   ├── Tags detected asynchronously
   ├── EPC + RSSI per tag reported
   └── Results buffered in ConcurrentLinkedQueue

5. Tag data processed
   ├── Deduplicated by EPC
   ├── Read count aggregated
   ├── RSSI averaged
   └── Matched to asset catalog

6. Results persisted
   ├── SQLite local database
   └── Server sync when online
```

---

## File Structure

```
ActivoFijoV200RFID.apk
ActivoFijoV200RFID.apk.bak                # Backup copy
ActivoFijoV200RFID-source/
  sources/                                  # Decompiled Java (10,798 files)
    maui/cf/activofijoser/                  # Main app package
    com/gg/reader/api/                      # Gexiang RFID SDK (206 files)
    com/rfid/trans/                         # Generic RFID protocol (13 files)
    com/lckj/lcrrgxmodule/                  # RFID factory pattern (7 files)
    cn/pda/serialport/                      # PDA serial port driver
    com/gxwl/device/                        # GXWL hardware driver
    com/google/mlkit/                       # ML Kit barcode scanning
    com/devexpress/                         # DevExpress UI controls
    com/bumptech/glide/                     # Image loading
    com/microsoft/maui/                     # MAUI framework
    kotlin/                                 # Kotlin standard library
    kotlinx/                                # Kotlin extensions
    mono/                                   # Mono runtime
    xamarin/                                # Xamarin bindings
    androidx/                               # Android support libraries
    crc64*/                                 # MAUI binding wrappers
  resources/
    AndroidManifest.xml                     # App manifest
    assets/
      success.wav, error.wav, decode.wav    # Audio files
      maagoatlottie.json                    # Lottie animation
      OpenSans-Regular.ttf                  # Fonts
      OpenSans-Semibold.ttf
      mlkit_barcode_models/                 # TF Lite barcode models
    res/                                    # Android resources
    lib/                                    # Native libraries
      arm64-v8a/                            # 167 .so files
      armeabi-v7a/                          # 167 .so files
      x86/                                  # 165 .so files
      x86_64/                               # 165 .so files
    classes.dex (8.6 MB)                    # DEX bytecode
    classes2.dex (7.3 MB)
    classes3.dex (5.2 MB)
```

---

## Build Information

- Build type: Release
- AOT compilation: Enabled
- Debug mode: Disabled
- Hardware acceleration: Enabled
- Cleartext traffic: Allowed
- Extract native libs: Enabled
- RTL support: Enabled
- Back gesture: Enabled (enableOnBackInvokedCallback)
- Multi-DEX: Yes (3 DEX files)
- Supported architectures: arm64-v8a, armeabi-v7a, x86, x86_64
