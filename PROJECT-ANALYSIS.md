# Project Analysis: Unified Inventory & Fixed Asset Management System

## Table of Contents

- [Job Description](#job-description)
- [Chat History Summary](#chat-history-summary)
- [Current System Inventory](#current-system-inventory)
- [Decompiled APK Analysis](#decompiled-apk-analysis)
- [Client Requirements](#client-requirements)
- [Asset Validation States](#asset-validation-states)
- [Target Hardware](#target-hardware)
- [Technical Findings from Decompilation](#technical-findings-from-decompilation)
- [Project Scope](#project-scope)
- [Risks and Considerations](#risks-and-considerations)
- [Recommended Technical Approach](#recommended-technical-approach)
- [Deliverables Checklist](#deliverables-checklist)

---

## Job Description

The client is seeking a developer with real-world RFID integration experience to create an Android application for field asset tracking. The application focuses on UHF reading, evidence capture, and synchronization with an existing web platform. The project is part of a nationwide audit and inventory management ecosystem.

### Main Objective

Develop a robust Android application that allows for the capture, validation, and synchronization of fixed assets using RFID technology, barcodes, and photographic evidence. The application must function efficiently offline, with the ability to synchronize afterward.

### Main Functions Required

- Real-time UHF RFID reading
- Barcode and QR code reading
- Association of RFID tags with specific assets
- Asset creation and editing capabilities
- Capture of photographs as evidence
- Asset validation by status (found, not found, surplus, disposal)
- Offline mode with automatic or manual data synchronization
- User and project login system
- Exporting information via API/Web

### Essential Technical Requirements

- Proficiency in Android Studio
- Experience developing with Kotlin or Java
- Proven experience with RFID SDKs for handhelds or antennas
- Experience with Bluetooth, USB HID, or serial communication
- Experience consuming RESTful APIs
- Knowledge and experience with local databases such as SQLite or Room
- Experience using Git version control

### Considered a Plus

- Experience with devices from brands such as Zebra, Chainway, Rugline, Urovo
- Previous experience in enterprise application development

### Project Deliverables

- Functional APK file of the application
- Complete project source code
- Detailed technical manual
- Installation documentation
- Solution architecture diagram

---

## Chat History Summary

### Key Decisions Made During Client-Freelancer Discussion

**1. RFID Hardware Confirmed:**
- Brand: Rugline (UHF RFID handheld, Android 13, 5.5-inch)
- Barcode-only device: Doying Handheld POS (Android 10, 1D/2D/QR)
- Both devices must be supported in a single app

**2. Asset Validation States Agreed:**
- Found
- Not Found
- Added (surplus)
- Transferred (asset found at wrong branch, triggers transfer notification)

**3. Application Scope Expanded:**
- Client has 3 Android apps to merge into 1
- Client has 2 desktop apps to merge into 1
- No source code available for any application (only APKs for Android)
- Database migration required from current WordPress/CPanel platform

**4. Development Approach:**
- Build everything from scratch
- Use decompiled APKs as functional reference
- Client will provide APK files and CPanel/WordPress access

**5. Client's Current Platform:**
- Web application hosted on WordPress with CPanel
- MySQL database accessible via CPanel
- Multiple branch locations (nationwide)

---

## Current System Inventory

### What the Client Has Today

| Application | Type | File | Framework | Status |
|-------------|------|------|-----------|--------|
| Inventory | Android | SERV122.apk (v1.2.2) | Cordova (HTML/JS) | APK only, no source |
| Fixed Assets | Android | ActivoFijoV113.apk (v1.1.3) | Cordova (HTML/JS) | APK only, no source |
| RFID | Android | ActivoFijoV200RFID.apk (v2.0.0) | .NET MAUI (C#) | APK only, no source |
| Web Platform | Desktop | WordPress + CPanel | PHP/MySQL | Has CPanel access |
| Local Server | Desktop | Unknown | Unknown | No code, no APK |

### Original Developer

All three Android apps were developed by **Codigo Fractal** (@marcxploit), branded as **SER (Servicios Empresariales Retail)** / **Simple Stock Mobile**.

---

## Decompiled APK Analysis

### SERV122.apk (Inventory App)

| Field | Value |
|-------|-------|
| App Name | SER Inventarios (Simple Stock Mobile) |
| Package | `cf.ser.ssm` |
| Version | 1.2.2 (build 10202) |
| Framework | Apache Cordova |
| Language | Spanish |
| SDK Range | 21-33 (Android 5.0 - 13) |
| APK Size | 22 MB |
| Java Files | 778 |

**Core Functions:**
- Login with SHA256 password hashing
- Physical inventory counting with barcode scanning
- Product catalog management (search, create, import from Excel/cloud)
- Multi-warehouse and multi-count support
- Cross-count verification for audits
- Bluetooth printing (ESC/POS and Zebra CPCL)
- Four report types with CSV/Excel export
- Offline-first with server sync
- GPS coordinate tagging
- Device-specific licensing

**Database:** LocalStorageDB (`northwindSSM`) + SQLite (`Northwind.db`)
- 15 tables total (12 localStorage + 3 SQLite)
- Key tables: catalogos, registros, almacenes, usuarios, configuraciones

**API Server:** `simplestockmobile.com/SER/InventariosAPIV3/`

### ActivoFijoV113.apk (Fixed Assets App)

| Field | Value |
|-------|-------|
| App Name | Inventario Activo Fijo |
| Package | `cf.ser.actfijo` |
| Version | 1.1.3 (build 10103) |
| Framework | Apache Cordova |
| Language | Spanish |
| SDK Range | 21-31 (Android 5.0 - 12) |
| APK Size | 22 MB |
| Java Files | 1,173 |

**Core Functions:**
- Multi-tenant login with company selection
- Fixed asset counting with barcode/QR scanning (ZXing)
- Photo capture (up to 3 photos per asset)
- Category-based asset organization
- Serial number capture with bulk entry
- Brand and model selection
- Dashboard with D3/C3 analytics charts (3 chart types)
- Resume previous inventory sessions
- Cross-count verification
- Bluetooth printing (ESC/POS and Zebra CPCL)
- Export to CSV and server sync

**Database:** LocalStorageDB (`northwindSSM`) + SQLite (`Northwind.db`)
- 16 tables total (14 localStorage + 2 SQLite)
- Adds `sesion_actual` table for dedicated session tracking

**API Server:** `ser.codigofractal.com`

### ActivoFijoV200RFID.apk (RFID App)

| Field | Value |
|-------|-------|
| App Name | Activo Fijo SER |
| Package | `maui.cf.activofijoser` |
| Version | 2.0.0 (build 1) |
| Framework | .NET MAUI (C#) |
| Runtime | Mono AOT compiled |
| UI Toolkit | DevExpress MAUI |
| SDK Range | 23-35 (Android 6.0 - 15) |
| APK Size | 112 MB |
| Java Files | 10,798 |

**Core Functions:**
- Dual RFID reader support via factory pattern:
  - Gexiang GX series (TCP/BT/USB/Serial, 200+ protocol messages)
  - Generic UHF readers (serial port, CRC16 protocol)
- Full UHF Gen2 protocol (EPC/TID/User read/write, lock, kill)
- RSSI signal strength monitoring
- Multi-antenna support with multiplexing
- Google ML Kit barcode scanning (3 TensorFlow Lite models)
- Hardware power management via GPIO
- KeepAlive background service for long scan sessions
- Battery and connectivity monitoring
- Audio feedback (success, error, decode sounds)

**RFID Hardware:**
- RugLine RT501 SDK binding (`RugLineRT501.SDK.Binding.dll`)
- Serial port: `/dev/ttyS3` @ 115200 baud
- JNI drivers: `libSerialPort.so`, `libserial_port.so`
- GPIO control: `/proc/gpiocontrol/set_uhf`

**Database:** SQLitePCLRaw (C# layer, schema not visible in Java decompile)

---

## Client Requirements

### Unified Android Application

Merge three separate apps into one:

```
Current State (3 apps)           Target State (1 app)
+--------------------+
| SERV122            |           +------------------------------+
| (Inventory)        |----+      | Unified Android App          |
+--------------------+    |      |                              |
+--------------------+    |      | Module 1: Inventory          |
| ActivoFijo V113    |----+----> | Module 2: Fixed Assets       |
| (Fixed Assets)     |    |      | Module 3: RFID               |
+--------------------+    |      | Shared: Login, Sync, Print,  |
+--------------------+    |      |   Offline, Reports, GPS      |
| ActivoFijo V200    |----+      +------------------------------+
| (RFID)             |
+--------------------+
```

### Unified Desktop/Web Application

Merge two desktop applications into one:

```
Current State (2 apps)           Target State (1 app)
+--------------------+
| Web App            |           +------------------------------+
| (WordPress/PHP)    |----+      | Unified Web Platform         |
+--------------------+    |      |                              |
+--------------------+    +----> | - Admin dashboard            |
| Local Server App   |    |      | - Inventory management       |
| (no source code)   |----+      | - Fixed asset management     |
+--------------------+           | - RFID data management       |
                                 | - User/role management       |
                                 | - Branch/location management |
                                 | - Reports and export         |
                                 | - REST API for Android sync  |
                                 | - Database migration         |
                                 +------------------------------+
```

### Database Migration

- Migrate from current WordPress/MySQL database to new unified platform
- Preserve existing asset records, user accounts, and branch data
- Map existing table structures to unified schema

---

## Asset Validation States

The client requires the following asset states for the unified app:

| State | Spanish | Trigger | Action |
|-------|---------|---------|--------|
| **Found** | Encontrado | Asset scanned matches catalog at current branch | Mark as verified, update timestamp |
| **Not Found** | No encontrado | Asset in catalog but not physically located | Flag for investigation |
| **Added** | Agregado | New asset found not in catalog (surplus) | Create new asset record |
| **Transferred** | Transferido | Asset found at wrong branch | Notify, initiate transfer record |

**Transfer Logic:** The system loads the complete branch catalog. When an asset from another branch is scanned, it triggers a transfer notification and updates records for both branches.

**Comparison with Current Apps:**
The existing apps only use basic flags (`forzado`, `sincronizado`, `eliminado`). The new app requires a proper asset lifecycle state machine with branch-aware validation.

---

## Target Hardware

| Device | Brand | OS | Features | Use Case |
|--------|-------|----|----------|----------|
| Handheld POS | Doying | Android 10 | 1D/2D/QR scanner, 4-inch touch, WiFi/BT | General inventory |
| Data Terminal | Rugline | Android 13 | UHF RFID reader, 1D/2D/QR scanner, 5.5-inch, 4G/WiFi/GPS | Fixed asset RFID |

**Confirmed SDK:** The decompiled V200 RFID app contains `RugLineRT501.SDK.Binding.dll`, confirming Rugline RT501 is the target RFID device. The Java RFID protocol layer (`com.rfid.trans`, `com.lckj.lcrrgxmodule`, `com.gg.reader.api`) can be reused directly.

---

## Technical Findings from Decompilation

### Code Reusability Assessment

| Component | SERV122 | V113 | V200 RFID | Reusable? |
|-----------|---------|------|-----------|-----------|
| UI Layer | Bootstrap MDB + jQuery | Bootstrap MDB + jQuery | DevExpress MAUI | No (all different from target Kotlin) |
| Business Logic | JavaScript | JavaScript | C# (AOT compiled) | Reference only |
| DB Schema | localStorage + SQLite | localStorage + SQLite | SQLitePCLRaw | Schema patterns reusable |
| RFID Protocol | N/A | N/A | Java (com.rfid.trans) | Yes, directly reusable |
| RFID Factory | N/A | N/A | Java (com.lckj) | Yes, directly reusable |
| GG Reader SDK | N/A | N/A | Java (com.gg.reader.api, 206 files) | Yes, directly reusable |
| Serial Port JNI | N/A | N/A | Java (cn.pda.serialport) | Yes, directly reusable |
| Barcode Scanning | Camera JS | ZXing JS | ML Kit (native) | ML Kit approach reusable |
| BT Printing | Cordova plugin | Cordova plugin | N/A | Protocol logic reference |
| API Endpoints | Known (SSM) | Known (CF) | Unknown (in C#) | URL patterns reference |

### Cordova Apps Share ~80% Codebase

SERV122 and ActivoFijoV113 share:
- Same database library (localStorageDB + SQLite plugin)
- Same database name (`northwindSSM` / `Northwind.db`)
- Same table naming conventions
- Same UI framework (Bootstrap MDB 4.19.1 + jQuery)
- Same developer (Codigo Fractal)
- Same build patterns

Key differences:
- V113 adds multi-tenant login (company selection)
- V113 adds photo capture (up to 3 per asset)
- V113 adds `sesion_actual` table
- V113 has richer dashboard analytics
- SERV122 has `lotes_caducidades` table (batch/expiration)
- SERV122 supports more printer models

### RFID App is a Complete Rewrite

V200 RFID shares zero code with the Cordova apps:
- Different language (C# vs JavaScript)
- Different framework (.NET MAUI vs Cordova)
- Different UI toolkit (DevExpress vs Bootstrap)
- Different database access (SQLitePCLRaw vs Cordova SQLite plugin)

However, the Java RFID protocol layer (226+ files) is native and directly reusable in a Kotlin/Java project.

---

## Project Scope

### Android Application (Build from Scratch)

| Module | Reference APK | Key Functions to Implement |
|--------|---------------|---------------------------|
| **Inventory** | SERV122 | Product counting, barcode scanning, location tracking, Excel import/export, reports, cross-count verification |
| **Fixed Assets** | ActivoFijoV113 | Asset tracking, photo evidence (3 per asset), multi-tenant login, category/brand/model management, dashboard analytics |
| **RFID** | ActivoFijoV200RFID | UHF tag read/write, dual reader support (Rugline + generic), serial/BT/TCP connectivity, antenna management, RSSI monitoring |
| **Shared Core** | All 3 apps | Authentication, offline mode, SQLite (Room), REST API sync, Bluetooth printing (ESC/POS + Zebra), GPS, CSV/Excel export, asset state machine (Found/Not Found/Added/Transferred) |

### Web Application (Build from Scratch)

| Component | Description |
|-----------|-------------|
| Admin Dashboard | Overview analytics, charts, KPIs |
| User Management | Users, roles, permissions, branch assignment |
| Branch Management | Locations, warehouses, departments |
| Asset Catalog | CRUD for products and fixed assets |
| Inventory Sessions | Create, assign, monitor inventory counts |
| RFID Tag Management | Tag-to-asset association, tag history |
| Transfer Management | Cross-branch transfer workflow |
| Reports | Inventory progress, variance, audit trails |
| REST API | Endpoints for Android app synchronization |
| Database Migration | Import from existing WordPress/MySQL |

### Database Migration

| Task | Description |
|------|-------------|
| Schema Analysis | Map current WordPress/MySQL tables to unified schema |
| Data Export | Extract existing records from CPanel |
| Data Transform | Convert to new schema format |
| Data Import | Load into new platform database |
| Validation | Verify data integrity post-migration |

---

## Risks and Considerations

### High Risk

| Risk | Impact | Mitigation |
|------|--------|------------|
| No source code for any application | All work is reverse-engineered from APKs | Decompiled code serves as functional reference, not starting point |
| RFID SDK dependency | V200 uses .NET binding (`RugLineRT501.SDK.Binding.dll`). Native Kotlin/Java SDK needed from Rugline | Java RFID protocol layer (`com.rfid.trans`, `com.lckj`, `com.gg.reader.api`) is directly reusable |
| Desktop app has no code or APK | Complete greenfield development | Design from scratch based on Android app features and client requirements |
| Database migration from WordPress | Schema mismatch, data loss risk | Careful mapping, staging environment, validation before production switch |

### Medium Risk

| Risk | Impact | Mitigation |
|------|--------|------------|
| Two incompatible Android stacks | Cordova (JS) and MAUI (C#) cannot be merged | Build new Kotlin app from scratch, use both as reference |
| Rugline device availability | Testing requires physical RFID hardware | Request test device from client early |
| Doying device compatibility | Barcode scanning may use proprietary SDK | Test with standard Android camera/ML Kit first |
| Multi-branch transfer logic | Complex state management across locations | Design clear state machine with server-side validation |

### Low Risk

| Risk | Impact | Mitigation |
|------|--------|------------|
| Bluetooth printer compatibility | ESC/POS and Zebra CPCL protocols well documented | Protocol logic documented in decompiled Cordova apps |
| Offline sync conflicts | Data conflicts when multiple devices sync | Implement conflict resolution strategy (server wins or timestamp-based) |
| GPS accuracy indoors | Warehouse GPS may be unreliable | Use as supplementary data, not primary location identifier |

---

## Recommended Technical Approach

### Android Application

```
Technology Stack:
├── Language: Kotlin
├── IDE: Android Studio
├── Architecture: MVVM + Clean Architecture
├── UI: Jetpack Compose (or XML Views)
├── Database: Room (SQLite)
│   └── Schema based on decompiled table structures
├── RFID Integration:
│   ├── Reuse: com.gg.reader.api (Gexiang GX SDK, 206 Java files)
│   ├── Reuse: com.rfid.trans (Generic UHF protocol, 13 files)
│   ├── Reuse: com.lckj.lcrrgxmodule (Factory pattern, 7 files)
│   ├── Reuse: cn.pda.serialport (Serial port JNI driver)
│   └── Reuse: libSerialPort.so, libserial_port.so (native libs)
├── Barcode: Google ML Kit Vision API
├── Network: Retrofit + OkHttp (REST API)
├── Offline Sync: Room + WorkManager
├── Printing: Bluetooth Serial (ESC/POS + Zebra CPCL)
├── Photos: CameraX API
├── GPS: FusedLocationProvider
├── DI: Hilt/Dagger
├── Image Loading: Coil or Glide
└── Export: Apache POI (Excel) + CSV
```

### Web Application

```
Technology Stack (Recommended):
├── Backend: Laravel (PHP) or Django (Python) or Node.js (Express)
├── Frontend: React or Vue.js
├── Database: MySQL or PostgreSQL
├── API: RESTful with JWT authentication
├── Hosting: Client's existing CPanel or cloud (AWS/GCP)
└── Migration: Custom scripts for WordPress/MySQL data
```

### System Architecture

```
+------------------+     REST API      +------------------+
| Android App      | <===============> | Web Platform     |
| (Kotlin)         |    (JSON/JWT)     | (Laravel/React)  |
|                  |                   |                  |
| - Inventory      |                   | - Admin Panel    |
| - Fixed Assets   |                   | - User Mgmt      |
| - RFID Scanning  |                   | - Reports        |
| - Offline/Room   |                   | - API Server     |
+------------------+                   +------------------+
        |                                      |
        v                                      v
+------------------+                   +------------------+
| Local SQLite     |                   | MySQL/PostgreSQL |
| (Room)           |                   | (Server DB)      |
+------------------+                   +------------------+
        |
        v
+------------------+
| Hardware Layer   |
| - Rugline RFID   |
| - Doying Scanner |
| - BT Printers    |
| - Camera/GPS     |
+------------------+
```

---

## Deliverables Checklist

| # | Deliverable | Description | Status |
|---|-------------|-------------|--------|
| 1 | Functional APK | Unified Android app with Inventory + Fixed Assets + RFID modules | Pending |
| 2 | Android Source Code | Complete Kotlin/Java project with build scripts | Pending |
| 3 | Web Platform | Functional web application with REST API | Pending |
| 4 | Web Source Code | Complete backend + frontend project | Pending |
| 5 | Technical Manual | Architecture docs, API reference, RFID integration guide | Pending |
| 6 | Installation Documentation | APK deployment, server setup, environment configuration | Pending |
| 7 | Architecture Diagram | System diagram: Android, API, Web, DB, Hardware layers | Pending |
| 8 | Database Migration | Scripts and documentation for WordPress/MySQL migration | Pending |
| 9 | APK Backups | Decompiled source of all 3 original APKs for reference | Complete |

---

## Appendix: Files Created During Analysis

| File | Description |
|------|-------------|
| `SERV122.apk.bak` | Backup of Inventory APK |
| `ActivoFijoV113.apk.bak` | Backup of Fixed Assets APK |
| `ActivoFijoV200RFID.apk.bak` | Backup of RFID APK |
| `SERV122-source/` | Decompiled Inventory source (778 Java files, 1,173 resources) |
| `ActivoFijoV113-source/` | Decompiled Fixed Assets source (1,173 Java files, 1,338 resources) |
| `ActivoFijoV200RFID-source/` | Decompiled RFID source (10,798 Java files, 2,357 resources) |
| `README.md` | SERV122 app analysis with full database schema |
| `ActivoFijoV113-README.md` | ActivoFijoV113 app analysis with full database schema |
| `ActivoFijoV200RFID-README.md` | ActivoFijoV200RFID app analysis with RFID protocol details |
| `PROJECT-ANALYSIS.md` | This document |
