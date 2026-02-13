# 5-Week Development Schedule

## Schedule Strategy

| Principle | Implementation |
|-----------|---------------|
| Trust building first | Weeks 1-2 deliver visible, demonstrable results the client can review |
| Low risk first | UI screens, database, API — no hardware dependency |
| Remote-friendly first | All work in weeks 1-4 testable on emulator or any Android phone |
| Hardware last | RFID device integration deferred to week 5 (requires physical device) |
| Frequent demos | Each week ends with a deliverable the client can see or test |

---

## Week 1 — Foundation & Web Platform Backend

**Goal:** Show the client a working web dashboard and API within the first week.

### Day 1-2: Project Setup

- [ ] Initialize Android project (Kotlin, Android Studio, Gradle)
- [ ] Initialize web project (Laravel or Django, REST API scaffolding)
- [ ] Set up Git repository with branching strategy
- [ ] Design unified database schema (merging all 3 app schemas)
- [ ] Create ER diagram for client review

### Day 3-5: Web Platform — Backend Core

- [ ] Database migration scripts (create all tables)
- [ ] User authentication API (JWT login, register, roles)
- [ ] Branch/location management API (CRUD)
- [ ] Asset catalog API (CRUD with search, filter, pagination)
- [ ] Inventory session API (create, assign, status tracking)
- [ ] Basic admin dashboard (login page, navigation, user list)

### Week 1 Deliverable to Client

> **Working web admin panel** with login, user management, and asset catalog CRUD.
> Client can log in, create users, add branches, and manage asset catalog.
> Share live URL or screen recording.

---

## Week 2 — Android App UI & Web Platform Completion

**Goal:** Show the client a polished Android app with all screens navigable, plus a complete web platform.

### Day 1-3: Android App — UI Screens (No Hardware)

- [ ] Login screen (company selection, username/password)
- [ ] Main dashboard with bottom navigation (Inventory / Assets / RFID / Settings)
- [ ] Inventory module screens:
  - Warehouse/location selection
  - Product capture screen (barcode input field, quantity, location)
  - Captured items list with edit/delete
  - Report screen with filters
- [ ] Fixed Assets module screens:
  - Area/department selection
  - Asset capture screen (code, description, category, brand, model, status)
  - Photo capture placeholder (3 photo slots)
  - Asset list with search and filter
- [ ] RFID module screens:
  - RFID scan screen (tag list placeholder, start/stop button)
  - Tag-to-asset association screen
  - RFID settings screen (reader type, power, antenna)
- [ ] Settings screens:
  - Server configuration
  - Printer configuration
  - Capture rules (toggles matching configuraciones_lectura)
  - About page

### Day 4-5: Web Platform — Complete

- [ ] Dashboard analytics page (charts: inventory progress, assets by category, by branch)
- [ ] Inventory session management (create session, assign users, view progress)
- [ ] Reports page (inventory summary, variance, audit trail)
- [ ] CSV/Excel export from web
- [ ] Transfer management page (cross-branch asset transfers)
- [ ] REST API documentation (Swagger/OpenAPI)

### Week 2 Deliverable to Client

> **Navigable Android APK** — client can install on any phone, tap through all screens.
> **Complete web platform** with dashboard, reports, and full API documentation.
> No hardware needed. All screens functional with mock data.

---

## Week 3 — Android Core Logic & Offline Database

**Goal:** Make the Android app functional — real data entry, local storage, camera barcode scanning.

### Day 1-2: Local Database & Authentication

- [ ] Room database setup (all entities, DAOs, migrations)
- [ ] Unified schema implementation:
  - Users, Sessions, Configurations
  - Products/Assets catalog
  - Inventory records (registros)
  - Warehouses/Branches (almacenes)
  - RFID tags table (new)
  - Asset status tracking (Found/Not Found/Added/Transferred)
- [ ] Login flow connected to Room (offline) and API (online)
- [ ] Session management (save/restore active session)
- [ ] Configuration persistence (capture rules, printer settings)

### Day 3-4: Inventory & Asset Capture (Camera Only)

- [ ] Google ML Kit barcode scanning integration (camera-based)
- [ ] Inventory capture workflow:
  - Scan barcode → search catalog → fill product info → enter quantity → save
  - Manual code entry fallback
  - Forced code entry for unknown products
- [ ] Fixed asset capture workflow:
  - Scan barcode → fill asset info → select status → save
  - Category, brand, model dropdowns populated from catalog
- [ ] Photo capture with CameraX (up to 3 photos per asset)
- [ ] GPS coordinate capture per record
- [ ] Asset validation state machine:
  - Found: asset matches catalog at current branch
  - Not Found: asset in catalog but not scanned
  - Added: new asset not in catalog
  - Transferred: asset belongs to different branch → notification

### Day 5: Reports & Export

- [ ] Inventory reports (grouped by product, by location, detail, variance)
- [ ] CSV export to device storage
- [ ] Excel export (Apache POI)
- [ ] Report display with DataTable-style filtering and sorting

### Week 3 Deliverable to Client

> **Functional Android APK** — client can log in, scan barcodes with phone camera,
> capture inventory/assets, take photos, view reports, export CSV.
> All data saved locally in SQLite. Works completely offline.

---

## Week 4 — API Sync, Printing & Data Migration

**Goal:** Connect Android app to web platform. Add Bluetooth printing. Migrate client's existing data.

### Day 1-2: Android-Server Synchronization

- [ ] Retrofit API client setup (all endpoints)
- [ ] Sync engine with WorkManager:
  - Upload: push local records to server when online
  - Download: pull catalog updates, user lists, branch data from server
  - Conflict resolution (server-wins with timestamp comparison)
  - Sync status tracking per record (sincronizado flag)
- [ ] Auto-sync on network reconnect
- [ ] Manual sync button with progress indicator
- [ ] Transfer notification system:
  - Detect asset from another branch
  - Create transfer record
  - Push notification to server
  - Server notifies receiving branch

### Day 3: Bluetooth Printing

- [ ] Bluetooth device discovery and pairing UI
- [ ] ESC/POS printer driver (ticket/receipt printing)
  - Inventory count summary
  - Asset detail ticket
  - Location summary report
- [ ] Zebra CPCL printer driver (label printing)
  - Asset label with barcode
  - Location label
- [ ] Print preview and test print
- [ ] Two printer slots (ticket printer + label printer)

### Day 4: Product Catalog Import

- [ ] Excel/XLSX file import on Android (read file → parse → insert to Room)
- [ ] Server catalog import (pull from API)
- [ ] Bulk insert with progress bar
- [ ] Duplicate detection and merge strategy
- [ ] Web platform: bulk upload endpoint (Excel/CSV)

### Day 5: Database Migration

- [ ] Connect to client's CPanel/MySQL
- [ ] Analyze existing WordPress database structure
- [ ] Write migration scripts:
  - Export existing users, branches, assets
  - Transform to unified schema
  - Import into new web platform database
- [ ] Validate migrated data with client
- [ ] Document migration process

### Week 4 Deliverable to Client

> **Connected system** — Android app syncs with web platform in real-time.
> Bluetooth printing works with ESC/POS and Zebra printers.
> Client's existing data migrated to new platform.
> Client can test full workflow: web admin → create inventory → Android captures → sync → web reports.

---

## Week 5 — RFID Integration, Testing & Delivery

**Goal:** Integrate RFID hardware, comprehensive testing, final polish, documentation.

> **Note:** This week requires access to the physical Rugline RT501 device.
> Request device from client at the start of week 4 at the latest.

### Day 1-2: RFID Hardware Integration

- [ ] Integrate RFID protocol layer from decompiled V200:
  - `com.rfid.trans` (BaseReader, serial protocol, CRC16)
  - `com.lckj.lcrrgxmodule` (factory pattern: GxUhfProduct + RfidUhfProduct)
  - `com.gg.reader.api` (Gexiang GX SDK for advanced readers)
  - `cn.pda.serialport` (JNI serial port driver)
  - Native libraries: `libSerialPort.so`, `libserial_port.so`
- [ ] RFID reader detection and connection (serial port auto-discovery)
- [ ] Real-time tag inventory:
  - Start/stop scanning
  - Tag list display (EPC, RSSI, read count, antenna)
  - Audio feedback on tag detection (success.wav, error.wav)
  - Deduplication by EPC
- [ ] Tag-to-asset association:
  - Scan RFID tag → match to catalog by EPC or manual association
  - Write EPC data to tag (optional)
  - Read TID for unique identification
- [ ] RFID settings:
  - RF power control
  - Antenna selection
  - Scan duration / session / Q-value
  - Reader type auto-detection (Rugline vs generic)

### Day 3: Doying Device Testing & Barcode Integration

- [ ] Test barcode scanning on Doying Handheld POS
- [ ] Verify hardware barcode trigger button integration (if applicable)
- [ ] Test on Rugline device (barcode mode, not just RFID)
- [ ] Verify all UI screens on both device form factors (4-inch and 5.5-inch)
- [ ] Performance testing with large datasets (5,000+ records)

### Day 4: Comprehensive Testing & Bug Fixes

- [ ] End-to-end testing:
  - Web: create inventory session → assign user → push catalog
  - Android: login → download catalog → scan items (barcode + RFID) → take photos → sync
  - Web: view results → generate reports → export
  - Transfer scenario: scan asset from branch A at branch B → verify notification
- [ ] Offline stress test:
  - Capture 500+ records offline → reconnect → verify sync
- [ ] Multi-device test:
  - Two Android devices syncing to same server simultaneously
- [ ] Edge cases:
  - Network loss during sync
  - Duplicate barcode/RFID scans
  - Invalid data handling
  - Large photo uploads
- [ ] Bug fixes and UI polish

### Day 5: Documentation & Final Delivery

- [ ] Technical manual:
  - System architecture overview
  - API reference (all endpoints with request/response examples)
  - RFID integration guide (supported readers, protocol details)
  - Database schema documentation
- [ ] Installation documentation:
  - Android APK installation steps
  - Web server deployment (CPanel or cloud)
  - Database setup and migration guide
  - Environment configuration
- [ ] Solution architecture diagram:
  - System components (Android, API, Web, Database)
  - Data flow diagrams
  - RFID communication flow
  - Sync workflow diagram
- [ ] Final deliverables package:
  - Signed release APK
  - Android Studio project (Git repository)
  - Web platform source code (Git repository)
  - All documentation (PDF + Markdown)
  - Database migration scripts
  - Architecture diagrams

### Week 5 Deliverable to Client

> **Complete system delivery:**
> - Production-ready APK with Inventory + Fixed Assets + RFID
> - Web platform deployed and accessible
> - All documentation and source code
> - Client's existing data migrated
> - RFID tested on Rugline hardware

---

## Weekly Deliverables Summary

| Week | Deliverable | Client Can See/Test | Risk Level |
|------|-------------|---------------------|------------|
| **1** | Web admin panel + API + DB schema | Login, manage users/branches/catalog on web | Low |
| **2** | Android UI (all screens) + Web complete | Install APK, navigate all screens, review web dashboard | Low |
| **3** | Android offline functionality | Scan barcodes, capture assets/photos, view reports on phone | Low-Medium |
| **4** | Sync + Printing + Data migration | Full online workflow, print labels, see migrated data | Medium |
| **5** | RFID + Testing + Documentation | Complete system with RFID on real hardware | High |

---

## Critical Path Dependencies

```
Week 1          Week 2          Week 3          Week 4          Week 5
DB Schema -----> Room Setup ---> Offline Logic -> Sync Engine --> Final Testing
    |                |               |               |               |
API Server ----> API Docs -----> Android API ----> Migration ----> Delivery
    |                |               |               |
Web Admin -----> Web Complete    Barcode Scan --> BT Printing
                     |               |                           RFID Integration
                 Android UI ----> Capture Logic                      |
                                     |                          Device Testing
                                 Asset States                        |
                                     |                          Documentation
                                 Reports/Export
```

---

## Client Communication Schedule

| When | Action | Purpose |
|------|--------|---------|
| End of Day 1 | Share Git repo + ER diagram | Show immediate progress |
| End of Week 1 | Demo web admin panel (live URL or video) | Build trust with tangible result |
| Mid Week 2 | Share APK (UI-only build) | Client sees the app on their phone |
| End of Week 2 | Demo web platform + Android app together | Show complete scope coverage |
| Mid Week 3 | Share APK (barcode scanning works) | Client tests real functionality |
| End of Week 3 | Demo offline workflow end-to-end | Prove core value proposition |
| End of Week 4 | Demo sync + printing + migrated data | System works as connected ecosystem |
| Start Week 5 | Request Rugline device if not received | Critical for RFID integration |
| Mid Week 5 | RFID demo video on Rugline device | Prove hardware integration works |
| End of Week 5 | Final delivery package | All deliverables handed over |

---

## Risk Mitigation Timeline

| Risk | When It Surfaces | Mitigation |
|------|------------------|------------|
| Client feedback changes scope | Week 1-2 | Frequent demos allow early course correction |
| Database migration issues | Week 4 | Client provides CPanel access by week 3 |
| Rugline device not available | Week 5 | Request device by start of week 4; RFID module designed to be testable with mock data |
| Doying barcode trigger incompatible | Week 5 | ML Kit camera scanning works as universal fallback |
| API endpoint disagreements | Week 2 | Swagger docs shared end of week 2 for client approval |
| Sync conflicts with multiple devices | Week 4 | Server-wins strategy with timestamp; test with 2 devices |
| Print formatting issues | Week 4 | ESC/POS and CPCL protocols well-documented from decompiled apps |

---

## What to Request from Client (by Week)

| Week | Request | Why |
|------|---------|-----|
| **Week 1** | CPanel/WordPress access credentials | To analyze existing database for migration planning |
| **Week 1** | List of branches and their current asset counts | For database schema validation |
| **Week 1** | Sample Excel file of their asset catalog | To test import functionality |
| **Week 2** | Feedback on web admin panel and Android UI | Early course correction |
| **Week 3** | Approval on API endpoint structure (Swagger doc) | Lock down API contract before sync implementation |
| **Week 4** | Ship Rugline RT501 device to you (or arrange remote access) | Required for week 5 RFID integration |
| **Week 4** | Bluetooth printer model details | For print formatting and testing |
| **Week 4** | Production server/hosting details | For web platform deployment |
| **Week 5** | Final acceptance testing feedback | For bug fixes before delivery |
