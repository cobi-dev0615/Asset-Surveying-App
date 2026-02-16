# SER Inventarios (SERV122.apk)

**Mobile Physical Inventory Management System**

| Field       | Value                                      |
|-------------|--------------------------------------------|
| App Name    | SER Inventarios (Simple Stock Mobile)      |
| Package     | `cf.ser.ssm`                               |
| Version     | 1.2.2 (build 10202)                        |
| Developer   | Codigo Fractal (@marcxploit)               |
| Platform    | Android 5.0 - 13 (SDK 21-33)              |
| Framework   | Apache Cordova (Hybrid HTML/JS + Native)   |
| Language    | Spanish                                    |

---

## Overview

SER Inventarios is an enterprise-grade mobile application designed for physical inventory counting in retail stores, warehouses, and distribution centers. It allows field workers to scan product barcodes, record quantities by location, print labels and tickets via Bluetooth, and synchronize results with a central server. The app operates fully offline and supports multi-count verification workflows.

---

## Features

### Authentication and Licensing

- Username and password login with SHA256 password hashing
- Role-based user permissions
- Device-specific license tied to hardware serial number
- 7-day demo mode for evaluation
- License validation against remote server (`glint.codigofractal.com`)
- User expiration date enforcement

### Physical Inventory Counting

- Warehouse and department selection
- Support for multiple count batches (1st, 2nd, 3rd count)
- Barcode scanning via camera or external scanner
- Manual product code entry
- Quantity input with optional decimal support
- Lot number, expiration date, and serial number tracking
- Location, rack, and pallet assignment
- Cross-count verification for audit purposes
- Real-time validation against imported product catalog
- Optional GPS coordinate tagging per count entry

### Product Catalog Management

- Search products by code, SKU, EAN, UPC, or description
- Manual product creation and editing
- Bulk import from Excel/XLSX files
- Cloud import from Simple Stock Report server
- Product details: codes, description, unit of measure, price, theoretical quantity

### Bluetooth Printing

- ESC/POS compatible printers for receipt and ticket printing
- Zebra CPCL printers for label printing (MZ220, iMZ220, QLn220, RW220)
- Bluetooth device discovery and pairing
- Printer configuration and test print functionality

### Reporting

- Count by Product: aggregated quantity totals
- Count by Product and Location: breakdown by warehouse position
- Detail Report: line-by-line entry listing
- GNC Report: gaps, negatives, and corrections analysis
- Variance analysis comparing theoretical versus actual quantities
- Total inventory value calculation
- Export to CSV and Excel formats

### Server Synchronization

- Upload inventory counts to cloud API
- Download product catalogs from central server
- Configurable on-premise server IP address
- Offline-first architecture with local data persistence
- Automatic sync when connectivity is available

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
| Serial   | Scanner  | GPS/Device   |
|(Printers)| (Camera) | (Storage)    |
+----------+----------+--------------+
|       Android OS (SDK 21-33)       |
+------------------------------------+
```

### Frontend Libraries

- **Bootstrap MDB Pro 4.19.1** - Material Design responsive UI
- **jQuery** - DOM manipulation and AJAX requests
- **DataTables 1.10.18** - Table display with search, sort, and pagination
- **Select2** - Enhanced dropdown selection
- **SweetAlert2** - Modal dialogs and alerts
- **C3.js / D3.js** - Dashboard charts and data visualization
- **AlaSQL** - Client-side Excel/XLSX file processing
- **Font Awesome 5.14.0** - Icon library

### Cordova Plugins

| Plugin             | Purpose                                    |
|--------------------|--------------------------------------------|
| BluetoothSerial    | Bluetooth printer communication            |
| BarcodeScanner     | QR and barcode reading via camera          |
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
| Dialogs            | Native alert and prompt dialogs            |

### Data Storage

The app uses two parallel database systems:

| System | Technology | Database Name | Purpose |
|--------|-----------|---------------|---------|
| LocalStorageDB | JavaScript localStorage | `northwindSSM` | Config, sessions, lightweight records |
| SQLite | Cordova SQLitePlugin | `Northwind.db` | Product catalogs, heavy data operations |

---

## Database Schema

### SQLite Tables

#### catalogos (Product Catalog)

| Column | Type | Description |
|--------|------|-------------|
| inventario | INTEGER | Inventory ID |
| id_producto | INTEGER | Product ID |
| codigo_1 | VARCHAR(50) | Primary barcode |
| codigo_2 | VARCHAR(50) | Secondary code (SKU) |
| codigo_3 | VARCHAR(50) | Tertiary code |
| descripcion | VARCHAR(50) | Product name |
| precio_venta | DECIMAL | Selling price |
| modelo | VARCHAR(50) | Model |
| marca | VARCHAR(50) | Brand |
| categoria | VARCHAR(50) | Category |
| subcategoria | VARCHAR(50) | Subcategory |
| precio_compra | DECIMAL | Purchase price |
| unidad_medida | VARCHAR(50) | Unit of measure |
| observaciones | VARCHAR(50) | Notes |
| cantidad_teorica | INTEGER | Expected quantity |
| forzado | INTEGER | Manually added flag (0/1) |
| sincronizado | INTEGER | Synced to server flag (0/1) |
| eliminado | INTEGER | Soft delete flag (0/1) |
| cantidad_real | DECIMAL(10,2) | Actual counted quantity |
| factor | DECIMAL(10,2) | Unit conversion factor |

Indexes: `indexCodigo1` on codigo_1, `indexCodigo2` on codigo_2, `indexCodigo3` on codigo_3

#### registros (Inventory Count Records)

| Column | Type | Description |
|--------|------|-------------|
| id_registro | INTEGER PK AUTO | Record ID |
| inventario | INTEGER | Inventory ID |
| id_producto | INTEGER | Product ID |
| almacen | VARCHAR(50) | Warehouse ID |
| nombre_almacen | VARCHAR(50) | Warehouse name |
| ubicacion | VARCHAR(50) | Location/rack |
| cantidad | INTEGER | Counted quantity |
| codigo_1 | VARCHAR(50) | Primary barcode |
| codigo_2 | VARCHAR(50) | Secondary code |
| codigo_3 | VARCHAR(50) | Tertiary code |
| descripcion | VARCHAR(128) | Product description |
| modelo | VARCHAR(50) | Model |
| marca | VARCHAR(50) | Brand |
| categoria | VARCHAR(50) | Category |
| subcategoria | VARCHAR(50) | Subcategory |
| precio_compra | DECIMAL | Purchase price |
| precio_venta | DECIMAL | Selling price |
| unidad_medida | VARCHAR(50) | Unit of measure |
| observaciones | VARCHAR(50) | Notes |
| lote | VARCHAR(50) | Lot/batch number |
| fecha_caducidad | VARCHAR(50) | Expiration date |
| n_serie | VARCHAR(50) | Serial number |
| fecha_captura | VARCHAR(50) | Capture date |
| hora_captura | VARCHAR(50) | Capture time |
| usuario | VARCHAR(50) | User ID |
| nombre_usuario | VARCHAR(50) | User name |
| cantidad_teorica | INTEGER | Expected quantity |
| forzado | INTEGER | Forced entry flag (0/1) |
| sincronizado | INTEGER | Synced flag (0/1) |
| eliminado | INTEGER | Soft delete flag (0/1) |

#### lotes_caducidades (Batch and Expiration Tracking)

| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER PK AUTO | Record ID |
| inventario | INTEGER | Inventory ID |
| cantidad | DECIMAL | Quantity |
| codigo1 | VARCHAR(50) | Primary code |
| codigo2 | VARCHAR(50) | Secondary code |
| codigo3 | VARCHAR(50) | Tertiary code |
| lote | VARCHAR(50) | Lot number |
| fechaCaducidad | VARCHAR(50) | Expiration date |

Index: `idx_codigo2` on codigo2

### LocalStorageDB Tables

#### permisos (License and Activation)

| Column | Description |
|--------|-------------|
| id_activacion | Activation ID |
| cliente | Client name |
| fecha_inicio | Start date |
| fecha_fin | End date |
| vigente | Active flag (0/1) |
| prueba | Demo flag (0/1) |
| codigo_activacion | Activation code |
| llave_activacion | Activation key |
| lista_negra | Blacklist flag (0/1) |
| eliminado | Soft delete flag (0/1) |

#### producto_info (App Version)

| Column | Default Value |
|--------|---------------|
| nombre_app | SER Inventarios |
| version_producto | 1.2.2 |
| codigo_producto | SERSSMAND |
| version_actual | 1.2.2 |

#### configuraciones (Connection and Printer Settings)

| Column | Description |
|--------|-------------|
| modo_online | Online/offline mode (0/1) |
| ip_servidor | Server IP address |
| nombre_servidor | Server hostname (default: simplestockmobile.com) |
| mac_impresora_0 | Ticket printer Bluetooth MAC |
| nombre_impresora_0 | Ticket printer name |
| marca_impresora_0 | Ticket printer brand (ESC/POS or Zebra) |
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
| factor | 0 | Unit conversion factor |

#### usuarios (User Accounts)

| Column | Description |
|--------|-------------|
| id_usuario | User ID |
| usuario | Username |
| nombre_usuario | Display name |
| password | SHA256 hashed password |
| rol | User role |
| expiracion_sesion | Session expiration date |
| acceso_app | App access flag (0/1) |
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

#### registros (Inventory Records - localStorage copy)

Same columns as SQLite `registros` table plus:

| Column | Description |
|--------|-------------|
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
| metodo_pago | Payment method |
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
| otros_datos | Additional data |
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

Same structure as `registros` table. Used for secondary verification counts during inventory audits.

### Seed Data

The app includes a sample dataset at `assets/www/json/datosInventario2290.json` containing 2,290 inventory records from June 2020:

| Warehouse | Records |
|-----------|---------|
| Cuarto Frio (Cold Room) | 973 |
| Almacen general (General Warehouse) | 780 |
| Piso de ventas (Sales Floor) | 439 |
| Bodega (Storage) | 98 |

Sample products include retail items such as antibacterial gel, pens, notebooks, snack foods, and canned goods with prices ranging from 3.50 to 36.00.

### Database Source Files

| File | Purpose |
|------|---------|
| `scripts/mscripts/bd.js` | Database initialization and schema |
| `scripts/mscripts/general.js` | Default configuration values |
| `scripts/mscripts/inventario_captura.js` | Record insertion during capture |
| `scripts/mscripts/inventario_reporte.js` | Report queries |
| `scripts/mscripts/productos_importacion.js` | Catalog import operations |
| `scripts/mscripts/productos_importacion_ssr.js` | Server catalog import |
| `scripts/mscripts/inventario_exportacion_ssr.js` | Data export and sync |

### Database Operations

The app uses these common patterns across both storage systems:

- **Soft deletes**: Records use `eliminado` flag (0/1) instead of physical deletion
- **Sync tracking**: `sincronizado` flag (0/1) marks records uploaded to server
- **Date tampering detection**: Compares `sesionesSSM.fecha_hora` against current date to detect clock manipulation
- **Batch transactions**: SQLite operations use transactions for bulk inserts of 30-5000 records
- **Forced products**: `forzado` flag distinguishes manually added products from catalog imports
- **Factor conversion**: `factor` field enables unit-of-measure conversions

---

## Android Permissions

| Permission                 | Purpose                              |
|----------------------------|--------------------------------------|
| `INTERNET`                 | Server synchronization               |
| `ACCESS_NETWORK_STATE`     | Network availability detection       |
| `BLUETOOTH`                | Bluetooth printer communication      |
| `BLUETOOTH_ADMIN`          | Bluetooth device discovery           |
| `ACCESS_FINE_LOCATION`     | GPS coordinates and BT discovery     |
| `ACCESS_COARSE_LOCATION`   | Bluetooth device scanning            |
| `WRITE_EXTERNAL_STORAGE`   | CSV and Excel file export            |
| `RECORD_AUDIO`             | Audio features                       |
| `VIBRATE`                  | Haptic feedback notifications        |

**Required hardware feature:** GPS (`android.hardware.location.gps`)

---

## App Screens

1. **Login** (`index.html`) - Authentication and session management
2. **Dashboard** (`inicio.html`) - Main menu with chart overview and navigation
3. **Inventory Location** (`inventario_ubicacion.html`) - Warehouse and count batch selection
4. **Inventory Capture** (`inventario_captura.html`) - Barcode scanning and quantity entry
5. **Cross-Count** (`inventario_ubicacion_cruzado.html`) - Secondary verification count
6. **Product Catalog** (`productos_catalogo.html`) - Product search and management
7. **Product Import** (`productos_importacion.html`) - Excel file import
8. **Server Import** (`productos_importacion_ssr.html`) - Cloud catalog sync
9. **New Product** (`productos_nuevo.html`) - Manual product creation
10. **Reports** (`inventario_reporte.html`) - Count reports and export
11. **Product Lookup** (`inventario_consulta.html`) - Quick product search
12. **Server Config** (`PanelServidor.html`) - Server IP configuration
13. **License Activation** (`panel_activacion.html`) - License code entry
14. **Active License** (`panel_licencia_activa.html`) - License status display
15. **Payment** (`panel_pago.html`) - Purchase and renewal
16. **About** (`acercade.html`) - Version and developer info

---

## Configuration Options

The app provides extensive capture configuration through the settings panel:

- Online or offline operation mode
- Mandatory location field requirement
- Product catalog validation enforcement
- Forced code handling for unknown products
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
- Photo capture toggle

---

## External Services

| Service                              | URL                                                    | Purpose                    |
|--------------------------------------|--------------------------------------------------------|----------------------------|
| License Server                       | `https://glint.codigofractal.com/GlintScriptsV2/`     | License validation         |
| Product and Inventory API            | `https://simplestockmobile.com/SER/InventariosAPIV3/` | Cloud sync                 |
| On-Premise Server                    | User-configurable IP                                   | Local network operations   |

### API Endpoints

- `licenciaPrueba.php` - Demo license generation
- `inventarioInsertar.php` - Upload inventory count data
- `ProductosCantidad.php` - Retrieve product quantities
- `ProductosCatalogoImportacion.php` - Import product catalog
- `UsuariosCatalogo.php` - User and catalog synchronization

---

## Supported Printers

**Zebra CPCL printers:**
MZ220, iMZ220, RW220, QLn220

**ESC/POS compatible printers:**
Any Bluetooth printer supporting the ESC/POS command set

---

## File Structure

```
SERV122.apk
SERV122.apk.bak              # Backup copy
SERV122-source/
  sources/                    # Decompiled Java source code
    cf/ser/ssm/               # Main app (MainActivity, BuildConfig)
    com/megster/cordova/       # BluetoothSerial plugin
    com/viniciusfagundes/      # NavigationBar plugin
    androidx/                  # Android support libraries
  resources/
    AndroidManifest.xml        # App manifest
    assets/www/                # Web app (HTML, JS, CSS, images)
    res/                       # Android resources (layouts, strings, icons)
    lib/                       # Native libraries (arm64, armeabi, x86, x86_64)
```

---

## Build Information

- Build type: Release
- Debug mode: Disabled
- Hardware acceleration: Enabled
- Screen orientation: Portrait only
- Supported architectures: arm64-v8a, armeabi-v7a, x86, x86_64
