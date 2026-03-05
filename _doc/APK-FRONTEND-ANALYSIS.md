# Análisis Frontend de APKs del Cliente — SER Inventarios

> Análisis detallado de las 3 aplicaciones Android proporcionadas por el cliente (Servicios Empresariales Retail). Incluye todas las pantallas, diálogos, funciones y endpoints de cada APK.

---

## Resumen Ejecutivo

| Aspecto | SERV122 (Inventarios) | ActivoFijoV113 | ActivoFijoV200RFID |
|---------|----------------------|----------------|-------------------|
| **Paquete** | `cf.ser.ssm` | `cf.ser.actfijo` | `maui.cf.activofijoser` |
| **Versión** | 1.2.2 | 1.1.3 | 2.0.0 |
| **Framework** | Apache Cordova | Apache Cordova | .NET MAUI |
| **UI Library** | MDB Pro 4.19.1 (Bootstrap 4) | MDB Pro 4.19.1 (Bootstrap 4) | Material 3 + DevExpress MAUI |
| **Min/Target SDK** | 21 / 30 | 21 / 30 | 23 / 35 |
| **Pantallas** | 18 páginas HTML | 19 páginas HTML | ~8 páginas MAUI (inferidas) |
| **Archivos JS** | ~20 custom | 26 custom | Compilado a nativo (.NET) |
| **Base de datos local** | localStorageDB + SQLite | localStorageDB + SQLite | Embebida en .NET |
| **Escáner** | Cordova BarcodeScanner | ZXing + Cordova BarcodeScanner | ML Kit + CameraX |
| **RFID** | No | No | Sí (GaoXin GG + RugLine RT501) |
| **Impresión BT** | ESC/POS + Zebra CPCL | ESC/POS + Zebra CPCL | Probable (permisos BT) |
| **GPS** | Sí (por registro) | Sí (por registro) | Sí (permisos) |
| **Cámara/Fotos** | No | Sí (3 fotos base64/activo) | Sí (CameraX) |
| **Desarrollador** | Codigo Fractal | Codigo Fractal | Codigo Fractal |

---

# APK 1: SERV122 — SER Inventarios (v1.2.2)

## Información General

- **Nombre:** SER Inventarios
- **Paquete:** `cf.ser.ssm`
- **Código interno:** `SERSSMAND`
- **Propósito:** Levantamiento de inventario físico de productos (conteo de stock)
- **Arquitectura:** Multi-page hybrid app (navegación `$(location).attr('href', 'page.html')`)
- **Orientación:** Solo retrato

## Stack Tecnológico

| Categoría | Tecnología |
|-----------|-----------|
| UI | MDB Pro 4.19.1 (Material Design Bootstrap 4) + jQuery |
| Iconos | FontAwesome 5.14.0 |
| Tablas | DataTables 1.10.18 |
| Dropdowns | Select2 (con tags) |
| Alertas | SweetAlert + SweetAlert2 |
| SQL Cliente | AlaSQL |
| BD Local (pequeña) | localStorageDB ("northwindSSM") |
| BD Local (grande) | Cordova SQLite Plugin |
| Gráficas | c3.js + d3.js, Chart.js |
| Hash | sha256.js |
| Carga | LoadingOverlay |
| Pagos | PayPal SDK |
| Escaneo | Cordova BarcodeScanner |
| Impresión BT | Cordova BluetoothSerial |
| GPS | Cordova Geolocation |
| Archivos | Cordova File API |

## Flujo de Navegación

```
index.html (Login)
  └─> inicio.html (Dashboard)
        ├─> inventario_ubicacion.html (Selección de Ubicación)
        │     └─> inventario_captura.html?ubicacion=X&nConteo=N (Captura)
        ├─> inventario_ubicacion_cruzado.html (Conteo Cruzado)
        │     └─> inventario_captura.html (Captura Cruzada)
        ├─> productos_catalogo.html (Catálogo)
        │     ├─> productos_nuevo.html (Nuevo Producto)
        │     ├─> productos_nuevo.html?id=X (Editar Producto)
        │     ├─> productos_importacion.html (Importar XLSX)
        │     └─> productos_importacion_ssr.html (Importar desde Servidor)
        ├─> inventario_consulta.html (Buscar Registros)
        ├─> inventario_reporte.html (Reportes)
        │     └─> inventario_exportacion_ssr.html (Exportar al Servidor)
        ├─> PanelServidor.html (Config. Servidor) [sidebar]
        ├─> panel_activacion.html (Activación Licencia) [sidebar]
        │     └─> panel_pago.html (Pago PayPal)
        ├─> panel_licencia_activa.html (Info Licencia) [sidebar]
        └─> acercade.html (Acerca de) [sidebar]
```

## Pantallas Detalladas

### 1. Login (`index.html`)

**Propósito:** Autenticación de usuario (offline, contra BD local).

**Elementos UI:**
- Navbar oscura: "Servicios Empresariales Retail"
- Logo SER
- Campo usuario (`#txt_usuario`)
- Campo contraseña (`#txt_password`)
- Botón "Entrar" (`#btn_login`, color cyan)
- Etiqueta de versión en pie

**Diálogos:**
- `#modal_info` — Información del desarrollador (Codigo Fractal)

**Funciones:**
- `iniciar_sesion()` — Valida credenciales contra localStorageDB `usuarios` (password hash SHA-256). Verifica rol, expiración de sesión, y navega a `inicio.html`
- Si no hay usuarios en BD, salta el login (primer uso)
- Detección de fecha límite (time-bomb): muestra "Acerca de" si fecha > 2025-05-30
- Back button: sale de la app (`navigator.app.exitApp()`)

---

### 2. Dashboard (`inicio.html`)

**Propósito:** Hub central de navegación con resumen gráfico del inventario.

**Elementos UI:**
- Sidebar deslizable: IMPRESORAS, SERVIDOR, LICENCIA, ACERCA DE, SALIR
- Botones de navegación:
  - "Conteo de inventario fisico" (`#btn_inventario`)
  - "Catalogo de productos" (`#btn_catalogo`)
  - "Consulta de productos" (`#btnConsulta`)
  - "Reportes de inventario" (`#btn_resumen`)
  - "Panel de control" (`#btn_configuraciones`, oculto)
- Gráfica donut/barras (c3.js): inventario teórico vs real
- Nombre de usuario en navbar

**Diálogos:**
- `#modal_info` — Información general
- `#modalImportacion` — Selección de método de importación: "Desde Servidor (SSR)" vs "Archivo XLSX"
- `#modal_impresoras` — Configuración de impresoras Bluetooth:
  - Dropdown impresora de tickets + impresora de etiquetas
  - Selector de lenguaje: ESC/POS o CPCL/Zebra
  - Botones de prueba de impresión
  - Escaneo y emparejamiento de dispositivos BT

**Funciones:**
- Navegación a todas las sub-páginas
- `preguntaCerrarSesion()` — Diálogo SweetAlert para cerrar sesión
- `consulta_dispositivos_bluetooth()` — Escanea dispositivos BT pareados
- `guarda_datos_impresora()` — Guarda config de impresoras en localStorageDB
- `creaGraficas()` — Gráfica c3.js barras: teórico vs real por producto
- Verificación de licencia y actualizaciones al cargar

---

### 3. Selección de Ubicación (`inventario_ubicacion.html`)

**Propósito:** Configurar usuario, almacén y número de conteo antes de iniciar captura.

**Elementos UI:**
- Campo usuario (`#txt_usuario`, deshabilitado para no-admin)
- Select2 almacén (`#txt_almacen`, con tags para crear nuevos)
- Selector de número de conteo (1 o 2)
- Botón "INICIAR CONTEO DE INVENTARIO" (`#btn_iniciar_conteo`)

**Diálogos:**
- `#modalUbicaciones` — Muestra ubicaciones existentes con totales agrupados (AlaSQL)

**Funciones:**
- `inicia_conteo()` — Valida campos, navega a `inventario_captura.html?ubicacion=X&nConteo=N`
- `guarda_datos_almacen()` — Guarda almacén en localStorageDB

---

### 4. Captura de Inventario (`inventario_captura.html`) — PANTALLA PRINCIPAL

**Propósito:** Pantalla core de operación — escaneo de códigos de barras, búsqueda de productos, entrada de cantidad, guardado de registros. Donde los operadores pasan la mayor parte del tiempo.

**Elementos UI:**
- Navbar: botón atrás, etiqueta de ubicación, menú de opciones
- Campo ubicación con botón de escaneo de cámara (modo 0)
- Campo código de producto con botón de escaneo (modo 1)
- Campo cantidad
- DataTable: registros capturados para la ubicación actual
- Campos opcionales (visibles según configuración): lote, número de serie, fecha caducidad, fecha fabricación, comentarios, coordenadas GPS, factor

**Diálogos:**

1. **`#modalOpciones`** — Menú de opciones con acciones variadas

2. **`#modalOpcionesLectura`** — Configuración de captura (~20 toggles):
   - `ubicacion_obligatoria` — Ubicación obligatoria
   - `validar_catalogo` — Validar contra catálogo
   - `codigos_forzados` — Permitir códigos desconocidos
   - `descripcion_codigo_forzado` — Requerir descripción para forzados
   - `lotes` — Habilitar seguimiento de lotes
   - `n_series` — Habilitar números de serie
   - `fecha_caducidad` — Habilitar fecha de caducidad
   - `fecha_fabricacion` — Habilitar fecha de fabricación
   - `cantidad_cero` — Permitir cantidad cero
   - `cantidades_negativas` — Permitir cantidades negativas
   - `usar_camara` — Usar cámara para escaneo
   - `busqueda_catalogo` — Habilitar búsqueda en catálogo
   - `comentarios` — Habilitar campo de comentarios
   - `foto` — Habilitar captura de foto
   - `nfc` — Habilitar lectura NFC
   - `rfid` — Habilitar lectura RFID
   - `coordenadas` — Habilitar captura GPS
   - `inventario_en_linea` — Modo inventario en línea
   - `permitir_decimales` — Permitir cantidades decimales
   - `factor` — Habilitar factor de conversión de unidad

3. **`#modal_forzado`** — Registro forzado cuando producto no está en catálogo (descripción + precio opcional)

4. **`#modal_n_series`** — Entrada de número de serie

5. **`#modalEliminaUbicacion`** — Confirmación de eliminación de ubicación

6. **`#ModalCatalogoProductos`** — Búsqueda de producto durante captura

**Funciones:**
- `scan(valor)` — Escáner con 5 contextos: ubicación (0), producto (1), lote (2), serie (3), eliminar ubicación (4)
- `consulta_producto_local(lectura)` — SQLite: `SELECT * FROM catalogos WHERE codigo_1=? OR codigo_2=? OR codigo_3=?`
- `inserta_fila_local()` — Inserta registro en localStorageDB con 30+ campos
- `limpia_campos()` — Resetea campos después de cada escaneo
- Feedback sonoro: `suenaBeep()` en éxito, `suenaError()` en fallo
- Vibración en alertas
- Captura GPS por registro (si habilitado)
- Impresión de etiquetas durante captura
- Actualización de DataTable después de cada escaneo

---

### 5. Consulta de Inventario (`inventario_consulta.html`)

**Propósito:** Buscar y explorar registros capturados.

**Elementos UI:**
- Campo de búsqueda con botón de escaneo
- Lista de resultados (`#lista_0`) — tarjetas Bootstrap: código, descripción, SKU, cantidad, ubicación, almacén, precio
- Botones de acción por tarjeta: imprimir, editar, eliminar

**Diálogos:**
- `#modalAlertaCatalogo` — Aviso para importar catálogo si BD vacía

**Funciones:**
- `consulta_lista_0(lectura)` — Búsqueda AlaSQL con LIKE en descripción y match exacto en códigos, GROUP BY producto
- `eliminar_producto()` — Elimina registro con confirmación SweetAlert
- `imprime()` — Impresión de etiqueta Zebra CPCL: Code 128, descripción, precio vía Bluetooth

---

### 6. Reportes de Inventario (`inventario_reporte.html`)

**Propósito:** Generar y mostrar reportes de inventario con 5 tipos, exportación e impresión.

**Elementos UI:**
- Selector de tipo de reporte (5 opciones)
- DataTable con columnas dinámicas según tipo
- Sección de estadísticas: total de productos, valor, registros, almacenes, ubicaciones
- Sección de diferencias (solo para reporte tipo 2): real, teórico, diferencia
- Botones: Exportar, Imprimir, Eliminar inventario

**Diálogos:**
- `#modalExportacion` — Selección de método: guardar en dispositivo (CSV) o exportar al servidor
- `#modalEliminarInventario` — Confirmación de eliminación con SweetAlert
- `#modalAyuda` — Ayuda sobre cada tipo de reporte

**Tipos de Reporte:**
1. **Agrupación por producto** — Productos agrupados, cantidades sumadas
2. **Agrupación por producto + ubicación** — Productos agrupados por producto y ubicación
3. **Diferencias** — Teórico vs real con diferencias (filas coloreadas: rojo negativo, verde cero, amarillo positivo)
4. **Detalle de conteo** — Registros individuales con 22 columnas
5. **Conteo cruzado** — Comparación conteo 1 vs conteo 2 con INNER JOIN

**Funciones:**
- Generación de reportes con AlaSQL (GROUP BY, SUM, JOIN)
- Exportación CSV vía Cordova File API
- Impresión BT del reporte completo (Zebra CPCL o ESC/POS)
- Eliminación total del inventario con confirmación

---

### 7. Exportación al Servidor (`inventario_exportacion_ssr.html`)

**Propósito:** Subir registros de inventario capturados al servidor SER.

**Elementos UI:**
- Radio buttons: tipo de conexión (servidor local / nube)
- Campo IP del servidor (editable para local, auto para nube)
- Campo ID de inventario
- Barra de progreso
- Botón "Iniciar exportacion"

**Diálogos:**
- `#modalInventario` — Progreso con barra y botón de importar

**Funciones:**
- Envío por lotes a `RegistrosGuardar.php`
- Barra de progreso actualizada durante carga
- Manejo de errores de red

**Endpoints API:**
- `{server}/SER/InventariosAPIV3/RegistrosGuardar.php` — POST registros de inventario

---

### 8. Catálogo de Productos (`productos_catalogo.html`)

**Propósito:** Explorar, buscar, imprimir, editar y eliminar productos del catálogo local.

**Elementos UI:**
- Barra de búsqueda con botón de escaneo
- Lista de productos como tarjetas: SKU, código, descripción, unidad, factor, precio
- Botones por producto: imprimir etiqueta, editar, eliminar
- FAB flotante con sub-opciones: importar desde servidor, importar XLSX, nuevo producto

**Diálogos:**
- `#modalAlertaCatalogo` — Aviso de catálogo vacío
- `#modalEtiquetas` — Diálogo de cantidad de etiquetas (max 50, formato Zebra 2"x1")

---

### 9. Nuevo/Editar Producto (`productos_nuevo.html`)

**Propósito:** Crear o editar producto en catálogo SQLite local.

**Elementos UI:**
- Código 1 (requerido) + escaneo
- SKU (Código 2) + escaneo
- Código 3 + escaneo
- Descripción (requerida, textarea)
- Unidad de medida, Precio de venta, Cantidad teórica, Factor
- Botones: Guardar, Limpiar

**Funciones:**
- Modo edición por parámetro `?id=X` en URL
- INSERT o UPDATE en SQLite `catalogos`
- Validación de campos requeridos y duplicados

---

### 10. Importar Productos desde XLSX (`productos_importacion.html`)

**Propósito:** Importar catálogo de productos desde archivo Excel.

**Elementos UI:**
- Selector de archivo `.xlsx`
- DataTable de previsualización
- Barra de progreso durante importación
- Enlace para descargar plantilla

**Funciones:**
- AlaSQL parsea `.xlsx` a JSON
- Inserción batch en SQLite (5000 registros por lote)
- Eliminación de duplicados por `codigo_1`
- Columnas esperadas: Codigo1, SKU, Codigo3, Descripcion, UnidadMedida, PrecioVenta, CantidadTeorica, Factor

---

### 11. Importar Productos desde Servidor (`productos_importacion_ssr.html`)

**Propósito:** Descargar catálogo de productos desde servidor SER.

**Elementos UI:**
- Radio buttons: conexión local / nube
- Campo IP servidor, Campo ID inventario
- Barra de progreso

**Endpoints API:**
- `ProductosCantidad.php` — Obtener total de productos
- `Productos.php` — Descargar productos paginados (5000/página)
- `LotesCaducidadesCantidad.php` — Obtener total de lotes
- `LotesCaducidades.php` — Descargar datos de lotes/caducidades

---

### 12. Configuración del Servidor (`PanelServidor.html`)

**Propósito:** Configurar la dirección IP del servidor local para comunicación LAN.

**Elementos UI:**
- Campo IP del servidor
- Botón guardar

---

### 13. Activación de Licencia (`panel_activacion.html`)

**Propósito:** Activar licencia de la app mediante código o compra.

**Diálogos:**
- `#modal_activacion` — Campo de código de activación
- `#modalEmailGmail` — Email para entrega de licencia
- `#modalMetodoPago` — Selección de método de pago

**Funciones:**
- Generación de llave: `sha256(product_code + activation_code + serial + model + manufacturer)`
- Validación contra servidor Glint
- Detección de manipulación de fecha
- Estados: `vigente` (válida) o `expirado`

---

### 14. Pago PayPal (`panel_pago.html`)

**Propósito:** Procesar pago de suscripción de licencia.

**Elementos UI:**
- Selector de duración: 1 semana ($3), 1 mes ($8), 3 meses ($16), 6 meses ($32), 12 meses ($56)
- Display de precio: subtotal, descuento, total en USD
- Botón PayPal

---

### 15. Licencia Activa (`panel_licencia_activa.html`)

**Propósito:** Mostrar estado actual de la licencia.

---

### 16. Acerca de (`acercade.html`)

**Propósito:** Versión y créditos del desarrollador.

---

### Endpoints API — SERV122

**API de Inventarios SER:**
- Base producción: `https://simplestockmobile.com/SER/InventariosAPIV3/`
- Base nube SSR: `https://ssr.seretail.com.mx/InventariosAPIV3/`
- Base local: `http://{IP}/SER/InventariosAPIV3/`

| Endpoint | Propósito |
|----------|----------|
| `ProductosCantidad.php` | Total de productos por inventario |
| `ProductosCatalogo.php` | Catálogo paginado |
| `Productos.php` | Productos paginados (5000/pág) |
| `RegistrosGuardar.php` | Subir registros de inventario |
| `LotesCaducidades.php` | Datos de lotes/caducidad |
| `LotesCaducidadesCantidad.php` | Total de lotes |

**API de Licencias (Glint):**

| Endpoint | Propósito |
|----------|----------|
| `ConsultaActualizaciones.php` | Verificar actualizaciones |
| `ConsultaPermisos.php` | Validar licencia |
| `ActivaProducto.php` | Activar clave de licencia |
| `IniciaPrueba.php` | Iniciar licencia de prueba |

---

# APK 2: ActivoFijoV113 — Inventario Activo Fijo (v1.1.3)

## Información General

- **Nombre:** Inventario activo fijo
- **Paquete:** `cf.ser.actfijo`
- **Código interno:** `SERINVFIJOAND`
- **Propósito:** Levantamiento de inventario de activos fijos (con fotos, GPS, traspasos entre sucursales)
- **Arquitectura:** Multi-page hybrid app (Cordova), misma estructura que SERV122
- **Orientación:** Solo retrato

## Stack Tecnológico

Idéntico a SERV122 con estas adiciones:

| Categoría | Tecnología |
|-----------|-----------|
| Cámara | cordova-plugin-camera 6.0.0 (fotos base64) |
| Toast | cordova-plugin-x-toast + toastr |
| FTP | cordova-plugin-ftp (utilidad de desarrollo) |

## Diferencias Clave vs SERV122

| Aspecto | SERV122 | ActivoFijoV113 |
|---------|---------|----------------|
| **Enfoque** | Conteo de stock (productos) | Inventario de activos fijos |
| **Login** | Offline (BD local) | Online (API con empresa/sucursal) |
| **Dashboard** | 1 gráfica (teórico vs real) | 3 gráficas (avance general, por área, por categoría) |
| **Captura** | Escaneo → busca local → guarda | Escaneo → busca en servidor → marca estatus |
| **Fotos** | No | 3 fotos base64 por activo |
| **Traspasos** | No | Sí (entre sucursales con confirmación) |
| **Estatus** | Solo cantidad contada | Encontrado / No Encontrado / Agregado |
| **Tabla pendientes** | No | DataTable con botones SELECCIONAR/NO ENCONTRADO |
| **API** | Solo exportación batch | Operaciones en tiempo real por registro |

## Flujo de Navegación

```
index.html (Login + Selección de Empresa/Inventario/Sucursal)
    |  [Login API → Selección de Inventario]
    v
inicio.html (Dashboard - 3 gráficas)
    |
    +──> inventario_ubicacion.html (Selección de Departamento/Área)
    |       |
    |       v
    |   inventario_captura.html (CAPTURA PRINCIPAL)
    |       |
    |       +──> inventario_consulta.html (Buscar Registros)
    |       +──> inventario_reporte.html (5 Tipos de Reporte)
    |       |       └──> inventario_exportacion_ssr.html (Exportar)
    |       +──> inventario_ubicacion_cruzado.html (Conteo Cruzado)
    |
    +──> productos_catalogo.html (Catálogo de Productos)
    |       +──> productos_nuevo.html (Nuevo/Editar)
    |       +──> productos_importacion.html (Importar Excel)
    |       +──> productos_importacion_ssr.html (Importar de Servidor)
    |
    +──> PanelServidor.html (Config. Servidor + Importación)
    +──> acercade.html (Acerca de)
    +──> panel_activacion.html (Licencia) → panel_pago.html (PayPal)
    +──> panel_licencia_activa.html (Info Licencia)
```

## Pantallas Detalladas

### 1. Login (`index.html`) — CON AUTENTICACIÓN API

**Propósito:** Login online con selección de empresa, autenticación contra servidor, y selección de inventario/sucursal.

**Elementos UI:**
- Dropdown empresa (`#txtEmpresas`) — poblado vía AJAX al cargar
- Campo usuario (`#txtUsuario`)
- Campo contraseña (`#txtPassword`)
- Botón "Iniciar sesion" (`#btnLogin`)
- Checkbox "Recuerdame" (`#chk_recordar`)
- Botón "Conexion" en pie → abre modal de servidor

**Diálogos:**
- `#modal_info` — Configuración URL del servidor:
  - Campo IP/dominio del servidor (`#txtServidor`)
  - Botón aceptar (`#btnAceptarConexion`)
- `#modalInventarios` — Selección de inventario después de login exitoso:
  - Select2 dropdown (`#comboInventarios`)
  - Botón aceptar (`#btnAceptarInventario`)

**Funciones:**
- `consultaCatalogoEmpresas()` — AJAX POST a `empresasCatalogo.php`. Si solo hay una empresa, la auto-selecciona
- `iniciarSesion()` — Valida usuario/contraseña, hash SHA-256, AJAX POST a `loginV2.php`. En éxito, llama `consultaCatalogoInventarios()`
- `consultaCatalogoInventarios(datosRecibidos)` — AJAX POST a `inventariosEmpresa.php`. Filtra por `inventariosAcceso` del login
- `guardaDatosSesion(datosSesion)` — Almacena sesión en localStorageDB (empresa, inventario, sucursal, usuario)

**Endpoints API:**
- `empresasCatalogo.php` — POST → [{id_empresa, nombre_empresa}]
- `loginV2.php` — POST (empresa, usuario, password SHA-256) → datos de usuario + inventariosAcceso
- `inventariosEmpresa.php` — POST (id_empresa) → [{id_inventario, nombre_inventario, id_sucursal, nombre_sucursal}]

---

### 2. Dashboard (`inicio.html`) — CON 3 GRÁFICAS

**Propósito:** Dashboard principal con visualización de avance del inventario.

**Elementos UI:**
- Sidebar: ACERCA DE, SALIR
- Navbar: nombre de empresa (`#lblNombreEmpresa`) + botón sync
- 3 tarjetas con gráficas C3.js:
  1. **"AVANCE GENERAL DEL INVENTARIO"** — Donut: Encontrado / No Encontrado / Sin Revisar
  2. **"AVANCE POR AREA"** — Donut: progreso por departamento
  3. **"ACTIVOS INVENTARIADOS POR CATEGORIA"** — Barras: conteo por categoría
- Botón pie: "INVENTARIO DE ACTIVOS" (`#btn_inventario`)
- Indicador de sincronización

**Diálogos:**
- `#modalSalir` — Confirmación de cierre de sesión
- `#modal_impresoras` — Configuración de impresoras Bluetooth:
  - Impresora de tickets: nombre, MAC, marca (CF/Zebra), prueba
  - Impresora de etiquetas: nombre, MAC, marca (CF/Zebra), prueba
  - Guardar/Cancelar

**Funciones:**
- `validaSesion()` — Verifica sesión en localStorageDB, redirige a login si no existe
- `cierraSesion()` — AJAX POST a `sesionCerrar.php`, limpia sesión local
- `consultaAvanceInventario()` — POST → {encontrado, no_encontrado, sin_revisar}
- `consultaAvanceDepartamento()` — POST → [{departamento, cantidad}]
- `consultaAvanceCategoria()` — POST → [{categoria, cantidad}]
- `generaGraficaGeneral()`, `generaGraficaDepartamento()`, `generaGraficaCategoria()` — Inicialización C3.js

**Endpoints API:**
- `sesionCerrar.php` — POST (id_usuario, id_inventario)
- `reporteGralAvanceInventario.php` — POST → {encontrado, no_encontrado, sin_revisar}
- `reporteGralAvanceDepartamento.php` — POST → [{departamento, cantidad}]
- `reporteGralAvanceCategoria.php` — POST → [{categoria, cantidad}]

---

### 3. Selección de Departamento (`inventario_ubicacion.html`)

**Propósito:** Seleccionar o crear departamento/área antes de captura.

**Elementos UI:**
- Select2 dropdown (`#txtAlmacen`) con tags
  - Ubicaciones predefinidas: Peso Libre, Peso Integrado, Shape y Box, Cardio, Salon de Clases, Site, Gerencia, Recepcion, Bodega, Vestidores, Staff, Cuarto de Limpieza, Cuarto de Mantenimiento, Cabinas
  - Combinadas con departamentos del servidor
- Botón "INICIAR INVENTARIO" (`#btn_iniciar_conteo`)

**Diálogos:**
- `#modalUbicaciones` — Lista de ubicaciones capturadas con conteos por ubicación

**Endpoints API:**
- `departamentosInventariadosCatalogo.php` — POST (id_inventario) → [{nombre_departamento}]

---

### 4. Captura de Inventario (`inventario_captura.html`) — PANTALLA PRINCIPAL

**Propósito:** Core de operación — escaneo de activos, marcado de estatus, registro forzado, fotos, GPS, traspasos. El archivo JS más grande (~2200 líneas).

**Elementos UI:**
- Dropdown categoría (`#selectCategoria`) — filtra activos
- Campo ubicación (`#txt_ubicacion`) + escaneo (modo 0)
- Campo código activo (`#txtCodigo`) + escaneo (modo 1) + botón buscar
- Etiqueta descripción (`#lbl_descripcion`)
- DataTable `#tabla_datos` con activos pendientes:
  - Columnas: cantidad, codigo_1, descripcion, fecha_captura, hora_captura
  - Botón "SELECCIONAR" (verde) → marca como Encontrado
  - Botón "NO ENCONTRADO" (rojo) → marca como No Encontrado
- Etiqueta "Activos pendientes: X" (`#lbl_n_filas`)
- Campos opcionales de cantidad/lote/serie

**Diálogos:**

1. **`#modalRegistro`** (pantalla completa) — Registro nuevo/forzado de activo:
   - Numero de activo (`#txtCodigo1Forzado`)
   - Numero de tag (`#txtCodigo2Forzado`)
   - Codigo tag nuevo (`#txtCodigo3Forzado`)
   - Numero serie actual (`#txtNSerieViejo`) + escaneo
   - Numero serie revisado (`#txtNSerieForzado`) + escaneo
   - Dropdown categoría (`#txtCategoriaForzado`)
   - Select2 marca (`#selectMarca`)
   - Descripción textarea (`#txtDescripcionForzado`)
   - Observaciones textarea (`#txtObservaciones`)
   - Cantidad (`#txtCantidad`, default 1)
   - **3 áreas de captura de foto** (`#picFoto1`, `#picFoto2`, `#picFoto3`) — cámara overlay, base64
   - Botones Aceptar / Cancelar

2. **`#modal_n_series`** — Captura batch de números de serie:
   - Campo serie + escaneo + tabla de series ingresadas + total

3. **`#modalOpciones`** — Menú de opciones:
   - Buscar desde catálogo → `inventario_consulta.html`
   - Opciones de captura → `#modalOpcionesLectura`
   - Exportar reporte → `inventario_reporte.html`
   - Imprimir → impresión BT
   - Eliminar registro / Eliminar ubicación

4. **`#modalOpcionesLectura`** — Toggles de configuración de captura:
   - Validar catálogo, Códigos forzados, GPS, Series, Lotes, Caducidad, Cantidad cero, Negativas, Tipo conteo

5. **`#modalSalir`** — Confirmación de salida

**Funciones clave:**
- `consultaProductoInfo(lectura)` — AJAX POST a `productosConsultarCodigo.php`. Maneja 3 escenarios:
  - Activo encontrado en ubicación actual → muestra descripción, cola para selección
  - Activo de otra sucursal → activa flujo de **traspaso** con confirmación SweetAlert
  - Activo no encontrado → `preguntaAgregarForzado()` para registro nuevo
- `preguntaAgregarForzado()` — SweetAlert2: "¿Desea agregarlo?" → abre `#modalRegistro`
- `guardaCodigoForzado()` — AJAX POST a `productoForzadoRegistro.php` o `ProductoEdicion.php` con campos + 3 fotos base64 + GPS + datos de traspaso
- `consultaInventarioPendiente()` — AJAX POST → activos pendientes por ubicación/departamento
- `ConsultaRegistroSeleccionado()` — AJAX POST a `ProductoConsultaId.php` → detalles completos
- `marcarNoEncontrado()` — AJAX POST a `registroInventarioMarcarNoEncontrado.php`
- `scan(valor)` — 6 contextos de escaneo:

| Modo | Contexto | Destino |
|------|---------|---------|
| 0 | Ubicación | `#txt_ubicacion` → `consultaInventarioPendiente()` |
| 1 | Código de producto | `#txtCodigo` |
| 2 | Número de lote | `#txtNSerieViejo` |
| 3 | Número de serie (batch) | `#txt_sn` → `inserta_n_serie()` |
| 4 | Ubicación para eliminar | (flujo de eliminación) |
| 5 | Serie (forzado) | `#txtNSerieForzado` |

- `imprime()` — Ticket BT completo: Zebra CPCL (cabecera, líneas, pie, firma) o ESC/POS
- Cámara: `navigator.camera.getPicture()` con salida base64, 3 fotos por activo
- GPS: `navigator.geolocation.watchPosition()`, coordenadas en cada registro

**Endpoints API:**
- `productosConsultarCodigo.php` — POST (id_inventario, codigo, id_almacen) → datos de activo
- `consultaInventarioPendiente.php` — POST → activos pendientes
- `productoForzadoRegistro.php` — POST (todos los campos + fotos x3 + GPS + traspaso)
- `ProductoEdicion.php` — POST (id_producto + campos editables + fotos)
- `ProductoConsultaId.php` — POST (id_producto, id_inventario) → detalles completos
- `registroInventarioMarcarNoEncontrado.php` — POST (id_producto, id_inventario, id_almacen)

---

### 5. Búsqueda de Registros (`inventario_consulta.html`)

**Propósito:** Buscar registros capturados localmente (client-side con AlaSQL).

**Elementos UI:**
- Campo búsqueda + escaneo
- Lista de resultados como tarjetas Bootstrap
- Botones por tarjeta: imprimir, editar, eliminar

---

### 6. Reportes (`inventario_reporte.html`)

**Propósito:** 5 tipos de reporte con exportación y impresión BT.

**Tipos de Reporte:** Mismos 5 que SERV122 (Agrupado, Agrupado+Ubicación, Diferencias, Detalle, Cruzado)

---

### 7. Exportación al Servidor (`inventario_exportacion_ssr.html`)

**Propósito:** Subir registros en lotes de 20 al servidor.

**Funciones:**
- Upload recursivo batch: `northwind.queryAll('registros', { limit: 20 })`
- AJAX POST a `inventarioInsertarV2.php`
- Servidor responde con IDs procesados delimitados por pipe (ej. "1|5|12|...")
- Cada ID procesado se elimina del localStorageDB
- Escaneo de QR con formato `serverIP%inventoryId`

---

### 8-12. Catálogo, Import Excel/Servidor, Nuevo Producto

Estructura idéntica a SERV122. Mismas páginas con misma funcionalidad.

---

### 13. Configuración del Servidor (`PanelServidor.html`)

Misma funcionalidad que SERV122 + escaneo de QR para conexión.

---

### 14-17. Licencia, Pago, Info Licencia, Acerca de

Estructura idéntica a SERV122 con mismo sistema de licenciamiento Glint.

---

### Endpoints API — ActivoFijoV113

**API Móvil (base: `/myAssets/api/movil/V1.0.0/`):**

| Endpoint | Propósito |
|----------|----------|
| `empresasCatalogo.php` | Catálogo de empresas |
| `inventariosEmpresa.php` | Inventarios por empresa |
| `loginV2.php` | Login con hash SHA-256 |
| `sesionCerrar.php` | Cerrar sesión |
| `reporteGralAvanceInventario.php` | Avance general |
| `reporteGralAvanceDepartamento.php` | Avance por departamento |
| `reporteGralAvanceCategoria.php` | Avance por categoría |
| `departamentosInventariadosCatalogo.php` | Departamentos inventariados |
| `productosConsultarCodigo.php` | Buscar activo por código |
| `consultaInventarioPendiente.php` | Activos pendientes por ubicación |
| `productoForzadoRegistro.php` | Registrar activo forzado (+ fotos) |
| `ProductoEdicion.php` | Editar activo (+ fotos) |
| `ProductoConsultaId.php` | Consultar activo por ID |
| `registroInventarioMarcarNoEncontrado.php` | Marcar No Encontrado |

**API Web (base: `/myAssets/api/web/V1.0.0/`):**

| Endpoint | Propósito |
|----------|----------|
| `inventarioInsertarV2.php` | Exportar registros (batch 20) |
| `productosCatalogo.php` | Catálogo completo |
| `ProductosCantidad.php` | Total de productos |
| `ProductosCatalogoImportacion.php` | Importación paginada |

---

# APK 3: ActivoFijoV200RFID — Activo Fijo SER (v2.0.0)

## Información General

- **Nombre:** Activo Fijo SER
- **Paquete:** `maui.cf.activofijoser`
- **Assembly .NET:** `AuditoriaActivoFijo`
- **Propósito:** Gestión moderna de activos fijos con soporte RFID y escáner de códigos de barras
- **Arquitectura:** .NET MAUI (compilado a nativo via Mono AOT), single-activity
- **Orientación:** Solo retrato
- **Nota:** Las páginas MAUI están compiladas a código nativo — el análisis se basa en la estructura de navegación, componentes DevExpress, SDK RFID, y permisos

## Stack Tecnológico

| Categoría | Tecnología |
|-----------|-----------|
| Framework | .NET MAUI 8+ |
| Componentes UI | DevExpress MAUI (Grid, DataForm, Editors, Charts, Navigation) |
| RFID SDK #1 | GaoXin GG Reader API (GClient) — Serial/BT/TCP |
| RFID SDK #2 | RugLine RT501 SDK (BaseReader) — Serial |
| Abstracción RFID | lcrrgxmodule factory pattern (ILcUhfProduct) |
| Escaneo Barcode | Google ML Kit Barcode + CameraX |
| Gráficas | SkiaSharp (renderizado GPU) |
| Imágenes | Glide |
| Serialización | Gson |
| Animación | Lottie (maagoatlottie.json) |
| Fuentes | OpenSans Regular/Semibold |
| Audio | SoundPool (decode.wav, success.wav, error.wav) |

## Estructura de Navegación (MAUI Shell)

```
MainActivity (Single Activity)
    └── MAUI Shell
          ├── Flyout Drawer (menú hamburguesa)
          ├── TabBar (navegación por pestañas)
          └── Stack Navigation (por sección)
                ├── Login Page
                ├── Dashboard / Home Page
                ├── Inventory Scan Page (RFID)
                ├── Barcode Scan Page (Cámara)
                ├── Asset Detail / Edit Page
                ├── Asset List / Search Page
                ├── Settings / Configuration Page
                └── Sync / Upload Page
```

## Componentes DevExpress Utilizados

### DXGrid (Data Grid)
- Grid con scroll horizontal, header/footer
- Pull-to-refresh (SwipeRefreshLayout)
- Cabeceras de columna, filas agrupadas, resúmenes totales
- Acciones de deslizar en filas (SwipeButtonAction)
- Renderizado custom de celdas
- **Uso:** Listas de inventario de activos, resultados de escaneo

### DXCollectionView
- Panel virtual scroll para colecciones grandes
- Scroll horizontal y vertical
- **Uso:** Listado/exploración eficiente de ítems

### DXEditors (Editores de Formulario)
- TextEditor, MultilineEditor, NumericEditor, PasswordEditor
- DateEditor, TimeEditor, ComboBoxEditor
- AutoCompleteEdit, CheckBoxEditor, SwitchEditor
- MaskedEditor, CustomViewEditor
- **Uso:** Formularios de captura de datos de activos

### DXDataForm
- Formularios auto-generados desde modelos de datos
- Secciones agrupadas con expansor
- Validación (pre-validate, post-validate)
- **Uso:** Formularios de edición de activos, configuración

### DXCharts
- Series: Area, Bar, Line, Spline, Pie, Candlestick, Stock
- Renderizado GPU vía SkiaSharp
- **Uso:** Dashboard, visualización de progreso

### DXNavigation
- TabControl, DrawerView, BottomSheetDialog, DXPopup, Pager
- **Uso:** Navegación principal de la app

## Integración RFID (Arquitectura Dual SDK)

### Patrón Factory
`LcModule` detecta el tipo de dispositivo vía `android.bld.RFIDManager`:
- **rfidType == 32** → `GxUhfProduct` (GaoXin GG Reader SDK)
- **Default** → `RfidUhfProduct` (RugLine RT501 SDK)

### SDK GaoXin GG Reader
- Cliente: `GClient` con soporte para Bluetooth (classic + BLE), TCP/IP, USB HID, Serial Android (`/dev/ttyS3` o `/dev/ttyS2`)
- Protocolo: GX con operaciones EPC Gen2 (UHF)
- Capacidades: Inventario, Lectura/Escritura EPC, TID, Userdata, Lock, Kill, Config frecuencia/potencia

### SDK RugLine RT501
- Reader: `BaseReader` con protocolo serial a 115200 baud
- Protocolo binario con validación CRC16
- Operaciones: `Inventory_G2`, `ReadData_G2`, `WriteData_G2`, `WriteEPC_G2`, `Lock_G2`, `Kill_G2`

### Interfaz Unificada (ILcUhfProduct)
```
Connect() / DisConnect()
StartRead() / StopRead()           -- Escaneo continuo de inventario
SetCallBack(TagCallback)           -- Callback de detección de tags
ReadDataByEPC() / ReadDataByTID()  -- Leer memoria por filtro
WriteDataByEPC() / WriteDataByTID() -- Escribir memoria por filtro
WriteEPCByTID()                    -- Escribir nuevo EPC usando TID
Lock() / Kill()                    -- Operaciones de seguridad
SetRfPower() / SetRegion() / SetAntenna() -- Config de hardware
beginSound() / playSound()         -- Feedback de audio
Get/SetInventoryParameter()        -- Parámetros de escaneo (Q, Session, TID, tiempo)
```

### Bridge .NET: RfidCallback
- `tagCallback(ReadTag)` — cuando se lee un tag (epcId, antId, rssi)
- `FinishCallBack()` — cuando se completa un ciclo de escaneo
- `CRCErrorCallBack(int)` — manejo de error CRC

### Modelo de Datos del Tag
- **ReadTag:** epcId (String), antId (int), rssi (int)
- **InventoryTagMap:** strEPC, strRSSI, nReadCount, antenna
- **ReaderParameter:** ComAddr, ScanTime, Session (0-3), QValue, TidLen, TidPtr, Antenna, Interval

## Pantallas Inferidas

### 1. Login Page
- **UI:** DevExpress TextEditor (usuario), PasswordEditor (contraseña), botón de acción
- **Evidencia:** Actividad de web authenticator, fuentes OpenSans

### 2. Dashboard / Home Page
- **UI:** DXCharts (gráficas de resumen), tarjetas de estadísticas, actividad reciente
- **Evidencia:** Adaptadores de series de gráficas (pie, bar)

### 3. Escaneo de Inventario (Modo RFID) — PANTALLA PRINCIPAL
- **UI:** Botón Start/Stop escaneo, conteo de tags en vivo, DXGrid con tags descubiertos (EPC, RSSI, antena, conteo de lecturas), indicador de progreso
- **Evidencia:** `StartRead()`/`StopRead()` en ILcUhfProduct, sonidos success/error/decode
- **RFID:** Botón trigger físico capturado vía `onKeyDown`/`onKeyUp` en MainActivity, inventario continuo con feedback sonoro

### 4. Escaneo de Barcode (Modo Cámara)
- **UI:** Visor CameraX, overlay ML Kit
- **Evidencia:** Modelos ML Kit barcode, permiso CAMERA, sonido decode.wav

### 5. Detalle/Edición de Activo
- **UI:** DXDataForm con editores agrupados (texto, numérico, fecha, combo, checkbox), captura/visualización de fotos
- **Evidencia:** Todos los tipos de editor DataForm presentes, validación

### 6. Lista/Búsqueda de Activos
- **UI:** DXGrid o DXCollectionView con pull-to-refresh, barra de búsqueda, filtros
- **Evidencia:** ShellSearchView, acciones de swipe en grid

### 7. Configuración
- **UI:** Configuración de lector RFID (potencia, región, sesión, Q-value), configuración de conexión
- **Evidencia:** Métodos `SetRfPower`, `SetRegion`, `SetInventoryParameter`, `ReaderParameter`

### 8. Sincronización
- **UI:** Estado de sync, progreso de subida, configuración de URL
- **Evidencia:** Permiso INTERNET, infraestructura de comunicación API

## Diálogos y Popups

| Componente | Propósito |
|-----------|----------|
| DXBottomSheetDialog | Bottom sheets para selecciones/filtros |
| DXPopup | Dropdowns para combo boxes, pickers |
| ModalNavigationManager_ModalFragment | Páginas modales de pantalla completa |
| CustomComponentDialog | Diálogos modales personalizados |
| custom_dialog.xml | Diálogo simple con botón "Ok" |
| AlertDialog (Material) | Diálogos de confirmación |

## Tema Visual

| Color | Hex | Uso |
|-------|-----|-----|
| colorPrimary | `#2e2e2e` | Gris oscuro principal |
| colorPrimaryDark | `#212121` | Barra de estado más oscura |
| colorAccent | `#4b515d` | Acento gris-azul |
| dx_accent_color | `#2088ff` | Acento azul DevExpress |
| maui_splash_color | `#ff000000` | Splash negro |

**Tema:** Toolbar oscuro con área de contenido clara. `AppTheme` hereda de `Theme.AppCompat.Light.DarkActionBar`.

---

# Comparativa de Funcionalidades por Pantalla

| Pantalla | SERV122 | ActivoFijoV113 | ActivoFijoV200RFID |
|----------|---------|----------------|-------------------|
| **Login** | Offline (BD local) | Online (API + empresa) | Online (MAUI) |
| **Dashboard** | 1 gráfica | 3 gráficas (donut+barras) | DXCharts (pie, bar) |
| **Captura** | Escaneo → busca local → guarda | Escaneo → busca servidor → marca estatus | RFID continuo + barcode cámara |
| **Fotos** | No | 3 fotos base64/activo | Sí (CameraX) |
| **RFID** | No | No | Dual SDK (GG + RT501) |
| **Traspasos** | No | Sí (entre sucursales) | Probable |
| **Impresión BT** | ESC/POS + Zebra CPCL | ESC/POS + Zebra CPCL | Probable (permisos BT) |
| **GPS** | Por registro (si habilitado) | Por registro (si habilitado) | Sí (permisos) |
| **Catálogo** | CRUD + Excel + servidor | CRUD + Excel + servidor | DevExpress Grid |
| **Reportes** | 5 tipos (AlaSQL) | 5 tipos (AlaSQL) | DXCharts |
| **Exportación** | Batch al servidor + CSV | Batch 20 al servidor + CSV | Sync |
| **Configuración** | 20 toggles de captura | ~10 toggles de captura | Config RFID (potencia, región, Q) |
| **Licencia** | Glint + PayPal | Glint + PayPal | Embebida |
| **Offline** | Completo | Parcial (captura offline, lookup online) | Probable parcial |

---

# Patrones de Diseño Comunes

## Arquitectura de Datos (SERV122 + ActivoFijoV113)

- **Dual database:** localStorageDB para config/sesión, SQLite para datos grandes (100K+ productos)
- **AlaSQL:** Consultas SQL client-side para reportes con GROUP BY, SUM, JOIN
- **Device-first:** Datos almacenados localmente; sync al servidor es explícita (importar/exportar)

## Feedback al Usuario

- **Audio:** `suenaBeep()` en éxito, `suenaError()` en fallo (archivos .wav via Cordova Media)
- **Vibración:** `navigator.vibrate()` en alertas
- **Toast:** Notificaciones pequeñas coloreadas (verde éxito, azul info, rojo error, naranja warning)
- **SweetAlert:** Diálogos de confirmación con botones personalizados

## Escaneo de Código de Barras

- **SERV122/V113:** `cordova.plugins.barcodeScanner.scan()` con linterna, prompt contextual
- **V200RFID:** Google ML Kit + CameraX (nativo, más rápido)

## Impresión Bluetooth

- **ESC/POS:** Para impresoras de tickets (formato recibo)
- **Zebra CPCL:** Para impresoras de etiquetas (2"x1", Code 128)
- **Dual printer:** Soporte simultáneo de ticket + etiqueta

## Licenciamiento (SERV122 + V113)

- Llave = `sha256(product_code + activation_code + device_serial + device_model + manufacturer)`
- Atada al dispositivo (anti-copia)
- Detección de manipulación de fecha
- Servidor Glint para validación
- Pagos vía PayPal SDK

---

# Sistema de Diálogos por APK

## SERV122 — 7 tipos de alerta

| Tipo | Mecanismo | Uso |
|------|-----------|-----|
| SweetAlert (swal) | Confirm con botones custom | Confirmaciones importantes |
| SweetAlert2 (Swal.fire) | MensajeAlerta() wrapper | Alertas generales |
| Toast plugin | muestraAlerta3() | Notificaciones pequeñas |
| Native confirm() | JavaScript | Decisiones simples |
| Native alert() | JavaScript | Errores |
| navigator.notification.alert | Cordova | Alertas nativas |
| LoadingOverlay | jQuery plugin | Carga/procesamiento |

## ActivoFijoV113 — 7 tipos (mismos + toastr)

Mismo sistema que SERV122 con adición de:
- **toastr** — Toast library para números de serie

## ActivoFijoV200RFID — Material 3 + DevExpress

| Tipo | Componente | Uso |
|------|-----------|-----|
| BottomSheet | DXBottomSheetDialog | Selecciones/filtros |
| Popup | DXPopupListenerImplementation | Dropdowns, pickers |
| Modal | ModalNavigationManager_ModalFragment | Páginas modales |
| Custom Dialog | CustomComponentDialog | Diálogos personalizados |
| Alert | Material AlertDialog | Confirmaciones |
| Audio | SoundPool | Beep/success/error |

---

*Reporte generado el 2026-02-27 — Análisis exhaustivo de los APKs decompilados del cliente SER*
