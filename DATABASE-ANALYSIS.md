# Database Analysis Results

**Date:** 2026-02-13
**Source:** phpMyAdmin exports from HostGator CPanel (seretail.com.mx)
**Server:** MySQL 5.7.23-23, PHP 8.1.34

---

## Overview

| Database | Domain | Host | Tables | Data Rows | Size |
|----------|--------|------|--------|-----------|------|
| `seretail_wp927` | WordPress (main site) | seretail.com.mx | 68 | ~170 | 4,532 lines |
| `seretail_ser_activo_fijo` | Fixed Assets | activofijo.seretail.com.mx | **16** | **~577,046** | **581,030 lines** |
| `seretail_ssm_ssr` | Inventory / SSR | ssr.seretail.com.mx | 23 | ~7,856 | 8,784 lines |

**Shared IP:** 162.241.62.220
**Home Directory:** /home2/seretail
**Disk Usage:** 59.8 GB / 75 GB (79.74%)

---

## 1. seretail_wp927 (WordPress)

### Verdict: Empty WordPress installation. No business data to migrate.

| Property | Value |
|----------|-------|
| Site URL | https://seretail.com.mx |
| WP Version | 6.9.x (DB version 60717) |
| Language | es_ES (Spanish) |
| Theme | twentytwentytwo |
| Admin email | avillegas@seretail.com.mx |
| Table prefix | `wpdq_` |
| Charset | utf8mb4 / utf8mb4_unicode_520_ci |

### Tables (68 total)

- **12** standard WordPress core tables
- **8** AIOWPS (All In One WP Security) plugin tables
- **22** CleanTalk Security plugin tables
- **26** Wordfence plugin tables

### Users

| ID | Login | Email | Role | Registered |
|----|-------|-------|------|------------|
| 1 | alan | avillegas@seretail.com.mx | Administrator | 2022-06-02 |
| 2 | marcxploit | (Marco Garcia) | Administrator | Missing from users table |

**Note:** User ID 2 (marcxploit / Marco Garcia, the original developer from Codigo Fractal) has usermeta entries but is missing from the `wpdq_users` INSERT. May have been deleted.

### Content

- 3 default posts (Hello world!, Sample Page, Privacy Policy draft)
- 1 default comment
- No custom post types, no custom tables, no business data

### Installed Plugins

1. Akismet (anti-spam)
2. All In One WP Security and Firewall
3. Really Simple SSL
4. CleanTalk Security/Malware Firewall
5. Wordfence

### Security Data

- 119 failed login attempts (brute-force bots)
- 6 xmlrpc.php attack hits
- 8 blocked IPs
- 4,459 malware signatures (CleanTalk definitions)

### Migration Action: **NONE** — Nothing to migrate from this database.

---

## 2. seretail_ser_activo_fijo (Fixed Assets)

### Verdict: Main production database. 157K+ asset scans, 172K+ products, 61 users. PRIMARY migration target.

> **Re-exported 2026-02-14** — File: `seretail_ser_activo_fijo (1).sql` (581,030 lines). Complete export with COMMIT, all indexes, constraints, and AUTO_INCREMENT values. All previous warnings resolved.

| Property | Value |
|----------|-------|
| Charset | utf8mb4 (all tables) |
| Engine | InnoDB (all tables) |
| Foreign Keys | **YES** — proper FK constraints on all major tables |
| Soft Deletes | Yes (`eliminado` column on all tables) |
| Total Tables | **16** |
| Total Lines | 581,030 |

### Tables (16 total)

#### empresas (Companies)

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key (AUTO_INCREMENT=22) |
| usuario | int(11) | FK to usuarios.id |
| codigo | varchar(8) | Company code (e.g., 'MX01') |
| nombre | varchar(256) | Company name |
| fecha_hora | datetime | Creation timestamp |
| eliminado | int(11) | Soft-delete flag |

**Data (5 rows):**

| ID | Code | Name | Created |
|----|------|------|---------|
| 11 | Smart Fi | Smart Fit 2024 | 2024-08-13 |
| 12 | 2103 | SER | 2025-01-06 |
| 17 | MX01 | SMART FIT 2025 | 2025-08-07 |
| 20 | MX101 | GRUPO DRAGON | 2025-09-25 |
| 21 | MX02 | Prueba Smart Fit | 2025-11-29 |

#### inventarios (Inventory Sessions)

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key (AUTO_INCREMENT=1295) |
| empresa | int(11) | FK to empresas.id |
| sucursal | varchar(150) | Branch code (e.g., 'MX010129') |
| ciudad | varchar(150) | City name |
| local | varchar(150) | Local/premises info |
| nombre | varchar(150) | Branch name (e.g., 'ADANA LINCOLN') |
| comentarios | varchar(150) | Comments |
| usuario | int(11) | FK to usuarios.id |
| inicio_conteo | int(11) | Count start marker |
| fin_conteo | int(11) | Count end marker |
| sucursal_id | int(11) | Numeric branch ID |
| fecha_hora | datetime | Session creation date |
| finalizado | int(11) | Finalization flag |
| status | int(11) | FK to inventarios_status.id |
| eliminado | int(11) | Soft-delete flag |
| ultima_actualizacion | timestamp | Auto-updated timestamp |

**Data: 733 sessions**

- By status: 684 FINALIZADO, 48 PENDIENTE, 1 INICIADO
- By company: Smart Fit 2024 (334), Smart Fit 2025 (393), SER (3), Grupo Dragon (2), Prueba (1)
- 55 unique cities across Mexico (CDMX dominant)
- Branch codes follow pattern `MX01XXXX`
- Branch names are Smart Fit gym locations

#### inventarios_status (Status Catalog)

| ID | Status |
|----|--------|
| 1 | PENDIENTE POR INICIAR |
| 2 | INICIADO |
| 3 | FINALIZADO |

#### inventario_registros (Individual Asset Scans) — MAIN TABLE

| Column | Type | Description |
|--------|------|-------------|
| id | bigint(20) | Primary key (AUTO_INCREMENT=298284) |
| id_inventario | int(11) | FK to inventarios.id |
| id_usuario | int(11) | FK to usuarios.id |
| id_producto | bigint(20) | FK to productos.id (no constraint) |
| traspasado | varchar(250) | 'true'/'false' — whether transferred |
| cantidad | int(11) | Quantity (always 1 for assets) |
| sucursal_origen | varchar(32) | Origin branch code if transferred |
| codigo_1 | varchar(250) | Primary asset code/barcode |
| codigo1Anterior | varchar(250) | Previous primary code |
| codigo_2 | varchar(250) | Secondary code (e.g., 'MX0008218') |
| codigo_3 | varchar(250) | Tertiary code |
| tagRFID | varchar(120) | RFID tag identifier |
| n_serie | varchar(250) | Serial number |
| nSerieAnterior | varchar(250) | Previous serial number |
| n_serie_nuevo | varchar(250) | New serial number |
| nombre_almacen | varchar(250) | Zone/area within the branch |
| version_app | varchar(11) | App version used to scan |
| ubicacion_1 | varchar(11) | Location sub-code |
| imagen1 | varchar(128) | Photo filename 1 |
| imagen2 | varchar(128) | Photo filename 2 |
| imagen3 | varchar(128) | Photo filename 3 |
| observaciones | longtext | Text observations |
| imagen | longtext | Additional image data |
| forzado | int(11) | Forced-entry flag |
| solicitado | int(11) | Requested flag |
| latitud | double | GPS latitude |
| longitud | double | GPS longitude |
| fecha_hora | datetime | Scan timestamp |
| ultima_actualizacion | datetime | Auto-updated timestamp |
| eliminado | int(11) | Soft-delete flag |

**Data: ~157,784 rows** (COMPLETE — previously truncated at 63K)

- ID range: up to 298,283 (AUTO_INCREMENT=298284)
- Zone/area names: Cardio, Peso Integrado, Peso Libre, Bodega, Recepcion, Vestidores, Gerencia, Staff, Salon de Clases, Shape y Box, Site, Cuarto de Limpieza, Cabinas
- Indexes on: eliminado, id_usuario, codigo_1, codigo_2, codigo_3, id_inventario, id_producto, n_serie, n_serie_nuevo, tagRFID

#### inventario_registros_backup (Backup Copy of Asset Scans)

**Data: ~156,308 rows** — Nearly identical backup of `inventario_registros`. Same schema.

#### productos (Product/Asset Catalog) — NEW IN RE-EXPORT

| Column | Type | Description |
|--------|------|-------------|
| id | bigint(20) | Primary key (AUTO_INCREMENT=464378) |
| id_inventario | int(11) | FK to inventarios.id |
| id_empresa | int(11) | FK to empresas.id |
| subsidaria | varchar(50) | Subsidiary/branch code (e.g., 'MX010011') |
| sucursal | int(1) | Branch ID (same as inventario id) |
| codigo_1 | varchar(50) | Primary asset code (Número activo) |
| codigo_2 | varchar(50) | Tag number (Número de tag) |
| codigo_3 | varchar(50) | Additional code |
| tagRFID | varchar(120) | RFID tag |
| descripcion | longtext | Asset description |
| n_serie | varchar(256) | Serial number |
| nSerieAnterior | varchar(256) | Previous serial number |
| n_serie_nuevo | varchar(256) | New serial number |
| categoria_1 | varchar(256) | Primary category (numeric code) |
| categoria_2 | varchar(256) | Secondary category (text label) |
| marca | varchar(256) | Brand |
| modelo | varchar(256) | Model |
| tipo_activo | varchar(256) | Asset type |
| fecha_inicio_servicio | varchar(256) | Service start date (as string) |
| imagen1 | varchar(256) | Photo filename 1 |
| imagen2 | varchar(256) | Photo filename 2 |
| imagen3 | varchar(256) | Photo filename 3 |
| cantidad_teorica | int(11) | Theoretical quantity |
| observaciones | longtext | Notes |
| imagen | longblob | Image blob |
| eliminado | int(1) | Soft-delete flag |
| no_encontrado | int(1) | Not-found flag |
| forzado | int(1) | Forced-entry flag |
| traspasado | int(1) | Transferred flag |
| solictado | int(1) | Requested flag (note: typo in original schema) |
| fecha_registro | datetime | Registration timestamp |
| ultima_actualizacion | datetime | Auto-updated timestamp |

**Data: ~172,620 rows** — Fixed asset catalog entries (gym equipment: monitors, lockers, bikes, treadmills, etc.)

- Categories include: MONITOR, LOCKERS, ESCRITORIO, COMPUTADORA DE ESCRITORIO, PANTALLA DE TV, UPS NO BREAK, CAMA DE HIDROMASAJE, BICICLETA, etc.
- Indexes on: codigo_1, codigo_2, codigo_3, eliminado, forzado, id_inventario, subsidaria, id_empresa, sucursal, no_encontrado, n_serie, n_serie_nuevo, tagRFID

#### usuarios (User Accounts) — NEW IN RE-EXPORT

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key (AUTO_INCREMENT=62) |
| usuario | varchar(250) latin1 | Username |
| nombres | varchar(250) latin1 | Full name |
| password | varchar(250) latin1 | SHA-256 hash |
| archivo_imagen | varchar(250) latin1 | Profile image filename |
| archivo_tamano | int(11) | Image file size |
| expiracion_sesion | date | Session expiry (default: 2999-12-31) |
| id_rol | int(11) | FK to usuarios_roles.id |
| inventariosAcceso | longtext | JSON/CSV of allowed inventory session IDs |
| empresasAcceso | longtext | JSON/CSV of allowed empresa IDs |
| activo | int(11) | Active user flag |
| acceso_cpanel | int(11) | CPanel/web access flag |
| acceso_app | int(11) | Mobile app access flag |
| eliminado | int(11) | Soft-delete flag |

**Data: 61 users (IDs 1-61)**

Key users:

| ID | Username | Name | Role | Active | Eliminated |
|----|----------|------|------|--------|------------|
| 1 | mgarcia | Marco García | 1 (Super Admin) | Yes | No |
| 5 | avillegas | Alan Villegas | 1 (Super Admin) | Yes | No |
| 11 | Lenin | Jose Luis Lenin Rodriguez Cruz | 4 (Invitado) | Yes | No |
| 26 | mgarcia | Marco García | 1 (Super Admin) | Yes | No |
| 35 | Supply | Supply | 4 (Invitado) | Yes | No |
| 36 | Mmorales | Mmorales | 4 (Invitado) | Yes | No |
| 60 | Tony | Tony | 1 (Super Admin) | Yes | No |
| 61 | Jam | Jam | 3 (Capturista) | Yes | No |

- Passwords are SHA-256 hashed (not bcrypt)
- `inventariosAcceso` and `empresasAcceso` store comma-separated IDs for access control
- 6 active users (activo=1, eliminado=0), 55 eliminated/inactive
- Duplicate usernames exist (e.g., 'mgarcia' at IDs 1 and 26, 'Paniagua' at IDs 20 and 21)

#### usuarios_roles (Role Definitions) — NEW IN RE-EXPORT

| ID | Role Name |
|----|-----------|
| 1 | Super Administrador del sistema |
| 2 | Supervisor de inventario |
| 3 | Capturista de inventario |
| 4 | Invitado |

**Note:** Role 4 "Invitado" matches what the client calls "Supervisor Invitado" for transfer operations.

#### log_sesiones (Session Audit Log) — NEW IN RE-EXPORT

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key (AUTO_INCREMENT=4127) |
| id_inventario | int(11) | FK to inventarios.id |
| usuario | int(11) | FK to usuarios.id |
| fecha_hora_entrada | datetime | Login timestamp |
| fecha_hora_salida | datetime | Logout timestamp |
| plataforma_dispositivo | varchar(100) latin1 | Device platform |
| serie_dispositivo | varchar(250) latin1 | Device serial number |
| latitud | float | GPS latitude |
| longitud | float | GPS longitude |
| sesion_activa | int(11) | Active session flag |

**Data: ~4,126 rows** — Complete audit trail of mobile app sessions from 2022-08-13 onwards.

#### ordenes_entrada (Entry/Transfer Orders) — NEW IN RE-EXPORT

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key (AUTO_INCREMENT=11) |
| usuario | int(11) | FK to usuarios.id (creator) |
| nOrden | int(11) | Order number |
| sucursalOrigen | int(11) | Origin branch (inventario ID) |
| sucursalDestino | int(11) | Destination branch (inventario ID) |
| motivo | varchar(256) | Reason (e.g., 'Mantenimiento', 'Daño en nuestro equipo') |
| comentarios | longtext | Comments |
| estatus | int(2) | FK to ordenes_entrada_estatus.id |
| autorizadoPor | int(11) | FK to usuarios.id (authorizer) |
| surtidoPor | int(10) | FK to usuarios.id (fulfiller) |
| canceladoPor | int(10) | Cancelled by user |
| rechazadoPor | int(10) | Rejected by user |
| fechaHora | datetime | Creation timestamp |
| fechaHoraSurtido | datetime | Fulfillment timestamp |
| fechaHoraCancelacion | datetime | Cancellation timestamp |
| eliminado | int(1) | Soft-delete flag |

**Data: 9 rows** — Transfer orders between branches (2025-08-11 to 2025-08-13).

#### ordenes_entrada_detalle (Order Line Items) — NEW IN RE-EXPORT

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key (AUTO_INCREMENT=15) |
| ordenEntrada | int(11) | FK to ordenes_entrada.id |
| idRegistro | int(11) | FK to inventario_registros.id |
| idInventario | int(11) | FK to inventarios.id |
| estatus | int(11) | Line item status |
| eliminado | int(11) | Soft-delete flag |
| ultimaActualizacion | datetime | Auto-updated timestamp |

**Data: 14 rows** — Individual assets linked to transfer orders.

#### ordenes_entrada_estatus (Order Status Catalog) — NEW IN RE-EXPORT

| ID | Status |
|----|--------|
| 1 | Pendiente |
| 2 | En proceso |
| 3 | Rechazado |
| 4 | Surtido |
| 5 | Cancelado |

#### reporte_acumulado (Accumulated Report — Materialized View) — NEW IN RE-EXPORT

Denormalized report table with pre-joined data for accumulated asset reports.

**Data: ~85,538 rows** — Pre-computed report data joining inventario_registros with productos, usuarios, and inventarios. Includes area, branch name, categories, user names, GPS coordinates.

**Note:** This is a materialized/cached view, not a source-of-truth table. Data is derived from the core tables.

#### reporte_general (General Report — Materialized View) — NEW IN RE-EXPORT

Denormalized report table for general per-session asset reports.

**Data: ~182 rows** — Pre-computed report data for a single inventory session (id_inventario=951). Includes photos, GPS, serial numbers, brands.

**Note:** Like `reporte_acumulado`, this is a cached report table, not a source-of-truth table.

#### activos_no_encontrados (Assets Not Found)

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key (AUTO_INCREMENT=6) |
| activo | bigint(20) | FK to productos.id |
| usuario | int(11) | FK to usuarios.id |
| latitud | float | GPS latitude |
| longitud | float | GPS longitude |
| fechaHora | datetime | Timestamp |

**Data: 2 rows** (IDs 4, 5)

#### activos_traspasados (Transferred Assets)

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key |
| activo | bigint(20) | FK to productos.id |
| sucursalOrigen | int(11) | Origin branch ID |
| sucursalDestino | int(11) | Destination branch ID |
| usuario | int(11) | FK to usuarios.id |
| fechaHora | datetime | Transfer timestamp |
| eliminado | int(11) | Soft-delete flag |

**Data: 0 rows** (empty — transfers tracked via `ordenes_entrada` instead)

### Relationships (With Foreign Key Constraints)

```
empresas.id  <----  inventarios.empresa          (FK: ON DELETE CASCADE)
inventarios.id  <----  inventario_registros.id_inventario  (FK: ON DELETE CASCADE)
inventarios.status  ---->  inventarios_status.id  (FK: ON DELETE NO ACTION)
inventario_registros.id_usuario  ---->  usuarios.id  (FK: ON DELETE NO ACTION)
productos.id  <----  activos_no_encontrados.activo  (FK: ON DELETE CASCADE)
productos.id  <----  activos_traspasados.activo     (FK: ON DELETE CASCADE)
productos.id_inventario  ---->  inventarios.id       (FK: ON DELETE CASCADE)
usuarios.id  <----  log_sesiones.usuario             (FK: ON DELETE NO ACTION)
usuarios.id  <----  ordenes_entrada.usuario          (FK: ON DELETE NO ACTION)
usuarios.id  <----  ordenes_entrada.autorizadoPor    (FK: ON DELETE NO ACTION)
usuarios.id_rol  ---->  usuarios_roles.id            (FK: ON DELETE NO ACTION)
ordenes_entrada.id  <----  ordenes_entrada_detalle.ordenEntrada  (FK: ON DELETE CASCADE)
ordenes_entrada.estatus  ---->  ordenes_entrada_estatus.id       (FK: ON DELETE NO ACTION)
```

### Data Quality Notes

1. **Duplicate usernames:** 'mgarcia' (IDs 1, 26), 'Paniagua' (IDs 20, 21), 'Hector' (IDs 10, 40), 'Kenia' (IDs 28, 31), 'invitado' (IDs 8, 32), 'Gio' (IDs 27, 55)
2. **SHA-256 passwords:** Users have SHA-256 hashed passwords (not bcrypt). Migration must re-hash or use custom auth.
3. **No dedicated branches table:** Branches are denormalized in `inventarios` (sucursal, ciudad, local, nombre fields).
4. **`solictado` typo:** Column name has a typo in `productos` table (missing 'i' in 'solicitado').
5. **Materialized report tables:** `reporte_acumulado` (85K rows) and `reporte_general` (182 rows) are pre-computed cached data, not source-of-truth.
6. **Access control via CSV strings:** `inventariosAcceso` and `empresasAcceso` in `usuarios` store comma-separated IDs, not proper join tables.

### Migration Action: **READY** — Export is complete. All 16 tables present with data, indexes, constraints, and AUTO_INCREMENT values.

---

## 3. seretail_ssm_ssr (Inventory / SSR)

### Verdict: Full inventory management schema. Mostly empty (setup phase). 4,919 products loaded.

| Property | Value |
|----------|-------|
| Charset | utf8mb4 (tables) / latin1 (most string columns) |
| Engine | InnoDB (all except log_movimientos = MyISAM) |
| Foreign Keys | None (all relationships are implicit) |
| Soft Deletes | Yes (`eliminado` column on all tables) |

### Tables (23 total)

#### Core Inventory Tables

| Table | Rows | Purpose |
|-------|------|---------|
| inventarios | 2 | Inventory session headers |
| inventario | 0 | Count records (summary level) |
| inventario_detalle | 0 | Count records (line-item detail) |
| inventario_cruzado | 0 | Cross-count comparison |
| inv_temp | 0 | Temporary working table |
| almacenes | 0 | Warehouses/locations |
| ubicaciones_conteo_online | 0 | Online count locations |

#### Product and Catalog Tables

| Table | Rows | Purpose |
|-------|------|---------|
| productos | 4,919 | Product catalog (GNC supplements) |
| lotes_caducidades | 2,929 | Lot/batch expiry tracking |
| teorico_lotes | 0 | Theoretical lot tracking |
| teorico_ubicacion | 0 | Theoretical location mapping |
| teo_ubi_ser | 0 | SER-format location mapping |

#### User and Configuration Tables

| Table | Rows | Purpose |
|-------|------|---------|
| usuarios | 2 | User accounts |
| usuarios_roles | 3 | Role definitions |
| clientes | 0 | Client companies |
| configuraciones | 1 | System configuration |
| configuraciones_app | 3 | App platform configuration |
| configuraciones_impresoras | 0 | Printer configuration |

#### Order and Audit Tables

| Table | Rows | Purpose |
|-------|------|---------|
| orden_salida | 0 | Outbound/exit orders |
| orden_salida_log | 0 | Order audit log |
| orden_salida_productos | 0 | Order product lines |
| log_movimientos | 0 | Movement audit log (MyISAM) |
| log_sesiones | 0 | Session audit log |

### Key Table Schemas

#### usuarios (Users)

| Column | Type | Description |
|--------|------|-------------|
| id_usuario | int(11) | PK, AUTO_INCREMENT |
| usuario | varchar(250) latin1 | Username |
| nombres | varchar(250) latin1 | Full name |
| password | varchar(250) latin1 | SHA-256 hash |
| expiracion_sesion | date | Session expiry (default: 2999-12-31) |
| rol | int(11) | FK to usuarios_roles.id |
| acceso_pc | int(11) | PC/web access flag |
| acceso_app | int(11) | Mobile app access flag |
| eliminado | int(11) | Soft-delete flag |

**Data:**

| ID | Username | Full Name | Role | PC | App | Expiry |
|----|----------|-----------|------|----|-----|--------|
| 1 | alan | Alan Villegas | 3 (Super Admin) | Yes | Yes | 2999-12-31 |
| 2 | Oscar | Oscar Cabrera | 2 (Supervisor) | Yes | Yes | 2025-06-30 |

#### usuarios_roles (User Roles)

| ID | Role Name |
|----|-----------|
| 1 | Capturista de inventario (Data Entry) |
| 2 | Supervisor de inventarios (Supervisor) |
| 3 | Super Administrador del sistema (Super Admin) |

#### productos (Product Catalog)

| Column | Type | Description |
|--------|------|-------------|
| id_producto | bigint(20) | PK, AUTO_INCREMENT |
| cliente | int(11) | FK to clientes |
| inventario | int(11) | FK to inventarios |
| codigo_1 | varchar(50) latin1 | Barcode/UPC |
| codigo_2 | varchar(50) latin1 | SKU |
| codigo_3 | varchar(50) latin1 | Additional code |
| codigo_4 | varchar(50) latin1 | Additional code |
| codigo_5 | varchar(50) latin1 | Additional code |
| descripcion | longtext latin1 | Product description |
| marca | varchar(100) latin1 | Brand |
| modelo | varchar(100) latin1 | Model |
| categoria | varchar(100) latin1 | Category |
| subcategoria | varchar(100) latin1 | Subcategory |
| subcategoria_2 | varchar(100) latin1 | Sub-subcategory |
| precio_compra | decimal(10,3) | Purchase price |
| precioUltimaCompra | decimal(10,2) | Last purchase price |
| precio | decimal(10,0) | Sale price |
| cantidad_teorica | decimal(10,3) | Theoretical stock |
| factor | decimal(10,0) | Conversion factor |
| unidad_medida | varchar(10) latin1 | Unit of measure |
| fecha_elaboracion | varchar(16) latin1 | Manufacturing date |
| seriado | varchar(5) latin1 | Serialized flag |
| observaciones | varchar(2000) latin1 | Notes |
| imagen | longblob | Product image |
| eliminado | int(1) | Soft-delete flag |
| forzado | int(1) | Forced entry flag |
| fecha_registro | datetime | Registration timestamp |

**Data: 4,919 rows** — GNC health supplement products (vitamins, proteins, supplements). All belong to inventario=1.

#### inventarios (Inventory Sessions)

| Column | Type | Description |
|--------|------|-------------|
| id_inventario | int(11) | PK, AUTO_INCREMENT |
| nombre_inventario | varchar(150) latin1 | Session name |
| empresa | varchar(150) latin1 | Company name |
| logo_empresa | longblob | Company logo |
| sucursal_id | int(11) | Branch ID |
| sucursal_nombre | varchar(150) | Branch name |
| sucursal | varchar(150) latin1 | Branch code |
| auditor | varchar(150) latin1 | Auditor name |
| firma_auditor | longblob | Auditor signature (blob) |
| gerente | varchar(150) latin1 | Manager name |
| firma_gerente | longblob | Manager signature (blob) |
| subgerente | varchar(150) latin1 | Assistant manager |
| firma_subgerente | longblob | Sub-manager signature (blob) |
| usuario | int(11) | FK to usuarios |
| nombre_usuario | varchar(150) latin1 | Username (denormalized) |
| inicio_conteo | int(11) | Count start number |
| fin_conteo | int(11) | Count end number |
| fecha_creacion | datetime | Creation date |
| motivo_cancelacion | longtext latin1 | Cancellation reason |
| eliminado | int(11) | Soft-delete flag |
| ultima_actualizacion | timestamp | Auto-updated |

**Data: 2 rows:**

| ID | Name | Company | User | Date |
|----|------|---------|------|------|
| 1 | Inventario mayo 2025 | Codigo Fractal | Alan Villegas | 2025-05-06 |
| 2 | 0260 | GNC | Oscar Cabrera | 2025-05-06 |

#### inventario (Count Records — Summary Level)

| Column | Type | Description |
|--------|------|-------------|
| id_registro | bigint(20) | PK, AUTO_INCREMENT |
| inventario | int(11) | FK to inventarios |
| usuario | int(11) | FK to usuarios |
| id_producto | bigint(20) | FK to productos |
| nombre_conteo | varchar(150) latin1 | Count name |
| cantidad | decimal(10,3) | Counted quantity |
| codigo_1 | varchar(250) latin1 | Barcode/UPC |
| codigo_2 | varchar(250) latin1 | SKU |
| codigo_3 | varchar(250) latin1 | Additional code |
| ubicacion_1 | varchar(250) latin1 | Location |
| precio_compra | decimal(10,3) | Purchase price |
| factor | decimal(10,3) | Conversion factor |
| unidad_medida | varchar(250) latin1 | Unit of measure |
| almacen | int(11) | FK to almacenes |
| cantidad_teorica | decimal(10,3) | Theoretical quantity |
| precio | decimal(10,0) | Sale price |
| nombre_almacen | varchar(250) latin1 | Warehouse name (denormalized) |
| lote | varchar(250) latin1 | Batch/lot number |
| fecha_caducidad | varchar(50) latin1 | Expiry date (as string) |
| ubicacion_2 | varchar(250) latin1 | Location 2 |
| ubicacion_3 | varchar(250) latin1 | Location 3 |
| imagen | longblob | Photo evidence |
| sincronizado | int(11) | Sync flag (0/1) |
| forzado | int(11) | Forced entry flag |
| id_app | int(11) | App device ID |
| eliminado | int(11) | Soft-delete flag |
| c2Actualizado | int(11) | Count 2 updated flag |
| fecha_hora | datetime | Timestamp |

**Data: 0 rows** (empty)

#### inventario_detalle (Count Records — Line-Item Detail)

| Column | Type | Description |
|--------|------|-------------|
| id | bigint(20) | PK, AUTO_INCREMENT |
| id_registro | bigint(20) | FK to inventario.id_registro |
| inventario | int(11) | FK to inventarios |
| usuario | int(11) | FK to usuarios |
| id_producto | bigint(20) | FK to productos |
| n_conteo | int(11) | Count number (1st, 2nd, etc.) |
| nombre_conteo | varchar(150) latin1 | Count name |
| cantidad | decimal(10,3) | Counted quantity |
| factor | decimal(10,0) | Conversion factor |
| codigo_1 | varchar(250) latin1 | Barcode |
| codigo_2 | varchar(250) latin1 | SKU |
| codigo_3 | varchar(250) latin1 | Additional code |
| unidad_medida | varchar(250) latin1 | Unit of measure |
| nombre_usuario | varchar(250) latin1 | Username (denormalized) |
| lote | varchar(250) latin1 | Batch |
| fecha_caducidad | varchar(50) latin1 | Expiry date (string) |
| fecha_elaboracion | varchar(16) latin1 | Manufacturing date |
| n_serie | varchar(250) latin1 | Serial number |
| ubicacion_1 | varchar(250) latin1 | Location 1 |
| ubicacion_2 | varchar(250) latin1 | Location 2 |
| almacen | int(11) | FK to almacenes |
| nombre_almacen | varchar(250) latin1 | Warehouse name |
| imagen | longblob | Photo evidence |
| latitud | double | GPS latitude |
| longitud | double | GPS longitude |
| id_dispositivo | varchar(250) latin1 | Device ID |
| marca_dispositivo | varchar(250) latin1 | Device brand |
| modelo_dispositivo | varchar(250) latin1 | Device model |
| n_serie_dispositivo | varchar(250) latin1 | Device serial |
| lectura_array | varchar(250) latin1 | Raw scan data array |
| fecha_captura | date | Capture date |
| hora_captura | time | Capture time |
| id_app | int(11) | App device ID |
| eliminado | int(11) | Soft-delete flag |
| editado | int(11) | Edited flag |
| versionApp | varchar(250) latin1 | App version |
| c2Actualizado | int(11) | Count 2 updated flag |
| importadoCSV | int(11) | Imported from CSV flag |
| fecha_hora | datetime | Timestamp |

**Data: 0 rows** (empty)

### Relationships (Implicit — No Foreign Key Constraints)

```
inventarios.id_inventario  <--  inventario.inventario
                           <--  inventario_detalle.inventario
                           <--  inventario_cruzado.inventario
                           <--  almacenes.inventario
                           <--  productos.inventario
                           <--  lotes_caducidades.inventario
                           <--  orden_salida.inventario
                           <--  log_movimientos.inventario
                           <--  ubicaciones_conteo_online.inventario
                           <--  inv_temp.inventario
                           <--  teorico_lotes.inventario
                           <--  teorico_ubicacion.inventario
                           <--  teo_ubi_ser.inventario

usuarios.id_usuario  <--  inventario.usuario
                     <--  inventarios.usuario
                     <--  inventario_detalle.usuario
                     <--  log_movimientos.usuario
                     <--  log_sesiones.usuario
                     <--  orden_salida.usuario
                     <--  ubicaciones_conteo_online.usuario

productos.id_producto  <--  inventario.id_producto
                       <--  inventario_detalle.id_producto
                       <--  inventario_cruzado.id_producto
                       <--  orden_salida_productos.id_producto

usuarios_roles.id  <--  usuarios.rol
clientes.id_cliente  <--  productos.cliente
                     <--  orden_salida.cliente
almacenes.id  <--  inventario.almacen
              <--  inventario_detalle.almacen
inventario.id_registro  <--  inventario_detalle.id_registro
orden_salida.id_orden_salida  <--  orden_salida_log.orden_salida
                              <--  orden_salida_productos.orden_salida
```

### Data Quality Issues

1. **Mixed character sets:** Tables default to `utf8mb4` but most string columns override to `latin1`. Problematic for Spanish text (accents, tildes).
2. **Dates as strings:** `fecha_caducidad`, `fechaCaducidad`, `fecha_inicio/fin` store dates as `varchar(50)` in format `dd/mm/yyyy 12:00:00 a. m.` instead of proper DATE/DATETIME types.
3. **Heavy denormalization:** `nombre_almacen`, `nombre_usuario`, `nombre_conteo` duplicated across tables instead of joined.
4. **No referential integrity:** Zero foreign key constraints. All enforced at application level.
5. **`usuarios_roles` has no PRIMARY KEY constraint.**
6. **`log_movimientos` uses MyISAM engine** (all others use InnoDB).

### Migration Action: Migrate `usuarios`, `usuarios_roles`, `productos`, `lotes_caducidades`, `inventarios`, and `configuraciones` tables. Normalize character sets to utf8mb4.

---

## Cross-Database Summary

### Business Data Distribution

| Data Type | WordPress DB | Fixed Assets DB | SSR/Inventory DB |
|-----------|-------------|-----------------|------------------|
| Companies | - | 5 companies | 1 config record |
| Users | 1 WP admin | **61 users + 4 roles** | 2 users + 3 roles |
| Products/Assets | - | **172,620 asset catalog entries** | 4,919 products |
| Inventory Sessions | - | 733 sessions (AUTO_INC=1295) | 2 sessions |
| Scan Records | - | **157,784 records** (+156K backup) | 0 records |
| Branches | - | 55 cities (inline) | 0 |
| Transfers | - | **9 orders + 14 line items** | 0 |
| Session Logs | - | **4,126 audit entries** | 0 |
| Report Cache | - | **85,720 cached rows** (2 tables) | 0 |
| Photos | - | ~30,507 references | 0 |
| RFID Data | - | Column exists, all empty | - |
| Lot/Batch | - | - | 2,929 records |

### Known Users Across Systems

| Source | ID | Username | Name | Role |
|--------|----|----------|------|------|
| WordPress | 1 | alan | - | WP Administrator |
| WordPress | 2 | marcxploit | Marco Garcia | WP Administrator (deleted?) |
| SSR | 1 | alan | Alan Villegas | Super Admin |
| SSR | 2 | Oscar | Oscar Cabrera | Supervisor |
| Fixed Assets | 1 | mgarcia | Marco García | Super Admin |
| Fixed Assets | 5 | avillegas | Alan Villegas | Super Admin |
| Fixed Assets | 42 | Oscar | Oscar Cabrera | Supervisor |
| Fixed Assets | 60 | Tony | Tony | Super Admin |
| Fixed Assets | 61 | Jam | Jam | Capturista |
| Fixed Assets | ... | (61 total users) | ... | 4 roles |

### Domains and Subdomains

| Domain | Database | Purpose |
|--------|----------|---------|
| seretail.com.mx | seretail_wp927 | Main website (empty WordPress) |
| activofijo.seretail.com.mx | seretail_ser_activo_fijo | Fixed asset management (production) |
| ssr.seretail.com.mx | seretail_ssm_ssr | Inventory/stock management |

---

## Action Items

### ~~Immediate (Before Development)~~ — RESOLVED (2026-02-14)

1. ~~**Re-export `seretail_ser_activo_fijo`**~~ — **DONE.** New export: 581,030 lines, 16 tables, complete with COMMIT.
2. ~~**Verify missing tables**~~ — **DONE.** `usuarios` (61 rows), `productos` (172K rows), `log_sesiones` (4K rows), `ordenes_entrada` (9 rows + 14 details), `reporte_acumulado` (85K rows), `reporte_general` (182 rows), `inventario_registros_backup` (156K rows) all present.
3. **Locate photo storage** — ~30,507 asset photos referenced as filenames (e.g., `408299-1.jpg`). Find where these are stored on the server (likely in a directory under activofijo.seretail.com.mx). **STILL PENDING.**

### For Unified Schema Design

4. **Normalize character sets** — standardize all columns to `utf8mb4` (drop latin1 overrides in usuarios, log_sesiones).
5. ~~**Add proper foreign key constraints**~~ — **ALREADY EXISTS** in prod. Our Laravel schema already has FK constraints.
6. **Convert string dates to DATE/DATETIME** — `fecha_inicio_servicio` in productos stored as varchar.
7. **Reduce denormalization** — report tables (reporte_acumulado, reporte_general) are materialized views; consider generating these on-the-fly instead.
8. ~~**Add proper PRIMARY KEY to `usuarios_roles`**~~ — Has UNIQUE KEY on `id` in prod. Our schema has proper PK.
9. **Unify user accounts** — Merge the 61 Fixed Assets users with the 2 SSR users. Handle SHA-256 → bcrypt password migration.
10. ~~**Create dedicated `sucursales` (branches) table**~~ — **DONE** in our Laravel schema. Will need to extract branches from denormalized `inventarios` data.

### New Items (from re-export analysis)

11. **Add `ordenes_entrada` system** — Transfer order management with approval workflow (Pendiente → En proceso → Surtido/Rechazado/Cancelado). Need 3 new tables + controller.
12. **Handle duplicate usernames** — 6 duplicate username pairs in prod data. Decide: keep newest, merge, or add suffix.
13. **Password migration strategy** — Existing passwords are SHA-256. Options: (a) force password reset, (b) dual-hash check during login, (c) re-hash on first successful login.
14. **Access control migration** — `inventariosAcceso` and `empresasAcceso` CSV fields need to be migrated to proper pivot/join tables.
15. **Decide on report caching** — `reporte_acumulado` (85K rows) and `reporte_general` (182 rows) are cached reports. Generate dynamically or maintain cache tables?
