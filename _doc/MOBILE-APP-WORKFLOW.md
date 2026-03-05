# SER Inventarios — Mobile App Workflow

## App Overview

**Package:** `com.seretail.inventarios`
**Platform:** Android (Kotlin + Jetpack Compose)
**Architecture:** MVVM, Single Activity, Compose Navigation
**API Base:** `https://app-test.seretail.com.mx/api/`

---

## Authentication Flow

```
App Launch
    │
    ├── Check DataStore for token + Room for user
    │
    ├── Token exists + User found ──► Empresa Selection (auto-skip if configured)
    │
    └── No token / No user ──► Login Screen
                                    │
                                    ├── Enter usuario + contraseña
                                    ├── POST /api/login ──► Receive token + user data
                                    ├── Save token to DataStore
                                    ├── Save user to Room DB
                                    └── Navigate to Empresa Selection
```

### Empresa/Sucursal Selection (Post-Login Onboarding)

```
Empresa Selection Screen
    │
    ├── Step 1: Show empresa list (from Room, refresh from API)
    │       └── User selects empresa ──► Load sucursales
    │
    ├── Step 2: Show sucursal list for selected empresa
    │       └── User selects sucursal ──► Confirmation dialog
    │
    ├── Confirm ──► Save empresa_id + sucursal_id to DataStore
    │              └── Navigate to Dashboard
    │
    └── Already configured ──► Auto-skip to Dashboard
```

---

## Main Navigation (Bottom Bar — 5 Tabs)

```
┌─────────────┬──────────────┬──────────┬──────────────┬────────────┐
│  Dashboard  │  Inventario  │  Profile │  Activo Fijo │  Settings  │
└─────────────┴──────────────┴──────────┴──────────────┴────────────┘
```

---

## Dashboard

```
Dashboard Screen
    │
    ├── Header: App title, online/offline indicator, user avatar, sync button
    │
    ├── Quick Stats Cards (clickable)
    │       ├── Inventario count ──► Inventario List
    │       └── Activo Fijo count ──► Activo Fijo List
    │
    ├── RFID Card ──► RFID Capture Screen
    │
    ├── Pending Sync Alert (if unsynced records > 0)
    │
    ├── Status Breakdown (Activo Fijo)
    │       ├── Encontrados (Found)
    │       ├── No Encontrados (Not Found)
    │       ├── Agregados (Added)
    │       └── Traspasados (Transferred)
    │
    └── Charts
            ├── Pie chart: progress/status distribution
            └── Bar chart: assets by category
```

---

## Inventario Module

### Inventario List

```
Inventario List Screen
    │
    ├── Shows all inventory sessions for current sucursal
    ├── Auto-resumes last active session on first load
    │
    ├── FAB (+) ──► Create Session Dialog
    │                   ├── Enter session name
    │                   ├── POST /api/inventarios (or local create)
    │                   └── Navigate to Capture Screen
    │
    ├── Session Card (tap) ──► Inventario Capture Screen
    │
    ├── Search icon ──► Inventario Query Screen
    │
    └── Reports icon ──► Inventario Reports Screen
```

### Inventario Capture (Core Workflow)

```
Inventario Capture Screen
    │
    ├── FORM SECTION (collapsible)
    │       │
    │       ├── Barcode field ──┬── Manual text entry
    │       │                   └── Camera button ──► Barcode Scanner
    │       │                                            │
    │       │                   ◄── Scanned barcode ─────┘
    │       │
    │       ├── On barcode entered/scanned:
    │       │       ├── Search catalog (Room DB) by barcode + empresa_id
    │       │       ├── Found ──► Auto-fill description
    │       │       ├── Not found + forced codes allowed ──► Mark as forced code
    │       │       ├── Not found + validate catalog ──► Show error, play error sound
    │       │       └── Load lote suggestions for barcode
    │       │
    │       ├── Quantity (default: 1) + Unidad/Caja toggle
    │       ├── Factor (conditional, from settings)
    │       ├── Serial number (conditional, from settings)
    │       ├── Location
    │       ├── Lot + autocomplete dropdown
    │       ├── Expiry date (Caducidad)
    │       │
    │       └── SAVE button
    │               ├── Validate barcode not empty
    │               ├── Get current user from Room
    │               ├── Create InventarioRegistroEntity
    │               ├── Insert into Room DB (sincronizado = false)
    │               ├── Play success sound
    │               └── Clear form for next scan
    │
    ├── REGISTROS LIST
    │       ├── Show all captured items (newest first)
    │       └── Each item: barcode, description, quantity, delete button
    │
    ├── BOTTOM STATS BAR
    │       ├── Conteo (total quantity)
    │       ├── Registros (record count)
    │       └── Factor (total factor, if applicable)
    │
    └── TOP BAR ACTIONS
            ├── Export button ──► Export Dialog (Excel/CSV)
            └── Captured count display
```

### Inventario Query

```
Inventario Query Screen
    │
    ├── Search field (barcode or description)
    │
    ├── Search Room DB across all inventario registros
    │
    └── Results list
            └── Each result: barcode, description, quantity, location, lot, date
                    └── Delete button + confirmation dialog
```

### Inventario Reports

```
Inventario Reports Screen
    │
    ├── Session selector dropdown
    │
    ├── Report type selector (5 types):
    │       ├── By Product: group by barcode, sum quantities
    │       ├── By Product + Location: group by barcode + location
    │       ├── Differences: teórico vs real + monetary values
    │       ├── Detailed: one row per registro
    │       └── Cross Count: group by barcode + location
    │
    ├── Summary stats card: Total Conteo, Registros, Ubicaciones
    │       └── (Differences only): Teórico, Real, Diferencia, Importes
    │
    ├── Sortable column headers (tap to sort ASC/DESC)
    │       └── Columns vary by report type (Code, Description, Quantity, etc.)
    │
    ├── Results list with report cards
    │
    └── Export FAB ──► Export Dialog (Excel/CSV)
            └── Generate file ──► Share intent
```

---

## Activo Fijo Module

### Activo Fijo List

```
Activo Fijo List Screen
    │
    ├── Shows all asset sessions for current sucursal
    ├── Auto-resumes last active session on first load
    │
    ├── FAB (+) ──► Create Session Dialog
    │
    ├── Session Card (tap) ──► Activo Fijo Capture Screen
    │
    ├── Compare button (if 2+ sessions)
    │       ├── Toggle compare mode
    │       ├── Select exactly 2 sessions
    │       └── Compare button ──► Cross Count Screen
    │
    └── Top bar: Compare toggle icon
```

### Activo Fijo Capture (Core Workflow)

```
Activo Fijo Capture Screen
    │
    ├── FORM SECTION (collapsible)
    │       │
    │       ├── Barcode ──┬── Manual entry
    │       │              └── Camera ──► Barcode Scanner
    │       │
    │       ├── On barcode scanned:
    │       │       ├── Search catalog with transfer check
    │       │       │       ├── Found in current sucursal ──► Auto-fill fields
    │       │       │       ├── Found in DIFFERENT sucursal ──► Transfer Dialog
    │       │       │       └── Not found ──► Empty fields (new asset)
    │       │       │
    │       │       └── Check if already captured in this session
    │       │               └── Yes ──► Enter edit mode (load existing data)
    │       │
    │       ├── Description, Category, Brand (with autocomplete)
    │       ├── Model, Color, Serie
    │       ├── Location, Area (with autocomplete, persists between captures)
    │       ├── Tag Nuevo, Serie Revisado
    │       ├── Comentarios
    │       │
    │       ├── STATUS CHIPS (select one):
    │       │       ├── 1: Encontrado (Found) — default
    │       │       ├── 2: No Encontrado (Not Found)
    │       │       ├── 3: Agregado (Added/New)
    │       │       └── 4: Traspasado (Transferred)
    │       │
    │       ├── PHOTO SLOTS (3 max)
    │       │       ├── Tap slot ──► CameraX photo capture
    │       │       ├── Photo saved as URI string
    │       │       └── Remove button per photo
    │       │
    │       └── SAVE button
    │               ├── Validate barcode not empty
    │               ├── Get GPS coordinates (if captureGps enabled)
    │               ├── Edit mode: UPDATE existing registro
    │               ├── New mode: INSERT new registro
    │               ├── Play success sound
    │               └── Clear form (keep Area for next capture)
    │
    ├── TRANSFER DIALOG (when asset from different branch)
    │       ├── User confirms transfer
    │       ├── Save registro with status = 4 (Transferred)
    │       ├── Create TraspasoEntity (origin + destination sucursal)
    │       └── Play success sound
    │
    ├── REGISTROS LIST
    │       ├── Session stats dashboard (pie chart + counts)
    │       ├── Category filter chips
    │       └── Each item: barcode, description, status, edit/delete buttons
    │
    └── TOP BAR ACTIONS
            ├── Search ──► Asset Search Screen
            ├── Catalog ──► Asset Catalog Screen
            ├── RFID ──► RFID Capture Screen
            ├── Export ──► Export Dialog (Excel/CSV)
            ├── Print ──► Bluetooth printer (if configured)
            └── Captured count display
```

### Asset Catalog

```
Asset Catalog Screen
    │
    ├── Stats header: Total products, Captured, Pending
    │
    ├── Search field
    │
    ├── Category list (if no category selected)
    │       └── Tap category ──► Show products in category
    │
    └── Product list
            ├── ✓ Checkmark if captured in current session
            ├── ○ Empty circle if not captured
            └── Product: description + barcode
```

### Asset Search

```
Asset Search Screen
    │
    ├── Search bar (barcode / TAG) + scanner button
    │
    ├── Search button ──► Query Room DB
    │
    ├── Catalog Info Card (from productos table)
    │       └── Code, description, category, brand, model, color, serie
    │
    ├── Capture Info Card (from activo_fijo_registros table)
    │       └── Same fields + location, comments, status, date, sync status
    │
    └── Photos section (count + thumbnails)
```

### Cross Count Comparison

```
Cross Count Screen
    │
    ├── Load registros from both sessions
    │
    ├── Summary: Coinciden, Faltantes, Diferente estado
    │
    └── Comparison cards
            ├── ✓ Match: same barcode, same status in both sessions
            ├── ⚠ Missing: barcode exists in one session but not the other
            └── ✗ Status mismatch: same barcode, different status
```

---

## RFID Module

```
RFID Capture Screen
    │
    ├── Connection Status Card
    │       ├── Disconnected (gray) ──► Connect button
    │       ├── Connecting (orange) ──► Progress bar
    │       ├── Connected (green) ──► Ready to scan
    │       └── Error (red) ──► Retry
    │
    ├── Session Selector: choose active session
    │
    ├── Power Control: slider 0-30 dBm
    │
    ├── Scan Controls
    │       ├── Start Escaneo ──► Begin RFID tag reading
    │       └── Stop Escaneo ──► Stop reading
    │
    ├── Count Display
    │       ├── Total tags read (blue)
    │       ├── Matched to catalog (green)
    │       └── Unmatched (red)
    │
    └── Tag List
            └── Each tag:
                    ├── EPC (unique identifier)
                    ├── Matched / Sin coincidencia
                    ├── RSSI signal strength (dBm)
                    ├── Read count
                    └── Signal strength color bar
```

---

## Barcode Scanner

```
Barcode Scanner Screen (fullscreen overlay)
    │
    ├── Request camera permission (first use)
    │
    ├── CameraX live preview
    │
    ├── Scan overlay (rounded rectangle, blue border)
    │
    ├── Supported formats:
    │       CODE_128, CODE_39, EAN_13, EAN_8,
    │       QR_CODE, UPC_A, UPC_E, ITF
    │
    ├── On successful scan:
    │       ├── Pass barcode via savedStateHandle
    │       └── Pop back to calling screen
    │
    ├── Torch toggle (FAB, bottom center)
    │
    └── Back button (top left)
```

---

## Settings

```
Settings Screen
    │
    ├── CONNECTION
    │       └── Server URL field
    │
    ├── EMPRESA & SUCURSAL
    │       └── Dropdowns to change current selection
    │
    ├── SYNC
    │       ├── Auto sync toggle
    │       ├── WiFi only toggle
    │       ├── Use camera toggle
    │       ├── Last sync timestamp
    │       └── Sync Now button
    │
    ├── PRINTER
    │       └── Bluetooth printer selection + configure
    │
    ├── PRODUCT CATALOG
    │       ├── View Catalog ──► Product Catalog Screen
    │       ├── Import Catalog ──► File picker (CSV/Excel)
    │       └── Download from Server ──► Catalog Import Screen
    │
    ├── CAPTURE OPTIONS (8 toggles)
    │       ├── Validate catalog
    │       ├── Allow forced codes
    │       ├── Capture factor
    │       ├── Capture lotes
    │       ├── Capture serial number
    │       ├── Allow negatives
    │       ├── Capture zeros
    │       ├── Capture GPS
    │       └── Count by unit
    │
    ├── Logout button (red)
    ├── About ──► About Screen
    └── Version info
```

---

## Catalog Management

### Product Catalog

```
Product Catalog Screen
    │
    ├── Product count badge
    ├── Search field
    ├── Category filter chips ("Todos" + categories)
    │
    ├── Product list
    │       └── Each: barcode (bold), description, category badge, brand
    │
    ├── FAB (+) ──► New Product Screen
    │
    └── Tap product ──► Edit Product Screen
```

### New/Edit Product

```
New Product Screen
    │
    ├── BARCODES
    │       ├── Código 1 (Principal, required) + scanner
    │       ├── Código 2 (SKU) + scanner
    │       └── Código 3 + scanner
    │
    ├── PRODUCT INFO
    │       ├── Descripción (required)
    │       ├── Categoría, Marca, Modelo, Color, Serie
    │       └── Unidad de Medida
    │
    ├── NUMERIC DATA
    │       ├── Precio Venta
    │       ├── Cantidad Teórica
    │       └── Factor
    │
    └── Save button ──► Insert/Update in Room DB
```

### Catalog Import

```
Catalog Import Screen
    │
    ├── Initial: description + Start Import button
    │
    ├── Importing:
    │       ├── Phase text ("Downloading products...")
    │       ├── Progress bar (0-100%)
    │       ├── Imported count / Total count
    │       └── Current page / Total pages
    │
    └── Complete: Success message + Back / Import Again
```

---

## Data Flow & Sync

### Offline-First Architecture

```
┌──────────────┐     ┌──────────────┐     ┌──────────────┐
│   UI Layer   │────►│  ViewModel   │────►│  Repository  │
│  (Compose)   │◄────│  (StateFlow) │◄────│              │
└──────────────┘     └──────────────┘     └──────┬───────┘
                                                  │
                                          ┌───────┴───────┐
                                          │               │
                                    ┌─────▼─────┐  ┌──────▼──────┐
                                    │  Room DB   │  │  Retrofit   │
                                    │  (SQLite)  │  │  (REST API) │
                                    └────────────┘  └─────────────┘
                                     Local-first     Server sync
```

### Sync Flow (WorkManager)

```
Sync Trigger
    │
    ├── Auto: every 15 minutes (if autoSync enabled)
    ├── Manual: Sync Now button
    └── On network reconnect
    │
    ▼
Download Phase (Server → Local)
    ├── GET /api/empresas ──► Room empresas table
    ├── GET /api/sucursales ──► Room sucursales table
    ├── GET /api/productos?page=N ──► Room productos table (paginated)
    ├── GET /api/lotes ──► Room lotes table
    ├── GET /api/inventarios ──► Room inventarios table
    └── GET /api/activo-fijo/sesiones ──► Room activo_fijo_sessions table
    │
    ▼
Upload Phase (Local → Server)
    ├── Query registros WHERE sincronizado = false
    ├── Group by session
    ├── POST /api/inventario-registros (batch)
    ├── POST /api/activo-fijo/registros (batch, with base64 images)
    ├── POST /api/traspasos
    ├── POST /api/rfid-tags
    ├── Mark as sincronizado = true on success
    └── Queue failures in sync_queue for retry
```

### Session Persistence

```
Enter Capture Screen
    └── Save session ID to DataStore

App Killed / Restarted
    └── List Screen loads
            ├── Read lastActiveSessionId from DataStore
            ├── Verify session still exists in Room
            └── Auto-navigate to Capture Screen

Logout
    └── Clear all session IDs from DataStore
```

---

## Status State Machine (Activo Fijo)

```
Barcode Scanned
    │
    ├── Found in catalog, SAME sucursal
    │       └── Status: 1 (Encontrado) ──► Green
    │
    ├── Found in catalog, DIFFERENT sucursal
    │       └── Transfer Dialog
    │               ├── Confirm ──► Status: 4 (Traspasado) ──► Orange
    │               │                   └── Create TraspasoEntity
    │               └── Cancel ──► Return to form
    │
    ├── NOT in catalog (new asset)
    │       └── Status: 3 (Agregado) ──► Blue
    │
    └── In catalog but NOT scanned (report-only)
            └── Status: 2 (No Encontrado) ──► Red
```

---

## Profile & Logout

```
Profile Screen
    │
    ├── User avatar (initials + role color)
    ├── Name, Role badge
    ├── Info: usuario, email, empresa, sucursal
    ├── Session: last sync timestamp
    │
    └── Logout button
            ├── Clear token + user from DataStore
            ├── Clear active session IDs
            └── Navigate to Login Screen
```

---

## Key Technical Details

| Component | Technology |
|-----------|-----------|
| DI | Hilt |
| Local DB | Room (SQLite), 14 entities, 10 DAOs |
| API | Retrofit + Moshi |
| Barcode | CameraX + Google ML Kit |
| Sync | WorkManager (15 min interval) |
| Preferences | Jetpack DataStore (27+ keys) |
| Images | Coil (display), CameraX (capture) |
| Navigation | Jetpack Compose Navigation |
| State | StateFlow + MVVM |
| Migrations | Room migrations (v6 baseline) |

---

## File Counts

| Layer | Files |
|-------|-------|
| Entities | 14 |
| DAOs | 10 |
| Repositories | 5 |
| Screens | 20 |
| ViewModels | 15 |
| Shared Components | 5 |
| DI Modules | 2 |
| **Total Kotlin** | **~70** |
