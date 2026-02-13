# Database Analysis Results

**Date:** 2026-02-13
**Source:** phpMyAdmin exports from HostGator CPanel (seretail.com.mx)
**Server:** MySQL 5.7.23-23, PHP 8.1.34

---

## Overview

| Database | Domain | Host | Tables | Data Rows | Size |
|----------|--------|------|--------|-----------|------|
| `seretail_wp927` | WordPress (main site) | seretail.com.mx | 68 | ~170 | 4,532 lines |
| `seretail_ser_activo_fijo` | Fixed Assets | activofijo.seretail.com.mx | 6 | ~63,929 | 64,410 lines |
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

### Verdict: Main production database. 63K+ asset scan records. PRIMARY migration target.

| Property | Value |
|----------|-------|
| Charset | utf8mb4 (all tables) |
| Engine | InnoDB (all tables) |
| Foreign Keys | None (all relationships are implicit) |
| Soft Deletes | Yes (`eliminado` column on all tables) |

### Tables (6 total)

#### empresas (Companies)

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key |
| usuario | int(11) | FK to users (not in this dump) |
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
| id | int(11) | Primary key |
| empresa | int(11) | FK to empresas.id |
| sucursal | varchar(150) | Branch code (e.g., 'MX010129') |
| ciudad | varchar(150) | City name |
| local | varchar(150) | Local/premises info |
| nombre | varchar(150) | Branch name (e.g., 'ADANA LINCOLN') |
| comentarios | varchar(150) | Comments |
| usuario | int(11) | FK to users (not in this dump) |
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
| id | bigint(20) | Primary key |
| id_inventario | int(11) | FK to inventarios.id |
| id_usuario | int(11) | FK to users (not in this dump) |
| id_producto | bigint(20) | FK to products (not in this dump) |
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

**Data: 63,186+ rows** (truncated — see warnings below)

- ID range: 136,015 — 200,595+
- Date range: 2024-08-19 to 2025-11-23
- 279 distinct inventory sessions referenced
- 12 distinct users: IDs 5, 10, 13, 14, 27, 30, 33, 34, 37, 39, 40, 46
- App versions: 1.1.0, 1.1.0.1, 1.1.2
- Transfers: 231 rows marked as `traspasado='true'`
- Photos: ~30,507 rows have image filenames (~48% of records)
- GPS coordinates: ~18,965 entries with non-zero lat/lng
- **RFID tags: EMPTY in ALL rows** — feature never used
- Zone/area names: Cardio, Peso Integrado, Peso Libre, Bodega, Recepcion, Vestidores, Gerencia, Staff, Salon de Clases, Shape y Box, Site, Cuarto de Limpieza, Cabinas

#### activos_no_encontrados (Assets Not Found)

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key |
| activo | bigint(20) | FK to product/asset ID |
| usuario | int(11) | FK to user |
| latitud | float | GPS latitude |
| longitud | float | GPS longitude |
| fechaHora | datetime | Timestamp |

**Data: 2 rows**

#### activos_traspasados (Transferred Assets)

| Column | Type | Description |
|--------|------|-------------|
| id | int(11) | Primary key |
| activo | bigint(20) | FK to product/asset ID |
| sucursalOrigen | int(11) | Origin branch ID |
| sucursalDestino | int(11) | Destination branch ID |
| usuario | int(11) | FK to user |
| fechaHora | datetime | Transfer timestamp |
| eliminado | int(11) | Soft-delete flag |

**Data: 0 rows** (empty)

### Relationships (Implicit — No Foreign Key Constraints)

```
empresas.id  <----  inventarios.empresa
inventarios.id  <----  inventario_registros.id_inventario
inventarios.status  ---->  inventarios_status.id
inventario_registros.id_usuario  ---->  [users table — NOT IN DUMP]
inventario_registros.id_producto  ---->  [products table — NOT IN DUMP]
activos_no_encontrados.activo  ---->  [products table — NOT IN DUMP]
activos_no_encontrados.usuario  ---->  [users table — NOT IN DUMP]
activos_traspasados.activo  ---->  [products table — NOT IN DUMP]
activos_traspasados.usuario  ---->  [users table — NOT IN DUMP]
```

### WARNINGS

1. **TRUNCATED EXPORT:** The dump ends mid-row at ID 200,595. Missing: remaining data rows, all ALTER TABLE statements (primary keys, indexes, auto_increment values), and the closing COMMIT. **Must re-export.**
2. **MISSING TABLES:** The `usuarios` (users) and `productos` (products/assets master) tables are NOT in this dump. The 12 user IDs and thousands of `id_producto` values reference tables not included. **Check phpMyAdmin for additional tables.**
3. **No dedicated branches table:** Branches are stored as denormalized strings in `inventarios`.

### Migration Action: **CRITICAL** — Re-export this database completely. Verify all tables are included.

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
| Users | 1 WP admin | 12 user IDs (no table) | 2 users + 3 roles |
| Products/Assets | - | referenced (no table) | 4,919 products |
| Inventory Sessions | - | 733 sessions | 2 sessions |
| Scan Records | - | 63,186+ records | 0 records |
| Branches | - | 55 cities (inline) | 0 |
| Transfers | - | 231 flagged | 0 |
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
| Fixed Assets | 5,10,13,14,27,30,33,34,37,39,40,46 | Unknown | Unknown | Unknown (no table) |

### Domains and Subdomains

| Domain | Database | Purpose |
|--------|----------|---------|
| seretail.com.mx | seretail_wp927 | Main website (empty WordPress) |
| activofijo.seretail.com.mx | seretail_ser_activo_fijo | Fixed asset management (production) |
| ssr.seretail.com.mx | seretail_ssm_ssr | Inventory/stock management |

---

## Action Items

### Immediate (Before Development)

1. **Re-export `seretail_ser_activo_fijo`** — current export is truncated mid-row at ID 200,595. Need complete dump with all ALTER TABLE statements.
2. **Verify missing tables** — the Fixed Assets database is missing `usuarios` and `productos` master tables. Check phpMyAdmin for all tables in that database.
3. **Locate photo storage** — ~30,507 asset photos referenced as filenames (e.g., `408299-1.jpg`). Find where these are stored on the server (likely in a directory under activofijo.seretail.com.mx).

### For Unified Schema Design

4. **Normalize character sets** — standardize all columns to `utf8mb4` (drop latin1 overrides).
5. **Add proper foreign key constraints** — current databases have zero referential integrity.
6. **Convert string dates to DATE/DATETIME** — several columns store dates as varchar strings.
7. **Reduce denormalization** — remove duplicate name columns, use proper joins.
8. **Add proper PRIMARY KEY to `usuarios_roles`**.
9. **Unify user accounts** — merge the 12 Fixed Assets user IDs with the 2 SSR user accounts.
10. **Create dedicated `sucursales` (branches) table** — currently branches are inline strings in `inventarios`.
