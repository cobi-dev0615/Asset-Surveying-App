# Inventario Activo Fijo (ActivoFijoV113.apk)

**Mobile Fixed Asset Inventory Management System**

| Field       | Value                                        |
|-------------|----------------------------------------------|
| App Name    | Inventario Activo Fijo                       |
| Package     | `cf.ser.actfijo`                             |
| Version     | 1.1.3 (build 10103)                         |
| Product Code| SERINVFIJOAND                                |
| Developer   | Codigo Fractal (@marcxploit)                 |
| Company     | Servicios Empresariales Retail               |
| Platform    | Android 5.0 - 12 (SDK 21-31)                |
| Framework   | Apache Cordova (Hybrid HTML/JS + Native)     |
| Language    | Spanish                                      |

---

## Overview

Inventario Activo Fijo is an enterprise mobile application for physical fixed asset inventory management. It enables companies to conduct asset counts across multiple locations, scan barcodes and capture photos for asset identification, print labels via Bluetooth, track GPS coordinates, and synchronize results with a central server. The app supports multi-tenant operation with company selection at login and operates fully offline with server sync capabilities.

---

## Features

### Authentication and Licensing

- Multi-tenant login with company selection dropdown
- Username and password authentication with SHA256 hashing
- Inventory and location selection at login
- Device-specific licensing tied to hardware serial number
- Trial and production license modes
- License validation against remote server (`glint.codigofractal.com`)
- License blacklist system for fraud prevention
- In-app payment processing for license purchase

### Fixed Asset Inventory Counting

- Area and department selection for targeted counting
- Barcode and QR code scanning via camera (ZXing library)
- Manual product code entry
- Category-based asset organization
- Quantity input with optional decimal support
- Serial number capture with bulk entry modal
- Photo capture (up to 3 photos per asset for condition documentation)
- Brand and model selection
- Lot number and expiration date tracking (optional)
- Forced code entry for assets not in catalog
- GPS coordinate tagging per count entry
- Resume previous inventory sessions
- Cross-count verification for audit accuracy

### Product Catalog Management

- Search products by code, SKU, description, or brand
- Manual product creation and editing
- Bulk import from Excel/XLSX files
- Cloud import from server
- Product details: up to 3 codes, description, brand, category, price, unit of measure
- Print product labels

### Bluetooth Printing

- ESC/POS compatible printers for ticket printing
- Zebra CPCL printers for label printing (MZ220, iMZ220, RW220, RW420, QLn220, QLn420)
- Bluetooth device discovery and pairing
- Two printer slots: tickets (printer 0) and labels (printer 1)
- Test print functionality

### Reporting and Analytics

- Dashboard with D3/C3 charts showing:
  - Overall inventory progress
  - Progress by department/area
  - Assets by category
- Four report types:
  - Grouped by Product: aggregated quantity totals
  - Grouped by Product and Location: breakdown by position
  - Detail Report: line-by-line entries with timestamps
  - Differences: theoretical versus actual variance analysis
- Inventory value calculation
- Export to CSV files on device
- Export to server for multi-device synchronization
- Print location summary reports via Bluetooth

### Server Synchronization

- Upload inventory counts to cloud API (`ser.codigofractal.com`)
- Download product catalogs from central server
- Multi-device collaboration through server sync
- Offline-first architecture with local data persistence
- Sync status tracking per record

---

## Technical Architecture

```
+-------------------------------------+
|       UI Layer (HTML/CSS/JS)        |
|  Bootstrap MDB 4.19.1 + jQuery     |
|  DataTables + SweetAlert2 + C3.js  |
+-------------------------------------+
|         Cordova Bridge              |
+----------+----------+--------------+
| Bluetooth| Barcode  | SQLite/File  |
| Serial   | Scanner  | GPS/Camera   |
|(Printers)| (ZXing)  | (Storage)    |
+----------+----------+--------------+
|       Android OS (SDK 21-31)       |
+------------------------------------+
```

### Frontend Libraries

- **Bootstrap MDB Pro 4.19.1** - Material Design responsive UI
- **jQuery** - DOM manipulation and AJAX requests
- **DataTables 1.10.18** - Table display with search, sort, and pagination
- **Select2** - Enhanced dropdown selection
- **SweetAlert2** - Modal dialogs and alerts
- **C3.js / D3.js** - Dashboard charts and data visualization
- **AlaSQL** - Client-side Excel/XLSX file processing and complex aggregations
- **Font Awesome 5.14.0** - Icon library

### Cordova Plugins

| Plugin             | Purpose                                    |
|--------------------|--------------------------------------------|
| BluetoothSerial    | Bluetooth printer communication            |
| BarcodeScanner     | QR and barcode scanning via ZXing          |
| Camera             | Photo capture for asset documentation      |
| Geolocation        | GPS coordinate capture                     |
| SQLitePlugin       | Local database for products and records    |
| File               | File system access for export              |
| Device             | Hardware identification for licensing      |
| Media              | Audio alert playback                       |
| InAppBrowser       | Embedded web browser for external links    |
| Toast              | Native Android toast notifications         |
| NavigationBar      | System navigation bar customization        |
| SplashScreen       | App startup loading screen                 |
| StatusBar          | System status bar styling                  |
| Dialogs            | Native alert, confirm, and prompt dialogs  |

### Data Storage

The app uses two parallel database systems:

| System | Technology | Database Name | Purpose |
|--------|-----------|---------------|---------|
| LocalStorageDB | JavaScript localStorage | `northwindSSM` | Config, sessions, lightweight records |
| SQLite | Cordova SQLitePlugin | `Northwind.db` | Product catalogs, large dataset operations |

---

## Database Schema

### SQLite Tables

#### catalogos (Product Catalog)

| Column | Type | Description |
|--------|------|-------------|
| inventario | TEXT | Inventory ID |
| id_producto | TEXT | Product ID |
| codigo_1 | TEXT | Primary barcode |
| codigo_2 | TEXT | Secondary code (SKU) |
| codigo_3 | TEXT | Tertiary code |
| descripcion | TEXT | Product name |
| precio_venta | TEXT | Selling price |
| modelo | TEXT | Model |
| marca | TEXT | Brand |
| categoria | TEXT | Category |
| subcategoria | TEXT | Subcategory |
| precio_compra | TEXT | Purchase price |
| unidad_medida | TEXT | Unit of measure |
| observaciones | TEXT | Notes |
| cantidad_teorica | TEXT | Expected quantity |
| forzado | TEXT | Manually added flag (0/1) |
| sincronizado | TEXT | Synced to server flag (0/1) |
| eliminado | TEXT | Soft delete flag (0/1) |
| cantidad_real | DECIMAL(10,2) | Actual counted quantity (default 0) |

#### registros (Inventory Count Records)

| Column | Type | Description |
|--------|------|-------------|
| id_registro | TEXT | Record ID |
| inventario | TEXT | Inventory ID |
| id_producto | TEXT | Product ID |
| almacen | TEXT | Warehouse ID |
| nombre_almacen | TEXT | Warehouse name |
| ubicacion | TEXT | Location/rack |
| cantidad | TEXT | Counted quantity |
| codigo_1 | TEXT | Primary barcode |
| codigo_2 | TEXT | Secondary code |
| codigo_3 | TEXT | Tertiary code |
| descripcion | TEXT | Product description |
| modelo | TEXT | Model |
| marca | TEXT | Brand |
| categoria | TEXT | Category |
| subcategoria | TEXT | Subcategory |
| precio_compra | TEXT | Purchase price |
| precio_venta | TEXT | Selling price |
| unidad_medida | TEXT | Unit of measure |
| observaciones | TEXT | Notes |
| lote | TEXT | Lot/batch number |
| fecha_caducidad | TEXT | Expiration date |
| n_serie | TEXT | Serial number |
| fecha_captura | TEXT | Capture date |
| hora_captura | TEXT | Capture time |
| usuario | TEXT | User ID |
| nombre_usuario | TEXT | User name |
| cantidad_teorica | TEXT | Expected quantity |
| forzado | TEXT | Forced entry flag (0/1) |
| sincronizado | TEXT | Synced flag (0/1) |
| eliminado | TEXT | Soft delete flag (0/1) |

### LocalStorageDB Tables

#### sesion_actual (Current Session Data)

| Column | Description |
|--------|-------------|
| datos_sesion | JSON string containing full session data |

#### permisos (License and Activation)

| Column | Description |
|--------|-------------|
| id_activacion | Activation ID |
| cliente | Client name |
| fecha_inicio | Start date |
| fecha_fin | End date |
| vigente | Active flag (0/1) |
| prueba | Demo/trial flag (0/1) |
| codigo_activacion | Activation code |
| llave_activacion | Activation key |
| lista_negra | Blacklist flag (0/1) |
| eliminado | Soft delete flag (0/1) |

#### producto_info (App Version)

| Column | Default Value |
|--------|---------------|
| nombre_app | Inventario activo fijo |
| version_producto | 1.1.3 |
| codigo_producto | SERINVFIJOAND |
| version_actual | 1.1.3 |

#### configuraciones (Connection and Printer Settings)

| Column | Description |
|--------|-------------|
| modo_online | Online/offline mode (0/1, default: 1) |
| ip_servidor | Server IP address |
| nombre_servidor | Server hostname |
| mac_impresora_0 | Ticket printer Bluetooth MAC |
| nombre_impresora_0 | Ticket printer name |
| marca_impresora_0 | Ticket printer brand |
| mac_impresora_1 | Label printer Bluetooth MAC |
| nombre_impresora_1 | Label printer name |
| marca_impresora_1 | Label printer brand |

#### configuraciones_lectura (Capture Rules)

| Column | Default | Description |
|--------|---------|-------------|
| ubicacion_obligatoria | 1 | Location required |
| validar_catalogo | 1 | Validate against catalog |
| codigos_forzados | 1 | Allow forced codes |
| descripcion_codigo_forzado | 1 | Require description for forced codes |
| lotes | 0 | Batch tracking |
| n_series | 0 | Serial number tracking |
| fecha_caducidad | 0 | Expiration date tracking |
| fecha_fabricacion | 0 | Manufacturing date tracking |
| cantidad_cero | 0 | Allow zero quantities |
| cantidades_negativas | 0 | Allow negative quantities |
| usar_camara | 1 | Camera barcode scanning |
| busqueda_catalogo | 0 | Catalog search mode |
| comentarios | 1 | Comments field |
| foto | 0 | Photo capture |
| nfc | 0 | NFC support |
| rfid | 0 | RFID support |
| coordenadas | 0 | GPS coordinate capture |
| inventario_en_linea | 0 | Online inventory mode |
| permitir_decimales | 1 | Allow decimal quantities |
| n_decimales | 2 | Number of decimal places |

#### usuarios (User Accounts)

| Column | Description |
|--------|-------------|
| nombre_usuario | Display name |
| usuario | Username/login |
| password | SHA256 hashed password |
| administrador | Admin flag (0/1) |
| eliminado | Soft delete flag (0/1) |

#### inventarios (Inventory Headers)

| Column | Default Value |
|--------|---------------|
| id_inventario | 1 |
| nombre_inventario | Inventario general |
| fecha_creacion | Current date |
| usuario | Supervisor |
| eliminado | 0 |

#### almacenes (Warehouses)

| Column | Default Value |
|--------|---------------|
| id_almacen | 1 |
| inventario | 1 |
| nombre_almacen | Almacen general |
| eliminado | 0 |
| n_conteo | 0 |

#### catalogos (LocalStorage copy)

Same columns as SQLite catalogos table. Used as localStorage cache for quick access.

#### registros (Inventory Records - localStorage copy)

Same columns as SQLite registros table plus:

| Column | Description |
|--------|-------------|
| n_conteo | Count number (1st, 2nd count) |
| latitud | GPS latitude |
| longitud | GPS longitude |
| factor | Unit conversion factor |
| total_factor | Factor-adjusted total |
| fecha_elaboracion | Manufacturing date |
| lectura_array | Raw scan data array |

#### sesionesSSM (Active Session)

| Column | Default Value |
|--------|---------------|
| id_usuario | 0 |
| nombre_usuario | Supervisor |
| es_administrador | 1 |
| usuario_conteo | Supervisor |
| fecha_hora | Current datetime |

#### datos_pago (Payment Transactions)

| Column | Description |
|--------|-------------|
| orden_id | Payment order ID |
| metodo_pago | Payment method (PayPal, etc.) |
| tipo_licencia | License type |
| cliente_id | Client ID |
| email | Client email |
| cliente | Client name |
| fecha_inicio | Start date |
| hora_inicio | Start time |
| fecha_fin | End date |
| codigo_activacion | Activation code |
| llave_activacion | Activation key |
| fecha_hora | Transaction datetime |
| otros_datos | Additional data (JSON) |
| sincronizado | Synced flag (0/1) |

#### datos_pago_error (Failed Payment Records)

| Column | Description |
|--------|-------------|
| metodo_pago | Payment method |
| tipo_licencia | License type |
| orden_status | Order status |
| orden_id | Order ID |
| cliente_id | Client ID |
| email | Client email |
| cliente | Client name |
| fecha_hora | Transaction datetime |
| otros_datos | Additional data |
| sincronizado | Synced flag (0/1) |

#### registros_cruzados (Cross-Count Records)

Same structure as registros table including n_conteo, latitud, and longitud columns. Used for secondary verification counts during inventory audits.

### Seed Data

The app includes a sample dataset at `assets/www/json/datosInventario2290.json` containing 2,290 inventory records from June 2020 with retail products across 4 warehouses.

### Database Source Files

| File | Purpose |
|------|---------|
| `scripts/mscripts/bd.js` | Database initialization and schema management |
| `scripts/mscripts/general.js` | Default configuration values and global variables |
| `scripts/mscripts/licencia.js` | License validation and payment operations |
| `scripts/mscripts/inventario_captura.js` | Record insertion during asset capture |
| `scripts/mscripts/inventario_reporte.js` | Report queries and aggregations |
| `scripts/mscripts/productos_catalogo.js` | Catalog search and management |
| `scripts/mscripts/productos_nuevo.js` | New product creation |
| `scripts/mscripts/productos_importacion.js` | Excel catalog import |
| `scripts/mscripts/productos_importacion_ssr.js` | Server catalog import |
| `scripts/mscripts/PanelServidor.js` | Server configuration |

### Database Operations

The app uses these common patterns across both storage systems:

- **Soft deletes**: Records use `eliminado` flag (0/1) instead of physical deletion
- **Sync tracking**: `sincronizado` flag (0/1) marks records uploaded to server
- **Date tampering detection**: Compares `sesionesSSM.fecha_hora` against current date
- **Dual storage**: Critical data stored in both LocalStorageDB and SQLite
- **Schema migration**: `actualizaBDLocal()` handles column additions via `alterTable()` for backward compatibility
- **Forced products**: `forzado` flag distinguishes manually added assets from catalog imports

---

## Android Permissions

| Permission                 | Purpose                              |
|----------------------------|--------------------------------------|
| `INTERNET`                 | Server synchronization               |
| `BLUETOOTH`                | Bluetooth printer communication      |
| `BLUETOOTH_ADMIN`          | Bluetooth device discovery           |
| `ACCESS_FINE_LOCATION`     | GPS coordinates and BT discovery     |
| `ACCESS_COARSE_LOCATION`   | Bluetooth device scanning            |
| `WRITE_EXTERNAL_STORAGE`   | CSV and Excel file export            |
| `CAMERA`                   | Photo capture and barcode scanning   |
| `FLASHLIGHT`               | Camera flash for scanning            |
| `RECORD_AUDIO`             | Audio features                       |
| `MODIFY_AUDIO_SETTINGS`    | Audio configuration                  |
| `READ_PHONE_STATE`         | Device identification                |
| `VIBRATE`                  | Haptic feedback notifications        |

**Required hardware features:** Camera, GPS

---

## App Screens

1. **Login** (`index.html`) - Multi-tenant authentication with company and inventory selection
2. **Dashboard** (`inicio.html`) - Analytics charts, main navigation, printer configuration
3. **Inventory Location** (`inventario_ubicacion.html`) - Area/department selection, resume sessions
4. **Inventory Capture** (`inventario_captura.html`) - Barcode scanning, quantity entry, photo capture, serial numbers
5. **Cross-Count** (`inventario_ubicacion_cruzado.html`) - Secondary verification count
6. **Product Catalog** (`productos_catalogo.html`) - Product search and management
7. **Product Import** (`productos_importacion.html`) - Excel file import
8. **New Product** (`productos_nuevo.html`) - Manual product creation
9. **Reports** (`inventario_reporte.html`) - Four report types with export options
10. **Product Lookup** (`inventario_consulta.html`) - Quick product search
11. **License Activation** (`panel_activacion.html`) - License code entry and payment
12. **Payment** (`panel_pago.html`) - In-app purchase processing
13. **About** (`acercade.html`) - Version and developer info

---

## Configuration Options

The app provides extensive capture configuration:

- Online or offline operation mode
- Mandatory location field requirement
- Product catalog validation enforcement
- Forced code handling for unknown assets
- Lot number tracking toggle
- Serial number tracking toggle
- Expiration date tracking toggle
- Manufacturing date tracking toggle
- Zero quantity allowance
- Negative quantity allowance
- Decimal quantity support with configurable precision
- Camera barcode scanning toggle
- NFC and RFID support toggles
- GPS coordinate capture toggle
- Comments field toggle
- Photo capture toggle (up to 3 photos per asset)

---

## External Services

| Service                | URL                                                  | Purpose                    |
|------------------------|------------------------------------------------------|----------------------------|
| App Server             | `https://ser.codigofractal.com/`                     | API and data sync          |
| License Server         | `https://glint.codigofractal.com/GlintScriptsV2/`   | License validation         |
| Website                | `https://www.simplestockmobile.com/`                 | Product information        |

### API Endpoints

- `empresasCatalogo.php` - Get company list for multi-tenant login
- `inventariosEmpresa.php` - Get available inventories per company
- `sesionCerrar.php` - Close user session
- `productosConsultarCodigo.php` - Look up product by code
- `reporteGralAvanceInventario.php` - Get inventory progress analytics

---

## Supported Printers

**Zebra CPCL printers:**
MZ220, iMZ220, RW220, RW420, QLn220, QLn420

**ESC/POS compatible printers:**
Any Bluetooth printer supporting the ESC/POS command set

---

## Hardware Integration

| Hardware | Plugin | Use Case |
|----------|--------|----------|
| Camera | Camera, BarcodeScanner | Photo documentation, barcode/QR scanning |
| Bluetooth | BluetoothSerial | Printer communication |
| GPS | Geolocation | Asset location tagging |
| Vibration | Built-in | Haptic feedback on errors |
| Audio | Media | Success/error sound alerts |
| Flashlight | Camera | Scanning in low light |

---

## Key Differences from SER Inventarios (SERV122)

| Feature | SER Inventarios | Activo Fijo |
|---------|-----------------|-------------|
| Purpose | Retail product inventory | Fixed asset inventory |
| Multi-tenant | No | Yes (company selection) |
| Camera photos | No | Yes (up to 3 per asset) |
| Barcode library | Basic scanner | ZXing (encode + decode) |
| Dashboard charts | Basic doughnut | 3 analytics charts |
| Default mode | Offline | Online |
| API server | simplestockmobile.com | ser.codigofractal.com |
| Session table | Shared with SSM | Dedicated sesion_actual |
| Product code | SERSSMAND | SERINVFIJOAND |

---

## File Structure

```
ActivoFijoV113.apk
ActivoFijoV113.apk.bak           # Backup copy
ActivoFijoV113-source/
  sources/                        # Decompiled Java source code
    cf/ser/actfijo/               # Main app (MainActivity, BuildConfig)
    com/megster/cordova/           # BluetoothSerial plugin
    com/phonegap/plugins/         # BarcodeScanner plugin
    com/google/zxing/             # ZXing barcode library
    com/viniciusfagundes/         # NavigationBar plugin
    barcodescanner/               # Scanner utilities
    androidx/                     # Android support libraries
  resources/
    AndroidManifest.xml           # App manifest
    assets/www/                   # Web app (HTML, JS, CSS, images)
    res/                          # Android resources (layouts, strings, icons)
    lib/                          # Native libraries (arm64, armeabi, x86, x86_64)
```

---

## Build Information

- Build type: Release
- Debug mode: Disabled
- Hardware acceleration: Enabled
- Screen orientation: Portrait only
- Cleartext traffic: Enabled
- RTL support: Enabled
- Supported architectures: arm64-v8a, armeabi-v7a, x86, x86_64
